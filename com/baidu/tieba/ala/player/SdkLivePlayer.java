package com.baidu.tieba.ala.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.as;
import com.baidu.live.liveroom.e.e;
import com.baidu.live.o.d;
import com.baidu.live.o.f;
import com.baidu.live.o.g;
import com.baidu.live.o.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private long aEq;
    private com.baidu.live.o.b aZu;
    private String aZv;
    private ArrayList<com.baidu.live.liveroom.e.a> geA;
    private ArrayList<AlaLiveInfoData> geB;
    private g geC;
    private com.baidu.live.o.c geD;
    private boolean isPlaying;
    private Context mContext;

    public static SdkLivePlayer ez(Context context) {
        if (e.DF().DG()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a at;
        com.baidu.live.liveroom.e.a at2;
        this.aZv = "";
        this.isPlaying = false;
        this.aEq = 0L;
        this.geD = new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.geA = new ArrayList<>();
        boolean z = com.baidu.live.v.a.Eo().aQp.arQ;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            at = e.DF().at(context);
            at2 = e.DF().at(context);
        } else if (z) {
            at = e.DF().au(context);
            at2 = e.DF().au(context);
        } else {
            at = e.DF().at(context);
            at2 = e.DF().at(context);
        }
        this.geA.add(at);
        this.geA.add(at2);
        d DH = e.DF().DH();
        if (DH != null && !DH.Ea()) {
            DH.a(this.geD);
        }
        this.geC = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.geB;
    }

    @Override // com.baidu.live.o.f
    public void b(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bDa();
        ab(arrayList);
    }

    public void ab(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        as asVar;
        this.geB = arrayList;
        LinearLayout.LayoutParams bDd = bDd();
        if (ListUtils.getCount(arrayList) == 2) {
            bDd = bDc();
        }
        if (arrayList == null || arrayList.size() != 1 || (asVar = com.baidu.live.v.a.Eo().aRw) == null || asVar.avB == null || ((i = asVar.avB.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, bDd, i, i2);
            }
        }
        this.isPlaying = true;
        this.aEq = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot("1397", getUbcFlowSlotKey(), bDe());
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String c = h.c(alaLiveInfoData);
        if (!TextUtils.isEmpty(c)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + c);
            }
            if (i == 0) {
                this.aZv = c;
            }
            if (this.geA != null && this.geA.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.geA.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.v.a.Eo().aQp.clientIP);
                    jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("sessionLine", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e);
                    }
                }
                aVar.a(null);
                aVar.d(this.mContext, Uri.parse(c));
                if ("ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                aVar.setDecodeMode(i2);
                aVar.cu(8);
                aVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.getPlayerView(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.e.d() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.c
                    public void a(com.baidu.live.liveroom.e.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.aZu != null) {
                                SdkLivePlayer.this.aZu.bx(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.cu(0);
                        }
                    }
                });
                aVar.c(Uri.parse(c));
                aVar.start();
                aVar.setVideoScalingMode(i3);
                a(aVar, alaLiveInfoData);
            }
        }
    }

    private void a(com.baidu.live.liveroom.e.a aVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.v.a.Eo().aQp.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        aVar.b(1, hashMap);
    }

    private void Hp() {
        if (!ListUtils.isEmpty(this.geA)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bDa() {
        bM(true);
    }

    @Override // com.baidu.live.o.f
    public void bM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Hp();
        }
        this.aZv = "";
        if (!ListUtils.isEmpty(this.geA)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.geB != null) {
            this.geB.clear();
        }
        this.isPlaying = false;
        UbcStatisticManager.getInstance().flowEndSlot("1397", getUbcFlowSlotKey());
    }

    @Override // com.baidu.live.o.f
    public View getLivePlayer() {
        return this;
    }

    public void bDb() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.geB)) {
            ab(this.geB);
        }
    }

    public void asn() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.geA)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
        this.isPlaying = false;
        this.aEq = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot("1397", getUbcFlowSlotKey(), bDe());
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.geA)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.geA.clear();
        }
        d DH = e.DF().DH();
        if (DH != null) {
            DH.b(this.geD);
        }
    }

    public String getVideoPath() {
        return this.aZv;
    }

    public void setIPlayerCallBack(com.baidu.live.o.b bVar) {
        this.aZu = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.o.a aVar) {
        if (this.geC != null) {
            this.geC.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.geB = arrayList;
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.geB = arrayList;
    }

    private LinearLayout.LayoutParams bDc() {
        int aw = com.baidu.live.utils.g.aw(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aw;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bDd() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.geC != null) {
            this.geC.Eb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.geC != null) {
            this.geC.Ec();
        }
    }

    private JSONObject bDe() {
        JSONObject jSONObject = new JSONObject();
        if (this.geB != null && !this.geB.isEmpty()) {
            try {
                jSONObject.put("live_id", this.geB.get(0).live_id);
                jSONObject.put("vid", this.geB.get(0).feed_id);
                jSONObject.put("play_start_time", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private String getUbcFlowSlotKey() {
        return "playtime_" + this.aEq;
    }
}

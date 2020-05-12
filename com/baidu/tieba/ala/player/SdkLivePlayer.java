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
    private long aEw;
    private String aZA;
    private com.baidu.live.o.b aZz;
    private ArrayList<com.baidu.live.liveroom.e.a> geG;
    private ArrayList<AlaLiveInfoData> geH;
    private g geI;
    private com.baidu.live.o.c geJ;
    private boolean isPlaying;
    private Context mContext;

    public static SdkLivePlayer en(Context context) {
        if (e.DE().DF()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a ah;
        com.baidu.live.liveroom.e.a ah2;
        this.aZA = "";
        this.isPlaying = false;
        this.aEw = 0L;
        this.geJ = new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.geG = new ArrayList<>();
        boolean z = com.baidu.live.v.a.En().aQu.arW;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ah = e.DE().ah(context);
            ah2 = e.DE().ah(context);
        } else if (z) {
            ah = e.DE().ai(context);
            ah2 = e.DE().ai(context);
        } else {
            ah = e.DE().ah(context);
            ah2 = e.DE().ah(context);
        }
        this.geG.add(ah);
        this.geG.add(ah2);
        d DG = e.DE().DG();
        if (DG != null && !DG.DZ()) {
            DG.a(this.geJ);
        }
        this.geI = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.geH;
    }

    @Override // com.baidu.live.o.f
    public void b(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bCY();
        ab(arrayList);
    }

    public void ab(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        as asVar;
        this.geH = arrayList;
        LinearLayout.LayoutParams bDc = bDc();
        if (ListUtils.getCount(arrayList) == 2) {
            bDc = bDb();
        }
        if (arrayList == null || arrayList.size() != 1 || (asVar = com.baidu.live.v.a.En().aRB) == null || asVar.avH == null || ((i = asVar.avH.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, bDc, i, i2);
            }
        }
        this.isPlaying = true;
        this.aEw = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot("1397", getUbcFlowSlotKey(), bDd());
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String c = h.c(alaLiveInfoData);
        if (!TextUtils.isEmpty(c)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + c);
            }
            if (i == 0) {
                this.aZA = c;
            }
            if (this.geG != null && this.geG.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.geG.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.v.a.En().aQu.clientIP);
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
                            if (SdkLivePlayer.this.aZz != null) {
                                SdkLivePlayer.this.aZz.bx(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
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
        hashMap.put("clientIp", com.baidu.live.v.a.En().aQu.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        aVar.b(1, hashMap);
    }

    private void Ho() {
        if (!ListUtils.isEmpty(this.geG)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geG.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bCY() {
        bM(true);
    }

    @Override // com.baidu.live.o.f
    public void bM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Ho();
        }
        this.aZA = "";
        if (!ListUtils.isEmpty(this.geG)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geG.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.geH != null) {
            this.geH.clear();
        }
        this.isPlaying = false;
        UbcStatisticManager.getInstance().flowEndSlot("1397", getUbcFlowSlotKey());
    }

    @Override // com.baidu.live.o.f
    public View getLivePlayer() {
        return this;
    }

    public void bCZ() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.geH)) {
            ab(this.geH);
        }
    }

    public void asl() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.geG)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geG.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
        this.isPlaying = false;
        this.aEw = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot("1397", getUbcFlowSlotKey(), bDd());
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.geG)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.geG.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.geG.clear();
        }
        d DG = e.DE().DG();
        if (DG != null) {
            DG.b(this.geJ);
        }
    }

    public String getVideoPath() {
        return this.aZA;
    }

    public void setIPlayerCallBack(com.baidu.live.o.b bVar) {
        this.aZz = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.o.a aVar) {
        if (this.geI != null) {
            this.geI.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.geH = arrayList;
        bDa();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.geH = arrayList;
        bDa();
    }

    private void bDa() {
        if (this.geH != null && this.geG != null && this.geH.size() > 0 && this.geG.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.geH.size(); i2++) {
                if (this.geH.get(i2) != null && this.geG.get(i2) != null) {
                    if (this.geH.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.geG.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams bDb() {
        int ak = com.baidu.live.utils.g.ak(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = ak;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bDc() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.geI != null) {
            this.geI.Ea();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.geI != null) {
            this.geI.Eb();
        }
    }

    private JSONObject bDd() {
        JSONObject jSONObject = new JSONObject();
        if (this.geH != null && !this.geH.isEmpty()) {
            try {
                jSONObject.put("live_id", this.geH.get(0).live_id);
                jSONObject.put("vid", this.geH.get(0).feed_id);
                jSONObject.put("play_start_time", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private String getUbcFlowSlotKey() {
        return "playtime_" + this.aEw;
    }
}

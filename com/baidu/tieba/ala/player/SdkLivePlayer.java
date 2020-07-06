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
import com.baidu.live.data.bb;
import com.baidu.live.liveroom.e.e;
import com.baidu.live.p.d;
import com.baidu.live.p.f;
import com.baidu.live.p.g;
import com.baidu.live.p.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private long aME;
    private com.baidu.live.p.b bmc;
    private String bmd;
    private ArrayList<com.baidu.live.liveroom.e.a> gGw;
    private ArrayList<AlaLiveInfoData> gGx;
    private g gGy;
    private com.baidu.live.p.c gGz;
    private boolean isPlaying;
    private Context mContext;

    public static SdkLivePlayer eD(Context context) {
        if (e.FL().FM()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a as;
        com.baidu.live.liveroom.e.a as2;
        this.bmd = "";
        this.isPlaying = false;
        this.aME = 0L;
        this.gGz = new com.baidu.live.p.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.gGw = new ArrayList<>();
        boolean z = com.baidu.live.v.a.Hm().aZp.azg;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            as = e.FL().as(context);
            as2 = e.FL().as(context);
        } else if (z) {
            as = e.FL().at(context);
            as2 = e.FL().at(context);
        } else {
            as = e.FL().as(context);
            as2 = e.FL().as(context);
        }
        this.gGw.add(as);
        this.gGw.add(as2);
        d FN = e.FL().FN();
        if (FN != null && !FN.Gy()) {
            FN.a(this.gGz);
        }
        this.gGy = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.gGx;
    }

    @Override // com.baidu.live.p.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bMx();
        ab(arrayList);
    }

    public void ab(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bb bbVar;
        this.gGx = arrayList;
        LinearLayout.LayoutParams bMB = bMB();
        if (ListUtils.getCount(arrayList) == 2) {
            bMB = bMA();
        }
        if (arrayList == null || arrayList.size() != 1 || (bbVar = com.baidu.live.v.a.Hm().bdV) == null || bbVar.aDa == null || ((i = bbVar.aDa.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, bMB, i, i2);
            }
        }
        this.isPlaying = true;
        this.aME = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey(), bMC());
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bmd = d;
            }
            if (this.gGw != null && this.gGw.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.gGw.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.v.a.Hm().aZp.clientIP);
                    jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("sessionLine", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e);
                    }
                }
                aVar.a(null);
                aVar.d(this.mContext, Uri.parse(d));
                if ("ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                aVar.setDecodeMode(i2);
                aVar.cJ(8);
                aVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.getPlayerView(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.e.d() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.c
                    public void a(com.baidu.live.liveroom.e.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bmc != null) {
                                SdkLivePlayer.this.bmc.bL(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.cJ(0);
                        }
                    }
                });
                aVar.c(Uri.parse(d));
                aVar.start();
                aVar.setVideoScalingMode(i3);
                a(aVar, alaLiveInfoData);
            }
        }
    }

    private void a(com.baidu.live.liveroom.e.a aVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.v.a.Hm().aZp.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        aVar.b(1, hashMap);
    }

    private void Ku() {
        if (!ListUtils.isEmpty(this.gGw)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gGw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bMx() {
        bY(true);
    }

    @Override // com.baidu.live.p.f
    public void bY(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Ku();
        }
        this.bmd = "";
        if (!ListUtils.isEmpty(this.gGw)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gGw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.gGx != null) {
            this.gGx.clear();
        }
        this.isPlaying = false;
        UbcStatisticManager.getInstance().flowEndSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey());
    }

    @Override // com.baidu.live.p.f
    public View getLivePlayer() {
        return this;
    }

    public void bMy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.gGx)) {
            ab(this.gGx);
        }
    }

    public void awZ() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.gGw)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gGw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
        this.isPlaying = false;
        UbcStatisticManager.getInstance().flowEndSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey());
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.gGw)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gGw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.gGw.clear();
        }
        d FN = e.FL().FN();
        if (FN != null) {
            FN.b(this.gGz);
        }
    }

    public String getVideoPath() {
        return this.bmd;
    }

    public void setIPlayerCallBack(com.baidu.live.p.b bVar) {
        this.bmc = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.p.a aVar) {
        if (this.gGy != null) {
            this.gGy.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.gGx = arrayList;
        bMz();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.gGx = arrayList;
        bMz();
    }

    private void bMz() {
        if (this.gGx != null && this.gGw != null && this.gGx.size() > 0 && this.gGw.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.gGx.size(); i2++) {
                if (this.gGx.get(i2) != null && this.gGw.get(i2) != null) {
                    if (this.gGx.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.gGw.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams bMA() {
        int av = com.baidu.live.utils.g.av(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = av;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bMB() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gGy != null) {
            this.gGy.Gz();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gGy != null) {
            this.gGy.GA();
        }
    }

    private JSONObject bMC() {
        JSONObject jSONObject = new JSONObject();
        if (this.gGx != null && !this.gGx.isEmpty()) {
            try {
                jSONObject.put("live_id", this.gGx.get(0).live_id);
                jSONObject.put("room_id", this.gGx.get(0).room_id);
                jSONObject.put("vid", this.gGx.get(0).feed_id);
                jSONObject.put("play_start_time", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private String getUbcFlowSlotKey() {
        return "playtime_" + this.aME;
    }
}

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
import com.baidu.live.data.bc;
import com.baidu.live.liveroom.e.e;
import com.baidu.live.p.d;
import com.baidu.live.p.f;
import com.baidu.live.p.g;
import com.baidu.live.p.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean avT;
    private com.baidu.live.p.b bmx;
    private String bmy;
    private ArrayList<com.baidu.live.liveroom.e.a> gLV;
    private ArrayList<AlaLiveInfoData> gLW;
    private g gLX;
    private com.baidu.live.p.c gLY;
    private Context mContext;

    public static SdkLivePlayer eH(Context context) {
        if (e.FF().FG()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a as;
        com.baidu.live.liveroom.e.a as2;
        this.bmy = "";
        this.avT = false;
        this.gLY = new com.baidu.live.p.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.gLV = new ArrayList<>();
        boolean z = com.baidu.live.v.a.Hs().aZn.aAt;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            as = e.FF().as(context);
            as2 = e.FF().as(context);
        } else if (z) {
            as = e.FF().at(context);
            as2 = e.FF().at(context);
        } else {
            as = e.FF().as(context);
            as2 = e.FF().as(context);
        }
        this.gLV.add(as);
        this.gLV.add(as2);
        d FH = e.FF().FH();
        if (FH != null && !FH.Gt()) {
            FH.a(this.gLY);
        }
        this.gLX = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.gLW;
    }

    @Override // com.baidu.live.p.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bPF();
        ac(arrayList);
    }

    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        bc bcVar;
        this.gLW = arrayList;
        LinearLayout.LayoutParams bPJ = bPJ();
        if (ListUtils.getCount(arrayList) == 2) {
            bPJ = bPI();
        }
        if (arrayList == null || arrayList.size() != 1 || (bcVar = com.baidu.live.v.a.Hs().beo) == null || bcVar.aEv == null || ((i = bcVar.aEv.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, bPJ, i, i2);
            }
        }
        this.avT = true;
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String d = h.d(alaLiveInfoData);
        if (!TextUtils.isEmpty(d)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + d);
            }
            if (i == 0) {
                this.bmy = d;
            }
            if (this.gLV != null && this.gLV.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.gLV.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.v.a.Hs().aZn.clientIP);
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
                aVar.cK(8);
                aVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.getPlayerView(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.e.d() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.c
                    public void a(com.baidu.live.liveroom.e.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bmx != null) {
                                SdkLivePlayer.this.bmx.bR(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.cK(0);
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
        hashMap.put("clientIp", com.baidu.live.v.a.Hs().aZn.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        aVar.b(1, hashMap);
    }

    private void KB() {
        if (!ListUtils.isEmpty(this.gLV)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gLV.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bPF() {
        bZ(true);
    }

    @Override // com.baidu.live.p.f
    public void bZ(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            KB();
        }
        this.bmy = "";
        if (!ListUtils.isEmpty(this.gLV)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gLV.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.gLW != null) {
            this.gLW.clear();
        }
        this.avT = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    @Override // com.baidu.live.p.f
    public View getLivePlayer() {
        return this;
    }

    public void bPG() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.gLW)) {
            ac(this.gLW);
        }
    }

    public void azN() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.gLV)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gLV.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
        this.avT = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.gLV)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gLV.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.gLV.clear();
        }
        d FH = e.FF().FH();
        if (FH != null) {
            FH.b(this.gLY);
        }
    }

    public String getVideoPath() {
        return this.bmy;
    }

    public void setIPlayerCallBack(com.baidu.live.p.b bVar) {
        this.bmx = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.p.a aVar) {
        if (this.gLX != null) {
            this.gLX.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public boolean isPlaying() {
        return this.avT;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.gLW = arrayList;
        bPH();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.gLW = arrayList;
        bPH();
    }

    private void bPH() {
        if (this.gLW != null && this.gLV != null && this.gLW.size() > 0 && this.gLV.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.gLW.size(); i2++) {
                if (this.gLW.get(i2) != null && this.gLV.get(i2) != null) {
                    if (this.gLW.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.gLV.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams bPI() {
        int av = com.baidu.live.utils.g.av(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = av;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bPJ() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gLX != null) {
            this.gLX.Gu();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gLX != null) {
            this.gLX.Gv();
        }
    }
}

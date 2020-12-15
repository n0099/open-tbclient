package com.baidu.tieba.ala.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.bo;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.f;
import com.baidu.live.u.g;
import com.baidu.live.u.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aGB;
    private com.baidu.live.u.b bNW;
    private String bNX;
    private ArrayList<com.baidu.live.liveroom.e.d> hSH;
    private ArrayList<AlaLiveInfoData> hSI;
    private com.baidu.live.liveroom.e.f hSJ;
    private g hSK;
    private int hSL;
    private com.baidu.live.u.c hSM;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer fL(Context context) {
        if (i.PB().PC()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bNX = "";
        this.aGB = false;
        this.mPaused = false;
        this.hSM = new com.baidu.live.u.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hSH = new ArrayList<>();
        com.baidu.live.liveroom.e.d bc = i.PB().bc(context);
        com.baidu.live.liveroom.e.d bc2 = i.PB().bc(context);
        boolean z = com.baidu.live.ae.a.RB().brA.aMK;
        this.hSH.add(bc);
        this.hSH.add(bc2);
        com.baidu.live.u.d PE = i.PB().PE();
        if (PE != null && !PE.Qz()) {
            PE.a(this.hSM);
        }
        this.hSK = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.hSK != null) {
                this.hSK.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.hSH.size() > 0) {
            return this.hSH.get(0);
        }
        return null;
    }

    public void cof() {
        if (this.hSH != null && this.hSH.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hSH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aGB = false;
        }
    }

    public void cog() {
        String str;
        requestAudioFocus();
        if (this.hSI != null && this.hSI.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.hSI.iterator();
            int i = 0;
            while (it.hasNext()) {
                AlaLiveInfoData next = it.next();
                if (next != null) {
                    if (TextUtils.isEmpty(next.playUrl)) {
                        str = h.d(next);
                    } else {
                        str = next.playUrl;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (this.hSH != null && this.hSH.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.hSH.get(i);
                            dVar.stop();
                            dVar.c(Uri.parse(str));
                            dVar.start();
                            i++;
                        }
                    }
                }
                i = i;
            }
        }
    }

    public AlaLiveInfoData getCurrentLiveInfoData() {
        if (this.hSI.size() > 0) {
            return this.hSI.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hSI;
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        coh();
        al(arrayList);
    }

    public void al(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        com.baidu.live.liveroom.e.d dVar;
        bo boVar;
        requestAudioFocus();
        this.hSI = arrayList;
        LinearLayout.LayoutParams col = col();
        if (ListUtils.getCount(arrayList) == 2) {
            col = cok();
        }
        if (arrayList == null || arrayList.size() != 1 || (boVar = com.baidu.live.ae.a.RB().bxq) == null || boVar.aQT == null || ((i = boVar.aQT.aRI) != 1 && i != 2)) {
            i = 1;
        }
        if (this.hSH != null && !this.hSH.isEmpty() && (dVar = this.hSH.get(0)) != null && dVar.getPlayerView() != null) {
            dVar.getPlayerView().setLayoutParams(col);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, col, i, i2);
                }
            }
        }
        this.aGB = true;
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String str;
        if (TextUtils.isEmpty(alaLiveInfoData.playUrl)) {
            str = h.d(alaLiveInfoData);
        } else {
            str = alaLiveInfoData.playUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + str);
            }
            if (i == 0) {
                this.bNX = str;
            }
            if (this.hSH != null && this.hSH.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.hSH.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.getPlayerView().getParent() == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.ae.a.RB().brA.clientIP);
                        jSONObject.put("level", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                        jSONObject.put("sessionLine", 1);
                        dVar.b(i + 1, jSONObject);
                    } catch (Exception e) {
                        if (BdLog.isDebugMode()) {
                            BdLog.e(e);
                        }
                    }
                    dVar.setPlayerCallback(null);
                    dVar.d(this.mContext, Uri.parse(str));
                    if (dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                        ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                    }
                    if ("ZTE A0622".equals(Build.MODEL)) {
                        i2 = 2;
                    }
                    dVar.setDecodeMode(i2);
                    dVar.fj(4);
                    dVar.getPlayerView().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.getPlayerView(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.hSJ != null) {
                                SdkLivePlayer.this.hSJ.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.hSJ != null) {
                                SdkLivePlayer.this.hSJ.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.hSJ != null) {
                                SdkLivePlayer.this.hSJ.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.hSL == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.coh();
                                    SdkLivePlayer.this.al(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bNW != null) {
                                    SdkLivePlayer.this.bNW.eb(((Integer) dVar.getPlayerView().getTag(a.f.live_player_id)).intValue());
                                }
                                dVar.fj(0);
                            }
                            if (SdkLivePlayer.this.hSJ != null) {
                                SdkLivePlayer.this.hSJ.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.hSL = i4;
                        }
                    });
                    dVar.c(Uri.parse(str));
                    dVar.start();
                    dVar.setVideoScalingMode(i3);
                    a(dVar, alaLiveInfoData);
                }
            }
        }
    }

    private void a(com.baidu.live.liveroom.e.d dVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.ae.a.RB().brA.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Yj() {
        if (!ListUtils.isEmpty(this.hSH)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hSH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void coh() {
        cE(true);
    }

    @Override // com.baidu.live.u.f
    public void cE(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cof();
            return;
        }
        if (z) {
            Yj();
        }
        this.bNX = "";
        if (!ListUtils.isEmpty(this.hSH)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hSH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.hSI != null) {
            this.hSI.clear();
        }
        this.aGB = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void coi() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cof();
            return;
        }
        if (!ListUtils.isEmpty(this.hSH)) {
            for (int i = 0; i < this.hSH.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.hSH.get(i);
                if (i != 0 && dVar != null && dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
            }
        }
        this.bNX = "";
        if (!ListUtils.isEmpty(this.hSH)) {
            for (int i2 = 0; i2 < this.hSH.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.hSH.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.hSI != null) {
            this.hSI.clear();
        }
        this.aGB = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.hSH)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hSH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    if (next.isPlaying()) {
                        this.mPaused = true;
                    }
                    next.pause();
                }
            }
        }
    }

    public void resume() {
        requestAudioFocus();
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.hSH)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hSH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.resume();
                }
            }
        }
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void aSi() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            cof();
            return;
        }
        if (!ListUtils.isEmpty(this.hSH)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hSH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aGB = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.hSH)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hSH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.hSH.clear();
        }
        com.baidu.live.u.d PE = i.PB().PE();
        if (PE != null) {
            PE.b(this.hSM);
        }
    }

    @Override // com.baidu.live.u.f
    public String getVideoPath() {
        return this.bNX;
    }

    public void setIPlayerCallBack(com.baidu.live.u.b bVar) {
        this.bNW = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.u.a aVar) {
        if (this.hSK != null) {
            this.hSK.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.hSJ = fVar;
    }

    public boolean isPlaying() {
        return this.aGB;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hSI = arrayList;
        coj();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hSI = arrayList;
        coj();
    }

    private void coj() {
        if (this.hSI != null && this.hSH != null && this.hSI.size() > 0 && this.hSH.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hSI.size(); i2++) {
                if (this.hSI.get(i2) != null && this.hSH.get(i2) != null) {
                    if (this.hSI.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hSH.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cok() {
        int bh = com.baidu.live.utils.h.bh(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.gC(equipmentWidth));
        layoutParams.topMargin = bh;
        return layoutParams;
    }

    private LinearLayout.LayoutParams col() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hSK != null) {
            this.hSK.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.hSK != null) {
            this.hSK.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.hSK != null && TbadkCoreApplication.getInst().isBaidu() && !this.hSK.hasFocus()) {
            this.hSK.abandonAudioFocus();
            this.hSK.requestAudioFocus();
        }
    }
}

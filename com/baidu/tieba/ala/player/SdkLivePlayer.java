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
import com.baidu.live.data.bn;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.s.f;
import com.baidu.live.s.g;
import com.baidu.live.s.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aDV;
    private com.baidu.live.s.b bIO;
    private String bIP;
    private ArrayList<com.baidu.live.liveroom.e.d> hIY;
    private ArrayList<AlaLiveInfoData> hIZ;
    private com.baidu.live.liveroom.e.f hJa;
    private g hJb;
    private int hJc;
    private com.baidu.live.s.c hJd;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer ff(Context context) {
        if (i.Nj().Nk()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bIP = "";
        this.aDV = false;
        this.mPaused = false;
        this.hJd = new com.baidu.live.s.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hIY = new ArrayList<>();
        com.baidu.live.liveroom.e.d ay = i.Nj().ay(context);
        com.baidu.live.liveroom.e.d ay2 = i.Nj().ay(context);
        boolean z = com.baidu.live.aa.a.Ph().bms.aJP;
        this.hIY.add(ay);
        this.hIY.add(ay2);
        com.baidu.live.s.d Nm = i.Nj().Nm();
        if (Nm != null && !Nm.Og()) {
            Nm.a(this.hJd);
        }
        this.hJb = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.hJb != null) {
                this.hJb.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.hIY.size() > 0) {
            return this.hIY.get(0);
        }
        return null;
    }

    public void ckj() {
        if (this.hIY != null && this.hIY.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hIY.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aDV = false;
        }
    }

    public void ckk() {
        String str;
        requestAudioFocus();
        if (this.hIZ != null && this.hIZ.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.hIZ.iterator();
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
                        if (this.hIY != null && this.hIY.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.hIY.get(i);
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
        if (this.hIZ.size() > 0) {
            return this.hIZ.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hIZ;
    }

    @Override // com.baidu.live.s.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        ckl();
        ak(arrayList);
    }

    public void ak(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        com.baidu.live.liveroom.e.d dVar;
        bn bnVar;
        requestAudioFocus();
        this.hIZ = arrayList;
        LinearLayout.LayoutParams ckp = ckp();
        if (ListUtils.getCount(arrayList) == 2) {
            ckp = cko();
        }
        if (arrayList == null || arrayList.size() != 1 || (bnVar = com.baidu.live.aa.a.Ph().bsh) == null || bnVar.aNT == null || ((i = bnVar.aNT.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (this.hIY != null && !this.hIY.isEmpty() && (dVar = this.hIY.get(0)) != null && dVar.getPlayerView() != null) {
            dVar.getPlayerView().setLayoutParams(ckp);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, ckp, i, i2);
                }
            }
        }
        this.aDV = true;
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
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
                this.bIP = str;
            }
            if (this.hIY != null && this.hIY.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.hIY.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.getPlayerView().getParent() == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.aa.a.Ph().bms.clientIP);
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
                    dVar.eM(4);
                    dVar.getPlayerView().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.getPlayerView(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.hJa != null) {
                                SdkLivePlayer.this.hJa.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.hJa != null) {
                                SdkLivePlayer.this.hJa.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.hJa != null) {
                                SdkLivePlayer.this.hJa.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.hJc == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.ckl();
                                    SdkLivePlayer.this.ak(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bIO != null) {
                                    SdkLivePlayer.this.bIO.dI(((Integer) dVar.getPlayerView().getTag(a.f.live_player_id)).intValue());
                                }
                                dVar.eM(0);
                            }
                            if (SdkLivePlayer.this.hJa != null) {
                                SdkLivePlayer.this.hJa.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.hJc = i4;
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
        hashMap.put("clientIp", com.baidu.live.aa.a.Ph().bms.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void VJ() {
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hIY.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void ckl() {
        cq(true);
    }

    @Override // com.baidu.live.s.f
    public void cq(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            ckj();
            return;
        }
        if (z) {
            VJ();
        }
        this.bIP = "";
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hIY.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.hIZ != null) {
            this.hIZ.clear();
        }
        this.aDV = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void ckm() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            ckj();
            return;
        }
        if (!ListUtils.isEmpty(this.hIY)) {
            for (int i = 0; i < this.hIY.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.hIY.get(i);
                if (i != 0 && dVar != null && dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
            }
        }
        this.bIP = "";
        if (!ListUtils.isEmpty(this.hIY)) {
            for (int i2 = 0; i2 < this.hIY.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.hIY.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.hIZ != null) {
            this.hIZ.clear();
        }
        this.aDV = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    @Override // com.baidu.live.s.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hIY.iterator();
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
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hIY.iterator();
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

    public void aPd() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            ckj();
            return;
        }
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hIY.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aDV = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.hIY)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hIY.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.hIY.clear();
        }
        com.baidu.live.s.d Nm = i.Nj().Nm();
        if (Nm != null) {
            Nm.b(this.hJd);
        }
    }

    @Override // com.baidu.live.s.f
    public String getVideoPath() {
        return this.bIP;
    }

    public void setIPlayerCallBack(com.baidu.live.s.b bVar) {
        this.bIO = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.s.a aVar) {
        if (this.hJb != null) {
            this.hJb.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.hJa = fVar;
    }

    public boolean isPlaying() {
        return this.aDV;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hIZ = arrayList;
        ckn();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hIZ = arrayList;
        ckn();
    }

    private void ckn() {
        if (this.hIZ != null && this.hIY != null && this.hIZ.size() > 0 && this.hIY.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hIZ.size(); i2++) {
                if (this.hIZ.get(i2) != null && this.hIY.get(i2) != null) {
                    if (this.hIZ.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hIY.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cko() {
        int aD = com.baidu.live.utils.h.aD(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.gd(equipmentWidth));
        layoutParams.topMargin = aD;
        return layoutParams;
    }

    private LinearLayout.LayoutParams ckp() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hJb != null) {
            this.hJb.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.hJb != null) {
            this.hJb.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.hJb != null && TbadkCoreApplication.getInst().isBaidu() && !this.hJb.hasFocus()) {
            this.hJb.abandonAudioFocus();
            this.hJb.requestAudioFocus();
        }
    }
}

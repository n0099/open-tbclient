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
import com.baidu.live.data.bm;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.r.f;
import com.baidu.live.r.g;
import com.baidu.live.r.h;
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
    private boolean aEQ;
    private com.baidu.live.r.b bET;
    private String bEU;
    private ArrayList<com.baidu.live.liveroom.e.d> hDu;
    private ArrayList<AlaLiveInfoData> hDv;
    private com.baidu.live.liveroom.e.f hDw;
    private g hDx;
    private int hDy;
    private com.baidu.live.r.c hDz;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer ff(Context context) {
        if (i.Ns().Nt()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bEU = "";
        this.aEQ = false;
        this.mPaused = false;
        this.hDz = new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hDu = new ArrayList<>();
        com.baidu.live.liveroom.e.d ay = i.Ns().ay(context);
        com.baidu.live.liveroom.e.d ay2 = i.Ns().ay(context);
        boolean z = com.baidu.live.z.a.Pq().bmJ.aKA;
        this.hDu.add(ay);
        this.hDu.add(ay2);
        com.baidu.live.r.d Nv = i.Ns().Nv();
        if (Nv != null && !Nv.Op()) {
            Nv.a(this.hDz);
        }
        this.hDx = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.hDx != null) {
                this.hDx.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.hDu.size() > 0) {
            return this.hDu.get(0);
        }
        return null;
    }

    public void cio() {
        if (this.hDu != null && this.hDu.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hDu.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aEQ = false;
        }
    }

    public void cip() {
        String str;
        requestAudioFocus();
        if (this.hDv != null && this.hDv.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.hDv.iterator();
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
                        if (this.hDu != null && this.hDu.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.hDu.get(i);
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
        if (this.hDv.size() > 0) {
            return this.hDv.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hDv;
    }

    @Override // com.baidu.live.r.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        ciq();
        ak(arrayList);
    }

    public void ak(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        com.baidu.live.liveroom.e.d dVar;
        bm bmVar;
        requestAudioFocus();
        this.hDv = arrayList;
        LinearLayout.LayoutParams ciu = ciu();
        if (ListUtils.getCount(arrayList) == 2) {
            ciu = cit();
        }
        if (arrayList == null || arrayList.size() != 1 || (bmVar = com.baidu.live.z.a.Pq().bsy) == null || bmVar.aOH == null || ((i = bmVar.aOH.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (this.hDu != null && !this.hDu.isEmpty() && (dVar = this.hDu.get(0)) != null && dVar.getPlayerView() != null) {
            dVar.getPlayerView().setLayoutParams(ciu);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, ciu, i, i2);
                }
            }
        }
        this.aEQ = true;
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
                this.bEU = str;
            }
            if (this.hDu != null && this.hDu.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.hDu.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.getPlayerView().getParent() == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.z.a.Pq().bmJ.clientIP);
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
                    dVar.eQ(4);
                    dVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.getPlayerView(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.hDw != null) {
                                SdkLivePlayer.this.hDw.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.hDw != null) {
                                SdkLivePlayer.this.hDw.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.hDw != null) {
                                SdkLivePlayer.this.hDw.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.hDy == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.ciq();
                                    SdkLivePlayer.this.ak(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bET != null) {
                                    SdkLivePlayer.this.bET.dM(((Integer) dVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                                }
                                dVar.eQ(0);
                            }
                            if (SdkLivePlayer.this.hDw != null) {
                                SdkLivePlayer.this.hDw.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.hDy = i4;
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
        hashMap.put("clientIp", com.baidu.live.z.a.Pq().bmJ.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void TS() {
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hDu.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void ciq() {
        cn(true);
    }

    @Override // com.baidu.live.r.f
    public void cn(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cio();
            return;
        }
        if (z) {
            TS();
        }
        this.bEU = "";
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hDu.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.hDv != null) {
            this.hDv.clear();
        }
        this.aEQ = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void cir() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cio();
            return;
        }
        if (!ListUtils.isEmpty(this.hDu)) {
            for (int i = 0; i < this.hDu.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.hDu.get(i);
                if (i != 0 && dVar != null && dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
            }
        }
        this.bEU = "";
        if (!ListUtils.isEmpty(this.hDu)) {
            for (int i2 = 0; i2 < this.hDu.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.hDu.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.hDv != null) {
            this.hDv.clear();
        }
        this.aEQ = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    @Override // com.baidu.live.r.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hDu.iterator();
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
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hDu.iterator();
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

    public void aNl() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            cio();
            return;
        }
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hDu.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aEQ = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.hDu)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hDu.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.hDu.clear();
        }
        com.baidu.live.r.d Nv = i.Ns().Nv();
        if (Nv != null) {
            Nv.b(this.hDz);
        }
    }

    @Override // com.baidu.live.r.f
    public String getVideoPath() {
        return this.bEU;
    }

    public void setIPlayerCallBack(com.baidu.live.r.b bVar) {
        this.bET = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.r.a aVar) {
        if (this.hDx != null) {
            this.hDx.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.hDw = fVar;
    }

    public boolean isPlaying() {
        return this.aEQ;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hDv = arrayList;
        cis();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hDv = arrayList;
        cis();
    }

    private void cis() {
        if (this.hDv != null && this.hDu != null && this.hDv.size() > 0 && this.hDu.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hDv.size(); i2++) {
                if (this.hDv.get(i2) != null && this.hDu.get(i2) != null) {
                    if (this.hDv.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hDu.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cit() {
        int aC = com.baidu.live.utils.h.aC(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.fU(equipmentWidth));
        layoutParams.topMargin = aC;
        return layoutParams;
    }

    private LinearLayout.LayoutParams ciu() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hDx != null) {
            this.hDx.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.hDx != null) {
            this.hDx.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.hDx != null && TbadkCoreApplication.getInst().isBaidu() && !this.hDx.hasFocus()) {
            this.hDx.abandonAudioFocus();
            this.hDx.requestAudioFocus();
        }
    }
}

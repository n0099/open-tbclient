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
import com.baidu.live.data.bj;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.q.f;
import com.baidu.live.q.g;
import com.baidu.live.q.h;
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
    private boolean aEI;
    private com.baidu.live.q.b bBX;
    private String bBY;
    private ArrayList<com.baidu.live.liveroom.e.d> hrA;
    private ArrayList<AlaLiveInfoData> hrB;
    private com.baidu.live.liveroom.e.f hrC;
    private g hrD;
    private int hrE;
    private com.baidu.live.q.c hrF;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer fe(Context context) {
        if (i.MY().MZ()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bBY = "";
        this.aEI = false;
        this.mPaused = false;
        this.hrF = new com.baidu.live.q.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hrA = new ArrayList<>();
        com.baidu.live.liveroom.e.d ay = i.MY().ay(context);
        com.baidu.live.liveroom.e.d ay2 = i.MY().ay(context);
        boolean z = com.baidu.live.x.a.OS().blo.aJY;
        this.hrA.add(ay);
        this.hrA.add(ay2);
        com.baidu.live.q.d Nb = i.MY().Nb();
        if (Nb != null && !Nb.NR()) {
            Nb.a(this.hrF);
        }
        this.hrD = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.hrD != null) {
                this.hrD.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.hrA.size() > 0) {
            return this.hrA.get(0);
        }
        return null;
    }

    public void cfm() {
        if (this.hrA != null && this.hrA.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hrA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aEI = false;
        }
    }

    public void cfn() {
        String str;
        requestAudioFocus();
        if (this.hrB != null && this.hrB.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.hrB.iterator();
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
                        if (this.hrA != null && this.hrA.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.hrA.get(i);
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
        if (this.hrB.size() > 0) {
            return this.hrB.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hrB;
    }

    @Override // com.baidu.live.q.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cfo();
        aj(arrayList);
    }

    public void aj(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        com.baidu.live.liveroom.e.d dVar;
        bj bjVar;
        requestAudioFocus();
        this.hrB = arrayList;
        LinearLayout.LayoutParams cfs = cfs();
        if (ListUtils.getCount(arrayList) == 2) {
            cfs = cfr();
        }
        if (arrayList == null || arrayList.size() != 1 || (bjVar = com.baidu.live.x.a.OS().bqJ) == null || bjVar.aOc == null || ((i = bjVar.aOc.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (this.hrA != null && !this.hrA.isEmpty() && (dVar = this.hrA.get(0)) != null && dVar.getPlayerView() != null) {
            dVar.getPlayerView().setLayoutParams(cfs);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, cfs, i, i2);
                }
            }
        }
        this.aEI = true;
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
                this.bBY = str;
            }
            if (this.hrA != null && this.hrA.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.hrA.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.getPlayerView().getParent() == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.x.a.OS().blo.clientIP);
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
                    dVar.eN(4);
                    dVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.getPlayerView(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.hrC != null) {
                                SdkLivePlayer.this.hrC.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.hrC != null) {
                                SdkLivePlayer.this.hrC.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.hrC != null) {
                                SdkLivePlayer.this.hrC.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.hrE == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.cfo();
                                    SdkLivePlayer.this.aj(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bBX != null) {
                                    SdkLivePlayer.this.bBX.dM(((Integer) dVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                                }
                                dVar.eN(0);
                            }
                            if (SdkLivePlayer.this.hrC != null) {
                                SdkLivePlayer.this.hrC.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.hrE = i4;
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
        hashMap.put("clientIp", com.baidu.live.x.a.OS().blo.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void ST() {
        if (!ListUtils.isEmpty(this.hrA)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hrA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void cfo() {
        cl(true);
    }

    @Override // com.baidu.live.q.f
    public void cl(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cfm();
            return;
        }
        if (z) {
            ST();
        }
        this.bBY = "";
        if (!ListUtils.isEmpty(this.hrA)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hrA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.hrB != null) {
            this.hrB.clear();
        }
        this.aEI = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void cfp() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cfm();
            return;
        }
        if (!ListUtils.isEmpty(this.hrA)) {
            for (int i = 0; i < this.hrA.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.hrA.get(i);
                if (i != 0 && dVar != null && dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
            }
        }
        this.bBY = "";
        if (!ListUtils.isEmpty(this.hrA)) {
            for (int i2 = 0; i2 < this.hrA.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.hrA.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.hrB != null) {
            this.hrB.clear();
        }
        this.aEI = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    @Override // com.baidu.live.q.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.hrA)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hrA.iterator();
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
        if (!ListUtils.isEmpty(this.hrA)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hrA.iterator();
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

    public void aLr() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            cfm();
            return;
        }
        if (!ListUtils.isEmpty(this.hrA)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hrA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aEI = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.hrA)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.hrA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.hrA.clear();
        }
        com.baidu.live.q.d Nb = i.MY().Nb();
        if (Nb != null) {
            Nb.b(this.hrF);
        }
    }

    @Override // com.baidu.live.q.f
    public String getVideoPath() {
        return this.bBY;
    }

    public void setIPlayerCallBack(com.baidu.live.q.b bVar) {
        this.bBX = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.q.a aVar) {
        if (this.hrD != null) {
            this.hrD.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.hrC = fVar;
    }

    public boolean isPlaying() {
        return this.aEI;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hrB = arrayList;
        cfq();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hrB = arrayList;
        cfq();
    }

    private void cfq() {
        if (this.hrB != null && this.hrA != null && this.hrB.size() > 0 && this.hrA.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hrB.size(); i2++) {
                if (this.hrB.get(i2) != null && this.hrA.get(i2) != null) {
                    if (this.hrB.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hrA.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cfr() {
        int aC = com.baidu.live.utils.h.aC(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.fP(equipmentWidth));
        layoutParams.topMargin = aC;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cfs() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hrD != null) {
            this.hrD.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.hrD != null) {
            this.hrD.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.hrD != null && TbadkCoreApplication.getInst().isBaidu() && !this.hrD.hasFocus()) {
            this.hrD.abandonAudioFocus();
            this.hrD.requestAudioFocus();
        }
    }
}

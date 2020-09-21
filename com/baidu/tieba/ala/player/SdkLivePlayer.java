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
import com.baidu.live.liveroom.e.d;
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
    private boolean aBD;
    private com.baidu.live.q.b bvu;
    private String bvv;
    private g hcA;
    private int hcB;
    private com.baidu.live.q.c hcC;
    private ArrayList<d> hcx;
    private ArrayList<AlaLiveInfoData> hcy;
    private com.baidu.live.liveroom.e.f hcz;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer eX(Context context) {
        if (i.LT().LU()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bvv = "";
        this.aBD = false;
        this.hcC = new com.baidu.live.q.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.hcx = new ArrayList<>();
        d av = i.LT().av(context);
        d av2 = i.LT().av(context);
        boolean z = com.baidu.live.x.a.NN().bhy.aGU;
        this.hcx.add(av);
        this.hcx.add(av2);
        com.baidu.live.q.d LW = i.LT().LW();
        if (LW != null && !LW.MM()) {
            LW.a(this.hcC);
        }
        this.hcA = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.hcA != null) {
                this.hcA.abandonAudioFocus();
            }
        }
    }

    public d getCurrentFloatingPlayer() {
        if (this.hcx.size() > 0) {
            return this.hcx.get(0);
        }
        return null;
    }

    public void cbQ() {
        if (this.hcx != null && this.hcx.size() > 0) {
            Iterator<d> it = this.hcx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
    }

    public void cbR() {
        String str;
        requestAudioFocus();
        if (this.hcy != null && this.hcy.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.hcy.iterator();
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
                        if (this.hcx != null && this.hcx.size() > i) {
                            d dVar = this.hcx.get(i);
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
        if (this.hcy.size() > 0) {
            return this.hcy.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.hcy;
    }

    @Override // com.baidu.live.q.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cbS();
        aj(arrayList);
    }

    public void aj(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        d dVar;
        bj bjVar;
        requestAudioFocus();
        this.hcy = arrayList;
        LinearLayout.LayoutParams cbW = cbW();
        if (ListUtils.getCount(arrayList) == 2) {
            cbW = cbV();
        }
        if (arrayList == null || arrayList.size() != 1 || (bjVar = com.baidu.live.x.a.NN().bmW) == null || bjVar.aKX == null || ((i = bjVar.aKX.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (this.hcx != null && !this.hcx.isEmpty() && (dVar = this.hcx.get(0)) != null && dVar.getPlayerView() != null) {
            dVar.getPlayerView().setLayoutParams(cbW);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, cbW, i, i2);
                }
            }
        }
        this.aBD = true;
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
                this.bvv = str;
            }
            if (this.hcx != null && this.hcx.size() > 0) {
                final d dVar = this.hcx.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.getPlayerView().getParent() == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.x.a.NN().bhy.clientIP);
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
                    dVar.eE(4);
                    dVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.getPlayerView(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.hcz != null) {
                                SdkLivePlayer.this.hcz.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.hcz != null) {
                                SdkLivePlayer.this.hcz.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.hcz != null) {
                                SdkLivePlayer.this.hcz.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.hcB == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.cbS();
                                    SdkLivePlayer.this.aj(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bvu != null) {
                                    SdkLivePlayer.this.bvu.dH(((Integer) dVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                                }
                                dVar.eE(0);
                            }
                            if (SdkLivePlayer.this.hcz != null) {
                                SdkLivePlayer.this.hcz.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.hcB = i4;
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

    private void a(d dVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.x.a.NN().bhy.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Rb() {
        if (!ListUtils.isEmpty(this.hcx)) {
            Iterator<d> it = this.hcx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void cbS() {
        ci(true);
    }

    @Override // com.baidu.live.q.f
    public void ci(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cbQ();
            return;
        }
        if (z) {
            Rb();
        }
        this.bvv = "";
        if (!ListUtils.isEmpty(this.hcx)) {
            Iterator<d> it = this.hcx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.hcy != null) {
            this.hcy.clear();
        }
        this.aBD = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void cbT() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cbQ();
            return;
        }
        if (!ListUtils.isEmpty(this.hcx)) {
            for (int i = 0; i < this.hcx.size(); i++) {
                d dVar = this.hcx.get(i);
                if (i != 0 && dVar != null && dVar.getPlayerView() != null && dVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) dVar.getPlayerView().getParent()).removeView(dVar.getPlayerView());
                }
            }
        }
        this.bvv = "";
        if (!ListUtils.isEmpty(this.hcx)) {
            for (int i2 = 0; i2 < this.hcx.size(); i2++) {
                d dVar2 = this.hcx.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.hcy != null) {
            this.hcy.clear();
        }
        this.aBD = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    @Override // com.baidu.live.q.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.hcx)) {
            Iterator<d> it = this.hcx.iterator();
            while (it.hasNext()) {
                d next = it.next();
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
        if (!ListUtils.isEmpty(this.hcx)) {
            Iterator<d> it = this.hcx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.resume();
                }
            }
        }
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void aII() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            cbQ();
            return;
        }
        if (!ListUtils.isEmpty(this.hcx)) {
            Iterator<d> it = this.hcx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aBD = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.hcx)) {
            Iterator<d> it = this.hcx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.hcx.clear();
        }
        com.baidu.live.q.d LW = i.LT().LW();
        if (LW != null) {
            LW.b(this.hcC);
        }
    }

    @Override // com.baidu.live.q.f
    public String getVideoPath() {
        return this.bvv;
    }

    public void setIPlayerCallBack(com.baidu.live.q.b bVar) {
        this.bvu = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.q.a aVar) {
        if (this.hcA != null) {
            this.hcA.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.hcz = fVar;
    }

    public boolean isPlaying() {
        return this.aBD;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.hcy = arrayList;
        cbU();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.hcy = arrayList;
        cbU();
    }

    private void cbU() {
        if (this.hcy != null && this.hcx != null && this.hcy.size() > 0 && this.hcx.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.hcy.size(); i2++) {
                if (this.hcy.get(i2) != null && this.hcx.get(i2) != null) {
                    if (this.hcy.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.hcx.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cbV() {
        int az = com.baidu.live.utils.h.az(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.fG(equipmentWidth));
        layoutParams.topMargin = az;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cbW() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hcA != null) {
            this.hcA.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.hcA != null) {
            this.hcA.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.hcA != null && TbadkCoreApplication.getInst().isBaidu() && !this.hcA.hasFocus()) {
            this.hcA.abandonAudioFocus();
            this.hcA.requestAudioFocus();
        }
    }
}

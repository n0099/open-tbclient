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
import com.baidu.live.data.bv;
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
/* loaded from: classes10.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aFs;
    private com.baidu.live.u.b bTp;
    private String bTq;
    private ArrayList<com.baidu.live.liveroom.e.d> igR;
    private ArrayList<AlaLiveInfoData> igS;
    private com.baidu.live.liveroom.e.f igT;
    private g igU;
    private int igV;
    private com.baidu.live.u.c igW;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer gb(Context context) {
        if (i.MW().MX()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bTq = "";
        this.aFs = false;
        this.mPaused = false;
        this.igW = new com.baidu.live.u.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.igR = new ArrayList<>();
        com.baidu.live.liveroom.e.d aZ = i.MW().aZ(context);
        com.baidu.live.liveroom.e.d aZ2 = i.MW().aZ(context);
        boolean z = com.baidu.live.ae.a.Qm().bwx.aML;
        this.igR.add(aZ);
        this.igR.add(aZ2);
        com.baidu.live.u.d MZ = i.MW().MZ();
        if (MZ != null && !MZ.Pn()) {
            MZ.a(this.igW);
        }
        this.igU = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.igU != null) {
                this.igU.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.igR.size() > 0) {
            return this.igR.get(0);
        }
        return null;
    }

    public void cor() {
        if (this.igR != null && this.igR.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.igR.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aFs = false;
        }
    }

    public void cos() {
        String str;
        requestAudioFocus();
        if (this.igS != null && this.igS.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.igS.iterator();
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
                        if (this.igR != null && this.igR.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.igR.get(i);
                            dVar.stop();
                            dVar.e(Uri.parse(str));
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
        if (this.igS.size() > 0) {
            return this.igS.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.igS;
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cot();
        af(arrayList);
    }

    public void af(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        com.baidu.live.liveroom.e.d dVar;
        bv bvVar;
        requestAudioFocus();
        this.igS = arrayList;
        LinearLayout.LayoutParams cox = cox();
        if (ListUtils.getCount(arrayList) == 2) {
            cox = cow();
        }
        if (arrayList == null || arrayList.size() != 1 || (bvVar = com.baidu.live.ae.a.Qm().bCs) == null || bvVar.aRt == null || ((i = bvVar.aRt.aSl) != 1 && i != 2)) {
            i = 1;
        }
        if (this.igR != null && !this.igR.isEmpty() && (dVar = this.igR.get(0)) != null && dVar.MV() != null) {
            dVar.MV().setLayoutParams(cox);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, cox, i, i2);
                }
            }
        }
        this.aFs = true;
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
                this.bTq = str;
            }
            if (this.igR != null && this.igR.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.igR.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.MV().getParent() == null) {
                    if ("1".equals(alaLiveInfoData.pubShowId)) {
                        i3 = 8;
                        if (!com.baidu.live.ae.a.Qm().bwx.aNX) {
                            i3 = 0;
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.ae.a.Qm().bwx.clientIP);
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
                    if (dVar.MV() != null && dVar.MV().getParent() != null) {
                        ((ViewGroup) dVar.MV().getParent()).removeView(dVar.MV());
                    }
                    if ("ZTE A0622".equals(Build.MODEL)) {
                        i2 = 2;
                    }
                    dVar.setDecodeMode(i2);
                    dVar.dI(4);
                    dVar.MV().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.MV(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.igT != null) {
                                SdkLivePlayer.this.igT.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.igT != null) {
                                SdkLivePlayer.this.igT.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.igT != null) {
                                SdkLivePlayer.this.igT.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.igV == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.cot();
                                    SdkLivePlayer.this.af(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bTp != null) {
                                    SdkLivePlayer.this.bTp.cw(((Integer) dVar.MV().getTag(a.f.live_player_id)).intValue());
                                }
                                dVar.dI(0);
                            }
                            if (SdkLivePlayer.this.igT != null) {
                                SdkLivePlayer.this.igT.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.igV = i4;
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void b(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            SdkLivePlayer.this.aFs = false;
                            super.b(dVar2, i4, i5);
                        }
                    });
                    dVar.e(Uri.parse(str));
                    a(dVar, alaLiveInfoData);
                    dVar.start();
                    dVar.setVideoScalingMode(i3);
                }
            }
        }
    }

    private void a(com.baidu.live.liveroom.e.d dVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.ae.a.Qm().bwx.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        hashMap.put("type", "20487");
        hashMap.put("bd_live", "1");
        dVar.b(1, hashMap);
    }

    private void Xl() {
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.igR.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.MV() != null && next.MV().getParent() != null) {
                    ((ViewGroup) next.MV().getParent()).removeView(next.MV());
                }
            }
        }
        removeAllViews();
    }

    public void cot() {
        cM(true);
    }

    @Override // com.baidu.live.u.f
    public void cM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cor();
            return;
        }
        if (z) {
            Xl();
        }
        this.bTq = "";
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.igR.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.igS != null) {
            this.igS.clear();
        }
        this.aFs = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void cou() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cor();
            return;
        }
        if (!ListUtils.isEmpty(this.igR)) {
            for (int i = 0; i < this.igR.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.igR.get(i);
                if (i != 0 && dVar != null && dVar.MV() != null && dVar.MV().getParent() != null) {
                    ((ViewGroup) dVar.MV().getParent()).removeView(dVar.MV());
                }
            }
        }
        this.bTq = "";
        if (!ListUtils.isEmpty(this.igR)) {
            for (int i2 = 0; i2 < this.igR.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.igR.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.igS != null) {
            this.igS.clear();
        }
        this.aFs = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.igR.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    if (next.isPlaying()) {
                        next.pause();
                    }
                    this.mPaused = true;
                }
            }
        }
    }

    public void resume() {
        requestAudioFocus();
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.igR.iterator();
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

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            cor();
            return;
        }
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.igR.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aFs = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.igR)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.igR.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.igR.clear();
        }
        com.baidu.live.u.d MZ = i.MW().MZ();
        if (MZ != null) {
            MZ.b(this.igW);
        }
    }

    @Override // com.baidu.live.u.f
    public void setVideoMode(int i) {
        if (this.igS != null && this.igR != null && this.igS.size() > 0 && this.igR.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.igS.size()) {
                    if (this.igS.get(i3) != null && this.igR.get(i3) != null) {
                        if (this.igS.get(i3).screen_direction == 2) {
                            i = 2;
                        }
                        this.igR.get(i3).setVideoScalingMode(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.live.u.f
    public String getVideoPath() {
        return this.bTq;
    }

    public void setIPlayerCallBack(com.baidu.live.u.b bVar) {
        this.bTp = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.u.a aVar) {
        if (this.igU != null) {
            this.igU.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.igT = fVar;
    }

    public boolean isPlaying() {
        return this.aFs;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.igS = arrayList;
        cov();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.igS = arrayList;
        cov();
    }

    private void cov() {
        if (this.igS != null && this.igR != null && this.igS.size() > 0 && this.igR.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.igS.size(); i2++) {
                if (this.igS.get(i2) != null && this.igR.get(i2) != null) {
                    if (this.igS.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.igR.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cow() {
        int bl = com.baidu.live.utils.h.bl(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.fb(equipmentWidth));
        layoutParams.topMargin = bl;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cox() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.igU != null) {
            this.igU.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.igU != null) {
            this.igU.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.igU != null && TbadkCoreApplication.getInst().isBaidu() && !this.igU.hasFocus()) {
            this.igU.abandonAudioFocus();
            this.igU.requestAudioFocus();
        }
    }
}

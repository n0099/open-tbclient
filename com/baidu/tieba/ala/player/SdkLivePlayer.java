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
import com.baidu.live.data.bq;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.v.f;
import com.baidu.live.v.g;
import com.baidu.live.v.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aCf;
    private com.baidu.live.v.b bNZ;
    private String bOa;
    private int iaA;
    private com.baidu.live.v.c iaB;
    private ArrayList<com.baidu.live.liveroom.e.d> iaw;
    private ArrayList<AlaLiveInfoData> iax;
    private com.baidu.live.liveroom.e.f iay;
    private g iaz;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer gb(Context context) {
        if (i.Lv().Lw()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bOa = "";
        this.aCf = false;
        this.mPaused = false;
        this.iaB = new com.baidu.live.v.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.iaw = new ArrayList<>();
        com.baidu.live.liveroom.e.d ba = i.Lv().ba(context);
        com.baidu.live.liveroom.e.d ba2 = i.Lv().ba(context);
        boolean z = com.baidu.live.af.a.OJ().bru.aIB;
        this.iaw.add(ba);
        this.iaw.add(ba2);
        com.baidu.live.v.d Ly = i.Lv().Ly();
        if (Ly != null && !Ly.NI()) {
            Ly.a(this.iaB);
        }
        this.iaz = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.iaz != null) {
                this.iaz.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.iaw.size() > 0) {
            return this.iaw.get(0);
        }
        return null;
    }

    public void cng() {
        if (this.iaw != null && this.iaw.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.iaw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aCf = false;
        }
    }

    public void cnh() {
        String str;
        requestAudioFocus();
        if (this.iax != null && this.iax.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.iax.iterator();
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
                        if (this.iaw != null && this.iaw.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.iaw.get(i);
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
        if (this.iax.size() > 0) {
            return this.iax.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.iax;
    }

    @Override // com.baidu.live.v.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cni();
        ag(arrayList);
    }

    public void ag(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        com.baidu.live.liveroom.e.d dVar;
        bq bqVar;
        requestAudioFocus();
        this.iax = arrayList;
        LinearLayout.LayoutParams cnm = cnm();
        if (ListUtils.getCount(arrayList) == 2) {
            cnm = cnl();
        }
        if (arrayList == null || arrayList.size() != 1 || (bqVar = com.baidu.live.af.a.OJ().bxp) == null || bqVar.aMV == null || ((i = bqVar.aMV.aNK) != 1 && i != 2)) {
            i = 1;
        }
        if (this.iaw != null && !this.iaw.isEmpty() && (dVar = this.iaw.get(0)) != null && dVar.Lu() != null) {
            dVar.Lu().setLayoutParams(cnm);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, cnm, i, i2);
                }
            }
        }
        this.aCf = true;
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
                this.bOa = str;
            }
            if (this.iaw != null && this.iaw.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.iaw.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.Lu().getParent() == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.af.a.OJ().bru.clientIP);
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
                    if (dVar.Lu() != null && dVar.Lu().getParent() != null) {
                        ((ViewGroup) dVar.Lu().getParent()).removeView(dVar.Lu());
                    }
                    if ("ZTE A0622".equals(Build.MODEL)) {
                        i2 = 2;
                    }
                    dVar.setDecodeMode(i2);
                    dVar.dB(4);
                    dVar.Lu().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.Lu(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.iay != null) {
                                SdkLivePlayer.this.iay.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.iay != null) {
                                SdkLivePlayer.this.iay.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.iay != null) {
                                SdkLivePlayer.this.iay.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.iaA == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.cni();
                                    SdkLivePlayer.this.ag(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bNZ != null) {
                                    SdkLivePlayer.this.bNZ.cs(((Integer) dVar.Lu().getTag(a.f.live_player_id)).intValue());
                                }
                                dVar.dB(0);
                            }
                            if (SdkLivePlayer.this.iay != null) {
                                SdkLivePlayer.this.iay.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.iaA = i4;
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
        hashMap.put("clientIp", com.baidu.live.af.a.OJ().bru.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        hashMap.put("type", "20487");
        hashMap.put("bd_live", "1");
        dVar.b(1, hashMap);
    }

    private void Vz() {
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.iaw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.Lu() != null && next.Lu().getParent() != null) {
                    ((ViewGroup) next.Lu().getParent()).removeView(next.Lu());
                }
            }
        }
        removeAllViews();
    }

    public void cni() {
        cD(true);
    }

    @Override // com.baidu.live.v.f
    public void cD(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cng();
            return;
        }
        if (z) {
            Vz();
        }
        this.bOa = "";
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.iaw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.iax != null) {
            this.iax.clear();
        }
        this.aCf = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void cnj() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cng();
            return;
        }
        if (!ListUtils.isEmpty(this.iaw)) {
            for (int i = 0; i < this.iaw.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.iaw.get(i);
                if (i != 0 && dVar != null && dVar.Lu() != null && dVar.Lu().getParent() != null) {
                    ((ViewGroup) dVar.Lu().getParent()).removeView(dVar.Lu());
                }
            }
        }
        this.bOa = "";
        if (!ListUtils.isEmpty(this.iaw)) {
            for (int i2 = 0; i2 < this.iaw.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.iaw.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.iax != null) {
            this.iax.clear();
        }
        this.aCf = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    @Override // com.baidu.live.v.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.iaw.iterator();
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
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.iaw.iterator();
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

    public void aQJ() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            cng();
            return;
        }
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.iaw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aCf = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.iaw)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.iaw.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.iaw.clear();
        }
        com.baidu.live.v.d Ly = i.Lv().Ly();
        if (Ly != null) {
            Ly.b(this.iaB);
        }
    }

    @Override // com.baidu.live.v.f
    public String getVideoPath() {
        return this.bOa;
    }

    public void setIPlayerCallBack(com.baidu.live.v.b bVar) {
        this.bNZ = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.v.a aVar) {
        if (this.iaz != null) {
            this.iaz.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.iay = fVar;
    }

    public boolean isPlaying() {
        return this.aCf;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.iax = arrayList;
        cnk();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.iax = arrayList;
        cnk();
    }

    private void cnk() {
        if (this.iax != null && this.iaw != null && this.iax.size() > 0 && this.iaw.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.iax.size(); i2++) {
                if (this.iax.get(i2) != null && this.iaw.get(i2) != null) {
                    if (this.iax.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.iaw.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams cnl() {
        int bm = com.baidu.live.utils.h.bm(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.eW(equipmentWidth));
        layoutParams.topMargin = bm;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cnm() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.iaz != null) {
            this.iaz.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.iaz != null) {
            this.iaz.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.iaz != null && TbadkCoreApplication.getInst().isBaidu() && !this.iaz.hasFocus()) {
            this.iaz.abandonAudioFocus();
            this.iaz.requestAudioFocus();
        }
    }
}

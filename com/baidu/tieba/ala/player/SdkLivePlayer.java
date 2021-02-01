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
/* loaded from: classes11.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aDS;
    private com.baidu.live.u.b bRP;
    private String bRQ;
    private ArrayList<com.baidu.live.liveroom.e.d> ieU;
    private ArrayList<AlaLiveInfoData> ieV;
    private com.baidu.live.liveroom.e.f ieW;
    private g ieX;
    private int ieY;
    private com.baidu.live.u.c ieZ;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer gc(Context context) {
        if (i.MT().MU()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bRQ = "";
        this.aDS = false;
        this.mPaused = false;
        this.ieZ = new com.baidu.live.u.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.ieU = new ArrayList<>();
        com.baidu.live.liveroom.e.d ba = i.MT().ba(context);
        com.baidu.live.liveroom.e.d ba2 = i.MT().ba(context);
        boolean z = com.baidu.live.ae.a.Qj().buX.aLl;
        this.ieU.add(ba);
        this.ieU.add(ba2);
        com.baidu.live.u.d MW = i.MT().MW();
        if (MW != null && !MW.Pk()) {
            MW.a(this.ieZ);
        }
        this.ieX = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.ieX != null) {
                this.ieX.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.ieU.size() > 0) {
            return this.ieU.get(0);
        }
        return null;
    }

    public void coe() {
        if (this.ieU != null && this.ieU.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ieU.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aDS = false;
        }
    }

    public void cof() {
        String str;
        requestAudioFocus();
        if (this.ieV != null && this.ieV.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.ieV.iterator();
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
                        if (this.ieU != null && this.ieU.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.ieU.get(i);
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
        if (this.ieV.size() > 0) {
            return this.ieV.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.ieV;
    }

    @Override // com.baidu.live.u.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cog();
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
        this.ieV = arrayList;
        LinearLayout.LayoutParams cok = cok();
        if (ListUtils.getCount(arrayList) == 2) {
            cok = coj();
        }
        if (arrayList == null || arrayList.size() != 1 || (bvVar = com.baidu.live.ae.a.Qj().bAS) == null || bvVar.aPT == null || ((i = bvVar.aPT.aQL) != 1 && i != 2)) {
            i = 1;
        }
        if (this.ieU != null && !this.ieU.isEmpty() && (dVar = this.ieU.get(0)) != null && dVar.MS() != null) {
            dVar.MS().setLayoutParams(cok);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, cok, i, i2);
                }
            }
        }
        this.aDS = true;
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
                this.bRQ = str;
            }
            if (this.ieU != null && this.ieU.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.ieU.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.MS().getParent() == null) {
                    if ("1".equals(alaLiveInfoData.pubShowId)) {
                        i3 = 8;
                        if (!com.baidu.live.ae.a.Qj().buX.aMx) {
                            i3 = 0;
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.ae.a.Qj().buX.clientIP);
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
                    if (dVar.MS() != null && dVar.MS().getParent() != null) {
                        ((ViewGroup) dVar.MS().getParent()).removeView(dVar.MS());
                    }
                    if ("ZTE A0622".equals(Build.MODEL)) {
                        i2 = 2;
                    }
                    dVar.setDecodeMode(i2);
                    dVar.dH(4);
                    dVar.MS().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.MS(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.ieW != null) {
                                SdkLivePlayer.this.ieW.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.ieW != null) {
                                SdkLivePlayer.this.ieW.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.ieW != null) {
                                SdkLivePlayer.this.ieW.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.ieY == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.cog();
                                    SdkLivePlayer.this.af(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bRP != null) {
                                    SdkLivePlayer.this.bRP.cv(((Integer) dVar.MS().getTag(a.f.live_player_id)).intValue());
                                }
                                dVar.dH(0);
                            }
                            if (SdkLivePlayer.this.ieW != null) {
                                SdkLivePlayer.this.ieW.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.ieY = i4;
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void b(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            SdkLivePlayer.this.aDS = false;
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
        hashMap.put("clientIp", com.baidu.live.ae.a.Qj().buX.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        hashMap.put("type", "20487");
        hashMap.put("bd_live", "1");
        dVar.b(1, hashMap);
    }

    private void Xi() {
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ieU.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.MS() != null && next.MS().getParent() != null) {
                    ((ViewGroup) next.MS().getParent()).removeView(next.MS());
                }
            }
        }
        removeAllViews();
    }

    public void cog() {
        cM(true);
    }

    @Override // com.baidu.live.u.f
    public void cM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            coe();
            return;
        }
        if (z) {
            Xi();
        }
        this.bRQ = "";
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ieU.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.ieV != null) {
            this.ieV.clear();
        }
        this.aDS = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void coh() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            coe();
            return;
        }
        if (!ListUtils.isEmpty(this.ieU)) {
            for (int i = 0; i < this.ieU.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.ieU.get(i);
                if (i != 0 && dVar != null && dVar.MS() != null && dVar.MS().getParent() != null) {
                    ((ViewGroup) dVar.MS().getParent()).removeView(dVar.MS());
                }
            }
        }
        this.bRQ = "";
        if (!ListUtils.isEmpty(this.ieU)) {
            for (int i2 = 0; i2 < this.ieU.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.ieU.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.ieV != null) {
            this.ieV.clear();
        }
        this.aDS = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    @Override // com.baidu.live.u.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ieU.iterator();
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
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ieU.iterator();
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
            coe();
            return;
        }
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ieU.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aDS = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.ieU)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ieU.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.ieU.clear();
        }
        com.baidu.live.u.d MW = i.MT().MW();
        if (MW != null) {
            MW.b(this.ieZ);
        }
    }

    @Override // com.baidu.live.u.f
    public void setVideoMode(int i) {
        if (this.ieV != null && this.ieU != null && this.ieV.size() > 0 && this.ieU.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.ieV.size()) {
                    if (this.ieV.get(i3) != null && this.ieU.get(i3) != null) {
                        if (this.ieV.get(i3).screen_direction == 2) {
                            i = 2;
                        }
                        this.ieU.get(i3).setVideoScalingMode(i);
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
        return this.bRQ;
    }

    public void setIPlayerCallBack(com.baidu.live.u.b bVar) {
        this.bRP = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.u.a aVar) {
        if (this.ieX != null) {
            this.ieX.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.ieW = fVar;
    }

    public boolean isPlaying() {
        return this.aDS;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.ieV = arrayList;
        coi();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.ieV = arrayList;
        coi();
    }

    private void coi() {
        if (this.ieV != null && this.ieU != null && this.ieV.size() > 0 && this.ieU.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.ieV.size(); i2++) {
                if (this.ieV.get(i2) != null && this.ieU.get(i2) != null) {
                    if (this.ieV.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.ieU.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams coj() {
        int bm = com.baidu.live.utils.h.bm(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.fa(equipmentWidth));
        layoutParams.topMargin = bm;
        return layoutParams;
    }

    private LinearLayout.LayoutParams cok() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ieX != null) {
            this.ieX.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.ieX != null) {
            this.ieX.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.ieX != null && TbadkCoreApplication.getInst().isBaidu() && !this.ieX.hasFocus()) {
            this.ieX.abandonAudioFocus();
            this.ieX.requestAudioFocus();
        }
    }
}

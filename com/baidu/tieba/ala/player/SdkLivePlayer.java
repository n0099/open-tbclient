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
import com.baidu.live.data.be;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.h;
import com.baidu.live.p.f;
import com.baidu.live.p.g;
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
/* loaded from: classes7.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aAV;
    private com.baidu.live.p.b bsc;
    private String bsd;
    private ArrayList<d> gYK;
    private ArrayList<AlaLiveInfoData> gYL;
    private com.baidu.live.liveroom.e.f gYM;
    private g gYN;
    private int gYO;
    private com.baidu.live.p.c gYP;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer eR(Context context) {
        if (h.Lr().Ls()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bsd = "";
        this.aAV = false;
        this.gYP = new com.baidu.live.p.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.gYK = new ArrayList<>();
        d av = h.Lr().av(context);
        d av2 = h.Lr().av(context);
        boolean z = com.baidu.live.w.a.Nk().beH.aFD;
        this.gYK.add(av);
        this.gYK.add(av2);
        com.baidu.live.p.d Lu = h.Lr().Lu();
        if (Lu != null && !Lu.Mh()) {
            Lu.a(this.gYP);
        }
        this.gYN = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.gYN != null) {
                this.gYN.abandonAudioFocus();
            }
        }
    }

    public d getCurrentFloatingPlayer() {
        if (this.gYK.size() > 0) {
            return this.gYK.get(0);
        }
        return null;
    }

    public void bZP() {
        if (this.gYK != null && this.gYK.size() > 0) {
            Iterator<d> it = this.gYK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
    }

    public void bZQ() {
        String str;
        if (this.gYL != null && this.gYL.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.gYL.iterator();
            int i = 0;
            while (it.hasNext()) {
                AlaLiveInfoData next = it.next();
                if (next != null) {
                    if (TextUtils.isEmpty(next.playUrl)) {
                        str = com.baidu.live.p.h.d(next);
                    } else {
                        str = next.playUrl;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (this.gYK != null && this.gYK.size() > i) {
                            d dVar = this.gYK.get(i);
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
        if (this.gYL.size() > 0) {
            return this.gYL.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.gYL;
    }

    @Override // com.baidu.live.p.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bZR();
        ai(arrayList);
    }

    public void ai(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        be beVar;
        this.gYL = arrayList;
        LinearLayout.LayoutParams bZU = bZU();
        if (ListUtils.getCount(arrayList) == 2) {
            bZU = bZT();
        }
        if (arrayList == null || arrayList.size() != 1 || (beVar = com.baidu.live.w.a.Nk().bka) == null || beVar.aJF == null || ((i = beVar.aJF.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, bZU, i, i2);
            }
        }
        this.aAV = true;
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String str;
        if (TextUtils.isEmpty(alaLiveInfoData.playUrl)) {
            str = com.baidu.live.p.h.d(alaLiveInfoData);
        } else {
            str = alaLiveInfoData.playUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + str);
            }
            if (i == 0) {
                this.bsd = str;
            }
            if (this.gYK != null && this.gYK.size() > 0) {
                final d dVar = this.gYK.get(i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.w.a.Nk().beH.clientIP);
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
                dVar.eA(8);
                dVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(dVar.getPlayerView(), layoutParams);
                dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void onStart() {
                        super.onStart();
                        if (SdkLivePlayer.this.gYM != null) {
                            SdkLivePlayer.this.gYM.onStart();
                        }
                    }

                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void onPause() {
                        super.onPause();
                        if (SdkLivePlayer.this.gYM != null) {
                            SdkLivePlayer.this.gYM.onPause();
                        }
                    }

                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void onEnd(int i4) {
                        super.onEnd(i4);
                        if (SdkLivePlayer.this.gYM != null) {
                            SdkLivePlayer.this.gYM.onEnd(i4);
                        }
                    }

                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                        if (SdkLivePlayer.this.gYO == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
                            ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                            if (!ListUtils.isEmpty(arrayList)) {
                                ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                SdkLivePlayer.this.bZR();
                                SdkLivePlayer.this.ai(arrayList2);
                            }
                        }
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bsc != null) {
                                SdkLivePlayer.this.bsc.dD(((Integer) dVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            dVar.eA(0);
                        }
                        if (SdkLivePlayer.this.gYM != null) {
                            SdkLivePlayer.this.gYM.a(dVar2, i4, i5);
                        }
                        SdkLivePlayer.this.gYO = i4;
                    }
                });
                dVar.c(Uri.parse(str));
                dVar.start();
                dVar.setVideoScalingMode(i3);
                a(dVar, alaLiveInfoData);
            }
        }
    }

    private void a(d dVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.w.a.Nk().beH.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Qt() {
        if (!ListUtils.isEmpty(this.gYK)) {
            Iterator<d> it = this.gYK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bZR() {
        ch(true);
    }

    @Override // com.baidu.live.p.f
    public void ch(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            bZP();
            return;
        }
        if (z) {
            Qt();
        }
        this.bsd = "";
        if (!ListUtils.isEmpty(this.gYK)) {
            Iterator<d> it = this.gYK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.gYL != null) {
            this.gYL.clear();
        }
        this.aAV = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    @Override // com.baidu.live.p.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.gYK)) {
            Iterator<d> it = this.gYK.iterator();
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
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.gYK)) {
            Iterator<d> it = this.gYK.iterator();
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

    public void aHX() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            bZP();
            return;
        }
        if (!ListUtils.isEmpty(this.gYK)) {
            Iterator<d> it = this.gYK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aAV = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.gYK)) {
            Iterator<d> it = this.gYK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.gYK.clear();
        }
        com.baidu.live.p.d Lu = h.Lr().Lu();
        if (Lu != null) {
            Lu.b(this.gYP);
        }
    }

    @Override // com.baidu.live.p.f
    public String getVideoPath() {
        return this.bsd;
    }

    public void setIPlayerCallBack(com.baidu.live.p.b bVar) {
        this.bsc = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.p.a aVar) {
        if (this.gYN != null) {
            this.gYN.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.gYM = fVar;
    }

    public boolean isPlaying() {
        return this.aAV;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.gYL = arrayList;
        bZS();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.gYL = arrayList;
        bZS();
    }

    private void bZS() {
        if (this.gYL != null && this.gYK != null && this.gYL.size() > 0 && this.gYK.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.gYL.size(); i2++) {
                if (this.gYL.get(i2) != null && this.gYK.get(i2) != null) {
                    if (this.gYL.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.gYK.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams bZT() {
        int az = com.baidu.live.utils.g.az(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.g.fv(equipmentWidth));
        layoutParams.topMargin = az;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bZU() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gYN != null) {
            this.gYN.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.gYN != null) {
            this.gYN.abandonAudioFocus();
        }
    }
}

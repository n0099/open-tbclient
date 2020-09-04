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
    private boolean aAX;
    private com.baidu.live.p.b bsf;
    private String bsg;
    private ArrayList<d> gYO;
    private ArrayList<AlaLiveInfoData> gYP;
    private com.baidu.live.liveroom.e.f gYQ;
    private g gYR;
    private int gYS;
    private com.baidu.live.p.c gYT;
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
        this.bsg = "";
        this.aAX = false;
        this.gYT = new com.baidu.live.p.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.gYO = new ArrayList<>();
        d av = h.Lr().av(context);
        d av2 = h.Lr().av(context);
        boolean z = com.baidu.live.w.a.Nk().beJ.aFF;
        this.gYO.add(av);
        this.gYO.add(av2);
        com.baidu.live.p.d Lu = h.Lr().Lu();
        if (Lu != null && !Lu.Mh()) {
            Lu.a(this.gYT);
        }
        this.gYR = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.gYR != null) {
                this.gYR.abandonAudioFocus();
            }
        }
    }

    public d getCurrentFloatingPlayer() {
        if (this.gYO.size() > 0) {
            return this.gYO.get(0);
        }
        return null;
    }

    public void bZQ() {
        if (this.gYO != null && this.gYO.size() > 0) {
            Iterator<d> it = this.gYO.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
    }

    public void bZR() {
        String str;
        requestAudioFocus();
        if (this.gYP != null && this.gYP.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.gYP.iterator();
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
                        if (this.gYO != null && this.gYO.size() > i) {
                            d dVar = this.gYO.get(i);
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
        if (this.gYP.size() > 0) {
            return this.gYP.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.gYP;
    }

    @Override // com.baidu.live.p.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bZS();
        ai(arrayList);
    }

    public void ai(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        be beVar;
        requestAudioFocus();
        this.gYP = arrayList;
        LinearLayout.LayoutParams bZV = bZV();
        if (ListUtils.getCount(arrayList) == 2) {
            bZV = bZU();
        }
        if (arrayList == null || arrayList.size() != 1 || (beVar = com.baidu.live.w.a.Nk().bkd) == null || beVar.aJH == null || ((i = beVar.aJH.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, bZV, i, i2);
            }
        }
        this.aAX = true;
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
                this.bsg = str;
            }
            if (this.gYO != null && this.gYO.size() > 0) {
                final d dVar = this.gYO.get(i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.w.a.Nk().beJ.clientIP);
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
                        if (SdkLivePlayer.this.gYQ != null) {
                            SdkLivePlayer.this.gYQ.onStart();
                        }
                    }

                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void onPause() {
                        super.onPause();
                        if (SdkLivePlayer.this.gYQ != null) {
                            SdkLivePlayer.this.gYQ.onPause();
                        }
                    }

                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void onEnd(int i4) {
                        super.onEnd(i4);
                        if (SdkLivePlayer.this.gYQ != null) {
                            SdkLivePlayer.this.gYQ.onEnd(i4);
                        }
                    }

                    @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                    public void a(d dVar2, int i4, int i5) {
                        if (SdkLivePlayer.this.gYS == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba()) {
                            ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                            if (!ListUtils.isEmpty(arrayList)) {
                                ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                SdkLivePlayer.this.bZS();
                                SdkLivePlayer.this.ai(arrayList2);
                            }
                        }
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bsf != null) {
                                SdkLivePlayer.this.bsf.dD(((Integer) dVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            dVar.eA(0);
                        }
                        if (SdkLivePlayer.this.gYQ != null) {
                            SdkLivePlayer.this.gYQ.a(dVar2, i4, i5);
                        }
                        SdkLivePlayer.this.gYS = i4;
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
        hashMap.put("clientIp", com.baidu.live.w.a.Nk().beJ.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        dVar.b(1, hashMap);
    }

    private void Qt() {
        if (!ListUtils.isEmpty(this.gYO)) {
            Iterator<d> it = this.gYO.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bZS() {
        ch(true);
    }

    @Override // com.baidu.live.p.f
    public void ch(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            bZQ();
            return;
        }
        if (z) {
            Qt();
        }
        this.bsg = "";
        if (!ListUtils.isEmpty(this.gYO)) {
            Iterator<d> it = this.gYO.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.gYP != null) {
            this.gYP.clear();
        }
        this.aAX = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    @Override // com.baidu.live.p.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.gYO)) {
            Iterator<d> it = this.gYO.iterator();
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
        if (!ListUtils.isEmpty(this.gYO)) {
            Iterator<d> it = this.gYO.iterator();
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
            bZQ();
            return;
        }
        if (!ListUtils.isEmpty(this.gYO)) {
            Iterator<d> it = this.gYO.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aAX = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, LogConfig.KEY_NOTICE, "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.gYO)) {
            Iterator<d> it = this.gYO.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.gYO.clear();
        }
        com.baidu.live.p.d Lu = h.Lr().Lu();
        if (Lu != null) {
            Lu.b(this.gYT);
        }
    }

    @Override // com.baidu.live.p.f
    public String getVideoPath() {
        return this.bsg;
    }

    public void setIPlayerCallBack(com.baidu.live.p.b bVar) {
        this.bsf = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.p.a aVar) {
        if (this.gYR != null) {
            this.gYR.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.gYQ = fVar;
    }

    public boolean isPlaying() {
        return this.aAX;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.gYP = arrayList;
        bZT();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.gYP = arrayList;
        bZT();
    }

    private void bZT() {
        if (this.gYP != null && this.gYO != null && this.gYP.size() > 0 && this.gYO.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.gYP.size(); i2++) {
                if (this.gYP.get(i2) != null && this.gYO.get(i2) != null) {
                    if (this.gYP.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.gYO.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams bZU() {
        int az = com.baidu.live.utils.g.az(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.g.fv(equipmentWidth));
        layoutParams.topMargin = az;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bZV() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gYR != null) {
            this.gYR.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.gYR != null) {
            this.gYR.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.gYR != null && TbadkCoreApplication.getInst().isBaidu() && !this.gYR.hasFocus()) {
            this.gYR.abandonAudioFocus();
            this.gYR.requestAudioFocus();
        }
    }
}

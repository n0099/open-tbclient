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
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private boolean aGS;
    private com.baidu.live.v.b bSL;
    private String bSM;
    private ArrayList<com.baidu.live.liveroom.e.d> ifh;
    private ArrayList<AlaLiveInfoData> ifi;
    private com.baidu.live.liveroom.e.f ifj;
    private g ifk;
    private int ifl;
    private com.baidu.live.v.c ifm;
    private Context mContext;
    private boolean mIsFloating;
    private boolean mPaused;

    public static SdkLivePlayer ge(Context context) {
        if (i.Pq().Pr()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        this.bSM = "";
        this.aGS = false;
        this.mPaused = false;
        this.ifm = new com.baidu.live.v.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.ifh = new ArrayList<>();
        com.baidu.live.liveroom.e.d bb = i.Pq().bb(context);
        com.baidu.live.liveroom.e.d bb2 = i.Pq().bb(context);
        boolean z = com.baidu.live.af.a.SE().bwi.aNo;
        this.ifh.add(bb);
        this.ifh.add(bb2);
        com.baidu.live.v.d Pt = i.Pq().Pt();
        if (Pt != null && !Pt.RD()) {
            Pt.a(this.ifm);
        }
        this.ifk = new g(this.mContext);
    }

    public boolean isFloatingMode() {
        return this.mIsFloating;
    }

    public void setFloatingModel(boolean z) {
        if (this.mIsFloating != z) {
            this.mIsFloating = z;
            if (!this.mIsFloating && this.ifk != null) {
                this.ifk.abandonAudioFocus();
            }
        }
    }

    public com.baidu.live.liveroom.e.d getCurrentFloatingPlayer() {
        if (this.ifh.size() > 0) {
            return this.ifh.get(0);
        }
        return null;
    }

    public void cqX() {
        if (this.ifh != null && this.ifh.size() > 0) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ifh.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
            this.aGS = false;
        }
    }

    public void cqY() {
        String str;
        requestAudioFocus();
        if (this.ifi != null && this.ifi.size() > 0) {
            Iterator<AlaLiveInfoData> it = this.ifi.iterator();
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
                        if (this.ifh != null && this.ifh.size() > i) {
                            com.baidu.live.liveroom.e.d dVar = this.ifh.get(i);
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
        if (this.ifi.size() > 0) {
            return this.ifi.get(0);
        }
        return null;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.ifi;
    }

    @Override // com.baidu.live.v.f
    public void c(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        cqZ();
        al(arrayList);
    }

    public void al(ArrayList<AlaLiveInfoData> arrayList) {
        e(arrayList, false);
    }

    public void e(ArrayList<AlaLiveInfoData> arrayList, boolean z) {
        int i;
        com.baidu.live.liveroom.e.d dVar;
        bq bqVar;
        requestAudioFocus();
        this.ifi = arrayList;
        LinearLayout.LayoutParams crd = crd();
        if (ListUtils.getCount(arrayList) == 2) {
            crd = crc();
        }
        if (arrayList == null || arrayList.size() != 1 || (bqVar = com.baidu.live.af.a.SE().bCb) == null || bqVar.aRI == null || ((i = bqVar.aRI.aSx) != 1 && i != 2)) {
            i = 1;
        }
        if (this.ifh != null && !this.ifh.isEmpty() && (dVar = this.ifh.get(0)) != null && dVar.Pp() != null) {
            dVar.Pp().setLayoutParams(crd);
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                if (i3 != 0 || !z) {
                    a(arrayList.get(i3), i3, crd, i, i2);
                }
            }
        }
        this.aGS = true;
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
                this.bSM = str;
            }
            if (this.ifh != null && this.ifh.size() > 0) {
                final com.baidu.live.liveroom.e.d dVar = this.ifh.get(i);
                if (i != 0 || !dVar.isPlaying() || dVar.Pp().getParent() == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                        jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                        jSONObject.put("clientIp", com.baidu.live.af.a.SE().bwi.clientIP);
                        jSONObject.put(MapBundleKey.MapObjKey.OBJ_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                        jSONObject.put("sessionLine", 1);
                        dVar.b(i + 1, jSONObject);
                    } catch (Exception e) {
                        if (BdLog.isDebugMode()) {
                            BdLog.e(e);
                        }
                    }
                    dVar.setPlayerCallback(null);
                    dVar.d(this.mContext, Uri.parse(str));
                    if (dVar.Pp() != null && dVar.Pp().getParent() != null) {
                        ((ViewGroup) dVar.Pp().getParent()).removeView(dVar.Pp());
                    }
                    if ("ZTE A0622".equals(Build.MODEL)) {
                        i2 = 2;
                    }
                    dVar.setDecodeMode(i2);
                    dVar.fh(4);
                    dVar.Pp().setTag(a.f.live_player_id, Integer.valueOf(i + 1));
                    addView(dVar.Pp(), layoutParams);
                    dVar.setPlayerCallback(new com.baidu.live.liveroom.e.g() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            if (SdkLivePlayer.this.ifj != null) {
                                SdkLivePlayer.this.ifj.onStart();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            if (SdkLivePlayer.this.ifj != null) {
                                SdkLivePlayer.this.ifj.onPause();
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i4) {
                            super.onEnd(i4);
                            if (SdkLivePlayer.this.ifj != null) {
                                SdkLivePlayer.this.ifj.onEnd(i4);
                            }
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar2, int i4, int i5) {
                            if (com.baidu.live.liveroom.e.h.isDebug()) {
                                Log.d("sdkLivePlayer", "onInfo " + i4 + ", " + i5);
                            }
                            if (SdkLivePlayer.this.ifl == 936 && i4 == 904 && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo() && !TbadkCoreApplication.getInst().isTieba()) {
                                ArrayList arrayList = (ArrayList) SdkLivePlayer.this.getAlaLiveInfoDataList();
                                if (!ListUtils.isEmpty(arrayList)) {
                                    ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
                                    SdkLivePlayer.this.cqZ();
                                    SdkLivePlayer.this.al(arrayList2);
                                }
                            }
                            if (i4 == 904) {
                                if (BdLog.isDebugMode()) {
                                    BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                                }
                                if (SdkLivePlayer.this.bSL != null) {
                                    SdkLivePlayer.this.bSL.dY(((Integer) dVar.Pp().getTag(a.f.live_player_id)).intValue());
                                }
                                dVar.fh(0);
                            }
                            if (SdkLivePlayer.this.ifj != null) {
                                SdkLivePlayer.this.ifj.a(dVar2, i4, i5);
                            }
                            SdkLivePlayer.this.ifl = i4;
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
        hashMap.put("clientIp", com.baidu.live.af.a.SE().bwi.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        hashMap.put("type", "20487");
        hashMap.put("bd_live", "1");
        dVar.b(1, hashMap);
    }

    private void Zr() {
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ifh.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null && next.Pp() != null && next.Pp().getParent() != null) {
                    ((ViewGroup) next.Pp().getParent()).removeView(next.Pp());
                }
            }
        }
        removeAllViews();
    }

    public void cqZ() {
        cH(true);
    }

    @Override // com.baidu.live.v.f
    public void cH(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cqX();
            return;
        }
        if (z) {
            Zr();
        }
        this.bSM = "";
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ifh.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        if (this.ifi != null) {
            this.ifi.clear();
        }
        this.aGS = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void cra() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (isFloatingMode()) {
            cqX();
            return;
        }
        if (!ListUtils.isEmpty(this.ifh)) {
            for (int i = 0; i < this.ifh.size(); i++) {
                com.baidu.live.liveroom.e.d dVar = this.ifh.get(i);
                if (i != 0 && dVar != null && dVar.Pp() != null && dVar.Pp().getParent() != null) {
                    ((ViewGroup) dVar.Pp().getParent()).removeView(dVar.Pp());
                }
            }
        }
        this.bSM = "";
        if (!ListUtils.isEmpty(this.ifh)) {
            for (int i2 = 0; i2 < this.ifh.size(); i2++) {
                com.baidu.live.liveroom.e.d dVar2 = this.ifh.get(i2);
                if (i2 != 0 && dVar2 != null) {
                    dVar2.setPlayerCallback(null);
                    dVar2.stop();
                }
            }
        }
        if (this.ifi != null) {
            this.ifi.clear();
        }
        this.aGS = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    @Override // com.baidu.live.v.f
    public View getLivePlayer() {
        return this;
    }

    public void pause() {
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ifh.iterator();
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
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ifh.iterator();
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

    public void aUC() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (isFloatingMode()) {
            cqX();
            return;
        }
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ifh.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.stop();
                    this.mPaused = false;
                }
            }
        }
        this.aGS = false;
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PLAY_FLOW, "notice", "liveroom", "playtime"));
    }

    public void destroy() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer destroy()");
        }
        this.mPaused = false;
        if (!ListUtils.isEmpty(this.ifh)) {
            Iterator<com.baidu.live.liveroom.e.d> it = this.ifh.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.d next = it.next();
                if (next != null) {
                    next.setPlayerCallback(null);
                    next.release();
                }
            }
            this.ifh.clear();
        }
        com.baidu.live.v.d Pt = i.Pq().Pt();
        if (Pt != null) {
            Pt.b(this.ifm);
        }
    }

    @Override // com.baidu.live.v.f
    public String getVideoPath() {
        return this.bSM;
    }

    public void setIPlayerCallBack(com.baidu.live.v.b bVar) {
        this.bSL = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.v.a aVar) {
        if (this.ifk != null) {
            this.ifk.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public void setPlayerCallback(com.baidu.live.liveroom.e.f fVar) {
        this.ifj = fVar;
    }

    public boolean isPlaying() {
        return this.aGS;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.ifi = arrayList;
        crb();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.ifi = arrayList;
        crb();
    }

    private void crb() {
        if (this.ifi != null && this.ifh != null && this.ifi.size() > 0 && this.ifh.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.ifi.size(); i2++) {
                if (this.ifi.get(i2) != null && this.ifh.get(i2) != null) {
                    if (this.ifi.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.ifh.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams crc() {
        int bn = com.baidu.live.utils.h.bn(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, com.baidu.live.utils.h.gD(equipmentWidth));
        layoutParams.topMargin = bn;
        return layoutParams;
    }

    private LinearLayout.LayoutParams crd() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ifk != null) {
            this.ifk.requestAudioFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isFloatingMode() && this.ifk != null) {
            this.ifk.abandonAudioFocus();
        }
    }

    private void requestAudioFocus() {
        if (this.ifk != null && TbadkCoreApplication.getInst().isBaidu() && !this.ifk.hasFocus()) {
            this.ifk.abandonAudioFocus();
            this.ifk.requestAudioFocus();
        }
    }
}

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
import com.baidu.live.data.ax;
import com.baidu.live.liveroom.e.e;
import com.baidu.live.o.d;
import com.baidu.live.o.f;
import com.baidu.live.o.g;
import com.baidu.live.o.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private long aJY;
    private com.baidu.live.o.b bgW;
    private String bgX;
    private ArrayList<com.baidu.live.liveroom.e.a> gtI;
    private ArrayList<AlaLiveInfoData> gtJ;
    private g gtK;
    private int gtL;
    private com.baidu.live.o.c gtM;
    private boolean isPlaying;
    private Context mContext;

    public static SdkLivePlayer eC(Context context) {
        if (e.Fc().Fd()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a ar;
        com.baidu.live.liveroom.e.a ar2;
        this.bgX = "";
        this.isPlaying = false;
        this.aJY = 0L;
        this.gtL = 1;
        this.gtM = new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.gtI = new ArrayList<>();
        boolean z = com.baidu.live.v.a.Ge().aWF.awX;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            ar = e.Fc().ar(context);
            ar2 = e.Fc().ar(context);
        } else if (z) {
            ar = e.Fc().as(context);
            ar2 = e.Fc().as(context);
        } else {
            ar = e.Fc().ar(context);
            ar2 = e.Fc().ar(context);
        }
        this.gtI.add(ar);
        this.gtI.add(ar2);
        d Fe = e.Fc().Fe();
        if (Fe != null && !Fe.FP()) {
            Fe.a(this.gtM);
        }
        this.gtK = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.gtJ;
    }

    @Override // com.baidu.live.o.f
    public void b(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bJr();
        ab(arrayList);
    }

    public void ab(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        ax axVar;
        this.gtJ = arrayList;
        LinearLayout.LayoutParams bJv = bJv();
        if (ListUtils.getCount(arrayList) == 2) {
            bJv = bJu();
        }
        if (arrayList == null || arrayList.size() != 1 || (axVar = com.baidu.live.v.a.Ge().aYP) == null || axVar.aAP == null || ((i = axVar.aAP.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                AlaLiveInfoData alaLiveInfoData = arrayList.get(i3);
                if (alaLiveInfoData.screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, bJv, i, i2, alaLiveInfoData.screen_direction);
            }
        }
        this.isPlaying = true;
        this.aJY = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey(), bJw());
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3, int i4) {
        String c = h.c(alaLiveInfoData);
        if (!TextUtils.isEmpty(c)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + c);
            }
            if (i == 0) {
                this.bgX = c;
                this.gtL = i4;
            }
            if (this.gtI != null && this.gtI.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.gtI.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", alaLiveInfoData.getSessionID());
                    jSONObject.put("liveId", alaLiveInfoData.getLiveID());
                    jSONObject.put("clientIp", com.baidu.live.v.a.Ge().aWF.clientIP);
                    jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("sessionLine", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e);
                    }
                }
                aVar.a(null);
                aVar.d(this.mContext, Uri.parse(c));
                if ("ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                aVar.setDecodeMode(i2);
                aVar.cD(8);
                aVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.getPlayerView(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.e.d() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.c
                    public void a(com.baidu.live.liveroom.e.a aVar2, int i5, int i6) {
                        if (i5 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.bgW != null) {
                                SdkLivePlayer.this.bgW.bG(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.cD(0);
                        }
                    }
                });
                aVar.c(Uri.parse(c));
                aVar.start();
                aVar.setVideoScalingMode(i3);
                a(aVar, alaLiveInfoData);
            }
        }
    }

    private void a(com.baidu.live.liveroom.e.a aVar, AlaLiveInfoData alaLiveInfoData) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientIp", com.baidu.live.v.a.Ge().aWF.clientIP);
        hashMap.put("liveId", alaLiveInfoData != null ? alaLiveInfoData.getLiveID() + "" : "0");
        hashMap.put("roomId", alaLiveInfoData != null ? alaLiveInfoData.room_id + "" : "0");
        hashMap.put("uid", ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()));
        aVar.b(1, hashMap);
    }

    private void Jh() {
        if (!ListUtils.isEmpty(this.gtI)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtI.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bJr() {
        bW(true);
    }

    @Override // com.baidu.live.o.f
    public void bW(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            Jh();
        }
        this.bgX = "";
        if (!ListUtils.isEmpty(this.gtI)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtI.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.gtJ != null) {
            this.gtJ.clear();
        }
        this.isPlaying = false;
        UbcStatisticManager.getInstance().flowEndSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey());
    }

    @Override // com.baidu.live.o.f
    public View getLivePlayer() {
        return this;
    }

    public void bJs() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.gtJ)) {
            ab(this.gtJ);
        }
    }

    public void avT() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.gtI)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtI.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
        this.isPlaying = false;
        this.aJY = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey(), bJw());
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.gtI)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtI.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.gtI.clear();
        }
        d Fe = e.Fc().Fe();
        if (Fe != null) {
            Fe.b(this.gtM);
        }
    }

    public String getVideoPath() {
        return this.bgX;
    }

    public int getCurScreenDirection() {
        return this.gtL;
    }

    public void setVideoScreenDirection(int i) {
        this.gtL = i;
        int i2 = i == 2 ? 2 : 0;
        if (this.gtI != null && this.gtI.size() > 0 && this.gtI.get(0) != null) {
            this.gtI.get(0).setVideoScalingMode(i2);
        }
    }

    public void setIPlayerCallBack(com.baidu.live.o.b bVar) {
        this.bgW = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.o.a aVar) {
        if (this.gtK != null) {
            this.gtK.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.gtJ = arrayList;
        bJt();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.gtJ = arrayList;
        bJt();
    }

    private void bJt() {
        if (this.gtJ != null && this.gtI != null && this.gtJ.size() > 0 && this.gtI.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.gtJ.size(); i2++) {
                if (this.gtJ.get(i2) != null && this.gtI.get(i2) != null) {
                    if (this.gtJ.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.gtI.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams bJu() {
        int au = com.baidu.live.utils.g.au(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = au;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bJv() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gtK != null) {
            this.gtK.FQ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gtK != null) {
            this.gtK.FR();
        }
    }

    private JSONObject bJw() {
        JSONObject jSONObject = new JSONObject();
        if (this.gtJ != null && !this.gtJ.isEmpty()) {
            try {
                jSONObject.put("live_id", this.gtJ.get(0).live_id);
                jSONObject.put("room_id", this.gtJ.get(0).room_id);
                jSONObject.put("vid", this.gtJ.get(0).feed_id);
                jSONObject.put("play_start_time", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private String getUbcFlowSlotKey() {
        return "playtime_" + this.aJY;
    }
}

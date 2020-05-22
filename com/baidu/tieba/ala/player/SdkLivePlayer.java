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
    private int gtA;
    private com.baidu.live.o.c gtB;
    private ArrayList<com.baidu.live.liveroom.e.a> gtx;
    private ArrayList<AlaLiveInfoData> gty;
    private g gtz;
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
        this.gtA = 1;
        this.gtB = new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.gtx = new ArrayList<>();
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
        this.gtx.add(ar);
        this.gtx.add(ar2);
        d Fe = e.Fc().Fe();
        if (Fe != null && !Fe.FP()) {
            Fe.a(this.gtB);
        }
        this.gtz = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.gty;
    }

    @Override // com.baidu.live.o.f
    public void b(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bJp();
        ab(arrayList);
    }

    public void ab(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        ax axVar;
        this.gty = arrayList;
        LinearLayout.LayoutParams bJt = bJt();
        if (ListUtils.getCount(arrayList) == 2) {
            bJt = bJs();
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
                a(arrayList.get(i3), i3, bJt, i, i2, alaLiveInfoData.screen_direction);
            }
        }
        this.isPlaying = true;
        this.aJY = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey(), bJu());
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3, int i4) {
        String c = h.c(alaLiveInfoData);
        if (!TextUtils.isEmpty(c)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + c);
            }
            if (i == 0) {
                this.bgX = c;
                this.gtA = i4;
            }
            if (this.gtx != null && this.gtx.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.gtx.get(i);
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
                aVar.cB(8);
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
                                SdkLivePlayer.this.bgW.bE(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.cB(0);
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
        if (!ListUtils.isEmpty(this.gtx)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtx.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bJp() {
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
        if (!ListUtils.isEmpty(this.gtx)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtx.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.gty != null) {
            this.gty.clear();
        }
        this.isPlaying = false;
        UbcStatisticManager.getInstance().flowEndSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey());
    }

    @Override // com.baidu.live.o.f
    public View getLivePlayer() {
        return this;
    }

    public void bJq() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.gty)) {
            ab(this.gty);
        }
    }

    public void avT() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.gtx)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtx.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
        this.isPlaying = false;
        this.aJY = System.currentTimeMillis();
        UbcStatisticManager.getInstance().flowStartSlot(UbcStatisticLiveKey.KEY_ID_FLOW, getUbcFlowSlotKey(), bJu());
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.gtx)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.gtx.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.gtx.clear();
        }
        d Fe = e.Fc().Fe();
        if (Fe != null) {
            Fe.b(this.gtB);
        }
    }

    public String getVideoPath() {
        return this.bgX;
    }

    public int getCurScreenDirection() {
        return this.gtA;
    }

    public void setVideoScreenDirection(int i) {
        this.gtA = i;
        int i2 = i == 2 ? 2 : 0;
        if (this.gtx != null && this.gtx.size() > 0 && this.gtx.get(0) != null) {
            this.gtx.get(0).setVideoScalingMode(i2);
        }
    }

    public void setIPlayerCallBack(com.baidu.live.o.b bVar) {
        this.bgW = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.o.a aVar) {
        if (this.gtz != null) {
            this.gtz.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.gty = arrayList;
        bJr();
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.gty = arrayList;
        bJr();
    }

    private void bJr() {
        if (this.gty != null && this.gtx != null && this.gty.size() > 0 && this.gtx.size() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.gty.size(); i2++) {
                if (this.gty.get(i2) != null && this.gtx.get(i2) != null) {
                    if (this.gty.get(i2).screen_direction == 2) {
                        i = 2;
                    }
                    this.gtx.get(i2).setVideoScalingMode(i);
                }
            }
        }
    }

    private LinearLayout.LayoutParams bJs() {
        int au = com.baidu.live.utils.g.au(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = au;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bJt() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gtz != null) {
            this.gtz.FQ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gtz != null) {
            this.gtz.FR();
        }
    }

    private JSONObject bJu() {
        JSONObject jSONObject = new JSONObject();
        if (this.gty != null && !this.gty.isEmpty()) {
            try {
                jSONObject.put("live_id", this.gty.get(0).live_id);
                jSONObject.put("room_id", this.gty.get(0).room_id);
                jSONObject.put("vid", this.gty.get(0).feed_id);
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

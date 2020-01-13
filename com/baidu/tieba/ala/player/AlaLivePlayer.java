package com.baidu.tieba.ala.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.ao;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLivePlayer extends LinearLayout {
    private BdPageContext apm;
    private ArrayList<com.baidu.live.liveroom.d.a> fvA;
    private ArrayList<AlaLiveInfoData> fvB;
    private a fvC;
    private String fvD;

    /* loaded from: classes2.dex */
    public interface a {
        void bd(int i);
    }

    public static AlaLivePlayer eH(Context context) {
        if (e.wt().wu()) {
            return new AlaLivePlayer(context);
        }
        return null;
    }

    public AlaLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.d.a aD;
        com.baidu.live.liveroom.d.a aD2;
        this.fvD = "";
        setOrientation(0);
        this.fvA = new ArrayList<>();
        boolean z = com.baidu.live.s.a.wR().asq.XA;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            aD = e.wt().aD(context);
            aD2 = e.wt().aD(context);
        } else if (z) {
            aD = e.wt().aE(context);
            aD2 = e.wt().aE(context);
        } else {
            aD = e.wt().aD(context);
            aD2 = e.wt().aD(context);
        }
        this.fvA.add(aD);
        this.fvA.add(aD2);
    }

    public void setPageContext(BdPageContext<?> bdPageContext) {
        this.apm = bdPageContext;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.fvB;
    }

    public void f(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        brc();
        Z(arrayList);
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.fvB = arrayList;
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.fvB = arrayList;
    }

    public void Z(ArrayList<AlaLiveInfoData> arrayList) {
        ao aoVar;
        int i;
        int i2 = 1;
        this.fvB = arrayList;
        LinearLayout.LayoutParams brb = brb();
        if (ListUtils.getCount(arrayList) == 2) {
            brb = bra();
        }
        if (arrayList != null && arrayList.size() == 1 && (aoVar = com.baidu.live.s.a.wR().atk) != null && aoVar.abb != null && ((i = aoVar.abb.decodeMode) == 1 || i == 2)) {
            i2 = i;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (arrayList.get(i4).screen_direction == 2) {
                    i3 = 2;
                }
                a(arrayList.get(i4), i4, brb, i2, i3);
            }
        }
    }

    private LinearLayout.LayoutParams bra() {
        int aG = g.aG(this.apm.getPageActivity());
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.apm.getPageActivity()) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aG;
        return layoutParams;
    }

    private LinearLayout.LayoutParams brb() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String e = com.baidu.tieba.ala.player.a.e(alaLiveInfoData);
        if (!TextUtils.isEmpty(e)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + e);
            }
            if (i == 0) {
                this.fvD = e;
            }
            if (this.fvA != null && this.fvA.size() > 0) {
                final com.baidu.live.liveroom.d.a aVar = this.fvA.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("SESSION_ID", alaLiveInfoData.getSessionID());
                    jSONObject.put("LIVE_ID", alaLiveInfoData.getLiveID());
                    jSONObject.put("CLIENT_IP", com.baidu.live.s.a.wR().asq.clientIP);
                    jSONObject.put("LEVEL", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("SESSION_LINE", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e2) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e2);
                    }
                }
                aVar.a(null);
                aVar.d(this.apm.getPageActivity(), Uri.parse(e));
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && "ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                aVar.setDecodeMode(i2);
                aVar.bQ(8);
                aVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.getPlayerView(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.d.d() { // from class: com.baidu.tieba.ala.player.AlaLivePlayer.1
                    @Override // com.baidu.live.liveroom.d.c
                    public void a(com.baidu.live.liveroom.d.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (AlaLivePlayer.this.fvC != null) {
                                AlaLivePlayer.this.fvC.bd(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.bQ(0);
                        }
                    }
                });
                aVar.b(Uri.parse(e));
                aVar.start();
                aVar.setVideoScalingMode(i3);
            }
        }
    }

    private void bjX() {
        if (!ListUtils.isEmpty(this.fvA)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fvA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void brc() {
        jX(true);
    }

    public void jX(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            bjX();
        }
        this.fvD = "";
        if (!ListUtils.isEmpty(this.fvA)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fvA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.fvB != null) {
            this.fvB.clear();
        }
    }

    public void brd() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.fvB)) {
            Z(this.fvB);
        }
    }

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.fvA)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fvA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.fvA)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fvA.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.fvA.clear();
        }
    }

    public String getVideoPath() {
        return this.fvD;
    }

    public void setIPlayerCallBack(a aVar) {
        this.fvC = aVar;
    }

    public boolean isPlaying() {
        return !TextUtils.isEmpty(this.fvD);
    }
}

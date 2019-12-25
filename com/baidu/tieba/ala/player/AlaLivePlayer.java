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
import com.baidu.live.data.ak;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLivePlayer extends LinearLayout {
    private BdPageContext aoA;
    private ArrayList<com.baidu.live.liveroom.d.a> fsr;
    private ArrayList<AlaLiveInfoData> fss;
    private a fst;
    private String fsu;

    /* loaded from: classes2.dex */
    public interface a {
        void bd(int i);
    }

    public static AlaLivePlayer eH(Context context) {
        if (e.wc().wd()) {
            return new AlaLivePlayer(context);
        }
        return null;
    }

    public AlaLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.d.a aD;
        com.baidu.live.liveroom.d.a aD2;
        this.fsu = "";
        setOrientation(0);
        this.fsr = new ArrayList<>();
        boolean z = com.baidu.live.r.a.wA().arE.Xh;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            aD = e.wc().aD(context);
            aD2 = e.wc().aD(context);
        } else if (z) {
            aD = e.wc().aE(context);
            aD2 = e.wc().aE(context);
        } else {
            aD = e.wc().aD(context);
            aD2 = e.wc().aD(context);
        }
        this.fsr.add(aD);
        this.fsr.add(aD2);
    }

    public void setPageContext(BdPageContext<?> bdPageContext) {
        this.aoA = bdPageContext;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.fss;
    }

    public void f(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bqb();
        Z(arrayList);
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.fss = arrayList;
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.fss = arrayList;
    }

    public void Z(ArrayList<AlaLiveInfoData> arrayList) {
        ak akVar;
        int i;
        int i2 = 1;
        this.fss = arrayList;
        LinearLayout.LayoutParams bqa = bqa();
        if (ListUtils.getCount(arrayList) == 2) {
            bqa = bpZ();
        }
        if (arrayList != null && arrayList.size() == 1 && (akVar = com.baidu.live.r.a.wA().asy) != null && akVar.aaO != null && ((i = akVar.aaO.abj) == 1 || i == 2)) {
            i2 = i;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (arrayList.get(i4).screen_direction == 2) {
                    i3 = 2;
                }
                a(arrayList.get(i4), i4, bqa, i2, i3);
            }
        }
    }

    private LinearLayout.LayoutParams bpZ() {
        int aG = g.aG(this.aoA.getPageActivity());
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.aoA.getPageActivity()) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aG;
        return layoutParams;
    }

    private LinearLayout.LayoutParams bqa() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String e = com.baidu.tieba.ala.player.a.e(alaLiveInfoData);
        if (!TextUtils.isEmpty(e)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + e);
            }
            if (i == 0) {
                this.fsu = e;
            }
            if (this.fsr != null && this.fsr.size() > 0) {
                final com.baidu.live.liveroom.d.a aVar = this.fsr.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("SESSION_ID", alaLiveInfoData.getSessionID());
                    jSONObject.put("LIVE_ID", alaLiveInfoData.getLiveID());
                    jSONObject.put("CLIENT_IP", com.baidu.live.r.a.wA().arE.clientIP);
                    jSONObject.put("LEVEL", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("SESSION_LINE", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e2) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e2);
                    }
                }
                aVar.a(null);
                aVar.d(this.aoA.getPageActivity(), Uri.parse(e));
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
                            if (AlaLivePlayer.this.fst != null) {
                                AlaLivePlayer.this.fst.bd(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
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

    private void bjl() {
        if (!ListUtils.isEmpty(this.fsr)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fsr.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bqb() {
        jM(true);
    }

    public void jM(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            bjl();
        }
        this.fsu = "";
        if (!ListUtils.isEmpty(this.fsr)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fsr.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.fss != null) {
            this.fss.clear();
        }
    }

    public void bqc() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.fss)) {
            Z(this.fss);
        }
    }

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.fsr)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fsr.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.fsr)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.fsr.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.fsr.clear();
        }
    }

    public String getVideoPath() {
        return this.fsu;
    }

    public void setIPlayerCallBack(a aVar) {
        this.fst = aVar;
    }

    public boolean isPlaying() {
        return !TextUtils.isEmpty(this.fsu);
    }
}

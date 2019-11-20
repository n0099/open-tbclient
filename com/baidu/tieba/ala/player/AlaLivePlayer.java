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
import com.baidu.live.data.af;
import com.baidu.live.k.a;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.utils.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaLivePlayer extends LinearLayout {
    private BdPageContext agz;
    private ArrayList<com.baidu.live.liveroom.d.a> eAQ;
    private ArrayList<AlaLiveInfoData> eAR;
    private a eAS;
    private String eAT;

    /* loaded from: classes6.dex */
    public interface a {
        void aS(int i);
    }

    /* renamed from: do  reason: not valid java name */
    public static AlaLivePlayer m24do(Context context) {
        if (e.ui().uj()) {
            return new AlaLivePlayer(context);
        }
        return null;
    }

    public AlaLivePlayer(Context context) {
        super(context);
        this.eAT = "";
        setOrientation(0);
        this.eAQ = new ArrayList<>();
        com.baidu.live.liveroom.d.a as = e.ui().as(context);
        com.baidu.live.liveroom.d.a as2 = e.ui().as(context);
        this.eAQ.add(as);
        this.eAQ.add(as2);
    }

    public void setPageContext(BdPageContext<?> bdPageContext) {
        this.agz = bdPageContext;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.eAR;
    }

    public void f(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        aYf();
        P(arrayList);
    }

    public void P(ArrayList<AlaLiveInfoData> arrayList) {
        af afVar;
        int i;
        int i2 = 1;
        this.eAR = arrayList;
        LinearLayout.LayoutParams aYe = aYe();
        if (ListUtils.getCount(arrayList) == 2) {
            aYe = aYd();
        }
        if (arrayList != null && arrayList.size() == 1 && (afVar = com.baidu.live.l.a.uB().aku) != null && afVar.TS != null && ((i = afVar.TS.Ui) == 1 || i == 2)) {
            i2 = i;
        }
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                a(arrayList.get(i3), i3, aYe, i2, 0);
            }
        }
    }

    private LinearLayout.LayoutParams aYd() {
        int au = f.au(this.agz.getPageActivity());
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.agz.getPageActivity()) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = au;
        return layoutParams;
    }

    private LinearLayout.LayoutParams aYe() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String e = com.baidu.tieba.ala.player.a.e(alaLiveInfoData);
        if (!TextUtils.isEmpty(e)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + e);
            }
            if (i == 0) {
                this.eAT = e;
            }
            if (this.eAQ != null && this.eAQ.size() > 0) {
                final com.baidu.live.liveroom.d.a aVar = this.eAQ.get(i);
                if (aVar.uh() != null && aVar.uh().getParent() != null) {
                    ((ViewGroup) aVar.uh().getParent()).removeView(aVar.uh());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("SESSION_ID", alaLiveInfoData.getSessionID());
                    jSONObject.put("LIVE_ID", alaLiveInfoData.getLiveID());
                    jSONObject.put("CLIENT_IP", com.baidu.live.l.a.uB().ajF.clientIP);
                    jSONObject.put("LEVEL", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("SESSION_LINE", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e2) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e2);
                    }
                }
                aVar.a(null);
                aVar.d(this.agz.getPageActivity(), Uri.parse(e));
                aVar.setVideoScalingMode(i3);
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && "ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                aVar.setDecodeMode(i2);
                aVar.bz(8);
                aVar.uh().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.uh(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.d.d() { // from class: com.baidu.tieba.ala.player.AlaLivePlayer.1
                    @Override // com.baidu.live.liveroom.d.c
                    public void a(com.baidu.live.liveroom.d.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (AlaLivePlayer.this.eAS != null) {
                                AlaLivePlayer.this.eAS.aS(((Integer) aVar.uh().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.bz(0);
                        }
                    }
                });
                aVar.b(Uri.parse(e));
                aVar.start();
            }
        }
    }

    private void aRK() {
        if (!ListUtils.isEmpty(this.eAQ)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eAQ.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null && next.uh() != null && next.uh().getParent() != null) {
                    ((ViewGroup) next.uh().getParent()).removeView(next.uh());
                }
            }
        }
        removeAllViews();
    }

    public void aYf() {
        iv(true);
    }

    public void iv(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            aRK();
        }
        this.eAT = "";
        if (!ListUtils.isEmpty(this.eAQ)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eAQ.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.eAR != null) {
            this.eAR.clear();
        }
    }

    public void aYg() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.eAR)) {
            P(this.eAR);
        }
    }

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.eAQ)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eAQ.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.pause();
                }
            }
        }
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.eAQ)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eAQ.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.eAQ.clear();
        }
    }

    public String getVideoPath() {
        return this.eAT;
    }

    public void setIPlayerCallBack(a aVar) {
        this.eAS = aVar;
    }

    public boolean isPlaying() {
        return !TextUtils.isEmpty(this.eAT);
    }
}

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
    private BdPageContext agR;
    private ArrayList<com.baidu.live.liveroom.d.a> eBH;
    private ArrayList<AlaLiveInfoData> eBI;
    private a eBJ;
    private String eBK;

    /* loaded from: classes6.dex */
    public interface a {
        void aS(int i);
    }

    /* renamed from: do  reason: not valid java name */
    public static AlaLivePlayer m24do(Context context) {
        if (e.uh().ui()) {
            return new AlaLivePlayer(context);
        }
        return null;
    }

    public AlaLivePlayer(Context context) {
        super(context);
        this.eBK = "";
        setOrientation(0);
        this.eBH = new ArrayList<>();
        com.baidu.live.liveroom.d.a as = e.uh().as(context);
        com.baidu.live.liveroom.d.a as2 = e.uh().as(context);
        this.eBH.add(as);
        this.eBH.add(as2);
    }

    public void setPageContext(BdPageContext<?> bdPageContext) {
        this.agR = bdPageContext;
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.eBI;
    }

    public void f(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        aYh();
        P(arrayList);
    }

    public void P(ArrayList<AlaLiveInfoData> arrayList) {
        af afVar;
        int i;
        int i2 = 1;
        this.eBI = arrayList;
        LinearLayout.LayoutParams aYg = aYg();
        if (ListUtils.getCount(arrayList) == 2) {
            aYg = aYf();
        }
        if (arrayList != null && arrayList.size() == 1 && (afVar = com.baidu.live.l.a.uA().akM) != null && afVar.Ul != null && ((i = afVar.Ul.UC) == 1 || i == 2)) {
            i2 = i;
        }
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                a(arrayList.get(i3), i3, aYg, i2, 0);
            }
        }
    }

    private LinearLayout.LayoutParams aYf() {
        int au = f.au(this.agR.getPageActivity());
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.agR.getPageActivity()) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = au;
        return layoutParams;
    }

    private LinearLayout.LayoutParams aYg() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String e = com.baidu.tieba.ala.player.a.e(alaLiveInfoData);
        if (!TextUtils.isEmpty(e)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + e);
            }
            if (i == 0) {
                this.eBK = e;
            }
            if (this.eBH != null && this.eBH.size() > 0) {
                final com.baidu.live.liveroom.d.a aVar = this.eBH.get(i);
                if (aVar.ug() != null && aVar.ug().getParent() != null) {
                    ((ViewGroup) aVar.ug().getParent()).removeView(aVar.ug());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("SESSION_ID", alaLiveInfoData.getSessionID());
                    jSONObject.put("LIVE_ID", alaLiveInfoData.getLiveID());
                    jSONObject.put("CLIENT_IP", com.baidu.live.l.a.uA().ajX.clientIP);
                    jSONObject.put("LEVEL", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("SESSION_LINE", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e2) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e2);
                    }
                }
                aVar.a(null);
                aVar.d(this.agR.getPageActivity(), Uri.parse(e));
                aVar.setVideoScalingMode(i3);
                if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && "ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                aVar.setDecodeMode(i2);
                aVar.bz(8);
                aVar.ug().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.ug(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.d.d() { // from class: com.baidu.tieba.ala.player.AlaLivePlayer.1
                    @Override // com.baidu.live.liveroom.d.c
                    public void a(com.baidu.live.liveroom.d.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (AlaLivePlayer.this.eBJ != null) {
                                AlaLivePlayer.this.eBJ.aS(((Integer) aVar.ug().getTag(a.g.live_player_id)).intValue());
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

    private void aRM() {
        if (!ListUtils.isEmpty(this.eBH)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eBH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null && next.ug() != null && next.ug().getParent() != null) {
                    ((ViewGroup) next.ug().getParent()).removeView(next.ug());
                }
            }
        }
        removeAllViews();
    }

    public void aYh() {
        iv(true);
    }

    public void iv(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            aRM();
        }
        this.eBK = "";
        if (!ListUtils.isEmpty(this.eBH)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eBH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.eBI != null) {
            this.eBI.clear();
        }
    }

    public void aYi() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.eBI)) {
            P(this.eBI);
        }
    }

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.eBH)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eBH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.pause();
                }
            }
        }
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.eBH)) {
            Iterator<com.baidu.live.liveroom.d.a> it = this.eBH.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.d.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.eBH.clear();
        }
    }

    public String getVideoPath() {
        return this.eBK;
    }

    public void setIPlayerCallBack(a aVar) {
        this.eBJ = aVar;
    }

    public boolean isPlaying() {
        return !TextUtils.isEmpty(this.eBK);
    }
}

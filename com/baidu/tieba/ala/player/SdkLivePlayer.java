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
import com.baidu.live.data.ap;
import com.baidu.live.liveroom.e.e;
import com.baidu.live.o.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.live.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkLivePlayer extends LinearLayout implements com.baidu.live.o.c {
    private ArrayList<com.baidu.live.liveroom.e.a> fzb;
    private ArrayList<AlaLiveInfoData> fzc;
    private com.baidu.live.o.a fzd;
    private String fze;
    private Context mContext;

    public static SdkLivePlayer eK(Context context) {
        if (e.yG().yH()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a aH;
        com.baidu.live.liveroom.e.a aH2;
        this.fze = "";
        this.mContext = context;
        setOrientation(0);
        this.fzb = new ArrayList<>();
        boolean z = com.baidu.live.v.a.zj().awA.Zr;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            aH = e.yG().aH(context);
            aH2 = e.yG().aH(context);
        } else if (z) {
            aH = e.yG().aI(context);
            aH2 = e.yG().aI(context);
        } else {
            aH = e.yG().aH(context);
            aH2 = e.yG().aH(context);
        }
        this.fzb.add(aH);
        this.fzb.add(aH2);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.fzc;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        btk();
        aa(arrayList);
    }

    public void aa(ArrayList<AlaLiveInfoData> arrayList) {
        ap apVar;
        int i;
        int i2 = 1;
        this.fzc = arrayList;
        LinearLayout.LayoutParams btn = btn();
        if (ListUtils.getCount(arrayList) == 2) {
            btn = btm();
        }
        if (arrayList != null && arrayList.size() == 1 && (apVar = com.baidu.live.v.a.zj().axB) != null && apVar.acZ != null && ((i = apVar.acZ.decodeMode) == 1 || i == 2)) {
            i2 = i;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (arrayList.get(i4).screen_direction == 2) {
                    i3 = 2;
                }
                a(arrayList.get(i4), i4, btn, i2, i3);
            }
        }
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String b = d.b(alaLiveInfoData);
        if (!TextUtils.isEmpty(b)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + b);
            }
            if (i == 0) {
                this.fze = b;
            }
            if (this.fzb != null && this.fzb.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.fzb.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("SESSION_ID", alaLiveInfoData.getSessionID());
                    jSONObject.put("LIVE_ID", alaLiveInfoData.getLiveID());
                    jSONObject.put("CLIENT_IP", com.baidu.live.v.a.zj().awA.clientIP);
                    jSONObject.put("LEVEL", AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                    jSONObject.put("SESSION_LINE", 1);
                    aVar.b(i + 1, jSONObject);
                } catch (Exception e) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(e);
                    }
                }
                aVar.a(null);
                aVar.d(this.mContext, Uri.parse(b));
                if ("ZTE A0622".equals(Build.MODEL)) {
                    i2 = 2;
                }
                aVar.setDecodeMode(i2);
                aVar.cf(8);
                aVar.getPlayerView().setTag(a.g.live_player_id, Integer.valueOf(i + 1));
                addView(aVar.getPlayerView(), layoutParams);
                aVar.a(new com.baidu.live.liveroom.e.d() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
                    @Override // com.baidu.live.liveroom.e.c
                    public void a(com.baidu.live.liveroom.e.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.fzd != null) {
                                SdkLivePlayer.this.fzd.bk(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
                            }
                            aVar.cf(0);
                        }
                    }
                });
                aVar.c(Uri.parse(b));
                aVar.start();
                aVar.setVideoScalingMode(i3);
            }
        }
    }

    private void blL() {
        if (!ListUtils.isEmpty(this.fzb)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzb.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void btk() {
        ka(true);
    }

    public void ka(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            blL();
        }
        this.fze = "";
        if (!ListUtils.isEmpty(this.fzb)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzb.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.fzc != null) {
            this.fzc.clear();
        }
    }

    @Override // com.baidu.live.o.c
    public View getLivePlayer() {
        return this;
    }

    public void btl() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.fzc)) {
            aa(this.fzc);
        }
    }

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.fzb)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzb.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.fzb)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzb.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.fzb.clear();
        }
    }

    public String getVideoPath() {
        return this.fze;
    }

    public void setIPlayerCallBack(com.baidu.live.o.a aVar) {
        this.fzd = aVar;
    }

    public boolean isPlaying() {
        return !TextUtils.isEmpty(this.fze);
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.fzc = arrayList;
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.fzc = arrayList;
    }

    private LinearLayout.LayoutParams btm() {
        int aK = g.aK(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aK;
        return layoutParams;
    }

    private LinearLayout.LayoutParams btn() {
        return new LinearLayout.LayoutParams(-1, -1);
    }
}

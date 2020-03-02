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
import com.baidu.live.liveroom.e.d;
import com.baidu.live.o.e;
import com.baidu.live.o.f;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.live.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkLivePlayer extends LinearLayout implements e {
    private ArrayList<com.baidu.live.liveroom.e.a> fzc;
    private ArrayList<AlaLiveInfoData> fzd;
    private com.baidu.live.o.a fze;
    private String fzf;
    private com.baidu.live.o.b fzg;
    private boolean isPlaying;
    private Context mContext;

    public static SdkLivePlayer eK(Context context) {
        if (com.baidu.live.liveroom.e.e.yG().yH()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a aH;
        com.baidu.live.liveroom.e.a aH2;
        this.fzf = "";
        this.isPlaying = false;
        this.fzg = new com.baidu.live.o.b() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.fzc = new ArrayList<>();
        boolean z = com.baidu.live.v.a.zl().awB.Zr;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            aH = com.baidu.live.liveroom.e.e.yG().aH(context);
            aH2 = com.baidu.live.liveroom.e.e.yG().aH(context);
        } else if (z) {
            aH = com.baidu.live.liveroom.e.e.yG().aI(context);
            aH2 = com.baidu.live.liveroom.e.e.yG().aI(context);
        } else {
            aH = com.baidu.live.liveroom.e.e.yG().aH(context);
            aH2 = com.baidu.live.liveroom.e.e.yG().aH(context);
        }
        this.fzc.add(aH);
        this.fzc.add(aH2);
        com.baidu.live.o.c yI = com.baidu.live.liveroom.e.e.yG().yI();
        if (yI != null && !yI.za()) {
            yI.a(this.fzg);
        }
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.fzd;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        btm();
        aa(arrayList);
    }

    public void aa(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        ap apVar;
        this.fzd = arrayList;
        LinearLayout.LayoutParams btp = btp();
        if (ListUtils.getCount(arrayList) == 2) {
            btp = bto();
        }
        if (arrayList == null || arrayList.size() != 1 || (apVar = com.baidu.live.v.a.zl().axC) == null || apVar.acZ == null || ((i = apVar.acZ.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, btp, i, i2);
            }
        }
        this.isPlaying = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String b = f.b(alaLiveInfoData);
        if (!TextUtils.isEmpty(b)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + b);
            }
            if (i == 0) {
                this.fzf = b;
            }
            if (this.fzc != null && this.fzc.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.fzc.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("SESSION_ID", alaLiveInfoData.getSessionID());
                    jSONObject.put("LIVE_ID", alaLiveInfoData.getLiveID());
                    jSONObject.put("CLIENT_IP", com.baidu.live.v.a.zl().awB.clientIP);
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
                aVar.a(new d() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.c
                    public void a(com.baidu.live.liveroom.e.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.fze != null) {
                                SdkLivePlayer.this.fze.bk(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
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

    private void blN() {
        if (!ListUtils.isEmpty(this.fzc)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzc.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void btm() {
        ka(true);
    }

    public void ka(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            blN();
        }
        this.fzf = "";
        if (!ListUtils.isEmpty(this.fzc)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzc.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.fzd != null) {
            this.fzd.clear();
        }
        this.isPlaying = false;
    }

    @Override // com.baidu.live.o.e
    public View getLivePlayer() {
        return this;
    }

    public void btn() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.fzd)) {
            aa(this.fzd);
        }
    }

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.fzc)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzc.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.stop();
                }
            }
        }
        this.isPlaying = false;
    }

    public void destroy() {
        if (!ListUtils.isEmpty(this.fzc)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzc.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.fzc.clear();
        }
        com.baidu.live.o.c yI = com.baidu.live.liveroom.e.e.yG().yI();
        if (yI != null) {
            yI.b(this.fzg);
        }
    }

    public String getVideoPath() {
        return this.fzf;
    }

    public void setIPlayerCallBack(com.baidu.live.o.a aVar) {
        this.fze = aVar;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.fzd = arrayList;
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.fzd = arrayList;
    }

    private LinearLayout.LayoutParams bto() {
        int aK = g.aK(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aK;
        return layoutParams;
    }

    private LinearLayout.LayoutParams btp() {
        return new LinearLayout.LayoutParams(-1, -1);
    }
}

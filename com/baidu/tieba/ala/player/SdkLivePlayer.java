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
import com.baidu.live.o.f;
import com.baidu.live.o.g;
import com.baidu.live.o.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SdkLivePlayer extends LinearLayout implements f {
    private String fAa;
    private com.baidu.live.o.c fAb;
    private ArrayList<com.baidu.live.liveroom.e.a> fzW;
    private ArrayList<AlaLiveInfoData> fzX;
    private com.baidu.live.o.b fzY;
    private g fzZ;
    private boolean isPlaying;
    private Context mContext;

    public static SdkLivePlayer eJ(Context context) {
        if (e.yL().yM()) {
            return new SdkLivePlayer(context);
        }
        return null;
    }

    public SdkLivePlayer(Context context) {
        super(context);
        com.baidu.live.liveroom.e.a aG;
        com.baidu.live.liveroom.e.a aG2;
        this.fAa = "";
        this.isPlaying = false;
        this.fAb = new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.1
        };
        this.mContext = context;
        setOrientation(0);
        this.fzW = new ArrayList<>();
        boolean z = com.baidu.live.v.a.zs().awM.ZB;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            aG = e.yL().aG(context);
            aG2 = e.yL().aG(context);
        } else if (z) {
            aG = e.yL().aH(context);
            aG2 = e.yL().aH(context);
        } else {
            aG = e.yL().aG(context);
            aG2 = e.yL().aG(context);
        }
        this.fzW.add(aG);
        this.fzW.add(aG2);
        d yN = e.yL().yN();
        if (yN != null && !yN.zf()) {
            yN.a(this.fAb);
        }
        this.fzZ = new g(this.mContext);
    }

    public List<AlaLiveInfoData> getAlaLiveInfoDataList() {
        return this.fzX;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        bts();
        aa(arrayList);
    }

    public void aa(ArrayList<AlaLiveInfoData> arrayList) {
        int i;
        ap apVar;
        this.fzX = arrayList;
        LinearLayout.LayoutParams btv = btv();
        if (ListUtils.getCount(arrayList) == 2) {
            btv = btu();
        }
        if (arrayList == null || arrayList.size() != 1 || (apVar = com.baidu.live.v.a.zs().axR) == null || apVar.adk == null || ((i = apVar.adk.decodeMode) != 1 && i != 2)) {
            i = 1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).screen_direction == 2) {
                    i2 = 2;
                }
                a(arrayList.get(i3), i3, btv, i, i2);
            }
        }
        this.isPlaying = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, final int i, LinearLayout.LayoutParams layoutParams, int i2, int i3) {
        String b = h.b(alaLiveInfoData);
        if (!TextUtils.isEmpty(b)) {
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer startLive=url=" + b);
            }
            if (i == 0) {
                this.fAa = b;
            }
            if (this.fzW != null && this.fzW.size() > 0) {
                final com.baidu.live.liveroom.e.a aVar = this.fzW.get(i);
                if (aVar.getPlayerView() != null && aVar.getPlayerView().getParent() != null) {
                    ((ViewGroup) aVar.getPlayerView().getParent()).removeView(aVar.getPlayerView());
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("SESSION_ID", alaLiveInfoData.getSessionID());
                    jSONObject.put("LIVE_ID", alaLiveInfoData.getLiveID());
                    jSONObject.put("CLIENT_IP", com.baidu.live.v.a.zs().awM.clientIP);
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
                aVar.a(new com.baidu.live.liveroom.e.d() { // from class: com.baidu.tieba.ala.player.SdkLivePlayer.2
                    @Override // com.baidu.live.liveroom.e.c
                    public void a(com.baidu.live.liveroom.e.a aVar2, int i4, int i5) {
                        if (i4 == 904) {
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onFirstFrame(index＝)" + i);
                            }
                            if (SdkLivePlayer.this.fzY != null) {
                                SdkLivePlayer.this.fzY.bk(((Integer) aVar.getPlayerView().getTag(a.g.live_player_id)).intValue());
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

    private void blT() {
        if (!ListUtils.isEmpty(this.fzW)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzW.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null && next.getPlayerView() != null && next.getPlayerView().getParent() != null) {
                    ((ViewGroup) next.getPlayerView().getParent()).removeView(next.getPlayerView());
                }
            }
        }
        removeAllViews();
    }

    public void bts() {
        kf(true);
    }

    public void kf(boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer stopLivePlayer()");
        }
        if (z) {
            blT();
        }
        this.fAa = "";
        if (!ListUtils.isEmpty(this.fzW)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzW.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.stop();
                }
            }
        }
        if (this.fzX != null) {
            this.fzX.clear();
        }
        this.isPlaying = false;
    }

    @Override // com.baidu.live.o.f
    public View getLivePlayer() {
        return this;
    }

    public void btt() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer restartPlay()");
        }
        if (!ListUtils.isEmpty(this.fzX)) {
            aa(this.fzX);
        }
    }

    public void pausePlay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("AlaLivePlayer pausePlay()");
        }
        if (!ListUtils.isEmpty(this.fzW)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzW.iterator();
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
        if (!ListUtils.isEmpty(this.fzW)) {
            Iterator<com.baidu.live.liveroom.e.a> it = this.fzW.iterator();
            while (it.hasNext()) {
                com.baidu.live.liveroom.e.a next = it.next();
                if (next != null) {
                    next.a(null);
                    next.release();
                }
            }
            this.fzW.clear();
        }
        d yN = e.yL().yN();
        if (yN != null) {
            yN.b(this.fAb);
        }
    }

    public String getVideoPath() {
        return this.fAa;
    }

    public void setIPlayerCallBack(com.baidu.live.o.b bVar) {
        this.fzY = bVar;
    }

    public void setIPlayerAudioFocusCallBack(com.baidu.live.o.a aVar) {
        if (this.fzZ != null) {
            this.fzZ.setIPlayerAudioFocusCallBack(aVar);
        }
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlayLiveInfo(AlaLiveInfoData alaLiveInfoData) {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        arrayList.add(alaLiveInfoData);
        this.fzX = arrayList;
    }

    public void setPlayLiveInfo(ArrayList<AlaLiveInfoData> arrayList) {
        this.fzX = arrayList;
    }

    private LinearLayout.LayoutParams btu() {
        int aJ = com.baidu.live.utils.g.aJ(this.mContext);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(equipmentWidth, (equipmentWidth * 4) / 3);
        layoutParams.topMargin = aJ;
        return layoutParams;
    }

    private LinearLayout.LayoutParams btv() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fzZ != null) {
            this.fzZ.zg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fzZ != null) {
            this.fzZ.zh();
        }
    }
}

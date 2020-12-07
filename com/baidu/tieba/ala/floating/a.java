package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.w;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.h;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.p.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private d gKd;
    private SdkLivePlayer gKe;
    private com.baidu.live.liveroom.e.b gKf;
    private com.baidu.tieba.ala.liveroom.p.a gKg;
    private JSONObject gKh;
    private InterfaceC0653a gKi;
    private com.baidu.live.liveroom.e.a gKj = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean Pw() {
            if (a.this.isDebug()) {
                Log.d("AlaFloatLiveController", "onFloatingClosed");
            }
            b.destroy();
            return false;
        }
    };
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;

    /* renamed from: com.baidu.tieba.ala.floating.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0653a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bVp() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dA(JSONObject jSONObject) {
        this.gKh = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, w wVar, String str, long j) {
        this.gKe = sdkLivePlayer;
        if (this.gKe == null || !this.gKe.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bVs()) {
            AlaLiveInfoData alaLiveInfoData = wVar != null ? wVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bVr();
                    return;
                }
                this.gKf = i.PB().PD();
                if (this.gKf != null) {
                    this.gKe.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gKd.mC(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gKd.mC(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gKd.mC(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gKd != null) {
                                if (i == 701) {
                                    a.this.gKd.mD(true);
                                } else {
                                    a.this.gKd.mD(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gKe.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gKe.cog();
                            this.gKe.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dA(this.gKh);
                    cVar.dB(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gKf.a(this.gKe.getCurrentFloatingPlayer(), bVq().e(this.mContext, null), jSONObject, this.gKj);
                    this.gKe.setFloatingModel(true);
                    if (this.gKg == null) {
                        this.gKg = new com.baidu.tieba.ala.liveroom.p.a();
                        this.gKg.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.p.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                w wVar2;
                                if (i2 == 1 && (wVar2 = (w) obj) != null && wVar2.mLiveInfo != null && wVar2.mLiveInfo.live_status == 2) {
                                    a.this.bVr();
                                }
                            }
                        });
                    }
                    this.gKg.a(wVar, str, j);
                }
            }
        }
    }

    private d bVq() {
        if (this.gKd != null) {
            return this.gKd;
        }
        this.gKd = new d(this.mContext);
        this.gKd.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVv() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVw() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bVt();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVx() {
                if (a.this.gKe != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gKe.cof();
                        return;
                    }
                    a.this.gKe.resume();
                    if (!a.this.gKe.isPlaying()) {
                        a.this.gKe.cof();
                    }
                    a.this.gKd.mC(false);
                }
            }
        });
        return this.gKd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVr() {
        bVq().bVy();
    }

    public boolean bVs() {
        return this.gKf != null && this.gKf.Pz();
    }

    public void bVt() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gKe != null) {
            this.gKe.setFloatingModel(false);
        }
        if (this.gKg != null) {
            this.gKg.stop();
            this.gKg = null;
        }
        if (this.gKf != null) {
            this.gKf.Px();
        }
    }

    public void bVu() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gKe != null) {
            this.gKe.setFloatingModel(false);
        }
        if (this.gKg != null) {
            this.gKg.stop();
            this.gKg = null;
        }
        if (this.gKf != null) {
            this.gKf.cy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gKe != null) {
            this.gKe.setFloatingModel(false);
            if (this.gKi != null && this.gKi.a(this.gKe)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gKe.cog();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gKi = null;
            this.gKe = null;
        }
        if (this.gKg != null) {
            this.gKg.stop();
            this.gKg = null;
        }
    }

    public void a(InterfaceC0653a interfaceC0653a) {
        this.gKi = interfaceC0653a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

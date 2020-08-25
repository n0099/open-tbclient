package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.r;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.p.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private d fVX;
    private SdkLivePlayer fVY;
    private com.baidu.live.liveroom.e.b fVZ;
    private com.baidu.tieba.ala.liveroom.p.a fWa;
    private JSONObject fWb;
    private InterfaceC0600a fWc;
    private com.baidu.live.liveroom.e.a fWd = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean Lm() {
            Log.d("AlaFloatLiveController", "onFloatingClosed");
            b.destroy();
            return false;
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.floating.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0600a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dj(JSONObject jSONObject) {
        this.fWb = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, r rVar, String str, long j) {
        this.fVY = sdkLivePlayer;
        if (this.fVY == null || !this.fVY.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bJp()) {
            AlaLiveInfoData alaLiveInfoData = rVar != null ? rVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                if (alaLiveInfoData.live_status == 2) {
                    bJo();
                    return;
                }
                this.fVZ = h.Lr().Lt();
                if (this.fVZ != null) {
                    this.fVY.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.fVX.lf(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.fVX.lf(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.fVX.lf(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.fVX != null) {
                                if (i == 701) {
                                    a.this.fVX.lg(true);
                                } else {
                                    a.this.fVX.lg(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.fVY.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = com.baidu.live.p.h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.fVY.bZR();
                            this.fVY.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dj(this.fWb);
                    cVar.dk(alaLiveInfoData.toJson());
                    this.fVZ.a(this.fVY.getCurrentFloatingPlayer(), bJn().e(this.mContext, null), cVar.toJson().toString(), this.fWd);
                    this.fVY.setFloatingModel(true);
                    if (this.fWa == null) {
                        this.fWa = new com.baidu.tieba.ala.liveroom.p.a();
                        this.fWa.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.p.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                r rVar2;
                                if (i2 == 1 && (rVar2 = (r) obj) != null && rVar2.mLiveInfo != null && rVar2.mLiveInfo.live_status == 2) {
                                    a.this.bJo();
                                }
                            }
                        });
                    }
                    this.fWa.a(rVar, str, j);
                }
            }
        }
    }

    private d bJn() {
        if (this.fVX != null) {
            return this.fVX;
        }
        this.fVX = new d(this.mContext);
        this.fVX.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bJs() {
                Log.d("AlaFloatLiveController", "onRetryClicked");
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bJt() {
                Log.d("AlaFloatLiveController", "onFloatingClicked");
                a.this.bJq();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bJu() {
                if (a.this.fVY != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                        a.this.fVY.bZQ();
                    } else {
                        a.this.fVY.bZQ();
                    }
                }
            }
        });
        return this.fVX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJo() {
        bJn().bJv();
    }

    public boolean bJp() {
        return this.fVZ != null && this.fVZ.Lp();
    }

    public void bJq() {
        Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        if (this.fVY != null) {
            this.fVY.setFloatingModel(false);
        }
        if (this.fWa != null) {
            this.fWa.stop();
            this.fWa = null;
        }
        if (this.fVZ != null) {
            this.fVZ.Ln();
        }
    }

    public void bJr() {
        Log.d("AlaFloatLiveController", "dismissFloating");
        if (this.fVY != null) {
            this.fVY.setFloatingModel(false);
        }
        if (this.fWa != null) {
            this.fWa.stop();
            this.fWa = null;
        }
        if (this.fVZ != null) {
            this.fVZ.cc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        if (this.fVY != null) {
            this.fVY.setFloatingModel(false);
            if (this.fWc != null && this.fWc.a(this.fVY)) {
                Log.d("AlaFloatLiveController", "has OnClosePlayer");
            } else {
                this.fVY.bZR();
                Log.d("AlaFloatLiveController", "close player");
            }
            this.fWc = null;
            this.fVY = null;
        }
        if (this.fWa != null) {
            this.fWa.stop();
            this.fWa = null;
        }
    }

    public void a(InterfaceC0600a interfaceC0600a) {
        this.fWc = interfaceC0600a;
    }
}

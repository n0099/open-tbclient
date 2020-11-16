package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.w;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.s.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.q.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private d gBg;
    private SdkLivePlayer gBh;
    private com.baidu.live.liveroom.e.b gBi;
    private com.baidu.tieba.ala.liveroom.q.a gBj;
    private JSONObject gBk;
    private InterfaceC0640a gBl;
    private com.baidu.live.liveroom.e.a gBm = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean Ne() {
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
    public interface InterfaceC0640a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bRF() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dz(JSONObject jSONObject) {
        this.gBk = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, w wVar, String str, long j) {
        this.gBh = sdkLivePlayer;
        if (this.gBh == null || !this.gBh.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bRI()) {
            AlaLiveInfoData alaLiveInfoData = wVar != null ? wVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bRH();
                    return;
                }
                this.gBi = i.Nj().Nl();
                if (this.gBi != null) {
                    this.gBh.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gBg.mh(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gBg.mh(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gBg.mh(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gBg != null) {
                                if (i == 701) {
                                    a.this.gBg.mi(true);
                                } else {
                                    a.this.gBg.mi(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gBh.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gBh.ckl();
                            this.gBh.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dz(this.gBk);
                    cVar.dA(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gBi.a(this.gBh.getCurrentFloatingPlayer(), bRG().e(this.mContext, null), jSONObject, this.gBm);
                    this.gBh.setFloatingModel(true);
                    if (this.gBj == null) {
                        this.gBj = new com.baidu.tieba.ala.liveroom.q.a();
                        this.gBj.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                w wVar2;
                                if (i2 == 1 && (wVar2 = (w) obj) != null && wVar2.mLiveInfo != null && wVar2.mLiveInfo.live_status == 2) {
                                    a.this.bRH();
                                }
                            }
                        });
                    }
                    this.gBj.a(wVar, str, j);
                }
            }
        }
    }

    private d bRG() {
        if (this.gBg != null) {
            return this.gBg;
        }
        this.gBg = new d(this.mContext);
        this.gBg.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bRL() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bRM() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bRJ();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bRN() {
                if (a.this.gBh != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gBh.ckk();
                        return;
                    }
                    a.this.gBh.resume();
                    if (!a.this.gBh.isPlaying()) {
                        a.this.gBh.ckk();
                    }
                    a.this.gBg.mh(false);
                }
            }
        });
        return this.gBg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRH() {
        bRG().bRO();
    }

    public boolean bRI() {
        return this.gBi != null && this.gBi.Nh();
    }

    public void bRJ() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gBh != null) {
            this.gBh.setFloatingModel(false);
        }
        if (this.gBj != null) {
            this.gBj.stop();
            this.gBj = null;
        }
        if (this.gBi != null) {
            this.gBi.Nf();
        }
    }

    public void bRK() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gBh != null) {
            this.gBh.setFloatingModel(false);
        }
        if (this.gBj != null) {
            this.gBj.stop();
            this.gBj = null;
        }
        if (this.gBi != null) {
            this.gBi.ck(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gBh != null) {
            this.gBh.setFloatingModel(false);
            if (this.gBl != null && this.gBl.a(this.gBh)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gBh.ckl();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gBl = null;
            this.gBh = null;
        }
        if (this.gBj != null) {
            this.gBj.stop();
            this.gBj = null;
        }
    }

    public void a(InterfaceC0640a interfaceC0640a) {
        this.gBl = interfaceC0640a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

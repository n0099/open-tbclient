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
    private d gKf;
    private SdkLivePlayer gKg;
    private com.baidu.live.liveroom.e.b gKh;
    private com.baidu.tieba.ala.liveroom.p.a gKi;
    private JSONObject gKj;
    private InterfaceC0653a gKk;
    private com.baidu.live.liveroom.e.a gKl = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
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

    public AlaLiveInfoData bVq() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dA(JSONObject jSONObject) {
        this.gKj = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, w wVar, String str, long j) {
        this.gKg = sdkLivePlayer;
        if (this.gKg == null || !this.gKg.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bVt()) {
            AlaLiveInfoData alaLiveInfoData = wVar != null ? wVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bVs();
                    return;
                }
                this.gKh = i.PB().PD();
                if (this.gKh != null) {
                    this.gKg.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gKf.mC(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gKf.mC(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gKf.mC(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gKf != null) {
                                if (i == 701) {
                                    a.this.gKf.mD(true);
                                } else {
                                    a.this.gKf.mD(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gKg.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gKg.coh();
                            this.gKg.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dA(this.gKj);
                    cVar.dB(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gKh.a(this.gKg.getCurrentFloatingPlayer(), bVr().e(this.mContext, null), jSONObject, this.gKl);
                    this.gKg.setFloatingModel(true);
                    if (this.gKi == null) {
                        this.gKi = new com.baidu.tieba.ala.liveroom.p.a();
                        this.gKi.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.p.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                w wVar2;
                                if (i2 == 1 && (wVar2 = (w) obj) != null && wVar2.mLiveInfo != null && wVar2.mLiveInfo.live_status == 2) {
                                    a.this.bVs();
                                }
                            }
                        });
                    }
                    this.gKi.a(wVar, str, j);
                }
            }
        }
    }

    private d bVr() {
        if (this.gKf != null) {
            return this.gKf;
        }
        this.gKf = new d(this.mContext);
        this.gKf.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVw() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVx() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bVu();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVy() {
                if (a.this.gKg != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gKg.cog();
                        return;
                    }
                    a.this.gKg.resume();
                    if (!a.this.gKg.isPlaying()) {
                        a.this.gKg.cog();
                    }
                    a.this.gKf.mC(false);
                }
            }
        });
        return this.gKf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVs() {
        bVr().bVz();
    }

    public boolean bVt() {
        return this.gKh != null && this.gKh.Pz();
    }

    public void bVu() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gKg != null) {
            this.gKg.setFloatingModel(false);
        }
        if (this.gKi != null) {
            this.gKi.stop();
            this.gKi = null;
        }
        if (this.gKh != null) {
            this.gKh.Px();
        }
    }

    public void bVv() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gKg != null) {
            this.gKg.setFloatingModel(false);
        }
        if (this.gKi != null) {
            this.gKi.stop();
            this.gKi = null;
        }
        if (this.gKh != null) {
            this.gKh.cy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gKg != null) {
            this.gKg.setFloatingModel(false);
            if (this.gKk != null && this.gKk.a(this.gKg)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gKg.coh();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gKk = null;
            this.gKg = null;
        }
        if (this.gKi != null) {
            this.gKi.stop();
            this.gKi = null;
        }
    }

    public void a(InterfaceC0653a interfaceC0653a) {
        this.gKk = interfaceC0653a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.u;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.q.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.q.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private d fZo;
    private SdkLivePlayer fZp;
    private com.baidu.live.liveroom.e.b fZq;
    private com.baidu.tieba.ala.liveroom.q.a fZr;
    private JSONObject fZs;
    private InterfaceC0595a fZt;
    private com.baidu.live.liveroom.e.a fZu = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean L(JSONObject jSONObject) {
            if (a.this.isDebug()) {
                Log.d("AlaFloatLiveController", "onFloatingClosed");
            }
            b.dp(jSONObject);
            return false;
        }
    };
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;

    /* renamed from: com.baidu.tieba.ala.floating.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0595a {
        boolean a(SdkLivePlayer sdkLivePlayer, JSONObject jSONObject);
    }

    public AlaLiveInfoData bKx() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dn(JSONObject jSONObject) {
        this.fZs = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, u uVar, String str, long j) {
        this.fZp = sdkLivePlayer;
        if (this.fZp == null || !this.fZp.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bKA()) {
            AlaLiveInfoData alaLiveInfoData = uVar != null ? uVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bKz();
                    return;
                }
                this.fZq = i.LT().LV();
                if (this.fZq != null) {
                    this.fZp.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.fZo.lj(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.fZo.lj(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.fZo.lj(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.fZo != null) {
                                if (i == 701) {
                                    a.this.fZo.lk(true);
                                } else {
                                    a.this.fZo.lk(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.fZp.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.fZp.cbS();
                            this.fZp.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dn(this.fZs);
                    cVar.dq(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.fZq.a(this.fZp.getCurrentFloatingPlayer(), bKy().e(this.mContext, null), jSONObject, this.fZu);
                    this.fZp.setFloatingModel(true);
                    if (this.fZr == null) {
                        this.fZr = new com.baidu.tieba.ala.liveroom.q.a();
                        this.fZr.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                u uVar2;
                                if (i2 == 1 && (uVar2 = (u) obj) != null && uVar2.mLiveInfo != null && uVar2.mLiveInfo.live_status == 2) {
                                    a.this.bKz();
                                }
                            }
                        });
                    }
                    this.fZr.a(uVar, str, j);
                }
            }
        }
    }

    private d bKy() {
        if (this.fZo != null) {
            return this.fZo;
        }
        this.fZo = new d(this.mContext);
        this.fZo.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bKD() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bKE() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bKB();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bKF() {
                if (a.this.fZp != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                        a.this.fZp.cbR();
                        return;
                    }
                    a.this.fZp.resume();
                    if (!a.this.fZp.isPlaying()) {
                        a.this.fZp.cbR();
                    }
                    a.this.fZo.lj(false);
                }
            }
        });
        return this.fZo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKz() {
        bKy().bKG();
    }

    public boolean bKA() {
        return this.fZq != null && this.fZq.LR();
    }

    public void bKB() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.fZp != null) {
            this.fZp.setFloatingModel(false);
        }
        if (this.fZr != null) {
            this.fZr.stop();
            this.fZr = null;
        }
        if (this.fZq != null) {
            this.fZq.LP();
        }
    }

    public void bKC() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.fZp != null) {
            this.fZp.setFloatingModel(false);
        }
        if (this.fZr != null) {
            this.fZr.stop();
            this.fZr = null;
        }
        if (this.fZq != null) {
            this.fZq.cc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: do  reason: not valid java name */
    public void m40do(JSONObject jSONObject) {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.fZp != null) {
            this.fZp.setFloatingModel(false);
            if (this.fZt != null && this.fZt.a(this.fZp, jSONObject)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.fZp.cbS();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.fZt = null;
            this.fZp = null;
        }
        if (this.fZr != null) {
            this.fZr.stop();
            this.fZr = null;
        }
    }

    public void a(InterfaceC0595a interfaceC0595a) {
        this.fZt = interfaceC0595a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

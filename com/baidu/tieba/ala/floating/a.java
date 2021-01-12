package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.x;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.v.h;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.p.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private d gRl;
    private SdkLivePlayer gRm;
    private com.baidu.live.liveroom.e.b gRn;
    private com.baidu.tieba.ala.liveroom.p.a gRo;
    private JSONObject gRp;
    private InterfaceC0627a gRq;
    private com.baidu.live.liveroom.e.a gRr = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean Lp() {
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
    /* loaded from: classes10.dex */
    public interface InterfaceC0627a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bUe() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dJ(JSONObject jSONObject) {
        this.gRp = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, x xVar, String str, long j) {
        this.gRm = sdkLivePlayer;
        if (this.gRm == null || !this.gRm.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bUh()) {
            AlaLiveInfoData alaLiveInfoData = xVar != null ? xVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bUg();
                    return;
                }
                this.gRn = i.Lv().Lx();
                if (this.gRn != null) {
                    this.gRm.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gRl.mY(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gRl.mY(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gRl.mY(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gRl != null) {
                                if (i == 701) {
                                    a.this.gRl.mZ(true);
                                } else {
                                    a.this.gRl.mZ(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gRm.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gRm.cni();
                            this.gRm.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dJ(this.gRp);
                    cVar.dK(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gRn.a(this.gRm.getCurrentFloatingPlayer(), bUf().h(this.mContext, null), jSONObject, this.gRr);
                    this.gRm.setFloatingModel(true);
                    if (this.gRo == null) {
                        this.gRo = new com.baidu.tieba.ala.liveroom.p.a();
                        this.gRo.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.p.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                x xVar2;
                                if (i2 == 1 && (xVar2 = (x) obj) != null && xVar2.mLiveInfo != null && xVar2.mLiveInfo.live_status == 2) {
                                    a.this.bUg();
                                }
                            }
                        });
                    }
                    this.gRo.a(xVar, str, j);
                }
            }
        }
    }

    private d bUf() {
        if (this.gRl != null) {
            return this.gRl;
        }
        this.gRl = new d(this.mContext);
        this.gRl.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUk() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUl() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bUi();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUm() {
                if (a.this.gRm != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gRm.cnh();
                        return;
                    }
                    a.this.gRm.resume();
                    if (!a.this.gRm.isPlaying()) {
                        a.this.gRm.cnh();
                    }
                    a.this.gRl.mY(false);
                }
            }
        });
        return this.gRl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUg() {
        bUf().bUn();
    }

    public boolean bUh() {
        return this.gRn != null && this.gRn.Ls();
    }

    public void bUi() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gRm != null) {
            this.gRm.setFloatingModel(false);
        }
        if (this.gRo != null) {
            this.gRo.stop();
            this.gRo = null;
        }
        if (this.gRn != null) {
            this.gRn.Lq();
        }
    }

    public void bUj() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gRm != null) {
            this.gRm.setFloatingModel(false);
        }
        if (this.gRo != null) {
            this.gRo.stop();
            this.gRo = null;
        }
        if (this.gRn != null) {
            this.gRn.cx(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gRm != null) {
            this.gRm.setFloatingModel(false);
            if (this.gRq != null && this.gRq.a(this.gRm)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gRm.cni();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gRq = null;
            this.gRm = null;
        }
        if (this.gRo != null) {
            this.gRo.stop();
            this.gRo = null;
        }
    }

    public void a(InterfaceC0627a interfaceC0627a) {
        this.gRq = interfaceC0627a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

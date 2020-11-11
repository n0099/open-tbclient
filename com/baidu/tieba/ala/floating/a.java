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
    private SdkLivePlayer gBA;
    private com.baidu.live.liveroom.e.b gBB;
    private com.baidu.tieba.ala.liveroom.q.a gBC;
    private JSONObject gBD;
    private InterfaceC0640a gBE;
    private com.baidu.live.liveroom.e.a gBF = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean NN() {
            if (a.this.isDebug()) {
                Log.d("AlaFloatLiveController", "onFloatingClosed");
            }
            b.destroy();
            return false;
        }
    };
    private d gBz;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;

    /* renamed from: com.baidu.tieba.ala.floating.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0640a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bSm() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dF(JSONObject jSONObject) {
        this.gBD = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, w wVar, String str, long j) {
        this.gBA = sdkLivePlayer;
        if (this.gBA == null || !this.gBA.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bSp()) {
            AlaLiveInfoData alaLiveInfoData = wVar != null ? wVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bSo();
                    return;
                }
                this.gBB = i.NS().NU();
                if (this.gBB != null) {
                    this.gBA.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gBz.mg(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gBz.mg(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gBz.mg(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gBz != null) {
                                if (i == 701) {
                                    a.this.gBz.mh(true);
                                } else {
                                    a.this.gBz.mh(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gBA.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gBA.ckS();
                            this.gBA.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dF(this.gBD);
                    cVar.dG(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gBB.a(this.gBA.getCurrentFloatingPlayer(), bSn().e(this.mContext, null), jSONObject, this.gBF);
                    this.gBA.setFloatingModel(true);
                    if (this.gBC == null) {
                        this.gBC = new com.baidu.tieba.ala.liveroom.q.a();
                        this.gBC.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                w wVar2;
                                if (i2 == 1 && (wVar2 = (w) obj) != null && wVar2.mLiveInfo != null && wVar2.mLiveInfo.live_status == 2) {
                                    a.this.bSo();
                                }
                            }
                        });
                    }
                    this.gBC.a(wVar, str, j);
                }
            }
        }
    }

    private d bSn() {
        if (this.gBz != null) {
            return this.gBz;
        }
        this.gBz = new d(this.mContext);
        this.gBz.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bSs() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bSt() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bSq();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bSu() {
                if (a.this.gBA != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gBA.ckR();
                        return;
                    }
                    a.this.gBA.resume();
                    if (!a.this.gBA.isPlaying()) {
                        a.this.gBA.ckR();
                    }
                    a.this.gBz.mg(false);
                }
            }
        });
        return this.gBz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSo() {
        bSn().bSv();
    }

    public boolean bSp() {
        return this.gBB != null && this.gBB.NQ();
    }

    public void bSq() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gBA != null) {
            this.gBA.setFloatingModel(false);
        }
        if (this.gBC != null) {
            this.gBC.stop();
            this.gBC = null;
        }
        if (this.gBB != null) {
            this.gBB.NO();
        }
    }

    public void bSr() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gBA != null) {
            this.gBA.setFloatingModel(false);
        }
        if (this.gBC != null) {
            this.gBC.stop();
            this.gBC = null;
        }
        if (this.gBB != null) {
            this.gBB.ci(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gBA != null) {
            this.gBA.setFloatingModel(false);
            if (this.gBE != null && this.gBE.a(this.gBA)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gBA.ckS();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gBE = null;
            this.gBA = null;
        }
        if (this.gBC != null) {
            this.gBC.stop();
            this.gBC = null;
        }
    }

    public void a(InterfaceC0640a interfaceC0640a) {
        this.gBE = interfaceC0640a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

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
/* loaded from: classes11.dex */
public class a {
    private d gVR;
    private SdkLivePlayer gVS;
    private com.baidu.live.liveroom.e.b gVT;
    private com.baidu.tieba.ala.liveroom.p.a gVU;
    private JSONObject gVV;
    private InterfaceC0644a gVW;
    private com.baidu.live.liveroom.e.a gVX = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean Pk() {
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
    /* loaded from: classes11.dex */
    public interface InterfaceC0644a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bXV() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dJ(JSONObject jSONObject) {
        this.gVV = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, x xVar, String str, long j) {
        this.gVS = sdkLivePlayer;
        if (this.gVS == null || !this.gVS.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bXY()) {
            AlaLiveInfoData alaLiveInfoData = xVar != null ? xVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bXX();
                    return;
                }
                this.gVT = i.Pq().Ps();
                if (this.gVT != null) {
                    this.gVS.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gVR.nc(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gVR.nc(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gVR.nc(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gVR != null) {
                                if (i == 701) {
                                    a.this.gVR.nd(true);
                                } else {
                                    a.this.gVR.nd(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gVS.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gVS.cqZ();
                            this.gVS.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dJ(this.gVV);
                    cVar.dK(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gVT.a(this.gVS.getCurrentFloatingPlayer(), bXW().h(this.mContext, null), jSONObject, this.gVX);
                    this.gVS.setFloatingModel(true);
                    if (this.gVU == null) {
                        this.gVU = new com.baidu.tieba.ala.liveroom.p.a();
                        this.gVU.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.p.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                x xVar2;
                                if (i2 == 1 && (xVar2 = (x) obj) != null && xVar2.mLiveInfo != null && xVar2.mLiveInfo.live_status == 2) {
                                    a.this.bXX();
                                }
                            }
                        });
                    }
                    this.gVU.a(xVar, str, j);
                }
            }
        }
    }

    private d bXW() {
        if (this.gVR != null) {
            return this.gVR;
        }
        this.gVR = new d(this.mContext);
        this.gVR.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bYb() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bYc() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bXZ();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bYd() {
                if (a.this.gVS != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gVS.cqY();
                        return;
                    }
                    a.this.gVS.resume();
                    if (!a.this.gVS.isPlaying()) {
                        a.this.gVS.cqY();
                    }
                    a.this.gVR.nc(false);
                }
            }
        });
        return this.gVR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXX() {
        bXW().bYe();
    }

    public boolean bXY() {
        return this.gVT != null && this.gVT.Pn();
    }

    public void bXZ() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gVS != null) {
            this.gVS.setFloatingModel(false);
        }
        if (this.gVU != null) {
            this.gVU.stop();
            this.gVU = null;
        }
        if (this.gVT != null) {
            this.gVT.Pl();
        }
    }

    public void bYa() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gVS != null) {
            this.gVS.setFloatingModel(false);
        }
        if (this.gVU != null) {
            this.gVU.stop();
            this.gVU = null;
        }
        if (this.gVT != null) {
            this.gVT.cB(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gVS != null) {
            this.gVS.setFloatingModel(false);
            if (this.gVW != null && this.gVW.a(this.gVS)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gVS.cqZ();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gVW = null;
            this.gVS = null;
        }
        if (this.gVU != null) {
            this.gVU.stop();
            this.gVU = null;
        }
    }

    public void a(InterfaceC0644a interfaceC0644a) {
        this.gVW = interfaceC0644a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

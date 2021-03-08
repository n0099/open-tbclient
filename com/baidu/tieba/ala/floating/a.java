package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.h;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.n.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private d gVS;
    private SdkLivePlayer gVT;
    private com.baidu.live.liveroom.e.b gVU;
    private com.baidu.tieba.ala.liveroom.n.a gVV;
    private JSONObject gVW;
    private InterfaceC0633a gVX;
    private com.baidu.live.liveroom.e.a gVY = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean MQ() {
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
    public interface InterfaceC0633a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bUW() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dM(JSONObject jSONObject) {
        this.gVW = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, ab abVar, String str, long j) {
        this.gVT = sdkLivePlayer;
        if (this.gVT == null || !this.gVT.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bUZ()) {
            AlaLiveInfoData alaLiveInfoData = abVar != null ? abVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bUY();
                    return;
                }
                this.gVU = i.MW().MY();
                if (this.gVU != null) {
                    this.gVT.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gVS.nd(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gVS.nd(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gVS.nd(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gVS != null) {
                                if (i == 701) {
                                    a.this.gVS.ne(true);
                                } else {
                                    a.this.gVS.ne(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gVT.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gVT.cot();
                            this.gVT.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dM(this.gVW);
                    cVar.dN(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gVU.a(this.gVT.getCurrentFloatingPlayer(), bUX().h(this.mContext, null), jSONObject, this.gVY);
                    this.gVT.setFloatingModel(true);
                    if (this.gVV == null) {
                        this.gVV = new com.baidu.tieba.ala.liveroom.n.a();
                        this.gVV.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.n.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                ab abVar2;
                                if (i2 == 1 && (abVar2 = (ab) obj) != null && abVar2.mLiveInfo != null && abVar2.mLiveInfo.live_status == 2) {
                                    a.this.bUY();
                                }
                            }
                        });
                    }
                    this.gVV.a(abVar, str, j);
                }
            }
        }
    }

    private d bUX() {
        if (this.gVS != null) {
            return this.gVS;
        }
        this.gVS = new d(this.mContext);
        this.gVS.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVc() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVd() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bVa();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bVe() {
                if (a.this.gVT != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gVT.cos();
                        return;
                    }
                    a.this.gVT.resume();
                    if (!a.this.gVT.isPlaying()) {
                        a.this.gVT.cos();
                    }
                    a.this.gVS.nd(false);
                }
            }
        });
        return this.gVS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUY() {
        bUX().bVf();
    }

    public boolean bUZ() {
        return this.gVU != null && this.gVU.MT();
    }

    public void bVa() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gVT != null) {
            this.gVT.setFloatingModel(false);
        }
        if (this.gVV != null) {
            this.gVV.stop();
            this.gVV = null;
        }
        if (this.gVU != null) {
            this.gVU.MR();
        }
    }

    public void bVb() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gVT != null) {
            this.gVT.setFloatingModel(false);
        }
        if (this.gVV != null) {
            this.gVV.stop();
            this.gVV = null;
        }
        if (this.gVU != null) {
            this.gVU.cG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gVT != null) {
            this.gVT.setFloatingModel(false);
            if (this.gVX != null && this.gVX.a(this.gVT)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gVT.cot();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gVX = null;
            this.gVT = null;
        }
        if (this.gVV != null) {
            this.gVV.stop();
            this.gVV = null;
        }
    }

    public void a(InterfaceC0633a interfaceC0633a) {
        this.gVX = interfaceC0633a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

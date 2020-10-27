package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.w;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.i;
import com.baidu.live.r.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.q.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private d gvL;
    private SdkLivePlayer gvM;
    private com.baidu.live.liveroom.e.b gvN;
    private com.baidu.tieba.ala.liveroom.q.a gvO;
    private JSONObject gvP;
    private InterfaceC0628a gvQ;
    private com.baidu.live.liveroom.e.a gvR = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean Nn() {
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
    public interface InterfaceC0628a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bPM() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dz(JSONObject jSONObject) {
        this.gvP = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, w wVar, String str, long j) {
        this.gvM = sdkLivePlayer;
        if (this.gvM == null || !this.gvM.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bPP()) {
            AlaLiveInfoData alaLiveInfoData = wVar != null ? wVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bPO();
                    return;
                }
                this.gvN = i.Ns().Nu();
                if (this.gvN != null) {
                    this.gvM.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gvL.lX(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gvL.lX(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gvL.lX(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gvL != null) {
                                if (i == 701) {
                                    a.this.gvL.lY(true);
                                } else {
                                    a.this.gvL.lY(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gvM.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gvM.ciq();
                            this.gvM.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dz(this.gvP);
                    cVar.dA(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gvN.a(this.gvM.getCurrentFloatingPlayer(), bPN().e(this.mContext, null), jSONObject, this.gvR);
                    this.gvM.setFloatingModel(true);
                    if (this.gvO == null) {
                        this.gvO = new com.baidu.tieba.ala.liveroom.q.a();
                        this.gvO.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                w wVar2;
                                if (i2 == 1 && (wVar2 = (w) obj) != null && wVar2.mLiveInfo != null && wVar2.mLiveInfo.live_status == 2) {
                                    a.this.bPO();
                                }
                            }
                        });
                    }
                    this.gvO.a(wVar, str, j);
                }
            }
        }
    }

    private d bPN() {
        if (this.gvL != null) {
            return this.gvL;
        }
        this.gvL = new d(this.mContext);
        this.gvL.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bPS() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bPT() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bPQ();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bPU() {
                if (a.this.gvM != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gvM.cip();
                        return;
                    }
                    a.this.gvM.resume();
                    if (!a.this.gvM.isPlaying()) {
                        a.this.gvM.cip();
                    }
                    a.this.gvL.lX(false);
                }
            }
        });
        return this.gvL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPO() {
        bPN().bPV();
    }

    public boolean bPP() {
        return this.gvN != null && this.gvN.Nq();
    }

    public void bPQ() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gvM != null) {
            this.gvM.setFloatingModel(false);
        }
        if (this.gvO != null) {
            this.gvO.stop();
            this.gvO = null;
        }
        if (this.gvN != null) {
            this.gvN.No();
        }
    }

    public void bPR() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gvM != null) {
            this.gvM.setFloatingModel(false);
        }
        if (this.gvO != null) {
            this.gvO.stop();
            this.gvO = null;
        }
        if (this.gvN != null) {
            this.gvN.ch(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gvM != null) {
            this.gvM.setFloatingModel(false);
            if (this.gvQ != null && this.gvQ.a(this.gvM)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gvM.ciq();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gvQ = null;
            this.gvM = null;
        }
        if (this.gvO != null) {
            this.gvO.stop();
            this.gvO = null;
        }
    }

    public void a(InterfaceC0628a interfaceC0628a) {
        this.gvQ = interfaceC0628a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

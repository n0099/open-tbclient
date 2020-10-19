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
    private d glG;
    private SdkLivePlayer glH;
    private com.baidu.live.liveroom.e.b glI;
    private com.baidu.tieba.ala.liveroom.q.a glJ;
    private JSONObject glK;
    private InterfaceC0612a glL;
    private com.baidu.live.liveroom.e.a glM = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean MT() {
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
    public interface InterfaceC0612a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bNh() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void du(JSONObject jSONObject) {
        this.glK = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, u uVar, String str, long j) {
        this.glH = sdkLivePlayer;
        if (this.glH == null || !this.glH.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bNk()) {
            AlaLiveInfoData alaLiveInfoData = uVar != null ? uVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bNj();
                    return;
                }
                this.glI = i.MY().Na();
                if (this.glI != null) {
                    this.glH.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.glG.lH(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.glG.lH(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.glG.lH(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.glG != null) {
                                if (i == 701) {
                                    a.this.glG.lI(true);
                                } else {
                                    a.this.glG.lI(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.glH.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.glH.cfo();
                            this.glH.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.du(this.glK);
                    cVar.dv(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.glI.a(this.glH.getCurrentFloatingPlayer(), bNi().e(this.mContext, null), jSONObject, this.glM);
                    this.glH.setFloatingModel(true);
                    if (this.glJ == null) {
                        this.glJ = new com.baidu.tieba.ala.liveroom.q.a();
                        this.glJ.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                u uVar2;
                                if (i2 == 1 && (uVar2 = (u) obj) != null && uVar2.mLiveInfo != null && uVar2.mLiveInfo.live_status == 2) {
                                    a.this.bNj();
                                }
                            }
                        });
                    }
                    this.glJ.a(uVar, str, j);
                }
            }
        }
    }

    private d bNi() {
        if (this.glG != null) {
            return this.glG;
        }
        this.glG = new d(this.mContext);
        this.glG.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bNn() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bNo() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bNl();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bNp() {
                if (a.this.glH != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.glH.cfn();
                        return;
                    }
                    a.this.glH.resume();
                    if (!a.this.glH.isPlaying()) {
                        a.this.glH.cfn();
                    }
                    a.this.glG.lH(false);
                }
            }
        });
        return this.glG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNj() {
        bNi().bNq();
    }

    public boolean bNk() {
        return this.glI != null && this.glI.MW();
    }

    public void bNl() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.glH != null) {
            this.glH.setFloatingModel(false);
        }
        if (this.glJ != null) {
            this.glJ.stop();
            this.glJ = null;
        }
        if (this.glI != null) {
            this.glI.MU();
        }
    }

    public void bNm() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.glH != null) {
            this.glH.setFloatingModel(false);
        }
        if (this.glJ != null) {
            this.glJ.stop();
            this.glJ = null;
        }
        if (this.glI != null) {
            this.glI.cf(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.glH != null) {
            this.glH.setFloatingModel(false);
            if (this.glL != null && this.glL.a(this.glH)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.glH.cfo();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.glL = null;
            this.glH = null;
        }
        if (this.glJ != null) {
            this.glJ.stop();
            this.glJ = null;
        }
    }

    public void a(InterfaceC0612a interfaceC0612a) {
        this.glL = interfaceC0612a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

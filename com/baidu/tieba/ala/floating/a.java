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
/* loaded from: classes11.dex */
public class a {
    private d gTV;
    private SdkLivePlayer gTW;
    private com.baidu.live.liveroom.e.b gTX;
    private com.baidu.tieba.ala.liveroom.n.a gTY;
    private JSONObject gTZ;
    private InterfaceC0626a gUa;
    private com.baidu.live.liveroom.e.a gUb = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean MN() {
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
    public interface InterfaceC0626a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bUJ() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dK(JSONObject jSONObject) {
        this.gTZ = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, ab abVar, String str, long j) {
        this.gTW = sdkLivePlayer;
        if (this.gTW == null || !this.gTW.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bUM()) {
            AlaLiveInfoData alaLiveInfoData = abVar != null ? abVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bUL();
                    return;
                }
                this.gTX = i.MT().MV();
                if (this.gTX != null) {
                    this.gTW.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gTV.nd(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gTV.nd(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gTV.nd(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gTV != null) {
                                if (i == 701) {
                                    a.this.gTV.ne(true);
                                } else {
                                    a.this.gTV.ne(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gTW.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gTW.cog();
                            this.gTW.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dK(this.gTZ);
                    cVar.dL(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gTX.a(this.gTW.getCurrentFloatingPlayer(), bUK().h(this.mContext, null), jSONObject, this.gUb);
                    this.gTW.setFloatingModel(true);
                    if (this.gTY == null) {
                        this.gTY = new com.baidu.tieba.ala.liveroom.n.a();
                        this.gTY.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.n.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                ab abVar2;
                                if (i2 == 1 && (abVar2 = (ab) obj) != null && abVar2.mLiveInfo != null && abVar2.mLiveInfo.live_status == 2) {
                                    a.this.bUL();
                                }
                            }
                        });
                    }
                    this.gTY.a(abVar, str, j);
                }
            }
        }
    }

    private d bUK() {
        if (this.gTV != null) {
            return this.gTV;
        }
        this.gTV = new d(this.mContext);
        this.gTV.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUP() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUQ() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bUN();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUR() {
                if (a.this.gTW != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gTW.cof();
                        return;
                    }
                    a.this.gTW.resume();
                    if (!a.this.gTW.isPlaying()) {
                        a.this.gTW.cof();
                    }
                    a.this.gTV.nd(false);
                }
            }
        });
        return this.gTV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUL() {
        bUK().bUS();
    }

    public boolean bUM() {
        return this.gTX != null && this.gTX.MQ();
    }

    public void bUN() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gTW != null) {
            this.gTW.setFloatingModel(false);
        }
        if (this.gTY != null) {
            this.gTY.stop();
            this.gTY = null;
        }
        if (this.gTX != null) {
            this.gTX.MO();
        }
    }

    public void bUO() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gTW != null) {
            this.gTW.setFloatingModel(false);
        }
        if (this.gTY != null) {
            this.gTY.stop();
            this.gTY = null;
        }
        if (this.gTX != null) {
            this.gTX.cG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gTW != null) {
            this.gTW.setFloatingModel(false);
            if (this.gUa != null && this.gUa.a(this.gTW)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gTW.cog();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gUa = null;
            this.gTW = null;
        }
        if (this.gTY != null) {
            this.gTY.stop();
            this.gTY = null;
        }
    }

    public void a(InterfaceC0626a interfaceC0626a) {
        this.gUa = interfaceC0626a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

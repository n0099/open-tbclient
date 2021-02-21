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
    private d gUj;
    private SdkLivePlayer gUk;
    private com.baidu.live.liveroom.e.b gUl;
    private com.baidu.tieba.ala.liveroom.n.a gUm;
    private JSONObject gUn;
    private InterfaceC0627a gUo;
    private com.baidu.live.liveroom.e.a gUp = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
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
    public interface InterfaceC0627a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public AlaLiveInfoData bUQ() {
        return this.mLiveInfo;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dK(JSONObject jSONObject) {
        this.gUn = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, ab abVar, String str, long j) {
        this.gUk = sdkLivePlayer;
        if (this.gUk == null || !this.gUk.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bUT()) {
            AlaLiveInfoData alaLiveInfoData = abVar != null ? abVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                this.mLiveInfo = alaLiveInfoData;
                if (alaLiveInfoData.live_status == 2) {
                    bUS();
                    return;
                }
                this.gUl = i.MT().MV();
                if (this.gUl != null) {
                    this.gUk.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.gUj.nd(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.gUj.nd(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.gUj.nd(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.gUj != null) {
                                if (i == 701) {
                                    a.this.gUj.ne(true);
                                } else {
                                    a.this.gUj.ne(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.gUk.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.gUk.con();
                            this.gUk.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dK(this.gUn);
                    cVar.dL(alaLiveInfoData.toJson());
                    String jSONObject = cVar.toJson().toString();
                    if (isDebug()) {
                        Log.d("AlaFloatLiveController", "switchToFloating ...");
                    }
                    this.gUl.a(this.gUk.getCurrentFloatingPlayer(), bUR().h(this.mContext, null), jSONObject, this.gUp);
                    this.gUk.setFloatingModel(true);
                    if (this.gUm == null) {
                        this.gUm = new com.baidu.tieba.ala.liveroom.n.a();
                        this.gUm.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.n.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                ab abVar2;
                                if (i2 == 1 && (abVar2 = (ab) obj) != null && abVar2.mLiveInfo != null && abVar2.mLiveInfo.live_status == 2) {
                                    a.this.bUS();
                                }
                            }
                        });
                    }
                    this.gUm.a(abVar, str, j);
                }
            }
        }
    }

    private d bUR() {
        if (this.gUj != null) {
            return this.gUj;
        }
        this.gUj = new d(this.mContext);
        this.gUj.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUW() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onRetryClicked");
                }
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUX() {
                if (a.this.isDebug()) {
                    Log.d("AlaFloatLiveController", "onFloatingClicked");
                }
                a.this.bUU();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bUY() {
                if (a.this.gUk != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                        a.this.gUk.com();
                        return;
                    }
                    a.this.gUk.resume();
                    if (!a.this.gUk.isPlaying()) {
                        a.this.gUk.com();
                    }
                    a.this.gUj.nd(false);
                }
            }
        });
        return this.gUj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        bUR().bUZ();
    }

    public boolean bUT() {
        return this.gUl != null && this.gUl.MQ();
    }

    public void bUU() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "switchFloatingToNormal");
        }
        if (this.gUk != null) {
            this.gUk.setFloatingModel(false);
        }
        if (this.gUm != null) {
            this.gUm.stop();
            this.gUm = null;
        }
        if (this.gUl != null) {
            this.gUl.MO();
        }
    }

    public void bUV() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", "dismissFloating");
        }
        if (this.gUk != null) {
            this.gUk.setFloatingModel(false);
        }
        if (this.gUm != null) {
            this.gUm.stop();
            this.gUm = null;
        }
        if (this.gUl != null) {
            this.gUl.cG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (isDebug()) {
            Log.d("AlaFloatLiveController", MissionEvent.MESSAGE_DESTROY);
        }
        if (this.gUk != null) {
            this.gUk.setFloatingModel(false);
            if (this.gUo != null && this.gUo.a(this.gUk)) {
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "has OnClosePlayer");
                }
            } else {
                this.gUk.con();
                if (isDebug()) {
                    Log.d("AlaFloatLiveController", "close player");
                }
            }
            this.gUo = null;
            this.gUk = null;
        }
        if (this.gUm != null) {
            this.gUm.stop();
            this.gUm = null;
        }
    }

    public void a(InterfaceC0627a interfaceC0627a) {
        this.gUo = interfaceC0627a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return com.baidu.live.liveroom.e.h.isDebug();
    }
}

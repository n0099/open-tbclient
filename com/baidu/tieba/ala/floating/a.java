package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.r;
import com.baidu.live.liveroom.e.g;
import com.baidu.live.liveroom.e.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.floating.d;
import com.baidu.tieba.ala.liveroom.p.d;
import com.baidu.tieba.ala.player.SdkLivePlayer;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private d fWb;
    private SdkLivePlayer fWc;
    private com.baidu.live.liveroom.e.b fWd;
    private com.baidu.tieba.ala.liveroom.p.a fWe;
    private JSONObject fWf;
    private InterfaceC0600a fWg;
    private com.baidu.live.liveroom.e.a fWh = new com.baidu.live.liveroom.e.a() { // from class: com.baidu.tieba.ala.floating.a.1
        @Override // com.baidu.live.liveroom.e.a
        public boolean Lm() {
            b.destroy();
            return false;
        }
    };
    private Context mContext;

    /* renamed from: com.baidu.tieba.ala.floating.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0600a {
        boolean a(SdkLivePlayer sdkLivePlayer);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void dj(JSONObject jSONObject) {
        this.fWf = jSONObject;
    }

    public void a(SdkLivePlayer sdkLivePlayer, r rVar, String str, long j) {
        this.fWc = sdkLivePlayer;
        if (this.fWc == null || !this.fWc.isPlaying()) {
            Log.d("AlaFloatLiveController", "switchToFloating canceled when player null or stoped");
        } else if (!bJq()) {
            AlaLiveInfoData alaLiveInfoData = rVar != null ? rVar.mLiveInfo : null;
            if (alaLiveInfoData != null) {
                if (alaLiveInfoData.live_status == 2) {
                    bJp();
                    return;
                }
                this.fWd = h.Lr().Lt();
                if (this.fWd != null) {
                    this.fWc.setPlayerCallback(new g() { // from class: com.baidu.tieba.ala.floating.a.2
                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onStart() {
                            super.onStart();
                            a.this.fWb.lh(false);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onPause() {
                            super.onPause();
                            a.this.fWb.lh(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void onEnd(int i) {
                            super.onEnd(i);
                            a.this.fWb.lh(true);
                        }

                        @Override // com.baidu.live.liveroom.e.g, com.baidu.live.liveroom.e.f
                        public void a(com.baidu.live.liveroom.e.d dVar, int i, int i2) {
                            if (a.this.fWb != null) {
                                if (i == 701) {
                                    a.this.fWb.li(true);
                                } else {
                                    a.this.fWb.li(false);
                                }
                            }
                        }
                    });
                    AlaLiveInfoData currentLiveInfoData = this.fWc.getCurrentLiveInfoData();
                    if (currentLiveInfoData != null) {
                        String d = com.baidu.live.p.h.d(currentLiveInfoData);
                        if (!TextUtils.isEmpty(currentLiveInfoData.playUrl) && !TextUtils.equals(d, currentLiveInfoData.playUrl)) {
                            currentLiveInfoData.playUrl = null;
                            this.fWc.bZS();
                            this.fWc.c(currentLiveInfoData);
                        }
                    }
                    c cVar = new c();
                    cVar.dj(this.fWf);
                    cVar.dk(alaLiveInfoData.toJson());
                    this.fWd.a(this.fWc.getCurrentFloatingPlayer(), bJo().e(this.mContext, null), cVar.toJson().toString(), this.fWh);
                    this.fWc.setFloatingModel(true);
                    if (this.fWe == null) {
                        this.fWe = new com.baidu.tieba.ala.liveroom.p.a();
                        this.fWe.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.3
                            @Override // com.baidu.tieba.ala.liveroom.p.d.a
                            public void a(int i, String str2, int i2, Object obj) {
                                r rVar2;
                                if (i2 == 1 && (rVar2 = (r) obj) != null && rVar2.mLiveInfo != null && rVar2.mLiveInfo.live_status == 2) {
                                    a.this.bJp();
                                }
                            }
                        });
                    }
                    this.fWe.a(rVar, str, j);
                }
            }
        }
    }

    private d bJo() {
        if (this.fWb != null) {
            return this.fWb;
        }
        this.fWb = new d(this.mContext);
        this.fWb.a(new d.a() { // from class: com.baidu.tieba.ala.floating.a.4
            @Override // com.baidu.tieba.ala.floating.d.a
            public void bJt() {
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bJu() {
                a.this.bJr();
            }

            @Override // com.baidu.tieba.ala.floating.d.a
            public void bJv() {
                if (a.this.fWc != null) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
                        a.this.fWc.bZR();
                        return;
                    }
                    a.this.fWc.resume();
                    if (!a.this.fWc.isPlaying()) {
                        a.this.fWc.bZR();
                    }
                    a.this.fWb.lh(false);
                }
            }
        });
        return this.fWb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJp() {
        bJo().bJw();
    }

    public boolean bJq() {
        return this.fWd != null && this.fWd.Lp();
    }

    public void bJr() {
        if (this.fWc != null) {
            this.fWc.setFloatingModel(false);
        }
        if (this.fWe != null) {
            this.fWe.stop();
            this.fWe = null;
        }
        if (this.fWd != null) {
            this.fWd.Ln();
        }
    }

    public void bJs() {
        if (this.fWc != null) {
            this.fWc.setFloatingModel(false);
        }
        if (this.fWe != null) {
            this.fWe.stop();
            this.fWe = null;
        }
        if (this.fWd != null) {
            this.fWd.cc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        if (this.fWc != null) {
            this.fWc.setFloatingModel(false);
            if (this.fWg == null || !this.fWg.a(this.fWc)) {
                this.fWc.bZS();
            }
            this.fWg = null;
            this.fWc = null;
        }
        if (this.fWe != null) {
            this.fWe.stop();
            this.fWe = null;
        }
    }

    public void a(InterfaceC0600a interfaceC0600a) {
        this.fWg = interfaceC0600a;
    }
}

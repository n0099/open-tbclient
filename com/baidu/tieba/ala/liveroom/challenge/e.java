package com.baidu.tieba.ala.liveroom.challenge;

import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.f;
import com.baidu.live.challenge.g;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.challenge.k;
import com.baidu.live.d.a;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.w;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.d.a gVw;
    private com.baidu.live.challenge.e gYb;
    private com.baidu.tieba.ala.liveroom.data.e gZr;
    private f gZs;
    private i gZt;
    private j gZu;
    private h gZv;
    private d gZx;
    private ImageView gZy;
    private com.baidu.tieba.ala.liveroom.data.f gZz;
    private boolean gZw = false;
    private boolean gZA = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gZr = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.gZy = imageView;
        this.gZz = fVar;
        this.gZA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e bYO() {
        return this.gZr;
    }

    public void j(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bYO().caK() != 2) {
            if (!z2) {
                this.gZy.setVisibility(0);
            }
            if (this.gYb == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bYO().pageContext)) != null && runTask2.getData() != null) {
                this.gYb = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gZs == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, bYO().pageContext)) != null && runTask.getData() != null) {
                this.gZs = (f) runTask.getData();
            }
            if (this.gYb != null && this.gZs != null) {
                if (this.gZt == null) {
                    this.gZt = this.gYb.a(bYO().pageContext);
                    this.gZt.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void dK(int i) {
                            if (e.this.gZu != null) {
                                e.this.gZu.dL(i);
                            }
                        }
                    });
                    this.gZt.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int CX() {
                            return e.this.bYO().hgB.getRtcStreamStatus();
                        }
                    });
                    this.gZt.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(az azVar, bd bdVar, bd bdVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(az azVar, bd bdVar, bd bdVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(az azVar, bd bdVar, bd bdVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(az azVar, bd bdVar, bd bdVar2) {
                            e.this.bYP();
                            e.this.gZy.setVisibility(0);
                        }
                    });
                }
                if (this.gZu == null) {
                    this.gZu = this.gZs.CG();
                    this.gZu.setUserId(String.valueOf(bYO().hgk.Gz().aHk.userId));
                    this.gZu.setUserPortrait(bYO().hgk.Gz().aHk.portrait);
                    this.gZu.a(this.gZt);
                    this.gZu.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void CZ() {
                            e.this.gZu.removeView();
                            if (e.this.gVw != null && e.this.gVw.getRootView() != null) {
                                e.this.gVw.setVisible(0);
                                e.this.gVw.CE();
                            }
                            if (e.this.gZx != null) {
                                e.this.gZx.bYN();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Da() {
                            e.this.gZy.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aFu, aVar.aFv);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Db() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Dc() {
                        }
                    });
                }
                this.gZt.e(bYO().hgk.Gz().mLiveInfo.live_id, bYO().hgk.Gz().aHk.userId);
                this.gZt.a((i.m) this.gZu);
                this.gZt.a((i.a) this.gZu);
                this.gZt.a((i.e) this.gZu);
                this.gZt.a((i.k) this.gZu);
                this.gZt.a((i.InterfaceC0175i) this.gZu);
                this.gZt.a((i.l) this.gZu);
                this.gZt.a((i.h) this.gZu);
                this.gZt.a((i.g) this.gZu);
                this.gZt.a((i.c) this.gZu);
                this.gZt.a((i.j) this.gZu);
                this.gZt.setIsHost(bYO().hgk.Gz().isHost);
                if (this.gZv == null) {
                    this.gZv = this.gYb.b(bYO().pageContext);
                    this.gZv.b(false, true, z3);
                    this.gZv.a(this.gZt);
                    this.gZv.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void CH() {
                            e.this.bYO().hgl.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(az azVar, bd bdVar, bd bdVar2) {
                            if (e.this.gZx != null) {
                                e.this.gZx.a(azVar, bdVar, bdVar2);
                            }
                            if (e.this.gVw != null) {
                                e.this.gVw.setCanVisible(false);
                                e.this.gVw.setVisible(8);
                            }
                            e.this.bYO().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.bYO().caL();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void CI() {
                            e.this.bYO().beP();
                            if (e.this.gZx != null) {
                                e.this.gZx.CI();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void CJ() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bk(boolean z4) {
                            if (e.this.gZx != null) {
                                e.this.gZx.bYM();
                            }
                            if (e.this.gVw != null) {
                                e.this.gVw.setCanVisible(true);
                            }
                            if (e.this.gZy != null) {
                                e.this.gZy.setVisibility(0);
                            }
                            e.this.bYO().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.bYP();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bl(boolean z4) {
                        }
                    });
                    this.gZv.i(bYO().hgE);
                }
                this.gZt.a((i.c) this.gZv);
                this.gZt.a((i.n) this.gZv);
                this.gZt.a((i.d) this.gZv);
                if (this.gZt.CS() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gZy.setVisibility(0);
                }
                if (this.gVw != null && this.gVw.getRootView() != null) {
                    if (this.gVw.CC()) {
                        this.gVw.setVisible(0);
                        this.gZy.setVisibility(0);
                    } else {
                        this.gVw.setVisible(4);
                    }
                }
                if (z3 && !this.gZw) {
                    this.gZw = true;
                    this.gZt.a(this.gZz.hgK.mChallengeData);
                    if (this.gZz.hgK.mAvtsData != null) {
                        a(this.gZz.hgK.mAvtsData, this.gZz.hgK.mAvtsConfigInfo);
                        this.gZy.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gZt != null) {
            this.gZt.bn(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYP() {
        bYO().VJ();
        bYO().caM();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.OE().f(true, false);
        bYO().hgB.switchToCommonMode(f.getWidth(), f.getHeight());
        bYO().caN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (alaAvtsData != null) {
            AlaLiveRtcConfig alaLiveRtcConfig = new AlaLiveRtcConfig();
            alaLiveRtcConfig.mUId = TbadkCoreApplication.getCurrentAccountId();
            alaLiveRtcConfig.mRoomId = alaAvtsData.roomId;
            alaLiveRtcConfig.mLineIndex = alaAvtsData.lineId;
            alaLiveRtcConfig.mRtcServerHost = alaAvtsData.host;
            alaLiveRtcConfig.mRtcServerPort = alaAvtsData.port;
            if (alaAvtsConfigInfo != null) {
                alaLiveRtcConfig.mHandshakeTimeout = alaAvtsConfigInfo.handshakeTimeout;
                alaLiveRtcConfig.mHeartInterval = alaAvtsConfigInfo.heartInterval;
                alaLiveRtcConfig.mHeartTimeout = alaAvtsConfigInfo.heartTimeout;
                alaLiveRtcConfig.mCloseTimeout = alaAvtsConfigInfo.closeTimeout;
                alaLiveRtcConfig.mReduceDelay = alaAvtsConfigInfo.reduceDelay;
            }
            bYO().caM();
            bYO().hgB.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.OE().f(true, true);
            bYO().hgB.switchToRtcMode(f.getWidth(), f.getHeight());
            bYO().caN();
        }
    }

    public boolean bYQ() {
        return this.gZt.CS() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean bYR() {
        return this.gZt.CS() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void bYS() {
        if (this.gZu != null) {
            this.gZu.bo(this.gZA);
            this.gZu.b(bYO().hgE, true);
        }
    }

    public void bYT() {
        if (this.gZu != null && this.gZu.isActive()) {
            this.gZu.onBackKeyDown();
        }
    }

    public void a(w wVar) {
        if (this.gZv != null) {
            this.gZv.a(wVar);
        }
        if (this.gVw != null) {
            this.gVw.b(wVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gZu != null && this.gZu.isActive() && this.gZu.onBackKeyDown();
    }

    public void bYU() {
        if (this.gZt != null) {
            this.gZt.CD();
            this.gZt.onDestroy();
        }
        if (this.gVw != null) {
            this.gVw.CD();
            this.gVw.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gZv != null) {
            this.gZv.CK();
        }
    }

    public void onDestroy() {
        if (this.gZv != null) {
            this.gZv.onDestroy();
        }
        if (this.gZu != null) {
            this.gZu.removeView();
        }
    }

    public boolean bYV() {
        return this.gZv != null && this.gZv.isActive();
    }

    public int bm(boolean z) {
        if (this.gZv != null) {
            return this.gZv.bm(z);
        }
        return 0;
    }

    public boolean bYW() {
        return this.gVw != null && this.gVw.CC();
    }

    public void gb(String str) {
        if (this.gZt != null) {
            this.gZt.gb(str);
        }
    }

    public void N(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bYO().caK() != 2 && com.baidu.live.aa.a.Ph().bms.aKs) {
            if (this.gVw == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bYO().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gVw = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gVw != null) {
                this.gVw.a(bYO().hgk.cfS(), true, z2);
                this.gVw.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gVw.getRootView() != null && this.gVw.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.gVw.getRootView().setId(a.f.ala_live_room_pk_panel);
                    bYO().hgl.addView(this.gVw.getRootView(), layoutParams);
                }
                this.gVw.a(null, bYO().hgk.Gz());
                if (this.gZz != null && this.gZz.hgK != null && this.gZz.hgK.mPkData != null) {
                    this.gVw.dH(this.gZz.hgK.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gZx = dVar;
    }

    public int bYx() {
        int i = 0;
        if (this.gZv != null) {
            i = this.gZv.bm(true);
        }
        return i + bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

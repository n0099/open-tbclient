package com.baidu.tieba.ala.liveroom.challenge;

import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.challenge.k;
import com.baidu.live.d.a;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.u;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.d.a gpE;
    private com.baidu.live.challenge.e gsf;
    private d gtB;
    private ImageView gtC;
    private g gtD;
    private f gtv;
    private com.baidu.live.challenge.f gtw;
    private i gtx;
    private j gty;
    private h gtz;
    private boolean gtA = false;
    private boolean gtE = false;

    public e(f fVar) {
        this.gtv = fVar;
    }

    public void a(ImageView imageView, g gVar, boolean z) {
        this.gtC = imageView;
        this.gtD = gVar;
        this.gtE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f bQB() {
        return this.gtv;
    }

    public void j(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bQB().bSx() != 2) {
            if (!z2) {
                this.gtC.setVisibility(0);
            }
            if (this.gsf == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bQB().pageContext)) != null && runTask2.getData() != null) {
                this.gsf = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gtw == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, bQB().pageContext)) != null && runTask.getData() != null) {
                this.gtw = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.gsf != null && this.gtw != null) {
                if (this.gtx == null) {
                    this.gtx = this.gsf.a(bQB().pageContext);
                    this.gtx.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void dJ(int i) {
                            if (e.this.gty != null) {
                                e.this.gty.dK(i);
                            }
                        }
                    });
                    this.gtx.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int Cj() {
                            return e.this.bQB().gAT.getRtcStreamStatus();
                        }
                    });
                    this.gtx.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(au auVar, ay ayVar, ay ayVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(au auVar, ay ayVar, ay ayVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(au auVar, ay ayVar, ay ayVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(au auVar, ay ayVar, ay ayVar2) {
                            e.this.bQC();
                            e.this.gtC.setVisibility(0);
                        }
                    });
                }
                if (this.gty == null) {
                    this.gty = this.gtw.BT();
                    this.gty.setUserId(String.valueOf(bQB().gAu.Fq().aEz.userId));
                    this.gty.fQ(bQB().gAu.Fq().aEz.portrait);
                    this.gty.a(this.gtx);
                    this.gty.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void Cl() {
                            e.this.gty.removeView();
                            if (e.this.gpE != null && e.this.gpE.getRootView() != null) {
                                e.this.gpE.setVisible(0);
                                e.this.gpE.BR();
                            }
                            if (e.this.gtB != null) {
                                e.this.gtB.bQA();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Cm() {
                            e.this.gtC.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aDc, aVar.aDd);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Cn() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Co() {
                        }
                    });
                }
                this.gtx.e(bQB().gAu.Fq().mLiveInfo.live_id, bQB().gAu.Fq().aEz.userId);
                this.gtx.a((i.m) this.gty);
                this.gtx.a((i.a) this.gty);
                this.gtx.a((i.e) this.gty);
                this.gtx.a((i.k) this.gty);
                this.gtx.a((i.InterfaceC0168i) this.gty);
                this.gtx.a((i.l) this.gty);
                this.gtx.a((i.h) this.gty);
                this.gtx.a((i.g) this.gty);
                this.gtx.a((i.c) this.gty);
                this.gtx.a((i.j) this.gty);
                this.gtx.setIsHost(bQB().gAu.Fq().isHost);
                if (this.gtz == null) {
                    this.gtz = this.gsf.b(bQB().pageContext);
                    this.gtz.b(false, true, z3);
                    this.gtz.a(this.gtx);
                    this.gtz.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void BU() {
                            e.this.bQB().gAv.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(au auVar, ay ayVar, ay ayVar2) {
                            if (e.this.gtB != null) {
                                e.this.gtB.a(auVar, ayVar, ayVar2);
                            }
                            if (e.this.gpE != null) {
                                e.this.gpE.setCanVisible(false);
                                e.this.gpE.setVisible(8);
                            }
                            e.this.bQB().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            e.this.bQB().bSy();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void BV() {
                            e.this.bQB().aYv();
                            if (e.this.gtB != null) {
                                e.this.gtB.BV();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void BW() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bc(boolean z4) {
                            if (e.this.gtB != null) {
                                e.this.gtB.bQz();
                            }
                            if (e.this.gpE != null) {
                                e.this.gpE.setCanVisible(true);
                            }
                            if (e.this.gtC != null) {
                                e.this.gtC.setVisibility(0);
                            }
                            e.this.bQB().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            e.this.bQC();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bd(boolean z4) {
                        }
                    });
                    this.gtz.m(bQB().gAV);
                }
                this.gtx.a((i.c) this.gtz);
                this.gtx.a((i.n) this.gtz);
                this.gtx.a((i.d) this.gtz);
                if (this.gtx.Ce() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gtC.setVisibility(0);
                }
                if (this.gpE != null && this.gpE.getRootView() != null) {
                    if (this.gpE.BP()) {
                        this.gpE.setVisible(0);
                        this.gtC.setVisibility(0);
                    } else {
                        this.gpE.setVisible(4);
                    }
                }
                if (z3 && !this.gtA) {
                    this.gtA = true;
                    this.gtx.a(this.gtD.gBb.mChallengeData);
                    if (this.gtD.gBb.mAvtsData != null) {
                        a(this.gtD.gBb.mAvtsData, this.gtD.gBb.mAvtsConfigInfo);
                        this.gtC.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gtx != null) {
            this.gtx.bf(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQC() {
        bQB().Rb();
        bQB().bSz();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Nk().f(true, false);
        bQB().gAT.switchToCommonMode(f.getWidth(), f.getHeight());
        bQB().bSA();
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
            bQB().bSz();
            bQB().gAT.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Nk().f(true, true);
            bQB().gAT.switchToRtcMode(f.getWidth(), f.getHeight());
            bQB().bSA();
        }
    }

    public boolean bQD() {
        return this.gtx.Ce() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean bQE() {
        return this.gtx.Ce() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void bQF() {
        if (this.gty != null) {
            this.gty.bg(this.gtE);
            this.gty.b(bQB().gAV, true);
        }
    }

    public void a(u uVar) {
        if (this.gtz != null) {
            this.gtz.a(uVar);
        }
        if (this.gpE != null) {
            this.gpE.b(uVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gty != null && this.gty.isActive() && this.gty.onBackKeyDown();
    }

    public void bQG() {
        if (this.gtx != null) {
            this.gtx.BQ();
            this.gtx.onDestroy();
        }
        if (this.gpE != null) {
            this.gpE.BQ();
            this.gpE.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gtz != null) {
            this.gtz.BX();
        }
    }

    public void onDestroy() {
        if (this.gtz != null) {
            this.gtz.onDestroy();
        }
        if (this.gty != null) {
            this.gty.removeView();
        }
    }

    public boolean bQH() {
        return this.gtz != null && this.gtz.isActive();
    }

    public int be(boolean z) {
        if (this.gtz != null) {
            return this.gtz.be(z);
        }
        return 0;
    }

    public boolean bQI() {
        return this.gpE != null && this.gpE.BP();
    }

    public void fN(String str) {
        if (this.gtx != null) {
            this.gtx.fN(str);
        }
    }

    public void K(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bQB().bSx() != 2 && com.baidu.live.x.a.NN().bhy.aHx) {
            if (this.gpE == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bQB().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gpE = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gpE != null) {
                this.gpE.a(bQB().gAu.bXz(), true, z2);
                this.gpE.a(new a.InterfaceC0169a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gpE.getRootView() != null && this.gpE.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.gpE.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bQB().gAv.addView(this.gpE.getRootView(), layoutParams);
                }
                this.gpE.a(null, bQB().gAu.Fq());
                if (this.gtD != null && this.gtD.gBb != null && this.gtD.gBb.mPkData != null) {
                    this.gpE.dG(this.gtD.gBb.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gtB = dVar;
    }

    public int bQl() {
        int i = 0;
        if (this.gtz != null) {
            i = this.gtz.be(true);
        }
        return i + bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }
}

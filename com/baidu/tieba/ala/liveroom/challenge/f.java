package com.baidu.tieba.ala.liveroom.challenge;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.g;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.challenge.k;
import com.baidu.live.challenge.l;
import com.baidu.live.d.a;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.m;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class f {
    private com.baidu.live.d.a eQX;
    private com.baidu.live.challenge.f eTf;
    private com.baidu.tieba.ala.liveroom.data.f eUa;
    private g eUb;
    private j eUc;
    private k eUd;
    private i eUe;
    private com.baidu.live.challenge.e eUf;
    private boolean eUg = false;
    private e eUh;
    private ImageView eUi;
    private com.baidu.tieba.ala.liveroom.data.g eUj;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.eUa = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.eUi = imageView;
        this.eUj = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f bkg() {
        return this.eUa;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bkg().blM() != 2 && z2) {
            if (this.eTf == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bkg().pageContext)) != null && runTask2.getData() != null) {
                this.eTf = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.eUb == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, bkg().pageContext)) != null && runTask.getData() != null) {
                this.eUb = (g) runTask.getData();
            }
            if (this.eTf != null && this.eUb != null) {
                if (this.eUc == null) {
                    this.eUc = this.eTf.a(bkg().pageContext);
                    this.eUc.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bm(int i) {
                            if (f.this.eUd != null) {
                                f.this.eUd.bj(i);
                                if (f.this.eUf == null) {
                                    f.this.eUf = f.this.eUb.pP();
                                    f.this.eUf.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.eUf.hide();
                                            f.this.eUf.as(false);
                                            if (f.this.eUd != null) {
                                                f.this.eUd.b(f.this.bkg().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.eUf.bj(i);
                                if (!f.this.eUd.isActive()) {
                                    f.this.eUf.J(f.this.eUi);
                                }
                            }
                        }
                    });
                    this.eUc.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int qe() {
                            return f.this.bkg().faI.getRtcStreamStatus();
                        }
                    });
                    this.eUc.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.c
                        public void b(ad adVar, ae aeVar, ae aeVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void c(ad adVar, ae aeVar, ae aeVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void d(ad adVar, ae aeVar, ae aeVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void e(ad adVar, ae aeVar, ae aeVar2) {
                            f.this.bkh();
                            f.this.eUi.setVisibility(0);
                        }
                    });
                }
                if (this.eUd == null) {
                    this.eUd = this.eUb.pO();
                    this.eUd.cV(bkg().fai.yO().XQ.portrait);
                    this.eUd.a(this.eUc);
                    this.eUd.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void qg() {
                            f.this.eUd.removeView();
                            if (f.this.eQX != null && f.this.eQX.getRootView() != null) {
                                f.this.eQX.setVisible(0);
                                f.this.eQX.pL();
                                f.this.eUi.setVisibility(8);
                            }
                            if (f.this.eUh != null) {
                                f.this.eUh.bkf();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qh() {
                            f.this.eUi.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.WW, aVar.WX);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qi() {
                            if (f.this.eUf != null) {
                                f.this.eUf.as(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qj() {
                            if (f.this.eUf != null && !f.this.eUf.isShowing() && f.this.eUf.pN()) {
                                f.this.eUf.J(f.this.eUi);
                            }
                        }
                    });
                }
                this.eUc.d(bkg().fai.yO().mLiveInfo.live_id, bkg().fai.yO().XQ.userId);
                this.eUc.a((j.InterfaceC0081j) this.eUd);
                this.eUc.a((j.a) this.eUd);
                this.eUc.a((j.d) this.eUd);
                this.eUc.a((j.i) this.eUd);
                this.eUc.a((j.h) this.eUd);
                this.eUc.a((j.g) this.eUd);
                this.eUc.a((j.f) this.eUd);
                this.eUc.a((j.c) this.eUd);
                if (this.eUe == null) {
                    this.eUe = this.eTf.b(bkg().pageContext);
                    this.eUe.b(false, true, z3);
                    this.eUe.a(this.eUc);
                    this.eUe.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void pQ() {
                            f.this.bkg().faj.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ad adVar, ae aeVar, ae aeVar2) {
                            if (f.this.eUh != null) {
                                f.this.eUh.a(adVar, aeVar, aeVar2);
                            }
                            if (f.this.eQX != null) {
                                f.this.eQX.setCanVisible(false);
                                f.this.eQX.setVisible(8);
                            }
                            f.this.bkg().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bkg().blO();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pR() {
                            f.this.bkg().awQ();
                            if (f.this.eUh != null) {
                                f.this.eUh.pR();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pS() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void at(boolean z4) {
                            if (f.this.eUh != null) {
                                f.this.eUh.bke();
                            }
                            if (f.this.eQX != null) {
                                f.this.eQX.setCanVisible(true);
                            }
                            if (f.this.eUi != null) {
                                f.this.eUi.setVisibility(0);
                            }
                            f.this.bkg().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bkh();
                        }
                    });
                    this.eUe.e(bkg().rootView);
                }
                this.eUc.a((j.c) this.eUe);
                this.eUc.a((j.k) this.eUe);
                if (this.eUc.qa() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.eUi.setVisibility(0);
                }
                if (this.eQX != null && this.eQX.getRootView() != null) {
                    if (this.eQX.pJ()) {
                        this.eQX.setVisible(0);
                        this.eUi.setVisibility(8);
                    } else {
                        this.eQX.setVisible(4);
                    }
                }
                if (z3 && !this.eUg) {
                    this.eUg = true;
                    this.eUc.a(this.eUj.faP.mChallengeData);
                    if (this.eUj.faP.mAvtsData != null) {
                        a(this.eUj.faP.mAvtsData, this.eUj.faP.mAvtsConfigInfo);
                        this.eUi.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.eUc != null) {
            this.eUc.av(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkh() {
        bkg().blN();
        bkg().blP();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.zg().f(true, false);
        bkg().faI.switchToCommonMode(f.getWidth(), f.getHeight());
        bkg().blQ();
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
            bkg().blP();
            bkg().faI.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.zg().f(true, true);
            bkg().faI.switchToRtcMode(f.getWidth(), f.getHeight());
            bkg().blQ();
        }
    }

    public void bki() {
        if (this.eUf != null) {
            this.eUf.hide();
        }
        if (this.eUd != null) {
            this.eUd.b(bkg().rootView, true);
        }
    }

    public void a(m mVar) {
        if (this.eUe != null) {
            this.eUe.a(mVar);
        }
        if (this.eQX != null) {
            this.eQX.b(mVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.eUf != null && this.eUf.pN()) {
            this.eUf.J(imageView);
        }
    }

    public void bkj() {
        if (this.eUf != null) {
            this.eUf.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.eUd != null && this.eUd.isActive() && this.eUd.onBackKeyDown();
    }

    public void bkk() {
        if (this.eUc != null) {
            this.eUc.pK();
            this.eUc.onDestroy();
        }
        if (this.eQX != null) {
            this.eQX.pK();
            this.eQX.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.eUe != null) {
            this.eUe.pT();
        }
    }

    public void onDestroy() {
        if (this.eUe != null) {
            this.eUe.onDestroy();
        }
        if (this.eUf != null) {
            this.eUf.hide();
        }
        if (this.eUd != null) {
            this.eUd.removeView();
        }
    }

    public boolean bkl() {
        return this.eUe != null && this.eUe.isActive();
    }

    public int au(boolean z) {
        if (this.eUe != null) {
            return this.eUe.au(z);
        }
        return 0;
    }

    public boolean bkm() {
        return this.eQX != null && this.eQX.pJ();
    }

    public void cU(String str) {
        if (this.eUc != null) {
            this.eUc.cU(str);
        }
    }

    public void C(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bkg().blM() != 2 && com.baidu.live.v.a.zl().awB.ZU) {
            if (this.eQX == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bkg().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eQX = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eQX != null) {
                this.eQX.a(bkg().fai.bpS(), true, z2);
                this.eQX.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.eQX.getRootView() != null && this.eQX.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.eQX.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bkg().faj.addView(this.eQX.getRootView(), layoutParams);
                }
                this.eQX.a(null, bkg().fai.yO());
                if (this.eUj != null && this.eUj.faP != null && this.eUj.faP.mPkData != null) {
                    this.eQX.bi(this.eUj.faP.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.eUh = eVar;
    }
}

package com.baidu.tieba.ala.liveroom.challenge;

import android.view.KeyEvent;
import android.view.View;
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
import com.baidu.live.challenge.l;
import com.baidu.live.d.a;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.q;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes3.dex */
public class f {
    private com.baidu.live.d.a fKo;
    private com.baidu.live.challenge.f fMC;
    private i fNA;
    private com.baidu.live.challenge.e fNB;
    private boolean fNC = false;
    private e fND;
    private ImageView fNE;
    private g fNF;
    private com.baidu.tieba.ala.liveroom.data.f fNw;
    private com.baidu.live.challenge.g fNx;
    private j fNy;
    private k fNz;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.fNw = fVar;
    }

    public void a(ImageView imageView, g gVar) {
        this.fNE = imageView;
        this.fNF = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f bzF() {
        return this.fNw;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bzF().bBi() != 2 && z2) {
            if (this.fMC == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bzF().pageContext)) != null && runTask2.getData() != null) {
                this.fMC = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.fNx == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.g.class, bzF().pageContext)) != null && runTask.getData() != null) {
                this.fNx = (com.baidu.live.challenge.g) runTask.getData();
            }
            if (this.fMC != null && this.fNx != null) {
                if (this.fNy == null) {
                    this.fNy = this.fMC.a(bzF().pageContext);
                    this.fNy.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bI(int i) {
                            if (f.this.fNz != null) {
                                f.this.fNz.bF(i);
                                if (f.this.fNB == null) {
                                    f.this.fNB = f.this.fNx.vr();
                                    f.this.fNB.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.fNB.hide();
                                            f.this.fNB.aT(false);
                                            if (f.this.fNz != null) {
                                                f.this.fNz.b(f.this.bzF().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.fNB.bF(i);
                                if (!f.this.fNz.isActive()) {
                                    f.this.fNB.I(f.this.fNE);
                                }
                            }
                        }
                    });
                    this.fNy.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int vG() {
                            return f.this.bzF().fTM.getRtcStreamStatus();
                        }
                    });
                    this.fNy.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.c
                        public void b(ak akVar, al alVar, al alVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void c(ak akVar, al alVar, al alVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void d(ak akVar, al alVar, al alVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void e(ak akVar, al alVar, al alVar2) {
                            f.this.bzG();
                            f.this.fNE.setVisibility(0);
                        }
                    });
                }
                if (this.fNz == null) {
                    this.fNz = this.fNx.vq();
                    this.fNz.eo(bzF().fTm.Fk().avj.portrait);
                    this.fNz.a(this.fNy);
                    this.fNz.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void vI() {
                            f.this.fNz.removeView();
                            if (f.this.fKo != null && f.this.fKo.getRootView() != null) {
                                f.this.fKo.setVisible(0);
                                f.this.fKo.vn();
                                f.this.fNE.setVisibility(8);
                            }
                            if (f.this.fND != null) {
                                f.this.fND.bzE();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void vJ() {
                            f.this.fNE.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.aui, aVar.auj);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void vK() {
                            if (f.this.fNB != null) {
                                f.this.fNB.aT(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void vL() {
                            if (f.this.fNB != null && !f.this.fNB.isShowing() && f.this.fNB.vp()) {
                                f.this.fNB.I(f.this.fNE);
                            }
                        }
                    });
                }
                this.fNy.e(bzF().fTm.Fk().mLiveInfo.live_id, bzF().fTm.Fk().avj.userId);
                this.fNy.a((j.InterfaceC0157j) this.fNz);
                this.fNy.a((j.a) this.fNz);
                this.fNy.a((j.d) this.fNz);
                this.fNy.a((j.i) this.fNz);
                this.fNy.a((j.h) this.fNz);
                this.fNy.a((j.g) this.fNz);
                this.fNy.a((j.f) this.fNz);
                this.fNy.a((j.c) this.fNz);
                this.fNy.setIsHost(bzF().fTm.Fk().isHost);
                if (this.fNA == null) {
                    this.fNA = this.fMC.b(bzF().pageContext);
                    this.fNA.b(false, true, z3);
                    this.fNA.a(this.fNy);
                    this.fNA.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void vs() {
                            f.this.bzF().fTn.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ak akVar, al alVar, al alVar2) {
                            if (f.this.fND != null) {
                                f.this.fND.a(akVar, alVar, alVar2);
                            }
                            if (f.this.fKo != null) {
                                f.this.fKo.setCanVisible(false);
                                f.this.fKo.setVisible(8);
                            }
                            f.this.bzF().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bzF().bBj();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void vt() {
                            f.this.bzF().aKz();
                            if (f.this.fND != null) {
                                f.this.fND.vt();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void vu() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aU(boolean z4) {
                            if (f.this.fND != null) {
                                f.this.fND.bzD();
                            }
                            if (f.this.fKo != null) {
                                f.this.fKo.setCanVisible(true);
                            }
                            if (f.this.fNE != null) {
                                f.this.fNE.setVisibility(0);
                            }
                            f.this.bzF().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bzG();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aV(boolean z4) {
                        }
                    });
                    this.fNA.j(bzF().rootView);
                }
                this.fNy.a((j.c) this.fNA);
                this.fNy.a((j.k) this.fNA);
                if (this.fNy.vC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.fNE.setVisibility(0);
                }
                if (this.fKo != null && this.fKo.getRootView() != null) {
                    if (this.fKo.vl()) {
                        this.fKo.setVisible(0);
                        this.fNE.setVisibility(8);
                    } else {
                        this.fKo.setVisible(4);
                    }
                }
                if (z3 && !this.fNC) {
                    this.fNC = true;
                    this.fNy.a(this.fNF.fTT.mChallengeData);
                    if (this.fNF.fTT.mAvtsData != null) {
                        a(this.fNF.fTT.mAvtsData, this.fNF.fTT.mAvtsConfigInfo);
                        this.fNE.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.fNy != null) {
            this.fNy.aX(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzG() {
        bzF().Jh();
        bzF().bBk();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.FX().f(true, false);
        bzF().fTM.switchToCommonMode(f.getWidth(), f.getHeight());
        bzF().bBl();
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
            bzF().bBk();
            bzF().fTM.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.FX().f(true, true);
            bzF().fTM.switchToRtcMode(f.getWidth(), f.getHeight());
            bzF().bBl();
        }
    }

    public void bzH() {
        if (this.fNB != null) {
            this.fNB.hide();
        }
        if (this.fNz != null) {
            this.fNz.b(bzF().rootView, true);
        }
    }

    public void a(q qVar) {
        if (this.fNA != null) {
            this.fNA.a(qVar);
        }
        if (this.fKo != null) {
            this.fKo.b(qVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.fNB != null && this.fNB.vp()) {
            this.fNB.I(imageView);
        }
    }

    public void Ji() {
        if (this.fNB != null) {
            this.fNB.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.fNz != null && this.fNz.isActive() && this.fNz.onBackKeyDown();
    }

    public void bzI() {
        if (this.fNy != null) {
            this.fNy.vm();
            this.fNy.onDestroy();
        }
        if (this.fKo != null) {
            this.fKo.vm();
            this.fKo.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fNA != null) {
            this.fNA.vv();
        }
    }

    public void onDestroy() {
        if (this.fNA != null) {
            this.fNA.onDestroy();
        }
        if (this.fNB != null) {
            this.fNB.hide();
        }
        if (this.fNz != null) {
            this.fNz.removeView();
        }
    }

    public boolean bzJ() {
        return this.fNA != null && this.fNA.isActive();
    }

    public int aW(boolean z) {
        if (this.fNA != null) {
            return this.fNA.aW(z);
        }
        return 0;
    }

    public boolean bzK() {
        return this.fKo != null && this.fKo.vl();
    }

    public void en(String str) {
        if (this.fNy != null) {
            this.fNy.en(str);
        }
    }

    public void F(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bzF().bBi() != 2 && com.baidu.live.v.a.Ge().aWF.axA) {
            if (this.fKo == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bzF().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fKo = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fKo != null) {
                this.fKo.a(bzF().fTm.bFz(), true, z2);
                this.fKo.a(new a.InterfaceC0158a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.fKo.getRootView() != null && this.fKo.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.fKo.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bzF().fTn.addView(this.fKo.getRootView(), layoutParams);
                }
                this.fKo.a(null, bzF().fTm.Fk());
                if (this.fNF != null && this.fNF.fTT != null && this.fNF.fTT.mPkData != null) {
                    this.fKo.bE(this.fNF.fTT.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.fND = eVar;
    }
}

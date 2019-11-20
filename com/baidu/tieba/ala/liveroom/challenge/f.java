package com.baidu.tieba.ala.liveroom.challenge;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.c.a;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.g;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.challenge.k;
import com.baidu.live.challenge.l;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
/* loaded from: classes6.dex */
public class f {
    private com.baidu.live.c.a dWa;
    private com.baidu.live.challenge.f dXK;
    private com.baidu.tieba.ala.liveroom.data.e dYK;
    private g dYL;
    private j dYM;
    private k dYN;
    private i dYO;
    private com.baidu.live.challenge.e dYP;
    private boolean dYQ = false;
    private e dYR;
    private ImageView dYS;
    private com.baidu.tieba.ala.liveroom.data.f dYT;

    public f(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.dYK = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.dYS = imageView;
        this.dYT = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e aPZ() {
        return this.dYK;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && aPZ().aRJ() != 2 && z2) {
            if (this.dXK == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, aPZ().pageContext)) != null && runTask2.getData() != null) {
                this.dXK = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.dYL == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, aPZ().pageContext)) != null && runTask.getData() != null) {
                this.dYL = (g) runTask.getData();
            }
            if (this.dXK != null && this.dYL != null) {
                if (this.dYM == null) {
                    this.dYM = this.dXK.a(aPZ().pageContext);
                    this.dYM.a(new j.d() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.d
                        public void aU(int i) {
                            if (f.this.dYN != null) {
                                f.this.dYN.aR(i);
                                if (f.this.dYP == null) {
                                    f.this.dYP = f.this.dYL.nF();
                                    f.this.dYP.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.dYP.hide();
                                            f.this.dYP.ae(false);
                                            if (f.this.dYN != null) {
                                                f.this.dYN.b(f.this.aPZ().AE, true);
                                            }
                                        }
                                    });
                                }
                                f.this.dYP.aR(i);
                                if (!f.this.dYN.isActive()) {
                                    f.this.dYP.I(f.this.dYS);
                                }
                            }
                        }
                    });
                    this.dYM.a(new j.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.g
                        public int nY() {
                            return f.this.aPZ().efe.getRtcStreamStatus();
                        }
                    });
                    this.dYM.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.e
                        public void b(v vVar, w wVar, w wVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.e
                        public void c(v vVar, w wVar, w wVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.e
                        public void d(v vVar, w wVar, w wVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.e
                        public void e(v vVar, w wVar, w wVar2) {
                            f.this.aQa();
                            f.this.dYS.setVisibility(0);
                        }
                    });
                }
                if (this.dYN == null) {
                    this.dYN = this.dYL.nE();
                    this.dYN.bU(aPZ().eeL.uk().OR.portrait);
                    this.dYN.a(this.dYM);
                    this.dYN.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void nZ() {
                            f.this.dYN.removeView();
                            if (f.this.dWa != null && f.this.dWa.getRootView() != null) {
                                f.this.dWa.setVisible(0);
                                f.this.dWa.nB();
                                f.this.dYS.setVisibility(8);
                            }
                            if (f.this.dYR != null) {
                                f.this.dYR.aPY();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void oa() {
                            f.this.dYS.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.Oc, aVar.Od);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void ob() {
                            if (f.this.dYP != null) {
                                f.this.dYP.ae(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void oc() {
                            if (f.this.dYP != null && !f.this.dYP.isShowing() && f.this.dYP.nD()) {
                                f.this.dYP.I(f.this.dYS);
                            }
                        }
                    });
                }
                this.dYM.d(aPZ().eeL.uk().mLiveInfo.live_id, aPZ().eeL.uk().OR.userId);
                this.dYM.a((j.a) this.dYN);
                this.dYM.a((j.f) this.dYN);
                this.dYM.a((j.k) this.dYN);
                this.dYM.a((j.InterfaceC0058j) this.dYN);
                this.dYM.a((j.i) this.dYN);
                this.dYM.a((j.h) this.dYN);
                this.dYM.a((j.e) this.dYN);
                if (this.dYO == null) {
                    this.dYO = this.dXK.b(aPZ().pageContext);
                    this.dYO.b(false, true, z3);
                    this.dYO.a(this.dYM);
                    this.dYO.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void nG() {
                            f.this.aPZ().eeM.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(v vVar, w wVar, w wVar2) {
                            if (f.this.dYR != null) {
                                f.this.dYR.a(vVar, wVar, wVar2);
                            }
                            if (f.this.dWa != null) {
                                f.this.dWa.setCanVisible(false);
                                f.this.dWa.setVisible(8);
                            }
                            f.this.aPZ().AE.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.aPZ().aRM();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void nH() {
                            f.this.aPZ().aRL();
                            if (f.this.dYR != null) {
                                f.this.dYR.nH();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void nI() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void af(boolean z4) {
                            if (f.this.dYR != null) {
                                f.this.dYR.aPX();
                            }
                            if (f.this.dWa != null) {
                                f.this.dWa.setCanVisible(true);
                            }
                            if (f.this.dYS != null) {
                                f.this.dYS.setVisibility(0);
                            }
                            f.this.aPZ().AE.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.aQa();
                        }
                    });
                    this.dYO.e(aPZ().AE);
                }
                this.dYM.a((j.e) this.dYO);
                this.dYM.a((j.b) this.dYO);
                this.dYM.a((j.c) this.dYO);
                this.dYM.a((j.l) this.dYO);
                if (this.dYM.nP() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.dYS.setVisibility(0);
                }
                if (this.dWa != null && this.dWa.getRootView() != null) {
                    if (this.dWa.nz()) {
                        this.dWa.setVisible(0);
                        this.dYS.setVisibility(8);
                    } else {
                        this.dWa.setVisible(4);
                    }
                }
                if (z3 && !this.dYQ) {
                    this.dYQ = true;
                    this.dYM.a(this.dYT.efi.mChallengeData);
                    if (this.dYT.efi.mAvtsData != null) {
                        a(this.dYT.efi.mAvtsData, this.dYT.efi.mAvtsConfigInfo);
                        this.dYS.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.dYM != null) {
            this.dYM.ag(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQa() {
        aPZ().aRK();
        aPZ().aRN();
        AlaLiveRecordConfigHelper.VideoResolution hJ = AlaLiveRecordConfigHelper.aRu().hJ(false);
        aPZ().efe.switchToCommonMode(hJ.getWidth(), hJ.getHeight());
        aPZ().aRO();
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
            aPZ().aRN();
            aPZ().efe.setRtcConfig(alaLiveRtcConfig);
            AlaLiveRecordConfigHelper.VideoResolution hJ = AlaLiveRecordConfigHelper.aRu().hJ(true);
            aPZ().efe.switchToRtcMode(hJ.getWidth(), hJ.getHeight());
            aPZ().aRO();
        }
    }

    public void aQb() {
        if (this.dYP != null) {
            this.dYP.hide();
        }
        if (this.dYN != null) {
            this.dYN.b(aPZ().AE, true);
        }
    }

    public void b(com.baidu.live.data.i iVar) {
        if (this.dYO != null) {
            this.dYO.b(iVar);
        }
        if (this.dWa != null) {
            this.dWa.a(iVar);
        }
    }

    public void a(ImageView imageView) {
        if (this.dYP != null && this.dYP.nD()) {
            this.dYP.I(imageView);
        }
    }

    public void aQc() {
        if (this.dYP != null) {
            this.dYP.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.dYN != null && this.dYN.isActive() && this.dYN.onBackKeyDown();
    }

    public void aQd() {
        if (this.dYM != null) {
            this.dYM.nA();
            this.dYM.onDestroy();
        }
        if (this.dWa != null) {
            this.dWa.nA();
            this.dWa.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.dYO != null) {
            this.dYO.nJ();
        }
    }

    public void onDestroy() {
        if (this.dYO != null) {
            this.dYO.onDestroy();
        }
        if (this.dYP != null) {
            this.dYP.hide();
        }
        if (this.dYN != null) {
            this.dYN.removeView();
        }
    }

    public boolean aQe() {
        return this.dYO != null && this.dYO.isActive();
    }

    public boolean aQf() {
        return this.dWa != null && this.dWa.nz();
    }

    public void bT(String str) {
        if (this.dYM != null) {
            this.dYM.bT(str);
        }
    }

    public void B(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && aPZ().aRJ() != 2 && com.baidu.live.l.a.uB().ajF.QW) {
            if (this.dWa == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.c.a.class, aPZ().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.c.a)) {
                this.dWa = (com.baidu.live.c.a) runTask.getData();
            }
            if (this.dWa != null) {
                this.dWa.a(aPZ().eeL.aVm(), true, z2);
                this.dWa.a(new a.InterfaceC0057a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.dWa.getRootView() != null && this.dWa.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.dWa.getRootView().setId(a.g.ala_live_room_pk_panel);
                    aPZ().eeM.addView(this.dWa.getRootView(), layoutParams);
                }
                this.dWa.a(null, aPZ().eeL.uk());
                if (this.dYT != null && this.dYT.efi != null && this.dYT.efi.mPkData != null) {
                    this.dWa.aQ(this.dYT.efi.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.dYR = eVar;
    }
}

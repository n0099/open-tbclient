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
    private com.baidu.live.c.a dWR;
    private com.baidu.live.challenge.f dYB;
    private com.baidu.tieba.ala.liveroom.data.e dZB;
    private g dZC;
    private j dZD;
    private k dZE;
    private i dZF;
    private com.baidu.live.challenge.e dZG;
    private boolean dZH = false;
    private e dZI;
    private ImageView dZJ;
    private com.baidu.tieba.ala.liveroom.data.f dZK;

    public f(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.dZB = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.dZJ = imageView;
        this.dZK = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e aQb() {
        return this.dZB;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && aQb().aRL() != 2 && z2) {
            if (this.dYB == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, aQb().pageContext)) != null && runTask2.getData() != null) {
                this.dYB = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.dZC == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, aQb().pageContext)) != null && runTask.getData() != null) {
                this.dZC = (g) runTask.getData();
            }
            if (this.dYB != null && this.dZC != null) {
                if (this.dZD == null) {
                    this.dZD = this.dYB.a(aQb().pageContext);
                    this.dZD.a(new j.d() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.d
                        public void aU(int i) {
                            if (f.this.dZE != null) {
                                f.this.dZE.aR(i);
                                if (f.this.dZG == null) {
                                    f.this.dZG = f.this.dZC.nF();
                                    f.this.dZG.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.dZG.hide();
                                            f.this.dZG.ae(false);
                                            if (f.this.dZE != null) {
                                                f.this.dZE.b(f.this.aQb().Bg, true);
                                            }
                                        }
                                    });
                                }
                                f.this.dZG.aR(i);
                                if (!f.this.dZE.isActive()) {
                                    f.this.dZG.I(f.this.dZJ);
                                }
                            }
                        }
                    });
                    this.dZD.a(new j.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.g
                        public int nY() {
                            return f.this.aQb().efV.getRtcStreamStatus();
                        }
                    });
                    this.dZD.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
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
                            f.this.aQc();
                            f.this.dZJ.setVisibility(0);
                        }
                    });
                }
                if (this.dZE == null) {
                    this.dZE = this.dZC.nE();
                    this.dZE.bU(aQb().efC.uj().Ps.portrait);
                    this.dZE.a(this.dZD);
                    this.dZE.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void nZ() {
                            f.this.dZE.removeView();
                            if (f.this.dWR != null && f.this.dWR.getRootView() != null) {
                                f.this.dWR.setVisible(0);
                                f.this.dWR.nB();
                                f.this.dZJ.setVisibility(8);
                            }
                            if (f.this.dZI != null) {
                                f.this.dZI.aQa();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void oa() {
                            f.this.dZJ.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.OC, aVar.OD);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void ob() {
                            if (f.this.dZG != null) {
                                f.this.dZG.ae(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void oc() {
                            if (f.this.dZG != null && !f.this.dZG.isShowing() && f.this.dZG.nD()) {
                                f.this.dZG.I(f.this.dZJ);
                            }
                        }
                    });
                }
                this.dZD.d(aQb().efC.uj().mLiveInfo.live_id, aQb().efC.uj().Ps.userId);
                this.dZD.a((j.a) this.dZE);
                this.dZD.a((j.f) this.dZE);
                this.dZD.a((j.k) this.dZE);
                this.dZD.a((j.InterfaceC0058j) this.dZE);
                this.dZD.a((j.i) this.dZE);
                this.dZD.a((j.h) this.dZE);
                this.dZD.a((j.e) this.dZE);
                if (this.dZF == null) {
                    this.dZF = this.dYB.b(aQb().pageContext);
                    this.dZF.b(false, true, z3);
                    this.dZF.a(this.dZD);
                    this.dZF.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void nG() {
                            f.this.aQb().efD.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(v vVar, w wVar, w wVar2) {
                            if (f.this.dZI != null) {
                                f.this.dZI.a(vVar, wVar, wVar2);
                            }
                            if (f.this.dWR != null) {
                                f.this.dWR.setCanVisible(false);
                                f.this.dWR.setVisible(8);
                            }
                            f.this.aQb().Bg.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.aQb().aRO();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void nH() {
                            f.this.aQb().aRN();
                            if (f.this.dZI != null) {
                                f.this.dZI.nH();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void nI() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void af(boolean z4) {
                            if (f.this.dZI != null) {
                                f.this.dZI.aPZ();
                            }
                            if (f.this.dWR != null) {
                                f.this.dWR.setCanVisible(true);
                            }
                            if (f.this.dZJ != null) {
                                f.this.dZJ.setVisibility(0);
                            }
                            f.this.aQb().Bg.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.aQc();
                        }
                    });
                    this.dZF.e(aQb().Bg);
                }
                this.dZD.a((j.e) this.dZF);
                this.dZD.a((j.b) this.dZF);
                this.dZD.a((j.c) this.dZF);
                this.dZD.a((j.l) this.dZF);
                if (this.dZD.nP() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.dZJ.setVisibility(0);
                }
                if (this.dWR != null && this.dWR.getRootView() != null) {
                    if (this.dWR.nz()) {
                        this.dWR.setVisible(0);
                        this.dZJ.setVisibility(8);
                    } else {
                        this.dWR.setVisible(4);
                    }
                }
                if (z3 && !this.dZH) {
                    this.dZH = true;
                    this.dZD.a(this.dZK.efZ.mChallengeData);
                    if (this.dZK.efZ.mAvtsData != null) {
                        a(this.dZK.efZ.mAvtsData, this.dZK.efZ.mAvtsConfigInfo);
                        this.dZJ.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.dZD != null) {
            this.dZD.ag(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQc() {
        aQb().aRM();
        aQb().aRP();
        AlaLiveRecordConfigHelper.VideoResolution hJ = AlaLiveRecordConfigHelper.aRw().hJ(false);
        aQb().efV.switchToCommonMode(hJ.getWidth(), hJ.getHeight());
        aQb().aRQ();
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
            aQb().aRP();
            aQb().efV.setRtcConfig(alaLiveRtcConfig);
            AlaLiveRecordConfigHelper.VideoResolution hJ = AlaLiveRecordConfigHelper.aRw().hJ(true);
            aQb().efV.switchToRtcMode(hJ.getWidth(), hJ.getHeight());
            aQb().aRQ();
        }
    }

    public void aQd() {
        if (this.dZG != null) {
            this.dZG.hide();
        }
        if (this.dZE != null) {
            this.dZE.b(aQb().Bg, true);
        }
    }

    public void b(com.baidu.live.data.i iVar) {
        if (this.dZF != null) {
            this.dZF.b(iVar);
        }
        if (this.dWR != null) {
            this.dWR.a(iVar);
        }
    }

    public void a(ImageView imageView) {
        if (this.dZG != null && this.dZG.nD()) {
            this.dZG.I(imageView);
        }
    }

    public void aQe() {
        if (this.dZG != null) {
            this.dZG.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.dZE != null && this.dZE.isActive() && this.dZE.onBackKeyDown();
    }

    public void aQf() {
        if (this.dZD != null) {
            this.dZD.nA();
            this.dZD.onDestroy();
        }
        if (this.dWR != null) {
            this.dWR.nA();
            this.dWR.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.dZF != null) {
            this.dZF.nJ();
        }
    }

    public void onDestroy() {
        if (this.dZF != null) {
            this.dZF.onDestroy();
        }
        if (this.dZG != null) {
            this.dZG.hide();
        }
        if (this.dZE != null) {
            this.dZE.removeView();
        }
    }

    public boolean aQg() {
        return this.dZF != null && this.dZF.isActive();
    }

    public boolean aQh() {
        return this.dWR != null && this.dWR.nz();
    }

    public void bT(String str) {
        if (this.dZD != null) {
            this.dZD.bT(str);
        }
    }

    public void B(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && aQb().aRL() != 2 && com.baidu.live.l.a.uA().ajX.Rw) {
            if (this.dWR == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.c.a.class, aQb().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.c.a)) {
                this.dWR = (com.baidu.live.c.a) runTask.getData();
            }
            if (this.dWR != null) {
                this.dWR.a(aQb().efC.aVo(), true, z2);
                this.dWR.a(new a.InterfaceC0057a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.dWR.getRootView() != null && this.dWR.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.dWR.getRootView().setId(a.g.ala_live_room_pk_panel);
                    aQb().efD.addView(this.dWR.getRootView(), layoutParams);
                }
                this.dWR.a(null, aQb().efC.uj());
                if (this.dZK != null && this.dZK.efZ != null && this.dZK.efZ.mPkData != null) {
                    this.dWR.aQ(this.dZK.efZ.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.dZI = eVar;
    }
}

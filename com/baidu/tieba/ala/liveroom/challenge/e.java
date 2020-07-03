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
import com.baidu.live.data.am;
import com.baidu.live.data.aq;
import com.baidu.live.data.q;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.live.d.a fVm;
    private com.baidu.live.challenge.e fXA;
    private f fYL;
    private com.baidu.live.challenge.f fYM;
    private i fYN;
    private j fYO;
    private h fYP;
    private boolean fYQ = false;
    private d fYR;
    private ImageView fYS;
    private g fYT;

    public e(f fVar) {
        this.fYL = fVar;
    }

    public void a(ImageView imageView, g gVar) {
        this.fYS = imageView;
        this.fYT = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f bCw() {
        return this.fYL;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bCw().bEk() != 2 && z2) {
            if (this.fXA == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bCw().pageContext)) != null && runTask2.getData() != null) {
                this.fXA = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.fYM == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, bCw().pageContext)) != null && runTask.getData() != null) {
                this.fYM = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.fXA != null && this.fYM != null) {
                if (this.fYN == null) {
                    this.fYN = this.fXA.a(bCw().pageContext);
                    this.fYN.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void bN(int i) {
                            if (e.this.fYO != null) {
                                e.this.fYO.bO(i);
                            }
                        }
                    });
                    this.fYN.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int wa() {
                            return e.this.bCw().ggs.getRtcStreamStatus();
                        }
                    });
                    this.fYN.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(am amVar, aq aqVar, aq aqVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(am amVar, aq aqVar, aq aqVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(am amVar, aq aqVar, aq aqVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(am amVar, aq aqVar, aq aqVar2) {
                            e.this.bCx();
                            e.this.fYS.setVisibility(0);
                        }
                    });
                }
                if (this.fYO == null) {
                    this.fYO = this.fYM.vK();
                    this.fYO.setUserId(String.valueOf(bCw().gfS.FU().axp.userId));
                    this.fYO.es(bCw().gfS.FU().axp.portrait);
                    this.fYO.a(this.fYN);
                    this.fYO.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void wc() {
                            e.this.fYO.removeView();
                            if (e.this.fVm != null && e.this.fVm.getRootView() != null) {
                                e.this.fVm.setVisible(0);
                                e.this.fVm.vI();
                                e.this.fYS.setVisibility(8);
                            }
                            if (e.this.fYR != null) {
                                e.this.fYR.bCv();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void wd() {
                            e.this.fYS.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.awk, aVar.awl);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void we() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void wf() {
                        }
                    });
                }
                this.fYN.e(bCw().gfS.FU().mLiveInfo.live_id, bCw().gfS.FU().axp.userId);
                this.fYN.a((i.l) this.fYO);
                this.fYN.a((i.a) this.fYO);
                this.fYN.a((i.e) this.fYO);
                this.fYN.a((i.j) this.fYO);
                this.fYN.a((i.InterfaceC0159i) this.fYO);
                this.fYN.a((i.k) this.fYO);
                this.fYN.a((i.h) this.fYO);
                this.fYN.a((i.g) this.fYO);
                this.fYN.a((i.c) this.fYO);
                this.fYN.setIsHost(bCw().gfS.FU().isHost);
                if (this.fYP == null) {
                    this.fYP = this.fXA.b(bCw().pageContext);
                    this.fYP.b(false, true, z3);
                    this.fYP.a(this.fYN);
                    this.fYP.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void vL() {
                            e.this.bCw().gfT.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(am amVar, aq aqVar, aq aqVar2) {
                            if (e.this.fYR != null) {
                                e.this.fYR.a(amVar, aqVar, aqVar2);
                            }
                            if (e.this.fVm != null) {
                                e.this.fVm.setCanVisible(false);
                                e.this.fVm.setVisible(8);
                            }
                            e.this.bCw().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            e.this.bCw().bEl();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void vM() {
                            e.this.bCw().aLF();
                            if (e.this.fYR != null) {
                                e.this.fYR.vM();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void vN() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void aU(boolean z4) {
                            if (e.this.fYR != null) {
                                e.this.fYR.bCu();
                            }
                            if (e.this.fVm != null) {
                                e.this.fVm.setCanVisible(true);
                            }
                            if (e.this.fYS != null) {
                                e.this.fYS.setVisibility(0);
                            }
                            e.this.bCw().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            e.this.bCx();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void aV(boolean z4) {
                        }
                    });
                    this.fYP.j(bCw().ggu);
                }
                this.fYN.a((i.c) this.fYP);
                this.fYN.a((i.m) this.fYP);
                this.fYN.a((i.d) this.fYP);
                if (this.fYN.vV() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.fYS.setVisibility(0);
                }
                if (this.fVm != null && this.fVm.getRootView() != null) {
                    if (this.fVm.vG()) {
                        this.fVm.setVisible(0);
                        this.fYS.setVisibility(8);
                    } else {
                        this.fVm.setVisible(4);
                    }
                }
                if (z3 && !this.fYQ) {
                    this.fYQ = true;
                    this.fYN.a(this.fYT.ggA.mChallengeData);
                    if (this.fYT.ggA.mAvtsData != null) {
                        a(this.fYT.ggA.mAvtsData, this.fYT.ggA.mAvtsConfigInfo);
                        this.fYS.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.fYN != null) {
            this.fYN.aX(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCx() {
        bCw().Ku();
        bCw().bEm();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GG().f(true, false);
        bCw().ggs.switchToCommonMode(f.getWidth(), f.getHeight());
        bCw().bEn();
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
            bCw().bEm();
            bCw().ggs.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GG().f(true, true);
            bCw().ggs.switchToRtcMode(f.getWidth(), f.getHeight());
            bCw().bEn();
        }
    }

    public void bCy() {
        if (this.fYO != null) {
            this.fYO.b(bCw().ggu, true);
        }
    }

    public void a(q qVar) {
        if (this.fYP != null) {
            this.fYP.a(qVar);
        }
        if (this.fVm != null) {
            this.fVm.b(qVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.fYO != null && this.fYO.isActive() && this.fYO.onBackKeyDown();
    }

    public void bCz() {
        if (this.fYN != null) {
            this.fYN.vH();
            this.fYN.onDestroy();
        }
        if (this.fVm != null) {
            this.fVm.vH();
            this.fVm.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fYP != null) {
            this.fYP.vO();
        }
    }

    public void onDestroy() {
        if (this.fYP != null) {
            this.fYP.onDestroy();
        }
        if (this.fYO != null) {
            this.fYO.removeView();
        }
    }

    public boolean bCA() {
        return this.fYP != null && this.fYP.isActive();
    }

    public int aW(boolean z) {
        if (this.fYP != null) {
            return this.fYP.aW(z);
        }
        return 0;
    }

    public boolean bCB() {
        return this.fVm != null && this.fVm.vG();
    }

    public void eq(String str) {
        if (this.fYN != null) {
            this.fYN.eq(str);
        }
    }

    public void G(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bCw().bEk() != 2 && com.baidu.live.v.a.Hm().aZp.azJ) {
            if (this.fVm == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bCw().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fVm = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fVm != null) {
                this.fVm.a(bCw().gfS.bIF(), true, z2);
                this.fVm.a(new a.InterfaceC0160a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.fVm.getRootView() != null && this.fVm.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.fVm.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bCw().gfT.addView(this.fVm.getRootView(), layoutParams);
                }
                this.fVm.a(null, bCw().gfS.FU());
                if (this.fYT != null && this.fYT.ggA != null && this.fYT.ggA.mPkData != null) {
                    this.fVm.bK(this.fYT.ggA.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.fYR = dVar;
    }

    public int bCh() {
        int i = 0;
        if (this.fYP != null) {
            i = this.fYP.aW(true);
        }
        return i + bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }
}

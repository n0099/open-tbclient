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
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.data.q;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.d.a gar;
    private com.baidu.live.challenge.e gcF;
    private f gdS;
    private com.baidu.live.challenge.f gdT;
    private i gdU;
    private j gdV;
    private h gdW;
    private boolean gdX = false;
    private d gdY;
    private ImageView gdZ;
    private g gea;

    public e(f fVar) {
        this.gdS = fVar;
    }

    public void a(ImageView imageView, g gVar) {
        this.gdZ = imageView;
        this.gea = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f bFI() {
        return this.gdS;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bFI().bHw() != 2 && z2) {
            if (this.gcF == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bFI().pageContext)) != null && runTask2.getData() != null) {
                this.gcF = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gdT == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, bFI().pageContext)) != null && runTask.getData() != null) {
                this.gdT = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.gcF != null && this.gdT != null) {
                if (this.gdU == null) {
                    this.gdU = this.gcF.a(bFI().pageContext);
                    this.gdU.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void bT(int i) {
                            if (e.this.gdV != null) {
                                e.this.gdV.bU(i);
                            }
                        }
                    });
                    this.gdU.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int ww() {
                            return e.this.bFI().glA.getRtcStreamStatus();
                        }
                    });
                    this.gdU.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(an anVar, ar arVar, ar arVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(an anVar, ar arVar, ar arVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(an anVar, ar arVar, ar arVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(an anVar, ar arVar, ar arVar2) {
                            e.this.bFJ();
                            e.this.gdZ.setVisibility(0);
                        }
                    });
                }
                if (this.gdV == null) {
                    this.gdV = this.gdT.wg();
                    this.gdV.setUserId(String.valueOf(bFI().gla.FO().ayC.userId));
                    this.gdV.es(bFI().gla.FO().ayC.portrait);
                    this.gdV.a(this.gdU);
                    this.gdV.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void wy() {
                            e.this.gdV.removeView();
                            if (e.this.gar != null && e.this.gar.getRootView() != null) {
                                e.this.gar.setVisible(0);
                                e.this.gar.we();
                                e.this.gdZ.setVisibility(8);
                            }
                            if (e.this.gdY != null) {
                                e.this.gdY.bFH();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void wz() {
                            e.this.gdZ.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.axp, aVar.axq);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void wA() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void wB() {
                        }
                    });
                }
                this.gdU.e(bFI().gla.FO().mLiveInfo.live_id, bFI().gla.FO().ayC.userId);
                this.gdU.a((i.l) this.gdV);
                this.gdU.a((i.a) this.gdV);
                this.gdU.a((i.e) this.gdV);
                this.gdU.a((i.j) this.gdV);
                this.gdU.a((i.InterfaceC0158i) this.gdV);
                this.gdU.a((i.k) this.gdV);
                this.gdU.a((i.h) this.gdV);
                this.gdU.a((i.g) this.gdV);
                this.gdU.a((i.c) this.gdV);
                this.gdU.setIsHost(bFI().gla.FO().isHost);
                if (this.gdW == null) {
                    this.gdW = this.gcF.b(bFI().pageContext);
                    this.gdW.b(false, true, z3);
                    this.gdW.a(this.gdU);
                    this.gdW.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void wh() {
                            e.this.bFI().glb.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(an anVar, ar arVar, ar arVar2) {
                            if (e.this.gdY != null) {
                                e.this.gdY.a(anVar, arVar, arVar2);
                            }
                            if (e.this.gar != null) {
                                e.this.gar.setCanVisible(false);
                                e.this.gar.setVisible(8);
                            }
                            e.this.bFI().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            e.this.bFI().bHx();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void wi() {
                            e.this.bFI().aPt();
                            if (e.this.gdY != null) {
                                e.this.gdY.wi();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void wj() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void aX(boolean z4) {
                            if (e.this.gdY != null) {
                                e.this.gdY.bFG();
                            }
                            if (e.this.gar != null) {
                                e.this.gar.setCanVisible(true);
                            }
                            if (e.this.gdZ != null) {
                                e.this.gdZ.setVisibility(0);
                            }
                            e.this.bFI().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            e.this.bFJ();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void aY(boolean z4) {
                        }
                    });
                    this.gdW.k(bFI().glC);
                }
                this.gdU.a((i.c) this.gdW);
                this.gdU.a((i.m) this.gdW);
                this.gdU.a((i.d) this.gdW);
                if (this.gdU.wr() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gdZ.setVisibility(0);
                }
                if (this.gar != null && this.gar.getRootView() != null) {
                    if (this.gar.wc()) {
                        this.gar.setVisible(0);
                        this.gdZ.setVisibility(8);
                    } else {
                        this.gar.setVisible(4);
                    }
                }
                if (z3 && !this.gdX) {
                    this.gdX = true;
                    this.gdU.a(this.gea.glI.mChallengeData);
                    if (this.gea.glI.mAvtsData != null) {
                        a(this.gea.glI.mAvtsData, this.gea.glI.mAvtsConfigInfo);
                        this.gdZ.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gdU != null) {
            this.gdU.ba(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFJ() {
        bFI().KB();
        bFI().bHy();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GN().f(true, false);
        bFI().glA.switchToCommonMode(f.getWidth(), f.getHeight());
        bFI().bHz();
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
            bFI().bHy();
            bFI().glA.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GN().f(true, true);
            bFI().glA.switchToRtcMode(f.getWidth(), f.getHeight());
            bFI().bHz();
        }
    }

    public void bFK() {
        if (this.gdV != null) {
            this.gdV.b(bFI().glC, true);
        }
    }

    public void a(q qVar) {
        if (this.gdW != null) {
            this.gdW.a(qVar);
        }
        if (this.gar != null) {
            this.gar.b(qVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gdV != null && this.gdV.isActive() && this.gdV.onBackKeyDown();
    }

    public void bFL() {
        if (this.gdU != null) {
            this.gdU.wd();
            this.gdU.onDestroy();
        }
        if (this.gar != null) {
            this.gar.wd();
            this.gar.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gdW != null) {
            this.gdW.wk();
        }
    }

    public void onDestroy() {
        if (this.gdW != null) {
            this.gdW.onDestroy();
        }
        if (this.gdV != null) {
            this.gdV.removeView();
        }
    }

    public boolean bFM() {
        return this.gdW != null && this.gdW.isActive();
    }

    public int aZ(boolean z) {
        if (this.gdW != null) {
            return this.gdW.aZ(z);
        }
        return 0;
    }

    public boolean bFN() {
        return this.gar != null && this.gar.wc();
    }

    public void eq(String str) {
        if (this.gdU != null) {
            this.gdU.eq(str);
        }
    }

    public void H(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bFI().bHw() != 2 && com.baidu.live.v.a.Hs().aZn.aAW) {
            if (this.gar == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bFI().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gar = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gar != null) {
                this.gar.a(bFI().gla.bLL(), true, z2);
                this.gar.a(new a.InterfaceC0159a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gar.getRootView() != null && this.gar.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.gar.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bFI().glb.addView(this.gar.getRootView(), layoutParams);
                }
                this.gar.a(null, bFI().gla.FO());
                if (this.gea != null && this.gea.glI != null && this.gea.glI.mPkData != null) {
                    this.gar.bQ(this.gea.glI.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gdY = dVar;
    }

    public int bFt() {
        int i = 0;
        if (this.gdW != null) {
            i = this.gdW.aZ(true);
        }
        return i + bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }
}

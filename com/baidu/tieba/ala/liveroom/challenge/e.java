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
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.data.r;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes7.dex */
public class e {
    private com.baidu.live.d.a gmt;
    private com.baidu.live.challenge.e goN;
    private f gqb;
    private com.baidu.live.challenge.f gqc;
    private i gqd;
    private j gqe;
    private h gqf;
    private boolean gqg = false;
    private d gqh;
    private ImageView gqi;
    private g gqj;

    public e(f fVar) {
        this.gqb = fVar;
    }

    public void a(ImageView imageView, g gVar) {
        this.gqi = imageView;
        this.gqj = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f bPn() {
        return this.gqb;
    }

    public void i(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bPn().bRa() != 2 && z2) {
            if (this.goN == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bPn().pageContext)) != null && runTask2.getData() != null) {
                this.goN = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gqc == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, bPn().pageContext)) != null && runTask.getData() != null) {
                this.gqc = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.goN != null && this.gqc != null) {
                if (this.gqd == null) {
                    this.gqd = this.goN.a(bPn().pageContext);
                    this.gqd.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void dF(int i) {
                            if (e.this.gqe != null) {
                                e.this.gqe.dG(i);
                            }
                        }
                    });
                    this.gqd.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int BU() {
                            return e.this.bPn().gxE.getRtcStreamStatus();
                        }
                    });
                    this.gqd.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(ap apVar, at atVar, at atVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(ap apVar, at atVar, at atVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(ap apVar, at atVar, at atVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(ap apVar, at atVar, at atVar2) {
                            e.this.bPo();
                            e.this.gqi.setVisibility(0);
                        }
                    });
                }
                if (this.gqe == null) {
                    this.gqe = this.gqc.BE();
                    this.gqe.setUserId(String.valueOf(bPn().gxe.LC().aDE.userId));
                    this.gqe.fK(bPn().gxe.LC().aDE.portrait);
                    this.gqe.a(this.gqd);
                    this.gqe.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void BW() {
                            e.this.gqe.removeView();
                            if (e.this.gmt != null && e.this.gmt.getRootView() != null) {
                                e.this.gmt.setVisible(0);
                                e.this.gmt.BC();
                                e.this.gqi.setVisibility(8);
                            }
                            if (e.this.gqh != null) {
                                e.this.gqh.bPm();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void BX() {
                            e.this.gqi.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aCr, aVar.aCs);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void BY() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void BZ() {
                        }
                    });
                }
                this.gqd.e(bPn().gxe.LC().mLiveInfo.live_id, bPn().gxe.LC().aDE.userId);
                this.gqd.a((i.l) this.gqe);
                this.gqd.a((i.a) this.gqe);
                this.gqd.a((i.e) this.gqe);
                this.gqd.a((i.j) this.gqe);
                this.gqd.a((i.InterfaceC0166i) this.gqe);
                this.gqd.a((i.k) this.gqe);
                this.gqd.a((i.h) this.gqe);
                this.gqd.a((i.g) this.gqe);
                this.gqd.a((i.c) this.gqe);
                this.gqd.setIsHost(bPn().gxe.LC().isHost);
                if (this.gqf == null) {
                    this.gqf = this.goN.b(bPn().pageContext);
                    this.gqf.b(false, true, z3);
                    this.gqf.a(this.gqd);
                    this.gqf.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void BF() {
                            e.this.bPn().gxf.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(ap apVar, at atVar, at atVar2) {
                            if (e.this.gqh != null) {
                                e.this.gqh.a(apVar, atVar, atVar2);
                            }
                            if (e.this.gmt != null) {
                                e.this.gmt.setCanVisible(false);
                                e.this.gmt.setVisible(8);
                            }
                            e.this.bPn().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            e.this.bPn().bRb();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void BG() {
                            e.this.bPn().aXJ();
                            if (e.this.gqh != null) {
                                e.this.gqh.BG();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void BH() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bc(boolean z4) {
                            if (e.this.gqh != null) {
                                e.this.gqh.bPl();
                            }
                            if (e.this.gmt != null) {
                                e.this.gmt.setCanVisible(true);
                            }
                            if (e.this.gqi != null) {
                                e.this.gqi.setVisibility(0);
                            }
                            e.this.bPn().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            e.this.bPo();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bd(boolean z4) {
                        }
                    });
                    this.gqf.l(bPn().gxG);
                }
                this.gqd.a((i.c) this.gqf);
                this.gqd.a((i.m) this.gqf);
                this.gqd.a((i.d) this.gqf);
                if (this.gqd.BP() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gqi.setVisibility(0);
                }
                if (this.gmt != null && this.gmt.getRootView() != null) {
                    if (this.gmt.BA()) {
                        this.gmt.setVisible(0);
                        this.gqi.setVisibility(8);
                    } else {
                        this.gmt.setVisible(4);
                    }
                }
                if (z3 && !this.gqg) {
                    this.gqg = true;
                    this.gqd.a(this.gqj.gxM.mChallengeData);
                    if (this.gqj.gxM.mAvtsData != null) {
                        a(this.gqj.gxM.mAvtsData, this.gqj.gxM.mAvtsConfigInfo);
                        this.gqi.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gqd != null) {
            this.gqd.bf(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPo() {
        bPn().Qt();
        bPn().bRc();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.MC().f(true, false);
        bPn().gxE.switchToCommonMode(f.getWidth(), f.getHeight());
        bPn().bRd();
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
            bPn().bRc();
            bPn().gxE.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.MC().f(true, true);
            bPn().gxE.switchToRtcMode(f.getWidth(), f.getHeight());
            bPn().bRd();
        }
    }

    public void bPp() {
        if (this.gqe != null) {
            this.gqe.b(bPn().gxG, true);
        }
    }

    public void a(r rVar) {
        if (this.gqf != null) {
            this.gqf.a(rVar);
        }
        if (this.gmt != null) {
            this.gmt.b(rVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gqe != null && this.gqe.isActive() && this.gqe.onBackKeyDown();
    }

    public void bPq() {
        if (this.gqd != null) {
            this.gqd.BB();
            this.gqd.onDestroy();
        }
        if (this.gmt != null) {
            this.gmt.BB();
            this.gmt.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gqf != null) {
            this.gqf.BI();
        }
    }

    public void onDestroy() {
        if (this.gqf != null) {
            this.gqf.onDestroy();
        }
        if (this.gqe != null) {
            this.gqe.removeView();
        }
    }

    public boolean bPr() {
        return this.gqf != null && this.gqf.isActive();
    }

    public int be(boolean z) {
        if (this.gqf != null) {
            return this.gqf.be(z);
        }
        return 0;
    }

    public boolean bPs() {
        return this.gmt != null && this.gmt.BA();
    }

    public void fI(String str) {
        if (this.gqd != null) {
            this.gqd.fI(str);
        }
    }

    public void K(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bPn().bRa() != 2 && com.baidu.live.w.a.Nk().beH.aGg) {
            if (this.gmt == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bPn().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gmt = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gmt != null) {
                this.gmt.a(bPn().gxe.bVO(), true, z2);
                this.gmt.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gmt.getRootView() != null && this.gmt.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.gmt.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bPn().gxf.addView(this.gmt.getRootView(), layoutParams);
                }
                this.gmt.a(null, bPn().gxe.LC());
                if (this.gqj != null && this.gqj.gxM != null && this.gqj.gxM.mPkData != null) {
                    this.gmt.dC(this.gqj.gxM.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gqh = dVar;
    }

    public int bOY() {
        int i = 0;
        if (this.gqf != null) {
            i = this.gqf.be(true);
        }
        return i + bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }
}

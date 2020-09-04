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
    private com.baidu.live.d.a gmx;
    private com.baidu.live.challenge.e goR;
    private f gqf;
    private com.baidu.live.challenge.f gqg;
    private i gqh;
    private j gqi;
    private h gqj;
    private boolean gqk = false;
    private d gql;
    private ImageView gqm;
    private g gqn;

    public e(f fVar) {
        this.gqf = fVar;
    }

    public void a(ImageView imageView, g gVar) {
        this.gqm = imageView;
        this.gqn = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f bPo() {
        return this.gqf;
    }

    public void i(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bPo().bRb() != 2 && z2) {
            if (this.goR == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bPo().pageContext)) != null && runTask2.getData() != null) {
                this.goR = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gqg == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, bPo().pageContext)) != null && runTask.getData() != null) {
                this.gqg = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.goR != null && this.gqg != null) {
                if (this.gqh == null) {
                    this.gqh = this.goR.a(bPo().pageContext);
                    this.gqh.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void dF(int i) {
                            if (e.this.gqi != null) {
                                e.this.gqi.dG(i);
                            }
                        }
                    });
                    this.gqh.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int BU() {
                            return e.this.bPo().gxI.getRtcStreamStatus();
                        }
                    });
                    this.gqh.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
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
                            e.this.bPp();
                            e.this.gqm.setVisibility(0);
                        }
                    });
                }
                if (this.gqi == null) {
                    this.gqi = this.gqg.BE();
                    this.gqi.setUserId(String.valueOf(bPo().gxi.LC().aDG.userId));
                    this.gqi.fL(bPo().gxi.LC().aDG.portrait);
                    this.gqi.a(this.gqh);
                    this.gqi.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void BW() {
                            e.this.gqi.removeView();
                            if (e.this.gmx != null && e.this.gmx.getRootView() != null) {
                                e.this.gmx.setVisible(0);
                                e.this.gmx.BC();
                                e.this.gqm.setVisibility(8);
                            }
                            if (e.this.gql != null) {
                                e.this.gql.bPn();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void BX() {
                            e.this.gqm.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aCt, aVar.aCu);
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
                this.gqh.e(bPo().gxi.LC().mLiveInfo.live_id, bPo().gxi.LC().aDG.userId);
                this.gqh.a((i.l) this.gqi);
                this.gqh.a((i.a) this.gqi);
                this.gqh.a((i.e) this.gqi);
                this.gqh.a((i.j) this.gqi);
                this.gqh.a((i.InterfaceC0166i) this.gqi);
                this.gqh.a((i.k) this.gqi);
                this.gqh.a((i.h) this.gqi);
                this.gqh.a((i.g) this.gqi);
                this.gqh.a((i.c) this.gqi);
                this.gqh.setIsHost(bPo().gxi.LC().isHost);
                if (this.gqj == null) {
                    this.gqj = this.goR.b(bPo().pageContext);
                    this.gqj.b(false, true, z3);
                    this.gqj.a(this.gqh);
                    this.gqj.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void BF() {
                            e.this.bPo().gxj.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(ap apVar, at atVar, at atVar2) {
                            if (e.this.gql != null) {
                                e.this.gql.a(apVar, atVar, atVar2);
                            }
                            if (e.this.gmx != null) {
                                e.this.gmx.setCanVisible(false);
                                e.this.gmx.setVisible(8);
                            }
                            e.this.bPo().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            e.this.bPo().bRc();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void BG() {
                            e.this.bPo().aXJ();
                            if (e.this.gql != null) {
                                e.this.gql.BG();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void BH() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bc(boolean z4) {
                            if (e.this.gql != null) {
                                e.this.gql.bPm();
                            }
                            if (e.this.gmx != null) {
                                e.this.gmx.setCanVisible(true);
                            }
                            if (e.this.gqm != null) {
                                e.this.gqm.setVisibility(0);
                            }
                            e.this.bPo().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            e.this.bPp();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bd(boolean z4) {
                        }
                    });
                    this.gqj.l(bPo().gxK);
                }
                this.gqh.a((i.c) this.gqj);
                this.gqh.a((i.m) this.gqj);
                this.gqh.a((i.d) this.gqj);
                if (this.gqh.BP() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gqm.setVisibility(0);
                }
                if (this.gmx != null && this.gmx.getRootView() != null) {
                    if (this.gmx.BA()) {
                        this.gmx.setVisible(0);
                        this.gqm.setVisibility(8);
                    } else {
                        this.gmx.setVisible(4);
                    }
                }
                if (z3 && !this.gqk) {
                    this.gqk = true;
                    this.gqh.a(this.gqn.gxQ.mChallengeData);
                    if (this.gqn.gxQ.mAvtsData != null) {
                        a(this.gqn.gxQ.mAvtsData, this.gqn.gxQ.mAvtsConfigInfo);
                        this.gqm.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gqh != null) {
            this.gqh.bf(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPp() {
        bPo().Qt();
        bPo().bRd();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.MC().f(true, false);
        bPo().gxI.switchToCommonMode(f.getWidth(), f.getHeight());
        bPo().bRe();
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
            bPo().bRd();
            bPo().gxI.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.MC().f(true, true);
            bPo().gxI.switchToRtcMode(f.getWidth(), f.getHeight());
            bPo().bRe();
        }
    }

    public void bPq() {
        if (this.gqi != null) {
            this.gqi.b(bPo().gxK, true);
        }
    }

    public void a(r rVar) {
        if (this.gqj != null) {
            this.gqj.a(rVar);
        }
        if (this.gmx != null) {
            this.gmx.b(rVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gqi != null && this.gqi.isActive() && this.gqi.onBackKeyDown();
    }

    public void bPr() {
        if (this.gqh != null) {
            this.gqh.BB();
            this.gqh.onDestroy();
        }
        if (this.gmx != null) {
            this.gmx.BB();
            this.gmx.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gqj != null) {
            this.gqj.BI();
        }
    }

    public void onDestroy() {
        if (this.gqj != null) {
            this.gqj.onDestroy();
        }
        if (this.gqi != null) {
            this.gqi.removeView();
        }
    }

    public boolean bPs() {
        return this.gqj != null && this.gqj.isActive();
    }

    public int be(boolean z) {
        if (this.gqj != null) {
            return this.gqj.be(z);
        }
        return 0;
    }

    public boolean bPt() {
        return this.gmx != null && this.gmx.BA();
    }

    public void fJ(String str) {
        if (this.gqh != null) {
            this.gqh.fJ(str);
        }
    }

    public void K(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bPo().bRb() != 2 && com.baidu.live.w.a.Nk().beJ.aGi) {
            if (this.gmx == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bPo().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gmx = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gmx != null) {
                this.gmx.a(bPo().gxi.bVP(), true, z2);
                this.gmx.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gmx.getRootView() != null && this.gmx.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.gmx.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bPo().gxj.addView(this.gmx.getRootView(), layoutParams);
                }
                this.gmx.a(null, bPo().gxi.LC());
                if (this.gqn != null && this.gqn.gxQ != null && this.gqn.gxQ.mPkData != null) {
                    this.gmx.dC(this.gqn.gxQ.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gql = dVar;
    }

    public int bOZ() {
        int i = 0;
        if (this.gqj != null) {
            i = this.gqj.be(true);
        }
        return i + bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }
}

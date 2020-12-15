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
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.ba;
import com.baidu.live.data.be;
import com.baidu.live.data.w;
import com.baidu.live.f.a;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.f.a heS;
    private com.baidu.live.challenge.e hhH;
    private com.baidu.tieba.ala.liveroom.data.e hjc;
    private f hjd;
    private i hje;
    private j hjf;
    private h hjg;
    private d hji;
    private ImageView hjj;
    private com.baidu.tieba.ala.liveroom.data.f hjk;
    private boolean hjh = false;
    private boolean hjl = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hjc = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.hjj = imageView;
        this.hjk = fVar;
        this.hjl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e ccK() {
        return this.hjc;
    }

    public void j(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && ccK().ceG() != 2) {
            if (!z2) {
                this.hjj.setVisibility(0);
            }
            if (this.hhH == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, ccK().pageContext)) != null && runTask2.getData() != null) {
                this.hhH = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.hjd == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, ccK().pageContext)) != null && runTask.getData() != null) {
                this.hjd = (f) runTask.getData();
            }
            if (this.hhH != null && this.hjd != null) {
                if (this.hje == null) {
                    this.hje = this.hhH.a(ccK().pageContext);
                    this.hje.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void ed(int i) {
                            if (e.this.hjf != null) {
                                e.this.hjf.ee(i);
                            }
                        }
                    });
                    this.hje.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int EH() {
                            return e.this.ccK().hqk.getRtcStreamStatus();
                        }
                    });
                    this.hje.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(ba baVar, be beVar, be beVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(ba baVar, be beVar, be beVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(ba baVar, be beVar, be beVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(ba baVar, be beVar, be beVar2) {
                            e.this.ccL();
                            e.this.hjj.setVisibility(0);
                        }
                    });
                }
                if (this.hjf == null) {
                    this.hjf = this.hjd.Eq();
                    this.hjf.setUserId(String.valueOf(ccK().hpT.Iq().aJV.userId));
                    this.hjf.setUserPortrait(ccK().hpT.Iq().aJV.portrait);
                    this.hjf.a(this.hje);
                    this.hjf.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void EJ() {
                            e.this.hjf.removeView();
                            if (e.this.heS != null && e.this.heS.getRootView() != null) {
                                e.this.heS.setVisible(0);
                                e.this.heS.Eo();
                            }
                            if (e.this.hji != null) {
                                e.this.hji.ccJ();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void EK() {
                            e.this.hjj.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aIc, aVar.aId);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void EL() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void EM() {
                        }
                    });
                }
                this.hje.e(ccK().hpT.Iq().mLiveInfo.live_id, ccK().hpT.Iq().aJV.userId);
                this.hje.a((i.m) this.hjf);
                this.hje.a((i.a) this.hjf);
                this.hje.a((i.e) this.hjf);
                this.hje.a((i.k) this.hjf);
                this.hje.a((i.InterfaceC0180i) this.hjf);
                this.hje.a((i.l) this.hjf);
                this.hje.a((i.h) this.hjf);
                this.hje.a((i.g) this.hjf);
                this.hje.a((i.c) this.hjf);
                this.hje.a((i.j) this.hjf);
                this.hje.setIsHost(ccK().hpT.Iq().isHost);
                if (this.hjg == null) {
                    this.hjg = this.hhH.b(ccK().pageContext);
                    this.hjg.b(false, true, z3);
                    this.hjg.a(this.hje);
                    this.hjg.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void Er() {
                            e.this.ccK().hpU.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(ba baVar, be beVar, be beVar2) {
                            if (e.this.hji != null) {
                                e.this.hji.a(baVar, beVar, beVar2);
                            }
                            if (e.this.heS != null) {
                                e.this.heS.setCanVisible(false);
                                e.this.heS.setVisible(8);
                            }
                            e.this.ccK().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.ccK().ceH();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Es() {
                            e.this.ccK().bhU();
                            if (e.this.hji != null) {
                                e.this.hji.Es();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Et() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bs(boolean z4) {
                            if (e.this.hji != null) {
                                e.this.hji.ccI();
                            }
                            if (e.this.heS != null) {
                                e.this.heS.setCanVisible(true);
                            }
                            if (e.this.hjj != null) {
                                e.this.hjj.setVisibility(0);
                            }
                            e.this.ccK().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.ccL();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bt(boolean z4) {
                        }
                    });
                    this.hjg.i(ccK().hqn);
                }
                this.hje.a((i.c) this.hjg);
                this.hje.a((i.n) this.hjg);
                this.hje.a((i.d) this.hjg);
                if (this.hje.EC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.hjj.setVisibility(0);
                }
                if (this.heS != null && this.heS.getRootView() != null) {
                    if (this.heS.Em()) {
                        this.heS.setVisible(0);
                        this.hjj.setVisibility(0);
                    } else {
                        this.heS.setVisible(4);
                    }
                }
                if (z3 && !this.hjh) {
                    this.hjh = true;
                    this.hje.a(this.hjk.hqt.mChallengeData);
                    if (this.hjk.hqt.mAvtsData != null) {
                        a(this.hjk.hqt.mAvtsData, this.hjk.hqt.mAvtsConfigInfo);
                        this.hjj.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.hje != null) {
            this.hje.bv(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccL() {
        ccK().Yj();
        ccK().ceI();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.QY().f(true, false);
        ccK().hqk.switchToCommonMode(f.getWidth(), f.getHeight());
        ccK().ceJ();
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
            ccK().ceI();
            ccK().hqk.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.QY().f(true, true);
            ccK().hqk.switchToRtcMode(f.getWidth(), f.getHeight());
            ccK().ceJ();
        }
    }

    public boolean ccM() {
        return this.hje.EC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean ccN() {
        return this.hje.EC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void ccO() {
        if (this.hjf != null) {
            this.hjf.bw(this.hjl);
            this.hjf.b(ccK().hqn, true);
        }
    }

    public void ccP() {
        if (this.hjf != null && this.hjf.isActive()) {
            this.hjf.onBackKeyDown();
        }
    }

    public void a(w wVar) {
        if (this.hjg != null) {
            this.hjg.a(wVar);
        }
        if (this.heS != null) {
            this.heS.b(wVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hjf != null && this.hjf.isActive() && this.hjf.onBackKeyDown();
    }

    public void ccQ() {
        if (this.hje != null) {
            this.hje.En();
            this.hje.onDestroy();
        }
        if (this.heS != null) {
            this.heS.En();
            this.heS.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hjg != null) {
            this.hjg.Eu();
        }
    }

    public void onDestroy() {
        if (this.hjg != null) {
            this.hjg.onDestroy();
        }
        if (this.hjf != null) {
            this.hjf.removeView();
        }
    }

    public boolean ccR() {
        return this.hjg != null && this.hjg.isActive();
    }

    public int bu(boolean z) {
        if (this.hjg != null) {
            return this.hjg.bu(z);
        }
        return 0;
    }

    public boolean ccS() {
        return this.heS != null && this.heS.Em();
    }

    public void gx(String str) {
        if (this.hje != null) {
            this.hje.gx(str);
        }
    }

    public void N(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && ccK().ceG() != 2 && com.baidu.live.ae.a.RB().brA.aNn) {
            if (this.heS == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.f.a.class, ccK().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.f.a)) {
                this.heS = (com.baidu.live.f.a) runTask.getData();
            }
            if (this.heS != null) {
                this.heS.a(ccK().hpT.cjN(), true, z2);
                this.heS.a(new a.InterfaceC0183a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.heS.getRootView() != null && this.heS.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.heS.getRootView().setId(a.f.ala_live_room_pk_panel);
                    ccK().hpU.addView(this.heS.getRootView(), layoutParams);
                }
                this.heS.c(null, ccK().hpT.Iq());
                if (this.hjk != null && this.hjk.hqt != null && this.hjk.hqt.mPkData != null) {
                    this.heS.ea(this.hjk.hqt.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.hji = dVar;
    }

    public int ccs() {
        int i = 0;
        if (this.hjg != null) {
            i = this.hjg.bu(true);
        }
        return i + ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

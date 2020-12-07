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
    private com.baidu.live.f.a heQ;
    private com.baidu.live.challenge.e hhF;
    private com.baidu.tieba.ala.liveroom.data.e hja;
    private f hjb;
    private i hjc;
    private j hjd;
    private h hje;
    private d hjg;
    private ImageView hjh;
    private com.baidu.tieba.ala.liveroom.data.f hji;
    private boolean hjf = false;
    private boolean hjj = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hja = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.hjh = imageView;
        this.hji = fVar;
        this.hjj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e ccJ() {
        return this.hja;
    }

    public void j(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && ccJ().ceF() != 2) {
            if (!z2) {
                this.hjh.setVisibility(0);
            }
            if (this.hhF == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, ccJ().pageContext)) != null && runTask2.getData() != null) {
                this.hhF = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.hjb == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, ccJ().pageContext)) != null && runTask.getData() != null) {
                this.hjb = (f) runTask.getData();
            }
            if (this.hhF != null && this.hjb != null) {
                if (this.hjc == null) {
                    this.hjc = this.hhF.a(ccJ().pageContext);
                    this.hjc.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void ed(int i) {
                            if (e.this.hjd != null) {
                                e.this.hjd.ee(i);
                            }
                        }
                    });
                    this.hjc.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int EH() {
                            return e.this.ccJ().hqi.getRtcStreamStatus();
                        }
                    });
                    this.hjc.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
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
                            e.this.ccK();
                            e.this.hjh.setVisibility(0);
                        }
                    });
                }
                if (this.hjd == null) {
                    this.hjd = this.hjb.Eq();
                    this.hjd.setUserId(String.valueOf(ccJ().hpR.Iq().aJV.userId));
                    this.hjd.setUserPortrait(ccJ().hpR.Iq().aJV.portrait);
                    this.hjd.a(this.hjc);
                    this.hjd.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void EJ() {
                            e.this.hjd.removeView();
                            if (e.this.heQ != null && e.this.heQ.getRootView() != null) {
                                e.this.heQ.setVisible(0);
                                e.this.heQ.Eo();
                            }
                            if (e.this.hjg != null) {
                                e.this.hjg.ccI();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void EK() {
                            e.this.hjh.setVisibility(0);
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
                this.hjc.e(ccJ().hpR.Iq().mLiveInfo.live_id, ccJ().hpR.Iq().aJV.userId);
                this.hjc.a((i.m) this.hjd);
                this.hjc.a((i.a) this.hjd);
                this.hjc.a((i.e) this.hjd);
                this.hjc.a((i.k) this.hjd);
                this.hjc.a((i.InterfaceC0180i) this.hjd);
                this.hjc.a((i.l) this.hjd);
                this.hjc.a((i.h) this.hjd);
                this.hjc.a((i.g) this.hjd);
                this.hjc.a((i.c) this.hjd);
                this.hjc.a((i.j) this.hjd);
                this.hjc.setIsHost(ccJ().hpR.Iq().isHost);
                if (this.hje == null) {
                    this.hje = this.hhF.b(ccJ().pageContext);
                    this.hje.b(false, true, z3);
                    this.hje.a(this.hjc);
                    this.hje.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void Er() {
                            e.this.ccJ().hpS.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(ba baVar, be beVar, be beVar2) {
                            if (e.this.hjg != null) {
                                e.this.hjg.a(baVar, beVar, beVar2);
                            }
                            if (e.this.heQ != null) {
                                e.this.heQ.setCanVisible(false);
                                e.this.heQ.setVisible(8);
                            }
                            e.this.ccJ().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.ccJ().ceG();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Es() {
                            e.this.ccJ().bhU();
                            if (e.this.hjg != null) {
                                e.this.hjg.Es();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Et() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bs(boolean z4) {
                            if (e.this.hjg != null) {
                                e.this.hjg.ccH();
                            }
                            if (e.this.heQ != null) {
                                e.this.heQ.setCanVisible(true);
                            }
                            if (e.this.hjh != null) {
                                e.this.hjh.setVisibility(0);
                            }
                            e.this.ccJ().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.ccK();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bt(boolean z4) {
                        }
                    });
                    this.hje.i(ccJ().hql);
                }
                this.hjc.a((i.c) this.hje);
                this.hjc.a((i.n) this.hje);
                this.hjc.a((i.d) this.hje);
                if (this.hjc.EC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.hjh.setVisibility(0);
                }
                if (this.heQ != null && this.heQ.getRootView() != null) {
                    if (this.heQ.Em()) {
                        this.heQ.setVisible(0);
                        this.hjh.setVisibility(0);
                    } else {
                        this.heQ.setVisible(4);
                    }
                }
                if (z3 && !this.hjf) {
                    this.hjf = true;
                    this.hjc.a(this.hji.hqr.mChallengeData);
                    if (this.hji.hqr.mAvtsData != null) {
                        a(this.hji.hqr.mAvtsData, this.hji.hqr.mAvtsConfigInfo);
                        this.hjh.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.hjc != null) {
            this.hjc.bv(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccK() {
        ccJ().Yj();
        ccJ().ceH();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.QY().f(true, false);
        ccJ().hqi.switchToCommonMode(f.getWidth(), f.getHeight());
        ccJ().ceI();
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
            ccJ().ceH();
            ccJ().hqi.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.QY().f(true, true);
            ccJ().hqi.switchToRtcMode(f.getWidth(), f.getHeight());
            ccJ().ceI();
        }
    }

    public boolean ccL() {
        return this.hjc.EC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean ccM() {
        return this.hjc.EC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void ccN() {
        if (this.hjd != null) {
            this.hjd.bw(this.hjj);
            this.hjd.b(ccJ().hql, true);
        }
    }

    public void ccO() {
        if (this.hjd != null && this.hjd.isActive()) {
            this.hjd.onBackKeyDown();
        }
    }

    public void a(w wVar) {
        if (this.hje != null) {
            this.hje.a(wVar);
        }
        if (this.heQ != null) {
            this.heQ.b(wVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hjd != null && this.hjd.isActive() && this.hjd.onBackKeyDown();
    }

    public void ccP() {
        if (this.hjc != null) {
            this.hjc.En();
            this.hjc.onDestroy();
        }
        if (this.heQ != null) {
            this.heQ.En();
            this.heQ.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hje != null) {
            this.hje.Eu();
        }
    }

    public void onDestroy() {
        if (this.hje != null) {
            this.hje.onDestroy();
        }
        if (this.hjd != null) {
            this.hjd.removeView();
        }
    }

    public boolean ccQ() {
        return this.hje != null && this.hje.isActive();
    }

    public int bu(boolean z) {
        if (this.hje != null) {
            return this.hje.bu(z);
        }
        return 0;
    }

    public boolean ccR() {
        return this.heQ != null && this.heQ.Em();
    }

    public void gx(String str) {
        if (this.hjc != null) {
            this.hjc.gx(str);
        }
    }

    public void N(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && ccJ().ceF() != 2 && com.baidu.live.ae.a.RB().brA.aNn) {
            if (this.heQ == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.f.a.class, ccJ().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.f.a)) {
                this.heQ = (com.baidu.live.f.a) runTask.getData();
            }
            if (this.heQ != null) {
                this.heQ.a(ccJ().hpR.cjM(), true, z2);
                this.heQ.a(new a.InterfaceC0183a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.heQ.getRootView() != null && this.heQ.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.heQ.getRootView().setId(a.f.ala_live_room_pk_panel);
                    ccJ().hpS.addView(this.heQ.getRootView(), layoutParams);
                }
                this.heQ.c(null, ccJ().hpR.Iq());
                if (this.hji != null && this.hji.hqr != null && this.hji.hqr.mPkData != null) {
                    this.heQ.ea(this.hji.hqr.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.hjg = dVar;
    }

    public int ccr() {
        int i = 0;
        if (this.hje != null) {
            i = this.hje.bu(true);
        }
        return i + ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

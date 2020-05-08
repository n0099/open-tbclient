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
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.data.n;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class f {
    private com.baidu.live.d.a fwh;
    private com.baidu.live.challenge.f fyp;
    private com.baidu.tieba.ala.liveroom.data.f fzj;
    private g fzk;
    private j fzl;
    private k fzm;
    private i fzn;
    private com.baidu.live.challenge.e fzo;
    private boolean fzp = false;
    private e fzq;
    private ImageView fzr;
    private com.baidu.tieba.ala.liveroom.data.g fzs;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.fzj = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.fzr = imageView;
        this.fzs = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f btE() {
        return this.fzj;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && btE().bvh() != 2 && z2) {
            if (this.fyp == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, btE().pageContext)) != null && runTask2.getData() != null) {
                this.fyp = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.fzk == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, btE().pageContext)) != null && runTask.getData() != null) {
                this.fzk = (g) runTask.getData();
            }
            if (this.fyp != null && this.fzk != null) {
                if (this.fzl == null) {
                    this.fzl = this.fyp.a(btE().pageContext);
                    this.fzl.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bz(int i) {
                            if (f.this.fzm != null) {
                                f.this.fzm.bw(i);
                                if (f.this.fzo == null) {
                                    f.this.fzo = f.this.fzk.uk();
                                    f.this.fzo.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.fzo.hide();
                                            f.this.fzo.aQ(false);
                                            if (f.this.fzm != null) {
                                                f.this.fzm.b(f.this.btE().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.fzo.bw(i);
                                if (!f.this.fzm.isActive()) {
                                    f.this.fzo.J(f.this.fzr);
                                }
                            }
                        }
                    });
                    this.fzl.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int uz() {
                            return f.this.btE().fFH.getRtcStreamStatus();
                        }
                    });
                    this.fzl.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.c
                        public void b(ag agVar, ah ahVar, ah ahVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void c(ag agVar, ah ahVar, ah ahVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void d(ag agVar, ah ahVar, ah ahVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void e(ag agVar, ah ahVar, ah ahVar2) {
                            f.this.btF();
                            f.this.fzr.setVisibility(0);
                        }
                    });
                }
                if (this.fzm == null) {
                    this.fzm = this.fzk.uj();
                    this.fzm.dK(btE().fFh.DM().aqk.portrait);
                    this.fzm.a(this.fzl);
                    this.fzm.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void uB() {
                            f.this.fzm.removeView();
                            if (f.this.fwh != null && f.this.fwh.getRootView() != null) {
                                f.this.fwh.setVisible(0);
                                f.this.fwh.ug();
                                f.this.fzr.setVisibility(8);
                            }
                            if (f.this.fzq != null) {
                                f.this.fzq.btD();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void uC() {
                            f.this.fzr.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.apo, aVar.apq);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void uD() {
                            if (f.this.fzo != null) {
                                f.this.fzo.aQ(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void uE() {
                            if (f.this.fzo != null && !f.this.fzo.isShowing() && f.this.fzo.ui()) {
                                f.this.fzo.J(f.this.fzr);
                            }
                        }
                    });
                }
                this.fzl.d(btE().fFh.DM().mLiveInfo.live_id, btE().fFh.DM().aqk.userId);
                this.fzl.a((j.InterfaceC0126j) this.fzm);
                this.fzl.a((j.a) this.fzm);
                this.fzl.a((j.d) this.fzm);
                this.fzl.a((j.i) this.fzm);
                this.fzl.a((j.h) this.fzm);
                this.fzl.a((j.g) this.fzm);
                this.fzl.a((j.f) this.fzm);
                this.fzl.a((j.c) this.fzm);
                if (this.fzn == null) {
                    this.fzn = this.fyp.b(btE().pageContext);
                    this.fzn.b(false, true, z3);
                    this.fzn.a(this.fzl);
                    this.fzn.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void ul() {
                            f.this.btE().fFi.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ag agVar, ah ahVar, ah ahVar2) {
                            if (f.this.fzq != null) {
                                f.this.fzq.a(agVar, ahVar, ahVar2);
                            }
                            if (f.this.fwh != null) {
                                f.this.fwh.setCanVisible(false);
                                f.this.fwh.setVisible(8);
                            }
                            f.this.btE().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.btE().bvi();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void um() {
                            f.this.btE().aFe();
                            if (f.this.fzq != null) {
                                f.this.fzq.um();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void un() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aR(boolean z4) {
                            if (f.this.fzq != null) {
                                f.this.fzq.btC();
                            }
                            if (f.this.fwh != null) {
                                f.this.fwh.setCanVisible(true);
                            }
                            if (f.this.fzr != null) {
                                f.this.fzr.setVisibility(0);
                            }
                            f.this.btE().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.btF();
                        }
                    });
                    this.fzn.f(btE().rootView);
                }
                this.fzl.a((j.c) this.fzn);
                this.fzl.a((j.k) this.fzn);
                if (this.fzl.uv() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.fzr.setVisibility(0);
                }
                if (this.fwh != null && this.fwh.getRootView() != null) {
                    if (this.fwh.ue()) {
                        this.fwh.setVisible(0);
                        this.fzr.setVisibility(8);
                    } else {
                        this.fwh.setVisible(4);
                    }
                }
                if (z3 && !this.fzp) {
                    this.fzp = true;
                    this.fzl.a(this.fzs.fFO.mChallengeData);
                    if (this.fzs.fFO.mAvtsData != null) {
                        a(this.fzs.fFO.mAvtsData, this.fzs.fFO.mAvtsConfigInfo);
                        this.fzr.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.fzl != null) {
            this.fzl.aT(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btF() {
        btE().Ho();
        btE().bvj();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Eh().f(true, false);
        btE().fFH.switchToCommonMode(f.getWidth(), f.getHeight());
        btE().bvk();
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
            btE().bvj();
            btE().fFH.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Eh().f(true, true);
            btE().fFH.switchToRtcMode(f.getWidth(), f.getHeight());
            btE().bvk();
        }
    }

    public void btG() {
        if (this.fzo != null) {
            this.fzo.hide();
        }
        if (this.fzm != null) {
            this.fzm.b(btE().rootView, true);
        }
    }

    public void a(n nVar) {
        if (this.fzn != null) {
            this.fzn.a(nVar);
        }
        if (this.fwh != null) {
            this.fwh.b(nVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.fzo != null && this.fzo.ui()) {
            this.fzo.J(imageView);
        }
    }

    public void Hp() {
        if (this.fzo != null) {
            this.fzo.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.fzm != null && this.fzm.isActive() && this.fzm.onBackKeyDown();
    }

    public void btH() {
        if (this.fzl != null) {
            this.fzl.uf();
            this.fzl.onDestroy();
        }
        if (this.fwh != null) {
            this.fwh.uf();
            this.fwh.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fzn != null) {
            this.fzn.uo();
        }
    }

    public void onDestroy() {
        if (this.fzn != null) {
            this.fzn.onDestroy();
        }
        if (this.fzo != null) {
            this.fzo.hide();
        }
        if (this.fzm != null) {
            this.fzm.removeView();
        }
    }

    public boolean btI() {
        return this.fzn != null && this.fzn.isActive();
    }

    public int aS(boolean z) {
        if (this.fzn != null) {
            return this.fzn.aS(z);
        }
        return 0;
    }

    public boolean btJ() {
        return this.fwh != null && this.fwh.ue();
    }

    public void dJ(String str) {
        if (this.fzl != null) {
            this.fzl.dJ(str);
        }
    }

    public void C(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && btE().bvh() != 2 && com.baidu.live.v.a.En().aQu.asA) {
            if (this.fwh == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, btE().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fwh = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fwh != null) {
                this.fwh.a(btE().fFh.bzr(), true, z2);
                this.fwh.a(new a.InterfaceC0127a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.fwh.getRootView() != null && this.fwh.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.fwh.getRootView().setId(a.g.ala_live_room_pk_panel);
                    btE().fFi.addView(this.fwh.getRootView(), layoutParams);
                }
                this.fwh.a(null, btE().fFh.DM());
                if (this.fzs != null && this.fzs.fFO != null && this.fzs.fFO.mPkData != null) {
                    this.fwh.bv(this.fzs.fFO.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.fzq = eVar;
    }
}

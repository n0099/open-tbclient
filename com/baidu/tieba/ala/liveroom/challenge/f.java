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
    private com.baidu.live.d.a fwc;
    private com.baidu.live.challenge.f fyk;
    private com.baidu.tieba.ala.liveroom.data.f fze;
    private g fzf;
    private j fzg;
    private k fzh;
    private i fzi;
    private com.baidu.live.challenge.e fzj;
    private boolean fzk = false;
    private e fzl;
    private ImageView fzm;
    private com.baidu.tieba.ala.liveroom.data.g fzn;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.fze = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.fzm = imageView;
        this.fzn = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f btG() {
        return this.fze;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && btG().bvj() != 2 && z2) {
            if (this.fyk == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, btG().pageContext)) != null && runTask2.getData() != null) {
                this.fyk = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.fzf == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, btG().pageContext)) != null && runTask.getData() != null) {
                this.fzf = (g) runTask.getData();
            }
            if (this.fyk != null && this.fzf != null) {
                if (this.fzg == null) {
                    this.fzg = this.fyk.a(btG().pageContext);
                    this.fzg.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bz(int i) {
                            if (f.this.fzh != null) {
                                f.this.fzh.bw(i);
                                if (f.this.fzj == null) {
                                    f.this.fzj = f.this.fzf.ul();
                                    f.this.fzj.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.fzj.hide();
                                            f.this.fzj.aQ(false);
                                            if (f.this.fzh != null) {
                                                f.this.fzh.b(f.this.btG().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.fzj.bw(i);
                                if (!f.this.fzh.isActive()) {
                                    f.this.fzj.J(f.this.fzm);
                                }
                            }
                        }
                    });
                    this.fzg.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int uA() {
                            return f.this.btG().fFC.getRtcStreamStatus();
                        }
                    });
                    this.fzg.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
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
                            f.this.btH();
                            f.this.fzm.setVisibility(0);
                        }
                    });
                }
                if (this.fzh == null) {
                    this.fzh = this.fzf.uk();
                    this.fzh.dK(btG().fFc.DN().aqe.portrait);
                    this.fzh.a(this.fzg);
                    this.fzh.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void uC() {
                            f.this.fzh.removeView();
                            if (f.this.fwc != null && f.this.fwc.getRootView() != null) {
                                f.this.fwc.setVisible(0);
                                f.this.fwc.uh();
                                f.this.fzm.setVisibility(8);
                            }
                            if (f.this.fzl != null) {
                                f.this.fzl.btF();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void uD() {
                            f.this.fzm.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.api, aVar.apj);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void uE() {
                            if (f.this.fzj != null) {
                                f.this.fzj.aQ(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void uF() {
                            if (f.this.fzj != null && !f.this.fzj.isShowing() && f.this.fzj.uj()) {
                                f.this.fzj.J(f.this.fzm);
                            }
                        }
                    });
                }
                this.fzg.d(btG().fFc.DN().mLiveInfo.live_id, btG().fFc.DN().aqe.userId);
                this.fzg.a((j.InterfaceC0105j) this.fzh);
                this.fzg.a((j.a) this.fzh);
                this.fzg.a((j.d) this.fzh);
                this.fzg.a((j.i) this.fzh);
                this.fzg.a((j.h) this.fzh);
                this.fzg.a((j.g) this.fzh);
                this.fzg.a((j.f) this.fzh);
                this.fzg.a((j.c) this.fzh);
                if (this.fzi == null) {
                    this.fzi = this.fyk.b(btG().pageContext);
                    this.fzi.b(false, true, z3);
                    this.fzi.a(this.fzg);
                    this.fzi.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void um() {
                            f.this.btG().fFd.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ag agVar, ah ahVar, ah ahVar2) {
                            if (f.this.fzl != null) {
                                f.this.fzl.a(agVar, ahVar, ahVar2);
                            }
                            if (f.this.fwc != null) {
                                f.this.fwc.setCanVisible(false);
                                f.this.fwc.setVisible(8);
                            }
                            f.this.btG().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.btG().bvk();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void un() {
                            f.this.btG().aFe();
                            if (f.this.fzl != null) {
                                f.this.fzl.un();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void uo() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aR(boolean z4) {
                            if (f.this.fzl != null) {
                                f.this.fzl.btE();
                            }
                            if (f.this.fwc != null) {
                                f.this.fwc.setCanVisible(true);
                            }
                            if (f.this.fzm != null) {
                                f.this.fzm.setVisibility(0);
                            }
                            f.this.btG().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.btH();
                        }
                    });
                    this.fzi.f(btG().rootView);
                }
                this.fzg.a((j.c) this.fzi);
                this.fzg.a((j.k) this.fzi);
                if (this.fzg.uw() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.fzm.setVisibility(0);
                }
                if (this.fwc != null && this.fwc.getRootView() != null) {
                    if (this.fwc.uf()) {
                        this.fwc.setVisible(0);
                        this.fzm.setVisibility(8);
                    } else {
                        this.fwc.setVisible(4);
                    }
                }
                if (z3 && !this.fzk) {
                    this.fzk = true;
                    this.fzg.a(this.fzn.fFJ.mChallengeData);
                    if (this.fzn.fFJ.mAvtsData != null) {
                        a(this.fzn.fFJ.mAvtsData, this.fzn.fFJ.mAvtsConfigInfo);
                        this.fzm.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.fzg != null) {
            this.fzg.aT(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btH() {
        btG().Hp();
        btG().bvl();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Ei().f(true, false);
        btG().fFC.switchToCommonMode(f.getWidth(), f.getHeight());
        btG().bvm();
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
            btG().bvl();
            btG().fFC.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Ei().f(true, true);
            btG().fFC.switchToRtcMode(f.getWidth(), f.getHeight());
            btG().bvm();
        }
    }

    public void btI() {
        if (this.fzj != null) {
            this.fzj.hide();
        }
        if (this.fzh != null) {
            this.fzh.b(btG().rootView, true);
        }
    }

    public void a(n nVar) {
        if (this.fzi != null) {
            this.fzi.a(nVar);
        }
        if (this.fwc != null) {
            this.fwc.b(nVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.fzj != null && this.fzj.uj()) {
            this.fzj.J(imageView);
        }
    }

    public void Hq() {
        if (this.fzj != null) {
            this.fzj.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.fzh != null && this.fzh.isActive() && this.fzh.onBackKeyDown();
    }

    public void btJ() {
        if (this.fzg != null) {
            this.fzg.ug();
            this.fzg.onDestroy();
        }
        if (this.fwc != null) {
            this.fwc.ug();
            this.fwc.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fzi != null) {
            this.fzi.up();
        }
    }

    public void onDestroy() {
        if (this.fzi != null) {
            this.fzi.onDestroy();
        }
        if (this.fzj != null) {
            this.fzj.hide();
        }
        if (this.fzh != null) {
            this.fzh.removeView();
        }
    }

    public boolean btK() {
        return this.fzi != null && this.fzi.isActive();
    }

    public int aS(boolean z) {
        if (this.fzi != null) {
            return this.fzi.aS(z);
        }
        return 0;
    }

    public boolean btL() {
        return this.fwc != null && this.fwc.uf();
    }

    public void dJ(String str) {
        if (this.fzg != null) {
            this.fzg.dJ(str);
        }
    }

    public void C(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && btG().bvj() != 2 && com.baidu.live.v.a.Eo().aQp.asu) {
            if (this.fwc == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, btG().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fwc = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fwc != null) {
                this.fwc.a(btG().fFc.bzt(), true, z2);
                this.fwc.a(new a.InterfaceC0106a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.fwc.getRootView() != null && this.fwc.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.fwc.getRootView().setId(a.g.ala_live_room_pk_panel);
                    btG().fFd.addView(this.fwc.getRootView(), layoutParams);
                }
                this.fwc.a(null, btG().fFc.DN());
                if (this.fzn != null && this.fzn.fFJ != null && this.fzn.fFJ.mPkData != null) {
                    this.fwc.bv(this.fzn.fFJ.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.fzl = eVar;
    }
}

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
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
/* loaded from: classes2.dex */
public class f {
    private com.baidu.live.d.a eMT;
    private com.baidu.live.challenge.f ePc;
    private com.baidu.tieba.ala.liveroom.data.f eQi;
    private g eQj;
    private j eQk;
    private k eQl;
    private i eQm;
    private com.baidu.live.challenge.e eQn;
    private boolean eQo = false;
    private e eQp;
    private ImageView eQq;
    private com.baidu.tieba.ala.liveroom.data.g eQr;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.eQi = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.eQq = imageView;
        this.eQr = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f bio() {
        return this.eQi;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bio().bjW() != 2 && z2) {
            if (this.ePc == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bio().pageContext)) != null && runTask2.getData() != null) {
                this.ePc = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.eQj == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, bio().pageContext)) != null && runTask.getData() != null) {
                this.eQj = (g) runTask.getData();
            }
            if (this.ePc != null && this.eQj != null) {
                if (this.eQk == null) {
                    this.eQk = this.ePc.a(bio().pageContext);
                    this.eQk.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bf(int i) {
                            if (f.this.eQl != null) {
                                f.this.eQl.bc(i);
                                if (f.this.eQn == null) {
                                    f.this.eQn = f.this.eQj.pe();
                                    f.this.eQn.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.eQn.hide();
                                            f.this.eQn.ap(false);
                                            if (f.this.eQl != null) {
                                                f.this.eQl.b(f.this.bio().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.eQn.bc(i);
                                if (!f.this.eQl.isActive()) {
                                    f.this.eQn.J(f.this.eQq);
                                }
                            }
                        }
                    });
                    this.eQk.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int pt() {
                            return f.this.bio().eWS.getRtcStreamStatus();
                        }
                    });
                    this.eQk.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.c
                        public void b(ac acVar, ad adVar, ad adVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void c(ac acVar, ad adVar, ad adVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void d(ac acVar, ad adVar, ad adVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void e(ac acVar, ad adVar, ad adVar2) {
                            f.this.bip();
                            f.this.eQq.setVisibility(0);
                        }
                    });
                }
                if (this.eQl == null) {
                    this.eQl = this.eQj.pd();
                    this.eQl.cM(bio().eWr.ww().Wf.portrait);
                    this.eQl.a(this.eQk);
                    this.eQl.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void pv() {
                            f.this.eQl.removeView();
                            if (f.this.eMT != null && f.this.eMT.getRootView() != null) {
                                f.this.eMT.setVisible(0);
                                f.this.eMT.pa();
                                f.this.eQq.setVisibility(8);
                            }
                            if (f.this.eQp != null) {
                                f.this.eQp.bin();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void pw() {
                            f.this.eQq.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.Vq, aVar.Vr);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void px() {
                            if (f.this.eQn != null) {
                                f.this.eQn.ap(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void py() {
                            if (f.this.eQn != null && !f.this.eQn.isShowing() && f.this.eQn.pc()) {
                                f.this.eQn.J(f.this.eQq);
                            }
                        }
                    });
                }
                this.eQk.d(bio().eWr.ww().mLiveInfo.live_id, bio().eWr.ww().Wf.userId);
                this.eQk.a((j.InterfaceC0074j) this.eQl);
                this.eQk.a((j.a) this.eQl);
                this.eQk.a((j.d) this.eQl);
                this.eQk.a((j.i) this.eQl);
                this.eQk.a((j.h) this.eQl);
                this.eQk.a((j.g) this.eQl);
                this.eQk.a((j.f) this.eQl);
                this.eQk.a((j.c) this.eQl);
                if (this.eQm == null) {
                    this.eQm = this.ePc.b(bio().pageContext);
                    this.eQm.b(false, true, z3);
                    this.eQm.a(this.eQk);
                    this.eQm.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void pf() {
                            f.this.bio().eWs.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ac acVar, ad adVar, ad adVar2) {
                            if (f.this.eQp != null) {
                                f.this.eQp.a(acVar, adVar, adVar2);
                            }
                            if (f.this.eMT != null) {
                                f.this.eMT.setCanVisible(false);
                                f.this.eMT.setVisible(8);
                            }
                            f.this.bio().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bio().bjY();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pg() {
                            f.this.bio().auA();
                            if (f.this.eQp != null) {
                                f.this.eQp.pg();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void ph() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aq(boolean z4) {
                            if (f.this.eQp != null) {
                                f.this.eQp.bim();
                            }
                            if (f.this.eMT != null) {
                                f.this.eMT.setCanVisible(true);
                            }
                            if (f.this.eQq != null) {
                                f.this.eQq.setVisibility(0);
                            }
                            f.this.bio().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bip();
                        }
                    });
                    this.eQm.e(bio().rootView);
                }
                this.eQk.a((j.c) this.eQm);
                this.eQk.a((j.k) this.eQm);
                if (this.eQk.pp() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.eQq.setVisibility(0);
                }
                if (this.eMT != null && this.eMT.getRootView() != null) {
                    if (this.eMT.oY()) {
                        this.eMT.setVisible(0);
                        this.eQq.setVisibility(8);
                    } else {
                        this.eMT.setVisible(4);
                    }
                }
                if (z3 && !this.eQo) {
                    this.eQo = true;
                    this.eQk.a(this.eQr.eWX.mChallengeData);
                    if (this.eQr.eWX.mAvtsData != null) {
                        a(this.eQr.eWX.mAvtsData, this.eQr.eWX.mAvtsConfigInfo);
                        this.eQq.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.eQk != null) {
            this.eQk.as(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bip() {
        bio().bjX();
        bio().bjZ();
        AlaLiveRecordConfigHelper.VideoResolution jh = AlaLiveRecordConfigHelper.bjH().jh(false);
        bio().eWS.switchToCommonMode(jh.getWidth(), jh.getHeight());
        bio().bka();
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
            bio().bjZ();
            bio().eWS.setRtcConfig(alaLiveRtcConfig);
            AlaLiveRecordConfigHelper.VideoResolution jh = AlaLiveRecordConfigHelper.bjH().jh(true);
            bio().eWS.switchToRtcMode(jh.getWidth(), jh.getHeight());
            bio().bka();
        }
    }

    public void biq() {
        if (this.eQn != null) {
            this.eQn.hide();
        }
        if (this.eQl != null) {
            this.eQl.b(bio().rootView, true);
        }
    }

    public void a(com.baidu.live.data.l lVar) {
        if (this.eQm != null) {
            this.eQm.a(lVar);
        }
        if (this.eMT != null) {
            this.eMT.b(lVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.eQn != null && this.eQn.pc()) {
            this.eQn.J(imageView);
        }
    }

    public void bir() {
        if (this.eQn != null) {
            this.eQn.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.eQl != null && this.eQl.isActive() && this.eQl.onBackKeyDown();
    }

    public void bis() {
        if (this.eQk != null) {
            this.eQk.oZ();
            this.eQk.onDestroy();
        }
        if (this.eMT != null) {
            this.eMT.oZ();
            this.eMT.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.eQm != null) {
            this.eQm.pi();
        }
    }

    public void onDestroy() {
        if (this.eQm != null) {
            this.eQm.onDestroy();
        }
        if (this.eQn != null) {
            this.eQn.hide();
        }
        if (this.eQl != null) {
            this.eQl.removeView();
        }
    }

    public boolean bit() {
        return this.eQm != null && this.eQm.isActive();
    }

    public int ar(boolean z) {
        if (this.eQm != null) {
            return this.eQm.ar(z);
        }
        return 0;
    }

    public boolean biu() {
        return this.eMT != null && this.eMT.oY();
    }

    public void cL(String str) {
        if (this.eQk != null) {
            this.eQk.cL(str);
        }
    }

    public void A(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bio().bjW() != 2 && com.baidu.live.s.a.wR().asq.Yd) {
            if (this.eMT == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bio().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eMT = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eMT != null) {
                this.eMT.a(bio().eWr.bod(), true, z2);
                this.eMT.a(new a.InterfaceC0075a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.eMT.getRootView() != null && this.eMT.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.eMT.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bio().eWs.addView(this.eMT.getRootView(), layoutParams);
                }
                this.eMT.a(null, bio().eWr.ww());
                if (this.eQr != null && this.eQr.eWX != null && this.eQr.eWX.mPkData != null) {
                    this.eMT.bb(this.eQr.eWX.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.eQp = eVar;
    }
}

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
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.m;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class f {
    private com.baidu.live.d.a eQW;
    private com.baidu.tieba.ala.liveroom.data.f eTZ;
    private com.baidu.live.challenge.f eTe;
    private g eUa;
    private j eUb;
    private k eUc;
    private i eUd;
    private com.baidu.live.challenge.e eUe;
    private boolean eUf = false;
    private e eUg;
    private ImageView eUh;
    private com.baidu.tieba.ala.liveroom.data.g eUi;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.eTZ = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.eUh = imageView;
        this.eUi = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f bke() {
        return this.eTZ;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bke().blK() != 2 && z2) {
            if (this.eTe == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bke().pageContext)) != null && runTask2.getData() != null) {
                this.eTe = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.eUa == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, bke().pageContext)) != null && runTask.getData() != null) {
                this.eUa = (g) runTask.getData();
            }
            if (this.eTe != null && this.eUa != null) {
                if (this.eUb == null) {
                    this.eUb = this.eTe.a(bke().pageContext);
                    this.eUb.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bm(int i) {
                            if (f.this.eUc != null) {
                                f.this.eUc.bj(i);
                                if (f.this.eUe == null) {
                                    f.this.eUe = f.this.eUa.pP();
                                    f.this.eUe.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.eUe.hide();
                                            f.this.eUe.as(false);
                                            if (f.this.eUc != null) {
                                                f.this.eUc.b(f.this.bke().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.eUe.bj(i);
                                if (!f.this.eUc.isActive()) {
                                    f.this.eUe.J(f.this.eUh);
                                }
                            }
                        }
                    });
                    this.eUb.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int qe() {
                            return f.this.bke().faH.getRtcStreamStatus();
                        }
                    });
                    this.eUb.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.c
                        public void b(ad adVar, ae aeVar, ae aeVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void c(ad adVar, ae aeVar, ae aeVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void d(ad adVar, ae aeVar, ae aeVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void e(ad adVar, ae aeVar, ae aeVar2) {
                            f.this.bkf();
                            f.this.eUh.setVisibility(0);
                        }
                    });
                }
                if (this.eUc == null) {
                    this.eUc = this.eUa.pO();
                    this.eUc.cV(bke().fah.yN().XQ.portrait);
                    this.eUc.a(this.eUb);
                    this.eUc.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void qg() {
                            f.this.eUc.removeView();
                            if (f.this.eQW != null && f.this.eQW.getRootView() != null) {
                                f.this.eQW.setVisible(0);
                                f.this.eQW.pL();
                                f.this.eUh.setVisibility(8);
                            }
                            if (f.this.eUg != null) {
                                f.this.eUg.bkd();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qh() {
                            f.this.eUh.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.WW, aVar.WX);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qi() {
                            if (f.this.eUe != null) {
                                f.this.eUe.as(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qj() {
                            if (f.this.eUe != null && !f.this.eUe.isShowing() && f.this.eUe.pN()) {
                                f.this.eUe.J(f.this.eUh);
                            }
                        }
                    });
                }
                this.eUb.d(bke().fah.yN().mLiveInfo.live_id, bke().fah.yN().XQ.userId);
                this.eUb.a((j.InterfaceC0081j) this.eUc);
                this.eUb.a((j.a) this.eUc);
                this.eUb.a((j.d) this.eUc);
                this.eUb.a((j.i) this.eUc);
                this.eUb.a((j.h) this.eUc);
                this.eUb.a((j.g) this.eUc);
                this.eUb.a((j.f) this.eUc);
                this.eUb.a((j.c) this.eUc);
                if (this.eUd == null) {
                    this.eUd = this.eTe.b(bke().pageContext);
                    this.eUd.b(false, true, z3);
                    this.eUd.a(this.eUb);
                    this.eUd.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void pQ() {
                            f.this.bke().fai.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ad adVar, ae aeVar, ae aeVar2) {
                            if (f.this.eUg != null) {
                                f.this.eUg.a(adVar, aeVar, aeVar2);
                            }
                            if (f.this.eQW != null) {
                                f.this.eQW.setCanVisible(false);
                                f.this.eQW.setVisible(8);
                            }
                            f.this.bke().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bke().blM();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pR() {
                            f.this.bke().awO();
                            if (f.this.eUg != null) {
                                f.this.eUg.pR();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pS() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void at(boolean z4) {
                            if (f.this.eUg != null) {
                                f.this.eUg.bkc();
                            }
                            if (f.this.eQW != null) {
                                f.this.eQW.setCanVisible(true);
                            }
                            if (f.this.eUh != null) {
                                f.this.eUh.setVisibility(0);
                            }
                            f.this.bke().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bkf();
                        }
                    });
                    this.eUd.e(bke().rootView);
                }
                this.eUb.a((j.c) this.eUd);
                this.eUb.a((j.k) this.eUd);
                if (this.eUb.qa() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.eUh.setVisibility(0);
                }
                if (this.eQW != null && this.eQW.getRootView() != null) {
                    if (this.eQW.pJ()) {
                        this.eQW.setVisible(0);
                        this.eUh.setVisibility(8);
                    } else {
                        this.eQW.setVisible(4);
                    }
                }
                if (z3 && !this.eUf) {
                    this.eUf = true;
                    this.eUb.a(this.eUi.faO.mChallengeData);
                    if (this.eUi.faO.mAvtsData != null) {
                        a(this.eUi.faO.mAvtsData, this.eUi.faO.mAvtsConfigInfo);
                        this.eUh.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.eUb != null) {
            this.eUb.av(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkf() {
        bke().blL();
        bke().blN();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.ze().f(true, false);
        bke().faH.switchToCommonMode(f.getWidth(), f.getHeight());
        bke().blO();
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
            bke().blN();
            bke().faH.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.ze().f(true, true);
            bke().faH.switchToRtcMode(f.getWidth(), f.getHeight());
            bke().blO();
        }
    }

    public void bkg() {
        if (this.eUe != null) {
            this.eUe.hide();
        }
        if (this.eUc != null) {
            this.eUc.b(bke().rootView, true);
        }
    }

    public void a(m mVar) {
        if (this.eUd != null) {
            this.eUd.a(mVar);
        }
        if (this.eQW != null) {
            this.eQW.b(mVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.eUe != null && this.eUe.pN()) {
            this.eUe.J(imageView);
        }
    }

    public void bkh() {
        if (this.eUe != null) {
            this.eUe.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.eUc != null && this.eUc.isActive() && this.eUc.onBackKeyDown();
    }

    public void bki() {
        if (this.eUb != null) {
            this.eUb.pK();
            this.eUb.onDestroy();
        }
        if (this.eQW != null) {
            this.eQW.pK();
            this.eQW.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.eUd != null) {
            this.eUd.pT();
        }
    }

    public void onDestroy() {
        if (this.eUd != null) {
            this.eUd.onDestroy();
        }
        if (this.eUe != null) {
            this.eUe.hide();
        }
        if (this.eUc != null) {
            this.eUc.removeView();
        }
    }

    public boolean bkj() {
        return this.eUd != null && this.eUd.isActive();
    }

    public int au(boolean z) {
        if (this.eUd != null) {
            return this.eUd.au(z);
        }
        return 0;
    }

    public boolean bkk() {
        return this.eQW != null && this.eQW.pJ();
    }

    public void cU(String str) {
        if (this.eUb != null) {
            this.eUb.cU(str);
        }
    }

    public void C(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bke().blK() != 2 && com.baidu.live.v.a.zj().awA.ZU) {
            if (this.eQW == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bke().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eQW = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eQW != null) {
                this.eQW.a(bke().fah.bpQ(), true, z2);
                this.eQW.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.eQW.getRootView() != null && this.eQW.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.eQW.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bke().fai.addView(this.eQW.getRootView(), layoutParams);
                }
                this.eQW.a(null, bke().fah.yN());
                if (this.eUi != null && this.eUi.faO != null && this.eUi.faO.mPkData != null) {
                    this.eQW.bi(this.eUi.faO.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.eUg = eVar;
    }
}

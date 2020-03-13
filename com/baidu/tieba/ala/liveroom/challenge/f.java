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
    private com.baidu.live.d.a eRk;
    private com.baidu.live.challenge.f eTs;
    private com.baidu.tieba.ala.liveroom.data.f eUn;
    private g eUo;
    private j eUp;
    private k eUq;
    private i eUr;
    private com.baidu.live.challenge.e eUs;
    private boolean eUt = false;
    private e eUu;
    private ImageView eUv;
    private com.baidu.tieba.ala.liveroom.data.g eUw;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.eUn = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.eUv = imageView;
        this.eUw = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f bkh() {
        return this.eUn;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bkh().blN() != 2 && z2) {
            if (this.eTs == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bkh().pageContext)) != null && runTask2.getData() != null) {
                this.eTs = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.eUo == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, bkh().pageContext)) != null && runTask.getData() != null) {
                this.eUo = (g) runTask.getData();
            }
            if (this.eTs != null && this.eUo != null) {
                if (this.eUp == null) {
                    this.eUp = this.eTs.a(bkh().pageContext);
                    this.eUp.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bm(int i) {
                            if (f.this.eUq != null) {
                                f.this.eUq.bj(i);
                                if (f.this.eUs == null) {
                                    f.this.eUs = f.this.eUo.pP();
                                    f.this.eUs.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.eUs.hide();
                                            f.this.eUs.as(false);
                                            if (f.this.eUq != null) {
                                                f.this.eUq.b(f.this.bkh().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.eUs.bj(i);
                                if (!f.this.eUq.isActive()) {
                                    f.this.eUs.J(f.this.eUv);
                                }
                            }
                        }
                    });
                    this.eUp.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int qe() {
                            return f.this.bkh().faV.getRtcStreamStatus();
                        }
                    });
                    this.eUp.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
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
                            f.this.bki();
                            f.this.eUv.setVisibility(0);
                        }
                    });
                }
                if (this.eUq == null) {
                    this.eUq = this.eUo.pO();
                    this.eUq.cV(bkh().fav.yO().XQ.portrait);
                    this.eUq.a(this.eUp);
                    this.eUq.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void qg() {
                            f.this.eUq.removeView();
                            if (f.this.eRk != null && f.this.eRk.getRootView() != null) {
                                f.this.eRk.setVisible(0);
                                f.this.eRk.pL();
                                f.this.eUv.setVisibility(8);
                            }
                            if (f.this.eUu != null) {
                                f.this.eUu.bkg();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qh() {
                            f.this.eUv.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.WW, aVar.WX);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qi() {
                            if (f.this.eUs != null) {
                                f.this.eUs.as(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qj() {
                            if (f.this.eUs != null && !f.this.eUs.isShowing() && f.this.eUs.pN()) {
                                f.this.eUs.J(f.this.eUv);
                            }
                        }
                    });
                }
                this.eUp.d(bkh().fav.yO().mLiveInfo.live_id, bkh().fav.yO().XQ.userId);
                this.eUp.a((j.InterfaceC0081j) this.eUq);
                this.eUp.a((j.a) this.eUq);
                this.eUp.a((j.d) this.eUq);
                this.eUp.a((j.i) this.eUq);
                this.eUp.a((j.h) this.eUq);
                this.eUp.a((j.g) this.eUq);
                this.eUp.a((j.f) this.eUq);
                this.eUp.a((j.c) this.eUq);
                if (this.eUr == null) {
                    this.eUr = this.eTs.b(bkh().pageContext);
                    this.eUr.b(false, true, z3);
                    this.eUr.a(this.eUp);
                    this.eUr.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void pQ() {
                            f.this.bkh().faw.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ad adVar, ae aeVar, ae aeVar2) {
                            if (f.this.eUu != null) {
                                f.this.eUu.a(adVar, aeVar, aeVar2);
                            }
                            if (f.this.eRk != null) {
                                f.this.eRk.setCanVisible(false);
                                f.this.eRk.setVisible(8);
                            }
                            f.this.bkh().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bkh().blP();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pR() {
                            f.this.bkh().awQ();
                            if (f.this.eUu != null) {
                                f.this.eUu.pR();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pS() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void at(boolean z4) {
                            if (f.this.eUu != null) {
                                f.this.eUu.bkf();
                            }
                            if (f.this.eRk != null) {
                                f.this.eRk.setCanVisible(true);
                            }
                            if (f.this.eUv != null) {
                                f.this.eUv.setVisibility(0);
                            }
                            f.this.bkh().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bki();
                        }
                    });
                    this.eUr.e(bkh().rootView);
                }
                this.eUp.a((j.c) this.eUr);
                this.eUp.a((j.k) this.eUr);
                if (this.eUp.qa() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.eUv.setVisibility(0);
                }
                if (this.eRk != null && this.eRk.getRootView() != null) {
                    if (this.eRk.pJ()) {
                        this.eRk.setVisible(0);
                        this.eUv.setVisibility(8);
                    } else {
                        this.eRk.setVisible(4);
                    }
                }
                if (z3 && !this.eUt) {
                    this.eUt = true;
                    this.eUp.a(this.eUw.fbc.mChallengeData);
                    if (this.eUw.fbc.mAvtsData != null) {
                        a(this.eUw.fbc.mAvtsData, this.eUw.fbc.mAvtsConfigInfo);
                        this.eUv.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.eUp != null) {
            this.eUp.av(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bki() {
        bkh().blO();
        bkh().blQ();
        LiveRecorderConfigHelper.VideoResolution g = LiveRecorderConfigHelper.zg().g(true, false);
        bkh().faV.switchToCommonMode(g.getWidth(), g.getHeight());
        bkh().blR();
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
            bkh().blQ();
            bkh().faV.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution g = LiveRecorderConfigHelper.zg().g(true, true);
            bkh().faV.switchToRtcMode(g.getWidth(), g.getHeight());
            bkh().blR();
        }
    }

    public void bkj() {
        if (this.eUs != null) {
            this.eUs.hide();
        }
        if (this.eUq != null) {
            this.eUq.b(bkh().rootView, true);
        }
    }

    public void a(m mVar) {
        if (this.eUr != null) {
            this.eUr.a(mVar);
        }
        if (this.eRk != null) {
            this.eRk.b(mVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.eUs != null && this.eUs.pN()) {
            this.eUs.J(imageView);
        }
    }

    public void bkk() {
        if (this.eUs != null) {
            this.eUs.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.eUq != null && this.eUq.isActive() && this.eUq.onBackKeyDown();
    }

    public void bkl() {
        if (this.eUp != null) {
            this.eUp.pK();
            this.eUp.onDestroy();
        }
        if (this.eRk != null) {
            this.eRk.pK();
            this.eRk.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.eUr != null) {
            this.eUr.pT();
        }
    }

    public void onDestroy() {
        if (this.eUr != null) {
            this.eUr.onDestroy();
        }
        if (this.eUs != null) {
            this.eUs.hide();
        }
        if (this.eUq != null) {
            this.eUq.removeView();
        }
    }

    public boolean bkm() {
        return this.eUr != null && this.eUr.isActive();
    }

    public int au(boolean z) {
        if (this.eUr != null) {
            return this.eUr.au(z);
        }
        return 0;
    }

    public boolean bkn() {
        return this.eRk != null && this.eRk.pJ();
    }

    public void cU(String str) {
        if (this.eUp != null) {
            this.eUp.cU(str);
        }
    }

    public void D(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bkh().blN() != 2 && com.baidu.live.v.a.zl().awC.ZU) {
            if (this.eRk == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bkh().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eRk = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eRk != null) {
                this.eRk.a(bkh().fav.bpT(), true, z2);
                this.eRk.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.eRk.getRootView() != null && this.eRk.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.eRk.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bkh().faw.addView(this.eRk.getRootView(), layoutParams);
                }
                this.eRk.a(null, bkh().fav.yO());
                if (this.eUw != null && this.eUw.fbc != null && this.eUw.fbc.mPkData != null) {
                    this.eRk.bi(this.eUw.fbc.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.eUu = eVar;
    }
}

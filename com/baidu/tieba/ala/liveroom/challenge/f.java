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
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.q;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class f {
    private com.baidu.live.d.a fKd;
    private com.baidu.live.challenge.f fMr;
    private com.baidu.tieba.ala.liveroom.data.f fNl;
    private g fNm;
    private j fNn;
    private k fNo;
    private i fNp;
    private com.baidu.live.challenge.e fNq;
    private boolean fNr = false;
    private e fNs;
    private ImageView fNt;
    private com.baidu.tieba.ala.liveroom.data.g fNu;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.fNl = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.fNt = imageView;
        this.fNu = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f bzD() {
        return this.fNl;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bzD().bBg() != 2 && z2) {
            if (this.fMr == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bzD().pageContext)) != null && runTask2.getData() != null) {
                this.fMr = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.fNm == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, bzD().pageContext)) != null && runTask.getData() != null) {
                this.fNm = (g) runTask.getData();
            }
            if (this.fMr != null && this.fNm != null) {
                if (this.fNn == null) {
                    this.fNn = this.fMr.a(bzD().pageContext);
                    this.fNn.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bG(int i) {
                            if (f.this.fNo != null) {
                                f.this.fNo.bD(i);
                                if (f.this.fNq == null) {
                                    f.this.fNq = f.this.fNm.vr();
                                    f.this.fNq.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.fNq.hide();
                                            f.this.fNq.aT(false);
                                            if (f.this.fNo != null) {
                                                f.this.fNo.b(f.this.bzD().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.fNq.bD(i);
                                if (!f.this.fNo.isActive()) {
                                    f.this.fNq.I(f.this.fNt);
                                }
                            }
                        }
                    });
                    this.fNn.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int vG() {
                            return f.this.bzD().fTB.getRtcStreamStatus();
                        }
                    });
                    this.fNn.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.c
                        public void b(ak akVar, al alVar, al alVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void c(ak akVar, al alVar, al alVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void d(ak akVar, al alVar, al alVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.c
                        public void e(ak akVar, al alVar, al alVar2) {
                            f.this.bzE();
                            f.this.fNt.setVisibility(0);
                        }
                    });
                }
                if (this.fNo == null) {
                    this.fNo = this.fNm.vq();
                    this.fNo.eo(bzD().fTb.Fk().avj.portrait);
                    this.fNo.a(this.fNn);
                    this.fNo.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void vI() {
                            f.this.fNo.removeView();
                            if (f.this.fKd != null && f.this.fKd.getRootView() != null) {
                                f.this.fKd.setVisible(0);
                                f.this.fKd.vn();
                                f.this.fNt.setVisibility(8);
                            }
                            if (f.this.fNs != null) {
                                f.this.fNs.bzC();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void vJ() {
                            f.this.fNt.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.aui, aVar.auj);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void vK() {
                            if (f.this.fNq != null) {
                                f.this.fNq.aT(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void vL() {
                            if (f.this.fNq != null && !f.this.fNq.isShowing() && f.this.fNq.vp()) {
                                f.this.fNq.I(f.this.fNt);
                            }
                        }
                    });
                }
                this.fNn.e(bzD().fTb.Fk().mLiveInfo.live_id, bzD().fTb.Fk().avj.userId);
                this.fNn.a((j.InterfaceC0157j) this.fNo);
                this.fNn.a((j.a) this.fNo);
                this.fNn.a((j.d) this.fNo);
                this.fNn.a((j.i) this.fNo);
                this.fNn.a((j.h) this.fNo);
                this.fNn.a((j.g) this.fNo);
                this.fNn.a((j.f) this.fNo);
                this.fNn.a((j.c) this.fNo);
                this.fNn.setIsHost(bzD().fTb.Fk().isHost);
                if (this.fNp == null) {
                    this.fNp = this.fMr.b(bzD().pageContext);
                    this.fNp.b(false, true, z3);
                    this.fNp.a(this.fNn);
                    this.fNp.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void vs() {
                            f.this.bzD().fTc.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ak akVar, al alVar, al alVar2) {
                            if (f.this.fNs != null) {
                                f.this.fNs.a(akVar, alVar, alVar2);
                            }
                            if (f.this.fKd != null) {
                                f.this.fKd.setCanVisible(false);
                                f.this.fKd.setVisible(8);
                            }
                            f.this.bzD().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bzD().bBh();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void vt() {
                            f.this.bzD().aKz();
                            if (f.this.fNs != null) {
                                f.this.fNs.vt();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void vu() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aU(boolean z4) {
                            if (f.this.fNs != null) {
                                f.this.fNs.bzB();
                            }
                            if (f.this.fKd != null) {
                                f.this.fKd.setCanVisible(true);
                            }
                            if (f.this.fNt != null) {
                                f.this.fNt.setVisibility(0);
                            }
                            f.this.bzD().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bzE();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aV(boolean z4) {
                        }
                    });
                    this.fNp.j(bzD().rootView);
                }
                this.fNn.a((j.c) this.fNp);
                this.fNn.a((j.k) this.fNp);
                if (this.fNn.vC() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.fNt.setVisibility(0);
                }
                if (this.fKd != null && this.fKd.getRootView() != null) {
                    if (this.fKd.vl()) {
                        this.fKd.setVisible(0);
                        this.fNt.setVisibility(8);
                    } else {
                        this.fKd.setVisible(4);
                    }
                }
                if (z3 && !this.fNr) {
                    this.fNr = true;
                    this.fNn.a(this.fNu.fTI.mChallengeData);
                    if (this.fNu.fTI.mAvtsData != null) {
                        a(this.fNu.fTI.mAvtsData, this.fNu.fTI.mAvtsConfigInfo);
                        this.fNt.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.fNn != null) {
            this.fNn.aX(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzE() {
        bzD().Jh();
        bzD().bBi();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.FX().f(true, false);
        bzD().fTB.switchToCommonMode(f.getWidth(), f.getHeight());
        bzD().bBj();
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
            bzD().bBi();
            bzD().fTB.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.FX().f(true, true);
            bzD().fTB.switchToRtcMode(f.getWidth(), f.getHeight());
            bzD().bBj();
        }
    }

    public void bzF() {
        if (this.fNq != null) {
            this.fNq.hide();
        }
        if (this.fNo != null) {
            this.fNo.b(bzD().rootView, true);
        }
    }

    public void a(q qVar) {
        if (this.fNp != null) {
            this.fNp.a(qVar);
        }
        if (this.fKd != null) {
            this.fKd.b(qVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.fNq != null && this.fNq.vp()) {
            this.fNq.I(imageView);
        }
    }

    public void Ji() {
        if (this.fNq != null) {
            this.fNq.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.fNo != null && this.fNo.isActive() && this.fNo.onBackKeyDown();
    }

    public void bzG() {
        if (this.fNn != null) {
            this.fNn.vm();
            this.fNn.onDestroy();
        }
        if (this.fKd != null) {
            this.fKd.vm();
            this.fKd.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fNp != null) {
            this.fNp.vv();
        }
    }

    public void onDestroy() {
        if (this.fNp != null) {
            this.fNp.onDestroy();
        }
        if (this.fNq != null) {
            this.fNq.hide();
        }
        if (this.fNo != null) {
            this.fNo.removeView();
        }
    }

    public boolean bzH() {
        return this.fNp != null && this.fNp.isActive();
    }

    public int aW(boolean z) {
        if (this.fNp != null) {
            return this.fNp.aW(z);
        }
        return 0;
    }

    public boolean bzI() {
        return this.fKd != null && this.fKd.vl();
    }

    public void en(String str) {
        if (this.fNn != null) {
            this.fNn.en(str);
        }
    }

    public void F(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bzD().bBg() != 2 && com.baidu.live.v.a.Ge().aWF.axA) {
            if (this.fKd == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bzD().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.fKd = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.fKd != null) {
                this.fKd.a(bzD().fTb.bFx(), true, z2);
                this.fKd.a(new a.InterfaceC0158a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.fKd.getRootView() != null && this.fKd.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.fKd.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bzD().fTc.addView(this.fKd.getRootView(), layoutParams);
                }
                this.fKd.a(null, bzD().fTb.Fk());
                if (this.fNu != null && this.fNu.fTI != null && this.fNu.fTI.mPkData != null) {
                    this.fKd.bC(this.fNu.fTI.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.fNs = eVar;
    }
}

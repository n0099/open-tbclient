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
    private com.baidu.live.d.a eRI;
    private com.baidu.live.challenge.f eTQ;
    private com.baidu.tieba.ala.liveroom.data.f eUL;
    private g eUM;
    private j eUN;
    private k eUO;
    private i eUP;
    private com.baidu.live.challenge.e eUQ;
    private boolean eUR = false;
    private e eUS;
    private ImageView eUT;
    private com.baidu.tieba.ala.liveroom.data.g eUU;

    public f(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.eUL = fVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.g gVar) {
        this.eUT = imageView;
        this.eUU = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.f bkm() {
        return this.eUL;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bkm().blS() != 2 && z2) {
            if (this.eTQ == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bkm().pageContext)) != null && runTask2.getData() != null) {
                this.eTQ = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.eUM == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, bkm().pageContext)) != null && runTask.getData() != null) {
                this.eUM = (g) runTask.getData();
            }
            if (this.eTQ != null && this.eUM != null) {
                if (this.eUN == null) {
                    this.eUN = this.eTQ.a(bkm().pageContext);
                    this.eUN.a(new j.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.b
                        public void bm(int i) {
                            if (f.this.eUO != null) {
                                f.this.eUO.bj(i);
                                if (f.this.eUQ == null) {
                                    f.this.eUQ = f.this.eUM.pU();
                                    f.this.eUQ.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.eUQ.hide();
                                            f.this.eUQ.as(false);
                                            if (f.this.eUO != null) {
                                                f.this.eUO.b(f.this.bkm().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.eUQ.bj(i);
                                if (!f.this.eUO.isActive()) {
                                    f.this.eUQ.J(f.this.eUT);
                                }
                            }
                        }
                    });
                    this.eUN.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.e
                        public int qj() {
                            return f.this.bkm().fbt.getRtcStreamStatus();
                        }
                    });
                    this.eUN.a(new j.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
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
                            f.this.bkn();
                            f.this.eUT.setVisibility(0);
                        }
                    });
                }
                if (this.eUO == null) {
                    this.eUO = this.eUM.pT();
                    this.eUO.cU(bkm().faT.yT().Ya.portrait);
                    this.eUO.a(this.eUN);
                    this.eUO.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void ql() {
                            f.this.eUO.removeView();
                            if (f.this.eRI != null && f.this.eRI.getRootView() != null) {
                                f.this.eRI.setVisible(0);
                                f.this.eRI.pQ();
                                f.this.eUT.setVisibility(8);
                            }
                            if (f.this.eUS != null) {
                                f.this.eUS.bkl();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qm() {
                            f.this.eUT.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.Xg, aVar.Xh);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qn() {
                            if (f.this.eUQ != null) {
                                f.this.eUQ.as(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void qo() {
                            if (f.this.eUQ != null && !f.this.eUQ.isShowing() && f.this.eUQ.pS()) {
                                f.this.eUQ.J(f.this.eUT);
                            }
                        }
                    });
                }
                this.eUN.d(bkm().faT.yT().mLiveInfo.live_id, bkm().faT.yT().Ya.userId);
                this.eUN.a((j.InterfaceC0081j) this.eUO);
                this.eUN.a((j.a) this.eUO);
                this.eUN.a((j.d) this.eUO);
                this.eUN.a((j.i) this.eUO);
                this.eUN.a((j.h) this.eUO);
                this.eUN.a((j.g) this.eUO);
                this.eUN.a((j.f) this.eUO);
                this.eUN.a((j.c) this.eUO);
                if (this.eUP == null) {
                    this.eUP = this.eTQ.b(bkm().pageContext);
                    this.eUP.b(false, true, z3);
                    this.eUP.a(this.eUN);
                    this.eUP.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void pV() {
                            f.this.bkm().faU.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(ad adVar, ae aeVar, ae aeVar2) {
                            if (f.this.eUS != null) {
                                f.this.eUS.a(adVar, aeVar, aeVar2);
                            }
                            if (f.this.eRI != null) {
                                f.this.eRI.setCanVisible(false);
                                f.this.eRI.setVisible(8);
                            }
                            f.this.bkm().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bkm().blU();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pW() {
                            f.this.bkm().awT();
                            if (f.this.eUS != null) {
                                f.this.eUS.pW();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pX() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void at(boolean z4) {
                            if (f.this.eUS != null) {
                                f.this.eUS.bkk();
                            }
                            if (f.this.eRI != null) {
                                f.this.eRI.setCanVisible(true);
                            }
                            if (f.this.eUT != null) {
                                f.this.eUT.setVisibility(0);
                            }
                            f.this.bkm().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bkn();
                        }
                    });
                    this.eUP.e(bkm().rootView);
                }
                this.eUN.a((j.c) this.eUP);
                this.eUN.a((j.k) this.eUP);
                if (this.eUN.qf() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.eUT.setVisibility(0);
                }
                if (this.eRI != null && this.eRI.getRootView() != null) {
                    if (this.eRI.pO()) {
                        this.eRI.setVisible(0);
                        this.eUT.setVisibility(8);
                    } else {
                        this.eRI.setVisible(4);
                    }
                }
                if (z3 && !this.eUR) {
                    this.eUR = true;
                    this.eUN.a(this.eUU.fbA.mChallengeData);
                    if (this.eUU.fbA.mAvtsData != null) {
                        a(this.eUU.fbA.mAvtsData, this.eUU.fbA.mAvtsConfigInfo);
                        this.eUT.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.eUN != null) {
            this.eUN.av(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkn() {
        bkm().blT();
        bkm().blV();
        LiveRecorderConfigHelper.VideoResolution g = LiveRecorderConfigHelper.zn().g(true, false);
        bkm().fbt.switchToCommonMode(g.getWidth(), g.getHeight());
        bkm().blW();
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
            bkm().blV();
            bkm().fbt.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution g = LiveRecorderConfigHelper.zn().g(true, true);
            bkm().fbt.switchToRtcMode(g.getWidth(), g.getHeight());
            bkm().blW();
        }
    }

    public void bko() {
        if (this.eUQ != null) {
            this.eUQ.hide();
        }
        if (this.eUO != null) {
            this.eUO.b(bkm().rootView, true);
        }
    }

    public void a(m mVar) {
        if (this.eUP != null) {
            this.eUP.a(mVar);
        }
        if (this.eRI != null) {
            this.eRI.b(mVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.eUQ != null && this.eUQ.pS()) {
            this.eUQ.J(imageView);
        }
    }

    public void bkp() {
        if (this.eUQ != null) {
            this.eUQ.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.eUO != null && this.eUO.isActive() && this.eUO.onBackKeyDown();
    }

    public void bkq() {
        if (this.eUN != null) {
            this.eUN.pP();
            this.eUN.onDestroy();
        }
        if (this.eRI != null) {
            this.eRI.pP();
            this.eRI.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.eUP != null) {
            this.eUP.pY();
        }
    }

    public void onDestroy() {
        if (this.eUP != null) {
            this.eUP.onDestroy();
        }
        if (this.eUQ != null) {
            this.eUQ.hide();
        }
        if (this.eUO != null) {
            this.eUO.removeView();
        }
    }

    public boolean bkr() {
        return this.eUP != null && this.eUP.isActive();
    }

    public int au(boolean z) {
        if (this.eUP != null) {
            return this.eUP.au(z);
        }
        return 0;
    }

    public boolean bks() {
        return this.eRI != null && this.eRI.pO();
    }

    public void cT(String str) {
        if (this.eUN != null) {
            this.eUN.cT(str);
        }
    }

    public void D(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bkm().blS() != 2 && com.baidu.live.v.a.zs().awM.aaf) {
            if (this.eRI == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bkm().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eRI = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eRI != null) {
                this.eRI.a(bkm().faT.bpY(), true, z2);
                this.eRI.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.eRI.getRootView() != null && this.eRI.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.eRI.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bkm().faU.addView(this.eRI.getRootView(), layoutParams);
                }
                this.eRI.a(null, bkm().faT.yT());
                if (this.eUU != null && this.eUU.fbA != null && this.eUU.fbA.mPkData != null) {
                    this.eRI.bi(this.eUU.fbA.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.eUS = eVar;
    }
}

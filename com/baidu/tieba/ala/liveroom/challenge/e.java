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
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.data.w;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.d.a gPL;
    private com.baidu.live.challenge.e gSp;
    private f gTF;
    private com.baidu.live.challenge.f gTG;
    private i gTH;
    private j gTI;
    private h gTJ;
    private d gTL;
    private ImageView gTM;
    private g gTN;
    private boolean gTK = false;
    private boolean gTO = false;

    public e(f fVar) {
        this.gTF = fVar;
    }

    public void a(ImageView imageView, g gVar, boolean z) {
        this.gTM = imageView;
        this.gTN = gVar;
        this.gTO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f bWT() {
        return this.gTF;
    }

    public void j(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bWT().bYP() != 2) {
            if (!z2) {
                this.gTM.setVisibility(0);
            }
            if (this.gSp == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bWT().pageContext)) != null && runTask2.getData() != null) {
                this.gSp = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gTG == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, bWT().pageContext)) != null && runTask.getData() != null) {
                this.gTG = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.gSp != null && this.gTG != null) {
                if (this.gTH == null) {
                    this.gTH = this.gSp.a(bWT().pageContext);
                    this.gTH.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void dO(int i) {
                            if (e.this.gTI != null) {
                                e.this.gTI.dP(i);
                            }
                        }
                    });
                    this.gTH.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int Dn() {
                            return e.this.bWT().hba.getRtcStreamStatus();
                        }
                    });
                    this.gTH.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(ax axVar, bb bbVar, bb bbVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(ax axVar, bb bbVar, bb bbVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(ax axVar, bb bbVar, bb bbVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(ax axVar, bb bbVar, bb bbVar2) {
                            e.this.bWU();
                            e.this.gTM.setVisibility(0);
                        }
                    });
                }
                if (this.gTI == null) {
                    this.gTI = this.gTG.CW();
                    this.gTI.setUserId(String.valueOf(bWT().haB.GH().aIe.userId));
                    this.gTI.gf(bWT().haB.GH().aIe.portrait);
                    this.gTI.a(this.gTH);
                    this.gTI.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void Dp() {
                            e.this.gTI.removeView();
                            if (e.this.gPL != null && e.this.gPL.getRootView() != null) {
                                e.this.gPL.setVisible(0);
                                e.this.gPL.CU();
                            }
                            if (e.this.gTL != null) {
                                e.this.gTL.bWS();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Dq() {
                            e.this.gTM.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aGp, aVar.aGq);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Dr() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Ds() {
                        }
                    });
                }
                this.gTH.e(bWT().haB.GH().mLiveInfo.live_id, bWT().haB.GH().aIe.userId);
                this.gTH.a((i.m) this.gTI);
                this.gTH.a((i.a) this.gTI);
                this.gTH.a((i.e) this.gTI);
                this.gTH.a((i.k) this.gTI);
                this.gTH.a((i.InterfaceC0175i) this.gTI);
                this.gTH.a((i.l) this.gTI);
                this.gTH.a((i.h) this.gTI);
                this.gTH.a((i.g) this.gTI);
                this.gTH.a((i.c) this.gTI);
                this.gTH.a((i.j) this.gTI);
                this.gTH.setIsHost(bWT().haB.GH().isHost);
                if (this.gTJ == null) {
                    this.gTJ = this.gSp.b(bWT().pageContext);
                    this.gTJ.b(false, true, z3);
                    this.gTJ.a(this.gTH);
                    this.gTJ.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void CX() {
                            e.this.bWT().haC.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(ax axVar, bb bbVar, bb bbVar2) {
                            if (e.this.gTL != null) {
                                e.this.gTL.a(axVar, bbVar, bbVar2);
                            }
                            if (e.this.gPL != null) {
                                e.this.gPL.setCanVisible(false);
                                e.this.gPL.setVisible(8);
                            }
                            e.this.bWT().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            e.this.bWT().bYQ();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void CY() {
                            e.this.bWT().bcW();
                            if (e.this.gTL != null) {
                                e.this.gTL.CY();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void CZ() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bh(boolean z4) {
                            if (e.this.gTL != null) {
                                e.this.gTL.bWR();
                            }
                            if (e.this.gPL != null) {
                                e.this.gPL.setCanVisible(true);
                            }
                            if (e.this.gTM != null) {
                                e.this.gTM.setVisibility(0);
                            }
                            e.this.bWT().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            e.this.bWU();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bi(boolean z4) {
                        }
                    });
                    this.gTJ.m(bWT().hbc);
                }
                this.gTH.a((i.c) this.gTJ);
                this.gTH.a((i.n) this.gTJ);
                this.gTH.a((i.d) this.gTJ);
                if (this.gTH.Di() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gTM.setVisibility(0);
                }
                if (this.gPL != null && this.gPL.getRootView() != null) {
                    if (this.gPL.CS()) {
                        this.gPL.setVisible(0);
                        this.gTM.setVisibility(0);
                    } else {
                        this.gPL.setVisible(4);
                    }
                }
                if (z3 && !this.gTK) {
                    this.gTK = true;
                    this.gTH.a(this.gTN.hbi.mChallengeData);
                    if (this.gTN.hbi.mAvtsData != null) {
                        a(this.gTN.hbi.mAvtsData, this.gTN.hbi.mAvtsConfigInfo);
                        this.gTM.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gTH != null) {
            this.gTH.bk(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWU() {
        bWT().TS();
        bWT().bYR();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.ON().f(true, false);
        bWT().hba.switchToCommonMode(f.getWidth(), f.getHeight());
        bWT().bYS();
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
            bWT().bYR();
            bWT().hba.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.ON().f(true, true);
            bWT().hba.switchToRtcMode(f.getWidth(), f.getHeight());
            bWT().bYS();
        }
    }

    public boolean bWV() {
        return this.gTH.Di() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean bWW() {
        return this.gTH.Di() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void bWX() {
        if (this.gTI != null) {
            this.gTI.bl(this.gTO);
            this.gTI.b(bWT().hbc, true);
        }
    }

    public void bWY() {
        if (this.gTI != null && this.gTI.isActive()) {
            this.gTI.onBackKeyDown();
        }
    }

    public void a(w wVar) {
        if (this.gTJ != null) {
            this.gTJ.a(wVar);
        }
        if (this.gPL != null) {
            this.gPL.b(wVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gTI != null && this.gTI.isActive() && this.gTI.onBackKeyDown();
    }

    public void bWZ() {
        if (this.gTH != null) {
            this.gTH.CT();
            this.gTH.onDestroy();
        }
        if (this.gPL != null) {
            this.gPL.CT();
            this.gPL.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gTJ != null) {
            this.gTJ.Da();
        }
    }

    public void onDestroy() {
        if (this.gTJ != null) {
            this.gTJ.onDestroy();
        }
        if (this.gTI != null) {
            this.gTI.removeView();
        }
    }

    public boolean bXa() {
        return this.gTJ != null && this.gTJ.isActive();
    }

    public int bj(boolean z) {
        if (this.gTJ != null) {
            return this.gTJ.bj(z);
        }
        return 0;
    }

    public boolean bXb() {
        return this.gPL != null && this.gPL.CS();
    }

    public void gc(String str) {
        if (this.gTH != null) {
            this.gTH.gc(str);
        }
    }

    public void N(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bWT().bYP() != 2 && com.baidu.live.z.a.Pq().bmJ.aLd) {
            if (this.gPL == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bWT().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gPL = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gPL != null) {
                this.gPL.a(bWT().haB.cdY(), true, z2);
                this.gPL.a(new a.InterfaceC0176a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gPL.getRootView() != null && this.gPL.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.gPL.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bWT().haC.addView(this.gPL.getRootView(), layoutParams);
                }
                this.gPL.a(null, bWT().haB.GH());
                if (this.gTN != null && this.gTN.hbi != null && this.gTN.hbi.mPkData != null) {
                    this.gPL.dL(this.gTN.hbi.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gTL = dVar;
    }

    public int bWC() {
        int i = 0;
        if (this.gTJ != null) {
            i = this.gTJ.bj(true);
        }
        return i + bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }
}

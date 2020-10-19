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
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.u;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.d.a gDX;
    private com.baidu.live.challenge.e gGA;
    private f gHQ;
    private com.baidu.live.challenge.f gHR;
    private i gHS;
    private j gHT;
    private h gHU;
    private d gHW;
    private ImageView gHX;
    private g gHY;
    private boolean gHV = false;
    private boolean gHZ = false;

    public e(f fVar) {
        this.gHQ = fVar;
    }

    public void a(ImageView imageView, g gVar, boolean z) {
        this.gHX = imageView;
        this.gHY = gVar;
        this.gHZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f bTU() {
        return this.gHQ;
    }

    public void j(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bTU().bVQ() != 2) {
            if (!z2) {
                this.gHX.setVisibility(0);
            }
            if (this.gGA == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bTU().pageContext)) != null && runTask2.getData() != null) {
                this.gGA = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gHR == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, bTU().pageContext)) != null && runTask.getData() != null) {
                this.gHR = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.gGA != null && this.gHR != null) {
                if (this.gHS == null) {
                    this.gHS = this.gGA.a(bTU().pageContext);
                    this.gHS.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void dO(int i) {
                            if (e.this.gHT != null) {
                                e.this.gHT.dP(i);
                            }
                        }
                    });
                    this.gHS.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int Dg() {
                            return e.this.bTU().gPm.getRtcStreamStatus();
                        }
                    });
                    this.gHS.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(au auVar, ay ayVar, ay ayVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(au auVar, ay ayVar, ay ayVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(au auVar, ay ayVar, ay ayVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(au auVar, ay ayVar, ay ayVar2) {
                            e.this.bTV();
                            e.this.gHX.setVisibility(0);
                        }
                    });
                }
                if (this.gHT == null) {
                    this.gHT = this.gHR.CQ();
                    this.gHT.setUserId(String.valueOf(bTU().gON.Gm().aHD.userId));
                    this.gHT.ge(bTU().gON.Gm().aHD.portrait);
                    this.gHT.a(this.gHS);
                    this.gHT.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void Di() {
                            e.this.gHT.removeView();
                            if (e.this.gDX != null && e.this.gDX.getRootView() != null) {
                                e.this.gDX.setVisible(0);
                                e.this.gDX.CO();
                            }
                            if (e.this.gHW != null) {
                                e.this.gHW.bTT();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Dj() {
                            e.this.gHX.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aGh, aVar.aGi);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Dk() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Dl() {
                        }
                    });
                }
                this.gHS.e(bTU().gON.Gm().mLiveInfo.live_id, bTU().gON.Gm().aHD.userId);
                this.gHS.a((i.m) this.gHT);
                this.gHS.a((i.a) this.gHT);
                this.gHS.a((i.e) this.gHT);
                this.gHS.a((i.k) this.gHT);
                this.gHS.a((i.InterfaceC0174i) this.gHT);
                this.gHS.a((i.l) this.gHT);
                this.gHS.a((i.h) this.gHT);
                this.gHS.a((i.g) this.gHT);
                this.gHS.a((i.c) this.gHT);
                this.gHS.a((i.j) this.gHT);
                this.gHS.setIsHost(bTU().gON.Gm().isHost);
                if (this.gHU == null) {
                    this.gHU = this.gGA.b(bTU().pageContext);
                    this.gHU.b(false, true, z3);
                    this.gHU.a(this.gHS);
                    this.gHU.a(new com.baidu.live.challenge.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void CR() {
                            e.this.bTU().gOO.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(au auVar, ay ayVar, ay ayVar2) {
                            if (e.this.gHW != null) {
                                e.this.gHW.a(auVar, ayVar, ayVar2);
                            }
                            if (e.this.gDX != null) {
                                e.this.gDX.setCanVisible(false);
                                e.this.gDX.setVisible(8);
                            }
                            e.this.bTU().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            e.this.bTU().bVR();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void CS() {
                            e.this.bTU().bbd();
                            if (e.this.gHW != null) {
                                e.this.gHW.CS();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void CT() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bg(boolean z4) {
                            if (e.this.gHW != null) {
                                e.this.gHW.bTS();
                            }
                            if (e.this.gDX != null) {
                                e.this.gDX.setCanVisible(true);
                            }
                            if (e.this.gHX != null) {
                                e.this.gHX.setVisibility(0);
                            }
                            e.this.bTU().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            e.this.bTV();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bh(boolean z4) {
                        }
                    });
                    this.gHU.m(bTU().gPo);
                }
                this.gHS.a((i.c) this.gHU);
                this.gHS.a((i.n) this.gHU);
                this.gHS.a((i.d) this.gHU);
                if (this.gHS.Db() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gHX.setVisibility(0);
                }
                if (this.gDX != null && this.gDX.getRootView() != null) {
                    if (this.gDX.CM()) {
                        this.gDX.setVisible(0);
                        this.gHX.setVisibility(0);
                    } else {
                        this.gDX.setVisible(4);
                    }
                }
                if (z3 && !this.gHV) {
                    this.gHV = true;
                    this.gHS.a(this.gHY.gPu.mChallengeData);
                    if (this.gHY.gPu.mAvtsData != null) {
                        a(this.gHY.gPu.mAvtsData, this.gHY.gPu.mAvtsConfigInfo);
                        this.gHX.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gHS != null) {
            this.gHS.bj(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTV() {
        bTU().ST();
        bTU().bVS();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Op().f(true, false);
        bTU().gPm.switchToCommonMode(f.getWidth(), f.getHeight());
        bTU().bVT();
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
            bTU().bVS();
            bTU().gPm.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Op().f(true, true);
            bTU().gPm.switchToRtcMode(f.getWidth(), f.getHeight());
            bTU().bVT();
        }
    }

    public boolean bTW() {
        return this.gHS.Db() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean bTX() {
        return this.gHS.Db() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void bTY() {
        if (this.gHT != null) {
            this.gHT.bk(this.gHZ);
            this.gHT.b(bTU().gPo, true);
        }
    }

    public void bTZ() {
        if (this.gHT != null && this.gHT.isActive()) {
            this.gHT.onBackKeyDown();
        }
    }

    public void a(u uVar) {
        if (this.gHU != null) {
            this.gHU.a(uVar);
        }
        if (this.gDX != null) {
            this.gDX.b(uVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gHT != null && this.gHT.isActive() && this.gHT.onBackKeyDown();
    }

    public void bUa() {
        if (this.gHS != null) {
            this.gHS.CN();
            this.gHS.onDestroy();
        }
        if (this.gDX != null) {
            this.gDX.CN();
            this.gDX.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gHU != null) {
            this.gHU.CU();
        }
    }

    public void onDestroy() {
        if (this.gHU != null) {
            this.gHU.onDestroy();
        }
        if (this.gHT != null) {
            this.gHT.removeView();
        }
    }

    public boolean bUb() {
        return this.gHU != null && this.gHU.isActive();
    }

    public int bi(boolean z) {
        if (this.gHU != null) {
            return this.gHU.bi(z);
        }
        return 0;
    }

    public boolean bUc() {
        return this.gDX != null && this.gDX.CM();
    }

    public void gb(String str) {
        if (this.gHS != null) {
            this.gHS.gb(str);
        }
    }

    public void K(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bTU().bVQ() != 2 && com.baidu.live.x.a.OS().blo.aKB) {
            if (this.gDX == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bTU().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gDX = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gDX != null) {
                this.gDX.a(bTU().gON.caU(), true, z2);
                this.gDX.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gDX.getRootView() != null && this.gDX.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.gDX.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bTU().gOO.addView(this.gDX.getRootView(), layoutParams);
                }
                this.gDX.a(null, bTU().gON.Gm());
                if (this.gHY != null && this.gHY.gPu != null && this.gHY.gPu.mPkData != null) {
                    this.gDX.dL(this.gHY.gPu.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gHW = dVar;
    }

    public int bTE() {
        int i = 0;
        if (this.gHU != null) {
            i = this.gHU.bi(true);
        }
        return i + bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }
}

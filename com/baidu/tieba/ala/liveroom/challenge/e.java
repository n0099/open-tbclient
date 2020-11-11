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
import com.baidu.live.d.a;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.w;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.d.a gVP;
    private com.baidu.live.challenge.e gYu;
    private com.baidu.tieba.ala.liveroom.data.e gZK;
    private f gZL;
    private i gZM;
    private j gZN;
    private h gZO;
    private d gZQ;
    private ImageView gZR;
    private com.baidu.tieba.ala.liveroom.data.f gZS;
    private boolean gZP = false;
    private boolean gZT = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gZK = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.gZR = imageView;
        this.gZS = fVar;
        this.gZT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e bZv() {
        return this.gZK;
    }

    public void j(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bZv().cbr() != 2) {
            if (!z2) {
                this.gZR.setVisibility(0);
            }
            if (this.gYu == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, bZv().pageContext)) != null && runTask2.getData() != null) {
                this.gYu = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.gZL == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, bZv().pageContext)) != null && runTask.getData() != null) {
                this.gZL = (f) runTask.getData();
            }
            if (this.gYu != null && this.gZL != null) {
                if (this.gZM == null) {
                    this.gZM = this.gYu.a(bZv().pageContext);
                    this.gZM.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void dO(int i) {
                            if (e.this.gZN != null) {
                                e.this.gZN.dP(i);
                            }
                        }
                    });
                    this.gZM.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int DG() {
                            return e.this.bZv().hgU.getRtcStreamStatus();
                        }
                    });
                    this.gZM.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(az azVar, bd bdVar, bd bdVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(az azVar, bd bdVar, bd bdVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(az azVar, bd bdVar, bd bdVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(az azVar, bd bdVar, bd bdVar2) {
                            e.this.bZw();
                            e.this.gZR.setVisibility(0);
                        }
                    });
                }
                if (this.gZN == null) {
                    this.gZN = this.gZL.Dp();
                    this.gZN.setUserId(String.valueOf(bZv().hgD.Hi().aIV.userId));
                    this.gZN.setUserPortrait(bZv().hgD.Hi().aIV.portrait);
                    this.gZN.a(this.gZM);
                    this.gZN.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void DI() {
                            e.this.gZN.removeView();
                            if (e.this.gVP != null && e.this.gVP.getRootView() != null) {
                                e.this.gVP.setVisible(0);
                                e.this.gVP.Dn();
                            }
                            if (e.this.gZQ != null) {
                                e.this.gZQ.bZu();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void DJ() {
                            e.this.gZR.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aHf, aVar.aHg);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void DK() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void DL() {
                        }
                    });
                }
                this.gZM.e(bZv().hgD.Hi().mLiveInfo.live_id, bZv().hgD.Hi().aIV.userId);
                this.gZM.a((i.m) this.gZN);
                this.gZM.a((i.a) this.gZN);
                this.gZM.a((i.e) this.gZN);
                this.gZM.a((i.k) this.gZN);
                this.gZM.a((i.InterfaceC0177i) this.gZN);
                this.gZM.a((i.l) this.gZN);
                this.gZM.a((i.h) this.gZN);
                this.gZM.a((i.g) this.gZN);
                this.gZM.a((i.c) this.gZN);
                this.gZM.a((i.j) this.gZN);
                this.gZM.setIsHost(bZv().hgD.Hi().isHost);
                if (this.gZO == null) {
                    this.gZO = this.gYu.b(bZv().pageContext);
                    this.gZO.b(false, true, z3);
                    this.gZO.a(this.gZM);
                    this.gZO.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void Dq() {
                            e.this.bZv().hgE.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(az azVar, bd bdVar, bd bdVar2) {
                            if (e.this.gZQ != null) {
                                e.this.gZQ.a(azVar, bdVar, bdVar2);
                            }
                            if (e.this.gVP != null) {
                                e.this.gVP.setCanVisible(false);
                                e.this.gVP.setVisible(8);
                            }
                            e.this.bZv().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.bZv().cbs();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Dr() {
                            e.this.bZv().bfw();
                            if (e.this.gZQ != null) {
                                e.this.gZQ.Dr();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Ds() {
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bi(boolean z4) {
                            if (e.this.gZQ != null) {
                                e.this.gZQ.bZt();
                            }
                            if (e.this.gVP != null) {
                                e.this.gVP.setCanVisible(true);
                            }
                            if (e.this.gZR != null) {
                                e.this.gZR.setVisibility(0);
                            }
                            e.this.bZv().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.bZw();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bj(boolean z4) {
                        }
                    });
                    this.gZO.m(bZv().hgX);
                }
                this.gZM.a((i.c) this.gZO);
                this.gZM.a((i.n) this.gZO);
                this.gZM.a((i.d) this.gZO);
                if (this.gZM.DB() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.gZR.setVisibility(0);
                }
                if (this.gVP != null && this.gVP.getRootView() != null) {
                    if (this.gVP.Dl()) {
                        this.gVP.setVisible(0);
                        this.gZR.setVisibility(0);
                    } else {
                        this.gVP.setVisible(4);
                    }
                }
                if (z3 && !this.gZP) {
                    this.gZP = true;
                    this.gZM.a(this.gZS.hhd.mChallengeData);
                    if (this.gZS.hhd.mAvtsData != null) {
                        a(this.gZS.hhd.mAvtsData, this.gZS.hhd.mAvtsConfigInfo);
                        this.gZR.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.gZM != null) {
            this.gZM.bl(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZw() {
        bZv().Ws();
        bZv().cbt();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Pn().f(true, false);
        bZv().hgU.switchToCommonMode(f.getWidth(), f.getHeight());
        bZv().cbu();
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
            bZv().cbt();
            bZv().hgU.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Pn().f(true, true);
            bZv().hgU.switchToRtcMode(f.getWidth(), f.getHeight());
            bZv().cbu();
        }
    }

    public boolean bZx() {
        return this.gZM.DB() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean bZy() {
        return this.gZM.DB() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void bZz() {
        if (this.gZN != null) {
            this.gZN.bm(this.gZT);
            this.gZN.b(bZv().hgX, true);
        }
    }

    public void bZA() {
        if (this.gZN != null && this.gZN.isActive()) {
            this.gZN.onBackKeyDown();
        }
    }

    public void a(w wVar) {
        if (this.gZO != null) {
            this.gZO.a(wVar);
        }
        if (this.gVP != null) {
            this.gVP.b(wVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gZN != null && this.gZN.isActive() && this.gZN.onBackKeyDown();
    }

    public void bZB() {
        if (this.gZM != null) {
            this.gZM.Dm();
            this.gZM.onDestroy();
        }
        if (this.gVP != null) {
            this.gVP.Dm();
            this.gVP.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gZO != null) {
            this.gZO.Dt();
        }
    }

    public void onDestroy() {
        if (this.gZO != null) {
            this.gZO.onDestroy();
        }
        if (this.gZN != null) {
            this.gZN.removeView();
        }
    }

    public boolean bZC() {
        return this.gZO != null && this.gZO.isActive();
    }

    public int bk(boolean z) {
        if (this.gZO != null) {
            return this.gZO.bk(z);
        }
        return 0;
    }

    public boolean bZD() {
        return this.gVP != null && this.gVP.Dl();
    }

    public void gh(String str) {
        if (this.gZM != null) {
            this.gZM.gh(str);
        }
    }

    public void N(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bZv().cbr() != 2 && com.baidu.live.aa.a.PQ().bod.aMd) {
            if (this.gVP == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bZv().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.gVP = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.gVP != null) {
                this.gVP.a(bZv().hgD.cgz(), true, z2);
                this.gVP.a(new a.InterfaceC0178a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.gVP.getRootView() != null && this.gVP.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.gVP.getRootView().setId(a.f.ala_live_room_pk_panel);
                    bZv().hgE.addView(this.gVP.getRootView(), layoutParams);
                }
                this.gVP.a(null, bZv().hgD.Hi());
                if (this.gZS != null && this.gZS.hhd != null && this.gZS.hhd.mPkData != null) {
                    this.gVP.dL(this.gZS.hhd.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.gZQ = dVar;
    }

    public int bZe() {
        int i = 0;
        if (this.gZO != null) {
            i = this.gZO.bk(true);
        }
        return i + bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

package com.baidu.tieba.ala.liveroom.challenge;

import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.g;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.challenge.k;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.ab;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.e.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.z.a.b;
import com.baidu.tieba.ala.liveroom.data.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    private com.baidu.live.e.a hsj;
    private com.baidu.live.challenge.e hvb;
    private i hwA;
    private j hwB;
    private h hwC;
    private d hwE;
    private ImageView hwF;
    private f hwG;
    private com.baidu.tieba.ala.liveroom.data.e hwy;
    private com.baidu.live.challenge.f hwz;
    private boolean hwD = false;
    private boolean hwH = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hwy = eVar;
    }

    public void a(ImageView imageView, f fVar, boolean z) {
        this.hwF = imageView;
        this.hwG = fVar;
        this.hwH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e ccR() {
        return this.hwy;
    }

    public void k(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && ccR().bRl() != 2) {
            if (!z2) {
                this.hwF.setVisibility(0);
            }
            if (this.hvb == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, ccR().pageContext)) != null && runTask2.getData() != null) {
                this.hvb = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.hwz == null && (runTask = MessageManager.getInstance().runTask(2913114, com.baidu.live.challenge.f.class, ccR().pageContext)) != null && runTask.getData() != null) {
                this.hwz = (com.baidu.live.challenge.f) runTask.getData();
            }
            if (this.hvb != null && this.hwz != null) {
                if (this.hwA == null) {
                    this.hwA = this.hvb.a(ccR().pageContext);
                    this.hwA.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void cy(int i) {
                            if (e.this.hwB != null) {
                                e.this.hwB.cz(i);
                            }
                        }
                    });
                    this.hwA.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int AO() {
                            return e.this.ccR().hDH.getRtcStreamStatus();
                        }
                    });
                    this.hwA.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(bg bgVar, bk bkVar, bk bkVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(bg bgVar, bk bkVar, bk bkVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(bg bgVar, bk bkVar, bk bkVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(bg bgVar, bk bkVar, bk bkVar2) {
                            e.this.ccS();
                            e.this.hwF.setVisibility(0);
                        }
                    });
                }
                if (this.hwB == null) {
                    this.hwB = this.hwz.Ax();
                    this.hwB.setUserId(String.valueOf(ccR().hDq.Fp().aJD.userId));
                    this.hwB.setUserPortrait(ccR().hDq.Fp().aJD.portrait);
                    this.hwB.a(this.hwA);
                    this.hwB.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void AQ() {
                            e.this.hwB.removeView();
                            if (e.this.hsj != null && e.this.hsj.getRootView() != null) {
                                e.this.hsj.setVisible(0);
                                e.this.hsj.Av();
                            }
                            if (e.this.hwE != null) {
                                e.this.hwE.ccQ();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void AR() {
                            e.this.hwF.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aGY, aVar.aGZ);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void AS() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void AT() {
                        }
                    });
                }
                this.hwA.h(ccR().hDq.Fp().mLiveInfo.live_id, ccR().hDq.Fp().aJD.userId);
                this.hwA.a((i.m) this.hwB);
                this.hwA.a((i.a) this.hwB);
                this.hwA.a((i.e) this.hwB);
                this.hwA.a((i.k) this.hwB);
                this.hwA.a((i.InterfaceC0172i) this.hwB);
                this.hwA.a((i.l) this.hwB);
                this.hwA.a((i.h) this.hwB);
                this.hwA.a((i.g) this.hwB);
                this.hwA.a((i.c) this.hwB);
                this.hwA.a((i.j) this.hwB);
                this.hwA.setIsHost(ccR().hDq.Fp().isHost);
                if (this.hwC == null) {
                    this.hwC = this.hvb.b(ccR().pageContext);
                    this.hwC.c(false, true, z3);
                    this.hwC.a(this.hwA);
                    this.hwC.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void Ay() {
                            e.this.ccR().hDr.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(bg bgVar, bk bkVar, bk bkVar2) {
                            if (e.this.hwE != null) {
                                e.this.hwE.a(bgVar, bkVar, bkVar2);
                            }
                            if (e.this.hsj != null) {
                                e.this.hsj.setCanVisible(false);
                                e.this.hsj.setVisible(8);
                            }
                            e.this.ccR().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.ccR().ceO();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("challengeId", bgVar.challengeId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "one_to_two_start").setContentExt(null, null, jSONObject));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Az() {
                            e.this.ccR().ceN();
                            if (e.this.hwE != null) {
                                e.this.hwE.Az();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void AA() {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "two_to_one_start").setContentExt(null, null, null));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bn(boolean z4) {
                            if (e.this.hwE != null) {
                                e.this.hwE.ccP();
                            }
                            if (e.this.hsj != null) {
                                e.this.hsj.setCanVisible(true);
                            }
                            if (e.this.hwF != null) {
                                e.this.hwF.setVisibility(0);
                            }
                            e.this.ccR().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.ccS();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bo(boolean z4) {
                        }
                    });
                    this.hwC.k(ccR().hDK);
                }
                this.hwA.a((i.c) this.hwC);
                this.hwA.a((i.n) this.hwC);
                this.hwA.a((i.d) this.hwC);
                if (this.hwA.AJ() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.hwF.setVisibility(0);
                }
                if (this.hsj != null && this.hsj.getRootView() != null) {
                    if (this.hsj.At()) {
                        this.hsj.setVisible(0);
                        this.hwF.setVisibility(0);
                    } else {
                        this.hsj.setVisible(4);
                    }
                }
                if (z3 && !this.hwD) {
                    this.hwD = true;
                    this.hwA.a(this.hwG.hDQ.mChallengeData);
                    if (this.hwG.hDQ.mAvtsData != null) {
                        a(this.hwG.hDQ.mAvtsData, this.hwG.hDQ.mAvtsConfigInfo);
                        this.hwF.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.hwA != null) {
            this.hwA.bq(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccS() {
        AlaLiveVideoConfig videoConfig;
        ccR().Xl();
        ccR().ceP();
        if (ccR().hDH != null && (videoConfig = ccR().hDH.getVideoConfig()) != null) {
            com.baidu.live.z.a.b.PI().a(true, videoConfig, false);
        }
        b.a f = com.baidu.live.z.a.b.PI().f(true, false);
        ccR().hDH.switchToCommonMode(f.getWidth(), f.getHeight());
        ccR().ceQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        AlaLiveVideoConfig videoConfig;
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
            ccR().ceP();
            ccR().hDH.setRtcConfig(alaLiveRtcConfig);
            if (ccR().hDH != null && (videoConfig = ccR().hDH.getVideoConfig()) != null) {
                com.baidu.live.z.a.b.PI().a(true, videoConfig, true);
            }
            b.a g = com.baidu.live.z.a.b.PI().g(true, true);
            ccR().hDH.switchToRtcMode(g.getWidth(), g.getHeight());
            ccR().ceQ();
        }
    }

    public boolean ccT() {
        return this.hwA.AJ() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean ccU() {
        return this.hwA.AJ() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void ccV() {
        if (this.hwB != null) {
            this.hwB.br(this.hwH);
            this.hwB.b(ccR().hDK, true);
        }
    }

    public void ccW() {
        if (this.hwB != null && this.hwB.isActive()) {
            this.hwB.onBackKeyDown();
        }
    }

    public void a(ab abVar) {
        if (this.hwC != null) {
            this.hwC.a(abVar);
        }
        if (this.hsj != null) {
            this.hsj.b(abVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hwB != null && this.hwB.isActive() && this.hwB.onBackKeyDown();
    }

    public void ccX() {
        if (this.hwA != null) {
            this.hwA.Au();
            this.hwA.onDestroy();
        }
        if (this.hsj != null) {
            this.hsj.Au();
            this.hsj.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hwC != null) {
            this.hwC.AB();
        }
    }

    public void onDestroy() {
        if (this.hwC != null) {
            this.hwC.onDestroy();
        }
        if (this.hwB != null) {
            this.hwB.removeView();
        }
    }

    public boolean ccY() {
        return this.hwC != null && this.hwC.isActive();
    }

    public int bp(boolean z) {
        if (this.hwC != null) {
            return this.hwC.bp(z);
        }
        return 0;
    }

    public boolean ccZ() {
        return this.hsj != null && this.hsj.At();
    }

    public void fu(String str) {
        if (this.hwA != null) {
            this.hwA.fu(str);
        }
    }

    public void P(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && ccR().bRl() != 2 && com.baidu.live.ae.a.Qm().bwx.aNo) {
            if (this.hsj == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.e.a.class, ccR().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.e.a)) {
                this.hsj = (com.baidu.live.e.a) runTask.getData();
            }
            if (this.hsj != null) {
                this.hsj.a(ccR().hDq.cjO(), true, z2);
                this.hsj.a(new a.InterfaceC0173a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.hsj.getRootView() != null && this.hsj.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.hsj.getRootView().setId(a.f.ala_live_room_pk_panel);
                    ccR().hDr.addView(this.hsj.getRootView(), layoutParams);
                }
                this.hsj.c(null, ccR().hDq.Fp());
                if (this.hwG != null && this.hwG.hDQ != null && this.hwG.hDQ.mPkData != null) {
                    this.hsj.cv(this.hwG.hDQ.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.hwE = dVar;
    }

    public int ccy() {
        int i = 0;
        if (this.hwC != null) {
            i = this.hwC.bp(true);
        }
        return i + ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

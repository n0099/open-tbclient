package com.baidu.tieba.ala.liveroom.challenge;

import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ala.helper.AlaLiveRtcConfig;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.challenge.f;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.live.e.a hqm;
    private com.baidu.live.challenge.e hte;
    private com.baidu.tieba.ala.liveroom.data.e huB;
    private f huC;
    private i huD;
    private j huE;
    private h huF;
    private d huH;
    private ImageView huI;
    private com.baidu.tieba.ala.liveroom.data.f huJ;
    private boolean huG = false;
    private boolean huK = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.huB = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.huI = imageView;
        this.huJ = fVar;
        this.huK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e ccE() {
        return this.huB;
    }

    public void k(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && ccE().bQY() != 2) {
            if (!z2) {
                this.huI.setVisibility(0);
            }
            if (this.hte == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, ccE().pageContext)) != null && runTask2.getData() != null) {
                this.hte = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.huC == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, ccE().pageContext)) != null && runTask.getData() != null) {
                this.huC = (f) runTask.getData();
            }
            if (this.hte != null && this.huC != null) {
                if (this.huD == null) {
                    this.huD = this.hte.a(ccE().pageContext);
                    this.huD.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void cx(int i) {
                            if (e.this.huE != null) {
                                e.this.huE.cy(i);
                            }
                        }
                    });
                    this.huD.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int AL() {
                            return e.this.ccE().hBK.getRtcStreamStatus();
                        }
                    });
                    this.huD.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
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
                            e.this.ccF();
                            e.this.huI.setVisibility(0);
                        }
                    });
                }
                if (this.huE == null) {
                    this.huE = this.huC.Au();
                    this.huE.setUserId(String.valueOf(ccE().hBt.Fm().aId.userId));
                    this.huE.setUserPortrait(ccE().hBt.Fm().aId.portrait);
                    this.huE.a(this.huD);
                    this.huE.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void AN() {
                            e.this.huE.removeView();
                            if (e.this.hqm != null && e.this.hqm.getRootView() != null) {
                                e.this.hqm.setVisible(0);
                                e.this.hqm.As();
                            }
                            if (e.this.huH != null) {
                                e.this.huH.ccD();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void AO() {
                            e.this.huI.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aFy, aVar.aFz);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void AP() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void AQ() {
                        }
                    });
                }
                this.huD.h(ccE().hBt.Fm().mLiveInfo.live_id, ccE().hBt.Fm().aId.userId);
                this.huD.a((i.m) this.huE);
                this.huD.a((i.a) this.huE);
                this.huD.a((i.e) this.huE);
                this.huD.a((i.k) this.huE);
                this.huD.a((i.InterfaceC0166i) this.huE);
                this.huD.a((i.l) this.huE);
                this.huD.a((i.h) this.huE);
                this.huD.a((i.g) this.huE);
                this.huD.a((i.c) this.huE);
                this.huD.a((i.j) this.huE);
                this.huD.setIsHost(ccE().hBt.Fm().isHost);
                if (this.huF == null) {
                    this.huF = this.hte.b(ccE().pageContext);
                    this.huF.c(false, true, z3);
                    this.huF.a(this.huD);
                    this.huF.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void Av() {
                            e.this.ccE().hBu.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(bg bgVar, bk bkVar, bk bkVar2) {
                            if (e.this.huH != null) {
                                e.this.huH.a(bgVar, bkVar, bkVar2);
                            }
                            if (e.this.hqm != null) {
                                e.this.hqm.setCanVisible(false);
                                e.this.hqm.setVisible(8);
                            }
                            e.this.ccE().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.ccE().ceB();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("challengeId", bgVar.challengeId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "one_to_two_start").setContentExt(null, null, jSONObject));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Aw() {
                            e.this.ccE().ceA();
                            if (e.this.huH != null) {
                                e.this.huH.Aw();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Ax() {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "two_to_one_start").setContentExt(null, null, null));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bn(boolean z4) {
                            if (e.this.huH != null) {
                                e.this.huH.ccC();
                            }
                            if (e.this.hqm != null) {
                                e.this.hqm.setCanVisible(true);
                            }
                            if (e.this.huI != null) {
                                e.this.huI.setVisibility(0);
                            }
                            e.this.ccE().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.ccF();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bo(boolean z4) {
                        }
                    });
                    this.huF.k(ccE().hBN);
                }
                this.huD.a((i.c) this.huF);
                this.huD.a((i.n) this.huF);
                this.huD.a((i.d) this.huF);
                if (this.huD.AG() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.huI.setVisibility(0);
                }
                if (this.hqm != null && this.hqm.getRootView() != null) {
                    if (this.hqm.Aq()) {
                        this.hqm.setVisible(0);
                        this.huI.setVisibility(0);
                    } else {
                        this.hqm.setVisible(4);
                    }
                }
                if (z3 && !this.huG) {
                    this.huG = true;
                    this.huD.a(this.huJ.hBT.mChallengeData);
                    if (this.huJ.hBT.mAvtsData != null) {
                        a(this.huJ.hBT.mAvtsData, this.huJ.hBT.mAvtsConfigInfo);
                        this.huI.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.huD != null) {
            this.huD.bq(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccF() {
        AlaLiveVideoConfig videoConfig;
        ccE().Xi();
        ccE().ceC();
        if (ccE().hBK != null && (videoConfig = ccE().hBK.getVideoConfig()) != null) {
            com.baidu.live.z.a.b.PF().a(true, videoConfig, false);
        }
        b.a f = com.baidu.live.z.a.b.PF().f(true, false);
        ccE().hBK.switchToCommonMode(f.getWidth(), f.getHeight());
        ccE().ceD();
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
            ccE().ceC();
            ccE().hBK.setRtcConfig(alaLiveRtcConfig);
            if (ccE().hBK != null && (videoConfig = ccE().hBK.getVideoConfig()) != null) {
                com.baidu.live.z.a.b.PF().a(true, videoConfig, true);
            }
            b.a g = com.baidu.live.z.a.b.PF().g(true, true);
            ccE().hBK.switchToRtcMode(g.getWidth(), g.getHeight());
            ccE().ceD();
        }
    }

    public boolean ccG() {
        return this.huD.AG() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean ccH() {
        return this.huD.AG() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void ccI() {
        if (this.huE != null) {
            this.huE.br(this.huK);
            this.huE.b(ccE().hBN, true);
        }
    }

    public void ccJ() {
        if (this.huE != null && this.huE.isActive()) {
            this.huE.onBackKeyDown();
        }
    }

    public void a(ab abVar) {
        if (this.huF != null) {
            this.huF.a(abVar);
        }
        if (this.hqm != null) {
            this.hqm.b(abVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.huE != null && this.huE.isActive() && this.huE.onBackKeyDown();
    }

    public void ccK() {
        if (this.huD != null) {
            this.huD.Ar();
            this.huD.onDestroy();
        }
        if (this.hqm != null) {
            this.hqm.Ar();
            this.hqm.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.huF != null) {
            this.huF.Ay();
        }
    }

    public void onDestroy() {
        if (this.huF != null) {
            this.huF.onDestroy();
        }
        if (this.huE != null) {
            this.huE.removeView();
        }
    }

    public boolean ccL() {
        return this.huF != null && this.huF.isActive();
    }

    public int bp(boolean z) {
        if (this.huF != null) {
            return this.huF.bp(z);
        }
        return 0;
    }

    public boolean ccM() {
        return this.hqm != null && this.hqm.Aq();
    }

    public void fo(String str) {
        if (this.huD != null) {
            this.huD.fo(str);
        }
    }

    public void P(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && ccE().bQY() != 2 && com.baidu.live.ae.a.Qj().buX.aLO) {
            if (this.hqm == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.e.a.class, ccE().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.e.a)) {
                this.hqm = (com.baidu.live.e.a) runTask.getData();
            }
            if (this.hqm != null) {
                this.hqm.a(ccE().hBt.cjB(), true, z2);
                this.hqm.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.hqm.getRootView() != null && this.hqm.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.hqm.getRootView().setId(a.f.ala_live_room_pk_panel);
                    ccE().hBu.addView(this.hqm.getRootView(), layoutParams);
                }
                this.hqm.c(null, ccE().hBt.Fm());
                if (this.huJ != null && this.huJ.hBT != null && this.huJ.hBT.mPkData != null) {
                    this.hqm.cu(this.huJ.hBT.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.huH = dVar;
    }

    public int ccl() {
        int i = 0;
        if (this.huF != null) {
            i = this.huF.bp(true);
        }
        return i + ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

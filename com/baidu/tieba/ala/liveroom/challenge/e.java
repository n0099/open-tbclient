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
    private com.baidu.live.e.a hqA;
    private com.baidu.live.challenge.e hts;
    private com.baidu.tieba.ala.liveroom.data.e huP;
    private f huQ;
    private i huR;
    private j huS;
    private h huT;
    private d huV;
    private ImageView huW;
    private com.baidu.tieba.ala.liveroom.data.f huX;
    private boolean huU = false;
    private boolean huY = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.huP = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.huW = imageView;
        this.huX = fVar;
        this.huY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e ccL() {
        return this.huP;
    }

    public void k(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && ccL().bRf() != 2) {
            if (!z2) {
                this.huW.setVisibility(0);
            }
            if (this.hts == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, ccL().pageContext)) != null && runTask2.getData() != null) {
                this.hts = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.huQ == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, ccL().pageContext)) != null && runTask.getData() != null) {
                this.huQ = (f) runTask.getData();
            }
            if (this.hts != null && this.huQ != null) {
                if (this.huR == null) {
                    this.huR = this.hts.a(ccL().pageContext);
                    this.huR.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void cx(int i) {
                            if (e.this.huS != null) {
                                e.this.huS.cy(i);
                            }
                        }
                    });
                    this.huR.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int AL() {
                            return e.this.ccL().hBY.getRtcStreamStatus();
                        }
                    });
                    this.huR.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
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
                            e.this.ccM();
                            e.this.huW.setVisibility(0);
                        }
                    });
                }
                if (this.huS == null) {
                    this.huS = this.huQ.Au();
                    this.huS.setUserId(String.valueOf(ccL().hBH.Fm().aId.userId));
                    this.huS.setUserPortrait(ccL().hBH.Fm().aId.portrait);
                    this.huS.a(this.huR);
                    this.huS.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void AN() {
                            e.this.huS.removeView();
                            if (e.this.hqA != null && e.this.hqA.getRootView() != null) {
                                e.this.hqA.setVisible(0);
                                e.this.hqA.As();
                            }
                            if (e.this.huV != null) {
                                e.this.huV.ccK();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void AO() {
                            e.this.huW.setVisibility(0);
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
                this.huR.h(ccL().hBH.Fm().mLiveInfo.live_id, ccL().hBH.Fm().aId.userId);
                this.huR.a((i.m) this.huS);
                this.huR.a((i.a) this.huS);
                this.huR.a((i.e) this.huS);
                this.huR.a((i.k) this.huS);
                this.huR.a((i.InterfaceC0166i) this.huS);
                this.huR.a((i.l) this.huS);
                this.huR.a((i.h) this.huS);
                this.huR.a((i.g) this.huS);
                this.huR.a((i.c) this.huS);
                this.huR.a((i.j) this.huS);
                this.huR.setIsHost(ccL().hBH.Fm().isHost);
                if (this.huT == null) {
                    this.huT = this.hts.b(ccL().pageContext);
                    this.huT.c(false, true, z3);
                    this.huT.a(this.huR);
                    this.huT.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void Av() {
                            e.this.ccL().hBI.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(bg bgVar, bk bkVar, bk bkVar2) {
                            if (e.this.huV != null) {
                                e.this.huV.a(bgVar, bkVar, bkVar2);
                            }
                            if (e.this.hqA != null) {
                                e.this.hqA.setCanVisible(false);
                                e.this.hqA.setVisible(8);
                            }
                            e.this.ccL().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.ccL().ceI();
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
                            e.this.ccL().ceH();
                            if (e.this.huV != null) {
                                e.this.huV.Aw();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void Ax() {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "two_to_one_start").setContentExt(null, null, null));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bn(boolean z4) {
                            if (e.this.huV != null) {
                                e.this.huV.ccJ();
                            }
                            if (e.this.hqA != null) {
                                e.this.hqA.setCanVisible(true);
                            }
                            if (e.this.huW != null) {
                                e.this.huW.setVisibility(0);
                            }
                            e.this.ccL().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.ccM();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bo(boolean z4) {
                        }
                    });
                    this.huT.k(ccL().hCb);
                }
                this.huR.a((i.c) this.huT);
                this.huR.a((i.n) this.huT);
                this.huR.a((i.d) this.huT);
                if (this.huR.AG() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.huW.setVisibility(0);
                }
                if (this.hqA != null && this.hqA.getRootView() != null) {
                    if (this.hqA.Aq()) {
                        this.hqA.setVisible(0);
                        this.huW.setVisibility(0);
                    } else {
                        this.hqA.setVisible(4);
                    }
                }
                if (z3 && !this.huU) {
                    this.huU = true;
                    this.huR.a(this.huX.hCh.mChallengeData);
                    if (this.huX.hCh.mAvtsData != null) {
                        a(this.huX.hCh.mAvtsData, this.huX.hCh.mAvtsConfigInfo);
                        this.huW.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.huR != null) {
            this.huR.bq(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccM() {
        AlaLiveVideoConfig videoConfig;
        ccL().Xi();
        ccL().ceJ();
        if (ccL().hBY != null && (videoConfig = ccL().hBY.getVideoConfig()) != null) {
            com.baidu.live.z.a.b.PF().a(true, videoConfig, false);
        }
        b.a f = com.baidu.live.z.a.b.PF().f(true, false);
        ccL().hBY.switchToCommonMode(f.getWidth(), f.getHeight());
        ccL().ceK();
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
            ccL().ceJ();
            ccL().hBY.setRtcConfig(alaLiveRtcConfig);
            if (ccL().hBY != null && (videoConfig = ccL().hBY.getVideoConfig()) != null) {
                com.baidu.live.z.a.b.PF().a(true, videoConfig, true);
            }
            b.a g = com.baidu.live.z.a.b.PF().g(true, true);
            ccL().hBY.switchToRtcMode(g.getWidth(), g.getHeight());
            ccL().ceK();
        }
    }

    public boolean ccN() {
        return this.huR.AG() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean ccO() {
        return this.huR.AG() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void ccP() {
        if (this.huS != null) {
            this.huS.br(this.huY);
            this.huS.b(ccL().hCb, true);
        }
    }

    public void ccQ() {
        if (this.huS != null && this.huS.isActive()) {
            this.huS.onBackKeyDown();
        }
    }

    public void a(ab abVar) {
        if (this.huT != null) {
            this.huT.a(abVar);
        }
        if (this.hqA != null) {
            this.hqA.b(abVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.huS != null && this.huS.isActive() && this.huS.onBackKeyDown();
    }

    public void ccR() {
        if (this.huR != null) {
            this.huR.Ar();
            this.huR.onDestroy();
        }
        if (this.hqA != null) {
            this.hqA.Ar();
            this.hqA.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.huT != null) {
            this.huT.Ay();
        }
    }

    public void onDestroy() {
        if (this.huT != null) {
            this.huT.onDestroy();
        }
        if (this.huS != null) {
            this.huS.removeView();
        }
    }

    public boolean ccS() {
        return this.huT != null && this.huT.isActive();
    }

    public int bp(boolean z) {
        if (this.huT != null) {
            return this.huT.bp(z);
        }
        return 0;
    }

    public boolean ccT() {
        return this.hqA != null && this.hqA.Aq();
    }

    public void fo(String str) {
        if (this.huR != null) {
            this.huR.fo(str);
        }
    }

    public void P(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && ccL().bRf() != 2 && com.baidu.live.ae.a.Qj().buX.aLO) {
            if (this.hqA == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.e.a.class, ccL().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.e.a)) {
                this.hqA = (com.baidu.live.e.a) runTask.getData();
            }
            if (this.hqA != null) {
                this.hqA.a(ccL().hBH.cjI(), true, z2);
                this.hqA.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.hqA.getRootView() != null && this.hqA.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.hqA.getRootView().setId(a.f.ala_live_room_pk_panel);
                    ccL().hBI.addView(this.hqA.getRootView(), layoutParams);
                }
                this.hqA.c(null, ccL().hBH.Fm());
                if (this.huX != null && this.huX.hCh != null && this.huX.hCh.mPkData != null) {
                    this.hqA.cu(this.huX.hCh.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.huV = dVar;
    }

    public int ccs() {
        int i = 0;
        if (this.huT != null) {
            i = this.huT.bp(true);
        }
        return i + ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

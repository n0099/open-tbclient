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
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.x;
import com.baidu.live.f.a;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.live.f.a hqF;
    private com.baidu.live.challenge.e htA;
    private com.baidu.tieba.ala.liveroom.data.e huX;
    private f huY;
    private i huZ;
    private j hva;
    private h hvb;
    private d hvd;
    private ImageView hve;
    private com.baidu.tieba.ala.liveroom.data.f hvf;
    private boolean hvc = false;
    private boolean hvg = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.huX = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.hve = imageView;
        this.hvf = fVar;
        this.hvg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e cfA() {
        return this.huX;
    }

    public void k(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && cfA().bUl() != 2) {
            if (!z2) {
                this.hve.setVisibility(0);
            }
            if (this.htA == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, cfA().pageContext)) != null && runTask2.getData() != null) {
                this.htA = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.huY == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, cfA().pageContext)) != null && runTask.getData() != null) {
                this.huY = (f) runTask.getData();
            }
            if (this.htA != null && this.huY != null) {
                if (this.huZ == null) {
                    this.huZ = this.htA.a(cfA().pageContext);
                    this.huZ.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void ea(int i) {
                            if (e.this.hva != null) {
                                e.this.hva.eb(i);
                            }
                        }
                    });
                    this.huZ.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int DW() {
                            return e.this.cfA().hCg.getRtcStreamStatus();
                        }
                    });
                    this.huZ.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
                        @Override // com.baidu.live.challenge.i.c
                        public void b(bc bcVar, bg bgVar, bg bgVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void c(bc bcVar, bg bgVar, bg bgVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void d(bc bcVar, bg bgVar, bg bgVar2) {
                        }

                        @Override // com.baidu.live.challenge.i.c
                        public void e(bc bcVar, bg bgVar, bg bgVar2) {
                            e.this.cfB();
                            e.this.hve.setVisibility(0);
                        }
                    });
                }
                if (this.hva == null) {
                    this.hva = this.huY.DF();
                    this.hva.setUserId(String.valueOf(cfA().hBP.HR().aKu.userId));
                    this.hva.setUserPortrait(cfA().hBP.HR().aKu.portrait);
                    this.hva.a(this.huZ);
                    this.hva.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void DY() {
                            e.this.hva.removeView();
                            if (e.this.hqF != null && e.this.hqF.getRootView() != null) {
                                e.this.hqF.setVisible(0);
                                e.this.hqF.DD();
                            }
                            if (e.this.hvd != null) {
                                e.this.hvd.cfz();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void DZ() {
                            e.this.hve.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aIy, aVar.aIz);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Ea() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Eb() {
                        }
                    });
                }
                this.huZ.h(cfA().hBP.HR().mLiveInfo.live_id, cfA().hBP.HR().aKu.userId);
                this.huZ.a((i.m) this.hva);
                this.huZ.a((i.a) this.hva);
                this.huZ.a((i.e) this.hva);
                this.huZ.a((i.k) this.hva);
                this.huZ.a((i.InterfaceC0174i) this.hva);
                this.huZ.a((i.l) this.hva);
                this.huZ.a((i.h) this.hva);
                this.huZ.a((i.g) this.hva);
                this.huZ.a((i.c) this.hva);
                this.huZ.a((i.j) this.hva);
                this.huZ.setIsHost(cfA().hBP.HR().isHost);
                if (this.hvb == null) {
                    this.hvb = this.htA.b(cfA().pageContext);
                    this.hvb.c(false, true, z3);
                    this.hvb.a(this.huZ);
                    this.hvb.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void DG() {
                            e.this.cfA().hBQ.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(bc bcVar, bg bgVar, bg bgVar2) {
                            if (e.this.hvd != null) {
                                e.this.hvd.a(bcVar, bgVar, bgVar2);
                            }
                            if (e.this.hqF != null) {
                                e.this.hqF.setCanVisible(false);
                                e.this.hqF.setVisible(8);
                            }
                            e.this.cfA().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.cfA().chx();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("challengeId", bcVar.challengeId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "one_to_two_start").setContentExt(null, null, jSONObject));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void DH() {
                            e.this.cfA().chw();
                            if (e.this.hvd != null) {
                                e.this.hvd.DH();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void DI() {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "two_to_one_start").setContentExt(null, null, null));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bp(boolean z4) {
                            if (e.this.hvd != null) {
                                e.this.hvd.cfy();
                            }
                            if (e.this.hqF != null) {
                                e.this.hqF.setCanVisible(true);
                            }
                            if (e.this.hve != null) {
                                e.this.hve.setVisibility(0);
                            }
                            e.this.cfA().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.cfB();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bq(boolean z4) {
                        }
                    });
                    this.hvb.k(cfA().hCj);
                }
                this.huZ.a((i.c) this.hvb);
                this.huZ.a((i.n) this.hvb);
                this.huZ.a((i.d) this.hvb);
                if (this.huZ.DR() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.hve.setVisibility(0);
                }
                if (this.hqF != null && this.hqF.getRootView() != null) {
                    if (this.hqF.DB()) {
                        this.hqF.setVisible(0);
                        this.hve.setVisibility(0);
                    } else {
                        this.hqF.setVisible(4);
                    }
                }
                if (z3 && !this.hvc) {
                    this.hvc = true;
                    this.huZ.a(this.hvf.hCp.mChallengeData);
                    if (this.hvf.hCp.mAvtsData != null) {
                        a(this.hvf.hCp.mAvtsData, this.hvf.hCp.mAvtsConfigInfo);
                        this.hve.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.huZ != null) {
            this.huZ.bs(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfB() {
        cfA().Zr();
        cfA().chy();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Sb().f(true, false);
        cfA().hCg.switchToCommonMode(f.getWidth(), f.getHeight());
        cfA().chz();
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
            cfA().chy();
            cfA().hCg.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Sb().f(true, true);
            cfA().hCg.switchToRtcMode(f.getWidth(), f.getHeight());
            cfA().chz();
        }
    }

    public boolean cfC() {
        return this.huZ.DR() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean cfD() {
        return this.huZ.DR() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void cfE() {
        if (this.hva != null) {
            this.hva.bt(this.hvg);
            this.hva.b(cfA().hCj, true);
        }
    }

    public void cfF() {
        if (this.hva != null && this.hva.isActive()) {
            this.hva.onBackKeyDown();
        }
    }

    public void a(x xVar) {
        if (this.hvb != null) {
            this.hvb.a(xVar);
        }
        if (this.hqF != null) {
            this.hqF.b(xVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hva != null && this.hva.isActive() && this.hva.onBackKeyDown();
    }

    public void cfG() {
        if (this.huZ != null) {
            this.huZ.DC();
            this.huZ.onDestroy();
        }
        if (this.hqF != null) {
            this.hqF.DC();
            this.hqF.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hvb != null) {
            this.hvb.DJ();
        }
    }

    public void onDestroy() {
        if (this.hvb != null) {
            this.hvb.onDestroy();
        }
        if (this.hva != null) {
            this.hva.removeView();
        }
    }

    public boolean cfH() {
        return this.hvb != null && this.hvb.isActive();
    }

    public int br(boolean z) {
        if (this.hvb != null) {
            return this.hvb.br(z);
        }
        return 0;
    }

    public boolean cfI() {
        return this.hqF != null && this.hqF.DB();
    }

    public void gg(String str) {
        if (this.huZ != null) {
            this.huZ.gg(str);
        }
    }

    public void P(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && cfA().bUl() != 2 && com.baidu.live.af.a.SE().bwi.aNR) {
            if (this.hqF == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.f.a.class, cfA().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.f.a)) {
                this.hqF = (com.baidu.live.f.a) runTask.getData();
            }
            if (this.hqF != null) {
                this.hqF.a(cfA().hBP.cmz(), true, z2);
                this.hqF.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.hqF.getRootView() != null && this.hqF.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = cfA().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = cfA().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.hqF.getRootView().setId(a.f.ala_live_room_pk_panel);
                    cfA().hBQ.addView(this.hqF.getRootView(), layoutParams);
                }
                this.hqF.c(null, cfA().hBP.HR());
                if (this.hvf != null && this.hvf.hCp != null && this.hvf.hCp.mPkData != null) {
                    this.hqF.dX(this.hvf.hCp.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.hvd = dVar;
    }

    public int cfh() {
        int i = 0;
        if (this.hvb != null) {
            i = this.hvb.br(true);
        }
        return i + cfA().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

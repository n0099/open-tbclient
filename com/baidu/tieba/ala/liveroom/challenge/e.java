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
/* loaded from: classes10.dex */
public class e {
    private com.baidu.live.f.a hlY;
    private com.baidu.live.challenge.e hoU;
    private com.baidu.tieba.ala.liveroom.data.e hqr;
    private f hqs;
    private i hqt;
    private j hqu;
    private h hqv;
    private d hqx;
    private ImageView hqy;
    private com.baidu.tieba.ala.liveroom.data.f hqz;
    private boolean hqw = false;
    private boolean hqA = false;

    public e(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hqr = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar, boolean z) {
        this.hqy = imageView;
        this.hqz = fVar;
        this.hqA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e cbJ() {
        return this.hqr;
    }

    public void k(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && cbJ().bQu() != 2) {
            if (!z2) {
                this.hqy.setVisibility(0);
            }
            if (this.hoU == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.e.class, cbJ().pageContext)) != null && runTask2.getData() != null) {
                this.hoU = (com.baidu.live.challenge.e) runTask2.getData();
            }
            if (this.hqs == null && (runTask = MessageManager.getInstance().runTask(2913114, f.class, cbJ().pageContext)) != null && runTask.getData() != null) {
                this.hqs = (f) runTask.getData();
            }
            if (this.hoU != null && this.hqs != null) {
                if (this.hqt == null) {
                    this.hqt = this.hoU.a(cbJ().pageContext);
                    this.hqt.a(new i.b() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.1
                        @Override // com.baidu.live.challenge.i.b
                        public void cu(int i) {
                            if (e.this.hqu != null) {
                                e.this.hqu.cv(i);
                            }
                        }
                    });
                    this.hqt.a(new i.f() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.2
                        @Override // com.baidu.live.challenge.i.f
                        public int Ab() {
                            return e.this.cbJ().hxA.getRtcStreamStatus();
                        }
                    });
                    this.hqt.a(new i.c() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.3
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
                            e.this.cbK();
                            e.this.hqy.setVisibility(0);
                        }
                    });
                }
                if (this.hqu == null) {
                    this.hqu = this.hqs.zK();
                    this.hqu.setUserId(String.valueOf(cbJ().hxj.DW().aFH.userId));
                    this.hqu.setUserPortrait(cbJ().hxj.DW().aFH.portrait);
                    this.hqu.a(this.hqt);
                    this.hqu.a(new k() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.4
                        @Override // com.baidu.live.challenge.k
                        public void Ad() {
                            e.this.hqu.removeView();
                            if (e.this.hlY != null && e.this.hlY.getRootView() != null) {
                                e.this.hlY.setVisible(0);
                                e.this.hlY.zI();
                            }
                            if (e.this.hqx != null) {
                                e.this.hqx.cbI();
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Ae() {
                            e.this.hqy.setVisibility(0);
                        }

                        @Override // com.baidu.live.challenge.k
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                e.this.a(aVar.aDL, aVar.aDM);
                            }
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Af() {
                        }

                        @Override // com.baidu.live.challenge.k
                        public void Ag() {
                        }
                    });
                }
                this.hqt.h(cbJ().hxj.DW().mLiveInfo.live_id, cbJ().hxj.DW().aFH.userId);
                this.hqt.a((i.m) this.hqu);
                this.hqt.a((i.a) this.hqu);
                this.hqt.a((i.e) this.hqu);
                this.hqt.a((i.k) this.hqu);
                this.hqt.a((i.InterfaceC0165i) this.hqu);
                this.hqt.a((i.l) this.hqu);
                this.hqt.a((i.h) this.hqu);
                this.hqt.a((i.g) this.hqu);
                this.hqt.a((i.c) this.hqu);
                this.hqt.a((i.j) this.hqu);
                this.hqt.setIsHost(cbJ().hxj.DW().isHost);
                if (this.hqv == null) {
                    this.hqv = this.hoU.b(cbJ().pageContext);
                    this.hqv.c(false, true, z3);
                    this.hqv.a(this.hqt);
                    this.hqv.a(new g() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.5
                        @Override // com.baidu.live.challenge.g
                        public void zL() {
                            e.this.cbJ().hxk.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void a(bc bcVar, bg bgVar, bg bgVar2) {
                            if (e.this.hqx != null) {
                                e.this.hqx.a(bcVar, bgVar, bgVar2);
                            }
                            if (e.this.hlY != null) {
                                e.this.hlY.setCanVisible(false);
                                e.this.hlY.setVisible(8);
                            }
                            e.this.cbJ().rootView.setBackgroundResource(a.e.ala_live_challenge_live_bg_gradient);
                            e.this.cbJ().cdG();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("challengeId", bcVar.challengeId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "one_to_two_start").setContentExt(null, null, jSONObject));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void zM() {
                            e.this.cbJ().cdF();
                            if (e.this.hqx != null) {
                                e.this.hqx.zM();
                            }
                        }

                        @Override // com.baidu.live.challenge.g
                        public void zN() {
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "author_liveroom", "two_to_one_start").setContentExt(null, null, null));
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bl(boolean z4) {
                            if (e.this.hqx != null) {
                                e.this.hqx.cbH();
                            }
                            if (e.this.hlY != null) {
                                e.this.hlY.setCanVisible(true);
                            }
                            if (e.this.hqy != null) {
                                e.this.hqy.setVisibility(0);
                            }
                            e.this.cbJ().rootView.setBackgroundResource(a.e.sdk_transparent_bg);
                            e.this.cbK();
                        }

                        @Override // com.baidu.live.challenge.g
                        public void bm(boolean z4) {
                        }
                    });
                    this.hqv.k(cbJ().hxD);
                }
                this.hqt.a((i.c) this.hqv);
                this.hqt.a((i.n) this.hqv);
                this.hqt.a((i.d) this.hqv);
                if (this.hqt.zW() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.hqy.setVisibility(0);
                }
                if (this.hlY != null && this.hlY.getRootView() != null) {
                    if (this.hlY.zG()) {
                        this.hlY.setVisible(0);
                        this.hqy.setVisibility(0);
                    } else {
                        this.hlY.setVisible(4);
                    }
                }
                if (z3 && !this.hqw) {
                    this.hqw = true;
                    this.hqt.a(this.hqz.hxJ.mChallengeData);
                    if (this.hqz.hxJ.mAvtsData != null) {
                        a(this.hqz.hxJ.mAvtsData, this.hqz.hxJ.mAvtsConfigInfo);
                        this.hqy.setVisibility(0);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.hqt != null) {
            this.hqt.bo(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbK() {
        cbJ().Vz();
        cbJ().cdH();
        LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Og().f(true, false);
        cbJ().hxA.switchToCommonMode(f.getWidth(), f.getHeight());
        cbJ().cdI();
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
            cbJ().cdH();
            cbJ().hxA.setRtcConfig(alaLiveRtcConfig);
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Og().f(true, true);
            cbJ().hxA.switchToRtcMode(f.getWidth(), f.getHeight());
            cbJ().cdI();
        }
    }

    public boolean cbL() {
        return this.hqt.zW() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_CHALLENGING;
    }

    public boolean cbM() {
        return this.hqt.zW() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_PUNISHMENT;
    }

    public void cbN() {
        if (this.hqu != null) {
            this.hqu.bp(this.hqA);
            this.hqu.b(cbJ().hxD, true);
        }
    }

    public void cbO() {
        if (this.hqu != null && this.hqu.isActive()) {
            this.hqu.onBackKeyDown();
        }
    }

    public void a(x xVar) {
        if (this.hqv != null) {
            this.hqv.a(xVar);
        }
        if (this.hlY != null) {
            this.hlY.b(xVar);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hqu != null && this.hqu.isActive() && this.hqu.onBackKeyDown();
    }

    public void cbP() {
        if (this.hqt != null) {
            this.hqt.zH();
            this.hqt.onDestroy();
        }
        if (this.hlY != null) {
            this.hlY.zH();
            this.hlY.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hqv != null) {
            this.hqv.zO();
        }
    }

    public void onDestroy() {
        if (this.hqv != null) {
            this.hqv.onDestroy();
        }
        if (this.hqu != null) {
            this.hqu.removeView();
        }
    }

    public boolean cbQ() {
        return this.hqv != null && this.hqv.isActive();
    }

    public int bn(boolean z) {
        if (this.hqv != null) {
            return this.hqv.bn(z);
        }
        return 0;
    }

    public boolean cbR() {
        return this.hlY != null && this.hlY.zG();
    }

    public void eV(String str) {
        if (this.hqt != null) {
            this.hqt.eV(str);
        }
    }

    public void P(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && cbJ().bQu() != 2 && com.baidu.live.af.a.OJ().bru.aJe) {
            if (this.hlY == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.f.a.class, cbJ().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.f.a)) {
                this.hlY = (com.baidu.live.f.a) runTask.getData();
            }
            if (this.hlY != null) {
                this.hlY.a(cbJ().hxj.ciI(), true, z2);
                this.hlY.a(new a.InterfaceC0168a() { // from class: com.baidu.tieba.ala.liveroom.challenge.e.6
                });
                if (this.hlY.getRootView() != null && this.hlY.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds240);
                    layoutParams.rightMargin = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                    this.hlY.getRootView().setId(a.f.ala_live_room_pk_panel);
                    cbJ().hxk.addView(this.hlY.getRootView(), layoutParams);
                }
                this.hlY.c(null, cbJ().hxj.DW());
                if (this.hqz != null && this.hqz.hxJ != null && this.hqz.hxJ.mPkData != null) {
                    this.hlY.cr(this.hqz.hxJ.mPkData.pk_status);
                }
            }
        }
    }

    public void a(d dVar) {
        this.hqx = dVar;
    }

    public int cbq() {
        int i = 0;
        if (this.hqv != null) {
            i = this.hqv.bn(true);
        }
        return i + cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }
}

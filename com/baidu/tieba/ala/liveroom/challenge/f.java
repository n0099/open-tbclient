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
import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
/* loaded from: classes2.dex */
public class f {
    private com.baidu.live.d.a eLH;
    private com.baidu.live.challenge.f eNF;
    private com.baidu.tieba.ala.liveroom.data.e eOH;
    private g eOI;
    private j eOJ;
    private k eOK;
    private i eOL;
    private com.baidu.live.challenge.e eOM;
    private boolean eON = false;
    private e eOO;
    private ImageView eOP;
    private com.baidu.tieba.ala.liveroom.data.f eOQ;

    public f(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.eOH = eVar;
    }

    public void a(ImageView imageView, com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.eOP = imageView;
        this.eOQ = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.ala.liveroom.data.e bhC() {
        return this.eOH;
    }

    public void h(boolean z, boolean z2, boolean z3) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        if (!z && bhC().bjk() != 2 && z2) {
            if (this.eNF == null && (runTask2 = MessageManager.getInstance().runTask(2913074, com.baidu.live.challenge.f.class, bhC().pageContext)) != null && runTask2.getData() != null) {
                this.eNF = (com.baidu.live.challenge.f) runTask2.getData();
            }
            if (this.eOI == null && (runTask = MessageManager.getInstance().runTask(2913114, g.class, bhC().pageContext)) != null && runTask.getData() != null) {
                this.eOI = (g) runTask.getData();
            }
            if (this.eNF != null && this.eOI != null) {
                if (this.eOJ == null) {
                    this.eOJ = this.eNF.a(bhC().pageContext);
                    this.eOJ.a(new j.d() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1
                        @Override // com.baidu.live.challenge.j.d
                        public void bf(int i) {
                            if (f.this.eOK != null) {
                                f.this.eOK.bc(i);
                                if (f.this.eOM == null) {
                                    f.this.eOM = f.this.eOI.oX();
                                    f.this.eOM.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            f.this.eOM.hide();
                                            f.this.eOM.ap(false);
                                            if (f.this.eOK != null) {
                                                f.this.eOK.b(f.this.bhC().rootView, true);
                                            }
                                        }
                                    });
                                }
                                f.this.eOM.bc(i);
                                if (!f.this.eOK.isActive()) {
                                    f.this.eOM.J(f.this.eOP);
                                }
                            }
                        }
                    });
                    this.eOJ.a(new j.g() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.2
                        @Override // com.baidu.live.challenge.j.g
                        public int pq() {
                            return f.this.bhC().eUY.getRtcStreamStatus();
                        }
                    });
                    this.eOJ.a(new j.e() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.3
                        @Override // com.baidu.live.challenge.j.e
                        public void b(y yVar, z zVar, z zVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.e
                        public void c(y yVar, z zVar, z zVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.e
                        public void d(y yVar, z zVar, z zVar2) {
                        }

                        @Override // com.baidu.live.challenge.j.e
                        public void e(y yVar, z zVar, z zVar2) {
                            f.this.bhD();
                            f.this.eOP.setVisibility(0);
                        }
                    });
                }
                if (this.eOK == null) {
                    this.eOK = this.eOI.oW();
                    this.eOK.cL(bhC().eUF.wf().VP.portrait);
                    this.eOK.a(this.eOJ);
                    this.eOK.a(new l() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.4
                        @Override // com.baidu.live.challenge.l
                        public void pr() {
                            f.this.eOK.removeView();
                            if (f.this.eLH != null && f.this.eLH.getRootView() != null) {
                                f.this.eLH.setVisible(0);
                                f.this.eLH.oT();
                                f.this.eOP.setVisibility(8);
                            }
                            if (f.this.eOO != null) {
                                f.this.eOO.bhB();
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void ps() {
                            f.this.eOP.setVisibility(8);
                        }

                        @Override // com.baidu.live.challenge.l
                        public void a(com.baidu.live.challenge.a aVar) {
                            if (aVar != null) {
                                f.this.a(aVar.UZ, aVar.Va);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void pt() {
                            if (f.this.eOM != null) {
                                f.this.eOM.ap(false);
                            }
                        }

                        @Override // com.baidu.live.challenge.l
                        public void pu() {
                            if (f.this.eOM != null && !f.this.eOM.isShowing() && f.this.eOM.oV()) {
                                f.this.eOM.J(f.this.eOP);
                            }
                        }
                    });
                }
                this.eOJ.d(bhC().eUF.wf().mLiveInfo.live_id, bhC().eUF.wf().VP.userId);
                this.eOJ.a((j.a) this.eOK);
                this.eOJ.a((j.f) this.eOK);
                this.eOJ.a((j.k) this.eOK);
                this.eOJ.a((j.InterfaceC0074j) this.eOK);
                this.eOJ.a((j.i) this.eOK);
                this.eOJ.a((j.h) this.eOK);
                this.eOJ.a((j.e) this.eOK);
                if (this.eOL == null) {
                    this.eOL = this.eNF.b(bhC().pageContext);
                    this.eOL.b(false, true, z3);
                    this.eOL.a(this.eOJ);
                    this.eOL.a(new h() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.5
                        @Override // com.baidu.live.challenge.h
                        public void oY() {
                            f.this.bhC().eUG.scrollOrigin();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void a(y yVar, z zVar, z zVar2) {
                            if (f.this.eOO != null) {
                                f.this.eOO.a(yVar, zVar, zVar2);
                            }
                            if (f.this.eLH != null) {
                                f.this.eLH.setCanVisible(false);
                                f.this.eLH.setVisible(8);
                            }
                            f.this.bhC().rootView.setBackgroundResource(a.f.ala_live_challenge_live_bg_gradient);
                            f.this.bhC().bjm();
                        }

                        @Override // com.baidu.live.challenge.h
                        public void oZ() {
                            f.this.bhC().auh();
                            if (f.this.eOO != null) {
                                f.this.eOO.oZ();
                            }
                        }

                        @Override // com.baidu.live.challenge.h
                        public void pa() {
                        }

                        @Override // com.baidu.live.challenge.h
                        public void aq(boolean z4) {
                            if (f.this.eOO != null) {
                                f.this.eOO.bhA();
                            }
                            if (f.this.eLH != null) {
                                f.this.eLH.setCanVisible(true);
                            }
                            if (f.this.eOP != null) {
                                f.this.eOP.setVisibility(0);
                            }
                            f.this.bhC().rootView.setBackgroundResource(a.f.sdk_transparent_bg);
                            f.this.bhD();
                        }
                    });
                    this.eOL.e(bhC().rootView);
                }
                this.eOJ.a((j.e) this.eOL);
                this.eOJ.a((j.b) this.eOL);
                this.eOJ.a((j.c) this.eOL);
                this.eOJ.a((j.l) this.eOL);
                if (this.eOJ.ph() == ChallenfeInfoData.ChallengeStatus.CHALLENGE_STAGE_IDEL) {
                    this.eOP.setVisibility(0);
                }
                if (this.eLH != null && this.eLH.getRootView() != null) {
                    if (this.eLH.oR()) {
                        this.eLH.setVisible(0);
                        this.eOP.setVisibility(8);
                    } else {
                        this.eLH.setVisible(4);
                    }
                }
                if (z3 && !this.eON) {
                    this.eON = true;
                    this.eOJ.a(this.eOQ.eVc.mChallengeData);
                    if (this.eOQ.eVc.mAvtsData != null) {
                        a(this.eOQ.eVc.mAvtsData, this.eOQ.eVc.mAvtsConfigInfo);
                        this.eOP.setVisibility(8);
                    }
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.eOJ != null) {
            this.eOJ.as(i == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhD() {
        bhC().bjl();
        bhC().bjn();
        AlaLiveRecordConfigHelper.VideoResolution iY = AlaLiveRecordConfigHelper.biV().iY(false);
        bhC().eUY.switchToCommonMode(iY.getWidth(), iY.getHeight());
        bhC().bjo();
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
            bhC().bjn();
            bhC().eUY.setRtcConfig(alaLiveRtcConfig);
            AlaLiveRecordConfigHelper.VideoResolution iY = AlaLiveRecordConfigHelper.biV().iY(true);
            bhC().eUY.switchToRtcMode(iY.getWidth(), iY.getHeight());
            bhC().bjo();
        }
    }

    public void bhE() {
        if (this.eOM != null) {
            this.eOM.hide();
        }
        if (this.eOK != null) {
            this.eOK.b(bhC().rootView, true);
        }
    }

    public void a(com.baidu.live.data.k kVar) {
        if (this.eOL != null) {
            this.eOL.a(kVar);
        }
        if (this.eLH != null) {
            this.eLH.b(kVar);
        }
    }

    public void d(ImageView imageView) {
        if (this.eOM != null && this.eOM.oV()) {
            this.eOM.J(imageView);
        }
    }

    public void bhF() {
        if (this.eOM != null) {
            this.eOM.hide();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.eOK != null && this.eOK.isActive() && this.eOK.onBackKeyDown();
    }

    public void bhG() {
        if (this.eOJ != null) {
            this.eOJ.oS();
            this.eOJ.onDestroy();
        }
        if (this.eLH != null) {
            this.eLH.oS();
            this.eLH.onDestroy();
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.eOL != null) {
            this.eOL.pb();
        }
    }

    public void onDestroy() {
        if (this.eOL != null) {
            this.eOL.onDestroy();
        }
        if (this.eOM != null) {
            this.eOM.hide();
        }
        if (this.eOK != null) {
            this.eOK.removeView();
        }
    }

    public boolean bhH() {
        return this.eOL != null && this.eOL.isActive();
    }

    public int ar(boolean z) {
        if (this.eOL != null) {
            return this.eOL.ar(z);
        }
        return 0;
    }

    public boolean bhI() {
        return this.eLH != null && this.eLH.oR();
    }

    public void cK(String str) {
        if (this.eOJ != null) {
            this.eOJ.cK(str);
        }
    }

    public void B(boolean z, boolean z2) {
        CustomResponsedMessage runTask;
        if (!z && bhC().bjk() != 2 && com.baidu.live.r.a.wA().arE.XK) {
            if (this.eLH == null && (runTask = MessageManager.getInstance().runTask(2913075, com.baidu.live.d.a.class, bhC().pageContext)) != null && runTask.getData() != null && (runTask.getData() instanceof com.baidu.live.d.a)) {
                this.eLH = (com.baidu.live.d.a) runTask.getData();
            }
            if (this.eLH != null) {
                this.eLH.a(bhC().eUF.bne(), true, z2);
                this.eLH.a(new a.InterfaceC0075a() { // from class: com.baidu.tieba.ala.liveroom.challenge.f.6
                });
                if (this.eLH.getRootView() != null && this.eLH.getRootView().getParent() == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.topMargin = bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds240);
                    layoutParams.rightMargin = bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    this.eLH.getRootView().setId(a.g.ala_live_room_pk_panel);
                    bhC().eUG.addView(this.eLH.getRootView(), layoutParams);
                }
                this.eLH.a(null, bhC().eUF.wf());
                if (this.eOQ != null && this.eOQ.eVc != null && this.eOQ.eVc.mPkData != null) {
                    this.eLH.bb(this.eOQ.eVc.mPkData.pk_status);
                }
            }
        }
    }

    public void a(e eVar) {
        this.eOO = eVar;
    }
}

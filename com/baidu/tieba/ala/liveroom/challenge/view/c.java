package com.baidu.tieba.ala.liveroom.challenge.view;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.challenge.j;
import com.baidu.live.data.k;
import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.utils.g;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView;
import com.baidu.tieba.ala.liveroom.challenge.view.b;
/* loaded from: classes2.dex */
public class c implements i {
    private AlaChallengeLiveView eTn;
    private b eTo;
    private h eTp;
    private AlaChallengeCountDown eTq;
    private j eTr;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean eTs = false;
    private boolean eTt = false;
    private boolean eTu = false;
    private boolean eTv = true;
    private boolean eTw = false;
    private boolean eTx = false;
    private boolean eTy = false;
    private boolean eTz = false;
    private boolean eTA = false;
    private long challengeId = 0;
    private long Vc = 0;
    private long liveId = -1;
    private long eTB = 0;
    private int eTC = 10;
    private boolean isHost = false;
    private boolean eTD = false;
    private boolean eTE = false;
    private boolean eTF = false;
    private b.a eTG = new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void biC() {
            if (c.this.eTn != null && c.this.eTn.getParent() != null) {
                c.this.eTt = true;
                if (c.this.eTp != null) {
                    c.this.eTp.oZ();
                }
                c.this.eTn.setCloseBtnVisible(true);
                c.this.eTn.setAllInBtnVisible(true);
                c.this.eTn.setLiveContainerVisible(true);
                if (!com.baidu.live.c.oI().getBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, false)) {
                    com.baidu.live.c.oI().putBoolean("SHARE_PRE_KEY_CHALLENGE_COUNT_DOWN" + c.this.challengeId, true);
                    if ((!c.this.eTE && !c.this.isHost) || (!c.this.eTD && c.this.isHost)) {
                        if (c.this.eTq == null) {
                            c.this.eTq = new AlaChallengeCountDown(c.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = c.this.eTq.getLayoutParams() != null ? (RelativeLayout.LayoutParams) c.this.eTq.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (c.this.eTq.getParent() != null) {
                            ((ViewGroup) c.this.eTq.getParent()).removeView(c.this.eTq);
                        }
                        c.this.eTn.getLiveContainerView().addView(c.this.eTq, layoutParams);
                        c.this.eTq.startCountDown();
                    }
                }
                if (c.this.isHost) {
                    c.this.eTz = true;
                }
                c.this.biJ();
                c.this.biK();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void biD() {
            if (c.this.eTn != null && c.this.eTn.getParent() != null) {
                c.this.eTu = false;
                if (c.this.eTp != null) {
                    c.this.eTp.aq(false);
                }
                if (c.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = c.this.mTbPageContext;
                    cVar.challengeId = c.this.challengeId;
                    cVar.Vc = c.this.Vc;
                    cVar.liveId = c.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                c.this.eTn.setLiveContainerVisible(false);
                c.this.eTz = true;
                c.this.eTA = true;
                c.this.biJ();
                c.this.biK();
                c.this.eTz = false;
                c.this.eTA = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void biE() {
            if (c.this.eTn != null && c.this.eTn.getParent() != null) {
                if (!c.this.eTu) {
                    c.this.biI();
                    c.this.biM();
                }
                c.this.eTz = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.b.a
        public void biF() {
            c.this.eTA = false;
        }
    };
    private AlaChallengeLiveView.a eTH = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void biA() {
            c.this.biO();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void biB() {
            c.this.eTr.pj();
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void b(z zVar) {
            if (zVar != null && zVar.ZA != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.mTbPageContext.getPageActivity(), String.valueOf(zVar.ZA.userId), zVar.ZA.userName, zVar.ZA.portrait, zVar.ZA.sex, zVar.ZA.levelId, null, null, 0L, zVar.ZA.fansCount, zVar.ZA.followCount, zVar.ZA.userStatus, String.valueOf(zVar.ZB.group_id), String.valueOf(zVar.ZB.live_id), false, String.valueOf(c.this.eTB), zVar.ZA.appId, zVar.ZA.userName)));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void c(z zVar) {
            if (!c.this.isHost) {
                if (c.this.eTF) {
                    BdUtilHelper.hideSoftKeyPad(c.this.mTbPageContext.getPageActivity(), c.this.eTn);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.r.a.wA().arE.Yr || !TbadkCoreApplication.getInst().isMobileBaidu()) && zVar != null && zVar.ZB != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(c.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(zVar.ZB.live_id, "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }
    };
    private Runnable eTI = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.4
        @Override // java.lang.Runnable
        public void run() {
            String string;
            c.this.mHandler.removeCallbacks(this);
            if (c.this.eTC < 10) {
                string = c.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_challenge_all_in_countdown_time1, String.valueOf(c.this.eTC));
            } else {
                string = c.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_challenge_all_in_countdown_time, String.valueOf(c.this.eTC));
            }
            c.this.eTn.setAllInCountDownText(string);
            if (c.this.eTC <= 0) {
                c.this.eTC = 10;
                c.this.mHandler.removeCallbacks(this);
                c.this.eTn.setAllInBtnVisible(false);
                c.this.eTn.setAllInCountDownTextVisible(false);
                return;
            }
            c.v(c.this);
            c.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private Handler mHandler = new Handler();

    static /* synthetic */ int v(c cVar) {
        int i = cVar.eTC;
        cVar.eTC = i - 1;
        return i;
    }

    public c(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eTo = new b(tbPageContext.getPageActivity());
        this.eTo.a(this.eTG);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.eTo.bl(i, (i * 4) / 3);
    }

    @Override // com.baidu.live.challenge.i
    public void e(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.i
    public void b(boolean z, boolean z2, boolean z3) {
        this.eTE = z;
        this.isHost = z2;
        this.eTD = z3;
    }

    private void biG() {
        if (this.eTn == null) {
            this.eTn = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.eTn.setIsHost(this.isHost);
            this.eTn.setViewClickCallBack(this.eTH);
        }
    }

    private void biH() {
        int i = 0;
        if (this.eTn != null && this.mParentView != null) {
            if (this.eTn.getParent() != null) {
                ((ViewGroup) this.eTn.getParent()).removeView(this.eTn);
            }
            int i2 = this.mParentView.getChildCount() >= 2 ? 2 : 0;
            while (true) {
                if (i >= this.mParentView.getChildCount()) {
                    i = i2;
                    break;
                } else if (this.mParentView.getChildAt(i) instanceof com.baidu.live.liveroom.e.a) {
                    break;
                } else {
                    i++;
                }
            }
            if (this.eTn.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.eTn, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.eTn, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biI() {
        if (this.eTn != null && this.eTn.getParent() != null) {
            ((ViewGroup) this.eTn.getParent()).removeView(this.eTn);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(j jVar) {
        this.eTr = jVar;
    }

    @Override // com.baidu.live.challenge.i
    public void a(h hVar) {
        this.eTp = hVar;
    }

    @Override // com.baidu.live.challenge.i
    public void pb() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.eTt);
        }
        this.eTA = true;
        biK();
    }

    @Override // com.baidu.live.challenge.i
    public void bd(int i) {
        if (1 == i) {
            this.eTz = true;
            biJ();
        }
        if (2 == i) {
            this.eTA = true;
            biK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biJ() {
        if (this.eTt && this.eTz) {
            this.eTo.c(this.eTn);
            if (this.eTn != null && this.eTn.getAnchorAnimLiveBgView() != null) {
                this.eTn.getAnchorAnimLiveBgView().setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biK() {
        if (this.eTt && this.eTA) {
            this.eTo.b(this.eTn);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void b(y yVar, z zVar, z zVar2) {
        this.eTu = true;
        this.eTv = false;
        g(yVar, zVar, zVar2);
    }

    @Override // com.baidu.live.challenge.j.e
    public void c(y yVar, z zVar, z zVar2) {
        this.eTu = true;
        this.eTv = true;
        g(yVar, zVar, zVar2);
        biL();
        if (this.eTy && this.eTx) {
            this.eTn.setAllInLabelVisible(true);
        }
    }

    @Override // com.baidu.live.challenge.j.e
    public void d(y yVar, final z zVar, z zVar2) {
        if (this.eTs) {
            this.eTu = true;
            this.eTv = true;
            if (yVar.Zp == 2) {
                g(yVar, zVar, zVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.d(zVar);
                    }
                }, 5000L);
            } else {
                d(zVar);
            }
        }
        this.eTy = false;
        this.eTx = false;
        this.eTw = false;
    }

    @Override // com.baidu.live.challenge.j.e
    public void e(y yVar, z zVar, z zVar2) {
        this.eTw = false;
    }

    private void g(y yVar, z zVar, z zVar2) {
        if (yVar != null) {
            this.challengeId = yVar.challengeId;
        }
        if (zVar != null) {
            if (zVar.ZA != null) {
                this.Vc = zVar.ZA.userId;
            }
            if (zVar.ZB != null) {
                this.liveId = zVar.ZB.live_id;
            }
        }
        if (!this.eTs) {
            this.eTs = true;
            if (this.eTp != null) {
                this.eTp.oY();
            }
            biG();
            biH();
            this.eTy = false;
            this.eTx = false;
            this.eTz = false;
            this.eTA = false;
            if (this.eTo != null && this.eTn != null) {
                this.eTn.a(yVar, zVar, zVar2, true);
                this.eTn.setRivalUserViewBg(zVar2);
                this.eTn.setAnchorUserViewBg(zVar);
                if (this.eTp != null) {
                    this.eTp.a(yVar, zVar, zVar2);
                }
                if (this.eTo != null) {
                    this.eTo.a(this.mTbPageContext.getPageActivity(), this.eTn);
                }
            }
        }
        if (this.eTt && this.eTn != null) {
            this.eTn.a(yVar, zVar, zVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void a(k kVar) {
        if (kVar != null && kVar.VP != null) {
            this.eTB = kVar.VP.userId;
        }
    }

    private void biL() {
        if (this.eTn != null) {
            this.eTn.getAnchorLiveAllInAnimImg().setVisibility(8);
            this.eTn.getRivalLiveAllInAnimImg().setVisibility(8);
            this.eTn.setAllInBtnVisible(false);
            this.eTo.a(false, this.eTn.getAnchorLiveAllInAnimImg(), this.eTn.getRivalLiveAllInAnimImg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(z zVar) {
        if (this.eTp != null) {
            this.eTp.pa();
        }
        biL();
        if (this.eTn != null) {
            this.eTn.setAnchorUserViewBg(zVar);
        }
        if (this.eTn != null) {
            this.eTn.setAllInLabelVisible(false);
            this.eTn.biy();
            this.eTo.a(false, this.eTn.getAnchorLiveAllInAnimImg(), this.eTn.getRivalLiveAllInAnimImg());
            this.eTo.b(this.mTbPageContext.getPageActivity(), this.eTn);
        }
    }

    @Override // com.baidu.live.challenge.i
    public void oS() {
        if (this.eTu) {
            if (this.eTp != null) {
                this.eTp.aq(true);
            }
            if (this.eTn != null) {
                this.eTn.bix();
            }
            this.eTz = false;
            this.eTA = false;
            biM();
            biI();
        }
    }

    @Override // com.baidu.live.challenge.i
    public void onDestroy() {
        biM();
        this.eTo.a((b.a) null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biM() {
        this.eTo.rJ();
        if (this.eTn != null) {
            this.eTo.a(false, this.eTn.getAnchorLiveAllInAnimImg(), this.eTn.getRivalLiveAllInAnimImg());
            this.eTn.releaseResource();
        }
        if (this.eTq != null) {
            this.eTq.biv();
        }
        this.eTu = false;
        this.eTs = false;
        this.eTt = false;
    }

    @Override // com.baidu.live.challenge.j.b
    public void a(int i, boolean z, String str) {
        if (this.eTn != null) {
            if (z) {
                this.eTn.setAllInBtnVisible(false);
                switch (i) {
                    case 1:
                        if (!this.eTy) {
                            this.eTy = true;
                            this.eTo.a(this.mTbPageContext, this.eTn.getAnchorLiveAllInAnimImg());
                            return;
                        }
                        return;
                    case 2:
                    default:
                        return;
                }
            }
            BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_do_request_fail), 1);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void pm() {
        if (!this.eTy && this.eTn != null) {
            this.eTy = true;
            this.eTo.a(this.mTbPageContext, this.eTn.getAnchorLiveAllInAnimImg());
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void pn() {
        if (!this.eTx && this.eTn != null) {
            this.eTx = true;
            biN();
            this.eTo.a(this.mTbPageContext, this.eTn.getRivalLiveAllInAnimImg());
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void po() {
        if (this.eTn != null) {
            if (this.isHost && !this.eTw) {
                this.eTw = true;
                TiebaInitialize.log(new StatisticItem("c13053"));
            }
            this.mHandler.removeCallbacks(this.eTI);
            if (this.eTy && !this.eTx) {
                this.eTx = true;
                this.eTo.b(this.mTbPageContext, this.eTn.getRivalLiveAllInAnimImg());
            } else if (this.eTx && !this.eTy) {
                this.eTy = true;
                this.eTo.b(this.mTbPageContext, this.eTn.getAnchorLiveAllInAnimImg());
            } else if (!this.eTx && !this.eTy && !this.eTv) {
                this.eTy = true;
                this.eTx = true;
                this.eTo.b(this.mTbPageContext, this.eTn.getRivalLiveAllInAnimImg());
                this.eTo.b(this.mTbPageContext, this.eTn.getAnchorLiveAllInAnimImg());
            }
            this.eTn.setAllInBtnVisible(false);
            this.eTn.setAllInCountDownTextVisible(false);
        }
    }

    @Override // com.baidu.live.challenge.j.c
    public void pp() {
        if (this.eTn != null) {
            if (this.eTo != null) {
                this.eTn.getAnchorLiveAllInAnimImg().setVisibility(8);
                this.eTn.getRivalLiveAllInAnimImg().setVisibility(8);
                this.eTo.a(true, this.eTn.getAnchorLiveAllInAnimImg(), this.eTn.getRivalLiveAllInAnimImg());
            }
            this.eTn.setAllInBtnVisible(false);
            this.eTn.setAllInLabelVisible(false);
        }
    }

    @Override // com.baidu.live.challenge.j.l
    public void d(boolean z, String str) {
        if (z) {
            this.eTv = true;
            this.eTn.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    private void biN() {
        this.eTn.setAllInCountDownTextVisible(true);
        this.mHandler.post(this.eTI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biO() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        if (this.eTw) {
            bdAlertDialog.setMessageId(a.i.ala_challenge_all_in_back_confirm_tip);
        } else {
            bdAlertDialog.setMessageId(a.i.ala_challenge_back_confirm_tip);
        }
        bdAlertDialog.setNegativeButton(a.i.sdk_quit, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                c.this.eTr.pk();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setPositiveButton(a.i.ala_challenge_back_stay, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.c.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mTbPageContext);
        bdAlertDialog.show();
    }

    @Override // com.baidu.live.challenge.i
    public boolean isActive() {
        return this.eTu;
    }

    @Override // com.baidu.live.challenge.i
    public int ar(boolean z) {
        int aH;
        int aI = g.aI(this.mTbPageContext.getPageActivity());
        if (z) {
            aH = g.aG(this.mTbPageContext.getPageActivity());
        } else {
            aH = g.aH(this.mTbPageContext.getPageActivity());
        }
        int i = aH + aI;
        if (z && this.eTn != null && this.eTn.getCloseBtnView() != null && this.eTn.getCloseBtnView().getVisibility() == 0) {
            int dimensionPixelOffset = this.mTbPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds30) + i;
            ViewGroup.LayoutParams layoutParams = this.eTn.getCloseBtnView().getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + dimensionPixelOffset : dimensionPixelOffset;
        }
        return i;
    }
}

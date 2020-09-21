package com.baidu.tieba.ala.liveroom.challenge.view;

import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.challenge.g;
import com.baidu.live.challenge.h;
import com.baidu.live.challenge.i;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.bq;
import com.baidu.live.data.e;
import com.baidu.live.data.u;
import com.baidu.live.follow.a.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.GetChallengeMvpToastInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView;
import com.baidu.tieba.ala.liveroom.challenge.view.a;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class d implements h {
    private com.baidu.live.follow.a.b gzA;
    private CustomMessageListener gzB;
    private com.baidu.tieba.ala.liveroom.challenge.c.a gzC;
    private AlaChallengeLiveView gzk;
    private a gzl;
    private g gzm;
    private AlaChallengeCountDown gzn;
    private i gzo;
    private long gzw;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean gzp = false;
    private boolean gzq = false;
    private boolean gzr = false;
    private boolean gzs = true;
    private boolean gzt = false;
    private boolean gzu = false;
    private long challengeId = 0;
    private long aDf = 0;
    private long liveId = -1;
    private long gzv = 0;
    private boolean isHost = false;
    private boolean gzx = false;
    private boolean gzy = false;
    private boolean gzz = false;
    public boolean gyr = false;
    private Set<Long> gzD = new HashSet();
    private a.InterfaceC0623a gzE = new a.InterfaceC0623a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0623a
        public void bRT() {
            if (d.this.gzk != null && d.this.gzk.getParent() != null) {
                d.this.gzq = true;
                if (d.this.gzm != null) {
                    d.this.gzm.BV();
                }
                d.this.gzk.setCloseBtnVisible(true);
                d.this.gzk.setLiveContainerVisible(true);
                if (!d.this.gzD.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.gzD.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.gzy && !d.this.isHost) || (!d.this.gzx && d.this.isHost)) {
                        if (d.this.gzn == null) {
                            d.this.gzn = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.gzn.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.gzn.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.gzn.getParent() != null) {
                            ((ViewGroup) d.this.gzn.getParent()).removeView(d.this.gzn);
                        }
                        d.this.gzk.getLiveContainerView().addView(d.this.gzn, layoutParams);
                        d.this.gzn.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.gzt = true;
                }
                d.this.bSe();
                d.this.bSf();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0623a
        public void bRU() {
            if (d.this.gzk != null && d.this.gzk.getParent() != null) {
                d.this.gzr = false;
                if (d.this.gzm != null) {
                    d.this.gzm.bc(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.aDf = d.this.aDf;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.gzk.setLiveContainerVisible(false);
                bRV();
                bRW();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0623a
        public void bRV() {
            if (d.this.gzk != null && d.this.gzk.getParent() != null) {
                if (!d.this.gzr) {
                    d.this.bSd();
                    d.this.bSg();
                }
                d.this.gzt = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0623a
        public void bRW() {
            d.this.gzu = false;
        }
    };
    private AlaChallengeLiveView.a gzF = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bRR() {
            d.this.mb(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bq bqVar) {
            if (bqVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.i.ala_challenge_punish_close_dont_tip));
            } else if (bqVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bqVar.aEQ);
            } else {
                d.this.mb(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(ay ayVar) {
            if (ayVar != null && ayVar.aJI != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(ayVar.aJI.userId), ayVar.aJI.userName, ayVar.aJI.portrait, ayVar.aJI.sex, ayVar.aJI.levelId, null, null, 0L, ayVar.aJI.fansCount, ayVar.aJI.followCount, ayVar.aJI.userStatus, String.valueOf(ayVar.aJW.group_id), String.valueOf(ayVar.aJW.live_id), false, String.valueOf(d.this.gzv), ayVar.aJI.appId, ayVar.aJI.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(ay ayVar) {
            if (ayVar != null && ayVar.aJI != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_neterror));
                } else {
                    e eVar = new e();
                    eVar.setUserId(String.valueOf(ayVar.aJI.userId));
                    eVar.setPortrait(ayVar.aJI.portrait);
                    eVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    eVar.setIsAttention(true);
                    eVar.setInLive("1");
                    eVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Rg().a(String.valueOf(ayVar.aJI.userId), eVar);
                    if (d.this.gzk != null) {
                        d.this.gzk.lZ(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(ay ayVar) {
            if (!d.this.isHost) {
                if (d.this.gzz) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.gzk);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.i.sdk_neterror);
                } else if ((com.baidu.live.x.a.NN().bhy.aId || !TbadkCoreApplication.getInst().isMobileBaidu()) && ayVar != null && ayVar.aJW != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(ayVar.aJW.live_id, "", "live_sdk");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void bRS() {
            if (d.this.gyr && d.this.gzm != null) {
                d.this.gzm.bd(d.this.gyr);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void ma(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.b.c cVar = new com.baidu.live.b.c(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            cVar.b(d.this.challengeId, d.this.liveId, d.this.aDf);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        }
    };
    private HttpMessageListener gzG = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.gzC != null) {
                    d.this.gzC.release();
                }
                d.this.gzC = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.aDf, d.this.challengeId, d.this.gzo, getChallengeMvpToastInfoResponseMessage);
                d.this.gzC.NY();
            }
        }
    };
    CustomMessageListener gzH = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.gzo != null) {
                d.this.gzo.a(d.this.challengeId, d.this.liveId, d.this.aDf, 6, "0");
            }
        }
    };
    private CustomMessageListener gzI = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.gzw > 0 && d.this.gzk != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.gzw))) {
                    d.this.gzk.lZ(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gzl = new a(tbPageContext.getPageActivity());
        this.gzl.a(this.gzE);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.gzl.bO(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.gzG);
        MessageManager.getInstance().registerListener(this.gzH);
        MessageManager.getInstance().registerListener(this.gzI);
    }

    @Override // com.baidu.live.challenge.h
    public void m(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.gzy = z;
        this.isHost = z2;
        this.gzx = z3;
    }

    private void bSb() {
        if (this.gzk == null) {
            this.gzk = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.gzk.setIsHost(this.isHost);
            this.gzk.setViewClickCallBack(this.gzF);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.gyr = z;
        if (this.gzk != null) {
            this.gzk.setNeedCloseRecommendFloat(this.gyr);
        }
    }

    private void bSc() {
        int i = 0;
        if (this.gzk != null && this.mParentView != null) {
            if (this.gzk.getParent() != null) {
                ((ViewGroup) this.gzk.getParent()).removeView(this.gzk);
            }
            int i2 = this.mParentView.getChildCount() >= 2 ? 2 : 0;
            while (true) {
                if (i >= this.mParentView.getChildCount()) {
                    i = i2;
                    break;
                } else if (this.mParentView.getChildAt(i) instanceof com.baidu.live.liveroom.g.a) {
                    break;
                } else {
                    i++;
                }
            }
            if (this.gzk.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.gzk, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.gzk, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSd() {
        if (this.gzk != null && this.gzk.getParent() != null) {
            ((ViewGroup) this.gzk.getParent()).removeView(this.gzk);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.gzo = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.gzm = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void BX() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.gzq);
        }
        this.gzu = true;
        bSf();
    }

    @Override // com.baidu.live.challenge.h
    public void dH(int i) {
        if (1 == i) {
            this.gzt = true;
            bSe();
        }
        if (2 == i) {
            this.gzu = true;
            bSf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSe() {
        if (this.gzq && this.gzt) {
            this.gzl.k(this.gzk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSf() {
        if (this.gzq && this.gzu) {
            this.gzl.j(this.gzk);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(au auVar, ay ayVar, ay ayVar2) {
        this.gzr = true;
        this.gzs = false;
        f(auVar, ayVar, ayVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(au auVar, ay ayVar, ay ayVar2) {
        this.gzr = true;
        this.gzs = true;
        f(auVar, ayVar, ayVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(au auVar, final ay ayVar, ay ayVar2) {
        long j = -1;
        if (this.gzp) {
            this.gzr = true;
            this.gzs = true;
            if (auVar.aJL == 2) {
                f(auVar, ayVar, ayVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(ayVar);
                    }
                }, 5000L);
                return;
            }
            g(ayVar);
            return;
        }
        long j2 = auVar != null ? auVar.challengeId : -1L;
        if (ayVar != null && ayVar.aJW != null) {
            j = ayVar.aJW.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(au auVar, ay ayVar, ay ayVar2) {
    }

    private void f(au auVar, ay ayVar, ay ayVar2) {
        if (auVar != null) {
            this.challengeId = auVar.challengeId;
        }
        if (ayVar != null) {
            if (ayVar.aJI != null) {
                this.aDf = ayVar.aJI.userId;
            }
            if (ayVar.aJW != null) {
                this.liveId = ayVar.aJW.live_id;
            }
        }
        if (ayVar2 != null && ayVar2.aJI != null) {
            this.gzw = ayVar2.aJI.userId;
        }
        if (!this.gzp) {
            this.gzp = true;
            if (this.gzm != null) {
                this.gzm.BU();
            }
            bSb();
            bSc();
            this.gzt = false;
            this.gzu = false;
            if (this.gzl != null && this.gzk != null) {
                this.gzk.a(auVar, ayVar, ayVar2, true);
                this.gzk.setRivalUserViewBg(ayVar2);
                this.gzk.setAnchorUserViewBg(ayVar);
                if (this.gzm != null) {
                    this.gzm.a(auVar, ayVar, ayVar2);
                }
                if (this.gzl != null) {
                    this.gzl.a(this.mTbPageContext.getPageActivity(), this.gzk);
                }
                bSh();
                String str = null;
                if (ayVar2 != null && ayVar2.aJW != null) {
                    str = String.valueOf(ayVar2.aJW.live_id);
                }
                if (TextUtils.isEmpty(str) || !ef(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.gzk.lZ(false);
                }
            }
        }
        if (this.gzq && this.gzk != null) {
            this.gzk.a(auVar, ayVar, ayVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(u uVar) {
        if (uVar != null && uVar.aEz != null) {
            this.gzv = uVar.aEz.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ay ayVar) {
        if (this.gzm != null) {
            this.gzm.BW();
        }
        if (this.gzk != null) {
            this.gzk.setAnchorUserViewBg(ayVar);
        }
        if (this.gzk != null) {
            this.gzk.bRO();
            this.gzk.bRN();
            this.gzl.b(this.mTbPageContext.getPageActivity(), this.gzk);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void BQ() {
        if (this.gzr) {
            if (this.gzm != null) {
                this.gzm.bc(true);
            }
            if (this.gzk != null) {
                this.gzk.bRM();
            }
            this.gzt = false;
            this.gzu = false;
            bSg();
            this.mHandler.removeCallbacksAndMessages(null);
            bSd();
            if (this.gzC != null) {
                this.gzC.release();
                this.gzC = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        bSg();
        this.gzl.a((a.InterfaceC0623a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gzC != null) {
            this.gzC.release();
            this.gzC = null;
        }
        if (this.gzD != null) {
            this.gzD.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.gzG);
        MessageManager.getInstance().unRegisterListener(this.gzH);
        MessageManager.getInstance().unRegisterListener(this.gzI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSg() {
        MessageManager.getInstance().unRegisterListener(this.gzB);
        if (this.gzA != null) {
            this.gzA.release();
        }
        this.gzl.FW();
        if (this.gzk != null) {
            this.gzk.releaseResource();
        }
        if (this.gzn != null) {
            this.gzn.bRK();
        }
        this.gzr = false;
        this.gzp = false;
        this.gzq = false;
        this.gzw = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.gzs = true;
            this.gzk.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(final boolean z) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        if (z) {
            bdAlertDialog.setMessageId(a.i.ala_challenge_punish_close_confirm_tip);
        } else {
            bdAlertDialog.setMessageId(a.i.ala_challenge_back_confirm_tip);
        }
        bdAlertDialog.setPositiveButton(a.i.ala_challenge_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    d.this.gzo.Ci();
                    return;
                }
                d.this.gzo.Cg();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bdAlertDialog.setPositiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
            bdAlertDialog.setNagetiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
        } else {
            bdAlertDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            bdAlertDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        bdAlertDialog.create(this.mTbPageContext);
        bdAlertDialog.show();
    }

    @Override // com.baidu.live.challenge.h
    public boolean isActive() {
        return this.gzr;
    }

    @Override // com.baidu.live.challenge.h
    public int be(boolean z) {
        int j = com.baidu.live.utils.h.j(this.mTbPageContext.getPageActivity(), z);
        if (z && this.gzk != null && this.gzk.getCloseBtnView() != null && this.gzk.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.gzk.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + j;
            }
        }
        return j;
    }

    private boolean ef(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.gzA == null) {
            this.gzA = new com.baidu.live.follow.a.a();
        }
        this.gzA.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.gzk != null) {
                    d.this.gzk.lZ(z2);
                }
            }
        });
        this.gzA.an(str, str2);
        return true;
    }

    private void bSh() {
        if (this.gzB == null) {
            this.gzB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.gzw > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.gzw))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.gzk != null) {
                                    d.this.gzk.lZ(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.gzk != null) {
                                d.this.gzk.lZ(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Rg().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gzB);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.gzs = true;
            this.gzk.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.i.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    @Override // com.baidu.live.challenge.h
    public void c(int i, long j) {
        if (this.gzr && i == 3 && j == this.challengeId) {
            if (com.baidu.live.x.a.NN().bhy == null || com.baidu.live.x.a.NN().bhy.aHM == 1) {
                bSi();
            }
        }
    }

    public void bSi() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

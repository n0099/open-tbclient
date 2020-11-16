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
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.bv;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
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
    private AlaChallengeLiveView hfc;
    private a hfd;
    private g hfe;
    private AlaChallengeCountDown hff;
    private i hfg;
    private long hfo;
    private com.baidu.live.follow.a.b hfs;
    private CustomMessageListener hft;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hfu;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hfh = false;
    private boolean hfi = false;
    private boolean hfj = false;
    private boolean hfk = true;
    private boolean hfl = false;
    private boolean hfm = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hfn = 0;
    private boolean isHost = false;
    private boolean hfp = false;
    private boolean hfq = false;
    private boolean hfr = false;
    public boolean hej = false;
    private Set<Long> hfv = new HashSet();
    private a.InterfaceC0671a hfw = new a.InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void cah() {
            if (d.this.hfc != null && d.this.hfc.getParent() != null) {
                d.this.hfi = true;
                if (d.this.hfe != null) {
                    d.this.hfe.CI();
                }
                d.this.hfc.setCloseBtnVisible(true);
                d.this.hfc.setLiveContainerVisible(true);
                if (!d.this.hfv.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hfv.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hfq && !d.this.isHost) || (!d.this.hfp && d.this.isHost)) {
                        if (d.this.hff == null) {
                            d.this.hff = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hff.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hff.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hff.getParent() != null) {
                            ((ViewGroup) d.this.hff.getParent()).removeView(d.this.hff);
                        }
                        d.this.hfc.getLiveContainerView().addView(d.this.hff, layoutParams);
                        d.this.hff.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hfl = true;
                }
                d.this.car();
                d.this.cas();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void cai() {
            if (d.this.hfc != null && d.this.hfc.getParent() != null) {
                d.this.hfj = false;
                if (d.this.hfe != null) {
                    d.this.hfe.bk(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hfc.setLiveContainerVisible(false);
                caj();
                cak();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void caj() {
            if (d.this.hfc != null && d.this.hfc.getParent() != null) {
                if (!d.this.hfj) {
                    d.this.caq();
                    d.this.cat();
                }
                d.this.hfl = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void cak() {
            d.this.hfm = false;
        }
    };
    private AlaChallengeLiveView.a hfx = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void caf() {
            d.this.nd(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bv bvVar) {
            if (bvVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.h.ala_challenge_punish_close_dont_tip));
            } else if (bvVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bvVar.aHB);
            } else {
                d.this.nd(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(bd bdVar) {
            if (bdVar != null && bdVar.aMK != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(bdVar.aMK.userId), bdVar.aMK.userName, bdVar.aMK.portrait, bdVar.aMK.sex, bdVar.aMK.levelId, null, null, 0L, bdVar.aMK.fansCount, bdVar.aMK.followCount, bdVar.aMK.userStatus, String.valueOf(bdVar.aMY.group_id), String.valueOf(bdVar.aMY.live_id), false, String.valueOf(bdVar.aMK.userId), bdVar.aMK.appId, bdVar.aMK.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(bd bdVar) {
            if (bdVar != null && bdVar.aMK != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(bdVar.aMK.userId));
                    fVar.setPortrait(bdVar.aMK.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.VO().a(String.valueOf(bdVar.aMK.userId), fVar);
                    if (d.this.hfc != null) {
                        d.this.hfc.nb(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bd bdVar) {
            if (!d.this.isHost) {
                if (d.this.hfr) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hfc);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.h.sdk_neterror);
                } else if ((com.baidu.live.aa.a.Ph().bms.aLa || !TbadkCoreApplication.getInst().isMobileBaidu()) && bdVar != null && bdVar.aMY != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(bdVar.aMY.live_id, "", "live_sdk");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cag() {
            if (d.this.hej && d.this.hfe != null) {
                d.this.hfe.bl(d.this.hej);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void nc(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.b.d dVar = new com.baidu.live.b.d(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            dVar.b(d.this.challengeId, d.this.liveId, d.this.anchorId);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar));
        }
    };
    private HttpMessageListener hfy = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.hfu != null) {
                    d.this.hfu.release();
                }
                d.this.hfu = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hfg, getChallengeMvpToastInfoResponseMessage);
                d.this.hfu.PA();
            }
        }
    };
    CustomMessageListener hfz = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hfg != null) {
                d.this.hfg.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hfA = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hfo > 0 && d.this.hfc != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hfo))) {
                    d.this.hfc.nb(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hfd = new a(tbPageContext.getPageActivity());
        this.hfd.a(this.hfw);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hfd.bS(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hfy);
        MessageManager.getInstance().registerListener(this.hfz);
        MessageManager.getInstance().registerListener(this.hfA);
    }

    @Override // com.baidu.live.challenge.h
    public void i(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.hfq = z;
        this.isHost = z2;
        this.hfp = z3;
    }

    private void cao() {
        if (this.hfc == null) {
            this.hfc = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hfc.setIsHost(this.isHost);
            this.hfc.setViewClickCallBack(this.hfx);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hej = z;
        if (this.hfc != null) {
            this.hfc.setNeedCloseRecommendFloat(this.hej);
        }
    }

    private void cap() {
        int i = 0;
        if (this.hfc != null && this.mParentView != null) {
            if (this.hfc.getParent() != null) {
                ((ViewGroup) this.hfc.getParent()).removeView(this.hfc);
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
            if (this.hfc.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hfc, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hfc, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caq() {
        if (this.hfc != null && this.hfc.getParent() != null) {
            ((ViewGroup) this.hfc.getParent()).removeView(this.hfc);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hfg = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hfe = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void CK() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hfi);
        }
        this.hfm = true;
        cas();
    }

    @Override // com.baidu.live.challenge.h
    public void dI(int i) {
        if (1 == i) {
            this.hfl = true;
            car();
        }
        if (2 == i) {
            this.hfm = true;
            cas();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void car() {
        if (this.hfi && this.hfl) {
            this.hfd.k(this.hfc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cas() {
        if (this.hfi && this.hfm) {
            this.hfd.j(this.hfc);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(az azVar, bd bdVar, bd bdVar2) {
        this.hfj = true;
        this.hfk = false;
        f(azVar, bdVar, bdVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(az azVar, bd bdVar, bd bdVar2) {
        this.hfj = true;
        this.hfk = true;
        f(azVar, bdVar, bdVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(az azVar, final bd bdVar, bd bdVar2) {
        long j = -1;
        if (this.hfh) {
            this.hfj = true;
            this.hfk = true;
            if (azVar.aMN == 2) {
                f(azVar, bdVar, bdVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(bdVar);
                    }
                }, 5000L);
                return;
            }
            g(bdVar);
            return;
        }
        long j2 = azVar != null ? azVar.challengeId : -1L;
        if (bdVar != null && bdVar.aMY != null) {
            j = bdVar.aMY.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(az azVar, bd bdVar, bd bdVar2) {
    }

    private void f(az azVar, bd bdVar, bd bdVar2) {
        if (azVar != null) {
            this.challengeId = azVar.challengeId;
        }
        if (bdVar != null) {
            if (bdVar.aMK != null) {
                this.anchorId = bdVar.aMK.userId;
            }
            if (bdVar.aMY != null) {
                this.liveId = bdVar.aMY.live_id;
            }
        }
        if (bdVar2 != null && bdVar2.aMK != null) {
            this.hfo = bdVar2.aMK.userId;
        }
        if (!this.hfh) {
            this.hfh = true;
            if (this.hfe != null) {
                this.hfe.CH();
            }
            cao();
            cap();
            this.hfl = false;
            this.hfm = false;
            if (this.hfd != null && this.hfc != null) {
                this.hfc.a(azVar, bdVar, bdVar2, true);
                this.hfc.setRivalUserViewBg(bdVar2);
                this.hfc.setAnchorUserViewBg(bdVar);
                if (this.hfe != null) {
                    this.hfe.a(azVar, bdVar, bdVar2);
                }
                if (this.hfd != null) {
                    this.hfd.a(this.mTbPageContext.getPageActivity(), this.hfc);
                }
                cau();
                String str = null;
                if (bdVar2 != null && bdVar2.aMY != null) {
                    str = String.valueOf(bdVar2.aMY.live_id);
                }
                if (TextUtils.isEmpty(str) || !et(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hfc.nb(false);
                }
            }
        }
        if (this.hfi && this.hfc != null) {
            this.hfc.a(azVar, bdVar, bdVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(w wVar) {
        if (wVar != null && wVar.aHk != null) {
            this.hfn = wVar.aHk.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bd bdVar) {
        if (this.hfe != null) {
            this.hfe.CJ();
        }
        if (this.hfc != null) {
            this.hfc.setAnchorUserViewBg(bdVar);
        }
        if (this.hfc != null) {
            this.hfc.cac();
            this.hfc.cab();
            this.hfd.b(this.mTbPageContext.getPageActivity(), this.hfc);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void CD() {
        if (this.hfj) {
            if (this.hfe != null) {
                this.hfe.bk(true);
            }
            if (this.hfc != null) {
                this.hfc.caa();
            }
            this.hfl = false;
            this.hfm = false;
            cat();
            this.mHandler.removeCallbacksAndMessages(null);
            caq();
            if (this.hfu != null) {
                this.hfu.release();
                this.hfu = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        cat();
        this.hfd.a((a.InterfaceC0671a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hfu != null) {
            this.hfu.release();
            this.hfu = null;
        }
        if (this.hfv != null) {
            this.hfv.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hfy);
        MessageManager.getInstance().unRegisterListener(this.hfz);
        MessageManager.getInstance().unRegisterListener(this.hfA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cat() {
        MessageManager.getInstance().unRegisterListener(this.hft);
        if (this.hfs != null) {
            this.hfs.release();
        }
        this.hfd.Hg();
        if (this.hfc != null) {
            this.hfc.releaseResource();
        }
        if (this.hff != null) {
            this.hff.bZY();
        }
        this.hfj = false;
        this.hfh = false;
        this.hfi = false;
        this.hfo = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.hfk = true;
            this.hfc.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(final boolean z) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setContentViewSize(1);
        if (z) {
            bdAlertDialog.setMessageId(a.h.ala_challenge_punish_close_confirm_tip);
        } else {
            bdAlertDialog.setMessageId(a.h.ala_challenge_back_confirm_tip);
        }
        bdAlertDialog.setPositiveButton(a.h.ala_challenge_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    d.this.hfg.CW();
                    return;
                }
                d.this.hfg.CU();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            bdAlertDialog.setPositiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
            bdAlertDialog.setNagetiveButtonTextColor(this.mTbPageContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
        } else {
            bdAlertDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            bdAlertDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        bdAlertDialog.create(this.mTbPageContext);
        bdAlertDialog.show();
    }

    @Override // com.baidu.live.challenge.h
    public boolean isActive() {
        return this.hfj;
    }

    @Override // com.baidu.live.challenge.h
    public int bm(boolean z) {
        int j = com.baidu.live.utils.h.j(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hfc != null && this.hfc.getCloseBtnView() != null && this.hfc.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hfc.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + j;
            }
        }
        return j;
    }

    private boolean et(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.hfs == null) {
            this.hfs = new com.baidu.live.follow.a.a();
        }
        this.hfs.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hfc != null) {
                    d.this.hfc.nb(z2);
                }
            }
        });
        this.hfs.aq(str, str2);
        return true;
    }

    private void cau() {
        if (this.hft == null) {
            this.hft = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hfo > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hfo))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hfc != null) {
                                    d.this.hfc.nb(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hfc != null) {
                                d.this.hfc.nb(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.VO().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hft);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.hfk = true;
            this.hfc.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    @Override // com.baidu.live.challenge.h
    public void c(int i, long j) {
        if (this.hfj && i == 3 && j == this.challengeId) {
            if (com.baidu.live.aa.a.Ph().bms == null || com.baidu.live.aa.a.Ph().bms.aKH == 1) {
                cav();
            }
        }
    }

    public void cav() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

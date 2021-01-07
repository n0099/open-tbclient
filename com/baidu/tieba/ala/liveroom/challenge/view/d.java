package com.baidu.tieba.ala.liveroom.challenge.view;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
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
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.bz;
import com.baidu.live.data.f;
import com.baidu.live.data.x;
import com.baidu.live.follow.a.c;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.liveroom.challenge.message.GetChallengeMvpToastInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.message.SetChallengeMvpPunishChooseResponseMessage;
import com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView;
import com.baidu.tieba.ala.liveroom.challenge.view.a;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d implements h {
    private AlaChallengeLiveView hAH;
    private a hAI;
    private g hAJ;
    private AlaChallengeCountDown hAK;
    private i hAL;
    private long hAT;
    private com.baidu.live.follow.a.c hAX;
    private CustomMessageListener hAY;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hAZ;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hAM = false;
    private boolean hAN = false;
    private boolean hAO = false;
    private boolean hAP = true;
    private boolean hAQ = false;
    private boolean hAR = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hAS = 0;
    private boolean isHost = false;
    private boolean hAU = false;
    private boolean hAV = false;
    private boolean hAW = false;
    public boolean hzO = false;
    private Set<Long> hBa = new HashSet();
    private a.InterfaceC0676a hBb = new a.InterfaceC0676a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0676a
        public void cgU() {
            if (d.this.hAH != null && d.this.hAH.getParent() != null) {
                d.this.hAN = true;
                if (d.this.hAJ != null) {
                    d.this.hAJ.DH();
                }
                d.this.hAH.setCloseBtnVisible(true);
                d.this.hAH.setLiveContainerVisible(true);
                if (!d.this.hBa.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hBa.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hAV && !d.this.isHost) || (!d.this.hAU && d.this.isHost)) {
                        if (d.this.hAK == null) {
                            d.this.hAK = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hAK.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hAK.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hAK.getParent() != null) {
                            ((ViewGroup) d.this.hAK.getParent()).removeView(d.this.hAK);
                        }
                        d.this.hAH.getLiveContainerView().addView(d.this.hAK, layoutParams);
                        d.this.hAK.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hAQ = true;
                }
                d.this.che();
                d.this.chf();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "one_to_two_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0676a
        public void cgV() {
            if (d.this.hAH != null && d.this.hAH.getParent() != null) {
                d.this.hAO = false;
                if (d.this.hAJ != null) {
                    d.this.hAJ.bp(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hAH.setLiveContainerVisible(false);
                cgW();
                cgX();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "two_to_one_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0676a
        public void cgW() {
            if (d.this.hAH != null && d.this.hAH.getParent() != null) {
                if (!d.this.hAO) {
                    d.this.chd();
                    d.this.chg();
                }
                d.this.hAQ = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0676a
        public void cgX() {
            d.this.hAR = false;
        }
    };
    private AlaChallengeLiveView.a hBc = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cgS() {
            d.this.nY(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bz bzVar) {
            if (bzVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.h.ala_challenge_punish_close_dont_tip));
            } else if (bzVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bzVar.aKL);
            } else {
                d.this.nY(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(bg bgVar) {
            if (bgVar != null && bgVar.aQy != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(bgVar.aQy.userId), bgVar.aQy.userName, bgVar.aQy.portrait, bgVar.aQy.sex, bgVar.aQy.levelId, null, null, 0L, bgVar.aQy.fansCount, bgVar.aQy.followCount, bgVar.aQy.userStatus, String.valueOf(bgVar.aQM.group_id), String.valueOf(bgVar.aQM.live_id), false, String.valueOf(bgVar.aQy.userId), bgVar.aQy.appId, bgVar.aQy.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(bg bgVar) {
            if (bgVar != null && bgVar.aQy != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(bgVar.aQy.userId));
                    fVar.setPortrait(bgVar.aQy.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Zy().a(String.valueOf(bgVar.aQy.userId), fVar);
                    if (d.this.hAH != null) {
                        d.this.hAH.nW(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bg bgVar) {
            if (!d.this.isHost) {
                if (d.this.hAW) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hAH);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.h.sdk_neterror);
                } else if ((com.baidu.live.af.a.SE().bwi.aOz || !TbadkCoreApplication.getInst().isMobileBaidu()) && bgVar != null && bgVar.aQM != null) {
                    com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(bgVar.aQM.live_id)));
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(bgVar.aQM.live_id, "", "live_sdk");
                    com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cgT() {
            if (d.this.hzO && d.this.hAJ != null) {
                d.this.hAJ.bq(d.this.hzO);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void nX(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            com.baidu.live.d.d dVar = new com.baidu.live.d.d(d.this.mTbPageContext.getPageActivity(), i, d.this.isHost);
            dVar.b(d.this.challengeId, d.this.liveId, d.this.anchorId);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar));
        }
    };
    private HttpMessageListener hBd = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage)) {
                boolean z = !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0;
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPTOASTINFO_RESULT, "author_liveroom", z ? "challenge_getmvptoastinfo_succ" : "challenge_getmvptoastinfo_fail"), httpResponsedMessage, true);
                if (z) {
                    GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                    if (d.this.hAZ != null) {
                        d.this.hAZ.release();
                    }
                    d.this.hAZ = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hAL, getChallengeMvpToastInfoResponseMessage);
                    d.this.hAZ.SY();
                }
            }
        }
    };
    private HttpMessageListener hBe = new HttpMessageListener(1021200) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetChallengeMvpPunishChooseResponseMessage)) {
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE_RESULT, "author_liveroom", !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 ? "challenge_mvppunishchoose_succ" : "challenge_mvppunishchoose_fail"), httpResponsedMessage, true);
            }
        }
    };
    CustomMessageListener hBf = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hAL != null) {
                d.this.hAL.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hBg = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hAT > 0 && d.this.hAH != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hAT))) {
                    d.this.hAH.nW(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hAI = new a(tbPageContext.getPageActivity());
        this.hAI.a(this.hBb);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hAI.bV(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hBd);
        MessageManager.getInstance().registerListener(this.hBf);
        MessageManager.getInstance().registerListener(this.hBg);
        MessageManager.getInstance().registerListener(this.hBe);
    }

    @Override // com.baidu.live.challenge.h
    public void k(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void c(boolean z, boolean z2, boolean z3) {
        this.hAV = z;
        this.isHost = z2;
        this.hAU = z3;
    }

    private void chb() {
        if (this.hAH == null) {
            this.hAH = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hAH.setIsHost(this.isHost);
            this.hAH.setViewClickCallBack(this.hBc);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzO = z;
        if (this.hAH != null) {
            this.hAH.setNeedCloseRecommendFloat(this.hzO);
        }
    }

    private void chc() {
        int i = 0;
        if (this.hAH != null && this.mParentView != null) {
            if (this.hAH.getParent() != null) {
                ((ViewGroup) this.hAH.getParent()).removeView(this.hAH);
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
            if (this.hAH.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hAH, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hAH, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chd() {
        if (this.hAH != null && this.hAH.getParent() != null) {
            ((ViewGroup) this.hAH.getParent()).removeView(this.hAH);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hAL = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hAJ = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void DJ() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hAN);
        }
        this.hAR = true;
        chf();
    }

    @Override // com.baidu.live.challenge.h
    public void dY(int i) {
        if (1 == i) {
            this.hAQ = true;
            che();
        }
        if (2 == i) {
            this.hAR = true;
            chf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void che() {
        if (this.hAN && this.hAQ) {
            this.hAI.k(this.hAH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        if (this.hAN && this.hAR) {
            this.hAI.j(this.hAH);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bc bcVar, bg bgVar, bg bgVar2) {
        this.hAO = true;
        this.hAP = false;
        f(bcVar, bgVar, bgVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(bc bcVar, bg bgVar, bg bgVar2) {
        this.hAO = true;
        this.hAP = true;
        f(bcVar, bgVar, bgVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(bc bcVar, final bg bgVar, bg bgVar2) {
        long j = -1;
        if (this.hAM) {
            this.hAO = true;
            this.hAP = true;
            if (bcVar.aQB == 2) {
                f(bcVar, bgVar, bgVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(bgVar);
                    }
                }, 5000L);
                return;
            }
            g(bgVar);
            return;
        }
        long j2 = bcVar != null ? bcVar.challengeId : -1L;
        if (bgVar != null && bgVar.aQM != null) {
            j = bgVar.aQM.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(bc bcVar, bg bgVar, bg bgVar2) {
    }

    private void f(bc bcVar, bg bgVar, bg bgVar2) {
        if (bcVar != null) {
            this.challengeId = bcVar.challengeId;
        }
        if (bgVar != null) {
            if (bgVar.aQy != null) {
                this.anchorId = bgVar.aQy.userId;
            }
            if (bgVar.aQM != null) {
                this.liveId = bgVar.aQM.live_id;
            }
        }
        if (bgVar2 != null && bgVar2.aQy != null) {
            this.hAT = bgVar2.aQy.userId;
        }
        if (!this.hAM) {
            this.hAM = true;
            if (this.hAJ != null) {
                this.hAJ.DG();
            }
            chb();
            chc();
            this.hAQ = false;
            this.hAR = false;
            if (this.hAI != null && this.hAH != null) {
                this.hAH.a(bcVar, bgVar, bgVar2, true);
                this.hAH.setRivalUserViewBg(bgVar2);
                this.hAH.setAnchorUserViewBg(bgVar);
                if (this.hAJ != null) {
                    this.hAJ.a(bcVar, bgVar, bgVar2);
                }
                if (this.hAI != null) {
                    this.hAI.a(this.mTbPageContext.getPageActivity(), this.hAH);
                }
                chh();
                String str = null;
                if (bgVar2 != null && bgVar2.aQM != null) {
                    str = String.valueOf(bgVar2.aQM.live_id);
                }
                if (TextUtils.isEmpty(str) || !ey(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hAH.nW(false);
                }
            }
        }
        if (this.hAN && this.hAH != null) {
            this.hAH.a(bcVar, bgVar, bgVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(x xVar) {
        if (xVar != null && xVar.aKu != null) {
            this.hAS = xVar.aKu.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bg bgVar) {
        if (this.hAJ != null) {
            this.hAJ.DI();
        }
        if (this.hAH != null) {
            this.hAH.setAnchorUserViewBg(bgVar);
        }
        if (this.hAH != null) {
            this.hAH.cgP();
            this.hAH.cgO();
            this.hAI.b(this.mTbPageContext.getPageActivity(), this.hAH);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void DC() {
        if (this.hAO) {
            if (this.hAJ != null) {
                this.hAJ.bp(true);
            }
            if (this.hAH != null) {
                this.hAH.cgN();
            }
            this.hAQ = false;
            this.hAR = false;
            chg();
            this.mHandler.removeCallbacksAndMessages(null);
            chd();
            if (this.hAZ != null) {
                this.hAZ.release();
                this.hAZ = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        chg();
        this.hAI.a((a.InterfaceC0676a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hAZ != null) {
            this.hAZ.release();
            this.hAZ = null;
        }
        if (this.hBa != null) {
            this.hBa.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hBd);
        MessageManager.getInstance().unRegisterListener(this.hBf);
        MessageManager.getInstance().unRegisterListener(this.hBg);
        MessageManager.getInstance().unRegisterListener(this.hBe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chg() {
        MessageManager.getInstance().unRegisterListener(this.hAY);
        if (this.hAX != null) {
            this.hAX.release();
        }
        this.hAI.Ix();
        if (this.hAH != null) {
            this.hAH.releaseResource();
        }
        if (this.hAK != null) {
            this.hAK.cgL();
        }
        this.hAO = false;
        this.hAM = false;
        this.hAN = false;
        this.hAT = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.hAP = true;
            this.hAH.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY(final boolean z) {
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
        bdAlertDialog.setPositiveButton(a.h.ala_challenge_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.6
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    d.this.hAL.DV();
                    return;
                }
                d.this.hAL.DT();
                TiebaInitialize.log(new StatisticItem("c13055"));
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
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
        return this.hAO;
    }

    @Override // com.baidu.live.challenge.h
    public int br(boolean z) {
        int o = com.baidu.live.utils.h.o(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hAH != null && this.hAH.getCloseBtnView() != null && this.hAH.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hAH.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + o;
            }
        }
        return o;
    }

    private boolean ey(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.hAX == null) {
            this.hAX = new com.baidu.live.follow.a.b();
        }
        this.hAX.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
            @Override // com.baidu.live.follow.a.c.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hAH != null) {
                    d.this.hAH.nW(z2);
                }
            }
        });
        this.hAX.at(str, str2);
        return true;
    }

    private void chh() {
        if (this.hAY == null) {
            this.hAY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hAT > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hAT))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hAH != null) {
                                    d.this.hAH.nW(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hAH != null) {
                                d.this.hAH.nW(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Zy().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hAY);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.hAP = true;
            this.hAH.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    @Override // com.baidu.live.challenge.h
    public void f(int i, long j) {
        if (this.hAO && i == 3 && j == this.challengeId) {
            if (com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aOg == 1) {
                chi();
            }
        }
    }

    public void chi() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_GETMVPTOASTINFO, "author_liveroom", ""));
    }
}

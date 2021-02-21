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
import com.baidu.live.data.ab;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.data.cg;
import com.baidu.live.data.f;
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
    private a hAA;
    private g hAB;
    private AlaChallengeCountDown hAC;
    private i hAD;
    private long hAL;
    private com.baidu.live.follow.a.c hAP;
    private CustomMessageListener hAQ;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hAR;
    private AlaChallengeLiveView hAz;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hAE = false;
    private boolean hAF = false;
    private boolean hAG = false;
    private boolean hAH = true;
    private boolean hAI = false;
    private boolean hAJ = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hAK = 0;
    private boolean isHost = false;
    private boolean hAM = false;
    private boolean hAN = false;
    private boolean hAO = false;
    public boolean hzG = false;
    private Set<Long> hAS = new HashSet();
    private a.InterfaceC0662a hAT = new a.InterfaceC0662a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0662a
        public void cee() {
            if (d.this.hAz != null && d.this.hAz.getParent() != null) {
                d.this.hAF = true;
                if (d.this.hAB != null) {
                    d.this.hAB.Aw();
                }
                d.this.hAz.setCloseBtnVisible(true);
                d.this.hAz.setLiveContainerVisible(true);
                if (!d.this.hAS.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hAS.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hAN && !d.this.isHost) || (!d.this.hAM && d.this.isHost)) {
                        if (d.this.hAC == null) {
                            d.this.hAC = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hAC.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hAC.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hAC.getParent() != null) {
                            ((ViewGroup) d.this.hAC.getParent()).removeView(d.this.hAC);
                        }
                        d.this.hAz.getLiveContainerView().addView(d.this.hAC, layoutParams);
                        d.this.hAC.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hAI = true;
                }
                d.this.ceo();
                d.this.cep();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "one_to_two_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0662a
        public void cef() {
            if (d.this.hAz != null && d.this.hAz.getParent() != null) {
                d.this.hAG = false;
                if (d.this.hAB != null) {
                    d.this.hAB.bn(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hAz.setLiveContainerVisible(false);
                ceg();
                ceh();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "two_to_one_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0662a
        public void ceg() {
            if (d.this.hAz != null && d.this.hAz.getParent() != null) {
                if (!d.this.hAG) {
                    d.this.cen();
                    d.this.ceq();
                }
                d.this.hAI = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0662a
        public void ceh() {
            d.this.hAJ = false;
        }
    };
    private AlaChallengeLiveView.a hAU = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cec() {
            d.this.of(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(cg cgVar) {
            if (cgVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.h.ala_challenge_punish_close_dont_tip));
            } else if (cgVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), cgVar.aIu);
            } else {
                d.this.of(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(bk bkVar) {
            if (bkVar != null && bkVar.aOI != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(bkVar.aOI.userId), bkVar.aOI.userName, bkVar.aOI.portrait, bkVar.aOI.sex, bkVar.aOI.levelId, null, null, 0L, bkVar.aOI.fansCount, bkVar.aOI.followCount, bkVar.aOI.userStatus, String.valueOf(bkVar.aOW.group_id), String.valueOf(bkVar.aOW.live_id), false, String.valueOf(bkVar.aOI.userId), bkVar.aOI.appId, bkVar.aOI.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(bk bkVar) {
            if (bkVar != null && bkVar.aOI != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(bkVar.aOI.userId));
                    fVar.setPortrait(bkVar.aOI.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Xo().a(String.valueOf(bkVar.aOI.userId), fVar);
                    if (d.this.hAz != null) {
                        d.this.hAz.od(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bk bkVar) {
            if (!d.this.isHost) {
                if (d.this.hAO) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hAz);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.h.sdk_neterror);
                } else if ((com.baidu.live.ae.a.Qj().buX.aMw || !TbadkCoreApplication.getInst().isMobileBaidu()) && bkVar != null && bkVar.aOW != null) {
                    com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(bkVar.aOW.live_id)));
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(bkVar.aOW.live_id, bkVar.aOW.room_id + "", "live_sdk");
                    com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void ced() {
            if (d.this.hzG && d.this.hAB != null) {
                d.this.hAB.bo(d.this.hzG);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void oe(boolean z) {
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
    private HttpMessageListener hAV = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage)) {
                boolean z = !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0;
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPTOASTINFO_RESULT, "author_liveroom", z ? "challenge_getmvptoastinfo_succ" : "challenge_getmvptoastinfo_fail"), httpResponsedMessage, true);
                if (z) {
                    GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                    if (d.this.hAR != null) {
                        d.this.hAR.release();
                    }
                    d.this.hAR = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hAD, getChallengeMvpToastInfoResponseMessage);
                    d.this.hAR.QE();
                }
            }
        }
    };
    private HttpMessageListener hAW = new HttpMessageListener(1021200) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetChallengeMvpPunishChooseResponseMessage)) {
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE_RESULT, "author_liveroom", !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 ? "challenge_mvppunishchoose_succ" : "challenge_mvppunishchoose_fail"), httpResponsedMessage, true);
            }
        }
    };
    CustomMessageListener hAX = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hAD != null) {
                d.this.hAD.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hAY = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hAL > 0 && d.this.hAz != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hAL))) {
                    d.this.hAz.od(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hAA = new a(tbPageContext.getPageActivity());
        this.hAA.a(this.hAT);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hAA.bT(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hAV);
        MessageManager.getInstance().registerListener(this.hAX);
        MessageManager.getInstance().registerListener(this.hAY);
        MessageManager.getInstance().registerListener(this.hAW);
    }

    @Override // com.baidu.live.challenge.h
    public void k(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void c(boolean z, boolean z2, boolean z3) {
        this.hAN = z;
        this.isHost = z2;
        this.hAM = z3;
    }

    private void cel() {
        if (this.hAz == null) {
            this.hAz = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hAz.setIsHost(this.isHost);
            this.hAz.setViewClickCallBack(this.hAU);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzG = z;
        if (this.hAz != null) {
            this.hAz.setNeedCloseRecommendFloat(this.hzG);
        }
    }

    private void cem() {
        int i = 0;
        if (this.hAz != null && this.mParentView != null) {
            if (this.hAz.getParent() != null) {
                ((ViewGroup) this.hAz.getParent()).removeView(this.hAz);
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
            if (this.hAz.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hAz, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hAz, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cen() {
        if (this.hAz != null && this.hAz.getParent() != null) {
            ((ViewGroup) this.hAz.getParent()).removeView(this.hAz);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hAD = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hAB = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void Ay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hAF);
        }
        this.hAJ = true;
        cep();
    }

    @Override // com.baidu.live.challenge.h
    public void cv(int i) {
        if (1 == i) {
            this.hAI = true;
            ceo();
        }
        if (2 == i) {
            this.hAJ = true;
            cep();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceo() {
        if (this.hAF && this.hAI) {
            this.hAA.k(this.hAz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cep() {
        if (this.hAF && this.hAJ) {
            this.hAA.j(this.hAz);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bg bgVar, bk bkVar, bk bkVar2) {
        this.hAG = true;
        this.hAH = false;
        f(bgVar, bkVar, bkVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(bg bgVar, bk bkVar, bk bkVar2) {
        this.hAG = true;
        this.hAH = true;
        f(bgVar, bkVar, bkVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(bg bgVar, final bk bkVar, bk bkVar2) {
        long j = -1;
        if (this.hAE) {
            this.hAG = true;
            this.hAH = true;
            if (bgVar.aOL == 2) {
                f(bgVar, bkVar, bkVar2);
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.g(bkVar);
                    }
                }, 5000L);
                return;
            }
            g(bkVar);
            return;
        }
        long j2 = bgVar != null ? bgVar.challengeId : -1L;
        if (bkVar != null && bkVar.aOW != null) {
            j = bkVar.aOW.live_id;
        }
        BdLog.e("CHALLENGE_TAG challenge is Over but challenge not init?? || Challenge id=" + j2 + "|| live id =" + j);
    }

    @Override // com.baidu.live.challenge.i.c
    public void e(bg bgVar, bk bkVar, bk bkVar2) {
    }

    private void f(bg bgVar, bk bkVar, bk bkVar2) {
        if (bgVar != null) {
            this.challengeId = bgVar.challengeId;
        }
        if (bkVar != null) {
            if (bkVar.aOI != null) {
                this.anchorId = bkVar.aOI.userId;
            }
            if (bkVar.aOW != null) {
                this.liveId = bkVar.aOW.live_id;
            }
        }
        if (bkVar2 != null && bkVar2.aOI != null) {
            this.hAL = bkVar2.aOI.userId;
        }
        if (!this.hAE) {
            this.hAE = true;
            if (this.hAB != null) {
                this.hAB.Av();
            }
            cel();
            cem();
            this.hAI = false;
            this.hAJ = false;
            if (this.hAA != null && this.hAz != null) {
                this.hAz.a(bgVar, bkVar, bkVar2, true);
                this.hAz.setRivalUserViewBg(bkVar2);
                this.hAz.setAnchorUserViewBg(bkVar);
                if (this.hAB != null) {
                    this.hAB.a(bgVar, bkVar, bkVar2);
                }
                if (this.hAA != null) {
                    this.hAA.a(this.mTbPageContext.getPageActivity(), this.hAz);
                }
                cer();
                String str = null;
                if (bkVar2 != null && bkVar2.aOW != null) {
                    str = String.valueOf(bkVar2.aOW.live_id);
                }
                if (TextUtils.isEmpty(str) || !ew(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hAz.od(false);
                }
            }
        }
        if (this.hAF && this.hAz != null) {
            this.hAz.a(bgVar, bkVar, bkVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(ab abVar) {
        if (abVar != null && abVar.aId != null) {
            this.hAK = abVar.aId.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bk bkVar) {
        if (this.hAB != null) {
            this.hAB.Ax();
        }
        if (this.hAz != null) {
            this.hAz.setAnchorUserViewBg(bkVar);
        }
        if (this.hAz != null) {
            this.hAz.cdZ();
            this.hAz.cdY();
            this.hAA.b(this.mTbPageContext.getPageActivity(), this.hAz);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void Ar() {
        if (this.hAG) {
            if (this.hAB != null) {
                this.hAB.bn(true);
            }
            if (this.hAz != null) {
                this.hAz.cdX();
            }
            this.hAI = false;
            this.hAJ = false;
            ceq();
            this.mHandler.removeCallbacksAndMessages(null);
            cen();
            if (this.hAR != null) {
                this.hAR.release();
                this.hAR = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        ceq();
        this.hAA.a((a.InterfaceC0662a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hAR != null) {
            this.hAR.release();
            this.hAR = null;
        }
        if (this.hAS != null) {
            this.hAS.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hAV);
        MessageManager.getInstance().unRegisterListener(this.hAX);
        MessageManager.getInstance().unRegisterListener(this.hAY);
        MessageManager.getInstance().unRegisterListener(this.hAW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceq() {
        MessageManager.getInstance().unRegisterListener(this.hAQ);
        if (this.hAP != null) {
            this.hAP.release();
        }
        this.hAA.FS();
        if (this.hAz != null) {
            this.hAz.releaseResource();
        }
        if (this.hAC != null) {
            this.hAC.cdV();
        }
        this.hAG = false;
        this.hAE = false;
        this.hAF = false;
        this.hAL = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void h(boolean z, String str) {
        if (z) {
            this.hAH = true;
            this.hAz.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void of(final boolean z) {
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
                    d.this.hAD.AK();
                    return;
                }
                d.this.hAD.AI();
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
        return this.hAG;
    }

    @Override // com.baidu.live.challenge.h
    public int bp(boolean z) {
        int p = com.baidu.live.utils.h.p(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hAz != null && this.hAz.getCloseBtnView() != null && this.hAz.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hAz.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + p;
            }
        }
        return p;
    }

    private boolean ew(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.hAP == null) {
            this.hAP = new com.baidu.live.follow.a.b();
        }
        this.hAP.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
            @Override // com.baidu.live.follow.a.c.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hAz != null) {
                    d.this.hAz.od(z2);
                }
            }
        });
        this.hAP.as(str, str2);
        return true;
    }

    private void cer() {
        if (this.hAQ == null) {
            this.hAQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hAL > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hAL))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hAz != null) {
                                    d.this.hAz.od(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hAz != null) {
                                d.this.hAz.od(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hAQ);
    }

    @Override // com.baidu.live.challenge.i.d
    public void g(boolean z, String str) {
        if (z) {
            this.hAH = true;
            this.hAz.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    @Override // com.baidu.live.challenge.h
    public void g(int i, long j) {
        if (this.hAG && i == 3 && j == this.challengeId) {
            if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aMd == 1) {
                ces();
            }
        }
    }

    public void ces() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_GETMVPTOASTINFO, "author_liveroom", ""));
    }
}

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
/* loaded from: classes10.dex */
public class d implements h {
    private com.baidu.tieba.ala.liveroom.challenge.c.a hCA;
    private AlaChallengeLiveView hCi;
    private a hCj;
    private g hCk;
    private AlaChallengeCountDown hCl;
    private i hCm;
    private long hCu;
    private com.baidu.live.follow.a.c hCy;
    private CustomMessageListener hCz;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hCn = false;
    private boolean hCo = false;
    private boolean hCp = false;
    private boolean hCq = true;
    private boolean hCr = false;
    private boolean hCs = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hCt = 0;
    private boolean isHost = false;
    private boolean hCv = false;
    private boolean hCw = false;
    private boolean hCx = false;
    public boolean hBp = false;
    private Set<Long> hCB = new HashSet();
    private a.InterfaceC0668a hCC = new a.InterfaceC0668a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0668a
        public void cek() {
            if (d.this.hCi != null && d.this.hCi.getParent() != null) {
                d.this.hCo = true;
                if (d.this.hCk != null) {
                    d.this.hCk.Az();
                }
                d.this.hCi.setCloseBtnVisible(true);
                d.this.hCi.setLiveContainerVisible(true);
                if (!d.this.hCB.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hCB.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hCw && !d.this.isHost) || (!d.this.hCv && d.this.isHost)) {
                        if (d.this.hCl == null) {
                            d.this.hCl = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hCl.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hCl.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hCl.getParent() != null) {
                            ((ViewGroup) d.this.hCl.getParent()).removeView(d.this.hCl);
                        }
                        d.this.hCi.getLiveContainerView().addView(d.this.hCl, layoutParams);
                        d.this.hCl.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hCr = true;
                }
                d.this.ceu();
                d.this.cev();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "one_to_two_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0668a
        public void cel() {
            if (d.this.hCi != null && d.this.hCi.getParent() != null) {
                d.this.hCp = false;
                if (d.this.hCk != null) {
                    d.this.hCk.bn(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hCi.setLiveContainerVisible(false);
                cem();
                cen();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "two_to_one_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0668a
        public void cem() {
            if (d.this.hCi != null && d.this.hCi.getParent() != null) {
                if (!d.this.hCp) {
                    d.this.cet();
                    d.this.cew();
                }
                d.this.hCr = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0668a
        public void cen() {
            d.this.hCs = false;
        }
    };
    private AlaChallengeLiveView.a hCD = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cei() {
            d.this.of(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(cg cgVar) {
            if (cgVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.h.ala_challenge_punish_close_dont_tip));
            } else if (cgVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), cgVar.aJU);
            } else {
                d.this.of(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(bk bkVar) {
            if (bkVar != null && bkVar.aQi != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(bkVar.aQi.userId), bkVar.aQi.userName, bkVar.aQi.portrait, bkVar.aQi.sex, bkVar.aQi.levelId, null, null, 0L, bkVar.aQi.fansCount, bkVar.aQi.followCount, bkVar.aQi.userStatus, String.valueOf(bkVar.aQw.group_id), String.valueOf(bkVar.aQw.live_id), false, String.valueOf(bkVar.aQi.userId), bkVar.aQi.appId, bkVar.aQi.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(bk bkVar) {
            if (bkVar != null && bkVar.aQi != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(bkVar.aQi.userId));
                    fVar.setPortrait(bkVar.aQi.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Xr().a(String.valueOf(bkVar.aQi.userId), fVar);
                    if (d.this.hCi != null) {
                        d.this.hCi.od(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bk bkVar) {
            if (!d.this.isHost) {
                if (d.this.hCx) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hCi);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.h.sdk_neterror);
                } else if ((com.baidu.live.ae.a.Qm().bwx.aNW || !TbadkCoreApplication.getInst().isMobileBaidu()) && bkVar != null && bkVar.aQw != null) {
                    com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(bkVar.aQw.live_id)));
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(bkVar.aQw.live_id, bkVar.aQw.room_id + "", "live_sdk");
                    com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cej() {
            if (d.this.hBp && d.this.hCk != null) {
                d.this.hCk.bo(d.this.hBp);
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
            dVar.c(d.this.challengeId, d.this.liveId, d.this.anchorId);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar));
        }
    };
    private HttpMessageListener hCE = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage)) {
                boolean z = !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0;
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPTOASTINFO_RESULT, "author_liveroom", z ? "challenge_getmvptoastinfo_succ" : "challenge_getmvptoastinfo_fail"), httpResponsedMessage, true);
                if (z) {
                    GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                    if (d.this.hCA != null) {
                        d.this.hCA.release();
                    }
                    d.this.hCA = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hCm, getChallengeMvpToastInfoResponseMessage);
                    d.this.hCA.QH();
                }
            }
        }
    };
    private HttpMessageListener hCF = new HttpMessageListener(1021200) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetChallengeMvpPunishChooseResponseMessage)) {
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE_RESULT, "author_liveroom", !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 ? "challenge_mvppunishchoose_succ" : "challenge_mvppunishchoose_fail"), httpResponsedMessage, true);
            }
        }
    };
    CustomMessageListener hCG = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hCm != null) {
                d.this.hCm.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hCH = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hCu > 0 && d.this.hCi != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hCu))) {
                    d.this.hCi.od(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hCj = new a(tbPageContext.getPageActivity());
        this.hCj.a(this.hCC);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hCj.bT(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hCE);
        MessageManager.getInstance().registerListener(this.hCG);
        MessageManager.getInstance().registerListener(this.hCH);
        MessageManager.getInstance().registerListener(this.hCF);
    }

    @Override // com.baidu.live.challenge.h
    public void k(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void c(boolean z, boolean z2, boolean z3) {
        this.hCw = z;
        this.isHost = z2;
        this.hCv = z3;
    }

    private void cer() {
        if (this.hCi == null) {
            this.hCi = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hCi.setIsHost(this.isHost);
            this.hCi.setViewClickCallBack(this.hCD);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hBp = z;
        if (this.hCi != null) {
            this.hCi.setNeedCloseRecommendFloat(this.hBp);
        }
    }

    private void ces() {
        int i = 0;
        if (this.hCi != null && this.mParentView != null) {
            if (this.hCi.getParent() != null) {
                ((ViewGroup) this.hCi.getParent()).removeView(this.hCi);
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
            if (this.hCi.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hCi, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hCi, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cet() {
        if (this.hCi != null && this.hCi.getParent() != null) {
            ((ViewGroup) this.hCi.getParent()).removeView(this.hCi);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hCm = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hCk = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void AB() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hCo);
        }
        this.hCs = true;
        cev();
    }

    @Override // com.baidu.live.challenge.h
    public void cw(int i) {
        if (1 == i) {
            this.hCr = true;
            ceu();
        }
        if (2 == i) {
            this.hCs = true;
            cev();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceu() {
        if (this.hCo && this.hCr) {
            this.hCj.k(this.hCi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cev() {
        if (this.hCo && this.hCs) {
            this.hCj.j(this.hCi);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bg bgVar, bk bkVar, bk bkVar2) {
        this.hCp = true;
        this.hCq = false;
        f(bgVar, bkVar, bkVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(bg bgVar, bk bkVar, bk bkVar2) {
        this.hCp = true;
        this.hCq = true;
        f(bgVar, bkVar, bkVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(bg bgVar, final bk bkVar, bk bkVar2) {
        long j = -1;
        if (this.hCn) {
            this.hCp = true;
            this.hCq = true;
            if (bgVar.aQl == 2) {
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
        if (bkVar != null && bkVar.aQw != null) {
            j = bkVar.aQw.live_id;
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
            if (bkVar.aQi != null) {
                this.anchorId = bkVar.aQi.userId;
            }
            if (bkVar.aQw != null) {
                this.liveId = bkVar.aQw.live_id;
            }
        }
        if (bkVar2 != null && bkVar2.aQi != null) {
            this.hCu = bkVar2.aQi.userId;
        }
        if (!this.hCn) {
            this.hCn = true;
            if (this.hCk != null) {
                this.hCk.Ay();
            }
            cer();
            ces();
            this.hCr = false;
            this.hCs = false;
            if (this.hCj != null && this.hCi != null) {
                this.hCi.a(bgVar, bkVar, bkVar2, true);
                this.hCi.setRivalUserViewBg(bkVar2);
                this.hCi.setAnchorUserViewBg(bkVar);
                if (this.hCk != null) {
                    this.hCk.a(bgVar, bkVar, bkVar2);
                }
                if (this.hCj != null) {
                    this.hCj.a(this.mTbPageContext.getPageActivity(), this.hCi);
                }
                cex();
                String str = null;
                if (bkVar2 != null && bkVar2.aQw != null) {
                    str = String.valueOf(bkVar2.aQw.live_id);
                }
                if (TextUtils.isEmpty(str) || !ew(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hCi.od(false);
                }
            }
        }
        if (this.hCo && this.hCi != null) {
            this.hCi.a(bgVar, bkVar, bkVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(ab abVar) {
        if (abVar != null && abVar.aJD != null) {
            this.hCt = abVar.aJD.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bk bkVar) {
        if (this.hCk != null) {
            this.hCk.AA();
        }
        if (this.hCi != null) {
            this.hCi.setAnchorUserViewBg(bkVar);
        }
        if (this.hCi != null) {
            this.hCi.cef();
            this.hCi.cee();
            this.hCj.b(this.mTbPageContext.getPageActivity(), this.hCi);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void Au() {
        if (this.hCp) {
            if (this.hCk != null) {
                this.hCk.bn(true);
            }
            if (this.hCi != null) {
                this.hCi.ced();
            }
            this.hCr = false;
            this.hCs = false;
            cew();
            this.mHandler.removeCallbacksAndMessages(null);
            cet();
            if (this.hCA != null) {
                this.hCA.release();
                this.hCA = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        cew();
        this.hCj.a((a.InterfaceC0668a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hCA != null) {
            this.hCA.release();
            this.hCA = null;
        }
        if (this.hCB != null) {
            this.hCB.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hCE);
        MessageManager.getInstance().unRegisterListener(this.hCG);
        MessageManager.getInstance().unRegisterListener(this.hCH);
        MessageManager.getInstance().unRegisterListener(this.hCF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cew() {
        MessageManager.getInstance().unRegisterListener(this.hCz);
        if (this.hCy != null) {
            this.hCy.release();
        }
        this.hCj.FV();
        if (this.hCi != null) {
            this.hCi.releaseResource();
        }
        if (this.hCl != null) {
            this.hCl.ceb();
        }
        this.hCp = false;
        this.hCn = false;
        this.hCo = false;
        this.hCu = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void h(boolean z, String str) {
        if (z) {
            this.hCq = true;
            this.hCi.setCloseBtnVisible(false);
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
                    d.this.hCm.AN();
                    return;
                }
                d.this.hCm.AL();
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
        return this.hCp;
    }

    @Override // com.baidu.live.challenge.h
    public int bp(boolean z) {
        int p = com.baidu.live.utils.h.p(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hCi != null && this.hCi.getCloseBtnView() != null && this.hCi.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hCi.getCloseBtnView().getLayoutParams();
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
        if (this.hCy == null) {
            this.hCy = new com.baidu.live.follow.a.b();
        }
        this.hCy.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
            @Override // com.baidu.live.follow.a.c.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hCi != null) {
                    d.this.hCi.od(z2);
                }
            }
        });
        this.hCy.as(str, str2);
        return true;
    }

    private void cex() {
        if (this.hCz == null) {
            this.hCz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hCu > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hCu))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hCi != null) {
                                    d.this.hCi.od(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hCi != null) {
                                d.this.hCi.od(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Xr().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hCz);
    }

    @Override // com.baidu.live.challenge.i.d
    public void g(boolean z, String str) {
        if (z) {
            this.hCq = true;
            this.hCi.setCloseBtnVisible(false);
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
        if (this.hCp && i == 3 && j == this.challengeId) {
            if (com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aND == 1) {
                cey();
            }
        }
    }

    public void cey() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_GETMVPTOASTINFO, "author_liveroom", ""));
    }
}

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
    private com.baidu.live.follow.a.c hAB;
    private CustomMessageListener hAC;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hAD;
    private AlaChallengeLiveView hAl;
    private a hAm;
    private g hAn;
    private AlaChallengeCountDown hAo;
    private i hAp;
    private long hAx;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hAq = false;
    private boolean hAr = false;
    private boolean hAs = false;
    private boolean hAt = true;
    private boolean hAu = false;
    private boolean hAv = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hAw = 0;
    private boolean isHost = false;
    private boolean hAy = false;
    private boolean hAz = false;
    private boolean hAA = false;
    public boolean hzs = false;
    private Set<Long> hAE = new HashSet();
    private a.InterfaceC0661a hAF = new a.InterfaceC0661a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0661a
        public void cdX() {
            if (d.this.hAl != null && d.this.hAl.getParent() != null) {
                d.this.hAr = true;
                if (d.this.hAn != null) {
                    d.this.hAn.Aw();
                }
                d.this.hAl.setCloseBtnVisible(true);
                d.this.hAl.setLiveContainerVisible(true);
                if (!d.this.hAE.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hAE.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hAz && !d.this.isHost) || (!d.this.hAy && d.this.isHost)) {
                        if (d.this.hAo == null) {
                            d.this.hAo = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hAo.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hAo.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hAo.getParent() != null) {
                            ((ViewGroup) d.this.hAo.getParent()).removeView(d.this.hAo);
                        }
                        d.this.hAl.getLiveContainerView().addView(d.this.hAo, layoutParams);
                        d.this.hAo.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hAu = true;
                }
                d.this.ceh();
                d.this.cei();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "one_to_two_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0661a
        public void cdY() {
            if (d.this.hAl != null && d.this.hAl.getParent() != null) {
                d.this.hAs = false;
                if (d.this.hAn != null) {
                    d.this.hAn.bn(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hAl.setLiveContainerVisible(false);
                cdZ();
                cea();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "two_to_one_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0661a
        public void cdZ() {
            if (d.this.hAl != null && d.this.hAl.getParent() != null) {
                if (!d.this.hAs) {
                    d.this.ceg();
                    d.this.cej();
                }
                d.this.hAu = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0661a
        public void cea() {
            d.this.hAv = false;
        }
    };
    private AlaChallengeLiveView.a hAG = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cdV() {
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
                    if (d.this.hAl != null) {
                        d.this.hAl.od(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bk bkVar) {
            if (!d.this.isHost) {
                if (d.this.hAA) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hAl);
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
        public void cdW() {
            if (d.this.hzs && d.this.hAn != null) {
                d.this.hAn.bo(d.this.hzs);
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
    private HttpMessageListener hAH = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage)) {
                boolean z = !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0;
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPTOASTINFO_RESULT, "author_liveroom", z ? "challenge_getmvptoastinfo_succ" : "challenge_getmvptoastinfo_fail"), httpResponsedMessage, true);
                if (z) {
                    GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                    if (d.this.hAD != null) {
                        d.this.hAD.release();
                    }
                    d.this.hAD = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hAp, getChallengeMvpToastInfoResponseMessage);
                    d.this.hAD.QE();
                }
            }
        }
    };
    private HttpMessageListener hAI = new HttpMessageListener(1021200) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetChallengeMvpPunishChooseResponseMessage)) {
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE_RESULT, "author_liveroom", !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 ? "challenge_mvppunishchoose_succ" : "challenge_mvppunishchoose_fail"), httpResponsedMessage, true);
            }
        }
    };
    CustomMessageListener hAJ = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hAp != null) {
                d.this.hAp.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hAK = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hAx > 0 && d.this.hAl != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hAx))) {
                    d.this.hAl.od(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hAm = new a(tbPageContext.getPageActivity());
        this.hAm.a(this.hAF);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hAm.bS(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hAH);
        MessageManager.getInstance().registerListener(this.hAJ);
        MessageManager.getInstance().registerListener(this.hAK);
        MessageManager.getInstance().registerListener(this.hAI);
    }

    @Override // com.baidu.live.challenge.h
    public void k(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void c(boolean z, boolean z2, boolean z3) {
        this.hAz = z;
        this.isHost = z2;
        this.hAy = z3;
    }

    private void cee() {
        if (this.hAl == null) {
            this.hAl = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hAl.setIsHost(this.isHost);
            this.hAl.setViewClickCallBack(this.hAG);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzs = z;
        if (this.hAl != null) {
            this.hAl.setNeedCloseRecommendFloat(this.hzs);
        }
    }

    private void cef() {
        int i = 0;
        if (this.hAl != null && this.mParentView != null) {
            if (this.hAl.getParent() != null) {
                ((ViewGroup) this.hAl.getParent()).removeView(this.hAl);
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
            if (this.hAl.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hAl, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hAl, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceg() {
        if (this.hAl != null && this.hAl.getParent() != null) {
            ((ViewGroup) this.hAl.getParent()).removeView(this.hAl);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hAp = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hAn = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void Ay() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hAr);
        }
        this.hAv = true;
        cei();
    }

    @Override // com.baidu.live.challenge.h
    public void cv(int i) {
        if (1 == i) {
            this.hAu = true;
            ceh();
        }
        if (2 == i) {
            this.hAv = true;
            cei();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceh() {
        if (this.hAr && this.hAu) {
            this.hAm.k(this.hAl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cei() {
        if (this.hAr && this.hAv) {
            this.hAm.j(this.hAl);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bg bgVar, bk bkVar, bk bkVar2) {
        this.hAs = true;
        this.hAt = false;
        f(bgVar, bkVar, bkVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(bg bgVar, bk bkVar, bk bkVar2) {
        this.hAs = true;
        this.hAt = true;
        f(bgVar, bkVar, bkVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(bg bgVar, final bk bkVar, bk bkVar2) {
        long j = -1;
        if (this.hAq) {
            this.hAs = true;
            this.hAt = true;
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
            this.hAx = bkVar2.aOI.userId;
        }
        if (!this.hAq) {
            this.hAq = true;
            if (this.hAn != null) {
                this.hAn.Av();
            }
            cee();
            cef();
            this.hAu = false;
            this.hAv = false;
            if (this.hAm != null && this.hAl != null) {
                this.hAl.a(bgVar, bkVar, bkVar2, true);
                this.hAl.setRivalUserViewBg(bkVar2);
                this.hAl.setAnchorUserViewBg(bkVar);
                if (this.hAn != null) {
                    this.hAn.a(bgVar, bkVar, bkVar2);
                }
                if (this.hAm != null) {
                    this.hAm.a(this.mTbPageContext.getPageActivity(), this.hAl);
                }
                cek();
                String str = null;
                if (bkVar2 != null && bkVar2.aOW != null) {
                    str = String.valueOf(bkVar2.aOW.live_id);
                }
                if (TextUtils.isEmpty(str) || !ew(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hAl.od(false);
                }
            }
        }
        if (this.hAr && this.hAl != null) {
            this.hAl.a(bgVar, bkVar, bkVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(ab abVar) {
        if (abVar != null && abVar.aId != null) {
            this.hAw = abVar.aId.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bk bkVar) {
        if (this.hAn != null) {
            this.hAn.Ax();
        }
        if (this.hAl != null) {
            this.hAl.setAnchorUserViewBg(bkVar);
        }
        if (this.hAl != null) {
            this.hAl.cdS();
            this.hAl.cdR();
            this.hAm.b(this.mTbPageContext.getPageActivity(), this.hAl);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void Ar() {
        if (this.hAs) {
            if (this.hAn != null) {
                this.hAn.bn(true);
            }
            if (this.hAl != null) {
                this.hAl.cdQ();
            }
            this.hAu = false;
            this.hAv = false;
            cej();
            this.mHandler.removeCallbacksAndMessages(null);
            ceg();
            if (this.hAD != null) {
                this.hAD.release();
                this.hAD = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        cej();
        this.hAm.a((a.InterfaceC0661a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hAD != null) {
            this.hAD.release();
            this.hAD = null;
        }
        if (this.hAE != null) {
            this.hAE.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hAH);
        MessageManager.getInstance().unRegisterListener(this.hAJ);
        MessageManager.getInstance().unRegisterListener(this.hAK);
        MessageManager.getInstance().unRegisterListener(this.hAI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cej() {
        MessageManager.getInstance().unRegisterListener(this.hAC);
        if (this.hAB != null) {
            this.hAB.release();
        }
        this.hAm.FS();
        if (this.hAl != null) {
            this.hAl.releaseResource();
        }
        if (this.hAo != null) {
            this.hAo.cdO();
        }
        this.hAs = false;
        this.hAq = false;
        this.hAr = false;
        this.hAx = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void h(boolean z, String str) {
        if (z) {
            this.hAt = true;
            this.hAl.setCloseBtnVisible(false);
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
                    d.this.hAp.AK();
                    return;
                }
                d.this.hAp.AI();
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
        return this.hAs;
    }

    @Override // com.baidu.live.challenge.h
    public int bp(boolean z) {
        int p = com.baidu.live.utils.h.p(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hAl != null && this.hAl.getCloseBtnView() != null && this.hAl.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hAl.getCloseBtnView().getLayoutParams();
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
        if (this.hAB == null) {
            this.hAB = new com.baidu.live.follow.a.b();
        }
        this.hAB.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
            @Override // com.baidu.live.follow.a.c.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hAl != null) {
                    d.this.hAl.od(z2);
                }
            }
        });
        this.hAB.as(str, str2);
        return true;
    }

    private void cek() {
        if (this.hAC == null) {
            this.hAC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hAx > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hAx))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hAl != null) {
                                    d.this.hAl.od(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hAl != null) {
                                d.this.hAl.od(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hAC);
    }

    @Override // com.baidu.live.challenge.i.d
    public void g(boolean z, String str) {
        if (z) {
            this.hAt = true;
            this.hAl.setCloseBtnVisible(false);
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
        if (this.hAs && i == 3 && j == this.challengeId) {
            if (com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aMd == 1) {
                cel();
            }
        }
    }

    public void cel() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_GETMVPTOASTINFO, "author_liveroom", ""));
    }
}

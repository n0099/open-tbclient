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
/* loaded from: classes10.dex */
public class d implements h {
    private AlaChallengeLiveView hwb;
    private a hwc;
    private g hwd;
    private AlaChallengeCountDown hwe;
    private i hwf;
    private long hwn;
    private com.baidu.live.follow.a.c hwr;
    private CustomMessageListener hws;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hwt;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hwg = false;
    private boolean hwh = false;
    private boolean hwi = false;
    private boolean hwj = true;
    private boolean hwk = false;
    private boolean hwl = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hwm = 0;
    private boolean isHost = false;
    private boolean hwo = false;
    private boolean hwp = false;
    private boolean hwq = false;
    public boolean hvi = false;
    private Set<Long> hwu = new HashSet();
    private a.InterfaceC0659a hwv = new a.InterfaceC0659a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0659a
        public void cdc() {
            if (d.this.hwb != null && d.this.hwb.getParent() != null) {
                d.this.hwh = true;
                if (d.this.hwd != null) {
                    d.this.hwd.zM();
                }
                d.this.hwb.setCloseBtnVisible(true);
                d.this.hwb.setLiveContainerVisible(true);
                if (!d.this.hwu.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hwu.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hwp && !d.this.isHost) || (!d.this.hwo && d.this.isHost)) {
                        if (d.this.hwe == null) {
                            d.this.hwe = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hwe.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hwe.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hwe.getParent() != null) {
                            ((ViewGroup) d.this.hwe.getParent()).removeView(d.this.hwe);
                        }
                        d.this.hwb.getLiveContainerView().addView(d.this.hwe, layoutParams);
                        d.this.hwe.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hwk = true;
                }
                d.this.cdm();
                d.this.cdn();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "one_to_two_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0659a
        public void cdd() {
            if (d.this.hwb != null && d.this.hwb.getParent() != null) {
                d.this.hwi = false;
                if (d.this.hwd != null) {
                    d.this.hwd.bl(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hwb.setLiveContainerVisible(false);
                cde();
                cdf();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("challengeId", d.this.challengeId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", "two_to_one_end").setContentExt(null, null, jSONObject));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0659a
        public void cde() {
            if (d.this.hwb != null && d.this.hwb.getParent() != null) {
                if (!d.this.hwi) {
                    d.this.cdl();
                    d.this.cdo();
                }
                d.this.hwk = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0659a
        public void cdf() {
            d.this.hwl = false;
        }
    };
    private AlaChallengeLiveView.a hww = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.5
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cda() {
            d.this.nU(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bz bzVar) {
            if (bzVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.h.ala_challenge_punish_close_dont_tip));
            } else if (bzVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bzVar.aFY);
            } else {
                d.this.nU(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(bg bgVar) {
            if (bgVar != null && bgVar.aLL != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(bgVar.aLL.userId), bgVar.aLL.userName, bgVar.aLL.portrait, bgVar.aLL.sex, bgVar.aLL.levelId, null, null, 0L, bgVar.aLL.fansCount, bgVar.aLL.followCount, bgVar.aLL.userStatus, String.valueOf(bgVar.aLZ.group_id), String.valueOf(bgVar.aLZ.live_id), false, String.valueOf(bgVar.aLL.userId), bgVar.aLL.appId, bgVar.aLL.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(bg bgVar) {
            if (bgVar != null && bgVar.aLL != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(bgVar.aLL.userId));
                    fVar.setPortrait(bgVar.aLL.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.VF().a(String.valueOf(bgVar.aLL.userId), fVar);
                    if (d.this.hwb != null) {
                        d.this.hwb.nS(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bg bgVar) {
            if (!d.this.isHost) {
                if (d.this.hwq) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hwb);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.h.sdk_neterror);
                } else if ((com.baidu.live.af.a.OJ().bru.aJM || !TbadkCoreApplication.getInst().isMobileBaidu()) && bgVar != null && bgVar.aLZ != null) {
                    com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(bgVar.aLZ.live_id)));
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(bgVar.aLZ.live_id, "", "live_sdk");
                    com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void cdb() {
            if (d.this.hvi && d.this.hwd != null) {
                d.this.hwd.bm(d.this.hvi);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void nT(boolean z) {
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
    private HttpMessageListener hwx = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage)) {
                boolean z = !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0;
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPTOASTINFO_RESULT, "author_liveroom", z ? "challenge_getmvptoastinfo_succ" : "challenge_getmvptoastinfo_fail"), httpResponsedMessage, true);
                if (z) {
                    GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                    if (d.this.hwt != null) {
                        d.this.hwt.release();
                    }
                    d.this.hwt = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hwf, getChallengeMvpToastInfoResponseMessage);
                    d.this.hwt.Pd();
                }
            }
        }
    };
    private HttpMessageListener hwy = new HttpMessageListener(1021200) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetChallengeMvpPunishChooseResponseMessage)) {
                UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_MVPPUNISHCHOOSE_RESULT, "author_liveroom", !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 ? "challenge_mvppunishchoose_succ" : "challenge_mvppunishchoose_fail"), httpResponsedMessage, true);
            }
        }
    };
    CustomMessageListener hwz = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hwf != null) {
                d.this.hwf.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hwA = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hwn > 0 && d.this.hwb != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hwn))) {
                    d.this.hwb.nS(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hwc = new a(tbPageContext.getPageActivity());
        this.hwc.a(this.hwv);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hwc.bV(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hwx);
        MessageManager.getInstance().registerListener(this.hwz);
        MessageManager.getInstance().registerListener(this.hwA);
        MessageManager.getInstance().registerListener(this.hwy);
    }

    @Override // com.baidu.live.challenge.h
    public void k(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void c(boolean z, boolean z2, boolean z3) {
        this.hwp = z;
        this.isHost = z2;
        this.hwo = z3;
    }

    private void cdj() {
        if (this.hwb == null) {
            this.hwb = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hwb.setIsHost(this.isHost);
            this.hwb.setViewClickCallBack(this.hww);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.hvi = z;
        if (this.hwb != null) {
            this.hwb.setNeedCloseRecommendFloat(this.hvi);
        }
    }

    private void cdk() {
        int i = 0;
        if (this.hwb != null && this.mParentView != null) {
            if (this.hwb.getParent() != null) {
                ((ViewGroup) this.hwb.getParent()).removeView(this.hwb);
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
            if (this.hwb.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hwb, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hwb, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdl() {
        if (this.hwb != null && this.hwb.getParent() != null) {
            ((ViewGroup) this.hwb.getParent()).removeView(this.hwb);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hwf = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hwd = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void zO() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hwh);
        }
        this.hwl = true;
        cdn();
    }

    @Override // com.baidu.live.challenge.h
    public void cs(int i) {
        if (1 == i) {
            this.hwk = true;
            cdm();
        }
        if (2 == i) {
            this.hwl = true;
            cdn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdm() {
        if (this.hwh && this.hwk) {
            this.hwc.k(this.hwb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdn() {
        if (this.hwh && this.hwl) {
            this.hwc.j(this.hwb);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(bc bcVar, bg bgVar, bg bgVar2) {
        this.hwi = true;
        this.hwj = false;
        f(bcVar, bgVar, bgVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(bc bcVar, bg bgVar, bg bgVar2) {
        this.hwi = true;
        this.hwj = true;
        f(bcVar, bgVar, bgVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(bc bcVar, final bg bgVar, bg bgVar2) {
        long j = -1;
        if (this.hwg) {
            this.hwi = true;
            this.hwj = true;
            if (bcVar.aLO == 2) {
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
        if (bgVar != null && bgVar.aLZ != null) {
            j = bgVar.aLZ.live_id;
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
            if (bgVar.aLL != null) {
                this.anchorId = bgVar.aLL.userId;
            }
            if (bgVar.aLZ != null) {
                this.liveId = bgVar.aLZ.live_id;
            }
        }
        if (bgVar2 != null && bgVar2.aLL != null) {
            this.hwn = bgVar2.aLL.userId;
        }
        if (!this.hwg) {
            this.hwg = true;
            if (this.hwd != null) {
                this.hwd.zL();
            }
            cdj();
            cdk();
            this.hwk = false;
            this.hwl = false;
            if (this.hwc != null && this.hwb != null) {
                this.hwb.a(bcVar, bgVar, bgVar2, true);
                this.hwb.setRivalUserViewBg(bgVar2);
                this.hwb.setAnchorUserViewBg(bgVar);
                if (this.hwd != null) {
                    this.hwd.a(bcVar, bgVar, bgVar2);
                }
                if (this.hwc != null) {
                    this.hwc.a(this.mTbPageContext.getPageActivity(), this.hwb);
                }
                cdp();
                String str = null;
                if (bgVar2 != null && bgVar2.aLZ != null) {
                    str = String.valueOf(bgVar2.aLZ.live_id);
                }
                if (TextUtils.isEmpty(str) || !ex(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hwb.nS(false);
                }
            }
        }
        if (this.hwh && this.hwb != null) {
            this.hwb.a(bcVar, bgVar, bgVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(x xVar) {
        if (xVar != null && xVar.aFH != null) {
            this.hwm = xVar.aFH.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bg bgVar) {
        if (this.hwd != null) {
            this.hwd.zN();
        }
        if (this.hwb != null) {
            this.hwb.setAnchorUserViewBg(bgVar);
        }
        if (this.hwb != null) {
            this.hwb.ccX();
            this.hwb.ccW();
            this.hwc.b(this.mTbPageContext.getPageActivity(), this.hwb);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void zH() {
        if (this.hwi) {
            if (this.hwd != null) {
                this.hwd.bl(true);
            }
            if (this.hwb != null) {
                this.hwb.ccV();
            }
            this.hwk = false;
            this.hwl = false;
            cdo();
            this.mHandler.removeCallbacksAndMessages(null);
            cdl();
            if (this.hwt != null) {
                this.hwt.release();
                this.hwt = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        cdo();
        this.hwc.a((a.InterfaceC0659a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hwt != null) {
            this.hwt.release();
            this.hwt = null;
        }
        if (this.hwu != null) {
            this.hwu.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hwx);
        MessageManager.getInstance().unRegisterListener(this.hwz);
        MessageManager.getInstance().unRegisterListener(this.hwA);
        MessageManager.getInstance().unRegisterListener(this.hwy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdo() {
        MessageManager.getInstance().unRegisterListener(this.hws);
        if (this.hwr != null) {
            this.hwr.release();
        }
        this.hwc.EC();
        if (this.hwb != null) {
            this.hwb.releaseResource();
        }
        if (this.hwe != null) {
            this.hwe.ccT();
        }
        this.hwi = false;
        this.hwg = false;
        this.hwh = false;
        this.hwn = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.hwj = true;
            this.hwb.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nU(final boolean z) {
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
                    d.this.hwf.Aa();
                    return;
                }
                d.this.hwf.zY();
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
        return this.hwi;
    }

    @Override // com.baidu.live.challenge.h
    public int bn(boolean z) {
        int o = com.baidu.live.utils.h.o(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hwb != null && this.hwb.getCloseBtnView() != null && this.hwb.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hwb.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + o;
            }
        }
        return o;
    }

    private boolean ex(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.hwr == null) {
            this.hwr = new com.baidu.live.follow.a.b();
        }
        this.hwr.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
            @Override // com.baidu.live.follow.a.c.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hwb != null) {
                    d.this.hwb.nS(z2);
                }
            }
        });
        this.hwr.as(str, str2);
        return true;
    }

    private void cdp() {
        if (this.hws == null) {
            this.hws = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hwn > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hwn))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hwb != null) {
                                    d.this.hwb.nS(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hwb != null) {
                                d.this.hwb.nS(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.VF().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hws);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.hwj = true;
            this.hwb.setCloseBtnVisible(false);
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
        if (this.hwi && i == 3 && j == this.challengeId) {
            if (com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aJt == 1) {
                cdq();
            }
        }
    }

    public void cdq() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_GETMVPTOASTINFO, "author_liveroom", ""));
    }
}

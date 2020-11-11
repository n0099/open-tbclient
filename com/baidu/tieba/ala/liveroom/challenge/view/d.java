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
    private long hfH;
    private com.baidu.live.follow.a.b hfL;
    private CustomMessageListener hfM;
    private com.baidu.tieba.ala.liveroom.challenge.c.a hfN;
    private AlaChallengeLiveView hfv;
    private a hfw;
    private g hfx;
    private AlaChallengeCountDown hfy;
    private i hfz;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean hfA = false;
    private boolean hfB = false;
    private boolean hfC = false;
    private boolean hfD = true;
    private boolean hfE = false;
    private boolean hfF = false;
    private long challengeId = 0;
    private long anchorId = 0;
    private long liveId = -1;
    private long hfG = 0;
    private boolean isHost = false;
    private boolean hfI = false;
    private boolean hfJ = false;
    private boolean hfK = false;
    public boolean heC = false;
    private Set<Long> hfO = new HashSet();
    private a.InterfaceC0671a hfP = new a.InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.3
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void caO() {
            if (d.this.hfv != null && d.this.hfv.getParent() != null) {
                d.this.hfB = true;
                if (d.this.hfx != null) {
                    d.this.hfx.Dr();
                }
                d.this.hfv.setCloseBtnVisible(true);
                d.this.hfv.setLiveContainerVisible(true);
                if (!d.this.hfO.contains(Long.valueOf(d.this.challengeId))) {
                    d.this.hfO.add(Long.valueOf(d.this.challengeId));
                    if ((!d.this.hfJ && !d.this.isHost) || (!d.this.hfI && d.this.isHost)) {
                        if (d.this.hfy == null) {
                            d.this.hfy = new AlaChallengeCountDown(d.this.mTbPageContext.getPageActivity());
                        }
                        RelativeLayout.LayoutParams layoutParams = d.this.hfy.getLayoutParams() != null ? (RelativeLayout.LayoutParams) d.this.hfy.getLayoutParams() : new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        if (d.this.hfy.getParent() != null) {
                            ((ViewGroup) d.this.hfy.getParent()).removeView(d.this.hfy);
                        }
                        d.this.hfv.getLiveContainerView().addView(d.this.hfy, layoutParams);
                        d.this.hfy.startCountDown();
                    }
                }
                if (d.this.isHost) {
                    d.this.hfE = true;
                }
                d.this.caY();
                d.this.caZ();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void caP() {
            if (d.this.hfv != null && d.this.hfv.getParent() != null) {
                d.this.hfC = false;
                if (d.this.hfx != null) {
                    d.this.hfx.bi(false);
                }
                if (d.this.isHost) {
                    com.baidu.live.challenge.c cVar = new com.baidu.live.challenge.c();
                    cVar.pageContext = d.this.mTbPageContext;
                    cVar.challengeId = d.this.challengeId;
                    cVar.anchorId = d.this.anchorId;
                    cVar.liveId = d.this.liveId;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913088, cVar));
                }
                d.this.hfv.setLiveContainerVisible(false);
                caQ();
                caR();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void caQ() {
            if (d.this.hfv != null && d.this.hfv.getParent() != null) {
                if (!d.this.hfC) {
                    d.this.caX();
                    d.this.cba();
                }
                d.this.hfE = false;
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.a.InterfaceC0671a
        public void caR() {
            d.this.hfF = false;
        }
    };
    private AlaChallengeLiveView.a hfQ = new AlaChallengeLiveView.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.4
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void caM() {
            d.this.nc(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void a(bv bvVar) {
            if (bvVar == null) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(a.h.ala_challenge_punish_close_dont_tip));
            } else if (bvVar.buttonStatus == 0) {
                BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), bvVar.aJm);
            } else {
                d.this.nc(true);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void d(bd bdVar) {
            if (bdVar != null && bdVar.aOv != null) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mTbPageContext.getPageActivity(), String.valueOf(bdVar.aOv.userId), bdVar.aOv.userName, bdVar.aOv.portrait, bdVar.aOv.sex, bdVar.aOv.levelId, null, null, 0L, bdVar.aOv.fansCount, bdVar.aOv.followCount, bdVar.aOv.userStatus, String.valueOf(bdVar.aOJ.group_id), String.valueOf(bdVar.aOJ.live_id), false, String.valueOf(bdVar.aOv.userId), bdVar.aOv.appId, bdVar.aOv.userName);
                if (!d.this.isHost) {
                    alaPersonCardActivityConfig.enableNavLiveroom();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void e(bd bdVar) {
            if (bdVar != null && bdVar.aOv != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(d.this.mTbPageContext.getPageActivity());
                } else if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_neterror));
                } else {
                    f fVar = new f();
                    fVar.setUserId(String.valueOf(bdVar.aOv.userId));
                    fVar.setPortrait(bdVar.aOv.portrait);
                    fVar.setPageId(d.this.mTbPageContext.getUniqueId());
                    fVar.setIsAttention(true);
                    fVar.setInLive("1");
                    fVar.setFrom("source_challenge_rival_user");
                    com.baidu.live.view.a.Wx().a(String.valueOf(bdVar.aOv.userId), fVar);
                    if (d.this.hfv != null) {
                        d.this.hfv.na(true);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void f(bd bdVar) {
            if (!d.this.isHost) {
                if (d.this.hfK) {
                    BdUtilHelper.hideSoftKeyPad(d.this.mTbPageContext.getPageActivity(), d.this.hfv);
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    d.this.mTbPageContext.showToast(a.h.sdk_neterror);
                } else if ((com.baidu.live.aa.a.PQ().bod.aML || !TbadkCoreApplication.getInst().isMobileBaidu()) && bdVar != null && bdVar.aOJ != null) {
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(d.this.mTbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(bdVar.aOJ.live_id, "", "live_sdk");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void caN() {
            if (d.this.heC && d.this.hfx != null) {
                d.this.hfx.bj(d.this.heC);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.a
        public void nb(boolean z) {
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
    private HttpMessageListener hfR = new HttpMessageListener(1021199) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetChallengeMvpToastInfoResponseMessage) && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                GetChallengeMvpToastInfoResponseMessage getChallengeMvpToastInfoResponseMessage = (GetChallengeMvpToastInfoResponseMessage) httpResponsedMessage;
                if (d.this.hfN != null) {
                    d.this.hfN.release();
                }
                d.this.hfN = new com.baidu.tieba.ala.liveroom.challenge.c.a(d.this.mTbPageContext.getPageActivity(), d.this.liveId, d.this.anchorId, d.this.challengeId, d.this.hfz, getChallengeMvpToastInfoResponseMessage);
                d.this.hfN.Qj();
            }
        }
    };
    CustomMessageListener hfS = new CustomMessageListener(2913212) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.this.hfz != null) {
                d.this.hfz.a(d.this.challengeId, d.this.liveId, d.this.anchorId, 6, "0");
            }
        }
    };
    private CustomMessageListener hfT = new CustomMessageListener(2913214) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonUserData) && TbadkCoreApplication.isLogin() && d.this.hfH > 0 && d.this.hfv != null) {
                PersonUserData personUserData = (PersonUserData) customResponsedMessage.getData();
                if (personUserData.user_info != null && personUserData.relation_info != null && !TextUtils.isEmpty(personUserData.user_info.user_id) && personUserData.user_info.user_id.equals(String.valueOf(d.this.hfH))) {
                    d.this.hfv.na(personUserData.relation_info.follow_status != 0);
                }
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hfw = new a(tbPageContext.getPageActivity());
        this.hfw.a(this.hfP);
        int i = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity())[0] / 2;
        this.hfw.bS(i, (i * 4) / 3);
        MessageManager.getInstance().registerListener(this.hfR);
        MessageManager.getInstance().registerListener(this.hfS);
        MessageManager.getInstance().registerListener(this.hfT);
    }

    @Override // com.baidu.live.challenge.h
    public void m(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.live.challenge.h
    public void b(boolean z, boolean z2, boolean z3) {
        this.hfJ = z;
        this.isHost = z2;
        this.hfI = z3;
    }

    private void caV() {
        if (this.hfv == null) {
            this.hfv = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.hfv.setIsHost(this.isHost);
            this.hfv.setViewClickCallBack(this.hfQ);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void setNeedCloseRecommendFloat(boolean z) {
        this.heC = z;
        if (this.hfv != null) {
            this.hfv.setNeedCloseRecommendFloat(this.heC);
        }
    }

    private void caW() {
        int i = 0;
        if (this.hfv != null && this.mParentView != null) {
            if (this.hfv.getParent() != null) {
                ((ViewGroup) this.hfv.getParent()).removeView(this.hfv);
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
            if (this.hfv.getLayoutParams() == null) {
                Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
                this.mParentView.addView(this.hfv, i, new ViewGroup.LayoutParams(visibilityRegion.width(), visibilityRegion.height()));
                return;
            }
            this.mParentView.addView(this.hfv, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caX() {
        if (this.hfv != null && this.hfv.getParent() != null) {
            ((ViewGroup) this.hfv.getParent()).removeView(this.hfv);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(i iVar) {
        this.hfz = iVar;
    }

    @Override // com.baidu.live.challenge.h
    public void a(g gVar) {
        this.hfx = gVar;
    }

    @Override // com.baidu.live.challenge.h
    public void Dt() {
        if (BdLog.isDebugMode()) {
            BdLog.e("onMasterPlayerFirstFrame:" + this.hfB);
        }
        this.hfF = true;
        caZ();
    }

    @Override // com.baidu.live.challenge.h
    public void dM(int i) {
        if (1 == i) {
            this.hfE = true;
            caY();
        }
        if (2 == i) {
            this.hfF = true;
            caZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caY() {
        if (this.hfB && this.hfE) {
            this.hfw.k(this.hfv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caZ() {
        if (this.hfB && this.hfF) {
            this.hfw.j(this.hfv);
        }
    }

    @Override // com.baidu.live.challenge.i.c
    public void b(az azVar, bd bdVar, bd bdVar2) {
        this.hfC = true;
        this.hfD = false;
        f(azVar, bdVar, bdVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void c(az azVar, bd bdVar, bd bdVar2) {
        this.hfC = true;
        this.hfD = true;
        f(azVar, bdVar, bdVar2);
    }

    @Override // com.baidu.live.challenge.i.c
    public void d(az azVar, final bd bdVar, bd bdVar2) {
        long j = -1;
        if (this.hfA) {
            this.hfC = true;
            this.hfD = true;
            if (azVar.aOy == 2) {
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
        if (bdVar != null && bdVar.aOJ != null) {
            j = bdVar.aOJ.live_id;
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
            if (bdVar.aOv != null) {
                this.anchorId = bdVar.aOv.userId;
            }
            if (bdVar.aOJ != null) {
                this.liveId = bdVar.aOJ.live_id;
            }
        }
        if (bdVar2 != null && bdVar2.aOv != null) {
            this.hfH = bdVar2.aOv.userId;
        }
        if (!this.hfA) {
            this.hfA = true;
            if (this.hfx != null) {
                this.hfx.Dq();
            }
            caV();
            caW();
            this.hfE = false;
            this.hfF = false;
            if (this.hfw != null && this.hfv != null) {
                this.hfv.a(azVar, bdVar, bdVar2, true);
                this.hfv.setRivalUserViewBg(bdVar2);
                this.hfv.setAnchorUserViewBg(bdVar);
                if (this.hfx != null) {
                    this.hfx.a(azVar, bdVar, bdVar2);
                }
                if (this.hfw != null) {
                    this.hfw.a(this.mTbPageContext.getPageActivity(), this.hfv);
                }
                cbb();
                String str = null;
                if (bdVar2 != null && bdVar2.aOJ != null) {
                    str = String.valueOf(bdVar2.aOJ.live_id);
                }
                if (TextUtils.isEmpty(str) || !et(TbadkCoreApplication.getCurrentAccount(), str)) {
                    this.hfv.na(false);
                }
            }
        }
        if (this.hfB && this.hfv != null) {
            this.hfv.a(azVar, bdVar, bdVar2, false);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void a(w wVar) {
        if (wVar != null && wVar.aIV != null) {
            this.hfG = wVar.aIV.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bd bdVar) {
        if (this.hfx != null) {
            this.hfx.Ds();
        }
        if (this.hfv != null) {
            this.hfv.setAnchorUserViewBg(bdVar);
        }
        if (this.hfv != null) {
            this.hfv.caJ();
            this.hfv.caI();
            this.hfw.b(this.mTbPageContext.getPageActivity(), this.hfv);
        }
    }

    @Override // com.baidu.live.challenge.h
    public void Dm() {
        if (this.hfC) {
            if (this.hfx != null) {
                this.hfx.bi(true);
            }
            if (this.hfv != null) {
                this.hfv.caH();
            }
            this.hfE = false;
            this.hfF = false;
            cba();
            this.mHandler.removeCallbacksAndMessages(null);
            caX();
            if (this.hfN != null) {
                this.hfN.release();
                this.hfN = null;
            }
        }
    }

    @Override // com.baidu.live.challenge.h
    public void onDestroy() {
        cba();
        this.hfw.a((a.InterfaceC0671a) null);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hfN != null) {
            this.hfN.release();
            this.hfN = null;
        }
        if (this.hfO != null) {
            this.hfO.clear();
        }
        MessageManager.getInstance().unRegisterListener(this.hfR);
        MessageManager.getInstance().unRegisterListener(this.hfS);
        MessageManager.getInstance().unRegisterListener(this.hfT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cba() {
        MessageManager.getInstance().unRegisterListener(this.hfM);
        if (this.hfL != null) {
            this.hfL.release();
        }
        this.hfw.HP();
        if (this.hfv != null) {
            this.hfv.releaseResource();
        }
        if (this.hfy != null) {
            this.hfy.caF();
        }
        this.hfC = false;
        this.hfA = false;
        this.hfB = false;
        this.hfH = 0L;
    }

    @Override // com.baidu.live.challenge.i.n
    public void d(boolean z, String str) {
        if (z) {
            this.hfD = true;
            this.hfv.setCloseBtnVisible(false);
            return;
        }
        String str2 = (String) this.mTbPageContext.getPageActivity().getText(a.h.ala_challenge_do_request_fail);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        BdUtilHelper.showToast(this.mTbPageContext.getPageActivity(), str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(final boolean z) {
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
                    d.this.hfz.DF();
                    return;
                }
                d.this.hfz.DD();
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
        return this.hfC;
    }

    @Override // com.baidu.live.challenge.h
    public int bk(boolean z) {
        int k = com.baidu.live.utils.h.k(this.mTbPageContext.getPageActivity(), z);
        if (z && this.hfv != null && this.hfv.getCloseBtnView() != null && this.hfv.getCloseBtnView().getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.hfv.getCloseBtnView().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + k;
            }
        }
        return k;
    }

    private boolean et(String str, String str2) {
        if (!TbadkCoreApplication.isLogin()) {
            return false;
        }
        if (this.hfL == null) {
            this.hfL = new com.baidu.live.follow.a.a();
        }
        this.hfL.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.7
            @Override // com.baidu.live.follow.a.b.a
            public void a(boolean z, String str3, boolean z2) {
                if (d.this.hfv != null) {
                    d.this.hfv.na(z2);
                }
            }
        });
        this.hfL.ar(str, str2);
        return true;
    }

    private void cbb() {
        if (this.hfM == null) {
            this.hfM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.d.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (d.this.mTbPageContext != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        if (updateAttentionMessage.getData() != null && !TextUtils.isEmpty(updateAttentionMessage.getData().toUid) && d.this.hfH > 0 && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.hfH))) {
                            boolean z = updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag() == d.this.mTbPageContext.getUniqueId();
                            if (updateAttentionMessage.getData().isSucc) {
                                if (d.this.hfv != null) {
                                    d.this.hfv.na(updateAttentionMessage.getData().isAttention);
                                }
                                if (z && updateAttentionMessage.getData().isAttention) {
                                    d.this.mTbPageContext.showToast(d.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success_toast));
                                    return;
                                }
                                return;
                            }
                            if (d.this.hfv != null) {
                                d.this.hfv.na(updateAttentionMessage.getData().isAttention ? false : true);
                            }
                            if (z && !com.baidu.live.view.a.Wx().a(updateAttentionMessage.getData(), (BdPageContext<?>) d.this.mTbPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                                d.this.mTbPageContext.showToast(updateAttentionMessage.getData().errorString);
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hfM);
    }

    @Override // com.baidu.live.challenge.i.d
    public void c(boolean z, String str) {
        if (z) {
            this.hfD = true;
            this.hfv.setCloseBtnVisible(false);
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
        if (this.hfC && i == 3 && j == this.challengeId) {
            if (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aMs == 1) {
                cbc();
            }
        }
    }

    public void cbc() {
        HttpMessage httpMessage = new HttpMessage(1021199);
        httpMessage.addParam("challenge_id", this.challengeId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

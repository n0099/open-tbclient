package com.baidu.tieba.frs.f;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel cSD;
    private final View.OnClickListener dCL;
    private FrsHeaderViewContainer dDe;
    private com.baidu.tieba.frs.i dPp;
    private com.baidu.tieba.frs.view.c dRJ;
    private int dRK;
    private int dRL;
    private String dRM;
    private Runnable dRN;
    private int dRO;
    private boolean dRP;
    private x dRQ;
    private boolean dRR;
    private com.baidu.tieba.frs.entelechy.b.a dRS;
    private boolean dRT;
    private com.baidu.tieba.e.a dRU;
    private AntiHelper.a dRV;
    private CustomMessageListener dRW;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.i iVar, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(iVar.getPageContext());
        this.dDe = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dRM = null;
        this.dRP = false;
        this.cSD = null;
        this.dRQ = null;
        this.dRR = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVZ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVZ));
            }
        };
        this.dRV = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aWb));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aWb));
            }
        };
        this.dRW = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.f.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l auq = f.this.dPp.auq();
                if (auq != null && auq.aYE() != null && auq.aYE().getName() != null && auq.aYE().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = auq.aYE().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.vQ(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVZ));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(auq.aYE().getId())) {
                            f.this.lY(name);
                            auq.d(signData2);
                            signData2.forumId = auq.aYE().getId();
                            signData2.forumName = auq.aYE().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = auq.aYE().getUser_level();
                        if (f.this.azh()) {
                            i = auq.aYE().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.vQ(signMessage.mSignErrorCode)) {
                            AntiHelper.ao(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.azf()) {
                            f.this.dPp.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.dPp.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.nR(1);
                    }
                    f.this.dPp.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dCL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l auq = f.this.dPp.auq();
                if (auq != null && auq.aYE() != null && f.this.dRJ != null && (view == f.this.dRJ.azu() || view == f.this.dRJ.azv() || view == f.this.dRJ.azw())) {
                    if (f.this.dPp != null && auq.aYE() != null) {
                        TiebaStatic.log(new ak("c12046").ab(ImageViewerConfig.FORUM_ID, auq.aYE().getId()).s("obj_locate", f.this.dPp.aut() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), auq.aYE().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dPp.aur()) {
                        if (!com.baidu.adp.lib.util.j.oI()) {
                            f.this.dPp.showToast(d.j.neterror);
                        } else if (!ax.be(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").s("obj_locate", 1).ab(ImageViewerConfig.FORUM_ID, f.this.dPp.getForumId()));
                        } else {
                            f.this.gh(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dPp.aur()) {
                        if (!com.baidu.adp.lib.util.j.oI()) {
                            f.this.dPp.showToast(d.j.neterror);
                        } else if (ax.be(f.this.mContext.getPageActivity())) {
                            if (!f.this.azg()) {
                                f.this.azj();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.dPp.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.h(f.this.dPp.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.be(f.this.mContext.getPageActivity()) && auq != null && auq.btN() != null) {
                        String btN = auq.btN();
                        if (m.dK(btN) == 3) {
                            m.a(f.this.dPp.getPageContext(), btN);
                        } else {
                            av.CZ().a((TbPageContext) f.this.getPageContext(), new String[]{btN}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (auq != null && auq.getUserData() != null && auq.getUserData().isBawu()) {
                        String btU = auq.btU();
                        if (!am.isEmpty(btU)) {
                            com.baidu.tbadk.browser.a.Q(f.this.getPageContext().getPageActivity(), btU);
                            if (auq.aYE() != null) {
                                TiebaStatic.log(new ak("c10502").ab(ImageViewerConfig.FORUM_ID, auq.aYE().getId()).ab("uid", auq.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dPp.aur() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dRJ != null) {
                        f.this.dRJ.p(view, false);
                    }
                }
            }
        };
        this.dPp = iVar;
        this.dRS = aVar;
        this.dDe = frsHeaderViewContainer;
        this.dRU = new com.baidu.tieba.e.a();
        this.dRU.a(new a.InterfaceC0108a() { // from class: com.baidu.tieba.frs.f.f.5
            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0108a
            public void ba(int i, int i2) {
            }
        });
    }

    public void n(Bundle bundle) {
        this.dPp.registerListener(this.dRW);
        asZ();
        azk();
        this.dRP = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dRJ != null) {
            this.dRJ.onDestory();
        }
        if (this.cSD != null) {
            this.cSD.buT();
        }
        if (this.dRN != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.dRN);
        }
    }

    public void onActivityStop() {
        if (this.dRJ != null) {
            this.dRJ.onStop();
        }
    }

    public void gf(boolean z) {
        if (this.dRJ != null) {
            this.dRJ.gf(z);
        }
    }

    public boolean nN(int i) {
        this.mSkinType = i;
        if (this.dRJ != null) {
            this.dRJ.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void gg(boolean z) {
        if (z) {
            if (this.dRJ != null) {
                this.dDe.removeHeaderView(this.dRJ.azs());
                this.dRR = false;
            }
        } else if (this.dRJ != null && this.dRJ.azs() != null && !this.dRR) {
            this.dDe.addHeaderView(this.dRJ.azs(), this.dDe.getHeaderViewsCount());
            this.dRR = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && lVar != null && lVar.getUserData() != null && lVar.aYE() != null) {
            k(str, lVar.getUserData().getIsMem(), lVar.aYE().isLike());
        }
    }

    public void k(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dRM, str);
        this.dRO = i2;
        this.dRM = str;
        azb();
        if (this.dRJ == null || z) {
            this.dRJ = this.dRS.a(str, this.dPp, i);
            this.dRJ.changeSkinType(this.mSkinType);
            this.dRJ.l(this.dCL);
        }
        this.dDe.addHeaderView(this.dRJ.getView());
        int s = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dRJ.x(0, s, 0, s);
        azc();
    }

    public void aza() {
        if (!this.dRR && this.dRJ != null) {
            this.dDe.addHeaderView(this.dRJ.azs());
            if (this.dRJ.azt() != null && this.dPp.Ec() != null) {
                this.dPp.Ec().addHeaderView(this.dRJ.azt(), 0);
            }
            this.dRR = true;
        }
    }

    private void azb() {
        if (("normal_page".equals(this.dRM) || "frs_page".equals(this.dRM) || "book_page".equals(this.dRM)) && this.dRJ != null) {
            this.dDe.removeHeaderView(this.dRJ.getView());
            this.dDe.removeHeaderView(this.dRJ.azs());
            if (this.dRJ.azt() != null && this.dPp.Ec() != null) {
                this.dPp.Ec().removeHeaderView(this.dRJ.azt());
            }
        }
        this.dRR = false;
    }

    private void azc() {
        if (this.dRN == null) {
            this.dRN = new Runnable() { // from class: com.baidu.tieba.frs.f.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dPp.atY() == null || !f.this.dPp.atY().aur()) && f.this.dDe.isShown() && f.this.dPp.isPrimary() && !f.this.dRP && f.this.dRO == 1 && f.this.dPp.atY() != null && f.this.dPp.atY().auB() != null && !f.this.dPp.atY().auB().awA()) {
                            if (("frs_page".equals(f.this.dRM) || "normal_page".equals(f.this.dRM) || "book_page".equals(f.this.dRM)) && f.this.dRJ != null && f.this.dRJ.azr()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.awc();
                                f.this.dPp.dAX = true;
                                f.this.dRP = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.nr().postDelayed(this.dRN, 4000L);
    }

    public void f(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(lVar.aYE(), lVar);
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float a = a(forumData);
            if (this.dRJ != null) {
                this.dRJ.a(forumData, lVar);
                this.dRJ.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.dRJ.oe(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dRJ.gm(false);
                        return;
                    }
                    this.dRJ.gm(true);
                    this.dRJ.oe(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dRK = forumData.getLevelupScore();
        this.dRL = forumData.getCurScore();
        if (this.dRK > 0) {
            return this.dRL / this.dRK;
        }
        return 0.0f;
    }

    public void nO(int i) {
        if (i > 1) {
            if (this.dRJ != null) {
                this.dRJ.gn(false);
            }
        } else if (this.dRJ != null) {
            this.dRJ.gn(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            azd();
        }
    }

    public void setIsMem(int i) {
        if (this.dRJ != null) {
            this.dRJ.setMemberType(i);
        }
    }

    public void awc() {
        if (("normal_page".equals(this.dRM) || "frs_page".equals(this.dRM) || "book_page".equals(this.dRM)) && this.dRJ != null) {
            this.dRJ.awc();
        }
    }

    public void azd() {
        if (this.dRJ != null) {
            this.dRJ.awe();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.aYE(), lVar, z);
            }
        }
    }

    public void aze() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            nQ(0);
        }
    }

    public void nP(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            nQ(i);
        }
    }

    public void nQ(int i) {
        if (this.dRJ != null) {
            this.dRJ.od(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dRJ != null) {
            this.dRJ.a(forumData, lVar);
            if (forumData != null) {
                this.dRJ.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dRJ.gm(false);
                }
            }
        }
    }

    public boolean azf() {
        if (("normal_page".equals(this.dRM) || "frs_page".equals(this.dRM) || "book_page".equals(this.dRM)) && this.dRJ != null) {
            return this.dRJ.azq();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dRK - this.dRL) {
                z = true;
                this.dRK = signData.levelup_score;
            }
            this.dRL = i + this.dRL;
            if (this.dRL > this.dRK) {
                this.dRL = this.dRK;
            }
            if (this.dRK != 0) {
                f = this.dRL / this.dRK;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void nR(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dRJ != null) {
            this.dRJ.oe(i);
        }
    }

    public void g(l lVar) {
        SignData signData;
        ForumData aYE;
        if (lVar != null && lVar.aYE() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dRJ != null && (signData = lVar.aYE().getSignData()) != null && (aYE = lVar.aYE()) != null) {
                this.dRJ.a(aYE, lVar);
                this.dRJ.oe(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dRJ.azq()) {
                    a(this.dRJ, signData);
                    aYE.setCurScore(this.dRL);
                    aYE.setLevelupScore(this.dRK);
                    this.dRJ.a(aYE, lVar);
                }
            }
        }
    }

    public boolean azg() {
        if (("normal_page".equals(this.dRM) || "frs_page".equals(this.dRM) || "book_page".equals(this.dRM)) && this.dRJ != null) {
            return this.dRJ.azg();
        }
        return false;
    }

    public boolean azh() {
        if (("normal_page".equals(this.dRM) || "frs_page".equals(this.dRM) || "book_page".equals(this.dRM)) && this.dRJ != null) {
            return this.dRJ.azh();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void gh(boolean z) {
        if (this.dPp != null) {
            l auq = this.dPp.auq();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dPp.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (auq != null && auq.aYE() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dPp.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ab(ImageViewerConfig.FORUM_ID, auq.aYE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dPp.getFrom())) {
                    TiebaStatic.log(new ak("c10590").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, auq.aYE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dPp.getFrom())) {
                    TiebaStatic.log(new ak("c10587").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, auq.aYE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dPp.getFrom())) {
                    TiebaStatic.log(new ak("c10578").s("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, auq.aYE().getId()));
                }
                this.cSD.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dPp.getFrom())) {
                    TiebaStatic.eventStat(this.dPp.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dPp.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ab(ImageViewerConfig.FORUM_ID, auq.aYE().getId()));
                }
                this.cSD.K(auq.aYE().getName(), auq.aYE().getId(), "FRS");
                this.dRT = z;
            }
        }
    }

    public void azi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dPp.auq() != null && this.dPp.auq().aYE() != null && this.dPp.auq().aYE().getName() != null) {
            str = this.dPp.auq().aYE().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cZ(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cZ(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.f.f.8
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.i */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l auq = f.this.dPp.auq();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dPp.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (auq != null && auq.aYE() != null) {
                    f.this.dRQ.u(auq.aYE().getName(), com.baidu.adp.lib.g.b.c(auq.aYE().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.f.f.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AA();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void azj() {
        l auq = this.dPp.auq();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dPp.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (auq != null && auq.aYE() != null) {
            FrsActivityStatic.forumName = auq.aYE().getName() == null ? "" : auq.aYE().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, auq.aYE()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(String str) {
        if (this.dPp.atT() != null && this.dPp.atT().ayf() != null) {
            com.baidu.tieba.tbadkCore.c.btt().aa(com.baidu.tieba.tbadkCore.c.btt().d(str, this.dPp.atT().ayf().XF(), this.dPp.atT().ayf().getIsGood(), this.dPp.atT().ayf().getCategoryId()), false);
        }
    }

    private void asZ() {
        this.cSD = new LikeModel(this.dPp.getPageContext());
        this.cSD.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.f.f.10
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                r rVar;
                l auq = f.this.dPp.auq();
                if (auq != null && auq.aYE() != null && obj != null) {
                    if (AntiHelper.vQ(f.this.cSD.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cSD.getBlockPopInfoData(), f.this.dRV) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aWb));
                            return;
                        }
                        return;
                    }
                    String name = auq.aYE().getName();
                    String id = auq.aYE().getId();
                    boolean z = false;
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    if (rVar != null && f.this.cSD.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.cSD.getErrorCode() == 22) {
                            f.this.dPp.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.dPp.showToast(f.this.cSD.getErrorString());
                        }
                    } else {
                        f.this.lY(name);
                        rVar.setLike(1);
                        auq.c(rVar);
                        auq.dm(rVar.btw());
                        f.this.a(auq, f.this.dRT);
                        f.this.dRT = true;
                        f.this.dPp.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, rVar));
                    }
                    f.this.dPp.aV(Boolean.valueOf(z));
                }
            }
        });
    }

    private void azk() {
        this.dRQ = new x();
        this.dRQ.setFrom("from_frs");
        this.dRQ.a(new x.a() { // from class: com.baidu.tieba.frs.f.f.2
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void n(String str, long j) {
                l auq = f.this.dPp.auq();
                if (auq != null && auq.aYE() != null) {
                    String name = auq.aYE().getName();
                    String id = auq.aYE().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.lY(str);
                        auq.aYE().setLike(0);
                        f.this.nP(0);
                        f.this.dPp.aU(true);
                        f.this.f(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        r rVar = new r();
                        rVar.setLike(0);
                        rVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, rVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.x.a
            public void o(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aKp().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void L(int i, int i2, int i3) {
        l auq;
        if (i > 0 && i2 > 0 && (auq = this.dPp.auq()) != null && auq.aYE() != null && auq.getSignData() != null) {
            ForumData aYE = auq.aYE();
            SignData signData = auq.getSignData();
            signData.levelup_score = aYE.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            auq.d(signData);
            signData.forumId = aYE.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (azh()) {
                i4 = aYE.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aYE.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void avQ() {
        if (this.dRJ != null) {
            this.dRJ.avQ();
        }
    }

    public static boolean h(l lVar) {
        if (lVar != null) {
            return (lVar.btY() == null || StringUtils.isNull(lVar.btY().xm(), true) || lVar.btY().xm().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return ((lVar.btD() == null || lVar.btD().bup() != 1) && lVar.btX() == null && (lVar.btE() == null || v.E(lVar.btE().xl())) && ((lVar.aYE() == null || lVar.aYE().getFrsBannerData() == null || lVar.aYE().getFrsBannerData().getType() != 2) && (lVar.btZ() == null || StringUtils.isNull(lVar.btZ().xt(), true)))) ? false : true;
        }
        return false;
    }

    public void nS(int i) {
        View findViewById;
        if (this.dRJ != null && this.dRJ.azs() != null && (findViewById = this.dRJ.azs().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dRU != null) {
            this.dRU.onTouchEvent(motionEvent);
        }
    }
}

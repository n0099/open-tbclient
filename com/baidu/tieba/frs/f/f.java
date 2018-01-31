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
    private LikeModel cSY;
    private final View.OnClickListener dDg;
    private FrsHeaderViewContainer dDz;
    private com.baidu.tieba.frs.i dPK;
    private com.baidu.tieba.frs.view.c dSe;
    private int dSf;
    private int dSg;
    private String dSh;
    private Runnable dSi;
    private int dSj;
    private boolean dSk;
    private x dSl;
    private boolean dSm;
    private com.baidu.tieba.frs.entelechy.b.a dSn;
    private boolean dSo;
    private com.baidu.tieba.e.a dSp;
    private AntiHelper.a dSq;
    private CustomMessageListener dSr;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.i iVar, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(iVar.getPageContext());
        this.dDz = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.dSh = null;
        this.dSk = false;
        this.cSY = null;
        this.dSl = null;
        this.dSm = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aWc));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aWc));
            }
        };
        this.dSq = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aWe));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aWe));
            }
        };
        this.dSr = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.f.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                l auv = f.this.dPK.auv();
                if (auv != null && auv.aYJ() != null && auv.aYJ().getName() != null && auv.aYJ().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = auv.aYJ().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.vQ(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aWc));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(auv.aYJ().getId())) {
                            f.this.mf(name);
                            auv.d(signData2);
                            signData2.forumId = auv.aYJ().getId();
                            signData2.forumName = auv.aYJ().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = auv.aYJ().getUser_level();
                        if (f.this.azm()) {
                            i = auv.aYJ().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.vQ(signMessage.mSignErrorCode)) {
                            AntiHelper.an(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.azk()) {
                            f.this.dPK.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.dPK.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.nR(1);
                    }
                    f.this.dPK.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dDg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l auv = f.this.dPK.auv();
                if (auv != null && auv.aYJ() != null && f.this.dSe != null && (view == f.this.dSe.azz() || view == f.this.dSe.azA() || view == f.this.dSe.azB())) {
                    if (f.this.dPK != null && auv.aYJ() != null) {
                        TiebaStatic.log(new ak("c12046").aa(ImageViewerConfig.FORUM_ID, auv.aYJ().getId()).s("obj_locate", f.this.dPK.auy() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), auv.aYJ().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.dPK.auw()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dPK.showToast(d.j.neterror);
                        } else if (!ax.bb(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").s("obj_locate", 1).aa(ImageViewerConfig.FORUM_ID, f.this.dPK.getForumId()));
                        } else {
                            f.this.gj(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.dPK.auw()) {
                        if (!com.baidu.adp.lib.util.j.oJ()) {
                            f.this.dPK.showToast(d.j.neterror);
                        } else if (ax.bb(f.this.mContext.getPageActivity())) {
                            if (!f.this.azl()) {
                                f.this.azo();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.dPK.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.h(f.this.dPK.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.bb(f.this.mContext.getPageActivity()) && auv != null && auv.btP() != null) {
                        String btP = auv.btP();
                        if (m.dP(btP) == 3) {
                            m.a(f.this.dPK.getPageContext(), btP);
                        } else {
                            av.Da().a((TbPageContext) f.this.getPageContext(), new String[]{btP}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (auv != null && auv.getUserData() != null && auv.getUserData().isBawu()) {
                        String btW = auv.btW();
                        if (!am.isEmpty(btW)) {
                            com.baidu.tbadk.browser.a.P(f.this.getPageContext().getPageActivity(), btW);
                            if (auv.aYJ() != null) {
                                TiebaStatic.log(new ak("c10502").aa(ImageViewerConfig.FORUM_ID, auv.aYJ().getId()).aa("uid", auv.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.dPK.auw() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.dSe != null) {
                        f.this.dSe.p(view, false);
                    }
                }
            }
        };
        this.dPK = iVar;
        this.dSn = aVar;
        this.dDz = frsHeaderViewContainer;
        this.dSp = new com.baidu.tieba.e.a();
        this.dSp.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.frs.f.f.5
            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0109a
            public void ba(int i, int i2) {
            }
        });
    }

    public void n(Bundle bundle) {
        this.dPK.registerListener(this.dSr);
        ate();
        azp();
        this.dSk = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.dSe != null) {
            this.dSe.onDestory();
        }
        if (this.cSY != null) {
            this.cSY.buV();
        }
        if (this.dSi != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.dSi);
        }
    }

    public void onActivityStop() {
        if (this.dSe != null) {
            this.dSe.onStop();
        }
    }

    public void gh(boolean z) {
        if (this.dSe != null) {
            this.dSe.gh(z);
        }
    }

    public boolean nN(int i) {
        this.mSkinType = i;
        if (this.dSe != null) {
            this.dSe.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void gi(boolean z) {
        if (z) {
            if (this.dSe != null) {
                this.dDz.removeHeaderView(this.dSe.azx());
                this.dSm = false;
            }
        } else if (this.dSe != null && this.dSe.azx() != null && !this.dSm) {
            this.dDz.addHeaderView(this.dSe.azx(), this.dDz.getHeaderViewsCount());
            this.dSm = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && lVar != null && lVar.getUserData() != null && lVar.aYJ() != null) {
            k(str, lVar.getUserData().getIsMem(), lVar.aYJ().isLike());
        }
    }

    public void k(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.dSh, str);
        this.dSj = i2;
        this.dSh = str;
        azg();
        if (this.dSe == null || z) {
            this.dSe = this.dSn.a(str, this.dPK, i);
            this.dSe.changeSkinType(this.mSkinType);
            this.dSe.l(this.dDg);
        }
        this.dDz.addHeaderView(this.dSe.getView());
        int s = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.dSe.x(0, s, 0, s);
        azh();
    }

    public void azf() {
        if (!this.dSm && this.dSe != null) {
            this.dDz.addHeaderView(this.dSe.azx());
            if (this.dSe.azy() != null && this.dPK.Ee() != null) {
                this.dPK.Ee().addHeaderView(this.dSe.azy(), 0);
            }
            this.dSm = true;
        }
    }

    private void azg() {
        if (("normal_page".equals(this.dSh) || "frs_page".equals(this.dSh) || "book_page".equals(this.dSh)) && this.dSe != null) {
            this.dDz.removeHeaderView(this.dSe.getView());
            this.dDz.removeHeaderView(this.dSe.azx());
            if (this.dSe.azy() != null && this.dPK.Ee() != null) {
                this.dPK.Ee().removeHeaderView(this.dSe.azy());
            }
        }
        this.dSm = false;
    }

    private void azh() {
        if (this.dSi == null) {
            this.dSi = new Runnable() { // from class: com.baidu.tieba.frs.f.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dPK.aud() == null || !f.this.dPK.aud().auw()) && f.this.dDz.isShown() && f.this.dPK.isPrimary() && !f.this.dSk && f.this.dSj == 1 && f.this.dPK.aud() != null && f.this.dPK.aud().auG() != null && !f.this.dPK.aud().auG().awF()) {
                            if (("frs_page".equals(f.this.dSh) || "normal_page".equals(f.this.dSh) || "book_page".equals(f.this.dSh)) && f.this.dSe != null && f.this.dSe.azw()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.awh();
                                f.this.dPK.dBs = true;
                                f.this.dSk = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.ns().postDelayed(this.dSi, 4000L);
    }

    public void f(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(lVar.aYJ(), lVar);
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float a = a(forumData);
            if (this.dSe != null) {
                this.dSe.a(forumData, lVar);
                this.dSe.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.dSe.oe(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.dSe.go(false);
                        return;
                    }
                    this.dSe.go(true);
                    this.dSe.oe(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.dSf = forumData.getLevelupScore();
        this.dSg = forumData.getCurScore();
        if (this.dSf > 0) {
            return this.dSg / this.dSf;
        }
        return 0.0f;
    }

    public void nO(int i) {
        if (i > 1) {
            if (this.dSe != null) {
                this.dSe.gp(false);
            }
        } else if (this.dSe != null) {
            this.dSe.gp(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            azi();
        }
    }

    public void setIsMem(int i) {
        if (this.dSe != null) {
            this.dSe.setMemberType(i);
        }
    }

    public void awh() {
        if (("normal_page".equals(this.dSh) || "frs_page".equals(this.dSh) || "book_page".equals(this.dSh)) && this.dSe != null) {
            this.dSe.awh();
        }
    }

    public void azi() {
        if (this.dSe != null) {
            this.dSe.awj();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, lVar.aYJ(), lVar, z);
            }
        }
    }

    public void azj() {
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
        if (this.dSe != null) {
            this.dSe.od(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.dSe != null) {
            this.dSe.a(forumData, lVar);
            if (forumData != null) {
                this.dSe.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.dSe.go(false);
                }
            }
        }
    }

    public boolean azk() {
        if (("normal_page".equals(this.dSh) || "frs_page".equals(this.dSh) || "book_page".equals(this.dSh)) && this.dSe != null) {
            return this.dSe.azv();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.dSf - this.dSg) {
                z = true;
                this.dSf = signData.levelup_score;
            }
            this.dSg = i + this.dSg;
            if (this.dSg > this.dSf) {
                this.dSg = this.dSf;
            }
            if (this.dSf != 0) {
                f = this.dSg / this.dSf;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void nR(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dSe != null) {
            this.dSe.oe(i);
        }
    }

    public void g(l lVar) {
        SignData signData;
        ForumData aYJ;
        if (lVar != null && lVar.aYJ() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.dSe != null && (signData = lVar.aYJ().getSignData()) != null && (aYJ = lVar.aYJ()) != null) {
                this.dSe.a(aYJ, lVar);
                this.dSe.oe(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.dSe.azv()) {
                    a(this.dSe, signData);
                    aYJ.setCurScore(this.dSg);
                    aYJ.setLevelupScore(this.dSf);
                    this.dSe.a(aYJ, lVar);
                }
            }
        }
    }

    public boolean azl() {
        if (("normal_page".equals(this.dSh) || "frs_page".equals(this.dSh) || "book_page".equals(this.dSh)) && this.dSe != null) {
            return this.dSe.azl();
        }
        return false;
    }

    public boolean azm() {
        if (("normal_page".equals(this.dSh) || "frs_page".equals(this.dSh) || "book_page".equals(this.dSh)) && this.dSe != null) {
            return this.dSe.azm();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void gj(boolean z) {
        if (this.dPK != null) {
            l auv = this.dPK.auv();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dPK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (auv != null && auv.aYJ() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dPK.getFrom())) {
                    TiebaStatic.log(new ak("c10356").aa(ImageViewerConfig.FORUM_ID, auv.aYJ().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dPK.getFrom())) {
                    TiebaStatic.log(new ak("c10590").s("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, auv.aYJ().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dPK.getFrom())) {
                    TiebaStatic.log(new ak("c10587").s("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, auv.aYJ().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dPK.getFrom())) {
                    TiebaStatic.log(new ak("c10578").s("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, auv.aYJ().getId()));
                }
                this.cSY.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dPK.getFrom())) {
                    TiebaStatic.eventStat(this.dPK.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dPK.getFrom())) {
                    TiebaStatic.log(new ak("c10359").aa(ImageViewerConfig.FORUM_ID, auv.aYJ().getId()));
                }
                this.cSY.M(auv.aYJ().getName(), auv.aYJ().getId(), "FRS");
                this.dSo = z;
            }
        }
    }

    public void azn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dPK.auv() != null && this.dPK.auv().aYJ() != null && this.dPK.auv().aYJ().getName() != null) {
            str = this.dPK.auv().aYJ().getName();
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
                l auv = f.this.dPK.auv();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dPK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (auv != null && auv.aYJ() != null) {
                    f.this.dSl.u(auv.aYJ().getName(), com.baidu.adp.lib.g.b.c(auv.aYJ().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.f.f.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).AB();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void azo() {
        l auv = this.dPK.auv();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dPK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (auv != null && auv.aYJ() != null) {
            FrsActivityStatic.forumName = auv.aYJ().getName() == null ? "" : auv.aYJ().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, auv.aYJ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(String str) {
        if (this.dPK.atY() != null && this.dPK.atY().ayk() != null) {
            com.baidu.tieba.tbadkCore.c.btv().aa(com.baidu.tieba.tbadkCore.c.btv().d(str, this.dPK.atY().ayk().XH(), this.dPK.atY().ayk().getIsGood(), this.dPK.atY().ayk().getCategoryId()), false);
        }
    }

    private void ate() {
        this.cSY = new LikeModel(this.dPK.getPageContext());
        this.cSY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.f.f.10
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                r rVar;
                l auv = f.this.dPK.auv();
                if (auv != null && auv.aYJ() != null && obj != null) {
                    if (AntiHelper.vQ(f.this.cSY.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cSY.getBlockPopInfoData(), f.this.dSq) != null) {
                            TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aWe));
                            return;
                        }
                        return;
                    }
                    String name = auv.aYJ().getName();
                    String id = auv.aYJ().getId();
                    boolean z = false;
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    if (rVar != null && f.this.cSY.getErrorCode() == 0) {
                        z = true;
                    }
                    if (rVar == null || !z) {
                        if (f.this.cSY.getErrorCode() == 22) {
                            f.this.dPK.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.dPK.showToast(f.this.cSY.getErrorString());
                        }
                    } else {
                        f.this.mf(name);
                        rVar.setLike(1);
                        auv.c(rVar);
                        auv.dm(rVar.bty());
                        f.this.a(auv, f.this.dSo);
                        f.this.dSo = true;
                        f.this.dPK.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, rVar));
                    }
                    f.this.dPK.aV(Boolean.valueOf(z));
                }
            }
        });
    }

    private void azp() {
        this.dSl = new x();
        this.dSl.setFrom("from_frs");
        this.dSl.a(new x.a() { // from class: com.baidu.tieba.frs.f.f.2
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void n(String str, long j) {
                l auv = f.this.dPK.auv();
                if (auv != null && auv.aYJ() != null) {
                    String name = auv.aYJ().getName();
                    String id = auv.aYJ().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.mf(str);
                        auv.aYJ().setLike(0);
                        f.this.nP(0);
                        f.this.dPK.aU(true);
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
        com.baidu.tieba.im.settingcache.d.aKu().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void L(int i, int i2, int i3) {
        l auv;
        if (i > 0 && i2 > 0 && (auv = this.dPK.auv()) != null && auv.aYJ() != null && auv.getSignData() != null) {
            ForumData aYJ = auv.aYJ();
            SignData signData = auv.getSignData();
            signData.levelup_score = aYJ.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            auv.d(signData);
            signData.forumId = aYJ.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (azm()) {
                i4 = aYJ.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aYJ.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void avV() {
        if (this.dSe != null) {
            this.dSe.avV();
        }
    }

    public static boolean h(l lVar) {
        if (lVar != null) {
            return (lVar.bua() == null || StringUtils.isNull(lVar.bua().xn(), true) || lVar.bua().xn().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(l lVar) {
        if (lVar != null) {
            return ((lVar.btF() == null || lVar.btF().bur() != 1) && lVar.btZ() == null && (lVar.btG() == null || v.E(lVar.btG().xm())) && ((lVar.aYJ() == null || lVar.aYJ().getFrsBannerData() == null || lVar.aYJ().getFrsBannerData().getType() != 2) && (lVar.bub() == null || StringUtils.isNull(lVar.bub().xu(), true)))) ? false : true;
        }
        return false;
    }

    public void nS(int i) {
        View findViewById;
        if (this.dSe != null && this.dSe.azx() != null && (findViewById = this.dSe.azx().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dSp != null) {
            this.dSp.onTouchEvent(motionEvent);
        }
    }
}

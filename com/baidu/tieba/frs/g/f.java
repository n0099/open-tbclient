package com.baidu.tieba.frs.g;

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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel bZx;
    com.baidu.tieba.frs.entelechy.b.b cHC;
    private final View.OnClickListener cIN;
    private com.baidu.tieba.frs.g cOB;
    private BdTypeListView cRU;
    private com.baidu.tieba.frs.view.c daR;
    private int daS;
    private int daT;
    private String daU;
    private Runnable daV;
    private int daW;
    private boolean daX;
    private w daY;
    private boolean daZ;
    private com.baidu.tieba.frs.entelechy.b.a dba;
    private boolean dbb;
    private com.baidu.tieba.e.a dbc;
    private AntiHelper.a dbd;
    private CustomMessageListener dbe;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(com.baidu.tieba.frs.g gVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(gVar.getPageContext());
        this.cRU = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.daU = null;
        this.daX = false;
        this.bZx = null;
        this.daY = null;
        this.daZ = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahQ));
            }
        };
        this.dbd = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.f.3
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahS));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahS));
            }
        };
        this.dbe = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_MODEL_TASK) { // from class: com.baidu.tieba.frs.g.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SignData signData;
                boolean z;
                int i;
                k alE = f.this.cOB.alE();
                if (alE != null && alE.aRo() != null && alE.aRo().getName() != null && alE.aRo().getName().equals(FrsActivityStatic.forumName)) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name = alE.aRo().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.uB(signMessage.mSignErrorCode) && signMessage.signData != null) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahQ));
                            return;
                        }
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(alE.aRo().getId())) {
                            f.this.lG(name);
                            alE.d(signData2);
                            signData2.forumId = alE.aRo().getId();
                            signData2.forumName = alE.aRo().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = alE.aRo().getUser_level();
                        if (f.this.aqX()) {
                            i = alE.aRo().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
                        if (AntiHelper.uB(signMessage.mSignErrorCode)) {
                            AntiHelper.am(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                            return;
                        } else if (!f.this.aqV()) {
                            f.this.cOB.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                            return;
                        } else {
                            f.this.cOB.showToast(f.this.getPageContext().getResources().getString(d.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                            return;
                        }
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.lb(1);
                    }
                    f.this.cOB.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.cIN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k alE = f.this.cOB.alE();
                if (alE != null && alE.aRo() != null && f.this.daR != null && (view == f.this.daR.arj() || view == f.this.daR.ark() || view == f.this.daR.arl())) {
                    if (f.this.cOB != null && alE.aRo() != null) {
                        TiebaStatic.log(new ak("c12046").ac(ImageViewerConfig.FORUM_ID, alE.aRo().getId()).r("obj_locate", f.this.cOB.alH() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), alE.aRo().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == d.g.tv_love) {
                    if (!f.this.cOB.alF() && j.hh()) {
                        if (!ax.aS(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new ak("c10517").r("obj_locate", 1).ac(ImageViewerConfig.FORUM_ID, f.this.cOB.getForumId()));
                        } else {
                            f.this.fD(true);
                        }
                    }
                } else if (id == d.g.tv_sign) {
                    if (!f.this.cOB.alF() && j.hh() && ax.aS(f.this.mContext.getPageActivity())) {
                        if (!f.this.aqW()) {
                            f.this.aqZ();
                        } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(f.this.cOB.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(f.this.cOB.getForumId(), 0), 24002)));
                        }
                    }
                } else if (id == d.g.frs_header_games) {
                    if (ax.aS(f.this.mContext.getPageActivity()) && alE != null && alE.bvf() != null) {
                        String bvf = alE.bvf();
                        if (m.dD(bvf) == 3) {
                            m.a(f.this.cOB.getPageContext(), bvf);
                        } else {
                            av.vI().a((TbPageContext) f.this.getPageContext(), new String[]{bvf}, true);
                        }
                    }
                } else if (id == d.g.frs_bawu_center) {
                    if (alE != null && alE.getUserData() != null && alE.getUserData().isBawu()) {
                        String bvm = alE.bvm();
                        if (!am.isEmpty(bvm)) {
                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bvm);
                            if (alE.aRo() != null) {
                                TiebaStatic.log(new ak("c10502").ac(ImageViewerConfig.FORUM_ID, alE.aRo().getId()).ac("uid", alE.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == d.g.level_container && !f.this.cOB.alF() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page")) && f.this.daR != null) {
                        f.this.daR.h(view, false);
                    }
                }
            }
        };
        this.cOB = gVar;
        this.dba = aVar;
        if (this.dba != null) {
            this.cHC = this.dba.ani();
        }
        this.dbc = new com.baidu.tieba.e.a();
        this.dbc.a(new a.InterfaceC0096a() { // from class: com.baidu.tieba.frs.g.f.5
            @Override // com.baidu.tieba.e.a.InterfaceC0096a
            public void ag(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0096a
            public void ah(int i, int i2) {
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0096a
            public void ai(int i, int i2) {
            }
        });
    }

    public void k(Bundle bundle) {
        this.cOB.registerListener(this.dbe);
        akn();
        ara();
        this.daX = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.daR != null) {
            this.daR.onDestory();
        }
        if (this.bZx != null) {
            this.bZx.bwi();
        }
        if (this.daV != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.daV);
        }
    }

    public void onActivityStop() {
        if (this.daR != null) {
            this.daR.onStop();
        }
    }

    public void fB(boolean z) {
        if (this.daR != null) {
            this.daR.fB(z);
        }
    }

    public boolean kX(int i) {
        this.mSkinType = i;
        if (this.daR != null) {
            this.daR.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.cRU = bdTypeListView;
    }

    public void fC(boolean z) {
        if (z) {
            if (this.daR != null) {
                this.cRU.removeHeaderView(this.daR.ari());
                this.daZ = false;
            }
        } else if (this.daR != null && this.daR.ari() != null && !this.daZ) {
            this.cRU.addHeaderView(this.daR.ari(), this.cRU.getHeaderViewsCount());
            this.daZ = true;
        }
    }

    public void a(String str, k kVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && kVar != null && kVar.getUserData() != null && kVar.aRo() != null) {
            f(str, kVar.getUserData().getIsMem(), kVar.aRo().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.daU, str);
        this.daW = i2;
        this.daU = str;
        aqR();
        if (this.daR == null || z) {
            this.daR = this.dba.a(str, this.cOB, i);
            this.daR.changeSkinType(this.mSkinType);
            this.daR.setCommonClickListener(this.cIN);
        }
        this.cRU.addHeaderView(this.daR.getView());
        if (this.cHC != null) {
            this.cHC.a(this.cRU, this.daR);
        }
        int f = l.f(TbadkCoreApplication.getInst(), d.e.tbds44);
        this.daR.p(0, f, 0, f);
        aqS();
    }

    public void aqQ() {
        if (!this.daZ && this.daR != null) {
            this.cRU.addHeaderView(this.daR.ari());
            this.daZ = true;
        }
    }

    private void aqR() {
        if (("normal_page".equals(this.daU) || "frs_page".equals(this.daU) || "book_page".equals(this.daU)) && this.daR != null) {
            this.cRU.removeHeaderView(this.daR.getView());
            this.cRU.removeHeaderView(this.daR.ari());
        }
        this.daZ = false;
    }

    private void aqS() {
        if (this.daV == null) {
            this.daV = new Runnable() { // from class: com.baidu.tieba.frs.g.f.6
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0 && f.this.cRU.isRefreshDone() && f.this.cRU.isShown() && f.this.cOB.isPrimary() && !f.this.daX && f.this.daW == 1 && f.this.cOB.aln() != null && f.this.cOB.aln().alO() != null && !f.this.cOB.aln().alO().anX()) {
                        if (("frs_page".equals(f.this.daU) || "normal_page".equals(f.this.daU) || "book_page".equals(f.this.daU)) && f.this.daR != null && f.this.daR.arh()) {
                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                            f.this.anv();
                            f.this.cOB.cHb = true;
                            f.this.daX = true;
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.daV, 4000L);
    }

    public void g(k kVar) {
        if (kVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(kVar.aRo(), kVar);
            }
        }
    }

    public void b(ForumData forumData, k kVar) {
        if (forumData != null && kVar != null) {
            float a = a(forumData);
            if (this.daR != null) {
                this.daR.a(forumData, kVar);
                this.daR.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.daR.lj(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.daR.fF(false);
                        return;
                    }
                    this.daR.fF(true);
                    this.daR.lj(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.daS = forumData.getLevelupScore();
        this.daT = forumData.getCurScore();
        if (this.daS > 0) {
            return this.daT / this.daS;
        }
        return 0.0f;
    }

    public void kY(int i) {
        if (i > 1) {
            if (this.daR != null) {
                this.daR.fG(false);
            }
        } else if (this.daR != null) {
            this.daR.fG(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void f(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aqT();
        }
    }

    public void setIsMem(int i) {
        if (this.daR != null) {
            this.daR.setMemberType(i);
        }
    }

    public void anv() {
        if (("normal_page".equals(this.daU) || "frs_page".equals(this.daU) || "book_page".equals(this.daU)) && this.daR != null) {
            this.daR.anv();
        }
    }

    public void aqT() {
        if (this.daR != null) {
            this.daR.anx();
        }
    }

    public void a(k kVar, boolean z) {
        if (kVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, kVar.aRo(), kVar, z);
            }
        }
    }

    public void aqU() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            la(0);
        }
    }

    public void kZ(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            la(i);
        }
    }

    public void la(int i) {
        if (this.daR != null) {
            this.daR.li(i);
        }
    }

    public void a(int i, ForumData forumData, k kVar, boolean z) {
        if (this.daR != null) {
            this.daR.a(forumData, kVar);
            if (forumData != null) {
                this.daR.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.daR.fF(false);
                }
            }
        }
    }

    public boolean aqV() {
        if (("normal_page".equals(this.daU) || "frs_page".equals(this.daU) || "book_page".equals(this.daU)) && this.daR != null) {
            return this.daR.arg();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.daS - this.daT) {
                z = true;
                this.daS = signData.levelup_score;
            }
            this.daT = i + this.daT;
            if (this.daT > this.daS) {
                this.daT = this.daS;
            }
            if (this.daS != 0) {
                f = this.daT / this.daS;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void lb(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.daR != null) {
            this.daR.lj(i);
        }
    }

    public void h(k kVar) {
        SignData signData;
        ForumData aRo;
        if (kVar != null && kVar.aRo() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.daR != null && (signData = kVar.aRo().getSignData()) != null && (aRo = kVar.aRo()) != null) {
                this.daR.a(aRo, kVar);
                this.daR.lj(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.daR.arg()) {
                    a(this.daR, signData);
                    aRo.setCurScore(this.daT);
                    aRo.setLevelupScore(this.daS);
                    this.daR.a(aRo, kVar);
                }
            }
        }
    }

    public boolean aqW() {
        if (("normal_page".equals(this.daU) || "frs_page".equals(this.daU) || "book_page".equals(this.daU)) && this.daR != null) {
            return this.daR.aqW();
        }
        return false;
    }

    public boolean aqX() {
        if (("normal_page".equals(this.daU) || "frs_page".equals(this.daU) || "book_page".equals(this.daU)) && this.daR != null) {
            return this.daR.aqX();
        }
        return false;
    }

    public void fD(boolean z) {
        if (this.cOB != null) {
            k alE = this.cOB.alE();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.cOB.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED)));
            } else if (alE != null && alE.aRo() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cOB.getFrom())) {
                    TiebaStatic.log(new ak("c10356").ac(ImageViewerConfig.FORUM_ID, alE.aRo().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cOB.getFrom())) {
                    TiebaStatic.log(new ak("c10590").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alE.aRo().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cOB.getFrom())) {
                    TiebaStatic.log(new ak("c10587").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alE.aRo().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cOB.getFrom())) {
                    TiebaStatic.log(new ak("c10578").r("obj_type", 2).ac(ImageViewerConfig.FORUM_ID, alE.aRo().getId()));
                }
                this.bZx.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cOB.getFrom())) {
                    TiebaStatic.eventStat(this.cOB.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cOB.getFrom())) {
                    TiebaStatic.log(new ak("c10359").ac(ImageViewerConfig.FORUM_ID, alE.aRo().getId()));
                }
                this.bZx.H(alE.aRo().getName(), alE.aRo().getId(), "FRS");
                this.dbb = z;
            }
        }
    }

    public void aqY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cOB.alE() != null && this.cOB.alE().aRo() != null && this.cOB.alE().aRo().getName() != null) {
            str = this.cOB.alE().aRo().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cS(String.format(getPageContext().getString(d.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cS(getPageContext().getString(d.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(d.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.g.f.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                k alE = f.this.cOB.alE();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.cOB.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), f.this.getPageContext().getString(d.j.login_to_use), true, 11036)));
                } else if (alE != null && alE.aRo() != null) {
                    f.this.daY.u(alE.aRo().getName(), com.baidu.adp.lib.g.b.c(alE.aRo().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(d.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.g.f.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).th();
    }

    public void aqZ() {
        k alE = this.cOB.alE();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.cOB.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(d.j.login_to_use), true, 11014)));
        } else if (alE != null && alE.aRo() != null) {
            FrsActivityStatic.forumName = alE.aRo().getName() == null ? "" : alE.aRo().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, alE.aRo()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(String str) {
        if (this.cOB.ali() != null && this.cOB.ali().apQ() != null) {
            com.baidu.tieba.tbadkCore.c.buK().Z(com.baidu.tieba.tbadkCore.c.buK().d(str, this.cOB.ali().apQ().Qt(), this.cOB.ali().apQ().getIsGood(), this.cOB.ali().apQ().getCategoryId()), false);
        }
    }

    private void akn() {
        this.bZx = new LikeModel(this.cOB.getPageContext());
        this.bZx.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.g.f.10
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                q qVar;
                k alE = f.this.cOB.alE();
                if (alE != null && alE.aRo() != null && obj != null) {
                    if (AntiHelper.uB(f.this.bZx.getErrorCode())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.bZx.getBlockPopInfoData(), f.this.dbd) != null) {
                            TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahS));
                            return;
                        }
                        return;
                    }
                    String name = alE.aRo().getName();
                    String id = alE.aRo().getId();
                    boolean z = false;
                    if (!(obj instanceof q)) {
                        qVar = null;
                    } else {
                        qVar = (q) obj;
                    }
                    if (qVar != null && f.this.bZx.getErrorCode() == 0) {
                        z = true;
                    }
                    if (qVar == null || !z) {
                        if (f.this.bZx.getErrorCode() == 22) {
                            f.this.cOB.showToast(f.this.getPageContext().getString(d.j.had_liked_forum));
                        } else {
                            f.this.cOB.showToast(f.this.bZx.getErrorString());
                        }
                    } else {
                        f.this.lG(name);
                        qVar.setLike(1);
                        alE.c(qVar);
                        alE.dx(qVar.buN());
                        f.this.a(alE, f.this.dbb);
                        f.this.dbb = true;
                        f.this.cOB.showToast(f.this.getPageContext().getResources().getString(d.j.attention_success));
                        f.this.f(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, qVar));
                    }
                    f.this.cOB.R(Boolean.valueOf(z));
                }
            }
        });
    }

    private void ara() {
        this.daY = new w();
        this.daY.setFrom("from_frs");
        this.daY.a(new w.a() { // from class: com.baidu.tieba.frs.g.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                k alE = f.this.cOB.alE();
                if (alE != null && alE.aRo() != null) {
                    String name = alE.aRo().getName();
                    String id = alE.aRo().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.lG(str);
                        alE.aRo().setLike(0);
                        f.this.kZ(0);
                        f.this.cOB.Q(true);
                        f.this.f(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                        q qVar = new q();
                        qVar.setLike(0);
                        qVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, qVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void o(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aDi().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void C(int i, int i2, int i3) {
        k alE;
        if (i > 0 && i2 > 0 && (alE = this.cOB.alE()) != null && alE.aRo() != null && alE.getSignData() != null) {
            ForumData aRo = alE.aRo();
            SignData signData = alE.getSignData();
            signData.levelup_score = aRo.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            alE.d(signData);
            signData.forumId = aRo.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (aqX()) {
                i4 = aRo.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(aRo.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int arb() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.daR != null && this.daR.ari() != null && this.daR.ari().getParent() != null) {
                return this.cRU.getHeaderViewsCount() - 2;
            }
            return this.cRU.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void anh() {
        if (this.daR != null) {
            this.daR.anh();
        }
    }

    public static boolean i(k kVar) {
        if (kVar != null) {
            return (kVar.bvq() == null || StringUtils.isNull(kVar.bvq().pK(), true) || kVar.bvq().pK().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean j(k kVar) {
        if (kVar != null) {
            return ((kVar.buV() == null || kVar.buV().bvG() != 1) && kVar.bvp() == null && (kVar.buW() == null || v.w(kVar.buW().pJ())) && ((kVar.aRo() == null || kVar.aRo().getFrsBannerData() == null || kVar.aRo().getFrsBannerData().getType() != 2) && (kVar.bvr() == null || StringUtils.isNull(kVar.bvr().pR(), true)))) ? false : true;
        }
        return false;
    }

    public void lc(int i) {
        View findViewById;
        if (this.daR != null && this.daR.ari() != null && (findViewById = this.daR.ari().findViewById(d.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.dbc != null) {
            this.dbc.onTouchEvent(motionEvent);
        }
    }
}

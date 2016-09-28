package com.baidu.tieba.frs.i;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.am;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<FrsActivity> {
    private com.baidu.tieba.tbadkCore.x Ge;
    private com.baidu.tieba.play.k aMo;
    private int bGB;
    com.baidu.tieba.frs.entelechy.b.b bPF;
    private final View.OnClickListener bRx;
    private FrsActivity bWH;
    private BdTypeListView bZB;
    private com.baidu.tieba.frs.view.c cfj;
    private int cfk;
    private int cfl;
    private String cfm;
    private Runnable cfn;
    private boolean cfo;
    private am cfp;
    private boolean cfq;
    private com.baidu.tieba.frs.entelechy.b.a cfr;
    private CustomMessageListener cfs;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public p(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bZB = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cfm = null;
        this.cfo = false;
        this.Ge = null;
        this.cfp = null;
        this.cfq = false;
        this.cfs = new q(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bRx = new r(this);
        this.bWH = frsActivity;
        this.cfr = aVar;
        if (this.cfr != null) {
            this.bPF = this.cfr.acU();
        }
        frsActivity.registerListener(this.cfs);
    }

    public void a(com.baidu.tieba.play.k kVar) {
        this.aMo = kVar;
    }

    public void f(Bundle bundle) {
        lM();
        afQ();
        this.cfo = TbadkSettings.getInst().loadBoolean(FrsActivity.bON, false);
    }

    public void onActivityDestroy() {
        if (this.cfj != null) {
            this.cfj.onDestory();
        }
        if (this.Ge != null) {
            this.Ge.biU();
        }
        if (this.cfn != null) {
            this.bWH.mHandler.removeCallbacks(this.cfn);
        }
    }

    public void onActivityStop() {
        if (this.cfj != null) {
            this.cfj.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.cfj != null) {
            this.cfj.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c afD() {
        return this.cfj;
    }

    public void c(BdTypeListView bdTypeListView) {
        this.bZB = bdTypeListView;
    }

    public void e(String str, int i, int i2) {
        if (str.equals("frs_page") || str.equals("book_page")) {
            this.mPageType = str;
        } else {
            this.mPageType = "normal_page";
        }
        f(this.mPageType, i, i2);
    }

    public void eh(boolean z) {
        if (z) {
            if (this.cfj != null) {
                this.bZB.removeHeaderView(this.cfj.afV());
                this.cfq = false;
            }
        } else if (this.cfj != null && this.cfj.afV() != null && !this.cfq) {
            this.bZB.f(this.cfj.afV(), this.bZB.getHeaderViewsCount());
            this.cfq = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.p pVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && pVar != null && pVar.getUserData() != null && pVar.aMr() != null) {
            f(str, pVar.getUserData().getIsMem(), pVar.aMr().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cfm, str);
        this.bGB = i2;
        this.cfm = str;
        afF();
        if (this.cfj == null || z) {
            this.cfj = this.cfr.a(str, this.bWH, i);
            this.cfj.changeSkinType(this.mSkinType);
            this.cfj.setCommonClickListener(this.bRx);
        }
        this.bZB.addHeaderView(this.cfj.getView());
        if (this.aMo != null) {
            this.aMo.a(this.cfj.afZ());
        }
        if (this.bPF != null) {
            this.bPF.a(this.bZB, this.cfj);
        }
        afG();
    }

    public void afE() {
        if (!this.cfq && this.cfj != null) {
            this.bZB.addHeaderView(this.cfj.afV());
            this.cfq = true;
        }
    }

    private void afF() {
        if (("normal_page".equals(this.cfm) || "frs_page".equals(this.cfm) || "book_page".equals(this.cfm)) && this.cfj != null) {
            this.bZB.removeHeaderView(this.cfj.getView());
            this.bZB.removeHeaderView(this.cfj.afV());
        }
        this.cfq = false;
    }

    private void afG() {
        if (this.cfn == null) {
            this.cfn = new s(this);
        }
        this.bWH.mHandler.postDelayed(this.cfn, 4000L);
    }

    public void f(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(pVar.aMr(), pVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.cfj != null) {
                this.cfj.a(forumData, pVar);
                this.cfj.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cfj.iJ(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cfj.el(false);
                        return;
                    }
                    this.cfj.el(true);
                    this.cfj.iJ(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cfk = forumData.getLevelupScore();
        this.cfl = forumData.getCurScore();
        if (this.cfk > 0) {
            return this.cfl / this.cfk;
        }
        return 0.0f;
    }

    public void iE(int i) {
        if (i > 1) {
            if (this.cfj != null) {
                this.cfj.em(false);
            }
        } else if (this.cfj != null) {
            this.cfj.em(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void d(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            afH();
        }
    }

    public void setIsMem(int i) {
        if (this.cfj != null) {
            this.cfj.setMemberType(i);
        }
    }

    public void ade() {
        if (("normal_page".equals(this.cfm) || "frs_page".equals(this.cfm) || "book_page".equals(this.cfm)) && this.cfj != null) {
            this.cfj.ade();
        }
    }

    public void afH() {
        if (this.cfj != null) {
            this.cfj.adg();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (pVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, pVar.aMr(), pVar, z);
            }
        }
    }

    public void afI() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iG(0);
        }
    }

    public void iF(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iG(i);
        }
    }

    public void iG(int i) {
        if (this.cfj != null) {
            this.cfj.iI(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.cfj != null) {
            this.cfj.a(forumData, pVar);
            if (forumData != null) {
                this.cfj.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cfj.el(false);
                }
            }
        }
    }

    public boolean afJ() {
        if (("normal_page".equals(this.cfm) || "frs_page".equals(this.cfm) || "book_page".equals(this.cfm)) && this.cfj != null) {
            return this.cfj.afT();
        }
        return false;
    }

    public void afK() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfj != null) {
            this.cfj.afY().setVisibility(0);
        }
    }

    public void afL() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfj != null) {
            this.cfj.afY().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cfk - this.cfl) {
                z = true;
                this.cfk = signData.levelup_score;
            }
            this.cfl = i + this.cfl;
            if (this.cfl > this.cfk) {
                this.cfl = this.cfk;
            }
            if (this.cfk != 0) {
                f = this.cfl / this.cfk;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.a(z, f);
        }
    }

    public void iH(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfj != null) {
            this.cfj.iJ(i);
        }
    }

    public void g(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && pVar.aMr() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(pVar.aMr().getSignData(), pVar.aMr(), pVar);
            }
        }
    }

    public void h(com.baidu.tieba.tbadkCore.p pVar) {
        SignData signData;
        ForumData aMr;
        if (pVar != null && pVar.aMr() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfj != null && (signData = pVar.aMr().getSignData()) != null && (aMr = pVar.aMr()) != null && pVar != null) {
                if (this.cfj.afZ() != null) {
                    this.cfj.afZ().setWithSign(true);
                }
                this.cfj.a(aMr, pVar);
                this.cfj.iJ(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cfj.afT()) {
                    a(this.cfj, signData);
                    aMr.setCurScore(this.cfl);
                    aMr.setLevelupScore(this.cfk);
                    this.cfj.afZ().setWithSign(true);
                    this.cfj.a(aMr, pVar);
                    this.cfj.c(this.cfj.afX(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.cfj != null && signData != null && forumData != null && pVar != null) {
            this.cfj.a(forumData, pVar);
            this.cfj.iJ(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.cfj.afT()) {
                a(this.cfj, signData);
                forumData.setCurScore(this.cfl);
                forumData.setLevelupScore(this.cfk);
                this.cfj.a(forumData, pVar);
                this.cfj.c(this.cfj.afX(), true);
            }
        }
    }

    public boolean afM() {
        if (("normal_page".equals(this.cfm) || "frs_page".equals(this.cfm) || "book_page".equals(this.cfm)) && this.cfj != null) {
            return this.cfj.afM();
        }
        return false;
    }

    public boolean afN() {
        if (("normal_page".equals(this.cfm) || "frs_page".equals(this.cfm) || "book_page".equals(this.cfm)) && this.cfj != null) {
            return this.cfj.afN();
        }
        return false;
    }

    public BarImageView afO() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfj != null) {
            return this.cfj.afO();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void lN() {
        if (this.bWH != null) {
            com.baidu.tieba.tbadkCore.p abe = this.bWH.abe();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bWH.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11002)));
            } else if (abe != null && abe.aMr() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ax("c10356").ab("fid", abe.aMr().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ax("c10590").s("obj_type", 2).ab("fid", abe.aMr().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ax("c10587").s("obj_type", 2).ab("fid", abe.aMr().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ax("c10578").s("obj_type", 2).ab("fid", abe.aMr().getId()));
                }
                this.Ge.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bWH.getFrom())) {
                    TiebaStatic.eventStat(this.bWH.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ax("c10359").ab("fid", abe.aMr().getId()));
                }
                this.Ge.I(abe.aMr().getName(), abe.aMr().getId(), "FRS");
            }
        }
    }

    public void abh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bWH.abe() != null && this.bWH.abe().aMr() != null && this.bWH.abe().aMr().getName() != null) {
            str = this.bWH.abe().aMr().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cD(String.format(getPageContext().getString(r.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cD(getPageContext().getString(r.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(r.j.editor_dialog_yes), new t(this));
        aVar.b(getPageContext().getString(r.j.editor_dialog_no), new u(this));
        aVar.b(getPageContext()).tm();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void afP() {
        com.baidu.tieba.tbadkCore.p abe = this.bWH.abe();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bWH.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11014)));
        } else if (abe != null && abe.aMr() != null) {
            afK();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, abe.aMr()));
        }
    }

    private void lM() {
        this.Ge = new com.baidu.tieba.tbadkCore.x(this.bWH.getPageContext());
        this.Ge.setLoadDataCallBack(new v(this));
    }

    private void afQ() {
        this.cfp = new am();
        this.cfp.setFrom("from_frs");
        this.cfp.a(new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new x(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.p abe;
        if (i > 0 && i2 > 0 && (abe = this.bWH.abe()) != null && abe.aMr() != null && abe.getSignData() != null) {
            ForumData aMr = abe.aMr();
            SignData signData = abe.getSignData();
            signData.levelup_score = aMr.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            abe.d(signData);
            signData.forumId = aMr.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            g(abe);
            int i4 = -1;
            if (afN()) {
                i4 = aMr.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aMr.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int afR() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cfj.afV() != null && this.cfj.afV().getParent() != null) {
                return this.bZB.getHeaderViewsCount() - 2;
            }
            return this.bZB.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void acR() {
        if (this.cfj != null) {
            this.cfj.acR();
        }
    }

    public static boolean i(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return (pVar.bik() == null || StringUtils.isNull(pVar.bik().getBookId(), true) || pVar.bik().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean j(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return ((pVar.bhN() == null || pVar.bhN().bis() != 1) && pVar.bij() == null && com.baidu.tbadk.core.util.y.t(pVar.biq()) && (pVar.bhO() == null || com.baidu.tbadk.core.util.y.t(pVar.bhO().pw())) && ((pVar.aMr() == null || pVar.aMr().getFrsBannerData() == null || pVar.aMr().getFrsBannerData().getType() != 2) && (pVar.bil() == null || StringUtils.isNull(pVar.bil().pO(), true)))) ? false : true;
        }
        return false;
    }
}

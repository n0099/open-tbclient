package com.baidu.tieba.frs.i;

import android.content.Context;
import android.os.Bundle;
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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.an;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<FrsActivity> {
    private com.baidu.tieba.tbadkCore.y Dq;
    private com.baidu.tieba.play.f aIG;
    com.baidu.tieba.frs.entelechy.b.b bDb;
    private final View.OnClickListener bFi;
    private FrsActivity bJR;
    private BdTypeListView bMC;
    private com.baidu.tieba.frs.view.c bSe;
    private int bSf;
    private int bSg;
    private String bSh;
    private Runnable bSi;
    private boolean bSj;
    private an bSk;
    private boolean bSl;
    private com.baidu.tieba.frs.entelechy.b.a bSm;
    private CustomMessageListener bSn;
    private int bsO;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public p(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bMC = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bSh = null;
        this.bSj = false;
        this.Dq = null;
        this.bSk = null;
        this.bSl = false;
        this.bSn = new q(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bFi = new r(this);
        this.bJR = frsActivity;
        this.bSm = aVar;
        if (this.bSm != null) {
            this.bDb = this.bSm.XA();
        }
        frsActivity.registerListener(this.bSn);
    }

    public void a(com.baidu.tieba.play.f fVar) {
        this.aIG = fVar;
    }

    public void i(Bundle bundle) {
        kV();
        aap();
        this.bSj = TbadkSettings.getInst().loadBoolean(FrsActivity.bCk, false);
    }

    public void onActivityDestroy() {
        if (this.bSe != null) {
            this.bSe.onDestory();
        }
        if (this.Dq != null) {
            this.Dq.bbp();
        }
        if (this.bSi != null) {
            this.bJR.mHandler.removeCallbacks(this.bSi);
        }
    }

    public void onActivityStop() {
        if (this.bSe != null) {
            this.bSe.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bSe != null) {
            this.bSe.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c aac() {
        return this.bSe;
    }

    public void a(BdTypeListView bdTypeListView) {
        this.bMC = bdTypeListView;
    }

    public void f(boolean z, int i, int i2) {
        if (z) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        e(this.mPageType, i, i2);
    }

    public void dK(boolean z) {
        if (z) {
            if (this.bSe != null) {
                this.bMC.removeHeaderView(this.bSe.aau());
                this.bSl = false;
            }
        } else if (this.bSe != null && this.bSe.aau() != null && !this.bSl) {
            this.bMC.f(this.bSe.aau(), this.bMC.getHeaderViewsCount());
            this.bSl = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.p pVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str)) && pVar != null && pVar.getUserData() != null && pVar.aDN() != null) {
            e(str, pVar.getUserData().getIsMem(), pVar.aDN().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        this.bsO = i2;
        aae();
        this.bSh = "normal_page";
        if (this.bSe == null) {
            this.bSe = this.bSm.a(str, this.bJR, i);
            this.bSe.changeSkinType(this.mSkinType);
            this.bSe.setCommonClickListener(this.bFi);
        }
        this.bMC.addHeaderView(this.bSe.getView());
        if (this.aIG != null) {
            this.aIG.a(this.bSe.aay());
        }
        if (this.bDb != null) {
            this.bDb.a(this.bMC, this.bSe);
        }
        aaf();
    }

    public void aad() {
        if (!this.bSl && this.bSe != null) {
            this.bMC.addHeaderView(this.bSe.aau());
            this.bSl = true;
        }
    }

    public void hV(int i) {
        if (this.bSe == null) {
            this.bSe = this.bSm.a("frs_page", this.bJR, i);
            this.bSe.changeSkinType(this.mSkinType);
            this.bSe.setCommonClickListener(this.bFi);
        }
    }

    private void aae() {
        if (("normal_page".equals(this.bSh) || "frs_page".equals(this.bSh)) && this.bSe != null) {
            this.bMC.removeHeaderView(this.bSe.getView());
            this.bMC.removeHeaderView(this.bSe.aau());
        }
        this.bSl = false;
    }

    private void aaf() {
        if (this.bSi == null) {
            this.bSi = new s(this);
        }
        this.bJR.mHandler.postDelayed(this.bSi, 4000L);
    }

    public void f(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType)) {
                b(pVar.aDN(), pVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.bSe != null) {
                this.bSe.a(forumData, pVar);
                this.bSe.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bSe.ib(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.bSe.dO(false);
                        return;
                    }
                    this.bSe.dO(true);
                    this.bSe.ib(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bSf = forumData.getLevelupScore();
        this.bSg = forumData.getCurScore();
        if (this.bSf > 0) {
            return this.bSg / this.bSf;
        }
        return 0.0f;
    }

    public void hW(int i) {
        if (i > 1) {
            if (this.bSe != null) {
                this.bSe.dP(false);
            }
        } else if (this.bSe != null) {
            this.bSe.dP(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType)) {
            aag();
        }
    }

    public void setIsMem(int i) {
        if (this.bSe != null) {
            this.bSe.setMemberType(i);
        }
    }

    public void XN() {
        if (("normal_page".equals(this.bSh) || "frs_page".equals(this.bSh)) && this.bSe != null) {
            this.bSe.XN();
        }
    }

    public void aag() {
        if (this.bSe != null) {
            this.bSe.XP();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (pVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
                a(1, pVar.aDN(), pVar, z);
            }
        }
    }

    public void aah() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            hY(0);
        }
    }

    public void hX(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            hY(i);
        }
    }

    public void hY(int i) {
        if (this.bSe != null) {
            this.bSe.ia(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.bSe != null) {
            this.bSe.a(forumData, pVar);
            if (forumData != null) {
                this.bSe.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.bSe.dO(false);
                }
            }
        }
    }

    public boolean aai() {
        if (("normal_page".equals(this.bSh) || "frs_page".equals(this.bSh)) && this.bSe != null) {
            return this.bSe.aas();
        }
        return false;
    }

    public void aaj() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bSe != null) {
            this.bSe.aax().setVisibility(0);
        }
    }

    public void aak() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bSe != null) {
            this.bSe.aax().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.bSf - this.bSg) {
                z = true;
                this.bSf = signData.levelup_score;
            }
            this.bSg = i + this.bSg;
            if (this.bSg > this.bSf) {
                this.bSg = this.bSf;
            }
            if (this.bSf != 0) {
                f = this.bSg / this.bSf;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.a(z, f);
        }
    }

    public void hZ(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bSe != null) {
            this.bSe.ib(i);
        }
    }

    public void g(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && pVar.aDN() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
                a(pVar.aDN().getSignData(), pVar.aDN(), pVar);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.bSe != null && signData != null && forumData != null && pVar != null) {
            this.bSe.a(forumData, pVar);
            this.bSe.ib(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.bSe.aas()) {
                a(this.bSe, signData);
                forumData.setCurScore(this.bSg);
                forumData.setLevelupScore(this.bSf);
                this.bSe.a(forumData, pVar);
                this.bSe.f(this.bSe.aaw(), true);
            }
        }
    }

    public boolean aal() {
        if (("normal_page".equals(this.bSh) || "frs_page".equals(this.bSh)) && this.bSe != null) {
            return this.bSe.aal();
        }
        return false;
    }

    public boolean aam() {
        if (("normal_page".equals(this.bSh) || "frs_page".equals(this.bSh)) && this.bSe != null) {
            return this.bSe.aam();
        }
        return false;
    }

    public BarImageView aan() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bSe != null) {
            return this.bSe.aan();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void kW() {
        if (this.bJR != null) {
            com.baidu.tieba.tbadkCore.p VC = this.bJR.VC();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bJR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11002)));
            } else if (VC != null && VC.aDN() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bJR.getFrom())) {
                    TiebaStatic.log(new ay("c10356").ab("fid", VC.aDN().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bJR.getFrom())) {
                    TiebaStatic.log(new ay("c10590").s("obj_type", 2).ab("fid", VC.aDN().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bJR.getFrom())) {
                    TiebaStatic.log(new ay("c10587").s("obj_type", 2).ab("fid", VC.aDN().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bJR.getFrom())) {
                    TiebaStatic.log(new ay("c10578").s("obj_type", 2).ab("fid", VC.aDN().getId()));
                }
                this.Dq.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bJR.getFrom())) {
                    TiebaStatic.eventStat(this.bJR.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bJR.getFrom())) {
                    TiebaStatic.log(new ay("c10359").ab("fid", VC.aDN().getId()));
                }
                this.Dq.H(VC.aDN().getName(), VC.aDN().getId(), "FRS");
            }
        }
    }

    public void VF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bJR.VC() != null && this.bJR.VC().aDN() != null && this.bJR.VC().aDN().getName() != null) {
            str = this.bJR.VC().aDN().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cz(String.format(getPageContext().getString(u.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cz(getPageContext().getString(u.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(u.j.editor_dialog_yes), new t(this));
        aVar.b(getPageContext().getString(u.j.editor_dialog_no), new u(this));
        aVar.b(getPageContext()).rT();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aao() {
        com.baidu.tieba.tbadkCore.p VC = this.bJR.VC();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bJR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11014)));
        } else if (VC != null && VC.aDN() != null) {
            aaj();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, VC.aDN()));
        }
    }

    private void kV() {
        this.Dq = new com.baidu.tieba.tbadkCore.y(this.bJR.getPageContext());
        this.Dq.setLoadDataCallBack(new v(this));
    }

    private void aap() {
        this.bSk = new an();
        this.bSk.setFrom("from_frs");
        this.bSk.a(new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new x(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void p(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.p VC;
        if (i > 0 && i2 > 0 && (VC = this.bJR.VC()) != null && VC.aDN() != null && VC.getSignData() != null) {
            ForumData aDN = VC.aDN();
            SignData signData = VC.getSignData();
            signData.levelup_score = aDN.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            VC.d(signData);
            signData.forumId = aDN.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            g(VC);
            int i4 = -1;
            if (aam()) {
                i4 = aDN.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aDN.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aaq() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            if (this.bSe.aau() != null && this.bSe.aau().getParent() != null) {
                return this.bMC.getHeaderViewsCount() - 2;
            }
            return this.bMC.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void Xy() {
        if (this.bSe != null) {
            this.bSe.Xy();
        }
    }

    public static boolean h(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return ((pVar.ban() == null || pVar.ban().baO() != 1) && pVar.baI() == null && com.baidu.tbadk.core.util.y.t(pVar.baN()) && (pVar.bao() == null || com.baidu.tbadk.core.util.y.t(pVar.bao().oK())) && (pVar.aDN() == null || pVar.aDN().getFrsBannerData() == null || pVar.aDN().getFrsBannerData().getType() != 2)) ? false : true;
        }
        return false;
    }
}

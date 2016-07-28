package com.baidu.tieba.frs.j;

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
    private com.baidu.tieba.tbadkCore.y DR;
    private com.baidu.tieba.play.f aJx;
    com.baidu.tieba.frs.entelechy.b.b bEi;
    private final View.OnClickListener bGw;
    private FrsActivity bLx;
    private BdTypeListView bOm;
    private com.baidu.tieba.frs.view.c bUe;
    private int bUf;
    private int bUg;
    private String bUh;
    private Runnable bUi;
    private boolean bUj;
    private an bUk;
    private boolean bUl;
    private com.baidu.tieba.frs.entelechy.b.a bUm;
    private CustomMessageListener bUn;
    private int bvd;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public p(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bOm = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bUh = null;
        this.bUj = false;
        this.DR = null;
        this.bUk = null;
        this.bUl = false;
        this.bUn = new q(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bGw = new r(this);
        this.bLx = frsActivity;
        this.bUm = aVar;
        if (this.bUm != null) {
            this.bEi = this.bUm.XT();
        }
        frsActivity.registerListener(this.bUn);
    }

    public void a(com.baidu.tieba.play.f fVar) {
        this.aJx = fVar;
    }

    public void f(Bundle bundle) {
        kR();
        aaR();
        this.bUj = TbadkSettings.getInst().loadBoolean(FrsActivity.bDp, false);
    }

    public void onActivityDestroy() {
        if (this.bUe != null) {
            this.bUe.onDestory();
        }
        if (this.DR != null) {
            this.DR.beD();
        }
        if (this.bUi != null) {
            this.bLx.mHandler.removeCallbacks(this.bUi);
        }
    }

    public void onActivityStop() {
        if (this.bUe != null) {
            this.bUe.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bUe != null) {
            this.bUe.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c aaE() {
        return this.bUe;
    }

    public void c(BdTypeListView bdTypeListView) {
        this.bOm = bdTypeListView;
    }

    public void g(boolean z, int i, int i2) {
        if (z) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        e(this.mPageType, i, i2);
    }

    public void dK(boolean z) {
        if (z) {
            if (this.bUe != null) {
                this.bOm.removeHeaderView(this.bUe.aaW());
                this.bUl = false;
            }
        } else if (this.bUe != null && this.bUe.aaW() != null && !this.bUl) {
            this.bOm.f(this.bUe.aaW(), this.bOm.getHeaderViewsCount());
            this.bUl = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.p pVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str)) && pVar != null && pVar.getUserData() != null && pVar.aGX() != null) {
            e(str, pVar.getUserData().getIsMem(), pVar.aGX().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        this.bvd = i2;
        aaG();
        this.bUh = "normal_page";
        if (this.bUe == null) {
            this.bUe = this.bUm.a(str, this.bLx, i);
            this.bUe.changeSkinType(this.mSkinType);
            this.bUe.setCommonClickListener(this.bGw);
        }
        this.bOm.addHeaderView(this.bUe.getView());
        if (this.aJx != null) {
            this.aJx.a(this.bUe.aba());
        }
        if (this.bEi != null) {
            this.bEi.a(this.bOm, this.bUe);
        }
        aaH();
    }

    public void aaF() {
        if (!this.bUl && this.bUe != null) {
            this.bOm.addHeaderView(this.bUe.aaW());
            this.bUl = true;
        }
    }

    public void hW(int i) {
        if (this.bUe == null) {
            this.bUe = this.bUm.a("frs_page", this.bLx, i);
            this.bUe.changeSkinType(this.mSkinType);
            this.bUe.setCommonClickListener(this.bGw);
        }
    }

    private void aaG() {
        if (("normal_page".equals(this.bUh) || "frs_page".equals(this.bUh)) && this.bUe != null) {
            this.bOm.removeHeaderView(this.bUe.getView());
            this.bOm.removeHeaderView(this.bUe.aaW());
        }
        this.bUl = false;
    }

    private void aaH() {
        if (this.bUi == null) {
            this.bUi = new s(this);
        }
        this.bLx.mHandler.postDelayed(this.bUi, 4000L);
    }

    public void f(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType)) {
                b(pVar.aGX(), pVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.bUe != null) {
                this.bUe.a(forumData, pVar);
                this.bUe.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bUe.ic(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.bUe.dO(false);
                        return;
                    }
                    this.bUe.dO(true);
                    this.bUe.ic(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bUf = forumData.getLevelupScore();
        this.bUg = forumData.getCurScore();
        if (this.bUf > 0) {
            return this.bUg / this.bUf;
        }
        return 0.0f;
    }

    public void hX(int i) {
        if (i > 1) {
            if (this.bUe != null) {
                this.bUe.dP(false);
            }
        } else if (this.bUe != null) {
            this.bUe.dP(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType)) {
            aaI();
        }
    }

    public void setIsMem(int i) {
        if (this.bUe != null) {
            this.bUe.setMemberType(i);
        }
    }

    public void Yg() {
        if (("normal_page".equals(this.bUh) || "frs_page".equals(this.bUh)) && this.bUe != null) {
            this.bUe.Yg();
        }
    }

    public void aaI() {
        if (this.bUe != null) {
            this.bUe.Yi();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (pVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
                a(1, pVar.aGX(), pVar, z);
            }
        }
    }

    public void aaJ() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            hZ(0);
        }
    }

    public void hY(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            hZ(i);
        }
    }

    public void hZ(int i) {
        if (this.bUe != null) {
            this.bUe.ib(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.bUe != null) {
            this.bUe.a(forumData, pVar);
            if (forumData != null) {
                this.bUe.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.bUe.dO(false);
                }
            }
        }
    }

    public boolean aaK() {
        if (("normal_page".equals(this.bUh) || "frs_page".equals(this.bUh)) && this.bUe != null) {
            return this.bUe.aaU();
        }
        return false;
    }

    public void aaL() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bUe != null) {
            this.bUe.aaZ().setVisibility(0);
        }
    }

    public void aaM() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bUe != null) {
            this.bUe.aaZ().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.bUf - this.bUg) {
                z = true;
                this.bUf = signData.levelup_score;
            }
            this.bUg = i + this.bUg;
            if (this.bUg > this.bUf) {
                this.bUg = this.bUf;
            }
            if (this.bUf != 0) {
                f = this.bUg / this.bUf;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.a(z, f);
        }
    }

    public void ia(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bUe != null) {
            this.bUe.ic(i);
        }
    }

    public void g(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && pVar.aGX() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
                a(pVar.aGX().getSignData(), pVar.aGX(), pVar);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.bUe != null && signData != null && forumData != null && pVar != null) {
            this.bUe.a(forumData, pVar);
            this.bUe.ic(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.bUe.aaU()) {
                a(this.bUe, signData);
                forumData.setCurScore(this.bUg);
                forumData.setLevelupScore(this.bUf);
                this.bUe.a(forumData, pVar);
                this.bUe.d(this.bUe.aaY(), true);
            }
        }
    }

    public boolean aaN() {
        if (("normal_page".equals(this.bUh) || "frs_page".equals(this.bUh)) && this.bUe != null) {
            return this.bUe.aaN();
        }
        return false;
    }

    public boolean aaO() {
        if (("normal_page".equals(this.bUh) || "frs_page".equals(this.bUh)) && this.bUe != null) {
            return this.bUe.aaO();
        }
        return false;
    }

    public BarImageView aaP() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.bUe != null) {
            return this.bUe.aaP();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void kS() {
        if (this.bLx != null) {
            com.baidu.tieba.tbadkCore.p VU = this.bLx.VU();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m10getInst().login(this.bLx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11002)));
            } else if (VU != null && VU.aGX() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bLx.getFrom())) {
                    TiebaStatic.log(new ay("c10356").ab("fid", VU.aGX().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bLx.getFrom())) {
                    TiebaStatic.log(new ay("c10590").s("obj_type", 2).ab("fid", VU.aGX().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bLx.getFrom())) {
                    TiebaStatic.log(new ay("c10587").s("obj_type", 2).ab("fid", VU.aGX().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bLx.getFrom())) {
                    TiebaStatic.log(new ay("c10578").s("obj_type", 2).ab("fid", VU.aGX().getId()));
                }
                this.DR.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bLx.getFrom())) {
                    TiebaStatic.eventStat(this.bLx.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bLx.getFrom())) {
                    TiebaStatic.log(new ay("c10359").ab("fid", VU.aGX().getId()));
                }
                this.DR.I(VU.aGX().getName(), VU.aGX().getId(), "FRS");
            }
        }
    }

    public void VX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bLx.VU() != null && this.bLx.VU().aGX() != null && this.bLx.VU().aGX().getName() != null) {
            str = this.bLx.VU().aGX().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cz(String.format(getPageContext().getString(u.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cz(getPageContext().getString(u.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(u.j.editor_dialog_yes), new t(this));
        aVar.b(getPageContext().getString(u.j.editor_dialog_no), new u(this));
        aVar.b(getPageContext()).rS();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aaQ() {
        com.baidu.tieba.tbadkCore.p VU = this.bLx.VU();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m10getInst().login(this.bLx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(u.j.login_to_use), true, 11014)));
        } else if (VU != null && VU.aGX() != null) {
            aaL();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, VU.aGX()));
        }
    }

    private void kR() {
        this.DR = new com.baidu.tieba.tbadkCore.y(this.bLx.getPageContext());
        this.DR.setLoadDataCallBack(new v(this));
    }

    private void aaR() {
        this.bUk = new an();
        this.bUk.setFrom("from_frs");
        this.bUk.a(new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new x(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void q(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.p VU;
        if (i > 0 && i2 > 0 && (VU = this.bLx.VU()) != null && VU.aGX() != null && VU.getSignData() != null) {
            ForumData aGX = VU.aGX();
            SignData signData = VU.getSignData();
            signData.levelup_score = aGX.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            VU.d(signData);
            signData.forumId = aGX.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            g(VU);
            int i4 = -1;
            if (aaO()) {
                i4 = aGX.getUser_level() + 1;
            }
            TbadkCoreApplication.m10getInst().addSignedForum(aGX.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aaS() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            if (this.bUe.aaW() != null && this.bUe.aaW().getParent() != null) {
                return this.bOm.getHeaderViewsCount() - 2;
            }
            return this.bOm.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void XQ() {
        if (this.bUe != null) {
            this.bUe.XQ();
        }
    }

    public static boolean h(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return ((pVar.bdB() == null || pVar.bdB().bec() != 1) && pVar.bdW() == null && com.baidu.tbadk.core.util.y.t(pVar.beb()) && (pVar.bdC() == null || com.baidu.tbadk.core.util.y.t(pVar.bdC().oz())) && (pVar.aGX() == null || pVar.aGX().getFrsBannerData() == null || pVar.aGX().getFrsBannerData().getType() != 2)) ? false : true;
        }
        return false;
    }
}

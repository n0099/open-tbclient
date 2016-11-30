package com.baidu.tieba.frs.j;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.al;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<FrsActivity> {
    private com.baidu.tieba.tbadkCore.x Gg;
    private com.baidu.tieba.play.aa aMM;
    private int bJv;
    com.baidu.tieba.frs.entelechy.b.b bSu;
    private final View.OnClickListener bTO;
    private FrsActivity bZY;
    private BdTypeListView ccY;
    private AcrossForumViewData cgb;
    private com.baidu.tieba.frs.view.c cjU;
    private int cjV;
    private int cjW;
    private String cjX;
    private Runnable cjY;
    private boolean cjZ;
    private al cka;
    private boolean ckb;
    private com.baidu.tieba.frs.entelechy.b.a ckc;
    private boolean ckd;
    private com.baidu.tieba.frs.acrossForum.q cke;
    private CustomMessageListener ckf;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public n(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.ccY = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cjX = null;
        this.cjZ = false;
        this.Gg = null;
        this.cka = null;
        this.ckb = false;
        this.ckf = new o(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bTO = new p(this);
        this.bZY = frsActivity;
        this.ckc = aVar;
        if (this.ckc != null) {
            this.bSu = this.ckc.aeh();
        }
        frsActivity.registerListener(this.ckf);
    }

    public void a(com.baidu.tieba.play.aa aaVar) {
        this.aMM = aaVar;
    }

    public void f(Bundle bundle) {
        lP();
        ahD();
        this.cjZ = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cjU != null) {
            this.cjU.onDestory();
        }
        if (this.Gg != null) {
            this.Gg.blu();
        }
        if (this.cjY != null) {
            this.bZY.mHandler.removeCallbacks(this.cjY);
        }
    }

    public void onActivityStop() {
        if (this.cjU != null) {
            this.cjU.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.cjU != null) {
            this.cjU.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c ahq() {
        return this.cjU;
    }

    public void c(BdTypeListView bdTypeListView) {
        this.ccY = bdTypeListView;
    }

    public void ev(boolean z) {
        if (z) {
            if (this.cjU != null) {
                this.ccY.removeHeaderView(this.cjU.ahQ());
                this.ckb = false;
            }
        } else if (this.cjU != null && this.cjU.ahQ() != null && !this.ckb) {
            this.ccY.f(this.cjU.ahQ(), this.ccY.getHeaderViewsCount());
            this.ckb = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.p pVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && pVar != null && pVar.getUserData() != null && pVar.aOk() != null) {
            e(str, pVar.getUserData().getIsMem(), pVar.aOk().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cjX, str);
        this.bJv = i2;
        this.cjX = str;
        ahs();
        if (this.cjU == null || z) {
            if (this.cgb == null) {
                this.cjU = this.ckc.a(str, this.bZY, i);
            } else {
                this.cke = new com.baidu.tieba.frs.acrossForum.q(this.bZY, null, this.bZY.getForumId(), i, this.cgb);
                this.cke.b(this.bZY.abN());
                this.cke.b(this.bZY.abO());
                this.cjU = this.cke;
            }
            this.cjU.changeSkinType(this.mSkinType);
            this.cjU.setCommonClickListener(this.bTO);
        }
        if (!this.bZY.ach()) {
            this.ccY.addHeaderView(this.cjU.getView());
        }
        if (this.aMM != null) {
            this.aMM.a(this.cjU.ahV());
        }
        if (this.bSu != null) {
            this.bSu.a(this.ccY, this.cjU);
        }
        aht();
    }

    public void ahr() {
        if (!this.ckb && this.cjU != null) {
            if (!this.bZY.ach()) {
                this.ccY.addHeaderView(this.cjU.ahQ());
            }
            this.ckb = true;
        }
    }

    private void ahs() {
        if (("normal_page".equals(this.cjX) || "frs_page".equals(this.cjX) || "book_page".equals(this.cjX)) && this.cjU != null) {
            this.ccY.removeHeaderView(this.cjU.getView());
            this.ccY.removeHeaderView(this.cjU.ahQ());
        }
        this.ckb = false;
    }

    private void aht() {
        if (this.cjY == null) {
            this.cjY = new q(this);
        }
        this.bZY.mHandler.postDelayed(this.cjY, 4000L);
    }

    public void i(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(pVar.aOk(), pVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.cjU != null) {
                this.cjU.a(forumData, pVar);
                this.cjU.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cjU.iQ(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cjU.eA(false);
                        return;
                    }
                    this.cjU.eA(true);
                    this.cjU.iQ(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cjV = forumData.getLevelupScore();
        this.cjW = forumData.getCurScore();
        if (this.cjV > 0) {
            return this.cjW / this.cjV;
        }
        return 0.0f;
    }

    public void iK(int i) {
        if (i > 1) {
            if (this.cjU != null) {
                this.cjU.eB(false);
            }
        } else if (this.cjU != null) {
            this.cjU.eB(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void d(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            ahu();
        }
    }

    public void setIsMem(int i) {
        if (this.cjU != null) {
            this.cjU.setMemberType(i);
        }
    }

    public void aer() {
        if (("normal_page".equals(this.cjX) || "frs_page".equals(this.cjX) || "book_page".equals(this.cjX)) && this.cjU != null) {
            this.cjU.aer();
        }
    }

    public void ahu() {
        if (this.cjU != null) {
            this.cjU.aet();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (pVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, pVar.aOk(), pVar, z);
            }
        }
    }

    public void ahv() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iM(0);
        }
    }

    public void iL(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iM(i);
        }
    }

    public void iM(int i) {
        if (this.cjU != null) {
            this.cjU.iP(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.cjU != null) {
            this.cjU.a(forumData, pVar);
            if (forumData != null) {
                this.cjU.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cjU.eA(false);
                }
            }
        }
    }

    public boolean ahw() {
        if (("normal_page".equals(this.cjX) || "frs_page".equals(this.cjX) || "book_page".equals(this.cjX)) && this.cjU != null) {
            return this.cjU.ahO();
        }
        return false;
    }

    public void ahx() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cjU != null) {
            this.cjU.ahU().setVisibility(0);
        }
    }

    public void ahy() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cjU != null) {
            this.cjU.ahU().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cjV - this.cjW) {
                z = true;
                this.cjV = signData.levelup_score;
            }
            this.cjW = i + this.cjW;
            if (this.cjW > this.cjV) {
                this.cjW = this.cjV;
            }
            if (this.cjV != 0) {
                f = this.cjW / this.cjV;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.a(z, f);
        }
    }

    public void iN(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cjU != null) {
            this.cjU.iQ(i);
        }
    }

    public void j(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && pVar.aOk() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(pVar.aOk().getSignData(), pVar.aOk(), pVar);
            }
        }
    }

    public void k(com.baidu.tieba.tbadkCore.p pVar) {
        SignData signData;
        ForumData aOk;
        if (pVar != null && pVar.aOk() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cjU != null && (signData = pVar.aOk().getSignData()) != null && (aOk = pVar.aOk()) != null) {
                if (this.cjU.ahV() != null) {
                    this.cjU.ahV().setWithSign(true);
                }
                this.cjU.a(aOk, pVar);
                this.cjU.iQ(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cjU.ahO()) {
                    a(this.cjU, signData);
                    aOk.setCurScore(this.cjW);
                    aOk.setLevelupScore(this.cjV);
                    if (this.cjU.ahV() != null) {
                        this.cjU.ahV().setWithSign(true);
                    }
                    this.cjU.a(aOk, pVar);
                    this.cjU.c(this.cjU.ahT(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.cjU != null && signData != null && forumData != null && pVar != null) {
            this.cjU.a(forumData, pVar);
            this.cjU.iQ(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.cjU.ahO()) {
                a(this.cjU, signData);
                forumData.setCurScore(this.cjW);
                forumData.setLevelupScore(this.cjV);
                this.cjU.a(forumData, pVar);
                this.cjU.c(this.cjU.ahT(), true);
            }
        }
    }

    public boolean ahz() {
        if (("normal_page".equals(this.cjX) || "frs_page".equals(this.cjX) || "book_page".equals(this.cjX)) && this.cjU != null) {
            return this.cjU.ahz();
        }
        return false;
    }

    public boolean ahA() {
        if (("normal_page".equals(this.cjX) || "frs_page".equals(this.cjX) || "book_page".equals(this.cjX)) && this.cjU != null) {
            return this.cjU.ahA();
        }
        return false;
    }

    public BarImageView ahB() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cjU != null) {
            return this.cjU.ahB();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ew(boolean z) {
        if (this.bZY != null) {
            com.baidu.tieba.tbadkCore.p acr = this.bZY.acr();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bZY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11002)));
            } else if (acr != null && acr.aOk() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bZY.getFrom())) {
                    TiebaStatic.log(new av("c10356").ab("fid", acr.aOk().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bZY.getFrom())) {
                    TiebaStatic.log(new av("c10590").s("obj_type", 2).ab("fid", acr.aOk().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bZY.getFrom())) {
                    TiebaStatic.log(new av("c10587").s("obj_type", 2).ab("fid", acr.aOk().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bZY.getFrom())) {
                    TiebaStatic.log(new av("c10578").s("obj_type", 2).ab("fid", acr.aOk().getId()));
                }
                this.Gg.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bZY.getFrom())) {
                    TiebaStatic.eventStat(this.bZY.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bZY.getFrom())) {
                    TiebaStatic.log(new av("c10359").ab("fid", acr.aOk().getId()));
                }
                this.Gg.I(acr.aOk().getName(), acr.aOk().getId(), "FRS");
                this.ckd = z;
            }
        }
    }

    public void acu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bZY.acr() != null && this.bZY.acr().aOk() != null && this.bZY.acr().aOk().getName() != null) {
            str = this.bZY.acr().aOk().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cF(String.format(getPageContext().getString(r.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cF(getPageContext().getString(r.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(r.j.editor_dialog_yes), new r(this));
        aVar.b(getPageContext().getString(r.j.editor_dialog_no), new s(this));
        aVar.b(getPageContext()).tq();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ahC() {
        com.baidu.tieba.tbadkCore.p acr = this.bZY.acr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bZY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11014)));
        } else if (acr != null && acr.aOk() != null) {
            ahx();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, acr.aOk()));
        }
    }

    private void lP() {
        this.Gg = new com.baidu.tieba.tbadkCore.x(this.bZY.getPageContext());
        this.Gg.setLoadDataCallBack(new t(this));
    }

    private void ahD() {
        this.cka = new al();
        this.cka.setFrom("from_frs");
        this.cka.a(new u(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new v(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void s(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.p acr;
        if (i > 0 && i2 > 0 && (acr = this.bZY.acr()) != null && acr.aOk() != null && acr.getSignData() != null) {
            ForumData aOk = acr.aOk();
            SignData signData = acr.getSignData();
            signData.levelup_score = aOk.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            acr.d(signData);
            signData.forumId = aOk.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            j(acr);
            int i4 = -1;
            if (ahA()) {
                i4 = aOk.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aOk.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int ahE() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cjU.ahQ() != null && this.cjU.ahQ().getParent() != null) {
                return this.ccY.getHeaderViewsCount() - 2;
            }
            return this.ccY.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void aee() {
        if (this.cjU != null) {
            this.cjU.aee();
        }
    }

    public static boolean l(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return (pVar.bkF() == null || StringUtils.isNull(pVar.bkF().getBookId(), true) || pVar.bkF().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return ((pVar.bki() == null || pVar.bki().bkP() != 1) && pVar.bkE() == null && com.baidu.tbadk.core.util.x.t(pVar.bkL()) && (pVar.bkj() == null || com.baidu.tbadk.core.util.x.t(pVar.bkj().pz())) && ((pVar.aOk() == null || pVar.aOk().getFrsBannerData() == null || pVar.aOk().getFrsBannerData().getType() != 2) && (pVar.bkG() == null || StringUtils.isNull(pVar.bkG().pR(), true)))) ? false : true;
        }
        return false;
    }

    public void b(AcrossForumViewData acrossForumViewData) {
        if (acrossForumViewData != null) {
            this.cgb = acrossForumViewData;
        }
    }
}

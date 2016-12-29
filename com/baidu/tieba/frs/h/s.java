package com.baidu.tieba.frs.h;

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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f<FrsActivity> {
    private com.baidu.tieba.tbadkCore.w Gg;
    private com.baidu.tieba.play.aa aMd;
    private FrsActivity bFI;
    private BdTypeListView bIF;
    private AcrossForumViewData bLK;
    private com.baidu.tieba.frs.view.c bPd;
    private int bPe;
    private int bPf;
    private String bPg;
    private Runnable bPh;
    private boolean bPi;
    private com.baidu.tieba.tbadkCore.ak bPj;
    private boolean bPk;
    private com.baidu.tieba.frs.entelechy.b.a bPl;
    private boolean bPm;
    private com.baidu.tieba.frs.acrossForum.q bPn;
    private CustomMessageListener bPo;
    private int bpy;
    com.baidu.tieba.frs.entelechy.b.b byE;
    private final View.OnClickListener bzZ;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public s(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bIF = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bPg = null;
        this.bPi = false;
        this.Gg = null;
        this.bPj = null;
        this.bPk = false;
        this.bPo = new t(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bzZ = new u(this);
        this.bFI = frsActivity;
        this.bPl = aVar;
        if (this.bPl != null) {
            this.byE = this.bPl.YA();
        }
        frsActivity.registerListener(this.bPo);
    }

    public void a(com.baidu.tieba.play.aa aaVar) {
        this.aMd = aaVar;
    }

    public void f(Bundle bundle) {
        lP();
        aca();
        this.bPi = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.bPd != null) {
            this.bPd.onDestory();
        }
        if (this.Gg != null) {
            this.Gg.bfj();
        }
        if (this.bPh != null) {
            this.bFI.mHandler.removeCallbacks(this.bPh);
        }
    }

    public void onActivityStop() {
        if (this.bPd != null) {
            this.bPd.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bPd != null) {
            this.bPd.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c abN() {
        return this.bPd;
    }

    public void c(BdTypeListView bdTypeListView) {
        this.bIF = bdTypeListView;
    }

    public void ef(boolean z) {
        if (z) {
            if (this.bPd != null) {
                this.bIF.removeHeaderView(this.bPd.acn());
                this.bPk = false;
            }
        } else if (this.bPd != null && this.bPd.acn() != null && !this.bPk) {
            this.bIF.f(this.bPd.acn(), this.bIF.getHeaderViewsCount());
            this.bPk = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.o oVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && oVar != null && oVar.getUserData() != null && oVar.aIk() != null) {
            e(str, oVar.getUserData().getIsMem(), oVar.aIk().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.bPg, str);
        this.bpy = i2;
        this.bPg = str;
        abP();
        if (this.bPd == null || z) {
            if (this.bLK == null) {
                this.bPd = this.bPl.a(str, this.bFI, i);
            } else {
                this.bPn = new com.baidu.tieba.frs.acrossForum.q(this.bFI, null, this.bFI.getForumId(), i, this.bLK);
                this.bPn.b(this.bFI.Wc());
                this.bPn.b(this.bFI.Wd());
                this.bPd = this.bPn;
            }
            this.bPd.changeSkinType(this.mSkinType);
            this.bPd.setCommonClickListener(this.bzZ);
        }
        if (!this.bFI.Wv()) {
            this.bIF.addHeaderView(this.bPd.getView());
        }
        if (this.aMd != null) {
            this.aMd.a(this.bPd.acs());
        }
        if (this.byE != null) {
            this.byE.a(this.bIF, this.bPd);
        }
        abQ();
    }

    public void abO() {
        if (!this.bPk && this.bPd != null) {
            if (!this.bFI.Wv()) {
                this.bIF.addHeaderView(this.bPd.acn());
            }
            this.bPk = true;
        }
    }

    private void abP() {
        if (("normal_page".equals(this.bPg) || "frs_page".equals(this.bPg) || "book_page".equals(this.bPg)) && this.bPd != null) {
            this.bIF.removeHeaderView(this.bPd.getView());
            this.bIF.removeHeaderView(this.bPd.acn());
        }
        this.bPk = false;
    }

    private void abQ() {
        if (this.bPh == null) {
            this.bPh = new v(this);
        }
        this.bFI.mHandler.postDelayed(this.bPh, 4000L);
    }

    public void i(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(oVar.aIk(), oVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bPd != null) {
                this.bPd.a(forumData, oVar);
                this.bPd.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bPd.ia(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.bPd.ek(false);
                        return;
                    }
                    this.bPd.ek(true);
                    this.bPd.ia(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bPe = forumData.getLevelupScore();
        this.bPf = forumData.getCurScore();
        if (this.bPe > 0) {
            return this.bPf / this.bPe;
        }
        return 0.0f;
    }

    public void hU(int i) {
        if (i > 1) {
            if (this.bPd != null) {
                this.bPd.el(false);
            }
        } else if (this.bPd != null) {
            this.bPd.el(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void d(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            abR();
        }
    }

    public void setIsMem(int i) {
        if (this.bPd != null) {
            this.bPd.setMemberType(i);
        }
    }

    public void YK() {
        if (("normal_page".equals(this.bPg) || "frs_page".equals(this.bPg) || "book_page".equals(this.bPg)) && this.bPd != null) {
            this.bPd.YK();
        }
    }

    public void abR() {
        if (this.bPd != null) {
            this.bPd.YM();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, oVar.aIk(), oVar, z);
            }
        }
    }

    public void abS() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            hW(0);
        }
    }

    public void hV(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            hW(i);
        }
    }

    public void hW(int i) {
        if (this.bPd != null) {
            this.bPd.hZ(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bPd != null) {
            this.bPd.a(forumData, oVar);
            if (forumData != null) {
                this.bPd.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.bPd.ek(false);
                }
            }
        }
    }

    public boolean abT() {
        if (("normal_page".equals(this.bPg) || "frs_page".equals(this.bPg) || "book_page".equals(this.bPg)) && this.bPd != null) {
            return this.bPd.acl();
        }
        return false;
    }

    public void abU() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bPd != null) {
            this.bPd.acr().setVisibility(0);
        }
    }

    public void abV() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bPd != null) {
            this.bPd.acr().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.bPe - this.bPf) {
                z = true;
                this.bPe = signData.levelup_score;
            }
            this.bPf = i + this.bPf;
            if (this.bPf > this.bPe) {
                this.bPf = this.bPe;
            }
            if (this.bPe != 0) {
                f = this.bPf / this.bPe;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.a(z, f);
        }
    }

    public void hX(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bPd != null) {
            this.bPd.ia(i);
        }
    }

    public void j(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && oVar.aIk() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(oVar.aIk().getSignData(), oVar.aIk(), oVar);
            }
        }
    }

    public void k(com.baidu.tieba.tbadkCore.o oVar) {
        SignData signData;
        ForumData aIk;
        if (oVar != null && oVar.aIk() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bPd != null && (signData = oVar.aIk().getSignData()) != null && (aIk = oVar.aIk()) != null) {
                if (this.bPd.acs() != null) {
                    this.bPd.acs().setWithSign(true);
                }
                this.bPd.a(aIk, oVar);
                this.bPd.ia(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.bPd.acl()) {
                    a(this.bPd, signData);
                    aIk.setCurScore(this.bPf);
                    aIk.setLevelupScore(this.bPe);
                    if (this.bPd.acs() != null) {
                        this.bPd.acs().setWithSign(true);
                    }
                    this.bPd.a(aIk, oVar);
                    this.bPd.c(this.bPd.acq(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bPd != null && signData != null && forumData != null && oVar != null) {
            this.bPd.a(forumData, oVar);
            this.bPd.ia(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.bPd.acl()) {
                a(this.bPd, signData);
                forumData.setCurScore(this.bPf);
                forumData.setLevelupScore(this.bPe);
                this.bPd.a(forumData, oVar);
                this.bPd.c(this.bPd.acq(), true);
            }
        }
    }

    public boolean abW() {
        if (("normal_page".equals(this.bPg) || "frs_page".equals(this.bPg) || "book_page".equals(this.bPg)) && this.bPd != null) {
            return this.bPd.abW();
        }
        return false;
    }

    public boolean abX() {
        if (("normal_page".equals(this.bPg) || "frs_page".equals(this.bPg) || "book_page".equals(this.bPg)) && this.bPd != null) {
            return this.bPd.abX();
        }
        return false;
    }

    public BarImageView abY() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.bPd != null) {
            return this.bPd.abY();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void eg(boolean z) {
        if (this.bFI != null) {
            com.baidu.tieba.tbadkCore.o WF = this.bFI.WF();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bFI.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11002)));
            } else if (WF != null && WF.aIk() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bFI.getFrom())) {
                    TiebaStatic.log(new at("c10356").ab("fid", WF.aIk().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bFI.getFrom())) {
                    TiebaStatic.log(new at("c10590").s("obj_type", 2).ab("fid", WF.aIk().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bFI.getFrom())) {
                    TiebaStatic.log(new at("c10587").s("obj_type", 2).ab("fid", WF.aIk().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bFI.getFrom())) {
                    TiebaStatic.log(new at("c10578").s("obj_type", 2).ab("fid", WF.aIk().getId()));
                }
                this.Gg.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bFI.getFrom())) {
                    TiebaStatic.eventStat(this.bFI.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bFI.getFrom())) {
                    TiebaStatic.log(new at("c10359").ab("fid", WF.aIk().getId()));
                }
                this.Gg.I(WF.aIk().getName(), WF.aIk().getId(), "FRS");
                this.bPm = z;
            }
        }
    }

    public void WI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bFI.WF() != null && this.bFI.WF().aIk() != null && this.bFI.WF().aIk().getName() != null) {
            str = this.bFI.WF().aIk().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cG(String.format(getPageContext().getString(r.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cG(getPageContext().getString(r.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(r.j.editor_dialog_yes), new w(this));
        aVar.b(getPageContext().getString(r.j.editor_dialog_no), new x(this));
        aVar.b(getPageContext()).tb();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void abZ() {
        com.baidu.tieba.tbadkCore.o WF = this.bFI.WF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bFI.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(r.j.login_to_use), true, 11014)));
        } else if (WF != null && WF.aIk() != null) {
            abU();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, WF.aIk()));
        }
    }

    private void lP() {
        this.Gg = new com.baidu.tieba.tbadkCore.w(this.bFI.getPageContext());
        this.Gg.setLoadDataCallBack(new y(this));
    }

    private void aca() {
        this.bPj = new com.baidu.tieba.tbadkCore.ak();
        this.bPj.setFrom("from_frs");
        this.bPj.a(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new aa(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void s(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.o WF;
        if (i > 0 && i2 > 0 && (WF = this.bFI.WF()) != null && WF.aIk() != null && WF.getSignData() != null) {
            ForumData aIk = WF.aIk();
            SignData signData = WF.getSignData();
            signData.levelup_score = aIk.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            WF.d(signData);
            signData.forumId = aIk.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            j(WF);
            int i4 = -1;
            if (abX()) {
                i4 = aIk.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aIk.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int acb() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.bPd.acn() != null && this.bPd.acn().getParent() != null) {
                return this.bIF.getHeaderViewsCount() - 2;
            }
            return this.bIF.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void Yx() {
        if (this.bPd != null) {
            this.bPd.Yx();
        }
    }

    public static boolean l(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            return (oVar.bev() == null || StringUtils.isNull(oVar.bev().getBookId(), true) || oVar.bev().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean m(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            return ((oVar.bdY() == null || oVar.bdY().beG() != 1) && oVar.beu() == null && com.baidu.tbadk.core.util.x.t(oVar.beB()) && (oVar.bdZ() == null || com.baidu.tbadk.core.util.x.t(oVar.bdZ().pz())) && ((oVar.aIk() == null || oVar.aIk().getFrsBannerData() == null || oVar.aIk().getFrsBannerData().getType() != 2) && (oVar.bew() == null || StringUtils.isNull(oVar.bew().pS(), true)))) ? false : true;
        }
        return false;
    }

    public void b(AcrossForumViewData acrossForumViewData) {
        if (acrossForumViewData != null) {
            this.bLK = acrossForumViewData;
        }
    }
}

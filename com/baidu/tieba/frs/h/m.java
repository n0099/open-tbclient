package com.baidu.tieba.frs.h;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.ak;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f<FrsActivity> {
    private com.baidu.tieba.tbadkCore.x Dp;
    private int aWR;
    com.baidu.tieba.frs.entelechy.b.b bgN;
    private BdExpandListView bjM;
    private final View.OnClickListener bjV;
    private FrsActivity bpj;
    private HorizontalTabView.a bpr;
    private com.baidu.tieba.frs.entelechy.b.a buA;
    private com.baidu.tieba.frs.view.c buq;
    private int bur;
    private int bus;
    private String but;
    private Runnable buu;
    private boolean buv;
    private ak buw;
    private ai bux;
    private aa buy;
    private boolean buz;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public m(FrsActivity frsActivity, aa aaVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bjM = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.but = null;
        this.buv = false;
        this.Dp = null;
        this.buw = null;
        this.bux = null;
        this.buz = false;
        this.bpr = new n(this);
        this.bjV = new o(this);
        this.bpj = frsActivity;
        this.buy = aaVar;
        this.buA = aVar;
        if (this.buA != null) {
            this.bgN = this.buA.Sh();
        }
    }

    public void h(Bundle bundle) {
        kS();
        TY();
        TZ();
        this.buv = TbadkSettings.getInst().loadBoolean(FrsActivity.bfV, false);
    }

    public void onActivityDestroy() {
        if (this.buq != null) {
            this.buq.onDestory();
        }
        if (this.Dp != null) {
            this.Dp.aTc();
        }
        if (this.bux != null) {
            this.bux.aQL();
        }
        if (this.buu != null) {
            this.bpj.mHandler.removeCallbacks(this.buu);
        }
    }

    public void onActivityStop() {
        if (this.buq != null) {
            this.buq.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.buq != null) {
            this.buq.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c TL() {
        return this.buq;
    }

    public void a(BdExpandListView bdExpandListView) {
        this.bjM = bdExpandListView;
    }

    public void e(boolean z, int i, int i2) {
        if (z) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        e(this.mPageType, i, i2);
    }

    public void dl(boolean z) {
        if (z) {
            if (this.buq != null) {
                this.bjM.removeHeaderView(this.buq.Uf());
                this.buz = false;
            }
        } else if (this.buq != null && this.buq.Uf() != null && !this.buz) {
            this.bjM.f(this.buq.Uf(), this.bjM.getHeaderViewsCount());
            this.buz = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.o oVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str)) && oVar != null && oVar.getUserData() != null && oVar.avD() != null) {
            e(str, oVar.getUserData().getIsMem(), oVar.avD().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        this.aWR = i2;
        TN();
        this.but = "normal_page";
        if (this.buq == null) {
            this.buq = this.buA.a(str, this.bpj, i);
            this.buq.changeSkinType(this.mSkinType);
            this.buq.setCommonClickListener(this.bjV);
        }
        this.bjM.addHeaderView(this.buq.getView());
        if (this.bgN != null) {
            this.bgN.a(this.bjM, this.buq);
        }
        TO();
    }

    public void TM() {
        if (!this.buz && this.buq != null) {
            this.bjM.addHeaderView(this.buq.Uf());
            this.buz = true;
        }
    }

    public void gP(int i) {
        if (this.buq == null) {
            this.buq = this.buA.a("frs_page", this.bpj, i);
            this.buq.changeSkinType(this.mSkinType);
            this.buq.setCommonClickListener(this.bjV);
        }
    }

    private void TN() {
        if (("normal_page".equals(this.but) || "frs_page".equals(this.but)) && this.buq != null) {
            this.bjM.removeHeaderView(this.buq.getView());
            this.bjM.removeHeaderView(this.buq.Uf());
        }
        this.buz = false;
    }

    public void dm(boolean z) {
        if (z) {
            if (this.buq != null) {
                this.buq.Ui();
            }
        } else if (this.buq != null) {
            this.buq.Uh();
        }
    }

    private void TO() {
        if (this.buu == null) {
            this.buu = new p(this);
        }
        this.bpj.mHandler.postDelayed(this.buu, 4000L);
    }

    public void e(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType)) {
                b(oVar.avD(), oVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.buq != null) {
                this.buq.a(forumData, oVar);
                this.buq.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.buq.gW(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.buq.m17do(false);
                        return;
                    }
                    this.buq.m17do(true);
                    this.buq.gW(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bur = forumData.getLevelupScore();
        this.bus = forumData.getCurScore();
        if (this.bur > 0) {
            return this.bus / this.bur;
        }
        return 0.0f;
    }

    public void gQ(int i) {
        if (i > 1) {
            if (this.buq != null) {
                this.buq.dp(false);
            }
        } else if (this.buq != null) {
            this.buq.dp(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType)) {
            TP();
        }
    }

    public void setIsMem(int i) {
        if (this.buq != null) {
            this.buq.setMemberType(i);
        }
    }

    public void Ss() {
        if (("normal_page".equals(this.but) || "frs_page".equals(this.but)) && this.buq != null) {
            this.buq.Ss();
        }
    }

    public void TP() {
        if (this.buq != null) {
            this.buq.Su();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
                a(1, oVar.avD(), oVar, z);
            }
        }
    }

    public void TQ() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            gS(0);
        }
    }

    public void gR(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            gS(i);
        }
    }

    public void gS(int i) {
        if (this.buq != null) {
            this.buq.gV(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.buq != null) {
            this.buq.a(forumData, oVar);
            if (forumData != null) {
                this.buq.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.buq.m17do(false);
                }
            }
        }
    }

    public boolean TR() {
        if (("normal_page".equals(this.but) || "frs_page".equals(this.but)) && this.buq != null) {
            return this.buq.Ud();
        }
        return false;
    }

    public void TS() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.buq != null) {
            this.buq.Uk().setVisibility(0);
        }
    }

    public void TT() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.buq != null) {
            this.buq.Uk().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.bur - this.bus) {
                z = true;
                this.bur = signData.getLevelUpScore();
            }
            this.bus = bonusPoint + this.bus;
            if (this.bus > this.bur) {
                this.bus = this.bur;
            }
            if (this.bur != 0) {
                f = this.bus / this.bur;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.a(z, f);
        }
    }

    public void gT(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.buq != null) {
            this.buq.gW(i);
        }
    }

    public void f(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && oVar.avD() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
                a(oVar.avD().getSignData(), oVar.avD(), oVar);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.buq != null && signData != null && forumData != null && oVar != null) {
            this.buq.a(forumData, oVar);
            this.buq.gW(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.buq.Ud()) {
                a(this.buq, signData);
                forumData.setCurScore(this.bus);
                forumData.setLevelupScore(this.bur);
                this.buq.a(forumData, oVar);
                this.buq.f(this.buq.Uj(), true);
            }
        }
    }

    public boolean TU() {
        if (("normal_page".equals(this.but) || "frs_page".equals(this.but)) && this.buq != null) {
            return this.buq.TU();
        }
        return false;
    }

    public boolean TV() {
        if (("normal_page".equals(this.but) || "frs_page".equals(this.but)) && this.buq != null) {
            return this.buq.TV();
        }
        return false;
    }

    public BarImageView TW() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) && this.buq != null) {
            return this.buq.TW();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void kT() {
        if (this.bpj != null) {
            com.baidu.tieba.tbadkCore.o PZ = this.bpj.PZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m11getInst().login(this.bpj.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11002)));
            } else if (PZ != null && PZ.avD() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bpj.getFrom())) {
                    TiebaStatic.log(new aw("c10356").ac("fid", PZ.avD().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bpj.getFrom())) {
                    TiebaStatic.log(new aw("c10590").s("obj_type", 2).ac("fid", PZ.avD().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bpj.getFrom())) {
                    TiebaStatic.log(new aw("c10587").s("obj_type", 2).ac("fid", PZ.avD().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bpj.getFrom())) {
                    TiebaStatic.log(new aw("c10578").s("obj_type", 2).ac("fid", PZ.avD().getId()));
                }
                this.Dp.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bpj.getFrom())) {
                    TiebaStatic.eventStat(this.bpj.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bpj.getFrom())) {
                    TiebaStatic.log(new aw("c10359").ac("fid", PZ.avD().getId()));
                }
                this.Dp.C(PZ.avD().getName(), PZ.avD().getId(), "FRS");
            }
        }
    }

    public void Qc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bpj.PZ() != null && this.bpj.PZ().avD() != null && this.bpj.PZ().avD().getName() != null) {
            str = this.bpj.PZ().avD().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cA(String.format(getPageContext().getString(t.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cA(getPageContext().getString(t.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(t.j.editor_dialog_yes), new q(this));
        aVar.b(getPageContext().getString(t.j.editor_dialog_no), new r(this));
        aVar.b(getPageContext()).rV();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void TX() {
        com.baidu.tieba.tbadkCore.o PZ = this.bpj.PZ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m11getInst().login(this.bpj.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11014)));
        } else if (PZ != null && PZ.avD() != null) {
            TS();
            this.bux.bG(PZ.avD().getName(), PZ.avD().getId());
        }
    }

    private void kS() {
        this.Dp = new com.baidu.tieba.tbadkCore.x(this.bpj.getPageContext());
        this.Dp.setLoadDataCallBack(new s(this));
    }

    private void TY() {
        this.buw = new ak();
        this.buw.setFrom("from_frs");
        this.buw.a(new t(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new u(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void p(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.o PZ;
        if (i > 0 && i2 > 0 && (PZ = this.bpj.PZ()) != null && PZ.avD() != null && PZ.getSignData() != null) {
            ForumData avD = PZ.avD();
            SignData signData = PZ.getSignData();
            signData.setLevelUpScore(avD.getLevelupScore());
            signData.setBonusPoint(i3);
            signData.setMissSignNum(signData.getMissSignNum() - i2);
            signData.setCountSignNum(i);
            PZ.d(signData);
            signData.setForumId(avD.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            f(PZ);
            int i4 = -1;
            if (TV()) {
                i4 = avD.getUser_level() + 1;
            }
            TbadkCoreApplication.m11getInst().addSignedForum(avD.getName(), signData.getBonusPoint(), i4);
        }
    }

    private void TZ() {
        this.bux = new ai(this.bpj);
        this.bux.setLoadDataCallBack(new v(this));
    }

    public int Ua() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType)) {
            if (this.buq.Uf() != null && this.buq.Uf().getParent() != null) {
                return this.bjM.getHeaderViewsCount() - 2;
            }
            return this.bjM.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void Sf() {
        if (this.buq != null) {
            this.buq.Sf();
        }
    }

    public static boolean g(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            return ((oVar.aSd() == null || oVar.aSd().aSC() != 1) && oVar.aSy() == null && (oVar.avD() == null || oVar.avD().getFrsBannerData() == null || oVar.avD().getFrsBannerData().getType() != 2)) ? false : true;
        }
        return false;
    }
}

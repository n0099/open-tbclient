package com.baidu.tieba.frs.f;

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
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e<FrsActivity> {
    private com.baidu.tieba.play.ac aQP;
    private int bEq;
    com.baidu.tieba.frs.entelechy.b.b bNl;
    private final View.OnClickListener bOI;
    private FrsActivity bTf;
    private BdTypeListView bWb;
    private LikeModel brY;
    private com.baidu.tieba.frs.view.c ccW;
    private int ccX;
    private int ccY;
    private String ccZ;
    private Runnable cda;
    private boolean cdb;
    private com.baidu.tieba.tbadkCore.ag cdc;
    private boolean cdd;
    private com.baidu.tieba.frs.entelechy.b.a cde;
    private boolean cdf;
    private CustomMessageListener cdg;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public u(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bWb = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.ccZ = null;
        this.cdb = false;
        this.brY = null;
        this.cdc = null;
        this.cdd = false;
        this.cdg = new v(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bOI = new w(this);
        this.bTf = frsActivity;
        this.cde = aVar;
        if (this.cde != null) {
            this.bNl = this.cde.aaB();
        }
        frsActivity.registerListener(this.cdg);
    }

    public void a(com.baidu.tieba.play.ac acVar) {
        this.aQP = acVar;
    }

    public void g(Bundle bundle) {
        Ya();
        aeh();
        this.cdb = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.ccW != null) {
            this.ccW.onDestory();
        }
        if (this.brY != null) {
            this.brY.bgM();
        }
        if (this.cda != null) {
            this.bTf.mHandler.removeCallbacks(this.cda);
        }
    }

    public void onActivityStop() {
        if (this.ccW != null) {
            this.ccW.onStop();
        }
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.ccW != null) {
            this.ccW.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c adU() {
        return this.ccW;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.bWb = bdTypeListView;
    }

    public void ek(boolean z) {
        if (z) {
            if (this.ccW != null) {
                this.bWb.removeHeaderView(this.ccW.aew());
                this.cdd = false;
            }
        } else if (this.ccW != null && this.ccW.aew() != null && !this.cdd) {
            this.bWb.addHeaderView(this.ccW.aew(), this.bWb.getHeaderViewsCount());
            this.cdd = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && nVar != null && nVar.getUserData() != null && nVar.aJp() != null) {
            e(str, nVar.getUserData().getIsMem(), nVar.aJp().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.ccZ, str);
        this.bEq = i2;
        this.ccZ = str;
        adW();
        if (this.ccW == null || z) {
            this.ccW = this.cde.a(str, this.bTf, i);
            this.ccW.changeSkinType(this.mSkinType);
            this.ccW.setCommonClickListener(this.bOI);
        }
        if (!this.bTf.YL()) {
            this.bWb.addHeaderView(this.ccW.getView());
        }
        if (this.aQP != null) {
            this.aQP.a(this.ccW.aeB());
        }
        if (this.bNl != null) {
            this.bNl.a(this.bWb, this.ccW);
        }
        adX();
    }

    public void adV() {
        if (!this.cdd && this.ccW != null) {
            if (!this.bTf.YL()) {
                this.bWb.addHeaderView(this.ccW.aew());
            }
            this.cdd = true;
        }
    }

    private void adW() {
        if (("normal_page".equals(this.ccZ) || "frs_page".equals(this.ccZ) || "book_page".equals(this.ccZ)) && this.ccW != null) {
            this.bWb.removeHeaderView(this.ccW.getView());
            this.bWb.removeHeaderView(this.ccW.aew());
        }
        this.cdd = false;
    }

    private void adX() {
        if (this.cda == null) {
            this.cda = new x(this);
        }
        this.bTf.mHandler.postDelayed(this.cda, 4000L);
    }

    public void h(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(nVar.aJp(), nVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.ccW != null) {
                this.ccW.a(forumData, nVar);
                this.ccW.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.ccW.iK(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.ccW.eo(false);
                        return;
                    }
                    this.ccW.eo(true);
                    this.ccW.iK(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.ccX = forumData.getLevelupScore();
        this.ccY = forumData.getCurScore();
        if (this.ccX > 0) {
            return this.ccY / this.ccX;
        }
        return 0.0f;
    }

    public void iD(int i) {
        if (i > 1) {
            if (this.ccW != null) {
                this.ccW.ep(false);
            }
        } else if (this.ccW != null) {
            this.ccW.ep(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            adY();
        }
    }

    public void setIsMem(int i) {
        if (this.ccW != null) {
            this.ccW.setMemberType(i);
        }
    }

    public void aaJ() {
        if (("normal_page".equals(this.ccZ) || "frs_page".equals(this.ccZ) || "book_page".equals(this.ccZ)) && this.ccW != null) {
            this.ccW.aaJ();
        }
    }

    public void adY() {
        if (this.ccW != null) {
            this.ccW.aaL();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, nVar.aJp(), nVar, z);
            }
        }
    }

    public void adZ() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iF(0);
        }
    }

    public void iE(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iF(i);
        }
    }

    public void iF(int i) {
        if (this.ccW != null) {
            this.ccW.iJ(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.ccW != null) {
            this.ccW.a(forumData, nVar);
            if (forumData != null) {
                this.ccW.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.ccW.eo(false);
                }
            }
        }
    }

    public boolean aea() {
        if (("normal_page".equals(this.ccZ) || "frs_page".equals(this.ccZ) || "book_page".equals(this.ccZ)) && this.ccW != null) {
            return this.ccW.aeu();
        }
        return false;
    }

    public void aeb() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.ccW != null) {
            this.ccW.aeA().setVisibility(0);
        }
    }

    public void aec() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.ccW != null) {
            this.ccW.aeA().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.ccX - this.ccY) {
                z = true;
                this.ccX = signData.levelup_score;
            }
            this.ccY = i + this.ccY;
            if (this.ccY > this.ccX) {
                this.ccY = this.ccX;
            }
            if (this.ccX != 0) {
                f = this.ccY / this.ccX;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void iG(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.ccW != null) {
            this.ccW.iK(i);
        }
    }

    public void i(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null && nVar.aJp() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(nVar.aJp().getSignData(), nVar.aJp(), nVar);
            }
        }
    }

    public void j(com.baidu.tieba.tbadkCore.n nVar) {
        SignData signData;
        ForumData aJp;
        if (nVar != null && nVar.aJp() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.ccW != null && (signData = nVar.aJp().getSignData()) != null && (aJp = nVar.aJp()) != null) {
                if (this.ccW.aeB() != null) {
                    this.ccW.aeB().setWithSign(true);
                }
                this.ccW.a(aJp, nVar);
                this.ccW.iK(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.ccW.aeu()) {
                    a(this.ccW, signData);
                    aJp.setCurScore(this.ccY);
                    aJp.setLevelupScore(this.ccX);
                    if (this.ccW.aeB() != null) {
                        this.ccW.aeB().setWithSign(true);
                    }
                    this.ccW.a(aJp, nVar);
                    this.ccW.c(this.ccW.aez(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.ccW != null && signData != null && forumData != null && nVar != null) {
            this.ccW.a(forumData, nVar);
            this.ccW.iK(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.ccW.aeu()) {
                a(this.ccW, signData);
                forumData.setCurScore(this.ccY);
                forumData.setLevelupScore(this.ccX);
                this.ccW.a(forumData, nVar);
                this.ccW.c(this.ccW.aez(), true);
            }
        }
    }

    public boolean aed() {
        if (("normal_page".equals(this.ccZ) || "frs_page".equals(this.ccZ) || "book_page".equals(this.ccZ)) && this.ccW != null) {
            return this.ccW.aed();
        }
        return false;
    }

    public boolean aee() {
        if (("normal_page".equals(this.ccZ) || "frs_page".equals(this.ccZ) || "book_page".equals(this.ccZ)) && this.ccW != null) {
            return this.ccW.aee();
        }
        return false;
    }

    public BarImageView aef() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.ccW != null) {
            return this.ccW.aef();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void el(boolean z) {
        if (this.bTf != null) {
            com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bTf.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11002)));
            } else if (YV != null && YV.aJp() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bTf.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10356").Z("fid", YV.aJp().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bTf.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10590").s("obj_type", 2).Z("fid", YV.aJp().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bTf.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10587").s("obj_type", 2).Z("fid", YV.aJp().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bTf.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10578").s("obj_type", 2).Z("fid", YV.aJp().getId()));
                }
                this.brY.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bTf.getFrom())) {
                    TiebaStatic.eventStat(this.bTf.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bTf.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10359").Z("fid", YV.aJp().getId()));
                }
                this.brY.H(YV.aJp().getName(), YV.aJp().getId(), "FRS");
                this.cdf = z;
            }
        }
    }

    public void YY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bTf.YV() != null && this.bTf.YV().aJp() != null && this.bTf.YV().aJp().getName() != null) {
            str = this.bTf.YV().aJp().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cx(String.format(getPageContext().getString(w.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cx(getPageContext().getString(w.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(w.l.editor_dialog_yes), new y(this));
        aVar.b(getPageContext().getString(w.l.editor_dialog_no), new z(this));
        aVar.b(getPageContext()).ts();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aeg() {
        com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bTf.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11014)));
        } else if (YV != null && YV.aJp() != null) {
            aeb();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, YV.aJp()));
        }
    }

    private void Ya() {
        this.brY = new LikeModel(this.bTf.getPageContext());
        this.brY.setLoadDataCallBack(new aa(this));
    }

    private void aeh() {
        this.cdc = new com.baidu.tieba.tbadkCore.ag();
        this.cdc.setFrom("from_frs");
        this.cdc.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new ac(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.n YV;
        if (i > 0 && i2 > 0 && (YV = this.bTf.YV()) != null && YV.aJp() != null && YV.getSignData() != null) {
            ForumData aJp = YV.aJp();
            SignData signData = YV.getSignData();
            signData.levelup_score = aJp.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            YV.d(signData);
            signData.forumId = aJp.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            i(YV);
            int i4 = -1;
            if (aee()) {
                i4 = aJp.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aJp.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aei() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.ccW.aew() != null && this.ccW.aew().getParent() != null) {
                return this.bWb.getHeaderViewsCount() - 2;
            }
            return this.bWb.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void aay() {
        if (this.ccW != null) {
            this.ccW.aay();
        }
    }

    public static boolean k(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return (nVar.bfW() == null || StringUtils.isNull(nVar.bfW().getBookId(), true) || nVar.bfW().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return ((nVar.bfz() == null || nVar.bfz().bgh() != 1) && nVar.bfV() == null && com.baidu.tbadk.core.util.x.q(nVar.bgc()) && (nVar.bfA() == null || com.baidu.tbadk.core.util.x.q(nVar.bfA().pK())) && ((nVar.aJp() == null || nVar.aJp().getFrsBannerData() == null || nVar.aJp().getFrsBannerData().getType() != 2) && (nVar.bfX() == null || StringUtils.isNull(nVar.bfX().qd(), true)))) ? false : true;
        }
        return false;
    }

    public void iH(int i) {
        View findViewById;
        if (this.ccW != null && this.ccW.aew() != null && (findViewById = this.ccW.aew().findViewById(w.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }
}

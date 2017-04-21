package com.baidu.tieba.frs.g;

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
    private int bGA;
    com.baidu.tieba.frs.entelechy.b.b bPr;
    private final View.OnClickListener bQO;
    private FrsActivity bVk;
    private BdTypeListView bYg;
    private LikeModel bui;
    private com.baidu.tieba.frs.view.c cdO;
    private int cdP;
    private int cdQ;
    private String cdR;
    private Runnable cdS;
    private boolean cdT;
    private com.baidu.tieba.tbadkCore.ag cdU;
    private boolean cdV;
    private com.baidu.tieba.frs.entelechy.b.a cdW;
    private boolean cdX;
    private CustomMessageListener cdY;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public u(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bYg = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cdR = null;
        this.cdT = false;
        this.bui = null;
        this.cdU = null;
        this.cdV = false;
        this.cdY = new v(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bQO = new w(this);
        this.bVk = frsActivity;
        this.cdW = aVar;
        if (this.cdW != null) {
            this.bPr = this.cdW.aca();
        }
        frsActivity.registerListener(this.cdY);
    }

    public void h(Bundle bundle) {
        Zz();
        afd();
        this.cdT = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cdO != null) {
            this.cdO.onDestory();
        }
        if (this.bui != null) {
            this.bui.biy();
        }
        if (this.cdS != null) {
            this.bVk.mHandler.removeCallbacks(this.cdS);
        }
    }

    public void onActivityStop() {
        if (this.cdO != null) {
            this.cdO.onStop();
        }
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.cdO != null) {
            this.cdO.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c aeQ() {
        return this.cdO;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.bYg = bdTypeListView;
    }

    public void eu(boolean z) {
        if (z) {
            if (this.cdO != null) {
                this.bYg.removeHeaderView(this.cdO.afs());
                this.cdV = false;
            }
        } else if (this.cdO != null && this.cdO.afs() != null && !this.cdV) {
            this.bYg.addHeaderView(this.cdO.afs(), this.bYg.getHeaderViewsCount());
            this.cdV = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && nVar != null && nVar.getUserData() != null && nVar.aKx() != null) {
            e(str, nVar.getUserData().getIsMem(), nVar.aKx().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cdR, str);
        this.bGA = i2;
        this.cdR = str;
        aeS();
        if (this.cdO == null || z) {
            this.cdO = this.cdW.a(str, this.bVk, i);
            this.cdO.changeSkinType(this.mSkinType);
            this.cdO.setCommonClickListener(this.bQO);
        }
        if (!this.bVk.aai()) {
            this.bYg.addHeaderView(this.cdO.getView());
        }
        if (this.bPr != null) {
            this.bPr.a(this.bYg, this.cdO);
        }
        aeT();
    }

    public void aeR() {
        if (!this.cdV && this.cdO != null) {
            if (!this.bVk.aai()) {
                this.bYg.addHeaderView(this.cdO.afs());
            }
            this.cdV = true;
        }
    }

    private void aeS() {
        if (("normal_page".equals(this.cdR) || "frs_page".equals(this.cdR) || "book_page".equals(this.cdR)) && this.cdO != null) {
            this.bYg.removeHeaderView(this.cdO.getView());
            this.bYg.removeHeaderView(this.cdO.afs());
        }
        this.cdV = false;
    }

    private void aeT() {
        if (this.cdS == null) {
            this.cdS = new x(this);
        }
        this.bVk.mHandler.postDelayed(this.cdS, 4000L);
    }

    public void h(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(nVar.aKx(), nVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.cdO != null) {
                this.cdO.a(forumData, nVar);
                this.cdO.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cdO.iR(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cdO.ey(false);
                        return;
                    }
                    this.cdO.ey(true);
                    this.cdO.iR(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cdP = forumData.getLevelupScore();
        this.cdQ = forumData.getCurScore();
        if (this.cdP > 0) {
            return this.cdQ / this.cdP;
        }
        return 0.0f;
    }

    public void iK(int i) {
        if (i > 1) {
            if (this.cdO != null) {
                this.cdO.ez(false);
            }
        } else if (this.cdO != null) {
            this.cdO.ez(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aeU();
        }
    }

    public void setIsMem(int i) {
        if (this.cdO != null) {
            this.cdO.setMemberType(i);
        }
    }

    public void aci() {
        if (("normal_page".equals(this.cdR) || "frs_page".equals(this.cdR) || "book_page".equals(this.cdR)) && this.cdO != null) {
            this.cdO.aci();
        }
    }

    public void aeU() {
        if (this.cdO != null) {
            this.cdO.ack();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, nVar.aKx(), nVar, z);
            }
        }
    }

    public void aeV() {
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
        if (this.cdO != null) {
            this.cdO.iQ(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.cdO != null) {
            this.cdO.a(forumData, nVar);
            if (forumData != null) {
                this.cdO.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cdO.ey(false);
                }
            }
        }
    }

    public boolean aeW() {
        if (("normal_page".equals(this.cdR) || "frs_page".equals(this.cdR) || "book_page".equals(this.cdR)) && this.cdO != null) {
            return this.cdO.afq();
        }
        return false;
    }

    public void aeX() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cdO != null) {
            this.cdO.afw().setVisibility(0);
        }
    }

    public void aeY() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cdO != null) {
            this.cdO.afw().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cdP - this.cdQ) {
                z = true;
                this.cdP = signData.levelup_score;
            }
            this.cdQ = i + this.cdQ;
            if (this.cdQ > this.cdP) {
                this.cdQ = this.cdP;
            }
            if (this.cdP != 0) {
                f = this.cdQ / this.cdP;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void iN(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cdO != null) {
            this.cdO.iR(i);
        }
    }

    public void i(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null && nVar.aKx() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(nVar.aKx().getSignData(), nVar.aKx(), nVar);
            }
        }
    }

    public void j(com.baidu.tieba.tbadkCore.n nVar) {
        SignData signData;
        ForumData aKx;
        if (nVar != null && nVar.aKx() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cdO != null && (signData = nVar.aKx().getSignData()) != null && (aKx = nVar.aKx()) != null) {
                this.cdO.a(aKx, nVar);
                this.cdO.iR(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cdO.afq()) {
                    a(this.cdO, signData);
                    aKx.setCurScore(this.cdQ);
                    aKx.setLevelupScore(this.cdP);
                    this.cdO.a(aKx, nVar);
                    this.cdO.c(this.cdO.afv(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.cdO != null && signData != null && forumData != null && nVar != null) {
            this.cdO.a(forumData, nVar);
            this.cdO.iR(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.cdO.afq()) {
                a(this.cdO, signData);
                forumData.setCurScore(this.cdQ);
                forumData.setLevelupScore(this.cdP);
                this.cdO.a(forumData, nVar);
                this.cdO.c(this.cdO.afv(), true);
            }
        }
    }

    public boolean aeZ() {
        if (("normal_page".equals(this.cdR) || "frs_page".equals(this.cdR) || "book_page".equals(this.cdR)) && this.cdO != null) {
            return this.cdO.aeZ();
        }
        return false;
    }

    public boolean afa() {
        if (("normal_page".equals(this.cdR) || "frs_page".equals(this.cdR) || "book_page".equals(this.cdR)) && this.cdO != null) {
            return this.cdO.afa();
        }
        return false;
    }

    public BarImageView afb() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cdO != null) {
            return this.cdO.afb();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void ev(boolean z) {
        if (this.bVk != null) {
            com.baidu.tieba.tbadkCore.n aas = this.bVk.aas();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bVk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11002)));
            } else if (aas != null && aas.aKx() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bVk.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10356").aa("fid", aas.aKx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bVk.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10590").s("obj_type", 2).aa("fid", aas.aKx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bVk.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10587").s("obj_type", 2).aa("fid", aas.aKx().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bVk.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10578").s("obj_type", 2).aa("fid", aas.aKx().getId()));
                }
                this.bui.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bVk.getFrom())) {
                    TiebaStatic.eventStat(this.bVk.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bVk.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10359").aa("fid", aas.aKx().getId()));
                }
                this.bui.D(aas.aKx().getName(), aas.aKx().getId(), "FRS");
                this.cdX = z;
            }
        }
    }

    public void aav() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bVk.aas() != null && this.bVk.aas().aKx() != null && this.bVk.aas().aKx().getName() != null) {
            str = this.bVk.aas().aKx().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cE(String.format(getPageContext().getString(w.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cE(getPageContext().getString(w.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(w.l.editor_dialog_yes), new y(this));
        aVar.b(getPageContext().getString(w.l.editor_dialog_no), new z(this));
        aVar.b(getPageContext()).tQ();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void afc() {
        com.baidu.tieba.tbadkCore.n aas = this.bVk.aas();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bVk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11014)));
        } else if (aas != null && aas.aKx() != null) {
            aeX();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, aas.aKx()));
        }
    }

    private void Zz() {
        this.bui = new LikeModel(this.bVk.getPageContext());
        this.bui.setLoadDataCallBack(new aa(this));
    }

    private void afd() {
        this.cdU = new com.baidu.tieba.tbadkCore.ag();
        this.cdU.setFrom("from_frs");
        this.cdU.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new ac(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.n aas;
        if (i > 0 && i2 > 0 && (aas = this.bVk.aas()) != null && aas.aKx() != null && aas.getSignData() != null) {
            ForumData aKx = aas.aKx();
            SignData signData = aas.getSignData();
            signData.levelup_score = aKx.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aas.d(signData);
            signData.forumId = aKx.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            i(aas);
            int i4 = -1;
            if (afa()) {
                i4 = aKx.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aKx.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int afe() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cdO.afs() != null && this.cdO.afs().getParent() != null) {
                return this.bYg.getHeaderViewsCount() - 2;
            }
            return this.bYg.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void abX() {
        if (this.cdO != null) {
            this.cdO.abX();
        }
    }

    public static boolean k(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return (nVar.bhL() == null || StringUtils.isNull(nVar.bhL().getBookId(), true) || nVar.bhL().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return ((nVar.bhp() == null || nVar.bhp().bhV() != 1) && nVar.bhK() == null && (nVar.bhq() == null || com.baidu.tbadk.core.util.x.q(nVar.bhq().qi())) && ((nVar.aKx() == null || nVar.aKx().getFrsBannerData() == null || nVar.aKx().getFrsBannerData().getType() != 2) && (nVar.bhM() == null || StringUtils.isNull(nVar.bhM().qB(), true)))) ? false : true;
        }
        return false;
    }

    public void iO(int i) {
        View findViewById;
        if (this.cdO != null && this.cdO.afs() != null && (findViewById = this.cdO.afs().findViewById(w.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }
}

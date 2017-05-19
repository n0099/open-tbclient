package com.baidu.tieba.frs.e;

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
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private com.baidu.tieba.e.a aRD;
    private int bGx;
    private com.baidu.tieba.frs.r bNK;
    com.baidu.tieba.frs.entelechy.b.b bOG;
    private final View.OnClickListener bPI;
    private BdTypeListView bWg;
    private LikeModel bue;
    private int cbA;
    private int cbB;
    private String cbC;
    private Runnable cbD;
    private boolean cbE;
    private com.baidu.tieba.tbadkCore.ae cbF;
    private boolean cbG;
    private com.baidu.tieba.frs.entelechy.b.a cbH;
    private boolean cbI;
    private int cbJ;
    private CustomMessageListener cbK;
    private com.baidu.tieba.frs.view.b cbz;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public u(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(rVar.getPageContext());
        this.bWg = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cbC = null;
        this.cbE = false;
        this.bue = null;
        this.cbF = null;
        this.cbG = false;
        this.cbJ = 0;
        this.cbK = new v(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bPI = new w(this);
        this.bNK = rVar;
        this.cbH = aVar;
        if (this.cbH != null) {
            this.bOG = this.cbH.aal();
        }
        rVar.registerListener(this.cbK);
        this.aRD = new com.baidu.tieba.e.a();
        this.aRD.a(new x(this));
    }

    public void h(Bundle bundle) {
        Yq();
        add();
        this.cbE = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cbz != null) {
            this.cbz.onDestory();
        }
        if (this.bue != null) {
            this.bue.bfV();
        }
        if (this.cbD != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.cbD);
        }
    }

    public void onActivityStop() {
        if (this.cbz != null) {
            this.cbz.onStop();
        }
    }

    public boolean iC(int i) {
        this.mSkinType = i;
        if (this.cbz != null) {
            this.cbz.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.bWg = bdTypeListView;
    }

    public void ei(boolean z) {
        if (z) {
            if (this.cbz != null) {
                this.bWg.removeHeaderView(this.cbz.adh());
                this.cbG = false;
            }
        } else if (this.cbz != null && this.cbz.adh() != null && !this.cbG) {
            this.bWg.addHeaderView(this.cbz.adh(), this.bWg.getHeaderViewsCount());
            this.cbG = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && nVar != null && nVar.getUserData() != null && nVar.aHE() != null) {
            e(str, nVar.getUserData().getIsMem(), nVar.aHE().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cbC, str);
        this.bGx = i2;
        this.cbC = str;
        acT();
        if (this.cbz == null || z) {
            this.cbz = this.cbH.a(str, this.bNK, i);
            this.cbz.changeSkinType(this.mSkinType);
            this.cbz.setCommonClickListener(this.bPI);
        }
        this.bWg.addHeaderView(this.cbz.getView());
        if (this.bOG != null) {
            this.bOG.a(this.bWg, this.cbz);
        }
        if (this.bNK.Zt()) {
            this.cbz.iK(com.baidu.adp.lib.util.k.g(this.bNK.getActivity(), w.f.ds40));
        } else {
            this.cbz.iK(com.baidu.adp.lib.util.k.g(this.bNK.getActivity(), w.f.ds20));
        }
        acU();
    }

    public void acS() {
        if (!this.cbG && this.cbz != null) {
            this.bWg.addHeaderView(this.cbz.adh());
            this.cbG = true;
        }
    }

    private void acT() {
        if (("normal_page".equals(this.cbC) || "frs_page".equals(this.cbC) || "book_page".equals(this.cbC)) && this.cbz != null) {
            this.bWg.removeHeaderView(this.cbz.getView());
            this.bWg.removeHeaderView(this.cbz.adh());
        }
        this.cbG = false;
    }

    private void acU() {
        if (this.cbD == null) {
            this.cbD = new y(this);
        }
        com.baidu.adp.lib.g.h.fS().postDelayed(this.cbD, 4000L);
    }

    public void f(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(nVar.aHE(), nVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.cbz != null) {
                this.cbz.a(forumData, nVar);
                this.cbz.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cbz.iJ(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cbz.ek(false);
                    } else {
                        this.cbz.ek(true);
                        this.cbz.iJ(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.cbJ) {
                    bd bdVar = new bd();
                    bdVar.setForumName(forumData.getName());
                    bdVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, bdVar));
                    this.cbJ = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cbA = forumData.getLevelupScore();
        this.cbB = forumData.getCurScore();
        if (this.cbA > 0) {
            return this.cbB / this.cbA;
        }
        return 0.0f;
    }

    public void iD(int i) {
        if (i > 1) {
            if (this.cbz != null) {
                this.cbz.el(false);
            }
        } else if (this.cbz != null) {
            this.cbz.el(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            acV();
        }
    }

    public void setIsMem(int i) {
        if (this.cbz != null) {
            this.cbz.setMemberType(i);
        }
    }

    public void aaw() {
        if (("normal_page".equals(this.cbC) || "frs_page".equals(this.cbC) || "book_page".equals(this.cbC)) && this.cbz != null) {
            this.cbz.aaw();
        }
    }

    public void acV() {
        if (this.cbz != null) {
            this.cbz.aay();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, nVar.aHE(), nVar, z);
            }
        }
    }

    public void acW() {
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
        if (this.cbz != null) {
            this.cbz.iI(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.cbz != null) {
            this.cbz.a(forumData, nVar);
            if (forumData != null) {
                this.cbz.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cbz.ek(false);
                }
            }
        }
    }

    public boolean acX() {
        if (("normal_page".equals(this.cbC) || "frs_page".equals(this.cbC) || "book_page".equals(this.cbC)) && this.cbz != null) {
            return this.cbz.adf();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cbA - this.cbB) {
                z = true;
                this.cbA = signData.levelup_score;
            }
            this.cbB = i + this.cbB;
            if (this.cbB > this.cbA) {
                this.cbB = this.cbA;
            }
            if (this.cbA != 0) {
                f = this.cbB / this.cbA;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void iG(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbz != null) {
            this.cbz.iJ(i);
        }
    }

    public void g(com.baidu.tieba.tbadkCore.n nVar) {
        SignData signData;
        ForumData aHE;
        if (nVar != null && nVar.aHE() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbz != null && (signData = nVar.aHE().getSignData()) != null && (aHE = nVar.aHE()) != null) {
                this.cbz.a(aHE, nVar);
                this.cbz.iJ(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cbz.adf()) {
                    a(this.cbz, signData);
                    aHE.setCurScore(this.cbB);
                    aHE.setLevelupScore(this.cbA);
                    this.cbz.a(aHE, nVar);
                }
            }
        }
    }

    public boolean acY() {
        if (("normal_page".equals(this.cbC) || "frs_page".equals(this.cbC) || "book_page".equals(this.cbC)) && this.cbz != null) {
            return this.cbz.acY();
        }
        return false;
    }

    public boolean acZ() {
        if (("normal_page".equals(this.cbC) || "frs_page".equals(this.cbC) || "book_page".equals(this.cbC)) && this.cbz != null) {
            return this.cbz.acZ();
        }
        return false;
    }

    public BarImageView ada() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbz != null) {
            return this.cbz.ada();
        }
        return null;
    }

    public void ej(boolean z) {
        if (this.bNK != null) {
            com.baidu.tieba.tbadkCore.n Zq = this.bNK.Zq();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bNK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11002)));
            } else if (Zq != null && Zq.aHE() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bNK.getFrom())) {
                    TiebaStatic.log(new as("c10356").aa("fid", Zq.aHE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bNK.getFrom())) {
                    TiebaStatic.log(new as("c10590").s("obj_type", 2).aa("fid", Zq.aHE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bNK.getFrom())) {
                    TiebaStatic.log(new as("c10587").s("obj_type", 2).aa("fid", Zq.aHE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bNK.getFrom())) {
                    TiebaStatic.log(new as("c10578").s("obj_type", 2).aa("fid", Zq.aHE().getId()));
                }
                this.bue.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bNK.getFrom())) {
                    TiebaStatic.eventStat(this.bNK.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bNK.getFrom())) {
                    TiebaStatic.log(new as("c10359").aa("fid", Zq.aHE().getId()));
                }
                this.bue.D(Zq.aHE().getName(), Zq.aHE().getId(), "FRS");
                this.cbI = z;
            }
        }
    }

    public void adb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bNK.Zq() != null && this.bNK.Zq().aHE() != null && this.bNK.Zq().aHE().getName() != null) {
            str = this.bNK.Zq().aHE().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cC(String.format(getPageContext().getString(w.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cC(getPageContext().getString(w.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(w.l.editor_dialog_yes), new z(this));
        aVar.b(getPageContext().getString(w.l.editor_dialog_no), new aa(this));
        aVar.b(getPageContext()).td();
    }

    public void adc() {
        com.baidu.tieba.tbadkCore.n Zq = this.bNK.Zq();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bNK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11014)));
        } else if (Zq != null && Zq.aHE() != null) {
            FrsActivityStatic.forumName = Zq.aHE().getName() == null ? "" : Zq.aHE().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, Zq.aHE()));
        }
    }

    private void Yq() {
        this.bue = new LikeModel(this.bNK.getPageContext());
        this.bue.setLoadDataCallBack(new ab(this));
    }

    private void add() {
        this.cbF = new com.baidu.tieba.tbadkCore.ae();
        this.cbF.setFrom("from_frs");
        this.cbF.a(new ac(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        new ad(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.n Zq;
        if (i > 0 && i2 > 0 && (Zq = this.bNK.Zq()) != null && Zq.aHE() != null && Zq.getSignData() != null) {
            ForumData aHE = Zq.aHE();
            SignData signData = Zq.getSignData();
            signData.levelup_score = aHE.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            Zq.d(signData);
            signData.forumId = aHE.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (acZ()) {
                i4 = aHE.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aHE.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int ade() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cbz != null && this.cbz.adh() != null && this.cbz.adh().getParent() != null) {
                return this.bWg.getHeaderViewsCount() - 2;
            }
            return this.bWg.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void aak() {
        if (this.cbz != null) {
            this.cbz.aak();
        }
    }

    public static boolean h(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return (nVar.bfn() == null || StringUtils.isNull(nVar.bfn().getBookId(), true) || nVar.bfn().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return ((nVar.beR() == null || nVar.beR().bfx() != 1) && nVar.bfm() == null && (nVar.beS() == null || com.baidu.tbadk.core.util.x.r(nVar.beS().pM())) && ((nVar.aHE() == null || nVar.aHE().getFrsBannerData() == null || nVar.aHE().getFrsBannerData().getType() != 2) && (nVar.bfo() == null || StringUtils.isNull(nVar.bfo().pT(), true)))) ? false : true;
        }
        return false;
    }

    public void iH(int i) {
        View findViewById;
        if (this.cbz != null && this.cbz.adh() != null && (findViewById = this.cbz.adh().findViewById(w.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.aRD != null) {
            this.aRD.onTouchEvent(motionEvent);
        }
    }
}

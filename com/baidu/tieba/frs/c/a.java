package com.baidu.tieba.frs.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.o;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ax;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.i.a {
    private FrsActivity aPE;
    private com.baidu.adp.lib.guide.d aPV;
    private int aPW;
    private int aPX;
    private Runnable aPY;
    private int mIsLike;
    private BdListView aPQ = null;
    private FrsHeaderView aPR = null;
    private o aPS = null;
    private com.baidu.tieba.frs.view.h aPT = null;
    private aw aPU = null;
    private int mScrollState = 0;
    private int mSkinType = 0;
    private String mPageType = "normal_page";
    private String aNR = null;
    private boolean aPZ = false;
    private af LI = null;
    private ax aQa = null;
    private cl aQb = null;
    private final View.OnClickListener aNU = new b(this);

    public a(FrsActivity frsActivity) {
        this.aPE = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        oE();
        Mv();
        Mw();
        this.aPZ = TbadkSettings.getInst().loadBoolean(FrsActivity.aKV, false);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.aPR != null) {
            this.aPR.onDestory();
        }
        if (this.aPS != null) {
            this.aPS.onDestory();
        }
        if (this.LI != null) {
            this.LI.LP();
        }
        if (this.aQb != null) {
            this.aQb.LP();
        }
        if (this.aPY != null) {
            this.aPE.mHandler.removeCallbacks(this.aPY);
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oJ() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oI() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oL() {
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return 0;
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.adp.base.g
    public TbPageContext<?> getPageContext() {
        return this.aPE.getPageContext();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public LayoutInflater getLayoutInflater() {
        return this.aPE.getLayoutInflater();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.aPS != null) {
            this.aPS.changeSkinType(i);
        }
        if (this.aPU != null) {
            this.aPU.notifyDataSetChanged();
        }
        if (this.aPT != null) {
            this.aPT.changeSkinType(i);
        }
        if (this.aPR != null) {
            this.aPR.changeSkinType(i);
        }
        return super.a(tbPageContext, i);
    }

    public FrsHeaderView Ma() {
        return this.aPR;
    }

    public o Mb() {
        return this.aPS;
    }

    public void v(BdListView bdListView) {
        this.aPQ = bdListView;
    }

    public void f(boolean z, int i, int i2) {
        if (z) {
            this.mPageType = "frs_page";
            O(i, i2);
            return;
        }
        this.mPageType = "normal_page";
        N(i, i2);
    }

    public void a(String str, w wVar) {
        this.mPageType = str;
        if ("frs_page".equals(str)) {
            if (wVar != null && wVar.getUserData() != null && wVar.aar() != null) {
                O(wVar.getUserData().getIsMem(), wVar.aar().isLike());
            }
        } else if ("normal_page".equals(str)) {
            if (wVar != null && wVar.getUserData() != null && wVar.aar() != null) {
                N(wVar.getUserData().getIsMem(), wVar.aar().isLike());
            }
        } else if ("good_page".equals(str) && wVar != null && wVar.aar() != null) {
            b(wVar.aar().getGood_classify(), this.aPE.aLN);
        }
    }

    public void N(int i, int i2) {
        this.mIsLike = i2;
        Md();
        this.aNR = "normal_page";
        if (this.aPR == null) {
            this.aPR = new FrsHeaderView(this.aPE, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aPR.changeSkinType(this.mSkinType);
            this.aPR.n(this.aNU);
        }
        this.aPQ.addHeaderView(this.aPR.getView());
        Me();
    }

    public void O(int i, int i2) {
        this.mIsLike = i2;
        Md();
        this.aNR = "frs_page";
        fg(i);
        this.aPQ.addHeaderView(this.aPS.getView());
        Me();
    }

    public void fg(int i) {
        if (this.aPS == null) {
            this.aPS = new o(this.aPE.getPageContext(), null, null, i);
            this.aPS.changeSkinType(this.mSkinType);
            this.aPS.setBannerViewClickListener(this.aPE.KJ());
            this.aPS.n(this.aNU);
        }
    }

    public void Mc() {
        Md();
        this.aNR = "good_page";
        if (this.aPT == null) {
            this.aPT = new com.baidu.tieba.frs.view.h(getPageContext().getPageActivity());
            this.aPT.changeSkinType(this.mSkinType);
        }
        this.aPQ.addHeaderView(this.aPT.getView());
    }

    private void Md() {
        if ("normal_page".equals(this.aNR) && this.aPR != null) {
            this.aPQ.removeHeaderView(this.aPR.getView());
        } else if ("frs_page".equals(this.aNR) && this.aPS != null) {
            this.aPQ.removeHeaderView(this.aPS.getView());
        } else if ("good_page".equals(this.aNR) && this.aPT != null) {
            this.aPQ.removeHeaderView(this.aPT.getView());
        }
    }

    public void cf(boolean z) {
        if (z) {
            if (Ma() != null) {
                Ma().MD();
            }
            if (Mb() != null) {
                Mb().MD();
                return;
            }
            return;
        }
        if (Ma() != null) {
            Ma().MC();
        }
        if (Mb() != null) {
            Mb().MC();
        }
    }

    private void Me() {
        if (this.aPY == null) {
            this.aPY = new c(this);
        }
        this.aPE.mHandler.postDelayed(this.aPY, 4000L);
    }

    public void c(w wVar) {
        if (wVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(wVar.aar(), wVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(wVar.aar(), wVar);
            }
        }
    }

    public void a(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aPS != null) {
                this.aPS.c(forumData, wVar);
                this.aPS.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.aPS.fp(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aPS.ch(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aPR != null) {
                this.aPR.c(forumData, wVar);
                this.aPR.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aPR.ch(false);
                        return;
                    }
                    this.aPR.ch(true);
                    this.aPR.fp(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aPW = forumData.getLevelupScore();
        this.aPX = forumData.getCurScore();
        if (this.aPW > 0) {
            return this.aPX / this.aPW;
        }
        return 0.0f;
    }

    public void Mf() {
        if (this.aPS != null) {
            this.aPS.Mf();
        }
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.l> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Mc();
        if (arrayList != null) {
            if (this.aPU == null) {
                this.aPU = new aw(getPageContext().getPageActivity(), arrayList);
                this.aPT.a(this.aPU);
                this.aPT.b(onItemClickListener);
                return;
            }
            this.aPU.setData(arrayList);
            this.aPU.notifyDataSetChanged();
        }
    }

    public void eW(int i) {
        if (this.aPU != null) {
            this.aPU.eW(i);
        }
    }

    public void fh(int i) {
        if (i > 1) {
            if (this.aPR != null) {
                this.aPR.setIsFirstPage(false);
            }
            if (this.aPS != null) {
                this.aPS.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.aPR != null) {
            this.aPR.setIsFirstPage(true);
        }
        if (this.aPS != null) {
            this.aPS.setIsFirstPage(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            Mi();
        } else if ("normal_page".equals(this.mPageType)) {
            Mh();
        }
    }

    public void setIsMem(int i) {
        if (this.aPR != null) {
            this.aPR.fq(i);
        }
        if (this.aPS != null) {
            this.aPS.fq(i);
        }
    }

    public void Mg() {
        if ("normal_page".equals(this.aNR)) {
            if (this.aPR != null) {
                this.aPR.Mg();
            }
        } else if ("frs_page".equals(this.aNR) && this.aPS != null) {
            this.aPS.Mg();
        }
    }

    public void Mh() {
        if (this.aPR != null) {
            this.aPR.MG();
        }
    }

    public void Mi() {
        if (this.aPS != null) {
            this.aPS.MG();
        }
    }

    public void a(w wVar, boolean z) {
        if (wVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, wVar.aar(), wVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, wVar.aar(), wVar, z);
            }
        }
    }

    public void Mj() {
        if ("normal_page".equals(this.mPageType)) {
            fj(0);
        } else if ("frs_page".equals(this.mPageType)) {
            fk(0);
        }
    }

    public void fi(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fj(i);
        } else if ("frs_page".equals(this.mPageType)) {
            fk(i);
        }
    }

    public void fj(int i) {
        if (this.aPR != null) {
            this.aPR.fo(i);
        }
    }

    public void fk(int i) {
        if (this.aPS != null) {
            this.aPS.fo(i);
        }
    }

    public void a(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aPR != null) {
            this.aPR.c(forumData, wVar);
            if (forumData != null) {
                this.aPR.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aPR.ch(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aPS != null) {
            this.aPS.c(forumData, wVar);
            float a = a(forumData);
            if (forumData != null) {
                this.aPS.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aPS.ch(false);
                }
            }
        }
    }

    public boolean Mk() {
        if ("normal_page".equals(this.aNR) && this.aPR != null) {
            return this.aPR.Mz();
        }
        if ("frs_page".equals(this.aNR) && this.aPS != null) {
            return this.aPS.Mz();
        }
        return false;
    }

    public void Ml() {
        if ("normal_page".equals(this.mPageType)) {
            Mn();
        } else if ("frs_page".equals(this.mPageType)) {
            Mp();
        }
    }

    public void Mm() {
        if ("normal_page".equals(this.mPageType)) {
            Mo();
        } else if ("frs_page".equals(this.mPageType)) {
            Mq();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aPW - this.aPX) {
                z = true;
                this.aPW = signData.getLevelUpScore();
            }
            this.aPX = bonusPoint + this.aPX;
            if (this.aPX > this.aPW) {
                this.aPX = this.aPW;
            }
            if (this.aPW != 0) {
                f = this.aPX / this.aPW;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void fl(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fm(i);
        } else if ("frs_page".equals(this.mPageType)) {
            fn(i);
        }
    }

    public void d(w wVar) {
        if (wVar != null && wVar.aar() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(wVar.aar().getSignData(), wVar.aar(), wVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(wVar.aar().getSignData(), wVar.aar(), wVar);
            }
        }
    }

    public void fm(int i) {
        if (this.aPR != null) {
            this.aPR.fp(i);
        }
    }

    public void a(SignData signData, ForumData forumData, w wVar) {
        if (this.aPR != null && signData != null && forumData != null && wVar != null) {
            this.aPR.c(forumData, wVar);
            this.aPR.fp(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aPR.Mz()) {
                a(this.aPR, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aPX);
                    forumData.setLevelupScore(this.aPW);
                }
                this.aPR.c(forumData, wVar);
                this.aPR.c(this.aPR.ME(), true);
            }
        }
    }

    public void fn(int i) {
        if (this.aPS != null) {
            this.aPS.fp(i);
        }
    }

    public void b(SignData signData, ForumData forumData, w wVar) {
        if (this.aPS != null && signData != null && forumData != null && wVar != null) {
            this.aPS.c(forumData, wVar);
            this.aPS.fp(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aPS.Mz()) {
                a(this.aPS, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aPX);
                    forumData.setLevelupScore(this.aPW);
                }
                this.aPS.c(forumData, wVar);
                this.aPS.c(this.aPS.ME(), true);
            }
        }
    }

    public void Mn() {
        if (this.aPR != null) {
            this.aPR.MF().setVisibility(0);
        }
    }

    public void Mo() {
        if (this.aPR != null) {
            this.aPR.MF().setVisibility(8);
        }
    }

    public void Mp() {
        if (this.aPS != null) {
            this.aPS.MF().setVisibility(0);
        }
    }

    public void Mq() {
        if (this.aPS != null) {
            this.aPS.MF().setVisibility(8);
        }
    }

    public boolean Mr() {
        if ("normal_page".equals(this.aNR) && this.aPR != null) {
            return this.aPR.Mr();
        }
        if ("frs_page".equals(this.aNR) && this.aPS != null) {
            return this.aPS.Mr();
        }
        return false;
    }

    public void x(View view) {
        if (this.aPR != null) {
            this.aPR.c(view, false);
        }
    }

    public void y(View view) {
        if (this.aPS != null) {
            this.aPS.c(view, false);
        }
    }

    public boolean Ms() {
        if ("normal_page".equals(this.aNR)) {
            if (this.aPR != null) {
                return this.aPR.Ms();
            }
        } else if ("frs_page".equals(this.aNR) && this.aPS != null) {
            return this.aPS.Ms();
        }
        return false;
    }

    public BarImageView Mt() {
        o Mb;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView Ma = Ma();
            if (Ma != null) {
                return Ma.Mt();
            }
        } else if ("frs_page".equals(this.mPageType) && (Mb = Mb()) != null) {
            return Mb.Mt();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oF() {
        if (this.aPE != null) {
            w KE = this.aPE.KE();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.aPE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.login_to_use), true, 11002)));
            } else if (KE != null && KE.aar() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.aPE.getFrom())) {
                    this.LI.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                } else {
                    this.LI.setFrom(PbActivityConfig.KEY_FROM_FRS);
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.aPE.getFrom())) {
                    TiebaStatic.eventStat(this.aPE.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LI.ba(KE.aar().getName(), KE.aar().getId());
            }
        }
    }

    public void KK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.aPE.KE() != null && this.aPE.KE().aar() != null && this.aPE.KE().aar().getName() != null) {
            str = this.aPE.KE().aar().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cn(String.format(getPageContext().getString(t.attention_cancel_dialog_content), str));
        } else {
            aVar.cn(getPageContext().getString(t.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(t.editor_dialog_yes), new d(this));
        aVar.b(getPageContext().getString(t.editor_dialog_no), new e(this));
        aVar.b(getPageContext()).rL();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void Mu() {
        w KE = this.aPE.KE();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.aPE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.login_to_use), true, 11014)));
        } else if (KE != null && KE.aar() != null) {
            Ml();
            this.aQb.au(KE.aar().getName(), KE.aar().getId());
        }
    }

    private void oE() {
        this.LI = new af(getPageContext());
        this.LI.setLoadDataCallBack(new f(this));
    }

    private void Mv() {
        this.aQa = new ax();
        this.aQa.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aQa.a(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new h(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Mw() {
        this.aQb = new cl(this.aPE);
        this.aQb.setLoadDataCallBack(new i(this));
    }

    public void b(NavigationBar navigationBar) {
        if (TbadkCoreApplication.m411getInst().isFirstGoFrs()) {
            TbadkCoreApplication.m411getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(navigationBar).M(0).v(false);
            gVar.a(new j(this));
            this.aPV = gVar.gG();
            this.aPV.i(getPageContext().getPageActivity());
        }
    }
}

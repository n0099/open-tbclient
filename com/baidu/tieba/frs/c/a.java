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
    private FrsActivity aPF;
    private com.baidu.adp.lib.guide.d aPW;
    private int aPX;
    private int aPY;
    private Runnable aPZ;
    private int mIsLike;
    private BdListView aPR = null;
    private FrsHeaderView aPS = null;
    private o aPT = null;
    private com.baidu.tieba.frs.view.h aPU = null;
    private aw aPV = null;
    private int mScrollState = 0;
    private int mSkinType = 0;
    private String mPageType = "normal_page";
    private String aNS = null;
    private boolean aQa = false;
    private af LI = null;
    private ax aQb = null;
    private cl aQc = null;
    private final View.OnClickListener aNV = new b(this);

    public a(FrsActivity frsActivity) {
        this.aPF = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        oE();
        Mw();
        Mx();
        this.aQa = TbadkSettings.getInst().loadBoolean(FrsActivity.aKW, false);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.aPS != null) {
            this.aPS.onDestory();
        }
        if (this.aPT != null) {
            this.aPT.onDestory();
        }
        if (this.LI != null) {
            this.LI.LQ();
        }
        if (this.aQc != null) {
            this.aQc.LQ();
        }
        if (this.aPZ != null) {
            this.aPF.mHandler.removeCallbacks(this.aPZ);
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
        return this.aPF.getPageContext();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public LayoutInflater getLayoutInflater() {
        return this.aPF.getLayoutInflater();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.aPT != null) {
            this.aPT.changeSkinType(i);
        }
        if (this.aPV != null) {
            this.aPV.notifyDataSetChanged();
        }
        if (this.aPU != null) {
            this.aPU.changeSkinType(i);
        }
        if (this.aPS != null) {
            this.aPS.changeSkinType(i);
        }
        return super.a(tbPageContext, i);
    }

    public FrsHeaderView Mb() {
        return this.aPS;
    }

    public o Mc() {
        return this.aPT;
    }

    public void v(BdListView bdListView) {
        this.aPR = bdListView;
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
            if (wVar != null && wVar.getUserData() != null && wVar.aas() != null) {
                O(wVar.getUserData().getIsMem(), wVar.aas().isLike());
            }
        } else if ("normal_page".equals(str)) {
            if (wVar != null && wVar.getUserData() != null && wVar.aas() != null) {
                N(wVar.getUserData().getIsMem(), wVar.aas().isLike());
            }
        } else if ("good_page".equals(str) && wVar != null && wVar.aas() != null) {
            b(wVar.aas().getGood_classify(), this.aPF.aLO);
        }
    }

    public void N(int i, int i2) {
        this.mIsLike = i2;
        Me();
        this.aNS = "normal_page";
        if (this.aPS == null) {
            this.aPS = new FrsHeaderView(this.aPF, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aPS.changeSkinType(this.mSkinType);
            this.aPS.n(this.aNV);
        }
        this.aPR.addHeaderView(this.aPS.getView());
        Mf();
    }

    public void O(int i, int i2) {
        this.mIsLike = i2;
        Me();
        this.aNS = "frs_page";
        fg(i);
        this.aPR.addHeaderView(this.aPT.getView());
        Mf();
    }

    public void fg(int i) {
        if (this.aPT == null) {
            this.aPT = new o(this.aPF.getPageContext(), null, null, i);
            this.aPT.changeSkinType(this.mSkinType);
            this.aPT.setBannerViewClickListener(this.aPF.KK());
            this.aPT.n(this.aNV);
        }
    }

    public void Md() {
        Me();
        this.aNS = "good_page";
        if (this.aPU == null) {
            this.aPU = new com.baidu.tieba.frs.view.h(getPageContext().getPageActivity());
            this.aPU.changeSkinType(this.mSkinType);
        }
        this.aPR.addHeaderView(this.aPU.getView());
    }

    private void Me() {
        if ("normal_page".equals(this.aNS) && this.aPS != null) {
            this.aPR.removeHeaderView(this.aPS.getView());
        } else if ("frs_page".equals(this.aNS) && this.aPT != null) {
            this.aPR.removeHeaderView(this.aPT.getView());
        } else if ("good_page".equals(this.aNS) && this.aPU != null) {
            this.aPR.removeHeaderView(this.aPU.getView());
        }
    }

    public void cf(boolean z) {
        if (z) {
            if (Mb() != null) {
                Mb().ME();
            }
            if (Mc() != null) {
                Mc().ME();
                return;
            }
            return;
        }
        if (Mb() != null) {
            Mb().MD();
        }
        if (Mc() != null) {
            Mc().MD();
        }
    }

    private void Mf() {
        if (this.aPZ == null) {
            this.aPZ = new c(this);
        }
        this.aPF.mHandler.postDelayed(this.aPZ, 4000L);
    }

    public void c(w wVar) {
        if (wVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(wVar.aas(), wVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(wVar.aas(), wVar);
            }
        }
    }

    public void a(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aPT != null) {
                this.aPT.c(forumData, wVar);
                this.aPT.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.aPT.fp(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aPT.ch(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aPS != null) {
                this.aPS.c(forumData, wVar);
                this.aPS.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aPS.ch(false);
                        return;
                    }
                    this.aPS.ch(true);
                    this.aPS.fp(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aPX = forumData.getLevelupScore();
        this.aPY = forumData.getCurScore();
        if (this.aPX > 0) {
            return this.aPY / this.aPX;
        }
        return 0.0f;
    }

    public void Mg() {
        if (this.aPT != null) {
            this.aPT.Mg();
        }
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.l> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Md();
        if (arrayList != null) {
            if (this.aPV == null) {
                this.aPV = new aw(getPageContext().getPageActivity(), arrayList);
                this.aPU.a(this.aPV);
                this.aPU.b(onItemClickListener);
                return;
            }
            this.aPV.setData(arrayList);
            this.aPV.notifyDataSetChanged();
        }
    }

    public void eW(int i) {
        if (this.aPV != null) {
            this.aPV.eW(i);
        }
    }

    public void fh(int i) {
        if (i > 1) {
            if (this.aPS != null) {
                this.aPS.setIsFirstPage(false);
            }
            if (this.aPT != null) {
                this.aPT.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.aPS != null) {
            this.aPS.setIsFirstPage(true);
        }
        if (this.aPT != null) {
            this.aPT.setIsFirstPage(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            Mj();
        } else if ("normal_page".equals(this.mPageType)) {
            Mi();
        }
    }

    public void setIsMem(int i) {
        if (this.aPS != null) {
            this.aPS.fq(i);
        }
        if (this.aPT != null) {
            this.aPT.fq(i);
        }
    }

    public void Mh() {
        if ("normal_page".equals(this.aNS)) {
            if (this.aPS != null) {
                this.aPS.Mh();
            }
        } else if ("frs_page".equals(this.aNS) && this.aPT != null) {
            this.aPT.Mh();
        }
    }

    public void Mi() {
        if (this.aPS != null) {
            this.aPS.MH();
        }
    }

    public void Mj() {
        if (this.aPT != null) {
            this.aPT.MH();
        }
    }

    public void a(w wVar, boolean z) {
        if (wVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, wVar.aas(), wVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, wVar.aas(), wVar, z);
            }
        }
    }

    public void Mk() {
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
        if (this.aPS != null) {
            this.aPS.fo(i);
        }
    }

    public void fk(int i) {
        if (this.aPT != null) {
            this.aPT.fo(i);
        }
    }

    public void a(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aPS != null) {
            this.aPS.c(forumData, wVar);
            if (forumData != null) {
                this.aPS.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aPS.ch(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aPT != null) {
            this.aPT.c(forumData, wVar);
            float a = a(forumData);
            if (forumData != null) {
                this.aPT.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aPT.ch(false);
                }
            }
        }
    }

    public boolean Ml() {
        if ("normal_page".equals(this.aNS) && this.aPS != null) {
            return this.aPS.MA();
        }
        if ("frs_page".equals(this.aNS) && this.aPT != null) {
            return this.aPT.MA();
        }
        return false;
    }

    public void Mm() {
        if ("normal_page".equals(this.mPageType)) {
            Mo();
        } else if ("frs_page".equals(this.mPageType)) {
            Mq();
        }
    }

    public void Mn() {
        if ("normal_page".equals(this.mPageType)) {
            Mp();
        } else if ("frs_page".equals(this.mPageType)) {
            Mr();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aPX - this.aPY) {
                z = true;
                this.aPX = signData.getLevelUpScore();
            }
            this.aPY = bonusPoint + this.aPY;
            if (this.aPY > this.aPX) {
                this.aPY = this.aPX;
            }
            if (this.aPX != 0) {
                f = this.aPY / this.aPX;
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
        if (wVar != null && wVar.aas() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(wVar.aas().getSignData(), wVar.aas(), wVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(wVar.aas().getSignData(), wVar.aas(), wVar);
            }
        }
    }

    public void fm(int i) {
        if (this.aPS != null) {
            this.aPS.fp(i);
        }
    }

    public void a(SignData signData, ForumData forumData, w wVar) {
        if (this.aPS != null && signData != null && forumData != null && wVar != null) {
            this.aPS.c(forumData, wVar);
            this.aPS.fp(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aPS.MA()) {
                a(this.aPS, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aPY);
                    forumData.setLevelupScore(this.aPX);
                }
                this.aPS.c(forumData, wVar);
                this.aPS.c(this.aPS.MF(), true);
            }
        }
    }

    public void fn(int i) {
        if (this.aPT != null) {
            this.aPT.fp(i);
        }
    }

    public void b(SignData signData, ForumData forumData, w wVar) {
        if (this.aPT != null && signData != null && forumData != null && wVar != null) {
            this.aPT.c(forumData, wVar);
            this.aPT.fp(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aPT.MA()) {
                a(this.aPT, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aPY);
                    forumData.setLevelupScore(this.aPX);
                }
                this.aPT.c(forumData, wVar);
                this.aPT.c(this.aPT.MF(), true);
            }
        }
    }

    public void Mo() {
        if (this.aPS != null) {
            this.aPS.MG().setVisibility(0);
        }
    }

    public void Mp() {
        if (this.aPS != null) {
            this.aPS.MG().setVisibility(8);
        }
    }

    public void Mq() {
        if (this.aPT != null) {
            this.aPT.MG().setVisibility(0);
        }
    }

    public void Mr() {
        if (this.aPT != null) {
            this.aPT.MG().setVisibility(8);
        }
    }

    public boolean Ms() {
        if ("normal_page".equals(this.aNS) && this.aPS != null) {
            return this.aPS.Ms();
        }
        if ("frs_page".equals(this.aNS) && this.aPT != null) {
            return this.aPT.Ms();
        }
        return false;
    }

    public void x(View view) {
        if (this.aPS != null) {
            this.aPS.c(view, false);
        }
    }

    public void y(View view) {
        if (this.aPT != null) {
            this.aPT.c(view, false);
        }
    }

    public boolean Mt() {
        if ("normal_page".equals(this.aNS)) {
            if (this.aPS != null) {
                return this.aPS.Mt();
            }
        } else if ("frs_page".equals(this.aNS) && this.aPT != null) {
            return this.aPT.Mt();
        }
        return false;
    }

    public BarImageView Mu() {
        o Mc;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView Mb = Mb();
            if (Mb != null) {
                return Mb.Mu();
            }
        } else if ("frs_page".equals(this.mPageType) && (Mc = Mc()) != null) {
            return Mc.Mu();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oF() {
        if (this.aPF != null) {
            w KF = this.aPF.KF();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.aPF.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.login_to_use), true, 11002)));
            } else if (KF != null && KF.aas() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.aPF.getFrom())) {
                    this.LI.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                } else {
                    this.LI.setFrom(PbActivityConfig.KEY_FROM_FRS);
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.aPF.getFrom())) {
                    TiebaStatic.eventStat(this.aPF.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LI.ba(KF.aas().getName(), KF.aas().getId());
            }
        }
    }

    public void KL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.aPF.KF() != null && this.aPF.KF().aas() != null && this.aPF.KF().aas().getName() != null) {
            str = this.aPF.KF().aas().getName();
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
    public void Mv() {
        w KF = this.aPF.KF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.aPF.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.login_to_use), true, 11014)));
        } else if (KF != null && KF.aas() != null) {
            Mm();
            this.aQc.au(KF.aas().getName(), KF.aas().getId());
        }
    }

    private void oE() {
        this.LI = new af(getPageContext());
        this.LI.setLoadDataCallBack(new f(this));
    }

    private void Mw() {
        this.aQb = new ax();
        this.aQb.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aQb.a(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new h(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Mx() {
        this.aQc = new cl(this.aPF);
        this.aQc.setLoadDataCallBack(new i(this));
    }

    public void b(NavigationBar navigationBar) {
        if (TbadkCoreApplication.m411getInst().isFirstGoFrs()) {
            TbadkCoreApplication.m411getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(navigationBar).M(0).v(false);
            gVar.a(new j(this));
            this.aPW = gVar.gG();
            this.aPW.i(getPageContext().getPageActivity());
        }
    }
}

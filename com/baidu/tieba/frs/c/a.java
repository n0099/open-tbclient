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
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ax;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.i.a {
    private com.baidu.adp.lib.guide.d aNJ;
    private int aNK;
    private int aNL;
    private Runnable aNM;
    private FrsActivity aNs;
    private int mIsLike;
    private BdListView aNE = null;
    private FrsHeaderView aNF = null;
    private com.baidu.tieba.frs.view.o aNG = null;
    private com.baidu.tieba.frs.view.h aNH = null;
    private aw aNI = null;
    private int mScrollState = 0;
    private int mSkinType = 0;
    private String mPageType = "normal_page";
    private String aLH = null;
    private boolean aNN = false;
    private af LQ = null;
    private ax aNO = null;
    private cm aNP = null;
    private final View.OnClickListener aLK = new b(this);

    public a(FrsActivity frsActivity) {
        this.aNs = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        oo();
        Lq();
        Lr();
        this.aNN = TbadkSettings.getInst().loadBoolean(FrsActivity.aIN, false);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.aNF != null) {
            this.aNF.onDestory();
        }
        if (this.aNG != null) {
            this.aNG.onDestory();
        }
        if (this.LQ != null) {
            this.LQ.KK();
        }
        if (this.aNP != null) {
            this.aNP.KK();
        }
        if (this.aNM != null) {
            this.aNs.mHandler.removeCallbacks(this.aNM);
        }
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void ot() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void os() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return 0;
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.adp.base.g
    public TbPageContext<?> getPageContext() {
        return this.aNs.getPageContext();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public LayoutInflater getLayoutInflater() {
        return this.aNs.getLayoutInflater();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.aNG != null) {
            this.aNG.changeSkinType(i);
        }
        if (this.aNI != null) {
            this.aNI.notifyDataSetChanged();
        }
        if (this.aNH != null) {
            this.aNH.changeSkinType(i);
        }
        if (this.aNF != null) {
            this.aNF.changeSkinType(i);
        }
        return super.a(tbPageContext, i);
    }

    public FrsHeaderView KV() {
        return this.aNF;
    }

    public com.baidu.tieba.frs.view.o KW() {
        return this.aNG;
    }

    public void v(BdListView bdListView) {
        this.aNE = bdListView;
    }

    public void f(boolean z, int i, int i2) {
        if (z) {
            this.mPageType = "frs_page";
            N(i, i2);
            return;
        }
        this.mPageType = "normal_page";
        M(i, i2);
    }

    public void a(String str, w wVar) {
        this.mPageType = str;
        if ("frs_page".equals(str)) {
            if (wVar != null && wVar.getUserData() != null && wVar.Za() != null) {
                N(wVar.getUserData().getIsMem(), wVar.Za().isLike());
            }
        } else if ("normal_page".equals(str)) {
            if (wVar != null && wVar.getUserData() != null && wVar.Za() != null) {
                M(wVar.getUserData().getIsMem(), wVar.Za().isLike());
            }
        } else if ("good_page".equals(str) && wVar != null && wVar.Za() != null) {
            a(wVar.Za().getGood_classify(), this.aNs.aJG);
        }
    }

    public void M(int i, int i2) {
        this.mIsLike = i2;
        KY();
        this.aLH = "normal_page";
        if (this.aNF == null) {
            this.aNF = new FrsHeaderView(this.aNs, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aNF.changeSkinType(this.mSkinType);
            this.aNF.n(this.aLK);
        }
        this.aNE.addHeaderView(this.aNF.getView());
        KZ();
    }

    public void N(int i, int i2) {
        this.mIsLike = i2;
        KY();
        this.aLH = "frs_page";
        eS(i);
        this.aNE.addHeaderView(this.aNG.getView());
        KZ();
    }

    public void eS(int i) {
        if (this.aNG == null) {
            this.aNG = new com.baidu.tieba.frs.view.o(this.aNs.getPageContext(), null, null, i);
            this.aNG.changeSkinType(this.mSkinType);
            this.aNG.setBannerViewClickListener(this.aNs.JF());
            this.aNG.n(this.aLK);
        }
    }

    public void KX() {
        KY();
        this.aLH = "good_page";
        if (this.aNH == null) {
            this.aNH = new com.baidu.tieba.frs.view.h(getPageContext().getPageActivity());
            this.aNH.changeSkinType(this.mSkinType);
        }
        this.aNE.addHeaderView(this.aNH.getView());
    }

    private void KY() {
        if ("normal_page".equals(this.aLH) && this.aNF != null) {
            this.aNE.removeHeaderView(this.aNF.getView());
        } else if ("frs_page".equals(this.aLH) && this.aNG != null) {
            this.aNE.removeHeaderView(this.aNG.getView());
        } else if ("good_page".equals(this.aLH) && this.aNH != null) {
            this.aNE.removeHeaderView(this.aNH.getView());
        }
    }

    public void bW(boolean z) {
        if (z) {
            if (KV() != null) {
                KV().Ly();
            }
            if (KW() != null) {
                KW().Ly();
                return;
            }
            return;
        }
        if (KV() != null) {
            KV().Lx();
        }
        if (KW() != null) {
            KW().Lx();
        }
    }

    private void KZ() {
        if (this.aNM == null) {
            this.aNM = new c(this);
        }
        this.aNs.mHandler.postDelayed(this.aNM, 4000L);
    }

    public void c(w wVar) {
        if (wVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(wVar.Za(), wVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(wVar.Za(), wVar);
            }
        }
    }

    public void a(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aNG != null) {
                this.aNG.c(forumData, wVar);
                this.aNG.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.aNG.fb(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aNG.bY(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aNF != null) {
                this.aNF.c(forumData, wVar);
                this.aNF.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aNF.bY(false);
                        return;
                    }
                    this.aNF.bY(true);
                    this.aNF.fb(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aNK = forumData.getLevelupScore();
        this.aNL = forumData.getCurScore();
        if (this.aNK > 0) {
            return this.aNL / this.aNK;
        }
        return 0.0f;
    }

    public void La() {
        if (this.aNG != null) {
            this.aNG.La();
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.l> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        KX();
        if (arrayList != null) {
            if (this.aNI == null) {
                this.aNI = new aw(getPageContext().getPageActivity(), arrayList);
                this.aNH.a(this.aNI);
                this.aNH.b(onItemClickListener);
                return;
            }
            this.aNI.p(arrayList);
            this.aNI.notifyDataSetChanged();
        }
    }

    public void eI(int i) {
        if (this.aNI != null) {
            this.aNI.eI(i);
        }
    }

    public void eT(int i) {
        if (i > 1) {
            if (this.aNF != null) {
                this.aNF.bZ(false);
            }
            if (this.aNG != null) {
                this.aNG.bZ(false);
                return;
            }
            return;
        }
        if (this.aNF != null) {
            this.aNF.bZ(true);
        }
        if (this.aNG != null) {
            this.aNG.bZ(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            Ld();
        } else if ("normal_page".equals(this.mPageType)) {
            Lc();
        }
    }

    public void setIsMem(int i) {
        if (this.aNF != null) {
            this.aNF.fc(i);
        }
        if (this.aNG != null) {
            this.aNG.fc(i);
        }
    }

    public void Lb() {
        if ("normal_page".equals(this.aLH)) {
            if (this.aNF != null) {
                this.aNF.Lb();
            }
        } else if ("frs_page".equals(this.aLH) && this.aNG != null) {
            this.aNG.Lb();
        }
    }

    public void Lc() {
        if (this.aNF != null) {
            this.aNF.LB();
        }
    }

    public void Ld() {
        if (this.aNG != null) {
            this.aNG.LB();
        }
    }

    public void a(w wVar, boolean z) {
        if (wVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, wVar.Za(), wVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, wVar.Za(), wVar, z);
            }
        }
    }

    public void Le() {
        if ("normal_page".equals(this.mPageType)) {
            eV(0);
        } else if ("frs_page".equals(this.mPageType)) {
            eW(0);
        }
    }

    public void eU(int i) {
        if ("normal_page".equals(this.mPageType)) {
            eV(i);
        } else if ("frs_page".equals(this.mPageType)) {
            eW(i);
        }
    }

    public void eV(int i) {
        if (this.aNF != null) {
            this.aNF.fa(i);
        }
    }

    public void eW(int i) {
        if (this.aNG != null) {
            this.aNG.fa(i);
        }
    }

    public void a(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aNF != null) {
            this.aNF.c(forumData, wVar);
            if (forumData != null) {
                this.aNF.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aNF.bY(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aNG != null) {
            this.aNG.c(forumData, wVar);
            float a = a(forumData);
            if (forumData != null) {
                this.aNG.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aNG.bY(false);
                }
            }
        }
    }

    public boolean Lf() {
        if ("normal_page".equals(this.aLH) && this.aNF != null) {
            return this.aNF.Lu();
        }
        if ("frs_page".equals(this.aLH) && this.aNG != null) {
            return this.aNG.Lu();
        }
        return false;
    }

    public void Lg() {
        if ("normal_page".equals(this.mPageType)) {
            Li();
        } else if ("frs_page".equals(this.mPageType)) {
            Lk();
        }
    }

    public void Lh() {
        if ("normal_page".equals(this.mPageType)) {
            Lj();
        } else if ("frs_page".equals(this.mPageType)) {
            Ll();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aNK - this.aNL) {
                z = true;
                this.aNK = signData.getLevelUpScore();
            }
            this.aNL = bonusPoint + this.aNL;
            if (this.aNL > this.aNK) {
                this.aNL = this.aNK;
            }
            if (this.aNK != 0) {
                f = this.aNL / this.aNK;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void eX(int i) {
        if ("normal_page".equals(this.mPageType)) {
            eY(i);
        } else if ("frs_page".equals(this.mPageType)) {
            eZ(i);
        }
    }

    public void d(w wVar) {
        if (wVar != null && wVar.Za() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(wVar.Za().getSignData(), wVar.Za(), wVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(wVar.Za().getSignData(), wVar.Za(), wVar);
            }
        }
    }

    public void eY(int i) {
        if (this.aNF != null) {
            this.aNF.fb(i);
        }
    }

    public void a(SignData signData, ForumData forumData, w wVar) {
        if (this.aNF != null && signData != null && forumData != null && wVar != null) {
            this.aNF.c(forumData, wVar);
            this.aNF.fb(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aNF.Lu()) {
                a(this.aNF, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aNL);
                    forumData.setLevelupScore(this.aNK);
                }
                this.aNF.c(forumData, wVar);
                this.aNF.c(this.aNF.Lz(), true);
            }
        }
    }

    public void eZ(int i) {
        if (this.aNG != null) {
            this.aNG.fb(i);
        }
    }

    public void b(SignData signData, ForumData forumData, w wVar) {
        if (this.aNG != null && signData != null && forumData != null && wVar != null) {
            this.aNG.c(forumData, wVar);
            this.aNG.fb(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aNG.Lu()) {
                a(this.aNG, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aNL);
                    forumData.setLevelupScore(this.aNK);
                }
                this.aNG.c(forumData, wVar);
                this.aNG.c(this.aNG.Lz(), true);
            }
        }
    }

    public void Li() {
        if (this.aNF != null) {
            this.aNF.LA().setVisibility(0);
        }
    }

    public void Lj() {
        if (this.aNF != null) {
            this.aNF.LA().setVisibility(8);
        }
    }

    public void Lk() {
        if (this.aNG != null) {
            this.aNG.LA().setVisibility(0);
        }
    }

    public void Ll() {
        if (this.aNG != null) {
            this.aNG.LA().setVisibility(8);
        }
    }

    public boolean Lm() {
        if ("normal_page".equals(this.aLH) && this.aNF != null) {
            return this.aNF.Lm();
        }
        if ("frs_page".equals(this.aLH) && this.aNG != null) {
            return this.aNG.Lm();
        }
        return false;
    }

    public void u(View view) {
        if (this.aNF != null) {
            this.aNF.c(view, false);
        }
    }

    public void v(View view) {
        if (this.aNG != null) {
            this.aNG.c(view, false);
        }
    }

    public boolean Ln() {
        if ("normal_page".equals(this.aLH)) {
            if (this.aNF != null) {
                return this.aNF.Ln();
            }
        } else if ("frs_page".equals(this.aLH) && this.aNG != null) {
            return this.aNG.Ln();
        }
        return false;
    }

    public BarImageView Lo() {
        com.baidu.tieba.frs.view.o KW;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView KV = KV();
            if (KV != null) {
                return KV.Lo();
            }
        } else if ("frs_page".equals(this.mPageType) && (KW = KW()) != null) {
            return KW.Lo();
        }
        return null;
    }

    public void op() {
        if (this.aNs != null) {
            w JA = this.aNs.JA();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.aNs.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(y.login_to_use), true, 11002)));
            } else if (JA != null && JA.Za() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.aNs.getFrom())) {
                    this.LQ.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                } else {
                    this.LQ.setFrom(PbActivityConfig.KEY_FROM_FRS);
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.aNs.getFrom())) {
                    TiebaStatic.eventStat(this.aNs.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LQ.aV(JA.Za().getName(), JA.Za().getId());
            }
        }
    }

    public void JG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.aNs.JA() != null && this.aNs.JA().Za() != null && this.aNs.JA().Za().getName() != null) {
            str = this.aNs.JA().Za().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.ca(String.format(getPageContext().getString(y.attention_cancel_dialog_content), str));
        } else {
            aVar.ca(getPageContext().getString(y.attention_cancel_dialog_content_default));
        }
        aVar.bZ(getPageContext().getString(y.alert_title));
        aVar.a(getPageContext().getString(y.editor_dialog_yes), new d(this));
        aVar.b(getPageContext().getString(y.editor_dialog_no), new e(this));
        aVar.b(getPageContext()).re();
    }

    public void Lp() {
        w JA = this.aNs.JA();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.aNs.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(y.login_to_use), true, 11014)));
        } else if (JA != null && JA.Za() != null) {
            Lg();
            this.aNP.ap(JA.Za().getName(), JA.Za().getId());
        }
    }

    private void oo() {
        this.LQ = new af(getPageContext());
        this.LQ.setLoadDataCallBack(new f(this));
    }

    private void Lq() {
        this.aNO = new ax();
        this.aNO.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aNO.a(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new h(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Lr() {
        this.aNP = new cm(this.aNs);
        this.aNP.setLoadDataCallBack(new i(this));
    }

    public void b(NavigationBar navigationBar) {
        if (TbadkCoreApplication.m411getInst().isFirstGoFrs()) {
            TbadkCoreApplication.m411getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(navigationBar).O(0).v(false);
            gVar.a(new j(this));
            this.aNJ = gVar.gV();
            this.aNJ.i(getPageContext().getPageActivity());
        }
    }
}

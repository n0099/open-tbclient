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
    private FrsActivity aNb;
    private com.baidu.adp.lib.guide.d aNs;
    private int aNt;
    private int aNu;
    private Runnable aNv;
    private int mIsLike;
    private BdListView aNn = null;
    private FrsHeaderView aNo = null;
    private com.baidu.tieba.frs.view.o aNp = null;
    private com.baidu.tieba.frs.view.h aNq = null;
    private aw aNr = null;
    private int mScrollState = 0;
    private int mSkinType = 0;
    private String mPageType = "normal_page";
    private String aLx = null;
    private boolean aNw = false;
    private af LO = null;
    private ax aNx = null;
    private cm aNy = null;
    private final View.OnClickListener aLA = new b(this);

    public a(FrsActivity frsActivity) {
        this.aNb = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        oo();
        Le();
        Lf();
        this.aNw = TbadkSettings.getInst().loadBoolean(FrsActivity.aIF, false);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.aNo != null) {
            this.aNo.onDestory();
        }
        if (this.aNp != null) {
            this.aNp.onDestory();
        }
        if (this.LO != null) {
            this.LO.KA();
        }
        if (this.aNy != null) {
            this.aNy.KA();
        }
        if (this.aNv != null) {
            this.aNb.mHandler.removeCallbacks(this.aNv);
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
        return this.aNb.getPageContext();
    }

    @Override // com.baidu.tbadk.mvc.core.c
    public LayoutInflater getLayoutInflater() {
        return this.aNb.getLayoutInflater();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.aNp != null) {
            this.aNp.changeSkinType(i);
        }
        if (this.aNr != null) {
            this.aNr.notifyDataSetChanged();
        }
        if (this.aNq != null) {
            this.aNq.changeSkinType(i);
        }
        if (this.aNo != null) {
            this.aNo.changeSkinType(i);
        }
        return super.a(tbPageContext, i);
    }

    public FrsHeaderView KJ() {
        return this.aNo;
    }

    public com.baidu.tieba.frs.view.o KK() {
        return this.aNp;
    }

    public void v(BdListView bdListView) {
        this.aNn = bdListView;
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
            if (wVar != null && wVar.getUserData() != null && wVar.YO() != null) {
                N(wVar.getUserData().getIsMem(), wVar.YO().isLike());
            }
        } else if ("normal_page".equals(str)) {
            if (wVar != null && wVar.getUserData() != null && wVar.YO() != null) {
                M(wVar.getUserData().getIsMem(), wVar.YO().isLike());
            }
        } else if ("good_page".equals(str) && wVar != null && wVar.YO() != null) {
            a(wVar.YO().getGood_classify(), this.aNb.aJw);
        }
    }

    public void M(int i, int i2) {
        this.mIsLike = i2;
        KM();
        this.aLx = "normal_page";
        if (this.aNo == null) {
            this.aNo = new FrsHeaderView(this.aNb, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aNo.changeSkinType(this.mSkinType);
            this.aNo.n(this.aLA);
        }
        this.aNn.addHeaderView(this.aNo.getView());
        KN();
    }

    public void N(int i, int i2) {
        this.mIsLike = i2;
        KM();
        this.aLx = "frs_page";
        eR(i);
        this.aNn.addHeaderView(this.aNp.getView());
        KN();
    }

    public void eR(int i) {
        if (this.aNp == null) {
            this.aNp = new com.baidu.tieba.frs.view.o(this.aNb.getPageContext(), null, null, i);
            this.aNp.changeSkinType(this.mSkinType);
            this.aNp.setBannerViewClickListener(this.aNb.Jz());
            this.aNp.n(this.aLA);
        }
    }

    public void KL() {
        KM();
        this.aLx = "good_page";
        if (this.aNq == null) {
            this.aNq = new com.baidu.tieba.frs.view.h(getPageContext().getPageActivity());
            this.aNq.changeSkinType(this.mSkinType);
        }
        this.aNn.addHeaderView(this.aNq.getView());
    }

    private void KM() {
        if ("normal_page".equals(this.aLx) && this.aNo != null) {
            this.aNn.removeHeaderView(this.aNo.getView());
        } else if ("frs_page".equals(this.aLx) && this.aNp != null) {
            this.aNn.removeHeaderView(this.aNp.getView());
        } else if ("good_page".equals(this.aLx) && this.aNq != null) {
            this.aNn.removeHeaderView(this.aNq.getView());
        }
    }

    public void bY(boolean z) {
        if (z) {
            if (KJ() != null) {
                KJ().Lm();
            }
            if (KK() != null) {
                KK().Lm();
                return;
            }
            return;
        }
        if (KJ() != null) {
            KJ().Ll();
        }
        if (KK() != null) {
            KK().Ll();
        }
    }

    private void KN() {
        if (this.aNv == null) {
            this.aNv = new c(this);
        }
        this.aNb.mHandler.postDelayed(this.aNv, 4000L);
    }

    public void c(w wVar) {
        if (wVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(wVar.YO(), wVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(wVar.YO(), wVar);
            }
        }
    }

    public void a(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aNp != null) {
                this.aNp.c(forumData, wVar);
                this.aNp.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.aNp.fa(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aNp.ca(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, w wVar) {
        if (forumData != null && wVar != null) {
            float a = a(forumData);
            if (this.aNo != null) {
                this.aNo.c(forumData, wVar);
                this.aNo.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.aNo.ca(false);
                        return;
                    }
                    this.aNo.ca(true);
                    this.aNo.fa(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aNt = forumData.getLevelupScore();
        this.aNu = forumData.getCurScore();
        if (this.aNt > 0) {
            return this.aNu / this.aNt;
        }
        return 0.0f;
    }

    public void KO() {
        if (this.aNp != null) {
            this.aNp.KO();
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.l> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        KL();
        if (arrayList != null) {
            if (this.aNr == null) {
                this.aNr = new aw(getPageContext().getPageActivity(), arrayList);
                this.aNq.a(this.aNr);
                this.aNq.b(onItemClickListener);
                return;
            }
            this.aNr.p(arrayList);
            this.aNr.notifyDataSetChanged();
        }
    }

    public void eI(int i) {
        if (this.aNr != null) {
            this.aNr.eI(i);
        }
    }

    public void eS(int i) {
        if (i > 1) {
            if (this.aNo != null) {
                this.aNo.cb(false);
            }
            if (this.aNp != null) {
                this.aNp.cb(false);
                return;
            }
            return;
        }
        if (this.aNo != null) {
            this.aNo.cb(true);
        }
        if (this.aNp != null) {
            this.aNp.cb(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            KR();
        } else if ("normal_page".equals(this.mPageType)) {
            KQ();
        }
    }

    public void setIsMem(int i) {
        if (this.aNo != null) {
            this.aNo.fb(i);
        }
        if (this.aNp != null) {
            this.aNp.fb(i);
        }
    }

    public void KP() {
        if ("normal_page".equals(this.aLx)) {
            if (this.aNo != null) {
                this.aNo.KP();
            }
        } else if ("frs_page".equals(this.aLx) && this.aNp != null) {
            this.aNp.KP();
        }
    }

    public void KQ() {
        if (this.aNo != null) {
            this.aNo.Lp();
        }
    }

    public void KR() {
        if (this.aNp != null) {
            this.aNp.Lp();
        }
    }

    public void a(w wVar, boolean z) {
        if (wVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, wVar.YO(), wVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, wVar.YO(), wVar, z);
            }
        }
    }

    public void KS() {
        if ("normal_page".equals(this.mPageType)) {
            eU(0);
        } else if ("frs_page".equals(this.mPageType)) {
            eV(0);
        }
    }

    public void eT(int i) {
        if ("normal_page".equals(this.mPageType)) {
            eU(i);
        } else if ("frs_page".equals(this.mPageType)) {
            eV(i);
        }
    }

    public void eU(int i) {
        if (this.aNo != null) {
            this.aNo.eZ(i);
        }
    }

    public void eV(int i) {
        if (this.aNp != null) {
            this.aNp.eZ(i);
        }
    }

    public void a(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aNo != null) {
            this.aNo.c(forumData, wVar);
            if (forumData != null) {
                this.aNo.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aNo.ca(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, w wVar, boolean z) {
        if (this.aNp != null) {
            this.aNp.c(forumData, wVar);
            float a = a(forumData);
            if (forumData != null) {
                this.aNp.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.aNp.ca(false);
                }
            }
        }
    }

    public boolean KT() {
        if ("normal_page".equals(this.aLx) && this.aNo != null) {
            return this.aNo.Li();
        }
        if ("frs_page".equals(this.aLx) && this.aNp != null) {
            return this.aNp.Li();
        }
        return false;
    }

    public void KU() {
        if ("normal_page".equals(this.mPageType)) {
            KW();
        } else if ("frs_page".equals(this.mPageType)) {
            KY();
        }
    }

    public void KV() {
        if ("normal_page".equals(this.mPageType)) {
            KX();
        } else if ("frs_page".equals(this.mPageType)) {
            KZ();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aNt - this.aNu) {
                z = true;
                this.aNt = signData.getLevelUpScore();
            }
            this.aNu = bonusPoint + this.aNu;
            if (this.aNu > this.aNt) {
                this.aNu = this.aNt;
            }
            if (this.aNt != 0) {
                f = this.aNu / this.aNt;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void eW(int i) {
        if ("normal_page".equals(this.mPageType)) {
            eX(i);
        } else if ("frs_page".equals(this.mPageType)) {
            eY(i);
        }
    }

    public void d(w wVar) {
        if (wVar != null && wVar.YO() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(wVar.YO().getSignData(), wVar.YO(), wVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(wVar.YO().getSignData(), wVar.YO(), wVar);
            }
        }
    }

    public void eX(int i) {
        if (this.aNo != null) {
            this.aNo.fa(i);
        }
    }

    public void a(SignData signData, ForumData forumData, w wVar) {
        if (this.aNo != null && signData != null && forumData != null && wVar != null) {
            this.aNo.c(forumData, wVar);
            this.aNo.fa(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aNo.Li()) {
                a(this.aNo, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aNu);
                    forumData.setLevelupScore(this.aNt);
                }
                this.aNo.c(forumData, wVar);
                this.aNo.c(this.aNo.Ln(), true);
            }
        }
    }

    public void eY(int i) {
        if (this.aNp != null) {
            this.aNp.fa(i);
        }
    }

    public void b(SignData signData, ForumData forumData, w wVar) {
        if (this.aNp != null && signData != null && forumData != null && wVar != null) {
            this.aNp.c(forumData, wVar);
            this.aNp.fa(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aNp.Li()) {
                a(this.aNp, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aNu);
                    forumData.setLevelupScore(this.aNt);
                }
                this.aNp.c(forumData, wVar);
                this.aNp.c(this.aNp.Ln(), true);
            }
        }
    }

    public void KW() {
        if (this.aNo != null) {
            this.aNo.Lo().setVisibility(0);
        }
    }

    public void KX() {
        if (this.aNo != null) {
            this.aNo.Lo().setVisibility(8);
        }
    }

    public void KY() {
        if (this.aNp != null) {
            this.aNp.Lo().setVisibility(0);
        }
    }

    public void KZ() {
        if (this.aNp != null) {
            this.aNp.Lo().setVisibility(8);
        }
    }

    public boolean La() {
        if ("normal_page".equals(this.aLx) && this.aNo != null) {
            return this.aNo.La();
        }
        if ("frs_page".equals(this.aLx) && this.aNp != null) {
            return this.aNp.La();
        }
        return false;
    }

    public void u(View view) {
        if (this.aNo != null) {
            this.aNo.c(view, false);
        }
    }

    public void v(View view) {
        if (this.aNp != null) {
            this.aNp.c(view, false);
        }
    }

    public boolean Lb() {
        if ("normal_page".equals(this.aLx)) {
            if (this.aNo != null) {
                return this.aNo.Lb();
            }
        } else if ("frs_page".equals(this.aLx) && this.aNp != null) {
            return this.aNp.Lb();
        }
        return false;
    }

    public BarImageView Lc() {
        com.baidu.tieba.frs.view.o KK;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView KJ = KJ();
            if (KJ != null) {
                return KJ.Lc();
            }
        } else if ("frs_page".equals(this.mPageType) && (KK = KK()) != null) {
            return KK.Lc();
        }
        return null;
    }

    public void op() {
        if (this.aNb != null) {
            w Ju = this.aNb.Ju();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.aNb.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(y.login_to_use), true, 11002)));
            } else if (Ju != null && Ju.YO() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.aNb.getFrom())) {
                    this.LO.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                } else {
                    this.LO.setFrom(PbActivityConfig.KEY_FROM_FRS);
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.aNb.getFrom())) {
                    TiebaStatic.eventStat(this.aNb.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LO.aV(Ju.YO().getName(), Ju.YO().getId());
            }
        }
    }

    public void JA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.aNb.Ju() != null && this.aNb.Ju().YO() != null && this.aNb.Ju().YO().getName() != null) {
            str = this.aNb.Ju().YO().getName();
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

    public void Ld() {
        w Ju = this.aNb.Ju();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.aNb.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(y.login_to_use), true, 11014)));
        } else if (Ju != null && Ju.YO() != null) {
            KU();
            this.aNy.ap(Ju.YO().getName(), Ju.YO().getId());
        }
    }

    private void oo() {
        this.LO = new af(getPageContext());
        this.LO.setLoadDataCallBack(new f(this));
    }

    private void Le() {
        this.aNx = new ax();
        this.aNx.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aNx.a(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new h(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Lf() {
        this.aNy = new cm(this.aNb);
        this.aNy.setLoadDataCallBack(new i(this));
    }

    public void b(NavigationBar navigationBar) {
        if (TbadkCoreApplication.m411getInst().isFirstGoFrs()) {
            TbadkCoreApplication.m411getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(navigationBar).O(0).v(false);
            gVar.a(new j(this));
            this.aNs = gVar.gV();
            this.aNs.i(getPageContext().getPageActivity());
        }
    }
}

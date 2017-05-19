package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.o;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class b extends FrameLayout {
    private BdTypeListView aPZ;
    private PbListView aSj;
    private com.baidu.tbadk.i.f aSk;
    private View bPM;
    private final CustomMessageListener bPk;
    private List<com.baidu.tieba.homepage.b.a.a> ctV;
    private o.a cuA;
    private View.OnClickListener cuB;
    private com.baidu.tieba.homepage.personalize.b.ad cus;
    private com.baidu.tieba.homepage.framework.b cut;
    private o cuu;
    private com.baidu.tieba.homepage.personalize.model.f cuv;
    private ScrollFragmentTabHost cuw;
    private boolean cux;
    private boolean cuy;
    private o.a cuz;
    private com.baidu.tbadk.core.view.ah mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.i.h refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cuu != null) {
            this.cuw = scrollFragmentTabHost;
            this.cuu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aPZ != null) {
            this.aPZ.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cus != null) {
            this.cus.setPageUniqueId(bdUniqueId);
        }
        if (this.cuu != null) {
            this.cuu.j(bdUniqueId);
        }
        if (this.cuv != null) {
            this.cuv.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bPk != null) {
            this.bPk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bPk);
        }
    }

    public b(Context context) {
        super(context);
        this.cux = false;
        this.cuz = new c(this);
        this.cuA = new e(this);
        this.bPk = new f(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cuB = new h(this);
        init(context);
    }

    private void init(Context context) {
        this.aPZ = new BdTypeListView(context);
        this.aPZ.setDividerHeight(0);
        this.aPZ.setSelector(17170445);
        this.aSj = new PbListView(context);
        this.aSj.le();
        this.aSj.dh(w.e.cp_bg_line_c);
        this.aSj.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aSj.di(TbadkCoreApplication.m9getInst().getSkinType());
        this.aSj.setOnClickListener(this.cuB);
        this.aPZ.setNextPage(this.aSj);
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.pageContext);
        this.aPZ.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.bPM = BdListViewHelper.a(context, this.aPZ, BdListViewHelper.HeadType.DEFAULT);
        this.cuv = new com.baidu.tieba.homepage.personalize.model.f();
        this.cus = new com.baidu.tieba.homepage.personalize.b.ad(context, this.aPZ);
        this.cus.b(this.cuv);
        this.cuu = new o(this.pageContext, this.aPZ, this.cus);
        addView(this.aPZ);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void aht() {
        this.cus.a(this.cuz);
        this.cuu.a(this.cuA);
        this.mPullView.a(new i(this));
        this.mPullView.a(new j(this));
        this.aPZ.setOnSrollToBottomListener(new k(this));
        this.mPullView.a(new l(this));
        this.aPZ.setRecyclerListener(new m(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cut = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.aSj != null) {
            this.aSj.wp();
            this.aSj.dj(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cuu.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.bPM != null && this.bPM.getLayoutParams() != null) {
            if (this.cuu != null) {
                this.cuu.setHeaderViewHeight(i);
            }
            this.bPM.getLayoutParams().height = i;
            this.bPM.setLayoutParams(this.bPM.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (this.cuu != null) {
            this.cuu.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    public void Xb() {
        if (this.cuu != null) {
            this.cuu.Xb();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aSk != null) {
            this.aSk.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
        if (this.aSj != null) {
            this.aSj.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aSj.di(i);
        }
        this.cus.onChangeSkinType(i);
        aq.k(this, w.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void M(String str, int i) {
        if (this.aSj != null) {
            this.aSj.wp();
            this.aSj.dj(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cuu.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getContext(), new d(this));
        }
        this.refreshView.eR(getContext().getResources().getDimensionPixelSize(w.f.ds130));
        this.refreshView.fQ(str);
        this.refreshView.c(view, z);
        this.refreshView.Ee();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JR() {
        if (this.refreshView != null) {
            this.refreshView.H(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JQ() {
        if (this.aSk != null) {
            this.aSk.H(this);
            this.aSk = null;
        }
        if (this.cut != null) {
            this.cut.ahc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahu() {
        if (this.refreshView != null) {
            return this.refreshView.DX();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.aSk == null) {
            if (i < 0) {
                this.aSk = new com.baidu.tbadk.i.f(getContext());
            } else {
                this.aSk = new com.baidu.tbadk.i.f(getContext(), i);
            }
            this.aSk.onChangeSkinType();
        }
        this.aSk.c(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cuu != null) {
            this.cuu.setTabInForeBackgroundState(z);
        }
    }

    public void ahv() {
        setViewForeground(false);
        if (this.cuu != null) {
            this.cuu.dQ(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void setViewForeground(boolean z) {
        if (this.cuu != null) {
            this.cuu.eJ(z);
        }
    }

    public void ahj() {
        if (this.cuu != null) {
            this.cuu.update();
        }
    }

    public void reload() {
        if (this.aPZ != null) {
            Xb();
            this.aPZ.setSelection(0);
            if (this.aPZ.isRefreshDone()) {
                if (this.cuu != null && this.cuu.Kq() != null) {
                    this.cuu.Kq().ajv();
                    this.cuu.eM(false);
                }
                this.aPZ.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cuu.onDestroy();
        this.cus.a((o.a) null);
        this.cuu.a((o.a) null);
        this.mPullView.a((ae.b) null);
        this.mPullView.a((ae.c) null);
        this.aPZ.setOnSrollToBottomListener(null);
        this.mPullView.a((ae.a) null);
        this.mPullView.release();
        this.aPZ.setRecyclerListener(null);
    }

    public void onPause() {
        this.cuu.onPause();
    }

    public void onResume() {
        this.cuu.onResume();
    }

    public void agF() {
        if (this.cus != null) {
            this.cus.notifyDataSetChanged();
        }
    }

    public void ahw() {
        if (this.cuu != null) {
            this.cuu.dQ(true);
        }
        ca.To().db(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void ahs() {
        this.cuu.ahK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zs() {
        if (this.aSj != null && !this.aSj.wu()) {
            this.aSj.wo();
            this.aSj.dj(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cuu.Zs();
    }
}

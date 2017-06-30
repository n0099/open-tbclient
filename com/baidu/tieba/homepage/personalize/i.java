package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.x;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class i extends FrameLayout {
    private BdTypeListView aRs;
    private PbListView bbP;
    private com.baidu.tbadk.i.f bdc;
    private List<com.baidu.tieba.homepage.b.a.a> cHZ;
    private com.baidu.tieba.homepage.personalize.b.af cIF;
    private com.baidu.tieba.homepage.framework.b cIG;
    private x cIH;
    private com.baidu.tieba.homepage.personalize.model.f cII;
    private ScrollFragmentTabHost cIJ;
    private boolean cIK;
    private boolean cIL;
    private long cIM;
    private o.a cIN;
    private x.a cIO;
    private View.OnClickListener cIP;
    private boolean ccO;
    private View cdM;
    private final CustomMessageListener cdh;
    private CustomMessageListener cdk;
    private com.baidu.tbadk.core.view.ah mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.i.h refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cIH != null) {
            this.cIJ = scrollFragmentTabHost;
            this.cIH.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aRs != null) {
            this.aRs.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cIF != null) {
            this.cIF.setPageUniqueId(bdUniqueId);
        }
        if (this.cIH != null) {
            this.cIH.j(bdUniqueId);
        }
        if (this.cII != null) {
            this.cII.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cdh != null) {
            this.cdh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cdh);
        }
    }

    public i(Context context) {
        super(context);
        this.cIK = false;
        this.cIM = 0L;
        this.ccO = false;
        this.cIN = new j(this);
        this.cIO = new n(this);
        this.cdh = new o(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cIP = new q(this);
        this.cdk = new r(this, CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED);
        init(context);
    }

    private void init(Context context) {
        this.aRs = new BdTypeListView(context);
        this.aRs.setDividerHeight(0);
        this.aRs.setSelector(17170445);
        this.bbP = new PbListView(context);
        this.bbP.lc();
        this.bbP.dk(w.e.cp_bg_line_c);
        this.bbP.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_d));
        this.bbP.dl(TbadkCoreApplication.m9getInst().getSkinType());
        this.bbP.setOnClickListener(this.cIP);
        this.aRs.setNextPage(this.bbP);
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.pageContext);
        this.aRs.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.cdM = BdListViewHelper.a(context, this.aRs, BdListViewHelper.HeadType.DEFAULT);
        this.cII = new com.baidu.tieba.homepage.personalize.model.f();
        this.cIF = new com.baidu.tieba.homepage.personalize.b.af(context, this.aRs);
        this.cIF.b(this.cII);
        this.cIH = new x(this.pageContext, this.aRs, this.cIF);
        addView(this.aRs);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cdk);
    }

    public void amu() {
        this.cIF.a(this.cIN);
        this.cIH.a(this.cIO);
        this.mPullView.a(new s(this));
        this.mPullView.a(new t(this));
        this.aRs.setOnSrollToBottomListener(new u(this));
        this.aRs.setOnScrollStopDelayedListener(new v(this), 1L);
        this.mPullView.a(new k(this));
        this.aRs.setRecyclerListener(new l(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cIG = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.bbP != null) {
            this.bbP.wE();
            this.bbP.dm(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cIH.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cdM != null && this.cdM.getLayoutParams() != null) {
            if (this.cIH != null) {
                this.cIH.setHeaderViewHeight(i);
            }
            this.cdM.getLayoutParams().height = i;
            this.cdM.setLayoutParams(this.cdM.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (this.cIH != null) {
            this.cIH.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void showFloatingView() {
        if (this.cIH != null) {
            this.cIH.showFloatingView();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bdc != null) {
            this.bdc.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        if (this.bbP != null) {
            this.bbP.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_d));
            this.bbP.dl(i);
        }
        this.cIF.onChangeSkinType(i);
        com.baidu.tbadk.core.util.as.k(this, w.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void O(String str, int i) {
        if (this.bbP != null) {
            this.bbP.wE();
            this.bbP.dm(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cIH.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getContext(), new m(this));
        }
        this.refreshView.eU(getContext().getResources().getDimensionPixelSize(w.f.ds130));
        this.refreshView.gk(str);
        this.refreshView.c(view, z);
        this.refreshView.Ev();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Np() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nm() {
        if (this.bdc != null) {
            this.bdc.I(this);
            this.bdc = null;
        }
        if (this.cIG != null) {
            this.cIG.amc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amv() {
        if (this.refreshView != null) {
            return this.refreshView.Eo();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bdc == null) {
            if (i < 0) {
                this.bdc = new com.baidu.tbadk.i.f(getContext());
            } else {
                this.bdc = new com.baidu.tbadk.i.f(getContext(), i);
            }
            this.bdc.onChangeSkinType();
        }
        this.bdc.c(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cIH != null) {
            this.cIH.setTabInForeBackgroundState(z);
        }
    }

    public void amw() {
        setViewForeground(false);
        if (this.cIH != null) {
            this.cIH.ey(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.m9getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cIH != null) {
            this.cIH.fq(z);
        }
    }

    public void amj() {
        if (this.cIH != null) {
            this.cIH.update();
        }
    }

    public void reload() {
        if (this.aRs != null) {
            showFloatingView();
            this.aRs.setSelection(0);
            if (this.aRs.isRefreshDone()) {
                if (this.cIH != null && this.cIH.aes() != null) {
                    this.cIH.aes().aog();
                    this.cIH.ft(false);
                }
                this.aRs.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cdk);
        this.cIH.onDestroy();
        this.cIF.a((o.a) null);
        this.cIH.a((x.a) null);
        this.mPullView.a((ae.b) null);
        this.mPullView.a((ae.c) null);
        this.aRs.setOnSrollToBottomListener(null);
        this.mPullView.a((ae.a) null);
        this.mPullView.release();
        this.aRs.setRecyclerListener(null);
    }

    public void onPause() {
        this.cIH.onPause();
    }

    public void onResume() {
        this.cIH.onResume();
        if (this.ccO) {
            reload();
            this.ccO = false;
        }
    }

    public void alE() {
        if (this.cIF != null) {
            this.cIF.notifyDataSetChanged();
        }
    }

    public void amx() {
        if (this.cIH != null) {
            this.cIH.ey(true);
        }
        cf.VN().cw(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void ams() {
        this.cIH.amL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MG() {
        if (this.bbP != null && !this.bbP.wI()) {
            this.bbP.wD();
            this.bbP.dm(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cIH.MG();
    }
}

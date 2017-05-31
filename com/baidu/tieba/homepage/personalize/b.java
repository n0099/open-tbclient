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
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.o;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class b extends FrameLayout {
    private BdTypeListView aQa;
    private PbListView aZY;
    private final CustomMessageListener bUY;
    private View bVD;
    private com.baidu.tbadk.i.f baZ;
    private com.baidu.tieba.homepage.personalize.b.af cAK;
    private com.baidu.tieba.homepage.framework.b cAL;
    private o cAM;
    private com.baidu.tieba.homepage.personalize.model.f cAN;
    private ScrollFragmentTabHost cAO;
    private boolean cAP;
    private boolean cAQ;
    private o.a cAR;
    private o.a cAS;
    private View.OnClickListener cAT;
    private List<com.baidu.tieba.homepage.b.a.a> cAn;
    private com.baidu.tbadk.core.view.ah mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.i.h refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cAM != null) {
            this.cAO = scrollFragmentTabHost;
            this.cAM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.aQa != null) {
            this.aQa.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cAK != null) {
            this.cAK.setPageUniqueId(bdUniqueId);
        }
        if (this.cAM != null) {
            this.cAM.j(bdUniqueId);
        }
        if (this.cAN != null) {
            this.cAN.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bUY != null) {
            this.bUY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bUY);
        }
    }

    public b(Context context) {
        super(context);
        this.cAP = false;
        this.cAR = new c(this);
        this.cAS = new e(this);
        this.bUY = new f(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cAT = new h(this);
        init(context);
    }

    private void init(Context context) {
        this.aQa = new BdTypeListView(context);
        this.aQa.setDividerHeight(0);
        this.aQa.setSelector(17170445);
        this.aZY = new PbListView(context);
        this.aZY.le();
        this.aZY.di(w.e.cp_bg_line_c);
        this.aZY.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aZY.dj(TbadkCoreApplication.m9getInst().getSkinType());
        this.aZY.setOnClickListener(this.cAT);
        this.aQa.setNextPage(this.aZY);
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.pageContext);
        this.aQa.setPullRefresh(this.mPullView);
        this.mPullView.V(true);
        this.bVD = BdListViewHelper.a(context, this.aQa, BdListViewHelper.HeadType.DEFAULT);
        this.cAN = new com.baidu.tieba.homepage.personalize.model.f();
        this.cAK = new com.baidu.tieba.homepage.personalize.b.af(context, this.aQa);
        this.cAK.b(this.cAN);
        this.cAM = new o(this.pageContext, this.aQa, this.cAK);
        addView(this.aQa);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void aiI() {
        this.cAK.a(this.cAR);
        this.cAM.a(this.cAS);
        this.mPullView.a(new i(this));
        this.mPullView.a(new j(this));
        this.aQa.setOnSrollToBottomListener(new k(this));
        this.mPullView.a(new l(this));
        this.aQa.setRecyclerListener(new m(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.cAL = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.aZY != null) {
            this.aZY.wm();
            this.aZY.dk(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cAM.a(z, z2, dataRes, 0, null);
    }

    public void setHeaderViewHeight(int i) {
        if (this.bVD != null && this.bVD.getLayoutParams() != null) {
            if (this.cAM != null) {
                this.cAM.setHeaderViewHeight(i);
            }
            this.bVD.getLayoutParams().height = i;
            this.bVD.setLayoutParams(this.bVD.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (this.cAM != null) {
            this.cAM.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    public void Ye() {
        if (this.cAM != null) {
            this.cAM.Ye();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.baZ != null) {
            this.baZ.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.aZY != null) {
            this.aZY.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aZY.dj(i);
        }
        this.cAK.onChangeSkinType(i);
        aq.k(this, w.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void M(String str, int i) {
        if (this.aZY != null) {
            this.aZY.wm();
            this.aZY.dk(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cAM.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getContext(), new d(this));
        }
        this.refreshView.eS(getContext().getResources().getDimensionPixelSize(w.f.ds130));
        this.refreshView.fP(str);
        this.refreshView.c(view, z);
        this.refreshView.DY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mx() {
        if (this.refreshView != null) {
            this.refreshView.H(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mu() {
        if (this.baZ != null) {
            this.baZ.H(this);
            this.baZ = null;
        }
        if (this.cAL != null) {
            this.cAL.air();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiJ() {
        if (this.refreshView != null) {
            return this.refreshView.DR();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.baZ == null) {
            if (i < 0) {
                this.baZ = new com.baidu.tbadk.i.f(getContext());
            } else {
                this.baZ = new com.baidu.tbadk.i.f(getContext(), i);
            }
            this.baZ.onChangeSkinType();
        }
        this.baZ.c(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cAM != null) {
            this.cAM.setTabInForeBackgroundState(z);
        }
    }

    public void aiK() {
        setViewForeground(false);
        if (this.cAM != null) {
            this.cAM.eg(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void setViewForeground(boolean z) {
        if (this.cAM != null) {
            this.cAM.eZ(z);
        }
    }

    public void aiy() {
        if (this.cAM != null) {
            this.cAM.update();
        }
    }

    public void reload() {
        if (this.aQa != null) {
            Ye();
            this.aQa.setSelection(0);
            if (this.aQa.isRefreshDone()) {
                if (this.cAM != null && this.cAM.aaC() != null) {
                    this.cAM.aaC().akv();
                    this.cAM.fc(false);
                }
                this.aQa.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cAM.onDestroy();
        this.cAK.a((o.a) null);
        this.cAM.a((o.a) null);
        this.mPullView.a((ae.b) null);
        this.mPullView.a((ae.c) null);
        this.aQa.setOnSrollToBottomListener(null);
        this.mPullView.a((ae.a) null);
        this.mPullView.release();
        this.aQa.setRecyclerListener(null);
    }

    public void onPause() {
        this.cAM.onPause();
    }

    public void onResume() {
        this.cAM.onResume();
    }

    public void ahU() {
        if (this.cAK != null) {
            this.cAK.notifyDataSetChanged();
        }
    }

    public void aiL() {
        if (this.cAM != null) {
            this.cAM.eg(true);
        }
        cf.Uw().ds(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void aiH() {
        this.cAM.aiZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LS() {
        if (this.aZY != null && !this.aZY.wq()) {
            this.aZY.wl();
            this.aZY.dk(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
        }
        this.cAM.LS();
    }
}

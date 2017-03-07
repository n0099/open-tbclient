package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.n;
import com.baidu.tieba.w;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private static boolean cyw = false;
    private BdTypeListView aPo;
    private PbListView aRw;
    private com.baidu.tbadk.f.f aRx;
    private final CustomMessageListener bNQ;
    private TagInfo cyp;
    private com.baidu.tieba.homepage.personalize.b.ad cyq;
    private com.baidu.tieba.homepage.framework.c cyr;
    private n cys;
    private com.baidu.tieba.homepage.personalize.model.f cyt;
    private long cyu;
    private TextView cyv;
    private o.a cyx;
    private n.a cyy;
    private View.OnClickListener cyz;
    private com.baidu.tbadk.core.view.ae mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cys != null) {
            this.cys.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cys != null) {
            this.cys.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void WL() {
        if (this.cys != null) {
            this.cys.WL();
        }
    }

    public void completePullRefresh() {
        if (this.aPo != null) {
            this.aPo.completePullRefresh();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cys != null) {
            this.cys.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cyq != null) {
            this.cyq.setPageUniqueId(bdUniqueId);
        }
        if (this.cys != null) {
            this.cys.j(bdUniqueId);
        }
        if (this.cyt != null) {
            this.cyt.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bNQ != null) {
            this.bNQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bNQ);
        }
    }

    public a(Context context) {
        super(context);
        this.cyu = 0L;
        this.cyx = new b(this);
        this.cyy = new d(this);
        this.bNQ = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cyz = new g(this);
        init(context);
    }

    private void init(Context context) {
        this.aPo = new BdTypeListView(context);
        this.aPo.setDividerHeight(0);
        this.aPo.setSelector(17170445);
        this.aRw = new PbListView(context);
        this.aRw.la();
        this.aRw.dg(w.e.cp_bg_line_c);
        this.aRw.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRw.dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.aRw.setOnClickListener(this.cyz);
        this.aPo.setNextPage(this.aRw);
        com.baidu.adp.base.g<?> aa = com.baidu.adp.base.k.aa(context);
        if (aa instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aa;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.pageContext);
        this.aPo.setPullRefresh(this.mPullView);
        this.cyv = new TextView(context);
        this.cyv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(context, w.f.ds176)));
        this.aPo.addHeaderView(this.cyv, 0);
        this.mPullView.V(true);
        this.mPullView.a(new h(this));
        this.mPullView.a(new i(this));
        this.aPo.setOnSrollToBottomListener(new j(this));
        this.mPullView.a(new k(this));
        this.cyt = new com.baidu.tieba.homepage.personalize.model.f();
        this.cyq = new com.baidu.tieba.homepage.personalize.b.ad(context, this.aPo);
        this.cyq.b(this.cyt);
        this.cyq.a(this.cyx);
        this.cys = new n(this.pageContext, this.aPo, this.cyv, this.cyq, this);
        this.cys.a(this.cyy);
        addView(this.aPo);
        this.aPo.setRecyclerListener(new l(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cyr = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cyp = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aRw != null) {
            this.aRw.wI();
            this.aRw.di(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.cys.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.cyv != null) {
            aq.k(this.cyv, w.e.cp_bg_line_d);
        }
        if (this.aRx != null) {
            this.aRx.tD();
        }
        if (this.refreshView != null) {
            this.refreshView.tD();
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.aRw != null) {
            this.aRw.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aRw.dh(i);
        }
        this.cyq.onChangeSkinType(i);
        aq.k(this, w.e.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cyp == null || this.cyp.tag_code == null) {
            return 0L;
        }
        return this.cyp.tag_code.longValue();
    }

    public void M(String str, int i) {
        if (this.aRw != null) {
            this.aRw.wI();
            this.aRw.di(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.cys.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new c(this));
        }
        this.refreshView.eS(getContext().getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fN(str);
        this.refreshView.b(view, z);
        this.refreshView.EC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc() {
        if (this.aRx != null) {
            this.aRx.I(this);
            this.aRx = null;
        }
        if (this.cyr != null) {
            this.cyr.aiA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajl() {
        if (this.refreshView != null) {
            return this.refreshView.Ev();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.aRx == null) {
            if (i < 0) {
                this.aRx = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.aRx = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.aRx.tD();
        }
        this.aRx.b(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cys != null) {
            this.cys.setTabInForeBackgroundState(z);
        }
    }

    public void ajm() {
        setViewForeground(false);
        if (this.cys != null) {
            this.cys.dH(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void setViewForeground(boolean z) {
        this.cyu = System.currentTimeMillis();
        if (this.cys != null) {
            this.cys.eU(z);
        }
    }

    public void aiI() {
        if (this.cys != null) {
            this.cys.update();
        }
    }

    public void reload() {
        if (this.aPo != null) {
            WL();
            this.aPo.setSelection(0);
            if (this.aPo.isRefreshDone()) {
                if (this.cys != null && this.cys.KC() != null) {
                    this.cys.KC().alL();
                    this.cys.eX(false);
                }
                this.aPo.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cys.onDestroy();
    }

    public void onPause() {
        this.cys.onPause();
    }

    public void onResume() {
        this.cys.onResume();
    }

    public void aic() {
        if (this.cyq != null) {
            this.cyq.notifyDataSetChanged();
        }
    }

    public void ajn() {
        if (this.cys != null) {
            this.cys.dH(true);
        }
        if (this.cyu > 0) {
            TiebaStatic.log(new as("c10794").Z("obj_duration", String.valueOf((System.currentTimeMillis() - this.cyu) / 1000)));
            this.cyu = 0L;
        }
        cc.Sv().cM(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void ajo() {
        this.cys.ajD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YZ() {
        if (this.aRw != null && !this.aRw.wN()) {
            this.aRw.wH();
            this.aRw.di(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.cys.YZ();
    }
}

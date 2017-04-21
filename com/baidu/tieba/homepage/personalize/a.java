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
    private static boolean czn = false;
    private BdTypeListView aPG;
    private PbListView aRO;
    private com.baidu.tbadk.i.f aRP;
    private final CustomMessageListener bPW;
    private TagInfo czg;
    private com.baidu.tieba.homepage.personalize.b.ad czh;
    private com.baidu.tieba.homepage.framework.c czi;
    private n czj;
    private com.baidu.tieba.homepage.personalize.model.f czk;
    private long czl;
    private TextView czm;
    private o.a czo;
    private n.a czp;
    private View.OnClickListener czq;
    private com.baidu.tbadk.core.view.ae mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.i.h refreshView;

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.czj != null) {
            this.czj.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.czj != null) {
            this.czj.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void Yk() {
        if (this.czj != null) {
            this.czj.Yk();
        }
    }

    public void completePullRefresh() {
        if (this.aPG != null) {
            this.aPG.completePullRefresh();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.czj != null) {
            this.czj.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.czh != null) {
            this.czh.setPageUniqueId(bdUniqueId);
        }
        if (this.czj != null) {
            this.czj.j(bdUniqueId);
        }
        if (this.czk != null) {
            this.czk.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bPW != null) {
            this.bPW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bPW);
        }
    }

    public a(Context context) {
        super(context);
        this.czl = 0L;
        this.czo = new b(this);
        this.czp = new d(this);
        this.bPW = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.czq = new g(this);
        init(context);
    }

    private void init(Context context) {
        this.aPG = new BdTypeListView(context);
        this.aPG.setDividerHeight(0);
        this.aPG.setSelector(17170445);
        this.aRO = new PbListView(context);
        this.aRO.lf();
        this.aRO.dj(w.e.cp_bg_line_c);
        this.aRO.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRO.dk(TbadkCoreApplication.m9getInst().getSkinType());
        this.aRO.setOnClickListener(this.czq);
        this.aPG.setNextPage(this.aRO);
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(context);
        if (Z instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Z;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.pageContext);
        this.aPG.setPullRefresh(this.mPullView);
        this.czm = new TextView(context);
        this.czm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(context, w.f.ds176)));
        this.aPG.addHeaderView(this.czm, 0);
        this.mPullView.V(true);
        this.mPullView.a(new h(this));
        this.mPullView.a(new i(this));
        this.aPG.setOnSrollToBottomListener(new j(this));
        this.mPullView.a(new k(this));
        this.czk = new com.baidu.tieba.homepage.personalize.model.f();
        this.czh = new com.baidu.tieba.homepage.personalize.b.ad(context, this.aPG);
        this.czh.b(this.czk);
        this.czh.a(this.czo);
        this.czj = new n(this.pageContext, this.aPG, this.czm, this.czh, this);
        this.czj.a(this.czp);
        addView(this.aPG);
        this.aPG.setRecyclerListener(new l(this));
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.czi = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.czg = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aRO != null) {
            this.aRO.xe();
            this.aRO.dl(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.czj.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.czm != null) {
            aq.k(this.czm, w.e.cp_bg_line_d);
        }
        if (this.aRP != null) {
            this.aRP.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.aRO != null) {
            this.aRO.setTextColor(aq.getColor(w.e.cp_cont_d));
            this.aRO.dk(i);
        }
        this.czh.onChangeSkinType(i);
        aq.k(this, w.e.cp_bg_line_d);
        aq.j(this.aPG, w.e.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.czg == null || this.czg.tag_code == null) {
            return 0L;
        }
        return this.czg.tag_code.longValue();
    }

    public void M(String str, int i) {
        if (this.aRO != null) {
            this.aRO.xe();
            this.aRO.dl(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.czj.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.i.h(getContext(), new c(this));
        }
        this.refreshView.eV(getContext().getResources().getDimensionPixelSize(w.f.ds280));
        this.refreshView.fT(str);
        this.refreshView.b(view, z);
        this.refreshView.Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        if (this.refreshView != null) {
            this.refreshView.I(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        if (this.aRP != null) {
            this.aRP.I(this);
            this.aRP = null;
        }
        if (this.czi != null) {
            this.czi.ajv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akg() {
        if (this.refreshView != null) {
            return this.refreshView.ET();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.aRP == null) {
            if (i < 0) {
                this.aRP = new com.baidu.tbadk.i.f(getContext());
            } else {
                this.aRP = new com.baidu.tbadk.i.f(getContext(), i);
            }
            this.aRP.onChangeSkinType();
        }
        this.aRP.b(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.czj != null) {
            this.czj.setTabInForeBackgroundState(z);
        }
    }

    public void akh() {
        setViewForeground(false);
        if (this.czj != null) {
            this.czj.dT(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void setViewForeground(boolean z) {
        this.czl = System.currentTimeMillis();
        if (this.czj != null) {
            this.czj.fe(z);
        }
    }

    public void ajD() {
        if (this.czj != null) {
            this.czj.update();
        }
    }

    public void reload() {
        if (this.aPG != null) {
            Yk();
            this.aPG.setSelection(0);
            if (this.aPG.isRefreshDone()) {
                if (this.czj != null && this.czj.Lc() != null) {
                    this.czj.Lc().amG();
                    this.czj.fh(false);
                }
                this.aPG.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.czj.onDestroy();
    }

    public void onPause() {
        this.czj.onPause();
    }

    public void onResume() {
        this.czj.onResume();
    }

    public void aiX() {
        if (this.czh != null) {
            this.czh.notifyDataSetChanged();
        }
    }

    public void aki() {
        if (this.czj != null) {
            this.czj.dT(true);
        }
        if (this.czl > 0) {
            TiebaStatic.log(new as("c10794").aa("obj_duration", String.valueOf((System.currentTimeMillis() - this.czl) / 1000)));
            this.czl = 0L;
        }
        cc.TV().cY(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void akj() {
        this.czj.aky();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaw() {
        if (this.aRO != null && !this.aRO.xj()) {
            this.aRO.xd();
            this.aRO.dl(com.baidu.adp.lib.util.k.g(this.pageContext.getPageActivity(), w.f.ds110));
        }
        this.czj.aaw();
    }
}

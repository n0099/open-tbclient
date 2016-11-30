package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.n;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private com.baidu.tbadk.f.f HC;
    private PbListView aNs;
    private final CustomMessageListener bSW;
    private com.baidu.tieba.homepage.personalize.c.f cKA;
    private long cKB;
    private TextView cKC;
    private o.a cKD;
    private n.a cKE;
    private View.OnClickListener cKF;
    private TagInfo cKv;
    private BdTypeListView cKw;
    private com.baidu.tieba.homepage.personalize.b.ac cKx;
    private com.baidu.tieba.homepage.framework.c cKy;
    private n cKz;
    private com.baidu.tbadk.core.view.ac mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cKz != null) {
            this.cKz.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cKz != null) {
            this.cKz.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void aaf() {
        if (this.cKz != null) {
            this.cKz.aaf();
        }
    }

    public void ku() {
        if (this.cKw != null) {
            this.cKw.ku();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cKz != null) {
            this.cKz.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cKx != null) {
            this.cKx.setPageUniqueId(bdUniqueId);
        }
        if (this.cKz != null) {
            this.cKz.j(bdUniqueId);
        }
        if (this.cKA != null) {
            this.cKA.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bSW != null) {
            this.bSW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bSW);
        }
    }

    public a(Context context) {
        super(context);
        this.cKB = 0L;
        this.cKD = new b(this);
        this.cKE = new d(this);
        this.bSW = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cKF = new g(this);
        init(context);
    }

    private void init(Context context) {
        this.cKw = new BdTypeListView(context);
        this.cKw.setDividerHeight(0);
        this.cKw.setSelector(17170445);
        this.aNs = new PbListView(context);
        this.aNs.kk();
        this.aNs.dh(r.d.cp_bg_line_c);
        this.aNs.setTextColor(at.getColor(r.d.cp_cont_d));
        this.aNs.di(TbadkCoreApplication.m9getInst().getSkinType());
        this.aNs.setOnClickListener(this.cKF);
        this.cKw.setNextPage(this.aNs);
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.pageContext);
        this.cKw.setPullRefresh(this.mPullView);
        this.cKC = new TextView(context);
        this.cKC.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(context, r.e.ds176)));
        this.cKw.f(this.cKC, 0);
        this.mPullView.U(true);
        this.mPullView.a(new h(this));
        this.mPullView.a(new i(this));
        this.cKw.setOnSrollToBottomListener(new j(this));
        this.mPullView.a(new k(this));
        this.cKA = new com.baidu.tieba.homepage.personalize.c.f();
        this.cKx = new com.baidu.tieba.homepage.personalize.b.ac(context, this.cKw);
        this.cKx.b(this.cKA);
        this.cKx.a(this.cKD);
        this.cKz = new n(this.pageContext, this.cKw, this.cKC, this.cKx, this);
        this.cKz.a(this.cKE);
        addView(this.cKw);
        this.cKw.setRecyclerListener(new l(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cKy = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cKv = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aNs != null) {
            this.aNs.wG();
            this.aNs.dj(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cKz.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.cKC != null) {
            at.l(this.cKC, r.d.cp_bg_line_d);
        }
        if (this.HC != null) {
            this.HC.tB();
        }
        if (this.refreshView != null) {
            this.refreshView.tB();
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
        if (this.aNs != null) {
            this.aNs.setTextColor(at.getColor(r.d.cp_cont_d));
            this.aNs.di(i);
        }
        this.cKx.onChangeSkinType(i);
        at.l(this, r.d.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cKv == null || this.cKv.tag_code == null) {
            return 0L;
        }
        return this.cKv.tag_code.longValue();
    }

    public void V(String str, int i) {
        if (this.aNs != null) {
            this.aNs.wG();
            this.aNs.dj(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cKz.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new c(this));
        }
        this.refreshView.eV(getContext().getResources().getDimensionPixelSize(r.e.ds280));
        this.refreshView.gf(str);
        this.refreshView.b(view, z);
        this.refreshView.EG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP() {
        if (this.refreshView != null) {
            this.refreshView.M(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        if (this.HC != null) {
            this.HC.M(this);
            this.HC = null;
        }
        if (this.cKy != null) {
            this.cKy.anG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aos() {
        if (this.refreshView != null) {
            return this.refreshView.Ez();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.HC == null) {
            if (i < 0) {
                this.HC = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.HC = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.HC.tB();
        }
        this.HC.b(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cKz != null) {
            this.cKz.setTabInForeBackgroundState(z);
        }
    }

    public void aot() {
        setViewForeground(false);
        if (this.cKz != null) {
            this.cKz.dT(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.cKB = System.currentTimeMillis();
        if (this.cKz != null) {
            this.cKz.fo(z);
        }
    }

    public void anO() {
        if (this.cKz != null) {
            this.cKz.update();
        }
    }

    public void reload() {
        if (this.cKw != null) {
            aaf();
            this.cKw.setSelection(0);
            if (this.cKw.kw()) {
                if (this.cKz != null && this.cKz.Kp() != null) {
                    this.cKz.Kp().aro();
                    this.cKz.fr(false);
                }
                this.cKw.kv();
            }
        }
    }

    public void onDestroy() {
        this.cKz.onDestroy();
    }

    public void onPause() {
        this.cKz.onPause();
    }

    public void onResume() {
        this.cKz.onResume();
    }

    public void ank() {
        if (this.cKx != null) {
            this.cKx.notifyDataSetChanged();
        }
    }

    public void aou() {
        if (this.cKz != null) {
            this.cKz.dT(true);
        }
        if (this.cKB > 0) {
            TiebaStatic.log(new av("c10794").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.cKB) / 1000)));
            this.cKB = 0L;
        }
        bx.Pl().cw(false);
    }

    public void aov() {
        this.cKz.aoK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acw() {
        if (this.aNs != null && !this.aNs.wL()) {
            this.aNs.wF();
            this.aNs.dj(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cKz.acw();
    }
}

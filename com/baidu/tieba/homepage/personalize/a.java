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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.m;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private com.baidu.tbadk.f.f HA;
    private PbListView aMn;
    private final CustomMessageListener bQc;
    private TagInfo cFi;
    private BdTypeListView cFj;
    private com.baidu.tieba.homepage.personalize.b.ac cFk;
    private com.baidu.tieba.homepage.framework.c cFl;
    private m cFm;
    private com.baidu.tieba.homepage.personalize.c.f cFn;
    private long cFo;
    private TextView cFp;
    private m.a cFq;
    private View.OnClickListener cFr;
    private com.baidu.tbadk.core.view.ab mPullView;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.f.h refreshView;

    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tieba.homepage.framework.b.e eVar) {
        if (this.cFm != null) {
            this.cFm.setRecommendFrsNavigationAnimDispatcher(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cFm != null) {
            this.cFm.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void Zd() {
        if (this.cFm != null) {
            this.cFm.Zd();
        }
    }

    public void ku() {
        if (this.cFj != null) {
            this.cFj.ku();
        }
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cFm != null) {
            this.cFm.b(view, i, i2, i3, i4);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cFk != null) {
            this.cFk.setPageUniqueId(bdUniqueId);
        }
        if (this.cFm != null) {
            this.cFm.j(bdUniqueId);
        }
        if (this.cFn != null) {
            this.cFn.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.bQc != null) {
            this.bQc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bQc);
        }
    }

    public a(Context context) {
        super(context);
        this.cFo = 0L;
        this.cFq = new b(this);
        this.bQc = new c(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.cFr = new e(this);
        init(context);
    }

    private void init(Context context) {
        this.cFj = new BdTypeListView(context);
        this.cFj.setDividerHeight(0);
        this.cFj.setSelector(17170445);
        this.aMn = new PbListView(context);
        this.aMn.kk();
        this.aMn.dg(r.d.cp_bg_line_c);
        this.aMn.setTextColor(av.getColor(r.d.cp_cont_d));
        this.aMn.dh(TbadkCoreApplication.m9getInst().getSkinType());
        this.aMn.setOnClickListener(this.cFr);
        this.cFj.setNextPage(this.aMn);
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(context);
        if (C instanceof TbPageContext) {
            this.pageContext = (TbPageContext) C;
        }
        this.mPullView = new com.baidu.tbadk.core.view.ab(this.pageContext);
        this.cFj.setPullRefresh(this.mPullView);
        this.cFp = new TextView(context);
        this.cFp.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(context, r.e.ds176)));
        this.cFj.f(this.cFp, 0);
        this.mPullView.U(true);
        this.mPullView.a(new f(this));
        this.mPullView.a(new g(this));
        this.cFj.setOnSrollToBottomListener(new h(this));
        this.mPullView.a(new i(this));
        this.cFn = new com.baidu.tieba.homepage.personalize.c.f();
        this.cFk = new com.baidu.tieba.homepage.personalize.b.ac(context, this.cFj);
        this.cFk.b(this.cFn);
        this.cFm = new m(this.pageContext, this.cFj, this.cFp, this.cFk, this);
        this.cFm.a(this.cFq);
        addView(this.cFj);
        this.cFj.setRecyclerListener(new j(this));
    }

    public void setCallback(com.baidu.tieba.homepage.framework.c cVar) {
        this.cFl = cVar;
    }

    public void setTagInfo(TagInfo tagInfo) {
        this.cFi = tagInfo;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.aMn != null) {
            this.aMn.wC();
            this.aMn.di(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cFm.a(z, dataRes, 0, null);
    }

    public void onChangeSkinType(int i) {
        if (this.cFp != null) {
            av.l(this.cFp, r.d.cp_bg_line_d);
        }
        if (this.HA != null) {
            this.HA.tx();
        }
        if (this.refreshView != null) {
            this.refreshView.tx();
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.aMn != null) {
            this.aMn.setTextColor(av.getColor(r.d.cp_cont_d));
            this.aMn.dh(i);
        }
        this.cFk.onChangeSkinType(i);
        av.l(this, r.d.cp_bg_line_d);
    }

    public long getTagCode() {
        if (this.cFi == null || this.cFi.tag_code == null) {
            return 0L;
        }
        return this.cFi.tag_code.longValue();
    }

    public void V(String str, int i) {
        if (this.aMn != null) {
            this.aMn.wC();
            this.aMn.di(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cFm.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getContext(), new k(this));
        }
        this.refreshView.eS(getContext().getResources().getDimensionPixelSize(r.e.ds280));
        this.refreshView.gc(str);
        this.refreshView.b(view, z);
        this.refreshView.EB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ() {
        if (this.refreshView != null) {
            this.refreshView.L(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        if (this.HA != null) {
            this.HA.L(this);
            this.HA = null;
        }
        if (this.cFl != null) {
            this.cFl.alL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amx() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, int i) {
        if (this.HA == null) {
            if (i < 0) {
                this.HA = new com.baidu.tbadk.f.f(getContext());
            } else {
                this.HA = new com.baidu.tbadk.f.f(getContext(), i);
            }
            this.HA.tx();
        }
        this.HA.b(this, z);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cFm != null) {
            this.cFm.setTabInForeBackgroundState(z);
        }
    }

    public void amy() {
        setViewForeground(false);
        if (this.cFm != null) {
            this.cFm.dM(false);
        }
    }

    public void setViewForeground(boolean z) {
        this.cFo = System.currentTimeMillis();
        if (this.cFm != null) {
            this.cFm.eZ(z);
        }
    }

    public void alT() {
        if (this.cFm != null) {
            this.cFm.update();
        }
    }

    public void reload() {
        if (this.cFj != null) {
            Zd();
            this.cFj.setSelection(0);
            if (this.cFj.kw()) {
                if (this.cFm != null && this.cFm.JP() != null) {
                    this.cFm.JP().bap();
                    this.cFm.fc(false);
                }
                this.cFj.kv();
            }
        }
    }

    public void onDestroy() {
        this.cFm.onDestroy();
    }

    public void onPause() {
        this.cFm.onPause();
    }

    public void onResume() {
        this.cFm.onResume();
    }

    public void alp() {
        if (this.cFk != null) {
            this.cFk.notifyDataSetChanged();
        }
    }

    public void amz() {
        if (this.cFm != null) {
            this.cFm.dM(true);
        }
        if (this.cFo > 0) {
            TiebaStatic.log(new ax("c10794").ab("obj_duration", String.valueOf((System.currentTimeMillis() - this.cFo) / 1000)));
            this.cFo = 0L;
        }
        cb.Oj().cr(false);
    }

    public void amA() {
        this.cFm.amQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abm() {
        if (this.aMn != null && !this.aMn.wG()) {
            this.aMn.wB();
            this.aMn.di(com.baidu.adp.lib.util.k.e(this.pageContext.getPageActivity(), r.e.ds110));
        }
        this.cFm.abm();
    }
}

package com.baidu.tieba.homepage.fragment.a;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.f.f;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public NoNetworkView aQl;
    private PbListView aRt;
    public f loadingView;
    private TbPageContext<BaseFragmentActivity> mContext;
    private View mFooterView;
    private int mSkinType = 3;
    public View byB = null;
    public BdTypeListView aRs = null;
    public s mPullView = null;
    private NoNetworkView.a aXw = null;
    private com.baidu.tieba.homepage.listview.b byC = null;
    private boolean byD = false;

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, View view) {
        this.mContext = tbPageContext;
        A(view);
    }

    private void A(View view) {
        if (view != null) {
            this.byB = view;
            this.aQl = (NoNetworkView) this.byB.findViewById(n.f.view_no_network);
            this.aRs = (BdTypeListView) this.byB.findViewById(n.f.home_page_module_list);
            this.aRs.setDividerHeight(0);
            this.byC = new com.baidu.tieba.homepage.listview.b(this.mContext, this.aRs);
            this.mPullView = new s(this.mContext);
            this.aRs.setPullRefresh(this.mPullView);
            this.aRt = new PbListView(this.mContext.getPageActivity());
            this.aRt.nv();
            this.mFooterView = new View(this.mContext.getPageActivity());
            this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, k.d(this.mContext.getPageActivity(), n.d.ds70)));
            wz();
        }
    }

    private void wz() {
        as.j(this.byB, n.c.cp_bg_line_d);
        as.j(this.mFooterView, n.c.cp_bg_line_c);
        this.aRt.cU(n.c.cp_bg_line_c);
        this.aRs.setHeaderDividersEnabled(false);
    }

    public void b(com.baidu.tieba.homepage.fragment.data.b bVar) {
        if (this.byC != null) {
            this.byC.J(bVar.TP());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aQl != null) {
            this.aQl.onChangeSkinType(this.mContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.aRt != null) {
            this.aRt.cV(i);
        }
        if (this.mSkinType != i) {
            wz();
            this.byC.notifyDataSetChanged();
            this.mSkinType = i;
        }
    }

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void showLoadingView(View view, boolean z) {
        if (this.loadingView == null) {
            this.loadingView = new f(this.mContext.getPageActivity());
            this.loadingView.tH();
        }
        if (this.aQl != null) {
            this.aQl.setVisibility(8);
        }
        this.loadingView.b(view, z);
    }

    public void hideLoadingView(View view) {
        if (this.loadingView != null) {
            this.loadingView.v(view);
            this.loadingView = null;
            TW();
        }
        if (this.aQl != null && !i.iP()) {
            this.aQl.setVisibility(0);
        }
    }

    public void TT() {
        if (this.aRs != null) {
            this.aRs.completePullRefresh();
        }
    }

    public void TU() {
        if (this.aRs != null) {
            this.aRs.nD();
        }
    }

    public void b(BdListView.e eVar) {
        if (eVar != null) {
            this.aRs.setOnSrollToBottomListener(eVar);
        }
    }

    public void M(View view) {
        if (this.aRs != null) {
            this.aRs.addHeaderView(view);
        }
    }

    public void N(View view) {
        if (this.aRs != null) {
            this.aRs.removeHeaderView(view);
        }
    }

    public void TV() {
        if (this.byC != null) {
            this.byC.notifyDataSetChanged();
        }
    }

    private void TW() {
        if (this.aRs != null && this.mFooterView != null && !this.byD) {
            this.aRs.addFooterView(this.mFooterView);
            this.byD = true;
        }
    }

    public void aM(List<u> list) {
        if (this.byC != null) {
            this.byC.aN(list);
        }
    }
}

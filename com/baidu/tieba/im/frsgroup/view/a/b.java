package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private View IY;
    private TbPageContext<?> aRR;
    private f bXm;
    private PbListView cbk;
    private g eFh;
    private BdTypeListView mListView;
    private k mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.aRR = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new k(this.aRR);
        this.mPullView.setTag(this.aRR.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.IY = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.IY, BdListViewHelper.HeadType.HASTAB, j.oJ());
        this.mRootView.addView(this.mListView);
    }

    public void hE(boolean z) {
        if (this.IY != null && this.mListView != null) {
            BdListViewHelper.a(this.IY, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void ck(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.E(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void bI(List<i> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void aBK() {
        aJo();
        this.cbk.Eg();
    }

    public void aBL() {
        aJo();
        this.cbk.setText(this.aRR.getResources().getString(d.j.network_ungeilivable));
        this.cbk.Eh();
    }

    public void aBM() {
        aJo();
        this.cbk.setText(this.aRR.getResources().getString(d.j.list_no_more));
        this.cbk.Eh();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mListView, d.C0140d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.cbk != null) {
            this.cbk.gw(d.C0140d.cp_bg_line_c);
            this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
            this.cbk.gx(i);
        }
        if (this.eFh != null) {
            this.eFh.onChangeSkinType();
        }
        if (this.bXm != null) {
            this.bXm.onChangeSkinType();
        }
    }

    public void aJn() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.cbk = null;
        }
    }

    private void aJo() {
        if (this.mListView != null && this.cbk == null) {
            this.cbk = new PbListView(this.aRR.getPageActivity());
            this.cbk.st();
            this.mListView.setNextPage(this.cbk);
        }
    }

    public void VU() {
        if (this.bXm == null) {
            this.bXm = new f(this.aRR.getPageActivity(), BdListViewHelper.bCW);
            this.bXm.onChangeSkinType();
        }
        if (!this.bXm.MJ()) {
            this.mListView.setVisibility(8);
            this.bXm.j(this.mRootView, true);
        }
    }

    public void VV() {
        if (this.bXm != null && this.bXm.MJ()) {
            this.mListView.setVisibility(0);
            this.bXm.bk(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eFh == null) {
            this.eFh = new g(this.aRR.getPageActivity(), onClickListener);
            this.eFh.ib(BdListViewHelper.bCW);
            this.eFh.onChangeSkinType();
        }
        if (!this.eFh.MJ()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.aRR.getString(d.j.invite_friend_no_data_now);
            }
            this.eFh.setTitle(str);
            this.eFh.j(this.mRootView, true);
            this.eFh.MR();
        }
    }

    public void XN() {
        if (this.eFh != null && this.eFh.MJ()) {
            this.mListView.setVisibility(0);
            this.eFh.bk(this.mRootView);
        }
    }
}

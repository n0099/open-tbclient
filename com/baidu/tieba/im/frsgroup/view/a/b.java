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
    private View IS;
    private TbPageContext<?> aRI;
    private f bXd;
    private PbListView cbb;
    private g eFl;
    private BdTypeListView mListView;
    private k mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.aRI = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new k(this.aRI);
        this.mPullView.setTag(this.aRI.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.IS = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.IS, BdListViewHelper.HeadType.HASTAB, j.oJ());
        this.mRootView.addView(this.mListView);
    }

    public void hJ(boolean z) {
        if (this.IS != null && this.mListView != null) {
            BdListViewHelper.a(this.IS, BdListViewHelper.HeadType.HASTAB, z);
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
        this.cbb.Eg();
    }

    public void aBL() {
        aJo();
        this.cbb.setText(this.aRI.getResources().getString(d.j.network_ungeilivable));
        this.cbb.Eh();
    }

    public void aBM() {
        aJo();
        this.cbb.setText(this.aRI.getResources().getString(d.j.list_no_more));
        this.cbb.Eh();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mListView, d.C0141d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.cbb != null) {
            this.cbb.gw(d.C0141d.cp_bg_line_c);
            this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.cbb.gx(i);
        }
        if (this.eFl != null) {
            this.eFl.onChangeSkinType();
        }
        if (this.bXd != null) {
            this.bXd.onChangeSkinType();
        }
    }

    public void aJn() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.cbb = null;
        }
    }

    private void aJo() {
        if (this.mListView != null && this.cbb == null) {
            this.cbb = new PbListView(this.aRI.getPageActivity());
            this.cbb.st();
            this.mListView.setNextPage(this.cbb);
        }
    }

    public void VU() {
        if (this.bXd == null) {
            this.bXd = new f(this.aRI.getPageActivity(), BdListViewHelper.bCM);
            this.bXd.onChangeSkinType();
        }
        if (!this.bXd.MJ()) {
            this.mListView.setVisibility(8);
            this.bXd.j(this.mRootView, true);
        }
    }

    public void VV() {
        if (this.bXd != null && this.bXd.MJ()) {
            this.mListView.setVisibility(0);
            this.bXd.bk(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eFl == null) {
            this.eFl = new g(this.aRI.getPageActivity(), onClickListener);
            this.eFl.ib(BdListViewHelper.bCM);
            this.eFl.onChangeSkinType();
        }
        if (!this.eFl.MJ()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.aRI.getString(d.j.invite_friend_no_data_now);
            }
            this.eFl.setTitle(str);
            this.eFl.j(this.mRootView, true);
            this.eFl.MR();
        }
    }

    public void XN() {
        if (this.eFl != null && this.eFl.MJ()) {
            this.mListView.setVisibility(0);
            this.eFl.bk(this.mRootView);
        }
    }
}

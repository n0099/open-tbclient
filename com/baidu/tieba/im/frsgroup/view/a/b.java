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
    private TbPageContext<?> aRG;
    private f bXa;
    private PbListView caY;
    private g eEV;
    private BdTypeListView mListView;
    private k mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.aRG = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new k(this.aRG);
        this.mPullView.setTag(this.aRG.getUniqueId());
        this.mPullView.a(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.IS = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.IS, BdListViewHelper.HeadType.HASTAB, j.oJ());
        this.mRootView.addView(this.mListView);
    }

    public void hE(boolean z) {
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

    public void aBJ() {
        aJn();
        this.caY.Ef();
    }

    public void aBK() {
        aJn();
        this.caY.setText(this.aRG.getResources().getString(d.j.network_ungeilivable));
        this.caY.Eg();
    }

    public void aBL() {
        aJn();
        this.caY.setText(this.aRG.getResources().getString(d.j.list_no_more));
        this.caY.Eg();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mListView, d.C0141d.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.caY != null) {
            this.caY.gw(d.C0141d.cp_bg_line_c);
            this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.caY.gx(i);
        }
        if (this.eEV != null) {
            this.eEV.onChangeSkinType();
        }
        if (this.bXa != null) {
            this.bXa.onChangeSkinType();
        }
    }

    public void aJm() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.caY = null;
        }
    }

    private void aJn() {
        if (this.mListView != null && this.caY == null) {
            this.caY = new PbListView(this.aRG.getPageActivity());
            this.caY.st();
            this.mListView.setNextPage(this.caY);
        }
    }

    public void VT() {
        if (this.bXa == null) {
            this.bXa = new f(this.aRG.getPageActivity(), BdListViewHelper.bCJ);
            this.bXa.onChangeSkinType();
        }
        if (!this.bXa.MI()) {
            this.mListView.setVisibility(8);
            this.bXa.j(this.mRootView, true);
        }
    }

    public void VU() {
        if (this.bXa != null && this.bXa.MI()) {
            this.mListView.setVisibility(0);
            this.bXa.bk(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.eEV == null) {
            this.eEV = new g(this.aRG.getPageActivity(), onClickListener);
            this.eEV.ib(BdListViewHelper.bCJ);
            this.eEV.onChangeSkinType();
        }
        if (!this.eEV.MI()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.aRG.getString(d.j.invite_friend_no_data_now);
            }
            this.eEV.setTitle(str);
            this.eEV.j(this.mRootView, true);
            this.eEV.MQ();
        }
    }

    public void XM() {
        if (this.eEV != null && this.eEV.MI()) {
            this.mListView.setVisibility(0);
            this.eEV.bk(this.mRootView);
        }
    }
}

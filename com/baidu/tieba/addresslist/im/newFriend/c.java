package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View Th;
    private NewFriendsActivity bfp;
    private BdListView bfq;
    private a bfr;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private f mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bfp = newFriendsActivity;
        this.Th = this.bfp.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bfp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bfp.getPageContext().getString(d.k.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, this.bfp).findViewById(d.g.new_friend_search);
        ak.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.bfq = (BdListView) this.bfp.findViewById(d.g.new_friend_listview);
        this.bfr = new a(this.bfp);
        this.bfq.setAdapter((ListAdapter) this.bfr);
        this.bfq.setOnItemClickListener(this.bfp);
        this.bfq.setOnItemLongClickListener(this.bfp);
        this.mPullView = new f(newFriendsActivity.getPageContext());
        this.bfq.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bfp.getActivity(), this.bfq, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bfp.getPageContext().getPageActivity(), this.Th, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.bfp.getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.k.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bfq.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bfq.completePullRefreshPostDelayed(2000L);
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bfr.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bfp.getPageContext(), i);
        this.mPullView.dw(i);
        cVar.u(this.Th);
        this.mNoDataView.onChangeSkinType(this.bfp.getPageContext(), i);
        ak.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bfq.setEmptyView(this.mNoDataView);
        this.bfr.setData(list);
        this.bfr.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bfr.a(aVar);
        this.bfr.notifyDataSetChanged();
    }

    public void U(List<com.baidu.tieba.im.data.a> list) {
        this.bfr.U(list);
        this.bfr.notifyDataSetChanged();
    }

    public a Ny() {
        return this.bfr;
    }
}

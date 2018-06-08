package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View abp;
    private NewFriendsActivity bnw;
    private BdListView bnx;
    private a bny;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bnw = newFriendsActivity;
        this.abp = this.bnw.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bnw.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bnw.getPageContext().getString(d.k.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, this.bnw).findViewById(d.g.new_friend_search);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.bnx = (BdListView) this.bnw.findViewById(d.g.new_friend_listview);
        this.bny = new a(this.bnw);
        this.bnx.setAdapter((ListAdapter) this.bny);
        this.bnx.setOnItemClickListener(this.bnw);
        this.bnx.setOnItemLongClickListener(this.bnw);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.bnx.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bnw.getActivity(), this.bnx, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bnw.getPageContext().getPageActivity(), this.abp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.bnw.getActivity(), d.e.ds320)), NoDataViewFactory.d.dr(d.k.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bnx.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bnx.completePullRefreshPostDelayed(2000L);
    }

    public void a(f.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bny.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bnw.getPageContext(), i);
        this.mPullView.dy(i);
        cVar.onModeChanged(this.abp);
        this.mNoDataView.onChangeSkinType(this.bnw.getPageContext(), i);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bnx.setEmptyView(this.mNoDataView);
        this.bny.setData(list);
        this.bny.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bny.a(aVar);
        this.bny.notifyDataSetChanged();
    }

    public void X(List<com.baidu.tieba.im.data.a> list) {
        this.bny.X(list);
        this.bny.notifyDataSetChanged();
    }

    public a QX() {
        return this.bny;
    }
}

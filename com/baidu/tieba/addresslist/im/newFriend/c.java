package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View aaV;
    private NewFriendsActivity bpC;
    private BdListView bpD;
    private a bpE;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bpC = newFriendsActivity;
        this.aaV = this.bpC.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bpC.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bpC.getPageContext().getString(d.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, this.bpC).findViewById(d.g.new_friend_search);
        am.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.bpD = (BdListView) this.bpC.findViewById(d.g.new_friend_listview);
        this.bpE = new a(this.bpC);
        this.bpD.setAdapter((ListAdapter) this.bpE);
        this.bpD.setOnItemClickListener(this.bpC);
        this.bpD.setOnItemLongClickListener(this.bpC);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.bpD.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bpC.getActivity(), this.bpD, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bpC.getPageContext().getPageActivity(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.bpC.getActivity(), d.e.ds320)), NoDataViewFactory.d.du(d.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bpD.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bpD.completePullRefreshPostDelayed(2000L);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bpE.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bpC.getPageContext(), i);
        this.mPullView.dC(i);
        cVar.onModeChanged(this.aaV);
        this.mNoDataView.onChangeSkinType(this.bpC.getPageContext(), i);
        am.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bpD.setEmptyView(this.mNoDataView);
        this.bpE.setData(list);
        this.bpE.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bpE.a(aVar);
        this.bpE.notifyDataSetChanged();
    }

    public void X(List<com.baidu.tieba.im.data.a> list) {
        this.bpE.X(list);
        this.bpE.notifyDataSetChanged();
    }

    public a RB() {
        return this.bpE;
    }
}

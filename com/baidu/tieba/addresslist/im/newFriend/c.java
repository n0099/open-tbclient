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
    private View abt;
    private NewFriendsActivity boV;
    private BdListView boW;
    private a boX;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.boV = newFriendsActivity;
        this.abt = this.boV.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.boV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.boV.getPageContext().getString(d.k.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, this.boV).findViewById(d.g.new_friend_search);
        am.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.boW = (BdListView) this.boV.findViewById(d.g.new_friend_listview);
        this.boX = new a(this.boV);
        this.boW.setAdapter((ListAdapter) this.boX);
        this.boW.setOnItemClickListener(this.boV);
        this.boW.setOnItemLongClickListener(this.boV);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.boW.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.boV.getActivity(), this.boW, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.boV.getPageContext().getPageActivity(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.boV.getActivity(), d.e.ds320)), NoDataViewFactory.d.ds(d.k.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.boW.startPullRefresh();
    }

    public void completePullRefresh() {
        this.boW.completePullRefreshPostDelayed(2000L);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.boX.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.boV.getPageContext(), i);
        this.mPullView.dz(i);
        cVar.onModeChanged(this.abt);
        this.mNoDataView.onChangeSkinType(this.boV.getPageContext(), i);
        am.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.boW.setEmptyView(this.mNoDataView);
        this.boX.setData(list);
        this.boX.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.boX.a(aVar);
        this.boX.notifyDataSetChanged();
    }

    public void Y(List<com.baidu.tieba.im.data.a> list) {
        this.boX.Y(list);
        this.boX.notifyDataSetChanged();
    }

    public a Ru() {
        return this.boX;
    }
}

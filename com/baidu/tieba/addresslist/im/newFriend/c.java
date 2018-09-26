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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View adA;
    private NewFriendsActivity bvu;
    private BdListView bvv;
    private a bvw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bvu = newFriendsActivity;
        this.adA = this.bvu.findViewById(e.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bvu.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bvu.getPageContext().getString(e.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, this.bvu).findViewById(e.g.new_friend_search);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.bvv = (BdListView) this.bvu.findViewById(e.g.new_friend_listview);
        this.bvw = new a(this.bvu);
        this.bvv.setAdapter((ListAdapter) this.bvw);
        this.bvv.setOnItemClickListener(this.bvu);
        this.bvv.setOnItemLongClickListener(this.bvu);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bvv.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bvu.getActivity(), this.bvv, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bvu.getPageContext().getPageActivity(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bvu.getActivity(), e.C0141e.ds320)), NoDataViewFactory.d.dE(e.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bvv.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bvv.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bvw.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bvu.getPageContext(), i);
        this.mPullView.dM(i);
        cVar.onModeChanged(this.adA);
        this.mNoDataView.onChangeSkinType(this.bvu.getPageContext(), i);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bvv.setEmptyView(this.mNoDataView);
        this.bvw.setData(list);
        this.bvw.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bvw.a(aVar);
        this.bvw.notifyDataSetChanged();
    }

    public void Y(List<com.baidu.tieba.im.data.a> list) {
        this.bvw.Y(list);
        this.bvw.notifyDataSetChanged();
    }

    public a Tu() {
        return this.bvw;
    }
}

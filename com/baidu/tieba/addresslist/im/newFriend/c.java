package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
    private View aix;
    private NewFriendsActivity bzw;
    private BdListView bzx;
    private a bzy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bzw = newFriendsActivity;
        this.aix = this.bzw.findViewById(e.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bzw.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bzw.getPageContext().getString(e.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, this.bzw).findViewById(e.g.new_friend_search);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.bzx = (BdListView) this.bzw.findViewById(e.g.new_friend_listview);
        this.bzy = new a(this.bzw);
        this.bzx.setAdapter((ListAdapter) this.bzy);
        this.bzx.setOnItemClickListener(this.bzw);
        this.bzx.setOnItemLongClickListener(this.bzw);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bzx.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bzw.getActivity(), this.bzx, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bzw.getPageContext().getPageActivity(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bzw.getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bzx.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bzx.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bzy.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bzw.getPageContext(), i);
        this.mPullView.dW(i);
        cVar.onModeChanged(this.aix);
        this.mNoDataView.onChangeSkinType(this.bzw.getPageContext(), i);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bzx.setEmptyView(this.mNoDataView);
        this.bzy.setData(list);
        this.bzy.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bzy.a(aVar);
        this.bzy.notifyDataSetChanged();
    }

    public void ah(List<com.baidu.tieba.im.data.a> list) {
        this.bzy.ah(list);
        this.bzy.notifyDataSetChanged();
    }

    public a Vq() {
        return this.bzy;
    }
}

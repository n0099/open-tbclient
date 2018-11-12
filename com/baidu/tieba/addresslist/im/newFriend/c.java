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
    private View ajk;
    private NewFriendsActivity bAh;
    private BdListView bAi;
    private a bAj;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bAh = newFriendsActivity;
        this.ajk = this.bAh.findViewById(e.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bAh.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bAh.getPageContext().getString(e.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, this.bAh).findViewById(e.g.new_friend_search);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.bAi = (BdListView) this.bAh.findViewById(e.g.new_friend_listview);
        this.bAj = new a(this.bAh);
        this.bAi.setAdapter((ListAdapter) this.bAj);
        this.bAi.setOnItemClickListener(this.bAh);
        this.bAi.setOnItemLongClickListener(this.bAh);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bAi.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bAh.getActivity(), this.bAi, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bAh.getPageContext().getPageActivity(), this.ajk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bAh.getActivity(), e.C0200e.ds320)), NoDataViewFactory.d.ec(e.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bAi.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bAi.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bAj.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bAh.getPageContext(), i);
        this.mPullView.ek(i);
        cVar.onModeChanged(this.ajk);
        this.mNoDataView.onChangeSkinType(this.bAh.getPageContext(), i);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bAi.setEmptyView(this.mNoDataView);
        this.bAj.setData(list);
        this.bAj.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bAj.a(aVar);
        this.bAj.notifyDataSetChanged();
    }

    public void ag(List<com.baidu.tieba.im.data.a> list) {
        this.bAj.ag(list);
        this.bAj.notifyDataSetChanged();
    }

    public a Vz() {
        return this.bAj;
    }
}

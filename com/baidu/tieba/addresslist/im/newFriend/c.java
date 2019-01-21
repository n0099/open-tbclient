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
    private View anp;
    private NewFriendsActivity bEv;
    private BdListView bEw;
    private a bEx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bEv = newFriendsActivity;
        this.anp = this.bEv.findViewById(e.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bEv.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bEv.getPageContext().getString(e.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, this.bEv).findViewById(e.g.new_friend_search);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.bEw = (BdListView) this.bEv.findViewById(e.g.new_friend_listview);
        this.bEx = new a(this.bEv);
        this.bEw.setAdapter((ListAdapter) this.bEx);
        this.bEw.setOnItemClickListener(this.bEv);
        this.bEw.setOnItemLongClickListener(this.bEv);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bEw.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bEv.getActivity(), this.bEw, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bEv.getPageContext().getPageActivity(), this.anp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bEv.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bEw.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bEw.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bEx.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bEv.getPageContext(), i);
        this.mPullView.ey(i);
        cVar.onModeChanged(this.anp);
        this.mNoDataView.onChangeSkinType(this.bEv.getPageContext(), i);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bEw.setEmptyView(this.mNoDataView);
        this.bEx.setData(list);
        this.bEx.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bEx.a(aVar);
        this.bEx.notifyDataSetChanged();
    }

    public void ah(List<com.baidu.tieba.im.data.a> list) {
        this.bEx.ah(list);
        this.bEx.notifyDataSetChanged();
    }

    public a Xe() {
        return this.bEx;
    }
}

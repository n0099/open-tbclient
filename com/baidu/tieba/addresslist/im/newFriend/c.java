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
    private View ano;
    private NewFriendsActivity bEu;
    private BdListView bEv;
    private a bEw;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private k mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bEu = newFriendsActivity;
        this.ano = this.bEu.findViewById(e.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bEu.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bEu.getPageContext().getString(e.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, this.bEu).findViewById(e.g.new_friend_search);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.bEv = (BdListView) this.bEu.findViewById(e.g.new_friend_listview);
        this.bEw = new a(this.bEu);
        this.bEv.setAdapter((ListAdapter) this.bEw);
        this.bEv.setOnItemClickListener(this.bEu);
        this.bEv.setOnItemLongClickListener(this.bEu);
        this.mPullView = new k(newFriendsActivity.getPageContext());
        this.bEv.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bEu.getActivity(), this.bEv, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bEu.getPageContext().getPageActivity(), this.ano, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bEu.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bEv.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bEv.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bEw.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bEu.getPageContext(), i);
        this.mPullView.ey(i);
        cVar.onModeChanged(this.ano);
        this.mNoDataView.onChangeSkinType(this.bEu.getPageContext(), i);
        al.a(this.mSearchButton, e.f.icon_search_bg_s, e.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bEv.setEmptyView(this.mNoDataView);
        this.bEw.setData(list);
        this.bEw.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bEw.a(aVar);
        this.bEw.notifyDataSetChanged();
    }

    public void ah(List<com.baidu.tieba.im.data.a> list) {
        this.bEw.ah(list);
        this.bEw.notifyDataSetChanged();
    }

    public a Xe() {
        return this.bEw;
    }
}

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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View bub;
    private NewFriendsActivity cPB;
    private BdListView cPC;
    private a cPD;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.cPB = newFriendsActivity;
        this.bub = this.cPB.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.cPB.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cPB.getPageContext().getString(d.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, this.cPB).findViewById(d.g.new_friend_search);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.cPC = (BdListView) this.cPB.findViewById(d.g.new_friend_listview);
        this.cPD = new a(this.cPB);
        this.cPC.setAdapter((ListAdapter) this.cPD);
        this.cPC.setOnItemClickListener(this.cPB);
        this.cPC.setOnItemLongClickListener(this.cPB);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.cPC.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.cPB.getActivity(), this.cPC, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.cPB.getPageContext().getPageActivity(), this.bub, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.cPB.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.cPC.startPullRefresh();
    }

    public void completePullRefresh() {
        this.cPC.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.cPD.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.cPB.getPageContext(), i);
        this.mPullView.ib(i);
        cVar.onModeChanged(this.bub);
        this.mNoDataView.onChangeSkinType(this.cPB.getPageContext(), i);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.cPC.setEmptyView(this.mNoDataView);
        this.cPD.setData(list);
        this.cPD.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.cPD.a(aVar);
        this.cPD.notifyDataSetChanged();
    }

    public void au(List<com.baidu.tieba.im.data.a> list) {
        this.cPD.au(list);
        this.cPD.notifyDataSetChanged();
    }

    public a axb() {
        return this.cPD;
    }
}

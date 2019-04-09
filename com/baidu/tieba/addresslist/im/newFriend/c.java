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
    private View buc;
    private NewFriendsActivity cPC;
    private BdListView cPD;
    private a cPE;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.cPC = newFriendsActivity;
        this.buc = this.cPC.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.cPC.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cPC.getPageContext().getString(d.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, this.cPC).findViewById(d.g.new_friend_search);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.cPD = (BdListView) this.cPC.findViewById(d.g.new_friend_listview);
        this.cPE = new a(this.cPC);
        this.cPD.setAdapter((ListAdapter) this.cPE);
        this.cPD.setOnItemClickListener(this.cPC);
        this.cPD.setOnItemLongClickListener(this.cPC);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.cPD.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.cPC.getActivity(), this.cPD, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.cPC.getPageContext().getPageActivity(), this.buc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.cPC.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.cPD.startPullRefresh();
    }

    public void completePullRefresh() {
        this.cPD.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.cPE.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.cPC.getPageContext(), i);
        this.mPullView.ib(i);
        cVar.onModeChanged(this.buc);
        this.mNoDataView.onChangeSkinType(this.cPC.getPageContext(), i);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.cPD.setEmptyView(this.mNoDataView);
        this.cPE.setData(list);
        this.cPE.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.cPE.a(aVar);
        this.cPE.notifyDataSetChanged();
    }

    public void au(List<com.baidu.tieba.im.data.a> list) {
        this.cPE.au(list);
        this.cPE.notifyDataSetChanged();
    }

    public a axb() {
        return this.cPE;
    }
}

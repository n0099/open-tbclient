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
    private View btY;
    private BdListView cPA;
    private a cPB;
    private NewFriendsActivity cPz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.cPz = newFriendsActivity;
        this.btY = this.cPz.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.cPz.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cPz.getPageContext().getString(d.j.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, this.cPz).findViewById(d.g.new_friend_search);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.cPA = (BdListView) this.cPz.findViewById(d.g.new_friend_listview);
        this.cPB = new a(this.cPz);
        this.cPA.setAdapter((ListAdapter) this.cPB);
        this.cPA.setOnItemClickListener(this.cPz);
        this.cPA.setOnItemLongClickListener(this.cPz);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.cPA.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.cPz.getActivity(), this.cPA, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.cPz.getPageContext().getPageActivity(), this.btY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.cPz.getActivity(), d.e.ds320)), NoDataViewFactory.d.hU(d.j.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.cPA.startPullRefresh();
    }

    public void completePullRefresh() {
        this.cPA.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.cPB.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.cPz.getPageContext(), i);
        this.mPullView.ic(i);
        cVar.onModeChanged(this.btY);
        this.mNoDataView.onChangeSkinType(this.cPz.getPageContext(), i);
        al.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.cPA.setEmptyView(this.mNoDataView);
        this.cPB.setData(list);
        this.cPB.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.cPB.a(aVar);
        this.cPB.notifyDataSetChanged();
    }

    public void au(List<com.baidu.tieba.im.data.a> list) {
        this.cPB.au(list);
        this.cPB.notifyDataSetChanged();
    }

    public a axe() {
        return this.cPB;
    }
}

package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View Tl;
    private NewFriendsActivity bfo;
    private BdListView bfp;
    private a bfq;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private f mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.bfo = newFriendsActivity;
        this.Tl = this.bfo.findViewById(d.g.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bfo.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bfo.getPageContext().getString(d.k.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, this.bfo).findViewById(d.g.new_friend_search);
        ak.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.bfp = (BdListView) this.bfo.findViewById(d.g.new_friend_listview);
        this.bfq = new a(this.bfo);
        this.bfp.setAdapter((ListAdapter) this.bfq);
        this.bfp.setOnItemClickListener(this.bfo);
        this.bfp.setOnItemLongClickListener(this.bfo);
        this.mPullView = new f(newFriendsActivity.getPageContext());
        this.bfp.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.bfo.getActivity(), this.bfp, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.bfo.getPageContext().getPageActivity(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.bfo.getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.k.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.bfp.startPullRefresh();
    }

    public void completePullRefresh() {
        this.bfp.completePullRefreshPostDelayed(2000L);
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(a.b bVar) {
        this.bfq.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.bfo.getPageContext(), i);
        this.mPullView.dw(i);
        cVar.u(this.Tl);
        this.mNoDataView.onChangeSkinType(this.bfo.getPageContext(), i);
        ak.a(this.mSearchButton, d.f.icon_search_bg_s, d.f.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.bfp.setEmptyView(this.mNoDataView);
        this.bfq.setData(list);
        this.bfq.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.bfq.a(aVar);
        this.bfq.notifyDataSetChanged();
    }

    public void U(List<com.baidu.tieba.im.data.a> list) {
        this.bfq.U(list);
        this.bfq.notifyDataSetChanged();
    }

    public a NA() {
        return this.bfq;
    }
}

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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity cZl;
    private BdListView cZm;
    private a cZn;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.cZl = newFriendsActivity;
        this.mRoot = this.cZl.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.cZl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cZl.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.cZl).findViewById(R.id.new_friend_search);
        am.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.cZm = (BdListView) this.cZl.findViewById(R.id.new_friend_listview);
        this.cZn = new a(this.cZl);
        this.cZm.setAdapter((ListAdapter) this.cZn);
        this.cZm.setOnItemClickListener(this.cZl);
        this.cZm.setOnItemLongClickListener(this.cZl);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.cZm.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.cZl.getActivity(), this.cZm, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.cZl.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cZl.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.cZm.startPullRefresh();
    }

    public void completePullRefresh() {
        this.cZm.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.cZn.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.cZl.getPageContext(), i);
        this.mPullView.iV(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.cZl.getPageContext(), i);
        am.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.cZm.setEmptyView(this.mNoDataView);
        this.cZn.setData(list);
        this.cZn.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.cZn.a(aVar);
        this.cZn.notifyDataSetChanged();
    }

    public void aB(List<com.baidu.tieba.im.data.a> list) {
        this.cZn.aB(list);
        this.cZn.notifyDataSetChanged();
    }

    public a aDA() {
        return this.cZn;
    }
}

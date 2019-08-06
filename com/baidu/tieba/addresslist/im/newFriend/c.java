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
    private NewFriendsActivity cZs;
    private BdListView cZt;
    private a cZu;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.cZs = newFriendsActivity;
        this.mRoot = this.cZs.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.cZs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cZs.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.cZs).findViewById(R.id.new_friend_search);
        am.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.cZt = (BdListView) this.cZs.findViewById(R.id.new_friend_listview);
        this.cZu = new a(this.cZs);
        this.cZt.setAdapter((ListAdapter) this.cZu);
        this.cZt.setOnItemClickListener(this.cZs);
        this.cZt.setOnItemLongClickListener(this.cZs);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.cZt.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.cZs.getActivity(), this.cZt, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.cZs.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cZs.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.cZt.startPullRefresh();
    }

    public void completePullRefresh() {
        this.cZt.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.cZu.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.cZs.getPageContext(), i);
        this.mPullView.iV(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.cZs.getPageContext(), i);
        am.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.cZt.setEmptyView(this.mNoDataView);
        this.cZu.setData(list);
        this.cZu.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.cZu.a(aVar);
        this.cZu.notifyDataSetChanged();
    }

    public void aB(List<com.baidu.tieba.im.data.a> list) {
        this.cZu.aB(list);
        this.cZu.notifyDataSetChanged();
    }

    public a aDC() {
        return this.cZu;
    }
}

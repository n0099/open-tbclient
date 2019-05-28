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
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private View bBg;
    private NewFriendsActivity cXO;
    private BdListView cXP;
    private a cXQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.cXO = newFriendsActivity;
        this.bBg = this.cXO.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.cXO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cXO.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.cXO).findViewById(R.id.new_friend_search);
        al.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.cXP = (BdListView) this.cXO.findViewById(R.id.new_friend_listview);
        this.cXQ = new a(this.cXO);
        this.cXP.setAdapter((ListAdapter) this.cXQ);
        this.cXP.setOnItemClickListener(this.cXO);
        this.cXP.setOnItemLongClickListener(this.cXO);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.cXP.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.cXO.getActivity(), this.cXP, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.cXO.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cXO.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.cXP.startPullRefresh();
    }

    public void completePullRefresh() {
        this.cXP.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.cXQ.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.cXO.getPageContext(), i);
        this.mPullView.iP(i);
        cVar.onModeChanged(this.bBg);
        this.mNoDataView.onChangeSkinType(this.cXO.getPageContext(), i);
        al.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.cXP.setEmptyView(this.mNoDataView);
        this.cXQ.setData(list);
        this.cXQ.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.cXQ.a(aVar);
        this.cXQ.notifyDataSetChanged();
    }

    public void aB(List<com.baidu.tieba.im.data.a> list) {
        this.cXQ.aB(list);
        this.cXQ.notifyDataSetChanged();
    }

    public a aCk() {
        return this.cXQ;
    }
}

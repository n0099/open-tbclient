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
    private NewFriendsActivity cXP;
    private BdListView cXQ;
    private a cXR;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i mPullView;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.cXP = newFriendsActivity;
        this.bBg = this.cXP.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.cXP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cXP.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.cXP).findViewById(R.id.new_friend_search);
        al.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.cXQ = (BdListView) this.cXP.findViewById(R.id.new_friend_listview);
        this.cXR = new a(this.cXP);
        this.cXQ.setAdapter((ListAdapter) this.cXR);
        this.cXQ.setOnItemClickListener(this.cXP);
        this.cXQ.setOnItemLongClickListener(this.cXP);
        this.mPullView = new i(newFriendsActivity.getPageContext());
        this.cXQ.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.cXP.getActivity(), this.cXQ, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.cXP.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cXP.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.cXQ.startPullRefresh();
    }

    public void completePullRefresh() {
        this.cXQ.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.cXR.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.cXP.getPageContext(), i);
        this.mPullView.iP(i);
        cVar.onModeChanged(this.bBg);
        this.mNoDataView.onChangeSkinType(this.cXP.getPageContext(), i);
        al.a(this.mSearchButton, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.cXQ.setEmptyView(this.mNoDataView);
        this.cXR.setData(list);
        this.cXR.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.cXR.a(aVar);
        this.cXR.notifyDataSetChanged();
    }

    public void aB(List<com.baidu.tieba.im.data.a> list) {
        this.cXR.aB(list);
        this.cXR.notifyDataSetChanged();
    }

    public a aCk() {
        return this.cXR;
    }
}

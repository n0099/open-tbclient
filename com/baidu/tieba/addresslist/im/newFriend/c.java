package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<NewFriendsActivity> {
    private NewFriendsActivity glO;
    private BdListView glP;
    private a glQ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.glO = newFriendsActivity;
        this.mRoot = this.glO.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.glO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.glO.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.glO).findViewById(R.id.new_friend_search);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.glP = (BdListView) this.glO.findViewById(R.id.new_friend_listview);
        this.glQ = new a(this.glO);
        this.glP.setAdapter((ListAdapter) this.glQ);
        this.glP.setOnItemClickListener(this.glO);
        this.glP.setOnItemLongClickListener(this.glO);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.glP.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.glO.getActivity(), this.glP, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.glO.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.glO.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.glP.startPullRefresh();
    }

    public void completePullRefresh() {
        this.glP.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.glQ.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.glO.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.glO.getPageContext(), i);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.glP.setEmptyView(this.mNoDataView);
        this.glQ.setData(list);
        this.glQ.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.glQ.a(aVar);
        this.glQ.notifyDataSetChanged();
    }

    public void cb(List<com.baidu.tieba.im.data.a> list) {
        this.glQ.cb(list);
        this.glQ.notifyDataSetChanged();
    }

    public a bPx() {
        return this.glQ;
    }
}

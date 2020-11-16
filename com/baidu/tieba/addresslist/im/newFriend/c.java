package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity fUl;
    private BdListView fUm;
    private a fUn;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.fUl = newFriendsActivity;
        this.mRoot = this.fUl.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.fUl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fUl.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.fUl).findViewById(R.id.new_friend_search);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.fUm = (BdListView) this.fUl.findViewById(R.id.new_friend_listview);
        this.fUn = new a(this.fUl);
        this.fUm.setAdapter((ListAdapter) this.fUn);
        this.fUm.setOnItemClickListener(this.fUl);
        this.fUm.setOnItemLongClickListener(this.fUl);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.fUm.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.fUl.getActivity(), this.fUm, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.fUl.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.fUl.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qo(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.fUm.startPullRefresh();
    }

    public void completePullRefresh() {
        this.fUm.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.fUn.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.fUl.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.fUl.getPageContext(), i);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.fUm.setEmptyView(this.mNoDataView);
        this.fUn.setData(list);
        this.fUn.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.fUn.a(aVar);
        this.fUn.notifyDataSetChanged();
    }

    public void bQ(List<com.baidu.tieba.im.data.a> list) {
        this.fUn.bQ(list);
        this.fUn.notifyDataSetChanged();
    }

    public a bJw() {
        return this.fUn;
    }
}

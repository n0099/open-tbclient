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
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity gcx;
    private BdListView gcy;
    private a gcz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.gcx = newFriendsActivity;
        this.mRoot = this.gcx.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.gcx.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gcx.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.gcx).findViewById(R.id.new_friend_search);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.gcy = (BdListView) this.gcx.findViewById(R.id.new_friend_listview);
        this.gcz = new a(this.gcx);
        this.gcy.setAdapter((ListAdapter) this.gcz);
        this.gcy.setOnItemClickListener(this.gcx);
        this.gcy.setOnItemLongClickListener(this.gcx);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.gcy.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.gcx.getActivity(), this.gcy, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.gcx.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.gcx.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.gcy.startPullRefresh();
    }

    public void completePullRefresh() {
        this.gcy.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.gcz.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.gcx.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.gcx.getPageContext(), i);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.gcy.setEmptyView(this.mNoDataView);
        this.gcz.setData(list);
        this.gcz.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.gcz.a(aVar);
        this.gcz.notifyDataSetChanged();
    }

    public void bU(List<com.baidu.tieba.im.data.a> list) {
        this.gcz.bU(list);
        this.gcz.notifyDataSetChanged();
    }

    public a bNf() {
        return this.gcz;
    }
}

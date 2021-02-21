package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.d;
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
/* loaded from: classes8.dex */
public class c extends d<NewFriendsActivity> {
    private NewFriendsActivity gjJ;
    private BdListView gjK;
    private a gjL;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.gjJ = newFriendsActivity;
        this.mRoot = this.gjJ.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.gjJ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gjJ.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.gjJ).findViewById(R.id.new_friend_search);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.gjK = (BdListView) this.gjJ.findViewById(R.id.new_friend_listview);
        this.gjL = new a(this.gjJ);
        this.gjK.setAdapter((ListAdapter) this.gjL);
        this.gjK.setOnItemClickListener(this.gjJ);
        this.gjK.setOnItemLongClickListener(this.gjJ);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.gjK.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.gjJ.getActivity(), this.gjK, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.gjJ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.gjJ.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.gjK.startPullRefresh();
    }

    public void completePullRefresh() {
        this.gjK.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.gjL.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.gjJ.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.gjJ.getPageContext(), i);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.gjK.setEmptyView(this.mNoDataView);
        this.gjL.setData(list);
        this.gjL.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.gjL.a(aVar);
        this.gjL.notifyDataSetChanged();
    }

    public void bW(List<com.baidu.tieba.im.data.a> list) {
        this.gjL.bW(list);
        this.gjL.notifyDataSetChanged();
    }

    public a bMh() {
        return this.gjL;
    }
}

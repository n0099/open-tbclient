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
/* loaded from: classes7.dex */
public class c extends d<NewFriendsActivity> {
    private NewFriendsActivity glm;
    private BdListView gln;
    private a glo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.glm = newFriendsActivity;
        this.mRoot = this.glm.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.glm.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.glm.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.glm).findViewById(R.id.new_friend_search);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.gln = (BdListView) this.glm.findViewById(R.id.new_friend_listview);
        this.glo = new a(this.glm);
        this.gln.setAdapter((ListAdapter) this.glo);
        this.gln.setOnItemClickListener(this.glm);
        this.gln.setOnItemLongClickListener(this.glm);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.gln.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.glm.getActivity(), this.gln, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.glm.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.glm.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pA(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.gln.startPullRefresh();
    }

    public void completePullRefresh() {
        this.gln.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.glo.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.glm.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.glm.getPageContext(), i);
        this.mSearchButton.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_search40, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.gln.setEmptyView(this.mNoDataView);
        this.glo.setData(list);
        this.glo.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.glo.a(aVar);
        this.glo.notifyDataSetChanged();
    }

    public void bW(List<com.baidu.tieba.im.data.a> list) {
        this.glo.bW(list);
        this.glo.notifyDataSetChanged();
    }

    public a bMl() {
        return this.glo;
    }
}

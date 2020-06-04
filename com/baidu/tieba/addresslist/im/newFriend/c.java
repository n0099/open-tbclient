package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SvgManager;
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
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity eQM;
    private BdListView eQN;
    private a eQO;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.eQM = newFriendsActivity;
        this.mRoot = this.eQM.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.eQM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eQM.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.eQM).findViewById(R.id.new_friend_search);
        SvgManager.aUW().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.eQN = (BdListView) this.eQM.findViewById(R.id.new_friend_listview);
        this.eQO = new a(this.eQM);
        this.eQN.setAdapter((ListAdapter) this.eQO);
        this.eQN.setOnItemClickListener(this.eQM);
        this.eQN.setOnItemLongClickListener(this.eQM);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.eQN.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.eQM.getActivity(), this.eQN, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.eQM.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.eQM.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lV(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.eQN.startPullRefresh();
    }

    public void completePullRefresh() {
        this.eQN.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.eQO.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.eQM.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.eQM.getPageContext(), i);
        SvgManager.aUW().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.eQN.setEmptyView(this.mNoDataView);
        this.eQO.setData(list);
        this.eQO.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.eQO.a(aVar);
        this.eQO.notifyDataSetChanged();
    }

    public void be(List<com.baidu.tieba.im.data.a> list) {
        this.eQO.be(list);
        this.eQO.notifyDataSetChanged();
    }

    public a bnm() {
        return this.eQO;
    }
}

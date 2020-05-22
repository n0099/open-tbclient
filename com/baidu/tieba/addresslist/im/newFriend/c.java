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
    private NewFriendsActivity eQB;
    private BdListView eQC;
    private a eQD;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.eQB = newFriendsActivity;
        this.mRoot = this.eQB.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.eQB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eQB.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.eQB).findViewById(R.id.new_friend_search);
        SvgManager.aUV().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.eQC = (BdListView) this.eQB.findViewById(R.id.new_friend_listview);
        this.eQD = new a(this.eQB);
        this.eQC.setAdapter((ListAdapter) this.eQD);
        this.eQC.setOnItemClickListener(this.eQB);
        this.eQC.setOnItemLongClickListener(this.eQB);
        this.mPullView = new g(newFriendsActivity.getPageContext());
        this.eQC.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.eQB.getActivity(), this.eQC, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.eQB.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.eQB.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lT(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.eQC.startPullRefresh();
    }

    public void completePullRefresh() {
        this.eQC.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.eQD.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.eQB.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.eQB.getPageContext(), i);
        SvgManager.aUV().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.eQC.setEmptyView(this.mNoDataView);
        this.eQD.setData(list);
        this.eQD.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.eQD.a(aVar);
        this.eQD.notifyDataSetChanged();
    }

    public void be(List<com.baidu.tieba.im.data.a> list) {
        this.eQD.be(list);
        this.eQD.notifyDataSetChanged();
    }

    public a bnk() {
        return this.eQD;
    }
}

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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.c<NewFriendsActivity> {
    private NewFriendsActivity ebG;
    private BdListView ebH;
    private a ebI;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mPullView;
    private View mRoot;
    private ImageView mSearchButton;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.ebG = newFriendsActivity;
        this.mRoot = this.ebG.findViewById(R.id.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.ebG.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ebG.getPageContext().getString(R.string.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSearchButton = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.ebG).findViewById(R.id.new_friend_search);
        SvgManager.aGA().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ebH = (BdListView) this.ebG.findViewById(R.id.new_friend_listview);
        this.ebI = new a(this.ebG);
        this.ebH.setAdapter((ListAdapter) this.ebI);
        this.ebH.setOnItemClickListener(this.ebG);
        this.ebH.setOnItemLongClickListener(this.ebG);
        this.mPullView = new h(newFriendsActivity.getPageContext());
        this.ebH.setPullRefresh(this.mPullView);
        BdListViewHelper.a(this.ebG.getActivity(), this.ebH, BdListViewHelper.HeadType.DEFAULT);
        this.mNoDataView = NoDataViewFactory.a(this.ebG.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.ebG.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.no_new_friend_hint), null);
    }

    public void startPullRefresh() {
        this.ebH.startPullRefresh();
    }

    public void completePullRefresh() {
        this.ebH.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(a.b bVar) {
        this.ebI.a(bVar);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(this.ebG.getPageContext(), i);
        this.mPullView.changeSkin(i);
        cVar.onModeChanged(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.ebG.getPageContext(), i);
        SvgManager.aGA().a(this.mSearchButton, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.ebH.setEmptyView(this.mNoDataView);
        this.ebI.setData(list);
        this.ebI.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        this.ebI.a(aVar);
        this.ebI.notifyDataSetChanged();
    }

    public void aZ(List<com.baidu.tieba.im.data.a> list) {
        this.ebI.aZ(list);
        this.ebI.notifyDataSetChanged();
    }

    public a aYQ() {
        return this.ebI;
    }
}

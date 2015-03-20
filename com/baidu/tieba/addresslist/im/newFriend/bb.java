package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.g<NewFriendsActivity> {
    private NewFriendsActivity ayC;
    private BdListView ayD;
    private ai ayE;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private com.baidu.tbadk.core.view.ag mPullView;
    private View mRoot;

    public bb(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.ayC = newFriendsActivity;
        this.mRoot = this.ayC.findViewById(com.baidu.tieba.v.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.ayC.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ayC.getPageContext().getString(com.baidu.tieba.y.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, this.ayC);
        this.ayD = (BdListView) this.ayC.findViewById(com.baidu.tieba.v.new_friend_listview);
        this.ayE = new ai(this.ayC);
        this.ayD.setAdapter((ListAdapter) this.ayE);
        this.ayD.setOnItemClickListener(this.ayC);
        this.ayD.setOnItemLongClickListener(this.ayC);
        this.mPullView = new com.baidu.tbadk.core.view.ag(newFriendsActivity.getPageContext());
        this.ayD.setPullRefresh(this.mPullView);
        this.mNoDataView = NoDataViewFactory.a(this.ayC.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_new_friend_hint), null);
    }

    public void mX() {
        this.ayD.mX();
    }

    public void mW() {
        this.ayD.mW();
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void a(ak akVar) {
        this.ayE.a(akVar);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        cVar.X(i == 1);
        this.mNavigationBar.onChangeSkinType(this.ayC.getPageContext(), i);
        this.mPullView.ct(i);
        cVar.h(this.mRoot);
        this.mNoDataView.onChangeSkinType(this.ayC.getPageContext(), i);
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.ayD.setEmptyView(this.mNoDataView);
        this.ayE.setData(list);
        this.ayE.notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.im.data.b bVar) {
        this.ayE.a(bVar);
        this.ayE.notifyDataSetChanged();
    }

    public void w(List<com.baidu.tieba.im.data.b> list) {
        this.ayE.w(list);
        this.ayE.notifyDataSetChanged();
    }

    public ai Fc() {
        return this.ayE;
    }
}

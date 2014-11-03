package com.baidu.tieba.im.newFriend;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.f {
    private com.baidu.tbadk.core.view.y Yg;
    private com.baidu.tbadk.core.view.o ahX;
    private BaseActivity bho;
    private BdListView bhp;
    private ah bhq;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public az(BaseActivity baseActivity) {
        super(baseActivity);
        this.bho = baseActivity;
        this.mRoot = this.bho.findViewById(com.baidu.tieba.v.new_friend_activity);
        this.mNavigationBar = (NavigationBar) this.bho.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bho.getString(com.baidu.tieba.y.new_friends));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, this.bho);
        this.bhp = (BdListView) this.bho.findViewById(com.baidu.tieba.v.new_friend_listview);
        this.bhq = new ah(this.bho);
        this.bhp.setAdapter((ListAdapter) this.bhq);
        this.bhp.setOnItemClickListener(this.bho);
        this.bhp.setOnItemLongClickListener(this.bho);
        this.Yg = new com.baidu.tbadk.core.view.y(baseActivity);
        this.bhp.setPullRefresh(this.Yg);
        this.ahX = NoDataViewFactory.a(this.bho, this.mRoot, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.no_new_friend_hint), null);
    }

    public void hO() {
        this.bhp.hO();
    }

    public void hN() {
        this.bhp.hN();
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void a(aj ajVar) {
        this.bhq.a(ajVar);
    }

    public void a(com.baidu.tbadk.core.d dVar, int i) {
        dVar.L(i == 1);
        this.mNavigationBar.onChangeSkinType(i);
        this.Yg.bM(i);
        dVar.h(this.mRoot);
        this.ahX.onChangeSkinType(i);
    }

    public void setData(List<com.baidu.tieba.im.data.e> list) {
        this.bhp.setEmptyView(this.ahX);
        this.bhq.setData(list);
        this.bhq.notifyDataSetChanged();
    }

    public void c(com.baidu.tieba.im.data.e eVar) {
        this.bhq.c(eVar);
        this.bhq.notifyDataSetChanged();
    }

    public void ab(List<com.baidu.tieba.im.data.e> list) {
        this.bhq.ab(list);
        this.bhq.notifyDataSetChanged();
    }

    public ah Ro() {
        return this.bhq;
    }
}

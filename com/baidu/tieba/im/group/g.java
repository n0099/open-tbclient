package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f {
    private y Yc;
    private DiscoverMoreActivity aYt;
    private NoNetworkView aYu;
    private b aYv;
    private NavigationBar aog;
    private View mRoot;
    private BdListView vl;

    public g(DiscoverMoreActivity discoverMoreActivity) {
        super(discoverMoreActivity);
        this.Yc = null;
        this.aYt = discoverMoreActivity;
        nu();
    }

    private void nu() {
        this.mRoot = View.inflate(this.aYt, w.discover_group_activity, null);
        this.aYt.setContentView(this.mRoot);
        this.aog = (NavigationBar) this.mRoot.findViewById(v.discovergroup_navigation_bar);
        this.aog.setTitleText(com.baidu.tieba.y.msglist_personInfo);
        this.aog.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aYu = (NoNetworkView) this.mRoot.findViewById(v.discovergroup_no_network);
        this.aYu.a(new h(this));
        this.vl = (BdListView) this.mRoot.findViewById(v.list_view);
        this.Yc = new y(this.aYt);
        this.Yc.a(new i(this));
        this.vl.setPullRefresh(this.Yc);
        this.aYv = new b(this.aYt);
        this.vl.setAdapter((ListAdapter) this.aYv);
    }

    public void w(ArrayList<com.baidu.tbadk.b.a.a> arrayList) {
        if (arrayList != null) {
            this.aYv.v(arrayList);
        }
    }

    public BdListView ud() {
        return this.vl;
    }

    public b NW() {
        return this.aYv;
    }

    public void onChangeSkinType(int i) {
        this.aYt.getLayoutMode().L(i == 1);
        this.aYt.getLayoutMode().h(this.mRoot);
        this.aog.onChangeSkinType(i);
        this.aYu.onChangeSkinType(i);
        this.Yc.bM(i);
    }

    public void fL(int i) {
        if (this.aYv != null) {
            this.aYv.fL(i);
        }
    }

    public void gf(String str) {
        if (this.aYv != null) {
            this.aYv.gf(str);
        }
    }
}

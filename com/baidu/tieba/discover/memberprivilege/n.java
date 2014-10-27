package com.baidu.tieba.discover.memberprivilege;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f {
    private View HS;
    private NoNetworkView aoJ;
    private j apU;
    private MemberPrivilegeActivity apz;
    private NavigationBar mNavigationBar;
    private BdListView vl;

    public n(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity);
        this.apz = memberPrivilegeActivity;
        nu();
    }

    private void nu() {
        this.apz.setContentView(w.memberprivilege_activity);
        this.HS = this.apz.findViewById(v.root);
        this.mNavigationBar = (NavigationBar) this.HS.findViewById(v.navigationbar);
        this.mNavigationBar.setTitleText(y.member_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoJ = (NoNetworkView) this.HS.findViewById(v.nonetworkview);
        this.aoJ.a(new o(this));
        this.vl = (BdListView) this.HS.findViewById(v.listview);
        this.apU = new j(this.apz);
        this.vl.setAdapter((ListAdapter) this.apU);
        this.vl.setOnItemClickListener(this.apz);
    }

    public j AY() {
        return this.apU;
    }

    public void onChangeSkinType(int i) {
        this.apz.getLayoutMode().L(i == 1);
        this.apz.getLayoutMode().h(this.HS);
        this.mNavigationBar.onChangeSkinType(i);
        this.aoJ.onChangeSkinType(i);
    }
}

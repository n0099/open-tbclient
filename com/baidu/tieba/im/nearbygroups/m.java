package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.view.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f {
    private y Yg;
    private View agI;
    private NoNetworkView atH;
    private TextView bgG;
    private h bgH;
    private PinnedHeaderListView bgI;
    private s bgJ;
    private NearbyGroupsActivity bgr;
    private NavigationBar mNavigationBar;

    public m(NearbyGroupsActivity nearbyGroupsActivity) {
        super(nearbyGroupsActivity);
        this.mNavigationBar = null;
        this.bgr = null;
        this.agI = null;
        this.bgG = null;
        this.bgH = null;
        this.bgI = null;
        this.Yg = null;
        this.atH = null;
        this.bgJ = null;
        this.bgr = nearbyGroupsActivity;
        init();
    }

    private void init() {
        this.bgH = new h(this.bgr);
        this.bgJ = new s(this.bgr);
        this.bgr.setContentView(w.nearby_group_activity);
        this.agI = this.bgr.findViewById(v.parent);
        this.bgI = (PinnedHeaderListView) this.bgr.findViewById(v.nearby_list);
        this.mNavigationBar = (NavigationBar) this.bgr.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bgr.getResources().getString(com.baidu.tieba.y.nearby_group_title));
        this.bgG = this.mNavigationBar.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.bgr);
        this.atH = (NoNetworkView) this.bgr.findViewById(v.view_no_network);
        this.Yg = new y(this.bgr);
        this.bgI.setPullRefresh(this.Yg);
        this.bgI.setAdapter((ListAdapter) this.bgH);
        this.bgI.setNextPage(this.bgJ);
    }

    public PinnedHeaderListView Rd() {
        return this.bgI;
    }

    public void Er() {
        this.bgJ.Er();
    }

    public void DI() {
        this.bgJ.DI();
    }

    public void DH() {
        this.bgJ.DH();
    }

    public void a(aa aaVar) {
        this.bgI.setOnSrollToBottomListener(aaVar);
    }

    public void h(View.OnClickListener onClickListener) {
        this.bgJ.setOnClickListener(onClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void NT() {
        this.bgI.hO();
    }

    public void Re() {
        this.bgI.hN();
    }

    public int Rf() {
        return this.bgG.getId();
    }

    public void dq(boolean z) {
        this.bgH.dq(z);
        Rg();
    }

    public void dr(boolean z) {
        this.bgH.dr(z);
        Rg();
    }

    public NearbyGroupsData Rb() {
        return this.bgH.Rb();
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        this.bgH.a(nearbyGroupsData);
        Rg();
    }

    private void Rg() {
        NearbyGroupsData Rb = this.bgH.Rb();
        if (Rb == null || Rb.size() == 0) {
            this.bgJ.hide();
        } else {
            this.bgJ.Bc();
        }
    }

    public void onChangeSkinType(int i) {
        this.bgr.getLayoutMode().L(i == 1);
        aw.d(this.agI, i);
        this.Yg.bM(i);
        this.mNavigationBar.onChangeSkinType(i);
        this.atH.onChangeSkinType(i);
        this.bgJ.cu(i);
        this.bgr.getLayoutMode().h(this.agI);
    }
}

package com.baidu.tieba.faceshop;

import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class bb {
    private final com.baidu.tbadk.core.view.y Yc;
    private final NoNetworkView aoJ;
    private final NavigationBar atx;
    private aw auk;
    private final BaseActivity mActivity;
    private final LinearLayout mParent;
    private final BdListView vl;

    public bb(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        baseActivity.setContentView(ca.face_purchase_records_layout);
        this.mParent = (LinearLayout) baseActivity.findViewById(bz.purchase_record);
        this.atx = (NavigationBar) this.mParent.findViewById(bz.view_navigation_bar);
        this.atx.setTitleText(baseActivity.getResources().getString(cb.purchase_record));
        this.atx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoJ = (NoNetworkView) this.mParent.findViewById(bz.view_no_network);
        this.vl = (BdListView) this.mParent.findViewById(bz.purchase_record_list);
        this.Yc = new com.baidu.tbadk.core.view.y(baseActivity);
        this.vl.setPullRefresh(this.Yc);
    }

    public void c(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.auk == null) {
            this.auk = new aw(this.mActivity);
            this.vl.setAdapter((ListAdapter) this.auk);
        }
        this.auk.a(facePurchaseRecordsData);
        Dv();
    }

    public aw Du() {
        return this.auk;
    }

    public void Dv() {
        this.vl.hN();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.vl.setOnItemClickListener(onItemClickListener);
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.aoJ.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.aoJ.b(uVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        this.atx.onChangeSkinType(i);
        this.aoJ.onChangeSkinType(i);
        this.Yc.bM(i);
    }
}

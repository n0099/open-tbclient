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
    private final com.baidu.tbadk.core.view.y Yg;
    private final NoNetworkView aoS;
    private final NavigationBar atG;
    private aw aut;
    private final BaseActivity mActivity;
    private final LinearLayout mParent;
    private final BdListView vl;

    public bb(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        baseActivity.setContentView(ca.face_purchase_records_layout);
        this.mParent = (LinearLayout) baseActivity.findViewById(bz.purchase_record);
        this.atG = (NavigationBar) this.mParent.findViewById(bz.view_navigation_bar);
        this.atG.setTitleText(baseActivity.getResources().getString(cb.purchase_record));
        this.atG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoS = (NoNetworkView) this.mParent.findViewById(bz.view_no_network);
        this.vl = (BdListView) this.mParent.findViewById(bz.purchase_record_list);
        this.Yg = new com.baidu.tbadk.core.view.y(baseActivity);
        this.vl.setPullRefresh(this.Yg);
    }

    public void c(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.aut == null) {
            this.aut = new aw(this.mActivity);
            this.vl.setAdapter((ListAdapter) this.aut);
        }
        this.aut.a(facePurchaseRecordsData);
        Dx();
    }

    public aw Dw() {
        return this.aut;
    }

    public void Dx() {
        this.vl.hN();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.vl.setOnItemClickListener(onItemClickListener);
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.aoS.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.aoS.b(uVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        this.atG.onChangeSkinType(i);
        this.aoS.onChangeSkinType(i);
        this.Yg.bM(i);
    }
}

package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View ebm;
    private View ebq;
    private ProgressBar edA;
    private Button edB;
    private Button edC;
    private Button edD;
    private View edE;
    private View edF;
    private UpdatesActivity edm;
    private BdListView edy;
    private a edz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.edm = updatesActivity;
        initView();
        this.edz = new a(this.edm);
        this.edy.setAdapter((ListAdapter) this.edz);
        this.edy.setOnScrollListener(this.edm);
    }

    void initView() {
        this.ebm = View.inflate(this.edm.getPageContext().getPageActivity(), d.i.updates_activity, null);
        this.edm.setContentView(this.ebm);
        this.mNavigationBar = (NavigationBar) this.edm.findViewById(d.g.view_navigation_bar);
        this.ebq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.edm.getPageContext().getString(d.k.updates_activity_title));
        this.edE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.updates_activity_nav_left, (View.OnClickListener) null);
        this.edF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.updates_activity_nav_right, (View.OnClickListener) null);
        this.edD = (Button) this.edE.findViewById(d.g.btn_delete);
        this.edD.setOnClickListener(this.edm);
        this.ebq.setOnClickListener(this.edm);
        this.edy = (BdListView) this.ebm.findViewById(d.g.updates_list);
        this.edA = (ProgressBar) this.ebm.findViewById(d.g.pro_load);
        this.edB = (Button) this.edF.findViewById(d.g.btn_edit);
        this.edB.setOnClickListener(this.edm);
        this.edC = (Button) this.edF.findViewById(d.g.btn_cancel);
        this.edC.setOnClickListener(this.edm);
        nJ(0);
        hp(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.edz != null) {
            this.edz.destroy();
            this.edz = null;
        }
        this.edm = null;
    }

    public a aFo() {
        return this.edz;
    }

    public void aFp() {
        this.edB.setVisibility(8);
        this.ebq.setVisibility(8);
        this.edC.setVisibility(0);
        this.edE.setVisibility(0);
        aEf();
    }

    public void aFq() {
        this.edB.setVisibility(0);
        this.ebq.setVisibility(0);
        this.edC.setVisibility(8);
        this.edE.setVisibility(8);
        nJ(0);
        aEf();
    }

    public void aEf() {
        if (this.edz != null) {
            this.edz.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.edz != null) {
            this.edz.setData(list);
        }
    }

    public void nJ(int i) {
        if (this.edD != null && this.edm != null) {
            this.edD.setText(String.format(this.edm.getPageContext().getString(d.k.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.edD.setEnabled(false);
            } else {
                this.edD.setEnabled(true);
            }
        }
    }

    public void hp(boolean z) {
        this.edA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.edm.getLayoutMode().setNightMode(i == 1);
        this.edm.getLayoutMode().u(this.ebm);
        this.mNavigationBar.onChangeSkinType(this.edm.getPageContext(), i);
        ak.i(this.edD, d.f.btn_delete_groupupdates);
    }

    public View aFr() {
        return this.ebq;
    }

    public BdListView aFs() {
        return this.edy;
    }

    public Button aFt() {
        return this.edB;
    }

    public Button aFu() {
        return this.edC;
    }

    public Button aFv() {
        return this.edD;
    }
}

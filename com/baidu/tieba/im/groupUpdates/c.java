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
    private View ebj;
    private View ebn;
    private Button edA;
    private View edB;
    private View edC;
    private UpdatesActivity edj;
    private BdListView edv;
    private a edw;
    private ProgressBar edx;
    private Button edy;
    private Button edz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.edj = updatesActivity;
        initView();
        this.edw = new a(this.edj);
        this.edv.setAdapter((ListAdapter) this.edw);
        this.edv.setOnScrollListener(this.edj);
    }

    void initView() {
        this.ebj = View.inflate(this.edj.getPageContext().getPageActivity(), d.i.updates_activity, null);
        this.edj.setContentView(this.ebj);
        this.mNavigationBar = (NavigationBar) this.edj.findViewById(d.g.view_navigation_bar);
        this.ebn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.edj.getPageContext().getString(d.k.updates_activity_title));
        this.edB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.updates_activity_nav_left, (View.OnClickListener) null);
        this.edC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.updates_activity_nav_right, (View.OnClickListener) null);
        this.edA = (Button) this.edB.findViewById(d.g.btn_delete);
        this.edA.setOnClickListener(this.edj);
        this.ebn.setOnClickListener(this.edj);
        this.edv = (BdListView) this.ebj.findViewById(d.g.updates_list);
        this.edx = (ProgressBar) this.ebj.findViewById(d.g.pro_load);
        this.edy = (Button) this.edC.findViewById(d.g.btn_edit);
        this.edy.setOnClickListener(this.edj);
        this.edz = (Button) this.edC.findViewById(d.g.btn_cancel);
        this.edz.setOnClickListener(this.edj);
        nJ(0);
        hp(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.edw != null) {
            this.edw.destroy();
            this.edw = null;
        }
        this.edj = null;
    }

    public a aFo() {
        return this.edw;
    }

    public void aFp() {
        this.edy.setVisibility(8);
        this.ebn.setVisibility(8);
        this.edz.setVisibility(0);
        this.edB.setVisibility(0);
        aEf();
    }

    public void aFq() {
        this.edy.setVisibility(0);
        this.ebn.setVisibility(0);
        this.edz.setVisibility(8);
        this.edB.setVisibility(8);
        nJ(0);
        aEf();
    }

    public void aEf() {
        if (this.edw != null) {
            this.edw.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.edw != null) {
            this.edw.setData(list);
        }
    }

    public void nJ(int i) {
        if (this.edA != null && this.edj != null) {
            this.edA.setText(String.format(this.edj.getPageContext().getString(d.k.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.edA.setEnabled(false);
            } else {
                this.edA.setEnabled(true);
            }
        }
    }

    public void hp(boolean z) {
        this.edx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.edj.getLayoutMode().setNightMode(i == 1);
        this.edj.getLayoutMode().u(this.ebj);
        this.mNavigationBar.onChangeSkinType(this.edj.getPageContext(), i);
        ak.i(this.edA, d.f.btn_delete_groupupdates);
    }

    public View aFr() {
        return this.ebn;
    }

    public BdListView aFs() {
        return this.edv;
    }

    public Button aFt() {
        return this.edy;
    }

    public Button aFu() {
        return this.edz;
    }

    public Button aFv() {
        return this.edA;
    }
}

package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View eVo;
    private View eVs;
    private Button eXA;
    private Button eXB;
    private Button eXC;
    private View eXD;
    private View eXE;
    private UpdatesActivity eXm;
    private BdListView eXx;
    private a eXy;
    private ProgressBar eXz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eXm = updatesActivity;
        initView();
        this.eXy = new a(this.eXm);
        this.eXx.setAdapter((ListAdapter) this.eXy);
        this.eXx.setOnScrollListener(this.eXm);
    }

    void initView() {
        this.eVo = View.inflate(this.eXm.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eXm.setContentView(this.eVo);
        this.mNavigationBar = (NavigationBar) this.eXm.findViewById(e.g.view_navigation_bar);
        this.eVs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eXm.getPageContext().getString(e.j.updates_activity_title));
        this.eXD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eXE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eXC = (Button) this.eXD.findViewById(e.g.btn_delete);
        this.eXC.setOnClickListener(this.eXm);
        this.eVs.setOnClickListener(this.eXm);
        this.eXx = (BdListView) this.eVo.findViewById(e.g.updates_list);
        this.eXz = (ProgressBar) this.eVo.findViewById(e.g.pro_load);
        this.eXA = (Button) this.eXE.findViewById(e.g.btn_edit);
        this.eXA.setOnClickListener(this.eXm);
        this.eXB = (Button) this.eXE.findViewById(e.g.btn_cancel);
        this.eXB.setOnClickListener(this.eXm);
        qr(0);
        iO(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eXy != null) {
            this.eXy.destroy();
            this.eXy = null;
        }
        this.eXm = null;
    }

    public a aTr() {
        return this.eXy;
    }

    public void aTs() {
        this.eXA.setVisibility(8);
        this.eVs.setVisibility(8);
        this.eXB.setVisibility(0);
        this.eXD.setVisibility(0);
        aSj();
    }

    public void aTt() {
        this.eXA.setVisibility(0);
        this.eVs.setVisibility(0);
        this.eXB.setVisibility(8);
        this.eXD.setVisibility(8);
        qr(0);
        aSj();
    }

    public void aSj() {
        if (this.eXy != null) {
            this.eXy.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eXy != null) {
            this.eXy.setData(list);
        }
    }

    public void qr(int i) {
        if (this.eXC != null && this.eXm != null) {
            this.eXC.setText(String.format(this.eXm.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eXC.setEnabled(false);
            } else {
                this.eXC.setEnabled(true);
            }
        }
    }

    public void iO(boolean z) {
        this.eXz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eXm.getLayoutMode().setNightMode(i == 1);
        this.eXm.getLayoutMode().onModeChanged(this.eVo);
        this.mNavigationBar.onChangeSkinType(this.eXm.getPageContext(), i);
        al.i(this.eXC, e.f.btn_delete_groupupdates);
    }

    public View aTu() {
        return this.eVs;
    }

    public BdListView aTv() {
        return this.eXx;
    }

    public Button aTw() {
        return this.eXA;
    }

    public Button aTx() {
        return this.eXB;
    }

    public Button aTy() {
        return this.eXC;
    }
}

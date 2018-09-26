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
    private View eCG;
    private View eCK;
    private UpdatesActivity eEE;
    private BdListView eEP;
    private a eEQ;
    private ProgressBar eER;
    private Button eES;
    private Button eET;
    private Button eEU;
    private View eEV;
    private View eEW;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eEE = updatesActivity;
        initView();
        this.eEQ = new a(this.eEE);
        this.eEP.setAdapter((ListAdapter) this.eEQ);
        this.eEP.setOnScrollListener(this.eEE);
    }

    void initView() {
        this.eCG = View.inflate(this.eEE.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eEE.setContentView(this.eCG);
        this.mNavigationBar = (NavigationBar) this.eEE.findViewById(e.g.view_navigation_bar);
        this.eCK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eEE.getPageContext().getString(e.j.updates_activity_title));
        this.eEV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eEW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eEU = (Button) this.eEV.findViewById(e.g.btn_delete);
        this.eEU.setOnClickListener(this.eEE);
        this.eCK.setOnClickListener(this.eEE);
        this.eEP = (BdListView) this.eCG.findViewById(e.g.updates_list);
        this.eER = (ProgressBar) this.eCG.findViewById(e.g.pro_load);
        this.eES = (Button) this.eEW.findViewById(e.g.btn_edit);
        this.eES.setOnClickListener(this.eEE);
        this.eET = (Button) this.eEW.findViewById(e.g.btn_cancel);
        this.eET.setOnClickListener(this.eEE);
        oT(0);
        ih(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eEQ != null) {
            this.eEQ.destroy();
            this.eEQ = null;
        }
        this.eEE = null;
    }

    public a aOa() {
        return this.eEQ;
    }

    public void aOb() {
        this.eES.setVisibility(8);
        this.eCK.setVisibility(8);
        this.eET.setVisibility(0);
        this.eEV.setVisibility(0);
        aMS();
    }

    public void aOc() {
        this.eES.setVisibility(0);
        this.eCK.setVisibility(0);
        this.eET.setVisibility(8);
        this.eEV.setVisibility(8);
        oT(0);
        aMS();
    }

    public void aMS() {
        if (this.eEQ != null) {
            this.eEQ.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eEQ != null) {
            this.eEQ.setData(list);
        }
    }

    public void oT(int i) {
        if (this.eEU != null && this.eEE != null) {
            this.eEU.setText(String.format(this.eEE.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eEU.setEnabled(false);
            } else {
                this.eEU.setEnabled(true);
            }
        }
    }

    public void ih(boolean z) {
        this.eER.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eEE.getLayoutMode().setNightMode(i == 1);
        this.eEE.getLayoutMode().onModeChanged(this.eCG);
        this.mNavigationBar.onChangeSkinType(this.eEE.getPageContext(), i);
        al.i(this.eEU, e.f.btn_delete_groupupdates);
    }

    public View aOd() {
        return this.eCK;
    }

    public BdListView aOe() {
        return this.eEP;
    }

    public Button aOf() {
        return this.eES;
    }

    public Button aOg() {
        return this.eET;
    }

    public Button aOh() {
        return this.eEU;
    }
}

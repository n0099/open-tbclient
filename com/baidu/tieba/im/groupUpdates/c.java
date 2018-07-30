package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View evr;
    private View evv;
    private BdListView exB;
    private a exC;
    private ProgressBar exD;
    private Button exE;
    private Button exF;
    private Button exG;
    private View exH;
    private View exI;
    private UpdatesActivity exp;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.exp = updatesActivity;
        initView();
        this.exC = new a(this.exp);
        this.exB.setAdapter((ListAdapter) this.exC);
        this.exB.setOnScrollListener(this.exp);
    }

    void initView() {
        this.evr = View.inflate(this.exp.getPageContext().getPageActivity(), d.h.updates_activity, null);
        this.exp.setContentView(this.evr);
        this.mNavigationBar = (NavigationBar) this.exp.findViewById(d.g.view_navigation_bar);
        this.evv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.exp.getPageContext().getString(d.j.updates_activity_title));
        this.exH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.exI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.exG = (Button) this.exH.findViewById(d.g.btn_delete);
        this.exG.setOnClickListener(this.exp);
        this.evv.setOnClickListener(this.exp);
        this.exB = (BdListView) this.evr.findViewById(d.g.updates_list);
        this.exD = (ProgressBar) this.evr.findViewById(d.g.pro_load);
        this.exE = (Button) this.exI.findViewById(d.g.btn_edit);
        this.exE.setOnClickListener(this.exp);
        this.exF = (Button) this.exI.findViewById(d.g.btn_cancel);
        this.exF.setOnClickListener(this.exp);
        op(0);
        hJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.exC != null) {
            this.exC.destroy();
            this.exC = null;
        }
        this.exp = null;
    }

    public a aLO() {
        return this.exC;
    }

    public void aLP() {
        this.exE.setVisibility(8);
        this.evv.setVisibility(8);
        this.exF.setVisibility(0);
        this.exH.setVisibility(0);
        aKG();
    }

    public void aLQ() {
        this.exE.setVisibility(0);
        this.evv.setVisibility(0);
        this.exF.setVisibility(8);
        this.exH.setVisibility(8);
        op(0);
        aKG();
    }

    public void aKG() {
        if (this.exC != null) {
            this.exC.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.exC != null) {
            this.exC.setData(list);
        }
    }

    public void op(int i) {
        if (this.exG != null && this.exp != null) {
            this.exG.setText(String.format(this.exp.getPageContext().getString(d.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.exG.setEnabled(false);
            } else {
                this.exG.setEnabled(true);
            }
        }
    }

    public void hJ(boolean z) {
        this.exD.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.exp.getLayoutMode().setNightMode(i == 1);
        this.exp.getLayoutMode().onModeChanged(this.evr);
        this.mNavigationBar.onChangeSkinType(this.exp.getPageContext(), i);
        am.i(this.exG, d.f.btn_delete_groupupdates);
    }

    public View aLR() {
        return this.evv;
    }

    public BdListView aLS() {
        return this.exB;
    }

    public Button aLT() {
        return this.exE;
    }

    public Button aLU() {
        return this.exF;
    }

    public Button aLV() {
        return this.exG;
    }
}

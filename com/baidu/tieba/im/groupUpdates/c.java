package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View evn;
    private View evr;
    private Button exA;
    private Button exB;
    private Button exC;
    private View exD;
    private View exE;
    private UpdatesActivity exl;
    private BdListView exx;
    private a exy;
    private ProgressBar exz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.exl = updatesActivity;
        initView();
        this.exy = new a(this.exl);
        this.exx.setAdapter((ListAdapter) this.exy);
        this.exx.setOnScrollListener(this.exl);
    }

    void initView() {
        this.evn = View.inflate(this.exl.getPageContext().getPageActivity(), f.h.updates_activity, null);
        this.exl.setContentView(this.evn);
        this.mNavigationBar = (NavigationBar) this.exl.findViewById(f.g.view_navigation_bar);
        this.evr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.exl.getPageContext().getString(f.j.updates_activity_title));
        this.exD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.exE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.exC = (Button) this.exD.findViewById(f.g.btn_delete);
        this.exC.setOnClickListener(this.exl);
        this.evr.setOnClickListener(this.exl);
        this.exx = (BdListView) this.evn.findViewById(f.g.updates_list);
        this.exz = (ProgressBar) this.evn.findViewById(f.g.pro_load);
        this.exA = (Button) this.exE.findViewById(f.g.btn_edit);
        this.exA.setOnClickListener(this.exl);
        this.exB = (Button) this.exE.findViewById(f.g.btn_cancel);
        this.exB.setOnClickListener(this.exl);
        op(0);
        hJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.exy != null) {
            this.exy.destroy();
            this.exy = null;
        }
        this.exl = null;
    }

    public a aLL() {
        return this.exy;
    }

    public void aLM() {
        this.exA.setVisibility(8);
        this.evr.setVisibility(8);
        this.exB.setVisibility(0);
        this.exD.setVisibility(0);
        aKD();
    }

    public void aLN() {
        this.exA.setVisibility(0);
        this.evr.setVisibility(0);
        this.exB.setVisibility(8);
        this.exD.setVisibility(8);
        op(0);
        aKD();
    }

    public void aKD() {
        if (this.exy != null) {
            this.exy.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.exy != null) {
            this.exy.setData(list);
        }
    }

    public void op(int i) {
        if (this.exC != null && this.exl != null) {
            this.exC.setText(String.format(this.exl.getPageContext().getString(f.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.exC.setEnabled(false);
            } else {
                this.exC.setEnabled(true);
            }
        }
    }

    public void hJ(boolean z) {
        this.exz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.exl.getLayoutMode().setNightMode(i == 1);
        this.exl.getLayoutMode().onModeChanged(this.evn);
        this.mNavigationBar.onChangeSkinType(this.exl.getPageContext(), i);
        am.i(this.exC, f.C0146f.btn_delete_groupupdates);
    }

    public View aLO() {
        return this.evr;
    }

    public BdListView aLP() {
        return this.exx;
    }

    public Button aLQ() {
        return this.exA;
    }

    public Button aLR() {
        return this.exB;
    }

    public Button aLS() {
        return this.exC;
    }
}

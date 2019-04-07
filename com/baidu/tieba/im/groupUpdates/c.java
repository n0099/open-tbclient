package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View crH;
    private View glZ;
    private UpdatesActivity gnT;
    private BdListView goe;
    private a gof;
    private ProgressBar gog;
    private Button goh;
    private Button goi;
    private Button goj;
    private View gok;
    private View gol;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gnT = updatesActivity;
        initView();
        this.gof = new a(this.gnT);
        this.goe.setAdapter((ListAdapter) this.gof);
        this.goe.setOnScrollListener(this.gnT);
    }

    void initView() {
        this.crH = View.inflate(this.gnT.getPageContext().getPageActivity(), d.h.updates_activity, null);
        this.gnT.setContentView(this.crH);
        this.mNavigationBar = (NavigationBar) this.gnT.findViewById(d.g.view_navigation_bar);
        this.glZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gnT.getPageContext().getString(d.j.updates_activity_title));
        this.gok = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.gol = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.goj = (Button) this.gok.findViewById(d.g.btn_delete);
        this.goj.setOnClickListener(this.gnT);
        this.glZ.setOnClickListener(this.gnT);
        this.goe = (BdListView) this.crH.findViewById(d.g.updates_list);
        this.gog = (ProgressBar) this.crH.findViewById(d.g.pro_load);
        this.goh = (Button) this.gol.findViewById(d.g.btn_edit);
        this.goh.setOnClickListener(this.gnT);
        this.goi = (Button) this.gol.findViewById(d.g.btn_cancel);
        this.goi.setOnClickListener(this.gnT);
        tY(0);
        lo(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gof != null) {
            this.gof.destroy();
            this.gof = null;
        }
        this.gnT = null;
    }

    public a bus() {
        return this.gof;
    }

    public void but() {
        this.goh.setVisibility(8);
        this.glZ.setVisibility(8);
        this.goi.setVisibility(0);
        this.gok.setVisibility(0);
        btl();
    }

    public void buu() {
        this.goh.setVisibility(0);
        this.glZ.setVisibility(0);
        this.goi.setVisibility(8);
        this.gok.setVisibility(8);
        tY(0);
        btl();
    }

    public void btl() {
        if (this.gof != null) {
            this.gof.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gof != null) {
            this.gof.setData(list);
        }
    }

    public void tY(int i) {
        if (this.goj != null && this.gnT != null) {
            this.goj.setText(String.format(this.gnT.getPageContext().getString(d.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.goj.setEnabled(false);
            } else {
                this.goj.setEnabled(true);
            }
        }
    }

    public void lo(boolean z) {
        this.gog.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gnT.getLayoutMode().setNightMode(i == 1);
        this.gnT.getLayoutMode().onModeChanged(this.crH);
        this.mNavigationBar.onChangeSkinType(this.gnT.getPageContext(), i);
        al.k(this.goj, d.f.btn_delete_groupupdates);
    }

    public View buv() {
        return this.glZ;
    }

    public BdListView buw() {
        return this.goe;
    }

    public Button bux() {
        return this.goh;
    }

    public Button buy() {
        return this.goi;
    }

    public Button buz() {
        return this.goj;
    }
}

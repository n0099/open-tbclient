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
    private View crI;
    private View gma;
    private UpdatesActivity gnU;
    private BdListView gof;
    private a gog;
    private ProgressBar goh;
    private Button goi;
    private Button goj;
    private Button gok;
    private View gol;
    private View gom;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gnU = updatesActivity;
        initView();
        this.gog = new a(this.gnU);
        this.gof.setAdapter((ListAdapter) this.gog);
        this.gof.setOnScrollListener(this.gnU);
    }

    void initView() {
        this.crI = View.inflate(this.gnU.getPageContext().getPageActivity(), d.h.updates_activity, null);
        this.gnU.setContentView(this.crI);
        this.mNavigationBar = (NavigationBar) this.gnU.findViewById(d.g.view_navigation_bar);
        this.gma = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gnU.getPageContext().getString(d.j.updates_activity_title));
        this.gol = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.gom = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.gok = (Button) this.gol.findViewById(d.g.btn_delete);
        this.gok.setOnClickListener(this.gnU);
        this.gma.setOnClickListener(this.gnU);
        this.gof = (BdListView) this.crI.findViewById(d.g.updates_list);
        this.goh = (ProgressBar) this.crI.findViewById(d.g.pro_load);
        this.goi = (Button) this.gom.findViewById(d.g.btn_edit);
        this.goi.setOnClickListener(this.gnU);
        this.goj = (Button) this.gom.findViewById(d.g.btn_cancel);
        this.goj.setOnClickListener(this.gnU);
        tY(0);
        lo(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gog != null) {
            this.gog.destroy();
            this.gog = null;
        }
        this.gnU = null;
    }

    public a bus() {
        return this.gog;
    }

    public void but() {
        this.goi.setVisibility(8);
        this.gma.setVisibility(8);
        this.goj.setVisibility(0);
        this.gol.setVisibility(0);
        btl();
    }

    public void buu() {
        this.goi.setVisibility(0);
        this.gma.setVisibility(0);
        this.goj.setVisibility(8);
        this.gol.setVisibility(8);
        tY(0);
        btl();
    }

    public void btl() {
        if (this.gog != null) {
            this.gog.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gog != null) {
            this.gog.setData(list);
        }
    }

    public void tY(int i) {
        if (this.gok != null && this.gnU != null) {
            this.gok.setText(String.format(this.gnU.getPageContext().getString(d.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gok.setEnabled(false);
            } else {
                this.gok.setEnabled(true);
            }
        }
    }

    public void lo(boolean z) {
        this.goh.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gnU.getLayoutMode().setNightMode(i == 1);
        this.gnU.getLayoutMode().onModeChanged(this.crI);
        this.mNavigationBar.onChangeSkinType(this.gnU.getPageContext(), i);
        al.k(this.gok, d.f.btn_delete_groupupdates);
    }

    public View buv() {
        return this.gma;
    }

    public BdListView buw() {
        return this.gof;
    }

    public Button bux() {
        return this.goi;
    }

    public Button buy() {
        return this.goj;
    }

    public Button buz() {
        return this.gok;
    }
}

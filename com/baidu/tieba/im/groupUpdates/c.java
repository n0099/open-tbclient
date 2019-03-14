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
    private View crF;
    private View gmm;
    private UpdatesActivity gog;
    private BdListView gor;
    private a gos;
    private ProgressBar got;
    private Button gou;
    private Button gov;
    private Button gow;
    private View gox;
    private View goy;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gog = updatesActivity;
        initView();
        this.gos = new a(this.gog);
        this.gor.setAdapter((ListAdapter) this.gos);
        this.gor.setOnScrollListener(this.gog);
    }

    void initView() {
        this.crF = View.inflate(this.gog.getPageContext().getPageActivity(), d.h.updates_activity, null);
        this.gog.setContentView(this.crF);
        this.mNavigationBar = (NavigationBar) this.gog.findViewById(d.g.view_navigation_bar);
        this.gmm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gog.getPageContext().getString(d.j.updates_activity_title));
        this.gox = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.goy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.gow = (Button) this.gox.findViewById(d.g.btn_delete);
        this.gow.setOnClickListener(this.gog);
        this.gmm.setOnClickListener(this.gog);
        this.gor = (BdListView) this.crF.findViewById(d.g.updates_list);
        this.got = (ProgressBar) this.crF.findViewById(d.g.pro_load);
        this.gou = (Button) this.goy.findViewById(d.g.btn_edit);
        this.gou.setOnClickListener(this.gog);
        this.gov = (Button) this.goy.findViewById(d.g.btn_cancel);
        this.gov.setOnClickListener(this.gog);
        uc(0);
        lo(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gos != null) {
            this.gos.destroy();
            this.gos = null;
        }
        this.gog = null;
    }

    public a buv() {
        return this.gos;
    }

    public void buw() {
        this.gou.setVisibility(8);
        this.gmm.setVisibility(8);
        this.gov.setVisibility(0);
        this.gox.setVisibility(0);
        bto();
    }

    public void bux() {
        this.gou.setVisibility(0);
        this.gmm.setVisibility(0);
        this.gov.setVisibility(8);
        this.gox.setVisibility(8);
        uc(0);
        bto();
    }

    public void bto() {
        if (this.gos != null) {
            this.gos.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gos != null) {
            this.gos.setData(list);
        }
    }

    public void uc(int i) {
        if (this.gow != null && this.gog != null) {
            this.gow.setText(String.format(this.gog.getPageContext().getString(d.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gow.setEnabled(false);
            } else {
                this.gow.setEnabled(true);
            }
        }
    }

    public void lo(boolean z) {
        this.got.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gog.getLayoutMode().setNightMode(i == 1);
        this.gog.getLayoutMode().onModeChanged(this.crF);
        this.mNavigationBar.onChangeSkinType(this.gog.getPageContext(), i);
        al.k(this.gow, d.f.btn_delete_groupupdates);
    }

    public View buy() {
        return this.gmm;
    }

    public BdListView buz() {
        return this.gor;
    }

    public Button buA() {
        return this.gou;
    }

    public Button buB() {
        return this.gov;
    }

    public Button buC() {
        return this.gow;
    }
}

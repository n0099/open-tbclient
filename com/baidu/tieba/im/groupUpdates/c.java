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
    private View eWb;
    private View eWf;
    private UpdatesActivity eXZ;
    private BdListView eYk;
    private a eYl;
    private ProgressBar eYm;
    private Button eYn;
    private Button eYo;
    private Button eYp;
    private View eYq;
    private View eYr;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eXZ = updatesActivity;
        initView();
        this.eYl = new a(this.eXZ);
        this.eYk.setAdapter((ListAdapter) this.eYl);
        this.eYk.setOnScrollListener(this.eXZ);
    }

    void initView() {
        this.eWb = View.inflate(this.eXZ.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eXZ.setContentView(this.eWb);
        this.mNavigationBar = (NavigationBar) this.eXZ.findViewById(e.g.view_navigation_bar);
        this.eWf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eXZ.getPageContext().getString(e.j.updates_activity_title));
        this.eYq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eYr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eYp = (Button) this.eYq.findViewById(e.g.btn_delete);
        this.eYp.setOnClickListener(this.eXZ);
        this.eWf.setOnClickListener(this.eXZ);
        this.eYk = (BdListView) this.eWb.findViewById(e.g.updates_list);
        this.eYm = (ProgressBar) this.eWb.findViewById(e.g.pro_load);
        this.eYn = (Button) this.eYr.findViewById(e.g.btn_edit);
        this.eYn.setOnClickListener(this.eXZ);
        this.eYo = (Button) this.eYr.findViewById(e.g.btn_cancel);
        this.eYo.setOnClickListener(this.eXZ);
        qs(0);
        iO(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eYl != null) {
            this.eYl.destroy();
            this.eYl = null;
        }
        this.eXZ = null;
    }

    public a aTR() {
        return this.eYl;
    }

    public void aTS() {
        this.eYn.setVisibility(8);
        this.eWf.setVisibility(8);
        this.eYo.setVisibility(0);
        this.eYq.setVisibility(0);
        aSJ();
    }

    public void aTT() {
        this.eYn.setVisibility(0);
        this.eWf.setVisibility(0);
        this.eYo.setVisibility(8);
        this.eYq.setVisibility(8);
        qs(0);
        aSJ();
    }

    public void aSJ() {
        if (this.eYl != null) {
            this.eYl.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eYl != null) {
            this.eYl.setData(list);
        }
    }

    public void qs(int i) {
        if (this.eYp != null && this.eXZ != null) {
            this.eYp.setText(String.format(this.eXZ.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eYp.setEnabled(false);
            } else {
                this.eYp.setEnabled(true);
            }
        }
    }

    public void iO(boolean z) {
        this.eYm.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eXZ.getLayoutMode().setNightMode(i == 1);
        this.eXZ.getLayoutMode().onModeChanged(this.eWb);
        this.mNavigationBar.onChangeSkinType(this.eXZ.getPageContext(), i);
        al.i(this.eYp, e.f.btn_delete_groupupdates);
    }

    public View aTU() {
        return this.eWf;
    }

    public BdListView aTV() {
        return this.eYk;
    }

    public Button aTW() {
        return this.eYn;
    }

    public Button aTX() {
        return this.eYo;
    }

    public Button aTY() {
        return this.eYp;
    }
}

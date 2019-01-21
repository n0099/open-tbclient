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
    private View eWc;
    private View eWg;
    private UpdatesActivity eYa;
    private BdListView eYl;
    private a eYm;
    private ProgressBar eYn;
    private Button eYo;
    private Button eYp;
    private Button eYq;
    private View eYr;
    private View eYs;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eYa = updatesActivity;
        initView();
        this.eYm = new a(this.eYa);
        this.eYl.setAdapter((ListAdapter) this.eYm);
        this.eYl.setOnScrollListener(this.eYa);
    }

    void initView() {
        this.eWc = View.inflate(this.eYa.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eYa.setContentView(this.eWc);
        this.mNavigationBar = (NavigationBar) this.eYa.findViewById(e.g.view_navigation_bar);
        this.eWg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eYa.getPageContext().getString(e.j.updates_activity_title));
        this.eYr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eYs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eYq = (Button) this.eYr.findViewById(e.g.btn_delete);
        this.eYq.setOnClickListener(this.eYa);
        this.eWg.setOnClickListener(this.eYa);
        this.eYl = (BdListView) this.eWc.findViewById(e.g.updates_list);
        this.eYn = (ProgressBar) this.eWc.findViewById(e.g.pro_load);
        this.eYo = (Button) this.eYs.findViewById(e.g.btn_edit);
        this.eYo.setOnClickListener(this.eYa);
        this.eYp = (Button) this.eYs.findViewById(e.g.btn_cancel);
        this.eYp.setOnClickListener(this.eYa);
        qs(0);
        iO(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eYm != null) {
            this.eYm.destroy();
            this.eYm = null;
        }
        this.eYa = null;
    }

    public a aTR() {
        return this.eYm;
    }

    public void aTS() {
        this.eYo.setVisibility(8);
        this.eWg.setVisibility(8);
        this.eYp.setVisibility(0);
        this.eYr.setVisibility(0);
        aSJ();
    }

    public void aTT() {
        this.eYo.setVisibility(0);
        this.eWg.setVisibility(0);
        this.eYp.setVisibility(8);
        this.eYr.setVisibility(8);
        qs(0);
        aSJ();
    }

    public void aSJ() {
        if (this.eYm != null) {
            this.eYm.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eYm != null) {
            this.eYm.setData(list);
        }
    }

    public void qs(int i) {
        if (this.eYq != null && this.eYa != null) {
            this.eYq.setText(String.format(this.eYa.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eYq.setEnabled(false);
            } else {
                this.eYq.setEnabled(true);
            }
        }
    }

    public void iO(boolean z) {
        this.eYn.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eYa.getLayoutMode().setNightMode(i == 1);
        this.eYa.getLayoutMode().onModeChanged(this.eWc);
        this.mNavigationBar.onChangeSkinType(this.eYa.getPageContext(), i);
        al.i(this.eYq, e.f.btn_delete_groupupdates);
    }

    public View aTU() {
        return this.eWg;
    }

    public BdListView aTV() {
        return this.eYl;
    }

    public Button aTW() {
        return this.eYo;
    }

    public Button aTX() {
        return this.eYp;
    }

    public Button aTY() {
        return this.eYq;
    }
}

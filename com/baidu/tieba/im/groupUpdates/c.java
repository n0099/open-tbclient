package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View dEN;
    private View hCY;
    private UpdatesActivity hEU;
    private BdListView hFf;
    private a hFg;
    private ProgressBar hFh;
    private Button hFi;
    private Button hFj;
    private Button hFk;
    private View hFl;
    private View hFm;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.hEU = updatesActivity;
        initView();
        this.hFg = new a(this.hEU);
        this.hFf.setAdapter((ListAdapter) this.hFg);
        this.hFf.setOnScrollListener(this.hEU);
    }

    void initView() {
        this.dEN = View.inflate(this.hEU.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.hEU.setContentView(this.dEN);
        this.mNavigationBar = (NavigationBar) this.hEU.findViewById(R.id.view_navigation_bar);
        this.hCY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hEU.getPageContext().getString(R.string.updates_activity_title));
        this.hFl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.hFm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.hFk = (Button) this.hFl.findViewById(R.id.btn_delete);
        this.hFk.setOnClickListener(this.hEU);
        this.hCY.setOnClickListener(this.hEU);
        this.hFf = (BdListView) this.dEN.findViewById(R.id.updates_list);
        this.hFh = (ProgressBar) this.dEN.findViewById(R.id.pro_load);
        this.hFi = (Button) this.hFm.findViewById(R.id.btn_edit);
        this.hFi.setOnClickListener(this.hEU);
        this.hFj = (Button) this.hFm.findViewById(R.id.btn_cancel);
        this.hFj.setOnClickListener(this.hEU);
        wE(0);
        nK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hFg != null) {
            this.hFg.destroy();
            this.hFg = null;
        }
        this.hEU = null;
    }

    public a bWx() {
        return this.hFg;
    }

    public void bWy() {
        this.hFi.setVisibility(8);
        this.hCY.setVisibility(8);
        this.hFj.setVisibility(0);
        this.hFl.setVisibility(0);
        bVq();
    }

    public void bWz() {
        this.hFi.setVisibility(0);
        this.hCY.setVisibility(0);
        this.hFj.setVisibility(8);
        this.hFl.setVisibility(8);
        wE(0);
        bVq();
    }

    public void bVq() {
        if (this.hFg != null) {
            this.hFg.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.hFg != null) {
            this.hFg.setData(list);
        }
    }

    public void wE(int i) {
        if (this.hFk != null && this.hEU != null) {
            this.hFk.setText(String.format(this.hEU.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.hFk.setEnabled(false);
            } else {
                this.hFk.setEnabled(true);
            }
        }
    }

    public void nK(boolean z) {
        this.hFh.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hEU.getLayoutMode().setNightMode(i == 1);
        this.hEU.getLayoutMode().onModeChanged(this.dEN);
        this.mNavigationBar.onChangeSkinType(this.hEU.getPageContext(), i);
        am.setBackgroundResource(this.hFk, R.drawable.btn_delete_groupupdates);
    }

    public View bWA() {
        return this.hCY;
    }

    public BdListView bWB() {
        return this.hFf;
    }

    public Button bWC() {
        return this.hFi;
    }

    public Button bWD() {
        return this.hFj;
    }

    public Button bWE() {
        return this.hFk;
    }
}

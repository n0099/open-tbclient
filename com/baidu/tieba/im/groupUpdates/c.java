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
    private View dEO;
    private View hDa;
    private UpdatesActivity hEW;
    private BdListView hFh;
    private a hFi;
    private ProgressBar hFj;
    private Button hFk;
    private Button hFl;
    private Button hFm;
    private View hFn;
    private View hFo;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.hEW = updatesActivity;
        initView();
        this.hFi = new a(this.hEW);
        this.hFh.setAdapter((ListAdapter) this.hFi);
        this.hFh.setOnScrollListener(this.hEW);
    }

    void initView() {
        this.dEO = View.inflate(this.hEW.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.hEW.setContentView(this.dEO);
        this.mNavigationBar = (NavigationBar) this.hEW.findViewById(R.id.view_navigation_bar);
        this.hDa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hEW.getPageContext().getString(R.string.updates_activity_title));
        this.hFn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.hFo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.hFm = (Button) this.hFn.findViewById(R.id.btn_delete);
        this.hFm.setOnClickListener(this.hEW);
        this.hDa.setOnClickListener(this.hEW);
        this.hFh = (BdListView) this.dEO.findViewById(R.id.updates_list);
        this.hFj = (ProgressBar) this.dEO.findViewById(R.id.pro_load);
        this.hFk = (Button) this.hFo.findViewById(R.id.btn_edit);
        this.hFk.setOnClickListener(this.hEW);
        this.hFl = (Button) this.hFo.findViewById(R.id.btn_cancel);
        this.hFl.setOnClickListener(this.hEW);
        wE(0);
        nK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hFi != null) {
            this.hFi.destroy();
            this.hFi = null;
        }
        this.hEW = null;
    }

    public a bWz() {
        return this.hFi;
    }

    public void bWA() {
        this.hFk.setVisibility(8);
        this.hDa.setVisibility(8);
        this.hFl.setVisibility(0);
        this.hFn.setVisibility(0);
        bVs();
    }

    public void bWB() {
        this.hFk.setVisibility(0);
        this.hDa.setVisibility(0);
        this.hFl.setVisibility(8);
        this.hFn.setVisibility(8);
        wE(0);
        bVs();
    }

    public void bVs() {
        if (this.hFi != null) {
            this.hFi.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.hFi != null) {
            this.hFi.setData(list);
        }
    }

    public void wE(int i) {
        if (this.hFm != null && this.hEW != null) {
            this.hFm.setText(String.format(this.hEW.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.hFm.setEnabled(false);
            } else {
                this.hFm.setEnabled(true);
            }
        }
    }

    public void nK(boolean z) {
        this.hFj.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hEW.getLayoutMode().setNightMode(i == 1);
        this.hEW.getLayoutMode().onModeChanged(this.dEO);
        this.mNavigationBar.onChangeSkinType(this.hEW.getPageContext(), i);
        am.setBackgroundResource(this.hFm, R.drawable.btn_delete_groupupdates);
    }

    public View bWC() {
        return this.hDa;
    }

    public BdListView bWD() {
        return this.hFh;
    }

    public Button bWE() {
        return this.hFk;
    }

    public Button bWF() {
        return this.hFl;
    }

    public Button bWG() {
        return this.hFm;
    }
}

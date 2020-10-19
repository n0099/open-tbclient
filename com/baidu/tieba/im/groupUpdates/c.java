package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View fih;
    private View jPW;
    private UpdatesActivity jRS;
    private BdListView jSc;
    private a jSd;
    private ProgressBar jSe;
    private Button jSf;
    private Button jSg;
    private Button jSh;
    private View jSi;
    private View jSj;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.jRS = updatesActivity;
        initView();
        this.jSd = new a(this.jRS);
        this.jSc.setAdapter((ListAdapter) this.jSd);
        this.jSc.setOnScrollListener(this.jRS);
    }

    void initView() {
        this.fih = View.inflate(this.jRS.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.jRS.setContentView(this.fih);
        this.mNavigationBar = (NavigationBar) this.jRS.findViewById(R.id.view_navigation_bar);
        this.jPW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRS.getPageContext().getString(R.string.updates_activity_title));
        this.jSi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.jSj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.jSh = (Button) this.jSi.findViewById(R.id.btn_delete);
        this.jSh.setOnClickListener(this.jRS);
        this.jPW.setOnClickListener(this.jRS);
        this.jSc = (BdListView) this.fih.findViewById(R.id.updates_list);
        this.jSe = (ProgressBar) this.fih.findViewById(R.id.pro_load);
        this.jSf = (Button) this.jSj.findViewById(R.id.btn_edit);
        this.jSf.setOnClickListener(this.jRS);
        this.jSg = (Button) this.jSj.findViewById(R.id.btn_cancel);
        this.jSg.setOnClickListener(this.jRS);
        CA(0);
        rD(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jSd != null) {
            this.jSd.destroy();
            this.jSd = null;
        }
        this.jRS = null;
    }

    public a cNT() {
        return this.jSd;
    }

    public void cNU() {
        this.jSf.setVisibility(8);
        this.jPW.setVisibility(8);
        this.jSg.setVisibility(0);
        this.jSi.setVisibility(0);
        cMM();
    }

    public void cNV() {
        this.jSf.setVisibility(0);
        this.jPW.setVisibility(0);
        this.jSg.setVisibility(8);
        this.jSi.setVisibility(8);
        CA(0);
        cMM();
    }

    public void cMM() {
        if (this.jSd != null) {
            this.jSd.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.jSd != null) {
            this.jSd.setData(list);
        }
    }

    public void CA(int i) {
        if (this.jSh != null && this.jRS != null) {
            this.jSh.setText(String.format(this.jRS.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.jSh.setEnabled(false);
            } else {
                this.jSh.setEnabled(true);
            }
        }
    }

    public void rD(boolean z) {
        this.jSe.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jRS.getLayoutMode().setNightMode(i == 1);
        this.jRS.getLayoutMode().onModeChanged(this.fih);
        this.mNavigationBar.onChangeSkinType(this.jRS.getPageContext(), i);
        ap.setBackgroundResource(this.jSh, R.drawable.btn_delete_groupupdates);
    }

    public View cNW() {
        return this.jPW;
    }

    public BdListView cNX() {
        return this.jSc;
    }

    public Button cNY() {
        return this.jSf;
    }

    public Button cNZ() {
        return this.jSg;
    }

    public Button cOa() {
        return this.jSh;
    }
}

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
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View cNq;
    private View gKj;
    private UpdatesActivity gMf;
    private BdListView gMq;
    private a gMr;
    private ProgressBar gMs;
    private Button gMt;
    private Button gMu;
    private Button gMv;
    private View gMw;
    private View gMx;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gMf = updatesActivity;
        initView();
        this.gMr = new a(this.gMf);
        this.gMq.setAdapter((ListAdapter) this.gMr);
        this.gMq.setOnScrollListener(this.gMf);
    }

    void initView() {
        this.cNq = View.inflate(this.gMf.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gMf.setContentView(this.cNq);
        this.mNavigationBar = (NavigationBar) this.gMf.findViewById(R.id.view_navigation_bar);
        this.gKj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gMf.getPageContext().getString(R.string.updates_activity_title));
        this.gMw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gMx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gMv = (Button) this.gMw.findViewById(R.id.btn_delete);
        this.gMv.setOnClickListener(this.gMf);
        this.gKj.setOnClickListener(this.gMf);
        this.gMq = (BdListView) this.cNq.findViewById(R.id.updates_list);
        this.gMs = (ProgressBar) this.cNq.findViewById(R.id.pro_load);
        this.gMt = (Button) this.gMx.findViewById(R.id.btn_edit);
        this.gMt.setOnClickListener(this.gMf);
        this.gMu = (Button) this.gMx.findViewById(R.id.btn_cancel);
        this.gMu.setOnClickListener(this.gMf);
        us(0);
        mj(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gMr != null) {
            this.gMr.destroy();
            this.gMr = null;
        }
        this.gMf = null;
    }

    public a bCC() {
        return this.gMr;
    }

    public void bCD() {
        this.gMt.setVisibility(8);
        this.gKj.setVisibility(8);
        this.gMu.setVisibility(0);
        this.gMw.setVisibility(0);
        bBv();
    }

    public void bCE() {
        this.gMt.setVisibility(0);
        this.gKj.setVisibility(0);
        this.gMu.setVisibility(8);
        this.gMw.setVisibility(8);
        us(0);
        bBv();
    }

    public void bBv() {
        if (this.gMr != null) {
            this.gMr.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gMr != null) {
            this.gMr.setData(list);
        }
    }

    public void us(int i) {
        if (this.gMv != null && this.gMf != null) {
            this.gMv.setText(String.format(this.gMf.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gMv.setEnabled(false);
            } else {
                this.gMv.setEnabled(true);
            }
        }
    }

    public void mj(boolean z) {
        this.gMs.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gMf.getLayoutMode().setNightMode(i == 1);
        this.gMf.getLayoutMode().onModeChanged(this.cNq);
        this.mNavigationBar.onChangeSkinType(this.gMf.getPageContext(), i);
        am.setBackgroundResource(this.gMv, R.drawable.btn_delete_groupupdates);
    }

    public View bCF() {
        return this.gKj;
    }

    public BdListView bCG() {
        return this.gMq;
    }

    public Button bCH() {
        return this.gMt;
    }

    public Button bCI() {
        return this.gMu;
    }

    public Button bCJ() {
        return this.gMv;
    }
}

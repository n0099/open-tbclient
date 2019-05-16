package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View czN;
    private View gDn;
    private UpdatesActivity gFh;
    private BdListView gFs;
    private a gFt;
    private ProgressBar gFu;
    private Button gFv;
    private Button gFw;
    private Button gFx;
    private View gFy;
    private View gFz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gFh = updatesActivity;
        initView();
        this.gFt = new a(this.gFh);
        this.gFs.setAdapter((ListAdapter) this.gFt);
        this.gFs.setOnScrollListener(this.gFh);
    }

    void initView() {
        this.czN = View.inflate(this.gFh.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gFh.setContentView(this.czN);
        this.mNavigationBar = (NavigationBar) this.gFh.findViewById(R.id.view_navigation_bar);
        this.gDn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gFh.getPageContext().getString(R.string.updates_activity_title));
        this.gFy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gFz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gFx = (Button) this.gFy.findViewById(R.id.btn_delete);
        this.gFx.setOnClickListener(this.gFh);
        this.gDn.setOnClickListener(this.gFh);
        this.gFs = (BdListView) this.czN.findViewById(R.id.updates_list);
        this.gFu = (ProgressBar) this.czN.findViewById(R.id.pro_load);
        this.gFv = (Button) this.gFz.findViewById(R.id.btn_edit);
        this.gFv.setOnClickListener(this.gFh);
        this.gFw = (Button) this.gFz.findViewById(R.id.btn_cancel);
        this.gFw.setOnClickListener(this.gFh);
        vf(0);
        md(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gFt != null) {
            this.gFt.destroy();
            this.gFt = null;
        }
        this.gFh = null;
    }

    public a bCe() {
        return this.gFt;
    }

    public void bCf() {
        this.gFv.setVisibility(8);
        this.gDn.setVisibility(8);
        this.gFw.setVisibility(0);
        this.gFy.setVisibility(0);
        bAX();
    }

    public void bCg() {
        this.gFv.setVisibility(0);
        this.gDn.setVisibility(0);
        this.gFw.setVisibility(8);
        this.gFy.setVisibility(8);
        vf(0);
        bAX();
    }

    public void bAX() {
        if (this.gFt != null) {
            this.gFt.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gFt != null) {
            this.gFt.setData(list);
        }
    }

    public void vf(int i) {
        if (this.gFx != null && this.gFh != null) {
            this.gFx.setText(String.format(this.gFh.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gFx.setEnabled(false);
            } else {
                this.gFx.setEnabled(true);
            }
        }
    }

    public void md(boolean z) {
        this.gFu.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gFh.getLayoutMode().setNightMode(i == 1);
        this.gFh.getLayoutMode().onModeChanged(this.czN);
        this.mNavigationBar.onChangeSkinType(this.gFh.getPageContext(), i);
        al.k(this.gFx, R.drawable.btn_delete_groupupdates);
    }

    public View bCh() {
        return this.gDn;
    }

    public BdListView bCi() {
        return this.gFs;
    }

    public Button bCj() {
        return this.gFv;
    }

    public Button bCk() {
        return this.gFw;
    }

    public Button bCl() {
        return this.gFx;
    }
}

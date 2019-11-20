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
    private View cMz;
    private View gJs;
    private a gLA;
    private ProgressBar gLB;
    private Button gLC;
    private Button gLD;
    private Button gLE;
    private View gLF;
    private View gLG;
    private UpdatesActivity gLo;
    private BdListView gLz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gLo = updatesActivity;
        initView();
        this.gLA = new a(this.gLo);
        this.gLz.setAdapter((ListAdapter) this.gLA);
        this.gLz.setOnScrollListener(this.gLo);
    }

    void initView() {
        this.cMz = View.inflate(this.gLo.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gLo.setContentView(this.cMz);
        this.mNavigationBar = (NavigationBar) this.gLo.findViewById(R.id.view_navigation_bar);
        this.gJs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gLo.getPageContext().getString(R.string.updates_activity_title));
        this.gLF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gLG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gLE = (Button) this.gLF.findViewById(R.id.btn_delete);
        this.gLE.setOnClickListener(this.gLo);
        this.gJs.setOnClickListener(this.gLo);
        this.gLz = (BdListView) this.cMz.findViewById(R.id.updates_list);
        this.gLB = (ProgressBar) this.cMz.findViewById(R.id.pro_load);
        this.gLC = (Button) this.gLG.findViewById(R.id.btn_edit);
        this.gLC.setOnClickListener(this.gLo);
        this.gLD = (Button) this.gLG.findViewById(R.id.btn_cancel);
        this.gLD.setOnClickListener(this.gLo);
        ur(0);
        mj(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gLA != null) {
            this.gLA.destroy();
            this.gLA = null;
        }
        this.gLo = null;
    }

    public a bCA() {
        return this.gLA;
    }

    public void bCB() {
        this.gLC.setVisibility(8);
        this.gJs.setVisibility(8);
        this.gLD.setVisibility(0);
        this.gLF.setVisibility(0);
        bBt();
    }

    public void bCC() {
        this.gLC.setVisibility(0);
        this.gJs.setVisibility(0);
        this.gLD.setVisibility(8);
        this.gLF.setVisibility(8);
        ur(0);
        bBt();
    }

    public void bBt() {
        if (this.gLA != null) {
            this.gLA.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gLA != null) {
            this.gLA.setData(list);
        }
    }

    public void ur(int i) {
        if (this.gLE != null && this.gLo != null) {
            this.gLE.setText(String.format(this.gLo.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gLE.setEnabled(false);
            } else {
                this.gLE.setEnabled(true);
            }
        }
    }

    public void mj(boolean z) {
        this.gLB.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gLo.getLayoutMode().setNightMode(i == 1);
        this.gLo.getLayoutMode().onModeChanged(this.cMz);
        this.mNavigationBar.onChangeSkinType(this.gLo.getPageContext(), i);
        am.setBackgroundResource(this.gLE, R.drawable.btn_delete_groupupdates);
    }

    public View bCD() {
        return this.gJs;
    }

    public BdListView bCE() {
        return this.gLz;
    }

    public Button bCF() {
        return this.gLC;
    }

    public Button bCG() {
        return this.gLD;
    }

    public Button bCH() {
        return this.gLE;
    }
}

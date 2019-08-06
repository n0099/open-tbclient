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
    private View cBl;
    private View gKs;
    private Button gMA;
    private Button gMB;
    private Button gMC;
    private View gMD;
    private View gME;
    private UpdatesActivity gMm;
    private BdListView gMx;
    private a gMy;
    private ProgressBar gMz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gMm = updatesActivity;
        initView();
        this.gMy = new a(this.gMm);
        this.gMx.setAdapter((ListAdapter) this.gMy);
        this.gMx.setOnScrollListener(this.gMm);
    }

    void initView() {
        this.cBl = View.inflate(this.gMm.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gMm.setContentView(this.cBl);
        this.mNavigationBar = (NavigationBar) this.gMm.findViewById(R.id.view_navigation_bar);
        this.gKs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gMm.getPageContext().getString(R.string.updates_activity_title));
        this.gMD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gME = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gMC = (Button) this.gMD.findViewById(R.id.btn_delete);
        this.gMC.setOnClickListener(this.gMm);
        this.gKs.setOnClickListener(this.gMm);
        this.gMx = (BdListView) this.cBl.findViewById(R.id.updates_list);
        this.gMz = (ProgressBar) this.cBl.findViewById(R.id.pro_load);
        this.gMA = (Button) this.gME.findViewById(R.id.btn_edit);
        this.gMA.setOnClickListener(this.gMm);
        this.gMB = (Button) this.gME.findViewById(R.id.btn_cancel);
        this.gMB.setOnClickListener(this.gMm);
        vI(0);
        ms(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gMy != null) {
            this.gMy.destroy();
            this.gMy = null;
        }
        this.gMm = null;
    }

    public a bFd() {
        return this.gMy;
    }

    public void bFe() {
        this.gMA.setVisibility(8);
        this.gKs.setVisibility(8);
        this.gMB.setVisibility(0);
        this.gMD.setVisibility(0);
        bDW();
    }

    public void bFf() {
        this.gMA.setVisibility(0);
        this.gKs.setVisibility(0);
        this.gMB.setVisibility(8);
        this.gMD.setVisibility(8);
        vI(0);
        bDW();
    }

    public void bDW() {
        if (this.gMy != null) {
            this.gMy.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gMy != null) {
            this.gMy.setData(list);
        }
    }

    public void vI(int i) {
        if (this.gMC != null && this.gMm != null) {
            this.gMC.setText(String.format(this.gMm.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gMC.setEnabled(false);
            } else {
                this.gMC.setEnabled(true);
            }
        }
    }

    public void ms(boolean z) {
        this.gMz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gMm.getLayoutMode().setNightMode(i == 1);
        this.gMm.getLayoutMode().onModeChanged(this.cBl);
        this.mNavigationBar.onChangeSkinType(this.gMm.getPageContext(), i);
        am.k(this.gMC, R.drawable.btn_delete_groupupdates);
    }

    public View bFg() {
        return this.gKs;
    }

    public BdListView bFh() {
        return this.gMx;
    }

    public Button bFi() {
        return this.gMA;
    }

    public Button bFj() {
        return this.gMB;
    }

    public Button bFk() {
        return this.gMC;
    }
}

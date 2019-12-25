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
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View dAC;
    private View hxw;
    private BdListView hzD;
    private a hzE;
    private ProgressBar hzF;
    private Button hzG;
    private Button hzH;
    private Button hzI;
    private View hzJ;
    private View hzK;
    private UpdatesActivity hzs;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.hzs = updatesActivity;
        initView();
        this.hzE = new a(this.hzs);
        this.hzD.setAdapter((ListAdapter) this.hzE);
        this.hzD.setOnScrollListener(this.hzs);
    }

    void initView() {
        this.dAC = View.inflate(this.hzs.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.hzs.setContentView(this.dAC);
        this.mNavigationBar = (NavigationBar) this.hzs.findViewById(R.id.view_navigation_bar);
        this.hxw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hzs.getPageContext().getString(R.string.updates_activity_title));
        this.hzJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.hzK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.hzI = (Button) this.hzJ.findViewById(R.id.btn_delete);
        this.hzI.setOnClickListener(this.hzs);
        this.hxw.setOnClickListener(this.hzs);
        this.hzD = (BdListView) this.dAC.findViewById(R.id.updates_list);
        this.hzF = (ProgressBar) this.dAC.findViewById(R.id.pro_load);
        this.hzG = (Button) this.hzK.findViewById(R.id.btn_edit);
        this.hzG.setOnClickListener(this.hzs);
        this.hzH = (Button) this.hzK.findViewById(R.id.btn_cancel);
        this.hzH.setOnClickListener(this.hzs);
        wt(0);
        nw(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hzE != null) {
            this.hzE.destroy();
            this.hzE = null;
        }
        this.hzs = null;
    }

    public a bTN() {
        return this.hzE;
    }

    public void bTO() {
        this.hzG.setVisibility(8);
        this.hxw.setVisibility(8);
        this.hzH.setVisibility(0);
        this.hzJ.setVisibility(0);
        bSG();
    }

    public void bTP() {
        this.hzG.setVisibility(0);
        this.hxw.setVisibility(0);
        this.hzH.setVisibility(8);
        this.hzJ.setVisibility(8);
        wt(0);
        bSG();
    }

    public void bSG() {
        if (this.hzE != null) {
            this.hzE.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.hzE != null) {
            this.hzE.setData(list);
        }
    }

    public void wt(int i) {
        if (this.hzI != null && this.hzs != null) {
            this.hzI.setText(String.format(this.hzs.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.hzI.setEnabled(false);
            } else {
                this.hzI.setEnabled(true);
            }
        }
    }

    public void nw(boolean z) {
        this.hzF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hzs.getLayoutMode().setNightMode(i == 1);
        this.hzs.getLayoutMode().onModeChanged(this.dAC);
        this.mNavigationBar.onChangeSkinType(this.hzs.getPageContext(), i);
        am.setBackgroundResource(this.hzI, R.drawable.btn_delete_groupupdates);
    }

    public View bTQ() {
        return this.hxw;
    }

    public BdListView bTR() {
        return this.hzD;
    }

    public Button bTS() {
        return this.hzG;
    }

    public Button bTT() {
        return this.hzH;
    }

    public Button bTU() {
        return this.hzI;
    }
}

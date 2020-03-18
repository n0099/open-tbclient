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
    private View dFr;
    private View hEM;
    private UpdatesActivity hGI;
    private BdListView hGT;
    private a hGU;
    private ProgressBar hGV;
    private Button hGW;
    private Button hGX;
    private Button hGY;
    private View hGZ;
    private View hHa;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.hGI = updatesActivity;
        initView();
        this.hGU = new a(this.hGI);
        this.hGT.setAdapter((ListAdapter) this.hGU);
        this.hGT.setOnScrollListener(this.hGI);
    }

    void initView() {
        this.dFr = View.inflate(this.hGI.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.hGI.setContentView(this.dFr);
        this.mNavigationBar = (NavigationBar) this.hGI.findViewById(R.id.view_navigation_bar);
        this.hEM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hGI.getPageContext().getString(R.string.updates_activity_title));
        this.hGZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.hHa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.hGY = (Button) this.hGZ.findViewById(R.id.btn_delete);
        this.hGY.setOnClickListener(this.hGI);
        this.hEM.setOnClickListener(this.hGI);
        this.hGT = (BdListView) this.dFr.findViewById(R.id.updates_list);
        this.hGV = (ProgressBar) this.dFr.findViewById(R.id.pro_load);
        this.hGW = (Button) this.hHa.findViewById(R.id.btn_edit);
        this.hGW.setOnClickListener(this.hGI);
        this.hGX = (Button) this.hHa.findViewById(R.id.btn_cancel);
        this.hGX.setOnClickListener(this.hGI);
        wM(0);
        nQ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hGU != null) {
            this.hGU.destroy();
            this.hGU = null;
        }
        this.hGI = null;
    }

    public a bWS() {
        return this.hGU;
    }

    public void bWT() {
        this.hGW.setVisibility(8);
        this.hEM.setVisibility(8);
        this.hGX.setVisibility(0);
        this.hGZ.setVisibility(0);
        bVL();
    }

    public void bWU() {
        this.hGW.setVisibility(0);
        this.hEM.setVisibility(0);
        this.hGX.setVisibility(8);
        this.hGZ.setVisibility(8);
        wM(0);
        bVL();
    }

    public void bVL() {
        if (this.hGU != null) {
            this.hGU.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.hGU != null) {
            this.hGU.setData(list);
        }
    }

    public void wM(int i) {
        if (this.hGY != null && this.hGI != null) {
            this.hGY.setText(String.format(this.hGI.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.hGY.setEnabled(false);
            } else {
                this.hGY.setEnabled(true);
            }
        }
    }

    public void nQ(boolean z) {
        this.hGV.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hGI.getLayoutMode().setNightMode(i == 1);
        this.hGI.getLayoutMode().onModeChanged(this.dFr);
        this.mNavigationBar.onChangeSkinType(this.hGI.getPageContext(), i);
        am.setBackgroundResource(this.hGY, R.drawable.btn_delete_groupupdates);
    }

    public View bWV() {
        return this.hEM;
    }

    public BdListView bWW() {
        return this.hGT;
    }

    public Button bWX() {
        return this.hGW;
    }

    public Button bWY() {
        return this.hGX;
    }

    public Button bWZ() {
        return this.hGY;
    }
}

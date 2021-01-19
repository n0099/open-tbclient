package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends d<UpdatesActivity> {
    private View fIC;
    private ProgressBar kzA;
    private Button kzB;
    private Button kzC;
    private Button kzD;
    private View kzE;
    private View kzF;
    private UpdatesActivity kzn;
    private View kzx;
    private BdListView kzy;
    private a kzz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kzn = updatesActivity;
        initView();
        this.kzz = new a(this.kzn);
        this.kzy.setAdapter((ListAdapter) this.kzz);
        this.kzy.setOnScrollListener(this.kzn);
    }

    void initView() {
        this.fIC = View.inflate(this.kzn.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kzn.setContentView(this.fIC);
        this.mNavigationBar = (NavigationBar) this.kzn.findViewById(R.id.view_navigation_bar);
        this.kzx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kzn.getPageContext().getString(R.string.updates_activity_title));
        this.kzE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kzF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kzD = (Button) this.kzE.findViewById(R.id.btn_delete);
        this.kzD.setOnClickListener(this.kzn);
        this.kzx.setOnClickListener(this.kzn);
        this.kzy = (BdListView) this.fIC.findViewById(R.id.updates_list);
        this.kzA = (ProgressBar) this.fIC.findViewById(R.id.pro_load);
        this.kzB = (Button) this.kzF.findViewById(R.id.btn_edit);
        this.kzB.setOnClickListener(this.kzn);
        this.kzC = (Button) this.kzF.findViewById(R.id.btn_cancel);
        this.kzC.setOnClickListener(this.kzn);
        CH(0);
        sJ(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kzz != null) {
            this.kzz.destroy();
            this.kzz = null;
        }
        this.kzn = null;
    }

    public a cUw() {
        return this.kzz;
    }

    public void cUx() {
        this.kzB.setVisibility(8);
        this.kzx.setVisibility(8);
        this.kzC.setVisibility(0);
        this.kzE.setVisibility(0);
        cUz();
    }

    public void cUy() {
        this.kzB.setVisibility(0);
        this.kzx.setVisibility(0);
        this.kzC.setVisibility(8);
        this.kzE.setVisibility(8);
        CH(0);
        cUz();
    }

    public void cUz() {
        if (this.kzz != null) {
            this.kzz.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kzz != null) {
            this.kzz.setData(list);
        }
    }

    public void CH(int i) {
        if (this.kzD != null && this.kzn != null) {
            this.kzD.setText(String.format(this.kzn.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kzD.setEnabled(false);
            } else {
                this.kzD.setEnabled(true);
            }
        }
    }

    public void sJ(boolean z) {
        this.kzA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kzn.getLayoutMode().setNightMode(i == 1);
        this.kzn.getLayoutMode().onModeChanged(this.fIC);
        this.mNavigationBar.onChangeSkinType(this.kzn.getPageContext(), i);
        ao.setBackgroundResource(this.kzD, R.drawable.btn_delete_groupupdates);
    }

    public View cUA() {
        return this.kzx;
    }

    public BdListView cUB() {
        return this.kzy;
    }

    public Button cUC() {
        return this.kzB;
    }

    public Button cUD() {
        return this.kzC;
    }

    public Button cUE() {
        return this.kzD;
    }
}

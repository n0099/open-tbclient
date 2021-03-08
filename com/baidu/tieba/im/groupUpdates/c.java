package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends d<UpdatesActivity> {
    private View fMn;
    private UpdatesActivity kJI;
    private View kJS;
    private BdListView kJT;
    private a kJU;
    private ProgressBar kJV;
    private Button kJW;
    private Button kJX;
    private Button kJY;
    private View kJZ;
    private View kKa;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kJI = updatesActivity;
        initView();
        this.kJU = new a(this.kJI);
        this.kJT.setAdapter((ListAdapter) this.kJU);
        this.kJT.setOnScrollListener(this.kJI);
    }

    void initView() {
        this.fMn = View.inflate(this.kJI.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kJI.setContentView(this.fMn);
        this.mNavigationBar = (NavigationBar) this.kJI.findViewById(R.id.view_navigation_bar);
        this.kJS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kJI.getPageContext().getString(R.string.updates_activity_title));
        this.kJZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kKa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kJY = (Button) this.kJZ.findViewById(R.id.btn_delete);
        this.kJY.setOnClickListener(this.kJI);
        this.kJS.setOnClickListener(this.kJI);
        this.kJT = (BdListView) this.fMn.findViewById(R.id.updates_list);
        this.kJV = (ProgressBar) this.fMn.findViewById(R.id.pro_load);
        this.kJW = (Button) this.kKa.findViewById(R.id.btn_edit);
        this.kJW.setOnClickListener(this.kJI);
        this.kJX = (Button) this.kKa.findViewById(R.id.btn_cancel);
        this.kJX.setOnClickListener(this.kJI);
        Dc(0);
        sW(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kJU != null) {
            this.kJU.destroy();
            this.kJU = null;
        }
        this.kJI = null;
    }

    public a cWI() {
        return this.kJU;
    }

    public void cWJ() {
        this.kJW.setVisibility(8);
        this.kJS.setVisibility(8);
        this.kJX.setVisibility(0);
        this.kJZ.setVisibility(0);
        cWL();
    }

    public void cWK() {
        this.kJW.setVisibility(0);
        this.kJS.setVisibility(0);
        this.kJX.setVisibility(8);
        this.kJZ.setVisibility(8);
        Dc(0);
        cWL();
    }

    public void cWL() {
        if (this.kJU != null) {
            this.kJU.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kJU != null) {
            this.kJU.setData(list);
        }
    }

    public void Dc(int i) {
        if (this.kJY != null && this.kJI != null) {
            this.kJY.setText(String.format(this.kJI.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kJY.setEnabled(false);
            } else {
                this.kJY.setEnabled(true);
            }
        }
    }

    public void sW(boolean z) {
        this.kJV.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kJI.getLayoutMode().setNightMode(i == 1);
        this.kJI.getLayoutMode().onModeChanged(this.fMn);
        this.mNavigationBar.onChangeSkinType(this.kJI.getPageContext(), i);
        ap.setBackgroundResource(this.kJY, R.drawable.btn_delete_groupupdates);
    }

    public View cWM() {
        return this.kJS;
    }

    public BdListView cWN() {
        return this.kJT;
    }

    public Button cWO() {
        return this.kJW;
    }

    public Button cWP() {
        return this.kJX;
    }

    public Button cWQ() {
        return this.kJY;
    }
}

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
/* loaded from: classes8.dex */
public class c extends d<UpdatesActivity> {
    private View fKN;
    private UpdatesActivity kHG;
    private View kHQ;
    private BdListView kHR;
    private a kHS;
    private ProgressBar kHT;
    private Button kHU;
    private Button kHV;
    private Button kHW;
    private View kHX;
    private View kHY;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kHG = updatesActivity;
        initView();
        this.kHS = new a(this.kHG);
        this.kHR.setAdapter((ListAdapter) this.kHS);
        this.kHR.setOnScrollListener(this.kHG);
    }

    void initView() {
        this.fKN = View.inflate(this.kHG.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kHG.setContentView(this.fKN);
        this.mNavigationBar = (NavigationBar) this.kHG.findViewById(R.id.view_navigation_bar);
        this.kHQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kHG.getPageContext().getString(R.string.updates_activity_title));
        this.kHX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kHY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kHW = (Button) this.kHX.findViewById(R.id.btn_delete);
        this.kHW.setOnClickListener(this.kHG);
        this.kHQ.setOnClickListener(this.kHG);
        this.kHR = (BdListView) this.fKN.findViewById(R.id.updates_list);
        this.kHT = (ProgressBar) this.fKN.findViewById(R.id.pro_load);
        this.kHU = (Button) this.kHY.findViewById(R.id.btn_edit);
        this.kHU.setOnClickListener(this.kHG);
        this.kHV = (Button) this.kHY.findViewById(R.id.btn_cancel);
        this.kHV.setOnClickListener(this.kHG);
        CZ(0);
        sW(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kHS != null) {
            this.kHS.destroy();
            this.kHS = null;
        }
        this.kHG = null;
    }

    public a cWB() {
        return this.kHS;
    }

    public void cWC() {
        this.kHU.setVisibility(8);
        this.kHQ.setVisibility(8);
        this.kHV.setVisibility(0);
        this.kHX.setVisibility(0);
        cWE();
    }

    public void cWD() {
        this.kHU.setVisibility(0);
        this.kHQ.setVisibility(0);
        this.kHV.setVisibility(8);
        this.kHX.setVisibility(8);
        CZ(0);
        cWE();
    }

    public void cWE() {
        if (this.kHS != null) {
            this.kHS.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kHS != null) {
            this.kHS.setData(list);
        }
    }

    public void CZ(int i) {
        if (this.kHW != null && this.kHG != null) {
            this.kHW.setText(String.format(this.kHG.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kHW.setEnabled(false);
            } else {
                this.kHW.setEnabled(true);
            }
        }
    }

    public void sW(boolean z) {
        this.kHT.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kHG.getLayoutMode().setNightMode(i == 1);
        this.kHG.getLayoutMode().onModeChanged(this.fKN);
        this.mNavigationBar.onChangeSkinType(this.kHG.getPageContext(), i);
        ap.setBackgroundResource(this.kHW, R.drawable.btn_delete_groupupdates);
    }

    public View cWF() {
        return this.kHQ;
    }

    public BdListView cWG() {
        return this.kHR;
    }

    public Button cWH() {
        return this.kHU;
    }

    public Button cWI() {
        return this.kHV;
    }

    public Button cWJ() {
        return this.kHW;
    }
}

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
    private View kHC;
    private BdListView kHD;
    private a kHE;
    private ProgressBar kHF;
    private Button kHG;
    private Button kHH;
    private Button kHI;
    private View kHJ;
    private View kHK;
    private UpdatesActivity kHs;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kHs = updatesActivity;
        initView();
        this.kHE = new a(this.kHs);
        this.kHD.setAdapter((ListAdapter) this.kHE);
        this.kHD.setOnScrollListener(this.kHs);
    }

    void initView() {
        this.fKN = View.inflate(this.kHs.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kHs.setContentView(this.fKN);
        this.mNavigationBar = (NavigationBar) this.kHs.findViewById(R.id.view_navigation_bar);
        this.kHC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kHs.getPageContext().getString(R.string.updates_activity_title));
        this.kHJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kHK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kHI = (Button) this.kHJ.findViewById(R.id.btn_delete);
        this.kHI.setOnClickListener(this.kHs);
        this.kHC.setOnClickListener(this.kHs);
        this.kHD = (BdListView) this.fKN.findViewById(R.id.updates_list);
        this.kHF = (ProgressBar) this.fKN.findViewById(R.id.pro_load);
        this.kHG = (Button) this.kHK.findViewById(R.id.btn_edit);
        this.kHG.setOnClickListener(this.kHs);
        this.kHH = (Button) this.kHK.findViewById(R.id.btn_cancel);
        this.kHH.setOnClickListener(this.kHs);
        CZ(0);
        sW(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kHE != null) {
            this.kHE.destroy();
            this.kHE = null;
        }
        this.kHs = null;
    }

    public a cWu() {
        return this.kHE;
    }

    public void cWv() {
        this.kHG.setVisibility(8);
        this.kHC.setVisibility(8);
        this.kHH.setVisibility(0);
        this.kHJ.setVisibility(0);
        cWx();
    }

    public void cWw() {
        this.kHG.setVisibility(0);
        this.kHC.setVisibility(0);
        this.kHH.setVisibility(8);
        this.kHJ.setVisibility(8);
        CZ(0);
        cWx();
    }

    public void cWx() {
        if (this.kHE != null) {
            this.kHE.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kHE != null) {
            this.kHE.setData(list);
        }
    }

    public void CZ(int i) {
        if (this.kHI != null && this.kHs != null) {
            this.kHI.setText(String.format(this.kHs.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kHI.setEnabled(false);
            } else {
                this.kHI.setEnabled(true);
            }
        }
    }

    public void sW(boolean z) {
        this.kHF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kHs.getLayoutMode().setNightMode(i == 1);
        this.kHs.getLayoutMode().onModeChanged(this.fKN);
        this.mNavigationBar.onChangeSkinType(this.kHs.getPageContext(), i);
        ap.setBackgroundResource(this.kHI, R.drawable.btn_delete_groupupdates);
    }

    public View cWy() {
        return this.kHC;
    }

    public BdListView cWz() {
        return this.kHD;
    }

    public Button cWA() {
        return this.kHG;
    }

    public Button cWB() {
        return this.kHH;
    }

    public Button cWC() {
        return this.kHI;
    }
}

package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View fwA;
    private View kit;
    private a kkA;
    private ProgressBar kkB;
    private Button kkC;
    private Button kkD;
    private Button kkE;
    private View kkF;
    private View kkG;
    private UpdatesActivity kkp;
    private BdListView kkz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kkp = updatesActivity;
        initView();
        this.kkA = new a(this.kkp);
        this.kkz.setAdapter((ListAdapter) this.kkA);
        this.kkz.setOnScrollListener(this.kkp);
    }

    void initView() {
        this.fwA = View.inflate(this.kkp.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kkp.setContentView(this.fwA);
        this.mNavigationBar = (NavigationBar) this.kkp.findViewById(R.id.view_navigation_bar);
        this.kit = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kkp.getPageContext().getString(R.string.updates_activity_title));
        this.kkF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kkG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kkE = (Button) this.kkF.findViewById(R.id.btn_delete);
        this.kkE.setOnClickListener(this.kkp);
        this.kit.setOnClickListener(this.kkp);
        this.kkz = (BdListView) this.fwA.findViewById(R.id.updates_list);
        this.kkB = (ProgressBar) this.fwA.findViewById(R.id.pro_load);
        this.kkC = (Button) this.kkG.findViewById(R.id.btn_edit);
        this.kkC.setOnClickListener(this.kkp);
        this.kkD = (Button) this.kkG.findViewById(R.id.btn_cancel);
        this.kkD.setOnClickListener(this.kkp);
        Dg(0);
        se(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kkA != null) {
            this.kkA.destroy();
            this.kkA = null;
        }
        this.kkp = null;
    }

    public a cTB() {
        return this.kkA;
    }

    public void cTC() {
        this.kkC.setVisibility(8);
        this.kit.setVisibility(8);
        this.kkD.setVisibility(0);
        this.kkF.setVisibility(0);
        cSu();
    }

    public void cTD() {
        this.kkC.setVisibility(0);
        this.kit.setVisibility(0);
        this.kkD.setVisibility(8);
        this.kkF.setVisibility(8);
        Dg(0);
        cSu();
    }

    public void cSu() {
        if (this.kkA != null) {
            this.kkA.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kkA != null) {
            this.kkA.setData(list);
        }
    }

    public void Dg(int i) {
        if (this.kkE != null && this.kkp != null) {
            this.kkE.setText(String.format(this.kkp.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kkE.setEnabled(false);
            } else {
                this.kkE.setEnabled(true);
            }
        }
    }

    public void se(boolean z) {
        this.kkB.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kkp.getLayoutMode().setNightMode(i == 1);
        this.kkp.getLayoutMode().onModeChanged(this.fwA);
        this.mNavigationBar.onChangeSkinType(this.kkp.getPageContext(), i);
        ap.setBackgroundResource(this.kkE, R.drawable.btn_delete_groupupdates);
    }

    public View cTE() {
        return this.kit;
    }

    public BdListView cTF() {
        return this.kkz;
    }

    public Button cTG() {
        return this.kkC;
    }

    public Button cTH() {
        return this.kkD;
    }

    public Button cTI() {
        return this.kkE;
    }
}

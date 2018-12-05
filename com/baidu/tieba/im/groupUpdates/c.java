package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View eSB;
    private View eSx;
    private BdListView eUG;
    private a eUH;
    private ProgressBar eUI;
    private Button eUJ;
    private Button eUK;
    private Button eUL;
    private View eUM;
    private View eUN;
    private UpdatesActivity eUv;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eUv = updatesActivity;
        initView();
        this.eUH = new a(this.eUv);
        this.eUG.setAdapter((ListAdapter) this.eUH);
        this.eUG.setOnScrollListener(this.eUv);
    }

    void initView() {
        this.eSx = View.inflate(this.eUv.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eUv.setContentView(this.eSx);
        this.mNavigationBar = (NavigationBar) this.eUv.findViewById(e.g.view_navigation_bar);
        this.eSB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eUv.getPageContext().getString(e.j.updates_activity_title));
        this.eUM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eUN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eUL = (Button) this.eUM.findViewById(e.g.btn_delete);
        this.eUL.setOnClickListener(this.eUv);
        this.eSB.setOnClickListener(this.eUv);
        this.eUG = (BdListView) this.eSx.findViewById(e.g.updates_list);
        this.eUI = (ProgressBar) this.eSx.findViewById(e.g.pro_load);
        this.eUJ = (Button) this.eUN.findViewById(e.g.btn_edit);
        this.eUJ.setOnClickListener(this.eUv);
        this.eUK = (Button) this.eUN.findViewById(e.g.btn_cancel);
        this.eUK.setOnClickListener(this.eUv);
        qe(0);
        iL(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eUH != null) {
            this.eUH.destroy();
            this.eUH = null;
        }
        this.eUv = null;
    }

    public a aSE() {
        return this.eUH;
    }

    public void aSF() {
        this.eUJ.setVisibility(8);
        this.eSB.setVisibility(8);
        this.eUK.setVisibility(0);
        this.eUM.setVisibility(0);
        aRw();
    }

    public void aSG() {
        this.eUJ.setVisibility(0);
        this.eSB.setVisibility(0);
        this.eUK.setVisibility(8);
        this.eUM.setVisibility(8);
        qe(0);
        aRw();
    }

    public void aRw() {
        if (this.eUH != null) {
            this.eUH.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eUH != null) {
            this.eUH.setData(list);
        }
    }

    public void qe(int i) {
        if (this.eUL != null && this.eUv != null) {
            this.eUL.setText(String.format(this.eUv.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eUL.setEnabled(false);
            } else {
                this.eUL.setEnabled(true);
            }
        }
    }

    public void iL(boolean z) {
        this.eUI.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eUv.getLayoutMode().setNightMode(i == 1);
        this.eUv.getLayoutMode().onModeChanged(this.eSx);
        this.mNavigationBar.onChangeSkinType(this.eUv.getPageContext(), i);
        al.i(this.eUL, e.f.btn_delete_groupupdates);
    }

    public View aSH() {
        return this.eSB;
    }

    public BdListView aSI() {
        return this.eUG;
    }

    public Button aSJ() {
        return this.eUJ;
    }

    public Button aSK() {
        return this.eUK;
    }

    public Button aSL() {
        return this.eUL;
    }
}

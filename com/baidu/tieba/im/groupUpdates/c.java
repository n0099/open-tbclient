package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View ecq;
    private View ecu;
    private BdListView eeC;
    private a eeD;
    private ProgressBar eeE;
    private Button eeF;
    private Button eeG;
    private Button eeH;
    private View eeI;
    private View eeJ;
    private UpdatesActivity eeq;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eeq = updatesActivity;
        initView();
        this.eeD = new a(this.eeq);
        this.eeC.setAdapter((ListAdapter) this.eeD);
        this.eeC.setOnScrollListener(this.eeq);
    }

    void initView() {
        this.ecq = View.inflate(this.eeq.getPageContext().getPageActivity(), d.i.updates_activity, null);
        this.eeq.setContentView(this.ecq);
        this.mNavigationBar = (NavigationBar) this.eeq.findViewById(d.g.view_navigation_bar);
        this.ecu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eeq.getPageContext().getString(d.k.updates_activity_title));
        this.eeI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.updates_activity_nav_left, (View.OnClickListener) null);
        this.eeJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.updates_activity_nav_right, (View.OnClickListener) null);
        this.eeH = (Button) this.eeI.findViewById(d.g.btn_delete);
        this.eeH.setOnClickListener(this.eeq);
        this.ecu.setOnClickListener(this.eeq);
        this.eeC = (BdListView) this.ecq.findViewById(d.g.updates_list);
        this.eeE = (ProgressBar) this.ecq.findViewById(d.g.pro_load);
        this.eeF = (Button) this.eeJ.findViewById(d.g.btn_edit);
        this.eeF.setOnClickListener(this.eeq);
        this.eeG = (Button) this.eeJ.findViewById(d.g.btn_cancel);
        this.eeG.setOnClickListener(this.eeq);
        nI(0);
        hq(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eeD != null) {
            this.eeD.destroy();
            this.eeD = null;
        }
        this.eeq = null;
    }

    public a aFm() {
        return this.eeD;
    }

    public void aFn() {
        this.eeF.setVisibility(8);
        this.ecu.setVisibility(8);
        this.eeG.setVisibility(0);
        this.eeI.setVisibility(0);
        aEd();
    }

    public void aFo() {
        this.eeF.setVisibility(0);
        this.ecu.setVisibility(0);
        this.eeG.setVisibility(8);
        this.eeI.setVisibility(8);
        nI(0);
        aEd();
    }

    public void aEd() {
        if (this.eeD != null) {
            this.eeD.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eeD != null) {
            this.eeD.setData(list);
        }
    }

    public void nI(int i) {
        if (this.eeH != null && this.eeq != null) {
            this.eeH.setText(String.format(this.eeq.getPageContext().getString(d.k.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eeH.setEnabled(false);
            } else {
                this.eeH.setEnabled(true);
            }
        }
    }

    public void hq(boolean z) {
        this.eeE.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eeq.getLayoutMode().setNightMode(i == 1);
        this.eeq.getLayoutMode().u(this.ecq);
        this.mNavigationBar.onChangeSkinType(this.eeq.getPageContext(), i);
        ak.i(this.eeH, d.f.btn_delete_groupupdates);
    }

    public View aFp() {
        return this.ecu;
    }

    public BdListView aFq() {
        return this.eeC;
    }

    public Button aFr() {
        return this.eeF;
    }

    public Button aFs() {
        return this.eeG;
    }

    public Button aFt() {
        return this.eeH;
    }
}

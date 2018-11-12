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
    private View eLI;
    private View eLM;
    private UpdatesActivity eNG;
    private BdListView eNR;
    private a eNS;
    private ProgressBar eNT;
    private Button eNU;
    private Button eNV;
    private Button eNW;
    private View eNX;
    private View eNY;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eNG = updatesActivity;
        initView();
        this.eNS = new a(this.eNG);
        this.eNR.setAdapter((ListAdapter) this.eNS);
        this.eNR.setOnScrollListener(this.eNG);
    }

    void initView() {
        this.eLI = View.inflate(this.eNG.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eNG.setContentView(this.eLI);
        this.mNavigationBar = (NavigationBar) this.eNG.findViewById(e.g.view_navigation_bar);
        this.eLM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eNG.getPageContext().getString(e.j.updates_activity_title));
        this.eNX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eNY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eNW = (Button) this.eNX.findViewById(e.g.btn_delete);
        this.eNW.setOnClickListener(this.eNG);
        this.eLM.setOnClickListener(this.eNG);
        this.eNR = (BdListView) this.eLI.findViewById(e.g.updates_list);
        this.eNT = (ProgressBar) this.eLI.findViewById(e.g.pro_load);
        this.eNU = (Button) this.eNY.findViewById(e.g.btn_edit);
        this.eNU.setOnClickListener(this.eNG);
        this.eNV = (Button) this.eNY.findViewById(e.g.btn_cancel);
        this.eNV.setOnClickListener(this.eNG);
        pK(0);
        iI(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eNS != null) {
            this.eNS.destroy();
            this.eNS = null;
        }
        this.eNG = null;
    }

    public a aQM() {
        return this.eNS;
    }

    public void aQN() {
        this.eNU.setVisibility(8);
        this.eLM.setVisibility(8);
        this.eNV.setVisibility(0);
        this.eNX.setVisibility(0);
        aPE();
    }

    public void aQO() {
        this.eNU.setVisibility(0);
        this.eLM.setVisibility(0);
        this.eNV.setVisibility(8);
        this.eNX.setVisibility(8);
        pK(0);
        aPE();
    }

    public void aPE() {
        if (this.eNS != null) {
            this.eNS.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eNS != null) {
            this.eNS.setData(list);
        }
    }

    public void pK(int i) {
        if (this.eNW != null && this.eNG != null) {
            this.eNW.setText(String.format(this.eNG.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eNW.setEnabled(false);
            } else {
                this.eNW.setEnabled(true);
            }
        }
    }

    public void iI(boolean z) {
        this.eNT.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eNG.getLayoutMode().setNightMode(i == 1);
        this.eNG.getLayoutMode().onModeChanged(this.eLI);
        this.mNavigationBar.onChangeSkinType(this.eNG.getPageContext(), i);
        al.i(this.eNW, e.f.btn_delete_groupupdates);
    }

    public View aQP() {
        return this.eLM;
    }

    public BdListView aQQ() {
        return this.eNR;
    }

    public Button aQR() {
        return this.eNU;
    }

    public Button aQS() {
        return this.eNV;
    }

    public Button aQT() {
        return this.eNW;
    }
}

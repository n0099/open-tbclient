package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View bMz;
    private View eGG;
    private UpdatesActivity eID;
    private BdListView eIP;
    private a eIQ;
    private ProgressBar eIR;
    private Button eIS;
    private Button eIT;
    private Button eIU;
    private View eIV;
    private View eIW;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eID = updatesActivity;
        initView();
        this.eIQ = new a(this.eID);
        this.eIP.setAdapter((ListAdapter) this.eIQ);
        this.eIP.setOnScrollListener(this.eID);
    }

    void initView() {
        this.bMz = View.inflate(this.eID.getPageContext().getPageActivity(), d.h.updates_activity, null);
        this.eID.setContentView(this.bMz);
        this.mNavigationBar = (NavigationBar) this.eID.findViewById(d.g.view_navigation_bar);
        this.eGG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eID.getPageContext().getString(d.j.updates_activity_title));
        this.eIV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eIW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eIU = (Button) this.eIV.findViewById(d.g.btn_delete);
        this.eIU.setOnClickListener(this.eID);
        this.eGG.setOnClickListener(this.eID);
        this.eIP = (BdListView) this.bMz.findViewById(d.g.updates_list);
        this.eIR = (ProgressBar) this.bMz.findViewById(d.g.pro_load);
        this.eIS = (Button) this.eIW.findViewById(d.g.btn_edit);
        this.eIS.setOnClickListener(this.eID);
        this.eIT = (Button) this.eIW.findViewById(d.g.btn_cancel);
        this.eIT.setOnClickListener(this.eID);
        ql(0);
        hK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eIQ != null) {
            this.eIQ.destroy();
            this.eIQ = null;
        }
        this.eID = null;
    }

    public a aKr() {
        return this.eIQ;
    }

    public void aKs() {
        this.eIS.setVisibility(8);
        this.eGG.setVisibility(8);
        this.eIT.setVisibility(0);
        this.eIV.setVisibility(0);
        aJi();
    }

    public void aKt() {
        this.eIS.setVisibility(0);
        this.eGG.setVisibility(0);
        this.eIT.setVisibility(8);
        this.eIV.setVisibility(8);
        ql(0);
        aJi();
    }

    public void aJi() {
        if (this.eIQ != null) {
            this.eIQ.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eIQ != null) {
            this.eIQ.setData(list);
        }
    }

    public void ql(int i) {
        if (this.eIU != null && this.eID != null) {
            this.eIU.setText(String.format(this.eID.getPageContext().getString(d.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eIU.setEnabled(false);
            } else {
                this.eIU.setEnabled(true);
            }
        }
    }

    public void hK(boolean z) {
        this.eIR.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eID.getLayoutMode().aQ(i == 1);
        this.eID.getLayoutMode().aM(this.bMz);
        this.mNavigationBar.onChangeSkinType(this.eID.getPageContext(), i);
        aj.s(this.eIU, d.f.btn_delete_groupupdates);
    }

    public View aKu() {
        return this.eGG;
    }

    public BdListView aKv() {
        return this.eIP;
    }

    public Button aKw() {
        return this.eIS;
    }

    public Button aKx() {
        return this.eIT;
    }

    public Button aKy() {
        return this.eIU;
    }
}

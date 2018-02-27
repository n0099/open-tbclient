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
    private View bMm;
    private View eGu;
    private BdListView eID;
    private a eIE;
    private ProgressBar eIF;
    private Button eIG;
    private Button eIH;
    private Button eII;
    private View eIJ;
    private View eIK;
    private UpdatesActivity eIr;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eIr = updatesActivity;
        initView();
        this.eIE = new a(this.eIr);
        this.eID.setAdapter((ListAdapter) this.eIE);
        this.eID.setOnScrollListener(this.eIr);
    }

    void initView() {
        this.bMm = View.inflate(this.eIr.getPageContext().getPageActivity(), d.h.updates_activity, null);
        this.eIr.setContentView(this.bMm);
        this.mNavigationBar = (NavigationBar) this.eIr.findViewById(d.g.view_navigation_bar);
        this.eGu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eIr.getPageContext().getString(d.j.updates_activity_title));
        this.eIJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eIK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eII = (Button) this.eIJ.findViewById(d.g.btn_delete);
        this.eII.setOnClickListener(this.eIr);
        this.eGu.setOnClickListener(this.eIr);
        this.eID = (BdListView) this.bMm.findViewById(d.g.updates_list);
        this.eIF = (ProgressBar) this.bMm.findViewById(d.g.pro_load);
        this.eIG = (Button) this.eIK.findViewById(d.g.btn_edit);
        this.eIG.setOnClickListener(this.eIr);
        this.eIH = (Button) this.eIK.findViewById(d.g.btn_cancel);
        this.eIH.setOnClickListener(this.eIr);
        ql(0);
        hK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eIE != null) {
            this.eIE.destroy();
            this.eIE = null;
        }
        this.eIr = null;
    }

    public a aKq() {
        return this.eIE;
    }

    public void aKr() {
        this.eIG.setVisibility(8);
        this.eGu.setVisibility(8);
        this.eIH.setVisibility(0);
        this.eIJ.setVisibility(0);
        aJh();
    }

    public void aKs() {
        this.eIG.setVisibility(0);
        this.eGu.setVisibility(0);
        this.eIH.setVisibility(8);
        this.eIJ.setVisibility(8);
        ql(0);
        aJh();
    }

    public void aJh() {
        if (this.eIE != null) {
            this.eIE.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eIE != null) {
            this.eIE.setData(list);
        }
    }

    public void ql(int i) {
        if (this.eII != null && this.eIr != null) {
            this.eII.setText(String.format(this.eIr.getPageContext().getString(d.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eII.setEnabled(false);
            } else {
                this.eII.setEnabled(true);
            }
        }
    }

    public void hK(boolean z) {
        this.eIF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eIr.getLayoutMode().aQ(i == 1);
        this.eIr.getLayoutMode().aM(this.bMm);
        this.mNavigationBar.onChangeSkinType(this.eIr.getPageContext(), i);
        aj.s(this.eII, d.f.btn_delete_groupupdates);
    }

    public View aKt() {
        return this.eGu;
    }

    public BdListView aKu() {
        return this.eID;
    }

    public Button aKv() {
        return this.eIG;
    }

    public Button aKw() {
        return this.eIH;
    }

    public Button aKx() {
        return this.eII;
    }
}

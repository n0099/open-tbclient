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
    private View eKp;
    private View eKt;
    private ProgressBar eMA;
    private Button eMB;
    private Button eMC;
    private Button eMD;
    private View eME;
    private View eMF;
    private UpdatesActivity eMn;
    private BdListView eMy;
    private a eMz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eMn = updatesActivity;
        initView();
        this.eMz = new a(this.eMn);
        this.eMy.setAdapter((ListAdapter) this.eMz);
        this.eMy.setOnScrollListener(this.eMn);
    }

    void initView() {
        this.eKp = View.inflate(this.eMn.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eMn.setContentView(this.eKp);
        this.mNavigationBar = (NavigationBar) this.eMn.findViewById(e.g.view_navigation_bar);
        this.eKt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eMn.getPageContext().getString(e.j.updates_activity_title));
        this.eME = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eMF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eMD = (Button) this.eME.findViewById(e.g.btn_delete);
        this.eMD.setOnClickListener(this.eMn);
        this.eKt.setOnClickListener(this.eMn);
        this.eMy = (BdListView) this.eKp.findViewById(e.g.updates_list);
        this.eMA = (ProgressBar) this.eKp.findViewById(e.g.pro_load);
        this.eMB = (Button) this.eMF.findViewById(e.g.btn_edit);
        this.eMB.setOnClickListener(this.eMn);
        this.eMC = (Button) this.eMF.findViewById(e.g.btn_cancel);
        this.eMC.setOnClickListener(this.eMn);
        pr(0);
        iz(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eMz != null) {
            this.eMz.destroy();
            this.eMz = null;
        }
        this.eMn = null;
    }

    public a aRp() {
        return this.eMz;
    }

    public void aRq() {
        this.eMB.setVisibility(8);
        this.eKt.setVisibility(8);
        this.eMC.setVisibility(0);
        this.eME.setVisibility(0);
        aQh();
    }

    public void aRr() {
        this.eMB.setVisibility(0);
        this.eKt.setVisibility(0);
        this.eMC.setVisibility(8);
        this.eME.setVisibility(8);
        pr(0);
        aQh();
    }

    public void aQh() {
        if (this.eMz != null) {
            this.eMz.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eMz != null) {
            this.eMz.setData(list);
        }
    }

    public void pr(int i) {
        if (this.eMD != null && this.eMn != null) {
            this.eMD.setText(String.format(this.eMn.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eMD.setEnabled(false);
            } else {
                this.eMD.setEnabled(true);
            }
        }
    }

    public void iz(boolean z) {
        this.eMA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eMn.getLayoutMode().setNightMode(i == 1);
        this.eMn.getLayoutMode().onModeChanged(this.eKp);
        this.mNavigationBar.onChangeSkinType(this.eMn.getPageContext(), i);
        al.i(this.eMD, e.f.btn_delete_groupupdates);
    }

    public View aRs() {
        return this.eKt;
    }

    public BdListView aRt() {
        return this.eMy;
    }

    public Button aRu() {
        return this.eMB;
    }

    public Button aRv() {
        return this.eMC;
    }

    public Button aRw() {
        return this.eMD;
    }
}

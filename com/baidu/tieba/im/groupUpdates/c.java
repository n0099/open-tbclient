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
    private View bMp;
    private View eGK;
    private UpdatesActivity eIH;
    private BdListView eIT;
    private a eIU;
    private ProgressBar eIV;
    private Button eIW;
    private Button eIX;
    private Button eIY;
    private View eIZ;
    private View eJa;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eIH = updatesActivity;
        initView();
        this.eIU = new a(this.eIH);
        this.eIT.setAdapter((ListAdapter) this.eIU);
        this.eIT.setOnScrollListener(this.eIH);
    }

    void initView() {
        this.bMp = View.inflate(this.eIH.getPageContext().getPageActivity(), d.h.updates_activity, null);
        this.eIH.setContentView(this.bMp);
        this.mNavigationBar = (NavigationBar) this.eIH.findViewById(d.g.view_navigation_bar);
        this.eGK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eIH.getPageContext().getString(d.j.updates_activity_title));
        this.eIZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eJa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eIY = (Button) this.eIZ.findViewById(d.g.btn_delete);
        this.eIY.setOnClickListener(this.eIH);
        this.eGK.setOnClickListener(this.eIH);
        this.eIT = (BdListView) this.bMp.findViewById(d.g.updates_list);
        this.eIV = (ProgressBar) this.bMp.findViewById(d.g.pro_load);
        this.eIW = (Button) this.eJa.findViewById(d.g.btn_edit);
        this.eIW.setOnClickListener(this.eIH);
        this.eIX = (Button) this.eJa.findViewById(d.g.btn_cancel);
        this.eIX.setOnClickListener(this.eIH);
        qm(0);
        hP(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eIU != null) {
            this.eIU.destroy();
            this.eIU = null;
        }
        this.eIH = null;
    }

    public a aKr() {
        return this.eIU;
    }

    public void aKs() {
        this.eIW.setVisibility(8);
        this.eGK.setVisibility(8);
        this.eIX.setVisibility(0);
        this.eIZ.setVisibility(0);
        aJi();
    }

    public void aKt() {
        this.eIW.setVisibility(0);
        this.eGK.setVisibility(0);
        this.eIX.setVisibility(8);
        this.eIZ.setVisibility(8);
        qm(0);
        aJi();
    }

    public void aJi() {
        if (this.eIU != null) {
            this.eIU.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eIU != null) {
            this.eIU.setData(list);
        }
    }

    public void qm(int i) {
        if (this.eIY != null && this.eIH != null) {
            this.eIY.setText(String.format(this.eIH.getPageContext().getString(d.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eIY.setEnabled(false);
            } else {
                this.eIY.setEnabled(true);
            }
        }
    }

    public void hP(boolean z) {
        this.eIV.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eIH.getLayoutMode().aQ(i == 1);
        this.eIH.getLayoutMode().aM(this.bMp);
        this.mNavigationBar.onChangeSkinType(this.eIH.getPageContext(), i);
        aj.s(this.eIY, d.f.btn_delete_groupupdates);
    }

    public View aKu() {
        return this.eGK;
    }

    public BdListView aKv() {
        return this.eIT;
    }

    public Button aKw() {
        return this.eIW;
    }

    public Button aKx() {
        return this.eIX;
    }

    public Button aKy() {
        return this.eIY;
    }
}

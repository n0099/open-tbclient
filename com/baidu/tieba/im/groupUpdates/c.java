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
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View eTd;
    private View jsr;
    private Button juA;
    private Button juB;
    private Button juC;
    private View juD;
    private View juE;
    private UpdatesActivity jun;
    private BdListView jux;
    private a juy;
    private ProgressBar juz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.jun = updatesActivity;
        initView();
        this.juy = new a(this.jun);
        this.jux.setAdapter((ListAdapter) this.juy);
        this.jux.setOnScrollListener(this.jun);
    }

    void initView() {
        this.eTd = View.inflate(this.jun.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.jun.setContentView(this.eTd);
        this.mNavigationBar = (NavigationBar) this.jun.findViewById(R.id.view_navigation_bar);
        this.jsr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jun.getPageContext().getString(R.string.updates_activity_title));
        this.juD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.juE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.juC = (Button) this.juD.findViewById(R.id.btn_delete);
        this.juC.setOnClickListener(this.jun);
        this.jsr.setOnClickListener(this.jun);
        this.jux = (BdListView) this.eTd.findViewById(R.id.updates_list);
        this.juz = (ProgressBar) this.eTd.findViewById(R.id.pro_load);
        this.juA = (Button) this.juE.findViewById(R.id.btn_edit);
        this.juA.setOnClickListener(this.jun);
        this.juB = (Button) this.juE.findViewById(R.id.btn_cancel);
        this.juB.setOnClickListener(this.jun);
        Bt(0);
        qN(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.juy != null) {
            this.juy.destroy();
            this.juy = null;
        }
        this.jun = null;
    }

    public a cGD() {
        return this.juy;
    }

    public void cGE() {
        this.juA.setVisibility(8);
        this.jsr.setVisibility(8);
        this.juB.setVisibility(0);
        this.juD.setVisibility(0);
        cFw();
    }

    public void cGF() {
        this.juA.setVisibility(0);
        this.jsr.setVisibility(0);
        this.juB.setVisibility(8);
        this.juD.setVisibility(8);
        Bt(0);
        cFw();
    }

    public void cFw() {
        if (this.juy != null) {
            this.juy.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.juy != null) {
            this.juy.setData(list);
        }
    }

    public void Bt(int i) {
        if (this.juC != null && this.jun != null) {
            this.juC.setText(String.format(this.jun.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.juC.setEnabled(false);
            } else {
                this.juC.setEnabled(true);
            }
        }
    }

    public void qN(boolean z) {
        this.juz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jun.getLayoutMode().setNightMode(i == 1);
        this.jun.getLayoutMode().onModeChanged(this.eTd);
        this.mNavigationBar.onChangeSkinType(this.jun.getPageContext(), i);
        ap.setBackgroundResource(this.juC, R.drawable.btn_delete_groupupdates);
    }

    public View cGG() {
        return this.jsr;
    }

    public BdListView cGH() {
        return this.jux;
    }

    public Button cGI() {
        return this.juA;
    }

    public Button cGJ() {
        return this.juB;
    }

    public Button cGK() {
        return this.juC;
    }
}

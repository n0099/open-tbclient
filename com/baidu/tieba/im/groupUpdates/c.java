package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View enE;
    private View enI;
    private UpdatesActivity epF;
    private BdListView epR;
    private a epS;
    private ProgressBar epT;
    private Button epU;
    private Button epV;
    private Button epW;
    private View epX;
    private View epY;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.epF = updatesActivity;
        initView();
        this.epS = new a(this.epF);
        this.epR.setAdapter((ListAdapter) this.epS);
        this.epR.setOnScrollListener(this.epF);
    }

    void initView() {
        this.enE = View.inflate(this.epF.getPageContext().getPageActivity(), d.i.updates_activity, null);
        this.epF.setContentView(this.enE);
        this.mNavigationBar = (NavigationBar) this.epF.findViewById(d.g.view_navigation_bar);
        this.enI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.epF.getPageContext().getString(d.k.updates_activity_title));
        this.epX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.updates_activity_nav_left, (View.OnClickListener) null);
        this.epY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.updates_activity_nav_right, (View.OnClickListener) null);
        this.epW = (Button) this.epX.findViewById(d.g.btn_delete);
        this.epW.setOnClickListener(this.epF);
        this.enI.setOnClickListener(this.epF);
        this.epR = (BdListView) this.enE.findViewById(d.g.updates_list);
        this.epT = (ProgressBar) this.enE.findViewById(d.g.pro_load);
        this.epU = (Button) this.epY.findViewById(d.g.btn_edit);
        this.epU.setOnClickListener(this.epF);
        this.epV = (Button) this.epY.findViewById(d.g.btn_cancel);
        this.epV.setOnClickListener(this.epF);
        nU(0);
        hw(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.epS != null) {
            this.epS.destroy();
            this.epS = null;
        }
        this.epF = null;
    }

    public a aKh() {
        return this.epS;
    }

    public void aKi() {
        this.epU.setVisibility(8);
        this.enI.setVisibility(8);
        this.epV.setVisibility(0);
        this.epX.setVisibility(0);
        aIY();
    }

    public void aKj() {
        this.epU.setVisibility(0);
        this.enI.setVisibility(0);
        this.epV.setVisibility(8);
        this.epX.setVisibility(8);
        nU(0);
        aIY();
    }

    public void aIY() {
        if (this.epS != null) {
            this.epS.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.epS != null) {
            this.epS.setData(list);
        }
    }

    public void nU(int i) {
        if (this.epW != null && this.epF != null) {
            this.epW.setText(String.format(this.epF.getPageContext().getString(d.k.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.epW.setEnabled(false);
            } else {
                this.epW.setEnabled(true);
            }
        }
    }

    public void hw(boolean z) {
        this.epT.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.epF.getLayoutMode().setNightMode(i == 1);
        this.epF.getLayoutMode().onModeChanged(this.enE);
        this.mNavigationBar.onChangeSkinType(this.epF.getPageContext(), i);
        al.i(this.epW, d.f.btn_delete_groupupdates);
    }

    public View aKk() {
        return this.enI;
    }

    public BdListView aKl() {
        return this.epR;
    }

    public Button aKm() {
        return this.epU;
    }

    public Button aKn() {
        return this.epV;
    }

    public Button aKo() {
        return this.epW;
    }
}

package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View erD;
    private View erz;
    private BdListView etJ;
    private a etK;
    private ProgressBar etL;
    private Button etM;
    private Button etN;
    private Button etO;
    private View etP;
    private View etQ;
    private UpdatesActivity ety;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.ety = updatesActivity;
        initView();
        this.etK = new a(this.ety);
        this.etJ.setAdapter((ListAdapter) this.etK);
        this.etJ.setOnScrollListener(this.ety);
    }

    void initView() {
        this.erz = View.inflate(this.ety.getPageContext().getPageActivity(), d.i.updates_activity, null);
        this.ety.setContentView(this.erz);
        this.mNavigationBar = (NavigationBar) this.ety.findViewById(d.g.view_navigation_bar);
        this.erD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ety.getPageContext().getString(d.k.updates_activity_title));
        this.etP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.updates_activity_nav_left, (View.OnClickListener) null);
        this.etQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.updates_activity_nav_right, (View.OnClickListener) null);
        this.etO = (Button) this.etP.findViewById(d.g.btn_delete);
        this.etO.setOnClickListener(this.ety);
        this.erD.setOnClickListener(this.ety);
        this.etJ = (BdListView) this.erz.findViewById(d.g.updates_list);
        this.etL = (ProgressBar) this.erz.findViewById(d.g.pro_load);
        this.etM = (Button) this.etQ.findViewById(d.g.btn_edit);
        this.etM.setOnClickListener(this.ety);
        this.etN = (Button) this.etQ.findViewById(d.g.btn_cancel);
        this.etN.setOnClickListener(this.ety);
        ob(0);
        hG(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.etK != null) {
            this.etK.destroy();
            this.etK = null;
        }
        this.ety = null;
    }

    public a aKN() {
        return this.etK;
    }

    public void aKO() {
        this.etM.setVisibility(8);
        this.erD.setVisibility(8);
        this.etN.setVisibility(0);
        this.etP.setVisibility(0);
        aJF();
    }

    public void aKP() {
        this.etM.setVisibility(0);
        this.erD.setVisibility(0);
        this.etN.setVisibility(8);
        this.etP.setVisibility(8);
        ob(0);
        aJF();
    }

    public void aJF() {
        if (this.etK != null) {
            this.etK.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.etK != null) {
            this.etK.setData(list);
        }
    }

    public void ob(int i) {
        if (this.etO != null && this.ety != null) {
            this.etO.setText(String.format(this.ety.getPageContext().getString(d.k.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.etO.setEnabled(false);
            } else {
                this.etO.setEnabled(true);
            }
        }
    }

    public void hG(boolean z) {
        this.etL.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.ety.getLayoutMode().setNightMode(i == 1);
        this.ety.getLayoutMode().onModeChanged(this.erz);
        this.mNavigationBar.onChangeSkinType(this.ety.getPageContext(), i);
        am.i(this.etO, d.f.btn_delete_groupupdates);
    }

    public View aKQ() {
        return this.erD;
    }

    public BdListView aKR() {
        return this.etJ;
    }

    public Button aKS() {
        return this.etM;
    }

    public Button aKT() {
        return this.etN;
    }

    public Button aKU() {
        return this.etO;
    }
}

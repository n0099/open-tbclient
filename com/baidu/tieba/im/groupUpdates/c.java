package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View dFb;
    private View hDm;
    private View hFA;
    private UpdatesActivity hFi;
    private BdListView hFt;
    private a hFu;
    private ProgressBar hFv;
    private Button hFw;
    private Button hFx;
    private Button hFy;
    private View hFz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.hFi = updatesActivity;
        initView();
        this.hFu = new a(this.hFi);
        this.hFt.setAdapter((ListAdapter) this.hFu);
        this.hFt.setOnScrollListener(this.hFi);
    }

    void initView() {
        this.dFb = View.inflate(this.hFi.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.hFi.setContentView(this.dFb);
        this.mNavigationBar = (NavigationBar) this.hFi.findViewById(R.id.view_navigation_bar);
        this.hDm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hFi.getPageContext().getString(R.string.updates_activity_title));
        this.hFz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.hFA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.hFy = (Button) this.hFz.findViewById(R.id.btn_delete);
        this.hFy.setOnClickListener(this.hFi);
        this.hDm.setOnClickListener(this.hFi);
        this.hFt = (BdListView) this.dFb.findViewById(R.id.updates_list);
        this.hFv = (ProgressBar) this.dFb.findViewById(R.id.pro_load);
        this.hFw = (Button) this.hFA.findViewById(R.id.btn_edit);
        this.hFw.setOnClickListener(this.hFi);
        this.hFx = (Button) this.hFA.findViewById(R.id.btn_cancel);
        this.hFx.setOnClickListener(this.hFi);
        wE(0);
        nK(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hFu != null) {
            this.hFu.destroy();
            this.hFu = null;
        }
        this.hFi = null;
    }

    public a bWA() {
        return this.hFu;
    }

    public void bWB() {
        this.hFw.setVisibility(8);
        this.hDm.setVisibility(8);
        this.hFx.setVisibility(0);
        this.hFz.setVisibility(0);
        bVt();
    }

    public void bWC() {
        this.hFw.setVisibility(0);
        this.hDm.setVisibility(0);
        this.hFx.setVisibility(8);
        this.hFz.setVisibility(8);
        wE(0);
        bVt();
    }

    public void bVt() {
        if (this.hFu != null) {
            this.hFu.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.hFu != null) {
            this.hFu.setData(list);
        }
    }

    public void wE(int i) {
        if (this.hFy != null && this.hFi != null) {
            this.hFy.setText(String.format(this.hFi.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.hFy.setEnabled(false);
            } else {
                this.hFy.setEnabled(true);
            }
        }
    }

    public void nK(boolean z) {
        this.hFv.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hFi.getLayoutMode().setNightMode(i == 1);
        this.hFi.getLayoutMode().onModeChanged(this.dFb);
        this.mNavigationBar.onChangeSkinType(this.hFi.getPageContext(), i);
        am.setBackgroundResource(this.hFy, R.drawable.btn_delete_groupupdates);
    }

    public View bWD() {
        return this.hDm;
    }

    public BdListView bWE() {
        return this.hFt;
    }

    public Button bWF() {
        return this.hFw;
    }

    public Button bWG() {
        return this.hFx;
    }

    public Button bWH() {
        return this.hFy;
    }
}

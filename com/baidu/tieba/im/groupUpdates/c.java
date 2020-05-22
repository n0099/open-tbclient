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
    private View etr;
    private View iDo;
    private Button iFA;
    private View iFB;
    private View iFC;
    private UpdatesActivity iFk;
    private BdListView iFv;
    private a iFw;
    private ProgressBar iFx;
    private Button iFy;
    private Button iFz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.iFk = updatesActivity;
        initView();
        this.iFw = new a(this.iFk);
        this.iFv.setAdapter((ListAdapter) this.iFw);
        this.iFv.setOnScrollListener(this.iFk);
    }

    void initView() {
        this.etr = View.inflate(this.iFk.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.iFk.setContentView(this.etr);
        this.mNavigationBar = (NavigationBar) this.iFk.findViewById(R.id.view_navigation_bar);
        this.iDo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iFk.getPageContext().getString(R.string.updates_activity_title));
        this.iFB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.iFC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.iFA = (Button) this.iFB.findViewById(R.id.btn_delete);
        this.iFA.setOnClickListener(this.iFk);
        this.iDo.setOnClickListener(this.iFk);
        this.iFv = (BdListView) this.etr.findViewById(R.id.updates_list);
        this.iFx = (ProgressBar) this.etr.findViewById(R.id.pro_load);
        this.iFy = (Button) this.iFC.findViewById(R.id.btn_edit);
        this.iFy.setOnClickListener(this.iFk);
        this.iFz = (Button) this.iFC.findViewById(R.id.btn_cancel);
        this.iFz.setOnClickListener(this.iFk);
        xQ(0);
        pq(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iFw != null) {
            this.iFw.destroy();
            this.iFw = null;
        }
        this.iFk = null;
    }

    public a cnP() {
        return this.iFw;
    }

    public void cnQ() {
        this.iFy.setVisibility(8);
        this.iDo.setVisibility(8);
        this.iFz.setVisibility(0);
        this.iFB.setVisibility(0);
        cmI();
    }

    public void cnR() {
        this.iFy.setVisibility(0);
        this.iDo.setVisibility(0);
        this.iFz.setVisibility(8);
        this.iFB.setVisibility(8);
        xQ(0);
        cmI();
    }

    public void cmI() {
        if (this.iFw != null) {
            this.iFw.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.iFw != null) {
            this.iFw.setData(list);
        }
    }

    public void xQ(int i) {
        if (this.iFA != null && this.iFk != null) {
            this.iFA.setText(String.format(this.iFk.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.iFA.setEnabled(false);
            } else {
                this.iFA.setEnabled(true);
            }
        }
    }

    public void pq(boolean z) {
        this.iFx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.iFk.getLayoutMode().setNightMode(i == 1);
        this.iFk.getLayoutMode().onModeChanged(this.etr);
        this.mNavigationBar.onChangeSkinType(this.iFk.getPageContext(), i);
        am.setBackgroundResource(this.iFA, R.drawable.btn_delete_groupupdates);
    }

    public View cnS() {
        return this.iDo;
    }

    public BdListView cnT() {
        return this.iFv;
    }

    public Button cnU() {
        return this.iFy;
    }

    public Button cnV() {
        return this.iFz;
    }

    public Button cnW() {
        return this.iFA;
    }
}

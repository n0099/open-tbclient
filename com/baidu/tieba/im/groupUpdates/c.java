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
    private View iEb;
    private UpdatesActivity iFX;
    private BdListView iGi;
    private a iGj;
    private ProgressBar iGk;
    private Button iGl;
    private Button iGm;
    private Button iGn;
    private View iGo;
    private View iGp;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.iFX = updatesActivity;
        initView();
        this.iGj = new a(this.iFX);
        this.iGi.setAdapter((ListAdapter) this.iGj);
        this.iGi.setOnScrollListener(this.iFX);
    }

    void initView() {
        this.etr = View.inflate(this.iFX.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.iFX.setContentView(this.etr);
        this.mNavigationBar = (NavigationBar) this.iFX.findViewById(R.id.view_navigation_bar);
        this.iEb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iFX.getPageContext().getString(R.string.updates_activity_title));
        this.iGo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.iGp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.iGn = (Button) this.iGo.findViewById(R.id.btn_delete);
        this.iGn.setOnClickListener(this.iFX);
        this.iEb.setOnClickListener(this.iFX);
        this.iGi = (BdListView) this.etr.findViewById(R.id.updates_list);
        this.iGk = (ProgressBar) this.etr.findViewById(R.id.pro_load);
        this.iGl = (Button) this.iGp.findViewById(R.id.btn_edit);
        this.iGl.setOnClickListener(this.iFX);
        this.iGm = (Button) this.iGp.findViewById(R.id.btn_cancel);
        this.iGm.setOnClickListener(this.iFX);
        xS(0);
        pq(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iGj != null) {
            this.iGj.destroy();
            this.iGj = null;
        }
        this.iFX = null;
    }

    public a cnY() {
        return this.iGj;
    }

    public void cnZ() {
        this.iGl.setVisibility(8);
        this.iEb.setVisibility(8);
        this.iGm.setVisibility(0);
        this.iGo.setVisibility(0);
        cmR();
    }

    public void coa() {
        this.iGl.setVisibility(0);
        this.iEb.setVisibility(0);
        this.iGm.setVisibility(8);
        this.iGo.setVisibility(8);
        xS(0);
        cmR();
    }

    public void cmR() {
        if (this.iGj != null) {
            this.iGj.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.iGj != null) {
            this.iGj.setData(list);
        }
    }

    public void xS(int i) {
        if (this.iGn != null && this.iFX != null) {
            this.iGn.setText(String.format(this.iFX.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.iGn.setEnabled(false);
            } else {
                this.iGn.setEnabled(true);
            }
        }
    }

    public void pq(boolean z) {
        this.iGk.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.iFX.getLayoutMode().setNightMode(i == 1);
        this.iFX.getLayoutMode().onModeChanged(this.etr);
        this.mNavigationBar.onChangeSkinType(this.iFX.getPageContext(), i);
        am.setBackgroundResource(this.iGn, R.drawable.btn_delete_groupupdates);
    }

    public View cob() {
        return this.iEb;
    }

    public BdListView coc() {
        return this.iGi;
    }

    public Button cod() {
        return this.iGl;
    }

    public Button coe() {
        return this.iGm;
    }

    public Button cof() {
        return this.iGn;
    }
}

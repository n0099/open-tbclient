package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View czO;
    private View gDq;
    private Button gFA;
    private View gFB;
    private View gFC;
    private UpdatesActivity gFk;
    private BdListView gFv;
    private a gFw;
    private ProgressBar gFx;
    private Button gFy;
    private Button gFz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gFk = updatesActivity;
        initView();
        this.gFw = new a(this.gFk);
        this.gFv.setAdapter((ListAdapter) this.gFw);
        this.gFv.setOnScrollListener(this.gFk);
    }

    void initView() {
        this.czO = View.inflate(this.gFk.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gFk.setContentView(this.czO);
        this.mNavigationBar = (NavigationBar) this.gFk.findViewById(R.id.view_navigation_bar);
        this.gDq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gFk.getPageContext().getString(R.string.updates_activity_title));
        this.gFB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gFC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gFA = (Button) this.gFB.findViewById(R.id.btn_delete);
        this.gFA.setOnClickListener(this.gFk);
        this.gDq.setOnClickListener(this.gFk);
        this.gFv = (BdListView) this.czO.findViewById(R.id.updates_list);
        this.gFx = (ProgressBar) this.czO.findViewById(R.id.pro_load);
        this.gFy = (Button) this.gFC.findViewById(R.id.btn_edit);
        this.gFy.setOnClickListener(this.gFk);
        this.gFz = (Button) this.gFC.findViewById(R.id.btn_cancel);
        this.gFz.setOnClickListener(this.gFk);
        vf(0);
        me(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gFw != null) {
            this.gFw.destroy();
            this.gFw = null;
        }
        this.gFk = null;
    }

    public a bCi() {
        return this.gFw;
    }

    public void bCj() {
        this.gFy.setVisibility(8);
        this.gDq.setVisibility(8);
        this.gFz.setVisibility(0);
        this.gFB.setVisibility(0);
        bBb();
    }

    public void bCk() {
        this.gFy.setVisibility(0);
        this.gDq.setVisibility(0);
        this.gFz.setVisibility(8);
        this.gFB.setVisibility(8);
        vf(0);
        bBb();
    }

    public void bBb() {
        if (this.gFw != null) {
            this.gFw.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gFw != null) {
            this.gFw.setData(list);
        }
    }

    public void vf(int i) {
        if (this.gFA != null && this.gFk != null) {
            this.gFA.setText(String.format(this.gFk.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gFA.setEnabled(false);
            } else {
                this.gFA.setEnabled(true);
            }
        }
    }

    public void me(boolean z) {
        this.gFx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gFk.getLayoutMode().setNightMode(i == 1);
        this.gFk.getLayoutMode().onModeChanged(this.czO);
        this.mNavigationBar.onChangeSkinType(this.gFk.getPageContext(), i);
        al.k(this.gFA, R.drawable.btn_delete_groupupdates);
    }

    public View bCl() {
        return this.gDq;
    }

    public BdListView bCm() {
        return this.gFv;
    }

    public Button bCn() {
        return this.gFy;
    }

    public Button bCo() {
        return this.gFz;
    }

    public Button bCp() {
        return this.gFA;
    }
}

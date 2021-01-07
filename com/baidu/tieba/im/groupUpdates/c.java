package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<UpdatesActivity> {
    private View fNj;
    private UpdatesActivity kDS;
    private View kEc;
    private BdListView kEd;
    private a kEe;
    private ProgressBar kEf;
    private Button kEg;
    private Button kEh;
    private Button kEi;
    private View kEj;
    private View kEk;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kDS = updatesActivity;
        initView();
        this.kEe = new a(this.kDS);
        this.kEd.setAdapter((ListAdapter) this.kEe);
        this.kEd.setOnScrollListener(this.kDS);
    }

    void initView() {
        this.fNj = View.inflate(this.kDS.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kDS.setContentView(this.fNj);
        this.mNavigationBar = (NavigationBar) this.kDS.findViewById(R.id.view_navigation_bar);
        this.kEc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kDS.getPageContext().getString(R.string.updates_activity_title));
        this.kEj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kEk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kEi = (Button) this.kEj.findViewById(R.id.btn_delete);
        this.kEi.setOnClickListener(this.kDS);
        this.kEc.setOnClickListener(this.kDS);
        this.kEd = (BdListView) this.fNj.findViewById(R.id.updates_list);
        this.kEf = (ProgressBar) this.fNj.findViewById(R.id.pro_load);
        this.kEg = (Button) this.kEk.findViewById(R.id.btn_edit);
        this.kEg.setOnClickListener(this.kDS);
        this.kEh = (Button) this.kEk.findViewById(R.id.btn_cancel);
        this.kEh.setOnClickListener(this.kDS);
        Eo(0);
        sN(false);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        super.destroy();
        if (this.kEe != null) {
            this.kEe.destroy();
            this.kEe = null;
        }
        this.kDS = null;
    }

    public a cYo() {
        return this.kEe;
    }

    public void cYp() {
        this.kEg.setVisibility(8);
        this.kEc.setVisibility(8);
        this.kEh.setVisibility(0);
        this.kEj.setVisibility(0);
        cYr();
    }

    public void cYq() {
        this.kEg.setVisibility(0);
        this.kEc.setVisibility(0);
        this.kEh.setVisibility(8);
        this.kEj.setVisibility(8);
        Eo(0);
        cYr();
    }

    public void cYr() {
        if (this.kEe != null) {
            this.kEe.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kEe != null) {
            this.kEe.setData(list);
        }
    }

    public void Eo(int i) {
        if (this.kEi != null && this.kDS != null) {
            this.kEi.setText(String.format(this.kDS.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kEi.setEnabled(false);
            } else {
                this.kEi.setEnabled(true);
            }
        }
    }

    public void sN(boolean z) {
        this.kEf.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kDS.getLayoutMode().setNightMode(i == 1);
        this.kDS.getLayoutMode().onModeChanged(this.fNj);
        this.mNavigationBar.onChangeSkinType(this.kDS.getPageContext(), i);
        ao.setBackgroundResource(this.kEi, R.drawable.btn_delete_groupupdates);
    }

    public View cYs() {
        return this.kEc;
    }

    public BdListView cYt() {
        return this.kEd;
    }

    public Button cYu() {
        return this.kEg;
    }

    public Button cYv() {
        return this.kEh;
    }

    public Button cYw() {
        return this.kEi;
    }
}

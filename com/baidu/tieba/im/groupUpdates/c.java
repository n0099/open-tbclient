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
/* loaded from: classes25.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View fvP;
    private View kjd;
    private UpdatesActivity kkZ;
    private BdListView klj;
    private a klk;
    private ProgressBar kll;
    private Button klm;
    private Button kln;
    private Button klo;
    private View klp;
    private View klq;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kkZ = updatesActivity;
        initView();
        this.klk = new a(this.kkZ);
        this.klj.setAdapter((ListAdapter) this.klk);
        this.klj.setOnScrollListener(this.kkZ);
    }

    void initView() {
        this.fvP = View.inflate(this.kkZ.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kkZ.setContentView(this.fvP);
        this.mNavigationBar = (NavigationBar) this.kkZ.findViewById(R.id.view_navigation_bar);
        this.kjd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kkZ.getPageContext().getString(R.string.updates_activity_title));
        this.klp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.klq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.klo = (Button) this.klp.findViewById(R.id.btn_delete);
        this.klo.setOnClickListener(this.kkZ);
        this.kjd.setOnClickListener(this.kkZ);
        this.klj = (BdListView) this.fvP.findViewById(R.id.updates_list);
        this.kll = (ProgressBar) this.fvP.findViewById(R.id.pro_load);
        this.klm = (Button) this.klq.findViewById(R.id.btn_edit);
        this.klm.setOnClickListener(this.kkZ);
        this.kln = (Button) this.klq.findViewById(R.id.btn_cancel);
        this.kln.setOnClickListener(this.kkZ);
        DE(0);
        sh(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.klk != null) {
            this.klk.destroy();
            this.klk = null;
        }
        this.kkZ = null;
    }

    public a cTh() {
        return this.klk;
    }

    public void cTi() {
        this.klm.setVisibility(8);
        this.kjd.setVisibility(8);
        this.kln.setVisibility(0);
        this.klp.setVisibility(0);
        cSa();
    }

    public void cTj() {
        this.klm.setVisibility(0);
        this.kjd.setVisibility(0);
        this.kln.setVisibility(8);
        this.klp.setVisibility(8);
        DE(0);
        cSa();
    }

    public void cSa() {
        if (this.klk != null) {
            this.klk.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.klk != null) {
            this.klk.setData(list);
        }
    }

    public void DE(int i) {
        if (this.klo != null && this.kkZ != null) {
            this.klo.setText(String.format(this.kkZ.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.klo.setEnabled(false);
            } else {
                this.klo.setEnabled(true);
            }
        }
    }

    public void sh(boolean z) {
        this.kll.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kkZ.getLayoutMode().setNightMode(i == 1);
        this.kkZ.getLayoutMode().onModeChanged(this.fvP);
        this.mNavigationBar.onChangeSkinType(this.kkZ.getPageContext(), i);
        ap.setBackgroundResource(this.klo, R.drawable.btn_delete_groupupdates);
    }

    public View cTk() {
        return this.kjd;
    }

    public BdListView cTl() {
        return this.klj;
    }

    public Button cTm() {
        return this.klm;
    }

    public Button cTn() {
        return this.kln;
    }

    public Button cTo() {
        return this.klo;
    }
}

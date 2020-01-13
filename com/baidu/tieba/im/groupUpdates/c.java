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
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View dAM;
    private View hAZ;
    private UpdatesActivity hCV;
    private BdListView hDg;
    private a hDh;
    private ProgressBar hDi;
    private Button hDj;
    private Button hDk;
    private Button hDl;
    private View hDm;
    private View hDn;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.hCV = updatesActivity;
        initView();
        this.hDh = new a(this.hCV);
        this.hDg.setAdapter((ListAdapter) this.hDh);
        this.hDg.setOnScrollListener(this.hCV);
    }

    void initView() {
        this.dAM = View.inflate(this.hCV.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.hCV.setContentView(this.dAM);
        this.mNavigationBar = (NavigationBar) this.hCV.findViewById(R.id.view_navigation_bar);
        this.hAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hCV.getPageContext().getString(R.string.updates_activity_title));
        this.hDm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.hDn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.hDl = (Button) this.hDm.findViewById(R.id.btn_delete);
        this.hDl.setOnClickListener(this.hCV);
        this.hAZ.setOnClickListener(this.hCV);
        this.hDg = (BdListView) this.dAM.findViewById(R.id.updates_list);
        this.hDi = (ProgressBar) this.dAM.findViewById(R.id.pro_load);
        this.hDj = (Button) this.hDn.findViewById(R.id.btn_edit);
        this.hDj.setOnClickListener(this.hCV);
        this.hDk = (Button) this.hDn.findViewById(R.id.btn_cancel);
        this.hDk.setOnClickListener(this.hCV);
        wy(0);
        nI(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.hDh != null) {
            this.hDh.destroy();
            this.hDh = null;
        }
        this.hCV = null;
    }

    public a bUW() {
        return this.hDh;
    }

    public void bUX() {
        this.hDj.setVisibility(8);
        this.hAZ.setVisibility(8);
        this.hDk.setVisibility(0);
        this.hDm.setVisibility(0);
        bTP();
    }

    public void bUY() {
        this.hDj.setVisibility(0);
        this.hAZ.setVisibility(0);
        this.hDk.setVisibility(8);
        this.hDm.setVisibility(8);
        wy(0);
        bTP();
    }

    public void bTP() {
        if (this.hDh != null) {
            this.hDh.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.hDh != null) {
            this.hDh.setData(list);
        }
    }

    public void wy(int i) {
        if (this.hDl != null && this.hCV != null) {
            this.hDl.setText(String.format(this.hCV.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.hDl.setEnabled(false);
            } else {
                this.hDl.setEnabled(true);
            }
        }
    }

    public void nI(boolean z) {
        this.hDi.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.hCV.getLayoutMode().setNightMode(i == 1);
        this.hCV.getLayoutMode().onModeChanged(this.dAM);
        this.mNavigationBar.onChangeSkinType(this.hCV.getPageContext(), i);
        am.setBackgroundResource(this.hDl, R.drawable.btn_delete_groupupdates);
    }

    public View bUZ() {
        return this.hAZ;
    }

    public BdListView bVa() {
        return this.hDg;
    }

    public Button bVb() {
        return this.hDj;
    }

    public Button bVc() {
        return this.hDk;
    }

    public Button bVd() {
        return this.hDl;
    }
}

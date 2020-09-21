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
    private View eVX;
    private View jAZ;
    private UpdatesActivity jCV;
    private BdListView jDf;
    private a jDg;
    private ProgressBar jDh;
    private Button jDi;
    private Button jDj;
    private Button jDk;
    private View jDl;
    private View jDm;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.jCV = updatesActivity;
        initView();
        this.jDg = new a(this.jCV);
        this.jDf.setAdapter((ListAdapter) this.jDg);
        this.jDf.setOnScrollListener(this.jCV);
    }

    void initView() {
        this.eVX = View.inflate(this.jCV.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.jCV.setContentView(this.eVX);
        this.mNavigationBar = (NavigationBar) this.jCV.findViewById(R.id.view_navigation_bar);
        this.jAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jCV.getPageContext().getString(R.string.updates_activity_title));
        this.jDl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.jDm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.jDk = (Button) this.jDl.findViewById(R.id.btn_delete);
        this.jDk.setOnClickListener(this.jCV);
        this.jAZ.setOnClickListener(this.jCV);
        this.jDf = (BdListView) this.eVX.findViewById(R.id.updates_list);
        this.jDh = (ProgressBar) this.eVX.findViewById(R.id.pro_load);
        this.jDi = (Button) this.jDm.findViewById(R.id.btn_edit);
        this.jDi.setOnClickListener(this.jCV);
        this.jDj = (Button) this.jDm.findViewById(R.id.btn_cancel);
        this.jDj.setOnClickListener(this.jCV);
        BU(0);
        qX(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jDg != null) {
            this.jDg.destroy();
            this.jDg = null;
        }
        this.jCV = null;
    }

    public a cKk() {
        return this.jDg;
    }

    public void cKl() {
        this.jDi.setVisibility(8);
        this.jAZ.setVisibility(8);
        this.jDj.setVisibility(0);
        this.jDl.setVisibility(0);
        cJd();
    }

    public void cKm() {
        this.jDi.setVisibility(0);
        this.jAZ.setVisibility(0);
        this.jDj.setVisibility(8);
        this.jDl.setVisibility(8);
        BU(0);
        cJd();
    }

    public void cJd() {
        if (this.jDg != null) {
            this.jDg.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.jDg != null) {
            this.jDg.setData(list);
        }
    }

    public void BU(int i) {
        if (this.jDk != null && this.jCV != null) {
            this.jDk.setText(String.format(this.jCV.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.jDk.setEnabled(false);
            } else {
                this.jDk.setEnabled(true);
            }
        }
    }

    public void qX(boolean z) {
        this.jDh.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jCV.getLayoutMode().setNightMode(i == 1);
        this.jCV.getLayoutMode().onModeChanged(this.eVX);
        this.mNavigationBar.onChangeSkinType(this.jCV.getPageContext(), i);
        ap.setBackgroundResource(this.jDk, R.drawable.btn_delete_groupupdates);
    }

    public View cKn() {
        return this.jAZ;
    }

    public BdListView cKo() {
        return this.jDf;
    }

    public Button cKp() {
        return this.jDi;
    }

    public Button cKq() {
        return this.jDj;
    }

    public Button cKr() {
        return this.jDk;
    }
}

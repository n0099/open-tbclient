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
    private View efd;
    private View ioI;
    private UpdatesActivity iqE;
    private BdListView iqP;
    private a iqQ;
    private ProgressBar iqR;
    private Button iqS;
    private Button iqT;
    private Button iqU;
    private View iqV;
    private View iqW;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.iqE = updatesActivity;
        initView();
        this.iqQ = new a(this.iqE);
        this.iqP.setAdapter((ListAdapter) this.iqQ);
        this.iqP.setOnScrollListener(this.iqE);
    }

    void initView() {
        this.efd = View.inflate(this.iqE.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.iqE.setContentView(this.efd);
        this.mNavigationBar = (NavigationBar) this.iqE.findViewById(R.id.view_navigation_bar);
        this.ioI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iqE.getPageContext().getString(R.string.updates_activity_title));
        this.iqV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.iqW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.iqU = (Button) this.iqV.findViewById(R.id.btn_delete);
        this.iqU.setOnClickListener(this.iqE);
        this.ioI.setOnClickListener(this.iqE);
        this.iqP = (BdListView) this.efd.findViewById(R.id.updates_list);
        this.iqR = (ProgressBar) this.efd.findViewById(R.id.pro_load);
        this.iqS = (Button) this.iqW.findViewById(R.id.btn_edit);
        this.iqS.setOnClickListener(this.iqE);
        this.iqT = (Button) this.iqW.findViewById(R.id.btn_cancel);
        this.iqT.setOnClickListener(this.iqE);
        xk(0);
        oU(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iqQ != null) {
            this.iqQ.destroy();
            this.iqQ = null;
        }
        this.iqE = null;
    }

    public a chs() {
        return this.iqQ;
    }

    public void cht() {
        this.iqS.setVisibility(8);
        this.ioI.setVisibility(8);
        this.iqT.setVisibility(0);
        this.iqV.setVisibility(0);
        cgl();
    }

    public void chu() {
        this.iqS.setVisibility(0);
        this.ioI.setVisibility(0);
        this.iqT.setVisibility(8);
        this.iqV.setVisibility(8);
        xk(0);
        cgl();
    }

    public void cgl() {
        if (this.iqQ != null) {
            this.iqQ.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.iqQ != null) {
            this.iqQ.setData(list);
        }
    }

    public void xk(int i) {
        if (this.iqU != null && this.iqE != null) {
            this.iqU.setText(String.format(this.iqE.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.iqU.setEnabled(false);
            } else {
                this.iqU.setEnabled(true);
            }
        }
    }

    public void oU(boolean z) {
        this.iqR.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.iqE.getLayoutMode().setNightMode(i == 1);
        this.iqE.getLayoutMode().onModeChanged(this.efd);
        this.mNavigationBar.onChangeSkinType(this.iqE.getPageContext(), i);
        am.setBackgroundResource(this.iqU, R.drawable.btn_delete_groupupdates);
    }

    public View chv() {
        return this.ioI;
    }

    public BdListView chw() {
        return this.iqP;
    }

    public Button chx() {
        return this.iqS;
    }

    public Button chy() {
        return this.iqT;
    }

    public Button chz() {
        return this.iqU;
    }
}

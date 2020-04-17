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
    private View eeY;
    private View ioC;
    private BdListView iqJ;
    private a iqK;
    private ProgressBar iqL;
    private Button iqM;
    private Button iqN;
    private Button iqO;
    private View iqP;
    private View iqQ;
    private UpdatesActivity iqy;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.iqy = updatesActivity;
        initView();
        this.iqK = new a(this.iqy);
        this.iqJ.setAdapter((ListAdapter) this.iqK);
        this.iqJ.setOnScrollListener(this.iqy);
    }

    void initView() {
        this.eeY = View.inflate(this.iqy.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.iqy.setContentView(this.eeY);
        this.mNavigationBar = (NavigationBar) this.iqy.findViewById(R.id.view_navigation_bar);
        this.ioC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iqy.getPageContext().getString(R.string.updates_activity_title));
        this.iqP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.iqQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.iqO = (Button) this.iqP.findViewById(R.id.btn_delete);
        this.iqO.setOnClickListener(this.iqy);
        this.ioC.setOnClickListener(this.iqy);
        this.iqJ = (BdListView) this.eeY.findViewById(R.id.updates_list);
        this.iqL = (ProgressBar) this.eeY.findViewById(R.id.pro_load);
        this.iqM = (Button) this.iqQ.findViewById(R.id.btn_edit);
        this.iqM.setOnClickListener(this.iqy);
        this.iqN = (Button) this.iqQ.findViewById(R.id.btn_cancel);
        this.iqN.setOnClickListener(this.iqy);
        xk(0);
        oU(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iqK != null) {
            this.iqK.destroy();
            this.iqK = null;
        }
        this.iqy = null;
    }

    public a cht() {
        return this.iqK;
    }

    public void chu() {
        this.iqM.setVisibility(8);
        this.ioC.setVisibility(8);
        this.iqN.setVisibility(0);
        this.iqP.setVisibility(0);
        cgm();
    }

    public void chv() {
        this.iqM.setVisibility(0);
        this.ioC.setVisibility(0);
        this.iqN.setVisibility(8);
        this.iqP.setVisibility(8);
        xk(0);
        cgm();
    }

    public void cgm() {
        if (this.iqK != null) {
            this.iqK.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.iqK != null) {
            this.iqK.setData(list);
        }
    }

    public void xk(int i) {
        if (this.iqO != null && this.iqy != null) {
            this.iqO.setText(String.format(this.iqy.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.iqO.setEnabled(false);
            } else {
                this.iqO.setEnabled(true);
            }
        }
    }

    public void oU(boolean z) {
        this.iqL.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.iqy.getLayoutMode().setNightMode(i == 1);
        this.iqy.getLayoutMode().onModeChanged(this.eeY);
        this.mNavigationBar.onChangeSkinType(this.iqy.getPageContext(), i);
        am.setBackgroundResource(this.iqO, R.drawable.btn_delete_groupupdates);
    }

    public View chw() {
        return this.ioC;
    }

    public BdListView chx() {
        return this.iqJ;
    }

    public Button chy() {
        return this.iqM;
    }

    public Button chz() {
        return this.iqN;
    }

    public Button chA() {
        return this.iqO;
    }
}

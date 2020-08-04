package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View eIx;
    private View jdr;
    private Button jfA;
    private Button jfB;
    private Button jfC;
    private View jfD;
    private View jfE;
    private UpdatesActivity jfn;
    private BdListView jfx;
    private a jfy;
    private ProgressBar jfz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.jfn = updatesActivity;
        initView();
        this.jfy = new a(this.jfn);
        this.jfx.setAdapter((ListAdapter) this.jfy);
        this.jfx.setOnScrollListener(this.jfn);
    }

    void initView() {
        this.eIx = View.inflate(this.jfn.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.jfn.setContentView(this.eIx);
        this.mNavigationBar = (NavigationBar) this.jfn.findViewById(R.id.view_navigation_bar);
        this.jdr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jfn.getPageContext().getString(R.string.updates_activity_title));
        this.jfD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.jfE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.jfC = (Button) this.jfD.findViewById(R.id.btn_delete);
        this.jfC.setOnClickListener(this.jfn);
        this.jdr.setOnClickListener(this.jfn);
        this.jfx = (BdListView) this.eIx.findViewById(R.id.updates_list);
        this.jfz = (ProgressBar) this.eIx.findViewById(R.id.pro_load);
        this.jfA = (Button) this.jfE.findViewById(R.id.btn_edit);
        this.jfA.setOnClickListener(this.jfn);
        this.jfB = (Button) this.jfE.findViewById(R.id.btn_cancel);
        this.jfB.setOnClickListener(this.jfn);
        za(0);
        qh(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jfy != null) {
            this.jfy.destroy();
            this.jfy = null;
        }
        this.jfn = null;
    }

    public a cvM() {
        return this.jfy;
    }

    public void cvN() {
        this.jfA.setVisibility(8);
        this.jdr.setVisibility(8);
        this.jfB.setVisibility(0);
        this.jfD.setVisibility(0);
        cuF();
    }

    public void cvO() {
        this.jfA.setVisibility(0);
        this.jdr.setVisibility(0);
        this.jfB.setVisibility(8);
        this.jfD.setVisibility(8);
        za(0);
        cuF();
    }

    public void cuF() {
        if (this.jfy != null) {
            this.jfy.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.jfy != null) {
            this.jfy.setData(list);
        }
    }

    public void za(int i) {
        if (this.jfC != null && this.jfn != null) {
            this.jfC.setText(String.format(this.jfn.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.jfC.setEnabled(false);
            } else {
                this.jfC.setEnabled(true);
            }
        }
    }

    public void qh(boolean z) {
        this.jfz.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jfn.getLayoutMode().setNightMode(i == 1);
        this.jfn.getLayoutMode().onModeChanged(this.eIx);
        this.mNavigationBar.onChangeSkinType(this.jfn.getPageContext(), i);
        ao.setBackgroundResource(this.jfC, R.drawable.btn_delete_groupupdates);
    }

    public View cvP() {
        return this.jdr;
    }

    public BdListView cvQ() {
        return this.jfx;
    }

    public Button cvR() {
        return this.jfA;
    }

    public Button cvS() {
        return this.jfB;
    }

    public Button cvT() {
        return this.jfC;
    }
}

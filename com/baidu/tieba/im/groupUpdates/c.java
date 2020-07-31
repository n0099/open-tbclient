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
    private View jdp;
    private Button jfA;
    private View jfB;
    private View jfC;
    private UpdatesActivity jfl;
    private BdListView jfv;
    private a jfw;
    private ProgressBar jfx;
    private Button jfy;
    private Button jfz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.jfl = updatesActivity;
        initView();
        this.jfw = new a(this.jfl);
        this.jfv.setAdapter((ListAdapter) this.jfw);
        this.jfv.setOnScrollListener(this.jfl);
    }

    void initView() {
        this.eIx = View.inflate(this.jfl.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.jfl.setContentView(this.eIx);
        this.mNavigationBar = (NavigationBar) this.jfl.findViewById(R.id.view_navigation_bar);
        this.jdp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jfl.getPageContext().getString(R.string.updates_activity_title));
        this.jfB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.jfC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.jfA = (Button) this.jfB.findViewById(R.id.btn_delete);
        this.jfA.setOnClickListener(this.jfl);
        this.jdp.setOnClickListener(this.jfl);
        this.jfv = (BdListView) this.eIx.findViewById(R.id.updates_list);
        this.jfx = (ProgressBar) this.eIx.findViewById(R.id.pro_load);
        this.jfy = (Button) this.jfC.findViewById(R.id.btn_edit);
        this.jfy.setOnClickListener(this.jfl);
        this.jfz = (Button) this.jfC.findViewById(R.id.btn_cancel);
        this.jfz.setOnClickListener(this.jfl);
        za(0);
        qh(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.jfw != null) {
            this.jfw.destroy();
            this.jfw = null;
        }
        this.jfl = null;
    }

    public a cvM() {
        return this.jfw;
    }

    public void cvN() {
        this.jfy.setVisibility(8);
        this.jdp.setVisibility(8);
        this.jfz.setVisibility(0);
        this.jfB.setVisibility(0);
        cuF();
    }

    public void cvO() {
        this.jfy.setVisibility(0);
        this.jdp.setVisibility(0);
        this.jfz.setVisibility(8);
        this.jfB.setVisibility(8);
        za(0);
        cuF();
    }

    public void cuF() {
        if (this.jfw != null) {
            this.jfw.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.jfw != null) {
            this.jfw.setData(list);
        }
    }

    public void za(int i) {
        if (this.jfA != null && this.jfl != null) {
            this.jfA.setText(String.format(this.jfl.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.jfA.setEnabled(false);
            } else {
                this.jfA.setEnabled(true);
            }
        }
    }

    public void qh(boolean z) {
        this.jfx.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jfl.getLayoutMode().setNightMode(i == 1);
        this.jfl.getLayoutMode().onModeChanged(this.eIx);
        this.mNavigationBar.onChangeSkinType(this.jfl.getPageContext(), i);
        ao.setBackgroundResource(this.jfA, R.drawable.btn_delete_groupupdates);
    }

    public View cvP() {
        return this.jdp;
    }

    public BdListView cvQ() {
        return this.jfv;
    }

    public Button cvR() {
        return this.jfy;
    }

    public Button cvS() {
        return this.jfz;
    }

    public Button cvT() {
        return this.jfA;
    }
}

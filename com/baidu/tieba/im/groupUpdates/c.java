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
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View cCh;
    private View gMk;
    private UpdatesActivity gOe;
    private BdListView gOp;
    private a gOq;
    private ProgressBar gOr;
    private Button gOs;
    private Button gOt;
    private Button gOu;
    private View gOv;
    private View gOw;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gOe = updatesActivity;
        initView();
        this.gOq = new a(this.gOe);
        this.gOp.setAdapter((ListAdapter) this.gOq);
        this.gOp.setOnScrollListener(this.gOe);
    }

    void initView() {
        this.cCh = View.inflate(this.gOe.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gOe.setContentView(this.cCh);
        this.mNavigationBar = (NavigationBar) this.gOe.findViewById(R.id.view_navigation_bar);
        this.gMk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gOe.getPageContext().getString(R.string.updates_activity_title));
        this.gOv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gOw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gOu = (Button) this.gOv.findViewById(R.id.btn_delete);
        this.gOu.setOnClickListener(this.gOe);
        this.gMk.setOnClickListener(this.gOe);
        this.gOp = (BdListView) this.cCh.findViewById(R.id.updates_list);
        this.gOr = (ProgressBar) this.cCh.findViewById(R.id.pro_load);
        this.gOs = (Button) this.gOw.findViewById(R.id.btn_edit);
        this.gOs.setOnClickListener(this.gOe);
        this.gOt = (Button) this.gOw.findViewById(R.id.btn_cancel);
        this.gOt.setOnClickListener(this.gOe);
        vM(0);
        mv(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gOq != null) {
            this.gOq.destroy();
            this.gOq = null;
        }
        this.gOe = null;
    }

    public a bFR() {
        return this.gOq;
    }

    public void bFS() {
        this.gOs.setVisibility(8);
        this.gMk.setVisibility(8);
        this.gOt.setVisibility(0);
        this.gOv.setVisibility(0);
        bEK();
    }

    public void bFT() {
        this.gOs.setVisibility(0);
        this.gMk.setVisibility(0);
        this.gOt.setVisibility(8);
        this.gOv.setVisibility(8);
        vM(0);
        bEK();
    }

    public void bEK() {
        if (this.gOq != null) {
            this.gOq.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gOq != null) {
            this.gOq.setData(list);
        }
    }

    public void vM(int i) {
        if (this.gOu != null && this.gOe != null) {
            this.gOu.setText(String.format(this.gOe.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gOu.setEnabled(false);
            } else {
                this.gOu.setEnabled(true);
            }
        }
    }

    public void mv(boolean z) {
        this.gOr.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gOe.getLayoutMode().setNightMode(i == 1);
        this.gOe.getLayoutMode().onModeChanged(this.cCh);
        this.mNavigationBar.onChangeSkinType(this.gOe.getPageContext(), i);
        am.k(this.gOu, R.drawable.btn_delete_groupupdates);
    }

    public View bFU() {
        return this.gMk;
    }

    public BdListView bFV() {
        return this.gOp;
    }

    public Button bFW() {
        return this.gOs;
    }

    public Button bFX() {
        return this.gOt;
    }

    public Button bFY() {
        return this.gOu;
    }
}

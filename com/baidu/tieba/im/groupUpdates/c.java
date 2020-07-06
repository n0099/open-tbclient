package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View eCi;
    private View iVf;
    private UpdatesActivity iXb;
    private BdListView iXl;
    private a iXm;
    private ProgressBar iXn;
    private Button iXo;
    private Button iXp;
    private Button iXq;
    private View iXr;
    private View iXs;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.iXb = updatesActivity;
        initView();
        this.iXm = new a(this.iXb);
        this.iXl.setAdapter((ListAdapter) this.iXm);
        this.iXl.setOnScrollListener(this.iXb);
    }

    void initView() {
        this.eCi = View.inflate(this.iXb.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.iXb.setContentView(this.eCi);
        this.mNavigationBar = (NavigationBar) this.iXb.findViewById(R.id.view_navigation_bar);
        this.iVf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iXb.getPageContext().getString(R.string.updates_activity_title));
        this.iXr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.iXs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.iXq = (Button) this.iXr.findViewById(R.id.btn_delete);
        this.iXq.setOnClickListener(this.iXb);
        this.iVf.setOnClickListener(this.iXb);
        this.iXl = (BdListView) this.eCi.findViewById(R.id.updates_list);
        this.iXn = (ProgressBar) this.eCi.findViewById(R.id.pro_load);
        this.iXo = (Button) this.iXs.findViewById(R.id.btn_edit);
        this.iXo.setOnClickListener(this.iXb);
        this.iXp = (Button) this.iXs.findViewById(R.id.btn_cancel);
        this.iXp.setOnClickListener(this.iXb);
        yC(0);
        pA(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.iXm != null) {
            this.iXm.destroy();
            this.iXm = null;
        }
        this.iXb = null;
    }

    public a crO() {
        return this.iXm;
    }

    public void crP() {
        this.iXo.setVisibility(8);
        this.iVf.setVisibility(8);
        this.iXp.setVisibility(0);
        this.iXr.setVisibility(0);
        cqH();
    }

    public void crQ() {
        this.iXo.setVisibility(0);
        this.iVf.setVisibility(0);
        this.iXp.setVisibility(8);
        this.iXr.setVisibility(8);
        yC(0);
        cqH();
    }

    public void cqH() {
        if (this.iXm != null) {
            this.iXm.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.iXm != null) {
            this.iXm.setData(list);
        }
    }

    public void yC(int i) {
        if (this.iXq != null && this.iXb != null) {
            this.iXq.setText(String.format(this.iXb.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.iXq.setEnabled(false);
            } else {
                this.iXq.setEnabled(true);
            }
        }
    }

    public void pA(boolean z) {
        this.iXn.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.iXb.getLayoutMode().setNightMode(i == 1);
        this.iXb.getLayoutMode().onModeChanged(this.eCi);
        this.mNavigationBar.onChangeSkinType(this.iXb.getPageContext(), i);
        an.setBackgroundResource(this.iXq, R.drawable.btn_delete_groupupdates);
    }

    public View crR() {
        return this.iVf;
    }

    public BdListView crS() {
        return this.iXl;
    }

    public Button crT() {
        return this.iXo;
    }

    public Button crU() {
        return this.iXp;
    }

    public Button crV() {
        return this.iXq;
    }
}

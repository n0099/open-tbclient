package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View czN;
    private View gDo;
    private View gFA;
    private UpdatesActivity gFi;
    private BdListView gFt;
    private a gFu;
    private ProgressBar gFv;
    private Button gFw;
    private Button gFx;
    private Button gFy;
    private View gFz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gFi = updatesActivity;
        initView();
        this.gFu = new a(this.gFi);
        this.gFt.setAdapter((ListAdapter) this.gFu);
        this.gFt.setOnScrollListener(this.gFi);
    }

    void initView() {
        this.czN = View.inflate(this.gFi.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gFi.setContentView(this.czN);
        this.mNavigationBar = (NavigationBar) this.gFi.findViewById(R.id.view_navigation_bar);
        this.gDo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gFi.getPageContext().getString(R.string.updates_activity_title));
        this.gFz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gFA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gFy = (Button) this.gFz.findViewById(R.id.btn_delete);
        this.gFy.setOnClickListener(this.gFi);
        this.gDo.setOnClickListener(this.gFi);
        this.gFt = (BdListView) this.czN.findViewById(R.id.updates_list);
        this.gFv = (ProgressBar) this.czN.findViewById(R.id.pro_load);
        this.gFw = (Button) this.gFA.findViewById(R.id.btn_edit);
        this.gFw.setOnClickListener(this.gFi);
        this.gFx = (Button) this.gFA.findViewById(R.id.btn_cancel);
        this.gFx.setOnClickListener(this.gFi);
        vf(0);
        md(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gFu != null) {
            this.gFu.destroy();
            this.gFu = null;
        }
        this.gFi = null;
    }

    public a bCh() {
        return this.gFu;
    }

    public void bCi() {
        this.gFw.setVisibility(8);
        this.gDo.setVisibility(8);
        this.gFx.setVisibility(0);
        this.gFz.setVisibility(0);
        bBa();
    }

    public void bCj() {
        this.gFw.setVisibility(0);
        this.gDo.setVisibility(0);
        this.gFx.setVisibility(8);
        this.gFz.setVisibility(8);
        vf(0);
        bBa();
    }

    public void bBa() {
        if (this.gFu != null) {
            this.gFu.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gFu != null) {
            this.gFu.setData(list);
        }
    }

    public void vf(int i) {
        if (this.gFy != null && this.gFi != null) {
            this.gFy.setText(String.format(this.gFi.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gFy.setEnabled(false);
            } else {
                this.gFy.setEnabled(true);
            }
        }
    }

    public void md(boolean z) {
        this.gFv.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gFi.getLayoutMode().setNightMode(i == 1);
        this.gFi.getLayoutMode().onModeChanged(this.czN);
        this.mNavigationBar.onChangeSkinType(this.gFi.getPageContext(), i);
        al.k(this.gFy, R.drawable.btn_delete_groupupdates);
    }

    public View bCk() {
        return this.gDo;
    }

    public BdListView bCl() {
        return this.gFt;
    }

    public Button bCm() {
        return this.gFw;
    }

    public Button bCn() {
        return this.gFx;
    }

    public Button bCo() {
        return this.gFy;
    }
}

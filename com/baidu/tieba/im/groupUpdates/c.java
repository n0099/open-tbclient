package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View eKq;
    private View eKu;
    private a eMA;
    private ProgressBar eMB;
    private Button eMC;
    private Button eMD;
    private Button eME;
    private View eMF;
    private View eMG;
    private UpdatesActivity eMo;
    private BdListView eMz;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.eMo = updatesActivity;
        initView();
        this.eMA = new a(this.eMo);
        this.eMz.setAdapter((ListAdapter) this.eMA);
        this.eMz.setOnScrollListener(this.eMo);
    }

    void initView() {
        this.eKq = View.inflate(this.eMo.getPageContext().getPageActivity(), e.h.updates_activity, null);
        this.eMo.setContentView(this.eKq);
        this.mNavigationBar = (NavigationBar) this.eMo.findViewById(e.g.view_navigation_bar);
        this.eKu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.eMo.getPageContext().getString(e.j.updates_activity_title));
        this.eMF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.updates_activity_nav_left, (View.OnClickListener) null);
        this.eMG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.updates_activity_nav_right, (View.OnClickListener) null);
        this.eME = (Button) this.eMF.findViewById(e.g.btn_delete);
        this.eME.setOnClickListener(this.eMo);
        this.eKu.setOnClickListener(this.eMo);
        this.eMz = (BdListView) this.eKq.findViewById(e.g.updates_list);
        this.eMB = (ProgressBar) this.eKq.findViewById(e.g.pro_load);
        this.eMC = (Button) this.eMG.findViewById(e.g.btn_edit);
        this.eMC.setOnClickListener(this.eMo);
        this.eMD = (Button) this.eMG.findViewById(e.g.btn_cancel);
        this.eMD.setOnClickListener(this.eMo);
        pr(0);
        iz(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.eMA != null) {
            this.eMA.destroy();
            this.eMA = null;
        }
        this.eMo = null;
    }

    public a aRp() {
        return this.eMA;
    }

    public void aRq() {
        this.eMC.setVisibility(8);
        this.eKu.setVisibility(8);
        this.eMD.setVisibility(0);
        this.eMF.setVisibility(0);
        aQh();
    }

    public void aRr() {
        this.eMC.setVisibility(0);
        this.eKu.setVisibility(0);
        this.eMD.setVisibility(8);
        this.eMF.setVisibility(8);
        pr(0);
        aQh();
    }

    public void aQh() {
        if (this.eMA != null) {
            this.eMA.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.eMA != null) {
            this.eMA.setData(list);
        }
    }

    public void pr(int i) {
        if (this.eME != null && this.eMo != null) {
            this.eME.setText(String.format(this.eMo.getPageContext().getString(e.j.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.eME.setEnabled(false);
            } else {
                this.eME.setEnabled(true);
            }
        }
    }

    public void iz(boolean z) {
        this.eMB.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.eMo.getLayoutMode().setNightMode(i == 1);
        this.eMo.getLayoutMode().onModeChanged(this.eKq);
        this.mNavigationBar.onChangeSkinType(this.eMo.getPageContext(), i);
        al.i(this.eME, e.f.btn_delete_groupupdates);
    }

    public View aRs() {
        return this.eKu;
    }

    public BdListView aRt() {
        return this.eMz;
    }

    public Button aRu() {
        return this.eMC;
    }

    public Button aRv() {
        return this.eMD;
    }

    public Button aRw() {
        return this.eME;
    }
}

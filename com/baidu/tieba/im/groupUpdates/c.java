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
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View fqG;
    private View kcv;
    private BdListView keC;
    private a keD;
    private ProgressBar keE;
    private Button keF;
    private Button keG;
    private Button keH;
    private View keI;
    private View keJ;
    private UpdatesActivity ker;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.ker = updatesActivity;
        initView();
        this.keD = new a(this.ker);
        this.keC.setAdapter((ListAdapter) this.keD);
        this.keC.setOnScrollListener(this.ker);
    }

    void initView() {
        this.fqG = View.inflate(this.ker.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.ker.setContentView(this.fqG);
        this.mNavigationBar = (NavigationBar) this.ker.findViewById(R.id.view_navigation_bar);
        this.kcv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ker.getPageContext().getString(R.string.updates_activity_title));
        this.keI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.keJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.keH = (Button) this.keI.findViewById(R.id.btn_delete);
        this.keH.setOnClickListener(this.ker);
        this.kcv.setOnClickListener(this.ker);
        this.keC = (BdListView) this.fqG.findViewById(R.id.updates_list);
        this.keE = (ProgressBar) this.fqG.findViewById(R.id.pro_load);
        this.keF = (Button) this.keJ.findViewById(R.id.btn_edit);
        this.keF.setOnClickListener(this.ker);
        this.keG = (Button) this.keJ.findViewById(R.id.btn_cancel);
        this.keG.setOnClickListener(this.ker);
        CT(0);
        rV(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.keD != null) {
            this.keD.destroy();
            this.keD = null;
        }
        this.ker = null;
    }

    public a cRa() {
        return this.keD;
    }

    public void cRb() {
        this.keF.setVisibility(8);
        this.kcv.setVisibility(8);
        this.keG.setVisibility(0);
        this.keI.setVisibility(0);
        cPT();
    }

    public void cRc() {
        this.keF.setVisibility(0);
        this.kcv.setVisibility(0);
        this.keG.setVisibility(8);
        this.keI.setVisibility(8);
        CT(0);
        cPT();
    }

    public void cPT() {
        if (this.keD != null) {
            this.keD.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.keD != null) {
            this.keD.setData(list);
        }
    }

    public void CT(int i) {
        if (this.keH != null && this.ker != null) {
            this.keH.setText(String.format(this.ker.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.keH.setEnabled(false);
            } else {
                this.keH.setEnabled(true);
            }
        }
    }

    public void rV(boolean z) {
        this.keE.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.ker.getLayoutMode().setNightMode(i == 1);
        this.ker.getLayoutMode().onModeChanged(this.fqG);
        this.mNavigationBar.onChangeSkinType(this.ker.getPageContext(), i);
        ap.setBackgroundResource(this.keH, R.drawable.btn_delete_groupupdates);
    }

    public View cRd() {
        return this.kcv;
    }

    public BdListView cRe() {
        return this.keC;
    }

    public Button cRf() {
        return this.keF;
    }

    public Button cRg() {
        return this.keG;
    }

    public Button cRh() {
        return this.keH;
    }
}

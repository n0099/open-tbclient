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
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<UpdatesActivity> {
    private View eTh;
    private View jsx;
    private BdListView juD;
    private a juE;
    private ProgressBar juF;
    private Button juG;
    private Button juH;
    private Button juI;
    private View juJ;
    private View juK;
    private UpdatesActivity jut;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.jut = updatesActivity;
        initView();
        this.juE = new a(this.jut);
        this.juD.setAdapter((ListAdapter) this.juE);
        this.juD.setOnScrollListener(this.jut);
    }

    void initView() {
        this.eTh = View.inflate(this.jut.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.jut.setContentView(this.eTh);
        this.mNavigationBar = (NavigationBar) this.jut.findViewById(R.id.view_navigation_bar);
        this.jsx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jut.getPageContext().getString(R.string.updates_activity_title));
        this.juJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.juK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.juI = (Button) this.juJ.findViewById(R.id.btn_delete);
        this.juI.setOnClickListener(this.jut);
        this.jsx.setOnClickListener(this.jut);
        this.juD = (BdListView) this.eTh.findViewById(R.id.updates_list);
        this.juF = (ProgressBar) this.eTh.findViewById(R.id.pro_load);
        this.juG = (Button) this.juK.findViewById(R.id.btn_edit);
        this.juG.setOnClickListener(this.jut);
        this.juH = (Button) this.juK.findViewById(R.id.btn_cancel);
        this.juH.setOnClickListener(this.jut);
        Bt(0);
        qP(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.juE != null) {
            this.juE.destroy();
            this.juE = null;
        }
        this.jut = null;
    }

    public a cGE() {
        return this.juE;
    }

    public void cGF() {
        this.juG.setVisibility(8);
        this.jsx.setVisibility(8);
        this.juH.setVisibility(0);
        this.juJ.setVisibility(0);
        cFx();
    }

    public void cGG() {
        this.juG.setVisibility(0);
        this.jsx.setVisibility(0);
        this.juH.setVisibility(8);
        this.juJ.setVisibility(8);
        Bt(0);
        cFx();
    }

    public void cFx() {
        if (this.juE != null) {
            this.juE.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.juE != null) {
            this.juE.setData(list);
        }
    }

    public void Bt(int i) {
        if (this.juI != null && this.jut != null) {
            this.juI.setText(String.format(this.jut.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.juI.setEnabled(false);
            } else {
                this.juI.setEnabled(true);
            }
        }
    }

    public void qP(boolean z) {
        this.juF.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.jut.getLayoutMode().setNightMode(i == 1);
        this.jut.getLayoutMode().onModeChanged(this.eTh);
        this.mNavigationBar.onChangeSkinType(this.jut.getPageContext(), i);
        ap.setBackgroundResource(this.juI, R.drawable.btn_delete_groupupdates);
    }

    public View cGH() {
        return this.jsx;
    }

    public BdListView cGI() {
        return this.juD;
    }

    public Button cGJ() {
        return this.juG;
    }

    public Button cGK() {
        return this.juH;
    }

    public Button cGL() {
        return this.juI;
    }
}

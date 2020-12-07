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
    private View fDE;
    private View kwz;
    private BdListView kyF;
    private a kyG;
    private ProgressBar kyH;
    private Button kyI;
    private Button kyJ;
    private Button kyK;
    private View kyL;
    private View kyM;
    private UpdatesActivity kyv;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kyv = updatesActivity;
        initView();
        this.kyG = new a(this.kyv);
        this.kyF.setAdapter((ListAdapter) this.kyG);
        this.kyF.setOnScrollListener(this.kyv);
    }

    void initView() {
        this.fDE = View.inflate(this.kyv.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kyv.setContentView(this.fDE);
        this.mNavigationBar = (NavigationBar) this.kyv.findViewById(R.id.view_navigation_bar);
        this.kwz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kyv.getPageContext().getString(R.string.updates_activity_title));
        this.kyL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kyM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kyK = (Button) this.kyL.findViewById(R.id.btn_delete);
        this.kyK.setOnClickListener(this.kyv);
        this.kwz.setOnClickListener(this.kyv);
        this.kyF = (BdListView) this.fDE.findViewById(R.id.updates_list);
        this.kyH = (ProgressBar) this.fDE.findViewById(R.id.pro_load);
        this.kyI = (Button) this.kyM.findViewById(R.id.btn_edit);
        this.kyI.setOnClickListener(this.kyv);
        this.kyJ = (Button) this.kyM.findViewById(R.id.btn_cancel);
        this.kyJ.setOnClickListener(this.kyv);
        Et(0);
        sJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kyG != null) {
            this.kyG.destroy();
            this.kyG = null;
        }
        this.kyv = null;
    }

    public a cYt() {
        return this.kyG;
    }

    public void cYu() {
        this.kyI.setVisibility(8);
        this.kwz.setVisibility(8);
        this.kyJ.setVisibility(0);
        this.kyL.setVisibility(0);
        cXm();
    }

    public void cYv() {
        this.kyI.setVisibility(0);
        this.kwz.setVisibility(0);
        this.kyJ.setVisibility(8);
        this.kyL.setVisibility(8);
        Et(0);
        cXm();
    }

    public void cXm() {
        if (this.kyG != null) {
            this.kyG.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kyG != null) {
            this.kyG.setData(list);
        }
    }

    public void Et(int i) {
        if (this.kyK != null && this.kyv != null) {
            this.kyK.setText(String.format(this.kyv.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kyK.setEnabled(false);
            } else {
                this.kyK.setEnabled(true);
            }
        }
    }

    public void sJ(boolean z) {
        this.kyH.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kyv.getLayoutMode().setNightMode(i == 1);
        this.kyv.getLayoutMode().onModeChanged(this.fDE);
        this.mNavigationBar.onChangeSkinType(this.kyv.getPageContext(), i);
        ap.setBackgroundResource(this.kyK, R.drawable.btn_delete_groupupdates);
    }

    public View cYw() {
        return this.kwz;
    }

    public BdListView cYx() {
        return this.kyF;
    }

    public Button cYy() {
        return this.kyI;
    }

    public Button cYz() {
        return this.kyJ;
    }

    public Button cYA() {
        return this.kyK;
    }
}

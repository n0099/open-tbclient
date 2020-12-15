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
    private View kwB;
    private BdListView kyH;
    private a kyI;
    private ProgressBar kyJ;
    private Button kyK;
    private Button kyL;
    private Button kyM;
    private View kyN;
    private View kyO;
    private UpdatesActivity kyx;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.kyx = updatesActivity;
        initView();
        this.kyI = new a(this.kyx);
        this.kyH.setAdapter((ListAdapter) this.kyI);
        this.kyH.setOnScrollListener(this.kyx);
    }

    void initView() {
        this.fDE = View.inflate(this.kyx.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.kyx.setContentView(this.fDE);
        this.mNavigationBar = (NavigationBar) this.kyx.findViewById(R.id.view_navigation_bar);
        this.kwB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kyx.getPageContext().getString(R.string.updates_activity_title));
        this.kyN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.kyO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.kyM = (Button) this.kyN.findViewById(R.id.btn_delete);
        this.kyM.setOnClickListener(this.kyx);
        this.kwB.setOnClickListener(this.kyx);
        this.kyH = (BdListView) this.fDE.findViewById(R.id.updates_list);
        this.kyJ = (ProgressBar) this.fDE.findViewById(R.id.pro_load);
        this.kyK = (Button) this.kyO.findViewById(R.id.btn_edit);
        this.kyK.setOnClickListener(this.kyx);
        this.kyL = (Button) this.kyO.findViewById(R.id.btn_cancel);
        this.kyL.setOnClickListener(this.kyx);
        Et(0);
        sJ(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.kyI != null) {
            this.kyI.destroy();
            this.kyI = null;
        }
        this.kyx = null;
    }

    public a cYu() {
        return this.kyI;
    }

    public void cYv() {
        this.kyK.setVisibility(8);
        this.kwB.setVisibility(8);
        this.kyL.setVisibility(0);
        this.kyN.setVisibility(0);
        cXn();
    }

    public void cYw() {
        this.kyK.setVisibility(0);
        this.kwB.setVisibility(0);
        this.kyL.setVisibility(8);
        this.kyN.setVisibility(8);
        Et(0);
        cXn();
    }

    public void cXn() {
        if (this.kyI != null) {
            this.kyI.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.kyI != null) {
            this.kyI.setData(list);
        }
    }

    public void Et(int i) {
        if (this.kyM != null && this.kyx != null) {
            this.kyM.setText(String.format(this.kyx.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.kyM.setEnabled(false);
            } else {
                this.kyM.setEnabled(true);
            }
        }
    }

    public void sJ(boolean z) {
        this.kyJ.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.kyx.getLayoutMode().setNightMode(i == 1);
        this.kyx.getLayoutMode().onModeChanged(this.fDE);
        this.mNavigationBar.onChangeSkinType(this.kyx.getPageContext(), i);
        ap.setBackgroundResource(this.kyM, R.drawable.btn_delete_groupupdates);
    }

    public View cYx() {
        return this.kwB;
    }

    public BdListView cYy() {
        return this.kyH;
    }

    public Button cYz() {
        return this.kyK;
    }

    public Button cYA() {
        return this.kyL;
    }

    public Button cYB() {
        return this.kyM;
    }
}

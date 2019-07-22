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
    private View cBe;
    private View gJA;
    private BdListView gLF;
    private a gLG;
    private ProgressBar gLH;
    private Button gLI;
    private Button gLJ;
    private Button gLK;
    private View gLL;
    private View gLM;
    private UpdatesActivity gLu;
    private NavigationBar mNavigationBar;

    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        this.gLu = updatesActivity;
        initView();
        this.gLG = new a(this.gLu);
        this.gLF.setAdapter((ListAdapter) this.gLG);
        this.gLF.setOnScrollListener(this.gLu);
    }

    void initView() {
        this.cBe = View.inflate(this.gLu.getPageContext().getPageActivity(), R.layout.updates_activity, null);
        this.gLu.setContentView(this.cBe);
        this.mNavigationBar = (NavigationBar) this.gLu.findViewById(R.id.view_navigation_bar);
        this.gJA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gLu.getPageContext().getString(R.string.updates_activity_title));
        this.gLL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
        this.gLM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
        this.gLK = (Button) this.gLL.findViewById(R.id.btn_delete);
        this.gLK.setOnClickListener(this.gLu);
        this.gJA.setOnClickListener(this.gLu);
        this.gLF = (BdListView) this.cBe.findViewById(R.id.updates_list);
        this.gLH = (ProgressBar) this.cBe.findViewById(R.id.pro_load);
        this.gLI = (Button) this.gLM.findViewById(R.id.btn_edit);
        this.gLI.setOnClickListener(this.gLu);
        this.gLJ = (Button) this.gLM.findViewById(R.id.btn_cancel);
        this.gLJ.setOnClickListener(this.gLu);
        vG(0);
        ms(false);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.gLG != null) {
            this.gLG.destroy();
            this.gLG = null;
        }
        this.gLu = null;
    }

    public a bEP() {
        return this.gLG;
    }

    public void bEQ() {
        this.gLI.setVisibility(8);
        this.gJA.setVisibility(8);
        this.gLJ.setVisibility(0);
        this.gLL.setVisibility(0);
        bDI();
    }

    public void bER() {
        this.gLI.setVisibility(0);
        this.gJA.setVisibility(0);
        this.gLJ.setVisibility(8);
        this.gLL.setVisibility(8);
        vG(0);
        bDI();
    }

    public void bDI() {
        if (this.gLG != null) {
            this.gLG.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.gLG != null) {
            this.gLG.setData(list);
        }
    }

    public void vG(int i) {
        if (this.gLK != null && this.gLu != null) {
            this.gLK.setText(String.format(this.gLu.getPageContext().getString(R.string.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.gLK.setEnabled(false);
            } else {
                this.gLK.setEnabled(true);
            }
        }
    }

    public void ms(boolean z) {
        this.gLH.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.gLu.getLayoutMode().setNightMode(i == 1);
        this.gLu.getLayoutMode().onModeChanged(this.cBe);
        this.mNavigationBar.onChangeSkinType(this.gLu.getPageContext(), i);
        am.k(this.gLK, R.drawable.btn_delete_groupupdates);
    }

    public View bES() {
        return this.gJA;
    }

    public BdListView bET() {
        return this.gLF;
    }

    public Button bEU() {
        return this.gLI;
    }

    public Button bEV() {
        return this.gLJ;
    }

    public Button bEW() {
        return this.gLK;
    }
}

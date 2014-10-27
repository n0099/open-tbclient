package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f {
    private View aGI;
    private View aZU;
    private UpdatesActivity bbW;
    private BdListView bck;
    private h bcl;
    private ProgressBar bcm;
    private Button bcn;
    private Button bco;
    private Button bcp;
    private View bcq;
    private View bcr;
    private NavigationBar mNavigationBar;

    public t(UpdatesActivity updatesActivity) {
        super(updatesActivity);
        this.bbW = updatesActivity;
        nu();
        this.bcl = new h(this.bbW);
        this.bck.setAdapter((ListAdapter) this.bcl);
        this.bck.setOnScrollListener(this.bbW);
    }

    void nu() {
        this.aGI = View.inflate(this.bbW, w.updates_activity, null);
        this.bbW.setContentView(this.aGI);
        this.mNavigationBar = (NavigationBar) this.bbW.findViewById(v.view_navigation_bar);
        this.aZU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bbW.getString(y.updates_activity_title));
        this.bcq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.updates_activity_nav_left, (View.OnClickListener) null);
        this.bcr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.updates_activity_nav_right, (View.OnClickListener) null);
        this.bcp = (Button) this.bcq.findViewById(v.btn_delete);
        this.bcp.setOnClickListener(this.bbW);
        this.aZU.setOnClickListener(this.bbW);
        this.bck = (BdListView) this.aGI.findViewById(v.updates_list);
        this.bcm = (ProgressBar) this.aGI.findViewById(v.pro_load);
        this.bcn = (Button) this.bcr.findViewById(v.btn_edit);
        this.bcn.setOnClickListener(this.bbW);
        this.bco = (Button) this.bcr.findViewById(v.btn_cancel);
        this.bco.setOnClickListener(this.bbW);
        fT(0);
        dg(false);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        super.destroy();
        if (this.bcl != null) {
            this.bcl.destroy();
            this.bcl = null;
        }
        this.bbW = null;
    }

    public h Pj() {
        return this.bcl;
    }

    public void Pk() {
        this.bcn.setVisibility(8);
        this.aZU.setVisibility(8);
        this.bco.setVisibility(0);
        this.bcq.setVisibility(0);
        NP();
    }

    public void Pl() {
        this.bcn.setVisibility(0);
        this.aZU.setVisibility(0);
        this.bco.setVisibility(8);
        this.bcq.setVisibility(8);
        fT(0);
        NP();
    }

    public void NP() {
        if (this.bcl != null) {
            this.bcl.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.bcl != null) {
            this.bcl.setData(list);
        }
    }

    public void fT(int i) {
        if (this.bcp != null && this.bbW != null) {
            this.bcp.setText(String.format(this.bbW.getString(y.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.bcp.setEnabled(false);
            } else {
                this.bcp.setEnabled(true);
            }
        }
    }

    public void dg(boolean z) {
        this.bcm.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bbW.getLayoutMode().L(i == 1);
        this.bbW.getLayoutMode().h(this.aGI);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public View Pm() {
        return this.aZU;
    }

    public BdListView Pn() {
        return this.bck;
    }

    public Button Po() {
        return this.bcn;
    }

    public Button Pp() {
        return this.bco;
    }

    public Button Pq() {
        return this.bcp;
    }
}

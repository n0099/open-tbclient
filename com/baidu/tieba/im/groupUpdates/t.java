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
    private View aGS;
    private View bah;
    private ProgressBar bcA;
    private Button bcB;
    private Button bcC;
    private Button bcD;
    private View bcE;
    private View bcF;
    private UpdatesActivity bck;
    private BdListView bcy;
    private h bcz;
    private NavigationBar mNavigationBar;

    public t(UpdatesActivity updatesActivity) {
        super(updatesActivity);
        this.bck = updatesActivity;
        nu();
        this.bcz = new h(this.bck);
        this.bcy.setAdapter((ListAdapter) this.bcz);
        this.bcy.setOnScrollListener(this.bck);
    }

    void nu() {
        this.aGS = View.inflate(this.bck, w.updates_activity, null);
        this.bck.setContentView(this.aGS);
        this.mNavigationBar = (NavigationBar) this.bck.findViewById(v.view_navigation_bar);
        this.bah = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bck.getString(y.updates_activity_title));
        this.bcE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.updates_activity_nav_left, (View.OnClickListener) null);
        this.bcF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.updates_activity_nav_right, (View.OnClickListener) null);
        this.bcD = (Button) this.bcE.findViewById(v.btn_delete);
        this.bcD.setOnClickListener(this.bck);
        this.bah.setOnClickListener(this.bck);
        this.bcy = (BdListView) this.aGS.findViewById(v.updates_list);
        this.bcA = (ProgressBar) this.aGS.findViewById(v.pro_load);
        this.bcB = (Button) this.bcF.findViewById(v.btn_edit);
        this.bcB.setOnClickListener(this.bck);
        this.bcC = (Button) this.bcF.findViewById(v.btn_cancel);
        this.bcC.setOnClickListener(this.bck);
        fT(0);
        dg(false);
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        super.destroy();
        if (this.bcz != null) {
            this.bcz.destroy();
            this.bcz = null;
        }
        this.bck = null;
    }

    public h Pm() {
        return this.bcz;
    }

    public void Pn() {
        this.bcB.setVisibility(8);
        this.bah.setVisibility(8);
        this.bcC.setVisibility(0);
        this.bcE.setVisibility(0);
        NT();
    }

    public void Po() {
        this.bcB.setVisibility(0);
        this.bah.setVisibility(0);
        this.bcC.setVisibility(8);
        this.bcE.setVisibility(8);
        fT(0);
        NT();
    }

    public void NT() {
        if (this.bcz != null) {
            this.bcz.notifyDataSetChanged();
        }
    }

    public void setData(List<UpdatesItemData> list) {
        if (this.bcz != null) {
            this.bcz.setData(list);
        }
    }

    public void fT(int i) {
        if (this.bcD != null && this.bck != null) {
            this.bcD.setText(String.format(this.bck.getString(y.del_count), Integer.valueOf(i)));
            if (i == 0) {
                this.bcD.setEnabled(false);
            } else {
                this.bcD.setEnabled(true);
            }
        }
    }

    public void dg(boolean z) {
        this.bcA.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType(int i) {
        this.bck.getLayoutMode().L(i == 1);
        this.bck.getLayoutMode().h(this.aGS);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public View Pp() {
        return this.bah;
    }

    public BdListView Pq() {
        return this.bcy;
    }

    public Button Pr() {
        return this.bcB;
    }

    public Button Ps() {
        return this.bcC;
    }

    public Button Pt() {
        return this.bcD;
    }
}

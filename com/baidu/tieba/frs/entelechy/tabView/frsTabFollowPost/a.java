package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private String fNd;
    private BaseFragment jle;
    private View jso;
    private TextView jsp;
    private FrsTabSortSwitchButton jsq;
    private int jsr;
    private FrsTabSortSwitchButton.a jss = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zp(int i) {
            if (com.baidu.tieba.frs.b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.jle.showToast(R.string.neterror);
                return false;
            }
            if (a.this.jle instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.jle).cJY() == null || ((FrsNewAreaFragment) a.this.jle).cJZ() == null) {
                    return false;
                }
            } else if (!(a.this.jle instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.jle).cFR() == null || ((FrsCommonTabFragment) a.this.jle).cFS() == null) {
                    return false;
                }
            }
            if (a.this.jsr == i) {
                return true;
            }
            a.this.jsr = i;
            if (a.this.jsr != 7) {
                ab.bFI();
                e.dOU();
            } else {
                e.dOT();
            }
            if (a.this.jle instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.jle).cJY().Ac(a.this.jsq.zs(a.this.jsr));
                if (d.bjr()) {
                    com.baidu.tbadk.a.b.a.mJ(a.this.jsq.zs(a.this.jsr));
                }
                ((FrsNewAreaFragment) a.this.jle).cJZ().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.jle).setSortType(com.baidu.tieba.frs.d.j.At(a.this.jsq.zs(a.this.jsr)));
                ((FrsCommonTabFragment) a.this.jle).cFS().lU(true);
            }
            a.this.cGK();
            return true;
        }
    };

    public void setFid(String str) {
        this.fNd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGK() {
        ar arVar = new ar("c11437");
        arVar.ap("obj_type", this.jsq.zs(this.jsr));
        arVar.dR("fid", this.fNd);
        TiebaStatic.log(arVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.jsr = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.jle = baseFragment;
            this.jso = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jso.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jsp = (TextView) this.jso.findViewById(R.id.sort_tab_sort_name);
            this.jsq = (FrsTabSortSwitchButton) this.jso.findViewById(R.id.sort_tab_switch_btn);
            this.jsq.setOnSwitchChangeListener(this.jss);
            this.jsr = this.jsq.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jsq != null) {
            this.jsq.onChangeSkinType();
        }
        ap.setViewTextColor(this.jsp, R.color.CAM_X0105);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jsq != null) {
            this.jsq.setData(list);
        }
    }

    public void iF(int i) {
        if (this.jsq != null) {
            this.jsq.iF(com.baidu.tieba.frs.d.j.Au(i));
            this.jsr = this.jsq.getState();
        }
    }
}

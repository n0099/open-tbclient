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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private String fKR;
    private BaseFragment jfj;
    private View jmu;
    private TextView jmv;
    private FrsTabSortSwitchButton jmw;
    private int jmx;
    private FrsTabSortSwitchButton.a jmy = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zf(int i) {
            if (com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.jfj.showToast(R.string.neterror);
                return false;
            }
            if (a.this.jfj instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.jfj).cIE() == null || ((FrsNewAreaFragment) a.this.jfj).cIF() == null) {
                    return false;
                }
            } else if (!(a.this.jfj instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.jfj).cEx() == null || ((FrsCommonTabFragment) a.this.jfj).cEy() == null) {
                    return false;
                }
            }
            if (a.this.jmx == i) {
                return true;
            }
            a.this.jmx = i;
            if (a.this.jmx != 7) {
                z.bFp();
                e.dMB();
            } else {
                e.dMA();
            }
            if (a.this.jfj instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.jfj).cIE().zS(a.this.jmw.zi(a.this.jmx));
                if (d.bjf()) {
                    com.baidu.tbadk.a.b.a.mG(a.this.jmw.zi(a.this.jmx));
                }
                ((FrsNewAreaFragment) a.this.jfj).cIF().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.jfj).setSortType(com.baidu.tieba.frs.d.j.Aj(a.this.jmw.zi(a.this.jmx)));
                ((FrsCommonTabFragment) a.this.jfj).cEy().lQ(true);
            }
            a.this.cFq();
            return true;
        }
    };

    public void setFid(String str) {
        this.fKR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFq() {
        aq aqVar = new aq("c11437");
        aqVar.an("obj_type", this.jmw.zi(this.jmx));
        aqVar.dW("fid", this.fKR);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.jmx = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.jfj = baseFragment;
            this.jmu = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jmu.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jmv = (TextView) this.jmu.findViewById(R.id.sort_tab_sort_name);
            this.jmw = (FrsTabSortSwitchButton) this.jmu.findViewById(R.id.sort_tab_switch_btn);
            this.jmw.setOnSwitchChangeListener(this.jmy);
            this.jmx = this.jmw.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jmw != null) {
            this.jmw.onChangeSkinType();
        }
        ao.setViewTextColor(this.jmv, R.color.CAM_X0105);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jmw != null) {
            this.jmw.setData(list);
        }
    }

    public void iC(int i) {
        if (this.jmw != null) {
            this.jmw.iC(com.baidu.tieba.frs.d.j.Ak(i));
            this.jmx = this.jmw.getState();
        }
    }
}

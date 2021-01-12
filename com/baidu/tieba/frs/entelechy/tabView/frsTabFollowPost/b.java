package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class b {
    private String fKR;
    private FrsFragment jcX;
    private View jmu;
    private TextView jmv;
    private FrsTabSortSwitchButton jmw;
    private int jmx;
    private FrsTabSortSwitchButton.a jmy = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zf(int i) {
            if (com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.jcX.showToast(R.string.neterror);
                return false;
            } else if (b.this.jcX.cBd() == null || b.this.jcX.cBi() == null) {
                return false;
            } else {
                if (b.this.jmx == i) {
                    return true;
                }
                b.this.jcX.cBd().zT(b.this.jmw.zi(b.this.jmx));
                b.this.jmx = i;
                if (b.this.jmx != 7) {
                    z.bFp();
                    e.dMB();
                } else {
                    e.dMA();
                }
                b.this.jcX.cBd().zS(b.this.jmw.zi(b.this.jmx));
                if (d.bjf()) {
                    com.baidu.tbadk.a.b.a.mG(b.this.jmw.zi(b.this.jmx));
                }
                b.this.jcX.cBd().rk(true);
                b.this.jcX.cBi().startPullRefresh();
                b.this.jcX.cBd().rj(true);
                b.this.cFq();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fKR = str;
    }

    public FrsTabSortSwitchButton cFr() {
        return this.jmw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFq() {
        aq aqVar = new aq("c11437");
        aqVar.an("obj_type", this.jmw.zi(this.jmx));
        aqVar.dW("fid", this.fKR);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.jmx = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.jcX = frsFragment;
            this.jmu = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
        ao.setViewTextColor(this.jmv, R.color.CAM_X0108);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jmw != null) {
            this.jmw.setData(list);
        }
    }

    public void iC(int i) {
        if (this.jmw != null) {
            this.jmw.iC(i);
            this.jmx = this.jmw.getState();
        }
    }
}

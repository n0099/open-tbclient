package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.f.i;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class a {
    private String fsZ;
    private BaseFragment iGb;
    private View iMT;
    private TextView iMU;
    private FrsTabSortSwitchButton iMV;
    private int iMW;
    private FrsTabSortSwitchButton.a iMX = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zj(int i) {
            if (com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.iGb.showToast(R.string.neterror);
                return false;
            }
            if (a.this.iGb instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.iGb).cCc() == null || ((FrsNewAreaFragment) a.this.iGb).cCd() == null) {
                    return false;
                }
            } else if (!(a.this.iGb instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.iGb).cyY() == null || ((FrsCommonTabFragment) a.this.iGb).cyZ() == null) {
                    return false;
                }
            }
            if (a.this.iMW == i) {
                return true;
            }
            a.this.iMW = i;
            if (a.this.iMW != 7) {
                ac.bBw();
                e.dIC();
            } else {
                e.dIB();
            }
            if (a.this.iGb instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.iGb).cCc().zN(a.this.iMV.zm(a.this.iMW));
                ((FrsNewAreaFragment) a.this.iGb).cCd().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.iGb).setSortType(i.Ae(a.this.iMV.zm(a.this.iMW)));
                ((FrsCommonTabFragment) a.this.iGb).cyZ().kT(true);
            }
            a.this.czK();
            return true;
        }
    };

    public void setFid(String str) {
        this.fsZ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czK() {
        aq aqVar = new aq("c11437");
        aqVar.aj("obj_type", this.iMV.zm(this.iMW));
        aqVar.dR("fid", this.fsZ);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.iMW = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.iGb = baseFragment;
            this.iMT = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.iMU = (TextView) this.iMT.findViewById(R.id.sort_tab_sort_name);
            this.iMV = (FrsTabSortSwitchButton) this.iMT.findViewById(R.id.sort_tab_switch_btn);
            this.iMV.setOnSwitchChangeListener(this.iMX);
            this.iMW = this.iMV.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.iMV != null) {
            this.iMV.onChangeSkinType();
        }
        ap.setViewTextColor(this.iMU, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iMT, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.iMV != null) {
            this.iMV.setData(list);
        }
    }

    public void jF(int i) {
        if (this.iMV != null) {
            this.iMV.jF(i.Af(i));
            this.iMW = this.iMV.getState();
        }
    }
}

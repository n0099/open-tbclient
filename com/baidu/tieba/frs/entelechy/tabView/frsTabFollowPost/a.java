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
    private String fyR;
    private BaseFragment iLY;
    private View iSQ;
    private TextView iSR;
    private FrsTabSortSwitchButton iSS;
    private int iST;
    private FrsTabSortSwitchButton.a iSU = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zw(int i) {
            if (com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.iLY.showToast(R.string.neterror);
                return false;
            }
            if (a.this.iLY instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.iLY).cED() == null || ((FrsNewAreaFragment) a.this.iLY).cEE() == null) {
                    return false;
                }
            } else if (!(a.this.iLY instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.iLY).cBz() == null || ((FrsCommonTabFragment) a.this.iLY).cBA() == null) {
                    return false;
                }
            }
            if (a.this.iST == i) {
                return true;
            }
            a.this.iST = i;
            if (a.this.iST != 7) {
                ac.bDV();
                e.dLe();
            } else {
                e.dLd();
            }
            if (a.this.iLY instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.iLY).cED().Aa(a.this.iSS.zz(a.this.iST));
                ((FrsNewAreaFragment) a.this.iLY).cEE().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.iLY).setSortType(i.Ar(a.this.iSS.zz(a.this.iST)));
                ((FrsCommonTabFragment) a.this.iLY).cBA().lc(true);
            }
            a.this.cCl();
            return true;
        }
    };

    public void setFid(String str) {
        this.fyR = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCl() {
        aq aqVar = new aq("c11437");
        aqVar.al("obj_type", this.iSS.zz(this.iST));
        aqVar.dR("fid", this.fyR);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.iST = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.iLY = baseFragment;
            this.iSQ = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.iSR = (TextView) this.iSQ.findViewById(R.id.sort_tab_sort_name);
            this.iSS = (FrsTabSortSwitchButton) this.iSQ.findViewById(R.id.sort_tab_switch_btn);
            this.iSS.setOnSwitchChangeListener(this.iSU);
            this.iST = this.iSS.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.iSS != null) {
            this.iSS.onChangeSkinType();
        }
        ap.setViewTextColor(this.iSR, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iSQ, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.iSS != null) {
            this.iSS.setData(list);
        }
    }

    public void jP(int i) {
        if (this.iSS != null) {
            this.iSS.jP(i.As(i));
            this.iST = this.iSS.getState();
        }
    }
}

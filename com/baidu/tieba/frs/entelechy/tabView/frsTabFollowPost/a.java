package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class a {
    private String emF;
    private View gyN;
    private BaseFragment gyO;
    private TextView gyP;
    private FrsTabSortSwitchButton gyQ;
    private int gyR;
    private FrsTabSortSwitchButton.a gyS = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean tq(int i) {
            if (com.baidu.tieba.frs.a.bDd().bDe()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.gyO.showToast(R.string.neterror);
                return false;
            }
            if (a.this.gyO instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.gyO).bJK() == null || ((FrsNewAreaFragment) a.this.gyO).bJL() == null) {
                    return false;
                }
            } else if (!(a.this.gyO instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.gyO).bGS() == null || ((FrsCommonTabFragment) a.this.gyO).bGT() == null) {
                    return false;
                }
            }
            if (a.this.gyR == i) {
                return true;
            }
            a.this.gyR = i;
            if (a.this.gyR != 7) {
                aa.aSw();
                e.cMw();
            } else {
                e.cMv();
            }
            if (a.this.gyO instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.gyO).bJK().tT(a.this.gyQ.tt(a.this.gyR));
                ((FrsNewAreaFragment) a.this.gyO).bJL().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.gyO).setSortType(g.ul(a.this.gyQ.tt(a.this.gyR)));
                ((FrsCommonTabFragment) a.this.gyO).bGT().hv(true);
            }
            a.this.bHE();
            return true;
        }
    };

    public void setFid(String str) {
        this.emF = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHE() {
        an anVar = new an("c11437");
        anVar.X("obj_type", this.gyQ.tt(this.gyR));
        anVar.cx("fid", this.emF);
        TiebaStatic.log(anVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.gyR = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.gyO = baseFragment;
            this.gyN = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.gyP = (TextView) this.gyN.findViewById(R.id.sort_tab_sort_name);
            this.gyQ = (FrsTabSortSwitchButton) this.gyN.findViewById(R.id.sort_tab_switch_btn);
            this.gyQ.setOnSwitchChangeListener(this.gyS);
            this.gyR = this.gyQ.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.gyQ != null) {
            this.gyQ.onChangeSkinType();
        }
        am.setViewTextColor(this.gyP, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.gyN, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.gyQ != null) {
            this.gyQ.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.gyQ != null) {
            this.gyQ.changeState(g.um(i));
            this.gyR = this.gyQ.getState();
        }
    }
}

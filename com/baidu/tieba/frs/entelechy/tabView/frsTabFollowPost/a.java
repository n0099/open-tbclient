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
import com.baidu.tbadk.util.ab;
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
    private String evm;
    private View hxc;
    private BaseFragment hxd;
    private TextView hxe;
    private FrsTabSortSwitchButton hxf;
    private int hxg;
    private FrsTabSortSwitchButton.a hxh = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean ut(int i) {
            if (com.baidu.tieba.frs.a.bTX().bTY()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hxd.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hxd instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hxd).caD() == null || ((FrsNewAreaFragment) a.this.hxd).caE() == null) {
                    return false;
                }
            } else if (!(a.this.hxd instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hxd).bXO() == null || ((FrsCommonTabFragment) a.this.hxd).bXP() == null) {
                    return false;
                }
            }
            if (a.this.hxg == i) {
                return true;
            }
            a.this.hxg = i;
            if (a.this.hxg != 7) {
                ab.bgO();
                e.deE();
            } else {
                e.deD();
            }
            if (a.this.hxd instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hxd).caD().uX(a.this.hxf.uw(a.this.hxg));
                ((FrsNewAreaFragment) a.this.hxd).caE().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hxd).setSortType(g.vo(a.this.hxf.uw(a.this.hxg)));
                ((FrsCommonTabFragment) a.this.hxd).bXP().iQ(true);
            }
            a.this.bYx();
            return true;
        }
    };

    public void setFid(String str) {
        this.evm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYx() {
        an anVar = new an("c11437");
        anVar.ag("obj_type", this.hxf.uw(this.hxg));
        anVar.dh("fid", this.evm);
        TiebaStatic.log(anVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.hxg = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hxd = baseFragment;
            this.hxc = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hxe = (TextView) this.hxc.findViewById(R.id.sort_tab_sort_name);
            this.hxf = (FrsTabSortSwitchButton) this.hxc.findViewById(R.id.sort_tab_switch_btn);
            this.hxf.setOnSwitchChangeListener(this.hxh);
            this.hxg = this.hxf.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.hxf != null) {
            this.hxf.onChangeSkinType();
        }
        am.setViewTextColor(this.hxe, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.hxc, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.hxf != null) {
            this.hxf.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.hxf != null) {
            this.hxf.changeState(g.vp(i));
            this.hxg = this.hxf.getState();
        }
    }
}

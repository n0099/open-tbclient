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
/* loaded from: classes21.dex */
public class a {
    private String eYo;
    private BaseFragment ieI;
    private View ilC;
    private TextView ilD;
    private FrsTabSortSwitchButton ilE;
    private int ilF;
    private FrsTabSortSwitchButton.a ilG = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean yk(int i) {
            if (com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.ieI.showToast(R.string.neterror);
                return false;
            }
            if (a.this.ieI instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.ieI).cvy() == null || ((FrsNewAreaFragment) a.this.ieI).cvz() == null) {
                    return false;
                }
            } else if (!(a.this.ieI instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.ieI).csu() == null || ((FrsCommonTabFragment) a.this.ieI).csv() == null) {
                    return false;
                }
            }
            if (a.this.ilF == i) {
                return true;
            }
            a.this.ilF = i;
            if (a.this.ilF != 7) {
                ac.bwT();
                e.dBI();
            } else {
                e.dBH();
            }
            if (a.this.ieI instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.ieI).cvy().yO(a.this.ilE.yn(a.this.ilF));
                ((FrsNewAreaFragment) a.this.ieI).cvz().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.ieI).setSortType(i.zf(a.this.ilE.yn(a.this.ilF)));
                ((FrsCommonTabFragment) a.this.ieI).csv().ki(true);
            }
            a.this.ctg();
            return true;
        }
    };

    public void setFid(String str) {
        this.eYo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctg() {
        aq aqVar = new aq("c11437");
        aqVar.ai("obj_type", this.ilE.yn(this.ilF));
        aqVar.dF("fid", this.eYo);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.ilF = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.ieI = baseFragment;
            this.ilC = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.ilD = (TextView) this.ilC.findViewById(R.id.sort_tab_sort_name);
            this.ilE = (FrsTabSortSwitchButton) this.ilC.findViewById(R.id.sort_tab_switch_btn);
            this.ilE.setOnSwitchChangeListener(this.ilG);
            this.ilF = this.ilE.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.ilE != null) {
            this.ilE.onChangeSkinType();
        }
        ap.setViewTextColor(this.ilD, R.color.cp_cont_b);
        ap.setBackgroundColor(this.ilC, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.ilE != null) {
            this.ilE.setData(list);
        }
    }

    public void iX(int i) {
        if (this.ilE != null) {
            this.ilE.iX(i.zg(i));
            this.ilF = this.ilE.getState();
        }
    }
}

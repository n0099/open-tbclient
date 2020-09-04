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
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class a {
    private String eVx;
    private BaseFragment hXE;
    private View ieC;
    private TextView ieD;
    private FrsTabSortSwitchButton ieE;
    private int ieF;
    private FrsTabSortSwitchButton.a ieG = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean xL(int i) {
            if (com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hXE.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hXE instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hXE).csj() == null || ((FrsNewAreaFragment) a.this.hXE).csk() == null) {
                    return false;
                }
            } else if (!(a.this.hXE instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hXE).cph() == null || ((FrsCommonTabFragment) a.this.hXE).cpi() == null) {
                    return false;
                }
            }
            if (a.this.ieF == i) {
                return true;
            }
            a.this.ieF = i;
            if (a.this.ieF != 7) {
                ab.bvK();
                e.dxP();
            } else {
                e.dxO();
            }
            if (a.this.hXE instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hXE).csj().yp(a.this.ieE.xO(a.this.ieF));
                ((FrsNewAreaFragment) a.this.hXE).csk().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hXE).setSortType(g.yG(a.this.ieE.xO(a.this.ieF)));
                ((FrsCommonTabFragment) a.this.hXE).cpi().kh(true);
            }
            a.this.cpT();
            return true;
        }
    };

    public void setFid(String str) {
        this.eVx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpT() {
        aq aqVar = new aq("c11437");
        aqVar.ai("obj_type", this.ieE.xO(this.ieF));
        aqVar.dD("fid", this.eVx);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.ieF = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hXE = baseFragment;
            this.ieC = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.ieD = (TextView) this.ieC.findViewById(R.id.sort_tab_sort_name);
            this.ieE = (FrsTabSortSwitchButton) this.ieC.findViewById(R.id.sort_tab_switch_btn);
            this.ieE.setOnSwitchChangeListener(this.ieG);
            this.ieF = this.ieE.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.ieE != null) {
            this.ieE.onChangeSkinType();
        }
        ap.setViewTextColor(this.ieD, R.color.cp_cont_b);
        ap.setBackgroundColor(this.ieC, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.ieE != null) {
            this.ieE.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.ieE != null) {
            this.ieE.changeState(g.yH(i));
            this.ieF = this.ieE.getState();
        }
    }
}

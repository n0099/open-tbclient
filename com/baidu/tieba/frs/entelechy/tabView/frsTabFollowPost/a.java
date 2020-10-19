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
    private String fkA;
    private int iAA;
    private FrsTabSortSwitchButton.a iAB = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean yQ(int i) {
            if (com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.itF.showToast(R.string.neterror);
                return false;
            }
            if (a.this.itF instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.itF).cyV() == null || ((FrsNewAreaFragment) a.this.itF).cyW() == null) {
                    return false;
                }
            } else if (!(a.this.itF instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.itF).cvR() == null || ((FrsCommonTabFragment) a.this.itF).cvS() == null) {
                    return false;
                }
            }
            if (a.this.iAA == i) {
                return true;
            }
            a.this.iAA = i;
            if (a.this.iAA != 7) {
                ac.bzD();
                e.dFu();
            } else {
                e.dFt();
            }
            if (a.this.itF instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.itF).cyV().zu(a.this.iAz.yT(a.this.iAA));
                ((FrsNewAreaFragment) a.this.itF).cyW().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.itF).setSortType(i.zL(a.this.iAz.yT(a.this.iAA)));
                ((FrsCommonTabFragment) a.this.itF).cvS().kG(true);
            }
            a.this.cwD();
            return true;
        }
    };
    private View iAx;
    private TextView iAy;
    private FrsTabSortSwitchButton iAz;
    private BaseFragment itF;

    public void setFid(String str) {
        this.fkA = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwD() {
        aq aqVar = new aq("c11437");
        aqVar.aj("obj_type", this.iAz.yT(this.iAA));
        aqVar.dK("fid", this.fkA);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.iAA = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.itF = baseFragment;
            this.iAx = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.iAy = (TextView) this.iAx.findViewById(R.id.sort_tab_sort_name);
            this.iAz = (FrsTabSortSwitchButton) this.iAx.findViewById(R.id.sort_tab_switch_btn);
            this.iAz.setOnSwitchChangeListener(this.iAB);
            this.iAA = this.iAz.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.iAz != null) {
            this.iAz.onChangeSkinType();
        }
        ap.setViewTextColor(this.iAy, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iAx, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.iAz != null) {
            this.iAz.setData(list);
        }
    }

    public void ju(int i) {
        if (this.iAz != null) {
            this.iAz.ju(i.zM(i));
            this.iAA = this.iAz.getState();
        }
    }
}

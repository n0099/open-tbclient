package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class b {
    private String fkA;
    private int iAA;
    private FrsTabSortSwitchButton.a iAB = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean yQ(int i) {
            if (com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.irr.showToast(R.string.neterror);
                return false;
            } else if (b.this.irr.csy() == null || b.this.irr.csD() == null) {
                return false;
            } else {
                if (b.this.iAA == i) {
                    return true;
                }
                b.this.irr.csy().zv(b.this.iAz.yT(b.this.iAA));
                b.this.iAA = i;
                if (b.this.iAA != 7) {
                    ac.bzD();
                    e.dFu();
                } else {
                    e.dFt();
                }
                b.this.irr.csy().zu(b.this.iAz.yT(b.this.iAA));
                b.this.irr.csy().pL(true);
                b.this.irr.csD().startPullRefresh();
                b.this.irr.csy().pK(true);
                b.this.cwD();
                return true;
            }
        }
    };
    private View iAx;
    private TextView iAy;
    private FrsTabSortSwitchButton iAz;
    private FrsFragment irr;

    public void setFid(String str) {
        this.fkA = str;
    }

    public FrsTabSortSwitchButton cwE() {
        return this.iAz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwD() {
        aq aqVar = new aq("c11437");
        aqVar.aj("obj_type", this.iAz.yT(this.iAA));
        aqVar.dK("fid", this.fkA);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.iAA = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.irr = frsFragment;
            this.iAx = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
}

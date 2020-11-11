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
    private String fyR;
    private FrsFragment iJK;
    private View iSQ;
    private TextView iSR;
    private FrsTabSortSwitchButton iSS;
    private int iST;
    private FrsTabSortSwitchButton.a iSU = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zw(int i) {
            if (com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.iJK.showToast(R.string.neterror);
                return false;
            } else if (b.this.iJK.cyg() == null || b.this.iJK.cyl() == null) {
                return false;
            } else {
                if (b.this.iST == i) {
                    return true;
                }
                b.this.iJK.cyg().Ab(b.this.iSS.zz(b.this.iST));
                b.this.iST = i;
                if (b.this.iST != 7) {
                    ac.bDV();
                    e.dLe();
                } else {
                    e.dLd();
                }
                b.this.iJK.cyg().Aa(b.this.iSS.zz(b.this.iST));
                b.this.iJK.cyg().qm(true);
                b.this.iJK.cyl().startPullRefresh();
                b.this.iJK.cyg().ql(true);
                b.this.cCl();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fyR = str;
    }

    public FrsTabSortSwitchButton cCm() {
        return this.iSS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCl() {
        aq aqVar = new aq("c11437");
        aqVar.al("obj_type", this.iSS.zz(this.iST));
        aqVar.dR("fid", this.fyR);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.iST = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.iJK = frsFragment;
            this.iSQ = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
}

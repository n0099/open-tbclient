package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class b {
    private String emF;
    private FrsFragment gqW;
    private View gyN;
    private TextView gyP;
    private FrsTabSortSwitchButton gyQ;
    private int gyR;
    private FrsTabSortSwitchButton.a gyS = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean tq(int i) {
            if (com.baidu.tieba.frs.a.bDd().bDe()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.gqW.showToast(R.string.neterror);
                return false;
            } else if (b.this.gqW.bDT() == null || b.this.gqW.bDY() == null) {
                return false;
            } else {
                if (b.this.gyR == i) {
                    return true;
                }
                b.this.gqW.bDT().tU(b.this.gyQ.tt(b.this.gyR));
                b.this.gyR = i;
                if (b.this.gyR != 7) {
                    aa.aSw();
                    e.cMw();
                } else {
                    e.cMv();
                }
                b.this.gqW.bDT().tT(b.this.gyQ.tt(b.this.gyR));
                b.this.gqW.bDT().me(true);
                b.this.gqW.bDY().startPullRefresh();
                b.this.gqW.bDT().md(true);
                b.this.bHE();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.emF = str;
    }

    public FrsTabSortSwitchButton bHF() {
        return this.gyQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHE() {
        an anVar = new an("c11437");
        anVar.X("obj_type", this.gyQ.tt(this.gyR));
        anVar.cx("fid", this.emF);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.gyR = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.gqW = frsFragment;
            this.gyN = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
}

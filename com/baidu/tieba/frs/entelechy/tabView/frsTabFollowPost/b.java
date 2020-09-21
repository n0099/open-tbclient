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
/* loaded from: classes21.dex */
public class b {
    private String eYo;
    private FrsFragment icq;
    private View ilC;
    private TextView ilD;
    private FrsTabSortSwitchButton ilE;
    private int ilF;
    private FrsTabSortSwitchButton.a ilG = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean yk(int i) {
            if (com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.icq.showToast(R.string.neterror);
                return false;
            } else if (b.this.icq.cpa() == null || b.this.icq.cpf() == null) {
                return false;
            } else {
                if (b.this.ilF == i) {
                    return true;
                }
                b.this.icq.cpa().yP(b.this.ilE.yn(b.this.ilF));
                b.this.ilF = i;
                if (b.this.ilF != 7) {
                    ac.bwT();
                    e.dBI();
                } else {
                    e.dBH();
                }
                b.this.icq.cpa().yO(b.this.ilE.yn(b.this.ilF));
                b.this.icq.cpa().pg(true);
                b.this.icq.cpf().startPullRefresh();
                b.this.icq.cpa().pf(true);
                b.this.ctg();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.eYo = str;
    }

    public FrsTabSortSwitchButton cth() {
        return this.ilE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctg() {
        aq aqVar = new aq("c11437");
        aqVar.ai("obj_type", this.ilE.yn(this.ilF));
        aqVar.dF("fid", this.eYo);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.ilF = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.icq = frsFragment;
            this.ilC = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
}

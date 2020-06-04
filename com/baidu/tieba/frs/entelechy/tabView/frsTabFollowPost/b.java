package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class b {
    private String evm;
    private FrsFragment hpm;
    private View hxn;
    private TextView hxp;
    private FrsTabSortSwitchButton hxq;
    private int hxr;
    private FrsTabSortSwitchButton.a hxs = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean uv(int i) {
            if (com.baidu.tieba.frs.a.bTZ().bUa()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.hpm.showToast(R.string.neterror);
                return false;
            } else if (b.this.hpm.bUO() == null || b.this.hpm.bUT() == null) {
                return false;
            } else {
                if (b.this.hxr == i) {
                    return true;
                }
                b.this.hpm.bUO().va(b.this.hxq.uy(b.this.hxr));
                b.this.hxr = i;
                if (b.this.hxr != 7) {
                    ab.bgP();
                    e.deT();
                } else {
                    e.deS();
                }
                b.this.hpm.bUO().uZ(b.this.hxq.uy(b.this.hxr));
                b.this.hpm.bUO().nD(true);
                b.this.hpm.bUT().startPullRefresh();
                b.this.hpm.bUO().nC(true);
                b.this.bYA();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.evm = str;
    }

    public FrsTabSortSwitchButton bYB() {
        return this.hxq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYA() {
        an anVar = new an("c11437");
        anVar.ag("obj_type", this.hxq.uy(this.hxr));
        anVar.dh("fid", this.evm);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.hxr = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.hpm = frsFragment;
            this.hxn = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hxp = (TextView) this.hxn.findViewById(R.id.sort_tab_sort_name);
            this.hxq = (FrsTabSortSwitchButton) this.hxn.findViewById(R.id.sort_tab_switch_btn);
            this.hxq.setOnSwitchChangeListener(this.hxs);
            this.hxr = this.hxq.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.hxq != null) {
            this.hxq.onChangeSkinType();
        }
        am.setViewTextColor(this.hxp, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.hxn, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.hxq != null) {
            this.hxq.setData(list);
        }
    }
}

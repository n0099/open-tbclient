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
    private FrsFragment hpb;
    private View hxc;
    private TextView hxe;
    private FrsTabSortSwitchButton hxf;
    private int hxg;
    private FrsTabSortSwitchButton.a hxh = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean ut(int i) {
            if (com.baidu.tieba.frs.a.bTX().bTY()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.hpb.showToast(R.string.neterror);
                return false;
            } else if (b.this.hpb.bUM() == null || b.this.hpb.bUR() == null) {
                return false;
            } else {
                if (b.this.hxg == i) {
                    return true;
                }
                b.this.hpb.bUM().uY(b.this.hxf.uw(b.this.hxg));
                b.this.hxg = i;
                if (b.this.hxg != 7) {
                    ab.bgO();
                    e.deE();
                } else {
                    e.deD();
                }
                b.this.hpb.bUM().uX(b.this.hxf.uw(b.this.hxg));
                b.this.hpb.bUM().nD(true);
                b.this.hpb.bUR().startPullRefresh();
                b.this.hpb.bUM().nC(true);
                b.this.bYx();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.evm = str;
    }

    public FrsTabSortSwitchButton bYy() {
        return this.hxf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYx() {
        an anVar = new an("c11437");
        anVar.ag("obj_type", this.hxf.uw(this.hxg));
        anVar.dh("fid", this.evm);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.hxg = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.hpb = frsFragment;
            this.hxc = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
}

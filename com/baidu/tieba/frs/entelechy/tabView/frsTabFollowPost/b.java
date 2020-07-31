package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class b {
    private String eKO;
    private FrsFragment hHU;
    private View hQl;
    private TextView hQm;
    private FrsTabSortSwitchButton hQn;
    private int hQo;
    private FrsTabSortSwitchButton.a hQp = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean vs(int i) {
            if (com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.hHU.showToast(R.string.neterror);
                return false;
            } else if (b.this.hHU.cbr() == null || b.this.hHU.cbw() == null) {
                return false;
            } else {
                if (b.this.hQo == i) {
                    return true;
                }
                b.this.hHU.cbr().vX(b.this.hQn.vv(b.this.hQo));
                b.this.hQo = i;
                if (b.this.hQo != 7) {
                    ab.bmW();
                    e.dmo();
                } else {
                    e.dmn();
                }
                b.this.hHU.cbr().vW(b.this.hQn.vv(b.this.hQo));
                b.this.hHU.cbr().ou(true);
                b.this.hHU.cbw().startPullRefresh();
                b.this.hHU.cbr().ot(true);
                b.this.cfn();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.eKO = str;
    }

    public FrsTabSortSwitchButton cfo() {
        return this.hQn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfn() {
        ap apVar = new ap("c11437");
        apVar.ah("obj_type", this.hQn.vv(this.hQo));
        apVar.dn("fid", this.eKO);
        TiebaStatic.log(apVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.hQo = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.hHU = frsFragment;
            this.hQl = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hQm = (TextView) this.hQl.findViewById(R.id.sort_tab_sort_name);
            this.hQn = (FrsTabSortSwitchButton) this.hQl.findViewById(R.id.sort_tab_switch_btn);
            this.hQn.setOnSwitchChangeListener(this.hQp);
            this.hQo = this.hQn.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.hQn != null) {
            this.hQn.onChangeSkinType();
        }
        ao.setViewTextColor(this.hQm, R.color.cp_cont_b);
        ao.setBackgroundColor(this.hQl, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.hQn != null) {
            this.hQn.setData(list);
        }
    }
}

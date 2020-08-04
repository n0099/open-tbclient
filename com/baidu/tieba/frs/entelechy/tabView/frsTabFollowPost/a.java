package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
    private String eKO;
    private BaseFragment hKa;
    private View hQn;
    private TextView hQo;
    private FrsTabSortSwitchButton hQp;
    private int hQq;
    private FrsTabSortSwitchButton.a hQr = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean vs(int i) {
            if (com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hKa.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hKa instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hKa).chE() == null || ((FrsNewAreaFragment) a.this.hKa).chF() == null) {
                    return false;
                }
            } else if (!(a.this.hKa instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hKa).ceC() == null || ((FrsCommonTabFragment) a.this.hKa).ceD() == null) {
                    return false;
                }
            }
            if (a.this.hQq == i) {
                return true;
            }
            a.this.hQq = i;
            if (a.this.hQq != 7) {
                ab.bmW();
                e.dmp();
            } else {
                e.dmo();
            }
            if (a.this.hKa instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hKa).chE().vW(a.this.hQp.vv(a.this.hQq));
                ((FrsNewAreaFragment) a.this.hKa).chF().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hKa).setSortType(g.wn(a.this.hQp.vv(a.this.hQq)));
                ((FrsCommonTabFragment) a.this.hKa).ceD().jH(true);
            }
            a.this.cfn();
            return true;
        }
    };

    public void setFid(String str) {
        this.eKO = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfn() {
        ap apVar = new ap("c11437");
        apVar.ah("obj_type", this.hQp.vv(this.hQq));
        apVar.dn("fid", this.eKO);
        TiebaStatic.log(apVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.hQq = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hKa = baseFragment;
            this.hQn = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hQo = (TextView) this.hQn.findViewById(R.id.sort_tab_sort_name);
            this.hQp = (FrsTabSortSwitchButton) this.hQn.findViewById(R.id.sort_tab_switch_btn);
            this.hQp.setOnSwitchChangeListener(this.hQr);
            this.hQq = this.hQp.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.hQp != null) {
            this.hQp.onChangeSkinType();
        }
        ao.setViewTextColor(this.hQo, R.color.cp_cont_b);
        ao.setBackgroundColor(this.hQn, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.hQp != null) {
            this.hQp.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.hQp != null) {
            this.hQp.changeState(g.wo(i));
            this.hQq = this.hQp.getState();
        }
    }
}

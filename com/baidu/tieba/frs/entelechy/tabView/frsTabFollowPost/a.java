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
    private View hQl;
    private TextView hQm;
    private FrsTabSortSwitchButton hQn;
    private int hQo;
    private FrsTabSortSwitchButton.a hQp = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
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
            if (a.this.hQo == i) {
                return true;
            }
            a.this.hQo = i;
            if (a.this.hQo != 7) {
                ab.bmW();
                e.dmo();
            } else {
                e.dmn();
            }
            if (a.this.hKa instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hKa).chE().vW(a.this.hQn.vv(a.this.hQo));
                ((FrsNewAreaFragment) a.this.hKa).chF().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hKa).setSortType(g.wn(a.this.hQn.vv(a.this.hQo)));
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
        apVar.ah("obj_type", this.hQn.vv(this.hQo));
        apVar.dn("fid", this.eKO);
        TiebaStatic.log(apVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.hQo = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hKa = baseFragment;
            this.hQl = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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

    public void changeState(int i) {
        if (this.hQn != null) {
            this.hQn.changeState(g.wo(i));
            this.hQo = this.hQn.getState();
        }
    }
}

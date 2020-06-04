package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class a {
    private String evm;
    private View hxn;
    private BaseFragment hxo;
    private TextView hxp;
    private FrsTabSortSwitchButton hxq;
    private int hxr;
    private FrsTabSortSwitchButton.a hxs = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean uv(int i) {
            if (com.baidu.tieba.frs.a.bTZ().bUa()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hxo.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hxo instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hxo).caL() == null || ((FrsNewAreaFragment) a.this.hxo).caM() == null) {
                    return false;
                }
            } else if (!(a.this.hxo instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hxo).bXQ() == null || ((FrsCommonTabFragment) a.this.hxo).bXR() == null) {
                    return false;
                }
            }
            if (a.this.hxr == i) {
                return true;
            }
            a.this.hxr = i;
            if (a.this.hxr != 7) {
                ab.bgP();
                e.deT();
            } else {
                e.deS();
            }
            if (a.this.hxo instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hxo).caL().uZ(a.this.hxq.uy(a.this.hxr));
                ((FrsNewAreaFragment) a.this.hxo).caM().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hxo).setSortType(g.vq(a.this.hxq.uy(a.this.hxr)));
                ((FrsCommonTabFragment) a.this.hxo).bXR().iQ(true);
            }
            a.this.bYA();
            return true;
        }
    };

    public void setFid(String str) {
        this.evm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYA() {
        an anVar = new an("c11437");
        anVar.ag("obj_type", this.hxq.uy(this.hxr));
        anVar.dh("fid", this.evm);
        TiebaStatic.log(anVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.hxr = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hxo = baseFragment;
            this.hxn = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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

    public void changeState(int i) {
        if (this.hxq != null) {
            this.hxq.changeState(g.vr(i));
            this.hxr = this.hxq.getState();
        }
    }
}

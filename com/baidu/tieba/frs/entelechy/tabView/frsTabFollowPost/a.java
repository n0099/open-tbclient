package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
    private String eEs;
    private BaseFragment hEc;
    private View hKl;
    private TextView hKm;
    private FrsTabSortSwitchButton hKn;
    private int hKo;
    private FrsTabSortSwitchButton.a hKp = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean va(int i) {
            if (com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hEc.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hEc instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hEc).cef() == null || ((FrsNewAreaFragment) a.this.hEc).ceg() == null) {
                    return false;
                }
            } else if (!(a.this.hEc instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hEc).cbe() == null || ((FrsCommonTabFragment) a.this.hEc).cbf() == null) {
                    return false;
                }
            }
            if (a.this.hKo == i) {
                return true;
            }
            a.this.hKo = i;
            if (a.this.hKo != 7) {
                ab.bjd();
                e.djg();
            } else {
                e.djf();
            }
            if (a.this.hEc instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hEc).cef().vE(a.this.hKn.vd(a.this.hKo));
                ((FrsNewAreaFragment) a.this.hEc).ceg().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hEc).setSortType(g.vV(a.this.hKn.vd(a.this.hKo)));
                ((FrsCommonTabFragment) a.this.hEc).cbf().jc(true);
            }
            a.this.cbP();
            return true;
        }
    };

    public void setFid(String str) {
        this.eEs = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbP() {
        ao aoVar = new ao("c11437");
        aoVar.ag("obj_type", this.hKn.vd(this.hKo));
        aoVar.dk("fid", this.eEs);
        TiebaStatic.log(aoVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.hKo = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hEc = baseFragment;
            this.hKl = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hKm = (TextView) this.hKl.findViewById(R.id.sort_tab_sort_name);
            this.hKn = (FrsTabSortSwitchButton) this.hKl.findViewById(R.id.sort_tab_switch_btn);
            this.hKn.setOnSwitchChangeListener(this.hKp);
            this.hKo = this.hKn.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.hKn != null) {
            this.hKn.onChangeSkinType();
        }
        an.setViewTextColor(this.hKm, (int) R.color.cp_cont_b);
        an.setBackgroundColor(this.hKl, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.hKn != null) {
            this.hKn.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.hKn != null) {
            this.hKn.changeState(g.vW(i));
            this.hKo = this.hKn.getState();
        }
    }
}

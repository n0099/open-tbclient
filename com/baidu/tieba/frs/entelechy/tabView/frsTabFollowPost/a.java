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
import com.baidu.tbadk.util.aa;
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
    private String eQk;
    private View hip;
    private BaseFragment hiq;
    private TextView hir;
    private FrsTabSortSwitchButton his;
    private int hit;
    private FrsTabSortSwitchButton.a hiu = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean tO(int i) {
            if (com.baidu.tieba.frs.a.bNB().bNC()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hiq.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hiq instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hiq).bUf() == null || ((FrsNewAreaFragment) a.this.hiq).bUg() == null) {
                    return false;
                }
            } else if (!(a.this.hiq instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hiq).bRr() == null || ((FrsCommonTabFragment) a.this.hiq).bRs() == null) {
                    return false;
                }
            }
            if (a.this.hit == i) {
                return true;
            }
            a.this.hit = i;
            if (a.this.hit != 7) {
                aa.baD();
                e.cXp();
            } else {
                e.cXo();
            }
            if (a.this.hiq instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hiq).bUf().ur(a.this.his.tR(a.this.hit));
                ((FrsNewAreaFragment) a.this.hiq).bUg().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hiq).setSortType(g.uI(a.this.his.tR(a.this.hit)));
                ((FrsCommonTabFragment) a.this.hiq).bRs().it(true);
            }
            a.this.bSb();
            return true;
        }
    };

    public void setFid(String str) {
        this.eQk = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSb() {
        an anVar = new an("c11437");
        anVar.af("obj_type", this.his.tR(this.hit));
        anVar.cI("fid", this.eQk);
        TiebaStatic.log(anVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.hit = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hiq = baseFragment;
            this.hip = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hir = (TextView) this.hip.findViewById(R.id.sort_tab_sort_name);
            this.his = (FrsTabSortSwitchButton) this.hip.findViewById(R.id.sort_tab_switch_btn);
            this.his.setOnSwitchChangeListener(this.hiu);
            this.hit = this.his.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.his != null) {
            this.his.onChangeSkinType();
        }
        am.setViewTextColor(this.hir, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.hip, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.his != null) {
            this.his.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.his != null) {
            this.his.changeState(g.uJ(i));
            this.hit = this.his.getState();
        }
    }
}

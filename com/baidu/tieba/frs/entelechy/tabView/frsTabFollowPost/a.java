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
    private String eQf;
    private View hij;
    private BaseFragment hik;
    private TextView hil;
    private FrsTabSortSwitchButton him;
    private int hin;
    private FrsTabSortSwitchButton.a hio = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean tO(int i) {
            if (com.baidu.tieba.frs.a.bND().bNE()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hik.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hik instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hik).bUh() == null || ((FrsNewAreaFragment) a.this.hik).bUi() == null) {
                    return false;
                }
            } else if (!(a.this.hik instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hik).bRt() == null || ((FrsCommonTabFragment) a.this.hik).bRu() == null) {
                    return false;
                }
            }
            if (a.this.hin == i) {
                return true;
            }
            a.this.hin = i;
            if (a.this.hin != 7) {
                aa.baF();
                e.cXs();
            } else {
                e.cXr();
            }
            if (a.this.hik instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hik).bUh().ur(a.this.him.tR(a.this.hin));
                ((FrsNewAreaFragment) a.this.hik).bUi().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hik).setSortType(g.uI(a.this.him.tR(a.this.hin)));
                ((FrsCommonTabFragment) a.this.hik).bRu().it(true);
            }
            a.this.bSd();
            return true;
        }
    };

    public void setFid(String str) {
        this.eQf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSd() {
        an anVar = new an("c11437");
        anVar.af("obj_type", this.him.tR(this.hin));
        anVar.cI("fid", this.eQf);
        TiebaStatic.log(anVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.hin = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hik = baseFragment;
            this.hij = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hil = (TextView) this.hij.findViewById(R.id.sort_tab_sort_name);
            this.him = (FrsTabSortSwitchButton) this.hij.findViewById(R.id.sort_tab_switch_btn);
            this.him.setOnSwitchChangeListener(this.hio);
            this.hin = this.him.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.him != null) {
            this.him.onChangeSkinType();
        }
        am.setViewTextColor(this.hil, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.hij, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.him != null) {
            this.him.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.him != null) {
            this.him.changeState(g.uJ(i));
            this.hin = this.him.getState();
        }
    }
}

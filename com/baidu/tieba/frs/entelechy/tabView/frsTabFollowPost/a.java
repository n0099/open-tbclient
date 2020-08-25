package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
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
    private String eVt;
    private BaseFragment hXy;
    private FrsTabSortSwitchButton.a ieA = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean xL(int i) {
            if (com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.hXy.showToast(R.string.neterror);
                return false;
            }
            if (a.this.hXy instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.hXy).csi() == null || ((FrsNewAreaFragment) a.this.hXy).csj() == null) {
                    return false;
                }
            } else if (!(a.this.hXy instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.hXy).cpg() == null || ((FrsCommonTabFragment) a.this.hXy).cph() == null) {
                    return false;
                }
            }
            if (a.this.iez == i) {
                return true;
            }
            a.this.iez = i;
            if (a.this.iez != 7) {
                ab.bvJ();
                e.dxK();
            } else {
                e.dxJ();
            }
            if (a.this.hXy instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.hXy).csi().yp(a.this.iey.xO(a.this.iez));
                ((FrsNewAreaFragment) a.this.hXy).csj().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.hXy).setSortType(g.yG(a.this.iey.xO(a.this.iez)));
                ((FrsCommonTabFragment) a.this.hXy).cph().kf(true);
            }
            a.this.cpS();
            return true;
        }
    };
    private View iew;
    private TextView iex;
    private FrsTabSortSwitchButton iey;
    private int iez;

    public void setFid(String str) {
        this.eVt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpS() {
        aq aqVar = new aq("c11437");
        aqVar.ai("obj_type", this.iey.xO(this.iez));
        aqVar.dD("fid", this.eVt);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.iez = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.hXy = baseFragment;
            this.iew = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.iex = (TextView) this.iew.findViewById(R.id.sort_tab_sort_name);
            this.iey = (FrsTabSortSwitchButton) this.iew.findViewById(R.id.sort_tab_switch_btn);
            this.iey.setOnSwitchChangeListener(this.ieA);
            this.iez = this.iey.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.iey != null) {
            this.iey.onChangeSkinType();
        }
        ap.setViewTextColor(this.iex, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iew, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.iey != null) {
            this.iey.setData(list);
        }
    }

    public void changeState(int i) {
        if (this.iey != null) {
            this.iey.changeState(g.yH(i));
            this.iez = this.iey.getState();
        }
    }
}

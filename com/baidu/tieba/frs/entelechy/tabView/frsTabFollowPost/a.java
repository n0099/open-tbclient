package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private String fNd;
    private BaseFragment jkQ;
    private View jsa;
    private TextView jsb;
    private FrsTabSortSwitchButton jsc;
    private int jsd;
    private FrsTabSortSwitchButton.a jse = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zp(int i) {
            if (com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.jkQ.showToast(R.string.neterror);
                return false;
            }
            if (a.this.jkQ instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.jkQ).cJR() == null || ((FrsNewAreaFragment) a.this.jkQ).cJS() == null) {
                    return false;
                }
            } else if (!(a.this.jkQ instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.jkQ).cFK() == null || ((FrsCommonTabFragment) a.this.jkQ).cFL() == null) {
                    return false;
                }
            }
            if (a.this.jsd == i) {
                return true;
            }
            a.this.jsd = i;
            if (a.this.jsd != 7) {
                ab.bFI();
                e.dOM();
            } else {
                e.dOL();
            }
            if (a.this.jkQ instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.jkQ).cJR().Ac(a.this.jsc.zs(a.this.jsd));
                if (d.bjr()) {
                    com.baidu.tbadk.a.b.a.mJ(a.this.jsc.zs(a.this.jsd));
                }
                ((FrsNewAreaFragment) a.this.jkQ).cJS().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.jkQ).setSortType(com.baidu.tieba.frs.d.j.At(a.this.jsc.zs(a.this.jsd)));
                ((FrsCommonTabFragment) a.this.jkQ).cFL().lU(true);
            }
            a.this.cGD();
            return true;
        }
    };

    public void setFid(String str) {
        this.fNd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGD() {
        ar arVar = new ar("c11437");
        arVar.ap("obj_type", this.jsc.zs(this.jsd));
        arVar.dR("fid", this.fNd);
        TiebaStatic.log(arVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.jsd = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.jkQ = baseFragment;
            this.jsa = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jsa.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jsb = (TextView) this.jsa.findViewById(R.id.sort_tab_sort_name);
            this.jsc = (FrsTabSortSwitchButton) this.jsa.findViewById(R.id.sort_tab_switch_btn);
            this.jsc.setOnSwitchChangeListener(this.jse);
            this.jsd = this.jsc.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jsc != null) {
            this.jsc.onChangeSkinType();
        }
        ap.setViewTextColor(this.jsb, R.color.CAM_X0105);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jsc != null) {
            this.jsc.setData(list);
        }
    }

    public void iF(int i) {
        if (this.jsc != null) {
            this.jsc.iF(com.baidu.tieba.frs.d.j.Au(i));
            this.jsd = this.jsc.getState();
        }
    }
}

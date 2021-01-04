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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class a {
    private String fPy;
    private BaseFragment jjR;
    private View jra;
    private TextView jrb;
    private FrsTabSortSwitchButton jrc;
    private int jrd;
    private FrsTabSortSwitchButton.a jre = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean AL(int i) {
            if (com.baidu.tieba.frs.b.cDX().cDR() || com.baidu.tieba.frs.a.cDQ().cDR()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.jjR.showToast(R.string.neterror);
                return false;
            }
            if (a.this.jjR instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.jjR).cMv() == null || ((FrsNewAreaFragment) a.this.jjR).cMw() == null) {
                    return false;
                }
            } else if (!(a.this.jjR instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.jjR).cIo() == null || ((FrsCommonTabFragment) a.this.jjR).cIp() == null) {
                    return false;
                }
            }
            if (a.this.jrd == i) {
                return true;
            }
            a.this.jrd = i;
            if (a.this.jrd != 7) {
                z.bJg();
                e.dQs();
            } else {
                e.dQr();
            }
            if (a.this.jjR instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.jjR).cMv().By(a.this.jrc.AO(a.this.jrd));
                if (d.bmY()) {
                    com.baidu.tbadk.a.b.a.om(a.this.jrc.AO(a.this.jrd));
                }
                ((FrsNewAreaFragment) a.this.jjR).cMw().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.jjR).setSortType(com.baidu.tieba.frs.d.j.BP(a.this.jrc.AO(a.this.jrd)));
                ((FrsCommonTabFragment) a.this.jjR).cIp().lU(true);
            }
            a.this.cJh();
            return true;
        }
    };

    public void setFid(String str) {
        this.fPy = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJh() {
        aq aqVar = new aq("c11437");
        aqVar.an("obj_type", this.jrc.AO(this.jrd));
        aqVar.dX("fid", this.fPy);
        TiebaStatic.log(aqVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.jrd = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.jjR = baseFragment;
            this.jra = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jra.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jrb = (TextView) this.jra.findViewById(R.id.sort_tab_sort_name);
            this.jrc = (FrsTabSortSwitchButton) this.jra.findViewById(R.id.sort_tab_switch_btn);
            this.jrc.setOnSwitchChangeListener(this.jre);
            this.jrd = this.jrc.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jrc != null) {
            this.jrc.onChangeSkinType();
        }
        ao.setViewTextColor(this.jrb, R.color.CAM_X0105);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jrc != null) {
            this.jrc.setData(list);
        }
    }

    public void ki(int i) {
        if (this.jrc != null) {
            this.jrc.ki(com.baidu.tieba.frs.d.j.BQ(i));
            this.jrd = this.jrc.getState();
        }
    }
}

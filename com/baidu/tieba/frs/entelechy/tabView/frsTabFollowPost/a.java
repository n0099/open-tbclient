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
    private String fOD;
    private BaseFragment jmO;
    private View jtX;
    private TextView jtY;
    private FrsTabSortSwitchButton jtZ;
    private int jua;
    private FrsTabSortSwitchButton.a jub = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zq(int i) {
            if (com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.jmO.showToast(R.string.neterror);
                return false;
            }
            if (a.this.jmO instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.jmO).cKe() == null || ((FrsNewAreaFragment) a.this.jmO).cKf() == null) {
                    return false;
                }
            } else if (!(a.this.jmO instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.jmO).cFX() == null || ((FrsCommonTabFragment) a.this.jmO).cFY() == null) {
                    return false;
                }
            }
            if (a.this.jua == i) {
                return true;
            }
            a.this.jua = i;
            if (a.this.jua != 7) {
                ab.bFM();
                e.dPd();
            } else {
                e.dPc();
            }
            if (a.this.jmO instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.jmO).cKe().Ad(a.this.jtZ.zt(a.this.jua));
                if (d.bjt()) {
                    com.baidu.tbadk.a.b.a.mK(a.this.jtZ.zt(a.this.jua));
                }
                ((FrsNewAreaFragment) a.this.jmO).cKf().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.jmO).setSortType(com.baidu.tieba.frs.d.j.Au(a.this.jtZ.zt(a.this.jua)));
                ((FrsCommonTabFragment) a.this.jmO).cFY().lU(true);
            }
            a.this.cGQ();
            return true;
        }
    };

    public void setFid(String str) {
        this.fOD = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGQ() {
        ar arVar = new ar("c11437");
        arVar.aq("obj_type", this.jtZ.zt(this.jua));
        arVar.dR("fid", this.fOD);
        TiebaStatic.log(arVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.jua = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.jmO = baseFragment;
            this.jtX = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jtX.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jtY = (TextView) this.jtX.findViewById(R.id.sort_tab_sort_name);
            this.jtZ = (FrsTabSortSwitchButton) this.jtX.findViewById(R.id.sort_tab_switch_btn);
            this.jtZ.setOnSwitchChangeListener(this.jub);
            this.jua = this.jtZ.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jtZ != null) {
            this.jtZ.onChangeSkinType();
        }
        ap.setViewTextColor(this.jtY, R.color.CAM_X0105);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jtZ != null) {
            this.jtZ.setData(list);
        }
    }

    public void iG(int i) {
        if (this.jtZ != null) {
            this.jtZ.iG(com.baidu.tieba.frs.d.j.Av(i));
            this.jua = this.jtZ.getState();
        }
    }
}

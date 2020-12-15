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
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class a {
    private String fFV;
    private BaseFragment iXE;
    private View jeB;
    private TextView jeC;
    private FrsTabSortSwitchButton jeD;
    private int jeE;
    private FrsTabSortSwitchButton.a jeF = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean Az(int i) {
            if (com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.iXE.showToast(R.string.neterror);
                return false;
            }
            if (a.this.iXE instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.iXE).cJv() == null || ((FrsNewAreaFragment) a.this.iXE).cJw() == null) {
                    return false;
                }
            } else if (!(a.this.iXE instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.iXE).cFt() == null || ((FrsCommonTabFragment) a.this.iXE).cFu() == null) {
                    return false;
                }
            }
            if (a.this.jeE == i) {
                return true;
            }
            a.this.jeE = i;
            if (a.this.jeE != 7) {
                aa.bGN();
                e.dQw();
            } else {
                e.dQv();
            }
            if (a.this.iXE instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.iXE).cJv().Bm(a.this.jeD.AC(a.this.jeE));
                ((FrsNewAreaFragment) a.this.iXE).cJw().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.iXE).setSortType(com.baidu.tieba.frs.f.j.BD(a.this.jeD.AC(a.this.jeE)));
                ((FrsCommonTabFragment) a.this.iXE).cFu().lx(true);
            }
            a.this.cGi();
            return true;
        }
    };

    public void setFid(String str) {
        this.fFV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGi() {
        ar arVar = new ar("c11437");
        arVar.al("obj_type", this.jeD.AC(this.jeE));
        arVar.dY("fid", this.fFV);
        TiebaStatic.log(arVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.jeE = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.iXE = baseFragment;
            this.jeB = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            if (d.bkA()) {
                this.jeB.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            } else {
                this.jeB.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            }
            this.jeC = (TextView) this.jeB.findViewById(R.id.sort_tab_sort_name);
            this.jeD = (FrsTabSortSwitchButton) this.jeB.findViewById(R.id.sort_tab_switch_btn);
            this.jeD.setOnSwitchChangeListener(this.jeF);
            this.jeE = this.jeD.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jeD != null) {
            this.jeD.onChangeSkinType();
        }
        ap.setViewTextColor(this.jeC, R.color.CAM_X0105);
        if (d.bkA()) {
            ap.setBackgroundColor(this.jeB, R.color.CAM_X0205);
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jeD != null) {
            this.jeD.setData(list);
        }
    }

    public void kj(int i) {
        if (this.jeD != null) {
            this.jeD.kj(com.baidu.tieba.frs.f.j.BE(i));
            this.jeE = this.jeD.getState();
        }
    }
}

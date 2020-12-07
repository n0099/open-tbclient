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
    private BaseFragment iXC;
    private TextView jeA;
    private FrsTabSortSwitchButton jeB;
    private int jeC;
    private FrsTabSortSwitchButton.a jeD = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean Az(int i) {
            if (com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                a.this.iXC.showToast(R.string.neterror);
                return false;
            }
            if (a.this.iXC instanceof FrsNewAreaFragment) {
                if (((FrsNewAreaFragment) a.this.iXC).cJu() == null || ((FrsNewAreaFragment) a.this.iXC).cJv() == null) {
                    return false;
                }
            } else if (!(a.this.iXC instanceof FrsCommonTabFragment)) {
                return false;
            } else {
                if (((FrsCommonTabFragment) a.this.iXC).cFs() == null || ((FrsCommonTabFragment) a.this.iXC).cFt() == null) {
                    return false;
                }
            }
            if (a.this.jeC == i) {
                return true;
            }
            a.this.jeC = i;
            if (a.this.jeC != 7) {
                aa.bGN();
                e.dQv();
            } else {
                e.dQu();
            }
            if (a.this.iXC instanceof FrsNewAreaFragment) {
                ((FrsNewAreaFragment) a.this.iXC).cJu().Bm(a.this.jeB.AC(a.this.jeC));
                ((FrsNewAreaFragment) a.this.iXC).cJv().startPullRefresh();
            } else {
                ((FrsCommonTabFragment) a.this.iXC).setSortType(com.baidu.tieba.frs.f.j.BD(a.this.jeB.AC(a.this.jeC)));
                ((FrsCommonTabFragment) a.this.iXC).cFt().lx(true);
            }
            a.this.cGh();
            return true;
        }
    };
    private View jez;

    public void setFid(String str) {
        this.fFV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        ar arVar = new ar("c11437");
        arVar.al("obj_type", this.jeB.AC(this.jeC));
        arVar.dY("fid", this.fFV);
        TiebaStatic.log(arVar);
    }

    public a(BaseFragment baseFragment, RelativeLayout relativeLayout) {
        this.jeC = -1;
        if (baseFragment != null && relativeLayout != null) {
            this.iXC = baseFragment;
            this.jez = LayoutInflater.from(baseFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            if (d.bkA()) {
                this.jez.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            } else {
                this.jez.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            }
            this.jeA = (TextView) this.jez.findViewById(R.id.sort_tab_sort_name);
            this.jeB = (FrsTabSortSwitchButton) this.jez.findViewById(R.id.sort_tab_switch_btn);
            this.jeB.setOnSwitchChangeListener(this.jeD);
            this.jeC = this.jeB.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jeB != null) {
            this.jeB.onChangeSkinType();
        }
        ap.setViewTextColor(this.jeA, R.color.CAM_X0105);
        if (d.bkA()) {
            ap.setBackgroundColor(this.jez, R.color.CAM_X0205);
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jeB != null) {
            this.jeB.setData(list);
        }
    }

    public void kj(int i) {
        if (this.jeB != null) {
            this.jeB.kj(com.baidu.tieba.frs.f.j.BE(i));
            this.jeC = this.jeB.getState();
        }
    }
}

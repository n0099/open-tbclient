package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class b {
    private String fsZ;
    private FrsFragment iDN;
    private View iMT;
    private TextView iMU;
    private FrsTabSortSwitchButton iMV;
    private int iMW;
    private FrsTabSortSwitchButton.a iMX = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zj(int i) {
            if (com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.iDN.showToast(R.string.neterror);
                return false;
            } else if (b.this.iDN.cvF() == null || b.this.iDN.cvK() == null) {
                return false;
            } else {
                if (b.this.iMW == i) {
                    return true;
                }
                b.this.iDN.cvF().zO(b.this.iMV.zm(b.this.iMW));
                b.this.iMW = i;
                if (b.this.iMW != 7) {
                    ac.bBw();
                    e.dIC();
                } else {
                    e.dIB();
                }
                b.this.iDN.cvF().zN(b.this.iMV.zm(b.this.iMW));
                b.this.iDN.cvF().qd(true);
                b.this.iDN.cvK().startPullRefresh();
                b.this.iDN.cvF().qc(true);
                b.this.czK();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fsZ = str;
    }

    public FrsTabSortSwitchButton czL() {
        return this.iMV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czK() {
        aq aqVar = new aq("c11437");
        aqVar.aj("obj_type", this.iMV.zm(this.iMW));
        aqVar.dR("fid", this.fsZ);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.iMW = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.iDN = frsFragment;
            this.iMT = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.iMU = (TextView) this.iMT.findViewById(R.id.sort_tab_sort_name);
            this.iMV = (FrsTabSortSwitchButton) this.iMT.findViewById(R.id.sort_tab_switch_btn);
            this.iMV.setOnSwitchChangeListener(this.iMX);
            this.iMW = this.iMV.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.iMV != null) {
            this.iMV.onChangeSkinType();
        }
        ap.setViewTextColor(this.iMU, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iMT, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.iMV != null) {
            this.iMV.setData(list);
        }
    }
}

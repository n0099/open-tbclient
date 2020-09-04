package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class b {
    private String eVx;
    private FrsFragment hVq;
    private View ieC;
    private TextView ieD;
    private FrsTabSortSwitchButton ieE;
    private int ieF;
    private FrsTabSortSwitchButton.a ieG = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean xL(int i) {
            if (com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.hVq.showToast(R.string.neterror);
                return false;
            } else if (b.this.hVq.clO() == null || b.this.hVq.clT() == null) {
                return false;
            } else {
                if (b.this.ieF == i) {
                    return true;
                }
                b.this.hVq.clO().yq(b.this.ieE.xO(b.this.ieF));
                b.this.ieF = i;
                if (b.this.ieF != 7) {
                    ab.bvK();
                    e.dxP();
                } else {
                    e.dxO();
                }
                b.this.hVq.clO().yp(b.this.ieE.xO(b.this.ieF));
                b.this.hVq.clO().pa(true);
                b.this.hVq.clT().startPullRefresh();
                b.this.hVq.clO().oZ(true);
                b.this.cpT();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.eVx = str;
    }

    public FrsTabSortSwitchButton cpU() {
        return this.ieE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpT() {
        aq aqVar = new aq("c11437");
        aqVar.ai("obj_type", this.ieE.xO(this.ieF));
        aqVar.dD("fid", this.eVx);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.ieF = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.hVq = frsFragment;
            this.ieC = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.ieD = (TextView) this.ieC.findViewById(R.id.sort_tab_sort_name);
            this.ieE = (FrsTabSortSwitchButton) this.ieC.findViewById(R.id.sort_tab_switch_btn);
            this.ieE.setOnSwitchChangeListener(this.ieG);
            this.ieF = this.ieE.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.ieE != null) {
            this.ieE.onChangeSkinType();
        }
        ap.setViewTextColor(this.ieD, R.color.cp_cont_b);
        ap.setBackgroundColor(this.ieC, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.ieE != null) {
            this.ieE.setData(list);
        }
    }
}

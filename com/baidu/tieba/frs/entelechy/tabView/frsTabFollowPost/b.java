package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class b {
    private String eEs;
    private FrsFragment hBW;
    private View hKl;
    private TextView hKm;
    private FrsTabSortSwitchButton hKn;
    private int hKo;
    private FrsTabSortSwitchButton.a hKp = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean va(int i) {
            if (com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.hBW.showToast(R.string.neterror);
                return false;
            } else if (b.this.hBW.bXV() == null || b.this.hBW.bYa() == null) {
                return false;
            } else {
                if (b.this.hKo == i) {
                    return true;
                }
                b.this.hBW.bXV().vF(b.this.hKn.vd(b.this.hKo));
                b.this.hKo = i;
                if (b.this.hKo != 7) {
                    ab.bjd();
                    e.djg();
                } else {
                    e.djf();
                }
                b.this.hBW.bXV().vE(b.this.hKn.vd(b.this.hKo));
                b.this.hBW.bXV().nP(true);
                b.this.hBW.bYa().startPullRefresh();
                b.this.hBW.bXV().nO(true);
                b.this.cbP();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.eEs = str;
    }

    public FrsTabSortSwitchButton cbQ() {
        return this.hKn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbP() {
        ao aoVar = new ao("c11437");
        aoVar.ag("obj_type", this.hKn.vd(this.hKo));
        aoVar.dk("fid", this.eEs);
        TiebaStatic.log(aoVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.hKo = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.hBW = frsFragment;
            this.hKl = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hKm = (TextView) this.hKl.findViewById(R.id.sort_tab_sort_name);
            this.hKn = (FrsTabSortSwitchButton) this.hKl.findViewById(R.id.sort_tab_switch_btn);
            this.hKn.setOnSwitchChangeListener(this.hKp);
            this.hKo = this.hKn.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.hKn != null) {
            this.hKn.onChangeSkinType();
        }
        an.setViewTextColor(this.hKm, (int) R.color.cp_cont_b);
        an.setBackgroundColor(this.hKl, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.hKn != null) {
            this.hKn.setData(list);
        }
    }
}

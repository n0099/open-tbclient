package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class b {
    private String fFV;
    private FrsFragment iVs;
    private View jeB;
    private TextView jeC;
    private FrsTabSortSwitchButton jeD;
    private int jeE;
    private FrsTabSortSwitchButton.a jeF = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean Az(int i) {
            if (com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.iVs.showToast(R.string.neterror);
                return false;
            } else if (b.this.iVs.cCa() == null || b.this.iVs.cCf() == null) {
                return false;
            } else {
                if (b.this.jeE == i) {
                    return true;
                }
                b.this.iVs.cCa().Bn(b.this.jeD.AC(b.this.jeE));
                b.this.jeE = i;
                if (b.this.jeE != 7) {
                    aa.bGN();
                    e.dQw();
                } else {
                    e.dQv();
                }
                b.this.iVs.cCa().Bm(b.this.jeD.AC(b.this.jeE));
                b.this.iVs.cCa().qQ(true);
                b.this.iVs.cCf().startPullRefresh();
                b.this.iVs.cCa().qP(true);
                b.this.cGi();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fFV = str;
    }

    public FrsTabSortSwitchButton cGj() {
        return this.jeD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGi() {
        ar arVar = new ar("c11437");
        arVar.al("obj_type", this.jeD.AC(this.jeE));
        arVar.dY("fid", this.fFV);
        TiebaStatic.log(arVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.jeE = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.iVs = frsFragment;
            this.jeB = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
        ap.setViewTextColor(this.jeC, R.color.CAM_X0108);
        if (d.bkA()) {
            ap.setBackgroundColor(this.jeB, R.color.CAM_X0205);
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jeD != null) {
            this.jeD.setData(list);
        }
    }
}

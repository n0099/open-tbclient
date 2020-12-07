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
    private FrsFragment iVq;
    private TextView jeA;
    private FrsTabSortSwitchButton jeB;
    private int jeC;
    private FrsTabSortSwitchButton.a jeD = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean Az(int i) {
            if (com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.iVq.showToast(R.string.neterror);
                return false;
            } else if (b.this.iVq.cBZ() == null || b.this.iVq.cCe() == null) {
                return false;
            } else {
                if (b.this.jeC == i) {
                    return true;
                }
                b.this.iVq.cBZ().Bn(b.this.jeB.AC(b.this.jeC));
                b.this.jeC = i;
                if (b.this.jeC != 7) {
                    aa.bGN();
                    e.dQv();
                } else {
                    e.dQu();
                }
                b.this.iVq.cBZ().Bm(b.this.jeB.AC(b.this.jeC));
                b.this.iVq.cBZ().qQ(true);
                b.this.iVq.cCe().startPullRefresh();
                b.this.iVq.cBZ().qP(true);
                b.this.cGh();
                return true;
            }
        }
    };
    private View jez;

    public void setFid(String str) {
        this.fFV = str;
    }

    public FrsTabSortSwitchButton cGi() {
        return this.jeB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        ar arVar = new ar("c11437");
        arVar.al("obj_type", this.jeB.AC(this.jeC));
        arVar.dY("fid", this.fFV);
        TiebaStatic.log(arVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.jeC = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.iVq = frsFragment;
            this.jez = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
        ap.setViewTextColor(this.jeA, R.color.CAM_X0108);
        if (d.bkA()) {
            ap.setBackgroundColor(this.jez, R.color.CAM_X0205);
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jeB != null) {
            this.jeB.setData(list);
        }
    }
}

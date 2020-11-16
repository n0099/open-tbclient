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
/* loaded from: classes21.dex */
public class b {
    private String fyg;
    private FrsFragment iKx;
    private View iTD;
    private TextView iTE;
    private FrsTabSortSwitchButton iTF;
    private int iTG;
    private FrsTabSortSwitchButton.a iTH = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zU(int i) {
            if (com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.iKx.showToast(R.string.neterror);
                return false;
            } else if (b.this.iKx.cxJ() == null || b.this.iKx.cxO() == null) {
                return false;
            } else {
                if (b.this.iTG == i) {
                    return true;
                }
                b.this.iKx.cxJ().Az(b.this.iTF.zX(b.this.iTG));
                b.this.iTG = i;
                if (b.this.iTG != 7) {
                    aa.bDm();
                    e.dLd();
                } else {
                    e.dLc();
                }
                b.this.iKx.cxJ().Ay(b.this.iTF.zX(b.this.iTG));
                b.this.iKx.cxJ().qp(true);
                b.this.iKx.cxO().startPullRefresh();
                b.this.iKx.cxJ().qo(true);
                b.this.cBO();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fyg = str;
    }

    public FrsTabSortSwitchButton cBP() {
        return this.iTF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBO() {
        ar arVar = new ar("c11437");
        arVar.ak("obj_type", this.iTF.zX(this.iTG));
        arVar.dR("fid", this.fyg);
        TiebaStatic.log(arVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.iTG = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.iKx = frsFragment;
            this.iTD = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            if (d.bhw()) {
                this.iTD.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            } else {
                this.iTD.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            }
            this.iTE = (TextView) this.iTD.findViewById(R.id.sort_tab_sort_name);
            this.iTF = (FrsTabSortSwitchButton) this.iTD.findViewById(R.id.sort_tab_switch_btn);
            this.iTF.setOnSwitchChangeListener(this.iTH);
            this.iTG = this.iTF.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.iTF != null) {
            this.iTF.onChangeSkinType();
        }
        ap.setViewTextColor(this.iTE, R.color.CAM_X0108);
        if (d.bhw()) {
            ap.setBackgroundColor(this.iTD, R.color.CAM_X0205);
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.iTF != null) {
            this.iTF.setData(list);
        }
    }
}

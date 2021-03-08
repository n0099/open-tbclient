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
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class b {
    private String fOD;
    private FrsFragment jkB;
    private View jtX;
    private TextView jtY;
    private FrsTabSortSwitchButton jtZ;
    private int jua;
    private FrsTabSortSwitchButton.a jub = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zq(int i) {
            if (com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.jkB.showToast(R.string.neterror);
                return false;
            } else if (b.this.jkB.cCC() == null || b.this.jkB.cCH() == null) {
                return false;
            } else {
                if (b.this.jua == i) {
                    return true;
                }
                b.this.jkB.cCC().Ae(b.this.jtZ.zt(b.this.jua));
                b.this.jua = i;
                if (b.this.jua != 7) {
                    ab.bFM();
                    e.dPd();
                } else {
                    e.dPc();
                }
                b.this.jkB.cCC().Ad(b.this.jtZ.zt(b.this.jua));
                if (d.bjt()) {
                    com.baidu.tbadk.a.b.a.mK(b.this.jtZ.zt(b.this.jua));
                }
                b.this.jkB.cCC().ru(true);
                b.this.jkB.cCH().startPullRefresh();
                b.this.jkB.cCC().rt(true);
                b.this.cGQ();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fOD = str;
    }

    public FrsTabSortSwitchButton cGR() {
        return this.jtZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGQ() {
        ar arVar = new ar("c11437");
        arVar.aq("obj_type", this.jtZ.zt(this.jua));
        arVar.dR("fid", this.fOD);
        TiebaStatic.log(arVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.jua = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.jkB = frsFragment;
            this.jtX = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
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
        ap.setViewTextColor(this.jtY, R.color.CAM_X0108);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jtZ != null) {
            this.jtZ.setData(list);
        }
    }

    public void iG(int i) {
        if (this.jtZ != null) {
            this.jtZ.iG(i);
            this.jua = this.jtZ.getState();
        }
    }
}

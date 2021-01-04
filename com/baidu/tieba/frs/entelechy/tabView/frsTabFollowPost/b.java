package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class b {
    private String fPy;
    private FrsFragment jhE;
    private View jra;
    private TextView jrb;
    private FrsTabSortSwitchButton jrc;
    private int jrd;
    private FrsTabSortSwitchButton.a jre = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean AL(int i) {
            if (com.baidu.tieba.frs.b.cDX().cDR() || com.baidu.tieba.frs.a.cDQ().cDR()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.jhE.showToast(R.string.neterror);
                return false;
            } else if (b.this.jhE.cEU() == null || b.this.jhE.cEZ() == null) {
                return false;
            } else {
                if (b.this.jrd == i) {
                    return true;
                }
                b.this.jhE.cEU().Bz(b.this.jrc.AO(b.this.jrd));
                b.this.jrd = i;
                if (b.this.jrd != 7) {
                    z.bJg();
                    e.dQs();
                } else {
                    e.dQr();
                }
                b.this.jhE.cEU().By(b.this.jrc.AO(b.this.jrd));
                if (d.bmY()) {
                    com.baidu.tbadk.a.b.a.om(b.this.jrc.AO(b.this.jrd));
                }
                b.this.jhE.cEU().ro(true);
                b.this.jhE.cEZ().startPullRefresh();
                b.this.jhE.cEU().rn(true);
                b.this.cJh();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fPy = str;
    }

    public FrsTabSortSwitchButton cJi() {
        return this.jrc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJh() {
        aq aqVar = new aq("c11437");
        aqVar.an("obj_type", this.jrc.AO(this.jrd));
        aqVar.dX("fid", this.fPy);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.jrd = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.jhE = frsFragment;
            this.jra = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jra.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jrb = (TextView) this.jra.findViewById(R.id.sort_tab_sort_name);
            this.jrc = (FrsTabSortSwitchButton) this.jra.findViewById(R.id.sort_tab_switch_btn);
            this.jrc.setOnSwitchChangeListener(this.jre);
            this.jrd = this.jrc.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jrc != null) {
            this.jrc.onChangeSkinType();
        }
        ao.setViewTextColor(this.jrb, R.color.CAM_X0108);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jrc != null) {
            this.jrc.setData(list);
        }
    }

    public void ki(int i) {
        if (this.jrc != null) {
            this.jrc.ki(i);
            this.jrd = this.jrc.getState();
        }
    }
}

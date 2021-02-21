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
    private String fNd;
    private FrsFragment jiS;
    private View jso;
    private TextView jsp;
    private FrsTabSortSwitchButton jsq;
    private int jsr;
    private FrsTabSortSwitchButton.a jss = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zp(int i) {
            if (com.baidu.tieba.frs.b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.jiS.showToast(R.string.neterror);
                return false;
            } else if (b.this.jiS.cCw() == null || b.this.jiS.cCB() == null) {
                return false;
            } else {
                if (b.this.jsr == i) {
                    return true;
                }
                b.this.jiS.cCw().Ad(b.this.jsq.zs(b.this.jsr));
                b.this.jsr = i;
                if (b.this.jsr != 7) {
                    ab.bFI();
                    e.dOU();
                } else {
                    e.dOT();
                }
                b.this.jiS.cCw().Ac(b.this.jsq.zs(b.this.jsr));
                if (d.bjr()) {
                    com.baidu.tbadk.a.b.a.mJ(b.this.jsq.zs(b.this.jsr));
                }
                b.this.jiS.cCw().ru(true);
                b.this.jiS.cCB().startPullRefresh();
                b.this.jiS.cCw().rt(true);
                b.this.cGK();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fNd = str;
    }

    public FrsTabSortSwitchButton cGL() {
        return this.jsq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGK() {
        ar arVar = new ar("c11437");
        arVar.ap("obj_type", this.jsq.zs(this.jsr));
        arVar.dR("fid", this.fNd);
        TiebaStatic.log(arVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.jsr = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.jiS = frsFragment;
            this.jso = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jso.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jsp = (TextView) this.jso.findViewById(R.id.sort_tab_sort_name);
            this.jsq = (FrsTabSortSwitchButton) this.jso.findViewById(R.id.sort_tab_switch_btn);
            this.jsq.setOnSwitchChangeListener(this.jss);
            this.jsr = this.jsq.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jsq != null) {
            this.jsq.onChangeSkinType();
        }
        ap.setViewTextColor(this.jsp, R.color.CAM_X0108);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jsq != null) {
            this.jsq.setData(list);
        }
    }

    public void iF(int i) {
        if (this.jsq != null) {
            this.jsq.iF(i);
            this.jsr = this.jsq.getState();
        }
    }
}

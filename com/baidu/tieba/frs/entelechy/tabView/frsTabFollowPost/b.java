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
    private FrsFragment jiE;
    private View jsa;
    private TextView jsb;
    private FrsTabSortSwitchButton jsc;
    private int jsd;
    private FrsTabSortSwitchButton.a jse = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean zp(int i) {
            if (com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.jiE.showToast(R.string.neterror);
                return false;
            } else if (b.this.jiE.cCp() == null || b.this.jiE.cCu() == null) {
                return false;
            } else {
                if (b.this.jsd == i) {
                    return true;
                }
                b.this.jiE.cCp().Ad(b.this.jsc.zs(b.this.jsd));
                b.this.jsd = i;
                if (b.this.jsd != 7) {
                    ab.bFI();
                    e.dOM();
                } else {
                    e.dOL();
                }
                b.this.jiE.cCp().Ac(b.this.jsc.zs(b.this.jsd));
                if (d.bjr()) {
                    com.baidu.tbadk.a.b.a.mJ(b.this.jsc.zs(b.this.jsd));
                }
                b.this.jiE.cCp().ru(true);
                b.this.jiE.cCu().startPullRefresh();
                b.this.jiE.cCp().rt(true);
                b.this.cGD();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.fNd = str;
    }

    public FrsTabSortSwitchButton cGE() {
        return this.jsc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGD() {
        ar arVar = new ar("c11437");
        arVar.ap("obj_type", this.jsc.zs(this.jsd));
        arVar.dR("fid", this.fNd);
        TiebaStatic.log(arVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.jsd = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.jiE = frsFragment;
            this.jsa = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.jsa.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0);
            this.jsb = (TextView) this.jsa.findViewById(R.id.sort_tab_sort_name);
            this.jsc = (FrsTabSortSwitchButton) this.jsa.findViewById(R.id.sort_tab_switch_btn);
            this.jsc.setOnSwitchChangeListener(this.jse);
            this.jsd = this.jsc.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.jsc != null) {
            this.jsc.onChangeSkinType();
        }
        ap.setViewTextColor(this.jsb, R.color.CAM_X0108);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.jsc != null) {
            this.jsc.setData(list);
        }
    }

    public void iF(int i) {
        if (this.jsc != null) {
            this.jsc.iF(i);
            this.jsd = this.jsc.getState();
        }
    }
}

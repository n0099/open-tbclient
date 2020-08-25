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
    private String eVt;
    private FrsFragment hVk;
    private FrsTabSortSwitchButton.a ieA = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean xL(int i) {
            if (com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.hVk.showToast(R.string.neterror);
                return false;
            } else if (b.this.hVk.clN() == null || b.this.hVk.clS() == null) {
                return false;
            } else {
                if (b.this.iez == i) {
                    return true;
                }
                b.this.hVk.clN().yq(b.this.iey.xO(b.this.iez));
                b.this.iez = i;
                if (b.this.iez != 7) {
                    ab.bvJ();
                    e.dxK();
                } else {
                    e.dxJ();
                }
                b.this.hVk.clN().yp(b.this.iey.xO(b.this.iez));
                b.this.hVk.clN().oY(true);
                b.this.hVk.clS().startPullRefresh();
                b.this.hVk.clN().oX(true);
                b.this.cpS();
                return true;
            }
        }
    };
    private View iew;
    private TextView iex;
    private FrsTabSortSwitchButton iey;
    private int iez;

    public void setFid(String str) {
        this.eVt = str;
    }

    public FrsTabSortSwitchButton cpT() {
        return this.iey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpS() {
        aq aqVar = new aq("c11437");
        aqVar.ai("obj_type", this.iey.xO(this.iez));
        aqVar.dD("fid", this.eVt);
        TiebaStatic.log(aqVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.iez = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.hVk = frsFragment;
            this.iew = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.iex = (TextView) this.iew.findViewById(R.id.sort_tab_sort_name);
            this.iey = (FrsTabSortSwitchButton) this.iew.findViewById(R.id.sort_tab_switch_btn);
            this.iey.setOnSwitchChangeListener(this.ieA);
            this.iez = this.iey.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.iey != null) {
            this.iey.onChangeSkinType();
        }
        ap.setViewTextColor(this.iex, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iew, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.iey != null) {
            this.iey.setData(list);
        }
    }
}

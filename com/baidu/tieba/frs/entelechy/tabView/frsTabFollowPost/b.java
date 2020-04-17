package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton;
import com.baidu.tieba.tbadkCore.util.e;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class b {
    private String eQf;
    private FrsFragment hah;
    private View hij;
    private TextView hil;
    private FrsTabSortSwitchButton him;
    private int hin;
    private FrsTabSortSwitchButton.a hio = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean tO(int i) {
            if (com.baidu.tieba.frs.a.bND().bNE()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.hah.showToast(R.string.neterror);
                return false;
            } else if (b.this.hah.bOs() == null || b.this.hah.bOx() == null) {
                return false;
            } else {
                if (b.this.hin == i) {
                    return true;
                }
                b.this.hah.bOs().us(b.this.him.tR(b.this.hin));
                b.this.hin = i;
                if (b.this.hin != 7) {
                    aa.baF();
                    e.cXs();
                } else {
                    e.cXr();
                }
                b.this.hah.bOs().ur(b.this.him.tR(b.this.hin));
                b.this.hah.bOs().ni(true);
                b.this.hah.bOx().startPullRefresh();
                b.this.hah.bOs().nh(true);
                b.this.bSd();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.eQf = str;
    }

    public FrsTabSortSwitchButton bSe() {
        return this.him;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSd() {
        an anVar = new an("c11437");
        anVar.af("obj_type", this.him.tR(this.hin));
        anVar.cI("fid", this.eQf);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.hin = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.hah = frsFragment;
            this.hij = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hil = (TextView) this.hij.findViewById(R.id.sort_tab_sort_name);
            this.him = (FrsTabSortSwitchButton) this.hij.findViewById(R.id.sort_tab_switch_btn);
            this.him.setOnSwitchChangeListener(this.hio);
            this.hin = this.him.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.him != null) {
            this.him.onChangeSkinType();
        }
        am.setViewTextColor(this.hil, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.hij, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.him != null) {
            this.him.setData(list);
        }
    }
}

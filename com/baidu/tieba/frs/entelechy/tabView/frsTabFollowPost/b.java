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
    private String eQk;
    private FrsFragment han;
    private View hip;
    private TextView hir;
    private FrsTabSortSwitchButton his;
    private int hit;
    private FrsTabSortSwitchButton.a hiu = new FrsTabSortSwitchButton.a() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b.1
        @Override // com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.a
        public boolean tO(int i) {
            if (com.baidu.tieba.frs.a.bNC().bND()) {
                return false;
            }
            if (!j.isNetworkAvailableForImmediately()) {
                b.this.han.showToast(R.string.neterror);
                return false;
            } else if (b.this.han.bOr() == null || b.this.han.bOw() == null) {
                return false;
            } else {
                if (b.this.hit == i) {
                    return true;
                }
                b.this.han.bOr().us(b.this.his.tR(b.this.hit));
                b.this.hit = i;
                if (b.this.hit != 7) {
                    aa.baD();
                    e.cXq();
                } else {
                    e.cXp();
                }
                b.this.han.bOr().ur(b.this.his.tR(b.this.hit));
                b.this.han.bOr().ni(true);
                b.this.han.bOw().startPullRefresh();
                b.this.han.bOr().nh(true);
                b.this.bSc();
                return true;
            }
        }
    };

    public void setFid(String str) {
        this.eQk = str;
    }

    public FrsTabSortSwitchButton bSd() {
        return this.his;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSc() {
        an anVar = new an("c11437");
        anVar.af("obj_type", this.his.tR(this.hit));
        anVar.cI("fid", this.eQk);
        TiebaStatic.log(anVar);
    }

    public b(FrsFragment frsFragment, RelativeLayout relativeLayout) {
        this.hit = -1;
        if (frsFragment != null && relativeLayout != null) {
            this.han = frsFragment;
            this.hip = LayoutInflater.from(frsFragment.getContext()).inflate(R.layout.frs_sort_tab_layout, relativeLayout);
            this.hir = (TextView) this.hip.findViewById(R.id.sort_tab_sort_name);
            this.his = (FrsTabSortSwitchButton) this.hip.findViewById(R.id.sort_tab_switch_btn);
            this.his.setOnSwitchChangeListener(this.hiu);
            this.hit = this.his.getState();
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.his != null) {
            this.his.onChangeSkinType();
        }
        am.setViewTextColor(this.hir, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.hip, R.color.cp_bg_line_d);
    }

    public void setData(List<FrsTabInfo> list) {
        if (this.his != null) {
            this.his.setData(list);
        }
    }
}

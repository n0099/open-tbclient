package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsAllThreadFragment extends BaseFragment implements ag {
    private BdSwipeRefreshLayout dyk;
    private String forumId;
    private View fuG;
    private RecyclerView fuH;
    private int tabId;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.tabId = arguments.getInt("tab_id");
        }
        bjx();
        return this.fuG;
    }

    public void setView(View view) {
        this.fuG = view;
        this.fuH = (RecyclerView) this.fuG.findViewById(R.id.frs_lv_thread);
        this.dyk = (BdSwipeRefreshLayout) this.fuG.findViewById(R.id.frs_pull_refresh_layout);
        bjx();
    }

    private void bjx() {
        if (this.fuG != null && (this.fuG.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fuG.getParent()).removeView(this.fuG);
            this.fuG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.fuH != null) {
            this.fuH.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.dyk != null) {
            bjy();
            this.dyk.setRefreshing(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ak(2, "4");
        } else {
            ak(2, "5");
        }
    }

    private void ak(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bS("fid", this.forumId).bS("obj_type", str).O("obj_locate", i).bS("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

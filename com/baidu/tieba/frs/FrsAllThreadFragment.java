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
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsAllThreadFragment extends BaseFragment implements ag {
    private BdSwipeRefreshLayout dpp;
    private String forumId;
    private View ftG;
    private RecyclerView ftH;
    private int tabId;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
        }
        blG();
        return this.ftG;
    }

    public void setView(View view) {
        this.ftG = view;
        this.ftH = (RecyclerView) this.ftG.findViewById(R.id.frs_lv_thread);
        this.dpp = (BdSwipeRefreshLayout) this.ftG.findViewById(R.id.frs_pull_refresh_layout);
        blG();
    }

    private void blG() {
        if (this.ftG != null && (this.ftG.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ftG.getParent()).removeView(this.ftG);
            this.ftG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void blH() {
        if (this.ftH != null) {
            this.ftH.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKj() {
        if (this.dpp != null) {
            blH();
            this.dpp.setRefreshing(true);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bT("fid", this.forumId).bT("obj_type", str).P("obj_locate", i).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

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
    private BdSwipeRefreshLayout dxt;
    private String forumId;
    private View ftP;
    private RecyclerView ftQ;
    private int tabId;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.tabId = arguments.getInt("tab_id");
        }
        bjv();
        return this.ftP;
    }

    public void setView(View view) {
        this.ftP = view;
        this.ftQ = (RecyclerView) this.ftP.findViewById(R.id.frs_lv_thread);
        this.dxt = (BdSwipeRefreshLayout) this.ftP.findViewById(R.id.frs_pull_refresh_layout);
        bjv();
    }

    private void bjv() {
        if (this.ftP != null && (this.ftP.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ftP.getParent()).removeView(this.ftP);
            this.ftP.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjw() {
        if (this.ftQ != null) {
            this.ftQ.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKf() {
        if (this.dxt != null) {
            bjw();
            this.dxt.setRefreshing(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            aj(2, "4");
        } else {
            aj(2, "5");
        }
    }

    private void aj(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bS("fid", this.forumId).bS("obj_type", str).O("obj_locate", i).bS("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

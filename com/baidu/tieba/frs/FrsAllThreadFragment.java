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
    private BdSwipeRefreshLayout dpi;
    private String forumId;
    private View fth;
    private RecyclerView fti;
    private int tabId;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
        }
        blz();
        return this.fth;
    }

    public void setView(View view) {
        this.fth = view;
        this.fti = (RecyclerView) this.fth.findViewById(R.id.frs_lv_thread);
        this.dpi = (BdSwipeRefreshLayout) this.fth.findViewById(R.id.frs_pull_refresh_layout);
        blz();
    }

    private void blz() {
        if (this.fth != null && (this.fth.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fth.getParent()).removeView(this.fth);
            this.fth.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void blA() {
        if (this.fti != null) {
            this.fti.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.dpi != null) {
            blA();
            this.dpi.setRefreshing(true);
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

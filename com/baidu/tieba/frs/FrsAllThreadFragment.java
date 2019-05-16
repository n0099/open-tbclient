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
    private BdSwipeRefreshLayout dnh;
    private View foh;
    private RecyclerView foi;
    private String forumId;
    private int tabId;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
            this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
        }
        bju();
        return this.foh;
    }

    public void setView(View view) {
        this.foh = view;
        this.foi = (RecyclerView) this.foh.findViewById(R.id.frs_lv_thread);
        this.dnh = (BdSwipeRefreshLayout) this.foh.findViewById(R.id.frs_pull_refresh_layout);
        bju();
    }

    private void bju() {
        if (this.foh != null && (this.foh.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.foh.getParent()).removeView(this.foh);
            this.foh.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjv() {
        if (this.foi != null) {
            this.foi.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aID() {
        if (this.dnh != null) {
            bjv();
            this.dnh.setRefreshing(true);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13008").bT("fid", this.forumId).bT("obj_type", str).P("obj_locate", i).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}

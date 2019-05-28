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
    private BdSwipeRefreshLayout dni;
    private View foi;
    private RecyclerView foj;
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
        bjx();
        return this.foi;
    }

    public void setView(View view) {
        this.foi = view;
        this.foj = (RecyclerView) this.foi.findViewById(R.id.frs_lv_thread);
        this.dni = (BdSwipeRefreshLayout) this.foi.findViewById(R.id.frs_pull_refresh_layout);
        bjx();
    }

    private void bjx() {
        if (this.foi != null && (this.foi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.foi.getParent()).removeView(this.foi);
            this.foi.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.foj != null) {
            this.foj.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aIG() {
        if (this.dni != null) {
            bjy();
            this.dni.setRefreshing(true);
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

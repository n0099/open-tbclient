package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FrsAllThreadFragment extends BaseFragment implements ah {
    private BdSwipeRefreshLayout enH;
    private String forumId;
    private View gnO;
    private RecyclerView gnP;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        bDx();
        return this.gnO;
    }

    public void setView(View view) {
        this.gnO = view;
        this.gnP = (RecyclerView) this.gnO.findViewById(R.id.frs_lv_thread);
        this.enH = (BdSwipeRefreshLayout) this.gnO.findViewById(R.id.frs_pull_refresh_layout);
        bDx();
    }

    private void bDx() {
        if (this.gnO != null && (this.gnO.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gnO.getParent()).removeView(this.gnO);
            this.gnO.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gnP != null) {
            this.gnP.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdr() {
        if (this.enH != null) {
            scrollToTop();
            this.enH.setRefreshing(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            aE(2, "4");
        } else {
            aE(2, "5");
        }
    }

    private void aE(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cy("fid", this.forumId).cy("obj_type", str).X("obj_locate", i).cy("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

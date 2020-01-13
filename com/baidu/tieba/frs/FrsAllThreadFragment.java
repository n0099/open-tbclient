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
/* loaded from: classes7.dex */
public class FrsAllThreadFragment extends BaseFragment implements ah {
    private BdSwipeRefreshLayout ejj;
    private String forumId;
    private View gly;
    private RecyclerView glz;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        bBR();
        return this.gly;
    }

    public void setView(View view) {
        this.gly = view;
        this.glz = (RecyclerView) this.gly.findViewById(R.id.frs_lv_thread);
        this.ejj = (BdSwipeRefreshLayout) this.gly.findViewById(R.id.frs_pull_refresh_layout);
        bBR();
    }

    private void bBR() {
        if (this.gly != null && (this.gly.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gly.getParent()).removeView(this.gly);
            this.gly.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.glz != null) {
            this.glz.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baZ() {
        if (this.ejj != null) {
            scrollToTop();
            this.ejj.setRefreshing(true);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cp("fid", this.forumId).cp("obj_type", str).Z("obj_locate", i).cp("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

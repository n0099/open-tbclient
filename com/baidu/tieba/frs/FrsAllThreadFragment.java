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
/* loaded from: classes6.dex */
public class FrsAllThreadFragment extends BaseFragment implements ah {
    private BdSwipeRefreshLayout eiv;
    private String forumId;
    private View gip;
    private RecyclerView giq;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        bAP();
        return this.gip;
    }

    public void setView(View view) {
        this.gip = view;
        this.giq = (RecyclerView) this.gip.findViewById(R.id.frs_lv_thread);
        this.eiv = (BdSwipeRefreshLayout) this.gip.findViewById(R.id.frs_pull_refresh_layout);
        bAP();
    }

    private void bAP() {
        if (this.gip != null && (this.gip.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gip.getParent()).removeView(this.gip);
            this.gip.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.giq != null) {
            this.giq.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baE() {
        if (this.eiv != null) {
            scrollToTop();
            this.eiv.setRefreshing(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ay(2, "4");
        } else {
            ay(2, "5");
        }
    }

    private void ay(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cp("fid", this.forumId).cp("obj_type", str).Z("obj_locate", i).cp("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

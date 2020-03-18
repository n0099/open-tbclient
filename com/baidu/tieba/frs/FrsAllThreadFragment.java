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
public class FrsAllThreadFragment extends BaseFragment implements ai {
    private BdSwipeRefreshLayout enY;
    private String forumId;
    private View goy;
    private RecyclerView goz;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        bDF();
        return this.goy;
    }

    public void setView(View view) {
        this.goy = view;
        this.goz = (RecyclerView) this.goy.findViewById(R.id.frs_lv_thread);
        this.enY = (BdSwipeRefreshLayout) this.goy.findViewById(R.id.frs_pull_refresh_layout);
        bDF();
    }

    private void bDF() {
        if (this.goy != null && (this.goy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.goy.getParent()).removeView(this.goy);
            this.goy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void scrollToTop() {
        if (this.goz != null) {
            this.goz.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void bdw() {
        if (this.enY != null) {
            scrollToTop();
            this.enY.setRefreshing(true);
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cx("fid", this.forumId).cx("obj_type", str).X("obj_locate", i).cx("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

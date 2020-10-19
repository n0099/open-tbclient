package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class FrsAllThreadFragment extends BaseFragment implements as {
    private String forumId;
    private View ioi;
    private RecyclerView ioj;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        csj();
        return this.ioi;
    }

    public void setView(View view) {
        this.ioi = view;
        this.ioj = (RecyclerView) this.ioi.findViewById(R.id.frs_lv_thread);
        csj();
    }

    private void csj() {
        if (this.ioi != null && (this.ioi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ioi.getParent()).removeView(this.ioi);
            this.ioi.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void csk() {
        if (this.ioj != null) {
            this.ioj.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bKT() {
        csk();
        v vVar = new v();
        vVar.tabId = 1;
        vVar.fzJ = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bp(2, "4");
        } else {
            bp(2, "5");
        }
    }

    private void bp(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dK("fid", this.forumId).dK("obj_type", str).aj("obj_locate", i).dK("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

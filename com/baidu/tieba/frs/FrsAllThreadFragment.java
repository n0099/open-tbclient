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
/* loaded from: classes21.dex */
public class FrsAllThreadFragment extends BaseFragment implements as {
    private String forumId;
    private View hZh;
    private RecyclerView hZi;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        coL();
        return this.hZh;
    }

    public void setView(View view) {
        this.hZh = view;
        this.hZi = (RecyclerView) this.hZh.findViewById(R.id.frs_lv_thread);
        coL();
    }

    private void coL() {
        if (this.hZh != null && (this.hZh.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hZh.getParent()).removeView(this.hZh);
            this.hZh.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void coM() {
        if (this.hZi != null) {
            this.hZi.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bIh() {
        coM();
        v vVar = new v();
        vVar.tabId = 1;
        vVar.fnv = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bf(2, "4");
        } else {
            bf(2, "5");
        }
    }

    private void bf(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dF("fid", this.forumId).dF("obj_type", str).ai("obj_locate", i).dF("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

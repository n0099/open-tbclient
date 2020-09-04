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
/* loaded from: classes16.dex */
public class FrsAllThreadFragment extends BaseFragment implements as {
    private String forumId;
    private View hSh;
    private RecyclerView hSi;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        clz();
        return this.hSh;
    }

    public void setView(View view) {
        this.hSh = view;
        this.hSi = (RecyclerView) this.hSh.findViewById(R.id.frs_lv_thread);
        clz();
    }

    private void clz() {
        if (this.hSh != null && (this.hSh.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hSh.getParent()).removeView(this.hSh);
            this.hSh.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void clA() {
        if (this.hSi != null) {
            this.hSi.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bGR() {
        clA();
        v vVar = new v();
        vVar.tabId = 1;
        vVar.fkC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bb(2, "4");
        } else {
            bb(2, "5");
        }
    }

    private void bb(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dD("fid", this.forumId).dD("obj_type", str).ai("obj_locate", i).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

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
    private View iHp;
    private RecyclerView iHq;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        cxu();
        return this.iHp;
    }

    public void setView(View view) {
        this.iHp = view;
        this.iHq = (RecyclerView) this.iHp.findViewById(R.id.frs_lv_thread);
        cxu();
    }

    private void cxu() {
        if (this.iHp != null && (this.iHp.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.iHp.getParent()).removeView(this.iHp);
            this.iHp.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void cxv() {
        if (this.iHq != null) {
            this.iHq.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bPo() {
        cxv();
        v vVar = new v();
        vVar.tabId = 1;
        vVar.fNx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bs(2, "4");
        } else {
            bs(2, "5");
        }
    }

    private void bs(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dR("fid", this.forumId).dR("obj_type", str).ak("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

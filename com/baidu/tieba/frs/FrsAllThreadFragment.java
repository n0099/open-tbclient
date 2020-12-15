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
public class FrsAllThreadFragment extends BaseFragment implements ar {
    private String forumId;
    private View iSj;
    private RecyclerView iSk;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        cBL();
        return this.iSj;
    }

    public void setView(View view) {
        this.iSj = view;
        this.iSk = (RecyclerView) this.iSj.findViewById(R.id.frs_lv_thread);
        cBL();
    }

    private void cBL() {
        if (this.iSj != null && (this.iSj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.iSj.getParent()).removeView(this.iSj);
            this.iSj.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void cBM() {
        if (this.iSk != null) {
            this.iSk.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTa() {
        cBM();
        u uVar = new u();
        uVar.tabId = 1;
        uVar.fVi = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dY("fid", this.forumId).dY("obj_type", str).al("obj_locate", i).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

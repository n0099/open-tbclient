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
    private View iGB;
    private RecyclerView iGC;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        cxR();
        return this.iGB;
    }

    public void setView(View view) {
        this.iGB = view;
        this.iGC = (RecyclerView) this.iGB.findViewById(R.id.frs_lv_thread);
        cxR();
    }

    private void cxR() {
        if (this.iGB != null && (this.iGB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.iGB.getParent()).removeView(this.iGB);
            this.iGB.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void cxS() {
        if (this.iGC != null) {
            this.iGC.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bPV() {
        cxS();
        v vVar = new v();
        vVar.tabId = 1;
        vVar.fNU = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bu(2, "4");
        } else {
            bu(2, "5");
        }
    }

    private void bu(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dR("fid", this.forumId).dR("obj_type", str).al("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

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
public class FrsAllThreadFragment extends BaseFragment implements aq {
    private String forumId;
    private View hEM;
    private RecyclerView hEN;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        cbc();
        return this.hEM;
    }

    public void setView(View view) {
        this.hEM = view;
        this.hEN = (RecyclerView) this.hEM.findViewById(R.id.frs_lv_thread);
        cbc();
    }

    private void cbc() {
        if (this.hEM != null && (this.hEM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hEM.getParent()).removeView(this.hEM);
            this.hEM.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void cbd() {
        if (this.hEN != null) {
            this.hEN.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxR() {
        cbd();
        u uVar = new u();
        uVar.tabId = 1;
        uVar.eZg = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            be(2, "4");
        } else {
            be(2, "5");
        }
    }

    private void be(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13008").dn("fid", this.forumId).dn("obj_type", str).ah("obj_locate", i).dn("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

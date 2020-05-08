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
/* loaded from: classes9.dex */
public class FrsAllThreadFragment extends BaseFragment implements al {
    private String forumId;
    private View gXJ;
    private RecyclerView gXK;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        bOb();
        return this.gXJ;
    }

    public void setView(View view) {
        this.gXJ = view;
        this.gXK = (RecyclerView) this.gXJ.findViewById(R.id.frs_lv_thread);
        bOb();
    }

    private void bOb() {
        if (this.gXJ != null && (this.gXJ.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gXJ.getParent()).removeView(this.gXJ);
            this.gXJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bOc() {
        if (this.gXK != null) {
            this.gXK.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bml() {
        bOc();
        s sVar = new s();
        sVar.tabId = 1;
        sVar.etP = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            aT(2, "4");
        } else {
            aT(2, "5");
        }
    }

    private void aT(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cI("fid", this.forumId).cI("obj_type", str).af("obj_locate", i).cI("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

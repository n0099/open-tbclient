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
    private View hmv;
    private RecyclerView hmw;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        bUx();
        return this.hmv;
    }

    public void setView(View view) {
        this.hmv = view;
        this.hmw = (RecyclerView) this.hmv.findViewById(R.id.frs_lv_thread);
        bUx();
    }

    private void bUx() {
        if (this.hmv != null && (this.hmv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hmv.getParent()).removeView(this.hmv);
            this.hmv.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bUy() {
        if (this.hmw != null) {
            this.hmw.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void brJ() {
        bUy();
        s sVar = new s();
        sVar.tabId = 1;
        sVar.eIo = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            aY(2, "4");
        } else {
            aY(2, "5");
        }
    }

    private void aY(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").dh("fid", this.forumId).dh("obj_type", str).ag("obj_locate", i).dh("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

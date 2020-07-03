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
public class FrsAllThreadFragment extends BaseFragment implements aq {
    private String forumId;
    private View hyX;
    private RecyclerView hyY;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        bXF();
        return this.hyX;
    }

    public void setView(View view) {
        this.hyX = view;
        this.hyY = (RecyclerView) this.hyX.findViewById(R.id.frs_lv_thread);
        bXF();
    }

    private void bXF() {
        if (this.hyX != null && (this.hyX.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.hyX.getParent()).removeView(this.hyX);
            this.hyX.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bXG() {
        if (this.hyY != null) {
            this.hyY.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void buH() {
        bXG();
        u uVar = new u();
        uVar.tabId = 1;
        uVar.eSL = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bc(2, "4");
        } else {
            bc(2, "5");
        }
    }

    private void bc(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13008").dk("fid", this.forumId).dk("obj_type", str).ag("obj_locate", i).dk("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

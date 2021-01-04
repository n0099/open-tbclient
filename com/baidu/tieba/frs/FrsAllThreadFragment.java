package com.baidu.tieba.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsAllThreadFragment extends BaseFragment implements ao {
    private String forumId;
    private View jev;
    private RecyclerView jew;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        cEE();
        return this.jev;
    }

    public void setView(View view) {
        this.jev = view;
        this.jew = (RecyclerView) this.jev.findViewById(R.id.frs_lv_thread);
        cEE();
    }

    private void cEE() {
        if (this.jev != null && (this.jev.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.jev.getParent()).removeView(this.jev);
            this.jev.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cEF() {
        if (this.jew != null) {
            this.jew.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bVE() {
        cEF();
        t tVar = new t();
        tVar.tabId = 1;
        tVar.geO = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dX("fid", this.forumId).dX("obj_type", str).an("obj_locate", i).dX("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

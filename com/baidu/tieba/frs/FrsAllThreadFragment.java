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
    private View iZO;
    private RecyclerView iZP;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        cAN();
        return this.iZO;
    }

    public void setView(View view) {
        this.iZO = view;
        this.iZP = (RecyclerView) this.iZO.findViewById(R.id.frs_lv_thread);
        cAN();
    }

    private void cAN() {
        if (this.iZO != null && (this.iZO.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.iZO.getParent()).removeView(this.iZO);
            this.iZO.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cAO() {
        if (this.iZP != null) {
            this.iZP.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bRN() {
        cAO();
        t tVar = new t();
        tVar.tabId = 1;
        tVar.gae = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bv(2, "4");
        } else {
            bv(2, "5");
        }
    }

    private void bv(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dW("fid", this.forumId).dW("obj_type", str).an("obj_locate", i).dW("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

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
    private View jfI;
    private RecyclerView jfJ;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.forumId = arguments.getString("forum_id", "");
        }
        cCf();
        return this.jfI;
    }

    public void setView(View view) {
        this.jfI = view;
        this.jfJ = (RecyclerView) this.jfI.findViewById(R.id.frs_lv_thread);
        cCf();
    }

    private void cCf() {
        if (this.jfI != null && (this.jfI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.jfI.getParent()).removeView(this.jfI);
            this.jfI.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCg() {
        if (this.jfJ != null) {
            this.jfJ.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSx() {
        cCg();
        t tVar = new t();
        tVar.tabId = 1;
        tVar.gcC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            bA(2, "4");
        } else {
            bA(2, "5");
        }
    }

    private void bA(int i, String str) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dR("fid", this.forumId).dR("obj_type", str).ap("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageExtra.c getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.pageExtra.c(getUniqueId(), PageStayDurationConstants.PageName.FRS, baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }
}

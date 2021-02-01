package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes2.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c iIB;
    private RecommendModel iLH;
    private RecommendView iLI;
    private boolean iLJ;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iLI == null) {
            this.iLI = new RecommendView(getPageContext());
            this.iLI.setTabViewController(this.iIB);
            this.iLI.setPresenter(this);
            this.iLI.setListPullRefreshListener(this);
            this.iLI.setPageUniqueId(getUniqueId());
        }
        if (this.iLI.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iLI.getParent()).removeView(this.iLI);
        }
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        return this.iLI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iLH == null) {
            this.iLH = new RecommendModel(getPageContext());
            this.iLH.setPresenter(this);
            this.iLH.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.iLJ && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iLI.ir(false);
            this.iLH.cwQ();
            this.iLJ = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iLH != null) {
            this.iLH.cwQ();
        }
        com.baidu.tieba.s.c.dMr().D(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iLI.WZ();
            this.iLI.ir(false);
            this.iLH.cwQ();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.iLI.hideLoadingView();
        this.iLI.bRB();
        if (i != 0 || aVar == null) {
            this.iLI.qa(false);
            return;
        }
        this.iLI.WZ();
        this.iLI.bYh();
        this.iLI.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iLI != null) {
            this.iLI.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.iIB = null;
        this.iLI.onDestroy();
        this.iLH.onDestroy();
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.iLJ) {
                loadData();
                this.iLJ = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes9.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c hcp;
    private RecommendModel hfH;
    private RecommendView hfI;
    private boolean hfJ;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hfI == null) {
            this.hfI = new RecommendView(getPageContext());
            this.hfI.setTabViewController(this.hcp);
            this.hfI.setPresenter(this);
            this.hfI.setListPullRefreshListener(this);
            this.hfI.setPageUniqueId(getUniqueId());
        }
        if (this.hfI.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hfI.getParent()).removeView(this.hfI);
        }
        com.baidu.tieba.s.c.dgY().z(getUniqueId());
        return this.hfI;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hfH == null) {
            this.hfH = new RecommendModel(getPageContext());
            this.hfH.setPresenter(this);
            this.hfH.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.hfJ && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hfI.ga(false);
            this.hfH.bSJ();
            this.hfJ = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.hfH != null) {
            this.hfH.bSJ();
        }
        com.baidu.tieba.s.c.dgY().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hfI.btO();
            this.hfI.ga(false);
            this.hfH.bSJ();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.hfI.hideLoadingView();
        this.hfI.btV();
        if (i != 0 || aVar == null) {
            this.hfI.mB(false);
            return;
        }
        this.hfI.btO();
        this.hfI.byK();
        this.hfI.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hfI != null) {
            this.hfI.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.hcp = null;
        this.hfI.onDestroy();
        this.hfH.onDestroy();
        com.baidu.tieba.s.c.dgY().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.hfJ) {
                loadData();
                this.hfJ = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dgY().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes9.dex */
public class RecommendFragment extends BaseFragment implements g.c, a {
    private c fVc;
    private RecommendModel fWN;
    private RecommendView fWO;
    private boolean fWP;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fWO == null) {
            this.fWO = new RecommendView(getPageContext());
            this.fWO.setTabViewController(this.fVc);
            this.fWO.setPresenter(this);
            this.fWO.setListPullRefreshListener(this);
            this.fWO.setPageUniqueId(getUniqueId());
        }
        if (this.fWO.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fWO.getParent()).removeView(this.fWO);
        }
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
        return this.fWO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fWN == null) {
            this.fWN = new RecommendModel(getPageContext());
            this.fWN.setPresenter(this);
            this.fWN.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fWP && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fWO.eM(false);
            this.fWN.bzd();
            this.fWP = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.fWN != null) {
            this.fWN.bzd();
        }
        com.baidu.tieba.s.c.cKb().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fWO.bcy();
            this.fWO.eM(false);
            this.fWN.bzd();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fWO.hideLoadingView();
        this.fWO.bcE();
        if (i != 0 || aVar == null) {
            this.fWO.kN(false);
            return;
        }
        this.fWO.bcy();
        this.fWO.bgz();
        this.fWO.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fWO != null) {
            this.fWO.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.fVc = null;
        this.fWO.onDestroy();
        this.fWN.onDestroy();
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fWP) {
                loadData();
                this.fWP = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.fVc = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

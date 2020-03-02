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
    private c fUP;
    private RecommendModel fWA;
    private RecommendView fWB;
    private boolean fWC;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fWB == null) {
            this.fWB = new RecommendView(getPageContext());
            this.fWB.setTabViewController(this.fUP);
            this.fWB.setPresenter(this);
            this.fWB.setListPullRefreshListener(this);
            this.fWB.setPageUniqueId(getUniqueId());
        }
        if (this.fWB.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fWB.getParent()).removeView(this.fWB);
        }
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
        return this.fWB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fWA == null) {
            this.fWA = new RecommendModel(getPageContext());
            this.fWA.setPresenter(this);
            this.fWA.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fWC && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fWB.eM(false);
            this.fWA.bzc();
            this.fWC = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.fWA != null) {
            this.fWA.bzc();
        }
        com.baidu.tieba.s.c.cKa().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fWB.bcx();
            this.fWB.eM(false);
            this.fWA.bzc();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fWB.hideLoadingView();
        this.fWB.bcD();
        if (i != 0 || aVar == null) {
            this.fWB.kN(false);
            return;
        }
        this.fWB.bcx();
        this.fWB.bgy();
        this.fWB.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fWB != null) {
            this.fWB.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.fUP = null;
        this.fWB.onDestroy();
        this.fWA.onDestroy();
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fWC) {
                loadData();
                this.fWC = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.cKa().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.fUP = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

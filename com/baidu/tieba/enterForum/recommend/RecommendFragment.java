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
    private c fUN;
    private boolean fWA;
    private RecommendModel fWy;
    private RecommendView fWz;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fWz == null) {
            this.fWz = new RecommendView(getPageContext());
            this.fWz.setTabViewController(this.fUN);
            this.fWz.setPresenter(this);
            this.fWz.setListPullRefreshListener(this);
            this.fWz.setPageUniqueId(getUniqueId());
        }
        if (this.fWz.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fWz.getParent()).removeView(this.fWz);
        }
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
        return this.fWz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fWy == null) {
            this.fWy = new RecommendModel(getPageContext());
            this.fWy.setPresenter(this);
            this.fWy.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fWA && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fWz.eM(false);
            this.fWy.bza();
            this.fWA = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.fWy != null) {
            this.fWy.bza();
        }
        com.baidu.tieba.s.c.cJY().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fWz.bcv();
            this.fWz.eM(false);
            this.fWy.bza();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fWz.hideLoadingView();
        this.fWz.bcB();
        if (i != 0 || aVar == null) {
            this.fWz.kN(false);
            return;
        }
        this.fWz.bcv();
        this.fWz.bgw();
        this.fWz.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fWz != null) {
            this.fWz.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.fUN = null;
        this.fWz.onDestroy();
        this.fWy.onDestroy();
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fWA) {
                loadData();
                this.fWA = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.cJY().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.fUN = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

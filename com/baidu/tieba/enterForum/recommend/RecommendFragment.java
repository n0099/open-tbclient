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
/* loaded from: classes22.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c hRe;
    private RecommendModel hUl;
    private RecommendView hUm;
    private boolean hUn;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hUm == null) {
            this.hUm = new RecommendView(getPageContext());
            this.hUm.setTabViewController(this.hRe);
            this.hUm.setPresenter(this);
            this.hUm.setListPullRefreshListener(this);
            this.hUm.setPageUniqueId(getUniqueId());
        }
        if (this.hUm.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hUm.getParent()).removeView(this.hUm);
        }
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        return this.hUm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hUl == null) {
            this.hUl = new RecommendModel(getPageContext());
            this.hUl.setPresenter(this);
            this.hUl.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.hUn && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hUm.hn(false);
            this.hUl.cnb();
            this.hUn = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.hUl != null) {
            this.hUl.cnb();
        }
        com.baidu.tieba.s.c.dDn().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hUm.SK();
            this.hUm.hn(false);
            this.hUl.cnb();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.hUm.hideLoadingView();
        this.hUm.bKf();
        if (i != 0 || aVar == null) {
            this.hUm.ox(false);
            return;
        }
        this.hUm.SK();
        this.hUm.bPU();
        this.hUm.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hUm != null) {
            this.hUm.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.hRe = null;
        this.hUm.onDestroy();
        this.hUl.onDestroy();
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.hUn) {
                loadData();
                this.hUn = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

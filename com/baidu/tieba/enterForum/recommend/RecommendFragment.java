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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements h.c, a {
    private c faE;
    private RecommendModel fcK;
    private RecommendView fcL;
    private boolean fcM;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fcL == null) {
            this.fcL = new RecommendView(getPageContext());
            this.fcL.setTabViewController(this.faE);
            this.fcL.setPresenter(this);
            this.fcL.setListPullRefreshListener(this);
            this.fcL.setPageUniqueId(getUniqueId());
        }
        if (this.fcL.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fcL.getParent()).removeView(this.fcL);
        }
        com.baidu.tieba.q.c.cni().v(getUniqueId());
        return this.fcL;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fcK == null) {
            this.fcK = new RecommendModel(getPageContext());
            this.fcK.setPresenter(this);
            this.fcK.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fcM && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fcL.dp(false);
            this.fcK.bfc();
            this.fcM = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        if (this.fcK != null) {
            this.fcK.bfc();
        }
        com.baidu.tieba.q.c.cni().y(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fcL.aJm();
            this.fcL.dp(false);
            this.fcK.bfc();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fcL.hideLoadingView();
        this.fcL.aJF();
        if (i != 0 || aVar == null) {
            this.fcL.jm(false);
            return;
        }
        this.fcL.aJm();
        this.fcL.aMo();
        this.fcL.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fcL != null) {
            this.fcL.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.faE = null;
        this.fcL.onDestroy();
        this.fcK.onDestroy();
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fcM) {
                loadData();
                this.fcM = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.q.c.cni().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.faE = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

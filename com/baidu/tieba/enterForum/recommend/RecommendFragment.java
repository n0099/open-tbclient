package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements h.c, a {
    private c eRT;
    private RecommendModel eTU;
    private RecommendView eTV;
    private boolean eTW;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eTV == null) {
            this.eTV = new RecommendView(getPageContext());
            this.eTV.setTabViewController(this.eRT);
            this.eTV.setPresenter(this);
            this.eTV.setListPullRefreshListener(this);
            this.eTV.setPageUniqueId(getUniqueId());
        }
        if (this.eTV.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eTV.getParent()).removeView(this.eTV);
        }
        com.baidu.tieba.q.c.clt().u(getUniqueId());
        return this.eTV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eTU == null) {
            this.eTU = new RecommendModel(getPageContext());
            this.eTU.setPresenter(this);
            this.eTU.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eTW) {
            this.eTV.cV(false);
            this.eTU.bev();
            this.eTW = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (this.eTU != null) {
            this.eTU.bev();
        }
        com.baidu.tieba.q.c.clt().x(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.jS()) {
            this.eTV.aHH();
            this.eTV.cV(false);
            this.eTU.bev();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eTV.hideLoadingView();
        this.eTV.aHZ();
        if (i != 0 || aVar == null) {
            this.eTV.jk(false);
            return;
        }
        this.eTV.aHH();
        this.eTV.aUE();
        this.eTV.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eTV != null) {
            this.eTV.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eRT = null;
        this.eTV.onDestroy();
        this.eTU.onDestroy();
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.q.c.clt().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.eRT = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }
}

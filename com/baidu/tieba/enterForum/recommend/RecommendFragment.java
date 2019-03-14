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
    private c eCs;
    private RecommendModel eEo;
    private RecommendView eEp;
    private boolean eEq;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eEp == null) {
            this.eEp = new RecommendView(getPageContext());
            this.eEp.setTabViewController(this.eCs);
            this.eEp.setPresenter(this);
            this.eEp.setListPullRefreshListener(this);
            this.eEp.setPageUniqueId(getUniqueId());
        }
        if (this.eEp.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eEp.getParent()).removeView(this.eEp);
        }
        return this.eEp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eEo == null) {
            this.eEo = new RecommendModel(getPageContext());
            this.eEo.setPresenter(this);
            this.eEo.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eEq) {
            this.eEp.cE(false);
            this.eEo.aXj();
            this.eEq = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (this.eEo != null) {
            this.eEo.aXj();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.kY()) {
            this.eEp.aBt();
            this.eEp.cE(false);
            this.eEo.aXj();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eEp.hideLoadingView();
        this.eEp.aBM();
        if (i != 0 || aVar == null) {
            this.eEp.iD(false);
            return;
        }
        this.eEp.aBt();
        this.eEp.aOA();
        this.eEp.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eEp != null) {
            this.eEp.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eCs = null;
        this.eEp.onDestroy();
        this.eEo.onDestroy();
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        }
    }

    public void setTabViewController(c cVar) {
        this.eCs = cVar;
    }
}

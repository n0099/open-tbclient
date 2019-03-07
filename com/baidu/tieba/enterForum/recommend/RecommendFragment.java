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
    private c eCw;
    private RecommendModel eEs;
    private RecommendView eEt;
    private boolean eEu;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eEt == null) {
            this.eEt = new RecommendView(getPageContext());
            this.eEt.setTabViewController(this.eCw);
            this.eEt.setPresenter(this);
            this.eEt.setListPullRefreshListener(this);
            this.eEt.setPageUniqueId(getUniqueId());
        }
        if (this.eEt.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eEt.getParent()).removeView(this.eEt);
        }
        return this.eEt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eEs == null) {
            this.eEs = new RecommendModel(getPageContext());
            this.eEs.setPresenter(this);
            this.eEs.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eEu) {
            this.eEt.cE(false);
            this.eEs.aXj();
            this.eEu = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (this.eEs != null) {
            this.eEs.aXj();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.kY()) {
            this.eEt.aBt();
            this.eEt.cE(false);
            this.eEs.aXj();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eEt.hideLoadingView();
        this.eEt.aBM();
        if (i != 0 || aVar == null) {
            this.eEt.iD(false);
            return;
        }
        this.eEt.aBt();
        this.eEt.aOA();
        this.eEt.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eEt != null) {
            this.eEt.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eCw = null;
        this.eEt.onDestroy();
        this.eEs.onDestroy();
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
        this.eCw = cVar;
    }
}

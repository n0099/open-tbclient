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
    private c eCe;
    private RecommendModel eEa;
    private RecommendView eEb;
    private boolean eEc;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eEb == null) {
            this.eEb = new RecommendView(getPageContext());
            this.eEb.setTabViewController(this.eCe);
            this.eEb.setPresenter(this);
            this.eEb.setListPullRefreshListener(this);
            this.eEb.setPageUniqueId(getUniqueId());
        }
        if (this.eEb.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eEb.getParent()).removeView(this.eEb);
        }
        return this.eEb;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eEa == null) {
            this.eEa = new RecommendModel(getPageContext());
            this.eEa.setPresenter(this);
            this.eEa.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eEc) {
            this.eEb.cE(false);
            this.eEa.aXh();
            this.eEc = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (this.eEa != null) {
            this.eEa.aXh();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.kY()) {
            this.eEb.aBq();
            this.eEb.cE(false);
            this.eEa.aXh();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eEb.hideLoadingView();
        this.eEb.aBJ();
        if (i != 0 || aVar == null) {
            this.eEb.iD(false);
            return;
        }
        this.eEb.aBq();
        this.eEb.aOs();
        this.eEb.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eEb != null) {
            this.eEb.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eCe = null;
        this.eEb.onDestroy();
        this.eEa.onDestroy();
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
        this.eCe = cVar;
    }
}

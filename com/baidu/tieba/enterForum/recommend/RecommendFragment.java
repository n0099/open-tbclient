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
    private c eCd;
    private RecommendModel eDZ;
    private RecommendView eEa;
    private boolean eEb;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eEa == null) {
            this.eEa = new RecommendView(getPageContext());
            this.eEa.setTabViewController(this.eCd);
            this.eEa.setPresenter(this);
            this.eEa.setListPullRefreshListener(this);
            this.eEa.setPageUniqueId(getUniqueId());
        }
        if (this.eEa.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eEa.getParent()).removeView(this.eEa);
        }
        return this.eEa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eDZ == null) {
            this.eDZ = new RecommendModel(getPageContext());
            this.eDZ.setPresenter(this);
            this.eDZ.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eEb) {
            this.eEa.cE(false);
            this.eDZ.aXh();
            this.eEb = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (this.eDZ != null) {
            this.eDZ.aXh();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.kY()) {
            this.eEa.aBq();
            this.eEa.cE(false);
            this.eDZ.aXh();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eEa.hideLoadingView();
        this.eEa.aBJ();
        if (i != 0 || aVar == null) {
            this.eEa.iD(false);
            return;
        }
        this.eEa.aBq();
        this.eEa.aOs();
        this.eEa.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eEa != null) {
            this.eEa.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eCd = null;
        this.eEa.onDestroy();
        this.eDZ.onDestroy();
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
        this.eCd = cVar;
    }
}

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements h.c, a {
    private c eRU;
    private RecommendModel eTV;
    private RecommendView eTW;
    private boolean eTX;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eTW == null) {
            this.eTW = new RecommendView(getPageContext());
            this.eTW.setTabViewController(this.eRU);
            this.eTW.setPresenter(this);
            this.eTW.setListPullRefreshListener(this);
            this.eTW.setPageUniqueId(getUniqueId());
        }
        if (this.eTW.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eTW.getParent()).removeView(this.eTW);
        }
        com.baidu.tieba.q.c.clv().u(getUniqueId());
        return this.eTW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eTV == null) {
            this.eTV = new RecommendModel(getPageContext());
            this.eTV.setPresenter(this);
            this.eTV.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eTX && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.eTW.cV(false);
            this.eTV.bey();
            this.eTX = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (this.eTV != null) {
            this.eTV.bey();
        }
        com.baidu.tieba.q.c.clv().x(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.jS()) {
            this.eTW.aHK();
            this.eTW.cV(false);
            this.eTV.bey();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eTW.hideLoadingView();
        this.eTW.aIc();
        if (i != 0 || aVar == null) {
            this.eTW.jk(false);
            return;
        }
        this.eTW.aHK();
        this.eTW.aUH();
        this.eTW.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eTW != null) {
            this.eTW.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eRU = null;
        this.eTW.onDestroy();
        this.eTV.onDestroy();
        com.baidu.tieba.q.c.clv().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.eTX) {
                loadData();
                this.eTX = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.q.c.clv().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.eRU = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }
}

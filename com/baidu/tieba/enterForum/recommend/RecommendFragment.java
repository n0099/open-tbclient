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
    private c fVL;
    private RecommendModel fXv;
    private RecommendView fXw;
    private boolean fXx;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fXw == null) {
            this.fXw = new RecommendView(getPageContext());
            this.fXw.setTabViewController(this.fVL);
            this.fXw.setPresenter(this);
            this.fXw.setListPullRefreshListener(this);
            this.fXw.setPageUniqueId(getUniqueId());
        }
        if (this.fXw.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fXw.getParent()).removeView(this.fXw);
        }
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        return this.fXw;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fXv == null) {
            this.fXv = new RecommendModel(getPageContext());
            this.fXv.setPresenter(this);
            this.fXv.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fXx && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fXw.eN(false);
            this.fXv.bzj();
            this.fXx = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.fXv != null) {
            this.fXv.bzj();
        }
        com.baidu.tieba.s.c.cKv().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fXw.bcC();
            this.fXw.eN(false);
            this.fXv.bzj();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fXw.hideLoadingView();
        this.fXw.bcI();
        if (i != 0 || aVar == null) {
            this.fXw.kS(false);
            return;
        }
        this.fXw.bcC();
        this.fXw.bgE();
        this.fXw.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fXw != null) {
            this.fXw.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.fVL = null;
        this.fXw.onDestroy();
        this.fXv.onDestroy();
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fXx) {
                loadData();
                this.fXx = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.fVL = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

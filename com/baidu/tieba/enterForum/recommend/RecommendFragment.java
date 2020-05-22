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
/* loaded from: classes9.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c gPv;
    private RecommendModel gSN;
    private RecommendView gSO;
    private boolean gSP;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.gSO == null) {
            this.gSO = new RecommendView(getPageContext());
            this.gSO.setTabViewController(this.gPv);
            this.gSO.setPresenter(this);
            this.gSO.setListPullRefreshListener(this);
            this.gSO.setPageUniqueId(getUniqueId());
        }
        if (this.gSO.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gSO.getParent()).removeView(this.gSO);
        }
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        return this.gSO;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gSN == null) {
            this.gSN = new RecommendModel(getPageContext());
            this.gSN.setPresenter(this);
            this.gSN.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.gSP && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gSO.fV(false);
            this.gSN.bPD();
            this.gSP = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.gSN != null) {
            this.gSN.bPD();
        }
        com.baidu.tieba.s.c.dct().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.gSO.bqO();
            this.gSO.fV(false);
            this.gSN.bPD();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.gSO.hideLoadingView();
        this.gSO.bqV();
        if (i != 0 || aVar == null) {
            this.gSO.mq(false);
            return;
        }
        this.gSO.bqO();
        this.gSO.bvM();
        this.gSO.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gSO != null) {
            this.gSO.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.gPv = null;
        this.gSO.onDestroy();
        this.gSN.onDestroy();
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.gSP) {
                loadData();
                this.gSP = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

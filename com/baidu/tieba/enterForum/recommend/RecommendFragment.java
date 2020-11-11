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
    private c ijC;
    private RecommendModel imJ;
    private RecommendView imK;
    private boolean imL;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.imK == null) {
            this.imK = new RecommendView(getPageContext());
            this.imK.setTabViewController(this.ijC);
            this.imK.setPresenter(this);
            this.imK.setListPullRefreshListener(this);
            this.imK.setPageUniqueId(getUniqueId());
        }
        if (this.imK.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.imK.getParent()).removeView(this.imK);
        }
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        return this.imK;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.imJ == null) {
            this.imJ = new RecommendModel(getPageContext());
            this.imJ.setPresenter(this);
            this.imJ.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.imL && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.imK.hJ(false);
            this.imJ.csJ();
            this.imL = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.imJ != null) {
            this.imJ.csJ();
        }
        com.baidu.tieba.s.c.dIX().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.imK.Wk();
            this.imK.hJ(false);
            this.imJ.csJ();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.imK.hideLoadingView();
        this.imK.bPh();
        if (i != 0 || aVar == null) {
            this.imK.oY(false);
            return;
        }
        this.imK.Wk();
        this.imK.bVq();
        this.imK.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.imK != null) {
            this.imK.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.ijC = null;
        this.imK.onDestroy();
        this.imJ.onDestroy();
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.imL) {
                loadData();
                this.imL = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

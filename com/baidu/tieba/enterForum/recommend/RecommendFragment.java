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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes7.dex */
public class RecommendFragment extends BaseFragment implements g.c, a {
    private c fSt;
    private RecommendModel fUx;
    private RecommendView fUy;
    private boolean fUz;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fUy == null) {
            this.fUy = new RecommendView(getPageContext());
            this.fUy.setTabViewController(this.fSt);
            this.fUy.setPresenter(this);
            this.fUy.setListPullRefreshListener(this);
            this.fUy.setPageUniqueId(getUniqueId());
        }
        if (this.fUy.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fUy.getParent()).removeView(this.fUy);
        }
        com.baidu.tieba.r.c.cIs().w(getUniqueId());
        return this.fUy;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fUx == null) {
            this.fUx = new RecommendModel(getPageContext());
            this.fUx.setPresenter(this);
            this.fUx.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fUz && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fUy.eF(false);
            this.fUx.bxy();
            this.fUz = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.fUx != null) {
            this.fUx.bxy();
        }
        com.baidu.tieba.r.c.cIs().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fUy.baf();
            this.fUy.eF(false);
            this.fUx.bxy();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fUy.hideLoadingView();
        this.fUy.bam();
        if (i != 0 || aVar == null) {
            this.fUy.kJ(false);
            return;
        }
        this.fUy.baf();
        this.fUy.bem();
        this.fUy.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fUy != null) {
            this.fUy.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.fSt = null;
        this.fUy.onDestroy();
        this.fUx.onDestroy();
        com.baidu.tieba.r.c.cIs().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isPrimary()) {
            if (TbSingleton.getInstance().isShowNewYearSkin() && UtilHelper.canUseStyleImmersiveSticky()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fUz) {
                loadData();
                this.fUz = true;
                return;
            }
            return;
        }
        if (TbSingleton.getInstance().isShowNewYearSkin() && UtilHelper.canUseStyleImmersiveSticky()) {
            if (TbadkCoreApplication.getInst().getSkinType() != 4 && TbadkCoreApplication.getInst().getSkinType() != 1) {
                z = false;
            }
            UtilHelper.changeStatusBarIconAndTextColor(z, getActivity());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.r.c.cIs().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.fSt = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

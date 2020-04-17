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
    private c gAF;
    private RecommendModel gDZ;
    private RecommendView gEa;
    private boolean gEb;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.gEa == null) {
            this.gEa = new RecommendView(getPageContext());
            this.gEa.setTabViewController(this.gAF);
            this.gEa.setPresenter(this);
            this.gEa.setListPullRefreshListener(this);
            this.gEa.setPageUniqueId(getUniqueId());
        }
        if (this.gEa.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gEa.getParent()).removeView(this.gEa);
        }
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        return this.gEa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gDZ == null) {
            this.gDZ = new RecommendModel(getPageContext());
            this.gDZ.setPresenter(this);
            this.gDZ.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.gEb && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gEa.fK(false);
            this.gDZ.bJl();
            this.gEb = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.gDZ != null) {
            this.gDZ.bJl();
        }
        com.baidu.tieba.s.c.cVr().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.gEa.blt();
            this.gEa.fK(false);
            this.gDZ.bJl();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.gEa.hideLoadingView();
        this.gEa.blz();
        if (i != 0 || aVar == null) {
            this.gEa.lV(false);
            return;
        }
        this.gEa.blt();
        this.gEa.bpV();
        this.gEa.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gEa != null) {
            this.gEa.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.gAF = null;
        this.gEa.onDestroy();
        this.gDZ.onDestroy();
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.gEb) {
                loadData();
                this.gEb = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

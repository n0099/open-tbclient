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
/* loaded from: classes16.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c hhY;
    private RecommendModel hlr;
    private RecommendView hls;
    private boolean hlt;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hls == null) {
            this.hls = new RecommendView(getPageContext());
            this.hls.setTabViewController(this.hhY);
            this.hls.setPresenter(this);
            this.hls.setListPullRefreshListener(this);
            this.hls.setPageUniqueId(getUniqueId());
        }
        if (this.hls.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hls.getParent()).removeView(this.hls);
        }
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        return this.hls;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hlr == null) {
            this.hlr = new RecommendModel(getPageContext());
            this.hlr.setPresenter(this);
            this.hlr.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.hlt && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hls.gw(false);
            this.hlr.bWa();
            this.hlt = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.hlr != null) {
            this.hlr.bWa();
        }
        com.baidu.tieba.s.c.dkh().D(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hls.bwX();
            this.hls.gw(false);
            this.hlr.bWa();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.hls.hideLoadingView();
        this.hls.bxe();
        if (i != 0 || aVar == null) {
            this.hls.ng(false);
            return;
        }
        this.hls.bwX();
        this.hls.bBY();
        this.hls.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hls != null) {
            this.hls.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.hhY = null;
        this.hls.onDestroy();
        this.hlr.onDestroy();
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.hlt) {
                loadData();
                this.hlt = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

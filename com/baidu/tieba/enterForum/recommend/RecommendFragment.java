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
    private c huY;
    private RecommendModel hyi;
    private RecommendView hyj;
    private boolean hyk;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hyj == null) {
            this.hyj = new RecommendView(getPageContext());
            this.hyj.setTabViewController(this.huY);
            this.hyj.setPresenter(this);
            this.hyj.setListPullRefreshListener(this);
            this.hyj.setPageUniqueId(getUniqueId());
        }
        if (this.hyj.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hyj.getParent()).removeView(this.hyj);
        }
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
        return this.hyj;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hyi == null) {
            this.hyi = new RecommendModel(getPageContext());
            this.hyi.setPresenter(this);
            this.hyi.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.hyk && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hyj.gS(false);
            this.hyi.cgn();
            this.hyk = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.hyi != null) {
            this.hyi.cgn();
        }
        com.baidu.tieba.s.c.dvE().D(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hyj.bFW();
            this.hyj.gS(false);
            this.hyi.cgn();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.hyj.hideLoadingView();
        this.hyj.bGd();
        if (i != 0 || aVar == null) {
            this.hyj.nK(false);
            return;
        }
        this.hyj.bFW();
        this.hyj.bLs();
        this.hyj.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hyj != null) {
            this.hyj.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.huY = null;
        this.hyj.onDestroy();
        this.hyi.onDestroy();
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.hyk) {
                loadData();
                this.hyk = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

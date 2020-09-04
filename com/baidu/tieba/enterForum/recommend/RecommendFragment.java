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
    private c hve;
    private RecommendModel hyo;
    private RecommendView hyp;
    private boolean hyq;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hyp == null) {
            this.hyp = new RecommendView(getPageContext());
            this.hyp.setTabViewController(this.hve);
            this.hyp.setPresenter(this);
            this.hyp.setListPullRefreshListener(this);
            this.hyp.setPageUniqueId(getUniqueId());
        }
        if (this.hyp.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hyp.getParent()).removeView(this.hyp);
        }
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
        return this.hyp;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hyo == null) {
            this.hyo = new RecommendModel(getPageContext());
            this.hyo.setPresenter(this);
            this.hyo.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.hyq && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hyp.gT(false);
            this.hyo.cgo();
            this.hyq = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.hyo != null) {
            this.hyo.cgo();
        }
        com.baidu.tieba.s.c.dvJ().D(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hyp.bFX();
            this.hyp.gT(false);
            this.hyo.cgo();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.hyp.hideLoadingView();
        this.hyp.bGe();
        if (i != 0 || aVar == null) {
            this.hyp.nM(false);
            return;
        }
        this.hyp.bFX();
        this.hyp.bLt();
        this.hyp.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hyp != null) {
            this.hyp.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.hve = null;
        this.hyp.onDestroy();
        this.hyo.onDestroy();
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.hyq) {
                loadData();
                this.hyq = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

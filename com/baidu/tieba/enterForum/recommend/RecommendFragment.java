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
    private c gAL;
    private RecommendModel gEf;
    private RecommendView gEg;
    private boolean gEh;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.gEg == null) {
            this.gEg = new RecommendView(getPageContext());
            this.gEg.setTabViewController(this.gAL);
            this.gEg.setPresenter(this);
            this.gEg.setListPullRefreshListener(this);
            this.gEg.setPageUniqueId(getUniqueId());
        }
        if (this.gEg.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gEg.getParent()).removeView(this.gEg);
        }
        com.baidu.tieba.s.c.cVo().w(getUniqueId());
        return this.gEg;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gEf == null) {
            this.gEf = new RecommendModel(getPageContext());
            this.gEf.setPresenter(this);
            this.gEf.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.gEh && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gEg.fK(false);
            this.gEf.bJj();
            this.gEh = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.gEf != null) {
            this.gEf.bJj();
        }
        com.baidu.tieba.s.c.cVo().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.gEg.blr();
            this.gEg.fK(false);
            this.gEf.bJj();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.gEg.hideLoadingView();
        this.gEg.blx();
        if (i != 0 || aVar == null) {
            this.gEg.lV(false);
            return;
        }
        this.gEg.blr();
        this.gEg.bpT();
        this.gEg.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gEg != null) {
            this.gEg.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.gAL = null;
        this.gEg.onDestroy();
        this.gEf.onDestroy();
        com.baidu.tieba.s.c.cVo().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.gEh) {
                loadData();
                this.gEh = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.cVo().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

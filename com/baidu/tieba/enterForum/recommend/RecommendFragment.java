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
    private c ivl;
    private RecommendModel iys;
    private RecommendView iyt;
    private boolean iyu;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iyt == null) {
            this.iyt = new RecommendView(getPageContext());
            this.iyt.setTabViewController(this.ivl);
            this.iyt.setPresenter(this);
            this.iyt.setListPullRefreshListener(this);
            this.iyt.setPageUniqueId(getUniqueId());
        }
        if (this.iyt.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iyt.getParent()).removeView(this.iyt);
        }
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        return this.iyt;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iys == null) {
            this.iys = new RecommendModel(getPageContext());
            this.iys.setPresenter(this);
            this.iys.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.iyu && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iyt.ib(false);
            this.iys.cwC();
            this.iyu = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iys != null) {
            this.iys.cwC();
        }
        com.baidu.tieba.t.c.dOf().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iyt.Yb();
            this.iyt.ib(false);
            this.iys.cwC();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.iyt.hideLoadingView();
        this.iyt.bSm();
        if (i != 0 || aVar == null) {
            this.iyt.px(false);
            return;
        }
        this.iyt.Yb();
        this.iyt.bYt();
        this.iyt.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iyt != null) {
            this.iyt.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.ivl = null;
        this.iyt.onDestroy();
        this.iys.onDestroy();
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.iyu) {
                loadData();
                this.iyu = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

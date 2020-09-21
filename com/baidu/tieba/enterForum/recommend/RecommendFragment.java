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
/* loaded from: classes21.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c hCj;
    private RecommendModel hFq;
    private RecommendView hFr;
    private boolean hFs;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.hFr == null) {
            this.hFr = new RecommendView(getPageContext());
            this.hFr.setTabViewController(this.hCj);
            this.hFr.setPresenter(this);
            this.hFr.setListPullRefreshListener(this);
            this.hFr.setPageUniqueId(getUniqueId());
        }
        if (this.hFr.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.hFr.getParent()).removeView(this.hFr);
        }
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
        return this.hFr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.hFq == null) {
            this.hFq = new RecommendModel(getPageContext());
            this.hFq.setPresenter(this);
            this.hFq.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.hFs && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.hFr.gR(false);
            this.hFq.cjF();
            this.hFs = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.hFq != null) {
            this.hFq.cjF();
        }
        com.baidu.tieba.s.c.dzC().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.hFr.bHn();
            this.hFr.gR(false);
            this.hFq.cjF();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.hFr.hideLoadingView();
        this.hFr.bHu();
        if (i != 0 || aVar == null) {
            this.hFr.nS(false);
            return;
        }
        this.hFr.bHn();
        this.hFr.bMD();
        this.hFr.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hFr != null) {
            this.hFr.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.hCj = null;
        this.hFr.onDestroy();
        this.hFq.onDestroy();
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.hFs) {
                loadData();
                this.hFs = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements h.c, a {
    private c fbv;
    private RecommendModel fdB;
    private RecommendView fdC;
    private boolean fdD;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fdC == null) {
            this.fdC = new RecommendView(getPageContext());
            this.fdC.setTabViewController(this.fbv);
            this.fdC.setPresenter(this);
            this.fdC.setListPullRefreshListener(this);
            this.fdC.setPageUniqueId(getUniqueId());
        }
        if (this.fdC.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fdC.getParent()).removeView(this.fdC);
        }
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
        return this.fdC;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fdB == null) {
            this.fdB = new RecommendModel(getPageContext());
            this.fdB.setPresenter(this);
            this.fdB.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fdD && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fdC.dp(false);
            this.fdB.bfe();
            this.fdD = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        if (this.fdB != null) {
            this.fdB.bfe();
        }
        com.baidu.tieba.q.c.cnk().y(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fdC.aJo();
            this.fdC.dp(false);
            this.fdB.bfe();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fdC.hideLoadingView();
        this.fdC.aJH();
        if (i != 0 || aVar == null) {
            this.fdC.jm(false);
            return;
        }
        this.fdC.aJo();
        this.fdC.aMq();
        this.fdC.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fdC != null) {
            this.fdC.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.fbv = null;
        this.fdC.onDestroy();
        this.fdB.onDestroy();
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fdD) {
                loadData();
                this.fdD = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.q.c.cnk().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.fbv = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

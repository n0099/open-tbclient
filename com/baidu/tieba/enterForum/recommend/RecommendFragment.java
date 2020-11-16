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
    private c ikq;
    private boolean inA;
    private RecommendModel iny;
    private RecommendView inz;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.inz == null) {
            this.inz = new RecommendView(getPageContext());
            this.inz.setTabViewController(this.ikq);
            this.inz.setPresenter(this);
            this.inz.setListPullRefreshListener(this);
            this.inz.setPageUniqueId(getUniqueId());
        }
        if (this.inz.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.inz.getParent()).removeView(this.inz);
        }
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
        return this.inz;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iny == null) {
            this.iny = new RecommendModel(getPageContext());
            this.iny.setPresenter(this);
            this.iny.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.inA && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.inz.hM(false);
            this.iny.csm();
            this.inA = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iny != null) {
            this.iny.csm();
        }
        com.baidu.tieba.t.c.dIO().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.inz.VB();
            this.inz.hM(false);
            this.iny.csm();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.inz.hideLoadingView();
        this.inz.bOA();
        if (i != 0 || aVar == null) {
            this.inz.pb(false);
            return;
        }
        this.inz.VB();
        this.inz.bUJ();
        this.inz.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.inz != null) {
            this.inz.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.ikq = null;
        this.inz.onDestroy();
        this.iny.onDestroy();
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.inA) {
                loadData();
                this.inA = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

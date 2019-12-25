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
/* loaded from: classes6.dex */
public class RecommendFragment extends BaseFragment implements g.c, a {
    private c fPk;
    private RecommendModel fRn;
    private RecommendView fRo;
    private boolean fRp;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.fRo == null) {
            this.fRo = new RecommendView(getPageContext());
            this.fRo.setTabViewController(this.fPk);
            this.fRo.setPresenter(this);
            this.fRo.setListPullRefreshListener(this);
            this.fRo.setPageUniqueId(getUniqueId());
        }
        if (this.fRo.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.fRo.getParent()).removeView(this.fRo);
        }
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
        return this.fRo;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.fRn == null) {
            this.fRn = new RecommendModel(getPageContext());
            this.fRn.setPresenter(this);
            this.fRn.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.fRp && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.fRo.eA(false);
            this.fRn.bww();
            this.fRp = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (this.fRn != null) {
            this.fRn.bww();
        }
        com.baidu.tieba.r.c.cHo().z(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.fRo.aZK();
            this.fRo.eA(false);
            this.fRn.bww();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.fRo.hideLoadingView();
        this.fRo.bad();
        if (i != 0 || aVar == null) {
            this.fRo.ky(false);
            return;
        }
        this.fRo.aZK();
        this.fRo.bdR();
        this.fRo.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fRo != null) {
            this.fRo.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.fPk = null;
        this.fRo.onDestroy();
        this.fRn.onDestroy();
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.fRp) {
                loadData();
                this.fRp = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.fPk = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

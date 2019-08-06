package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.model.RecommendModel;
import com.baidu.tieba.enterForum.recommend.view.RecommendView;
/* loaded from: classes4.dex */
public class RecommendFragment extends BaseFragment implements h.c, a {
    private c eXe;
    private RecommendModel eZk;
    private RecommendView eZl;
    private boolean eZm;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eZl == null) {
            this.eZl = new RecommendView(getPageContext());
            this.eZl.setTabViewController(this.eXe);
            this.eZl.setPresenter(this);
            this.eZl.setListPullRefreshListener(this);
            this.eZl.setPageUniqueId(getUniqueId());
        }
        if (this.eZl.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eZl.getParent()).removeView(this.eZl);
        }
        com.baidu.tieba.q.c.coG().u(getUniqueId());
        return this.eZl;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eZk == null) {
            this.eZk = new RecommendModel(getPageContext());
            this.eZk.setPresenter(this);
            this.eZk.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eZm && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.eZl.cY(false);
            this.eZk.bgE();
            this.eZm = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        if (this.eZk != null) {
            this.eZk.bgE();
        }
        com.baidu.tieba.q.c.coG().x(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.kc()) {
            this.eZl.aJj();
            this.eZl.cY(false);
            this.eZk.bgE();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eZl.hideLoadingView();
        this.eZl.aJD();
        if (i != 0 || aVar == null) {
            this.eZl.ju(false);
            return;
        }
        this.eZl.aJj();
        this.eZl.aVR();
        this.eZl.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eZl != null) {
            this.eZl.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eXe = null;
        this.eZl.onDestroy();
        this.eZk.onDestroy();
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.eZm) {
                loadData();
                this.eZm = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.q.c.coG().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.eXe = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }
}

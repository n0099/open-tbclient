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
    private c eWU;
    private RecommendModel eYW;
    private RecommendView eYX;
    private boolean eYY;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eYX == null) {
            this.eYX = new RecommendView(getPageContext());
            this.eYX.setTabViewController(this.eWU);
            this.eYX.setPresenter(this);
            this.eYX.setListPullRefreshListener(this);
            this.eYX.setPageUniqueId(getUniqueId());
        }
        if (this.eYX.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.eYX.getParent()).removeView(this.eYX);
        }
        com.baidu.tieba.q.c.coo().u(getUniqueId());
        return this.eYX;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.eYW == null) {
            this.eYW = new RecommendModel(getPageContext());
            this.eYW.setPresenter(this);
            this.eYW.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.eYY && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.eYX.cY(false);
            this.eYW.bgB();
            this.eYY = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        if (this.eYW != null) {
            this.eYW.bgB();
        }
        com.baidu.tieba.q.c.coo().x(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.kc()) {
            this.eYX.aJh();
            this.eYX.cY(false);
            this.eYW.bgB();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.eYX.hideLoadingView();
        this.eYX.aJB();
        if (i != 0 || aVar == null) {
            this.eYX.ju(false);
            return;
        }
        this.eYX.aJh();
        this.eYX.aVP();
        this.eYX.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.eYX != null) {
            this.eYX.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eWU = null;
        this.eYX.onDestroy();
        this.eYW.onDestroy();
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.eYY) {
                loadData();
                this.eYY = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.q.c.coo().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.eWU = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }
}

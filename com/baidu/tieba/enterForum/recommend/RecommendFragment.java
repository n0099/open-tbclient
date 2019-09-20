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
    private c eYK;
    private RecommendModel faQ;
    private RecommendView faR;
    private boolean faS;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.faR == null) {
            this.faR = new RecommendView(getPageContext());
            this.faR.setTabViewController(this.eYK);
            this.faR.setPresenter(this);
            this.faR.setListPullRefreshListener(this);
            this.faR.setPageUniqueId(getUniqueId());
        }
        if (this.faR.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.faR.getParent()).removeView(this.faR);
        }
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
        return this.faR;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.faQ == null) {
            this.faQ = new RecommendModel(getPageContext());
            this.faQ.setPresenter(this);
            this.faQ.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.faS && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.faR.cY(false);
            this.faQ.bhk();
            this.faS = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        if (this.faQ != null) {
            this.faQ.bhk();
        }
        com.baidu.tieba.q.c.cpt().x(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.kc()) {
            this.faR.aJN();
            this.faR.cY(false);
            this.faQ.bhk();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.faR.hideLoadingView();
        this.faR.aKh();
        if (i != 0 || aVar == null) {
            this.faR.jx(false);
            return;
        }
        this.faR.aJN();
        this.faR.aWv();
        this.faR.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.faR != null) {
            this.faR.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.eYK = null;
        this.faR.onDestroy();
        this.faQ.onDestroy();
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.faS) {
                loadData();
                this.faS = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.q.c.cpt().b(getUniqueId(), false);
    }

    public void setTabViewController(c cVar) {
        this.eYK = cVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a025";
    }
}

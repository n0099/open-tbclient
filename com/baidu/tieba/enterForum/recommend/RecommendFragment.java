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
    private c idF;
    private RecommendModel igL;
    private RecommendView igM;
    private boolean igN;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.igM == null) {
            this.igM = new RecommendView(getPageContext());
            this.igM.setTabViewController(this.idF);
            this.igM.setPresenter(this);
            this.igM.setListPullRefreshListener(this);
            this.igM.setPageUniqueId(getUniqueId());
        }
        if (this.igM.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.igM.getParent()).removeView(this.igM);
        }
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
        return this.igM;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.igL == null) {
            this.igL = new RecommendModel(getPageContext());
            this.igL.setPresenter(this);
            this.igL.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.igN && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.igM.hA(false);
            this.igL.cqi();
            this.igN = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.igL != null) {
            this.igL.cqi();
        }
        com.baidu.tieba.s.c.dGv().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.igM.TK();
            this.igM.hA(false);
            this.igL.cqi();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.igM.hideLoadingView();
        this.igM.bMH();
        if (i != 0 || aVar == null) {
            this.igM.oP(false);
            return;
        }
        this.igM.TK();
        this.igM.bSR();
        this.igM.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.igM != null) {
            this.igM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.idF = null;
        this.igM.onDestroy();
        this.igL.onDestroy();
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.igN) {
                loadData();
                this.igN = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

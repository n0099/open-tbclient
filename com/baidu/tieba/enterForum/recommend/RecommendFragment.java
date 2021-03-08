package com.baidu.tieba.enterForum.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
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
/* loaded from: classes2.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c iKy;
    private RecommendModel iNE;
    private RecommendView iNF;
    private boolean iNG;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iNF == null) {
            this.iNF = new RecommendView(getPageContext());
            this.iNF.setTabViewController(this.iKy);
            this.iNF.setPresenter(this);
            this.iNF.setListPullRefreshListener(this);
            this.iNF.setPageUniqueId(getUniqueId());
        }
        if (this.iNF.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iNF.getParent()).removeView(this.iNF);
        }
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        return this.iNF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iNE == null) {
            this.iNE = new RecommendModel(getPageContext());
            this.iNE.setPresenter(this);
            this.iNE.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.iNG && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iNF.ir(false);
            this.iNE.cxd();
            this.iNG = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iNE != null) {
            this.iNE.cxd();
        }
        com.baidu.tieba.s.c.dMH().E(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iNF.Xc();
            this.iNF.ir(false);
            this.iNE.cxd();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.iNF.hideLoadingView();
        this.iNF.bRO();
        if (i != 0 || aVar == null) {
            this.iNF.qa(false);
            return;
        }
        this.iNF.Xc();
        this.iNF.bYu();
        this.iNF.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iNF != null) {
            this.iNF.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.iKy = null;
        this.iNF.onDestroy();
        this.iNE.onDestroy();
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.iNG) {
                loadData();
                this.iNG = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

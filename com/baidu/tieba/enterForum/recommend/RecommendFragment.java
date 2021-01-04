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
    private c iHy;
    private RecommendModel iKF;
    private RecommendView iKG;
    private boolean iKH;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iKG == null) {
            this.iKG = new RecommendView(getPageContext());
            this.iKG.setTabViewController(this.iHy);
            this.iKG.setPresenter(this);
            this.iKG.setListPullRefreshListener(this);
            this.iKG.setPageUniqueId(getUniqueId());
        }
        if (this.iKG.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iKG.getParent()).removeView(this.iKG);
        }
        com.baidu.tieba.s.c.dNX().z(getUniqueId());
        return this.iKG;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iKF == null) {
            this.iKF = new RecommendModel(getPageContext());
            this.iKF.setPresenter(this);
            this.iKF.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.iKH && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iKG.it(false);
            this.iKF.czv();
            this.iKH = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iKF != null) {
            this.iKF.czv();
        }
        com.baidu.tieba.s.c.dNX().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iKG.Zi();
            this.iKG.it(false);
            this.iKF.czv();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.iKG.hideLoadingView();
        this.iKG.bUO();
        if (i != 0 || aVar == null) {
            this.iKG.pU(false);
            return;
        }
        this.iKG.Zi();
        this.iKG.caY();
        this.iKG.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iKG != null) {
            this.iKG.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.iHy = null;
        this.iKG.onDestroy();
        this.iKF.onDestroy();
        com.baidu.tieba.s.c.dNX().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.iKH) {
                loadData();
                this.iKH = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

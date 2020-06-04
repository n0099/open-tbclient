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
/* loaded from: classes9.dex */
public class RecommendFragment extends BaseFragment implements f.c, a {
    private c gPG;
    private RecommendModel gSY;
    private RecommendView gSZ;
    private boolean gTa;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.gSZ == null) {
            this.gSZ = new RecommendView(getPageContext());
            this.gSZ.setTabViewController(this.gPG);
            this.gSZ.setPresenter(this);
            this.gSZ.setListPullRefreshListener(this);
            this.gSZ.setPageUniqueId(getUniqueId());
        }
        if (this.gSZ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.gSZ.getParent()).removeView(this.gSZ);
        }
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
        return this.gSZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.gSY == null) {
            this.gSY = new RecommendModel(getPageContext());
            this.gSY.setPresenter(this);
            this.gSY.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.gTa && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.gSZ.fV(false);
            this.gSY.bPF();
            this.gTa = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.gSY != null) {
            this.gSY.bPF();
        }
        com.baidu.tieba.s.c.dcI().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.gSZ.bqQ();
            this.gSZ.fV(false);
            this.gSY.bPF();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.gSZ.hideLoadingView();
        this.gSZ.bqX();
        if (i != 0 || aVar == null) {
            this.gSZ.mq(false);
            return;
        }
        this.gSZ.bqQ();
        this.gSZ.bvO();
        this.gSZ.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gSZ != null) {
            this.gSZ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.gPG = null;
        this.gSZ.onDestroy();
        this.gSY.onDestroy();
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.gTa) {
                loadData();
                this.gTa = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

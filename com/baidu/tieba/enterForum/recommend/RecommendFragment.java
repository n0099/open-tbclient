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
    private c iCR;
    private RecommendModel iFY;
    private RecommendView iFZ;
    private boolean iGa;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iFZ == null) {
            this.iFZ = new RecommendView(getPageContext());
            this.iFZ.setTabViewController(this.iCR);
            this.iFZ.setPresenter(this);
            this.iFZ.setListPullRefreshListener(this);
            this.iFZ.setPageUniqueId(getUniqueId());
        }
        if (this.iFZ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iFZ.getParent()).removeView(this.iFZ);
        }
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        return this.iFZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iFY == null) {
            this.iFY = new RecommendModel(getPageContext());
            this.iFY.setPresenter(this);
            this.iFY.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.iGa && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iFZ.ip(false);
            this.iFY.cvE();
            this.iGa = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iFY != null) {
            this.iFY.cvE();
        }
        com.baidu.tieba.s.c.dKg().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iFZ.Vq();
            this.iFZ.ip(false);
            this.iFY.cvE();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.iFZ.hideLoadingView();
        this.iFZ.bQX();
        if (i != 0 || aVar == null) {
            this.iFZ.pQ(false);
            return;
        }
        this.iFZ.Vq();
        this.iFZ.bXh();
        this.iFZ.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iFZ != null) {
            this.iFZ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.iCR = null;
        this.iFZ.onDestroy();
        this.iFY.onDestroy();
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.iGa) {
                loadData();
                this.iGa = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

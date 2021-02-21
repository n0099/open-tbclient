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
    private c iIP;
    private RecommendModel iLV;
    private RecommendView iLW;
    private boolean iLX;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iLW == null) {
            this.iLW = new RecommendView(getPageContext());
            this.iLW.setTabViewController(this.iIP);
            this.iLW.setPresenter(this);
            this.iLW.setListPullRefreshListener(this);
            this.iLW.setPageUniqueId(getUniqueId());
        }
        if (this.iLW.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iLW.getParent()).removeView(this.iLW);
        }
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        return this.iLW;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iLV == null) {
            this.iLV = new RecommendModel(getPageContext());
            this.iLV.setPresenter(this);
            this.iLV.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.iLX && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iLW.ir(false);
            this.iLV.cwX();
            this.iLX = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iLV != null) {
            this.iLV.cwX();
        }
        com.baidu.tieba.s.c.dMz().D(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iLW.WZ();
            this.iLW.ir(false);
            this.iLV.cwX();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.iLW.hideLoadingView();
        this.iLW.bRI();
        if (i != 0 || aVar == null) {
            this.iLW.qa(false);
            return;
        }
        this.iLW.WZ();
        this.iLW.bYo();
        this.iLW.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iLW != null) {
            this.iLW.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.iIP = null;
        this.iLW.onDestroy();
        this.iLV.onDestroy();
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.iLX) {
                loadData();
                this.iLX = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

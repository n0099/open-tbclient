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
    private c ivj;
    private RecommendModel iyq;
    private RecommendView iyr;
    private boolean iys;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.iyr == null) {
            this.iyr = new RecommendView(getPageContext());
            this.iyr.setTabViewController(this.ivj);
            this.iyr.setPresenter(this);
            this.iyr.setListPullRefreshListener(this);
            this.iyr.setPageUniqueId(getUniqueId());
        }
        if (this.iyr.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.iyr.getParent()).removeView(this.iyr);
        }
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
        return this.iyr;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iyq == null) {
            this.iyq = new RecommendModel(getPageContext());
            this.iyq.setPresenter(this);
            this.iyq.setUniqueId(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!this.iys && !TbadkCoreApplication.getInst().checkInterrupt()) {
            this.iyr.ib(false);
            this.iyq.cwB();
            this.iys = true;
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        if (this.iyq != null) {
            this.iyq.cwB();
        }
        com.baidu.tieba.t.c.dOe().C(getUniqueId());
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.iyr.Yb();
            this.iyr.ib(false);
            this.iyq.cwB();
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.a
    public void a(int i, com.baidu.tieba.enterForum.recommend.b.a aVar) {
        this.iyr.hideLoadingView();
        this.iyr.bSl();
        if (i != 0 || aVar == null) {
            this.iyr.px(false);
            return;
        }
        this.iyr.Yb();
        this.iyr.bYs();
        this.iyr.setData(aVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.iyr != null) {
            this.iyr.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.ivj = null;
        this.iyr.onDestroy();
        this.iyq.onDestroy();
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921385));
            if (!this.iys) {
                loadData();
                this.iys = true;
                return;
            }
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.ENTER_FORUM;
    }
}

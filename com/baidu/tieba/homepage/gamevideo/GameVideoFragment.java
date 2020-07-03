package com.baidu.tieba.homepage.gamevideo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.gamevideo.b.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class GameVideoFragment extends BaseFragment implements ao {
    private c ipu;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ipu == null) {
            this.ipu = new c(getPageContext(), getUniqueId());
        }
        this.ipu.init();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.ipu == null || this.ipu.getView() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        if (this.ipu.getView().getParent() instanceof ViewGroup) {
            ((ViewGroup) this.ipu.getView().getParent()).removeView(this.ipu.getView());
        }
        return this.ipu.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.ipu != null) {
            this.ipu.loadData();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void IB() {
        if (this.ipu != null) {
            this.ipu.IB();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void btP() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void btQ() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ao
    public void aYj() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ipu != null) {
            this.ipu.aYj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
        }
        if (this.ipu != null) {
            this.ipu.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ipu != null) {
            this.ipu.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ipu != null) {
            this.ipu.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(w.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a066";
    }
}

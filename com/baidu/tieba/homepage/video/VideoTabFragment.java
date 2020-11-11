package com.baidu.tieba.homepage.video;

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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.frs.aq;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class VideoTabFragment extends BaseFragment implements aq {
    private a jMn;
    private boolean jMo = false;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jMn == null) {
            this.jMn = new a(getPageContext(), getUniqueId());
        }
        this.jMn.init();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jMn == null || this.jMn.getView() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        if (this.jMn.getView().getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jMn.getView().getParent()).removeView(this.jMn.getView());
        }
        return this.jMn.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.jMn != null) {
            this.jMn.loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.jMo) {
                this.jMo = true;
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13579"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
        }
        if (this.jMn != null) {
            this.jMn.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void TL() {
        if (this.jMn != null) {
            this.jMn.TL();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPc() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPd() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bsD() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jMn != null) {
            this.jMn.bsD();
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
        if (!PageStayDurationConstants.PageName.HOMEPAGE.equals(y.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.jMn != null) {
            this.jMn.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jMn != null) {
            this.jMn.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a067";
    }
}

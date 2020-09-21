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
/* loaded from: classes21.dex */
public class VideoTabFragment extends BaseFragment implements aq {
    private a jeQ;
    private boolean jeR = false;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.jeQ == null) {
            this.jeQ = new a(getPageContext(), getUniqueId());
        }
        this.jeQ.init();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.jeQ == null || this.jeQ.getView() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        if (this.jeQ.getView().getParent() instanceof ViewGroup) {
            ((ViewGroup) this.jeQ.getView().getParent()).removeView(this.jeQ.getView());
        }
        return this.jeQ.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.jeQ != null) {
            this.jeQ.loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.jeR) {
                this.jeR = true;
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13579"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
        }
        if (this.jeQ != null) {
            this.jeQ.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void Pd() {
        if (this.jeQ != null) {
            this.jeQ.Pd();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHp() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHq() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(ab abVar) {
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.aq
    public void blA() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jeQ != null) {
            this.jeQ.blA();
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
        if (this.jeQ != null) {
            this.jeQ.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jeQ != null) {
            this.jeQ.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a067";
    }
}

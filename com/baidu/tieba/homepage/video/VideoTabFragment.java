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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class VideoTabFragment extends BaseFragment implements ap {
    private a kaC;
    private boolean kaD = false;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.kaC == null) {
            this.kaC = new a(getPageContext(), getUniqueId());
        }
        this.kaC.init();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.kaC == null || this.kaC.getView() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        if (this.kaC.getView().getParent() instanceof ViewGroup) {
            ((ViewGroup) this.kaC.getView().getParent()).removeView(this.kaC.getView());
        }
        return this.kaC.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.kaC != null) {
            this.kaC.loadData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.kaD) {
                this.kaD = true;
                TiebaStatic.log(new ar("c13579"));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, false));
        }
        if (this.kaC != null) {
            this.kaC.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        if (this.kaC != null) {
            this.kaC.VC();
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSi() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
    }

    @Override // com.baidu.tieba.frs.ap
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kaC != null) {
            this.kaC.bvt();
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
        if (this.kaC != null) {
            this.kaC.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kaC != null) {
            this.kaC.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a067";
    }
}

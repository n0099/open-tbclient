package com.baidu.tieba.homepage.topic.topictab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.homepage.topic.topictab.model.TopicModel;
import com.baidu.tieba.homepage.topic.topictab.view.TopicListView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class TopicFragment extends BaseFragment implements f.c, am, a {
    private boolean kab = false;
    private TopicModel kqb;
    private TopicListView kqc;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kqb.setPresenter(this);
        this.kqb.setUniqueId(getUniqueId());
        this.kqc.setPresenter(this);
        this.kqc.setListPullRefreshListener(this);
        this.kqc.setPageUniqueId(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.kqc.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.kqc.getParent()).removeView(this.kqc);
        }
        if (this.kab) {
            this.kqc.bZl();
            this.kab = false;
        }
        return this.kqc;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.kqc.setViewForeground();
            TiebaStatic.log(new ar("c13349"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        this.kqc.ir(false);
        this.kqb.cSy();
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        this.kqc.reload();
    }

    @Override // com.baidu.tieba.frs.am
    public void bRD() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bRE() {
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
    }

    @Override // com.baidu.tieba.frs.am
    public void bup() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        this.kqc.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kqb.cSy();
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void loadData() {
        if (j.isNetWorkAvailable()) {
            this.kqc.WZ();
            this.kqc.ir(false);
            this.kqb.cSy();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topictab.a
    public void q(int i, List<n> list) {
        this.kqc.hideLoadingView();
        this.kqc.bRI();
        if (i != 0 || y.isEmpty(list)) {
            this.kqc.qa(false);
            return;
        }
        this.kqc.WZ();
        this.kqc.bYo();
        this.kqc.setData(list);
        this.kqc.WY();
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a021";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.kqc.destroy();
        this.kqb.onDestroy();
        this.kab = true;
    }
}

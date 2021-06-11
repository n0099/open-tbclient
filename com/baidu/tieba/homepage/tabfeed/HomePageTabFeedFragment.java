package com.baidu.tieba.homepage.tabfeed;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.model.TabFeedNetFeedModel;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.m0.k0.d;
import d.a.m0.r.q.a2;
import d.a.m0.z0.b0;
import d.a.n0.b1.j.e;
import d.a.n0.b1.j.f;
import d.a.n0.b1.j.h.c;
import d.a.n0.r0.o0;
import d.a.n0.z.e0.j;
import d.a.n0.z.t;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HomePageTabFeedFragment extends BaseFragment implements e, o0 {

    /* renamed from: e  reason: collision with root package name */
    public String f16563e;

    /* renamed from: f  reason: collision with root package name */
    public String f16564f;

    /* renamed from: g  reason: collision with root package name */
    public int f16565g;

    /* renamed from: h  reason: collision with root package name */
    public f f16566h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.b1.j.k.a f16567i;
    public ViewGroup j;
    public CustomMessageListener k = new a(2016488);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (HomePageTabFeedFragment.this.f16566h == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || HomePageTabFeedFragment.this.f16566h.i() == null || ListUtils.getCount(HomePageTabFeedFragment.this.f16566h.i()) == 0) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                if (HomePageTabFeedFragment.this.f16567i == null || HomePageTabFeedFragment.this.f16567i.f() == null || TextUtils.isEmpty(optString2)) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= HomePageTabFeedFragment.this.f16567i.f().getCount()) {
                        break;
                    }
                    n B = HomePageTabFeedFragment.this.f16567i.f().B(i2);
                    if (B instanceof j) {
                        j jVar = (j) B;
                        if (jVar.i() != null && jVar.i().s1() != null && optString2.equals(String.valueOf(jVar.i().s1().live_id))) {
                            optString = jVar.i().z1();
                            break;
                        }
                    }
                    i2++;
                }
                if (StringUtils.isNull(optString)) {
                    return;
                }
            }
            int i3 = 0;
            while (true) {
                if (i3 < HomePageTabFeedFragment.this.f16566h.i().size()) {
                    a2 a2Var = HomePageTabFeedFragment.this.f16566h.i().get(i3);
                    if (a2Var != null && optString.equals(a2Var.A)) {
                        HomePageTabFeedFragment.this.f16566h.i().remove(i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (HomePageTabFeedFragment.this.f16567i.f() != null) {
                List<Integer> b2 = d.a.n0.b1.j.a.b(optString, HomePageTabFeedFragment.this.f16567i.f());
                int intValue = b2.get(0).intValue();
                int intValue2 = b2.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                HomePageTabFeedFragment.this.f16567i.f().E(intValue, intValue2);
            }
        }
    }

    @Override // d.a.n0.r0.o0
    public void H() {
    }

    @Override // d.a.n0.r0.o0
    public void I() {
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void I0(boolean z) {
        f fVar = this.f16566h;
        if (fVar != null) {
            if (this.f16567i != null && z) {
                if (fVar.b()) {
                    this.f16567i.q();
                    this.f16567i.n(true);
                } else {
                    hideNetRefreshView(this.j);
                    showLoadingView(this.j);
                }
            }
            this.f16566h.refresh();
        }
    }

    public int J0() {
        return R.layout.tab_feed_fragment;
    }

    public final int K0() {
        return ((l.i(getContext()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
    }

    public String L0() {
        return this.f16563e;
    }

    public final void M0() {
        if (isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f16563e);
            statisticItem.param("obj_type", this.f16564f);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.a.n0.b1.j.e
    public void N(c cVar) {
        hideLoadingView(this.j);
        f fVar = this.f16566h;
        if (fVar != null && !fVar.b()) {
            showNoDataRefreshView(this.j, false);
            return;
        }
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.k(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d getPageStayDurationItem() {
        d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q = this.f16563e;
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.o(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.o(true);
        }
    }

    @Override // d.a.n0.b1.j.e
    public void j() {
        f fVar = this.f16566h;
        if (fVar != null) {
            fVar.loadMore();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.f16563e = bundle.getString("tab_name");
            this.f16564f = bundle.getString(LowFlowsActivityConfig.TAB_CODE);
            this.f16565g = bundle.getInt("tab_type");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = this.j;
        if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.j.getParent()).removeView(this.j);
        }
        if (this.j == null) {
            ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(J0(), (ViewGroup) null);
            this.j = viewGroup3;
            this.f16567i = new d.a.n0.b1.j.k.a(this, this, viewGroup3, this.f16564f);
        }
        if (this.f16566h == null) {
            if (this.f16565g == 201) {
                this.f16566h = new ChannelTabNetFeedModel(getPageContext(), this);
            } else {
                this.f16566h = new TabFeedNetFeedModel(getPageContext(), this);
            }
            this.f16566h.o(this.f16564f, this.f16563e, this.f16565g);
        }
        this.f16566h.c(getUniqueId());
        registerListener(this.k);
        return this.j;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t.b().e(false);
        f fVar = this.f16566h;
        if (fVar != null) {
            fVar.destory();
        }
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.j();
        }
        MessageManager.getInstance().unRegisterListener(this.k);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (d.a.c.e.p.j.z()) {
            showLoadingView(this.j);
            f fVar = this.f16566h;
            if (fVar != null) {
                try {
                    fVar.refresh();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        showNetRefreshView(this.j, null, true);
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        I0(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (d.a.c.e.p.j.z()) {
            hideNetRefreshView(this.j);
            showLoadingView(this.j);
            I0(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.l();
        }
        t.b().e(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            d.a.n0.b1.j.k.a aVar = this.f16567i;
            if (aVar != null) {
                aVar.m();
            }
            M0();
            return;
        }
        d.a.n0.b1.j.k.a aVar2 = this.f16567i;
        if (aVar2 != null) {
            aVar2.l();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putString("tab_name", this.f16563e);
            bundle.putString(LowFlowsActivityConfig.TAB_CODE, this.f16564f);
            bundle.putInt("tab_type", this.f16565g);
        }
    }

    @Override // d.a.n0.b1.j.e
    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.j);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        f fVar = this.f16566h;
        if (fVar != null && !fVar.b()) {
            showNetRefreshView(this.j, errorData != null ? getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
        }
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.n(false);
        }
    }

    @Override // d.a.n0.r0.o0
    public void r() {
        I0(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.o(false);
        }
        super.showLoadingView(view, false, K0());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.o(false);
        }
        super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        d.a.n0.b1.j.k.a aVar = this.f16567i;
        if (aVar != null) {
            aVar.o(false);
        }
        super.showNoDataRefreshView(view, z);
        setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), R.dimen.ds364));
    }

    @Override // d.a.n0.r0.o0
    public void t() {
    }

    @Override // d.a.n0.r0.o0
    public void v() {
    }

    @Override // d.a.n0.r0.o0
    public void z(b0 b0Var) {
    }
}

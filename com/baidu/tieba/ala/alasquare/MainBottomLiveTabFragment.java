package com.baidu.tieba.ala.alasquare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.AlaLiveTabFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MainBottomLiveTabFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14370e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14371f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f14372g;

    /* renamed from: h  reason: collision with root package name */
    public CustomViewPager f14373h;
    public FragmentAdapter i;
    public List<c> j = new ArrayList();
    public NoNetworkView.b k = new a();
    public CustomMessageListener l = new b(2001384);

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f14374a;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f14374a = new ArrayList();
        }

        public void c(List<c> list) {
            this.f14374a.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f14374a.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f14374a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            c cVar = this.f14374a.get(i);
            if (cVar != null) {
                return cVar.f14377a;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            c cVar = this.f14374a.get(i);
            return cVar != null ? cVar.f14378b : "";
        }
    }

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z && MainBottomLiveTabFragment.this.isPrimary() && MainBottomLiveTabFragment.this.i.getCount() > 0) {
                Fragment item = MainBottomLiveTabFragment.this.i.getItem(0);
                if (item instanceof AlaLiveTabFragment) {
                    ((AlaLiveTabFragment) item).N0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_MAIN_BOTTOM_LIVE_TAB_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public AlaLiveTabFragment f14377a;

        /* renamed from: b  reason: collision with root package name */
        public String f14378b;

        public c() {
        }
    }

    public final void F0() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f14370e.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        this.f14372g.a(this.k);
        this.f14373h.setViewPagerScroll(0);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager());
        this.i = fragmentAdapter;
        this.f14373h.setAdapter(fragmentAdapter);
        c cVar = new c();
        cVar.f14377a = new AlaLiveTabFragment();
        cVar.f14378b = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_live);
        this.j.add(cVar);
        this.i.c(this.j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setViewTextColor(this.f14371f, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f14370e, R.color.CAM_X0207);
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        if (pageContext != null) {
            this.f14372g.c(pageContext, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.main_bottom_live_tab_layout, (ViewGroup) null);
        this.f14370e = (LinearLayout) inflate.findViewById(R.id.tab_layout);
        this.f14371f = (TextView) inflate.findViewById(R.id.tab_view);
        this.f14373h = (CustomViewPager) inflate.findViewById(R.id.viewpager);
        this.f14372g = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        F0();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || this.i.getCount() <= 0) {
            return;
        }
        Fragment item = this.i.getItem(0);
        if (item instanceof AlaLiveTabFragment) {
            AlaLiveTabFragment alaLiveTabFragment = (AlaLiveTabFragment) item;
            if (alaLiveTabFragment.M0()) {
                alaLiveTabFragment.setUserVisibleHint(true);
            }
        }
    }
}

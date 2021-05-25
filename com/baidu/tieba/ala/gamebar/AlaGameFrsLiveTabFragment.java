package com.baidu.tieba.ala.gamebar;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r0.k0;
import d.a.n0.r0.r0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveTabFragment extends BaseFragment implements ViewPager.OnPageChangeListener, r0 {

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f13966e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13967f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentTabHost f13968g;

    /* renamed from: h  reason: collision with root package name */
    public AlaGameFrsLiveTabAdapter f13969h;
    public String k;
    public String l;
    public String m;

    /* renamed from: i  reason: collision with root package name */
    public int f13970i = -1;
    public final Handler j = new Handler();
    public CustomMessageListener n = new a(0);
    public CustomMessageListener o = new b(2001621);
    public CustomMessageListener p = new e(0);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (AlaGameFrsLiveTabFragment.this.f13966e == null || AlaGameFrsLiveTabFragment.this.f13966e.getNavBarIsShow()) {
                    return;
                }
                AlaGameFrsLiveTabFragment.this.f13966e.showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() == 2001618 && AlaGameFrsLiveTabFragment.this.f13966e != null && AlaGameFrsLiveTabFragment.this.f13966e.getNavBarIsShow()) {
                AlaGameFrsLiveTabFragment.this.f13966e.hideNavigationBarWithAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaGameFrsLiveTabFragment.this.f13968g == null || AlaGameFrsLiveTabFragment.this.f13969h == null || AlaGameFrsLiveTabFragment.this.f13969h.getCount() < 2) {
                return;
            }
            AlaGameFrsLiveTabFragment.this.f13968g.setCurrentTab(1);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, AlaGameFrsLiveTabFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNull(AlaGameFrsLiveTabFragment.this.k)) {
                return;
            }
            AlaGameFrsLiveTabFragment.this.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(AlaGameFrsLiveTabFragment.this.getPageContext().getPageActivity(), AlaGameFrsLiveTabFragment.this.k, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGameLive".equals(split[0]) && 2 == Integer.valueOf(split[1]).intValue()) {
                AlaGameFrsLiveTabFragment.this.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.a.m0.k0.b {
        public f() {
        }

        @Override // d.a.m0.k0.b
        public boolean canStat(d.a.m0.k0.d dVar) {
            return false;
        }

        @Override // d.a.m0.k0.b
        public int getMaxCost() {
            return d.a.m0.k0.e.b().c();
        }

        @Override // d.a.m0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof k0) || AlaGameFrsLiveTabFragment.this.f13969h.getCount() > 0) {
                return;
            }
            k0 k0Var = (k0) customResponsedMessage.getData();
            Message<?> message = customResponsedMessage.getmOrginalMessage();
            if (message == null || message.getTag() == null || !message.getTag().equals(AlaGameFrsLiveTabFragment.this.getUniqueId())) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (k0Var.e() != null) {
                for (d.a.m0.e0.b bVar : k0Var.e()) {
                    if (bVar.getFragmentTabStructure().f49334a != null) {
                        arrayList.add(bVar.getFragmentTabStructure().f49334a);
                        arrayList2.add(Integer.valueOf(bVar.getFragmentTabStructure().f49338e));
                    }
                }
            }
            AlaGameFrsLiveTabFragment.this.f13969h.b(arrayList);
            int count = AlaGameFrsLiveTabFragment.this.f13969h.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment = AlaGameFrsLiveTabFragment.this;
                alaGameFrsLiveTabFragment.J0(alaGameFrsLiveTabFragment.f13969h.getItem(i2), ((Integer) arrayList2.get(i2)).intValue(), AlaGameFrsLiveTabFragment.this.L0(i2));
            }
            AlaGameFrsLiveTabFragment.this.f13968g.l();
            AlaGameFrsLiveTabFragment.this.f13968g.d(0);
        }
    }

    public final void J0(Fragment fragment, int i2, String str) {
        if (fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f12151c = fragment;
        bVar.f12149a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.tbds42));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f12150b = fragmentTabIndicator;
        fragmentTabIndicator.setContentTvTopMargin(9);
        this.f13968g.a(bVar);
    }

    public final int K0(String str) {
        return (!"live".equals(str) && "dynamic".equals(str)) ? 1 : 0;
    }

    public final String L0(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return getResources().getString(R.string.frsgame_title);
            }
            return getResources().getString(R.string.frs_game_live_video);
        }
        return getResources().getString(R.string.frsgame_title);
    }

    public final void M0() {
        this.f13969h = new AlaGameFrsLiveTabAdapter(getChildFragmentManager());
        g gVar = new g(2001619);
        gVar.setTag(getUniqueId());
        gVar.setPriority(Integer.MAX_VALUE);
        registerListener(gVar);
        k0 k0Var = new k0(getPageContext().getPageActivity());
        k0Var.g(this.k);
        k0Var.h(this.l);
        k0Var.f(this.m);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001619, k0Var);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void N0(String str) {
        this.m = str;
    }

    public void O0(String str) {
        this.k = str;
    }

    public void P0(String str) {
        this.l = str;
        Q0();
    }

    public final void Q0() {
        if (this.f13966e != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.l, 5, true, true) + getResources().getString(R.string.forum));
            this.f13966e.setCenterTextTitle(sb.toString());
        }
    }

    @Override // d.a.n0.r0.r0
    public NavigationBar e0() {
        return this.f13966e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        FragmentTabHost fragmentTabHost = this.f13968g;
        if (fragmentTabHost == null) {
            return null;
        }
        Fragment currentFragment = fragmentTabHost.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public d.a.m0.k0.b getPageStayFilter() {
        return new f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.n.setSelfListener(true);
        registerListener(2001617, this.n, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.n, getBaseFragmentActivity().getUniqueId());
        registerListener(this.o);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Resources resources;
        int i3;
        super.onChangeSkinType(i2);
        FragmentTabHost fragmentTabHost = this.f13968g;
        if (fragmentTabHost != null) {
            fragmentTabHost.setNeedShowThemeStyle(false);
            FragmentTabWidget fragmentTabWidget = this.f13968g.getFragmentTabWidget();
            if (i2 == 1) {
                resources = getResources();
                i3 = R.color.CAM_X0105_1;
            } else {
                resources = getResources();
                i3 = R.color.CAM_X0105;
            }
            fragmentTabWidget.setDiverColor(resources.getColor(i3));
            this.f13968g.o(i2);
            SkinManager.setBackgroundColor(this.f13968g.getTabWrapper(), R.color.common_color_10274);
        }
        NavigationBar navigationBar = this.f13966e;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f13966e.getBottomLine(), R.color.CAM_X0204);
        }
        ImageView imageView = this.f13967f;
        if (imageView != null) {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
        }
        AlaGameFrsLiveTabAdapter alaGameFrsLiveTabAdapter = this.f13969h;
        if (alaGameFrsLiveTabAdapter != null) {
            int count = alaGameFrsLiveTabAdapter.getCount();
            for (int i4 = 0; i4 < count; i4++) {
                Fragment item = this.f13969h.getItem(i4);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(2001446, this.p, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
        this.f13966e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView = (ImageView) this.f13966e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.f13967f = imageView;
        imageView.setLayoutParams(layoutParams);
        this.f13967f.setOnClickListener(new d());
        Q0();
        linearLayout.addView(this.f13966e, new LinearLayout.LayoutParams(-1, -2));
        this.f13966e.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundColor(this.f13966e.getBottomLine(), R.color.CAM_X0204);
        FragmentTabHost fragmentTabHost = new FragmentTabHost(getActivity());
        this.f13968g = fragmentTabHost;
        fragmentTabHost.setup(getChildFragmentManager());
        this.f13968g.setOnPageChangeListener(this);
        this.f13968g.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.tbds104));
        this.f13968g.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
        this.f13968g.getFragmentTabWidget().setDviderRectWidth(l.g(getActivity(), R.dimen.tbds84));
        this.f13968g.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.tbds4));
        linearLayout.addView(this.f13968g);
        return linearLayout;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.j.removeCallbacksAndMessages(null);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.f13970i = i2;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        FragmentTabHost fragmentTabHost;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.f13970i < 0) {
                M0();
                this.f13970i = 0;
                this.f13968g.setCurrentTab(0);
            }
            String p = d.a.m0.r.d0.b.j().p("square_jump_tab_name", null);
            if (!TextUtils.isEmpty(p)) {
                this.f13968g.setCurrentTab(K0(p));
            }
            d.a.m0.r.d0.b.j().x("square_jump_tab_name", "");
        }
        if (isAdded() && (fragmentTabHost = this.f13968g) != null && (fragmentTabHost.getCurrentFragment() instanceof BaseFragment)) {
            ((BaseFragment) this.f13968g.getCurrentFragment()).setPrimary(isPrimary());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public void t() {
        FragmentTabHost fragmentTabHost = this.f13968g;
        if (fragmentTabHost == null) {
            return;
        }
        FragmentTabHost.b f2 = this.f13968g.f(fragmentTabHost.getCurrentTabIndex());
        if (f2 == null) {
            return;
        }
        int i2 = f2.f12149a;
        if (i2 == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLiveLive_3"));
        } else if (i2 == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLiveLive_2"));
        }
    }
}

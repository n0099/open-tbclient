package com.baidu.tieba.enterForum.hotuserrank;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotUserRankView {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f14444a;

    /* renamed from: b  reason: collision with root package name */
    public View f14445b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f14446c;

    /* renamed from: d  reason: collision with root package name */
    public TbTabLayout f14447d;

    /* renamed from: e  reason: collision with root package name */
    public View f14448e;

    /* renamed from: f  reason: collision with root package name */
    public View f14449f;

    /* renamed from: g  reason: collision with root package name */
    public CustomViewPager f14450g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentAdapter f14451h;
    public d.a.n0.j0.i.b j;
    public View k;
    public TextView l;
    public String m;
    public View n;
    public TextView o;
    public View p;
    public boolean q;

    /* renamed from: i  reason: collision with root package name */
    public List<e> f14452i = new ArrayList();
    public Runnable r = new a();
    public View.OnClickListener s = new b();
    public ViewPager.OnPageChangeListener t = new c();
    public CustomMessageListener u = new d(2921447);

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<e> f14453a;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f14453a = new ArrayList();
        }

        public void b(List<e> list) {
            this.f14453a.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f14453a.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f14453a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            e eVar = this.f14453a.get(i2);
            if (eVar != null) {
                return eVar.f14458a;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            e eVar = this.f14453a.get(i2);
            return eVar != null ? eVar.f14459b : "";
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.f14450g.setViewPagerScroll();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.k) {
                HotUserRankView.this.f14444a.finish();
            } else if (view == HotUserRankView.this.l) {
                if (TextUtils.isEmpty(HotUserRankView.this.m)) {
                    HotUserRankView.this.f14444a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(HotUserRankView.this.f14444a.getPageContext(), new String[]{HotUserRankView.this.m});
                if (HotUserRankView.this.f14447d.getVisibility() == 0) {
                    StatisticItem statisticItem = new StatisticItem("c13658");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13669");
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (HotUserRankView.this.f14452i.get(i2) == null || ((e) HotUserRankView.this.f14452i.get(i2)).f14458a == null || ((e) HotUserRankView.this.f14452i.get(i2)).f14458a.N0() == null) {
                return;
            }
            HotUserRankView.this.j.e(((e) HotUserRankView.this.f14452i.get(i2)).f14458a.N0().g());
            StatisticItem statisticItem = new StatisticItem("c13657");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, ((e) HotUserRankView.this.f14452i.get(i2)).f14459b);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.n0.j0.i.c.c) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() == null || !customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.f14444a.getUniqueId())) {
                return;
            }
            d.a.n0.j0.i.c.c cVar = (d.a.n0.j0.i.c.c) customResponsedMessage.getData();
            if (cVar.f55975c == null) {
                return;
            }
            HotUserRankView.this.j.e(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public HotUserRankFragment f14458a;

        /* renamed from: b  reason: collision with root package name */
        public String f14459b;

        public e(HotUserRankView hotUserRankView) {
        }
    }

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.f14444a = baseFragmentActivity;
        View inflate = LayoutInflater.from(baseFragmentActivity).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.f14445b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f14446c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this.s);
        TextView addTextButton = this.f14446c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f14444a.getString(R.string.hot_user_rank_rule));
        this.l = addTextButton;
        addTextButton.setOnClickListener(this.s);
        TbTabLayout tbTabLayout = (TbTabLayout) this.f14445b.findViewById(R.id.tablayout);
        this.f14447d = tbTabLayout;
        tbTabLayout.setTabTextSize(l.g(baseFragmentActivity, R.dimen.tbds46));
        this.f14448e = this.f14445b.findViewById(R.id.tab_cover_left);
        this.f14449f = this.f14445b.findViewById(R.id.tab_cover_right);
        CustomViewPager customViewPager = (CustomViewPager) this.f14445b.findViewById(R.id.viewpager);
        this.f14450g = customViewPager;
        customViewPager.addOnPageChangeListener(this.t);
        this.f14450g.setViewPagerScroll(0);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f14444a.getSupportFragmentManager());
        this.f14451h = fragmentAdapter;
        this.f14450g.setAdapter(fragmentAdapter);
        this.f14447d.setupWithViewPager(this.f14450g);
        this.j = new d.a.n0.j0.i.b(this.f14444a.getPageContext(), this.f14445b.findViewById(R.id.bottom_view));
        this.f14444a.registerListener(this.u);
        this.n = this.f14445b.findViewById(R.id.update_tip);
        this.o = (TextView) this.f14445b.findViewById(R.id.update_tip_text);
        this.p = this.f14445b.findViewById(R.id.bottom_view_top_line);
    }

    public View i() {
        return this.f14445b;
    }

    public void j(int i2) {
        SkinManager.setBackgroundColor(this.f14445b, R.color.CAM_X0201);
        this.f14446c.onChangeSkinType(this.f14444a.getPageContext(), i2);
        this.f14447d.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
        this.f14447d.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        SkinManager.setBackgroundColor(this.f14447d, R.color.CAM_X0207);
        SkinManager.setViewTextColorSelector(this.l, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.j.d(i2);
        Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, null);
        int g2 = l.g(this.f14444a, R.dimen.tbds63);
        int g3 = l.g(this.f14444a, R.dimen.tbds2);
        if (pureDrawable != null) {
            pureDrawable.setBounds(0, g3, g2, g2 + g3);
            this.o.setCompoundDrawables(pureDrawable, null, null, null);
        }
        this.o.setCompoundDrawablePadding(l.g(this.f14444a, R.dimen.tbds9));
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f14444a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(0).into(this.n);
        SkinManager.setBackgroundResource(this.f14448e, R.drawable.hot_user_rank_tab_cover_left);
        SkinManager.setBackgroundResource(this.f14449f, R.drawable.hot_user_rank_tab_cover_right);
        this.p.setVisibility(i2 != 0 ? 8 : 0);
    }

    public void k() {
        d.a.c.e.m.e.a().removeCallbacks(this.r);
    }

    public void l(List<d.a.n0.j0.i.c.d> list, long j, int i2, String str) {
        this.m = str;
        if (!ListUtils.isEmpty(list) || j > 0) {
            this.f14452i.clear();
            if (ListUtils.isEmpty(list)) {
                this.f14447d.setVisibility(8);
                e eVar = new e(this);
                HotUserRankFragment hotUserRankFragment = new HotUserRankFragment();
                eVar.f14458a = hotUserRankFragment;
                hotUserRankFragment.Q0(j);
                this.f14452i.add(eVar);
                this.f14451h.b(this.f14452i);
                this.j.f(1);
                return;
            }
            for (d.a.n0.j0.i.c.d dVar : list) {
                this.f14447d.d(this.f14447d.z());
                e eVar2 = new e(this);
                HotUserRankFragment hotUserRankFragment2 = new HotUserRankFragment();
                eVar2.f14458a = hotUserRankFragment2;
                hotUserRankFragment2.P0(dVar.f55981b);
                eVar2.f14458a.R0(this.q);
                eVar2.f14459b = dVar.f55980a;
                this.f14452i.add(eVar2);
            }
            if (this.q) {
                this.f14446c.setCenterTextTitle(this.f14444a.getString(R.string.all_god_user_rank));
            } else {
                this.f14446c.setCenterTextTitle(this.f14444a.getString(R.string.all_hot_user_rank));
            }
            this.f14451h.b(this.f14452i);
            this.j.f(2);
            if (i2 != 0) {
                this.f14450g.setCurrentItem(i2);
            }
            d.a.c.e.m.e.a().postDelayed(this.r, 100L);
        }
    }

    public void m(boolean z) {
        this.q = z;
    }

    public void n(String str) {
        this.f14446c.setCenterTextTitle(str);
    }

    public void o(int i2) {
        this.n.setVisibility(i2);
    }
}

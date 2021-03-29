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
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotUserRankView {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f15430a;

    /* renamed from: b  reason: collision with root package name */
    public View f15431b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15432c;

    /* renamed from: d  reason: collision with root package name */
    public TbTabLayout f15433d;

    /* renamed from: e  reason: collision with root package name */
    public View f15434e;

    /* renamed from: f  reason: collision with root package name */
    public View f15435f;

    /* renamed from: g  reason: collision with root package name */
    public CustomViewPager f15436g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentAdapter f15437h;
    public d.b.i0.i0.i.b j;
    public View k;
    public TextView l;
    public String m;
    public View n;
    public TextView o;
    public View p;
    public boolean q;
    public List<e> i = new ArrayList();
    public Runnable r = new a();
    public View.OnClickListener s = new b();
    public ViewPager.OnPageChangeListener t = new c();
    public CustomMessageListener u = new d(2921447);

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<e> f15438a;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f15438a = new ArrayList();
        }

        public void c(List<e> list) {
            this.f15438a.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f15438a.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f15438a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            e eVar = this.f15438a.get(i);
            if (eVar != null) {
                return eVar.f15443a;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            e eVar = this.f15438a.get(i);
            return eVar != null ? eVar.f15444b : "";
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HotUserRankView.this.f15436g.setViewPagerScroll();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == HotUserRankView.this.k) {
                HotUserRankView.this.f15430a.finish();
            } else if (view == HotUserRankView.this.l) {
                if (TextUtils.isEmpty(HotUserRankView.this.m)) {
                    HotUserRankView.this.f15430a.showToast(R.string.load_error_retry);
                    return;
                }
                UrlManager.getInstance().dealOneLink(HotUserRankView.this.f15430a.getPageContext(), new String[]{HotUserRankView.this.m});
                if (HotUserRankView.this.f15433d.getVisibility() == 0) {
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
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (HotUserRankView.this.i.get(i) == null || ((e) HotUserRankView.this.i.get(i)).f15443a == null || ((e) HotUserRankView.this.i.get(i)).f15443a.O0() == null) {
                return;
            }
            HotUserRankView.this.j.e(((e) HotUserRankView.this.i.get(i)).f15443a.O0().g());
            StatisticItem statisticItem = new StatisticItem("c13657");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, ((e) HotUserRankView.this.i.get(i)).f15444b);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.i0.i.c.c) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() == null || !customResponsedMessage.getOrginalMessage().getTag().equals(HotUserRankView.this.f15430a.getUniqueId())) {
                return;
            }
            d.b.i0.i0.i.c.c cVar = (d.b.i0.i0.i.c.c) customResponsedMessage.getData();
            if (cVar.f55610c == null) {
                return;
            }
            HotUserRankView.this.j.e(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public HotUserRankFragment f15443a;

        /* renamed from: b  reason: collision with root package name */
        public String f15444b;

        public e(HotUserRankView hotUserRankView) {
        }
    }

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        this.f15430a = baseFragmentActivity;
        View inflate = LayoutInflater.from(baseFragmentActivity).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.f15431b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f15432c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this.s);
        TextView addTextButton = this.f15432c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f15430a.getString(R.string.hot_user_rank_rule));
        this.l = addTextButton;
        addTextButton.setOnClickListener(this.s);
        TbTabLayout tbTabLayout = (TbTabLayout) this.f15431b.findViewById(R.id.tablayout);
        this.f15433d = tbTabLayout;
        tbTabLayout.setTabTextSize(l.g(baseFragmentActivity, R.dimen.tbds46));
        this.f15434e = this.f15431b.findViewById(R.id.tab_cover_left);
        this.f15435f = this.f15431b.findViewById(R.id.tab_cover_right);
        CustomViewPager customViewPager = (CustomViewPager) this.f15431b.findViewById(R.id.viewpager);
        this.f15436g = customViewPager;
        customViewPager.addOnPageChangeListener(this.t);
        this.f15436g.setViewPagerScroll(0);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f15430a.getSupportFragmentManager());
        this.f15437h = fragmentAdapter;
        this.f15436g.setAdapter(fragmentAdapter);
        this.f15433d.setupWithViewPager(this.f15436g);
        this.j = new d.b.i0.i0.i.b(this.f15430a.getPageContext(), this.f15431b.findViewById(R.id.bottom_view));
        this.f15430a.registerListener(this.u);
        this.n = this.f15431b.findViewById(R.id.update_tip);
        this.o = (TextView) this.f15431b.findViewById(R.id.update_tip_text);
        this.p = this.f15431b.findViewById(R.id.bottom_view_top_line);
    }

    public View i() {
        return this.f15431b;
    }

    public void j(int i) {
        SkinManager.setBackgroundColor(this.f15431b, R.color.CAM_X0201);
        this.f15432c.onChangeSkinType(this.f15430a.getPageContext(), i);
        this.f15433d.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
        this.f15433d.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
        SkinManager.setBackgroundColor(this.f15433d, R.color.CAM_X0207);
        SkinManager.setViewTextColorSelector(this.l, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        this.j.d(i);
        Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, null);
        int g2 = l.g(this.f15430a, R.dimen.tbds63);
        int g3 = l.g(this.f15430a, R.dimen.tbds2);
        if (pureDrawable != null) {
            pureDrawable.setBounds(0, g3, g2, g2 + g3);
            this.o.setCompoundDrawables(pureDrawable, null, null, null);
        }
        this.o.setCompoundDrawablePadding(l.g(this.f15430a, R.dimen.tbds9));
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f15430a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(0).into(this.n);
        SkinManager.setBackgroundResource(this.f15434e, R.drawable.hot_user_rank_tab_cover_left);
        SkinManager.setBackgroundResource(this.f15435f, R.drawable.hot_user_rank_tab_cover_right);
        this.p.setVisibility(i != 0 ? 8 : 0);
    }

    public void k() {
        d.b.b.e.m.e.a().removeCallbacks(this.r);
    }

    public void l(List<d.b.i0.i0.i.c.d> list, long j, int i, String str) {
        this.m = str;
        if (!ListUtils.isEmpty(list) || j > 0) {
            this.i.clear();
            if (ListUtils.isEmpty(list)) {
                this.f15433d.setVisibility(8);
                e eVar = new e(this);
                HotUserRankFragment hotUserRankFragment = new HotUserRankFragment();
                eVar.f15443a = hotUserRankFragment;
                hotUserRankFragment.R0(j);
                this.i.add(eVar);
                this.f15437h.c(this.i);
                this.j.f(1);
                return;
            }
            for (d.b.i0.i0.i.c.d dVar : list) {
                this.f15433d.d(this.f15433d.z());
                e eVar2 = new e(this);
                HotUserRankFragment hotUserRankFragment2 = new HotUserRankFragment();
                eVar2.f15443a = hotUserRankFragment2;
                hotUserRankFragment2.Q0(dVar.f55616b);
                eVar2.f15443a.S0(this.q);
                eVar2.f15444b = dVar.f55615a;
                this.i.add(eVar2);
            }
            if (this.q) {
                this.f15432c.setCenterTextTitle(this.f15430a.getString(R.string.all_god_user_rank));
            } else {
                this.f15432c.setCenterTextTitle(this.f15430a.getString(R.string.all_hot_user_rank));
            }
            this.f15437h.c(this.i);
            this.j.f(2);
            if (i != 0) {
                this.f15436g.setCurrentItem(i);
            }
            d.b.b.e.m.e.a().postDelayed(this.r, 100L);
        }
    }

    public void m(boolean z) {
        this.q = z;
    }

    public void n(String str) {
        this.f15432c.setCenterTextTitle(str);
    }

    public void o(int i) {
        this.n.setVisibility(i);
    }
}

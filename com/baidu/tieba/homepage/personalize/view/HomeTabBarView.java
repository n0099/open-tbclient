package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import d.a.c.e.l.c;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f16577e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16578f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16579g;

    /* renamed from: h  reason: collision with root package name */
    public PagerSlidingTabStrip f16580h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f16581i;
    public int j;
    public int k;
    public int l;
    public View m;
    public int n;
    public float o;
    public NestedScrollHeader.f p;

    /* loaded from: classes4.dex */
    public class a extends c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16582a;

        public a(String str) {
            this.f16582a = str;
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                HomeTabBarView.this.f16579g.setImageResource(R.drawable.icon_use_gold_n);
                HomeTabBarView.this.f16579g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                return;
            }
            HomeTabBarView.this.f16579g.setImageBitmap(aVar.p());
            HomeTabBarView.this.f16579g.setTag(R.id.homepage_mission_entrance_url, this.f16582a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View y = HomeTabBarView.this.f16580h.y(HomeTabBarView.this.f16580h.getCurrentTabIndex());
            if (y == null || y.getRight() <= HomeTabBarView.this.f16580h.getRight()) {
                return;
            }
            HomeTabBarView.this.f16580h.scrollTo(HomeTabBarView.this.f16580h.getScrollX() + y.getWidth(), 0);
        }
    }

    public HomeTabBarView(Context context) {
        super(context);
        this.f16577e = 3;
        this.j = 0;
        this.n = R.color.CAM_X0105;
        d(context);
    }

    public View c(int i2) {
        return this.f16580h.y(i2);
    }

    public final void d(Context context) {
        this.k = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.j = this.k;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.home_page_search_icon);
        this.f16578f = imageView;
        imageView.setClickable(false);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.f16580h = pagerSlidingTabStrip;
        pagerSlidingTabStrip.z(l.g(context, R.dimen.T_X06), l.g(context, R.dimen.T_X04), l.g(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.f16580h.setExpandedTabLayoutParams(layoutParams);
        this.f16581i = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.m = findViewById(R.id.home_page_shadow);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.home_page_get_money);
        this.f16579g = tbImageView;
        tbImageView.setClickable(false);
        this.f16578f.setOnClickListener(this);
        this.f16579g.setOnClickListener(this);
        setOnClickListener(this);
        n(0.0f);
        j();
    }

    public boolean e() {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16580h;
        if (pagerSlidingTabStrip != null) {
            return pagerSlidingTabStrip.A();
        }
        return false;
    }

    public boolean f() {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16580h;
        if (pagerSlidingTabStrip != null) {
            return pagerSlidingTabStrip.B();
        }
        return false;
    }

    public final void g() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    public float getBackgroundAlpha() {
        return this.o;
    }

    public ImageView getTaskView() {
        return this.f16579g;
    }

    public void h() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    public void i() {
        this.f16580h.C();
    }

    public void j() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16577e) {
            return;
        }
        this.f16577e = skinType;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, this.o, skinType);
        this.f16578f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.n), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f16580h.D();
        SkinManager.setBackgroundResource(this.m, R.drawable.home_page_tab_shadow);
    }

    public void k() {
        this.f16578f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.n), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public final void l(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16580h.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                int i2 = layoutParams.rightMargin;
                int i3 = this.j;
                if (i2 != i3) {
                    layoutParams.rightMargin = i3;
                    this.f16580h.setLayoutParams(layoutParams);
                    this.f16580h.post(new b());
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.f16580h.setLayoutParams(layoutParams);
            }
        }
    }

    public final void m() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
            d.h().m(missionEntranceIcon, 10, new a(missionEntranceUrl), null);
            return;
        }
        this.f16579g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
        this.f16579g.setImageResource(R.drawable.icon_use_gold_n);
    }

    public void n(float f2) {
        LinearLayout linearLayout;
        int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
        if (i2 > 0 || f2 < 0.0f) {
            return;
        }
        this.o = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f2, this.f16577e);
        if (this.f16578f == null || (linearLayout = this.f16581i) == null || this.f16580h == null || this.m == null || linearLayout.getAlpha() == f2) {
            return;
        }
        this.f16581i.setAlpha(f2);
        this.m.setAlpha(f2);
        if (i2 == 0) {
            this.f16578f.setClickable(true);
            TbImageView tbImageView = this.f16579g;
            if (tbImageView != null) {
                tbImageView.setClickable(true);
            }
            l(true);
            o(true);
            return;
        }
        this.f16578f.setClickable(false);
        TbImageView tbImageView2 = this.f16579g;
        if (tbImageView2 != null) {
            tbImageView2.setClickable(false);
        }
        l(false);
        o(false);
    }

    public final void o(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                int i2 = layoutParams.rightMargin;
                int i3 = this.j;
                if (i2 != i3) {
                    layoutParams.rightMargin = i3;
                    this.m.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.m.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f16578f) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
            return;
        }
        TbImageView tbImageView = this.f16579g;
        if (view == tbImageView) {
            Object tag = tbImageView.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                g();
                NestedScrollHeader.f fVar = this.p;
                if (fVar != null) {
                    fVar.a(str);
                }
            }
        }
    }

    public void p() {
        this.f16580h.F();
    }

    public void setConcernTabIndex(int i2) {
        this.f16580h.setConcernTabIndex(i2);
    }

    public void setEntranceJumpListener(NestedScrollHeader.f fVar) {
        this.p = fVar;
    }

    public void setHotTopicTabIndex(int i2) {
        this.f16580h.setHotTopicIndex(i2);
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.f16579g.setVisibility(0);
            this.j = this.l;
            l(true);
            o(true);
            m();
            return;
        }
        this.j = this.k;
        this.f16579g.setVisibility(8);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f16580h.setOnPageChangeListener(onPageChangeListener);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        this.f16580h.setOnTabItemClickListener(cVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16580h;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setShowConcernRedTip(z);
        }
    }

    public void setShowHotTopicRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16580h;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setShowHotTopicRedTip(z);
        }
    }

    public void setTabItemClicked(boolean z) {
        this.f16580h.setTabItemClicked(z);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f16580h.setViewPager(viewPager);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16577e = 3;
        this.j = 0;
        this.n = R.color.CAM_X0105;
        d(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16577e = 3;
        this.j = 0;
        this.n = R.color.CAM_X0105;
        d(context);
    }
}

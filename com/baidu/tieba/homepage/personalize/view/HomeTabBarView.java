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
import d.b.c.e.l.c;
import d.b.c.e.l.d;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f16988e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16989f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16990g;

    /* renamed from: h  reason: collision with root package name */
    public PagerSlidingTabStrip f16991h;
    public LinearLayout i;
    public int j;
    public int k;
    public int l;
    public View m;
    public int n;
    public float o;
    public NestedScrollHeader.f p;

    /* loaded from: classes4.dex */
    public class a extends c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16992a;

        public a(String str) {
            this.f16992a = str;
        }

        @Override // d.b.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                HomeTabBarView.this.f16990g.setImageResource(R.drawable.icon_use_gold_n);
                HomeTabBarView.this.f16990g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                return;
            }
            HomeTabBarView.this.f16990g.setImageBitmap(aVar.p());
            HomeTabBarView.this.f16990g.setTag(R.id.homepage_mission_entrance_url, this.f16992a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View y = HomeTabBarView.this.f16991h.y(HomeTabBarView.this.f16991h.getCurrentTabIndex());
            if (y == null || y.getRight() <= HomeTabBarView.this.f16991h.getRight()) {
                return;
            }
            HomeTabBarView.this.f16991h.scrollTo(HomeTabBarView.this.f16991h.getScrollX() + y.getWidth(), 0);
        }
    }

    public HomeTabBarView(Context context) {
        super(context);
        this.f16988e = 3;
        this.j = 0;
        this.n = R.color.CAM_X0105;
        d(context);
    }

    public View c(int i) {
        return this.f16991h.y(i);
    }

    public final void d(Context context) {
        this.k = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.j = this.k;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.home_page_search_icon);
        this.f16989f = imageView;
        imageView.setClickable(false);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.f16991h = pagerSlidingTabStrip;
        pagerSlidingTabStrip.z(l.g(context, R.dimen.T_X06), l.g(context, R.dimen.T_X04), l.g(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.f16991h.setExpandedTabLayoutParams(layoutParams);
        this.i = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        this.m = findViewById(R.id.home_page_shadow);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.home_page_get_money);
        this.f16990g = tbImageView;
        tbImageView.setClickable(false);
        this.f16989f.setOnClickListener(this);
        this.f16990g.setOnClickListener(this);
        setOnClickListener(this);
        o(0.0f);
        k();
    }

    public boolean e() {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16991h;
        if (pagerSlidingTabStrip != null) {
            return pagerSlidingTabStrip.A();
        }
        return false;
    }

    public boolean f() {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16991h;
        if (pagerSlidingTabStrip != null) {
            return pagerSlidingTabStrip.B();
        }
        return false;
    }

    public float getBackgroundAlpha() {
        return this.o;
    }

    public ImageView getTaskView() {
        return this.f16990g;
    }

    public final void h() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    public void i() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    public void j() {
        this.f16991h.C();
    }

    public void k() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16988e) {
            return;
        }
        this.f16988e = skinType;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, this.o, skinType);
        this.f16989f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.n), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f16991h.D();
        SkinManager.setBackgroundResource(this.m, R.drawable.home_page_tab_shadow);
    }

    public void l() {
        this.f16989f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.n), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public final void m(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16991h.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                int i = layoutParams.rightMargin;
                int i2 = this.j;
                if (i != i2) {
                    layoutParams.rightMargin = i2;
                    this.f16991h.setLayoutParams(layoutParams);
                    this.f16991h.post(new b());
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.f16991h.setLayoutParams(layoutParams);
            }
        }
    }

    public final void n() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
            d.h().m(missionEntranceIcon, 10, new a(missionEntranceUrl), null);
            return;
        }
        this.f16990g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
        this.f16990g.setImageResource(R.drawable.icon_use_gold_n);
    }

    public void o(float f2) {
        LinearLayout linearLayout;
        int i = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
        if (i > 0 || f2 < 0.0f) {
            return;
        }
        this.o = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f2, this.f16988e);
        if (this.f16989f == null || (linearLayout = this.i) == null || this.f16991h == null || this.m == null || linearLayout.getAlpha() == f2) {
            return;
        }
        this.i.setAlpha(f2);
        this.m.setAlpha(f2);
        if (i == 0) {
            this.f16989f.setClickable(true);
            TbImageView tbImageView = this.f16990g;
            if (tbImageView != null) {
                tbImageView.setClickable(true);
            }
            m(true);
            p(true);
            return;
        }
        this.f16989f.setClickable(false);
        TbImageView tbImageView2 = this.f16990g;
        if (tbImageView2 != null) {
            tbImageView2.setClickable(false);
        }
        m(false);
        p(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f16989f) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
            return;
        }
        TbImageView tbImageView = this.f16990g;
        if (view == tbImageView) {
            Object tag = tbImageView.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                h();
                NestedScrollHeader.f fVar = this.p;
                if (fVar != null) {
                    fVar.a(str);
                }
            }
        }
    }

    public final void p(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                int i = layoutParams.rightMargin;
                int i2 = this.j;
                if (i != i2) {
                    layoutParams.rightMargin = i2;
                    this.m.setLayoutParams(layoutParams);
                }
            } else if (layoutParams.rightMargin != 0) {
                layoutParams.rightMargin = 0;
                this.m.setLayoutParams(layoutParams);
            }
        }
    }

    public void q() {
        this.f16991h.F();
    }

    public void setConcernTabIndex(int i) {
        this.f16991h.setConcernTabIndex(i);
    }

    public void setEntranceJumpListener(NestedScrollHeader.f fVar) {
        this.p = fVar;
    }

    public void setHotTopicTabIndex(int i) {
        this.f16991h.setHotTopicIndex(i);
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.f16990g.setVisibility(0);
            this.j = this.l;
            m(true);
            p(true);
            n();
            return;
        }
        this.j = this.k;
        this.f16990g.setVisibility(8);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f16991h.setOnPageChangeListener(onPageChangeListener);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        this.f16991h.setOnTabItemClickListener(cVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16991h;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setShowConcernRedTip(z);
        }
    }

    public void setShowHotTopicRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16991h;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setShowHotTopicRedTip(z);
        }
    }

    public void setTabItemClicked(boolean z) {
        this.f16991h.setTabItemClicked(z);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f16991h.setViewPager(viewPager);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16988e = 3;
        this.j = 0;
        this.n = R.color.CAM_X0105;
        d(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16988e = 3;
        this.j = 0;
        this.n = R.color.CAM_X0105;
        d(context);
    }
}

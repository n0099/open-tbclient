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
    public int f16555e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16556f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16557g;

    /* renamed from: h  reason: collision with root package name */
    public PagerSlidingTabStrip f16558h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f16559i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public NestedScrollHeader.f o;

    /* loaded from: classes4.dex */
    public class a extends c<d.a.c.k.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16560a;

        public a(String str) {
            this.f16560a = str;
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
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                HomeTabBarView.this.f16557g.setImageResource(R.drawable.icon_use_gold_n);
                HomeTabBarView.this.f16557g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                return;
            }
            HomeTabBarView.this.f16557g.setImageBitmap(aVar.p());
            HomeTabBarView.this.f16557g.setTag(R.id.homepage_mission_entrance_url, this.f16560a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View y = HomeTabBarView.this.f16558h.y(HomeTabBarView.this.f16558h.getCurrentTabIndex());
            if (y == null || y.getRight() <= HomeTabBarView.this.f16558h.getRight()) {
                return;
            }
            HomeTabBarView.this.f16558h.scrollTo(HomeTabBarView.this.f16558h.getScrollX() + y.getWidth(), 0);
        }
    }

    public HomeTabBarView(Context context) {
        super(context);
        this.f16555e = 3;
        this.j = 0;
        this.m = R.color.CAM_X0105;
        d(context);
    }

    public View c(int i2) {
        return this.f16558h.y(i2);
    }

    public final void d(Context context) {
        this.k = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
        this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
        this.j = this.k;
        LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.home_page_search_icon);
        this.f16556f = imageView;
        imageView.setClickable(false);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
        this.f16558h = pagerSlidingTabStrip;
        pagerSlidingTabStrip.z(l.g(context, R.dimen.T_X06), l.g(context, R.dimen.T_X04), l.g(context, R.dimen.tbds10), true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
        layoutParams.gravity = 1;
        layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
        this.f16558h.setExpandedTabLayoutParams(layoutParams);
        this.f16558h.setHorizontalFadingEdgeEnabled(true);
        this.f16558h.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
        this.f16559i = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.home_page_get_money);
        this.f16557g = tbImageView;
        tbImageView.setClickable(false);
        this.f16556f.setOnClickListener(this);
        this.f16557g.setOnClickListener(this);
        setOnClickListener(this);
        o(0.0f);
        k();
    }

    public boolean e() {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16558h;
        if (pagerSlidingTabStrip != null) {
            return pagerSlidingTabStrip.A();
        }
        return false;
    }

    public boolean f() {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16558h;
        if (pagerSlidingTabStrip != null) {
            return pagerSlidingTabStrip.B();
        }
        return false;
    }

    public float getBackgroundAlpha() {
        return this.n;
    }

    public ImageView getTaskView() {
        return this.f16557g;
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
        this.f16558h.C();
    }

    public void k() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16555e) {
            return;
        }
        this.f16555e = skinType;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, this.n, skinType);
        this.f16556f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.m), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f16558h.D();
    }

    public void l() {
        this.f16556f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.m), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public final void m(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16558h.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                int i2 = layoutParams.rightMargin;
                int i3 = this.j;
                if (i2 != i3) {
                    layoutParams.rightMargin = i3;
                    this.f16558h.setLayoutParams(layoutParams);
                    this.f16558h.post(new b());
                    return;
                }
                return;
            }
            int i4 = layoutParams.rightMargin;
            int i5 = this.j;
            if (i4 != i5) {
                layoutParams.rightMargin = i5;
                this.f16558h.setLayoutParams(layoutParams);
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
        this.f16557g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
        this.f16557g.setImageResource(R.drawable.icon_use_gold_n);
    }

    public void o(float f2) {
        LinearLayout linearLayout;
        int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
        if (i2 > 0 || f2 < 0.0f) {
            return;
        }
        this.n = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f2, this.f16555e);
        if (this.f16556f == null || (linearLayout = this.f16559i) == null || this.f16558h == null || linearLayout.getAlpha() == f2) {
            return;
        }
        this.f16559i.setAlpha(f2);
        if (i2 == 0) {
            this.f16556f.setClickable(true);
            TbImageView tbImageView = this.f16557g;
            if (tbImageView != null) {
                tbImageView.setClickable(true);
            }
            m(true);
            return;
        }
        this.f16556f.setClickable(false);
        TbImageView tbImageView2 = this.f16557g;
        if (tbImageView2 != null) {
            tbImageView2.setClickable(false);
        }
        m(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f16556f) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
            return;
        }
        TbImageView tbImageView = this.f16557g;
        if (view == tbImageView) {
            Object tag = tbImageView.getTag(R.id.homepage_mission_entrance_url);
            if (tag instanceof String) {
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                h();
                NestedScrollHeader.f fVar = this.o;
                if (fVar != null) {
                    fVar.a(str);
                }
            }
        }
    }

    public void setConcernTabIndex(int i2) {
        this.f16558h.setConcernTabIndex(i2);
    }

    public void setEntranceJumpListener(NestedScrollHeader.f fVar) {
        this.o = fVar;
    }

    public void setHotTopicTabIndex(int i2) {
        this.f16558h.setHotTopicIndex(i2);
    }

    public void setMissionEntranceVisibility(boolean z) {
        if (z) {
            this.f16557g.setVisibility(0);
            this.j = this.l;
            m(true);
            n();
            return;
        }
        this.j = this.k;
        this.f16557g.setVisibility(8);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f16558h.setOnPageChangeListener(onPageChangeListener);
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        this.f16558h.setOnTabItemClickListener(cVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16558h;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setShowConcernRedTip(z);
        }
    }

    public void setShowHotTopicRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.f16558h;
        if (pagerSlidingTabStrip != null) {
            pagerSlidingTabStrip.setShowHotTopicRedTip(z);
        }
    }

    public void setTabItemClicked(boolean z) {
        this.f16558h.setTabItemClicked(z);
    }

    public void setViewPager(ViewPager viewPager) {
        this.f16558h.setViewPager(viewPager);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16555e = 3;
        this.j = 0;
        this.m = R.color.CAM_X0105;
        d(context);
    }

    public HomeTabBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16555e = 3;
        this.j = 0;
        this.m = R.color.CAM_X0105;
        d(context);
    }
}

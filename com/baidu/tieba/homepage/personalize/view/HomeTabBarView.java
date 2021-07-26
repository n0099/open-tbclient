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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.l.c;
import d.a.d.e.l.d;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16868e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16869f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16870g;

    /* renamed from: h  reason: collision with root package name */
    public PagerSlidingTabStrip f16871h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f16872i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public NestedScrollHeader.f o;

    /* loaded from: classes4.dex */
    public class a extends c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16873a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomeTabBarView f16874b;

        public a(HomeTabBarView homeTabBarView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16874b = homeTabBarView;
            this.f16873a = str;
        }

        @Override // d.a.d.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // d.a.d.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                    this.f16874b.f16870g.setImageResource(R.drawable.icon_use_gold_n);
                    this.f16874b.f16870g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                this.f16874b.f16870g.setImageBitmap(aVar.p());
                this.f16874b.f16870g.setTag(R.id.homepage_mission_entrance_url, this.f16873a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeTabBarView f16875e;

        public b(HomeTabBarView homeTabBarView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16875e = homeTabBarView;
        }

        @Override // java.lang.Runnable
        public void run() {
            View y;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (y = this.f16875e.f16871h.y(this.f16875e.f16871h.getCurrentTabIndex())) == null || y.getRight() <= this.f16875e.f16871h.getRight()) {
                return;
            }
            this.f16875e.f16871h.scrollTo(this.f16875e.f16871h.getScrollX() + y.getWidth(), 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBarView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16868e = 3;
        this.j = 0;
        this.m = R.color.CAM_X0105;
        d(context);
    }

    public View c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f16871h.y(i2) : (View) invokeI.objValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.k = getContext().getResources().getDimensionPixelSize(R.dimen.tbds150);
            this.l = getContext().getResources().getDimensionPixelSize(R.dimen.tbds264);
            this.j = this.k;
            LayoutInflater.from(context).inflate(R.layout.home_tab_bar_view_layout, (ViewGroup) this, true);
            ImageView imageView = (ImageView) findViewById(R.id.home_page_search_icon);
            this.f16869f = imageView;
            imageView.setClickable(false);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.home_page_tabstrip);
            this.f16871h = pagerSlidingTabStrip;
            pagerSlidingTabStrip.z(l.g(context, R.dimen.T_X06), l.g(context, R.dimen.T_X04), l.g(context, R.dimen.tbds10), true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.gravity = 1;
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
            this.f16871h.setExpandedTabLayoutParams(layoutParams);
            this.f16871h.setHorizontalFadingEdgeEnabled(true);
            this.f16871h.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
            this.f16872i = (LinearLayout) findViewById(R.id.home_page_search_icon_layout);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.home_page_get_money);
            this.f16870g = tbImageView;
            tbImageView.setClickable(false);
            this.f16869f.setOnClickListener(this);
            this.f16870g.setOnClickListener(this);
            setOnClickListener(this);
            n(0.0f);
            j();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.f16871h;
            if (pagerSlidingTabStrip != null) {
                return pagerSlidingTabStrip.A();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.f16871h;
            if (pagerSlidingTabStrip != null) {
                return pagerSlidingTabStrip.B();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public float getBackgroundAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : invokeV.floatValue;
    }

    public ImageView getTaskView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16870g : (ImageView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f16871h.C();
        }
    }

    public void j() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f16868e) {
            return;
        }
        this.f16868e = skinType;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, this.n, skinType);
        this.f16869f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.m), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f16871h.D();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16869f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(this.m), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void l(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (layoutParams = (RelativeLayout.LayoutParams) this.f16871h.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            int i2 = layoutParams.rightMargin;
            int i3 = this.j;
            if (i2 != i3) {
                layoutParams.rightMargin = i3;
                this.f16871h.setLayoutParams(layoutParams);
                this.f16871h.post(new b(this));
                return;
            }
            return;
        }
        int i4 = layoutParams.rightMargin;
        int i5 = this.j;
        if (i4 != i5) {
            layoutParams.rightMargin = i5;
            this.f16871h.setLayoutParams(layoutParams);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
            String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
            if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
                d.h().m(missionEntranceIcon, 10, new a(this, missionEntranceUrl), null);
                return;
            }
            this.f16870g.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.f16870g.setImageResource(R.drawable.icon_use_gold_n);
        }
    }

    public void n(float f2) {
        int i2;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f2) == null) || f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        this.n = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f2, this.f16868e);
        if (this.f16869f == null || (linearLayout = this.f16872i) == null || this.f16871h == null || linearLayout.getAlpha() == f2) {
            return;
        }
        this.f16872i.setAlpha(f2);
        if (i2 == 0) {
            this.f16869f.setClickable(true);
            TbImageView tbImageView = this.f16870g;
            if (tbImageView != null) {
                tbImageView.setClickable(true);
            }
            l(true);
            return;
        }
        this.f16869f.setClickable(false);
        TbImageView tbImageView2 = this.f16870g;
        if (tbImageView2 != null) {
            tbImageView2.setClickable(false);
        }
        l(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            if (view == this.f16869f) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(getContext(), "", false)));
                return;
            }
            TbImageView tbImageView = this.f16870g;
            if (view == tbImageView) {
                Object tag = tbImageView.getTag(R.id.homepage_mission_entrance_url);
                if (tag instanceof String) {
                    String str = (String) tag;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    g();
                    NestedScrollHeader.f fVar = this.o;
                    if (fVar != null) {
                        fVar.a(str);
                    }
                }
            }
        }
    }

    public void setConcernTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f16871h.setConcernTabIndex(i2);
        }
    }

    public void setEntranceJumpListener(NestedScrollHeader.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void setHotTopicTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f16871h.setHotTopicIndex(i2);
        }
    }

    public void setMissionEntranceVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.f16870g.setVisibility(0);
                this.j = this.l;
                l(true);
                m();
                return;
            }
            this.j = this.k;
            this.f16870g.setVisibility(8);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onPageChangeListener) == null) {
            this.f16871h.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.f16871h.setOnTabItemClickListener(cVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
        }
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (pagerSlidingTabStrip = this.f16871h) == null) {
            return;
        }
        pagerSlidingTabStrip.setShowConcernRedTip(z);
    }

    public void setShowHotTopicRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (pagerSlidingTabStrip = this.f16871h) == null) {
            return;
        }
        pagerSlidingTabStrip.setShowHotTopicRedTip(z);
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f16871h.setTabItemClicked(z);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, viewPager) == null) {
            this.f16871h.setViewPager(viewPager);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16868e = 3;
        this.j = 0;
        this.m = R.color.CAM_X0105;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f16868e = 3;
        this.j = 0;
        this.m = R.color.CAM_X0105;
        d(context);
    }
}

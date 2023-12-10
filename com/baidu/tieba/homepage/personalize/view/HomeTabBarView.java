package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.LiveEnterForumTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a2b;
import com.baidu.tieba.ar6;
import com.baidu.tieba.br6;
import com.baidu.tieba.er6;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.nqa;
import com.baidu.tieba.xc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes6.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PagerSlidingTabStrip a;
    public float b;
    public BdUniqueId c;
    public LiveTipLabelView d;
    public boolean e;
    public boolean f;
    public List<AlaLiveInfo> g;
    public ViewTreeObserver.OnGlobalLayoutListener h;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends er6<xc8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeTabBarView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomeTabBarView homeTabBarView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homeTabBarView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(@NonNull xc8 xc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc8Var) == null) {
                this.b.g = xc8Var.a();
                if (!ListUtils.isEmpty(this.b.g) && this.b.f && !this.b.e) {
                    DefaultLog.getInstance().i("liveTipLog", "直播二楼数据返回更新并渲染直播tip");
                    this.b.q();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<HomeTabBarView> a;

        public b(HomeTabBarView homeTabBarView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(homeTabBarView);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            HomeTabBarView homeTabBarView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (homeTabBarView = this.a.get()) == null || homeTabBarView.f) {
                return;
            }
            homeTabBarView.f = true;
            DefaultLog.getInstance().i("liveTipLog", "TabBarView页面初始化完成");
            if (!homeTabBarView.e && homeTabBarView.g != null) {
                DefaultLog.getInstance().i("liveTipLog", "TabBarView页面初始化完成并渲染直播tip");
                homeTabBarView.q();
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = false;
        this.g = null;
        i(context);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = false;
        this.g = null;
        i(context);
    }

    public void p(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            r(i);
            View h = h(0);
            if ((h instanceof LinearLayout) && TbadkCoreApplication.isLogin() && UbsABTestHelper.isConcernForumCardShow()) {
                LinearLayout linearLayout = (LinearLayout) h;
                if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == 0) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = false;
        this.g = null;
        i(context);
    }

    public View h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.a.z(i);
        }
        return (View) invokeI.objValue;
    }

    public void r(int i) {
        LiveTipLabelView liveTipLabelView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && i == getConcernTabIndex() && (liveTipLabelView = this.d) != null) {
            liveTipLabelView.e();
        }
    }

    public void s(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048592, this, f) == null) && f <= 1.0f && f >= 0.0f) {
            this.b = f;
            SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.a.setConcernTabIndex(i);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onPageChangeListener) == null) {
            this.a.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.a.setOnTabItemClickListener(cVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
            j();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (pagerSlidingTabStrip = this.a) != null) {
            pagerSlidingTabStrip.setShowConcernRedTip(z);
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.a.setTabItemClicked(z);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, viewPager) == null) {
            this.a.setViewPager(viewPager);
        }
    }

    public void g(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a.s(z, z2);
            LiveTipLabelView liveTipLabelView = this.d;
            if (liveTipLabelView != null) {
                liveTipLabelView.i();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5003);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5004);
        }
    }

    private int getConcernTabIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            if (pagerSlidingTabStrip != null && pagerSlidingTabStrip.getAdapter() != null) {
                return this.a.getAdapter().p();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public float getBackgroundAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.floatValue;
    }

    public View getTabStrip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            if (pagerSlidingTabStrip != null) {
                return pagerSlidingTabStrip.B();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.C();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.D();
            LiveTipLabelView liveTipLabelView = this.d;
            if (liveTipLabelView != null) {
                liveTipLabelView.i();
            }
        }
    }

    public void o() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            if (pagerSlidingTabStrip != null) {
                pagerSlidingTabStrip.setOnTabItemClickListener(null);
            }
            LiveTipLabelView liveTipLabelView = this.d;
            if (liveTipLabelView != null) {
                liveTipLabelView.j();
            }
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null && (onGlobalLayoutListener = this.h) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    public void setTabStripCenterInParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.removeRule(9);
            this.a.setLayoutParams(layoutParams);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4008);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0424, (ViewGroup) this, true);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090ff4);
            this.a = pagerSlidingTabStrip;
            pagerSlidingTabStrip.A(BdUtilHelper.getDimens(context, R.dimen.T_X06), BdUtilHelper.getDimens(context, R.dimen.T_X04), BdUtilHelper.getDimens(context, R.dimen.tbds10), true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.gravity = 1;
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
            this.a.setExpandedTabLayoutParams(layoutParams);
            this.a.setHorizontalFadingEdgeEnabled(true);
            this.a.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
            setOnClickListener(this);
            s(0.0f);
            n();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4009);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DefaultLog.getInstance().i("liveTipLog", "注册直播二楼数据更新event");
            br6.b().b(new ar6(this.c, xc8.class), new a(this, xc8.class));
            if (this.h == null) {
                this.h = new b(this);
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.h);
                }
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5011);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5012);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            View h = h(getConcernTabIndex());
            if (!a2b.b().a() && LiveEnterForumTestHelper.isLiveEnterForumTestA() && !nqa.c().a() && h != null && this.a != null) {
                this.e = true;
                if (this.d == null) {
                    this.d = new LiveTipLabelView(getContext());
                }
                this.d.setViewLocation(this, this.a.getLeft() + h.getRight(), h.getTop());
            }
        }
    }
}

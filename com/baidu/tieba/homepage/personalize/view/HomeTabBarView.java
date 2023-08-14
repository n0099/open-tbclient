package com.baidu.tieba.homepage.personalize.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.view.NewHotTipLabelView;
import com.baidu.tieba.l08;
import com.baidu.tieba.rc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class HomeTabBarView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PagerSlidingTabStrip a;
    public float b;
    public NewHotTipLabelView c;
    public View d;
    public float e;
    public float f;
    public int g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public final Runnable i;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeTabBarView a;

        public a(HomeTabBarView homeTabBarView) {
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
            this.a = homeTabBarView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.o()) {
                HomeTabBarView homeTabBarView = this.a;
                homeTabBarView.k(homeTabBarView.c, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements PagerSlidingTabStrip.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeTabBarView a;

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
            this.a = homeTabBarView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.b
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.g = i;
            this.a.u(i);
            this.a.x(i);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements NewHotTipLabelView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomeTabBarView a;

        public c(HomeTabBarView homeTabBarView) {
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
            this.a = homeTabBarView;
        }

        @Override // com.baidu.tieba.homepage.personalize.view.NewHotTipLabelView.a
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeHandler.getInst().postDelayed(this.a.i, 5000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ HomeTabBarView b;

        public d(HomeTabBarView homeTabBarView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeTabBarView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homeTabBarView;
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<HomeTabBarView> a;

        public e(HomeTabBarView homeTabBarView) {
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (homeTabBarView = this.a.get()) == null) {
                return;
            }
            homeTabBarView.y();
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
        this.i = new a(this);
        n(context);
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
        this.i = new a(this);
        n(context);
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
        this.i = new a(this);
        n(context);
    }

    public View l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return this.a.z(i);
        }
        return (View) invokeI.objValue;
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a.setConcernTabIndex(i);
        }
    }

    public void setHotLabelData(rc5 rc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, rc5Var) == null) {
            if (this.c == null) {
                y();
            }
            NewHotTipLabelView newHotTipLabelView = this.c;
            if (newHotTipLabelView != null) {
                newHotTipLabelView.setData(rc5Var);
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onPageChangeListener) == null) {
            this.a.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void setOnTabItemClickListener(PagerSlidingTabStrip.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            this.a.setOnTabItemClickListener(cVar);
        }
    }

    public void setShowConcernRedTip(boolean z) {
        PagerSlidingTabStrip pagerSlidingTabStrip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z) == null) && (pagerSlidingTabStrip = this.a) != null) {
            pagerSlidingTabStrip.setShowConcernRedTip(z);
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.a.setTabItemClicked(z);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, viewPager) == null) {
            this.a.setViewPager(viewPager);
        }
    }

    public final void u(int i) {
        NewHotTipLabelView newHotTipLabelView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048604, this, i) != null) || (newHotTipLabelView = this.c) == null) {
            return;
        }
        newHotTipLabelView.setTranslationX(this.e - i);
    }

    public final void x(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i) != null) || (view2 = this.d) == null) {
            return;
        }
        view2.setTranslationX(this.e - i);
    }

    public void z(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048607, this, f) == null) && f <= 1.0f && f >= 0.0f) {
            this.b = f;
            SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5003);
            super.onMeasure(i, i2);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5004);
        }
    }

    public float getBackgroundAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.floatValue;
    }

    public int getHotTopicIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            if (pagerSlidingTabStrip != null && pagerSlidingTabStrip.getAdapter() != null) {
                return this.a.getAdapter().r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public View getTabStrip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            NewHotTipLabelView newHotTipLabelView = this.c;
            if (newHotTipLabelView == null) {
                return false;
            }
            if (newHotTipLabelView.getVisibility() != 0 && this.d.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            if (pagerSlidingTabStrip != null) {
                return pagerSlidingTabStrip.B();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.C();
            if (this.h == null) {
                this.h = new e(this);
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.h);
                }
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.D();
            NewHotTipLabelView newHotTipLabelView = this.c;
            if (newHotTipLabelView != null) {
                newHotTipLabelView.b(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setTabStripCenterInParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.removeRule(9);
            this.a.setLayoutParams(layoutParams);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.c == null) {
                this.c = new NewHotTipLabelView(getContext());
            }
            if (this.d == null) {
                this.d = j(this);
            }
            this.c.setView(this, this.e + this.g, this.f);
            this.d.setTranslationX(this.e + this.g);
            this.d.setTranslationY(this.f);
            this.c.setHotTipCallBack(new c(this));
        }
    }

    public void y() {
        View l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && getHotTopicIndex() >= 0 && (l = l(getHotTopicIndex())) != null && this.a != null) {
            int left = (this.a.getLeft() + l.getRight()) - UtilHelper.getDimenPixelSize(R.dimen.tbds36);
            int top = l.getTop();
            float f = left;
            if (this.e != f || this.f != top) {
                this.e = f;
                this.f = top;
                h();
            }
        }
    }

    public void i(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a.s(z, z2);
            NewHotTipLabelView newHotTipLabelView = this.c;
            if (newHotTipLabelView != null) {
                newHotTipLabelView.b(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void k(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, view3) == null) {
            view3.setAlpha(0.0f);
            view3.setVisibility(0);
            view3.animate().alpha(1.0f).setDuration(800L).setListener(null);
            view2.animate().alpha(0.0f).setDuration(800L).setListener(new d(this, view2));
        }
    }

    public View j(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds18), BdUtilHelper.getDimens(getContext(), R.dimen.tbds18));
            layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds20);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds11);
            View view2 = new View(getContext());
            view2.setLayoutParams(layoutParams);
            SkinManager.setBackgroundResource(view2, R.drawable.icon_news_red_dot);
            view2.setTag(Integer.valueOf((int) R.id.obfuscated_res_0x7f090fd6));
            view2.setVisibility(8);
            viewGroup.addView(view2);
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(4008);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0400, (ViewGroup) this, true);
            PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.obfuscated_res_0x7f090f79);
            this.a = pagerSlidingTabStrip;
            pagerSlidingTabStrip.A(BdUtilHelper.getDimens(context, R.dimen.T_X06), BdUtilHelper.getDimens(context, R.dimen.T_X04), BdUtilHelper.getDimens(context, R.dimen.tbds10), true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.gravity = 1;
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
            this.a.setExpandedTabLayoutParams(layoutParams);
            this.a.setHorizontalFadingEdgeEnabled(true);
            this.a.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds70));
            this.a.setScrollListener(new b(this));
            setOnClickListener(this);
            z(0.0f);
            r();
            SpeedStatsManager.getInstance().addStatsTimeStamp(4009);
        }
    }

    public void m() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            NewHotTipLabelView newHotTipLabelView = this.c;
            if (newHotTipLabelView != null) {
                newHotTipLabelView.setVisibility(8);
                this.d.setVisibility(8);
                l08.c("key_new_hot_tip_dismiss_time", System.currentTimeMillis());
                this.c.c();
            }
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null && (onGlobalLayoutListener = this.h) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    public void s() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.i);
            NewHotTipLabelView newHotTipLabelView = this.c;
            if (newHotTipLabelView != null) {
                newHotTipLabelView.setHotTipCallBack(null);
            }
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null && (onGlobalLayoutListener = this.h) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            if (pagerSlidingTabStrip != null) {
                pagerSlidingTabStrip.setOnTabItemClickListener(null);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5011);
            super.onLayout(z, i, i2, i3, i4);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5012);
        }
    }
}

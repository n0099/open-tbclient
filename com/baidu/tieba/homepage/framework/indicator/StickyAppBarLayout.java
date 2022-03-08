package com.baidu.tieba.homepage.framework.indicator;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import c.a.q0.h0.e;
import c.a.q0.r.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes5.dex */
public class StickyAppBarLayout extends AppBarLayout implements e.a, e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public StickyAppBarLayoutBehavior f42901e;

    /* renamed from: f  reason: collision with root package name */
    public b f42902f;

    /* renamed from: g  reason: collision with root package name */
    public NestedScrollHeader f42903g;

    /* renamed from: h  reason: collision with root package name */
    public HomeTabBarView f42904h;

    /* renamed from: i  reason: collision with root package name */
    public View f42905i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f42906j;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StickyAppBarLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(StickyAppBarLayout stickyAppBarLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stickyAppBarLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = stickyAppBarLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (bool = (Boolean) customResponsedMessage.getData()) == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.a.showHeader();
            } else if (this.a.isSticky()) {
            } else {
                this.a.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickyAppBarLayout(Context context) {
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
        this.f42906j = new a(this, 2921441);
        c(context);
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f42901e == null) {
                d();
            }
            StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior = this.f42901e;
            if (stickyAppBarLayoutBehavior != null) {
                stickyAppBarLayoutBehavior.hideHeader();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.home_page_header_view_layout, (ViewGroup) this, true);
            this.f42903g = (NestedScrollHeader) findViewById(R.id.home_nested_header);
            this.f42904h = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
            this.f42905i = findViewById(R.id.divider_line);
            CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
            layoutParams.setBehavior(new StickyAppBarLayoutBehavior());
            setOrientation(1);
            setLayoutParams(layoutParams);
            try {
                ViewCompat.setElevation(this, 0.0f);
                StateListAnimator stateListAnimator = new StateListAnimator();
                stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f));
                setStateListAnimator(stateListAnimator);
            } catch (Exception unused) {
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.f42901e = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
            statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
            TiebaStatic.log(statisticItem);
        }
    }

    public View getDividerLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42905i : (View) invokeV.objValue;
    }

    public HomeTabBarView getHomeTabBarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42904h : (HomeTabBarView) invokeV.objValue;
    }

    public NestedScrollHeader getNestedHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42903g : (NestedScrollHeader) invokeV.objValue;
    }

    public b getOnHeaderStickyListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42902f : (b) invokeV.objValue;
    }

    @Override // c.a.q0.h0.e.a
    public void initAndLoadForPreShow(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.f42904h.setMissionEntranceVisibility(false);
            this.f42904h.updateDataWithoutViewPager();
        }
    }

    public boolean isSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f42901e == null) {
                d();
            }
            StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior = this.f42901e;
            if (stickyAppBarLayoutBehavior != null) {
                return stickyAppBarLayoutBehavior.isSticky();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.f42906j);
        }
    }

    @Override // c.a.q0.h0.e.b
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            c.d(this).o(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
            NestedScrollHeader nestedScrollHeader = this.f42903g;
            if (nestedScrollHeader != null) {
                nestedScrollHeader.onChangeSkinType();
            }
            HomeTabBarView homeTabBarView = this.f42904h;
            if (homeTabBarView != null) {
                homeTabBarView.onChangeSkinType();
            }
            View view = this.f42905i;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0203);
            }
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.f42906j);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onFinishInflate();
            d();
        }
    }

    public void resetHeaderStickyListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f42902f = null;
            StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior = this.f42901e;
            if (stickyAppBarLayoutBehavior != null) {
                stickyAppBarLayoutBehavior.setOnHeaderStickyListener(null);
            }
        }
    }

    public void setOnHeaderStickyListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.f42902f = bVar;
        }
    }

    public boolean showHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f42901e == null) {
                d();
            }
            if (this.f42901e != null) {
                if (isSticky() && this.f42901e.getHeaderView() != null && this.f42901e.getHeaderView().getVisibility() == 0) {
                    e();
                }
                this.f42901e.showHeader();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
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
        this.f42906j = new a(this, 2921441);
        c(context);
    }
}

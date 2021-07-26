package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes4.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f16685a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout f16686b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16687c;

    /* renamed from: d  reason: collision with root package name */
    public NestedScrollHeader f16688d;

    /* renamed from: e  reason: collision with root package name */
    public HomeTabBarView f16689e;

    /* renamed from: f  reason: collision with root package name */
    public View f16690f;

    /* renamed from: g  reason: collision with root package name */
    public float f16691g;

    /* renamed from: h  reason: collision with root package name */
    public StickyAppBarLayout.b f16692h;

    /* renamed from: i  reason: collision with root package name */
    public AppBarLayout.OnOffsetChangedListener f16693i;

    /* loaded from: classes4.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickyAppBarLayoutBehavior f16694a;

        public a(StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stickyAppBarLayoutBehavior};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16694a = stickyAppBarLayoutBehavior;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921553, Integer.valueOf(i2)));
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i2);
                int i3 = (abs > totalScrollRange ? 1 : (abs == totalScrollRange ? 0 : -1));
                if (i3 >= 0) {
                    if (!this.f16694a.f16685a) {
                        this.f16694a.f16685a = true;
                        if (this.f16694a.f16692h != null) {
                            this.f16694a.f16692h.a(this.f16694a.f16685a);
                        }
                    }
                } else if (this.f16694a.f16685a) {
                    this.f16694a.f16685a = false;
                    if (this.f16694a.f16692h != null) {
                        this.f16694a.f16692h.a(this.f16694a.f16685a);
                    }
                }
                if (this.f16694a.f16691g == abs) {
                    return;
                }
                this.f16694a.f16691g = abs;
                if (totalScrollRange <= 0.0f) {
                    return;
                }
                this.f16694a.m(abs != 0.0f ? i3 >= 0 ? 1.0f : abs / totalScrollRange : 0.0f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AppBarLayout.Behavior.DragCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stickyAppBarLayoutBehavior};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
        public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, appBarLayout)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public StickyAppBarLayoutBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16685a = false;
        this.f16687c = false;
        this.f16691g = -1.0f;
        this.f16693i = new a(this);
        j();
    }

    public void g() {
        StickyAppBarLayout.b onHeaderStickyListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AppBarLayout appBarLayout = this.f16686b;
            if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
                return;
            }
            k(onHeaderStickyListener);
        }
    }

    public NestedScrollHeader h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16688d : (NestedScrollHeader) invokeV.objValue;
    }

    public void i() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (appBarLayout = this.f16686b) == null) {
            return;
        }
        appBarLayout.setExpanded(false, true);
    }

    public boolean isSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16685a : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setDragCallback(new b(this));
        }
    }

    public void k(StickyAppBarLayout.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f16692h = bVar;
        }
    }

    public void l() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (appBarLayout = this.f16686b) == null) {
            return;
        }
        appBarLayout.setExpanded(true, true);
    }

    public final void m(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            HomeTabBarView homeTabBarView = this.f16689e;
            if (homeTabBarView != null) {
                homeTabBarView.n(f2);
            }
            NestedScrollHeader nestedScrollHeader = this.f16688d;
            if (nestedScrollHeader != null) {
                nestedScrollHeader.r(1.0f - f2);
            }
            View view = this.f16690f;
            if (view == null || f2 > 1.0f || f2 < 0.0f) {
                return;
            }
            if (i2 == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            this.f16690f.setAlpha(f2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams) == null) {
            super.onAttachedToLayoutParams(layoutParams);
            AppBarLayout appBarLayout = this.f16686b;
            if (appBarLayout == null || this.f16687c) {
                return;
            }
            appBarLayout.addOnOffsetChangedListener(this.f16693i);
            this.f16687c = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromLayoutParams();
            AppBarLayout appBarLayout = this.f16686b;
            if (appBarLayout == null || !this.f16687c) {
                return;
            }
            appBarLayout.removeOnOffsetChangedListener(this.f16693i);
            this.f16687c = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, coordinatorLayout, appBarLayout, i2)) == null) {
            if (this.f16686b == null) {
                this.f16686b = appBarLayout;
                View findViewById = appBarLayout.findViewById(R.id.home_nested_header);
                if (findViewById instanceof NestedScrollHeader) {
                    this.f16688d = (NestedScrollHeader) findViewById;
                }
                View findViewById2 = this.f16686b.findViewById(R.id.home_tab_bar_view);
                if (findViewById2 instanceof HomeTabBarView) {
                    this.f16689e = (HomeTabBarView) findViewById2;
                }
                this.f16690f = this.f16686b.findViewById(R.id.divider_line);
                g();
            }
            AppBarLayout appBarLayout2 = this.f16686b;
            if (appBarLayout2 != null && !this.f16687c) {
                appBarLayout2.addOnOffsetChangedListener(this.f16693i);
                this.f16687c = true;
            }
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
        }
        return invokeLLI.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
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
        this.f16685a = false;
        this.f16687c = false;
        this.f16691g = -1.0f;
        this.f16693i = new a(this);
        j();
    }
}

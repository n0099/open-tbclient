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
/* loaded from: classes5.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout f33291b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33292c;

    /* renamed from: d  reason: collision with root package name */
    public NestedScrollHeader f33293d;

    /* renamed from: e  reason: collision with root package name */
    public HomeTabBarView f33294e;

    /* renamed from: f  reason: collision with root package name */
    public View f33295f;

    /* renamed from: g  reason: collision with root package name */
    public float f33296g;

    /* renamed from: h  reason: collision with root package name */
    public StickyAppBarLayout.b f33297h;
    public AppBarLayout.OnOffsetChangedListener i;

    /* loaded from: classes5.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StickyAppBarLayoutBehavior a;

        public a(StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stickyAppBarLayoutBehavior};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = stickyAppBarLayoutBehavior;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921553, Integer.valueOf(i)));
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                int i2 = (abs > totalScrollRange ? 1 : (abs == totalScrollRange ? 0 : -1));
                if (i2 >= 0) {
                    if (!this.a.a) {
                        this.a.a = true;
                        if (this.a.f33297h != null) {
                            this.a.f33297h.a(this.a.a);
                        }
                    }
                } else if (this.a.a) {
                    this.a.a = false;
                    if (this.a.f33297h != null) {
                        this.a.f33297h.a(this.a.a);
                    }
                }
                if (this.a.f33296g == abs) {
                    return;
                }
                this.a.f33296g = abs;
                if (totalScrollRange <= 0.0f) {
                    return;
                }
                this.a.m(abs != 0.0f ? i2 >= 0 ? 1.0f : abs / totalScrollRange : 0.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f33292c = false;
        this.f33296g = -1.0f;
        this.i = new a(this);
        j();
    }

    public void g() {
        StickyAppBarLayout.b onHeaderStickyListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AppBarLayout appBarLayout = this.f33291b;
            if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
                return;
            }
            k(onHeaderStickyListener);
        }
    }

    public NestedScrollHeader h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33293d : (NestedScrollHeader) invokeV.objValue;
    }

    public void i() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (appBarLayout = this.f33291b) == null) {
            return;
        }
        appBarLayout.setExpanded(false, true);
    }

    public boolean isSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
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
            this.f33297h = bVar;
        }
    }

    public void l() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (appBarLayout = this.f33291b) == null) {
            return;
        }
        appBarLayout.setExpanded(true, true);
    }

    public final void m(float f2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            HomeTabBarView homeTabBarView = this.f33294e;
            if (homeTabBarView != null) {
                homeTabBarView.n(f2);
            }
            NestedScrollHeader nestedScrollHeader = this.f33293d;
            if (nestedScrollHeader != null) {
                nestedScrollHeader.p(1.0f - f2);
            }
            View view = this.f33295f;
            if (view == null || f2 > 1.0f || f2 < 0.0f) {
                return;
            }
            if (i == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            this.f33295f.setAlpha(f2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams) == null) {
            super.onAttachedToLayoutParams(layoutParams);
            AppBarLayout appBarLayout = this.f33291b;
            if (appBarLayout == null || this.f33292c) {
                return;
            }
            appBarLayout.addOnOffsetChangedListener(this.i);
            this.f33292c = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromLayoutParams();
            AppBarLayout appBarLayout = this.f33291b;
            if (appBarLayout == null || !this.f33292c) {
                return;
            }
            appBarLayout.removeOnOffsetChangedListener(this.i);
            this.f33292c = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, coordinatorLayout, appBarLayout, i)) == null) {
            if (this.f33291b == null) {
                this.f33291b = appBarLayout;
                View findViewById = appBarLayout.findViewById(R.id.obfuscated_res_0x7f090d7f);
                if (findViewById instanceof NestedScrollHeader) {
                    this.f33293d = (NestedScrollHeader) findViewById;
                }
                View findViewById2 = this.f33291b.findViewById(R.id.obfuscated_res_0x7f090d87);
                if (findViewById2 instanceof HomeTabBarView) {
                    this.f33294e = (HomeTabBarView) findViewById2;
                }
                this.f33295f = this.f33291b.findViewById(R.id.obfuscated_res_0x7f0907f4);
                g();
            }
            AppBarLayout appBarLayout2 = this.f33291b;
            if (appBarLayout2 != null && !this.f33292c) {
                appBarLayout2.addOnOffsetChangedListener(this.i);
                this.f33292c = true;
            }
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
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
        this.a = false;
        this.f33292c = false;
        this.f33296g = -1.0f;
        this.i = new a(this);
        j();
    }
}

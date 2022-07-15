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
/* loaded from: classes3.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public AppBarLayout b;
    public boolean c;
    public NestedScrollHeader d;
    public HomeTabBarView e;
    public View f;
    public float g;
    public StickyAppBarLayout.b h;
    public AppBarLayout.OnOffsetChangedListener i;

    /* loaded from: classes3.dex */
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
                        if (this.a.h != null) {
                            this.a.h.a(this.a.a);
                        }
                    }
                } else if (this.a.a) {
                    this.a.a = false;
                    if (this.a.h != null) {
                        this.a.h.a(this.a.a);
                    }
                }
                if (this.a.g == abs) {
                    return;
                }
                this.a.g = abs;
                if (totalScrollRange <= 0.0f) {
                    return;
                }
                this.a.m(abs != 0.0f ? i2 >= 0 ? 1.0f : abs / totalScrollRange : 0.0f);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.c = false;
        this.g = -1.0f;
        this.i = new a(this);
        j();
    }

    public void g() {
        StickyAppBarLayout.b onHeaderStickyListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AppBarLayout appBarLayout = this.b;
            if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
                return;
            }
            k(onHeaderStickyListener);
        }
    }

    public NestedScrollHeader h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (NestedScrollHeader) invokeV.objValue;
    }

    public void i() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (appBarLayout = this.b) == null) {
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
            this.h = bVar;
        }
    }

    public void l() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (appBarLayout = this.b) == null) {
            return;
        }
        appBarLayout.setExpanded(true, true);
    }

    public final void m(float f) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            HomeTabBarView homeTabBarView = this.e;
            if (homeTabBarView != null) {
                homeTabBarView.p(f);
            }
            NestedScrollHeader nestedScrollHeader = this.d;
            if (nestedScrollHeader != null) {
                nestedScrollHeader.p(1.0f - f);
            }
            View view2 = this.f;
            if (view2 == null || f > 1.0f || f < 0.0f) {
                return;
            }
            if (i == 0) {
                view2.setVisibility(8);
                return;
            }
            view2.setVisibility(0);
            this.f.setAlpha(f);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutParams) == null) {
            super.onAttachedToLayoutParams(layoutParams);
            AppBarLayout appBarLayout = this.b;
            if (appBarLayout == null || this.c) {
                return;
            }
            appBarLayout.addOnOffsetChangedListener(this.i);
            this.c = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromLayoutParams();
            AppBarLayout appBarLayout = this.b;
            if (appBarLayout == null || !this.c) {
                return;
            }
            appBarLayout.removeOnOffsetChangedListener(this.i);
            this.c = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, coordinatorLayout, appBarLayout, i)) == null) {
            if (this.b == null) {
                this.b = appBarLayout;
                View findViewById = appBarLayout.findViewById(R.id.obfuscated_res_0x7f090d39);
                if (findViewById instanceof NestedScrollHeader) {
                    this.d = (NestedScrollHeader) findViewById;
                }
                View findViewById2 = this.b.findViewById(R.id.obfuscated_res_0x7f090d43);
                if (findViewById2 instanceof HomeTabBarView) {
                    this.e = (HomeTabBarView) findViewById2;
                }
                this.f = this.b.findViewById(R.id.obfuscated_res_0x7f0907ca);
                g();
            }
            AppBarLayout appBarLayout2 = this.b;
            if (appBarLayout2 != null && !this.c) {
                appBarLayout2.addOnOffsetChangedListener(this.i);
                this.c = true;
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
        this.c = false;
        this.g = -1.0f;
        this.i = new a(this);
        j();
    }
}

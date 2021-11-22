package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
/* loaded from: classes9.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50456a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout f50457b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50458c;

    /* renamed from: d  reason: collision with root package name */
    public NestedScrollHeader f50459d;

    /* renamed from: e  reason: collision with root package name */
    public HomeTabBarView f50460e;

    /* renamed from: f  reason: collision with root package name */
    public View f50461f;

    /* renamed from: g  reason: collision with root package name */
    public float f50462g;

    /* renamed from: h  reason: collision with root package name */
    public StickyAppBarLayout.b f50463h;

    /* renamed from: i  reason: collision with root package name */
    public AppBarLayout.OnOffsetChangedListener f50464i;

    /* loaded from: classes9.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StickyAppBarLayoutBehavior f50465a;

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
            this.f50465a = stickyAppBarLayoutBehavior;
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
                    if (!this.f50465a.f50456a) {
                        this.f50465a.f50456a = true;
                        if (this.f50465a.f50463h != null) {
                            this.f50465a.f50463h.a(this.f50465a.f50456a);
                        }
                    }
                } else if (this.f50465a.f50456a) {
                    this.f50465a.f50456a = false;
                    if (this.f50465a.f50463h != null) {
                        this.f50465a.f50463h.a(this.f50465a.f50456a);
                    }
                }
                if (this.f50465a.f50462g == abs) {
                    return;
                }
                this.f50465a.f50462g = abs;
                if (totalScrollRange <= 0.0f) {
                    return;
                }
                this.f50465a.h(abs != 0.0f ? i3 >= 0 ? 1.0f : abs / totalScrollRange : 0.0f);
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f50456a = false;
        this.f50458c = false;
        this.f50462g = -1.0f;
        this.f50464i = new a(this);
        g();
    }

    public void bindListener() {
        StickyAppBarLayout.b onHeaderStickyListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AppBarLayout appBarLayout = this.f50457b;
            if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
                return;
            }
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setDragCallback(new b(this));
        }
    }

    public NestedScrollHeader getHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50459d : (NestedScrollHeader) invokeV.objValue;
    }

    public final void h(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            HomeTabBarView homeTabBarView = this.f50460e;
            if (homeTabBarView != null) {
                homeTabBarView.updateContentAlpha(f2);
            }
            NestedScrollHeader nestedScrollHeader = this.f50459d;
            if (nestedScrollHeader != null) {
                nestedScrollHeader.updateContentAlpha(1.0f - f2);
            }
            View view = this.f50461f;
            if (view == null || f2 > 1.0f || f2 < 0.0f) {
                return;
            }
            if (i2 == 0) {
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            this.f50461f.setAlpha(f2);
        }
    }

    public void hideHeader() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (appBarLayout = this.f50457b) == null) {
            return;
        }
        appBarLayout.setExpanded(false, true);
    }

    public boolean isSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f50456a : invokeV.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, layoutParams) == null) {
            super.onAttachedToLayoutParams(layoutParams);
            AppBarLayout appBarLayout = this.f50457b;
            if (appBarLayout == null || this.f50458c) {
                return;
            }
            appBarLayout.addOnOffsetChangedListener(this.f50464i);
            this.f50458c = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromLayoutParams();
            AppBarLayout appBarLayout = this.f50457b;
            if (appBarLayout == null || !this.f50458c) {
                return;
            }
            appBarLayout.removeOnOffsetChangedListener(this.f50464i);
            this.f50458c = false;
        }
    }

    public void setOnHeaderStickyListener(StickyAppBarLayout.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f50463h = bVar;
        }
    }

    public void showHeader() {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (appBarLayout = this.f50457b) == null) {
            return;
        }
        appBarLayout.setExpanded(true, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, coordinatorLayout, appBarLayout, i2)) == null) {
            if (this.f50457b == null) {
                this.f50457b = appBarLayout;
                View findViewById = appBarLayout.findViewById(R.id.home_nested_header);
                if (findViewById instanceof NestedScrollHeader) {
                    this.f50459d = (NestedScrollHeader) findViewById;
                }
                View findViewById2 = this.f50457b.findViewById(R.id.home_tab_bar_view);
                if (findViewById2 instanceof HomeTabBarView) {
                    this.f50460e = (HomeTabBarView) findViewById2;
                }
                this.f50461f = this.f50457b.findViewById(R.id.divider_line);
                bindListener();
            }
            AppBarLayout appBarLayout2 = this.f50457b;
            if (appBarLayout2 != null && !this.f50458c) {
                appBarLayout2.addOnOffsetChangedListener(this.f50464i);
                this.f50458c = true;
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
        this.f50456a = false;
        this.f50458c = false;
        this.f50462g = -1.0f;
        this.f50464i = new a(this);
        g();
    }
}

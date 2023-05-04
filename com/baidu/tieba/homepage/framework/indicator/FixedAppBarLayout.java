package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.DebugToolActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.floatCardView.AlaLiveTipView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aw4;
import com.baidu.tieba.f55;
import com.baidu.tieba.gg;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.ii;
import com.baidu.tieba.jg;
import com.baidu.tieba.qb;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes4.dex */
public class FixedAppBarLayout extends AppBarLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;
    public Context b;
    public AnimatorSet c;
    public boolean d;
    public AlaLiveTipView e;
    public CustomMessageListener f;
    public View.OnClickListener g;
    public Runnable h;

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (this.a.a.a != null) {
                        this.a.a.a.g.setAlpha(floatValue);
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.a.a.g.setVisibility(8);
                    this.a.a.a.e.setVisibility(8);
                    this.a.a.a.d.setVisibility(0);
                }
            }
        }

        public e(FixedAppBarLayout fixedAppBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fixedAppBarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fixedAppBarLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null) {
                return;
            }
            this.a.c = new AnimatorSet();
            int[] iArr = new int[2];
            this.a.a.e.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            this.a.a.d.getLocationInWindow(iArr2);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            float width = (i3 - i) + (this.a.a.e.getWidth() / 2) + 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.a.e, Key.SCALE_X, 1.0f, 1.5f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a.a.e, Key.SCALE_Y, 1.0f, 1.5f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.a.a.f, Key.SCALE_X, 1.0f, 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.a.a.f, Key.SCALE_Y, 1.0f, 0.0f);
            ofFloat3.setDuration(400L);
            ofFloat4.setDuration(400L);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.a.a.e, Key.TRANSLATION_X, width);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.a.a.e, Key.TRANSLATION_Y, -((float) (((-(Math.abs(i4) - Math.abs(i2))) / 2) - 8)));
            ofFloat3.addUpdateListener(new a(this));
            this.a.a.e.setPivotX(0.0f);
            this.a.a.e.setPivotY(0.0f);
            this.a.c.setInterpolator(new LinearInterpolator());
            this.a.c.setDuration(500L);
            this.a.c.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat3).with(ofFloat4);
            this.a.c.addListener(new b(this));
            this.a.c.start();
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FixedAppBarLayout fixedAppBarLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fixedAppBarLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fixedAppBarLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            this.a.h();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        public b(FixedAppBarLayout fixedAppBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fixedAppBarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fixedAppBarLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DebugToolActivityConfig(this.a.getContext())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ FixedAppBarLayout b;

        public c(FixedAppBarLayout fixedAppBarLayout, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fixedAppBarLayout, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fixedAppBarLayout;
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.p(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        public d(FixedAppBarLayout fixedAppBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fixedAppBarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fixedAppBarLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(this.a.getContext(), "", false)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public HomeTabBarView b;
        public View c;
        public ImageView d;
        public ImageView e;
        public EMTextView f;
        public LinearLayout g;
        public TbImageView h;
        public View i;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public static f a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                f fVar = new f();
                fVar.a = view2;
                fVar.b = (HomeTabBarView) view2.findViewById(R.id.obfuscated_res_0x7f090f0b);
                fVar.c = view2.findViewById(R.id.obfuscated_res_0x7f090821);
                fVar.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fbe);
                fVar.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fd2);
                fVar.f = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091fd9);
                fVar.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f9d);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09103a);
                fVar.h = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fVar.h.setUseNightOrDarkMask(false);
                fVar.i = view2.findViewById(R.id.content_container);
                return fVar;
            }
            return (f) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedAppBarLayout(Context context) {
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
        this.f = new a(this, 2001371);
        this.g = new d(this);
        this.h = new e(this);
        f(context);
    }

    public final void p(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, viewGroup) == null) {
            if (viewGroup.getChildCount() > 0) {
                if (!(viewGroup.getChildAt(0) instanceof AlaLiveTipView)) {
                    return;
                }
                this.e = (AlaLiveTipView) viewGroup.getChildAt(0);
            } else {
                AlaLiveTipView alaLiveTipView = new AlaLiveTipView(getContext());
                this.e = alaLiveTipView;
                viewGroup.addView(alaLiveTipView);
                z95.f();
            }
            AlaLiveTipView alaLiveTipView2 = this.e;
            if (alaLiveTipView2 != null) {
                alaLiveTipView2.setViewLocate(1);
                this.e.setHasBubble(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedAppBarLayout(Context context, AttributeSet attributeSet) {
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
        this.f = new a(this, 2001371);
        this.g = new d(this);
        this.h = new e(this);
        f(context);
    }

    public void setSearchStyle(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int i = R.color.CAM_X0101;
            if (z) {
                if (z2) {
                    i = R.color.CAM_X0105;
                }
                this.a.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, getResources().getColor(i), WebPManager.ResourceStateType.NORMAL_PRESS));
                return;
            }
            this.a.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedAppBarLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.f = new a(this, 2001371);
        this.g = new d(this);
        this.h = new e(this);
        f(context);
    }

    public void setImageBackground(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bitmap) == null) {
            this.a.h.setImageBitmap(bitmap);
        }
    }

    public void setImageBackgroundVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.a.h.setVisibility(i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, drawable) == null) {
            this.a.h.setImageDrawable(drawable);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02aa, (ViewGroup) this, true);
            this.a = f.a(this);
            q();
            r();
            j();
            k();
            g();
            h();
            i();
        }
    }

    public final void g() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View view2 = this.a.c;
            if (aw4.h()) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
            this.a.c.setOnClickListener(new b(this));
        }
    }

    public final void h() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09152a)) == null) {
            return;
        }
        qb.b().a("livesquare", new c(this, viewGroup));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.b.setTabStripCenterInParent();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            jg.a().removeCallbacks(this.h);
            AnimatorSet animatorSet = this.c;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        }
    }

    public void n() {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alaLiveTipView = this.e) != null) {
            alaLiveTipView.S();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.d) {
                jg.a().postDelayed(this.h, 2000L);
                this.d = false;
            }
            AlaLiveTipView alaLiveTipView = this.e;
            if (alaLiveTipView != null) {
                alaLiveTipView.T();
            }
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.f);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.f);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
            layoutParams.setBehavior(new AppBarLayout.Behavior());
            setLayoutParams(layoutParams);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ViewCompat.setElevation(this, 0.0f);
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, Key.ELEVATION, 0.0f));
            setStateListAnimator(stateListAnimator);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11ab));
            if (l()) {
                this.d = true;
                this.a.g.setVisibility(0);
                this.a.d.setVisibility(4);
            } else {
                this.d = false;
                this.a.g.setVisibility(8);
                this.a.d.setVisibility(0);
            }
            this.a.g.setOnClickListener(this.g);
            this.a.d.setOnClickListener(this.g);
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String[] split = f55.m().s("key_home_page_seacher_anim_show_number", "").split(",");
            long currentTimeMillis = System.currentTimeMillis();
            if (split.length < 7 && !TimeHelper.isSameDay(gg.g(split[split.length - 1], 0L), currentTimeMillis)) {
                f55 m = f55.m();
                if (split.length == 6) {
                    str = String.valueOf(currentTimeMillis);
                } else {
                    str = currentTimeMillis + ",";
                }
                m.B("key_home_page_seacher_anim_show_number", str);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && UtilHelper.canUseStyleImmersiveSticky()) {
            if (this.a.i.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.i.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getStatusBarHeight();
                this.a.i.setLayoutParams(layoutParams);
            }
            if (this.a.h.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.a.h.getLayoutParams();
                layoutParams2.height = UtilHelper.getStatusBarHeight() + ii.g(getContext(), R.dimen.tbds156);
                this.a.h.setLayoutParams(layoutParams2);
            }
        }
    }
}

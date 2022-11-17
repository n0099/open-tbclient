package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
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
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tieba.ah;
import com.baidu.tieba.h35;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.qw4;
import com.baidu.tieba.qy4;
import com.baidu.tieba.uq4;
import com.baidu.tieba.xg;
import com.baidu.tieba.yi;
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
    public e a;
    public Context b;
    public AnimatorSet c;
    public boolean d;
    public CustomMessageListener e;
    public View.OnClickListener f;
    public Runnable g;

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (this.a.a.a != null) {
                        this.a.a.a.h.setAlpha(floatValue);
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.a.a.h.setVisibility(8);
                    this.a.a.a.f.setVisibility(8);
                    this.a.a.a.e.setVisibility(0);
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null) {
                return;
            }
            this.a.c = new AnimatorSet();
            int[] iArr = new int[2];
            this.a.a.f.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            this.a.a.e.getLocationInWindow(iArr2);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            float width = (i3 - i) + (this.a.a.f.getWidth() / 2) + 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.a.f, Key.SCALE_X, 1.0f, 1.5f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a.a.f, Key.SCALE_Y, 1.0f, 1.5f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.a.a.g, Key.SCALE_X, 1.0f, 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.a.a.g, Key.SCALE_Y, 1.0f, 0.0f);
            ofFloat3.setDuration(400L);
            ofFloat4.setDuration(400L);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.a.a.f, Key.TRANSLATION_X, width);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.a.a.f, Key.TRANSLATION_Y, -((float) (((-(Math.abs(i4) - Math.abs(i2))) / 2) - 8)));
            ofFloat3.addUpdateListener(new a(this));
            this.a.a.f.setPivotX(0.0f);
            this.a.a.f.setPivotY(0.0f);
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
            this.a.g();
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        public c(FixedAppBarLayout fixedAppBarLayout) {
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
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public AlaLiveTipView b;
        public HomeTabBarView c;
        public View d;
        public ImageView e;
        public ImageView f;
        public EMTextView g;
        public LinearLayout h;
        public TbImageView i;
        public View j;

        public e() {
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
        public static e a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                e eVar = new e();
                eVar.a = view2;
                eVar.b = (AlaLiveTipView) view2.findViewById(R.id.obfuscated_res_0x7f0913e3);
                eVar.c = (HomeTabBarView) view2.findViewById(R.id.obfuscated_res_0x7f090ddb);
                eVar.d = view2.findViewById(R.id.obfuscated_res_0x7f09078a);
                eVar.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e4c);
                eVar.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e60);
                eVar.g = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091e67);
                eVar.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e2c);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ef7);
                eVar.i = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                eVar.i.setUseNightOrDarkMask(false);
                eVar.j = view2.findViewById(R.id.obfuscated_res_0x7f090701);
                return eVar;
            }
            return (e) invokeL.objValue;
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
        this.e = new a(this, 2001371);
        this.f = new c(this);
        this.g = new d(this);
        e(context);
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
        this.e = new a(this, 2001371);
        this.f = new c(this);
        this.g = new d(this);
        e(context);
    }

    public void setSearchStyle(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int i = R.color.CAM_X0101;
            if (z) {
                if (z2) {
                    i = R.color.CAM_X0105;
                }
                this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a44, getResources().getColor(i), WebPManager.ResourceStateType.NORMAL_PRESS));
                return;
            }
            this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
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
        this.e = new a(this, 2001371);
        this.f = new c(this);
        this.g = new d(this);
        e(context);
    }

    public void setImageBackground(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bitmap) == null) {
            this.a.i.setImageBitmap(bitmap);
        }
    }

    public void setImageBackgroundVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.a.i.setVisibility(i);
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.b = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d028f, (ViewGroup) this, true);
            this.a = e.a(this);
            o();
            p();
            i();
            j();
            f();
            g();
            h();
        }
    }

    public final void f() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View view2 = this.a.d;
            if (uq4.h()) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
            this.a.d.setOnClickListener(new b(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.c.setTabStripCenterInParent();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ah.a().removeCallbacks(this.g);
            AnimatorSet animatorSet = this.c;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.d) {
            ah.a().postDelayed(this.g, 2000L);
            this.d = false;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
            layoutParams.setBehavior(new AppBarLayout.Behavior());
            setLayoutParams(layoutParams);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.e);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ViewCompat.setElevation(this, 0.0f);
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, Key.ELEVATION, 0.0f));
            setStateListAnimator(stateListAnimator);
        }
    }

    public final void g() {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (alaLiveTipView = this.a.b) == null) {
            return;
        }
        alaLiveTipView.setViewLocate(1);
        this.a.b.setHasBubble(false);
        if (this.a.b.getVisibility() != 0) {
            h35.f();
        }
        this.a.b.setVisibility(0);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.g.setText(this.b.getString(R.string.obfuscated_res_0x7f0f1107));
            if (k()) {
                this.d = true;
                this.a.h.setVisibility(0);
                this.a.e.setVisibility(4);
            } else {
                this.d = false;
                this.a.h.setVisibility(8);
                this.a.e.setVisibility(0);
            }
            this.a.h.setOnClickListener(this.f);
            this.a.e.setOnClickListener(this.f);
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String[] split = qy4.k().q("key_home_page_seacher_anim_show_number", "").split(",");
            long currentTimeMillis = System.currentTimeMillis();
            if (split.length < 7 && !TimeHelper.isSameDay(xg.g(split[split.length - 1], 0L), currentTimeMillis)) {
                qy4 k = qy4.k();
                if (split.length == 6) {
                    str = String.valueOf(currentTimeMillis);
                } else {
                    str = currentTimeMillis + ",";
                }
                k.y("key_home_page_seacher_anim_show_number", str);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && UtilHelper.canUseStyleImmersiveSticky()) {
            if (this.a.j.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.j.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getStatusBarHeight();
                this.a.j.setLayoutParams(layoutParams);
            }
            if (this.a.i.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.a.i.getLayoutParams();
                layoutParams2.height = UtilHelper.getStatusBarHeight() + yi.g(getContext(), R.dimen.tbds156);
                this.a.i.setLayoutParams(layoutParams2);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setImageBackgroundVisibility(8);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0208);
            this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a44, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            qw4 d2 = qw4.d(this.a.g);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0105);
            if (TbadkApplication.getInst().getSkinType() != 1 && TbadkApplication.getInst().getSkinType() != 4) {
                qw4 d3 = qw4.d(this.a.h);
                d3.l(R.dimen.L_X01);
                d3.k(R.color.CAM_X0113);
                d3.n(R.string.J_X01);
                d3.f(R.color.CAM_X0211);
            } else {
                qw4 d4 = qw4.d(this.a.h);
                d4.n(R.string.J_X01);
                d4.f(R.color.CAM_X0211);
            }
            this.a.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080773, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        }
    }
}

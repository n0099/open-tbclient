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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.repackage.ng;
import com.repackage.pi;
import com.repackage.qg;
import com.repackage.um4;
import com.repackage.vr4;
import com.repackage.yt4;
/* loaded from: classes3.dex */
public class FixedAppBarLayout extends AppBarLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public String b;
    public Context c;
    public AnimatorSet d;
    public boolean e;
    public View.OnClickListener f;
    public Runnable g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        public a(FixedAppBarLayout fixedAppBarLayout) {
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

    /* loaded from: classes3.dex */
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
                NestedScrollHeader.j();
                new AlaTabFeedActivityConfig(this.a.getContext()).start();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixedAppBarLayout a;

        /* loaded from: classes3.dex */
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

        /* loaded from: classes3.dex */
        public class b implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

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
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.d = new AnimatorSet();
            int[] iArr = new int[2];
            this.a.a.f.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            this.a.a.e.getLocationInWindow(iArr2);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            float width = (i3 - i) + (this.a.a.f.getWidth() / 2) + 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.a.f, "scaleX", 1.0f, 1.5f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a.a.f, "scaleY", 1.0f, 1.5f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.a.a.g, "scaleX", 1.0f, 0.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.a.a.g, "scaleY", 1.0f, 0.0f);
            ofFloat3.setDuration(400L);
            ofFloat4.setDuration(400L);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.a.a.f, "translationX", width);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.a.a.f, "translationY", -((float) (((-(Math.abs(i4) - Math.abs(i2))) / 2) - 8)));
            ofFloat3.addUpdateListener(new a(this));
            this.a.a.f.setPivotX(0.0f);
            this.a.a.f.setPivotY(0.0f);
            this.a.d.setInterpolator(new LinearInterpolator());
            this.a.d.setDuration(500L);
            this.a.d.play(ofFloat).with(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat3).with(ofFloat4);
            this.a.d.addListener(new b(this));
            this.a.d.start();
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TBLottieAnimationView b;
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
                eVar.b = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0912fd);
                eVar.c = (HomeTabBarView) view2.findViewById(R.id.obfuscated_res_0x7f090d3c);
                eVar.d = view2.findViewById(R.id.obfuscated_res_0x7f090738);
                eVar.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cbe);
                eVar.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cd0);
                eVar.g = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091cd7);
                eVar.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c9e);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e5f);
                eVar.i = tbImageView;
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                eVar.i.setUseNightOrDarkMask(false);
                eVar.j = view2.findViewById(R.id.obfuscated_res_0x7f0906b4);
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
        this.f = new c(this);
        this.g = new d(this);
        d(context);
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.c = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0286, (ViewGroup) this, true);
            this.a = e.a(this);
            n();
            o();
            h();
            i();
            e();
            f();
            g();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.d.setVisibility(um4.h() ? 0 : 8);
            this.a.d.setOnClickListener(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!UbsABTestHelper.isHomeLiveTestA() && !UbsABTestHelper.isHomeLiveTestB()) {
                this.a.b.setVisibility(8);
            } else {
                if (this.a.b.getVisibility() != 0) {
                    NestedScrollHeader.k();
                }
                this.a.b.setVisibility(0);
            }
            this.a.b.setOnClickListener(new b(this));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.g.setText(this.c.getString(R.string.obfuscated_res_0x7f0f1079));
            if (j()) {
                this.e = true;
                this.a.h.setVisibility(0);
                this.a.e.setVisibility(4);
            } else {
                this.e = false;
                this.a.h.setVisibility(8);
                this.a.e.setVisibility(0);
            }
            this.a.h.setOnClickListener(this.f);
            this.a.e.setOnClickListener(this.f);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && UtilHelper.canUseStyleImmersiveSticky()) {
            if (this.a.j.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.j.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getStatusBarHeight();
                this.a.j.setLayoutParams(layoutParams);
            }
            if (this.a.i.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.a.i.getLayoutParams();
                layoutParams2.height = UtilHelper.getStatusBarHeight() + pi.f(getContext(), R.dimen.tbds156);
                this.a.i.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.c.setTabStripCenterInParent();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String[] split = yt4.k().q("key_home_page_seacher_anim_show_number", "").split(",");
            long currentTimeMillis = System.currentTimeMillis();
            if (split.length >= 7 || TimeHelper.isSameDay(ng.g(split[split.length - 1], 0L), currentTimeMillis)) {
                return false;
            }
            yt4 k = yt4.k();
            if (split.length == 6) {
                str = String.valueOf(currentTimeMillis);
            } else {
                str = currentTimeMillis + ",";
            }
            k.y("key_home_page_seacher_anim_show_number", str);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setImageBackgroundVisibility(8);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0208);
            if (TbadkApplication.getInst().getSkinType() == 0) {
                setLiveSquareLottie("lottie_home_live_entrance/", R.raw.obfuscated_res_0x7f11003e);
            } else {
                setLiveSquareLottie("lottie_home_live_entrance_lh/", R.raw.obfuscated_res_0x7f11003f);
            }
            this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            vr4 d2 = vr4.d(this.a.g);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0105);
            if (TbadkApplication.getInst().getSkinType() != 1 && TbadkApplication.getInst().getSkinType() != 4) {
                vr4 d3 = vr4.d(this.a.h);
                d3.l(R.dimen.L_X01);
                d3.k(R.color.CAM_X0113);
                d3.n(R.string.J_X01);
                d3.f(R.color.CAM_X0211);
            } else {
                vr4 d4 = vr4.d(this.a.h);
                d4.n(R.string.J_X01);
                d4.f(R.color.CAM_X0211);
            }
            this.a.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080746, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            qg.a().removeCallbacks(this.g);
            AnimatorSet animatorSet = this.d;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.e) {
            qg.a().postDelayed(this.g, 2000L);
            this.e = false;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
            layoutParams.setBehavior(new AppBarLayout.Behavior());
            setLayoutParams(layoutParams);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ViewCompat.setElevation(this, 0.0f);
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f));
            setStateListAnimator(stateListAnimator);
        }
    }

    public void setImageBackground(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bitmap) == null) {
            this.a.i.setImageBitmap(bitmap);
        }
    }

    public void setImageBackgroundVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.a.i.setVisibility(i);
        }
    }

    public void setLiveSquareLottie(@NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) || str.equals(this.b)) {
            return;
        }
        this.b = str;
        this.a.b.cancelAnimation();
        this.a.b.setImageAssetsFolder(str);
        this.a.b.setAnimation(i);
        this.a.b.setRepeatMode(1);
        this.a.b.setRepeatCount(-1);
        this.a.b.setSpeed(0.67f);
        this.a.b.playAnimation();
    }

    public void setSearchStyle(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int i = R.color.CAM_X0101;
            if (z) {
                if (z2) {
                    i = R.color.CAM_X0105;
                }
                this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, getResources().getColor(i), WebPManager.ResourceStateType.NORMAL_PRESS));
                return;
            }
            this.a.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
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
        this.f = new c(this);
        this.g = new d(this);
        d(context);
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
        this.f = new c(this);
        this.g = new d(this);
        d(context);
    }
}

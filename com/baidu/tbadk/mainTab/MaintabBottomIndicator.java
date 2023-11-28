package com.baidu.tbadk.mainTab;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.dynamicIcon.DynamicIconData;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.jk5;
import com.baidu.tieba.rd;
import com.baidu.tieba.uua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public View c;
    public TBLottieAnimationView d;
    public TextView e;
    public TBLottieAnimationView f;
    public TbImageView g;
    public TbImageView h;
    public View i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public HashMap<String, TbFragmentTabIndicator.FragmentTapTip> o;
    public boolean p;
    public boolean q;
    public DynamicIconData r;
    public boolean s;
    public jk5 t;
    public String u;

    public void setShowIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaintabBottomIndicator a;

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

        public a(MaintabBottomIndicator maintabBottomIndicator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maintabBottomIndicator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = maintabBottomIndicator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.d.setVisibility(8);
                this.a.f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ MaintabBottomIndicator b;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(MaintabBottomIndicator maintabBottomIndicator, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maintabBottomIndicator, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = maintabBottomIndicator;
            this.a = str;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.b.r == null || !MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon()) {
                    this.b.g.setVisibility(0);
                }
                if (!rd.isEmpty(this.a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.a));
                }
                this.b.g.setEvent(null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaintabBottomIndicator(Context context) {
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
        this.a = 0;
        this.k = 3;
        this.o = new HashMap<>();
        this.p = false;
        this.q = true;
        this.u = "";
        i();
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            setAnimationResId(this.l);
            this.d.loop(false);
            setText(R.string.home_recommend);
            if (z) {
                this.d.playAnimation();
                EMManager.from(this.e).setTextStyle(R.string.F_X02);
                return;
            }
            this.d.cancelAnimation();
            this.d.setFrame(0);
            EMManager.from(this.e).setTextStyle(R.string.F_X01);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaintabBottomIndicator(Context context, AttributeSet attributeSet) {
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
        this.a = 0;
        this.k = 3;
        this.o = new HashMap<>();
        this.p = false;
        this.q = true;
        this.u = "";
        i();
    }

    public void l(int i, jk5 jk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, jk5Var) == null) {
            if (this.t != null) {
                o();
                SkinManager.setBackgroundColor(this.i, R.color.transparent, i);
            } else {
                int i2 = this.j;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(this.e, i2, 1, i);
                } else {
                    SkinManager.setViewTextColor(this.e, R.color.CAM_X0107, 1, i);
                }
                SkinManager.setBackgroundColor(this.i, R.color.CAM_X0203, i);
            }
            int i3 = this.l;
            if (i3 != 0) {
                try {
                    if (i == 4) {
                        SkinManager.setDarkLottieAnimation(this.d, i3);
                        this.d.setAlpha(0.83f);
                    } else {
                        SkinManager.setLottieAnimation(this.d, i3);
                        this.d.setAlpha(1.0f);
                    }
                    g();
                } catch (Exception unused) {
                }
            }
            p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0;
        this.k = 3;
        this.o = new HashMap<>();
        this.p = false;
        this.q = true;
        this.u = "";
        i();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.FragmentTapTip getTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return this.o.get(str);
        }
        return (TbFragmentTabIndicator.FragmentTapTip) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            if (this.l != i) {
                this.l = i;
            }
            SkinManager.setLottieAnimation(this.d, this.l);
        }
    }

    public void setDynamicIconData(DynamicIconData dynamicIconData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dynamicIconData) == null) {
            this.r = dynamicIconData;
            p();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            super.setSelected(z);
            if (z) {
                this.d.setProgress(1.0f);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.u = TbadkCoreApplication.getInst().getString(i);
            this.e.setText(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.j = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.a = i;
        }
    }

    private String getDynamicTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            jk5 jk5Var = this.t;
            if (jk5Var != null) {
                if (this.s) {
                    return jk5Var.g();
                }
                return jk5Var.f();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SharedPrefHelper.getInstance().putInt("key_lottie_show_count", SharedPrefHelper.getInstance().getInt("key_lottie_show_count", 0) + 1);
        }
    }

    public final void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !this.p || TbadkCoreApplication.getInst().getHomeBarShowType() != 1 || !(z = this.q)) {
            return;
        }
        n(z);
    }

    public TBLottieAnimationView getAnimationView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (System.currentTimeMillis() > SharedPrefHelper.getInstance().getLong("key_lottie_show_expired_time", 0L)) {
                SharedPrefHelper.getInstance().putInt("key_lottie_show_count", 0);
            }
        }
    }

    public void m() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (tBLottieAnimationView = this.f) != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onAttachedToWindow();
            onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setWriteIconView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.c.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void addTip(String str, TbFragmentTabIndicator.FragmentTapTip fragmentTapTip) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, fragmentTapTip) == null) && fragmentTapTip != null && (view2 = fragmentTapTip.f1079view) != null) {
            addView(view2);
            this.o.put(str, fragmentTapTip);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void addTipWrapContent(String str, TbFragmentTabIndicator.FragmentTapTip fragmentTapTip) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fragmentTapTip) == null) && fragmentTapTip != null && (view2 = fragmentTapTip.f1079view) != null) {
            addView(view2, -2, -2);
            this.o.put(str, fragmentTapTip);
        }
    }

    public void k(boolean z, jk5 jk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, jk5Var) == null) {
            this.t = jk5Var;
            if (z) {
                l(4, jk5Var);
            } else {
                l(this.k, jk5Var);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i = SharedPrefHelper.getInstance().getInt("key_lottie_show_count", 0);
            SharedPrefHelper.getInstance().putLong("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
            TBLottieAnimationView tBLottieAnimationView = this.f;
            tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
            if (i >= 3) {
                h();
            }
        }
    }

    public void h() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tBLottieAnimationView = this.f) != null && tBLottieAnimationView.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.f.startAnimation(scaleAnimation);
            this.f.setVisibility(4);
            this.d.setVisibility(0);
            SharedPrefHelper.getInstance().putInt("key_lottie_show_count", 4);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.e != null) {
            int f = uua.f(getDynamicTextColor());
            if (f == 0 || f == Integer.MAX_VALUE) {
                if (this.s) {
                    f = SkinManager.getColor(R.color.CAM_X0622);
                } else {
                    f = SkinManager.getColor(R.color.CAM_X0619);
                }
            }
            this.e.setTextColor(f);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams.topMargin = -BdUtilHelper.getDimens(getContext(), R.dimen.L_X04);
            this.e.setLayoutParams(marginLayoutParams);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.r != null && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon()) {
            this.d.setVisibility(8);
            this.f.setVisibility(4);
            this.g.setVisibility(8);
            this.h.setUseNightOrDarkMask(false);
            this.h.setVisibility(0);
            if (this.s) {
                this.h.startLoad(this.r.getSelectedStateUrl(), this.r.getImgLoadType(), false);
            } else {
                this.h.startLoad(this.r.getNormalStateUrl(), this.r.getImgLoadType(), false);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.b.setLayoutParams(layoutParams);
            this.c = this.b.findViewById(R.id.container_common_item);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.b.findViewById(R.id.view_bottom_icon);
            this.d = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.1f);
            this.d.disableRestoreInstanceStateJustOnce();
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.image_icon);
            this.g = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.g.setRadius(50);
            this.g.setDefaultBgResource(R.color.transparent);
            this.g.setConrers(15);
            this.h = (TbImageView) this.b.findViewById(R.id.dynamic_image_icon);
            TextView textView = (TextView) this.b.findViewById(R.id.view_bottom_text);
            this.e = textView;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = -BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X001);
            this.e.setLayoutParams(marginLayoutParams);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) this.b.findViewById(R.id.animation_view);
            this.f = tBLottieAnimationView2;
            tBLottieAnimationView2.setFirstLoadInternal(true);
            this.i = this.b.findViewById(R.id.bar_cross_line);
            addView(this.b);
            this.m = BdUtilHelper.getDimens(getContext(), R.dimen.tbds18);
            this.n = BdUtilHelper.getDimens(getContext(), R.dimen.tbds10);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onChangeSkin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            super.onChangeSkin(i);
            Set<Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip>> entrySet = this.o.entrySet();
            if (entrySet != null && (r0 = entrySet.iterator()) != null) {
                for (Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip> entry : entrySet) {
                    TbFragmentTabIndicator.FragmentTapTip value = entry.getValue();
                    if (value != null) {
                        value.onChangeSkin(i);
                    }
                }
            }
            if (this.k != i) {
                this.k = i;
                if (this.t != null) {
                    o();
                    SkinManager.setBackgroundColor(this.i, R.color.transparent, i);
                } else {
                    int i2 = this.j;
                    if (i2 != 0) {
                        SkinManager.setViewTextColor(this.e, i2);
                    } else {
                        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0107);
                    }
                    SkinManager.setBackgroundColor(this.i, R.color.CAM_X0203, i);
                }
                int i3 = this.l;
                if (i3 != 0) {
                    try {
                        SkinManager.setLottieAnimation(this.d, i3);
                        if (this.k == 4) {
                            this.d.setAlpha(0.83f);
                        } else {
                            this.d.setAlpha(1.0f);
                        }
                        g();
                    } catch (Exception unused) {
                    }
                }
            }
            p();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.onTabSelected(z);
            this.s = z;
            p();
            if (this.l == 0) {
                return;
            }
            if (z) {
                EMManager.from(this.e).setTextStyle(R.string.F_X02);
                this.g.setVisibility(8);
                this.d.playAnimation();
                HashMap<String, TbFragmentTabIndicator.FragmentTapTip> hashMap = this.o;
                if (hashMap != null) {
                    for (TbFragmentTabIndicator.FragmentTapTip fragmentTapTip : hashMap.values()) {
                        if (fragmentTapTip != null && (view2 = fragmentTapTip.f1079view) != null && view2.isClickable()) {
                            fragmentTapTip.f1079view.performClick();
                        }
                    }
                }
            } else {
                this.d.cancelAnimation();
                this.d.setFrame(0);
                EMManager.from(this.e).setTextStyle(R.string.F_X01);
            }
            if (this.t != null) {
                o();
            }
        }
    }

    public void setLottieView(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048603, this, z) != null) || this.f == null) {
            return;
        }
        String string = SharedPrefHelper.getInstance().getString("sync_send_maintab_my_tab_lottie_url", "");
        if (rd.isEmpty(string) && z) {
            return;
        }
        j();
        if (!TimeHelper.isInTimeBlock(SharedPrefHelper.getInstance().getLong("sync_send_maintab_my_tab_lottie_start_time", 0L), SharedPrefHelper.getInstance().getLong("sync_send_maintab_my_tab_lottie_end_time", 0L)) || SharedPrefHelper.getInstance().getInt("key_lottie_show_count", 0) >= 3) {
            return;
        }
        this.f.playAnimation();
        this.f.setAnimationUrl(string);
        f();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_INFO_CENTER_LOTTIE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        this.f.addAnimatorListener(new a(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterator<Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip>> it;
        int left;
        int measuredHeight;
        int measuredHeight2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            Set<Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip>> entrySet = this.o.entrySet();
            if (entrySet == null || (it = entrySet.iterator()) == null) {
                return;
            }
            while (it.hasNext() && this.e != null && this.d != null) {
                TbFragmentTabIndicator.FragmentTapTip value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.f1079view.getMeasuredWidth();
                    int measuredHeight3 = value.f1079view.getMeasuredHeight();
                    if (value.isRight) {
                        left = (this.e.getRight() - this.m) + value.offsetX;
                    } else {
                        left = ((this.e.getLeft() + ((int) (this.e.getMeasuredWidth() * 0.14d))) - measuredWidth) - value.offsetX;
                    }
                    if (this.a == 1) {
                        measuredHeight = this.d.getTop();
                        measuredHeight2 = this.n;
                    } else {
                        measuredHeight = getMeasuredHeight() / 2;
                        measuredHeight2 = value.f1079view.getMeasuredHeight() / 2;
                    }
                    int i5 = measuredHeight - measuredHeight2;
                    value.f1079view.layout(left, i5, measuredWidth + left, measuredHeight3 + i5);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            Set<Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip>> entrySet = this.o.entrySet();
            if (entrySet == null || (r0 = entrySet.iterator()) == null) {
                return;
            }
            for (Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip> entry : entrySet) {
                TbFragmentTabIndicator.FragmentTapTip value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.f1079view.getLayoutParams();
                    int i3 = layoutParams.width;
                    if (i3 == -2) {
                        value.f1079view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                    } else {
                        if (i3 > size) {
                            i3 = size;
                        }
                        int i4 = layoutParams.height;
                        if (i4 > size2) {
                            i4 = size2;
                        }
                        value.f1079view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.FragmentTapTip removeTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (this.o.containsKey(str)) {
                removeView(this.o.get(str).f1079view);
                return this.o.remove(str);
            }
            return null;
        }
        return (TbFragmentTabIndicator.FragmentTapTip) invokeL.objValue;
    }

    public void setImageIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            if (!rd.isEmpty(str)) {
                this.g.setVisibility(8);
                this.g.setEvent(new b(this, str2));
                this.g.startLoad(str, 10, false);
                return;
            }
            this.g.setVisibility(8);
        }
    }
}

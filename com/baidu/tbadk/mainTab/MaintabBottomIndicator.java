package com.baidu.tbadk.mainTab;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c45;
import com.repackage.e45;
import com.repackage.ki;
import com.repackage.li;
import com.repackage.wq4;
import com.repackage.ys4;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public FrameLayout h;
    public LinearLayout i;
    public TBLottieAnimationView j;
    public TextView k;
    public TBLottieAnimationView l;
    public TbImageView m;
    public TbImageView n;
    public View o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public HashMap<String, TbFragmentTabIndicator.a> u;
    public boolean v;
    public boolean w;
    public int x;
    public c45 y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaintabBottomIndicator a;

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
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.k();
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
                this.a.j.setVisibility(8);
                this.a.l.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ MaintabBottomIndicator b;

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

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.b.y == null || !e45.d().b()) {
                    this.b.m.setVisibility(0);
                }
                if (!ki.isEmpty(this.a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.a));
                }
                this.b.m.setEvent(null);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
        this.g = 0;
        this.q = 3;
        this.u = new HashMap<>();
        this.v = false;
        this.w = true;
        this.x = 1;
        o();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || aVar == null || (view2 = aVar.a) == null) {
            return;
        }
        addView(view2);
        this.u.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) || aVar == null || (view2 = aVar.a) == null) {
            return;
        }
        addView(view2, -2, -2);
        this.u.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.u.get(str) : (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.e(i);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.u.entrySet();
            if (entrySet != null && (r0 = entrySet.iterator()) != null) {
                for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                    TbFragmentTabIndicator.a value = entry.getValue();
                    if (value != null) {
                        value.b(i);
                    }
                }
            }
            if (this.q != i) {
                this.q = i;
                int i2 = this.p;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(this.k, i2);
                } else {
                    SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0107);
                }
                int i3 = this.r;
                if (i3 != 0) {
                    try {
                        SkinManager.setLottieAnimation(this.j, i3);
                        if (this.q == 1) {
                            this.j.setAlpha(0.66f);
                        } else if (this.q == 4) {
                            this.j.setAlpha(0.83f);
                        } else {
                            this.j.setAlpha(1.0f);
                        }
                        m();
                    } catch (Exception unused) {
                    }
                }
            }
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0203, i);
            z();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.f(z);
            this.z = z;
            z();
            if (this.r == 0) {
                return;
            }
            if (z) {
                wq4.d(this.k).A(R.string.F_X02);
                this.m.setVisibility(8);
                this.j.playAnimation();
                HashMap<String, TbFragmentTabIndicator.a> hashMap = this.u;
                if (hashMap != null) {
                    for (TbFragmentTabIndicator.a aVar : hashMap.values()) {
                        if (aVar != null && (view2 = aVar.a) != null && view2.isClickable()) {
                            aVar.a.performClick();
                        }
                    }
                    return;
                }
                return;
            }
            this.j.cancelAnimation();
            this.j.setFrame(0);
            wq4.d(this.k).A(R.string.F_X01);
        }
    }

    public TBLottieAnimationView getAnimationView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int l = ys4.k().l("key_lottie_show_count", 0);
            ys4.k().x("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
            TBLottieAnimationView tBLottieAnimationView = this.l;
            tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
            if (l >= 3) {
                n();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ys4.k().w("key_lottie_show_count", ys4.k().l("key_lottie_show_count", 0) + 1);
        }
    }

    public final void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.v && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && (z = this.w)) {
            int i = this.x;
            if (i == 1) {
                x(z);
            } else if (i == 2) {
                y();
            }
        }
    }

    public void n() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tBLottieAnimationView = this.l) != null && tBLottieAnimationView.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.l.startAnimation(scaleAnimation);
            this.l.setVisibility(4);
            this.j.setVisibility(0);
            ys4.k().w("key_lottie_show_count", 4);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.h.setLayoutParams(layoutParams);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.i = linearLayout;
            linearLayout.setId(R.id.obfuscated_res_0x7f0906b3);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            this.i.setOrientation(1);
            this.i.setLayoutParams(layoutParams2);
            this.h.addView(this.i);
            FrameLayout frameLayout = new FrameLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 1;
            frameLayout.setLayoutParams(layoutParams3);
            this.i.addView(frameLayout);
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(getContext());
            this.j = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.obfuscated_res_0x7f092386);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec), li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec));
            layoutParams4.topMargin = li.f(getContext(), R.dimen.tbds8);
            this.j.setLayoutParams(layoutParams4);
            frameLayout.addView(this.j);
            this.j.setSpeed(1.1f);
            this.j.q();
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(getContext());
            this.l = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090269);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec), li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec));
            layoutParams5.bottomMargin = li.f(getContext(), R.dimen.obfuscated_res_0x7f070232);
            this.l.setLayoutParams(layoutParams5);
            this.l.setVisibility(4);
            this.l.loop(false);
            try {
                Field declaredField = TBLottieAnimationView.class.getDeclaredField("autoPlay");
                declaredField.setAccessible(true);
                declaredField.set(this.l, Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            frameLayout.addView(this.l);
            this.l.setFirstLoadInternal(true);
            TbImageView tbImageView = new TbImageView(getContext());
            this.m = tbImageView;
            tbImageView.setId(R.id.obfuscated_res_0x7f090e3f);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec), li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec));
            int f = li.f(getContext(), R.dimen.tbds12);
            this.m.setPadding(f, f, f, f);
            layoutParams6.topMargin = li.f(getContext(), R.dimen.tbds8);
            this.m.setScaleType(ImageView.ScaleType.CENTER);
            this.m.setVisibility(8);
            this.m.setLayoutParams(layoutParams6);
            this.m.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.m.setRadius(50);
            this.m.setDefaultBgResource(R.color.transparent);
            this.m.setConrers(15);
            frameLayout.addView(this.m);
            TbImageView tbImageView2 = new TbImageView(getContext());
            this.n = tbImageView2;
            tbImageView2.setId(R.id.obfuscated_res_0x7f09082a);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec), li.f(getContext(), R.dimen.obfuscated_res_0x7f0702ec));
            this.n.setPadding(f, f, f, f);
            layoutParams7.topMargin = li.f(getContext(), R.dimen.tbds8);
            this.n.setScaleType(ImageView.ScaleType.FIT_XY);
            this.n.setVisibility(8);
            this.n.setLayoutParams(layoutParams7);
            frameLayout.addView(this.n);
            EMTextView eMTextView = new EMTextView(getContext());
            this.k = eMTextView;
            eMTextView.setId(R.id.obfuscated_res_0x7f092387);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
            this.k.setGravity(17);
            this.k.setTextColor(R.color.CAM_X0105);
            this.k.setTextSize(0, li.f(getContext(), R.dimen.T_X09));
            layoutParams8.gravity = 1;
            layoutParams8.topMargin = -li.f(getContext(), R.dimen.M_H_X001);
            layoutParams8.bottomMargin = li.f(getContext(), R.dimen.M_H_X001);
            this.k.setLayoutParams(layoutParams8);
            this.i.addView(this.k);
            View view2 = new View(getContext());
            this.o = view2;
            view2.setId(R.id.obfuscated_res_0x7f090309);
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, li.f(getContext(), R.dimen.L_X01));
            this.o.setBackgroundResource(R.color.CAM_X0203);
            this.o.setLayoutParams(layoutParams9);
            this.h.addView(this.o);
            addView(this.h);
            this.s = li.f(getContext(), R.dimen.tbds18);
            this.t = li.f(getContext(), R.dimen.tbds10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it;
        int left;
        int measuredHeight;
        int measuredHeight2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.u.entrySet();
            if (entrySet == null || (it = entrySet.iterator()) == null) {
                return;
            }
            while (it.hasNext() && this.k != null && this.j != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.a.getMeasuredWidth();
                    int measuredHeight3 = value.a.getMeasuredHeight();
                    if (value.b) {
                        left = this.k.getRight() - this.s;
                    } else {
                        left = (this.k.getLeft() + ((int) (this.k.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.g == 1) {
                        measuredHeight = this.j.getTop();
                        measuredHeight2 = this.t;
                    } else {
                        measuredHeight = getMeasuredHeight() / 2;
                        measuredHeight2 = value.a.getMeasuredHeight() / 2;
                    }
                    int i5 = measuredHeight - measuredHeight2;
                    value.a.layout(left, i5, measuredWidth + left, measuredHeight3 + i5);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.u.entrySet();
            if (entrySet == null || (r0 = entrySet.iterator()) == null) {
                return;
            }
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.a.getLayoutParams();
                    int i3 = layoutParams.width;
                    if (i3 == -2) {
                        value.a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                    } else {
                        if (i3 > size) {
                            i3 = size;
                        }
                        int i4 = layoutParams.height;
                        if (i4 > size2) {
                            i4 = size2;
                        }
                        value.a.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                    }
                }
            }
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j.isAnimating() : invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (System.currentTimeMillis() > ys4.k().m("key_lottie_show_expired_time", 0L)) {
                ys4.k().w("key_lottie_show_count", 0);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                s(4);
            } else {
                s(this.q);
            }
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            int i2 = this.p;
            if (i2 != 0) {
                SkinManager.setViewTextColor(this.k, i2, 1, i);
            } else {
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1, i);
            }
            int i3 = this.r;
            if (i3 != 0) {
                try {
                    if (i == 1) {
                        SkinManager.setNightLottieAnimation(this.j, i3);
                        this.j.setAlpha(0.66f);
                    } else if (i == 4) {
                        SkinManager.setDarkLottieAnimation(this.j, i3);
                        this.j.setAlpha(0.83f);
                    } else {
                        SkinManager.setLottieAnimation(this.j, i3);
                        this.j.setAlpha(1.0f);
                    }
                    m();
                } catch (Exception unused) {
                }
            }
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0203, i);
            z();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || this.r == i) {
            return;
        }
        this.r = i;
        SkinManager.setLottieAnimation(this.j, i);
    }

    public void setDynamicIconData(c45 c45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, c45Var) == null) {
            this.y = c45Var;
            z();
        }
    }

    public void setImageIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (!ki.isEmpty(str)) {
                this.m.setVisibility(8);
                this.m.setEvent(new b(this, str2));
                this.m.K(str, 10, false);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void setLottieView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || this.l == null) {
            return;
        }
        String q = ys4.k().q("sync_send_maintab_my_tab_lottie_url", "");
        if (ki.isEmpty(q) && z) {
            return;
        }
        q();
        if (TimeHelper.isInTimeBlock(ys4.k().m("sync_send_maintab_my_tab_lottie_start_time", 0L), ys4.k().m("sync_send_maintab_my_tab_lottie_end_time", 0L)) && ys4.k().l("key_lottie_show_count", 0) < 3) {
            this.l.playAnimation();
            this.l.setAnimationUrl(q);
            l();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_INFO_CENTER_LOTTIE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            this.l.addAnimatorListener(new a(this));
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            super.setSelected(z);
            if (z) {
                this.j.setProgress(1.0f);
            }
        }
    }

    public void setShowIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.k.setText(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.p = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }

    public void setWriteIconView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.i.setVisibility(8);
        }
    }

    public void t() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (tBLottieAnimationView = this.l) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
    }

    public void u() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (tBLottieAnimationView = this.j) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SkinManager.setLottieAnimation(this.j, R.raw.icon_refresh2);
            setText(R.string.obfuscated_res_0x7f0f0f92);
            this.j.loop(true);
            u();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SkinManager.setLottieAnimation(this.j, R.raw.icon_refresh3);
            setText(R.string.obfuscated_res_0x7f0f0859);
            this.j.loop(false);
            u();
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            setAnimationResId(this.r);
            this.j.loop(false);
            setText(R.string.obfuscated_res_0x7f0f0859);
            if (z) {
                this.j.playAnimation();
                wq4.d(this.k).A(R.string.F_X02);
                return;
            }
            this.j.cancelAnimation();
            this.j.setFrame(0);
            wq4.d(this.k).A(R.string.F_X01);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            SkinManager.setLottieAnimation(this.j, R.raw.icon_refresh1);
            setText(R.string.obfuscated_res_0x7f0f0f92);
            this.j.loop(false);
            u();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.y != null && e45.d().b()) {
            this.j.setVisibility(8);
            this.l.setVisibility(4);
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            if (this.z) {
                this.n.K(this.y.l(), this.y.j(), false);
            } else {
                this.n.K(this.y.k(), this.y.j(), false);
            }
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
        this.g = 0;
        this.q = 3;
        this.u = new HashMap<>();
        this.v = false;
        this.w = true;
        this.x = 1;
        o();
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
        this.g = 0;
        this.q = 3;
        this.u = new HashMap<>();
        this.v = false;
        this.w = true;
        this.x = 1;
        o();
    }
}

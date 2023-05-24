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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.cj5;
import com.baidu.tieba.dj5;
import com.baidu.tieba.fj5;
import com.baidu.tieba.o65;
import com.baidu.tieba.p45;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.xp9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int g;
    public View h;
    public View i;
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
    public cj5 x;
    public boolean y;
    public dj5 z;

    public void setShowIconType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
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
            this.a.k();
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

    /* loaded from: classes4.dex */
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
                if (this.b.x == null || !fj5.f().b()) {
                    this.b.m.setVisibility(0);
                }
                if (!qi.isEmpty(this.a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.a));
                }
                this.b.m.setEvent(null);
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
        this.A = "";
        o();
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            setAnimationResId(this.r);
            this.j.loop(false);
            setText(R.string.home_recommend);
            if (z) {
                this.j.playAnimation();
                p45.d(this.k).C(R.string.F_X02);
                return;
            }
            this.j.cancelAnimation();
            this.j.setFrame(0);
            p45.d(this.k).C(R.string.F_X01);
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
        this.A = "";
        o();
    }

    public void r(int i, dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, dj5Var) == null) {
            if (this.z != null) {
                u();
                SkinManager.setBackgroundColor(this.o, R.color.transparent, i);
            } else {
                int i2 = this.p;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(this.k, i2, 1, i);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1, i);
                }
                SkinManager.setBackgroundColor(this.o, R.color.CAM_X0203, i);
            }
            int i3 = this.r;
            if (i3 != 0) {
                try {
                    if (i == 4) {
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
            v();
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
        this.g = 0;
        this.q = 3;
        this.u = new HashMap<>();
        this.v = false;
        this.w = true;
        this.A = "";
        o();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.u.get(str);
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (this.r != i) {
                this.r = i;
            }
            SkinManager.setLottieAnimation(this.j, this.r);
        }
    }

    public void setDynamicIconData(cj5 cj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cj5Var) == null) {
            this.x = cj5Var;
            v();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.setSelected(z);
            if (z) {
                this.j.setProgress(1.0f);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.A = TbadkCoreApplication.getInst().getString(i);
            this.k.setText(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.p = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.g = i;
        }
    }

    private String getDynamicTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            dj5 dj5Var = this.z;
            if (dj5Var != null) {
                if (this.y) {
                    return dj5Var.g();
                }
                return dj5Var.f();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public TBLottieAnimationView getAnimationView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o65.m().z("key_lottie_show_count", o65.m().n("key_lottie_show_count", 0) + 1);
        }
    }

    public final void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !this.v || TbadkCoreApplication.getInst().getHomeBarShowType() != 1 || !(z = this.w)) {
            return;
        }
        t(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onAttachedToWindow();
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (System.currentTimeMillis() > o65.m().o("key_lottie_show_expired_time", 0L)) {
                o65.m().z("key_lottie_show_count", 0);
            }
        }
    }

    public void s() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (tBLottieAnimationView = this.l) != null) {
            tBLottieAnimationView.cancelAnimation();
        }
    }

    public void setWriteIconView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.i.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) && aVar != null && (view2 = aVar.a) != null) {
            addView(view2);
            this.u.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) && aVar != null && (view2 = aVar.a) != null) {
            addView(view2, -2, -2);
            this.u.put(str, aVar);
        }
    }

    public void q(boolean z, dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, dj5Var) == null) {
            this.z = dj5Var;
            if (z) {
                r(4, dj5Var);
            } else {
                r(this.q, dj5Var);
            }
        }
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
                if (this.z != null) {
                    u();
                    SkinManager.setBackgroundColor(this.o, R.color.transparent, i);
                } else {
                    int i2 = this.p;
                    if (i2 != 0) {
                        SkinManager.setViewTextColor(this.k, i2);
                    } else {
                        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0107);
                    }
                    SkinManager.setBackgroundColor(this.o, R.color.CAM_X0203, i);
                }
                int i3 = this.r;
                if (i3 != 0) {
                    try {
                        SkinManager.setLottieAnimation(this.j, i3);
                        if (this.q == 4) {
                            this.j.setAlpha(0.83f);
                        } else {
                            this.j.setAlpha(1.0f);
                        }
                        m();
                    } catch (Exception unused) {
                    }
                }
            }
            v();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.f(z);
            this.y = z;
            v();
            if (this.r == 0) {
                return;
            }
            if (z) {
                p45.d(this.k).C(R.string.F_X02);
                this.m.setVisibility(8);
                this.j.playAnimation();
                HashMap<String, TbFragmentTabIndicator.a> hashMap = this.u;
                if (hashMap != null) {
                    for (TbFragmentTabIndicator.a aVar : hashMap.values()) {
                        if (aVar != null && (view2 = aVar.a) != null && view2.isClickable()) {
                            aVar.a.performClick();
                        }
                    }
                }
            } else {
                this.j.cancelAnimation();
                this.j.setFrame(0);
                p45.d(this.k).C(R.string.F_X01);
            }
            if (this.z != null) {
                u();
            }
        }
    }

    public void setLottieView(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048599, this, z) != null) || this.l == null) {
            return;
        }
        String s = o65.m().s("sync_send_maintab_my_tab_lottie_url", "");
        if (qi.isEmpty(s) && z) {
            return;
        }
        p();
        if (!TimeHelper.isInTimeBlock(o65.m().o("sync_send_maintab_my_tab_lottie_start_time", 0L), o65.m().o("sync_send_maintab_my_tab_lottie_end_time", 0L)) || o65.m().n("key_lottie_show_count", 0) >= 3) {
            return;
        }
        this.l.playAnimation();
        this.l.setAnimationUrl(s);
        l();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_INFO_CENTER_LOTTIE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        this.l.addAnimatorListener(new a(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int n = o65.m().n("key_lottie_show_count", 0);
            o65.m().A("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
            TBLottieAnimationView tBLottieAnimationView = this.l;
            tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
            if (n >= 3) {
                n();
            }
        }
    }

    public void n() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (tBLottieAnimationView = this.l) != null && tBLottieAnimationView.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.l.startAnimation(scaleAnimation);
            this.l.setVisibility(4);
            this.j.setVisibility(0);
            o65.m().z("key_lottie_show_count", 4);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.k != null) {
            int f = xp9.f(getDynamicTextColor());
            if (f == 0 || f == Integer.MAX_VALUE) {
                if (this.y) {
                    f = SkinManager.getColor(R.color.CAM_X0622);
                } else {
                    f = SkinManager.getColor(R.color.CAM_X0619);
                }
            }
            this.k.setTextColor(f);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            marginLayoutParams.topMargin = -ri.g(getContext(), R.dimen.L_X04);
            this.k.setLayoutParams(marginLayoutParams);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.x != null && fj5.f().b()) {
            this.j.setVisibility(8);
            this.l.setVisibility(4);
            this.m.setVisibility(8);
            this.n.setUseNightOrDarkMask(false);
            this.n.setVisibility(0);
            if (this.y) {
                this.n.N(this.x.u(), this.x.s(), false);
            } else {
                this.n.N(this.x.t(), this.x.s(), false);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.h = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.h.setLayoutParams(layoutParams);
            this.i = this.h.findViewById(R.id.container_common_item);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.h.findViewById(R.id.view_bottom_icon);
            this.j = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.1f);
            this.j.s();
            TbImageView tbImageView = (TbImageView) this.h.findViewById(R.id.image_icon);
            this.m = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.m.setRadius(50);
            this.m.setDefaultBgResource(R.color.transparent);
            this.m.setConrers(15);
            this.n = (TbImageView) this.h.findViewById(R.id.dynamic_image_icon);
            TextView textView = (TextView) this.h.findViewById(R.id.view_bottom_text);
            this.k = textView;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = -ri.g(getContext(), R.dimen.M_H_X001);
            this.k.setLayoutParams(marginLayoutParams);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) this.h.findViewById(R.id.animation_view);
            this.l = tBLottieAnimationView2;
            tBLottieAnimationView2.setFirstLoadInternal(true);
            this.o = this.h.findViewById(R.id.bar_cross_line);
            addView(this.h);
            this.s = ri.g(getContext(), R.dimen.tbds18);
            this.t = ri.g(getContext(), R.dimen.tbds10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it;
        int left;
        int measuredHeight;
        int measuredHeight2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
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
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
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

    public void setImageIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            if (!qi.isEmpty(str)) {
                this.m.setVisibility(8);
                this.m.setEvent(new b(this, str2));
                this.m.N(str, 10, false);
                return;
            }
            this.m.setVisibility(8);
        }
    }
}

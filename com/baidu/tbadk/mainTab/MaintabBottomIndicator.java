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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.h0.f.c;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DYNAMIC_STATUS = 3;
    public static final String KEY_LOTTIE_SHOW_COUNT = "key_lottie_show_count";
    public static final String KEY_LOTTIE_SHOW_EXPIRED_TIME = "key_lottie_show_expired_time";
    public static final int KEY_LOTTIE_SHOW_MAX_COUNT = 3;
    public static final int LOADED_STATUS = 5;
    public static final int NORMAL_STATUS = 1;
    public static final int NORMAL_UNSELECTED_STATUS = 4;
    public static final int RESTORE_STATUS = 6;
    public static final int STATIC_STATUS = 2;
    public static final int TIP_POS_TYPE_CENTER = 0;
    public static final int TIP_POS_TYPE_TOP = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.h0.f.a dynamicIconData;

    /* renamed from: e  reason: collision with root package name */
    public int f39695e;

    /* renamed from: f  reason: collision with root package name */
    public View f39696f;

    /* renamed from: g  reason: collision with root package name */
    public View f39697g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f39698h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f39699i;
    public int iconStatus;
    public boolean isHomePageIndicator;
    public boolean isSelectHome;
    public boolean isSelected;

    /* renamed from: j  reason: collision with root package name */
    public TBLottieAnimationView f39700j;
    public TbImageView k;
    public TbImageView l;
    public View m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public HashMap<String, TbFragmentTabIndicator.a> s;

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaintabBottomIndicator f39701e;

        public a(MaintabBottomIndicator maintabBottomIndicator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maintabBottomIndicator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39701e = maintabBottomIndicator;
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
                this.f39701e.e();
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
                this.f39701e.f39698h.setVisibility(8);
                this.f39701e.f39700j.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MaintabBottomIndicator f39702b;

        public b(MaintabBottomIndicator maintabBottomIndicator, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maintabBottomIndicator, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39702b = maintabBottomIndicator;
            this.a = str;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.f39702b.dynamicIconData == null || !c.d().b()) {
                    this.f39702b.k.setVisibility(0);
                }
                if (!m.isEmpty(this.a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.a));
                }
                this.f39702b.k.setEvent(null);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39695e = 0;
        this.o = 3;
        this.s = new HashMap<>();
        this.isHomePageIndicator = false;
        this.isSelectHome = true;
        this.iconStatus = 1;
        h();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void addTip(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || aVar == null || (view = aVar.a) == null) {
            return;
        }
        addView(view);
        this.s.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void addTipWrapContent(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) || aVar == null || (view = aVar.a) == null) {
            return;
        }
        addView(view, -2, -2);
        this.s.put(str, aVar);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int l = c.a.q0.r.j0.b.k().l("key_lottie_show_count", 0);
            c.a.q0.r.j0.b.k().x(KEY_LOTTIE_SHOW_EXPIRED_TIME, System.currentTimeMillis() + 86400000);
            TBLottieAnimationView tBLottieAnimationView = this.f39700j;
            tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
            if (l >= 3) {
                hideLottieView();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.r.j0.b.k().w("key_lottie_show_count", c.a.q0.r.j0.b.k().l("key_lottie_show_count", 0) + 1);
        }
    }

    public final void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.isHomePageIndicator && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && (z = this.isSelectHome)) {
            int i2 = this.iconStatus;
            if (i2 == 1) {
                playNormalAnimation(z);
            } else if (i2 == 2) {
                playStaticAnimation();
            }
        }
    }

    public TBLottieAnimationView getAnimationView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39700j : (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f39699i : (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a getTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.s.get(str) : (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f39696f = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f39696f.setLayoutParams(layoutParams);
            this.f39697g = this.f39696f.findViewById(R.id.container_common_item);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f39696f.findViewById(R.id.view_bottom_icon);
            this.f39698h = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.1f);
            this.f39698h.disableRestoreInstanceStateJustOnce();
            TbImageView tbImageView = (TbImageView) this.f39696f.findViewById(R.id.image_icon);
            this.k = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setRadius(50);
            this.k.setDefaultBgResource(R.color.transparent);
            this.k.setConrers(15);
            this.l = (TbImageView) this.f39696f.findViewById(R.id.dynamic_image_icon);
            TextView textView = (TextView) this.f39696f.findViewById(R.id.view_bottom_text);
            this.f39699i = textView;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = -n.f(getContext(), R.dimen.M_H_X001);
            this.f39699i.setLayoutParams(marginLayoutParams);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) this.f39696f.findViewById(R.id.animation_view);
            this.f39700j = tBLottieAnimationView2;
            tBLottieAnimationView2.setFirstLoadInternal(true);
            this.m = this.f39696f.findViewById(R.id.bar_cross_line);
            addView(this.f39696f);
            this.q = n.f(getContext(), R.dimen.tbds18);
            this.r = n.f(getContext(), R.dimen.tbds10);
        }
    }

    public void hideLottieView() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tBLottieAnimationView = this.f39700j) != null && tBLottieAnimationView.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.f39700j.startAnimation(scaleAnimation);
            this.f39700j.setVisibility(4);
            this.f39698h.setVisibility(0);
            c.a.q0.r.j0.b.k().w("key_lottie_show_count", 4);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (System.currentTimeMillis() > c.a.q0.r.j0.b.k().m(KEY_LOTTIE_SHOW_EXPIRED_TIME, 0L)) {
                c.a.q0.r.j0.b.k().w("key_lottie_show_count", 0);
            }
        }
    }

    public boolean isAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f39698h.isAnimating() : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.dynamicIconData != null && c.d().b()) {
            this.f39698h.setVisibility(8);
            this.f39700j.setVisibility(4);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            if (this.isSelected) {
                this.l.startLoad(this.dynamicIconData.l(), this.dynamicIconData.j(), false);
            } else {
                this.l.startLoad(this.dynamicIconData.k(), this.dynamicIconData.j(), false);
            }
        }
    }

    public void makeDarkSkin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                makeSkinType(4);
            } else {
                makeSkinType(this.o);
            }
        }
    }

    public void makeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            int i3 = this.n;
            if (i3 != 0) {
                SkinManager.setViewTextColor(this.f39699i, i3, 1, i2);
            } else {
                SkinManager.setViewTextColor(this.f39699i, R.color.CAM_X0107, 1, i2);
            }
            int i4 = this.p;
            if (i4 != 0) {
                try {
                    if (i2 == 1) {
                        SkinManager.setNightLottieAnimation(this.f39698h, i4);
                        this.f39698h.setAlpha(0.66f);
                    } else if (i2 == 4) {
                        SkinManager.setDarkLottieAnimation(this.f39698h, i4);
                        this.f39698h.setAlpha(0.83f);
                    } else {
                        SkinManager.setLottieAnimation(this.f39698h, i4);
                        this.f39698h.setAlpha(1.0f);
                    }
                    g();
                } catch (Exception unused) {
                }
            }
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0203, i2);
            j();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onAttachedToWindow();
            onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkin(i2);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.s.entrySet();
            if (entrySet != null && (r0 = entrySet.iterator()) != null) {
                for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                    TbFragmentTabIndicator.a value = entry.getValue();
                    if (value != null) {
                        value.b(i2);
                    }
                }
            }
            if (this.o != i2) {
                this.o = i2;
                int i3 = this.n;
                if (i3 != 0) {
                    SkinManager.setViewTextColor(this.f39699i, i3);
                } else {
                    SkinManager.setViewTextColor(this.f39699i, (int) R.color.CAM_X0107);
                }
                int i4 = this.p;
                if (i4 != 0) {
                    try {
                        SkinManager.setLottieAnimation(this.f39698h, i4);
                        if (this.o == 1) {
                            this.f39698h.setAlpha(0.66f);
                        } else if (this.o == 4) {
                            this.f39698h.setAlpha(0.83f);
                        } else {
                            this.f39698h.setAlpha(1.0f);
                        }
                        g();
                    } catch (Exception unused) {
                    }
                }
            }
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0203, i2);
            j();
        }
    }

    public void onDestory() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (tBLottieAnimationView = this.f39700j) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it;
        int left;
        int measuredHeight;
        int measuredHeight2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.s.entrySet();
            if (entrySet == null || (it = entrySet.iterator()) == null) {
                return;
            }
            while (it.hasNext() && this.f39699i != null && this.f39698h != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.a.getMeasuredWidth();
                    int measuredHeight3 = value.a.getMeasuredHeight();
                    if (value.f39703b) {
                        left = this.f39699i.getRight() - this.q;
                    } else {
                        left = (this.f39699i.getLeft() + ((int) (this.f39699i.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.f39695e == 1) {
                        measuredHeight = this.f39698h.getTop();
                        measuredHeight2 = this.r;
                    } else {
                        measuredHeight = getMeasuredHeight() / 2;
                        measuredHeight2 = value.a.getMeasuredHeight() / 2;
                    }
                    int i6 = measuredHeight - measuredHeight2;
                    value.a.layout(left, i6, measuredWidth + left, measuredHeight3 + i6);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.s.entrySet();
            if (entrySet == null || (r0 = entrySet.iterator()) == null) {
                return;
            }
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.a.getLayoutParams();
                    int i4 = layoutParams.width;
                    if (i4 == -2) {
                        value.a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                    } else {
                        if (i4 > size) {
                            i4 = size;
                        }
                        int i5 = layoutParams.height;
                        if (i5 > size2) {
                            i5 = size2;
                        }
                        value.a.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.onTabSelected(z);
            this.isSelected = z;
            j();
            if (this.p == 0) {
                return;
            }
            if (z) {
                c.a.q0.r.v.c.d(this.f39699i).A(R.string.F_X02);
                this.k.setVisibility(8);
                this.f39698h.playAnimation();
                HashMap<String, TbFragmentTabIndicator.a> hashMap = this.s;
                if (hashMap != null) {
                    for (TbFragmentTabIndicator.a aVar : hashMap.values()) {
                        if (aVar != null && (view = aVar.a) != null && view.isClickable()) {
                            aVar.a.performClick();
                        }
                    }
                    return;
                }
                return;
            }
            this.f39698h.cancelAnimation();
            this.f39698h.setFrame(0);
            c.a.q0.r.v.c.d(this.f39699i).A(R.string.F_X01);
        }
    }

    public void playAnimation() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (tBLottieAnimationView = this.f39698h) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    public void playDynamicAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            SkinManager.setLottieAnimation(this.f39698h, R.raw.icon_refresh2);
            setText(R.string.refresh);
            this.f39698h.loop(true);
            playAnimation();
        }
    }

    public void playLoadedAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            SkinManager.setLottieAnimation(this.f39698h, R.raw.icon_refresh3);
            setText(R.string.home_recommend);
            this.f39698h.loop(false);
            playAnimation();
        }
    }

    public void playNormalAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            setAnimationResId(this.p);
            this.f39698h.loop(false);
            setText(R.string.home_recommend);
            if (z) {
                this.f39698h.playAnimation();
                c.a.q0.r.v.c.d(this.f39699i).A(R.string.F_X02);
                return;
            }
            this.f39698h.cancelAnimation();
            this.f39698h.setFrame(0);
            c.a.q0.r.v.c.d(this.f39699i).A(R.string.F_X01);
        }
    }

    public void playStaticAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SkinManager.setLottieAnimation(this.f39698h, R.raw.icon_refresh1);
            setText(R.string.refresh);
            this.f39698h.loop(false);
            playAnimation();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a removeTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            if (this.s.containsKey(str)) {
                removeView(this.s.get(str).a);
                return this.s.remove(str);
            }
            return null;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.p == i2) {
            return;
        }
        this.p = i2;
        SkinManager.setLottieAnimation(this.f39698h, i2);
    }

    public void setDynamicIconData(c.a.q0.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.dynamicIconData = aVar;
            j();
        }
    }

    public void setImageIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, str2) == null) {
            if (!m.isEmpty(str)) {
                this.k.setVisibility(8);
                this.k.setEvent(new b(this, str2));
                this.k.startLoad(str, 10, false);
                return;
            }
            this.k.setVisibility(8);
        }
    }

    public void setLottieView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || this.f39700j == null) {
            return;
        }
        String q = c.a.q0.r.j0.b.k().q("sync_send_maintab_my_tab_lottie_url", "");
        if (m.isEmpty(q) && z) {
            return;
        }
        i();
        if (TimeHelper.isInTimeBlock(c.a.q0.r.j0.b.k().m("sync_send_maintab_my_tab_lottie_start_time", 0L), c.a.q0.r.j0.b.k().m("sync_send_maintab_my_tab_lottie_end_time", 0L)) && c.a.q0.r.j0.b.k().l("key_lottie_show_count", 0) < 3) {
            this.f39700j.playAnimation();
            this.f39700j.setAnimationUrl(q);
            f();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_INFO_CENTER_LOTTIE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            this.f39700j.addAnimatorListener(new a(this));
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.setSelected(z);
            if (z) {
                this.f39698h.setProgress(1.0f);
            }
        }
    }

    public void setShowIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f39699i.setText(i2);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.n = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.f39695e = i2;
        }
    }

    public void setWriteIconView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f39697g.setVisibility(8);
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
        this.f39695e = 0;
        this.o = 3;
        this.s = new HashMap<>();
        this.isHomePageIndicator = false;
        this.isSelectHome = true;
        this.iconStatus = 1;
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaintabBottomIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f39695e = 0;
        this.o = 3;
        this.s = new HashMap<>();
        this.isHomePageIndicator = false;
        this.isSelectHome = true;
        this.iconStatus = 1;
        h();
    }
}

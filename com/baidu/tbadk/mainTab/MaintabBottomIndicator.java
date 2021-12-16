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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.r0.i0.e.c;
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
/* loaded from: classes11.dex */
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
    public c.a.r0.i0.e.a dynamicIconData;

    /* renamed from: e  reason: collision with root package name */
    public int f42350e;

    /* renamed from: f  reason: collision with root package name */
    public View f42351f;

    /* renamed from: g  reason: collision with root package name */
    public View f42352g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f42353h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f42354i;
    public int iconStatus;
    public boolean isHomePageIndicator;
    public boolean isSelectHome;
    public boolean isSelected;

    /* renamed from: j  reason: collision with root package name */
    public TBLottieAnimationView f42355j;

    /* renamed from: k  reason: collision with root package name */
    public TbImageView f42356k;
    public TbImageView l;
    public View m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public HashMap<String, TbFragmentTabIndicator.a> s;

    /* loaded from: classes11.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaintabBottomIndicator f42357e;

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
            this.f42357e = maintabBottomIndicator;
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
                this.f42357e.e();
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
                this.f42357e.f42353h.setVisibility(8);
                this.f42357e.f42355j.setVisibility(0);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MaintabBottomIndicator f42358b;

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
            this.f42358b = maintabBottomIndicator;
            this.a = str;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.f42358b.dynamicIconData == null || !c.d().b()) {
                    this.f42358b.f42356k.setVisibility(0);
                }
                if (!l.isEmpty(this.a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.a));
                }
                this.f42358b.f42356k.setEvent(null);
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
        this.f42350e = 0;
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
            int k2 = c.a.r0.s.g0.b.j().k("key_lottie_show_count", 0);
            c.a.r0.s.g0.b.j().w(KEY_LOTTIE_SHOW_EXPIRED_TIME, System.currentTimeMillis() + 86400000);
            TBLottieAnimationView tBLottieAnimationView = this.f42355j;
            tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
            if (k2 >= 3) {
                hideLottieView();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.s.g0.b.j().v("key_lottie_show_count", c.a.r0.s.g0.b.j().k("key_lottie_show_count", 0) + 1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42355j : (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42354i : (View) invokeV.objValue;
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
            this.f42351f = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f42351f.setLayoutParams(layoutParams);
            this.f42352g = this.f42351f.findViewById(R.id.container_common_item);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f42351f.findViewById(R.id.view_bottom_icon);
            this.f42353h = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.1f);
            this.f42353h.disableRestoreInstanceStateJustOnce();
            TbImageView tbImageView = (TbImageView) this.f42351f.findViewById(R.id.image_icon);
            this.f42356k = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f42356k.setRadius(50);
            this.f42356k.setDefaultBgResource(R.color.transparent);
            this.f42356k.setConrers(15);
            this.l = (TbImageView) this.f42351f.findViewById(R.id.dynamic_image_icon);
            TextView textView = (TextView) this.f42351f.findViewById(R.id.view_bottom_text);
            this.f42354i = textView;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = -m.f(getContext(), R.dimen.M_H_X001);
            this.f42354i.setLayoutParams(marginLayoutParams);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) this.f42351f.findViewById(R.id.animation_view);
            this.f42355j = tBLottieAnimationView2;
            tBLottieAnimationView2.setFirstLoadInternal(true);
            this.m = this.f42351f.findViewById(R.id.bar_cross_line);
            addView(this.f42351f);
            this.q = m.f(getContext(), R.dimen.tbds18);
            this.r = m.f(getContext(), R.dimen.tbds10);
        }
    }

    public void hideLottieView() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tBLottieAnimationView = this.f42355j) != null && tBLottieAnimationView.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.f42355j.startAnimation(scaleAnimation);
            this.f42355j.setVisibility(4);
            this.f42353h.setVisibility(0);
            c.a.r0.s.g0.b.j().v("key_lottie_show_count", 4);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (System.currentTimeMillis() > c.a.r0.s.g0.b.j().l(KEY_LOTTIE_SHOW_EXPIRED_TIME, 0L)) {
                c.a.r0.s.g0.b.j().v("key_lottie_show_count", 0);
            }
        }
    }

    public boolean isAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f42353h.isAnimating() : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.dynamicIconData != null && c.d().b()) {
            this.f42353h.setVisibility(8);
            this.f42355j.setVisibility(4);
            this.f42356k.setVisibility(8);
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
                SkinManager.setViewTextColor(this.f42354i, i3, 1, i2);
            } else {
                SkinManager.setViewTextColor(this.f42354i, R.color.CAM_X0107, 1, i2);
            }
            int i4 = this.p;
            if (i4 != 0) {
                try {
                    if (i2 == 1) {
                        SkinManager.setNightLottieAnimation(this.f42353h, i4);
                        this.f42353h.setAlpha(0.66f);
                    } else if (i2 == 4) {
                        SkinManager.setDarkLottieAnimation(this.f42353h, i4);
                        this.f42353h.setAlpha(0.83f);
                    } else {
                        SkinManager.setLottieAnimation(this.f42353h, i4);
                        this.f42353h.setAlpha(1.0f);
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
                    SkinManager.setViewTextColor(this.f42354i, i3);
                } else {
                    SkinManager.setViewTextColor(this.f42354i, R.color.CAM_X0107);
                }
                int i4 = this.p;
                if (i4 != 0) {
                    try {
                        SkinManager.setLottieAnimation(this.f42353h, i4);
                        if (this.o == 1) {
                            this.f42353h.setAlpha(0.66f);
                        } else if (this.o == 4) {
                            this.f42353h.setAlpha(0.83f);
                        } else {
                            this.f42353h.setAlpha(1.0f);
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (tBLottieAnimationView = this.f42355j) == null) {
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
            while (it.hasNext() && this.f42354i != null && this.f42353h != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.a.getMeasuredWidth();
                    int measuredHeight3 = value.a.getMeasuredHeight();
                    if (value.f42359b) {
                        left = this.f42354i.getRight() - this.q;
                    } else {
                        left = (this.f42354i.getLeft() + ((int) (this.f42354i.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.f42350e == 1) {
                        measuredHeight = this.f42353h.getTop();
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
                c.a.r0.s.v.c.d(this.f42354i).A(R.string.F_X02);
                this.f42356k.setVisibility(8);
                this.f42353h.playAnimation();
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
            this.f42353h.cancelAnimation();
            this.f42353h.setFrame(0);
            c.a.r0.s.v.c.d(this.f42354i).A(R.string.F_X01);
        }
    }

    public void playAnimation() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (tBLottieAnimationView = this.f42353h) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    public void playDynamicAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            SkinManager.setLottieAnimation(this.f42353h, R.raw.icon_refresh2);
            setText(R.string.refresh);
            this.f42353h.loop(true);
            playAnimation();
        }
    }

    public void playLoadedAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            SkinManager.setLottieAnimation(this.f42353h, R.raw.icon_refresh3);
            setText(R.string.home_recommend);
            this.f42353h.loop(false);
            playAnimation();
        }
    }

    public void playNormalAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            setAnimationResId(this.p);
            this.f42353h.loop(false);
            setText(R.string.home_recommend);
            if (z) {
                this.f42353h.playAnimation();
                c.a.r0.s.v.c.d(this.f42354i).A(R.string.F_X02);
                return;
            }
            this.f42353h.cancelAnimation();
            this.f42353h.setFrame(0);
            c.a.r0.s.v.c.d(this.f42354i).A(R.string.F_X01);
        }
    }

    public void playStaticAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SkinManager.setLottieAnimation(this.f42353h, R.raw.icon_refresh1);
            setText(R.string.refresh);
            this.f42353h.loop(false);
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
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.p = i2;
            SkinManager.setLottieAnimation(this.f42353h, i2);
        }
    }

    public void setDynamicIconData(c.a.r0.i0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            this.dynamicIconData = aVar;
            j();
        }
    }

    public void setImageIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, str2) == null) {
            if (!l.isEmpty(str)) {
                this.f42356k.setVisibility(8);
                this.f42356k.setEvent(new b(this, str2));
                this.f42356k.startLoad(str, 10, false);
                return;
            }
            this.f42356k.setVisibility(8);
        }
    }

    public void setLottieView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || this.f42355j == null) {
            return;
        }
        String p = c.a.r0.s.g0.b.j().p("sync_send_maintab_my_tab_lottie_url", "");
        if (l.isEmpty(p) && z) {
            return;
        }
        i();
        if (TimeHelper.isInTimeBlock(c.a.r0.s.g0.b.j().l("sync_send_maintab_my_tab_lottie_start_time", 0L), c.a.r0.s.g0.b.j().l("sync_send_maintab_my_tab_lottie_end_time", 0L)) && c.a.r0.s.g0.b.j().k("key_lottie_show_count", 0) < 3) {
            this.f42355j.playAnimation();
            this.f42355j.setAnimationUrl(p);
            f();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_INFO_CENTER_LOTTIE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            this.f42355j.addAnimatorListener(new a(this));
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.setSelected(z);
            if (z) {
                this.f42353h.setProgress(1.0f);
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
            this.f42354i.setText(i2);
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
            this.f42350e = i2;
        }
    }

    public void setWriteIconView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f42352g.setVisibility(8);
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
        this.f42350e = 0;
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
        this.f42350e = 0;
        this.o = 3;
        this.s = new HashMap<>();
        this.isHomePageIndicator = false;
        this.isSelectHome = true;
        this.iconStatus = 1;
        h();
    }
}

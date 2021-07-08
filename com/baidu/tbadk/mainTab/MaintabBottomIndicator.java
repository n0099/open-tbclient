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
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.e0.e.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class MaintabBottomIndicator extends TbFragmentTabIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public d.a.o0.e0.e.a C;
    public boolean D;
    public int k;
    public View l;
    public View m;
    public TBLottieAnimationView n;
    public TextView o;
    public TBLottieAnimationView p;
    public TbImageView q;
    public TbImageView r;
    public View s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public HashMap<String, TbFragmentTabIndicator.a> y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaintabBottomIndicator f13107e;

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
            this.f13107e = maintabBottomIndicator;
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
                this.f13107e.k();
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
                this.f13107e.n.setVisibility(8);
                this.f13107e.p.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MaintabBottomIndicator f13109b;

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
            this.f13109b = maintabBottomIndicator;
            this.f13108a = str;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.f13109b.C == null || !c.d().b()) {
                    this.f13109b.q.setVisibility(0);
                }
                if (!k.isEmpty(this.f13108a)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921491, this.f13108a));
                }
                this.f13109b.q.setEvent(null);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
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
        this.k = 0;
        this.u = 3;
        this.y = new HashMap<>();
        this.z = false;
        this.A = true;
        this.B = 1;
        o();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || aVar == null || (view = aVar.f13115a) == null) {
            return;
        }
        addView(view);
        this.y.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void b(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aVar) == null) || aVar == null || (view = aVar.f13115a) == null) {
            return;
        }
        addView(view, -2, -2);
        this.y.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.y.get(str) : (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.e(i2);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.y.entrySet();
            if (entrySet != null && (r0 = entrySet.iterator()) != null) {
                for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                    TbFragmentTabIndicator.a value = entry.getValue();
                    if (value != null) {
                        value.b(i2);
                    }
                }
            }
            if (this.u != i2) {
                this.u = i2;
                int i3 = this.t;
                if (i3 != 0) {
                    SkinManager.setViewTextColor(this.o, i3);
                } else {
                    SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
                }
                int i4 = this.v;
                if (i4 != 0) {
                    try {
                        SkinManager.setLottieAnimation(this.n, i4);
                        if (this.u == 1) {
                            this.n.setAlpha(0.66f);
                        } else if (this.u == 4) {
                            this.n.setAlpha(0.83f);
                        } else {
                            this.n.setAlpha(1.0f);
                        }
                        m();
                    } catch (Exception unused) {
                    }
                }
            }
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0203, i2);
            z();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.f(z);
            this.D = z;
            z();
            if (this.v == 0) {
                return;
            }
            if (z) {
                d.a.o0.r.u.c.d(this.o).y(R.string.F_X02);
                this.q.setVisibility(8);
                this.n.playAnimation();
                HashMap<String, TbFragmentTabIndicator.a> hashMap = this.y;
                if (hashMap != null) {
                    for (TbFragmentTabIndicator.a aVar : hashMap.values()) {
                        if (aVar != null && (view = aVar.f13115a) != null && view.isClickable()) {
                            aVar.f13115a.performClick();
                        }
                    }
                    return;
                }
                return;
            }
            this.n.cancelAnimation();
            this.n.setFrame(0);
            d.a.o0.r.u.c.d(this.o).y(R.string.F_X01);
        }
    }

    public TBLottieAnimationView getAnimationView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int k = d.a.o0.r.d0.b.j().k(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0);
            d.a.o0.r.d0.b.j().w("key_lottie_show_expired_time", System.currentTimeMillis() + 86400000);
            TBLottieAnimationView tBLottieAnimationView = this.p;
            tBLottieAnimationView.setFrame(tBLottieAnimationView.getFrame());
            if (k >= 3) {
                n();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.o0.r.d0.b.j().v(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, d.a.o0.r.d0.b.j().k(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0) + 1);
        }
    }

    public final void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.z && TbadkCoreApplication.getInst().getHomeBarShowType() == 1 && (z = this.A)) {
            int i2 = this.B;
            if (i2 == 1) {
                x(z);
            } else if (i2 == 2) {
                y();
            }
        }
    }

    public void n() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tBLottieAnimationView = this.p) != null && tBLottieAnimationView.getVisibility() == 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            this.p.startAnimation(scaleAnimation);
            this.p.setVisibility(4);
            this.n.setVisibility(0);
            d.a.o0.r.d0.b.j().v(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 4);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = LayoutInflater.from(getContext()).inflate(R.layout.maintab_bottom_indicator_item, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.l.setLayoutParams(layoutParams);
            this.m = this.l.findViewById(R.id.container_common_item);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.l.findViewById(R.id.view_bottom_icon);
            this.n = tBLottieAnimationView;
            tBLottieAnimationView.setSpeed(1.1f);
            this.n.l();
            TbImageView tbImageView = (TbImageView) this.l.findViewById(R.id.image_icon);
            this.q = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.q.setRadius(50);
            this.q.setDefaultBgResource(R.color.transparent);
            this.q.setConrers(15);
            this.r = (TbImageView) this.l.findViewById(R.id.dynamic_image_icon);
            TextView textView = (TextView) this.l.findViewById(R.id.view_bottom_text);
            this.o = textView;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = -l.g(getContext(), R.dimen.M_H_X001);
            this.o.setLayoutParams(marginLayoutParams);
            TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) this.l.findViewById(R.id.animation_view);
            this.p = tBLottieAnimationView2;
            tBLottieAnimationView2.setFirstLoadInternal(true);
            this.s = this.l.findViewById(R.id.bar_cross_line);
            addView(this.l);
            this.w = l.g(getContext(), R.dimen.tbds18);
            this.x = l.g(getContext(), R.dimen.tbds10);
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it;
        int left;
        int measuredHeight;
        int measuredHeight2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.y.entrySet();
            if (entrySet == null || (it = entrySet.iterator()) == null) {
                return;
            }
            while (it.hasNext() && this.o != null && this.n != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                if (value != null) {
                    int measuredWidth = value.f13115a.getMeasuredWidth();
                    int measuredHeight3 = value.f13115a.getMeasuredHeight();
                    if (value.f13116b) {
                        left = this.o.getRight() - this.w;
                    } else {
                        left = (this.o.getLeft() + ((int) (this.o.getMeasuredWidth() * 0.14d))) - measuredWidth;
                    }
                    if (this.k == 1) {
                        measuredHeight = this.n.getTop();
                        measuredHeight2 = this.x;
                    } else {
                        measuredHeight = getMeasuredHeight() / 2;
                        measuredHeight2 = value.f13115a.getMeasuredHeight() / 2;
                    }
                    int i6 = measuredHeight - measuredHeight2;
                    value.f13115a.layout(left, i6, measuredWidth + left, measuredHeight3 + i6);
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            Set<Map.Entry<String, TbFragmentTabIndicator.a>> entrySet = this.y.entrySet();
            if (entrySet == null || (r0 = entrySet.iterator()) == null) {
                return;
            }
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : entrySet) {
                TbFragmentTabIndicator.a value = entry.getValue();
                if (value != null) {
                    ViewGroup.LayoutParams layoutParams = value.f13115a.getLayoutParams();
                    int i4 = layoutParams.width;
                    if (i4 == -2) {
                        value.f13115a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                    } else {
                        if (i4 > size) {
                            i4 = size;
                        }
                        int i5 = layoutParams.height;
                        if (i5 > size2) {
                            i5 = size2;
                        }
                        value.f13115a.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                    }
                }
            }
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n.isAnimating() : invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (System.currentTimeMillis() > d.a.o0.r.d0.b.j().l("key_lottie_show_expired_time", 0L)) {
                d.a.o0.r.d0.b.j().v(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                s(4);
            } else {
                s(this.u);
            }
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            int i3 = this.t;
            if (i3 != 0) {
                SkinManager.setViewTextColor(this.o, i3, 1, i2);
            } else {
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1, i2);
            }
            int i4 = this.v;
            if (i4 != 0) {
                try {
                    if (i2 == 1) {
                        SkinManager.setNightLottieAnimation(this.n, i4);
                        this.n.setAlpha(0.66f);
                    } else if (i2 == 4) {
                        SkinManager.setDarkLottieAnimation(this.n, i4);
                        this.n.setAlpha(0.83f);
                    } else {
                        SkinManager.setLottieAnimation(this.n, i4);
                        this.n.setAlpha(1.0f);
                    }
                    m();
                } catch (Exception unused) {
                }
            }
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0203, i2);
            z();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.v = i2;
            SkinManager.setLottieAnimation(this.n, i2);
        }
    }

    public void setDynamicIconData(d.a.o0.e0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.C = aVar;
            z();
        }
    }

    public void setImageIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (!k.isEmpty(str)) {
                this.q.setVisibility(8);
                this.q.setEvent(new b(this, str2));
                this.q.M(str, 10, false);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void setLottieView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || this.p == null) {
            return;
        }
        String p = d.a.o0.r.d0.b.j().p("sync_send_maintab_my_tab_lottie_url", "");
        if (k.isEmpty(p) && z) {
            return;
        }
        q();
        if (TimeHelper.isInTimeBlock(d.a.o0.r.d0.b.j().l("sync_send_maintab_my_tab_lottie_start_time", 0L), d.a.o0.r.d0.b.j().l("sync_send_maintab_my_tab_lottie_end_time", 0L)) && d.a.o0.r.d0.b.j().k(MainTabActivity.KEY_LOTTIE_SHOW_COUNT, 0) < 3) {
            this.p.playAnimation();
            this.p.setAnimationUrl(p);
            l();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_INFO_CENTER_LOTTIE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            this.p.addAnimatorListener(new a(this));
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            super.setSelected(z);
            if (z) {
                this.n.setProgress(1.0f);
            }
        }
    }

    public void setShowIconType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.o.setText(i2);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.t = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setWriteIconView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.m.setVisibility(8);
        }
    }

    public void t() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (tBLottieAnimationView = this.p) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
    }

    public void u() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (tBLottieAnimationView = this.n) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh2);
            setText(R.string.refresh);
            this.n.loop(true);
            u();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh3);
            setText(R.string.home_recommend);
            this.n.loop(false);
            u();
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            setAnimationResId(this.v);
            this.n.loop(false);
            setText(R.string.home_recommend);
            if (z) {
                this.n.playAnimation();
                return;
            }
            this.n.cancelAnimation();
            this.n.setFrame(0);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            SkinManager.setLottieAnimation(this.n, R.raw.icon_refresh1);
            setText(R.string.refresh);
            this.n.loop(false);
            u();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.C != null && c.d().b()) {
            this.n.setVisibility(8);
            this.p.setVisibility(4);
            this.q.setVisibility(8);
            this.r.setVisibility(0);
            if (this.D) {
                this.r.M(this.C.l(), this.C.j(), false);
            } else {
                this.r.M(this.C.k(), this.C.j(), false);
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
        this.k = 0;
        this.u = 3;
        this.y = new HashMap<>();
        this.z = false;
        this.A = true;
        this.B = 1;
        o();
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
        this.k = 0;
        this.u = 3;
        this.y = new HashMap<>();
        this.z = false;
        this.A = true;
        this.B = 1;
        o();
    }
}

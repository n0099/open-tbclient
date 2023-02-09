package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.p15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CardLiveLabelView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public LinearLayout c;
    public TBLottieAnimationView d;
    public View e;
    public TextView f;
    public RelativeLayout g;
    public TBLottieAnimationView h;
    public TextView i;
    public View j;
    public LinearLayout k;
    public TBLottieAnimationView l;
    public TextView m;
    public TextView n;
    public View o;
    public TextView p;
    public LinearLayout q;
    public TBLottieAnimationView r;
    public TextView s;
    public TextView t;
    public View u;
    public TextView v;
    public RelativeLayout w;
    public View x;

    /* loaded from: classes3.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardLiveLabelView a;

        public a(CardLiveLabelView cardLiveLabelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardLiveLabelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardLiveLabelView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.r.cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardLiveLabelView a;

        public b(CardLiveLabelView cardLiveLabelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardLiveLabelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardLiveLabelView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.l.cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardLiveLabelView a;

        public c(CardLiveLabelView cardLiveLabelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardLiveLabelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardLiveLabelView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.d.cancelAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardLiveLabelView a;

        public d(CardLiveLabelView cardLiveLabelView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardLiveLabelView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardLiveLabelView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.h.cancelAnimation();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardLiveLabelView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && this.a == 1) {
            if (TextUtils.isEmpty(str)) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
                return;
            }
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.f.setText(str);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.m.setText(this.b.getResources().getString(R.string.live_in));
            } else {
                this.m.setText(str);
            }
            this.m.setVisibility(0);
            this.n.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.s.setText(this.b.getResources().getString(R.string.live_in));
            } else {
                this.s.setText(str);
            }
            this.s.setVisibility(0);
            this.t.setVisibility(8);
            this.v.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardLiveLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardLiveLabelView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 1;
        this.x = null;
        this.b = context;
        h();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.a;
            if (i != 1) {
                if (i == 2) {
                    p15 d2 = p15.d(this.c);
                    d2.n(R.string.J_X01);
                    d2.f(R.color.CAM_X0605);
                    p15 d3 = p15.d(this.j);
                    d3.n(R.string.J_X07);
                    d3.f(R.color.CAM_X0310);
                    SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
                    return;
                }
                return;
            }
            float g = ej.g(getContext(), R.dimen.tbds31);
            SkinManager.setBackgroundEndColorToAutoColor(this.c, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g, g, g, g, g, g, g, g});
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = (LinearLayout) this.x.findViewById(R.id.ala_live_lottie_bg);
            this.n = (TextView) this.x.findViewById(R.id.ala_live_state_point);
            this.o = this.x.findViewById(R.id.ala_live_lottie_view);
            this.m = (TextView) this.x.findViewById(R.id.ala_live_state);
            this.p = (TextView) this.x.findViewById(R.id.ala_live_state_desc);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.x.findViewById(R.id.ala_live_lottie);
            this.l = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.l, R.raw.lottie_ala_live);
            this.l.addOnAttachStateChangeListener(new b(this));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q = (LinearLayout) this.x.findViewById(R.id.ala_live_lottie_bg);
            this.t = (TextView) this.x.findViewById(R.id.ala_live_state_point);
            this.u = this.x.findViewById(R.id.ala_live_lottie_view);
            this.s = (TextView) this.x.findViewById(R.id.ala_live_state);
            this.v = (TextView) this.x.findViewById(R.id.ala_live_state_desc);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.x.findViewById(R.id.ala_live_lottie);
            this.r = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.r, R.raw.lottie_ala_live);
            this.r.addOnAttachStateChangeListener(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p15 d2 = p15.d(this.k);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0605);
            p15 d3 = p15.d(this.o);
            d3.n(R.string.J_X07);
            d3.f(R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0101);
            p15 d2 = p15.d(this.q);
            d2.n(R.string.J_X01);
            d2.p(new int[]{R.color.CAM_X0301, R.color.CAM_X0310}, Direction.LEFT);
        }
    }

    public int getViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = (RelativeLayout) LayoutInflater.from(this.b).inflate(R.layout.layout_ala_live_card_label, this).findViewById(R.id.obfuscated_res_0x7f091db7);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.a;
            if (i != 1 && i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        g();
                        return;
                    }
                    return;
                }
                f();
                return;
            }
            e();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = (LinearLayout) this.x.findViewById(R.id.ala_live_lottie_bg);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.x.findViewById(R.id.ala_live_lottie);
            this.d = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.d, R.raw.ala_live2);
            this.d.addOnAttachStateChangeListener(new c(this));
            this.e = this.x.findViewById(R.id.play_count_line);
            this.f = (TextView) this.x.findViewById(R.id.play_count);
            this.g = (RelativeLayout) this.x.findViewById(R.id.ala_live_lottie_container_home);
            this.h = (TBLottieAnimationView) this.x.findViewById(R.id.ala_live_lottie_home);
            this.i = (TextView) this.x.findViewById(R.id.ala_live_state_home);
            this.j = this.x.findViewById(R.id.ala_live_lottie_view_home);
            this.h.loop(true);
            SkinManager.setLottieAnimation(this.h, R.raw.lottie_ala_live);
            this.h.addOnAttachStateChangeListener(new d(this));
            int i = this.a;
            if (i != 1) {
                if (i == 2) {
                    this.g.setVisibility(0);
                    this.i.setVisibility(0);
                    this.d.setVisibility(8);
                    this.e.setVisibility(8);
                    this.f.setVisibility(8);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public void setViewType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a = i;
            if (i != 1 && i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.x = LayoutInflater.from(this.b).inflate(R.layout.layout_ala_live_card_label_c, (ViewGroup) null, false);
                        k();
                    }
                } else {
                    this.x = LayoutInflater.from(this.b).inflate(R.layout.layout_ala_live_card_label_b, (ViewGroup) null, false);
                    j();
                }
            } else {
                this.x = LayoutInflater.from(this.b).inflate(R.layout.layout_ala_live_card_label_a, (ViewGroup) null, false);
                i();
            }
            View view2 = this.x;
            if (view2 != null) {
                this.w.addView(view2);
            }
        }
    }
}

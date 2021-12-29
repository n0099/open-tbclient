package com.baidu.tieba.frs.vc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.c3.e;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class FrsFoldingView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45364e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45365f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout.LayoutParams f45366g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f45367h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f45368i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f45369j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f45370k;
    public View l;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsFoldingView f45371e;

        public a(FrsFoldingView frsFoldingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFoldingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45371e = frsFoldingView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f45371e.f45365f) {
                    this.f45371e.m();
                    this.f45371e.f45365f = false;
                    return;
                }
                this.f45371e.l();
                this.f45371e.f45365f = true;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f45372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFoldingView f45373f;

        public b(FrsFoldingView frsFoldingView, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFoldingView, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45373f = frsFoldingView;
            this.f45372e = valueAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) this.f45372e.getAnimatedValue()).floatValue();
                this.f45373f.f45366g.height = (int) (this.f45373f.f45364e * floatValue);
                this.f45373f.f45369j.setLayoutParams(this.f45373f.f45366g);
                this.f45373f.f45369j.setAlpha(floatValue);
                this.f45373f.f45370k.setRotation((-floatValue) * 180.0f);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f45374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsFoldingView f45375f;

        public c(FrsFoldingView frsFoldingView, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFoldingView, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45375f = frsFoldingView;
            this.f45374e = valueAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) this.f45374e.getAnimatedValue()).floatValue();
                this.f45375f.f45366g.height = (int) (this.f45375f.f45364e * floatValue);
                this.f45375f.f45369j.setLayoutParams(this.f45375f.f45366g);
                this.f45375f.f45369j.setAlpha(floatValue);
                this.f45375f.f45370k.setRotation((-floatValue) * 180.0f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsFoldingView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j();
            k();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(g1.folding_view_layout, (ViewGroup) this, true);
            this.l = inflate;
            this.f45367h = (LinearLayout) inflate.findViewById(f1.folding_root_layout);
            this.f45368i = (FrameLayout) this.l.findViewById(f1.permanent_layout);
            this.f45369j = (FrameLayout) this.l.findViewById(f1.collapsible_layout);
            this.f45370k = (ImageView) this.l.findViewById(f1.folding_arrow);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f45370k, e1.icon_pure_unfold12_svg, c1.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.findViewById(f1.folding_arrow).setOnClickListener(new a(this));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f45366g = (LinearLayout.LayoutParams) this.f45369j.getLayoutParams();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new c(this, ofFloat));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f45366g = (LinearLayout.LayoutParams) this.f45369j.getLayoutParams();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new b(this, ofFloat));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f45370k, e1.icon_pure_unfold12_svg, c1.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void setViews(List<View> list, List<e> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            this.f45368i.removeAllViews();
            this.f45368i.addView(list.get(0));
            if (list.size() > 1) {
                this.f45370k.setVisibility(0);
                this.f45369j.removeAllViews();
                this.f45369j.addView(list.get(1));
                this.f45364e = list2.get(1).getCount() * n.f(getContext().getApplicationContext(), d1.tbds93);
                return;
            }
            this.f45370k.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f45364e = 0;
        this.f45365f = true;
        i();
    }
}

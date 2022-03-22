package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.d.f.p.n;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SmartBubbleAnimatedView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f32337b;

    /* renamed from: c  reason: collision with root package name */
    public float f32338c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f32339d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f32340e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f32341f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f32342g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f32343h;
    public Rect i;
    public e j;
    public int k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public a(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = n.f(this.a.getContext(), R.dimen.tbds83);
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.f32338c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.a.l && (layoutParams instanceof LinearLayout.LayoutParams)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int i = layoutParams2.topMargin;
                    if (i > 0) {
                        layoutParams2.topMargin = i - 5;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = 0;
                    }
                }
                this.a.setLayoutParams(layoutParams);
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public b(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public c(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = (int) (layoutParams.height * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.setLayoutParams(layoutParams);
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public d(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a.j == null) {
                return;
            }
            this.a.j.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.a.j == null) {
                return;
            }
            this.a.j.a();
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

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context) {
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
        this.f32337b = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f32338c = 0.0f;
        this.f32341f = new Paint();
        this.f32342g = new Paint();
        this.f32343h = new RectF();
        this.i = new Rect();
        this.l = false;
        d(null, 0);
    }

    public final void d(AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, attributeSet, i) == null) {
            this.f32341f.setColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.83f));
            this.f32342g.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f32342g.setTextSize(n.f(getContext(), R.dimen.tbds32));
            this.k = n.f(getContext(), R.dimen.tbds83);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f32341f.setColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.83f));
            this.f32342g.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f32342g.setTextSize(n.f(getContext(), R.dimen.tbds32));
            invalidate();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.l) {
                e eVar = this.j;
                if (eVar != null) {
                    eVar.a();
                    return;
                }
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f32340e = ofFloat;
            ofFloat.addUpdateListener(new c(this));
            this.f32340e.addListener(new d(this));
            this.f32340e.setDuration(300L);
            this.f32340e.start();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f32339d = ValueAnimator.ofFloat(0.0f, 1.1f);
            if (this.l) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                    setLayoutParams(layoutParams);
                }
            }
            this.f32339d.addUpdateListener(new a(this));
            this.f32339d.setDuration(400L);
            this.f32339d.start();
            c.a.d.f.m.e.a().postDelayed(new b(this), this.f32337b);
        }
    }

    public int getTipViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            float height = ((1.0f - this.f32338c) * getHeight()) / 2.0f;
            float width = (getWidth() / 2) + ((this.f32338c * getWidth()) / 2.0f);
            float height2 = (getHeight() / 2) + ((this.f32338c * getHeight()) / 2.0f);
            this.f32343h.set(((1.0f - this.f32338c) * getWidth()) / 2.0f, height, width, height2);
            float f2 = (height2 - height) / 2.0f;
            canvas.drawRoundRect(this.f32343h, f2, f2, this.f32341f);
            Paint paint = this.f32342g;
            String str = this.a;
            paint.getTextBounds(str, 0, str.length(), this.i);
            int width2 = this.i.width();
            int height3 = this.i.height();
            String str2 = this.a;
            canvas.drawText(str2, 0, str2.length(), (getWidth() - width2) / 2, getHeight() - ((getHeight() - height3) / 2), this.f32342g);
        }
    }

    public void setExtrusionRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
        }
    }

    public void setOnBubbleAnimateListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.j = eVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
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
        this.f32337b = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f32338c = 0.0f;
        this.f32341f = new Paint();
        this.f32342g = new Paint();
        this.f32343h = new RectF();
        this.i = new Rect();
        this.l = false;
        d(attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
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
        this.f32337b = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f32338c = 0.0f;
        this.f32341f = new Paint();
        this.f32342g = new Paint();
        this.f32343h = new RectF();
        this.i = new Rect();
        this.l = false;
        d(attributeSet, i);
    }
}

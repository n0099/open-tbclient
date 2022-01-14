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
/* loaded from: classes12.dex */
public class SmartBubbleAnimatedView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long delayDuring;

    /* renamed from: e  reason: collision with root package name */
    public float f43138e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f43139f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f43140g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f43141h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f43142i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f43143j;
    public Rect k;
    public e l;
    public int m;
    public boolean n;
    public String tipText;

    /* loaded from: classes12.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f43144e;

        public a(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43144e = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f43144e.getLayoutParams();
                layoutParams.height = n.f(this.f43144e.getContext(), R.dimen.tbds83);
                this.f43144e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f43144e.f43138e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.f43144e.n && (layoutParams instanceof LinearLayout.LayoutParams)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int i2 = layoutParams2.topMargin;
                    if (i2 > 0) {
                        layoutParams2.topMargin = i2 - 5;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = 0;
                    }
                }
                this.f43144e.setLayoutParams(layoutParams);
                this.f43144e.requestLayout();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f43145e;

        public b(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43145e = smartBubbleAnimatedView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43145e.playDismissAnimation();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f43146e;

        public c(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43146e = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f43146e.getLayoutParams();
                layoutParams.height = (int) (layoutParams.height * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f43146e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f43146e.setLayoutParams(layoutParams);
                this.f43146e.requestLayout();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f43147e;

        public d(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43147e = smartBubbleAnimatedView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f43147e.l == null) {
                return;
            }
            this.f43147e.l.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f43147e.l == null) {
                return;
            }
            this.f43147e.l.a();
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

    /* loaded from: classes12.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delayDuring = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f43138e = 0.0f;
        this.f43141h = new Paint();
        this.f43142i = new Paint();
        this.f43143j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(null, 0);
    }

    public final void d(AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, attributeSet, i2) == null) {
            this.f43141h.setColor(c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.83f));
            this.f43142i.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f43142i.setTextSize(n.f(getContext(), R.dimen.tbds32));
            this.m = n.f(getContext(), R.dimen.tbds83);
        }
    }

    public int getTipViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : invokeV.intValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f43141h.setColor(c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.83f));
            this.f43142i.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.f43142i.setTextSize(n.f(getContext(), R.dimen.tbds32));
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float height = ((1.0f - this.f43138e) * getHeight()) / 2.0f;
            float width = (getWidth() / 2) + ((this.f43138e * getWidth()) / 2.0f);
            float height2 = (getHeight() / 2) + ((this.f43138e * getHeight()) / 2.0f);
            this.f43143j.set(((1.0f - this.f43138e) * getWidth()) / 2.0f, height, width, height2);
            float f2 = (height2 - height) / 2.0f;
            canvas.drawRoundRect(this.f43143j, f2, f2, this.f43141h);
            Paint paint = this.f43142i;
            String str = this.tipText;
            paint.getTextBounds(str, 0, str.length(), this.k);
            int width2 = this.k.width();
            int height3 = this.k.height();
            String str2 = this.tipText;
            canvas.drawText(str2, 0, str2.length(), (getWidth() - width2) / 2, getHeight() - ((getHeight() - height3) / 2), this.f43142i);
        }
    }

    public void playDismissAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.n) {
                e eVar = this.l;
                if (eVar != null) {
                    eVar.a();
                    return;
                }
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f43140g = ofFloat;
            ofFloat.addUpdateListener(new c(this));
            this.f43140g.addListener(new d(this));
            this.f43140g.setDuration(300L);
            this.f43140g.start();
        }
    }

    public void playExpansionAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f43139f = ValueAnimator.ofFloat(0.0f, 1.1f);
            if (this.n) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                    setLayoutParams(layoutParams);
                }
            }
            this.f43139f.addUpdateListener(new a(this));
            this.f43139f.setDuration(400L);
            this.f43139f.start();
            c.a.d.f.m.e.a().postDelayed(new b(this), this.delayDuring);
        }
    }

    public void setExtrusionRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void setOnBubbleAnimateListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.l = eVar;
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
        this.delayDuring = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f43138e = 0.0f;
        this.f43141h = new Paint();
        this.f43142i = new Paint();
        this.f43143j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i2) {
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
        this.delayDuring = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f43138e = 0.0f;
        this.f43141h = new Paint();
        this.f43142i = new Paint();
        this.f43143j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(attributeSet, i2);
    }
}

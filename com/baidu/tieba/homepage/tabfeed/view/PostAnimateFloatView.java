package com.baidu.tieba.homepage.tabfeed.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.l.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PostAnimateFloatView extends FrameLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f46153e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f46154f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46155g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46156h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46157i;

    /* renamed from: j  reason: collision with root package name */
    public float f46158j;

    /* renamed from: k  reason: collision with root package name */
    public ValueAnimator f46159k;
    public ValueAnimator l;
    public final Runnable m;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostAnimateFloatView f46160e;

        public a(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46160e = postAnimateFloatView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46160e.animateHide();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostAnimateFloatView f46161e;

        public b(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46161e = postAnimateFloatView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.o1.j.c.f();
                new LocalChannelTopicListActivityConfig(this.f46161e.getContext()).start();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostAnimateFloatView f46162e;

        public c(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46162e = postAnimateFloatView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.f46162e.f46156h) {
                    if (this.f46162e.f46155g != null) {
                        this.f46162e.f46155g.getLayoutParams().width = (int) (this.f46162e.f46158j * floatValue);
                        this.f46162e.f46155g.requestLayout();
                    }
                } else if (this.f46162e.f46155g != null) {
                    this.f46162e.f46155g.getLayoutParams().width = (int) (this.f46162e.f46158j * (1.0f - floatValue));
                    this.f46162e.f46155g.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostAnimateFloatView f46163e;

        public d(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46163e = postAnimateFloatView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f46163e.f46156h) {
                return;
            }
            this.f46163e.f46157i = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f46163e.f46156h) {
                return;
            }
            this.f46163e.f46157i = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) && this.f46163e.f46156h) {
                this.f46163e.f46157i = true;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostAnimateFloatView f46164e;

        public e(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46164e = postAnimateFloatView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.f46164e.f46156h) {
                    if (this.f46164e.f46155g != null) {
                        this.f46164e.f46155g.setAlpha(floatValue);
                    }
                } else if (this.f46164e.f46155g != null) {
                    this.f46164e.f46155g.setAlpha(1.0f - floatValue);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostAnimateFloatView f46165e;

        public f(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46165e = postAnimateFloatView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.f46165e.f46156h) {
                this.f46165e.f46157i = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && this.f46165e.f46156h) {
                this.f46165e.f46157i = false;
                c.a.d.f.m.e.a().postDelayed(this.f46165e.m, 5000L);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f46165e.f46156h) {
                return;
            }
            this.f46165e.f46157i = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostAnimateFloatView(Context context) {
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

    @SuppressLint({"NewApi"})
    public void animateHide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f46157i && this.f46156h) {
            h();
            this.f46156h = false;
            this.l.setStartDelay(0L);
            this.f46159k.setStartDelay(300L);
            this.l.start();
            this.f46159k.start();
        }
    }

    @SuppressLint({"NewApi"})
    public void animateShow() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f46157i || this.f46156h) {
            return;
        }
        h();
        this.f46156h = true;
        this.f46159k.setStartDelay(0L);
        this.l.setStartDelay(250L);
        this.f46159k.start();
        this.l.start();
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.l;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.l.removeAllListeners();
            }
            ValueAnimator valueAnimator2 = this.f46159k;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
                this.f46159k.removeAllListeners();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.m);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.layout_post_animate_float_view, (ViewGroup) this, true);
            this.f46153e = (LinearLayout) findViewById(R.id.root);
            this.f46154f = (ImageView) findViewById(R.id.post_iv);
            TextView textView = (TextView) findViewById(R.id.post_tv);
            this.f46155g = textView;
            this.f46158j = textView.getPaint().measureText(getContext().getString(R.string.post_new_local_thread));
            g();
            this.f46153e.setOnClickListener(new b(this));
        }
    }

    @SuppressLint({"NewApi"})
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f46159k == null) {
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(350L);
                this.f46159k = duration;
                duration.setInterpolator(new LinearInterpolator());
            }
            if (this.l == null) {
                ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(400L);
                this.l = duration2;
                duration2.setInterpolator(new LinearInterpolator());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ValueAnimator valueAnimator = this.f46159k;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f46159k.removeAllListeners();
                this.f46159k.addUpdateListener(new c(this));
                this.f46159k.addListener(new d(this));
            }
            ValueAnimator valueAnimator2 = this.l;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
                this.l.removeAllListeners();
                this.l.addUpdateListener(new e(this));
                this.l.addListener(new f(this));
            }
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            ImageView imageView = this.f46154f;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_issue30, R.color.CAM_X0101, null);
            }
            TextView textView = this.f46155g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            }
            LinearLayout linearLayout = this.f46153e;
            if (linearLayout != null) {
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(linearLayout);
                d2.n(R.string.J_X01);
                d2.h(R.color.CAM_X0302);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostAnimateFloatView(Context context, @Nullable AttributeSet attributeSet) {
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
    public PostAnimateFloatView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.m = new a(this);
        f(context);
    }
}

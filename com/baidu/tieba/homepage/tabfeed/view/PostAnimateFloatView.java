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
/* loaded from: classes5.dex */
public class PostAnimateFloatView extends FrameLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33492b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33493c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33494d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33495e;

    /* renamed from: f  reason: collision with root package name */
    public float f33496f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f33497g;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f33498h;
    public final Runnable i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostAnimateFloatView a;

        public a(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postAnimateFloatView;
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
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostAnimateFloatView a;

        public b(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postAnimateFloatView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.q1.k.c.f();
                new LocalChannelTopicListActivityConfig(this.a.getContext()).start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostAnimateFloatView a;

        public c(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postAnimateFloatView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.a.f33494d) {
                    if (this.a.f33493c != null) {
                        this.a.f33493c.getLayoutParams().width = (int) (this.a.f33496f * floatValue);
                        this.a.f33493c.requestLayout();
                    }
                } else if (this.a.f33493c != null) {
                    this.a.f33493c.getLayoutParams().width = (int) (this.a.f33496f * (1.0f - floatValue));
                    this.a.f33493c.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostAnimateFloatView a;

        public d(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postAnimateFloatView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a.f33494d) {
                return;
            }
            this.a.f33495e = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.a.f33494d) {
                return;
            }
            this.a.f33495e = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) && this.a.f33494d) {
                this.a.f33495e = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostAnimateFloatView a;

        public e(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postAnimateFloatView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.a.f33494d) {
                    if (this.a.f33493c != null) {
                        this.a.f33493c.setAlpha(floatValue);
                    }
                } else if (this.a.f33493c != null) {
                    this.a.f33493c.setAlpha(1.0f - floatValue);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostAnimateFloatView a;

        public f(PostAnimateFloatView postAnimateFloatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postAnimateFloatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postAnimateFloatView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.a.f33494d) {
                this.a.f33495e = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && this.a.f33494d) {
                this.a.f33495e = false;
                c.a.d.f.m.e.a().postDelayed(this.a.i, 5000L);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.a.f33494d) {
                return;
            }
            this.a.f33495e = true;
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

    @SuppressLint({"NewApi"})
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f33495e && this.f33494d) {
            k();
            this.f33494d = false;
            this.f33498h.setStartDelay(0L);
            this.f33497g.setStartDelay(300L);
            this.f33498h.start();
            this.f33497g.start();
        }
    }

    @SuppressLint({"NewApi"})
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f33495e || this.f33494d) {
            return;
        }
        k();
        this.f33494d = true;
        this.f33497g.setStartDelay(0L);
        this.f33498h.setStartDelay(250L);
        this.f33497g.start();
        this.f33498h.start();
    }

    @SuppressLint({"NewApi"})
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f33498h;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f33498h.removeAllListeners();
            }
            ValueAnimator valueAnimator2 = this.f33497g;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
                this.f33497g.removeAllListeners();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.i);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04b4, (ViewGroup) this, true);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ad7);
            this.f33492b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918b4);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0918d0);
            this.f33493c = textView;
            this.f33496f = textView.getPaint().measureText(getContext().getString(R.string.obfuscated_res_0x7f0f0e9c));
            j();
            this.a.setOnClickListener(new b(this));
        }
    }

    @SuppressLint({"NewApi"})
    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f33497g == null) {
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(350L);
                this.f33497g = duration;
                duration.setInterpolator(new LinearInterpolator());
            }
            if (this.f33498h == null) {
                ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(400L);
                this.f33498h = duration2;
                duration2.setInterpolator(new LinearInterpolator());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ValueAnimator valueAnimator = this.f33497g;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f33497g.removeAllListeners();
                this.f33497g.addUpdateListener(new c(this));
                this.f33497g.addListener(new d(this));
            }
            ValueAnimator valueAnimator2 = this.f33498h;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
                this.f33498h.removeAllListeners();
                this.f33498h.addUpdateListener(new e(this));
                this.f33498h.addListener(new f(this));
            }
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            ImageView imageView = this.f33492b;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080914, R.color.CAM_X0101, null);
            }
            TextView textView = this.f33493c;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            }
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(linearLayout);
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
    public PostAnimateFloatView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.i = new a(this);
        i(context);
    }
}

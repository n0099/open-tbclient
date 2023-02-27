package com.baidu.tbadk.widget.falling;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.FallingData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b35;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.jd9;
import com.baidu.tieba.ks5;
import com.baidu.tieba.ls5;
import com.baidu.tieba.ms5;
import com.baidu.tieba.on;
import com.baidu.tieba.yg;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public abstract class FallingView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o a;
    public final List<ks5> b;
    public final Context c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public Paint i;
    public AnimatorSet j;
    public AnimatorSet k;
    public ValueAnimator l;
    public final ConcurrentLinkedQueue<q> m;
    public p n;
    public r o;
    public View.OnClickListener p;
    @NonNull
    public ls5 q;
    @Nullable
    public ms5 r;
    public final Runnable s;
    public final Runnable t;
    public final Runnable u;

    /* loaded from: classes3.dex */
    public interface r {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public abstract ls5 p();

    public abstract ks5 q(Bitmap bitmap);

    public abstract void u(@NonNull View view2, @NonNull FallingData fallingData);

    /* loaded from: classes3.dex */
    public class g extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ FallingData b;
        public final /* synthetic */ FallingView c;

        /* loaded from: classes3.dex */
        public class a extends BaseBitmapDataSubscriber {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                }
            }

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public void onNewResultImpl(Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                    gh.a().removeCallbacks(this.a.c.u);
                    g gVar = this.a;
                    gVar.c.y(gVar.a, gVar.b, bitmap);
                }
            }
        }

        public g(FallingView fallingView, TbPageContext tbPageContext, FallingData fallingData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, tbPageContext, fallingData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fallingView;
            this.a = tbPageContext;
            this.b = fallingData;
        }

        @Override // com.baidu.tieba.yg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // com.baidu.tieba.yg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onVar, str, i) == null) {
                super.onLoaded((g) onVar, str, i);
                if (onVar != null) {
                    gh.a().removeCallbacks(this.c.u);
                    this.c.y(this.a, this.b, onVar.p());
                    return;
                }
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.b.getEggPic())).setProgressiveRenderingEnabled(true).build(), this.c.c).subscribe(new a(this), CallerThreadExecutor.getInstance());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public a(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public b(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a.l.isStarted() && !this.a.g) {
                this.a.l.start();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.h = true;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ FallingView b;

        public c(FallingView fallingView, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fallingView;
            this.a = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.cancel();
                if (this.b.q.f()) {
                    this.b.k.start();
                } else {
                    jd9.b(this.b.a.b, 600);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public d(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public e(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public f(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.v();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ FallingData b;
        public final /* synthetic */ FallingView c;

        public h(FallingView fallingView, TbPageContext tbPageContext, FallingData fallingData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, tbPageContext, fallingData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fallingView;
            this.a = tbPageContext;
            this.b = fallingData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FallingData fallingData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && (fallingData = this.b) != null) {
                this.c.u(view2, fallingData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public i(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.a.f.setPivotX(this.a.a.f.getWidth() / 2);
                this.a.a.f.setPivotY(this.a.a.f.getHeight() / 2);
                this.a.a.f.setScaleX(floatValue);
                this.a.a.f.setScaleY(floatValue);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public j(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                this.a.a.b.setX(pointF.x);
                this.a.a.b.setY(pointF.y);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public k(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.a.a.c.getVisibility() != 0) {
                    this.a.a.c.setVisibility(0);
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.a.a.c.getLayoutParams();
                layoutParams.width = intValue;
                this.a.a.c.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public l(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.a.f.setPivotX(this.a.a.f.getWidth() / 2);
                this.a.a.f.setPivotY(this.a.a.f.getHeight() / 2);
                this.a.a.f.setScaleX(floatValue);
                this.a.a.f.setScaleY(floatValue);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public m(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, animator, z) == null) {
                this.a.a.f.setScaleX(1.0f);
                this.a.a.f.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class n implements TypeEvaluator<PointF> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PointF a;
        public final PointF b;

        public n(PointF pointF, PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pointF, pointF2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pointF;
            this.b = pointF2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public PointF evaluate(float f, PointF pointF, PointF pointF2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), pointF, pointF2})) == null) {
                double d = 1.0f - f;
                double d2 = f;
                return new PointF((int) ((pointF.x * Math.pow(d, 3.0d)) + (this.a.x * 3.0f * f * Math.pow(d, 2.0d)) + (this.b.x * 3.0f * Math.pow(d2, 2.0d) * d) + (pointF2.x * Math.pow(d2, 3.0d))), (int) ((pointF.y * Math.pow(d, 3.0d)) + (this.a.y * 3.0f * f * Math.pow(d, 2.0d)) + (this.b.y * 3.0f * Math.pow(d2, 2.0d) * d) + (pointF2.y * Math.pow(d2, 3.0d))));
            }
            return (PointF) invokeCommon.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public View c;
        public View d;
        public TextView e;
        public TbImageView f;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static o d(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
                o oVar = new o();
                oVar.a = view2;
                oVar.b = view2;
                oVar.c = view2.findViewById(R.id.expand_layout);
                oVar.d = view2.findViewById(R.id.expand_background);
                oVar.e = (TextView) view2.findViewById(R.id.expand_text);
                oVar.f = (TbImageView) view2.findViewById(R.id.buoy_image);
                return oVar;
            }
            return (o) invokeL.objValue;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class p extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<FallingView> a;
        public final /* synthetic */ FallingView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(FallingView fallingView, FallingView fallingView2) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, fallingView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fallingView;
            this.a = new WeakReference<>(fallingView2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (this.a.get() == null) {
                    return;
                }
                for (int i = 0; i < this.b.b.size(); i++) {
                    ((ks5) this.b.b.get(i)).c();
                }
                this.b.invalidate();
                sendEmptyMessageDelayed(0, 5L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FallingData a;
        public final TbPageContext<?> b;

        public q(FallingData fallingData, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingData, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingData;
            this.b = tbPageContext;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FallingView(@NonNull Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FallingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    public final void m(ks5 ks5Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, ks5Var, i2) == null) {
            if (this.d == 0) {
                this.d = ej.l(this.c);
            }
            if (this.e == 0) {
                this.e = ej.j(this.c);
            }
            this.b.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                ks5 ks5Var2 = new ks5(ks5Var.i, this.d, this.e);
                ks5Var2.e = (-i3) * 180;
                this.b.add(ks5Var2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FallingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.b = new ArrayList();
        this.f = false;
        this.g = false;
        this.h = false;
        this.m = new ConcurrentLinkedQueue<>();
        this.s = new e(this);
        this.t = new f(this);
        this.u = new d(this);
        this.c = context;
        r(context);
        this.q = p();
    }

    public final int o(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view2.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public void setAnimationListener(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rVar) == null) {
            this.o = rVar;
        }
    }

    public void setEventCallback(@NonNull ms5 ms5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ms5Var) == null) {
            this.r = ms5Var;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int s = s(1000, i3);
            int s2 = s(600, i2);
            setMeasuredDimension(s2, s);
            this.d = s2;
            this.e = s;
        }
    }

    public final int s(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824) {
                return size;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i2, size);
            }
            return i2;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.b.size() > 0) {
                this.g = false;
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    if (!this.b.get(i2).b(canvas, this.i) && !this.g) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.g = z;
                }
                if (!this.g) {
                    ValueAnimator valueAnimator = this.l;
                    if (valueAnimator != null && !valueAnimator.isStarted() && this.h) {
                        this.l.start();
                        return;
                    }
                    ValueAnimator valueAnimator2 = this.l;
                    if (valueAnimator2 != null && !valueAnimator2.isStarted() && !this.q.f()) {
                        t();
                    } else {
                        t();
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.a.b.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && n(this.a.b, motionEvent.getX(), motionEvent.getY())) {
                View.OnClickListener onClickListener = this.p;
                if (onClickListener != null) {
                    onClickListener.onClick(this.a.b);
                    return true;
                }
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean n(View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = view2.getX();
            float y = view2.getY();
            if (f2 >= x && f2 <= x + view2.getWidth() && f3 >= y && f3 <= y + view2.getHeight()) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void x(@NonNull FallingData fallingData, TbPageContext<?> tbPageContext, boolean z) {
        r rVar;
        r rVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048592, this, fallingData, tbPageContext, z) == null) {
            if (z) {
                z();
                if (w(fallingData, tbPageContext) && (rVar2 = this.o) != null) {
                    rVar2.onAnimationStart();
                }
            } else if (this.f) {
                if (this.q.d()) {
                    this.m.add(new q(fallingData, tbPageContext));
                }
            } else if (w(fallingData, tbPageContext) && (rVar = this.o) != null) {
                rVar.onAnimationStart();
            }
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.a = o.d(LayoutInflater.from(context).inflate(R.layout.rain_falling_click_view, (ViewGroup) null, false));
            this.n = new p(this, this);
            b35 d2 = b35.d(this.a.c);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            b35 d3 = b35.d(this.a.e);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            b35 d4 = b35.d(this.a.d);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0317);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.a.f.setConrers(15);
            this.a.f.setPadding(ej.g(context, R.dimen.tbds10), ej.g(context, R.dimen.tbds5), ej.g(context, R.dimen.tbds10), ej.g(context, R.dimen.tbds5));
            this.a.f.setPlaceHolder(2);
            this.a.f.setLayerType(1, null);
            addView(this.a.b, layoutParams);
            Paint paint = new Paint();
            this.i = paint;
            paint.setDither(true);
        }
    }

    public final void t() {
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            z();
            q poll = this.m.poll();
            if (poll != null) {
                if (!w(poll.a, poll.b) && (rVar = this.o) != null) {
                    rVar.onAnimationEnd();
                    return;
                }
                return;
            }
            r rVar2 = this.o;
            if (rVar2 != null) {
                rVar2.onAnimationEnd();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.a.f.getVisibility() != 0) {
            return;
        }
        if (this.a.b.getVisibility() != 0) {
            this.a.b.setVisibility(0);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
        ofFloat.setDuration(600L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new i(this));
        int j2 = ej.j(this.c);
        int l2 = ej.l(this.c);
        float f2 = l2;
        PointF pointF = new PointF(((3.0f * f2) / 4.0f) - (this.a.f.getWidth() / 2), (-j2) / 4.0f);
        PointF pointF2 = new PointF(ej.g(this.c, R.dimen.tbds50), ej.g(this.c, R.dimen.tbds400));
        float f3 = j2;
        PointF pointF3 = new PointF((f2 / 2.0f) - ej.g(this.c, R.dimen.tbds50), f3 - ej.g(this.c, R.dimen.tbds655));
        int g2 = ej.g(this.c, R.dimen.tbds0);
        if (!this.q.f()) {
            g2 = -(l2 / 4);
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new n(pointF2, pointF3), pointF, new PointF(g2, f3 - ej.g(this.c, R.dimen.tbds552)));
        ofObject.setDuration(this.q.b());
        ofObject.addUpdateListener(new j(this));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, o(this.a.c));
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(500L);
        ofInt.addUpdateListener(new k(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
        ofFloat2.setDuration(600L);
        ofFloat2.setInterpolator(new AccelerateInterpolator());
        ofFloat2.addUpdateListener(new l(this));
        ofFloat2.addListener(new m(this));
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.l.cancel();
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(0);
        this.l = ofInt2;
        ofInt2.setDuration(3000L);
        this.l.addListener(new a(this));
        AnimatorSet animatorSet = this.j;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.j.cancel();
        }
        AnimatorSet animatorSet2 = this.k;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            this.k.cancel();
        }
        ofInt.addListener(new b(this));
        this.k = new AnimatorSet();
        if (this.q.e()) {
            this.k.playSequentially(ofFloat2, ofInt);
        } else {
            this.k.play(ofInt);
        }
        ofObject.addListener(new c(this, ofFloat));
        this.j = new AnimatorSet();
        if (this.q.e()) {
            this.j.playTogether(ofObject, ofFloat);
        } else {
            this.j.play(ofObject);
        }
        this.j.start();
    }

    public boolean w(@NonNull FallingData fallingData, TbPageContext<?> tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, fallingData, tbPageContext)) == null) {
            if (!StringUtils.isNull(fallingData.getContent())) {
                String content = fallingData.getContent();
                if (content.length() > 10) {
                    content = content.substring(0, 9) + StringHelper.STRING_MORE;
                }
                this.a.e.setText(content);
            } else {
                this.a.e.setText(this.c.getString(R.string.check_immediately));
            }
            gh.a().postDelayed(this.u, fallingData.getDelayTime());
            if (!StringUtils.isNull(fallingData.getBuoyPic())) {
                this.a.f.K(fallingData.getBuoyPic(), 10, false);
            } else {
                this.a.f.setVisibility(8);
            }
            zg.h().m(fallingData.getEggPic(), 10, new g(this, tbPageContext, fallingData), tbPageContext.getUniqueId());
            this.n.sendEmptyMessage(0);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void y(TbPageContext<?> tbPageContext, FallingData fallingData, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, tbPageContext, fallingData, bitmap) == null) {
            m(q(bitmap), this.q.c());
            postDelayed(this.t, 1500L);
            this.f = true;
            invalidate();
            this.p = new h(this, tbPageContext, fallingData);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f = false;
            this.h = false;
            this.b.clear();
            removeCallbacks(this.s);
            removeCallbacks(this.t);
            this.a.b.setVisibility(8);
            this.a.c.setVisibility(8);
            AnimatorSet animatorSet = this.j;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.k;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            ValueAnimator valueAnimator = this.l;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.n.removeMessages(0);
        }
    }
}

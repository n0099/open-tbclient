package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.resourceLoaderProc.ImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.d.a;
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class DragImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final int w0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public volatile d.a.c.d.b F;
    public Bitmap G;
    public Paint H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public float R;
    public d.a.r0.b1.i.b.b S;
    public ImageUrlData T;
    public Interpolator U;
    public Matrix V;
    public boolean W;
    public float a0;
    public float b0;
    public Rect c0;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f13187e;

    /* renamed from: f  reason: collision with root package name */
    public int f13188f;

    /* renamed from: g  reason: collision with root package name */
    public int f13189g;

    /* renamed from: h  reason: collision with root package name */
    public float f13190h;

    /* renamed from: i  reason: collision with root package name */
    public float f13191i;
    public RectF i0;
    public ArrayList<Float> j;
    public Rect j0;
    public float k;
    public h k0;
    public float l;
    public int l0;
    public float m;
    public int m0;
    public float n;
    public int n0;
    public boolean o;
    public g o0;
    public byte[] p;
    public BlockingLinkedDeque<g> p0;
    public int q;
    public BlockingLinkedDeque<g> q0;
    public int r;
    public volatile int r0;
    public k s;
    public f s0;
    public View.OnClickListener t;
    public volatile long t0;
    public View.OnLongClickListener u;
    public volatile boolean u0;
    public i v;
    public Handler v0;
    public e w;
    public GestureDetector x;
    public j y;
    public float z;

    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragImageView f13192e;

        public a(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13192e = dragImageView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                DragImageView dragImageView = this.f13192e;
                int i2 = dragImageView.A;
                if (i2 == 1 || i2 == 2 || !dragImageView.P) {
                    return false;
                }
                this.f13192e.B = 2;
                if (this.f13192e.m > this.f13192e.k) {
                    DragImageView dragImageView2 = this.f13192e;
                    dragImageView2.m = dragImageView2.k;
                    DragImageView dragImageView3 = this.f13192e;
                    dragImageView3.n = dragImageView3.m;
                    this.f13192e.n0();
                } else {
                    DragImageView dragImageView4 = this.f13192e;
                    dragImageView4.m = dragImageView4.k * 2.0f;
                    this.f13192e.o0(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f13192e.A != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    this.f13192e.w.e(f2, f3);
                    DragImageView dragImageView = this.f13192e;
                    dragImageView.startAnimation(dragImageView.w);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                if (this.f13192e.u != null && !this.f13192e.C) {
                    this.f13192e.u.onLongClick(this.f13192e);
                }
                super.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f13192e.C = true;
                if (this.f13192e.r == 0 && this.f13192e.D) {
                    return false;
                }
                int scrollX = this.f13192e.getScrollX();
                int scrollY = this.f13192e.getScrollY();
                if (!this.f13192e.d0()) {
                    this.f13192e.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (this.f13192e.f13190h >= this.f13192e.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (this.f13192e.r == 0) {
                        int i2 = scrollX >= 0 ? scrollX : 0;
                        scrollX = ((float) (this.f13192e.getWidth() + i2)) > this.f13192e.f13190h ? (int) (this.f13192e.f13190h - this.f13192e.getWidth()) : i2;
                    }
                }
                if (this.f13192e.f13191i + this.f13192e.I + this.f13192e.J >= this.f13192e.getHeight()) {
                    scrollY = (int) (scrollY + f3);
                    if (this.f13192e.r == 0) {
                        if (scrollY < (-this.f13192e.K)) {
                            scrollY = -this.f13192e.K;
                        }
                        if (this.f13192e.getHeight() + scrollY > this.f13192e.f13191i + this.f13192e.J + this.f13192e.L) {
                            scrollY = (int) ((this.f13192e.f13191i - this.f13192e.getHeight()) + this.f13192e.J + this.f13192e.L);
                        }
                    }
                }
                if (scrollX != this.f13192e.getScrollX() || scrollY != this.f13192e.getScrollY()) {
                    this.f13192e.scrollTo(scrollX, scrollY);
                    this.f13192e.invalidate();
                    if (this.f13192e.y != null) {
                        this.f13192e.y.a(this.f13192e, scrollX, scrollY);
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                if (this.f13192e.t != null && !this.f13192e.C) {
                    this.f13192e.t.onClick(this.f13192e);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f13193e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f13194f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float[] f13195g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DragImageView f13196h;

        public b(DragImageView dragImageView, Rect rect, float[] fArr, float[] fArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView, rect, fArr, fArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13196h = dragImageView;
            this.f13193e = rect;
            this.f13194f = fArr;
            this.f13195g = fArr2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || valueAnimator == null || this.f13193e == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float[] fArr = this.f13194f;
            DragImageView dragImageView = this.f13196h;
            Rect rect = this.f13193e;
            dragImageView.i0 = dragImageView.V(floatValue, fArr[1] + ((this.f13195g[1] - fArr[1]) * valueAnimator.getAnimatedFraction()), rect.right - rect.left, rect.bottom - rect.top);
            this.f13196h.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragImageView f13197e;

        public c(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13197e = dragImageView;
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
                this.f13197e.W = false;
                this.f13197e.B = 4;
                this.f13197e.invalidate();
                if (this.f13197e.k0 != null) {
                    this.f13197e.k0.b();
                }
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
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragImageView f13198e;

        public d(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13198e = dragImageView;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.f13198e.k0();
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        this.f13198e.invalidate();
                        this.f13198e.t0 = System.currentTimeMillis();
                        this.f13198e.v0.sendEmptyMessage(0);
                    }
                } else if (this.f13198e.u0) {
                    this.f13198e.k0();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13199e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f13200f;

        /* renamed from: g  reason: collision with root package name */
        public long f13201g;

        /* renamed from: h  reason: collision with root package name */
        public long f13202h;

        /* renamed from: i  reason: collision with root package name */
        public int f13203i;
        public int j;
        public long k;
        public long l;
        public final /* synthetic */ DragImageView m;

        public e(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = dragImageView;
            this.f13199e = false;
            this.f13200f = false;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            float f3;
            int i3;
            float f4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                long j = this.k;
                long j2 = this.l;
                long j3 = f2 * (j > j2 ? (float) j : (float) j2);
                long j4 = this.k;
                if (j3 <= j4) {
                    j4 = j3;
                }
                float f5 = ((float) j4) / 1000.0f;
                long j5 = this.f13201g;
                if (j5 > 0) {
                    i2 = this.f13203i;
                    f3 = ((float) j5) - ((f5 * 2500.0f) / 2.0f);
                } else {
                    i2 = this.f13203i;
                    f3 = ((float) j5) + ((f5 * 2500.0f) / 2.0f);
                }
                int i4 = i2 - ((int) (f5 * f3));
                long j6 = this.l;
                if (j3 > j6) {
                    j3 = j6;
                }
                float f6 = ((float) j3) / 1000.0f;
                long j7 = this.f13202h;
                if (j7 > 0) {
                    i3 = this.j;
                    f4 = ((float) j7) - ((2500.0f * f6) / 2.0f);
                } else {
                    i3 = this.j;
                    f4 = ((float) j7) + ((2500.0f * f6) / 2.0f);
                }
                int i5 = i3 - ((int) (f6 * f4));
                int i6 = 0;
                if (this.m.f13191i + this.m.I + this.m.J > this.m.getHeight()) {
                    if (i5 < (-this.m.K)) {
                        i5 = -this.m.K;
                    }
                    if (this.m.getHeight() + i5 > this.m.f13191i + this.m.J + this.m.L) {
                        i5 = (int) ((this.m.f13191i - this.m.getHeight()) + this.m.J + this.m.L);
                    }
                } else {
                    i5 = 0;
                }
                if (this.m.f13190h > this.m.getWidth()) {
                    if (this.m.getWidth() + i4 > this.m.f13190h) {
                        i4 = (int) (this.m.f13190h - this.m.getWidth());
                    }
                    if (i4 >= 0) {
                        i6 = i4;
                    }
                }
                this.m.scrollTo(i6, i5);
                this.m.invalidate();
            }
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13199e : invokeV.booleanValue;
        }

        public void e(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (f2 > 1500.0f) {
                    f2 = 1500.0f;
                } else if (f2 < -1500.0f) {
                    f2 = -1500.0f;
                }
                if (f3 > 1500.0f) {
                    f3 = 1500.0f;
                } else if (f3 < -1500.0f) {
                    f3 = -1500.0f;
                }
                this.f13201g = f2;
                this.f13202h = f3;
                this.k = Math.abs((f2 * 1000.0f) / 2500.0f);
                long abs = Math.abs((f3 * 1000.0f) / 2500.0f);
                this.l = abs;
                setDuration(Math.max(this.k, abs));
                setInterpolator(this.m.U);
                this.f13203i = this.m.getScrollX();
                this.j = this.m.getScrollY();
                this.f13199e = true;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f13200f = true;
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j, transformation)) == null) {
                if (!this.f13200f) {
                    if (this.m.o) {
                        this.f13199e = false;
                        return false;
                    }
                    try {
                        if (super.getTransformation(j, transformation)) {
                            return true;
                        }
                        this.f13199e = false;
                        return false;
                    } catch (Exception unused) {
                        this.f13199e = false;
                        return false;
                    }
                }
                this.f13200f = false;
                this.f13199e = false;
                return false;
            }
            return invokeJL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f13206a;

        /* renamed from: b  reason: collision with root package name */
        public int f13207b;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(DragImageView dragImageView);
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(DragImageView dragImageView, int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2100750185, "Lcom/baidu/tbadk/widget/DragImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2100750185, "Lcom/baidu/tbadk/widget/DragImageView;");
                return;
            }
        }
        w0 = l.i(TbadkCoreApplication.getInst()) / 5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13187e = new Matrix();
        this.f13188f = 0;
        this.f13189g = 0;
        this.o = false;
        this.p = null;
        this.q = 1300;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.z = 1.0f;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.H = new Paint(-16777216);
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.P = true;
        this.U = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.V = new Matrix();
        this.W = false;
        this.a0 = 1.0f;
        this.b0 = 0.0f;
        this.i0 = new RectF();
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = null;
        this.p0 = new BlockingLinkedDeque<>(5);
        this.q0 = new BlockingLinkedDeque<>(6);
        this.r0 = 0;
        this.t0 = 0L;
        this.u0 = true;
        this.v0 = new Handler(new d(this));
        X();
    }

    public static /* synthetic */ int E(DragImageView dragImageView) {
        int i2 = dragImageView.r0;
        dragImageView.r0 = i2 + 1;
        return i2;
    }

    private int getScreenWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeV.intValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.D = false;
            this.o = false;
            this.B = 3;
            O();
            float f2 = this.m;
            float f3 = this.k;
            if (f2 < f3) {
                this.m = f3;
                n0();
            }
            invalidate();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int scrollX = getScrollX();
            int i2 = 0;
            if (this.f13190h >= getWidth()) {
                if (scrollX < 0) {
                    scrollX = 0;
                }
                float f2 = this.f13190h;
                if (getWidth() + scrollX > f2) {
                    scrollX = (int) (f2 - getWidth());
                }
            }
            int scrollY = getScrollY();
            if (this.f13191i + this.I + this.J >= getHeight()) {
                int i3 = this.K;
                if (scrollY < (-i3)) {
                    scrollY = -i3;
                }
                i2 = scrollY;
                float f3 = this.f13191i;
                if (getHeight() + i2 > this.J + f3 + this.L) {
                    i2 = (int) ((f3 - getHeight()) + this.J + this.L);
                }
            }
            if (scrollX == getScrollX() && i2 == getScrollY()) {
                return;
            }
            scrollTo(scrollX, i2);
            invalidate();
            j jVar = this.y;
            if (jVar != null) {
                jVar.a(this, scrollX, i2);
            }
        }
    }

    public final void P() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (kVar = this.s) == null) {
            return;
        }
        kVar.a(this, Q(), R());
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.A;
            if (i2 != 1 && i2 != 2) {
                int size = this.j.size();
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled() && size > 0) {
                    float floatValue = this.j.get(size - 1).floatValue();
                    if (((int) (imageBitmap.getWidth() * imageBitmap.getHeight() * floatValue * floatValue)) * 1.25f * 1.25f <= this.q && floatValue <= 5.0f) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.A;
            if (i2 != 1 && i2 != 2) {
                int size = this.j.size();
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled() && size > 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public g S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g poll = this.q0.poll();
            if (poll == null) {
                poll = new g();
                try {
                    poll.f13206a = Bitmap.createBitmap(this.l0, this.m0, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                }
            }
            return poll;
        }
        return (g) invokeV.objValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.S == null) {
            d.a.r0.b1.i.b.b bVar = new d.a.r0.b1.i.b.b(this);
            this.S = bVar;
            bVar.S(this.t);
            this.S.T(this.u);
        }
    }

    public float U(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bitmap)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                return bVar.y();
            }
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                return 1.0f;
            }
            float sqrt = (float) Math.sqrt(this.q / (bitmap.getWidth() * bitmap.getHeight()));
            if (sqrt > 10.0f) {
                return 10.0f;
            }
            return sqrt;
        }
        return invokeL.floatValue;
    }

    public final RectF V(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f4 / 2.0f;
            float f7 = f5 / 2.0f;
            return new RectF(f2 - f6, f3 - f7, f2 + f6, f3 + f7);
        }
        return (RectF) invokeCommon.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (getImageBitmap() == null || this.S == null) ? false : true : invokeV.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.R = l.h(getContext());
            int i2 = l.i(getContext()) * l.k(getContext()) * 2;
            this.q = i2;
            if (i2 < 1690000) {
                this.q = 1690000;
            }
            this.f13190h = 0.0f;
            this.f13191i = 0.0f;
            this.j = new ArrayList<>();
            this.k = 1.0f;
            this.l = 1.0f;
            this.m = 1.0f;
            this.n = 1.0f;
            setClickable(true);
            setScaleType(ImageView.ScaleType.MATRIX);
            this.w = new e(this);
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            setWillNotDraw(false);
            scrollTo(0, 0);
            this.x = new GestureDetector(getContext(), new a(this));
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                return bVar.D();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar == null) {
                return false;
            }
            return bVar.G();
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar == null) {
                return false;
            }
            return bVar.H();
        }
        return invokeV.booleanValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.w.d()) {
                this.w.f();
            }
            super.setImageDrawable(null);
            this.p = null;
            this.G = null;
            s0();
            if (this.F != null) {
                this.F.close();
                this.F = null;
            }
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                bVar.O();
                System.gc();
            }
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (this.S == null || this.k != this.m) {
                return super.canScrollHorizontally(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (int) this.f13190h : invokeV.intValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        d.a.r0.b1.i.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (bVar = this.S) == null) {
            return;
        }
        bVar.t();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (int) this.f13191i : invokeV.intValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int i2 = this.A;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            return !this.D && getScrollX() <= 0;
        }
        return invokeV.booleanValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i2 = this.A;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            return !this.D && getScrollX() >= ((int) (this.f13190h - ((float) getWidth()))) - 1;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                return bVar.F();
            }
            return this.k == this.m;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.A == 1) {
            f fVar = this.s0;
            if (fVar != null) {
                fVar.f13204e = false;
                this.s0.interrupt();
            }
            this.v0.removeMessages(0);
            this.v0.removeMessages(1);
            this.v0.removeMessages(2);
        }
    }

    public int getBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.L : invokeV.intValue;
    }

    public g getCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.o0 : (g) invokeV.objValue;
    }

    public Bitmap getGifCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.G : (Bitmap) invokeV.objValue;
    }

    public Bitmap getImageBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Drawable drawable = getDrawable();
            if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                return null;
            }
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return (Bitmap) invokeV.objValue;
    }

    public byte[] getImageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (byte[]) invokeV.objValue;
    }

    public int getImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.A : invokeV.intValue;
    }

    public ImageUrlData getImageUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.T : (ImageUrlData) invokeV.objValue;
    }

    public int getLeftOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.M : invokeV.intValue;
    }

    public float getMinScaleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                return bVar.z();
            }
            return this.k / 4.0f;
        }
        return invokeV.floatValue;
    }

    public float[] getResizedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new float[]{this.f13190h, this.f13191i} : (float[]) invokeV.objValue;
    }

    public Bitmap getVisableBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            Matrix matrix = new Matrix(this.f13187e);
            matrix.postTranslate(-scrollX, -scrollY);
            canvas.drawBitmap(getImageBitmap(), matrix, null);
            return createBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void h0() {
        d.a.c.k.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.A == 1) {
            if (this.F == null) {
                f fVar = this.s0;
                if (fVar != null) {
                    fVar.f13204e = false;
                    this.s0.interrupt();
                    this.s0 = null;
                }
                if (this.p == null) {
                    return;
                }
                try {
                    aVar = a.C0584a.b().a(this.p, 0, this.p.length);
                } catch (StackOverflowError unused) {
                    aVar = null;
                }
                if (aVar != null && aVar.l() != null) {
                    this.F = aVar.l();
                    if (this.F != null) {
                        this.E = 1;
                        this.l0 = this.F.getWidth();
                        this.m0 = this.F.getHeight();
                        this.r0 = 0;
                        this.n0 = this.F.getFrameCount();
                    } else {
                        this.E = 0;
                    }
                } else {
                    d.a.r0.r.z.a.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                    return;
                }
            }
            if (this.F == null) {
                return;
            }
            f fVar2 = this.s0;
            if (fVar2 == null || !(fVar2 == null || fVar2.f13204e)) {
                this.u0 = true;
                this.s0 = new f(this, null);
                this.p0.clear();
                this.q0.clear();
                this.s0.f13204e = true;
                this.s0.start();
            }
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            Bitmap imageBitmap = getImageBitmap();
            if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
                this.k = j0(imageBitmap);
                this.l = U(imageBitmap);
                this.j.clear();
                this.j.add(Float.valueOf(this.k));
                float f2 = this.k;
                this.m = f2;
                this.n = f2;
                n0();
                return;
            }
            this.f13190h = 0.0f;
            this.f13191i = 0.0f;
            this.k = 1.0f;
            this.l = 1.0f;
            this.m = 1.0f;
            this.n = 1.0f;
            this.j.clear();
        }
    }

    public float j0(Bitmap bitmap) {
        InterceptResult invokeL;
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, bitmap)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                return bVar.N();
            }
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                return 1.0f;
            }
            if (this.r == 0) {
                float width = this.f13188f / bitmap.getWidth();
                float height = this.f13189g / bitmap.getHeight();
                if (this.Q) {
                    if (this.A == 2) {
                        return 2.5f;
                    }
                    min = Math.min(width, height);
                } else if (this.A == 2) {
                    return 1.0f;
                } else {
                    float f2 = this.R;
                    float f3 = f2 >= 1.0f ? f2 : 1.0f;
                    if (bitmap.getWidth() * f3 < this.f13188f && bitmap.getHeight() * f3 < this.f13189g) {
                        return f3;
                    }
                    min = Math.min(width, height);
                }
                return min;
            }
            return Math.max(this.f13188f / bitmap.getWidth(), ((this.f13189g - this.I) - this.J) / bitmap.getHeight());
        }
        return invokeL.floatValue;
    }

    public final void k0() {
        g gVar;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            g poll = this.p0.poll();
            if (poll == null) {
                this.u0 = true;
                return;
            }
            this.u0 = false;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.o0 != null) {
                j2 = gVar.f13207b - (currentTimeMillis - this.t0);
                this.q0.offer(this.o0);
            } else {
                j2 = 0;
            }
            this.o0 = poll;
            this.v0.sendEmptyMessageDelayed(2, j2 > 0 ? j2 : 0L);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.w.d()) {
                this.w.f();
            }
            s0();
            super.setImageDrawable(null);
            this.G = null;
        }
    }

    public void m0(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bitmap) == null) {
            Bitmap imageBitmap = getImageBitmap();
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.f13187e);
                return;
            }
            if (this.w.d()) {
                this.w.f();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.f13187e);
            scrollTo(scrollX, scrollY);
            this.A = 0;
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            o0(false, -1, -1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x011a A[Catch: Exception -> 0x0175, TryCatch #0 {Exception -> 0x0175, blocks: (B:9:0x0013, B:11:0x0018, B:13:0x0020, B:15:0x0030, B:14:0x002e, B:16:0x0032, B:18:0x0076, B:20:0x0081, B:22:0x008a, B:24:0x0097, B:26:0x009e, B:27:0x00a1, B:28:0x00ae, B:30:0x00c0, B:32:0x00ca, B:33:0x00ce, B:53:0x011a, B:55:0x0127, B:56:0x0130, B:58:0x0134, B:59:0x013a, B:61:0x0145, B:63:0x0151, B:65:0x015c, B:71:0x0169, B:36:0x00d6, B:38:0x00dc, B:40:0x00e3, B:49:0x0112, B:41:0x00ea, B:43:0x00ee, B:44:0x00f4, B:46:0x00ff, B:48:0x010b), top: B:79:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0134 A[Catch: Exception -> 0x0175, TryCatch #0 {Exception -> 0x0175, blocks: (B:9:0x0013, B:11:0x0018, B:13:0x0020, B:15:0x0030, B:14:0x002e, B:16:0x0032, B:18:0x0076, B:20:0x0081, B:22:0x008a, B:24:0x0097, B:26:0x009e, B:27:0x00a1, B:28:0x00ae, B:30:0x00c0, B:32:0x00ca, B:33:0x00ce, B:53:0x011a, B:55:0x0127, B:56:0x0130, B:58:0x0134, B:59:0x013a, B:61:0x0145, B:63:0x0151, B:65:0x015c, B:71:0x0169, B:36:0x00d6, B:38:0x00dc, B:40:0x00e3, B:49:0x0112, B:41:0x00ea, B:43:0x00ee, B:44:0x00f4, B:46:0x00ff, B:48:0x010b), top: B:79:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145 A[Catch: Exception -> 0x0175, TryCatch #0 {Exception -> 0x0175, blocks: (B:9:0x0013, B:11:0x0018, B:13:0x0020, B:15:0x0030, B:14:0x002e, B:16:0x0032, B:18:0x0076, B:20:0x0081, B:22:0x008a, B:24:0x0097, B:26:0x009e, B:27:0x00a1, B:28:0x00ae, B:30:0x00c0, B:32:0x00ca, B:33:0x00ce, B:53:0x011a, B:55:0x0127, B:56:0x0130, B:58:0x0134, B:59:0x013a, B:61:0x0145, B:63:0x0151, B:65:0x015c, B:71:0x0169, B:36:0x00d6, B:38:0x00dc, B:40:0x00e3, B:49:0x0112, B:41:0x00ea, B:43:0x00ee, B:44:0x00f4, B:46:0x00ff, B:48:0x010b), top: B:79:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(boolean z, int i2, int i3) {
        Bitmap imageBitmap;
        float f2;
        float width;
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || (imageBitmap = getImageBitmap()) == null || imageBitmap.isRecycled()) {
            return;
        }
        try {
            if (this.B != 2) {
                int size = this.j.size();
                if (size > 0) {
                    f3 = this.j.get(size - 1).floatValue();
                } else {
                    f3 = this.k;
                }
                this.m = f3;
            }
            this.f13187e.setScale(this.m, this.m);
            this.f13190h = imageBitmap.getWidth() * this.m;
            this.f13191i = imageBitmap.getHeight() * this.m;
            float width2 = imageBitmap.getWidth() * this.n;
            float height = imageBitmap.getHeight() * this.n;
            this.K = this.I;
            int i4 = 0;
            this.L = 0;
            float f4 = 0.0f;
            float f5 = this.f13190h < ((float) this.f13188f) ? (int) ((this.f13188f - this.f13190h) / 2.0f) : 0.0f;
            if (this.f13191i < this.f13189g) {
                float f6 = (int) ((this.f13189g - this.f13191i) / 2.0f);
                if (this.r == 1 && f6 > this.I) {
                    f6 = this.I;
                }
                f4 = f6;
                int i5 = (int) (this.I - f4);
                this.K = i5;
                this.L = this.I - i5;
            }
            this.M = (int) f5;
            this.f13187e.postTranslate(f5, f4);
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (z) {
                int screenWidth = getScreenWidth();
                if (i2 > getWidth()) {
                    i2 = getWidth();
                }
                float f7 = screenWidth;
                if (this.f13190h > f7) {
                    if (this.f13190h > f7 && this.f13190h / 2.0f < f7) {
                        f2 = i2;
                        width = this.f13190h / 4.0f;
                        i2 = (int) (f2 - width);
                    }
                    if (i2 > 0) {
                        i2 = (int) (this.f13190h - getWidth());
                    }
                    if (this.B == 2) {
                    }
                    if (this.f13191i <= getHeight()) {
                    }
                    setHorizontalScrollBarEnabled(false);
                    setVerticalScrollBarEnabled(false);
                    if (i2 < 0) {
                    }
                    if (scrollY >= 0) {
                    }
                    scrollTo(i2, i4);
                    setImageMatrix(this.f13187e);
                    P();
                }
                i2 = 0;
                if (i2 > 0 && this.f13190h - i2 < getWidth()) {
                    i2 = (int) (this.f13190h - getWidth());
                }
                if (this.B == 2) {
                    scrollY += (int) ((this.f13191i - height) / 2.0f);
                }
                if (this.f13191i <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.f13191i) {
                    scrollY = (int) (this.f13191i - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (i2 < 0) {
                    i2 = 0;
                }
                if (scrollY >= 0) {
                    i4 = scrollY;
                }
                scrollTo(i2, i4);
                setImageMatrix(this.f13187e);
                P();
            }
            if (this.B == 2) {
                scrollX += (int) ((this.f13190h - width2) / 2.0f);
            }
            if (this.f13190h > getWidth()) {
                if (getWidth() + scrollX > this.f13190h) {
                    f2 = this.f13190h;
                    width = getWidth();
                    i2 = (int) (f2 - width);
                    if (i2 > 0) {
                    }
                    if (this.B == 2) {
                    }
                    if (this.f13191i <= getHeight()) {
                    }
                    setHorizontalScrollBarEnabled(false);
                    setVerticalScrollBarEnabled(false);
                    if (i2 < 0) {
                    }
                    if (scrollY >= 0) {
                    }
                    scrollTo(i2, i4);
                    setImageMatrix(this.f13187e);
                    P();
                }
                i2 = scrollX;
                if (i2 > 0) {
                }
                if (this.B == 2) {
                }
                if (this.f13191i <= getHeight()) {
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (i2 < 0) {
                }
                if (scrollY >= 0) {
                }
                scrollTo(i2, i4);
                setImageMatrix(this.f13187e);
                P();
            }
            i2 = 0;
            if (i2 > 0) {
            }
            if (this.B == 2) {
            }
            if (this.f13191i <= getHeight()) {
            }
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            if (i2 < 0) {
            }
            if (scrollY >= 0) {
            }
            scrollTo(i2, i4);
            setImageMatrix(this.f13187e);
            P();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onAttachedToWindow();
            h0();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onDetachedFromWindow();
            c0();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        g gVar;
        Bitmap bitmap2;
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, canvas) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar == null || !bVar.K(canvas, getImageBitmap())) {
                if (this.A == 2 && this.N != 0 && !this.w.d()) {
                    int width = getWidth();
                    int height = getHeight();
                    Drawable drawable = getDrawable();
                    float f6 = height;
                    float f7 = 0.3f * f6;
                    float f8 = width;
                    float f9 = f6 * 0.7f;
                    if (!this.Q || drawable == null) {
                        f2 = f7;
                        f3 = f9;
                        f4 = f8;
                        f5 = 0.0f;
                    } else {
                        Rect bounds = drawable.getBounds();
                        int i2 = bounds.right - bounds.left;
                        int i3 = bounds.bottom - bounds.top;
                        float f10 = width / 2;
                        float f11 = i2 * 2.5f;
                        float f12 = height / 2;
                        float f13 = i3 * 2.5f;
                        f3 = f12 + f13;
                        f2 = f12 - f13;
                        f5 = f10 - f11;
                        f4 = f10 + f11;
                    }
                    this.H.setColor(SkinManager.getColor(this.N));
                    canvas.drawRect(f5, f2, f4, f3, this.H);
                    this.H.setColor(-16777216);
                }
                boolean z = false;
                if (this.B == 3 && this.W) {
                    this.W = false;
                    this.V.reset();
                    if (this.b0 < w0) {
                        this.B = 0;
                    } else {
                        this.B = 4;
                        r0();
                    }
                }
                if (this.A == 0 && this.W && this.c0 != null && this.T != null) {
                    canvas.drawColor(Color.argb((int) (this.a0 * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                    if (this.i0 == null) {
                        this.i0 = new RectF();
                    }
                    this.V.mapRect(this.i0, new RectF(this.c0));
                    Bitmap imageBitmap = getImageBitmap();
                    if (imageBitmap != null && !imageBitmap.isRecycled()) {
                        canvas.drawBitmap(getImageBitmap(), this.j0, this.i0, (Paint) null);
                    }
                } else if (this.B == 4 && this.c0 != null) {
                    canvas.drawColor(Color.argb((int) (this.a0 * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                    Bitmap imageBitmap2 = getImageBitmap();
                    if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                        canvas.drawBitmap(getImageBitmap(), this.j0, this.i0, (Paint) null);
                    }
                } else {
                    try {
                        super.onDraw(canvas);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                if (this.A != 1 || (bitmap = this.G) == null || bitmap.isRecycled()) {
                    return;
                }
                int width2 = this.G.getWidth();
                int height2 = this.G.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i4 = (width3 - width2) >> 1;
                int i5 = (height3 - height2) >> 1;
                float f14 = this.R;
                if (f14 < 1.0f) {
                    f14 = 1.0f;
                }
                float f15 = width2;
                float f16 = width3;
                if (f15 * f14 >= f16 || height2 * f14 >= height3) {
                    f14 = Math.min(f16 / f15, height3 / height2);
                }
                if (Math.abs(f14 - 1.0f) < 1.0E-8f) {
                    z = true;
                } else {
                    this.f13187e.setScale(f14, f14);
                    float f17 = f15 * f14;
                    i4 = (int) ((f16 - f17) / 2.0f);
                    float f18 = height2 * f14;
                    i5 = (int) ((height3 - f18) / 2.0f);
                    this.f13187e.postTranslate(i4, i5);
                    width2 = (int) f17;
                    height2 = (int) f18;
                }
                canvas.clipRect(i4, i5, width2 + i4, height2 + i5);
                canvas.drawColor(-1);
                if (this.E != 1 || this.F == null || (gVar = this.o0) == null || (bitmap2 = gVar.f13206a) == null) {
                    if (z) {
                        canvas.drawBitmap(this.G, i4, i5, (Paint) null);
                        return;
                    } else {
                        canvas.drawBitmap(this.G, this.f13187e, this.H);
                        return;
                    }
                }
                if (z) {
                    canvas.drawBitmap(bitmap2, i4, i5, (Paint) null);
                } else {
                    canvas.drawBitmap(bitmap2, this.f13187e, this.H);
                }
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (z) {
                this.f13188f = i4 - i2;
                this.f13189g = i5 - i3;
                i0();
            }
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        d.a.r0.b1.i.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0 || (bVar = this.S) == null) {
                return;
            }
            bVar.V();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, motionEvent)) == null) {
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null && bVar.M(motionEvent)) {
                if (getScrollX() != 0 || getScrollY() != 0) {
                    this.S.I(getScrollX(), getScrollY());
                    scrollTo(0, 0);
                }
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            if (action == 0) {
                this.B = 0;
                this.o = true;
                this.C = false;
                this.D = false;
            } else if (action != 1) {
                if (action == 2 && this.B == 0) {
                    this.B = 1;
                }
            } else {
                N();
            }
            if (action == CompatibleUtile.getInstance().getActionPointerUp()) {
                this.B = 1;
            } else if (action == CompatibleUtile.getInstance().getActionPointerDown()) {
                float q0 = q0(motionEvent);
                this.z = q0;
                if (q0 > 10.0f) {
                    this.B = 2;
                }
            }
            if ((this.B == 2 || !this.x.onTouchEvent(motionEvent)) && this.P) {
                if (action == 2 && this.B == 2) {
                    this.C = true;
                    this.D = true;
                    int i2 = this.A;
                    if (i2 != 1 && i2 != 2) {
                        float q02 = q0(motionEvent);
                        if (q02 >= 0.0f && Math.abs(this.z - q02) >= 10.0f) {
                            if (Math.abs(this.z - q02) > 100.0f) {
                                this.z = q02;
                            } else {
                                float f2 = q02 / this.z;
                                this.z = q02;
                                float f3 = this.m;
                                this.n = f3;
                                float f4 = f3 * f2;
                                this.m = f4;
                                float f5 = this.l;
                                if (f4 > f5) {
                                    this.m = f5;
                                }
                                float minScaleValue = getMinScaleValue();
                                if (this.m < minScaleValue) {
                                    this.m = minScaleValue;
                                }
                                n0();
                            }
                        }
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            P();
            int i2 = this.A;
            if (i2 == 1 || i2 == 2 || this.m == this.k) {
                return;
            }
            this.j.clear();
            this.j.add(Float.valueOf(this.k));
            float f2 = this.k;
            this.m = f2;
            this.n = f2;
            n0();
        }
    }

    public float q0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, motionEvent)) == null) ? CompatibleUtile.getInstance().getSpacing(motionEvent) : invokeL.floatValue;
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            ImageUrlData imageUrlData = this.T;
            if (imageUrlData == null) {
                h hVar = this.k0;
                if (hVar != null) {
                    hVar.b();
                    return;
                }
                return;
            }
            Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
            if (sourceImageRectInScreen == null) {
                h hVar2 = this.k0;
                if (hVar2 != null) {
                    hVar2.b();
                    return;
                }
                return;
            }
            int i2 = sourceImageRectInScreen.bottom;
            int i3 = sourceImageRectInScreen.top;
            int i4 = sourceImageRectInScreen.right;
            int i5 = sourceImageRectInScreen.left;
            RectF rectF = this.i0;
            float f2 = rectF.right;
            float f3 = rectF.left;
            float f4 = rectF.top;
            float f5 = (((i2 - i3) / (i4 - i5)) * (f2 - f3)) + f4;
            rectF.bottom = f5;
            float[] fArr = {(f3 + f2) / 2.0f, (f4 + f5) / 2.0f};
            float[] fArr2 = {(i5 + i4) / 2, (i3 + i2) / 2};
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
            ofFloat.setDuration(150L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new b(this, sourceImageRectInScreen, fArr, fArr2));
            ofFloat.addListener(new c(this));
            ofFloat.start();
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.A == 1) {
            f fVar = this.s0;
            if (fVar != null) {
                fVar.f13204e = false;
                this.s0.interrupt();
                this.s0 = null;
            }
            this.v0.removeMessages(0);
            this.v0.removeMessages(1);
            this.v0.removeMessages(2);
            this.u0 = true;
            this.o0 = null;
            this.q0.clear();
            this.p0.clear();
            this.l0 = 0;
            this.m0 = 0;
            this.r0 = 0;
            this.n0 = 0;
            this.F = null;
        }
    }

    public void setCanScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.P = z;
        }
    }

    public void setDefaultBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.w.d()) {
                this.w.f();
            }
            try {
                if (this.Q) {
                    super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.icon_default_avatar100));
                } else {
                    super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.btn_see_default));
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                super.setImageBitmap(null);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            this.A = 2;
            i0();
        }
    }

    public void setDragToExitListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, hVar) == null) {
            this.k0 = hVar;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, bArr, bitmap) == null) {
            if (this.w.d()) {
                this.w.f();
            }
            super.setImageDrawable(null);
            s0();
            i0();
            this.A = 1;
            this.G = bitmap;
            this.p = bArr;
            i iVar = this.v;
            if (iVar != null) {
                iVar.a(this);
            }
        }
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
        }
    }

    public void setGifSetListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, iVar) == null) {
            this.v = iVar;
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bitmap) == null) {
            if (this.w.d()) {
                this.w.f();
            }
            this.N = 0;
            super.setImageBitmap(bitmap);
            i0();
            this.A = 0;
            if (this.c0 == null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / bitmap.getWidth()) * bitmap.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF V = V(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.c0 = new Rect((int) V.left, (int) V.top, (int) V.right, (int) V.bottom);
            }
            if (this.j0 == null) {
                this.j0 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, bitmap, bArr) == null) {
            this.p = bArr;
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                bVar.Q(bitmap, bArr);
            }
            setImageBitmap(bitmap);
        }
    }

    public void setImageLoadCallBack(d.a.r0.b1.i.b.a aVar) {
        d.a.r0.b1.i.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, aVar) == null) || (bVar = this.S) == null) {
            return;
        }
        bVar.R(aVar);
    }

    public void setImageMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onLongClickListener) == null) {
            this.u = onLongClickListener;
            d.a.r0.b1.i.b.b bVar = this.S;
            if (bVar != null) {
                bVar.T(onLongClickListener);
            }
        }
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, imageUrlData) == null) {
            this.T = imageUrlData;
        }
    }

    public void setIsHeadImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.Q = z;
        }
    }

    public void setLoadBigImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.O = z;
        }
    }

    public void setOffset(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048644, this, i2, i3, i4, i5) == null) {
            this.I = i3;
            this.J = i5;
        }
    }

    public void setOnImageScrollListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, jVar) == null) {
            this.y = jVar;
        }
    }

    public void setOnSizeChangedListener(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, kVar) == null) {
            this.s = kVar;
        }
    }

    public void t0() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || (i2 = this.A) == 1 || i2 == 2) {
            return;
        }
        int size = this.j.size();
        if (size > 0) {
            this.j.add(Float.valueOf(this.j.get(size - 1).floatValue() * 1.25f));
        } else {
            this.j.add(Float.valueOf(this.k));
        }
        n0();
    }

    public void u0() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (i2 = this.A) == 1 || i2 == 2) {
            return;
        }
        int size = this.j.size();
        if (size > 1) {
            this.j.remove(size - 1);
        }
        n0();
    }

    /* loaded from: classes4.dex */
    public class f extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f13204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DragImageView f13205f;

        public f(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13205f = dragImageView;
            this.f13204e = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (this.f13204e && this.f13205f.F != null && this.f13205f.n0 > 0 && this.f13205f.l0 > 0 && this.f13205f.m0 > 0) {
                    try {
                        if (this.f13205f.r0 >= this.f13205f.F.getFrameCount()) {
                            this.f13205f.r0 = 0;
                        }
                        this.f13205f.F.c(this.f13205f.r0);
                        g S = this.f13205f.S();
                        if (S.f13206a == null || (S.f13206a.getWidth() != this.f13205f.l0 && S.f13206a.getHeight() != this.f13205f.m0)) {
                            try {
                                S.f13206a = Bitmap.createBitmap(this.f13205f.l0, this.f13205f.m0, Bitmap.Config.ARGB_8888);
                            } catch (OutOfMemoryError unused) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                                try {
                                    S.f13206a = Bitmap.createBitmap(this.f13205f.l0, this.f13205f.m0, Bitmap.Config.ARGB_4444);
                                } catch (OutOfMemoryError unused2) {
                                    TbadkCoreApplication.getInst().onAppMemoryLow();
                                } catch (Throwable th) {
                                    BdLog.e(th.getMessage());
                                }
                            }
                        }
                        this.f13205f.F.a(S.f13206a, null);
                        S.f13207b = this.f13205f.F.b(this.f13205f.r0);
                        DragImageView.E(this.f13205f);
                        if (S.f13206a == null) {
                            DragImageView.E(this.f13205f);
                        }
                        this.f13205f.r0 %= this.f13205f.n0;
                        this.f13205f.p0.put(S);
                        if (this.f13205f.u0) {
                            this.f13205f.v0.sendEmptyMessage(1);
                        }
                    } catch (Exception unused3) {
                        return;
                    }
                }
            }
        }

        public /* synthetic */ f(DragImageView dragImageView, a aVar) {
            this(dragImageView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13187e = new Matrix();
        this.f13188f = 0;
        this.f13189g = 0;
        this.o = false;
        this.p = null;
        this.q = 1300;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.z = 1.0f;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.H = new Paint(-16777216);
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.P = true;
        this.U = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.V = new Matrix();
        this.W = false;
        this.a0 = 1.0f;
        this.b0 = 0.0f;
        this.i0 = new RectF();
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = null;
        this.p0 = new BlockingLinkedDeque<>(5);
        this.q0 = new BlockingLinkedDeque<>(6);
        this.r0 = 0;
        this.t0 = 0L;
        this.u0 = true;
        this.v0 = new Handler(new d(this));
        X();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f13187e = new Matrix();
        this.f13188f = 0;
        this.f13189g = 0;
        this.o = false;
        this.p = null;
        this.q = 1300;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.z = 1.0f;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.H = new Paint(-16777216);
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.P = true;
        this.U = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.V = new Matrix();
        this.W = false;
        this.a0 = 1.0f;
        this.b0 = 0.0f;
        this.i0 = new RectF();
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = null;
        this.p0 = new BlockingLinkedDeque<>(5);
        this.q0 = new BlockingLinkedDeque<>(6);
        this.r0 = 0;
        this.t0 = 0L;
        this.u0 = true;
        this.v0 = new Handler(new d(this));
        X();
    }
}

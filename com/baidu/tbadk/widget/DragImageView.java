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
import c.a.d.d.a;
import c.a.d.f.p.l;
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
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class DragImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_MODE = 0;
    public static final int GIF_DYNAMIC = 1;
    public static final int GIF_STATIC = 0;
    public static final int HEAD_MODE = 1;
    public static final int IMAGE_TYPE_DEFAULT = 2;
    public static final int IMAGE_TYPE_DYNAMIC = 1;
    public static final int IMAGE_TYPE_STATIC = 0;
    public static final int v0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public volatile c.a.d.d.b E;
    public Bitmap F;
    public Paint G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public float Q;
    public c.a.q0.f1.i.b.b R;
    public ImageUrlData S;
    public Interpolator T;
    public Matrix U;
    public boolean V;
    public float W;
    public float a0;
    public Rect b0;
    public RectF c0;
    public Rect d0;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f41955e;
    public h e0;

    /* renamed from: f  reason: collision with root package name */
    public int f41956f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public int f41957g;
    public int g0;

    /* renamed from: h  reason: collision with root package name */
    public float f41958h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public float f41959i;
    public g i0;
    public boolean isThreadStoped;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<Float> f41960j;

    /* renamed from: k  reason: collision with root package name */
    public float f41961k;
    public BlockingLinkedDeque<g> k0;
    public float l;
    public float m;
    public Handler mHandler;
    public int mImageType;
    public float n;
    public boolean o;
    public byte[] p;
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
    public e w;
    public GestureDetector x;
    public j y;
    public float z;

    /* loaded from: classes9.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragImageView f41962e;

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
            this.f41962e = dragImageView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                DragImageView dragImageView = this.f41962e;
                int i2 = dragImageView.mImageType;
                if (i2 == 1 || i2 == 2 || !dragImageView.O) {
                    return false;
                }
                this.f41962e.A = 2;
                if (this.f41962e.m > this.f41962e.f41961k) {
                    DragImageView dragImageView2 = this.f41962e;
                    dragImageView2.m = dragImageView2.f41961k;
                    DragImageView dragImageView3 = this.f41962e;
                    dragImageView3.n = dragImageView3.m;
                    this.f41962e.T();
                } else {
                    DragImageView dragImageView4 = this.f41962e;
                    dragImageView4.m = dragImageView4.f41961k * 2.0f;
                    this.f41962e.U(true, (int) motionEvent.getX(), (int) motionEvent.getY());
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
                if (this.f41962e.mImageType != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    this.f41962e.w.b(f2, f3);
                    DragImageView dragImageView = this.f41962e;
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
                if (this.f41962e.u != null && !this.f41962e.B) {
                    this.f41962e.u.onLongClick(this.f41962e);
                }
                super.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f41962e.B = true;
                if (this.f41962e.r == 0 && this.f41962e.C) {
                    return false;
                }
                int scrollX = this.f41962e.getScrollX();
                int scrollY = this.f41962e.getScrollY();
                if (!this.f41962e.onLeftSide()) {
                    this.f41962e.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (this.f41962e.f41958h >= this.f41962e.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (this.f41962e.r == 0) {
                        int i2 = scrollX >= 0 ? scrollX : 0;
                        scrollX = ((float) (this.f41962e.getWidth() + i2)) > this.f41962e.f41958h ? (int) (this.f41962e.f41958h - this.f41962e.getWidth()) : i2;
                    }
                }
                if (this.f41962e.f41959i + this.f41962e.H + this.f41962e.I >= this.f41962e.getHeight()) {
                    scrollY = (int) (scrollY + f3);
                    if (this.f41962e.r == 0) {
                        if (scrollY < (-this.f41962e.J)) {
                            scrollY = -this.f41962e.J;
                        }
                        if (this.f41962e.getHeight() + scrollY > this.f41962e.f41959i + this.f41962e.I + this.f41962e.K) {
                            scrollY = (int) ((this.f41962e.f41959i - this.f41962e.getHeight()) + this.f41962e.I + this.f41962e.K);
                        }
                    }
                }
                if (scrollX != this.f41962e.getScrollX() || scrollY != this.f41962e.getScrollY()) {
                    this.f41962e.scrollTo(scrollX, scrollY);
                    this.f41962e.invalidate();
                    if (this.f41962e.y != null) {
                        this.f41962e.y.a(this.f41962e, scrollX, scrollY);
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
                if (this.f41962e.t != null && !this.f41962e.B) {
                    this.f41962e.t.onClick(this.f41962e);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f41963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f41964f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float[] f41965g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DragImageView f41966h;

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
            this.f41966h = dragImageView;
            this.f41963e = rect;
            this.f41964f = fArr;
            this.f41965g = fArr2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || valueAnimator == null || this.f41963e == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float[] fArr = this.f41964f;
            DragImageView dragImageView = this.f41966h;
            Rect rect = this.f41963e;
            dragImageView.c0 = dragImageView.P(floatValue, fArr[1] + ((this.f41965g[1] - fArr[1]) * valueAnimator.getAnimatedFraction()), rect.right - rect.left, rect.bottom - rect.top);
            this.f41966h.invalidate();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragImageView f41967e;

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
            this.f41967e = dragImageView;
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
                this.f41967e.V = false;
                this.f41967e.A = 4;
                this.f41967e.invalidate();
                if (this.f41967e.e0 != null) {
                    this.f41967e.e0.b();
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

    /* loaded from: classes9.dex */
    public class d implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DragImageView f41968e;

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
            this.f41968e = dragImageView;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    DragImageView dragImageView = this.f41968e;
                    if (!dragImageView.isThreadStoped) {
                        dragImageView.S();
                    }
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        this.f41968e.invalidate();
                        this.f41968e.t0 = System.currentTimeMillis();
                        this.f41968e.mHandler.sendEmptyMessage(0);
                    }
                } else if (this.f41968e.u0) {
                    this.f41968e.S();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41969e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f41970f;

        /* renamed from: g  reason: collision with root package name */
        public long f41971g;

        /* renamed from: h  reason: collision with root package name */
        public long f41972h;

        /* renamed from: i  reason: collision with root package name */
        public int f41973i;

        /* renamed from: j  reason: collision with root package name */
        public int f41974j;

        /* renamed from: k  reason: collision with root package name */
        public long f41975k;
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
            this.f41969e = false;
            this.f41970f = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41969e : invokeV.booleanValue;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            float f3;
            int i3;
            float f4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                long j2 = this.f41975k;
                long j3 = this.l;
                long j4 = f2 * (j2 > j3 ? (float) j2 : (float) j3);
                long j5 = this.f41975k;
                if (j4 <= j5) {
                    j5 = j4;
                }
                float f5 = ((float) j5) / 1000.0f;
                long j6 = this.f41971g;
                if (j6 > 0) {
                    i2 = this.f41973i;
                    f3 = ((float) j6) - ((f5 * 2500.0f) / 2.0f);
                } else {
                    i2 = this.f41973i;
                    f3 = ((float) j6) + ((f5 * 2500.0f) / 2.0f);
                }
                int i4 = i2 - ((int) (f5 * f3));
                long j7 = this.l;
                if (j4 > j7) {
                    j4 = j7;
                }
                float f6 = ((float) j4) / 1000.0f;
                long j8 = this.f41972h;
                if (j8 > 0) {
                    i3 = this.f41974j;
                    f4 = ((float) j8) - ((2500.0f * f6) / 2.0f);
                } else {
                    i3 = this.f41974j;
                    f4 = ((float) j8) + ((2500.0f * f6) / 2.0f);
                }
                int i5 = i3 - ((int) (f6 * f4));
                int i6 = 0;
                if (this.m.f41959i + this.m.H + this.m.I > this.m.getHeight()) {
                    if (i5 < (-this.m.J)) {
                        i5 = -this.m.J;
                    }
                    if (this.m.getHeight() + i5 > this.m.f41959i + this.m.I + this.m.K) {
                        i5 = (int) ((this.m.f41959i - this.m.getHeight()) + this.m.I + this.m.K);
                    }
                } else {
                    i5 = 0;
                }
                if (this.m.f41958h > this.m.getWidth()) {
                    if (this.m.getWidth() + i4 > this.m.f41958h) {
                        i4 = (int) (this.m.f41958h - this.m.getWidth());
                    }
                    if (i4 >= 0) {
                        i6 = i4;
                    }
                }
                this.m.scrollTo(i6, i5);
                this.m.invalidate();
            }
        }

        public void b(float f2, float f3) {
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
                this.f41971g = f2;
                this.f41972h = f3;
                this.f41975k = Math.abs((f2 * 1000.0f) / 2500.0f);
                long abs = Math.abs((f3 * 1000.0f) / 2500.0f);
                this.l = abs;
                setDuration(Math.max(this.f41975k, abs));
                setInterpolator(this.m.T);
                this.f41973i = this.m.getScrollX();
                this.f41974j = this.m.getScrollY();
                this.f41969e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f41970f = true;
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j2, transformation)) == null) {
                if (!this.f41970f) {
                    if (this.m.o) {
                        this.f41969e = false;
                        return false;
                    }
                    try {
                        if (super.getTransformation(j2, transformation)) {
                            return true;
                        }
                        this.f41969e = false;
                        return false;
                    } catch (Exception unused) {
                        this.f41969e = false;
                        return false;
                    }
                }
                this.f41970f = false;
                this.f41969e = false;
                return false;
            }
            return invokeJL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public int f41978b;

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

    /* loaded from: classes9.dex */
    public interface h {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes9.dex */
    public interface i {
        void a(DragImageView dragImageView);
    }

    /* loaded from: classes9.dex */
    public interface j {
        void a(DragImageView dragImageView, int i2, int i3);
    }

    /* loaded from: classes9.dex */
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
        v0 = l.i(TbadkCoreApplication.getInst()) / 5;
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
        this.f41955e = new Matrix();
        this.f41956f = 0;
        this.f41957g = 0;
        this.o = false;
        this.p = null;
        this.q = 1300;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.z = 1.0f;
        this.mImageType = 0;
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = null;
        this.F = null;
        this.G = new Paint(-16777216);
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.O = true;
        this.T = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.U = new Matrix();
        this.V = false;
        this.W = 1.0f;
        this.a0 = 0.0f;
        this.c0 = new RectF();
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = null;
        this.k0 = new BlockingLinkedDeque<>(5);
        this.q0 = new BlockingLinkedDeque<>(6);
        this.r0 = 0;
        this.isThreadStoped = false;
        this.t0 = 0L;
        this.u0 = true;
        this.mHandler = new Handler(new d(this));
        Q();
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

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int scrollX = getScrollX();
            int i2 = 0;
            if (this.f41958h >= getWidth()) {
                if (scrollX < 0) {
                    scrollX = 0;
                }
                float f2 = this.f41958h;
                if (getWidth() + scrollX > f2) {
                    scrollX = (int) (f2 - getWidth());
                }
            }
            int scrollY = getScrollY();
            if (this.f41959i + this.H + this.I >= getHeight()) {
                int i3 = this.J;
                if (scrollY < (-i3)) {
                    scrollY = -i3;
                }
                i2 = scrollY;
                float f3 = this.f41959i;
                if (getHeight() + i2 > this.I + f3 + this.K) {
                    i2 = (int) ((f3 - getHeight()) + this.I + this.K);
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

    public final void O() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (kVar = this.s) == null) {
            return;
        }
        kVar.a(this, canZoomIn(), canZoomOut());
    }

    public final RectF P(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f4 / 2.0f;
            float f7 = f5 / 2.0f;
            return new RectF(f2 - f6, f3 - f7, f2 + f6, f3 + f7);
        }
        return (RectF) invokeCommon.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.Q = l.h(getContext());
            int i2 = l.i(getContext()) * l.k(getContext()) * 2;
            this.q = i2;
            if (i2 < 1690000) {
                this.q = 1690000;
            }
            this.f41958h = 0.0f;
            this.f41959i = 0.0f;
            this.f41960j = new ArrayList<>();
            this.f41961k = 1.0f;
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

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Bitmap imageBitmap = getImageBitmap();
            if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
                this.f41961k = reInitScaleValue(imageBitmap);
                this.l = getMaxScaleValue(imageBitmap);
                this.f41960j.clear();
                this.f41960j.add(Float.valueOf(this.f41961k));
                float f2 = this.f41961k;
                this.m = f2;
                this.n = f2;
                T();
                return;
            }
            this.f41958h = 0.0f;
            this.f41959i = 0.0f;
            this.f41961k = 1.0f;
            this.l = 1.0f;
            this.m = 1.0f;
            this.n = 1.0f;
            this.f41960j.clear();
        }
    }

    public final void S() {
        g gVar;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g poll = this.k0.poll();
            if (poll == null) {
                this.u0 = true;
                return;
            }
            this.u0 = false;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.i0 != null) {
                j2 = gVar.f41978b - (currentTimeMillis - this.t0);
                this.q0.offer(this.i0);
            } else {
                j2 = 0;
            }
            this.i0 = poll;
            this.mHandler.sendEmptyMessageDelayed(2, j2 > 0 ? j2 : 0L);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            U(false, -1, -1);
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
    public final void U(boolean z, int i2, int i3) {
        Bitmap imageBitmap;
        float f2;
        float width;
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || (imageBitmap = getImageBitmap()) == null || imageBitmap.isRecycled()) {
            return;
        }
        try {
            if (this.A != 2) {
                int size = this.f41960j.size();
                if (size > 0) {
                    f3 = this.f41960j.get(size - 1).floatValue();
                } else {
                    f3 = this.f41961k;
                }
                this.m = f3;
            }
            this.f41955e.setScale(this.m, this.m);
            this.f41958h = imageBitmap.getWidth() * this.m;
            this.f41959i = imageBitmap.getHeight() * this.m;
            float width2 = imageBitmap.getWidth() * this.n;
            float height = imageBitmap.getHeight() * this.n;
            this.J = this.H;
            int i4 = 0;
            this.K = 0;
            float f4 = 0.0f;
            float f5 = this.f41958h < ((float) this.f41956f) ? (int) ((this.f41956f - this.f41958h) / 2.0f) : 0.0f;
            if (this.f41959i < this.f41957g) {
                float f6 = (int) ((this.f41957g - this.f41959i) / 2.0f);
                if (this.r == 1 && f6 > this.H) {
                    f6 = this.H;
                }
                f4 = f6;
                int i5 = (int) (this.H - f4);
                this.J = i5;
                this.K = this.H - i5;
            }
            this.L = (int) f5;
            this.f41955e.postTranslate(f5, f4);
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (z) {
                int screenWidth = getScreenWidth();
                if (i2 > getWidth()) {
                    i2 = getWidth();
                }
                float f7 = screenWidth;
                if (this.f41958h > f7) {
                    if (this.f41958h > f7 && this.f41958h / 2.0f < f7) {
                        f2 = i2;
                        width = this.f41958h / 4.0f;
                        i2 = (int) (f2 - width);
                    }
                    if (i2 > 0) {
                        i2 = (int) (this.f41958h - getWidth());
                    }
                    if (this.A == 2) {
                    }
                    if (this.f41959i <= getHeight()) {
                    }
                    setHorizontalScrollBarEnabled(false);
                    setVerticalScrollBarEnabled(false);
                    if (i2 < 0) {
                    }
                    if (scrollY >= 0) {
                    }
                    scrollTo(i2, i4);
                    setImageMatrix(this.f41955e);
                    O();
                }
                i2 = 0;
                if (i2 > 0 && this.f41958h - i2 < getWidth()) {
                    i2 = (int) (this.f41958h - getWidth());
                }
                if (this.A == 2) {
                    scrollY += (int) ((this.f41959i - height) / 2.0f);
                }
                if (this.f41959i <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.f41959i) {
                    scrollY = (int) (this.f41959i - getHeight());
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
                setImageMatrix(this.f41955e);
                O();
            }
            if (this.A == 2) {
                scrollX += (int) ((this.f41958h - width2) / 2.0f);
            }
            if (this.f41958h > getWidth()) {
                if (getWidth() + scrollX > this.f41958h) {
                    f2 = this.f41958h;
                    width = getWidth();
                    i2 = (int) (f2 - width);
                    if (i2 > 0) {
                    }
                    if (this.A == 2) {
                    }
                    if (this.f41959i <= getHeight()) {
                    }
                    setHorizontalScrollBarEnabled(false);
                    setVerticalScrollBarEnabled(false);
                    if (i2 < 0) {
                    }
                    if (scrollY >= 0) {
                    }
                    scrollTo(i2, i4);
                    setImageMatrix(this.f41955e);
                    O();
                }
                i2 = scrollX;
                if (i2 > 0) {
                }
                if (this.A == 2) {
                }
                if (this.f41959i <= getHeight()) {
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (i2 < 0) {
                }
                if (scrollY >= 0) {
                }
                scrollTo(i2, i4);
                setImageMatrix(this.f41955e);
                O();
            }
            i2 = 0;
            if (i2 > 0) {
            }
            if (this.A == 2) {
            }
            if (this.f41959i <= getHeight()) {
            }
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            if (i2 < 0) {
            }
            if (scrollY >= 0) {
            }
            scrollTo(i2, i4);
            setImageMatrix(this.f41955e);
            O();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ImageUrlData imageUrlData = this.S;
            if (imageUrlData == null) {
                h hVar = this.e0;
                if (hVar != null) {
                    hVar.b();
                    return;
                }
                return;
            }
            Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
            if (sourceImageRectInScreen == null) {
                h hVar2 = this.e0;
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
            RectF rectF = this.c0;
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

    public void actionUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.C = false;
            this.o = false;
            this.A = 3;
            N();
            float f2 = this.m;
            float f3 = this.f41961k;
            if (f2 < f3) {
                this.m = f3;
                T();
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (this.R == null || this.f41961k != this.m) {
                return super.canScrollHorizontally(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean canZoomIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.mImageType;
            if (i2 != 1 && i2 != 2) {
                int size = this.f41960j.size();
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled() && size > 0) {
                    float floatValue = this.f41960j.get(size - 1).floatValue();
                    if (((int) (imageBitmap.getWidth() * imageBitmap.getHeight() * floatValue * floatValue)) * 1.25f * 1.25f <= this.q && floatValue <= 5.0f) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean canZoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.mImageType;
            if (i2 != 1 && i2 != 2) {
                int size = this.f41960j.size();
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled() && size > 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (int) this.f41958h : invokeV.intValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        c.a.q0.f1.i.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.R) == null) {
            return;
        }
        bVar.t();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (int) this.f41959i : invokeV.intValue;
    }

    public g createFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            g poll = this.q0.poll();
            if (poll == null) {
                poll = new g();
                try {
                    poll.a = Bitmap.createBitmap(this.f0, this.g0, Bitmap.Config.ARGB_8888);
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

    public void createLargeImageDelegate() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.R == null) {
            c.a.q0.f1.i.b.b bVar = new c.a.q0.f1.i.b.b(this);
            this.R = bVar;
            bVar.S(this.t);
            this.R.T(this.u);
        }
    }

    public int getBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.K : invokeV.intValue;
    }

    public g getCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.i0 : (g) invokeV.objValue;
    }

    public Bitmap getGifCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.F : (Bitmap) invokeV.objValue;
    }

    public Bitmap getImageBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p : (byte[]) invokeV.objValue;
    }

    public int getImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mImageType : invokeV.intValue;
    }

    public ImageUrlData getImageUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.S : (ImageUrlData) invokeV.objValue;
    }

    public int getLeftOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.L : invokeV.intValue;
    }

    public float getMaxScaleValue(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, bitmap)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
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

    public float getMinScaleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null) {
                return bVar.z();
            }
            return this.f41961k / 4.0f;
        }
        return invokeV.floatValue;
    }

    public float[] getResizedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? new float[]{this.f41958h, this.f41959i} : (float[]) invokeV.objValue;
    }

    public Bitmap getVisableBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            Matrix matrix = new Matrix(this.f41955e);
            matrix.postTranslate(-scrollX, -scrollY);
            canvas.drawBitmap(getImageBitmap(), matrix, null);
            return createBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public boolean hasLoadLongImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (getImageBitmap() == null || this.R == null) ? false : true : invokeV.booleanValue;
    }

    public boolean isAtViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null) {
                return bVar.D();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLoadBigImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.N : invokeV.booleanValue;
    }

    public boolean isViewBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar == null) {
                return false;
            }
            return bVar.G();
        }
        return invokeV.booleanValue;
    }

    public boolean isViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar == null) {
                return false;
            }
            return bVar.H();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onAttachedToWindow();
            play();
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.w.a()) {
                this.w.c();
            }
            super.setImageDrawable(null);
            this.p = null;
            this.F = null;
            stop();
            if (this.E != null) {
                this.E.close();
                this.E = null;
            }
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null) {
                bVar.O();
                System.gc();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDetachedFromWindow();
            onDestroy();
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
        if (interceptable == null || interceptable.invokeL(1048614, this, canvas) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar == null || !bVar.K(canvas, getImageBitmap())) {
                if (this.mImageType == 2 && this.M != 0 && !this.w.a()) {
                    int width = getWidth();
                    int height = getHeight();
                    Drawable drawable = getDrawable();
                    float f6 = height;
                    float f7 = 0.3f * f6;
                    float f8 = width;
                    float f9 = f6 * 0.7f;
                    if (!this.P || drawable == null) {
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
                    this.G.setColor(SkinManager.getColor(this.M));
                    canvas.drawRect(f5, f2, f4, f3, this.G);
                    this.G.setColor(-16777216);
                }
                boolean z = false;
                if (this.A == 3 && this.V) {
                    this.V = false;
                    this.U.reset();
                    if (this.a0 < v0) {
                        this.A = 0;
                    } else {
                        this.A = 4;
                        V();
                    }
                }
                if (this.mImageType == 0 && this.V && this.b0 != null && this.S != null) {
                    canvas.drawColor(Color.argb((int) (this.W * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                    if (this.c0 == null) {
                        this.c0 = new RectF();
                    }
                    this.U.mapRect(this.c0, new RectF(this.b0));
                    Bitmap imageBitmap = getImageBitmap();
                    if (imageBitmap != null && !imageBitmap.isRecycled()) {
                        canvas.drawBitmap(getImageBitmap(), this.d0, this.c0, (Paint) null);
                    }
                } else if (this.A == 4 && this.b0 != null) {
                    canvas.drawColor(Color.argb((int) (this.W * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                    Bitmap imageBitmap2 = getImageBitmap();
                    if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                        canvas.drawBitmap(getImageBitmap(), this.d0, this.c0, (Paint) null);
                    }
                } else {
                    try {
                        super.onDraw(canvas);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                if (this.mImageType != 1 || (bitmap = this.F) == null || bitmap.isRecycled()) {
                    return;
                }
                int width2 = this.F.getWidth();
                int height2 = this.F.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i4 = (width3 - width2) >> 1;
                int i5 = (height3 - height2) >> 1;
                float f14 = this.Q;
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
                    this.f41955e.setScale(f14, f14);
                    float f17 = f15 * f14;
                    i4 = (int) ((f16 - f17) / 2.0f);
                    float f18 = height2 * f14;
                    i5 = (int) ((height3 - f18) / 2.0f);
                    this.f41955e.postTranslate(i4, i5);
                    width2 = (int) f17;
                    height2 = (int) f18;
                }
                canvas.clipRect(i4, i5, width2 + i4, height2 + i5);
                canvas.drawColor(-1);
                if (this.D != 1 || this.E == null || (gVar = this.i0) == null || (bitmap2 = gVar.a) == null) {
                    if (z) {
                        canvas.drawBitmap(this.F, i4, i5, (Paint) null);
                        return;
                    } else {
                        canvas.drawBitmap(this.F, this.f41955e, this.G);
                        return;
                    }
                }
                if (z) {
                    canvas.drawBitmap(bitmap2, i4, i5, (Paint) null);
                } else {
                    canvas.drawBitmap(bitmap2, this.f41955e, this.G);
                }
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (z) {
                this.f41956f = i4 - i2;
                this.f41957g = i5 - i3;
                R();
            }
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    public boolean onLeftSide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            int i2 = this.mImageType;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            return !this.C && getScrollX() <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        c.a.q0.f1.i.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0 || (bVar = this.R) == null) {
                return;
            }
            bVar.V();
        }
    }

    public boolean onRightSide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            int i2 = this.mImageType;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            return !this.C && getScrollX() >= ((int) (this.f41958h - ((float) getWidth()))) - 1;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionEvent)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null && bVar.M(motionEvent)) {
                if (getScrollX() != 0 || getScrollY() != 0) {
                    this.R.I(getScrollX(), getScrollY());
                    scrollTo(0, 0);
                }
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            if (action == 0) {
                this.A = 0;
                this.o = true;
                this.B = false;
                this.C = false;
            } else if (action != 1) {
                if (action == 2 && this.A == 0) {
                    this.A = 1;
                }
            } else {
                actionUp();
            }
            if (action == CompatibleUtile.getInstance().getActionPointerUp()) {
                this.A = 1;
            } else if (action == CompatibleUtile.getInstance().getActionPointerDown()) {
                float spacing = spacing(motionEvent);
                this.z = spacing;
                if (spacing > 10.0f) {
                    this.A = 2;
                }
            }
            if ((this.A == 2 || !this.x.onTouchEvent(motionEvent)) && this.O) {
                if (action == 2 && this.A == 2) {
                    this.B = true;
                    this.C = true;
                    int i2 = this.mImageType;
                    if (i2 != 1 && i2 != 2) {
                        float spacing2 = spacing(motionEvent);
                        if (spacing2 >= 0.0f && Math.abs(this.z - spacing2) >= 10.0f) {
                            if (Math.abs(this.z - spacing2) > 100.0f) {
                                this.z = spacing2;
                            } else {
                                float f2 = spacing2 / this.z;
                                this.z = spacing2;
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
                                T();
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

    public boolean pagerCantScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null) {
                return bVar.F();
            }
            return this.f41961k == this.m;
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && this.mImageType == 1) {
            f fVar = this.s0;
            if (fVar != null) {
                fVar.f41976e = false;
                this.s0.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void play() {
        c.a.d.m.d.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.mImageType == 1) {
            if (this.E == null) {
                f fVar = this.s0;
                if (fVar != null) {
                    fVar.f41976e = false;
                    this.s0.interrupt();
                    this.s0 = null;
                }
                if (this.p == null) {
                    return;
                }
                try {
                    aVar = a.C0078a.b().a(this.p, 0, this.p.length);
                } catch (StackOverflowError unused) {
                    aVar = null;
                }
                if (aVar != null && aVar.l() != null) {
                    this.E = aVar.l();
                    if (this.E != null) {
                        this.D = 1;
                        this.f0 = this.E.getWidth();
                        this.g0 = this.E.getHeight();
                        this.r0 = 0;
                        this.h0 = this.E.getFrameCount();
                    } else {
                        this.D = 0;
                    }
                } else {
                    c.a.q0.s.a0.a.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                    return;
                }
            }
            if (this.E == null) {
                return;
            }
            f fVar2 = this.s0;
            if (fVar2 == null || !fVar2.f41976e) {
                this.u0 = true;
                this.s0 = new f(this, null);
                this.k0.clear();
                this.q0.clear();
                this.s0.f41976e = true;
                this.s0.start();
                this.isThreadStoped = false;
            }
        }
    }

    public float reInitScaleValue(Bitmap bitmap) {
        InterceptResult invokeL;
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, bitmap)) == null) {
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null) {
                return bVar.N();
            }
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                return 1.0f;
            }
            if (this.r == 0) {
                float width = this.f41956f / bitmap.getWidth();
                float height = this.f41957g / bitmap.getHeight();
                if (this.P) {
                    if (this.mImageType == 2) {
                        return 2.5f;
                    }
                    min = Math.min(width, height);
                } else if (this.mImageType == 2) {
                    return 1.0f;
                } else {
                    float f2 = this.Q;
                    float f3 = f2 >= 1.0f ? f2 : 1.0f;
                    if (bitmap.getWidth() * f3 < this.f41956f && bitmap.getHeight() * f3 < this.f41957g) {
                        return f3;
                    }
                    min = Math.min(width, height);
                }
                return min;
            }
            return Math.max(this.f41956f / bitmap.getWidth(), ((this.f41957g - this.H) - this.I) / bitmap.getHeight());
        }
        return invokeL.floatValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.w.a()) {
                this.w.c();
            }
            stop();
            super.setImageDrawable(null);
            this.F = null;
        }
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bitmap) == null) {
            Bitmap imageBitmap = getImageBitmap();
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.f41955e);
                return;
            }
            if (this.w.a()) {
                this.w.c();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.f41955e);
            scrollTo(scrollX, scrollY);
            this.mImageType = 0;
        }
    }

    public void restoreSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            O();
            int i2 = this.mImageType;
            if (i2 == 1 || i2 == 2 || this.m == this.f41961k) {
                return;
            }
            this.f41960j.clear();
            this.f41960j.add(Float.valueOf(this.f41961k));
            float f2 = this.f41961k;
            this.m = f2;
            this.n = f2;
            T();
        }
    }

    public void setCanScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.O = z;
        }
    }

    public void setDefaultBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.w.a()) {
                this.w.c();
            }
            try {
                if (this.P) {
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
            this.mImageType = 2;
            R();
        }
    }

    public void setDragToExitListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, hVar) == null) {
            this.e0 = hVar;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, bArr, bitmap) == null) {
            if (this.w.a()) {
                this.w.c();
            }
            super.setImageDrawable(null);
            stop();
            R();
            this.mImageType = 1;
            this.F = bitmap;
            this.p = bArr;
            i iVar = this.v;
            if (iVar != null) {
                iVar.a(this);
            }
        }
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
        }
    }

    public void setGifSetListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, iVar) == null) {
            this.v = iVar;
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bitmap) == null) {
            if (this.w.a()) {
                this.w.c();
            }
            this.M = 0;
            super.setImageBitmap(bitmap);
            R();
            this.mImageType = 0;
            if (this.b0 == null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / bitmap.getWidth()) * bitmap.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF P = P(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.b0 = new Rect((int) P.left, (int) P.top, (int) P.right, (int) P.bottom);
            }
            if (this.d0 == null) {
                this.d0 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, bitmap, bArr) == null) {
            this.p = bArr;
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null) {
                bVar.Q(bitmap, bArr);
            }
            setImageBitmap(bitmap);
        }
    }

    public void setImageLoadCallBack(c.a.q0.f1.i.b.a aVar) {
        c.a.q0.f1.i.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, aVar) == null) || (bVar = this.R) == null) {
            return;
        }
        bVar.R(aVar);
    }

    public void setImageMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onLongClickListener) == null) {
            this.u = onLongClickListener;
            c.a.q0.f1.i.b.b bVar = this.R;
            if (bVar != null) {
                bVar.T(onLongClickListener);
            }
        }
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, imageUrlData) == null) {
            this.S = imageUrlData;
        }
    }

    public void setIsHeadImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.P = z;
        }
    }

    public void setLoadBigImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.N = z;
        }
    }

    public void setOffset(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048642, this, i2, i3, i4, i5) == null) {
            this.H = i3;
            this.I = i5;
        }
    }

    public void setOnImageScrollListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, jVar) == null) {
            this.y = jVar;
        }
    }

    public void setOnSizeChangedListener(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, kVar) == null) {
            this.s = kVar;
        }
    }

    public float spacing(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, motionEvent)) == null) ? CompatibleUtile.getInstance().getSpacing(motionEvent) : invokeL.floatValue;
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.isThreadStoped = true;
            if (this.mImageType != 1) {
                return;
            }
            f fVar = this.s0;
            if (fVar != null) {
                fVar.f41976e = false;
                this.s0.interrupt();
                this.s0 = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.u0 = true;
            this.i0 = null;
            this.q0.clear();
            this.k0.clear();
            this.f0 = 0;
            this.g0 = 0;
            this.r0 = 0;
            this.h0 = 0;
            this.E = null;
        }
    }

    public void zoomInBitmap() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || (i2 = this.mImageType) == 1 || i2 == 2) {
            return;
        }
        int size = this.f41960j.size();
        if (size > 0) {
            this.f41960j.add(Float.valueOf(this.f41960j.get(size - 1).floatValue() * 1.25f));
        } else {
            this.f41960j.add(Float.valueOf(this.f41961k));
        }
        T();
    }

    public void zoomOutBitmap() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (i2 = this.mImageType) == 1 || i2 == 2) {
            return;
        }
        int size = this.f41960j.size();
        if (size > 1) {
            this.f41960j.remove(size - 1);
        }
        T();
    }

    /* loaded from: classes9.dex */
    public class f extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f41976e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DragImageView f41977f;

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
            this.f41977f = dragImageView;
            this.f41976e = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!isInterrupted() && this.f41976e && this.f41977f.E != null && this.f41977f.h0 > 0 && this.f41977f.f0 > 0 && this.f41977f.g0 > 0) {
                    try {
                        if (this.f41977f.r0 >= this.f41977f.E.getFrameCount()) {
                            this.f41977f.r0 = 0;
                        }
                        this.f41977f.E.c(this.f41977f.r0);
                        g createFrame = this.f41977f.createFrame();
                        if (createFrame.a == null || (createFrame.a.getWidth() != this.f41977f.f0 && createFrame.a.getHeight() != this.f41977f.g0)) {
                            try {
                                createFrame.a = Bitmap.createBitmap(this.f41977f.f0, this.f41977f.g0, Bitmap.Config.ARGB_8888);
                            } catch (OutOfMemoryError unused) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                                try {
                                    createFrame.a = Bitmap.createBitmap(this.f41977f.f0, this.f41977f.g0, Bitmap.Config.ARGB_4444);
                                } catch (OutOfMemoryError unused2) {
                                    TbadkCoreApplication.getInst().onAppMemoryLow();
                                }
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        }
                        this.f41977f.E.a(createFrame.a, null);
                        createFrame.f41978b = this.f41977f.E.b(this.f41977f.r0);
                        DragImageView.E(this.f41977f);
                        if (createFrame.a == null) {
                            DragImageView.E(this.f41977f);
                        }
                        this.f41977f.r0 %= this.f41977f.h0;
                        this.f41977f.k0.put(createFrame);
                        if (this.f41977f.u0) {
                            this.f41977f.mHandler.sendEmptyMessage(1);
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
        this.f41955e = new Matrix();
        this.f41956f = 0;
        this.f41957g = 0;
        this.o = false;
        this.p = null;
        this.q = 1300;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.z = 1.0f;
        this.mImageType = 0;
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = null;
        this.F = null;
        this.G = new Paint(-16777216);
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.O = true;
        this.T = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.U = new Matrix();
        this.V = false;
        this.W = 1.0f;
        this.a0 = 0.0f;
        this.c0 = new RectF();
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = null;
        this.k0 = new BlockingLinkedDeque<>(5);
        this.q0 = new BlockingLinkedDeque<>(6);
        this.r0 = 0;
        this.isThreadStoped = false;
        this.t0 = 0L;
        this.u0 = true;
        this.mHandler = new Handler(new d(this));
        Q();
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
        this.f41955e = new Matrix();
        this.f41956f = 0;
        this.f41957g = 0;
        this.o = false;
        this.p = null;
        this.q = 1300;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.z = 1.0f;
        this.mImageType = 0;
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = null;
        this.F = null;
        this.G = new Paint(-16777216);
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.O = true;
        this.T = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.U = new Matrix();
        this.V = false;
        this.W = 1.0f;
        this.a0 = 0.0f;
        this.c0 = new RectF();
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = null;
        this.k0 = new BlockingLinkedDeque<>(5);
        this.q0 = new BlockingLinkedDeque<>(6);
        this.r0 = 0;
        this.isThreadStoped = false;
        this.t0 = 0L;
        this.u0 = true;
        this.mHandler = new Handler(new d(this));
        Q();
    }
}

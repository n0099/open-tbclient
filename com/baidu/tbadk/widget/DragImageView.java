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
import com.baidu.tieba.ck5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.dc;
import com.baidu.tieba.dk5;
import com.baidu.tieba.ec;
import com.baidu.tieba.fj;
import com.baidu.tieba.jx4;
import com.baidu.tieba.pn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class DragImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final int u0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public volatile ec B;
    public Bitmap C;
    public Paint D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public float N;
    public dk5 O;
    public ImageUrlData P;
    public Interpolator Q;
    public Matrix R;
    public boolean S;
    public float T;
    public float U;
    public Rect V;
    public RectF W;
    public Matrix a;
    public Rect a0;
    public int b;
    public h b0;
    public int c;
    public int c0;
    public float d;
    public int d0;
    public float e;
    public int e0;
    public ArrayList f;
    public g f0;
    public float g;
    public BlockingLinkedDeque g0;
    public float h;
    public BlockingLinkedDeque h0;
    public float i;
    public volatile int i0;
    public float j;
    public f j0;
    public boolean k;
    public byte[] l;
    public int m;
    public int n;
    public k o;
    public View.OnClickListener p;
    public View.OnLongClickListener q;
    public boolean q0;
    public i r;
    public volatile long r0;
    public e s;
    public volatile boolean s0;
    public GestureDetector t;
    public Handler t0;
    public j u;
    public float v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public interface h {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(DragImageView dragImageView);
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(DragImageView dragImageView, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragImageView a;

        public a(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dragImageView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                if (this.a.q != null && !this.a.y) {
                    this.a.q.onLongClick(this.a);
                }
                super.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
                if (this.a.p != null && !this.a.y) {
                    this.a.p.onClick(this.a);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                DragImageView dragImageView = this.a;
                int i = dragImageView.w;
                if (i == 1 || i == 2 || !dragImageView.L) {
                    return false;
                }
                this.a.x = 2;
                if (this.a.i > this.a.g) {
                    DragImageView dragImageView2 = this.a;
                    dragImageView2.i = dragImageView2.g;
                    DragImageView dragImageView3 = this.a;
                    dragImageView3.j = dragImageView3.i;
                    this.a.n0();
                } else {
                    DragImageView dragImageView4 = this.a;
                    dragImageView4.i = dragImageView4.g * 2.0f;
                    this.a.o0(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.a.w != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
                    this.a.s.b(f, f2);
                    DragImageView dragImageView = this.a;
                    dragImageView.startAnimation(dragImageView.s);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) != null) {
                return invokeCommon.booleanValue;
            }
            this.a.y = true;
            int i = 0;
            if (this.a.n == 0 && this.a.z) {
                return false;
            }
            int scrollX = this.a.getScrollX();
            int scrollY = this.a.getScrollY();
            if (!this.a.d0()) {
                this.a.getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (this.a.d >= this.a.getWidth()) {
                scrollX = (int) (scrollX + f);
                if (this.a.n == 0) {
                    if (scrollX >= 0) {
                        i = scrollX;
                    }
                    if (this.a.getWidth() + i > this.a.d) {
                        scrollX = (int) (this.a.d - this.a.getWidth());
                    } else {
                        scrollX = i;
                    }
                }
            }
            if (this.a.e + this.a.E + this.a.F >= this.a.getHeight()) {
                scrollY = (int) (scrollY + f2);
                if (this.a.n == 0) {
                    if (scrollY < (-this.a.G)) {
                        scrollY = -this.a.G;
                    }
                    if (this.a.getHeight() + scrollY > this.a.e + this.a.F + this.a.H) {
                        scrollY = (int) ((this.a.e - this.a.getHeight()) + this.a.F + this.a.H);
                    }
                }
            }
            if (scrollX != this.a.getScrollX() || scrollY != this.a.getScrollY()) {
                this.a.scrollTo(scrollX, scrollY);
                this.a.invalidate();
                if (this.a.u != null) {
                    this.a.u.a(this.a, scrollX, scrollY);
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Rect a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ float[] c;
        public final /* synthetic */ DragImageView d;

        public b(DragImageView dragImageView, Rect rect, float[] fArr, float[] fArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView, rect, fArr, fArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dragImageView;
            this.a = rect;
            this.b = fArr;
            this.c = fArr2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && valueAnimator != null && this.a != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float[] fArr = this.b;
                DragImageView dragImageView = this.d;
                Rect rect = this.a;
                dragImageView.W = dragImageView.V(floatValue, fArr[1] + ((this.c[1] - fArr[1]) * valueAnimator.getAnimatedFraction()), rect.right - rect.left, rect.bottom - rect.top);
                this.d.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragImageView a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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

        public c(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dragImageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.S = false;
            this.a.x = 4;
            this.a.invalidate();
            if (this.a.b0 != null) {
                this.a.b0.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragImageView a;

        public d(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dragImageView;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.a.invalidate();
                            this.a.r0 = System.currentTimeMillis();
                            this.a.t0.sendEmptyMessage(0);
                        }
                    } else if (this.a.s0) {
                        this.a.k0();
                    }
                } else {
                    DragImageView dragImageView = this.a;
                    if (!dragImageView.q0) {
                        dragImageView.k0();
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public long c;
        public long d;
        public int e;
        public int f;
        public long g;
        public long h;
        public final /* synthetic */ DragImageView i;

        public e(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = dragImageView;
            this.a = false;
            this.b = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b = true;
            }
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            float f2;
            int i;
            float f3;
            int i2;
            float f4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                if (f > 1.0f) {
                    f = 1.0f;
                }
                long j = this.g;
                long j2 = this.h;
                if (j > j2) {
                    f2 = (float) j;
                } else {
                    f2 = (float) j2;
                }
                long j3 = f * f2;
                long j4 = this.g;
                if (j3 <= j4) {
                    j4 = j3;
                }
                float f5 = ((float) j4) / 1000.0f;
                long j5 = this.c;
                if (j5 > 0) {
                    i = this.e;
                    f3 = ((float) j5) - ((f5 * 2500.0f) / 2.0f);
                } else {
                    i = this.e;
                    f3 = ((float) j5) + ((f5 * 2500.0f) / 2.0f);
                }
                int i3 = i - ((int) (f5 * f3));
                long j6 = this.h;
                if (j3 > j6) {
                    j3 = j6;
                }
                float f6 = ((float) j3) / 1000.0f;
                long j7 = this.d;
                if (j7 > 0) {
                    i2 = this.f;
                    f4 = ((float) j7) - ((2500.0f * f6) / 2.0f);
                } else {
                    i2 = this.f;
                    f4 = ((float) j7) + ((2500.0f * f6) / 2.0f);
                }
                int i4 = i2 - ((int) (f6 * f4));
                int i5 = 0;
                if (this.i.e + this.i.E + this.i.F > this.i.getHeight()) {
                    if (i4 < (-this.i.G)) {
                        i4 = -this.i.G;
                    }
                    if (this.i.getHeight() + i4 > this.i.e + this.i.F + this.i.H) {
                        i4 = (int) ((this.i.e - this.i.getHeight()) + this.i.F + this.i.H);
                    }
                } else {
                    i4 = 0;
                }
                if (this.i.d > this.i.getWidth()) {
                    if (this.i.getWidth() + i3 > this.i.d) {
                        i3 = (int) (this.i.d - this.i.getWidth());
                    }
                    if (i3 >= 0) {
                        i5 = i3;
                    }
                }
                this.i.scrollTo(i5, i4);
                this.i.invalidate();
            }
        }

        public void b(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                if (f > 1500.0f) {
                    f = 1500.0f;
                } else if (f < -1500.0f) {
                    f = -1500.0f;
                }
                if (f2 > 1500.0f) {
                    f2 = 1500.0f;
                } else if (f2 < -1500.0f) {
                    f2 = -1500.0f;
                }
                this.c = f;
                this.d = f2;
                this.g = Math.abs((f * 1000.0f) / 2500.0f);
                long abs = Math.abs((f2 * 1000.0f) / 2500.0f);
                this.h = abs;
                setDuration(Math.max(this.g, abs));
                setInterpolator(this.i.Q);
                this.e = this.i.getScrollX();
                this.f = this.i.getScrollY();
                this.a = true;
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048580, this, j, transformation)) == null) {
                if (this.b) {
                    this.b = false;
                    this.a = false;
                    return false;
                } else if (this.i.k) {
                    this.a = false;
                    return false;
                } else {
                    try {
                        if (super.getTransformation(j, transformation)) {
                            return true;
                        }
                        this.a = false;
                        return false;
                    } catch (Exception unused) {
                        this.a = false;
                        return false;
                    }
                }
            }
            return invokeJL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public final /* synthetic */ DragImageView b;

        public f(DragImageView dragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dragImageView;
            this.a = false;
        }

        public /* synthetic */ f(DragImageView dragImageView, a aVar) {
            this(dragImageView);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!isInterrupted() && this.a && this.b.B != null && this.b.e0 > 0 && this.b.c0 > 0 && this.b.d0 > 0) {
                    try {
                        if (this.b.i0 >= this.b.B.getFrameCount()) {
                            this.b.i0 = 0;
                        }
                        this.b.B.c(this.b.i0);
                        g S = this.b.S();
                        if (S.a == null || (S.a.getWidth() != this.b.c0 && S.a.getHeight() != this.b.d0)) {
                            try {
                                S.a = Bitmap.createBitmap(this.b.c0, this.b.d0, Bitmap.Config.ARGB_8888);
                            } catch (OutOfMemoryError unused) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                                try {
                                    S.a = Bitmap.createBitmap(this.b.c0, this.b.d0, Bitmap.Config.ARGB_4444);
                                } catch (OutOfMemoryError unused2) {
                                    TbadkCoreApplication.getInst().onAppMemoryLow();
                                }
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        }
                        this.b.B.a(S.a, null);
                        S.b = this.b.B.b(this.b.i0);
                        DragImageView.E(this.b);
                        if (S.a == null) {
                            DragImageView.E(this.b);
                        }
                        this.b.i0 %= this.b.e0;
                        this.b.g0.put(S);
                        if (this.b.s0) {
                            this.b.t0.sendEmptyMessage(1);
                        }
                    } catch (Exception unused3) {
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap a;
        public int b;

        public g() {
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
        u0 = fj.i(TbadkCoreApplication.getInst()) / 5;
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
            this.z = false;
            this.k = false;
            this.x = 3;
            O();
            float f2 = this.i;
            float f3 = this.g;
            if (f2 < f3) {
                this.i = f3;
                n0();
            }
            invalidate();
        }
    }

    public final void P() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (kVar = this.o) != null) {
            kVar.a(this, Q(), R());
        }
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.w;
            if (i2 != 1 && i2 != 2) {
                int size = this.f.size();
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled() && size > 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.O == null) {
            dk5 dk5Var = new dk5(this);
            this.O = dk5Var;
            dk5Var.S(this.p);
            this.O.T(this.q);
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (getImageBitmap() != null && this.O != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                return dk5Var.D();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var == null) {
                return false;
            }
            return dk5Var.G();
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var == null) {
                return false;
            }
            return dk5Var.H();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return (int) this.d;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        dk5 dk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (dk5Var = this.O) != null) {
            dk5Var.t();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return (int) this.e;
        }
        return invokeV.intValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int i2 = this.w;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            if (!this.z && getScrollX() <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                return dk5Var.F();
            }
            if (this.g == this.i) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public g getCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f0;
        }
        return (g) invokeV.objValue;
    }

    public Bitmap getGifCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.C;
        }
        return (Bitmap) invokeV.objValue;
    }

    public Bitmap getImageBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Drawable drawable = getDrawable();
            if (drawable != null && (drawable instanceof BitmapDrawable)) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public byte[] getImageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.l;
        }
        return (byte[]) invokeV.objValue;
    }

    public int getImageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public ImageUrlData getImageUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.P;
        }
        return (ImageUrlData) invokeV.objValue;
    }

    public int getLeftOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.I;
        }
        return invokeV.intValue;
    }

    public float getMinScaleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                return dk5Var.z();
            }
            return this.g / 4.0f;
        }
        return invokeV.floatValue;
    }

    public float[] getResizedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new float[]{this.d, this.e} : (float[]) invokeV.objValue;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.s.a()) {
                this.s.c();
            }
            s0();
            super.setImageDrawable(null);
            this.C = null;
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            o0(false, -1, -1);
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

    public void u0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && (i2 = this.w) != 1 && i2 != 2) {
            int size = this.f.size();
            if (size > 1) {
                this.f.remove(size - 1);
            }
            n0();
        }
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
        this.a = new Matrix();
        this.b = 0;
        this.c = 0;
        this.k = false;
        this.l = null;
        this.m = 1300;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.v = 1.0f;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.D = new Paint(-16777216);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.L = true;
        this.Q = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.R = new Matrix();
        this.S = false;
        this.T = 1.0f;
        this.U = 0.0f;
        this.W = new RectF();
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = null;
        this.g0 = new BlockingLinkedDeque(5);
        this.h0 = new BlockingLinkedDeque(6);
        this.i0 = 0;
        this.q0 = false;
        this.r0 = 0L;
        this.s0 = true;
        this.t0 = new Handler(new d(this));
        X();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, motionEvent)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var != null && dk5Var.M(motionEvent)) {
                if (getScrollX() != 0 || getScrollY() != 0) {
                    this.O.I(getScrollX(), getScrollY());
                    scrollTo(0, 0);
                }
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && this.x == 0) {
                        this.x = 1;
                    }
                } else {
                    N();
                }
            } else {
                this.x = 0;
                this.k = true;
                this.y = false;
                this.z = false;
            }
            if (action == CompatibleUtile.getInstance().getActionPointerUp()) {
                this.x = 1;
            } else if (action == CompatibleUtile.getInstance().getActionPointerDown()) {
                float q0 = q0(motionEvent);
                this.v = q0;
                if (q0 > 10.0f) {
                    this.x = 2;
                }
            }
            if ((this.x != 2 && this.t.onTouchEvent(motionEvent)) || !this.L) {
                return true;
            }
            if (action == 2 && this.x == 2) {
                this.y = true;
                this.z = true;
                int i2 = this.w;
                if (i2 != 1 && i2 != 2) {
                    float q02 = q0(motionEvent);
                    if (q02 >= 0.0f && Math.abs(this.v - q02) >= 10.0f) {
                        if (Math.abs(this.v - q02) > 100.0f) {
                            this.v = q02;
                        } else {
                            float f2 = q02 / this.v;
                            this.v = q02;
                            float f3 = this.i;
                            this.j = f3;
                            float f4 = f3 * f2;
                            this.i = f4;
                            float f5 = this.h;
                            if (f4 > f5) {
                                this.i = f5;
                            }
                            float minScaleValue = getMinScaleValue();
                            if (this.i < minScaleValue) {
                                this.i = minScaleValue;
                            }
                            n0();
                        }
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
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
        this.a = new Matrix();
        this.b = 0;
        this.c = 0;
        this.k = false;
        this.l = null;
        this.m = 1300;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.v = 1.0f;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.D = new Paint(-16777216);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.L = true;
        this.Q = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.R = new Matrix();
        this.S = false;
        this.T = 1.0f;
        this.U = 0.0f;
        this.W = new RectF();
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = null;
        this.g0 = new BlockingLinkedDeque(5);
        this.h0 = new BlockingLinkedDeque(6);
        this.i0 = 0;
        this.q0 = false;
        this.r0 = 0L;
        this.s0 = true;
        this.t0 = new Handler(new d(this));
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
        this.a = new Matrix();
        this.b = 0;
        this.c = 0;
        this.k = false;
        this.l = null;
        this.m = 1300;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.v = 1.0f;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.D = new Paint(-16777216);
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.L = true;
        this.Q = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.R = new Matrix();
        this.S = false;
        this.T = 1.0f;
        this.U = 0.0f;
        this.W = new RectF();
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = null;
        this.g0 = new BlockingLinkedDeque(5);
        this.h0 = new BlockingLinkedDeque(6);
        this.i0 = 0;
        this.q0 = false;
        this.r0 = 0L;
        this.s0 = true;
        this.t0 = new Handler(new d(this));
        X();
    }

    public static /* synthetic */ int E(DragImageView dragImageView) {
        int i2 = dragImageView.i0;
        dragImageView.i0 = i2 + 1;
        return i2;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (this.O != null && this.g == this.i) {
                return false;
            }
            return super.canScrollHorizontally(i2);
        }
        return invokeI.booleanValue;
    }

    public float q0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, motionEvent)) == null) {
            return CompatibleUtile.getInstance().getSpacing(motionEvent);
        }
        return invokeL.floatValue;
    }

    public void setCanScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.L = z;
        }
    }

    public void setDragToExitListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, hVar) == null) {
            this.b0 = hVar;
        }
    }

    public void setGifSetListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, iVar) == null) {
            this.r = iVar;
        }
    }

    public void setImageLoadCallBack(ck5 ck5Var) {
        dk5 dk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, ck5Var) == null) && (dk5Var = this.O) != null) {
            dk5Var.R(ck5Var);
        }
    }

    public void setImageMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                dk5Var.T(onLongClickListener);
            }
        }
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, imageUrlData) == null) {
            this.P = imageUrlData;
        }
    }

    public void setIsHeadImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.M = z;
        }
    }

    public void setLoadBigImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.K = z;
        }
    }

    public void setOnImageScrollListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, jVar) == null) {
            this.u = jVar;
        }
    }

    public void setOnSizeChangedListener(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, kVar) == null) {
            this.o = kVar;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        dk5 dk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && (dk5Var = this.O) != null) {
                dk5Var.V();
            }
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, bitmap, bArr) == null) {
            this.l = bArr;
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                dk5Var.Q(bitmap, bArr);
            }
            setImageBitmap(bitmap);
        }
    }

    public void setOffset(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048644, this, i2, i3, i4, i5) == null) {
            this.E = i3;
            this.F = i5;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int scrollX = getScrollX();
            int i2 = 0;
            if (this.d >= getWidth()) {
                if (scrollX < 0) {
                    scrollX = 0;
                }
                float f2 = this.d;
                if (getWidth() + scrollX > f2) {
                    scrollX = (int) (f2 - getWidth());
                }
            }
            int scrollY = getScrollY();
            if (this.e + this.E + this.F >= getHeight()) {
                int i3 = this.G;
                if (scrollY < (-i3)) {
                    scrollY = -i3;
                }
                i2 = scrollY;
                float f3 = this.e;
                if (getHeight() + i2 > this.F + f3 + this.H) {
                    i2 = (int) ((f3 - getHeight()) + this.F + this.H);
                }
            }
            if (scrollX != getScrollX() || i2 != getScrollY()) {
                scrollTo(scrollX, i2);
                invalidate();
                j jVar = this.u;
                if (jVar != null) {
                    jVar.a(this, scrollX, i2);
                }
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.N = fj.h(getContext());
            int i2 = fj.i(getContext()) * fj.k(getContext()) * 2;
            this.m = i2;
            if (i2 < 1690000) {
                this.m = 1690000;
            }
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = new ArrayList();
            this.g = 1.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            setClickable(true);
            setScaleType(ImageView.ScaleType.MATRIX);
            this.s = new e(this);
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            setWillNotDraw(false);
            scrollTo(0, 0);
            this.t = new GestureDetector(getContext(), new a(this));
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            ImageUrlData imageUrlData = this.P;
            if (imageUrlData == null) {
                h hVar = this.b0;
                if (hVar != null) {
                    hVar.b();
                    return;
                }
                return;
            }
            Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
            if (sourceImageRectInScreen == null) {
                h hVar2 = this.b0;
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
            RectF rectF = this.W;
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

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.w;
            if (i2 != 1 && i2 != 2) {
                int size = this.f.size();
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled() && size > 0) {
                    float floatValue = ((Float) this.f.get(size - 1)).floatValue();
                    if (((int) (imageBitmap.getWidth() * imageBitmap.getHeight() * floatValue * floatValue)) * 1.25f * 1.25f <= this.m && floatValue <= 5.0f) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            Bitmap imageBitmap = getImageBitmap();
            if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
                this.g = j0(imageBitmap);
                this.h = U(imageBitmap);
                this.f.clear();
                this.f.add(Float.valueOf(this.g));
                float f2 = this.g;
                this.i = f2;
                this.j = f2;
                n0();
                return;
            }
            this.d = 0.0f;
            this.e = 0.0f;
            this.g = 1.0f;
            this.h = 1.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.f.clear();
        }
    }

    public final void k0() {
        g gVar;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            g gVar2 = (g) this.g0.poll();
            if (gVar2 == null) {
                this.s0 = true;
                return;
            }
            this.s0 = false;
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = 0;
            if (this.f0 != null) {
                j2 = gVar.b - (currentTimeMillis - this.r0);
                this.h0.offer(this.f0);
            } else {
                j2 = 0;
            }
            this.f0 = gVar2;
            if (j2 > 0) {
                j3 = j2;
            }
            this.t0.sendEmptyMessageDelayed(2, j3);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.q0 = true;
            if (this.w != 1) {
                return;
            }
            f fVar = this.j0;
            if (fVar != null) {
                fVar.a = false;
                this.j0.interrupt();
                this.j0 = null;
            }
            this.t0.removeMessages(0);
            this.t0.removeMessages(1);
            this.t0.removeMessages(2);
            this.s0 = true;
            this.f0 = null;
            this.h0.clear();
            this.g0.clear();
            this.c0 = 0;
            this.d0 = 0;
            this.i0 = 0;
            this.e0 = 0;
            this.B = null;
        }
    }

    public void setDefaultBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.s.a()) {
                this.s.c();
            }
            try {
                if (this.M) {
                    super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.icon_default_avatar100));
                } else {
                    super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.obfuscated_res_0x7f0803fa));
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                super.setImageBitmap(null);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            this.w = 2;
            i0();
        }
    }

    public void t0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (i2 = this.w) != 1 && i2 != 2) {
            int size = this.f.size();
            if (size > 0) {
                this.f.add(Float.valueOf(((Float) this.f.get(size - 1)).floatValue() * 1.25f));
            } else {
                this.f.add(Float.valueOf(this.g));
            }
            n0();
        }
    }

    public g S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            g gVar = (g) this.h0.poll();
            if (gVar == null) {
                gVar = new g();
                try {
                    gVar.a = Bitmap.createBitmap(this.c0, this.d0, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                }
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.s.a()) {
                this.s.c();
            }
            super.setImageDrawable(null);
            this.l = null;
            this.C = null;
            s0();
            if (this.B != null) {
                this.B.close();
                this.B = null;
            }
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                dk5Var.O();
                System.gc();
            }
        }
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i2 = this.w;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            if (!this.z && getScrollX() >= ((int) (this.d - getWidth())) - 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || this.w != 1) {
            return;
        }
        f fVar = this.j0;
        if (fVar != null) {
            fVar.a = false;
            this.j0.interrupt();
        }
        this.t0.removeMessages(0);
        this.t0.removeMessages(1);
        this.t0.removeMessages(2);
    }

    public Bitmap getVisableBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            Matrix matrix = new Matrix(this.a);
            matrix.postTranslate(-scrollX, -scrollY);
            canvas.drawBitmap(getImageBitmap(), matrix, null);
            return createBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            P();
            int i2 = this.w;
            if (i2 != 1 && i2 != 2 && this.i != this.g) {
                this.f.clear();
                this.f.add(Float.valueOf(this.g));
                float f2 = this.g;
                this.i = f2;
                this.j = f2;
                n0();
            }
        }
    }

    public float U(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bitmap)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                return dk5Var.y();
            }
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                return 1.0f;
            }
            float sqrt = (float) Math.sqrt(this.m / (bitmap.getWidth() * bitmap.getHeight()));
            if (sqrt > 10.0f) {
                return 10.0f;
            }
            return sqrt;
        }
        return invokeL.floatValue;
    }

    public void m0(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, bitmap) == null) {
            Bitmap imageBitmap = getImageBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                    setImageBitmap(bitmap);
                    super.setImageMatrix(this.a);
                    return;
                }
                if (this.s.a()) {
                    this.s.c();
                }
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                super.setImageBitmap(bitmap);
                super.setImageMatrix(this.a);
                scrollTo(scrollX, scrollY);
                this.w = 0;
            }
        }
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

    public void h0() {
        pn pnVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || this.w != 1) {
            return;
        }
        if (this.B == null) {
            f fVar = this.j0;
            if (fVar != null) {
                fVar.a = false;
                this.j0.interrupt();
                this.j0 = null;
            }
            if (this.l == null) {
                return;
            }
            try {
                pnVar = dc.a.b().a(this.l, 0, this.l.length);
            } catch (StackOverflowError unused) {
                pnVar = null;
            }
            if (pnVar != null && pnVar.l() != null) {
                this.B = pnVar.l();
                if (this.B != null) {
                    this.A = 1;
                    this.c0 = this.B.getWidth();
                    this.d0 = this.B.getHeight();
                    this.i0 = 0;
                    this.e0 = this.B.getFrameCount();
                } else {
                    this.A = 0;
                }
            } else {
                jx4.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                return;
            }
        }
        if (this.B == null) {
            return;
        }
        f fVar2 = this.j0;
        if (fVar2 == null || !fVar2.a) {
            this.s0 = true;
            this.j0 = new f(this, null);
            this.g0.clear();
            this.h0.clear();
            this.j0.a = true;
            this.j0.start();
            this.q0 = false;
        }
    }

    public float j0(Bitmap bitmap) {
        InterceptResult invokeL;
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, bitmap)) == null) {
            dk5 dk5Var = this.O;
            if (dk5Var != null) {
                return dk5Var.N();
            }
            float f2 = 1.0f;
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                return 1.0f;
            }
            if (this.n == 0) {
                float width = this.b / bitmap.getWidth();
                float height = this.c / bitmap.getHeight();
                if (this.M) {
                    if (this.w == 2) {
                        return 2.5f;
                    }
                    min = Math.min(width, height);
                } else if (this.w == 2) {
                    return 1.0f;
                } else {
                    float f3 = this.N;
                    if (f3 >= 1.0f) {
                        f2 = f3;
                    }
                    if (bitmap.getWidth() * f2 >= this.b || bitmap.getHeight() * f2 >= this.c) {
                        min = Math.min(width, height);
                    } else {
                        return f2;
                    }
                }
                return min;
            }
            return Math.max(this.b / bitmap.getWidth(), ((this.c - this.E) - this.F) / bitmap.getHeight());
        }
        return invokeL.floatValue;
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
        float f3;
        float width;
        float f4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && (imageBitmap = getImageBitmap()) != null && !imageBitmap.isRecycled()) {
            try {
                if (this.x != 2) {
                    int size = this.f.size();
                    if (size > 0) {
                        f4 = ((Float) this.f.get(size - 1)).floatValue();
                    } else {
                        f4 = this.g;
                    }
                    this.i = f4;
                }
                this.a.setScale(this.i, this.i);
                this.d = imageBitmap.getWidth() * this.i;
                this.e = imageBitmap.getHeight() * this.i;
                float width2 = imageBitmap.getWidth() * this.j;
                float height = imageBitmap.getHeight() * this.j;
                this.G = this.E;
                int i4 = 0;
                this.H = 0;
                float f5 = 0.0f;
                if (this.d < this.b) {
                    f2 = (int) ((this.b - this.d) / 2.0f);
                } else {
                    f2 = 0.0f;
                }
                if (this.e < this.c) {
                    float f6 = (int) ((this.c - this.e) / 2.0f);
                    if (this.n == 1 && f6 > this.E) {
                        f6 = this.E;
                    }
                    f5 = f6;
                    int i5 = (int) (this.E - f5);
                    this.G = i5;
                    this.H = this.E - i5;
                }
                this.I = (int) f2;
                this.a.postTranslate(f2, f5);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    if (i2 > getWidth()) {
                        i2 = getWidth();
                    }
                    float f7 = screenWidth;
                    if (this.d > f7) {
                        if (this.d > f7 && this.d / 2.0f < f7) {
                            f3 = i2;
                            width = this.d / 4.0f;
                            i2 = (int) (f3 - width);
                        }
                        if (i2 > 0) {
                            i2 = (int) (this.d - getWidth());
                        }
                        if (this.x == 2) {
                        }
                        if (this.e > getHeight()) {
                        }
                        setHorizontalScrollBarEnabled(false);
                        setVerticalScrollBarEnabled(false);
                        if (i2 < 0) {
                        }
                        if (scrollY >= 0) {
                        }
                        scrollTo(i2, i4);
                        setImageMatrix(this.a);
                        P();
                    }
                    i2 = 0;
                    if (i2 > 0 && this.d - i2 < getWidth()) {
                        i2 = (int) (this.d - getWidth());
                    }
                    if (this.x == 2) {
                        scrollY += (int) ((this.e - height) / 2.0f);
                    }
                    if (this.e > getHeight()) {
                        if (getHeight() + scrollY > this.e) {
                            scrollY = (int) (this.e - getHeight());
                        }
                    } else {
                        scrollY = 0;
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
                    setImageMatrix(this.a);
                    P();
                }
                if (this.x == 2) {
                    scrollX += (int) ((this.d - width2) / 2.0f);
                }
                if (this.d > getWidth()) {
                    if (getWidth() + scrollX > this.d) {
                        f3 = this.d;
                        width = getWidth();
                        i2 = (int) (f3 - width);
                        if (i2 > 0) {
                        }
                        if (this.x == 2) {
                        }
                        if (this.e > getHeight()) {
                        }
                        setHorizontalScrollBarEnabled(false);
                        setVerticalScrollBarEnabled(false);
                        if (i2 < 0) {
                        }
                        if (scrollY >= 0) {
                        }
                        scrollTo(i2, i4);
                        setImageMatrix(this.a);
                        P();
                    }
                    i2 = scrollX;
                    if (i2 > 0) {
                    }
                    if (this.x == 2) {
                    }
                    if (this.e > getHeight()) {
                    }
                    setHorizontalScrollBarEnabled(false);
                    setVerticalScrollBarEnabled(false);
                    if (i2 < 0) {
                    }
                    if (scrollY >= 0) {
                    }
                    scrollTo(i2, i4);
                    setImageMatrix(this.a);
                    P();
                }
                i2 = 0;
                if (i2 > 0) {
                }
                if (this.x == 2) {
                }
                if (this.e > getHeight()) {
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (i2 < 0) {
                }
                if (scrollY >= 0) {
                }
                scrollTo(i2, i4);
                setImageMatrix(this.a);
                P();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
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
            dk5 dk5Var = this.O;
            if (dk5Var != null && dk5Var.K(canvas, getImageBitmap())) {
                return;
            }
            if (this.w == 2 && this.J != 0 && !this.s.a()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f6 = height;
                float f7 = 0.3f * f6;
                float f8 = width;
                float f9 = f6 * 0.7f;
                if (this.M && drawable != null) {
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
                } else {
                    f2 = f7;
                    f3 = f9;
                    f4 = f8;
                    f5 = 0.0f;
                }
                this.D.setColor(SkinManager.getColor(this.J));
                canvas.drawRect(f5, f2, f4, f3, this.D);
                this.D.setColor(-16777216);
            }
            boolean z = false;
            if (this.x == 3 && this.S) {
                this.S = false;
                this.R.reset();
                if (this.U < u0) {
                    this.x = 0;
                } else {
                    this.x = 4;
                    r0();
                }
            }
            if (this.w == 0 && this.S && this.V != null && this.P != null) {
                canvas.drawColor(Color.argb((int) (this.T * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.W == null) {
                    this.W = new RectF();
                }
                this.R.mapRect(this.W, new RectF(this.V));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.a0, this.W, (Paint) null);
                }
            } else if (this.x == 4 && this.V != null) {
                canvas.drawColor(Color.argb((int) (this.T * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.a0, this.W, (Paint) null);
                }
            } else {
                try {
                    super.onDraw(canvas);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (this.w == 1 && (bitmap = this.C) != null && !bitmap.isRecycled()) {
                int width2 = this.C.getWidth();
                int height2 = this.C.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i4 = (width3 - width2) >> 1;
                int i5 = (height3 - height2) >> 1;
                float f14 = this.N;
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
                    this.a.setScale(f14, f14);
                    float f17 = f15 * f14;
                    i4 = (int) ((f16 - f17) / 2.0f);
                    float f18 = height2 * f14;
                    i5 = (int) ((height3 - f18) / 2.0f);
                    this.a.postTranslate(i4, i5);
                    width2 = (int) f17;
                    height2 = (int) f18;
                }
                canvas.clipRect(i4, i5, width2 + i4, height2 + i5);
                canvas.drawColor(-1);
                if (this.A == 1 && this.B != null && (gVar = this.f0) != null && (bitmap2 = gVar.a) != null) {
                    if (z) {
                        canvas.drawBitmap(bitmap2, i4, i5, (Paint) null);
                    } else {
                        canvas.drawBitmap(bitmap2, this.a, this.D);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.C, i4, i5, (Paint) null);
                } else {
                    canvas.drawBitmap(this.C, this.a, this.D);
                }
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (z) {
                this.b = i4 - i2;
                this.c = i5 - i3;
                i0();
            }
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, bArr, bitmap) == null) {
            if (this.s.a()) {
                this.s.c();
            }
            super.setImageDrawable(null);
            s0();
            i0();
            this.w = 1;
            this.C = bitmap;
            this.l = bArr;
            i iVar = this.r;
            if (iVar != null) {
                iVar.a(this);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bitmap) == null) {
            if (this.s.a()) {
                this.s.c();
            }
            this.J = 0;
            super.setImageBitmap(bitmap);
            i0();
            this.w = 0;
            if (this.V == null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / bitmap.getWidth()) * bitmap.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF V = V(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.V = new Rect((int) V.left, (int) V.top, (int) V.right, (int) V.bottom);
            }
            if (this.a0 == null) {
                this.a0 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
        }
    }
}

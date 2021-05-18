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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.resourceLoaderProc.ImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import d.a.c.d.a;
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class DragImageView extends ImageView {
    public static final int r0 = l.i(TbadkCoreApplication.getInst()) / 5;
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
    public d.a.j0.b1.i.b.b S;
    public ImageUrlData T;
    public Interpolator U;
    public Matrix V;
    public boolean W;
    public float a0;
    public float b0;
    public Rect c0;
    public RectF d0;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f13048e;
    public Rect e0;

    /* renamed from: f  reason: collision with root package name */
    public int f13049f;
    public h f0;

    /* renamed from: g  reason: collision with root package name */
    public int f13050g;
    public int g0;

    /* renamed from: h  reason: collision with root package name */
    public float f13051h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public float f13052i;
    public int i0;
    public ArrayList<Float> j;
    public g j0;
    public float k;
    public BlockingLinkedDeque<g> k0;
    public float l;
    public BlockingLinkedDeque<g> l0;
    public float m;
    public volatile int m0;
    public float n;
    public f n0;
    public boolean o;
    public volatile long o0;
    public byte[] p;
    public volatile boolean p0;
    public int q;
    public Handler q0;
    public int r;
    public k s;
    public View.OnClickListener t;
    public View.OnLongClickListener u;
    public i v;
    public e w;
    public GestureDetector x;
    public j y;
    public float z;

    /* loaded from: classes3.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            DragImageView dragImageView = DragImageView.this;
            int i2 = dragImageView.A;
            if (i2 == 1 || i2 == 2 || !dragImageView.P) {
                return false;
            }
            DragImageView.this.B = 2;
            if (DragImageView.this.m > DragImageView.this.k) {
                DragImageView dragImageView2 = DragImageView.this;
                dragImageView2.m = dragImageView2.k;
                DragImageView dragImageView3 = DragImageView.this;
                dragImageView3.n = dragImageView3.m;
                DragImageView.this.n0();
            } else {
                DragImageView dragImageView4 = DragImageView.this;
                dragImageView4.m = dragImageView4.k * 2.0f;
                DragImageView.this.o0(true, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (DragImageView.this.A != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                DragImageView.this.w.c(f2, f3);
                DragImageView dragImageView = DragImageView.this;
                dragImageView.startAnimation(dragImageView.w);
            }
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (DragImageView.this.u != null && !DragImageView.this.C) {
                DragImageView.this.u.onLongClick(DragImageView.this);
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            DragImageView.this.C = true;
            if (DragImageView.this.r == 0 && DragImageView.this.D) {
                return false;
            }
            int scrollX = DragImageView.this.getScrollX();
            int scrollY = DragImageView.this.getScrollY();
            if (!DragImageView.this.d0()) {
                DragImageView.this.getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (DragImageView.this.f13051h >= DragImageView.this.getWidth()) {
                scrollX = (int) (scrollX + f2);
                if (DragImageView.this.r == 0) {
                    int i2 = scrollX >= 0 ? scrollX : 0;
                    scrollX = ((float) (DragImageView.this.getWidth() + i2)) > DragImageView.this.f13051h ? (int) (DragImageView.this.f13051h - DragImageView.this.getWidth()) : i2;
                }
            }
            if (DragImageView.this.f13052i + DragImageView.this.I + DragImageView.this.J >= DragImageView.this.getHeight()) {
                scrollY = (int) (scrollY + f3);
                if (DragImageView.this.r == 0) {
                    if (scrollY < (-DragImageView.this.K)) {
                        scrollY = -DragImageView.this.K;
                    }
                    if (DragImageView.this.getHeight() + scrollY > DragImageView.this.f13052i + DragImageView.this.J + DragImageView.this.L) {
                        scrollY = (int) ((DragImageView.this.f13052i - DragImageView.this.getHeight()) + DragImageView.this.J + DragImageView.this.L);
                    }
                }
            }
            if (scrollX != DragImageView.this.getScrollX() || scrollY != DragImageView.this.getScrollY()) {
                DragImageView.this.scrollTo(scrollX, scrollY);
                DragImageView.this.invalidate();
                if (DragImageView.this.y != null) {
                    DragImageView.this.y.a(DragImageView.this, scrollX, scrollY);
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (DragImageView.this.t != null && !DragImageView.this.C) {
                DragImageView.this.t.onClick(DragImageView.this);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f13054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f13055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float[] f13056g;

        public b(Rect rect, float[] fArr, float[] fArr2) {
            this.f13054e = rect;
            this.f13055f = fArr;
            this.f13056g = fArr2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || this.f13054e == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float[] fArr = this.f13055f;
            DragImageView dragImageView = DragImageView.this;
            Rect rect = this.f13054e;
            dragImageView.d0 = dragImageView.V(floatValue, fArr[1] + ((this.f13056g[1] - fArr[1]) * valueAnimator.getAnimatedFraction()), rect.right - rect.left, rect.bottom - rect.top);
            DragImageView.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DragImageView.this.W = false;
            DragImageView.this.B = 4;
            DragImageView.this.invalidate();
            if (DragImageView.this.f0 != null) {
                DragImageView.this.f0.b();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Handler.Callback {
        public d() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                DragImageView.this.k0();
            } else if (i2 != 1) {
                if (i2 == 2) {
                    DragImageView.this.invalidate();
                    DragImageView.this.o0 = System.currentTimeMillis();
                    DragImageView.this.q0.sendEmptyMessage(0);
                }
            } else if (DragImageView.this.p0) {
                DragImageView.this.k0();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public boolean f13060e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f13061f = false;

        /* renamed from: g  reason: collision with root package name */
        public long f13062g;

        /* renamed from: h  reason: collision with root package name */
        public long f13063h;

        /* renamed from: i  reason: collision with root package name */
        public int f13064i;
        public int j;
        public long k;
        public long l;

        public e() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            float f3;
            int i3;
            float f4;
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
            long j5 = this.f13062g;
            if (j5 > 0) {
                i2 = this.f13064i;
                f3 = ((float) j5) - ((f5 * 2500.0f) / 2.0f);
            } else {
                i2 = this.f13064i;
                f3 = ((float) j5) + ((f5 * 2500.0f) / 2.0f);
            }
            int i4 = i2 - ((int) (f5 * f3));
            long j6 = this.l;
            if (j3 > j6) {
                j3 = j6;
            }
            float f6 = ((float) j3) / 1000.0f;
            long j7 = this.f13063h;
            if (j7 > 0) {
                i3 = this.j;
                f4 = ((float) j7) - ((2500.0f * f6) / 2.0f);
            } else {
                i3 = this.j;
                f4 = ((float) j7) + ((2500.0f * f6) / 2.0f);
            }
            int i5 = i3 - ((int) (f6 * f4));
            int i6 = 0;
            if (DragImageView.this.f13052i + DragImageView.this.I + DragImageView.this.J > DragImageView.this.getHeight()) {
                if (i5 < (-DragImageView.this.K)) {
                    i5 = -DragImageView.this.K;
                }
                if (DragImageView.this.getHeight() + i5 > DragImageView.this.f13052i + DragImageView.this.J + DragImageView.this.L) {
                    i5 = (int) ((DragImageView.this.f13052i - DragImageView.this.getHeight()) + DragImageView.this.J + DragImageView.this.L);
                }
            } else {
                i5 = 0;
            }
            if (DragImageView.this.f13051h > DragImageView.this.getWidth()) {
                if (DragImageView.this.getWidth() + i4 > DragImageView.this.f13051h) {
                    i4 = (int) (DragImageView.this.f13051h - DragImageView.this.getWidth());
                }
                if (i4 >= 0) {
                    i6 = i4;
                }
            }
            DragImageView.this.scrollTo(i6, i5);
            DragImageView.this.invalidate();
        }

        public boolean b() {
            return this.f13060e;
        }

        public void c(float f2, float f3) {
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
            this.f13062g = f2;
            this.f13063h = f3;
            this.k = Math.abs((f2 * 1000.0f) / 2500.0f);
            long abs = Math.abs((f3 * 1000.0f) / 2500.0f);
            this.l = abs;
            setDuration(Math.max(this.k, abs));
            setInterpolator(DragImageView.this.U);
            this.f13064i = DragImageView.this.getScrollX();
            this.j = DragImageView.this.getScrollY();
            this.f13060e = true;
        }

        public void d() {
            this.f13061f = true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.f13061f) {
                if (DragImageView.this.o) {
                    this.f13060e = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.f13060e = false;
                    return false;
                } catch (Exception unused) {
                    this.f13060e = false;
                    return false;
                }
            }
            this.f13061f = false;
            this.f13060e = false;
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f13067a;

        /* renamed from: b  reason: collision with root package name */
        public int f13068b;
    }

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
        void a(DragImageView dragImageView, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    public DragImageView(Context context) {
        super(context);
        this.f13048e = new Matrix();
        this.f13049f = 0;
        this.f13050g = 0;
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
        this.d0 = new RectF();
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = null;
        this.k0 = new BlockingLinkedDeque<>(5);
        this.l0 = new BlockingLinkedDeque<>(6);
        this.m0 = 0;
        this.o0 = 0L;
        this.p0 = true;
        this.q0 = new Handler(new d());
        X();
    }

    public static /* synthetic */ int E(DragImageView dragImageView) {
        int i2 = dragImageView.m0;
        dragImageView.m0 = i2 + 1;
        return i2;
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public void N() {
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

    public final void O() {
        int scrollX = getScrollX();
        int i2 = 0;
        if (this.f13051h >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            float f2 = this.f13051h;
            if (getWidth() + scrollX > f2) {
                scrollX = (int) (f2 - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.f13052i + this.I + this.J >= getHeight()) {
            int i3 = this.K;
            if (scrollY < (-i3)) {
                scrollY = -i3;
            }
            i2 = scrollY;
            float f3 = this.f13052i;
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

    public final void P() {
        k kVar = this.s;
        if (kVar != null) {
            kVar.a(this, Q(), R());
        }
    }

    public boolean Q() {
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

    public boolean R() {
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

    public g S() {
        g poll = this.l0.poll();
        if (poll == null) {
            poll = new g();
            try {
                poll.f13067a = Bitmap.createBitmap(this.g0, this.h0, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
        return poll;
    }

    public void T() {
        if (this.S == null) {
            d.a.j0.b1.i.b.b bVar = new d.a.j0.b1.i.b.b(this);
            this.S = bVar;
            bVar.S(this.t);
            this.S.T(this.u);
        }
    }

    public float U(Bitmap bitmap) {
        d.a.j0.b1.i.b.b bVar = this.S;
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

    public final RectF V(float f2, float f3, float f4, float f5) {
        float f6 = f4 / 2.0f;
        float f7 = f5 / 2.0f;
        return new RectF(f2 - f6, f3 - f7, f2 + f6, f3 + f7);
    }

    public boolean W() {
        return (getImageBitmap() == null || this.S == null) ? false : true;
    }

    public final void X() {
        this.R = l.h(getContext());
        int i2 = l.i(getContext()) * l.k(getContext()) * 2;
        this.q = i2;
        if (i2 < 1690000) {
            this.q = 1690000;
        }
        this.f13051h = 0.0f;
        this.f13052i = 0.0f;
        this.j = new ArrayList<>();
        this.k = 1.0f;
        this.l = 1.0f;
        this.m = 1.0f;
        this.n = 1.0f;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.w = new e();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.x = new GestureDetector(getContext(), new a());
    }

    public boolean Y() {
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            return bVar.D();
        }
        return false;
    }

    public boolean Z() {
        return this.O;
    }

    public boolean a0() {
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar == null) {
            return false;
        }
        return bVar.G();
    }

    public boolean b0() {
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar == null) {
            return false;
        }
        return bVar.H();
    }

    public void c0() {
        if (this.w.b()) {
            this.w.d();
        }
        super.setImageDrawable(null);
        this.p = null;
        this.G = null;
        s0();
        if (this.F != null) {
            this.F.close();
            this.F = null;
        }
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            bVar.O();
            System.gc();
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.S == null || this.k != this.m) {
            return super.canScrollHorizontally(i2);
        }
        return false;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return (int) this.f13051h;
    }

    @Override // android.view.View
    public void computeScroll() {
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            bVar.t();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return (int) this.f13052i;
    }

    public boolean d0() {
        int i2 = this.A;
        if (i2 == 1 || i2 == 2) {
            return true;
        }
        return !this.D && getScrollX() <= 0;
    }

    public boolean e0() {
        int i2 = this.A;
        if (i2 == 1 || i2 == 2) {
            return true;
        }
        return !this.D && getScrollX() >= ((int) (this.f13051h - ((float) getWidth()))) - 1;
    }

    public boolean f0() {
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            return bVar.F();
        }
        return this.k == this.m;
    }

    public void g0() {
        if (this.A != 1) {
            return;
        }
        f fVar = this.n0;
        if (fVar != null) {
            fVar.f13065e = false;
            this.n0.interrupt();
        }
        this.q0.removeMessages(0);
        this.q0.removeMessages(1);
        this.q0.removeMessages(2);
    }

    public int getBottomOffset() {
        return this.L;
    }

    public g getCurrentFrame() {
        return this.j0;
    }

    public Bitmap getGifCache() {
        return this.G;
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public byte[] getImageData() {
        return this.p;
    }

    public int getImageType() {
        return this.A;
    }

    public ImageUrlData getImageUrlData() {
        return this.T;
    }

    public int getLeftOffset() {
        return this.M;
    }

    public float getMinScaleValue() {
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            return bVar.z();
        }
        return this.k / 4.0f;
    }

    public float[] getResizedSize() {
        return new float[]{this.f13051h, this.f13052i};
    }

    public Bitmap getVisableBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        Matrix matrix = new Matrix(this.f13048e);
        matrix.postTranslate(-scrollX, -scrollY);
        canvas.drawBitmap(getImageBitmap(), matrix, null);
        return createBitmap;
    }

    public void h0() {
        d.a.c.j.d.a aVar;
        if (this.A != 1) {
            return;
        }
        if (this.F == null) {
            f fVar = this.n0;
            if (fVar != null) {
                fVar.f13065e = false;
                this.n0.interrupt();
                this.n0 = null;
            }
            if (this.p == null) {
                return;
            }
            try {
                aVar = a.C0496a.b().a(this.p, 0, this.p.length);
            } catch (StackOverflowError unused) {
                aVar = null;
            }
            if (aVar != null && aVar.l() != null) {
                this.F = aVar.l();
                if (this.F != null) {
                    this.E = 1;
                    this.g0 = this.F.getWidth();
                    this.h0 = this.F.getHeight();
                    this.m0 = 0;
                    this.i0 = this.F.getFrameCount();
                } else {
                    this.E = 0;
                }
            } else {
                d.a.j0.r.z.a.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                return;
            }
        }
        if (this.F == null) {
            return;
        }
        f fVar2 = this.n0;
        if (fVar2 == null || !(fVar2 == null || fVar2.f13065e)) {
            this.p0 = true;
            this.n0 = new f(this, null);
            this.k0.clear();
            this.l0.clear();
            this.n0.f13065e = true;
            this.n0.start();
        }
    }

    public final void i0() {
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
        this.f13051h = 0.0f;
        this.f13052i = 0.0f;
        this.k = 1.0f;
        this.l = 1.0f;
        this.m = 1.0f;
        this.n = 1.0f;
        this.j.clear();
    }

    public float j0(Bitmap bitmap) {
        float min;
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            return bVar.N();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.r == 0) {
            float width = this.f13049f / bitmap.getWidth();
            float height = this.f13050g / bitmap.getHeight();
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
                if (bitmap.getWidth() * f3 < this.f13049f && bitmap.getHeight() * f3 < this.f13050g) {
                    return f3;
                }
                min = Math.min(width, height);
            }
            return min;
        }
        return Math.max(this.f13049f / bitmap.getWidth(), ((this.f13050g - this.I) - this.J) / bitmap.getHeight());
    }

    public final void k0() {
        g gVar;
        long j2;
        g poll = this.k0.poll();
        if (poll == null) {
            this.p0 = true;
            return;
        }
        this.p0 = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.j0 != null) {
            j2 = gVar.f13068b - (currentTimeMillis - this.o0);
            this.l0.offer(this.j0);
        } else {
            j2 = 0;
        }
        this.j0 = poll;
        this.q0.sendEmptyMessageDelayed(2, j2 > 0 ? j2 : 0L);
    }

    public void l0() {
        if (this.w.b()) {
            this.w.d();
        }
        s0();
        super.setImageDrawable(null);
        this.G = null;
    }

    public void m0(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
            setImageBitmap(bitmap);
            super.setImageMatrix(this.f13048e);
            return;
        }
        if (this.w.b()) {
            this.w.d();
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        super.setImageBitmap(bitmap);
        super.setImageMatrix(this.f13048e);
        scrollTo(scrollX, scrollY);
        this.A = 0;
    }

    public final void n0() {
        o0(false, -1, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0116 A[Catch: Exception -> 0x0171, TryCatch #0 {Exception -> 0x0171, blocks: (B:7:0x000f, B:9:0x0014, B:11:0x001c, B:13:0x002c, B:12:0x002a, B:14:0x002e, B:16:0x0072, B:18:0x007d, B:20:0x0086, B:22:0x0093, B:24:0x009a, B:25:0x009d, B:26:0x00aa, B:28:0x00bc, B:30:0x00c6, B:31:0x00ca, B:51:0x0116, B:53:0x0123, B:54:0x012c, B:56:0x0130, B:57:0x0136, B:59:0x0141, B:61:0x014d, B:63:0x0158, B:69:0x0165, B:34:0x00d2, B:36:0x00d8, B:38:0x00df, B:47:0x010e, B:39:0x00e6, B:41:0x00ea, B:42:0x00f0, B:44:0x00fb, B:46:0x0107), top: B:74:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130 A[Catch: Exception -> 0x0171, TryCatch #0 {Exception -> 0x0171, blocks: (B:7:0x000f, B:9:0x0014, B:11:0x001c, B:13:0x002c, B:12:0x002a, B:14:0x002e, B:16:0x0072, B:18:0x007d, B:20:0x0086, B:22:0x0093, B:24:0x009a, B:25:0x009d, B:26:0x00aa, B:28:0x00bc, B:30:0x00c6, B:31:0x00ca, B:51:0x0116, B:53:0x0123, B:54:0x012c, B:56:0x0130, B:57:0x0136, B:59:0x0141, B:61:0x014d, B:63:0x0158, B:69:0x0165, B:34:0x00d2, B:36:0x00d8, B:38:0x00df, B:47:0x010e, B:39:0x00e6, B:41:0x00ea, B:42:0x00f0, B:44:0x00fb, B:46:0x0107), top: B:74:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0141 A[Catch: Exception -> 0x0171, TryCatch #0 {Exception -> 0x0171, blocks: (B:7:0x000f, B:9:0x0014, B:11:0x001c, B:13:0x002c, B:12:0x002a, B:14:0x002e, B:16:0x0072, B:18:0x007d, B:20:0x0086, B:22:0x0093, B:24:0x009a, B:25:0x009d, B:26:0x00aa, B:28:0x00bc, B:30:0x00c6, B:31:0x00ca, B:51:0x0116, B:53:0x0123, B:54:0x012c, B:56:0x0130, B:57:0x0136, B:59:0x0141, B:61:0x014d, B:63:0x0158, B:69:0x0165, B:34:0x00d2, B:36:0x00d8, B:38:0x00df, B:47:0x010e, B:39:0x00e6, B:41:0x00ea, B:42:0x00f0, B:44:0x00fb, B:46:0x0107), top: B:74:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(boolean z, int i2, int i3) {
        float f2;
        float width;
        float f3;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
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
            this.f13048e.setScale(this.m, this.m);
            this.f13051h = imageBitmap.getWidth() * this.m;
            this.f13052i = imageBitmap.getHeight() * this.m;
            float width2 = imageBitmap.getWidth() * this.n;
            float height = imageBitmap.getHeight() * this.n;
            this.K = this.I;
            int i4 = 0;
            this.L = 0;
            float f4 = 0.0f;
            float f5 = this.f13051h < ((float) this.f13049f) ? (int) ((this.f13049f - this.f13051h) / 2.0f) : 0.0f;
            if (this.f13052i < this.f13050g) {
                float f6 = (int) ((this.f13050g - this.f13052i) / 2.0f);
                if (this.r == 1 && f6 > this.I) {
                    f6 = this.I;
                }
                f4 = f6;
                int i5 = (int) (this.I - f4);
                this.K = i5;
                this.L = this.I - i5;
            }
            this.M = (int) f5;
            this.f13048e.postTranslate(f5, f4);
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            if (z) {
                int screenWidth = getScreenWidth();
                if (i2 > getWidth()) {
                    i2 = getWidth();
                }
                float f7 = screenWidth;
                if (this.f13051h > f7) {
                    if (this.f13051h > f7 && this.f13051h / 2.0f < f7) {
                        f2 = i2;
                        width = this.f13051h / 4.0f;
                        i2 = (int) (f2 - width);
                    }
                    if (i2 > 0) {
                        i2 = (int) (this.f13051h - getWidth());
                    }
                    if (this.B == 2) {
                    }
                    if (this.f13052i <= getHeight()) {
                    }
                    setHorizontalScrollBarEnabled(false);
                    setVerticalScrollBarEnabled(false);
                    if (i2 < 0) {
                    }
                    if (scrollY >= 0) {
                    }
                    scrollTo(i2, i4);
                    setImageMatrix(this.f13048e);
                    P();
                }
                i2 = 0;
                if (i2 > 0 && this.f13051h - i2 < getWidth()) {
                    i2 = (int) (this.f13051h - getWidth());
                }
                if (this.B == 2) {
                    scrollY += (int) ((this.f13052i - height) / 2.0f);
                }
                if (this.f13052i <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.f13052i) {
                    scrollY = (int) (this.f13052i - getHeight());
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
                setImageMatrix(this.f13048e);
                P();
            }
            if (this.B == 2) {
                scrollX += (int) ((this.f13051h - width2) / 2.0f);
            }
            if (this.f13051h > getWidth()) {
                if (getWidth() + scrollX > this.f13051h) {
                    f2 = this.f13051h;
                    width = getWidth();
                    i2 = (int) (f2 - width);
                    if (i2 > 0) {
                    }
                    if (this.B == 2) {
                    }
                    if (this.f13052i <= getHeight()) {
                    }
                    setHorizontalScrollBarEnabled(false);
                    setVerticalScrollBarEnabled(false);
                    if (i2 < 0) {
                    }
                    if (scrollY >= 0) {
                    }
                    scrollTo(i2, i4);
                    setImageMatrix(this.f13048e);
                    P();
                }
                i2 = scrollX;
                if (i2 > 0) {
                }
                if (this.B == 2) {
                }
                if (this.f13052i <= getHeight()) {
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (i2 < 0) {
                }
                if (scrollY >= 0) {
                }
                scrollTo(i2, i4);
                setImageMatrix(this.f13048e);
                P();
            }
            i2 = 0;
            if (i2 > 0) {
            }
            if (this.B == 2) {
            }
            if (this.f13052i <= getHeight()) {
            }
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            if (i2 < 0) {
            }
            if (scrollY >= 0) {
            }
            scrollTo(i2, i4);
            setImageMatrix(this.f13048e);
            P();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h0();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c0();
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
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar == null || !bVar.K(canvas, getImageBitmap())) {
            if (this.A == 2 && this.N != 0 && !this.w.b()) {
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
                if (this.b0 < r0) {
                    this.B = 0;
                } else {
                    this.B = 4;
                    r0();
                }
            }
            if (this.A == 0 && this.W && this.c0 != null && this.T != null) {
                canvas.drawColor(Color.argb((int) (this.a0 * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.d0 == null) {
                    this.d0 = new RectF();
                }
                this.V.mapRect(this.d0, new RectF(this.c0));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.e0, this.d0, (Paint) null);
                }
            } else if (this.B == 4 && this.c0 != null) {
                canvas.drawColor(Color.argb((int) (this.a0 * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.e0, this.d0, (Paint) null);
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
                this.f13048e.setScale(f14, f14);
                float f17 = f15 * f14;
                i4 = (int) ((f16 - f17) / 2.0f);
                float f18 = height2 * f14;
                i5 = (int) ((height3 - f18) / 2.0f);
                this.f13048e.postTranslate(i4, i5);
                width2 = (int) f17;
                height2 = (int) f18;
            }
            canvas.clipRect(i4, i5, width2 + i4, height2 + i5);
            canvas.drawColor(-1);
            if (this.E != 1 || this.F == null || (gVar = this.j0) == null || (bitmap2 = gVar.f13067a) == null) {
                if (z) {
                    canvas.drawBitmap(this.G, i4, i5, (Paint) null);
                    return;
                } else {
                    canvas.drawBitmap(this.G, this.f13048e, this.H);
                    return;
                }
            }
            if (z) {
                canvas.drawBitmap(bitmap2, i4, i5, (Paint) null);
            } else {
                canvas.drawBitmap(bitmap2, this.f13048e, this.H);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            this.f13049f = i4 - i2;
            this.f13050g = i5 - i3;
            i0();
        }
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        d.a.j0.b1.i.b.b bVar;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0 || (bVar = this.S) == null) {
            return;
        }
        bVar.V();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d.a.j0.b1.i.b.b bVar = this.S;
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

    public void p0() {
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

    public float q0(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    public final void r0() {
        ImageUrlData imageUrlData = this.T;
        if (imageUrlData == null) {
            h hVar = this.f0;
            if (hVar != null) {
                hVar.b();
                return;
            }
            return;
        }
        Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            h hVar2 = this.f0;
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
        RectF rectF = this.d0;
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
        ofFloat.addUpdateListener(new b(sourceImageRectInScreen, fArr, fArr2));
        ofFloat.addListener(new c());
        ofFloat.start();
    }

    public void s0() {
        if (this.A != 1) {
            return;
        }
        f fVar = this.n0;
        if (fVar != null) {
            fVar.f13065e = false;
            this.n0.interrupt();
            this.n0 = null;
        }
        this.q0.removeMessages(0);
        this.q0.removeMessages(1);
        this.q0.removeMessages(2);
        this.p0 = true;
        this.j0 = null;
        this.l0.clear();
        this.k0.clear();
        this.g0 = 0;
        this.h0 = 0;
        this.m0 = 0;
        this.i0 = 0;
        this.F = null;
    }

    public void setCanScale(boolean z) {
        this.P = z;
    }

    public void setDefaultBitmap() {
        if (this.w.b()) {
            this.w.d();
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

    public void setDragToExitListener(h hVar) {
        this.f0 = hVar;
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.w.b()) {
            this.w.d();
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

    public void setGifMaxUseableMem(int i2) {
    }

    public void setGifSetListener(i iVar) {
        this.v = iVar;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.w.b()) {
            this.w.d();
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
        if (this.e0 == null) {
            this.e0 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.p = bArr;
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            bVar.Q(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void setImageLoadCallBack(d.a.j0.b1.i.b.a aVar) {
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            bVar.R(aVar);
        }
    }

    public void setImageMode(int i2) {
        this.r = i2;
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
        d.a.j0.b1.i.b.b bVar = this.S;
        if (bVar != null) {
            bVar.T(onLongClickListener);
        }
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.T = imageUrlData;
    }

    public void setIsHeadImage(boolean z) {
        this.Q = z;
    }

    public void setLoadBigImage(boolean z) {
        this.O = z;
    }

    public void setOffset(int i2, int i3, int i4, int i5) {
        this.I = i3;
        this.J = i5;
    }

    public void setOnImageScrollListener(j jVar) {
        this.y = jVar;
    }

    public void setOnSizeChangedListener(k kVar) {
        this.s = kVar;
    }

    public void t0() {
        int i2 = this.A;
        if (i2 == 1 || i2 == 2) {
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
        int i2 = this.A;
        if (i2 == 1 || i2 == 2) {
            return;
        }
        int size = this.j.size();
        if (size > 1) {
            this.j.remove(size - 1);
        }
        n0();
    }

    /* loaded from: classes3.dex */
    public class f extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f13065e;

        public f() {
            this.f13065e = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.f13065e && DragImageView.this.F != null && DragImageView.this.i0 > 0 && DragImageView.this.g0 > 0 && DragImageView.this.h0 > 0) {
                try {
                    if (DragImageView.this.m0 >= DragImageView.this.F.getFrameCount()) {
                        DragImageView.this.m0 = 0;
                    }
                    DragImageView.this.F.c(DragImageView.this.m0);
                    g S = DragImageView.this.S();
                    if (S.f13067a == null || (S.f13067a.getWidth() != DragImageView.this.g0 && S.f13067a.getHeight() != DragImageView.this.h0)) {
                        try {
                            S.f13067a = Bitmap.createBitmap(DragImageView.this.g0, DragImageView.this.h0, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError unused) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                S.f13067a = Bitmap.createBitmap(DragImageView.this.g0, DragImageView.this.h0, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError unused2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.F.a(S.f13067a, null);
                    S.f13068b = DragImageView.this.F.b(DragImageView.this.m0);
                    DragImageView.E(DragImageView.this);
                    if (S.f13067a == null) {
                        DragImageView.E(DragImageView.this);
                    }
                    DragImageView.this.m0 %= DragImageView.this.i0;
                    DragImageView.this.k0.put(S);
                    if (DragImageView.this.p0) {
                        DragImageView.this.q0.sendEmptyMessage(1);
                    }
                } catch (Exception unused3) {
                    return;
                }
            }
        }

        public /* synthetic */ f(DragImageView dragImageView, a aVar) {
            this();
        }
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13048e = new Matrix();
        this.f13049f = 0;
        this.f13050g = 0;
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
        this.d0 = new RectF();
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = null;
        this.k0 = new BlockingLinkedDeque<>(5);
        this.l0 = new BlockingLinkedDeque<>(6);
        this.m0 = 0;
        this.o0 = 0L;
        this.p0 = true;
        this.q0 = new Handler(new d());
        X();
    }

    public DragImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13048e = new Matrix();
        this.f13049f = 0;
        this.f13050g = 0;
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
        this.d0 = new RectF();
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = null;
        this.k0 = new BlockingLinkedDeque<>(5);
        this.l0 = new BlockingLinkedDeque<>(6);
        this.m0 = 0;
        this.o0 = 0L;
        this.p0 = true;
        this.q0 = new Handler(new d());
        X();
    }
}

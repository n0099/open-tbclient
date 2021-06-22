package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.a.c.a.i;
import d.a.c.a.j;
import d.a.c.f.a.a;
import d.a.o0.e2.i.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static HashMap<String, SoftReference<d.a.c.k.d.a>> A0;
    public static Method w0;
    public static Method x0;
    public static Method y0;
    public static Method z0;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public float E;
    public float F;
    public final int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public float P;
    public float Q;
    public boolean R;
    public boolean S;
    public int T;
    public f U;
    public g V;
    public View.OnClickListener W;
    public d.a.o0.e2.i.c a0;
    public TbRichTextView.v b0;
    public boolean c0;
    public RectF i0;
    public Path j0;
    public RectF k0;
    public final Matrix l0;
    public d.a.n0.b1.c m0;
    public String n0;
    public int o0;
    public boolean p0;
    public int q0;
    public int r0;
    public final d.a.o0.e2.i.c s0;
    public final d.a.c.e.l.c<d.a.c.k.d.a> t0;
    public a.InterfaceC0550a u0;
    public BdUniqueId v;
    public CustomMessageListener v0;
    public boolean w;
    public HashMap<String, e> x;
    public HashMap<String, e> y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // d.a.o0.e2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.o0.e2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            if (TbImageView.this.getBdImage() != null || TbImageView.this.getDrawable() != null || !TbImageView.this.c0) {
                if (TbImageView.this.W != null) {
                    TbImageView.this.W.onClick(view);
                    return true;
                } else if (TbImageView.this.a0 != null) {
                    TbImageView.this.a0.a(view);
                    return TbImageView.this.a0.onSingleTapConfirmed(motionEvent);
                } else {
                    return false;
                }
            }
            TbImageView.this.X();
            d.a.c.e.l.d h2 = d.a.c.e.l.d.h();
            TbImageView tbImageView = TbImageView.this;
            h2.k(tbImageView.z, tbImageView.A, tbImageView.t0, tbImageView.B, tbImageView.C, tbImageView.v, new Object[0]);
            return true;
        }

        @Override // d.a.o0.e2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (TbImageView.this.a0 != null) {
                TbImageView.this.a0.a(view);
                return TbImageView.this.a0.onDoubleTap(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public b() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            TbImageView.this.Z();
            f fVar = TbImageView.this.U;
            if (fVar != null) {
                fVar.onCancel();
            }
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar != null) {
                TbImageView.this.q0 = aVar.r();
                TbImageView.this.r0 = aVar.m();
                d.a.c.e.l.d h2 = d.a.c.e.l.d.h();
                TbImageView tbImageView = TbImageView.this;
                String g2 = h2.g(tbImageView.z, tbImageView.A);
                e eVar = TbImageView.this.y.get(g2);
                if (eVar != null) {
                    d.a.c.e.l.a.d(i2 == 1, i2 == 2, i2 == 3);
                    if (i2 == 3) {
                        d.a.c.e.l.a.e(true, System.currentTimeMillis() - eVar.f13190c);
                    }
                    TbImageView.this.y.remove(g2);
                }
            }
            TbImageView.this.Z();
            TbImageView.this.P(aVar);
            f fVar = TbImageView.this.U;
            if (fVar != null) {
                fVar.a(str, aVar != null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC0550a {
        public c() {
        }

        @Override // d.a.c.f.a.a.InterfaceC0550a
        public boolean a(Canvas canvas, Drawable drawable) {
            if (TbImageView.this.getBdImage() == null && TbImageView.this.p0) {
                TbImageView.this.F(canvas, drawable);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        public final void a() {
            if (TbImageView.w0 == null) {
                Method unused = TbImageView.w0 = d.a.c.e.b.a.a.c(TbImageView.class, "destroyLayer", new Object[0]);
            }
            if (TbImageView.x0 == null) {
                Method unused2 = TbImageView.x0 = d.a.c.e.b.a.a.c(TbImageView.class, "destroyLayer", Boolean.FALSE);
            }
            if (TbImageView.y0 == null) {
                Method unused3 = TbImageView.y0 = d.a.c.e.b.a.a.c(TbImageView.class, "clearDisplayList", new Object[0]);
            }
            if (TbImageView.z0 == null) {
                Method unused4 = TbImageView.z0 = d.a.c.e.b.a.a.c(TbImageView.class, "resetDisplayList", new Object[0]);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            d.a.c.e.l.d h2 = d.a.c.e.l.d.h();
            TbImageView tbImageView = TbImageView.this;
            String g2 = h2.g(tbImageView.z, tbImageView.A);
            if (g2 == null || !g2.equals(str)) {
                return;
            }
            TbImageView.this.destroyDrawingCache();
            a();
            d.a.c.e.b.a.a.e(TbImageView.w0, TbImageView.this, TbImageView.class);
            d.a.c.e.b.a.a.f(TbImageView.x0, TbImageView.this, TbImageView.class, Boolean.FALSE);
            d.a.c.e.b.a.a.e(TbImageView.y0, TbImageView.this, TbImageView.class);
            d.a.c.e.b.a.a.e(TbImageView.z0, TbImageView.this, TbImageView.class);
            TbImageView.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public String f13188a;

        /* renamed from: b  reason: collision with root package name */
        public int f13189b;

        /* renamed from: c  reason: collision with root package name */
        public long f13190c;

        public e() {
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    public TbImageView(Context context) {
        super(context);
        this.w = false;
        this.A = 10;
        this.G = R.drawable.img_loading;
        this.H = R.color.transparent;
        this.I = R.color.CAM_X0205;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = false;
        this.S = true;
        this.T = 3;
        this.i0 = new RectF();
        this.j0 = new Path();
        this.k0 = new RectF();
        this.l0 = new Matrix();
        this.p0 = false;
        this.q0 = 0;
        this.r0 = 0;
        this.s0 = new d.a.o0.e2.i.c(new a());
        this.t0 = new b();
        this.u0 = new c();
        this.v0 = new d(2016308);
        G();
    }

    private void G() {
        this.x = new HashMap<>();
        this.y = new HashMap<>();
        this.m0 = new d.a.n0.b1.c(this);
        a0();
        this.E = 30.0f;
        setConrers(0);
        d.a.c.f.a.a aVar = this.f2204i;
        if (aVar == null) {
            return;
        }
        aVar.o(this.u0);
    }

    public void A() {
        this.o0 = 0;
    }

    public void B() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        d.a.c.e.l.d.h().d(this.z, this.A, this.t0);
        if (TextUtils.isEmpty(this.z) || J()) {
            Z();
        }
    }

    public void F(Canvas canvas, Drawable drawable) {
        canvas.save();
        this.j0.reset();
        this.i0.right = getWidth();
        this.i0.bottom = getHeight();
        this.j0.addRoundRect(this.i0, this.f2203h.f42777a, Path.Direction.CW);
        int i2 = this.o0 ^ 15;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if ((i2 & 1) != 0) {
            Path path = this.j0;
            float[] fArr = this.f2203h.f42777a;
            path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
        }
        if ((i2 & 2) != 0) {
            Path path2 = this.j0;
            float f2 = rectF.right;
            float[] fArr2 = this.f2203h.f42777a;
            path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
        }
        if ((i2 & 4) != 0) {
            Path path3 = this.j0;
            float f3 = rectF.bottom;
            float[] fArr3 = this.f2203h.f42777a;
            path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
        }
        if ((i2 & 8) != 0) {
            Path path4 = this.j0;
            float f4 = rectF.right;
            float[] fArr4 = this.f2203h.f42777a;
            float f5 = rectF.bottom;
            path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
        }
        if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
            canvas.clipPath(this.j0);
        }
        drawable.draw(canvas);
        canvas.restore();
    }

    public boolean H() {
        return this.L;
    }

    public boolean I() {
        return this.M;
    }

    public boolean J() {
        return this.D;
    }

    public boolean K() {
        return this.O;
    }

    public final void L() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    public final void M(boolean z, Canvas canvas) {
        g gVar = this.V;
        if (gVar == null) {
            return;
        }
        if (z) {
            gVar.b(this, canvas);
        } else {
            gVar.a(this, canvas);
        }
    }

    public final void N(Canvas canvas) {
        if (this.N || getBdImage() != null) {
            if (this.o0 != 0 || getDrawCorner()) {
                setDrawerType(1);
                int i2 = this.o0 ^ 15;
                this.k0.set(0.0f, 0.0f, getWidth(), getHeight());
                if ((i2 & 1) != 0) {
                    float[] fArr = this.f2203h.f42777a;
                    canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.f2204i.f42763b);
                }
                if ((i2 & 2) != 0) {
                    float f2 = this.k0.right;
                    float[] fArr2 = this.f2203h.f42777a;
                    canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.f2204i.f42763b);
                }
                if ((i2 & 4) != 0) {
                    float f3 = this.k0.bottom;
                    float[] fArr3 = this.f2203h.f42777a;
                    canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.f2204i.f42763b);
                }
                if ((i2 & 8) != 0) {
                    RectF rectF = this.k0;
                    float f4 = rectF.right;
                    float[] fArr4 = this.f2203h.f42777a;
                    float f5 = rectF.bottom;
                    canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.f2204i.f42763b);
                }
            }
        }
    }

    public final void O(Canvas canvas) {
        if (this.N || getBdImage() != null) {
            if (this.o0 != 0 || getDrawBorder()) {
                setDrawerType(1);
                int i2 = this.o0 ^ 15;
                this.k0.set(0.0f, 0.0f, getWidth(), getHeight());
                this.f2204i.f42764c.setStrokeWidth(this.f2204i.f42764c.getStrokeWidth());
                if ((i2 & 1) != 0) {
                    canvas.drawLine(0.0f, 0.0f, this.f2203h.f42777a[0], 0.0f, this.f2204i.f42764c);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.f2203h.f42777a[1], this.f2204i.f42764c);
                }
                if ((i2 & 2) != 0) {
                    float f2 = this.k0.right;
                    canvas.drawLine(f2 - this.f2203h.f42777a[2], 0.0f, f2, 0.0f, this.f2204i.f42764c);
                    float f3 = this.k0.right;
                    canvas.drawLine(f3, 0.0f, f3, this.f2203h.f42777a[3], this.f2204i.f42764c);
                }
                if ((i2 & 4) != 0) {
                    float f4 = this.k0.bottom;
                    canvas.drawLine(0.0f, f4 - this.f2203h.f42777a[5], 0.0f, f4, this.f2204i.f42764c);
                    float f5 = this.k0.bottom;
                    canvas.drawLine(0.0f, f5, this.f2203h.f42777a[4], f5, this.f2204i.f42764c);
                }
                if ((i2 & 8) != 0) {
                    RectF rectF = this.k0;
                    float f6 = rectF.right;
                    float f7 = rectF.bottom;
                    canvas.drawLine(f6 - this.f2203h.f42777a[6], f7, f6, f7, this.f2204i.f42764c);
                    RectF rectF2 = this.k0;
                    float f8 = rectF2.right;
                    float f9 = rectF2.bottom;
                    canvas.drawLine(f8, f9, f8, f9 - this.f2203h.f42777a[7], this.f2204i.f42764c);
                }
            }
        }
    }

    public final void P(d.a.c.k.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.L = aVar.t();
    }

    public void Q() {
        setTag(null);
        this.z = null;
        this.L = false;
        this.M = false;
        this.K = false;
    }

    public void R(String str, int i2, int i3, int i4, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        i c2 = j.c(getContext());
        if (c2 != null) {
            BdUniqueId bdUniqueId2 = this.v;
            if (bdUniqueId2 == null) {
                bdUniqueId2 = c2.getUniqueId();
            }
            z2 = c2.isScroll();
            bdUniqueId = bdUniqueId2;
        } else {
            bdUniqueId = null;
            z2 = false;
        }
        S(str, i2, i3, i4, z, bdUniqueId, z2);
    }

    public void S(String str, int i2, int i3, int i4, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            this.z = str;
            int i5 = this.T;
            if (i5 == 3 || i5 == TbadkCoreApplication.getInst().getSkinType()) {
                return;
            }
            invalidate();
            return;
        }
        boolean z3 = str.equals(this.z) && i2 == this.A && bdUniqueId == this.v;
        d.a.c.k.d.a bdImage = getBdImage();
        if (!z3) {
            B();
            this.l = true;
            this.L = false;
            requestLayout();
        } else if (bdImage != null) {
            invalidate();
            this.q0 = bdImage.r();
            this.r0 = bdImage.m();
            f fVar = this.U;
            if (fVar != null) {
                fVar.a(str, true);
                return;
            }
            return;
        }
        this.z = str;
        this.A = i2;
        this.v = bdUniqueId;
        this.l = true;
        if (!TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
            this.B = i3;
            this.C = i4;
        }
        if (z2) {
            invalidate();
        } else if (!d.a.c.e.l.d.h().j(this.A) && this.R) {
            invalidate();
        } else if (z3 && !d.a.c.e.p.j.z()) {
            invalidate();
            f fVar2 = this.U;
            if (fVar2 != null) {
                fVar2.a(str, false);
            }
        } else {
            if (z) {
                X();
            }
            String g2 = d.a.c.e.l.d.h().g(str, i2);
            e eVar = new e();
            eVar.f13188a = str;
            eVar.f13189b = i2;
            eVar.f13190c = System.currentTimeMillis();
            this.y.put(g2, eVar);
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                String g3 = d.a.c.e.l.d.h().g(str, i2);
                if (this.x.containsKey(g3)) {
                    return;
                }
                e eVar2 = new e();
                eVar2.f13188a = str;
                eVar2.f13189b = i2;
                this.x.put(g3, eVar2);
                return;
            }
            d.a.c.e.l.d.h().k(this.z, this.A, this.t0, i3, i4, this.v, new Object[0]);
        }
    }

    public void T(String str, int i2, int i3, int i4, boolean z, boolean z2) {
        BdUniqueId bdUniqueId;
        i c2 = j.c(getContext());
        if (c2 != null) {
            BdUniqueId bdUniqueId2 = this.v;
            if (bdUniqueId2 == null) {
                bdUniqueId2 = c2.getUniqueId();
            }
            bdUniqueId = bdUniqueId2;
        } else {
            bdUniqueId = null;
        }
        S(str, i2, i3, i4, z, bdUniqueId, z2);
    }

    public void U(String str, int i2, boolean z) {
        R(str, i2, 0, 0, z);
    }

    public void V(String str, int i2, boolean z, boolean z2) {
        T(str, i2, 0, 0, z, z2);
    }

    public void X() {
        this.D = true;
        L();
    }

    public void Y() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        d.a.c.e.l.d.h().d(this.z, this.A, this.t0);
        this.y.remove(d.a.c.e.l.d.h().g(this.z, this.A));
        Z();
    }

    public void Z() {
        this.D = false;
        removeCallbacks(this);
        this.F = 0.0f;
        this.l0.reset();
        setExtraMatrix(this.l0);
        invalidate();
    }

    public final void a0() {
        boolean z = false;
        if (this.S) {
            this.f2203h.f42782f = (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true;
        } else {
            this.f2203h.f42782f = false;
        }
        int i2 = this.D ? this.G : this.H;
        if (i2 != this.J) {
            this.J = i2;
            this.l = true;
        }
        int i3 = this.I;
        if (i3 > 0) {
            if (this.S) {
                setDefaultBg(SkinManager.getDrawable(i3));
            } else {
                setDefaultBg(getResources().getDrawable(this.I));
            }
        } else {
            setDefaultBg(null);
        }
        if (this.S) {
            this.m0.j(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TbRichTextView.v vVar = this.b0;
        if (vVar != null) {
            vVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void f(Canvas canvas, ImageView imageView) {
        d.a.c.f.a.e eVar;
        super.f(canvas, imageView);
        if (this.m0 == null || (eVar = this.f2203h) == null) {
            return;
        }
        if (eVar.f42785i && (this.K || H())) {
            this.m0.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
        } else if (this.f2203h.f42784h && I()) {
            this.m0.a(canvas, getContext().getString(R.string.icon_tag_long), true);
        } else {
            String str = this.n0;
            if (str != null) {
                this.m0.a(canvas, str, false);
            }
        }
        int i2 = this.f2203h.j;
        if (i2 == d.a.c.f.a.b.f42773c) {
            this.m0.b(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
        } else if (i2 == d.a.c.f.a.b.f42772b) {
            this.m0.b(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.c.k.d.a getBdImage() {
        d.a.c.k.d.a aVar;
        if (TextUtils.isEmpty(this.z)) {
            Object tag = getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                aVar = d.a.n0.a0.c.k().m(str);
                if (aVar == null) {
                    aVar = d.a.n0.a0.c.k().l(str);
                }
            } else {
                aVar = null;
            }
        } else {
            aVar = (d.a.c.k.d.a) d.a.c.e.l.d.h().n(this.z, this.A, new Object[0]);
        }
        if (aVar != null) {
            P(aVar);
        }
        return aVar;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.c.k.d.a getDefaultBdImage() {
        SoftReference<d.a.c.k.d.a> softReference;
        d.a.c.k.d.a aVar;
        if (A0 == null) {
            A0 = new HashMap<>();
        }
        String valueOf = String.valueOf(this.J);
        if (this.S) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                valueOf = valueOf + SkinManager.nightSufix;
            } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                valueOf = valueOf + SkinManager.darkSuffix;
            }
        }
        if (this.T != TbadkCoreApplication.getInst().getSkinType()) {
            this.l = true;
            this.T = TbadkCoreApplication.getInst().getSkinType();
        }
        if (!A0.containsKey(valueOf) || (softReference = A0.get(valueOf)) == null || (aVar = softReference.get()) == null || !aVar.w()) {
            Bitmap bitmap = null;
            int i2 = this.J;
            if (i2 > 0) {
                if (this.S) {
                    if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        bitmap = BitmapHelper.getCashBitmap(this.J);
                    } else {
                        bitmap = SkinManager.getBitmap(this.J);
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.J);
                        }
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(i2);
                }
            }
            d.a.c.k.d.a aVar2 = new d.a.c.k.d.a(bitmap, false, String.valueOf(this.J));
            A0.put(valueOf, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public boolean getDrawCorner() {
        return this.p0;
    }

    public int getGifIconHeight() {
        d.a.n0.b1.c cVar = this.m0;
        if (cVar != null) {
            return (int) cVar.d(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconWidth() {
        d.a.n0.b1.c cVar = this.m0;
        if (cVar != null) {
            return (int) cVar.e(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    @Deprecated
    public int getLoadedHeight() {
        return this.r0;
    }

    @Deprecated
    public int getLoadedWidth() {
        return this.q0;
    }

    public View.OnClickListener getOnClickListener() {
        return this.W;
    }

    public float[] getRadius() {
        d.a.c.f.a.e eVar = this.f2203h;
        return eVar == null ? BDImageView.j(0.0f) : eVar.f42777a;
    }

    public float getSmartCropCenterPointHeightRatio() {
        return this.Q;
    }

    public float getSmartCropCenterPointWidthRatio() {
        return this.P;
    }

    public String getUrl() {
        return this.z;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a.c.a.f<?> a2 = j.a(getContext());
        if (this.v != null) {
            this.w = true;
        }
        if (a2 != null) {
            CustomMessageListener customMessageListener = this.v0;
            BdUniqueId bdUniqueId = this.v;
            if (bdUniqueId == null) {
                bdUniqueId = a2.getUniqueId();
            }
            customMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.v0);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.c0) {
            X();
            d.a.c.e.l.d.h().k(this.z, this.A, this.t0, this.B, this.C, this.v, new Object[0]);
            return;
        }
        View.OnClickListener onClickListener = this.W;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.w = false;
        Y();
        MessageManager.getInstance().unRegisterListener(this.v0);
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        a0();
        M(true, canvas);
        super.onDraw(canvas);
        N(canvas);
        O(canvas);
        M(false, canvas);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
            this.B = getMeasuredWidth();
            this.C = getMeasuredHeight();
            Iterator<Map.Entry<String, e>> it = this.x.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, e> next = it.next();
                next.getKey();
                e value = next.getValue();
                it.remove();
                d.a.c.e.l.d.h().k(value.f13188a, value.f13189b, this.t0, this.B, this.C, this.v, new Object[0]);
            }
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Y();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 != 8 && i2 != 4) {
            refresh();
        } else {
            Y();
        }
    }

    public void refresh() {
        R(this.z, this.A, this.B, this.C, false);
        invalidate();
    }

    public void run() {
        if (this.D) {
            float f2 = this.F;
            float f3 = this.E;
            float f4 = f2 + f3;
            this.F = f4;
            if (f4 > 360.0f - f3) {
                this.F = 0.0f;
            }
            this.l0.reset();
            this.l0.postRotate(this.F, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.l0);
            invalidate();
            L();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.S = z;
    }

    public void setConrers(int i2) {
        this.o0 = i2;
    }

    public void setDefaultBgResource(int i2) {
        if (this.I != i2) {
            this.I = i2;
            invalidate();
        }
    }

    public void setDefaultResource(int i2) {
        if (this.H != i2) {
            this.H = i2;
            invalidate();
        }
    }

    public void setDispatchTouchListener(TbRichTextView.v vVar) {
        this.b0 = vVar;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        super.setDrawBorder(z);
    }

    public void setDrawCorner(boolean z) {
        this.p0 = z;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i2) {
        super.setDrawerType(i2);
        d.a.c.f.a.a aVar = this.f2204i;
        if (aVar == null) {
            return;
        }
        aVar.o(this.u0);
    }

    public void setEvent(f fVar) {
        this.U = fVar;
    }

    public void setInterceptOnClick(boolean z) {
        this.c0 = z;
    }

    public void setIsBitmapPic(boolean z) {
        this.N = z;
    }

    public void setIsGifPic(boolean z) {
        this.K = z;
    }

    public void setIsLongPic(boolean z) {
        this.M = z;
    }

    public void setIsSmartCrop(boolean z) {
        this.O = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnTouchListener(this.s0);
        if (!isClickable()) {
            setClickable(true);
        }
        this.W = onClickListener;
    }

    public void setOnDrawListener(g gVar) {
        this.V = gVar;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.v = bdUniqueId;
        if (this.w || bdUniqueId == null) {
            return;
        }
        this.v0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.v0);
        this.w = true;
    }

    public void setPlaceHolder(int i2) {
        setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
        if (i2 == 0) {
            setDefaultBgResource(SkinManager.getResourceId(R.drawable.transparent_bg));
        } else if (i2 != 1) {
            setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
        } else {
            setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_28_n));
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i2) {
        setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
        if (i2 == 0) {
            setDefaultBgResource(R.drawable.transparent_bg);
        } else if (i2 != 1) {
            setDefaultBgResource(R.drawable.pic_use_header_40_n);
        } else {
            setDefaultBgResource(R.drawable.pic_use_header_28_n);
        }
    }

    public void setSmartCropCenterPointHeightRatio(float f2) {
        this.Q = f2;
    }

    public void setSmartCropCenterPointWidthRatio(float f2) {
        this.P = f2;
    }

    public void setSupportNoImage(boolean z) {
        this.R = z;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Object tag = getTag();
        super.setTag(obj);
        if (obj == null) {
            if (tag != null) {
                this.l = true;
                requestLayout();
            }
        } else if (obj.equals(tag)) {
        } else {
            this.l = true;
            requestLayout();
        }
    }

    public void setTagColor(int i2) {
        d.a.n0.b1.c cVar = this.m0;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void setTagPaddingDis(int i2, int i3) {
        d.a.n0.b1.c cVar = this.m0;
        if (cVar != null) {
            cVar.g(i2, i3);
        }
    }

    public void setTagStr(String str) {
        this.n0 = str;
    }

    public void setTagTextSize(int i2) {
        d.a.n0.b1.c cVar = this.m0;
        if (cVar != null) {
            cVar.i(i2);
        }
    }

    public void setTbGestureDetector(d.a.o0.e2.i.c cVar) {
        super.setOnTouchListener(this.s0);
        this.a0 = cVar;
    }

    public void z(int i2) {
        this.o0 = i2 | this.o0;
    }

    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TbImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.w = false;
        this.A = 10;
        this.G = R.drawable.img_loading;
        this.H = R.color.transparent;
        this.I = R.color.CAM_X0205;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = false;
        this.S = true;
        this.T = 3;
        this.i0 = new RectF();
        this.j0 = new Path();
        this.k0 = new RectF();
        this.l0 = new Matrix();
        this.p0 = false;
        this.q0 = 0;
        this.r0 = 0;
        this.s0 = new d.a.o0.e2.i.c(new a());
        this.t0 = new b();
        this.u0 = new c();
        this.v0 = new d(2016308);
        G();
    }
}

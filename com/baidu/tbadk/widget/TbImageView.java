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
import d.a.j0.d2.i.c;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static Method r0;
    public static Method s0;
    public static Method t0;
    public static Method u0;
    public static HashMap<String, SoftReference<d.a.c.j.d.a>> v0;
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
    public d.a.j0.d2.i.c a0;
    public TbRichTextView.v b0;
    public boolean c0;
    public RectF d0;
    public Path e0;
    public RectF f0;
    public final Matrix g0;
    public d.a.i0.b1.c h0;
    public String i0;
    public int j0;
    public boolean k0;
    public int l0;
    public int m0;
    public final d.a.j0.d2.i.c n0;
    public final d.a.c.e.l.c<d.a.c.j.d.a> o0;
    public a.InterfaceC0520a p0;
    public CustomMessageListener q0;
    public BdUniqueId v;
    public boolean w;
    public HashMap<String, e> x;
    public HashMap<String, e> y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.j0.d2.i.c.a
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
            h2.k(tbImageView.z, tbImageView.A, tbImageView.o0, tbImageView.B, tbImageView.C, tbImageView.v, new Object[0]);
            return true;
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            if (TbImageView.this.a0 != null) {
                TbImageView.this.a0.a(view);
                return TbImageView.this.a0.onDoubleTap(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {
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
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            if (aVar != null) {
                TbImageView.this.l0 = aVar.r();
                TbImageView.this.m0 = aVar.m();
                d.a.c.e.l.d h2 = d.a.c.e.l.d.h();
                TbImageView tbImageView = TbImageView.this;
                String g2 = h2.g(tbImageView.z, tbImageView.A);
                e eVar = TbImageView.this.y.get(g2);
                if (eVar != null) {
                    d.a.c.e.l.a.d(i2 == 1, i2 == 2, i2 == 3);
                    if (i2 == 3) {
                        d.a.c.e.l.a.e(true, System.currentTimeMillis() - eVar.f13799c);
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
    public class c implements a.InterfaceC0520a {
        public c() {
        }

        @Override // d.a.c.f.a.a.InterfaceC0520a
        public boolean a(Canvas canvas, Drawable drawable) {
            if (TbImageView.this.getBdImage() == null && TbImageView.this.k0) {
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
            if (TbImageView.r0 == null) {
                Method unused = TbImageView.r0 = d.a.c.e.b.a.a.c(TbImageView.class, "destroyLayer", new Object[0]);
            }
            if (TbImageView.s0 == null) {
                Method unused2 = TbImageView.s0 = d.a.c.e.b.a.a.c(TbImageView.class, "destroyLayer", Boolean.FALSE);
            }
            if (TbImageView.t0 == null) {
                Method unused3 = TbImageView.t0 = d.a.c.e.b.a.a.c(TbImageView.class, "clearDisplayList", new Object[0]);
            }
            if (TbImageView.u0 == null) {
                Method unused4 = TbImageView.u0 = d.a.c.e.b.a.a.c(TbImageView.class, "resetDisplayList", new Object[0]);
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
            d.a.c.e.b.a.a.e(TbImageView.r0, TbImageView.this, TbImageView.class);
            d.a.c.e.b.a.a.f(TbImageView.s0, TbImageView.this, TbImageView.class, Boolean.FALSE);
            d.a.c.e.b.a.a.e(TbImageView.t0, TbImageView.this, TbImageView.class);
            d.a.c.e.b.a.a.e(TbImageView.u0, TbImageView.this, TbImageView.class);
            TbImageView.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public String f13797a;

        /* renamed from: b  reason: collision with root package name */
        public int f13798b;

        /* renamed from: c  reason: collision with root package name */
        public long f13799c;

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
        this.d0 = new RectF();
        this.e0 = new Path();
        this.f0 = new RectF();
        this.g0 = new Matrix();
        this.k0 = false;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = new d.a.j0.d2.i.c(new a());
        this.o0 = new b();
        this.p0 = new c();
        this.q0 = new d(2016308);
        G();
    }

    private void G() {
        this.x = new HashMap<>();
        this.y = new HashMap<>();
        this.h0 = new d.a.i0.b1.c(this);
        a0();
        this.E = 30.0f;
        setConrers(0);
        d.a.c.f.a.a aVar = this.f2186i;
        if (aVar == null) {
            return;
        }
        aVar.o(this.p0);
    }

    public void A() {
        this.j0 = 0;
    }

    public void B() {
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        d.a.c.e.l.d.h().d(this.z, this.A, this.o0);
        if (TextUtils.isEmpty(this.z) || J()) {
            Z();
        }
    }

    public void F(Canvas canvas, Drawable drawable) {
        canvas.save();
        this.e0.reset();
        this.d0.right = getWidth();
        this.d0.bottom = getHeight();
        this.e0.addRoundRect(this.d0, this.f2185h.f40112a, Path.Direction.CW);
        int i2 = this.j0 ^ 15;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if ((i2 & 1) != 0) {
            Path path = this.e0;
            float[] fArr = this.f2185h.f40112a;
            path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
        }
        if ((i2 & 2) != 0) {
            Path path2 = this.e0;
            float f2 = rectF.right;
            float[] fArr2 = this.f2185h.f40112a;
            path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
        }
        if ((i2 & 4) != 0) {
            Path path3 = this.e0;
            float f3 = rectF.bottom;
            float[] fArr3 = this.f2185h.f40112a;
            path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
        }
        if ((i2 & 8) != 0) {
            Path path4 = this.e0;
            float f4 = rectF.right;
            float[] fArr4 = this.f2185h.f40112a;
            float f5 = rectF.bottom;
            path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
        }
        if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
            canvas.clipPath(this.e0);
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
            if (this.j0 != 0 || getDrawCorner()) {
                setDrawerType(1);
                int i2 = this.j0 ^ 15;
                this.f0.set(0.0f, 0.0f, getWidth(), getHeight());
                if ((i2 & 1) != 0) {
                    float[] fArr = this.f2185h.f40112a;
                    canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.f2186i.f40098b);
                }
                if ((i2 & 2) != 0) {
                    float f2 = this.f0.right;
                    float[] fArr2 = this.f2185h.f40112a;
                    canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.f2186i.f40098b);
                }
                if ((i2 & 4) != 0) {
                    float f3 = this.f0.bottom;
                    float[] fArr3 = this.f2185h.f40112a;
                    canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.f2186i.f40098b);
                }
                if ((i2 & 8) != 0) {
                    RectF rectF = this.f0;
                    float f4 = rectF.right;
                    float[] fArr4 = this.f2185h.f40112a;
                    float f5 = rectF.bottom;
                    canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.f2186i.f40098b);
                }
            }
        }
    }

    public final void O(Canvas canvas) {
        if (this.N || getBdImage() != null) {
            if (this.j0 != 0 || getDrawBorder()) {
                setDrawerType(1);
                int i2 = this.j0 ^ 15;
                this.f0.set(0.0f, 0.0f, getWidth(), getHeight());
                this.f2186i.f40099c.setStrokeWidth(this.f2186i.f40099c.getStrokeWidth());
                if ((i2 & 1) != 0) {
                    canvas.drawLine(0.0f, 0.0f, this.f2185h.f40112a[0], 0.0f, this.f2186i.f40099c);
                    canvas.drawLine(0.0f, 0.0f, 0.0f, this.f2185h.f40112a[1], this.f2186i.f40099c);
                }
                if ((i2 & 2) != 0) {
                    float f2 = this.f0.right;
                    canvas.drawLine(f2 - this.f2185h.f40112a[2], 0.0f, f2, 0.0f, this.f2186i.f40099c);
                    float f3 = this.f0.right;
                    canvas.drawLine(f3, 0.0f, f3, this.f2185h.f40112a[3], this.f2186i.f40099c);
                }
                if ((i2 & 4) != 0) {
                    float f4 = this.f0.bottom;
                    canvas.drawLine(0.0f, f4 - this.f2185h.f40112a[5], 0.0f, f4, this.f2186i.f40099c);
                    float f5 = this.f0.bottom;
                    canvas.drawLine(0.0f, f5, this.f2185h.f40112a[4], f5, this.f2186i.f40099c);
                }
                if ((i2 & 8) != 0) {
                    RectF rectF = this.f0;
                    float f6 = rectF.right;
                    float f7 = rectF.bottom;
                    canvas.drawLine(f6 - this.f2185h.f40112a[6], f7, f6, f7, this.f2186i.f40099c);
                    RectF rectF2 = this.f0;
                    float f8 = rectF2.right;
                    float f9 = rectF2.bottom;
                    canvas.drawLine(f8, f9, f8, f9 - this.f2185h.f40112a[7], this.f2186i.f40099c);
                }
            }
        }
    }

    public final void P(d.a.c.j.d.a aVar) {
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
        d.a.c.j.d.a bdImage = getBdImage();
        if (!z3) {
            B();
            this.l = true;
            this.L = false;
            requestLayout();
        } else if (bdImage != null) {
            invalidate();
            this.l0 = bdImage.r();
            this.m0 = bdImage.m();
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
            eVar.f13797a = str;
            eVar.f13798b = i2;
            eVar.f13799c = System.currentTimeMillis();
            this.y.put(g2, eVar);
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                String g3 = d.a.c.e.l.d.h().g(str, i2);
                if (this.x.containsKey(g3)) {
                    return;
                }
                e eVar2 = new e();
                eVar2.f13797a = str;
                eVar2.f13798b = i2;
                this.x.put(g3, eVar2);
                return;
            }
            d.a.c.e.l.d.h().k(this.z, this.A, this.o0, i3, i4, this.v, new Object[0]);
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

    public void V(String str, int i2, boolean z) {
        R(str, i2, 0, 0, z);
    }

    public void W(String str, int i2, boolean z, boolean z2) {
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
        d.a.c.e.l.d.h().d(this.z, this.A, this.o0);
        this.y.remove(d.a.c.e.l.d.h().g(this.z, this.A));
        Z();
    }

    public void Z() {
        this.D = false;
        removeCallbacks(this);
        this.F = 0.0f;
        this.g0.reset();
        setExtraMatrix(this.g0);
        invalidate();
    }

    public final void a0() {
        boolean z = false;
        if (this.S) {
            this.f2185h.f40117f = (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true;
        } else {
            this.f2185h.f40117f = false;
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
            this.h0.j(TbadkCoreApplication.getInst().getSkinType());
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
        if (this.h0 == null || (eVar = this.f2185h) == null) {
            return;
        }
        if (eVar.f40120i && (this.K || H())) {
            this.h0.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
        } else if (this.f2185h.f40119h && I()) {
            this.h0.a(canvas, getContext().getString(R.string.icon_tag_long), true);
        } else {
            String str = this.i0;
            if (str != null) {
                this.h0.a(canvas, str, false);
            }
        }
        int i2 = this.f2185h.j;
        if (i2 == d.a.c.f.a.b.f40108c) {
            this.h0.b(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
        } else if (i2 == d.a.c.f.a.b.f40107b) {
            this.h0.b(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.c.j.d.a getBdImage() {
        d.a.c.j.d.a aVar;
        if (TextUtils.isEmpty(this.z)) {
            Object tag = getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                aVar = d.a.i0.a0.c.k().m(str);
                if (aVar == null) {
                    aVar = d.a.i0.a0.c.k().l(str);
                }
            } else {
                aVar = null;
            }
        } else {
            aVar = (d.a.c.j.d.a) d.a.c.e.l.d.h().n(this.z, this.A, new Object[0]);
        }
        if (aVar != null) {
            P(aVar);
        }
        return aVar;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.c.j.d.a getDefaultBdImage() {
        SoftReference<d.a.c.j.d.a> softReference;
        d.a.c.j.d.a aVar;
        if (v0 == null) {
            v0 = new HashMap<>();
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
        if (!v0.containsKey(valueOf) || (softReference = v0.get(valueOf)) == null || (aVar = softReference.get()) == null || !aVar.w()) {
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
            d.a.c.j.d.a aVar2 = new d.a.c.j.d.a(bitmap, false, String.valueOf(this.J));
            v0.put(valueOf, new SoftReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public boolean getDrawCorner() {
        return this.k0;
    }

    public int getGifIconHeight() {
        d.a.i0.b1.c cVar = this.h0;
        if (cVar != null) {
            return (int) cVar.d(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    public int getGifIconWidth() {
        d.a.i0.b1.c cVar = this.h0;
        if (cVar != null) {
            return (int) cVar.e(getContext().getString(R.string.icon_tag_gif));
        }
        return -1;
    }

    @Deprecated
    public int getLoadedHeight() {
        return this.m0;
    }

    @Deprecated
    public int getLoadedWidth() {
        return this.l0;
    }

    public View.OnClickListener getOnClickListener() {
        return this.W;
    }

    public float[] getRadius() {
        d.a.c.f.a.e eVar = this.f2185h;
        return eVar == null ? BDImageView.j(0.0f) : eVar.f40112a;
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
            CustomMessageListener customMessageListener = this.q0;
            BdUniqueId bdUniqueId = this.v;
            if (bdUniqueId == null) {
                bdUniqueId = a2.getUniqueId();
            }
            customMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.q0);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onClick(View view) {
        if (getBdImage() == null && getDrawable() == null && this.c0) {
            X();
            d.a.c.e.l.d.h().k(this.z, this.A, this.o0, this.B, this.C, this.v, new Object[0]);
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
        MessageManager.getInstance().unRegisterListener(this.q0);
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
                d.a.c.e.l.d.h().k(value.f13797a, value.f13798b, this.o0, this.B, this.C, this.v, new Object[0]);
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
            this.g0.reset();
            this.g0.postRotate(this.F, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.g0);
            invalidate();
            L();
        }
    }

    public void setAutoChangeStyle(boolean z) {
        this.S = z;
    }

    public void setConrers(int i2) {
        this.j0 = i2;
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
        this.k0 = z;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i2) {
        super.setDrawerType(i2);
        d.a.c.f.a.a aVar = this.f2186i;
        if (aVar == null) {
            return;
        }
        aVar.o(this.p0);
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
        super.setOnTouchListener(this.n0);
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
        this.q0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.q0);
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
        d.a.i0.b1.c cVar = this.h0;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void setTagPaddingDis(int i2, int i3) {
        d.a.i0.b1.c cVar = this.h0;
        if (cVar != null) {
            cVar.g(i2, i3);
        }
    }

    public void setTagStr(String str) {
        this.i0 = str;
    }

    public void setTagTextSize(int i2) {
        d.a.i0.b1.c cVar = this.h0;
        if (cVar != null) {
            cVar.i(i2);
        }
    }

    public void setTbGestureDetector(d.a.j0.d2.i.c cVar) {
        super.setOnTouchListener(this.n0);
        this.a0 = cVar;
    }

    public void z(int i2) {
        this.j0 = i2 | this.j0;
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
        this.d0 = new RectF();
        this.e0 = new Path();
        this.f0 = new RectF();
        this.g0 = new Matrix();
        this.k0 = false;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = new d.a.j0.d2.i.c(new a());
        this.o0 = new b();
        this.p0 = new c();
        this.q0 = new d(2016308);
        G();
    }
}

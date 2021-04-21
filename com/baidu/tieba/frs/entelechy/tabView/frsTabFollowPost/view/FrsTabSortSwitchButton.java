package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.j0.q0.c0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    public float A;
    public boolean B;
    public boolean C;
    public boolean D;
    public List<c0> E;
    public List<Float> F;
    public GestureDetector G;
    public GestureDetector.SimpleOnGestureListener H;
    public e I;
    public ValueAnimator J;
    public float K;
    public float L;
    public boolean M;

    /* renamed from: e  reason: collision with root package name */
    public float f15895e;

    /* renamed from: f  reason: collision with root package name */
    public float f15896f;

    /* renamed from: g  reason: collision with root package name */
    public float f15897g;

    /* renamed from: h  reason: collision with root package name */
    public int f15898h;
    public int i;
    public int j;
    public int k;
    public float l;
    public float m;
    public float n;
    public int o;
    public String p;
    public String q;
    public Paint r;
    public Paint s;
    public Paint t;
    public RectF u;
    public Path v;
    public RectF w;
    public Path x;
    public int y;
    public float z;

    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!FrsTabSortSwitchButton.this.C && motionEvent.getX() <= FrsTabSortSwitchButton.this.f15895e && motionEvent.getY() <= FrsTabSortSwitchButton.this.f15896f) {
                if (FrsTabSortSwitchButton.this.getParent() != null) {
                    FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (FrsTabSortSwitchButton.this.B) {
                FrsTabSortSwitchButton.this.z -= f2;
                if (FrsTabSortSwitchButton.this.z < 0.0f) {
                    FrsTabSortSwitchButton.this.z = 0.0f;
                }
                Float f4 = (Float) ListUtils.getItem(FrsTabSortSwitchButton.this.F, FrsTabSortSwitchButton.this.F.size() - 1);
                float floatValue = f4 != null ? f4.floatValue() : 0.0f;
                if (FrsTabSortSwitchButton.this.z > floatValue) {
                    FrsTabSortSwitchButton.this.z = floatValue;
                }
                FrsTabSortSwitchButton.this.invalidate();
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int i = FrsTabSortSwitchButton.this.y;
            FrsTabSortSwitchButton.this.z = motionEvent.getX();
            FrsTabSortSwitchButton frsTabSortSwitchButton = FrsTabSortSwitchButton.this;
            frsTabSortSwitchButton.y = frsTabSortSwitchButton.r();
            FrsTabSortSwitchButton.this.C = true;
            if (FrsTabSortSwitchButton.this.y != i) {
                FrsTabSortSwitchButton.this.D(i);
                if (FrsTabSortSwitchButton.this.J != null) {
                    FrsTabSortSwitchButton.this.J.start();
                }
                FrsTabSortSwitchButton.this.w(i);
            }
            FrsTabSortSwitchButton.this.C = false;
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.K;
            if (FrsTabSortSwitchButton.this.M) {
                FrsTabSortSwitchButton frsTabSortSwitchButton = FrsTabSortSwitchButton.this;
                frsTabSortSwitchButton.z = frsTabSortSwitchButton.L - floatValue;
            } else {
                FrsTabSortSwitchButton frsTabSortSwitchButton2 = FrsTabSortSwitchButton.this;
                frsTabSortSwitchButton2.z = frsTabSortSwitchButton2.L + floatValue;
            }
            FrsTabSortSwitchButton.this.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Float f2 = (Float) ListUtils.getItem(FrsTabSortSwitchButton.this.F, FrsTabSortSwitchButton.this.y);
            if (f2 != null) {
                FrsTabSortSwitchButton.this.z = f2.floatValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Comparator<FrsTabInfo> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            return frsTabInfo.tab_id.intValue() - frsTabInfo2.tab_id.intValue();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        boolean a(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public final void A() {
        this.u.set(0.0f, 0.0f, this.f15895e, this.f15896f);
        this.v.reset();
        Path path = this.v;
        RectF rectF = this.u;
        float f2 = this.f15896f;
        path.addRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, Path.Direction.CW);
        Float f3 = (Float) ListUtils.getItem(this.F, this.y);
        this.z = f3 != null ? f3.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.t.getFontMetrics();
        this.A = (this.f15896f / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
    }

    public final boolean B(List<FrsTabInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return true;
        }
        Collections.sort(list, new d());
        int size = list.size();
        if (size != this.E.size()) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            c0 c0Var = this.E.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != c0Var.f59482b) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !c0Var.f59481a.equals(this.p)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !c0Var.f59481a.equals(this.q)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                String str = frsTabInfo.tab_name;
                if (str != null && str.length() > 5) {
                    if (!c0Var.f59481a.equals(frsTabInfo.tab_name.substring(0, 5))) {
                        return true;
                    }
                } else if (!c0Var.f59481a.equals(frsTabInfo.tab_name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void C() {
        this.r.setColor(SkinManager.getColor(this.f15898h));
        invalidate();
    }

    public final void D(int i) {
        this.L = this.F.get(i).floatValue();
        this.K = Math.abs(this.F.get(this.y).floatValue() - this.L);
        this.M = this.y < i;
    }

    public final void E() {
        this.y = 0;
        this.z = 0.0f;
        this.C = false;
        this.E.clear();
        this.F.clear();
        this.D = true;
    }

    public int getState() {
        return this.y;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.clipPath(this.v);
        super.onDraw(canvas);
        canvas.drawPath(this.v, this.r);
        t(canvas);
        int i = 0;
        while (i < this.E.size()) {
            u(canvas, this.E.get(i).f59481a, this.F.get(i).floatValue() + this.m, this.A, this.y == i);
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        float size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int count = ListUtils.getCount(this.E);
        float f2 = 0.0f;
        if (mode == Integer.MIN_VALUE) {
            this.f15895e = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                c0 c0Var = (c0) ListUtils.getItem(this.E, i3);
                if (c0Var != null) {
                    Paint paint = this.t;
                    String str = c0Var.f59481a;
                    if (str == null) {
                        str = "";
                    }
                    float measureText = paint.measureText(str) + (this.m * 2.0f);
                    if (this.D) {
                        this.F.add(Float.valueOf(this.f15895e));
                    }
                    this.f15895e += measureText;
                }
            }
        } else {
            this.f15895e = size;
            if (count > 0) {
                size /= count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.D) {
                    this.F.add(Float.valueOf(f2));
                }
                f2 += size;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.f15896f = this.f15897g;
        } else {
            this.f15896f = size2;
            this.f15897g = size2;
        }
        this.D = false;
        A();
        setMeasuredDimension((int) this.f15895e, (int) this.f15896f);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.G.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.B && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.y;
            int r = r();
            if (Math.abs(r - i) >= 2 || r > i) {
                this.y = r;
            } else if (r < i) {
                float floatValue = this.F.get(r).floatValue();
                int i2 = r + 1;
                float floatValue2 = i2 < this.F.size() ? this.F.get(i2).floatValue() : floatValue;
                float f2 = this.z;
                if (f2 >= floatValue && f2 <= floatValue + ((floatValue2 - floatValue) / 2.0f)) {
                    this.y = r;
                }
            } else {
                float floatValue3 = this.F.get(r).floatValue();
                int i3 = r + 1;
                if (this.z >= floatValue3 + (((i3 < this.F.size() ? this.F.get(i3).floatValue() : floatValue3) - floatValue3) / 2.0f) && i3 < this.F.size()) {
                    this.y = i3;
                }
            }
            this.C = true;
            this.L = this.z;
            float floatValue4 = this.F.get(this.y).floatValue();
            this.K = Math.abs(this.L - floatValue4);
            int i4 = this.y;
            if (i4 < i) {
                this.M = true;
            } else if (i4 > i) {
                this.M = false;
            } else {
                this.M = this.L > floatValue4;
            }
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
            if (this.y != i) {
                w(i);
            }
            this.C = false;
            return true;
        }
        return false;
    }

    public final int r() {
        float floatValue;
        int i = this.y;
        int i2 = 0;
        while (i2 < this.F.size()) {
            float floatValue2 = ((Float) ListUtils.getItem(this.F, i2)).floatValue();
            int i3 = i2 + 1;
            if (i3 == this.F.size()) {
                floatValue = this.f15895e;
            } else {
                floatValue = ((Float) ListUtils.getItem(this.F, i3)).floatValue();
            }
            float f2 = this.z;
            if (f2 <= floatValue2 || f2 >= floatValue) {
                float f3 = this.z;
                if (f3 == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (f3 == floatValue && (i2 = i + 1) < ListUtils.getCount(this.F)) {
                }
                i2 = i3;
            }
            return i2;
        }
        return i;
    }

    public void s(int i) {
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            if (this.E.get(i2).f59482b == i) {
                this.y = i2;
                if (i2 < this.F.size()) {
                    this.z = this.F.get(i2).floatValue();
                }
                invalidate();
                return;
            }
        }
    }

    public void setCanScroll(boolean z) {
        this.B = z;
    }

    public void setData(List<FrsTabInfo> list) {
        if (B(list)) {
            E();
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                c0 c0Var = new c0();
                c0Var.f59482b = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        c0Var.f59481a = "最热";
                    } else {
                        c0Var.f59481a = this.p;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        c0Var.f59481a = "最新";
                    } else {
                        c0Var.f59481a = this.q;
                    }
                } else {
                    String str = list.get(i).tab_name;
                    c0Var.f59481a = str;
                    if (str == null) {
                        c0Var.f59481a = "";
                    } else if (str.length() > 5) {
                        c0Var.f59481a = c0Var.f59481a.substring(0, 5);
                    }
                }
                this.E.add(c0Var);
            }
            requestLayout();
        }
    }

    public void setOnSwitchChangeListener(e eVar) {
        this.I = eVar;
    }

    public final void t(Canvas canvas) {
        float f2;
        if (this.z < 0.0f) {
            this.z = 0.0f;
        }
        float floatValue = !ListUtils.isEmpty(this.F) ? ((Float) ListUtils.getItem(this.F, this.y)).floatValue() : 0.0f;
        if (this.y + 1 < this.F.size()) {
            f2 = this.F.get(this.y + 1).floatValue();
        } else {
            f2 = this.y + 1 == this.F.size() ? this.f15895e : 0.0f;
        }
        float f3 = this.z + (f2 - floatValue);
        float f4 = this.f15895e;
        if (f3 > f4) {
            f3 = f4;
        }
        this.w.set(this.z, 0.0f, f3, this.f15896f);
        this.x.reset();
        Path path = this.x;
        RectF rectF = this.w;
        float f5 = this.f15897g;
        path.addRoundRect(rectF, f5 / 2.0f, f5 / 2.0f, Path.Direction.CW);
        this.s.reset();
        this.s.setAntiAlias(true);
        this.s.setColor(SkinManager.getColor(this.i));
        canvas.drawPath(this.x, this.s);
        this.s.reset();
        this.s.setAntiAlias(true);
        this.s.setColor(SkinManager.getColor(this.o));
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(this.n);
        RectF rectF2 = this.w;
        float f6 = this.z;
        float f7 = this.n;
        rectF2.set(f6 + (f7 / 2.0f), f7 / 2.0f, f3 - (f7 / 2.0f), this.f15897g - (f7 / 2.0f));
        float f8 = (this.f15897g - this.n) / 2.0f;
        canvas.drawRoundRect(this.w, f8, f8, this.s);
    }

    public final void u(Canvas canvas, String str, float f2, float f3, boolean z) {
        if (z) {
            this.t.setColor(SkinManager.getColor(this.k));
        } else {
            this.t.setColor(SkinManager.getColor(this.j));
        }
        canvas.drawText(str, f2, f3, this.t);
    }

    public int v(int i) {
        c0 c0Var = (c0) ListUtils.getItem(this.E, i);
        if (c0Var == null) {
            return -1;
        }
        return c0Var.f59482b;
    }

    public final void w(int i) {
        e eVar = this.I;
        if (eVar == null || eVar.a(this.y)) {
            return;
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.y = i;
        this.z = this.F.get(i).floatValue();
        invalidate();
    }

    public final void x(Context context) {
        this.u = new RectF();
        this.v = new Path();
        this.w = new RectF();
        this.x = new Path();
        Paint paint = new Paint(1);
        this.r = paint;
        paint.setColor(SkinManager.getColor(this.f15898h));
        this.s = new Paint(1);
        Paint paint2 = new Paint(1);
        this.t = paint2;
        paint2.setTextSize(this.l);
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.y = 0;
        this.G = new GestureDetector(context, this.H);
        this.p = getResources().getString(R.string.reply_post_frs);
        this.q = getResources().getString(R.string.send_post);
        y();
    }

    public final void y() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.J = duration;
        duration.addUpdateListener(new b());
        this.J.addListener(new c());
    }

    public final void z(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FrsTabSortSwitchButton);
        this.f15898h = obtainStyledAttributes.getResourceId(R$styleable.FrsTabSortSwitchButton_background_color, R.color.CAM_X0107);
        this.i = obtainStyledAttributes.getResourceId(R$styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.j = obtainStyledAttributes.getResourceId(R$styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.k = obtainStyledAttributes.getResourceId(R$styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.l = obtainStyledAttributes.getDimension(R$styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.m = obtainStyledAttributes.getDimension(R$styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.f15897g = obtainStyledAttributes.getDimension(R$styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.n = obtainStyledAttributes.getDimension(R$styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.o = obtainStyledAttributes.getResourceId(R$styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = false;
        this.C = false;
        this.D = true;
        this.H = new a();
        z(context, attributeSet);
        x(context);
        setOnTouchListener(this);
    }
}

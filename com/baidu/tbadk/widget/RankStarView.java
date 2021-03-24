package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class RankStarView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f14073e;

    /* renamed from: f  reason: collision with root package name */
    public float f14074f;

    /* renamed from: g  reason: collision with root package name */
    public int f14075g;

    /* renamed from: h  reason: collision with root package name */
    public int f14076h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Drawable n;
    public Drawable o;
    public Rect p;
    public Rect q;
    public boolean r;
    public int s;
    public a t;

    /* loaded from: classes3.dex */
    public interface a {
        void a(float f2);
    }

    public RankStarView(Context context) {
        super(context);
        this.f14073e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }

    public final void a(Canvas canvas) {
        float f2;
        if (this.n == null || this.o == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i = 0;
        while (true) {
            f2 = this.f14074f;
            if (i >= f2) {
                break;
            }
            Drawable drawable = this.o;
            int paddingTop = getPaddingTop();
            int i2 = this.f14076h;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i2, i2 + getPaddingTop());
            this.o.draw(canvas);
            paddingLeft += this.f14075g + this.f14076h;
            i++;
        }
        if (f2 - ((int) f2) <= 0.0f) {
            for (int i3 = (int) f2; i3 < this.f14073e; i3++) {
                Drawable drawable2 = this.n;
                int paddingTop2 = getPaddingTop();
                int i4 = this.f14076h;
                drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i4, i4 + getPaddingTop());
                this.n.draw(canvas);
                paddingLeft += this.f14075g + this.f14076h;
            }
            return;
        }
        int i5 = (int) f2;
        while (true) {
            i5++;
            if (i5 >= this.f14073e) {
                return;
            }
            Drawable drawable3 = this.n;
            int paddingTop3 = getPaddingTop();
            int i6 = this.f14076h;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i6, i6 + getPaddingTop());
            this.n.draw(canvas);
            paddingLeft += this.f14075g + this.f14076h;
        }
    }

    public final void b(Canvas canvas) {
        float f2;
        int i;
        int i2;
        int paddingLeft = getPaddingLeft();
        int i3 = 0;
        while (true) {
            f2 = this.f14074f;
            if (i3 >= ((int) f2)) {
                break;
            }
            Drawable drawable = this.o;
            int paddingTop = getPaddingTop();
            int i4 = this.f14076h;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i4, i4 + getPaddingTop());
            this.o.draw(canvas);
            paddingLeft += this.f14075g + this.f14076h;
            i3++;
        }
        if (f2 - ((int) f2) >= 0.5d) {
            Drawable drawable2 = this.o;
            int paddingTop2 = getPaddingTop();
            int i5 = this.f14076h;
            drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i5, i5 + getPaddingTop());
            this.o.draw(canvas);
            i = this.f14075g;
            i2 = this.f14076h;
        } else if (f2 - ((int) f2) > 0.0f) {
            Drawable drawable3 = this.o;
            int paddingTop3 = getPaddingTop();
            int i6 = this.f14076h;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i6, i6 + getPaddingTop());
            canvas.save();
            Rect rect = this.p;
            int paddingTop4 = getPaddingTop();
            int i7 = this.f14076h;
            rect.set(paddingLeft, paddingTop4, (i7 / 2) + paddingLeft, i7 + getPaddingTop());
            canvas.clipRect(this.p);
            this.o.draw(canvas);
            canvas.restore();
            Drawable drawable4 = this.n;
            int paddingTop5 = getPaddingTop();
            int i8 = this.f14076h;
            drawable4.setBounds(paddingLeft, paddingTop5, paddingLeft + i8, i8 + getPaddingTop());
            canvas.save();
            int paddingTop6 = getPaddingTop();
            int i9 = this.f14076h;
            this.q.set((this.f14076h / 2) + paddingLeft, paddingTop6, paddingLeft + i9, i9 + getPaddingTop());
            canvas.clipRect(this.q);
            this.n.draw(canvas);
            canvas.restore();
            i = this.f14075g;
            i2 = this.f14076h;
        } else {
            Drawable drawable5 = this.n;
            int paddingTop7 = getPaddingTop();
            int i10 = this.f14076h;
            drawable5.setBounds(paddingLeft, paddingTop7, paddingLeft + i10, i10 + getPaddingTop());
            this.n.draw(canvas);
            i = this.f14075g;
            i2 = this.f14076h;
        }
        int i11 = paddingLeft + i + i2;
        int i12 = (int) this.f14074f;
        while (true) {
            i12++;
            if (i12 >= this.f14073e) {
                return;
            }
            Drawable drawable6 = this.n;
            int paddingTop8 = getPaddingTop();
            int i13 = this.f14076h;
            drawable6.setBounds(i11, paddingTop8, i11 + i13, i13 + getPaddingTop());
            this.n.draw(canvas);
            i11 += this.f14075g + this.f14076h;
        }
    }

    public boolean c() {
        return this.f14074f != 0.0f;
    }

    public final void d(Context context) {
        this.f14076h = l.g(context, R.dimen.tbds63);
        this.p = new Rect(0, 0, 0, 0);
        this.q = new Rect(0, 0, 0, 0);
        f();
    }

    public void e(int i) {
        if (this.s != i) {
            this.s = i;
            f();
        }
    }

    public void f() {
        this.n = SvgManager.getInstance().getPureDrawable(this.j, this.k, null);
        this.o = SvgManager.getInstance().getPureDrawable(this.l, this.m, null);
    }

    public int getStarCount() {
        float f2 = this.f14074f;
        if (f2 == 0.0f) {
            return 0;
        }
        double d2 = f2;
        Double.isNaN(d2);
        return d2 % 1.0d == 0.0d ? (int) f2 : ((int) f2) + 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.n == null || this.o == null) {
            return;
        }
        if (this.r) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            this.f14076h = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.f14076h + getPaddingBottom() + getPaddingTop();
        }
        int i3 = this.f14076h;
        int i4 = this.f14073e;
        int i5 = (i3 * i4) + (this.f14075g * (i4 - 1));
        this.i = i5;
        if (mode != 1073741824) {
            size = getPaddingRight() + i5 + getPaddingLeft();
        } else if (size < i5) {
            this.i = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.i + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.i) * this.f14073e);
        }
        return onTouchEvent;
    }

    public void setIsHalfStar(boolean z) {
        this.r = z;
    }

    public void setStarChangListener(a aVar) {
        this.t = aVar;
    }

    public void setStarCount(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        int i = this.f14073e;
        if (f2 > i) {
            f2 = i;
        }
        if (this.f14074f != f2) {
            this.f14074f = f2;
            invalidate();
        }
        a aVar = this.t;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        f();
    }

    public void setStarSpacing(int i) {
        this.f14075g = i;
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14073e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14073e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }
}

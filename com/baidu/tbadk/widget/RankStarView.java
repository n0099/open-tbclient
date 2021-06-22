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
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class RankStarView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f13144e;

    /* renamed from: f  reason: collision with root package name */
    public float f13145f;

    /* renamed from: g  reason: collision with root package name */
    public int f13146g;

    /* renamed from: h  reason: collision with root package name */
    public int f13147h;

    /* renamed from: i  reason: collision with root package name */
    public int f13148i;
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
        this.f13144e = 5;
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
        int i2 = 0;
        while (true) {
            f2 = this.f13145f;
            if (i2 >= f2) {
                break;
            }
            Drawable drawable = this.o;
            int paddingTop = getPaddingTop();
            int i3 = this.f13147h;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i3, i3 + getPaddingTop());
            this.o.draw(canvas);
            paddingLeft += this.f13146g + this.f13147h;
            i2++;
        }
        if (f2 - ((int) f2) <= 0.0f) {
            for (int i4 = (int) f2; i4 < this.f13144e; i4++) {
                Drawable drawable2 = this.n;
                int paddingTop2 = getPaddingTop();
                int i5 = this.f13147h;
                drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i5, i5 + getPaddingTop());
                this.n.draw(canvas);
                paddingLeft += this.f13146g + this.f13147h;
            }
            return;
        }
        int i6 = (int) f2;
        while (true) {
            i6++;
            if (i6 >= this.f13144e) {
                return;
            }
            Drawable drawable3 = this.n;
            int paddingTop3 = getPaddingTop();
            int i7 = this.f13147h;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i7, i7 + getPaddingTop());
            this.n.draw(canvas);
            paddingLeft += this.f13146g + this.f13147h;
        }
    }

    public final void b(Canvas canvas) {
        float f2;
        int i2;
        int i3;
        int paddingLeft = getPaddingLeft();
        int i4 = 0;
        while (true) {
            f2 = this.f13145f;
            if (i4 >= ((int) f2)) {
                break;
            }
            Drawable drawable = this.o;
            int paddingTop = getPaddingTop();
            int i5 = this.f13147h;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i5, i5 + getPaddingTop());
            this.o.draw(canvas);
            paddingLeft += this.f13146g + this.f13147h;
            i4++;
        }
        if (f2 - ((int) f2) >= 0.5d) {
            Drawable drawable2 = this.o;
            int paddingTop2 = getPaddingTop();
            int i6 = this.f13147h;
            drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i6, i6 + getPaddingTop());
            this.o.draw(canvas);
            i2 = this.f13146g;
            i3 = this.f13147h;
        } else if (f2 - ((int) f2) > 0.0f) {
            Drawable drawable3 = this.o;
            int paddingTop3 = getPaddingTop();
            int i7 = this.f13147h;
            drawable3.setBounds(paddingLeft, paddingTop3, paddingLeft + i7, i7 + getPaddingTop());
            canvas.save();
            Rect rect = this.p;
            int paddingTop4 = getPaddingTop();
            int i8 = this.f13147h;
            rect.set(paddingLeft, paddingTop4, (i8 / 2) + paddingLeft, i8 + getPaddingTop());
            canvas.clipRect(this.p);
            this.o.draw(canvas);
            canvas.restore();
            Drawable drawable4 = this.n;
            int paddingTop5 = getPaddingTop();
            int i9 = this.f13147h;
            drawable4.setBounds(paddingLeft, paddingTop5, paddingLeft + i9, i9 + getPaddingTop());
            canvas.save();
            int paddingTop6 = getPaddingTop();
            int i10 = this.f13147h;
            this.q.set((this.f13147h / 2) + paddingLeft, paddingTop6, paddingLeft + i10, i10 + getPaddingTop());
            canvas.clipRect(this.q);
            this.n.draw(canvas);
            canvas.restore();
            i2 = this.f13146g;
            i3 = this.f13147h;
        } else {
            Drawable drawable5 = this.n;
            int paddingTop7 = getPaddingTop();
            int i11 = this.f13147h;
            drawable5.setBounds(paddingLeft, paddingTop7, paddingLeft + i11, i11 + getPaddingTop());
            this.n.draw(canvas);
            i2 = this.f13146g;
            i3 = this.f13147h;
        }
        int i12 = paddingLeft + i2 + i3;
        int i13 = (int) this.f13145f;
        while (true) {
            i13++;
            if (i13 >= this.f13144e) {
                return;
            }
            Drawable drawable6 = this.n;
            int paddingTop8 = getPaddingTop();
            int i14 = this.f13147h;
            drawable6.setBounds(i12, paddingTop8, i12 + i14, i14 + getPaddingTop());
            this.n.draw(canvas);
            i12 += this.f13146g + this.f13147h;
        }
    }

    public boolean c() {
        return this.f13145f != 0.0f;
    }

    public final void d(Context context) {
        this.f13147h = l.g(context, R.dimen.tbds63);
        this.p = new Rect(0, 0, 0, 0);
        this.q = new Rect(0, 0, 0, 0);
        f();
    }

    public void e(int i2) {
        if (this.s != i2) {
            this.s = i2;
            f();
        }
    }

    public void f() {
        this.n = SvgManager.getInstance().getPureDrawable(this.j, this.k, null);
        this.o = SvgManager.getInstance().getPureDrawable(this.l, this.m, null);
    }

    public int getStarCount() {
        float f2 = this.f13145f;
        if (f2 == 0.0f) {
            return 0;
        }
        return ((double) f2) % 1.0d == 0.0d ? (int) f2 : ((int) f2) + 1;
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
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == 1073741824) {
            this.f13147h = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.f13147h + getPaddingBottom() + getPaddingTop();
        }
        int i4 = this.f13147h;
        int i5 = this.f13144e;
        int i6 = (i4 * i5) + (this.f13146g * (i5 - 1));
        this.f13148i = i6;
        if (mode != 1073741824) {
            size = getPaddingRight() + i6 + getPaddingLeft();
        } else if (size < i6) {
            this.f13148i = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.f13148i + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.f13148i) * this.f13144e);
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
        int i2 = this.f13144e;
        if (f2 > i2) {
            f2 = i2;
        }
        if (this.f13145f != f2) {
            this.f13145f = f2;
            invalidate();
        }
        a aVar = this.t;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    public void setStarResource(@DrawableRes int i2, @ColorRes int i3, @DrawableRes int i4, @ColorRes int i5) {
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        f();
    }

    public void setStarSpacing(int i2) {
        this.f13146g = i2;
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13144e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13144e = 5;
        this.j = R.drawable.icon_pure_evaluation_star24_n;
        this.k = R.color.CAM_X0112;
        this.l = R.drawable.icon_pure_evaluation_star24_n;
        this.m = R.color.CAM_X0305;
        this.s = 3;
        d(context);
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class ItemTableRowView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f16778e;

    /* renamed from: f  reason: collision with root package name */
    public int f16779f;

    /* renamed from: g  reason: collision with root package name */
    public float f16780g;

    /* renamed from: h  reason: collision with root package name */
    public int f16781h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Drawable n;
    public Drawable o;
    public RectF p;
    public Paint q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public static final int x = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    public static final int y = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    public static final int z = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    public static final int A = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    public static final int B = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    public static final int C = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    public static final int D = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public void a() {
        this.f16780g = 0.0f;
    }

    public final void b() {
        this.i = x;
        this.f16781h = y;
        this.r = z;
        this.s = A;
        this.t = B;
        this.w = C;
        d();
        this.p = new RectF();
        this.q = new Paint(1);
    }

    public void c() {
        d();
        invalidate();
    }

    public void d() {
        this.n = SvgManager.getInstance().getPureDrawable(this.k, this.l, null);
        this.o = SvgManager.getInstance().getPureDrawable(this.k, this.m, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.n == null || this.o == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int i2 = 0;
        while (true) {
            i = this.f16778e;
            if (i2 >= i) {
                break;
            }
            Drawable drawable = this.n;
            int paddingTop = getPaddingTop();
            int i3 = this.i;
            drawable.setBounds(paddingLeft, paddingTop, paddingLeft + i3, i3 + getPaddingTop());
            this.n.draw(canvas);
            paddingLeft += this.f16781h + this.i;
            i2++;
        }
        while (i < this.f16779f) {
            Drawable drawable2 = this.o;
            int paddingTop2 = getPaddingTop();
            int i4 = this.i;
            drawable2.setBounds(paddingLeft, paddingTop2, paddingLeft + i4, i4 + getPaddingTop());
            this.o.draw(canvas);
            paddingLeft += this.f16781h + this.i;
            i++;
        }
        int i5 = (paddingLeft - this.f16781h) + this.w;
        float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.s) / 2;
        float f2 = i5;
        this.p.set(f2, measuredHeight, getMeasuredWidth(), this.s + measuredHeight);
        this.q.setColor(SkinManager.getColor(this.u));
        RectF rectF = this.p;
        int i6 = this.t;
        canvas.drawRoundRect(rectF, i6, i6, this.q);
        this.q.setColor(SkinManager.getColor(this.v));
        this.p.set(f2, measuredHeight, ((getMeasuredWidth() - i5) * this.f16780g) + f2, this.s + measuredHeight);
        RectF rectF2 = this.p;
        int i7 = this.t;
        canvas.drawRoundRect(rectF2, i7, i7, this.q);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            int paddingBottom = (size2 - getPaddingBottom()) - getPaddingTop();
            this.i = paddingBottom;
            this.s = Math.max(0, paddingBottom - D);
        } else {
            size2 = this.i + getPaddingBottom() + getPaddingTop();
        }
        int i3 = this.i;
        int i4 = this.f16779f;
        int i5 = (i3 * i4) + (this.f16781h * (i4 - 1));
        this.j = i5;
        if (mode != 1073741824) {
            size = this.w + i5 + getPaddingLeft() + getPaddingRight() + this.r;
        } else if (size < i5) {
            this.r = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.j) - this.w);
        }
        setMeasuredDimension(size, size2);
    }

    public void setData(float f2) {
        this.f16780g = f2;
    }

    public void setEmptyStartCount(int i) {
        this.f16778e = i;
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16779f = 5;
        this.k = R.drawable.icon_pure_evaluation_star24_n;
        this.l = 17170445;
        this.m = R.color.CAM_X0109;
        this.u = R.color.CAM_X0210;
        this.v = R.color.CAM_X0305;
        b();
    }
}

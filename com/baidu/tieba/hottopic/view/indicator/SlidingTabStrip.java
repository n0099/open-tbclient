package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SlidingTabStrip extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public final int f17392e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f17393f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f17394g;

    /* renamed from: h  reason: collision with root package name */
    public int f17395h;
    public int i;
    public int j;

    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    public final void a(int i, float f2) {
        View childAt = getChildAt(i);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds64);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        if (i == 0) {
            this.i = childAt.getLeft();
        } else {
            this.i = childAt.getLeft() + dimensionPixelSize2;
        }
        this.j = this.i + dimensionPixelSize;
        if (f2 < 0.0f || i >= getChildCount() - 1) {
            return;
        }
        View childAt2 = getChildAt(i + 1);
        float f3 = 1.0f - f2;
        this.i = (int) (((childAt2.getLeft() + dimensionPixelSize2) * f2) + (this.i * f3));
        this.j = (int) ((f2 * (childAt2.getLeft() + dimensionPixelSize2 + dimensionPixelSize)) + (f3 * this.j));
    }

    public void b(int i, float f2) {
        a(i, f2);
        invalidate();
    }

    public final void c(Canvas canvas, int i) {
        int i2;
        if (this.j <= 0 && (i2 = this.f17395h) >= 0 && i2 < getChildCount()) {
            this.j = getChildAt(this.f17395h).getRight() - getResources().getDimensionPixelSize(R.dimen.ds14);
        }
        canvas.drawRoundRect(new RectF(this.i, i - this.f17392e, this.j, i), 10.0f, 10.0f, this.f17393f);
    }

    public void d(int i) {
        this.f17393f.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
        this.f17394g.setColor(SkinManager.getColor(R.color.CAM_X0204));
        invalidate();
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                tabItemView.a();
                if (i2 == this.f17395h) {
                    SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
                }
            }
        }
    }

    public void e(int i, float f2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds14);
        View childAt = getChildAt(i);
        View childAt2 = getChildAt(this.f17395h);
        int left = childAt.getLeft();
        float left2 = (childAt2.getLeft() - left) * f2;
        if (this.f17395h == 0) {
            this.i = (int) (left + left2);
        } else {
            this.i = (int) (left + left2 + dimensionPixelSize);
        }
        this.j = this.i + getResources().getDimensionPixelSize(R.dimen.ds64);
        invalidate();
    }

    public void f(int i, int i2) {
        if (i == i2) {
            return;
        }
        this.f17395h = i;
        int childCount = getChildCount();
        if (i >= 0 && i < childCount) {
            View childAt = getChildAt(i);
            if (childAt instanceof TabItemView) {
                SkinManager.setViewTextColor(((TabItemView) childAt).getTextView(), R.color.CAM_X0105, 1);
            }
        }
        if (i2 < 0 || i2 >= childCount) {
            return;
        }
        View childAt2 = getChildAt(i2);
        if (childAt2 instanceof TabItemView) {
            SkinManager.setViewTextColor(((TabItemView) childAt2).getTextView(), R.color.CAM_X0107, 1);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        int childCount = getChildCount();
        if (canvas == null || childCount <= 0) {
            return;
        }
        c(canvas, getHeight());
    }

    public void setDrawBottomLine(boolean z) {
        invalidate();
    }

    public SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        this.f17392e = getResources().getDimensionPixelSize(R.dimen.ds5);
        Paint paint = new Paint();
        this.f17393f = paint;
        paint.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
        Paint paint2 = new Paint();
        this.f17394g = paint2;
        paint2.setColor(SkinManager.getColor(R.color.CAM_X0204));
    }
}

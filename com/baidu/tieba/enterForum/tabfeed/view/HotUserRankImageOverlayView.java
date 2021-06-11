package com.baidu.tieba.enterForum.tabfeed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.List;
/* loaded from: classes4.dex */
public class HotUserRankImageOverlayView extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public int f14620e;

    /* renamed from: f  reason: collision with root package name */
    public int f14621f;

    /* renamed from: g  reason: collision with root package name */
    public int f14622g;

    /* renamed from: h  reason: collision with root package name */
    public int f14623h;

    /* renamed from: i  reason: collision with root package name */
    public int f14624i;
    public int j;
    public ImageOverlayView.a k;
    public int l;
    public boolean m;
    public Paint n;
    public int o;
    public int p;

    public HotUserRankImageOverlayView(Context context) {
        super(context);
        this.l = 10;
        this.m = false;
        this.p = 1;
        c();
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f14620e = i2;
        this.f14621f = i3;
        this.f14622g = i4;
        this.f14623h = i5;
        this.f14624i = i6;
        this.j = i7;
        b();
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f14620e; i2++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f14621f, this.f14622g));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setAutoChangeStyle(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setPlaceHolder(1);
            addView(headImageView);
        }
    }

    public final void c() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStyle(Paint.Style.STROKE);
    }

    public void d() {
        this.n.setColor(SkinManager.getColor(this.f14624i));
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof HeadImageView) {
                ((HeadImageView) childAt).setPlaceHolder(1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.n.setColor(SkinManager.getColor(this.f14624i));
        this.n.setStrokeWidth(this.f14623h);
        int i2 = this.o;
        if (i2 <= 0) {
            i2 = this.f14624i;
        }
        this.o = i2;
        float f2 = this.f14623h * 0.5f;
        float f3 = this.f14621f / 2.0f;
        float acos = ((float) ((Math.acos((((f3 * 2.0f) - this.j) / 2.0f) / f3) / 3.141592653589793d) * 180.0d)) - 180.0f;
        float abs = Math.abs(2.0f * acos);
        int i3 = 0;
        int childCount = this.m ? 0 : getChildCount() - 1;
        while (i3 < getChildCount()) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                float left = childAt.getLeft() - f2;
                float top = childAt.getTop() - f2;
                float right = childAt.getRight() + f2;
                float bottom = childAt.getBottom() + f2;
                if (i3 == childCount) {
                    this.n.setColor(SkinManager.getColor(this.o));
                } else {
                    this.n.setColor(SkinManager.getColor(this.f14624i));
                }
                canvas.drawArc(left, top, right, bottom, i3 == childCount ? 0.0f : acos, i3 == childCount ? 360.0f : abs, false, this.n);
            }
            i3++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt;
        int paddingLeft = getPaddingLeft() + ((this.f14620e - 1) * (this.f14621f - this.j)) + this.f14623h;
        int paddingTop = getPaddingTop() + this.f14623h;
        for (int i6 = 0; i6 < this.f14620e && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            childAt.layout(paddingLeft, paddingTop, this.f14621f + paddingLeft, this.f14622g + paddingTop);
            paddingLeft -= this.f14621f - this.j;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.f14623h;
        if (this.p == 1) {
            i4 *= 2;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + i4;
        int i5 = this.f14620e;
        setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f14621f * i5)) - ((i5 - 1) * this.j), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f14622g + (this.f14623h * 2), i3));
    }

    public void setData(List<String> list) {
        String str;
        boolean z;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = this.f14620e - 1; i2 >= 0; i2--) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i2);
            if (headImageView == null) {
                return;
            }
            if (list.size() > 0) {
                str = list.remove(0);
                z = true;
            } else {
                str = null;
                z = false;
            }
            if (!z) {
                headImageView.setVisibility(4);
            } else {
                headImageView.setVisibility(0);
                if (this.l == 12) {
                    headImageView.R(str, 12, this.f14621f, this.f14622g, false);
                } else {
                    headImageView.R(str, 10, this.f14621f, this.f14622g, false);
                }
            }
        }
    }

    public void setFirstImageStrokeColor(@ColorRes int i2) {
        this.o = i2;
    }

    public void setImageClickListener(ImageOverlayView.a aVar) {
        this.k = aVar;
    }

    public void setLoadImageType(int i2) {
        this.l = i2;
    }

    public void setStrokeStyle(int i2) {
        this.p = i2;
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 10;
        this.m = false;
        this.p = 1;
        c();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = 10;
        this.m = false;
        this.p = 1;
        c();
    }
}

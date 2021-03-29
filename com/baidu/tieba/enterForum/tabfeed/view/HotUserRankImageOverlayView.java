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
    public int f15539e;

    /* renamed from: f  reason: collision with root package name */
    public int f15540f;

    /* renamed from: g  reason: collision with root package name */
    public int f15541g;

    /* renamed from: h  reason: collision with root package name */
    public int f15542h;
    public int i;
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

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f15539e = i;
        this.f15540f = i2;
        this.f15541g = i3;
        this.f15542h = i4;
        this.i = i5;
        this.j = i6;
        b();
    }

    public final void b() {
        for (int i = 0; i < this.f15539e; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f15540f, this.f15541g));
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
        this.n.setColor(SkinManager.getColor(this.i));
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof HeadImageView) {
                ((HeadImageView) childAt).setPlaceHolder(1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.n.setColor(SkinManager.getColor(this.i));
        this.n.setStrokeWidth(this.f15542h);
        int i = this.o;
        if (i <= 0) {
            i = this.i;
        }
        this.o = i;
        float f2 = this.f15542h * 0.5f;
        float f3 = this.f15540f / 2.0f;
        float acos = ((float) ((Math.acos((((f3 * 2.0f) - this.j) / 2.0f) / f3) / 3.141592653589793d) * 180.0d)) - 180.0f;
        float abs = Math.abs(2.0f * acos);
        int i2 = 0;
        int childCount = this.m ? 0 : getChildCount() - 1;
        while (i2 < getChildCount()) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof HeadImageView) && childAt.getVisibility() == 0) {
                float left = childAt.getLeft() - f2;
                float top = childAt.getTop() - f2;
                float right = childAt.getRight() + f2;
                float bottom = childAt.getBottom() + f2;
                if (i2 == childCount) {
                    this.n.setColor(SkinManager.getColor(this.o));
                } else {
                    this.n.setColor(SkinManager.getColor(this.i));
                }
                canvas.drawArc(left, top, right, bottom, i2 == childCount ? 0.0f : acos, i2 == childCount ? 360.0f : abs, false, this.n);
            }
            i2++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = getPaddingLeft() + ((this.f15539e - 1) * (this.f15540f - this.j)) + this.f15542h;
        int paddingTop = getPaddingTop() + this.f15542h;
        for (int i5 = 0; i5 < this.f15539e && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.f15540f + paddingLeft, this.f15541g + paddingTop);
            paddingLeft -= this.f15540f - this.j;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.f15542h;
        if (this.p == 1) {
            i3 *= 2;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
        int i4 = this.f15539e;
        setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f15540f * i4)) - ((i4 - 1) * this.j), i), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f15541g + (this.f15542h * 2), i2));
    }

    public void setData(List<String> list) {
        String str;
        boolean z;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        for (int i = this.f15539e - 1; i >= 0; i--) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
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
                    headImageView.T(str, 12, this.f15540f, this.f15541g, false);
                } else {
                    headImageView.T(str, 10, this.f15540f, this.f15541g, false);
                }
            }
        }
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.o = i;
    }

    public void setImageClickListener(ImageOverlayView.a aVar) {
        this.k = aVar;
    }

    public void setLoadImageType(int i) {
        this.l = i;
    }

    public void setStrokeStyle(int i) {
        this.p = i;
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 10;
        this.m = false;
        this.p = 1;
        c();
    }

    public HotUserRankImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 10;
        this.m = false;
        this.p = 1;
        c();
    }
}

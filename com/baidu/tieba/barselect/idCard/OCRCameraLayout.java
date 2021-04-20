package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R$styleable;
/* loaded from: classes4.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int p = 0;
    public static int q = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f14849e;

    /* renamed from: f  reason: collision with root package name */
    public View f14850f;

    /* renamed from: g  reason: collision with root package name */
    public View f14851g;

    /* renamed from: h  reason: collision with root package name */
    public View f14852h;
    public View i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Rect n;
    public Paint o;

    public OCRCameraLayout(Context context) {
        super(context);
        this.f14849e = p;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.OCRCameraLayout, 0, 0);
        try {
            this.j = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_contentView, -1);
            this.k = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_centerView, -1);
            this.l = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_leftDownView, -1);
            this.m = obtainStyledAttributes.getResourceId(R$styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f14850f = findViewById(this.j);
        int i = this.k;
        if (i != -1) {
            this.f14851g = findViewById(i);
        }
        this.f14852h = findViewById(this.l);
        this.i = findViewById(this.m);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.n, this.o);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14852h.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.f14850f.layout(i, i2, i3, i5);
            Rect rect = this.n;
            rect.left = 0;
            rect.top = i5;
            rect.right = width;
            rect.bottom = height;
            View view = this.f14851g;
            if (view != null) {
                int measuredWidth = (width - view.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.f14851g.getMeasuredHeight()) / 2) + i5;
                View view2 = this.f14851g;
                view2.layout(measuredWidth, measuredHeight, view2.getMeasuredWidth() + measuredWidth, this.f14851g.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.f14852h.getMeasuredHeight()) / 2) + i5;
            View view3 = this.f14852h;
            view3.layout(i7, measuredHeight2, view3.getMeasuredWidth() + i7, this.f14852h.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.i.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = i5 + ((i6 - this.i.getMeasuredHeight()) / 2);
            View view4 = this.i;
            view4.layout(measuredWidth2, measuredHeight3, view4.getMeasuredWidth() + measuredWidth2, this.i.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.f14850f.layout(i, i2, i8, height);
        Rect rect2 = this.n;
        rect2.left = i8;
        rect2.top = 0;
        rect2.right = width;
        rect2.bottom = height;
        View view5 = this.f14851g;
        if (view5 != null) {
            int measuredWidth3 = ((i9 - view5.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.f14851g.getMeasuredHeight()) / 2;
            View view6 = this.f14851g;
            view6.layout(measuredWidth3, measuredHeight4, view6.getMeasuredWidth() + measuredWidth3, this.f14851g.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.f14852h.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.f14852h.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        View view7 = this.f14852h;
        view7.layout(measuredWidth4, measuredHeight5, view7.getMeasuredWidth() + measuredWidth4, this.f14852h.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = i8 + ((i9 - this.i.getMeasuredWidth()) / 2);
        int i10 = marginLayoutParams2.topMargin;
        View view8 = this.i;
        view8.layout(measuredWidth5, i10, view8.getMeasuredWidth() + measuredWidth5, this.i.getMeasuredHeight() + i10);
    }

    public void setOrientation(int i) {
        if (this.f14849e == i) {
            return;
        }
        this.f14849e = i;
        requestLayout();
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14849e = p;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14849e = p;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }
}

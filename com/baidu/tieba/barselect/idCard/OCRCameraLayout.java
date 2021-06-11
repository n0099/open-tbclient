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
    public int f14224e;

    /* renamed from: f  reason: collision with root package name */
    public View f14225f;

    /* renamed from: g  reason: collision with root package name */
    public View f14226g;

    /* renamed from: h  reason: collision with root package name */
    public View f14227h;

    /* renamed from: i  reason: collision with root package name */
    public View f14228i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Rect n;
    public Paint o;

    public OCRCameraLayout(Context context) {
        super(context);
        this.f14224e = p;
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
        this.f14225f = findViewById(this.j);
        int i2 = this.k;
        if (i2 != -1) {
            this.f14226g = findViewById(i2);
        }
        this.f14227h = findViewById(this.l);
        this.f14228i = findViewById(this.m);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.n, this.o);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14227h.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f14228i.getLayoutParams();
        if (i4 < i5) {
            int i6 = (width * 4) / 3;
            int i7 = height - i6;
            this.f14225f.layout(i2, i3, i4, i6);
            Rect rect = this.n;
            rect.left = 0;
            rect.top = i6;
            rect.right = width;
            rect.bottom = height;
            View view = this.f14226g;
            if (view != null) {
                int measuredWidth = (width - view.getMeasuredWidth()) / 2;
                int measuredHeight = ((i7 - this.f14226g.getMeasuredHeight()) / 2) + i6;
                View view2 = this.f14226g;
                view2.layout(measuredWidth, measuredHeight, view2.getMeasuredWidth() + measuredWidth, this.f14226g.getMeasuredHeight() + measuredHeight);
            }
            int i8 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i7 - this.f14227h.getMeasuredHeight()) / 2) + i6;
            View view3 = this.f14227h;
            view3.layout(i8, measuredHeight2, view3.getMeasuredWidth() + i8, this.f14227h.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.f14228i.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = i6 + ((i7 - this.f14228i.getMeasuredHeight()) / 2);
            View view4 = this.f14228i;
            view4.layout(measuredWidth2, measuredHeight3, view4.getMeasuredWidth() + measuredWidth2, this.f14228i.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i9 = (height * 4) / 3;
        int i10 = width - i9;
        this.f14225f.layout(i2, i3, i9, height);
        Rect rect2 = this.n;
        rect2.left = i9;
        rect2.top = 0;
        rect2.right = width;
        rect2.bottom = height;
        View view5 = this.f14226g;
        if (view5 != null) {
            int measuredWidth3 = ((i10 - view5.getMeasuredWidth()) / 2) + i9;
            int measuredHeight4 = (height - this.f14226g.getMeasuredHeight()) / 2;
            View view6 = this.f14226g;
            view6.layout(measuredWidth3, measuredHeight4, view6.getMeasuredWidth() + measuredWidth3, this.f14226g.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i10 - this.f14227h.getMeasuredWidth()) / 2) + i9;
        int measuredHeight5 = (height - this.f14227h.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        View view7 = this.f14227h;
        view7.layout(measuredWidth4, measuredHeight5, view7.getMeasuredWidth() + measuredWidth4, this.f14227h.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = i9 + ((i10 - this.f14228i.getMeasuredWidth()) / 2);
        int i11 = marginLayoutParams2.topMargin;
        View view8 = this.f14228i;
        view8.layout(measuredWidth5, i11, view8.getMeasuredWidth() + measuredWidth5, this.f14228i.getMeasuredHeight() + i11);
    }

    public void setOrientation(int i2) {
        if (this.f14224e == i2) {
            return;
        }
        this.f14224e = i2;
        requestLayout();
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14224e = p;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14224e = p;
        setWillNotDraw(false);
        this.n = new Rect();
        Paint paint = new Paint();
        this.o = paint;
        paint.setStyle(Paint.Style.FILL);
        this.o.setColor(Color.argb(83, 0, 0, 0));
        a(attributeSet);
    }
}

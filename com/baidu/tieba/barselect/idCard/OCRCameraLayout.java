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
import com.baidu.tieba.c;
/* loaded from: classes3.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int eyt = 1;
    private View contentView;
    private int eyA;
    private Rect eyB;
    private View eyu;
    private View eyv;
    private View eyw;
    private int eyx;
    private int eyy;
    private int eyz;
    private int orientation;
    private Paint paint;

    public void setOrientation(int i) {
        if (this.orientation != i) {
            this.orientation = i;
            requestLayout();
        }
    }

    public OCRCameraLayout(Context context) {
        super(context);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eyB = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eyB = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eyB = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    private void f(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, c.a.OCRCameraLayout, 0, 0);
        try {
            this.eyx = obtainStyledAttributes.getResourceId(0, -1);
            this.eyy = obtainStyledAttributes.getResourceId(1, -1);
            this.eyz = obtainStyledAttributes.getResourceId(2, -1);
            this.eyA = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.eyx);
        if (this.eyy != -1) {
            this.eyu = findViewById(this.eyy);
        }
        this.eyv = findViewById(this.eyz);
        this.eyw = findViewById(this.eyA);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eyv.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eyw.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.eyB.left = 0;
            this.eyB.top = i5;
            this.eyB.right = width;
            this.eyB.bottom = height;
            if (this.eyu != null) {
                int measuredWidth = (width - this.eyu.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.eyu.getMeasuredHeight()) / 2) + i5;
                this.eyu.layout(measuredWidth, measuredHeight, this.eyu.getMeasuredWidth() + measuredWidth, this.eyu.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.eyv.getMeasuredHeight()) / 2) + i5;
            this.eyv.layout(i7, measuredHeight2, this.eyv.getMeasuredWidth() + i7, this.eyv.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.eyw.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.eyw.getMeasuredHeight()) / 2) + i5;
            this.eyw.layout(measuredWidth2, measuredHeight3, this.eyw.getMeasuredWidth() + measuredWidth2, this.eyw.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.eyB.left = i8;
        this.eyB.top = 0;
        this.eyB.right = width;
        this.eyB.bottom = height;
        if (this.eyu != null) {
            int measuredWidth3 = ((i9 - this.eyu.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.eyu.getMeasuredHeight()) / 2;
            this.eyu.layout(measuredWidth3, measuredHeight4, this.eyu.getMeasuredWidth() + measuredWidth3, this.eyu.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.eyv.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.eyv.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.eyv.layout(measuredWidth4, measuredHeight5, this.eyv.getMeasuredWidth() + measuredWidth4, this.eyv.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.eyw.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.eyw.layout(measuredWidth5, i10, this.eyw.getMeasuredWidth() + measuredWidth5, this.eyw.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.eyB, this.paint);
    }
}

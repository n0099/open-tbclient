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
    public static int eyl = 1;
    private View contentView;
    private View eyn;
    private View eyo;
    private View eyp;
    private int eyq;
    private int eyr;
    private int eys;
    private int eyt;
    private Rect eyu;
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
        this.eyu = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eyu = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eyu = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    private void f(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, c.a.OCRCameraLayout, 0, 0);
        try {
            this.eyq = obtainStyledAttributes.getResourceId(0, -1);
            this.eyr = obtainStyledAttributes.getResourceId(1, -1);
            this.eys = obtainStyledAttributes.getResourceId(2, -1);
            this.eyt = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.eyq);
        if (this.eyr != -1) {
            this.eyn = findViewById(this.eyr);
        }
        this.eyo = findViewById(this.eys);
        this.eyp = findViewById(this.eyt);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eyo.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eyp.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.eyu.left = 0;
            this.eyu.top = i5;
            this.eyu.right = width;
            this.eyu.bottom = height;
            if (this.eyn != null) {
                int measuredWidth = (width - this.eyn.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.eyn.getMeasuredHeight()) / 2) + i5;
                this.eyn.layout(measuredWidth, measuredHeight, this.eyn.getMeasuredWidth() + measuredWidth, this.eyn.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.eyo.getMeasuredHeight()) / 2) + i5;
            this.eyo.layout(i7, measuredHeight2, this.eyo.getMeasuredWidth() + i7, this.eyo.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.eyp.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.eyp.getMeasuredHeight()) / 2) + i5;
            this.eyp.layout(measuredWidth2, measuredHeight3, this.eyp.getMeasuredWidth() + measuredWidth2, this.eyp.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.eyu.left = i8;
        this.eyu.top = 0;
        this.eyu.right = width;
        this.eyu.bottom = height;
        if (this.eyn != null) {
            int measuredWidth3 = ((i9 - this.eyn.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.eyn.getMeasuredHeight()) / 2;
            this.eyn.layout(measuredWidth3, measuredHeight4, this.eyn.getMeasuredWidth() + measuredWidth3, this.eyn.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.eyo.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.eyo.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.eyo.layout(measuredWidth4, measuredHeight5, this.eyo.getMeasuredWidth() + measuredWidth4, this.eyo.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.eyp.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.eyp.layout(measuredWidth5, i10, this.eyp.getMeasuredWidth() + measuredWidth5, this.eyp.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.eyu, this.paint);
    }
}

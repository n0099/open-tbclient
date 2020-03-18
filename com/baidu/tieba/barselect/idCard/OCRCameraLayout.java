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
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int fGv = 1;
    private View contentView;
    private int fGA;
    private int fGB;
    private int fGC;
    private Rect fGD;
    private View fGw;
    private View fGx;
    private View fGy;
    private int fGz;
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
        this.fGD = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fGD = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fGD = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.fGz = obtainStyledAttributes.getResourceId(0, -1);
            this.fGA = obtainStyledAttributes.getResourceId(1, -1);
            this.fGB = obtainStyledAttributes.getResourceId(2, -1);
            this.fGC = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.fGz);
        if (this.fGA != -1) {
            this.fGw = findViewById(this.fGA);
        }
        this.fGx = findViewById(this.fGB);
        this.fGy = findViewById(this.fGC);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fGx.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fGy.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.fGD.left = 0;
            this.fGD.top = i5;
            this.fGD.right = width;
            this.fGD.bottom = height;
            if (this.fGw != null) {
                int measuredWidth = (width - this.fGw.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.fGw.getMeasuredHeight()) / 2) + i5;
                this.fGw.layout(measuredWidth, measuredHeight, this.fGw.getMeasuredWidth() + measuredWidth, this.fGw.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.fGx.getMeasuredHeight()) / 2) + i5;
            this.fGx.layout(i7, measuredHeight2, this.fGx.getMeasuredWidth() + i7, this.fGx.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.fGy.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.fGy.getMeasuredHeight()) / 2) + i5;
            this.fGy.layout(measuredWidth2, measuredHeight3, this.fGy.getMeasuredWidth() + measuredWidth2, this.fGy.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.fGD.left = i8;
        this.fGD.top = 0;
        this.fGD.right = width;
        this.fGD.bottom = height;
        if (this.fGw != null) {
            int measuredWidth3 = ((i9 - this.fGw.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.fGw.getMeasuredHeight()) / 2;
            this.fGw.layout(measuredWidth3, measuredHeight4, this.fGw.getMeasuredWidth() + measuredWidth3, this.fGw.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.fGx.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.fGx.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.fGx.layout(measuredWidth4, measuredHeight5, this.fGx.getMeasuredWidth() + measuredWidth4, this.fGx.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.fGy.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.fGy.layout(measuredWidth5, i10, this.fGy.getMeasuredWidth() + measuredWidth5, this.fGy.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.fGD, this.paint);
    }
}

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
/* loaded from: classes15.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int hfs = 1;
    private View contentView;
    private Rect hfA;
    private View hft;
    private View hfu;
    private View hfv;
    private int hfw;
    private int hfx;
    private int hfy;
    private int hfz;
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
        this.hfA = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hfA = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hfA = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.hfw = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.hfx = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.hfy = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.hfz = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.hfw);
        if (this.hfx != -1) {
            this.hft = findViewById(this.hfx);
        }
        this.hfu = findViewById(this.hfy);
        this.hfv = findViewById(this.hfz);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hfu.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hfv.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.hfA.left = 0;
            this.hfA.top = i5;
            this.hfA.right = width;
            this.hfA.bottom = height;
            if (this.hft != null) {
                int measuredWidth = (width - this.hft.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.hft.getMeasuredHeight()) / 2) + i5;
                this.hft.layout(measuredWidth, measuredHeight, this.hft.getMeasuredWidth() + measuredWidth, this.hft.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.hfu.getMeasuredHeight()) / 2) + i5;
            this.hfu.layout(i7, measuredHeight2, this.hfu.getMeasuredWidth() + i7, this.hfu.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.hfv.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.hfv.getMeasuredHeight()) / 2) + i5;
            this.hfv.layout(measuredWidth2, measuredHeight3, this.hfv.getMeasuredWidth() + measuredWidth2, this.hfv.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.hfA.left = i8;
        this.hfA.top = 0;
        this.hfA.right = width;
        this.hfA.bottom = height;
        if (this.hft != null) {
            int measuredWidth3 = ((i9 - this.hft.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.hft.getMeasuredHeight()) / 2;
            this.hft.layout(measuredWidth3, measuredHeight4, this.hft.getMeasuredWidth() + measuredWidth3, this.hft.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.hfu.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.hfu.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.hfu.layout(measuredWidth4, measuredHeight5, this.hfu.getMeasuredWidth() + measuredWidth4, this.hfu.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.hfv.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.hfv.layout(measuredWidth5, i10, this.hfv.getMeasuredWidth() + measuredWidth5, this.hfv.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.hfA, this.paint);
    }
}

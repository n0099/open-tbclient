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
/* loaded from: classes21.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int hBr = 1;
    private View contentView;
    private View hBs;
    private View hBt;
    private View hBu;
    private int hBv;
    private int hBw;
    private int hBx;
    private int hBy;
    private Rect hBz;
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
        this.hBz = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hBz = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hBz = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.hBv = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.hBw = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.hBx = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.hBy = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.hBv);
        if (this.hBw != -1) {
            this.hBs = findViewById(this.hBw);
        }
        this.hBt = findViewById(this.hBx);
        this.hBu = findViewById(this.hBy);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hBt.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hBu.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.hBz.left = 0;
            this.hBz.top = i5;
            this.hBz.right = width;
            this.hBz.bottom = height;
            if (this.hBs != null) {
                int measuredWidth = (width - this.hBs.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.hBs.getMeasuredHeight()) / 2) + i5;
                this.hBs.layout(measuredWidth, measuredHeight, this.hBs.getMeasuredWidth() + measuredWidth, this.hBs.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.hBt.getMeasuredHeight()) / 2) + i5;
            this.hBt.layout(i7, measuredHeight2, this.hBt.getMeasuredWidth() + i7, this.hBt.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.hBu.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.hBu.getMeasuredHeight()) / 2) + i5;
            this.hBu.layout(measuredWidth2, measuredHeight3, this.hBu.getMeasuredWidth() + measuredWidth2, this.hBu.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.hBz.left = i8;
        this.hBz.top = 0;
        this.hBz.right = width;
        this.hBz.bottom = height;
        if (this.hBs != null) {
            int measuredWidth3 = ((i9 - this.hBs.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.hBs.getMeasuredHeight()) / 2;
            this.hBs.layout(measuredWidth3, measuredHeight4, this.hBs.getMeasuredWidth() + measuredWidth3, this.hBs.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.hBt.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.hBt.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.hBt.layout(measuredWidth4, measuredHeight5, this.hBt.getMeasuredWidth() + measuredWidth4, this.hBt.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.hBu.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.hBu.layout(measuredWidth5, i10, this.hBu.getMeasuredWidth() + measuredWidth5, this.hBu.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.hBz, this.paint);
    }
}

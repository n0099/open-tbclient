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
    public static int hfw = 1;
    private View contentView;
    private int hfA;
    private int hfB;
    private int hfC;
    private int hfD;
    private Rect hfE;
    private View hfx;
    private View hfy;
    private View hfz;
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
        this.hfE = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hfE = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hfE = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.hfA = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.hfB = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.hfC = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.hfD = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.hfA);
        if (this.hfB != -1) {
            this.hfx = findViewById(this.hfB);
        }
        this.hfy = findViewById(this.hfC);
        this.hfz = findViewById(this.hfD);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hfy.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hfz.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.hfE.left = 0;
            this.hfE.top = i5;
            this.hfE.right = width;
            this.hfE.bottom = height;
            if (this.hfx != null) {
                int measuredWidth = (width - this.hfx.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.hfx.getMeasuredHeight()) / 2) + i5;
                this.hfx.layout(measuredWidth, measuredHeight, this.hfx.getMeasuredWidth() + measuredWidth, this.hfx.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.hfy.getMeasuredHeight()) / 2) + i5;
            this.hfy.layout(i7, measuredHeight2, this.hfy.getMeasuredWidth() + i7, this.hfy.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.hfz.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.hfz.getMeasuredHeight()) / 2) + i5;
            this.hfz.layout(measuredWidth2, measuredHeight3, this.hfz.getMeasuredWidth() + measuredWidth2, this.hfz.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.hfE.left = i8;
        this.hfE.top = 0;
        this.hfE.right = width;
        this.hfE.bottom = height;
        if (this.hfx != null) {
            int measuredWidth3 = ((i9 - this.hfx.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.hfx.getMeasuredHeight()) / 2;
            this.hfx.layout(measuredWidth3, measuredHeight4, this.hfx.getMeasuredWidth() + measuredWidth3, this.hfx.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.hfy.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.hfy.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.hfy.layout(measuredWidth4, measuredHeight5, this.hfy.getMeasuredWidth() + measuredWidth4, this.hfy.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.hfz.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.hfz.layout(measuredWidth5, i10, this.hfz.getMeasuredWidth() + measuredWidth5, this.hfz.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.hfE, this.paint);
    }
}

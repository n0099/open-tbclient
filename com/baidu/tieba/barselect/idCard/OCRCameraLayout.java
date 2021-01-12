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
/* loaded from: classes7.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int imW = 1;
    private View contentView;
    private View imX;
    private View imY;
    private View imZ;
    private int ina;
    private int inb;
    private int inc;
    private int ind;
    private Rect ine;
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
        this.ine = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.ine = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        l(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.ine = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        l(attributeSet);
    }

    private void l(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.ina = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.inb = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.inc = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.ind = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.ina);
        if (this.inb != -1) {
            this.imX = findViewById(this.inb);
        }
        this.imY = findViewById(this.inc);
        this.imZ = findViewById(this.ind);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.imY.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.imZ.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.ine.left = 0;
            this.ine.top = i5;
            this.ine.right = width;
            this.ine.bottom = height;
            if (this.imX != null) {
                int measuredWidth = (width - this.imX.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.imX.getMeasuredHeight()) / 2) + i5;
                this.imX.layout(measuredWidth, measuredHeight, this.imX.getMeasuredWidth() + measuredWidth, this.imX.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.imY.getMeasuredHeight()) / 2) + i5;
            this.imY.layout(i7, measuredHeight2, this.imY.getMeasuredWidth() + i7, this.imY.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.imZ.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.imZ.getMeasuredHeight()) / 2) + i5;
            this.imZ.layout(measuredWidth2, measuredHeight3, this.imZ.getMeasuredWidth() + measuredWidth2, this.imZ.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.ine.left = i8;
        this.ine.top = 0;
        this.ine.right = width;
        this.ine.bottom = height;
        if (this.imX != null) {
            int measuredWidth3 = ((i9 - this.imX.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.imX.getMeasuredHeight()) / 2;
            this.imX.layout(measuredWidth3, measuredHeight4, this.imX.getMeasuredWidth() + measuredWidth3, this.imX.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.imY.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.imY.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.imY.layout(measuredWidth4, measuredHeight5, this.imY.getMeasuredWidth() + measuredWidth4, this.imY.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.imZ.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.imZ.layout(measuredWidth5, i10, this.imZ.getMeasuredWidth() + measuredWidth5, this.imZ.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.ine, this.paint);
    }
}

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
    public static int fFN = 1;
    private View contentView;
    private View fFO;
    private View fFP;
    private View fFQ;
    private int fFR;
    private int fFS;
    private int fFT;
    private int fFU;
    private Rect fFV;
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
        this.fFV = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fFV = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fFV = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.fFR = obtainStyledAttributes.getResourceId(0, -1);
            this.fFS = obtainStyledAttributes.getResourceId(1, -1);
            this.fFT = obtainStyledAttributes.getResourceId(2, -1);
            this.fFU = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.fFR);
        if (this.fFS != -1) {
            this.fFO = findViewById(this.fFS);
        }
        this.fFP = findViewById(this.fFT);
        this.fFQ = findViewById(this.fFU);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fFP.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fFQ.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.fFV.left = 0;
            this.fFV.top = i5;
            this.fFV.right = width;
            this.fFV.bottom = height;
            if (this.fFO != null) {
                int measuredWidth = (width - this.fFO.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.fFO.getMeasuredHeight()) / 2) + i5;
                this.fFO.layout(measuredWidth, measuredHeight, this.fFO.getMeasuredWidth() + measuredWidth, this.fFO.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.fFP.getMeasuredHeight()) / 2) + i5;
            this.fFP.layout(i7, measuredHeight2, this.fFP.getMeasuredWidth() + i7, this.fFP.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.fFQ.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.fFQ.getMeasuredHeight()) / 2) + i5;
            this.fFQ.layout(measuredWidth2, measuredHeight3, this.fFQ.getMeasuredWidth() + measuredWidth2, this.fFQ.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.fFV.left = i8;
        this.fFV.top = 0;
        this.fFV.right = width;
        this.fFV.bottom = height;
        if (this.fFO != null) {
            int measuredWidth3 = ((i9 - this.fFO.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.fFO.getMeasuredHeight()) / 2;
            this.fFO.layout(measuredWidth3, measuredHeight4, this.fFO.getMeasuredWidth() + measuredWidth3, this.fFO.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.fFP.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.fFP.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.fFP.layout(measuredWidth4, measuredHeight5, this.fFP.getMeasuredWidth() + measuredWidth4, this.fFP.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.fFQ.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.fFQ.layout(measuredWidth5, i10, this.fFQ.getMeasuredWidth() + measuredWidth5, this.fFQ.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.fFV, this.paint);
    }
}

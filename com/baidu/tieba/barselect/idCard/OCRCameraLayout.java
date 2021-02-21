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
    public static int isP = 1;
    private View contentView;
    private View isQ;
    private View isR;
    private View isS;
    private int isT;
    private int isU;
    private int isV;
    private int isW;
    private Rect isX;
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
        this.isX = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.isX = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        k(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.isX = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        k(attributeSet);
    }

    private void k(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.isT = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.isU = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.isV = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.isW = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.isT);
        if (this.isU != -1) {
            this.isQ = findViewById(this.isU);
        }
        this.isR = findViewById(this.isV);
        this.isS = findViewById(this.isW);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.isR.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.isS.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.isX.left = 0;
            this.isX.top = i5;
            this.isX.right = width;
            this.isX.bottom = height;
            if (this.isQ != null) {
                int measuredWidth = (width - this.isQ.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.isQ.getMeasuredHeight()) / 2) + i5;
                this.isQ.layout(measuredWidth, measuredHeight, this.isQ.getMeasuredWidth() + measuredWidth, this.isQ.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.isR.getMeasuredHeight()) / 2) + i5;
            this.isR.layout(i7, measuredHeight2, this.isR.getMeasuredWidth() + i7, this.isR.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.isS.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.isS.getMeasuredHeight()) / 2) + i5;
            this.isS.layout(measuredWidth2, measuredHeight3, this.isS.getMeasuredWidth() + measuredWidth2, this.isS.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.isX.left = i8;
        this.isX.top = 0;
        this.isX.right = width;
        this.isX.bottom = height;
        if (this.isQ != null) {
            int measuredWidth3 = ((i9 - this.isQ.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.isQ.getMeasuredHeight()) / 2;
            this.isQ.layout(measuredWidth3, measuredHeight4, this.isQ.getMeasuredWidth() + measuredWidth3, this.isQ.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.isR.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.isR.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.isR.layout(measuredWidth4, measuredHeight5, this.isR.getMeasuredWidth() + measuredWidth4, this.isR.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.isS.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.isS.layout(measuredWidth5, i10, this.isS.getMeasuredWidth() + measuredWidth5, this.isS.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.isX, this.paint);
    }
}

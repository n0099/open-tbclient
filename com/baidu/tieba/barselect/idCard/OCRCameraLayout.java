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
    public static int hNN = 1;
    private View contentView;
    private View hNO;
    private View hNP;
    private View hNQ;
    private int hNR;
    private int hNS;
    private int hNT;
    private int hNU;
    private Rect hNV;
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
        this.hNV = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hNV = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hNV = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.hNR = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.hNS = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.hNT = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.hNU = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.hNR);
        if (this.hNS != -1) {
            this.hNO = findViewById(this.hNS);
        }
        this.hNP = findViewById(this.hNT);
        this.hNQ = findViewById(this.hNU);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hNP.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hNQ.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.hNV.left = 0;
            this.hNV.top = i5;
            this.hNV.right = width;
            this.hNV.bottom = height;
            if (this.hNO != null) {
                int measuredWidth = (width - this.hNO.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.hNO.getMeasuredHeight()) / 2) + i5;
                this.hNO.layout(measuredWidth, measuredHeight, this.hNO.getMeasuredWidth() + measuredWidth, this.hNO.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.hNP.getMeasuredHeight()) / 2) + i5;
            this.hNP.layout(i7, measuredHeight2, this.hNP.getMeasuredWidth() + i7, this.hNP.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.hNQ.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.hNQ.getMeasuredHeight()) / 2) + i5;
            this.hNQ.layout(measuredWidth2, measuredHeight3, this.hNQ.getMeasuredWidth() + measuredWidth2, this.hNQ.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.hNV.left = i8;
        this.hNV.top = 0;
        this.hNV.right = width;
        this.hNV.bottom = height;
        if (this.hNO != null) {
            int measuredWidth3 = ((i9 - this.hNO.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.hNO.getMeasuredHeight()) / 2;
            this.hNO.layout(measuredWidth3, measuredHeight4, this.hNO.getMeasuredWidth() + measuredWidth3, this.hNO.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.hNP.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.hNP.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.hNP.layout(measuredWidth4, measuredHeight5, this.hNP.getMeasuredWidth() + measuredWidth4, this.hNP.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.hNQ.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.hNQ.layout(measuredWidth5, i10, this.hNQ.getMeasuredWidth() + measuredWidth5, this.hNQ.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.hNV, this.paint);
    }
}

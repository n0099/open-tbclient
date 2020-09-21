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
/* loaded from: classes20.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int hmx = 1;
    private View contentView;
    private View hmA;
    private int hmB;
    private int hmC;
    private int hmD;
    private int hmE;
    private Rect hmF;
    private View hmy;
    private View hmz;
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
        this.hmF = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hmF = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hmF = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.hmB = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.hmC = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.hmD = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.hmE = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.hmB);
        if (this.hmC != -1) {
            this.hmy = findViewById(this.hmC);
        }
        this.hmz = findViewById(this.hmD);
        this.hmA = findViewById(this.hmE);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hmz.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hmA.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.hmF.left = 0;
            this.hmF.top = i5;
            this.hmF.right = width;
            this.hmF.bottom = height;
            if (this.hmy != null) {
                int measuredWidth = (width - this.hmy.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.hmy.getMeasuredHeight()) / 2) + i5;
                this.hmy.layout(measuredWidth, measuredHeight, this.hmy.getMeasuredWidth() + measuredWidth, this.hmy.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.hmz.getMeasuredHeight()) / 2) + i5;
            this.hmz.layout(i7, measuredHeight2, this.hmz.getMeasuredWidth() + i7, this.hmz.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.hmA.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.hmA.getMeasuredHeight()) / 2) + i5;
            this.hmA.layout(measuredWidth2, measuredHeight3, this.hmA.getMeasuredWidth() + measuredWidth2, this.hmA.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.hmF.left = i8;
        this.hmF.top = 0;
        this.hmF.right = width;
        this.hmF.bottom = height;
        if (this.hmy != null) {
            int measuredWidth3 = ((i9 - this.hmy.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.hmy.getMeasuredHeight()) / 2;
            this.hmy.layout(measuredWidth3, measuredHeight4, this.hmy.getMeasuredWidth() + measuredWidth3, this.hmy.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.hmz.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.hmz.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.hmz.layout(measuredWidth4, measuredHeight5, this.hmz.getMeasuredWidth() + measuredWidth4, this.hmz.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.hmA.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.hmA.layout(measuredWidth5, i10, this.hmA.getMeasuredWidth() + measuredWidth5, this.hmA.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.hmF, this.paint);
    }
}

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
    public static int gSz = 1;
    private View contentView;
    private View gSA;
    private View gSB;
    private View gSC;
    private int gSD;
    private int gSE;
    private int gSF;
    private int gSG;
    private Rect gSH;
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
        this.gSH = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gSH = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gSH = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.gSD = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.gSE = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.gSF = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.gSG = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.gSD);
        if (this.gSE != -1) {
            this.gSA = findViewById(this.gSE);
        }
        this.gSB = findViewById(this.gSF);
        this.gSC = findViewById(this.gSG);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gSB.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gSC.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.gSH.left = 0;
            this.gSH.top = i5;
            this.gSH.right = width;
            this.gSH.bottom = height;
            if (this.gSA != null) {
                int measuredWidth = (width - this.gSA.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.gSA.getMeasuredHeight()) / 2) + i5;
                this.gSA.layout(measuredWidth, measuredHeight, this.gSA.getMeasuredWidth() + measuredWidth, this.gSA.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.gSB.getMeasuredHeight()) / 2) + i5;
            this.gSB.layout(i7, measuredHeight2, this.gSB.getMeasuredWidth() + i7, this.gSB.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.gSC.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.gSC.getMeasuredHeight()) / 2) + i5;
            this.gSC.layout(measuredWidth2, measuredHeight3, this.gSC.getMeasuredWidth() + measuredWidth2, this.gSC.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.gSH.left = i8;
        this.gSH.top = 0;
        this.gSH.right = width;
        this.gSH.bottom = height;
        if (this.gSA != null) {
            int measuredWidth3 = ((i9 - this.gSA.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.gSA.getMeasuredHeight()) / 2;
            this.gSA.layout(measuredWidth3, measuredHeight4, this.gSA.getMeasuredWidth() + measuredWidth3, this.gSA.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.gSB.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.gSB.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.gSB.layout(measuredWidth4, measuredHeight5, this.gSB.getMeasuredWidth() + measuredWidth4, this.gSB.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.gSC.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.gSC.layout(measuredWidth5, i10, this.gSC.getMeasuredWidth() + measuredWidth5, this.gSC.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.gSH, this.paint);
    }
}

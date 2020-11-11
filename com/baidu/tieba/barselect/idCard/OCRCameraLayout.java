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
    public static int hTK = 1;
    private View contentView;
    private View hTL;
    private View hTM;
    private View hTN;
    private int hTO;
    private int hTP;
    private int hTQ;
    private int hTR;
    private Rect hTS;
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
        this.hTS = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hTS = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hTS = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.hTO = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.hTP = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.hTQ = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.hTR = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.hTO);
        if (this.hTP != -1) {
            this.hTL = findViewById(this.hTP);
        }
        this.hTM = findViewById(this.hTQ);
        this.hTN = findViewById(this.hTR);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hTM.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hTN.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.hTS.left = 0;
            this.hTS.top = i5;
            this.hTS.right = width;
            this.hTS.bottom = height;
            if (this.hTL != null) {
                int measuredWidth = (width - this.hTL.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.hTL.getMeasuredHeight()) / 2) + i5;
                this.hTL.layout(measuredWidth, measuredHeight, this.hTL.getMeasuredWidth() + measuredWidth, this.hTL.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.hTM.getMeasuredHeight()) / 2) + i5;
            this.hTM.layout(i7, measuredHeight2, this.hTM.getMeasuredWidth() + i7, this.hTM.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.hTN.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.hTN.getMeasuredHeight()) / 2) + i5;
            this.hTN.layout(measuredWidth2, measuredHeight3, this.hTN.getMeasuredWidth() + measuredWidth2, this.hTN.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.hTS.left = i8;
        this.hTS.top = 0;
        this.hTS.right = width;
        this.hTS.bottom = height;
        if (this.hTL != null) {
            int measuredWidth3 = ((i9 - this.hTL.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.hTL.getMeasuredHeight()) / 2;
            this.hTL.layout(measuredWidth3, measuredHeight4, this.hTL.getMeasuredWidth() + measuredWidth3, this.hTL.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.hTM.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.hTM.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.hTM.layout(measuredWidth4, measuredHeight5, this.hTM.getMeasuredWidth() + measuredWidth4, this.hTM.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.hTN.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.hTN.layout(measuredWidth5, i10, this.hTN.getMeasuredWidth() + measuredWidth5, this.hTN.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.hTS, this.paint);
    }
}

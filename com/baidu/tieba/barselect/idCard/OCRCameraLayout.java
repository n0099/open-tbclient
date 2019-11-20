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
/* loaded from: classes3.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int eHT = 1;
    private View contentView;
    private View eHU;
    private View eHV;
    private View eHW;
    private int eHX;
    private int eHY;
    private int eHZ;
    private int eIa;
    private Rect eIb;
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
        this.eIb = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eIb = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eIb = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    private void f(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.eHX = obtainStyledAttributes.getResourceId(0, -1);
            this.eHY = obtainStyledAttributes.getResourceId(1, -1);
            this.eHZ = obtainStyledAttributes.getResourceId(2, -1);
            this.eIa = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.eHX);
        if (this.eHY != -1) {
            this.eHU = findViewById(this.eHY);
        }
        this.eHV = findViewById(this.eHZ);
        this.eHW = findViewById(this.eIa);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eHV.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eHW.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.eIb.left = 0;
            this.eIb.top = i5;
            this.eIb.right = width;
            this.eIb.bottom = height;
            if (this.eHU != null) {
                int measuredWidth = (width - this.eHU.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.eHU.getMeasuredHeight()) / 2) + i5;
                this.eHU.layout(measuredWidth, measuredHeight, this.eHU.getMeasuredWidth() + measuredWidth, this.eHU.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.eHV.getMeasuredHeight()) / 2) + i5;
            this.eHV.layout(i7, measuredHeight2, this.eHV.getMeasuredWidth() + i7, this.eHV.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.eHW.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.eHW.getMeasuredHeight()) / 2) + i5;
            this.eHW.layout(measuredWidth2, measuredHeight3, this.eHW.getMeasuredWidth() + measuredWidth2, this.eHW.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.eIb.left = i8;
        this.eIb.top = 0;
        this.eIb.right = width;
        this.eIb.bottom = height;
        if (this.eHU != null) {
            int measuredWidth3 = ((i9 - this.eHU.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.eHU.getMeasuredHeight()) / 2;
            this.eHU.layout(measuredWidth3, measuredHeight4, this.eHU.getMeasuredWidth() + measuredWidth3, this.eHU.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.eHV.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.eHV.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.eHV.layout(measuredWidth4, measuredHeight5, this.eHV.getMeasuredWidth() + measuredWidth4, this.eHV.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.eHW.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.eHW.layout(measuredWidth5, i10, this.eHW.getMeasuredWidth() + measuredWidth5, this.eHW.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.eIb, this.paint);
    }
}

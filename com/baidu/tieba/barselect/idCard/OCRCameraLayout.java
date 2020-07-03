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
    public static int gMT = 1;
    private View contentView;
    private View gMU;
    private View gMV;
    private View gMW;
    private int gMX;
    private int gMY;
    private int gMZ;
    private int gNa;
    private Rect gNb;
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
        this.gNb = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gNb = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gNb = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.gMX = obtainStyledAttributes.getResourceId(0, -1);
            this.gMY = obtainStyledAttributes.getResourceId(1, -1);
            this.gMZ = obtainStyledAttributes.getResourceId(2, -1);
            this.gNa = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.gMX);
        if (this.gMY != -1) {
            this.gMU = findViewById(this.gMY);
        }
        this.gMV = findViewById(this.gMZ);
        this.gMW = findViewById(this.gNa);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gMV.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gMW.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.gNb.left = 0;
            this.gNb.top = i5;
            this.gNb.right = width;
            this.gNb.bottom = height;
            if (this.gMU != null) {
                int measuredWidth = (width - this.gMU.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.gMU.getMeasuredHeight()) / 2) + i5;
                this.gMU.layout(measuredWidth, measuredHeight, this.gMU.getMeasuredWidth() + measuredWidth, this.gMU.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.gMV.getMeasuredHeight()) / 2) + i5;
            this.gMV.layout(i7, measuredHeight2, this.gMV.getMeasuredWidth() + i7, this.gMV.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.gMW.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.gMW.getMeasuredHeight()) / 2) + i5;
            this.gMW.layout(measuredWidth2, measuredHeight3, this.gMW.getMeasuredWidth() + measuredWidth2, this.gMW.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.gNb.left = i8;
        this.gNb.top = 0;
        this.gNb.right = width;
        this.gNb.bottom = height;
        if (this.gMU != null) {
            int measuredWidth3 = ((i9 - this.gMU.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.gMU.getMeasuredHeight()) / 2;
            this.gMU.layout(measuredWidth3, measuredHeight4, this.gMU.getMeasuredWidth() + measuredWidth3, this.gMU.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.gMV.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.gMV.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.gMV.layout(measuredWidth4, measuredHeight5, this.gMV.getMeasuredWidth() + measuredWidth4, this.gMV.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.gMW.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.gMW.layout(measuredWidth5, i10, this.gMW.getMeasuredWidth() + measuredWidth5, this.gMW.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.gNb, this.paint);
    }
}

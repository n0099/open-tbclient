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
    public static int gzW = 1;
    private View contentView;
    private int gAa;
    private int gAb;
    private int gAc;
    private int gAd;
    private Rect gAe;
    private View gzX;
    private View gzY;
    private View gzZ;
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
        this.gAe = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gAe = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gAe = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.gAa = obtainStyledAttributes.getResourceId(0, -1);
            this.gAb = obtainStyledAttributes.getResourceId(1, -1);
            this.gAc = obtainStyledAttributes.getResourceId(2, -1);
            this.gAd = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.gAa);
        if (this.gAb != -1) {
            this.gzX = findViewById(this.gAb);
        }
        this.gzY = findViewById(this.gAc);
        this.gzZ = findViewById(this.gAd);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gzY.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gzZ.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.gAe.left = 0;
            this.gAe.top = i5;
            this.gAe.right = width;
            this.gAe.bottom = height;
            if (this.gzX != null) {
                int measuredWidth = (width - this.gzX.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.gzX.getMeasuredHeight()) / 2) + i5;
                this.gzX.layout(measuredWidth, measuredHeight, this.gzX.getMeasuredWidth() + measuredWidth, this.gzX.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.gzY.getMeasuredHeight()) / 2) + i5;
            this.gzY.layout(i7, measuredHeight2, this.gzY.getMeasuredWidth() + i7, this.gzY.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.gzZ.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.gzZ.getMeasuredHeight()) / 2) + i5;
            this.gzZ.layout(measuredWidth2, measuredHeight3, this.gzZ.getMeasuredWidth() + measuredWidth2, this.gzZ.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.gAe.left = i8;
        this.gAe.top = 0;
        this.gAe.right = width;
        this.gAe.bottom = height;
        if (this.gzX != null) {
            int measuredWidth3 = ((i9 - this.gzX.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.gzX.getMeasuredHeight()) / 2;
            this.gzX.layout(measuredWidth3, measuredHeight4, this.gzX.getMeasuredWidth() + measuredWidth3, this.gzX.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.gzY.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.gzY.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.gzY.layout(measuredWidth4, measuredHeight5, this.gzY.getMeasuredWidth() + measuredWidth4, this.gzY.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.gzZ.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.gzZ.layout(measuredWidth5, i10, this.gzZ.getMeasuredWidth() + measuredWidth5, this.gzZ.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.gAe, this.paint);
    }
}

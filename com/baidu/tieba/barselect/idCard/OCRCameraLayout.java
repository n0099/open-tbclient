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
/* loaded from: classes5.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int fzQ = 1;
    private View contentView;
    private View fzR;
    private View fzS;
    private View fzT;
    private int fzU;
    private int fzV;
    private int fzW;
    private int fzX;
    private Rect fzY;
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
        this.fzY = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fzY = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fzY = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.fzU = obtainStyledAttributes.getResourceId(0, -1);
            this.fzV = obtainStyledAttributes.getResourceId(1, -1);
            this.fzW = obtainStyledAttributes.getResourceId(2, -1);
            this.fzX = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.fzU);
        if (this.fzV != -1) {
            this.fzR = findViewById(this.fzV);
        }
        this.fzS = findViewById(this.fzW);
        this.fzT = findViewById(this.fzX);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fzS.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fzT.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.fzY.left = 0;
            this.fzY.top = i5;
            this.fzY.right = width;
            this.fzY.bottom = height;
            if (this.fzR != null) {
                int measuredWidth = (width - this.fzR.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.fzR.getMeasuredHeight()) / 2) + i5;
                this.fzR.layout(measuredWidth, measuredHeight, this.fzR.getMeasuredWidth() + measuredWidth, this.fzR.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.fzS.getMeasuredHeight()) / 2) + i5;
            this.fzS.layout(i7, measuredHeight2, this.fzS.getMeasuredWidth() + i7, this.fzS.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.fzT.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.fzT.getMeasuredHeight()) / 2) + i5;
            this.fzT.layout(measuredWidth2, measuredHeight3, this.fzT.getMeasuredWidth() + measuredWidth2, this.fzT.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.fzY.left = i8;
        this.fzY.top = 0;
        this.fzY.right = width;
        this.fzY.bottom = height;
        if (this.fzR != null) {
            int measuredWidth3 = ((i9 - this.fzR.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.fzR.getMeasuredHeight()) / 2;
            this.fzR.layout(measuredWidth3, measuredHeight4, this.fzR.getMeasuredWidth() + measuredWidth3, this.fzR.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.fzS.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.fzS.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.fzS.layout(measuredWidth4, measuredHeight5, this.fzS.getMeasuredWidth() + measuredWidth4, this.fzS.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.fzT.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.fzT.layout(measuredWidth5, i10, this.fzT.getMeasuredWidth() + measuredWidth5, this.fzT.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.fzY, this.paint);
    }
}

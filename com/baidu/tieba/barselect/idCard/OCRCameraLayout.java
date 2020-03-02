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
    public static int fFA = 1;
    private View contentView;
    private View fFB;
    private View fFC;
    private View fFD;
    private int fFE;
    private int fFF;
    private int fFG;
    private int fFH;
    private Rect fFI;
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
        this.fFI = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fFI = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fFI = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.fFE = obtainStyledAttributes.getResourceId(0, -1);
            this.fFF = obtainStyledAttributes.getResourceId(1, -1);
            this.fFG = obtainStyledAttributes.getResourceId(2, -1);
            this.fFH = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.fFE);
        if (this.fFF != -1) {
            this.fFB = findViewById(this.fFF);
        }
        this.fFC = findViewById(this.fFG);
        this.fFD = findViewById(this.fFH);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fFC.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fFD.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.fFI.left = 0;
            this.fFI.top = i5;
            this.fFI.right = width;
            this.fFI.bottom = height;
            if (this.fFB != null) {
                int measuredWidth = (width - this.fFB.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.fFB.getMeasuredHeight()) / 2) + i5;
                this.fFB.layout(measuredWidth, measuredHeight, this.fFB.getMeasuredWidth() + measuredWidth, this.fFB.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.fFC.getMeasuredHeight()) / 2) + i5;
            this.fFC.layout(i7, measuredHeight2, this.fFC.getMeasuredWidth() + i7, this.fFC.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.fFD.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.fFD.getMeasuredHeight()) / 2) + i5;
            this.fFD.layout(measuredWidth2, measuredHeight3, this.fFD.getMeasuredWidth() + measuredWidth2, this.fFD.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.fFI.left = i8;
        this.fFI.top = 0;
        this.fFI.right = width;
        this.fFI.bottom = height;
        if (this.fFB != null) {
            int measuredWidth3 = ((i9 - this.fFB.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.fFB.getMeasuredHeight()) / 2;
            this.fFB.layout(measuredWidth3, measuredHeight4, this.fFB.getMeasuredWidth() + measuredWidth3, this.fFB.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.fFC.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.fFC.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.fFC.layout(measuredWidth4, measuredHeight5, this.fFC.getMeasuredWidth() + measuredWidth4, this.fFC.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.fFD.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.fFD.layout(measuredWidth5, i10, this.fFD.getMeasuredWidth() + measuredWidth5, this.fFD.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.fFI, this.paint);
    }
}

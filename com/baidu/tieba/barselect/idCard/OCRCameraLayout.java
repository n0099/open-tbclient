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
    public static int fFy = 1;
    private View contentView;
    private View fFA;
    private View fFB;
    private int fFC;
    private int fFD;
    private int fFE;
    private int fFF;
    private Rect fFG;
    private View fFz;
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
        this.fFG = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fFG = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fFG = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.fFC = obtainStyledAttributes.getResourceId(0, -1);
            this.fFD = obtainStyledAttributes.getResourceId(1, -1);
            this.fFE = obtainStyledAttributes.getResourceId(2, -1);
            this.fFF = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.fFC);
        if (this.fFD != -1) {
            this.fFz = findViewById(this.fFD);
        }
        this.fFA = findViewById(this.fFE);
        this.fFB = findViewById(this.fFF);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fFA.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fFB.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.fFG.left = 0;
            this.fFG.top = i5;
            this.fFG.right = width;
            this.fFG.bottom = height;
            if (this.fFz != null) {
                int measuredWidth = (width - this.fFz.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.fFz.getMeasuredHeight()) / 2) + i5;
                this.fFz.layout(measuredWidth, measuredHeight, this.fFz.getMeasuredWidth() + measuredWidth, this.fFz.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.fFA.getMeasuredHeight()) / 2) + i5;
            this.fFA.layout(i7, measuredHeight2, this.fFA.getMeasuredWidth() + i7, this.fFA.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.fFB.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.fFB.getMeasuredHeight()) / 2) + i5;
            this.fFB.layout(measuredWidth2, measuredHeight3, this.fFB.getMeasuredWidth() + measuredWidth2, this.fFB.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.fFG.left = i8;
        this.fFG.top = 0;
        this.fFG.right = width;
        this.fFG.bottom = height;
        if (this.fFz != null) {
            int measuredWidth3 = ((i9 - this.fFz.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.fFz.getMeasuredHeight()) / 2;
            this.fFz.layout(measuredWidth3, measuredHeight4, this.fFz.getMeasuredWidth() + measuredWidth3, this.fFz.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.fFA.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.fFA.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.fFA.layout(measuredWidth4, measuredHeight5, this.fFA.getMeasuredWidth() + measuredWidth4, this.fFA.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.fFB.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.fFB.layout(measuredWidth5, i10, this.fFB.getMeasuredWidth() + measuredWidth5, this.fFB.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.fFG, this.paint);
    }
}

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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int eAc = 1;
    private View contentView;
    private View eAd;
    private View eAe;
    private View eAf;
    private int eAg;
    private int eAh;
    private int eAi;
    private int eAj;
    private Rect eAk;
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
        this.eAk = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eAk = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.eAk = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    private void f(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, d.a.OCRCameraLayout, 0, 0);
        try {
            this.eAg = obtainStyledAttributes.getResourceId(0, -1);
            this.eAh = obtainStyledAttributes.getResourceId(1, -1);
            this.eAi = obtainStyledAttributes.getResourceId(2, -1);
            this.eAj = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.eAg);
        if (this.eAh != -1) {
            this.eAd = findViewById(this.eAh);
        }
        this.eAe = findViewById(this.eAi);
        this.eAf = findViewById(this.eAj);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eAe.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eAf.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.eAk.left = 0;
            this.eAk.top = i5;
            this.eAk.right = width;
            this.eAk.bottom = height;
            if (this.eAd != null) {
                int measuredWidth = (width - this.eAd.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.eAd.getMeasuredHeight()) / 2) + i5;
                this.eAd.layout(measuredWidth, measuredHeight, this.eAd.getMeasuredWidth() + measuredWidth, this.eAd.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.eAe.getMeasuredHeight()) / 2) + i5;
            this.eAe.layout(i7, measuredHeight2, this.eAe.getMeasuredWidth() + i7, this.eAe.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.eAf.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.eAf.getMeasuredHeight()) / 2) + i5;
            this.eAf.layout(measuredWidth2, measuredHeight3, this.eAf.getMeasuredWidth() + measuredWidth2, this.eAf.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.eAk.left = i8;
        this.eAk.top = 0;
        this.eAk.right = width;
        this.eAk.bottom = height;
        if (this.eAd != null) {
            int measuredWidth3 = ((i9 - this.eAd.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.eAd.getMeasuredHeight()) / 2;
            this.eAd.layout(measuredWidth3, measuredHeight4, this.eAd.getMeasuredWidth() + measuredWidth3, this.eAd.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.eAe.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.eAe.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.eAe.layout(measuredWidth4, measuredHeight5, this.eAe.getMeasuredWidth() + measuredWidth4, this.eAe.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.eAf.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.eAf.layout(measuredWidth5, i10, this.eAf.getMeasuredWidth() + measuredWidth5, this.eAf.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.eAk, this.paint);
    }
}

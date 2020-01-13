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
/* loaded from: classes6.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int fDb = 1;
    private View contentView;
    private View fDc;
    private View fDd;
    private View fDe;
    private int fDf;
    private int fDg;
    private int fDh;
    private int fDi;
    private Rect fDj;
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
        this.fDj = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fDj = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.fDj = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        g(attributeSet);
    }

    private void g(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.fDf = obtainStyledAttributes.getResourceId(0, -1);
            this.fDg = obtainStyledAttributes.getResourceId(1, -1);
            this.fDh = obtainStyledAttributes.getResourceId(2, -1);
            this.fDi = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.fDf);
        if (this.fDg != -1) {
            this.fDc = findViewById(this.fDg);
        }
        this.fDd = findViewById(this.fDh);
        this.fDe = findViewById(this.fDi);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fDd.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fDe.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.fDj.left = 0;
            this.fDj.top = i5;
            this.fDj.right = width;
            this.fDj.bottom = height;
            if (this.fDc != null) {
                int measuredWidth = (width - this.fDc.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.fDc.getMeasuredHeight()) / 2) + i5;
                this.fDc.layout(measuredWidth, measuredHeight, this.fDc.getMeasuredWidth() + measuredWidth, this.fDc.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.fDd.getMeasuredHeight()) / 2) + i5;
            this.fDd.layout(i7, measuredHeight2, this.fDd.getMeasuredWidth() + i7, this.fDd.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.fDe.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.fDe.getMeasuredHeight()) / 2) + i5;
            this.fDe.layout(measuredWidth2, measuredHeight3, this.fDe.getMeasuredWidth() + measuredWidth2, this.fDe.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.fDj.left = i8;
        this.fDj.top = 0;
        this.fDj.right = width;
        this.fDj.bottom = height;
        if (this.fDc != null) {
            int measuredWidth3 = ((i9 - this.fDc.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.fDc.getMeasuredHeight()) / 2;
            this.fDc.layout(measuredWidth3, measuredHeight4, this.fDc.getMeasuredWidth() + measuredWidth3, this.fDc.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.fDd.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.fDd.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.fDd.layout(measuredWidth4, measuredHeight5, this.fDd.getMeasuredWidth() + measuredWidth4, this.fDd.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.fDe.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.fDe.layout(measuredWidth5, i10, this.fDe.getMeasuredWidth() + measuredWidth5, this.fDe.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.fDj, this.paint);
    }
}

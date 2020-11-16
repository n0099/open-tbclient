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
/* loaded from: classes20.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int hUk = 1;
    private View contentView;
    private View hUl;
    private View hUm;
    private View hUn;
    private int hUo;
    private int hUp;
    private int hUq;
    private int hUr;
    private Rect hUs;
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
        this.hUs = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hUs = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.hUs = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.hUo = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.hUp = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.hUq = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.hUr = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.hUo);
        if (this.hUp != -1) {
            this.hUl = findViewById(this.hUp);
        }
        this.hUm = findViewById(this.hUq);
        this.hUn = findViewById(this.hUr);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hUm.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.hUn.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.hUs.left = 0;
            this.hUs.top = i5;
            this.hUs.right = width;
            this.hUs.bottom = height;
            if (this.hUl != null) {
                int measuredWidth = (width - this.hUl.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.hUl.getMeasuredHeight()) / 2) + i5;
                this.hUl.layout(measuredWidth, measuredHeight, this.hUl.getMeasuredWidth() + measuredWidth, this.hUl.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.hUm.getMeasuredHeight()) / 2) + i5;
            this.hUm.layout(i7, measuredHeight2, this.hUm.getMeasuredWidth() + i7, this.hUm.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.hUn.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.hUn.getMeasuredHeight()) / 2) + i5;
            this.hUn.layout(measuredWidth2, measuredHeight3, this.hUn.getMeasuredWidth() + measuredWidth2, this.hUn.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.hUs.left = i8;
        this.hUs.top = 0;
        this.hUs.right = width;
        this.hUs.bottom = height;
        if (this.hUl != null) {
            int measuredWidth3 = ((i9 - this.hUl.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.hUl.getMeasuredHeight()) / 2;
            this.hUl.layout(measuredWidth3, measuredHeight4, this.hUl.getMeasuredWidth() + measuredWidth3, this.hUl.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.hUm.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.hUm.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.hUm.layout(measuredWidth4, measuredHeight5, this.hUm.getMeasuredWidth() + measuredWidth4, this.hUm.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.hUn.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.hUn.layout(measuredWidth5, i10, this.hUn.getMeasuredWidth() + measuredWidth5, this.hUn.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.hUs, this.paint);
    }
}

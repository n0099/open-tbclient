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
    public static int isB = 1;
    private View contentView;
    private View isC;
    private View isD;
    private View isE;
    private int isF;
    private int isG;
    private int isH;
    private int isI;
    private Rect isJ;
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
        this.isJ = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.isJ = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        k(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.isJ = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        k(attributeSet);
    }

    private void k(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.isF = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.isG = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.isH = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.isI = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.isF);
        if (this.isG != -1) {
            this.isC = findViewById(this.isG);
        }
        this.isD = findViewById(this.isH);
        this.isE = findViewById(this.isI);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.isD.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.isE.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.isJ.left = 0;
            this.isJ.top = i5;
            this.isJ.right = width;
            this.isJ.bottom = height;
            if (this.isC != null) {
                int measuredWidth = (width - this.isC.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.isC.getMeasuredHeight()) / 2) + i5;
                this.isC.layout(measuredWidth, measuredHeight, this.isC.getMeasuredWidth() + measuredWidth, this.isC.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.isD.getMeasuredHeight()) / 2) + i5;
            this.isD.layout(i7, measuredHeight2, this.isD.getMeasuredWidth() + i7, this.isD.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.isE.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.isE.getMeasuredHeight()) / 2) + i5;
            this.isE.layout(measuredWidth2, measuredHeight3, this.isE.getMeasuredWidth() + measuredWidth2, this.isE.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.isJ.left = i8;
        this.isJ.top = 0;
        this.isJ.right = width;
        this.isJ.bottom = height;
        if (this.isC != null) {
            int measuredWidth3 = ((i9 - this.isC.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.isC.getMeasuredHeight()) / 2;
            this.isC.layout(measuredWidth3, measuredHeight4, this.isC.getMeasuredWidth() + measuredWidth3, this.isC.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.isD.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.isD.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.isD.layout(measuredWidth4, measuredHeight5, this.isD.getMeasuredWidth() + measuredWidth4, this.isD.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.isE.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.isE.layout(measuredWidth5, i10, this.isE.getMeasuredWidth() + measuredWidth5, this.isE.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.isJ, this.paint);
    }
}

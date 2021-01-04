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
    public static int irE = 1;
    private View contentView;
    private View irF;
    private View irG;
    private View irH;
    private int irI;
    private int irJ;
    private int irK;
    private int irL;
    private Rect irM;
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
        this.irM = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.irM = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        l(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.irM = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        l(attributeSet);
    }

    private void l(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.irI = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.irJ = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.irK = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.irL = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.irI);
        if (this.irJ != -1) {
            this.irF = findViewById(this.irJ);
        }
        this.irG = findViewById(this.irK);
        this.irH = findViewById(this.irL);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.irG.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.irH.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.irM.left = 0;
            this.irM.top = i5;
            this.irM.right = width;
            this.irM.bottom = height;
            if (this.irF != null) {
                int measuredWidth = (width - this.irF.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.irF.getMeasuredHeight()) / 2) + i5;
                this.irF.layout(measuredWidth, measuredHeight, this.irF.getMeasuredWidth() + measuredWidth, this.irF.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.irG.getMeasuredHeight()) / 2) + i5;
            this.irG.layout(i7, measuredHeight2, this.irG.getMeasuredWidth() + i7, this.irG.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.irH.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.irH.getMeasuredHeight()) / 2) + i5;
            this.irH.layout(measuredWidth2, measuredHeight3, this.irH.getMeasuredWidth() + measuredWidth2, this.irH.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.irM.left = i8;
        this.irM.top = 0;
        this.irM.right = width;
        this.irM.bottom = height;
        if (this.irF != null) {
            int measuredWidth3 = ((i9 - this.irF.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.irF.getMeasuredHeight()) / 2;
            this.irF.layout(measuredWidth3, measuredHeight4, this.irF.getMeasuredWidth() + measuredWidth3, this.irF.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.irG.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.irG.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.irG.layout(measuredWidth4, measuredHeight5, this.irG.getMeasuredWidth() + measuredWidth4, this.irG.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.irH.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.irH.layout(measuredWidth5, i10, this.irH.getMeasuredWidth() + measuredWidth5, this.irH.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.irM, this.paint);
    }
}

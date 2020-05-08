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
    public static int glg = 1;
    private View contentView;
    private View glh;
    private View gli;
    private View glj;
    private int glk;
    private int gll;
    private int glm;
    private int gln;
    private Rect glo;
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
        this.glo = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.glo = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.glo = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.glk = obtainStyledAttributes.getResourceId(0, -1);
            this.gll = obtainStyledAttributes.getResourceId(1, -1);
            this.glm = obtainStyledAttributes.getResourceId(2, -1);
            this.gln = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.glk);
        if (this.gll != -1) {
            this.glh = findViewById(this.gll);
        }
        this.gli = findViewById(this.glm);
        this.glj = findViewById(this.gln);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gli.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.glj.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.glo.left = 0;
            this.glo.top = i5;
            this.glo.right = width;
            this.glo.bottom = height;
            if (this.glh != null) {
                int measuredWidth = (width - this.glh.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.glh.getMeasuredHeight()) / 2) + i5;
                this.glh.layout(measuredWidth, measuredHeight, this.glh.getMeasuredWidth() + measuredWidth, this.glh.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.gli.getMeasuredHeight()) / 2) + i5;
            this.gli.layout(i7, measuredHeight2, this.gli.getMeasuredWidth() + i7, this.gli.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.glj.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.glj.getMeasuredHeight()) / 2) + i5;
            this.glj.layout(measuredWidth2, measuredHeight3, this.glj.getMeasuredWidth() + measuredWidth2, this.glj.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.glo.left = i8;
        this.glo.top = 0;
        this.glo.right = width;
        this.glo.bottom = height;
        if (this.glh != null) {
            int measuredWidth3 = ((i9 - this.glh.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.glh.getMeasuredHeight()) / 2;
            this.glh.layout(measuredWidth3, measuredHeight4, this.glh.getMeasuredWidth() + measuredWidth3, this.glh.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.gli.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.gli.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.gli.layout(measuredWidth4, measuredHeight5, this.gli.getMeasuredWidth() + measuredWidth4, this.gli.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.glj.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.glj.layout(measuredWidth5, i10, this.glj.getMeasuredWidth() + measuredWidth5, this.glj.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.glo, this.paint);
    }
}

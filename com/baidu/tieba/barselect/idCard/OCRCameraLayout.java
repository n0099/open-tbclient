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
    public static int gAh = 1;
    private View contentView;
    private View gAi;
    private View gAj;
    private View gAk;
    private int gAl;
    private int gAm;
    private int gAn;
    private int gAo;
    private Rect gAp;
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
        this.gAp = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gAp = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gAp = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.gAl = obtainStyledAttributes.getResourceId(0, -1);
            this.gAm = obtainStyledAttributes.getResourceId(1, -1);
            this.gAn = obtainStyledAttributes.getResourceId(2, -1);
            this.gAo = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.gAl);
        if (this.gAm != -1) {
            this.gAi = findViewById(this.gAm);
        }
        this.gAj = findViewById(this.gAn);
        this.gAk = findViewById(this.gAo);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gAj.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gAk.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.gAp.left = 0;
            this.gAp.top = i5;
            this.gAp.right = width;
            this.gAp.bottom = height;
            if (this.gAi != null) {
                int measuredWidth = (width - this.gAi.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.gAi.getMeasuredHeight()) / 2) + i5;
                this.gAi.layout(measuredWidth, measuredHeight, this.gAi.getMeasuredWidth() + measuredWidth, this.gAi.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.gAj.getMeasuredHeight()) / 2) + i5;
            this.gAj.layout(i7, measuredHeight2, this.gAj.getMeasuredWidth() + i7, this.gAj.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.gAk.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.gAk.getMeasuredHeight()) / 2) + i5;
            this.gAk.layout(measuredWidth2, measuredHeight3, this.gAk.getMeasuredWidth() + measuredWidth2, this.gAk.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.gAp.left = i8;
        this.gAp.top = 0;
        this.gAp.right = width;
        this.gAp.bottom = height;
        if (this.gAi != null) {
            int measuredWidth3 = ((i9 - this.gAi.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.gAi.getMeasuredHeight()) / 2;
            this.gAi.layout(measuredWidth3, measuredHeight4, this.gAi.getMeasuredWidth() + measuredWidth3, this.gAi.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.gAj.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.gAj.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.gAj.layout(measuredWidth4, measuredHeight5, this.gAj.getMeasuredWidth() + measuredWidth4, this.gAj.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.gAk.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.gAk.layout(measuredWidth5, i10, this.gAk.getMeasuredWidth() + measuredWidth5, this.gAk.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.gAp, this.paint);
    }
}

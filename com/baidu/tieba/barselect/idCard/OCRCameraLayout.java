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
import com.baidu.tieba.c;
/* loaded from: classes3.dex */
public class OCRCameraLayout extends FrameLayout {
    private View contentView;
    private View eto;
    private View etp;
    private View etq;
    private int etr;
    private int ets;
    private int ett;
    private int etu;
    private Rect etv;
    private int orientation;
    private Paint paint;
    public static int ORIENTATION_PORTRAIT = 0;
    public static int ORIENTATION_HORIZONTAL = 1;

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
        this.etv = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.etv = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.etv = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        f(attributeSet);
    }

    private void f(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, c.a.OCRCameraLayout, 0, 0);
        try {
            this.etr = obtainStyledAttributes.getResourceId(0, -1);
            this.ets = obtainStyledAttributes.getResourceId(1, -1);
            this.ett = obtainStyledAttributes.getResourceId(2, -1);
            this.etu = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.etr);
        if (this.ets != -1) {
            this.eto = findViewById(this.ets);
        }
        this.etp = findViewById(this.ett);
        this.etq = findViewById(this.etu);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.etp.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.etq.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.etv.left = 0;
            this.etv.top = i5;
            this.etv.right = width;
            this.etv.bottom = height;
            if (this.eto != null) {
                int measuredWidth = (width - this.eto.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.eto.getMeasuredHeight()) / 2) + i5;
                this.eto.layout(measuredWidth, measuredHeight, this.eto.getMeasuredWidth() + measuredWidth, this.eto.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.etp.getMeasuredHeight()) / 2) + i5;
            this.etp.layout(i7, measuredHeight2, this.etp.getMeasuredWidth() + i7, this.etp.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.etq.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.etq.getMeasuredHeight()) / 2) + i5;
            this.etq.layout(measuredWidth2, measuredHeight3, this.etq.getMeasuredWidth() + measuredWidth2, this.etq.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.etv.left = i8;
        this.etv.top = 0;
        this.etv.right = width;
        this.etv.bottom = height;
        if (this.eto != null) {
            int measuredWidth3 = ((i9 - this.eto.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.eto.getMeasuredHeight()) / 2;
            this.eto.layout(measuredWidth3, measuredHeight4, this.eto.getMeasuredWidth() + measuredWidth3, this.eto.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.etp.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.etp.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.etp.layout(measuredWidth4, measuredHeight5, this.etp.getMeasuredWidth() + measuredWidth4, this.etp.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.etq.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.etq.layout(measuredWidth5, i10, this.etq.getMeasuredWidth() + measuredWidth5, this.etq.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.etv, this.paint);
    }
}

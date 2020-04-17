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
    public static int gla = 1;
    private View contentView;
    private View glb;
    private View glc;
    private View gld;
    private int gle;
    private int glf;
    private int glg;
    private int glh;
    private Rect gli;
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
        this.gli = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gli = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.gli = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.gle = obtainStyledAttributes.getResourceId(0, -1);
            this.glf = obtainStyledAttributes.getResourceId(1, -1);
            this.glg = obtainStyledAttributes.getResourceId(2, -1);
            this.glh = obtainStyledAttributes.getResourceId(3, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.gle);
        if (this.glf != -1) {
            this.glb = findViewById(this.glf);
        }
        this.glc = findViewById(this.glg);
        this.gld = findViewById(this.glh);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.glc.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gld.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.gli.left = 0;
            this.gli.top = i5;
            this.gli.right = width;
            this.gli.bottom = height;
            if (this.glb != null) {
                int measuredWidth = (width - this.glb.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.glb.getMeasuredHeight()) / 2) + i5;
                this.glb.layout(measuredWidth, measuredHeight, this.glb.getMeasuredWidth() + measuredWidth, this.glb.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.glc.getMeasuredHeight()) / 2) + i5;
            this.glc.layout(i7, measuredHeight2, this.glc.getMeasuredWidth() + i7, this.glc.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.gld.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.gld.getMeasuredHeight()) / 2) + i5;
            this.gld.layout(measuredWidth2, measuredHeight3, this.gld.getMeasuredWidth() + measuredWidth2, this.gld.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.gli.left = i8;
        this.gli.top = 0;
        this.gli.right = width;
        this.gli.bottom = height;
        if (this.glb != null) {
            int measuredWidth3 = ((i9 - this.glb.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.glb.getMeasuredHeight()) / 2;
            this.glb.layout(measuredWidth3, measuredHeight4, this.glb.getMeasuredWidth() + measuredWidth3, this.glb.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.glc.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.glc.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.glc.layout(measuredWidth4, measuredHeight5, this.glc.getMeasuredWidth() + measuredWidth4, this.glc.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.gld.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.gld.layout(measuredWidth5, i10, this.gld.getMeasuredWidth() + measuredWidth5, this.gld.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.gli, this.paint);
    }
}

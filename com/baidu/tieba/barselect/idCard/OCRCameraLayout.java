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
/* loaded from: classes21.dex */
public class OCRCameraLayout extends FrameLayout {
    public static int ORIENTATION_PORTRAIT = 0;
    public static int ifh = 1;
    private View contentView;
    private View ifi;
    private View ifj;
    private View ifk;
    private int ifl;
    private int ifm;
    private int ifn;
    private int ifo;
    private Rect ifp;
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
        this.ifp = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.ifp = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    public OCRCameraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orientation = ORIENTATION_PORTRAIT;
        setWillNotDraw(false);
        this.ifp = new Rect();
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.argb(83, 0, 0, 0));
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.OCRCameraLayout, 0, 0);
        try {
            this.ifl = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_contentView, -1);
            this.ifm = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_centerView, -1);
            this.ifn = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_leftDownView, -1);
            this.ifo = obtainStyledAttributes.getResourceId(R.styleable.OCRCameraLayout_rightUpView, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.contentView = findViewById(this.ifl);
        if (this.ifm != -1) {
            this.ifi = findViewById(this.ifm);
        }
        this.ifj = findViewById(this.ifn);
        this.ifk = findViewById(this.ifo);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ifj.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ifk.getLayoutParams();
        if (i3 < i4) {
            int i5 = (width * 4) / 3;
            int i6 = height - i5;
            this.contentView.layout(i, i2, i3, i5);
            this.ifp.left = 0;
            this.ifp.top = i5;
            this.ifp.right = width;
            this.ifp.bottom = height;
            if (this.ifi != null) {
                int measuredWidth = (width - this.ifi.getMeasuredWidth()) / 2;
                int measuredHeight = ((i6 - this.ifi.getMeasuredHeight()) / 2) + i5;
                this.ifi.layout(measuredWidth, measuredHeight, this.ifi.getMeasuredWidth() + measuredWidth, this.ifi.getMeasuredHeight() + measuredHeight);
            }
            int i7 = marginLayoutParams.leftMargin;
            int measuredHeight2 = ((i6 - this.ifj.getMeasuredHeight()) / 2) + i5;
            this.ifj.layout(i7, measuredHeight2, this.ifj.getMeasuredWidth() + i7, this.ifj.getMeasuredHeight() + measuredHeight2);
            int measuredWidth2 = (width - this.ifk.getMeasuredWidth()) - marginLayoutParams2.rightMargin;
            int measuredHeight3 = ((i6 - this.ifk.getMeasuredHeight()) / 2) + i5;
            this.ifk.layout(measuredWidth2, measuredHeight3, this.ifk.getMeasuredWidth() + measuredWidth2, this.ifk.getMeasuredHeight() + measuredHeight3);
            return;
        }
        int i8 = (height * 4) / 3;
        int i9 = width - i8;
        this.contentView.layout(i, i2, i8, height);
        this.ifp.left = i8;
        this.ifp.top = 0;
        this.ifp.right = width;
        this.ifp.bottom = height;
        if (this.ifi != null) {
            int measuredWidth3 = ((i9 - this.ifi.getMeasuredWidth()) / 2) + i8;
            int measuredHeight4 = (height - this.ifi.getMeasuredHeight()) / 2;
            this.ifi.layout(measuredWidth3, measuredHeight4, this.ifi.getMeasuredWidth() + measuredWidth3, this.ifi.getMeasuredHeight() + measuredHeight4);
        }
        int measuredWidth4 = ((i9 - this.ifj.getMeasuredWidth()) / 2) + i8;
        int measuredHeight5 = (height - this.ifj.getMeasuredHeight()) - marginLayoutParams.bottomMargin;
        this.ifj.layout(measuredWidth4, measuredHeight5, this.ifj.getMeasuredWidth() + measuredWidth4, this.ifj.getMeasuredHeight() + measuredHeight5);
        int measuredWidth5 = ((i9 - this.ifk.getMeasuredWidth()) / 2) + i8;
        int i10 = marginLayoutParams2.topMargin;
        this.ifk.layout(measuredWidth5, i10, this.ifk.getMeasuredWidth() + measuredWidth5, this.ifk.getMeasuredHeight() + i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.ifp, this.paint);
    }
}

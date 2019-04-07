package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class PartingLineView extends ViewGroup {
    private View cUA;
    private int cUF;
    private int cUG;
    private Paint cUH;
    private int cUI;
    private int cUJ;
    private Path cUK;
    private Path cUL;
    private int cUM;
    private RectF cUN;
    private RectF cUO;
    private Paint cin;
    private int cio;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private Context mContext;
    private Path mRoundPath;
    private View mTopView;

    public PartingLineView(Context context) {
        this(context, null);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet, i);
    }

    private void c(Context context, AttributeSet attributeSet, int i) {
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.PartingLineView);
        this.cUF = obtainStyledAttributes.getColor(d.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.cUG = obtainStyledAttributes.getColor(d.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(d.l.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(d.l.PartingLineView_bgBorderWidth, 1);
        this.cUI = obtainStyledAttributes.getColor(d.l.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.cUJ = obtainStyledAttributes.getDimensionPixelOffset(d.l.PartingLineView_dividerLineHeight, 1);
        this.cUM = obtainStyledAttributes.getDimensionPixelOffset(d.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        dH(context);
    }

    private void dH(Context context) {
        setWillNotDraw(false);
        this.cio = this.cUF;
        this.cin = new Paint();
        this.cin.setStyle(Paint.Style.FILL);
        this.cin.setAntiAlias(true);
        this.cin.setColor(this.cio);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.cUH = new Paint();
        this.cUH.setStyle(Paint.Style.STROKE);
        this.cUH.setAntiAlias(true);
        this.cUH.setColor(this.cUI);
        this.cUH.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.cUH.setStrokeWidth(this.cUJ);
        this.cUK = new Path();
        this.cUL = new Path();
        this.mRoundPath = new Path();
        this.cUN = new RectF();
        this.cUO = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.cUA = view2;
            bi(this.mTopView);
            bi(this.cUA);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.cin != null) {
            this.cUF = this.mContext.getResources().getColor(i);
            this.cio = this.cUF;
            this.cin.setColor(this.cio);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.cUG = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.cUH != null) {
            this.cUI = this.mContext.getResources().getColor(i);
            this.cUH.setColor(this.cUI);
        }
    }

    private void bi(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void fX(boolean z) {
        if (this.cin != null) {
            this.cio = z ? this.cUG : this.cUF;
            this.cin.setColor(this.cio);
            invalidate();
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        measureChildren(i, i2);
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        }
        if (mode != 1073741824) {
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.cUJ + (this.cUA != null ? this.cUA.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.mTopView != null) {
            int i6 = paddingTop + 0;
            this.mTopView.layout(0 + paddingLeft, i6, 0 + paddingRight + this.mTopView.getMeasuredWidth(), this.mTopView.getMeasuredHeight() + i6);
            i5 = i6 + this.mTopView.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.cUA != null) {
            this.cUA.layout(paddingLeft + 0, this.cUJ + i5, 0 + paddingRight + this.cUA.getMeasuredWidth(), i5 + this.cUA.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.cUA != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.cUL.reset();
            this.cUL.moveTo(paddingLeft, paddingTop);
            this.cUL.lineTo(paddingLeft + width, paddingTop);
            this.cUL.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.cUM);
            this.cUN.set((paddingLeft + width) - this.cUM, (this.mTopView.getHeight() + paddingTop) - this.cUM, paddingLeft + width + this.cUM, this.mTopView.getHeight() + paddingTop + this.cUM);
            this.cUL.arcTo(this.cUN, 270.0f, -180.0f);
            this.cUL.lineTo(paddingLeft + width, paddingTop + height);
            this.cUL.lineTo(paddingLeft, paddingTop + height);
            this.cUL.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.cUM);
            this.cUN.set(paddingLeft - this.cUM, (this.mTopView.getHeight() + paddingTop) - this.cUM, this.cUM + paddingLeft, this.mTopView.getHeight() + paddingTop + this.cUM);
            this.cUL.arcTo(this.cUN, 90.0f, -180.0f);
            this.cUL.lineTo(paddingLeft, paddingTop);
            this.cUL.close();
            int i = this.mBorderWidth / 2;
            this.cUO.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cUO, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.cin != null) {
                canvas.drawPath(this.cUL, this.cin);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.cUL, this.mBorderPaint);
            }
            if (this.cUH != null && this.mTopView != null && this.cUA != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.cUK.reset();
                this.cUK.moveTo(paddingLeft + this.cUM + 9, height2);
                this.cUK.lineTo(((getWidth() - paddingRight) - this.cUM) - 9, height2);
                canvas.drawPath(this.cUK, this.cUH);
            }
        }
    }
}

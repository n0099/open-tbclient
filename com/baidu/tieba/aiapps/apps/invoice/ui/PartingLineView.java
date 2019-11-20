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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PartingLineView extends ViewGroup {
    private Paint aiV;
    private int cEf;
    private View doX;
    private View doY;
    private int dpd;
    private int dpe;
    private Paint dpf;
    private int dpg;
    private int dph;
    private Path dpi;
    private Path dpj;
    private int dpk;
    private RectF dpl;
    private RectF dpm;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private Context mContext;
    private Path mRoundPath;

    public PartingLineView(Context context) {
        this(context, null);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PartingLineView);
        this.dpd = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.dpe = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.dpg = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.dph = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.dpk = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        df(context);
    }

    private void df(Context context) {
        setWillNotDraw(false);
        this.cEf = this.dpd;
        this.aiV = new Paint();
        this.aiV.setStyle(Paint.Style.FILL);
        this.aiV.setAntiAlias(true);
        this.aiV.setColor(this.cEf);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.dpf = new Paint();
        this.dpf.setStyle(Paint.Style.STROKE);
        this.dpf.setAntiAlias(true);
        this.dpf.setColor(this.dpg);
        this.dpf.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.dpf.setStrokeWidth(this.dph);
        this.dpi = new Path();
        this.dpj = new Path();
        this.mRoundPath = new Path();
        this.dpl = new RectF();
        this.dpm = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.doX = view;
            this.doY = view2;
            bq(this.doX);
            bq(this.doY);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aiV != null) {
            this.dpd = this.mContext.getResources().getColor(i);
            this.cEf = this.dpd;
            this.aiV.setColor(this.cEf);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.dpe = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.dpf != null) {
            this.dpg = this.mContext.getResources().getColor(i);
            this.dpf.setColor(this.dpg);
        }
    }

    private void bq(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void gq(boolean z) {
        if (this.aiV != null) {
            this.cEf = z ? this.dpe : this.dpd;
            this.aiV.setColor(this.cEf);
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
            setMeasuredDimension(size, (this.doX != null ? this.doX.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.dph + (this.doY != null ? this.doY.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.doX != null) {
            int i6 = paddingTop + 0;
            this.doX.layout(0 + paddingLeft, i6, 0 + paddingRight + this.doX.getMeasuredWidth(), this.doX.getMeasuredHeight() + i6);
            i5 = i6 + this.doX.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.doY != null) {
            this.doY.layout(paddingLeft + 0, this.dph + i5, 0 + paddingRight + this.doY.getMeasuredWidth(), i5 + this.doY.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.doX != null && this.doY != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.dpj.reset();
            this.dpj.moveTo(paddingLeft, paddingTop);
            this.dpj.lineTo(paddingLeft + width, paddingTop);
            this.dpj.lineTo(paddingLeft + width, (this.doX.getHeight() + paddingTop) - this.dpk);
            this.dpl.set((paddingLeft + width) - this.dpk, (this.doX.getHeight() + paddingTop) - this.dpk, paddingLeft + width + this.dpk, this.doX.getHeight() + paddingTop + this.dpk);
            this.dpj.arcTo(this.dpl, 270.0f, -180.0f);
            this.dpj.lineTo(paddingLeft + width, paddingTop + height);
            this.dpj.lineTo(paddingLeft, paddingTop + height);
            this.dpj.lineTo(paddingLeft, this.doX.getHeight() + paddingTop + this.dpk);
            this.dpl.set(paddingLeft - this.dpk, (this.doX.getHeight() + paddingTop) - this.dpk, this.dpk + paddingLeft, this.doX.getHeight() + paddingTop + this.dpk);
            this.dpj.arcTo(this.dpl, 90.0f, -180.0f);
            this.dpj.lineTo(paddingLeft, paddingTop);
            this.dpj.close();
            int i = this.mBorderWidth / 2;
            this.dpm.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.dpm, 10.0f, 10.0f, Path.Direction.CCW);
            this.dpj.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.aiV != null) {
                canvas.drawPath(this.dpj, this.aiV);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.dpj, this.mBorderPaint);
            }
            if (this.dpf != null && this.doX != null && this.doY != null) {
                float height2 = paddingTop + this.doX.getHeight();
                this.dpi.reset();
                this.dpi.moveTo(paddingLeft + this.dpk + 9, height2);
                this.dpi.lineTo(((getWidth() - paddingRight) - this.dpk) - 9, height2);
                canvas.drawPath(this.dpi, this.dpf);
            }
        }
    }
}

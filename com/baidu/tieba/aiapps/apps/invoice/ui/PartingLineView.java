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
    private Paint ajn;
    private int cEW;
    private View dpO;
    private View dpP;
    private int dpU;
    private int dpV;
    private Paint dpW;
    private int dpX;
    private int dpY;
    private Path dpZ;
    private Path dqa;
    private int dqb;
    private RectF dqc;
    private RectF dqd;
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
        this.dpU = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.dpV = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.dpX = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.dpY = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.dqb = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        df(context);
    }

    private void df(Context context) {
        setWillNotDraw(false);
        this.cEW = this.dpU;
        this.ajn = new Paint();
        this.ajn.setStyle(Paint.Style.FILL);
        this.ajn.setAntiAlias(true);
        this.ajn.setColor(this.cEW);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.dpW = new Paint();
        this.dpW.setStyle(Paint.Style.STROKE);
        this.dpW.setAntiAlias(true);
        this.dpW.setColor(this.dpX);
        this.dpW.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.dpW.setStrokeWidth(this.dpY);
        this.dpZ = new Path();
        this.dqa = new Path();
        this.mRoundPath = new Path();
        this.dqc = new RectF();
        this.dqd = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.dpO = view;
            this.dpP = view2;
            bq(this.dpO);
            bq(this.dpP);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.ajn != null) {
            this.dpU = this.mContext.getResources().getColor(i);
            this.cEW = this.dpU;
            this.ajn.setColor(this.cEW);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.dpV = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.dpW != null) {
            this.dpX = this.mContext.getResources().getColor(i);
            this.dpW.setColor(this.dpX);
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
        if (this.ajn != null) {
            this.cEW = z ? this.dpV : this.dpU;
            this.ajn.setColor(this.cEW);
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
            setMeasuredDimension(size, (this.dpO != null ? this.dpO.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.dpY + (this.dpP != null ? this.dpP.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.dpO != null) {
            int i6 = paddingTop + 0;
            this.dpO.layout(0 + paddingLeft, i6, 0 + paddingRight + this.dpO.getMeasuredWidth(), this.dpO.getMeasuredHeight() + i6);
            i5 = i6 + this.dpO.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.dpP != null) {
            this.dpP.layout(paddingLeft + 0, this.dpY + i5, 0 + paddingRight + this.dpP.getMeasuredWidth(), i5 + this.dpP.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dpO != null && this.dpP != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.dqa.reset();
            this.dqa.moveTo(paddingLeft, paddingTop);
            this.dqa.lineTo(paddingLeft + width, paddingTop);
            this.dqa.lineTo(paddingLeft + width, (this.dpO.getHeight() + paddingTop) - this.dqb);
            this.dqc.set((paddingLeft + width) - this.dqb, (this.dpO.getHeight() + paddingTop) - this.dqb, paddingLeft + width + this.dqb, this.dpO.getHeight() + paddingTop + this.dqb);
            this.dqa.arcTo(this.dqc, 270.0f, -180.0f);
            this.dqa.lineTo(paddingLeft + width, paddingTop + height);
            this.dqa.lineTo(paddingLeft, paddingTop + height);
            this.dqa.lineTo(paddingLeft, this.dpO.getHeight() + paddingTop + this.dqb);
            this.dqc.set(paddingLeft - this.dqb, (this.dpO.getHeight() + paddingTop) - this.dqb, this.dqb + paddingLeft, this.dpO.getHeight() + paddingTop + this.dqb);
            this.dqa.arcTo(this.dqc, 90.0f, -180.0f);
            this.dqa.lineTo(paddingLeft, paddingTop);
            this.dqa.close();
            int i = this.mBorderWidth / 2;
            this.dqd.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.dqd, 10.0f, 10.0f, Path.Direction.CCW);
            this.dqa.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.ajn != null) {
                canvas.drawPath(this.dqa, this.ajn);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.dqa, this.mBorderPaint);
            }
            if (this.dpW != null && this.dpO != null && this.dpP != null) {
                float height2 = paddingTop + this.dpO.getHeight();
                this.dpZ.reset();
                this.dpZ.moveTo(paddingLeft + this.dqb + 9, height2);
                this.dpZ.lineTo(((getWidth() - paddingRight) - this.dqb) - 9, height2);
                canvas.drawPath(this.dpZ, this.dpW);
            }
        }
    }
}

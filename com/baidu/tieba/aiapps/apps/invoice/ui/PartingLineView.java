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
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class PartingLineView extends ViewGroup {
    private Paint cqv;
    private int cqw;
    private View dcZ;
    private int dde;
    private int ddf;
    private Paint ddg;
    private int ddh;
    private int ddi;
    private Path ddj;
    private Path ddk;
    private int ddl;
    private RectF ddm;
    private RectF ddn;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.PartingLineView);
        this.dde = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.ddf = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.ddh = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.ddi = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.ddl = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        du(context);
    }

    private void du(Context context) {
        setWillNotDraw(false);
        this.cqw = this.dde;
        this.cqv = new Paint();
        this.cqv.setStyle(Paint.Style.FILL);
        this.cqv.setAntiAlias(true);
        this.cqv.setColor(this.cqw);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.ddg = new Paint();
        this.ddg.setStyle(Paint.Style.STROKE);
        this.ddg.setAntiAlias(true);
        this.ddg.setColor(this.ddh);
        this.ddg.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.ddg.setStrokeWidth(this.ddi);
        this.ddj = new Path();
        this.ddk = new Path();
        this.mRoundPath = new Path();
        this.ddm = new RectF();
        this.ddn = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.dcZ = view2;
            bo(this.mTopView);
            bo(this.dcZ);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.cqv != null) {
            this.dde = this.mContext.getResources().getColor(i);
            this.cqw = this.dde;
            this.cqv.setColor(this.cqw);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.ddf = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.ddg != null) {
            this.ddh = this.mContext.getResources().getColor(i);
            this.ddg.setColor(this.ddh);
        }
    }

    private void bo(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void gu(boolean z) {
        if (this.cqv != null) {
            this.cqw = z ? this.ddf : this.dde;
            this.cqv.setColor(this.cqw);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.ddi + (this.dcZ != null ? this.dcZ.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.dcZ != null) {
            this.dcZ.layout(paddingLeft + 0, this.ddi + i5, 0 + paddingRight + this.dcZ.getMeasuredWidth(), i5 + this.dcZ.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.dcZ != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.ddk.reset();
            this.ddk.moveTo(paddingLeft, paddingTop);
            this.ddk.lineTo(paddingLeft + width, paddingTop);
            this.ddk.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.ddl);
            this.ddm.set((paddingLeft + width) - this.ddl, (this.mTopView.getHeight() + paddingTop) - this.ddl, paddingLeft + width + this.ddl, this.mTopView.getHeight() + paddingTop + this.ddl);
            this.ddk.arcTo(this.ddm, 270.0f, -180.0f);
            this.ddk.lineTo(paddingLeft + width, paddingTop + height);
            this.ddk.lineTo(paddingLeft, paddingTop + height);
            this.ddk.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.ddl);
            this.ddm.set(paddingLeft - this.ddl, (this.mTopView.getHeight() + paddingTop) - this.ddl, this.ddl + paddingLeft, this.mTopView.getHeight() + paddingTop + this.ddl);
            this.ddk.arcTo(this.ddm, 90.0f, -180.0f);
            this.ddk.lineTo(paddingLeft, paddingTop);
            this.ddk.close();
            int i = this.mBorderWidth / 2;
            this.ddn.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.ddn, 10.0f, 10.0f, Path.Direction.CCW);
            this.ddk.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.cqv != null) {
                canvas.drawPath(this.ddk, this.cqv);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.ddk, this.mBorderPaint);
            }
            if (this.ddg != null && this.mTopView != null && this.dcZ != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.ddj.reset();
                this.ddj.moveTo(paddingLeft + this.ddl + 9, height2);
                this.ddj.lineTo(((getWidth() - paddingRight) - this.ddl) - 9, height2);
                canvas.drawPath(this.ddj, this.ddg);
            }
        }
    }
}

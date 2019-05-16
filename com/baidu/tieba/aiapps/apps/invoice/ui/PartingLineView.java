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
    private View dcY;
    private int ddd;
    private int dde;
    private Paint ddf;
    private int ddg;
    private int ddh;
    private Path ddi;
    private Path ddj;
    private int ddk;
    private RectF ddl;
    private RectF ddm;
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
        this.ddd = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.dde = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.ddg = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.ddh = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.ddk = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        du(context);
    }

    private void du(Context context) {
        setWillNotDraw(false);
        this.cqw = this.ddd;
        this.cqv = new Paint();
        this.cqv.setStyle(Paint.Style.FILL);
        this.cqv.setAntiAlias(true);
        this.cqv.setColor(this.cqw);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.ddf = new Paint();
        this.ddf.setStyle(Paint.Style.STROKE);
        this.ddf.setAntiAlias(true);
        this.ddf.setColor(this.ddg);
        this.ddf.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.ddf.setStrokeWidth(this.ddh);
        this.ddi = new Path();
        this.ddj = new Path();
        this.mRoundPath = new Path();
        this.ddl = new RectF();
        this.ddm = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.dcY = view2;
            bo(this.mTopView);
            bo(this.dcY);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.cqv != null) {
            this.ddd = this.mContext.getResources().getColor(i);
            this.cqw = this.ddd;
            this.cqv.setColor(this.cqw);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.dde = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.ddf != null) {
            this.ddg = this.mContext.getResources().getColor(i);
            this.ddf.setColor(this.ddg);
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
            this.cqw = z ? this.dde : this.ddd;
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.ddh + (this.dcY != null ? this.dcY.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.dcY != null) {
            this.dcY.layout(paddingLeft + 0, this.ddh + i5, 0 + paddingRight + this.dcY.getMeasuredWidth(), i5 + this.dcY.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.dcY != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.ddj.reset();
            this.ddj.moveTo(paddingLeft, paddingTop);
            this.ddj.lineTo(paddingLeft + width, paddingTop);
            this.ddj.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.ddk);
            this.ddl.set((paddingLeft + width) - this.ddk, (this.mTopView.getHeight() + paddingTop) - this.ddk, paddingLeft + width + this.ddk, this.mTopView.getHeight() + paddingTop + this.ddk);
            this.ddj.arcTo(this.ddl, 270.0f, -180.0f);
            this.ddj.lineTo(paddingLeft + width, paddingTop + height);
            this.ddj.lineTo(paddingLeft, paddingTop + height);
            this.ddj.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.ddk);
            this.ddl.set(paddingLeft - this.ddk, (this.mTopView.getHeight() + paddingTop) - this.ddk, this.ddk + paddingLeft, this.mTopView.getHeight() + paddingTop + this.ddk);
            this.ddj.arcTo(this.ddl, 90.0f, -180.0f);
            this.ddj.lineTo(paddingLeft, paddingTop);
            this.ddj.close();
            int i = this.mBorderWidth / 2;
            this.ddm.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.ddm, 10.0f, 10.0f, Path.Direction.CCW);
            this.ddj.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.cqv != null) {
                canvas.drawPath(this.ddj, this.cqv);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.ddj, this.mBorderPaint);
            }
            if (this.ddf != null && this.mTopView != null && this.dcY != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.ddi.reset();
                this.ddi.moveTo(paddingLeft + this.ddk + 9, height2);
                this.ddi.lineTo(((getWidth() - paddingRight) - this.ddk) - 9, height2);
                canvas.drawPath(this.ddi, this.ddf);
            }
        }
    }
}

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
    private Paint cqw;
    private int cqx;
    private View dda;
    private int ddf;
    private int ddg;
    private Paint ddh;
    private int ddi;
    private int ddj;
    private Path ddk;
    private Path ddl;
    private int ddm;
    private RectF ddn;
    private RectF ddo;
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
        this.ddf = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.ddg = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.ddi = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.ddj = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.ddm = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        du(context);
    }

    private void du(Context context) {
        setWillNotDraw(false);
        this.cqx = this.ddf;
        this.cqw = new Paint();
        this.cqw.setStyle(Paint.Style.FILL);
        this.cqw.setAntiAlias(true);
        this.cqw.setColor(this.cqx);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.ddh = new Paint();
        this.ddh.setStyle(Paint.Style.STROKE);
        this.ddh.setAntiAlias(true);
        this.ddh.setColor(this.ddi);
        this.ddh.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.ddh.setStrokeWidth(this.ddj);
        this.ddk = new Path();
        this.ddl = new Path();
        this.mRoundPath = new Path();
        this.ddn = new RectF();
        this.ddo = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.dda = view2;
            bo(this.mTopView);
            bo(this.dda);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.cqw != null) {
            this.ddf = this.mContext.getResources().getColor(i);
            this.cqx = this.ddf;
            this.cqw.setColor(this.cqx);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.ddg = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.ddh != null) {
            this.ddi = this.mContext.getResources().getColor(i);
            this.ddh.setColor(this.ddi);
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
        if (this.cqw != null) {
            this.cqx = z ? this.ddg : this.ddf;
            this.cqw.setColor(this.cqx);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.ddj + (this.dda != null ? this.dda.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.dda != null) {
            this.dda.layout(paddingLeft + 0, this.ddj + i5, 0 + paddingRight + this.dda.getMeasuredWidth(), i5 + this.dda.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.dda != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.ddl.reset();
            this.ddl.moveTo(paddingLeft, paddingTop);
            this.ddl.lineTo(paddingLeft + width, paddingTop);
            this.ddl.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.ddm);
            this.ddn.set((paddingLeft + width) - this.ddm, (this.mTopView.getHeight() + paddingTop) - this.ddm, paddingLeft + width + this.ddm, this.mTopView.getHeight() + paddingTop + this.ddm);
            this.ddl.arcTo(this.ddn, 270.0f, -180.0f);
            this.ddl.lineTo(paddingLeft + width, paddingTop + height);
            this.ddl.lineTo(paddingLeft, paddingTop + height);
            this.ddl.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.ddm);
            this.ddn.set(paddingLeft - this.ddm, (this.mTopView.getHeight() + paddingTop) - this.ddm, this.ddm + paddingLeft, this.mTopView.getHeight() + paddingTop + this.ddm);
            this.ddl.arcTo(this.ddn, 90.0f, -180.0f);
            this.ddl.lineTo(paddingLeft, paddingTop);
            this.ddl.close();
            int i = this.mBorderWidth / 2;
            this.ddo.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.ddo, 10.0f, 10.0f, Path.Direction.CCW);
            this.ddl.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.cqw != null) {
                canvas.drawPath(this.ddl, this.cqw);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.ddl, this.mBorderPaint);
            }
            if (this.ddh != null && this.mTopView != null && this.dda != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.ddk.reset();
                this.ddk.moveTo(paddingLeft + this.ddm + 9, height2);
                this.ddk.lineTo(((getWidth() - paddingRight) - this.ddm) - 9, height2);
                canvas.drawPath(this.ddk, this.ddh);
            }
        }
    }
}

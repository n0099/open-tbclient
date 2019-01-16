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
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class PartingLineView extends ViewGroup {
    private Paint aYN;
    private View bJc;
    private int bJh;
    private int bJi;
    private Paint bJj;
    private int bJk;
    private int bJl;
    private Path bJm;
    private Path bJn;
    private int bJo;
    private RectF bJp;
    private RectF bJq;
    private int mBgColor;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.PartingLineView);
        this.bJh = obtainStyledAttributes.getColor(e.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.bJi = obtainStyledAttributes.getColor(e.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(e.l.PartingLineView_bgBorderColor, -16777216);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_bgBorderWidth, 1);
        this.bJk = obtainStyledAttributes.getColor(e.l.PartingLineView_dividerLineColor, -16777216);
        this.bJl = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerLineHeight, 1);
        this.bJo = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        ck(context);
    }

    private void ck(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.bJh;
        this.aYN = new Paint();
        this.aYN.setStyle(Paint.Style.FILL);
        this.aYN.setAntiAlias(true);
        this.aYN.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.bJj = new Paint();
        this.bJj.setStyle(Paint.Style.STROKE);
        this.bJj.setAntiAlias(true);
        this.bJj.setColor(this.bJk);
        this.bJj.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.bJj.setStrokeWidth(this.bJl);
        this.bJm = new Path();
        this.bJn = new Path();
        this.mRoundPath = new Path();
        this.bJp = new RectF();
        this.bJq = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.bJc = view2;
            al(this.mTopView);
            al(this.bJc);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aYN != null) {
            this.bJh = this.mContext.getResources().getColor(i);
            this.mBgColor = this.bJh;
            this.aYN.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.bJi = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.bJj != null) {
            this.bJk = this.mContext.getResources().getColor(i);
            this.bJj.setColor(this.bJk);
        }
    }

    private void al(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void dF(boolean z) {
        if (this.aYN != null) {
            this.mBgColor = z ? this.bJi : this.bJh;
            this.aYN.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.bJl + (this.bJc != null ? this.bJc.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.bJc != null) {
            this.bJc.layout(paddingLeft + 0, this.bJl + i5, 0 + paddingRight + this.bJc.getMeasuredWidth(), i5 + this.bJc.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.bJc != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.bJn.reset();
            this.bJn.moveTo(paddingLeft, paddingTop);
            this.bJn.lineTo(paddingLeft + width, paddingTop);
            this.bJn.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.bJo);
            this.bJp.set((paddingLeft + width) - this.bJo, (this.mTopView.getHeight() + paddingTop) - this.bJo, paddingLeft + width + this.bJo, this.mTopView.getHeight() + paddingTop + this.bJo);
            this.bJn.arcTo(this.bJp, 270.0f, -180.0f);
            this.bJn.lineTo(paddingLeft + width, paddingTop + height);
            this.bJn.lineTo(paddingLeft, paddingTop + height);
            this.bJn.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.bJo);
            this.bJp.set(paddingLeft - this.bJo, (this.mTopView.getHeight() + paddingTop) - this.bJo, this.bJo + paddingLeft, this.mTopView.getHeight() + paddingTop + this.bJo);
            this.bJn.arcTo(this.bJp, 90.0f, -180.0f);
            this.bJn.lineTo(paddingLeft, paddingTop);
            this.bJn.close();
            int i = this.mBorderWidth / 2;
            this.bJq.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.bJq, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.aYN != null) {
                canvas.drawPath(this.bJn, this.aYN);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.bJn, this.mBorderPaint);
            }
            if (this.bJj != null && this.mTopView != null && this.bJc != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.bJm.reset();
                this.bJm.moveTo(paddingLeft + this.bJo + 9, height2);
                this.bJm.lineTo(((getWidth() - paddingRight) - this.bJo) - 9, height2);
                canvas.drawPath(this.bJm, this.bJj);
            }
        }
    }
}

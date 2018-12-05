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
    private Paint aYa;
    private RectF bIA;
    private View bIm;
    private int bIr;
    private int bIs;
    private Paint bIt;
    private int bIu;
    private int bIv;
    private Path bIw;
    private Path bIx;
    private int bIy;
    private RectF bIz;
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
        this.bIr = obtainStyledAttributes.getColor(e.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.bIs = obtainStyledAttributes.getColor(e.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(e.l.PartingLineView_bgBorderColor, -16777216);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_bgBorderWidth, 1);
        this.bIu = obtainStyledAttributes.getColor(e.l.PartingLineView_dividerLineColor, -16777216);
        this.bIv = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerLineHeight, 1);
        this.bIy = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        ck(context);
    }

    private void ck(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.bIr;
        this.aYa = new Paint();
        this.aYa.setStyle(Paint.Style.FILL);
        this.aYa.setAntiAlias(true);
        this.aYa.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.bIt = new Paint();
        this.bIt.setStyle(Paint.Style.STROKE);
        this.bIt.setAntiAlias(true);
        this.bIt.setColor(this.bIu);
        this.bIt.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.bIt.setStrokeWidth(this.bIv);
        this.bIw = new Path();
        this.bIx = new Path();
        this.mRoundPath = new Path();
        this.bIz = new RectF();
        this.bIA = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.bIm = view2;
            al(this.mTopView);
            al(this.bIm);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aYa != null) {
            this.bIr = this.mContext.getResources().getColor(i);
            this.mBgColor = this.bIr;
            this.aYa.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.bIs = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.bIt != null) {
            this.bIu = this.mContext.getResources().getColor(i);
            this.bIt.setColor(this.bIu);
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

    public void dC(boolean z) {
        if (this.aYa != null) {
            this.mBgColor = z ? this.bIs : this.bIr;
            this.aYa.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.bIv + (this.bIm != null ? this.bIm.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.bIm != null) {
            this.bIm.layout(paddingLeft + 0, this.bIv + i5, 0 + paddingRight + this.bIm.getMeasuredWidth(), i5 + this.bIm.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.bIm != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.bIx.reset();
            this.bIx.moveTo(paddingLeft, paddingTop);
            this.bIx.lineTo(paddingLeft + width, paddingTop);
            this.bIx.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.bIy);
            this.bIz.set((paddingLeft + width) - this.bIy, (this.mTopView.getHeight() + paddingTop) - this.bIy, paddingLeft + width + this.bIy, this.mTopView.getHeight() + paddingTop + this.bIy);
            this.bIx.arcTo(this.bIz, 270.0f, -180.0f);
            this.bIx.lineTo(paddingLeft + width, paddingTop + height);
            this.bIx.lineTo(paddingLeft, paddingTop + height);
            this.bIx.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.bIy);
            this.bIz.set(paddingLeft - this.bIy, (this.mTopView.getHeight() + paddingTop) - this.bIy, this.bIy + paddingLeft, this.mTopView.getHeight() + paddingTop + this.bIy);
            this.bIx.arcTo(this.bIz, 90.0f, -180.0f);
            this.bIx.lineTo(paddingLeft, paddingTop);
            this.bIx.close();
            int i = this.mBorderWidth / 2;
            this.bIA.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.bIA, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.aYa != null) {
                canvas.drawPath(this.bIx, this.aYa);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.bIx, this.mBorderPaint);
            }
            if (this.bIt != null && this.mTopView != null && this.bIm != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.bIw.reset();
                this.bIw.moveTo(paddingLeft + this.bIy + 9, height2);
                this.bIw.lineTo(((getWidth() - paddingRight) - this.bIy) - 9, height2);
                canvas.drawPath(this.bIw, this.bIt);
            }
        }
    }
}

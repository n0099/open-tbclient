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
    private Paint aYd;
    private Path bIA;
    private int bIB;
    private RectF bIC;
    private RectF bID;
    private View bIp;
    private int bIu;
    private int bIv;
    private Paint bIw;
    private int bIx;
    private int bIy;
    private Path bIz;
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
        this.bIu = obtainStyledAttributes.getColor(e.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.bIv = obtainStyledAttributes.getColor(e.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(e.l.PartingLineView_bgBorderColor, -16777216);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_bgBorderWidth, 1);
        this.bIx = obtainStyledAttributes.getColor(e.l.PartingLineView_dividerLineColor, -16777216);
        this.bIy = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerLineHeight, 1);
        this.bIB = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        ck(context);
    }

    private void ck(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.bIu;
        this.aYd = new Paint();
        this.aYd.setStyle(Paint.Style.FILL);
        this.aYd.setAntiAlias(true);
        this.aYd.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.bIw = new Paint();
        this.bIw.setStyle(Paint.Style.STROKE);
        this.bIw.setAntiAlias(true);
        this.bIw.setColor(this.bIx);
        this.bIw.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.bIw.setStrokeWidth(this.bIy);
        this.bIz = new Path();
        this.bIA = new Path();
        this.mRoundPath = new Path();
        this.bIC = new RectF();
        this.bID = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.bIp = view2;
            al(this.mTopView);
            al(this.bIp);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aYd != null) {
            this.bIu = this.mContext.getResources().getColor(i);
            this.mBgColor = this.bIu;
            this.aYd.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.bIv = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.bIw != null) {
            this.bIx = this.mContext.getResources().getColor(i);
            this.bIw.setColor(this.bIx);
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
        if (this.aYd != null) {
            this.mBgColor = z ? this.bIv : this.bIu;
            this.aYd.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.bIy + (this.bIp != null ? this.bIp.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.bIp != null) {
            this.bIp.layout(paddingLeft + 0, this.bIy + i5, 0 + paddingRight + this.bIp.getMeasuredWidth(), i5 + this.bIp.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.bIp != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.bIA.reset();
            this.bIA.moveTo(paddingLeft, paddingTop);
            this.bIA.lineTo(paddingLeft + width, paddingTop);
            this.bIA.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.bIB);
            this.bIC.set((paddingLeft + width) - this.bIB, (this.mTopView.getHeight() + paddingTop) - this.bIB, paddingLeft + width + this.bIB, this.mTopView.getHeight() + paddingTop + this.bIB);
            this.bIA.arcTo(this.bIC, 270.0f, -180.0f);
            this.bIA.lineTo(paddingLeft + width, paddingTop + height);
            this.bIA.lineTo(paddingLeft, paddingTop + height);
            this.bIA.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.bIB);
            this.bIC.set(paddingLeft - this.bIB, (this.mTopView.getHeight() + paddingTop) - this.bIB, this.bIB + paddingLeft, this.mTopView.getHeight() + paddingTop + this.bIB);
            this.bIA.arcTo(this.bIC, 90.0f, -180.0f);
            this.bIA.lineTo(paddingLeft, paddingTop);
            this.bIA.close();
            int i = this.mBorderWidth / 2;
            this.bID.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.bID, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.aYd != null) {
                canvas.drawPath(this.bIA, this.aYd);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.bIA, this.mBorderPaint);
            }
            if (this.bIw != null && this.mTopView != null && this.bIp != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.bIz.reset();
                this.bIz.moveTo(paddingLeft + this.bIB + 9, height2);
                this.bIz.lineTo(((getWidth() - paddingRight) - this.bIB) - 9, height2);
                canvas.drawPath(this.bIz, this.bIw);
            }
        }
    }
}

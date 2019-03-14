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
    private int cUD;
    private int cUE;
    private Paint cUF;
    private int cUG;
    private int cUH;
    private Path cUI;
    private Path cUJ;
    private int cUK;
    private RectF cUL;
    private RectF cUM;
    private View cUy;
    private Paint cil;
    private int cim;
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
        this.cUD = obtainStyledAttributes.getColor(d.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.cUE = obtainStyledAttributes.getColor(d.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(d.l.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(d.l.PartingLineView_bgBorderWidth, 1);
        this.cUG = obtainStyledAttributes.getColor(d.l.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.cUH = obtainStyledAttributes.getDimensionPixelOffset(d.l.PartingLineView_dividerLineHeight, 1);
        this.cUK = obtainStyledAttributes.getDimensionPixelOffset(d.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        dH(context);
    }

    private void dH(Context context) {
        setWillNotDraw(false);
        this.cim = this.cUD;
        this.cil = new Paint();
        this.cil.setStyle(Paint.Style.FILL);
        this.cil.setAntiAlias(true);
        this.cil.setColor(this.cim);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.cUF = new Paint();
        this.cUF.setStyle(Paint.Style.STROKE);
        this.cUF.setAntiAlias(true);
        this.cUF.setColor(this.cUG);
        this.cUF.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.cUF.setStrokeWidth(this.cUH);
        this.cUI = new Path();
        this.cUJ = new Path();
        this.mRoundPath = new Path();
        this.cUL = new RectF();
        this.cUM = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.cUy = view2;
            bi(this.mTopView);
            bi(this.cUy);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.cil != null) {
            this.cUD = this.mContext.getResources().getColor(i);
            this.cim = this.cUD;
            this.cil.setColor(this.cim);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.cUE = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.cUF != null) {
            this.cUG = this.mContext.getResources().getColor(i);
            this.cUF.setColor(this.cUG);
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
        if (this.cil != null) {
            this.cim = z ? this.cUE : this.cUD;
            this.cil.setColor(this.cim);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.cUH + (this.cUy != null ? this.cUy.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.cUy != null) {
            this.cUy.layout(paddingLeft + 0, this.cUH + i5, 0 + paddingRight + this.cUy.getMeasuredWidth(), i5 + this.cUy.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.cUy != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.cUJ.reset();
            this.cUJ.moveTo(paddingLeft, paddingTop);
            this.cUJ.lineTo(paddingLeft + width, paddingTop);
            this.cUJ.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.cUK);
            this.cUL.set((paddingLeft + width) - this.cUK, (this.mTopView.getHeight() + paddingTop) - this.cUK, paddingLeft + width + this.cUK, this.mTopView.getHeight() + paddingTop + this.cUK);
            this.cUJ.arcTo(this.cUL, 270.0f, -180.0f);
            this.cUJ.lineTo(paddingLeft + width, paddingTop + height);
            this.cUJ.lineTo(paddingLeft, paddingTop + height);
            this.cUJ.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.cUK);
            this.cUL.set(paddingLeft - this.cUK, (this.mTopView.getHeight() + paddingTop) - this.cUK, this.cUK + paddingLeft, this.mTopView.getHeight() + paddingTop + this.cUK);
            this.cUJ.arcTo(this.cUL, 90.0f, -180.0f);
            this.cUJ.lineTo(paddingLeft, paddingTop);
            this.cUJ.close();
            int i = this.mBorderWidth / 2;
            this.cUM.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cUM, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.cil != null) {
                canvas.drawPath(this.cUJ, this.cil);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.cUJ, this.mBorderPaint);
            }
            if (this.cUF != null && this.mTopView != null && this.cUy != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.cUI.reset();
                this.cUI.moveTo(paddingLeft + this.cUK + 9, height2);
                this.cUI.lineTo(((getWidth() - paddingRight) - this.cUK) - 9, height2);
                canvas.drawPath(this.cUI, this.cUF);
            }
        }
    }
}

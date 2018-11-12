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
    private Paint aUD;
    private View bEJ;
    private int bEO;
    private int bEP;
    private Paint bEQ;
    private int bER;
    private int bES;
    private Path bET;
    private Path bEU;
    private int bEV;
    private RectF bEW;
    private RectF bEX;
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
        this.bEO = obtainStyledAttributes.getColor(e.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.bEP = obtainStyledAttributes.getColor(e.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(e.l.PartingLineView_bgBorderColor, -16777216);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_bgBorderWidth, 1);
        this.bER = obtainStyledAttributes.getColor(e.l.PartingLineView_dividerLineColor, -16777216);
        this.bES = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerLineHeight, 1);
        this.bEV = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        ch(context);
    }

    private void ch(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.bEO;
        this.aUD = new Paint();
        this.aUD.setStyle(Paint.Style.FILL);
        this.aUD.setAntiAlias(true);
        this.aUD.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.bEQ = new Paint();
        this.bEQ.setStyle(Paint.Style.STROKE);
        this.bEQ.setAntiAlias(true);
        this.bEQ.setColor(this.bER);
        this.bEQ.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.bEQ.setStrokeWidth(this.bES);
        this.bET = new Path();
        this.bEU = new Path();
        this.mRoundPath = new Path();
        this.bEW = new RectF();
        this.bEX = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.bEJ = view2;
            al(this.mTopView);
            al(this.bEJ);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aUD != null) {
            this.bEO = this.mContext.getResources().getColor(i);
            this.mBgColor = this.bEO;
            this.aUD.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.bEP = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.bEQ != null) {
            this.bER = this.mContext.getResources().getColor(i);
            this.bEQ.setColor(this.bER);
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

    public void dB(boolean z) {
        if (this.aUD != null) {
            this.mBgColor = z ? this.bEP : this.bEO;
            this.aUD.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.bES + (this.bEJ != null ? this.bEJ.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.bEJ != null) {
            this.bEJ.layout(paddingLeft + 0, this.bES + i5, 0 + paddingRight + this.bEJ.getMeasuredWidth(), i5 + this.bEJ.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.bEJ != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.bEU.reset();
            this.bEU.moveTo(paddingLeft, paddingTop);
            this.bEU.lineTo(paddingLeft + width, paddingTop);
            this.bEU.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.bEV);
            this.bEW.set((paddingLeft + width) - this.bEV, (this.mTopView.getHeight() + paddingTop) - this.bEV, paddingLeft + width + this.bEV, this.mTopView.getHeight() + paddingTop + this.bEV);
            this.bEU.arcTo(this.bEW, 270.0f, -180.0f);
            this.bEU.lineTo(paddingLeft + width, paddingTop + height);
            this.bEU.lineTo(paddingLeft, paddingTop + height);
            this.bEU.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.bEV);
            this.bEW.set(paddingLeft - this.bEV, (this.mTopView.getHeight() + paddingTop) - this.bEV, this.bEV + paddingLeft, this.mTopView.getHeight() + paddingTop + this.bEV);
            this.bEU.arcTo(this.bEW, 90.0f, -180.0f);
            this.bEU.lineTo(paddingLeft, paddingTop);
            this.bEU.close();
            int i = this.mBorderWidth / 2;
            this.bEX.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.bEX, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.aUD != null) {
                canvas.drawPath(this.bEU, this.aUD);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.bEU, this.mBorderPaint);
            }
            if (this.bEQ != null && this.mTopView != null && this.bEJ != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.bET.reset();
                this.bET.moveTo(paddingLeft + this.bEV + 9, height2);
                this.bET.lineTo(((getWidth() - paddingRight) - this.bEV) - 9, height2);
                canvas.drawPath(this.bET, this.bEQ);
            }
        }
    }
}

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
    private Paint GF;
    private int GW;
    private Paint csM;
    private int csN;
    private Paint dgA;
    private int dgB;
    private int dgC;
    private Path dgD;
    private Path dgE;
    private int dgF;
    private RectF dgG;
    private RectF dgH;
    private View dgt;
    private int dgy;
    private int dgz;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.PartingLineView);
        this.dgy = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.dgz = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.GW = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.dgB = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.dgC = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.dgF = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        dw(context);
    }

    private void dw(Context context) {
        setWillNotDraw(false);
        this.csN = this.dgy;
        this.csM = new Paint();
        this.csM.setStyle(Paint.Style.FILL);
        this.csM.setAntiAlias(true);
        this.csM.setColor(this.csN);
        this.GF = new Paint();
        this.GF.setStyle(Paint.Style.STROKE);
        this.GF.setAntiAlias(true);
        this.GF.setColor(this.GW);
        this.GF.setStrokeWidth(this.mBorderWidth);
        this.dgA = new Paint();
        this.dgA.setStyle(Paint.Style.STROKE);
        this.dgA.setAntiAlias(true);
        this.dgA.setColor(this.dgB);
        this.dgA.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.dgA.setStrokeWidth(this.dgC);
        this.dgD = new Path();
        this.dgE = new Path();
        this.mRoundPath = new Path();
        this.dgG = new RectF();
        this.dgH = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.dgt = view2;
            bq(this.mTopView);
            bq(this.dgt);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.csM != null) {
            this.dgy = this.mContext.getResources().getColor(i);
            this.csN = this.dgy;
            this.csM.setColor(this.csN);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.dgz = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.GF != null) {
            this.GW = this.mContext.getResources().getColor(i);
            this.GF.setColor(this.GW);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.dgA != null) {
            this.dgB = this.mContext.getResources().getColor(i);
            this.dgA.setColor(this.dgB);
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

    public void gB(boolean z) {
        if (this.csM != null) {
            this.csN = z ? this.dgz : this.dgy;
            this.csM.setColor(this.csN);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.dgC + (this.dgt != null ? this.dgt.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.dgt != null) {
            this.dgt.layout(paddingLeft + 0, this.dgC + i5, 0 + paddingRight + this.dgt.getMeasuredWidth(), i5 + this.dgt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.dgt != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.dgE.reset();
            this.dgE.moveTo(paddingLeft, paddingTop);
            this.dgE.lineTo(paddingLeft + width, paddingTop);
            this.dgE.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.dgF);
            this.dgG.set((paddingLeft + width) - this.dgF, (this.mTopView.getHeight() + paddingTop) - this.dgF, paddingLeft + width + this.dgF, this.mTopView.getHeight() + paddingTop + this.dgF);
            this.dgE.arcTo(this.dgG, 270.0f, -180.0f);
            this.dgE.lineTo(paddingLeft + width, paddingTop + height);
            this.dgE.lineTo(paddingLeft, paddingTop + height);
            this.dgE.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.dgF);
            this.dgG.set(paddingLeft - this.dgF, (this.mTopView.getHeight() + paddingTop) - this.dgF, this.dgF + paddingLeft, this.mTopView.getHeight() + paddingTop + this.dgF);
            this.dgE.arcTo(this.dgG, 90.0f, -180.0f);
            this.dgE.lineTo(paddingLeft, paddingTop);
            this.dgE.close();
            int i = this.mBorderWidth / 2;
            this.dgH.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.dgH, 10.0f, 10.0f, Path.Direction.CCW);
            this.dgE.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.csM != null) {
                canvas.drawPath(this.dgE, this.csM);
            }
            if (this.GF != null) {
                canvas.drawPath(this.dgE, this.GF);
            }
            if (this.dgA != null && this.mTopView != null && this.dgt != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.dgD.reset();
                this.dgD.moveTo(paddingLeft + this.dgF + 9, height2);
                this.dgD.lineTo(((getWidth() - paddingRight) - this.dgF) - 9, height2);
                canvas.drawPath(this.dgD, this.dgA);
            }
        }
    }
}

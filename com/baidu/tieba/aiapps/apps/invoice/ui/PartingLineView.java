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
    private Paint GF;
    private int GW;
    private Paint crR;
    private int crS;
    private View deI;
    private int deN;
    private int deO;
    private Paint deP;
    private int deQ;
    private int deR;
    private Path deS;
    private Path deT;
    private int deU;
    private RectF deV;
    private RectF deW;
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
        this.deN = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.deO = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.GW = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.deQ = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.deR = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.deU = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        dv(context);
    }

    private void dv(Context context) {
        setWillNotDraw(false);
        this.crS = this.deN;
        this.crR = new Paint();
        this.crR.setStyle(Paint.Style.FILL);
        this.crR.setAntiAlias(true);
        this.crR.setColor(this.crS);
        this.GF = new Paint();
        this.GF.setStyle(Paint.Style.STROKE);
        this.GF.setAntiAlias(true);
        this.GF.setColor(this.GW);
        this.GF.setStrokeWidth(this.mBorderWidth);
        this.deP = new Paint();
        this.deP.setStyle(Paint.Style.STROKE);
        this.deP.setAntiAlias(true);
        this.deP.setColor(this.deQ);
        this.deP.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.deP.setStrokeWidth(this.deR);
        this.deS = new Path();
        this.deT = new Path();
        this.mRoundPath = new Path();
        this.deV = new RectF();
        this.deW = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.deI = view2;
            bq(this.mTopView);
            bq(this.deI);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.crR != null) {
            this.deN = this.mContext.getResources().getColor(i);
            this.crS = this.deN;
            this.crR.setColor(this.crS);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.deO = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.GF != null) {
            this.GW = this.mContext.getResources().getColor(i);
            this.GF.setColor(this.GW);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.deP != null) {
            this.deQ = this.mContext.getResources().getColor(i);
            this.deP.setColor(this.deQ);
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

    public void gy(boolean z) {
        if (this.crR != null) {
            this.crS = z ? this.deO : this.deN;
            this.crR.setColor(this.crS);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.deR + (this.deI != null ? this.deI.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.deI != null) {
            this.deI.layout(paddingLeft + 0, this.deR + i5, 0 + paddingRight + this.deI.getMeasuredWidth(), i5 + this.deI.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.deI != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.deT.reset();
            this.deT.moveTo(paddingLeft, paddingTop);
            this.deT.lineTo(paddingLeft + width, paddingTop);
            this.deT.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.deU);
            this.deV.set((paddingLeft + width) - this.deU, (this.mTopView.getHeight() + paddingTop) - this.deU, paddingLeft + width + this.deU, this.mTopView.getHeight() + paddingTop + this.deU);
            this.deT.arcTo(this.deV, 270.0f, -180.0f);
            this.deT.lineTo(paddingLeft + width, paddingTop + height);
            this.deT.lineTo(paddingLeft, paddingTop + height);
            this.deT.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.deU);
            this.deV.set(paddingLeft - this.deU, (this.mTopView.getHeight() + paddingTop) - this.deU, this.deU + paddingLeft, this.mTopView.getHeight() + paddingTop + this.deU);
            this.deT.arcTo(this.deV, 90.0f, -180.0f);
            this.deT.lineTo(paddingLeft, paddingTop);
            this.deT.close();
            int i = this.mBorderWidth / 2;
            this.deW.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.deW, 10.0f, 10.0f, Path.Direction.CCW);
            this.deT.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.crR != null) {
                canvas.drawPath(this.deT, this.crR);
            }
            if (this.GF != null) {
                canvas.drawPath(this.deT, this.GF);
            }
            if (this.deP != null && this.mTopView != null && this.deI != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.deS.reset();
                this.deS.moveTo(paddingLeft + this.deU + 9, height2);
                this.deS.lineTo(((getWidth() - paddingRight) - this.deU) - 9, height2);
                canvas.drawPath(this.deS, this.deP);
            }
        }
    }
}

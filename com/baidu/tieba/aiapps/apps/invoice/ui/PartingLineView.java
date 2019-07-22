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
    private Paint crK;
    private int crL;
    private View deB;
    private int deG;
    private int deH;
    private Paint deI;
    private int deJ;
    private int deK;
    private Path deL;
    private Path deM;
    private int deN;
    private RectF deO;
    private RectF deP;
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
        this.deG = obtainStyledAttributes.getColor(0, SupportMenu.CATEGORY_MASK);
        this.deH = obtainStyledAttributes.getColor(1, SupportMenu.CATEGORY_MASK);
        this.GW = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(3, 1);
        this.deJ = obtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        this.deK = obtainStyledAttributes.getDimensionPixelOffset(5, 1);
        this.deN = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        obtainStyledAttributes.recycle();
        dv(context);
    }

    private void dv(Context context) {
        setWillNotDraw(false);
        this.crL = this.deG;
        this.crK = new Paint();
        this.crK.setStyle(Paint.Style.FILL);
        this.crK.setAntiAlias(true);
        this.crK.setColor(this.crL);
        this.GF = new Paint();
        this.GF.setStyle(Paint.Style.STROKE);
        this.GF.setAntiAlias(true);
        this.GF.setColor(this.GW);
        this.GF.setStrokeWidth(this.mBorderWidth);
        this.deI = new Paint();
        this.deI.setStyle(Paint.Style.STROKE);
        this.deI.setAntiAlias(true);
        this.deI.setColor(this.deJ);
        this.deI.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.deI.setStrokeWidth(this.deK);
        this.deL = new Path();
        this.deM = new Path();
        this.mRoundPath = new Path();
        this.deO = new RectF();
        this.deP = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.deB = view2;
            bq(this.mTopView);
            bq(this.deB);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.crK != null) {
            this.deG = this.mContext.getResources().getColor(i);
            this.crL = this.deG;
            this.crK.setColor(this.crL);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.deH = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.GF != null) {
            this.GW = this.mContext.getResources().getColor(i);
            this.GF.setColor(this.GW);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.deI != null) {
            this.deJ = this.mContext.getResources().getColor(i);
            this.deI.setColor(this.deJ);
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
        if (this.crK != null) {
            this.crL = z ? this.deH : this.deG;
            this.crK.setColor(this.crL);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.deK + (this.deB != null ? this.deB.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.deB != null) {
            this.deB.layout(paddingLeft + 0, this.deK + i5, 0 + paddingRight + this.deB.getMeasuredWidth(), i5 + this.deB.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.deB != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.deM.reset();
            this.deM.moveTo(paddingLeft, paddingTop);
            this.deM.lineTo(paddingLeft + width, paddingTop);
            this.deM.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.deN);
            this.deO.set((paddingLeft + width) - this.deN, (this.mTopView.getHeight() + paddingTop) - this.deN, paddingLeft + width + this.deN, this.mTopView.getHeight() + paddingTop + this.deN);
            this.deM.arcTo(this.deO, 270.0f, -180.0f);
            this.deM.lineTo(paddingLeft + width, paddingTop + height);
            this.deM.lineTo(paddingLeft, paddingTop + height);
            this.deM.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.deN);
            this.deO.set(paddingLeft - this.deN, (this.mTopView.getHeight() + paddingTop) - this.deN, this.deN + paddingLeft, this.mTopView.getHeight() + paddingTop + this.deN);
            this.deM.arcTo(this.deO, 90.0f, -180.0f);
            this.deM.lineTo(paddingLeft, paddingTop);
            this.deM.close();
            int i = this.mBorderWidth / 2;
            this.deP.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.deP, 10.0f, 10.0f, Path.Direction.CCW);
            this.deM.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.crK != null) {
                canvas.drawPath(this.deM, this.crK);
            }
            if (this.GF != null) {
                canvas.drawPath(this.deM, this.GF);
            }
            if (this.deI != null && this.mTopView != null && this.deB != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.deL.reset();
                this.deL.moveTo(paddingLeft + this.deN + 9, height2);
                this.deL.lineTo(((getWidth() - paddingRight) - this.deN) - 9, height2);
                canvas.drawPath(this.deL, this.deI);
            }
        }
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ItemTableRowView extends View {
    private RectF GD;
    private int flH;
    private int flI;
    private int flK;
    private int flL;
    private int flM;
    private int flO;
    private Drawable flP;
    private Drawable flQ;
    private int iWt;
    private int iWu;
    private int iWv;
    private int iWw;
    private int iWx;
    private int iWy;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int iWz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int iWA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int iWB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int iWC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int iWD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int iWE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flH = 5;
        this.flL = R.drawable.icon_pure_evaluation_star24_n;
        this.flM = 17170445;
        this.flO = R.color.cp_cont_b;
        this.iWw = R.color.cp_bg_line_b;
        this.iWx = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.iWu = iWz;
        this.flI = iWA;
        this.iWv = iWB;
        this.lineHeight = iWC;
        this.radius = DEFAULT_RADIUS;
        this.iWy = iWD;
        boV();
        this.GD = new RectF();
        this.paint = new Paint(1);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            this.iWu = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.iWu - iWE);
        } else {
            size2 = this.iWu + getPaddingBottom() + getPaddingTop();
        }
        this.flK = (this.iWu * this.flH) + (this.flI * (this.flH - 1));
        if (mode != 1073741824) {
            size = this.flK + getPaddingLeft() + getPaddingRight() + this.iWv + this.iWy;
        } else if (size < this.flK) {
            this.iWv = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.flK) - this.iWy);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.flP != null && this.flQ != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.iWt; i++) {
                this.flP.setBounds(paddingLeft, getPaddingTop(), this.iWu + paddingLeft, this.iWu + getPaddingTop());
                this.flP.draw(canvas);
                paddingLeft += this.flI + this.iWu;
            }
            for (int i2 = this.iWt; i2 < this.flH; i2++) {
                this.flQ.setBounds(paddingLeft, getPaddingTop(), this.iWu + paddingLeft, this.iWu + getPaddingTop());
                this.flQ.draw(canvas);
                paddingLeft += this.flI + this.iWu;
            }
            int i3 = (paddingLeft - this.flI) + this.iWy;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.GD.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.iWw));
            canvas.drawRoundRect(this.GD, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.iWx));
            this.GD.set(i3, measuredHeight, ((getMeasuredWidth() - i3) * this.progress) + i3, this.lineHeight + measuredHeight);
            canvas.drawRoundRect(this.GD, this.radius, this.radius, this.paint);
        }
    }

    public void setData(float f) {
        this.progress = f;
    }

    public void clear() {
        this.progress = 0.0f;
    }

    public void onChangeSkinType() {
        boV();
        invalidate();
    }

    public void boV() {
        this.flP = SvgManager.bmU().a(this.flL, this.flM, (SvgManager.SvgResourceStateType) null);
        this.flQ = SvgManager.bmU().a(this.flL, this.flO, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.iWt = i;
    }
}

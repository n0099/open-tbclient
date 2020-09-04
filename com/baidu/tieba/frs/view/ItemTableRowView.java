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
/* loaded from: classes16.dex */
public class ItemTableRowView extends View {
    private RectF Gl;
    private int eWE;
    private int eWF;
    private int eWH;
    private int eWI;
    private int eWJ;
    private int eWL;
    private Drawable eWM;
    private Drawable eWN;
    private int iAi;
    private int iAj;
    private int iAk;
    private int iAl;
    private int iAm;
    private int iAn;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int iAo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int iAp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int iAq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int iAr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int iAs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int iAt = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWE = 5;
        this.eWI = R.drawable.icon_pure_evaluation_star24_n;
        this.eWJ = 17170445;
        this.eWL = R.color.cp_cont_b;
        this.iAl = R.color.cp_bg_line_b;
        this.iAm = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.iAj = iAo;
        this.eWF = iAp;
        this.iAk = iAq;
        this.lineHeight = iAr;
        this.radius = DEFAULT_RADIUS;
        this.iAn = iAs;
        blq();
        this.Gl = new RectF();
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
            this.iAj = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.iAj - iAt);
        } else {
            size2 = this.iAj + getPaddingBottom() + getPaddingTop();
        }
        this.eWH = (this.iAj * this.eWE) + (this.eWF * (this.eWE - 1));
        if (mode != 1073741824) {
            size = this.eWH + getPaddingLeft() + getPaddingRight() + this.iAk + this.iAn;
        } else if (size < this.eWH) {
            this.iAk = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.eWH) - this.iAn);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eWM != null && this.eWN != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.iAi; i++) {
                this.eWM.setBounds(paddingLeft, getPaddingTop(), this.iAj + paddingLeft, this.iAj + getPaddingTop());
                this.eWM.draw(canvas);
                paddingLeft += this.eWF + this.iAj;
            }
            for (int i2 = this.iAi; i2 < this.eWE; i2++) {
                this.eWN.setBounds(paddingLeft, getPaddingTop(), this.iAj + paddingLeft, this.iAj + getPaddingTop());
                this.eWN.draw(canvas);
                paddingLeft += this.eWF + this.iAj;
            }
            int i3 = (paddingLeft - this.eWF) + this.iAn;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.Gl.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.iAl));
            canvas.drawRoundRect(this.Gl, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.iAm));
            this.Gl.set(i3, measuredHeight, ((getMeasuredWidth() - i3) * this.progress) + i3, this.lineHeight + measuredHeight);
            canvas.drawRoundRect(this.Gl, this.radius, this.radius, this.paint);
        }
    }

    public void setData(float f) {
        this.progress = f;
    }

    public void clear() {
        this.progress = 0.0f;
    }

    public void onChangeSkinType() {
        blq();
        invalidate();
    }

    public void blq() {
        this.eWM = SvgManager.bjq().a(this.eWI, this.eWJ, (SvgManager.SvgResourceStateType) null);
        this.eWN = SvgManager.bjq().a(this.eWI, this.eWL, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.iAi = i;
    }
}

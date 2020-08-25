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
    private int eWA;
    private int eWB;
    private int eWD;
    private int eWE;
    private int eWF;
    private int eWH;
    private Drawable eWI;
    private Drawable eWJ;
    private int iAc;
    private int iAd;
    private int iAe;
    private int iAf;
    private int iAg;
    private int iAh;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int iAi = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int iAj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int iAk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int iAl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int iAm = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int iAn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWA = 5;
        this.eWE = R.drawable.icon_pure_evaluation_star24_n;
        this.eWF = 17170445;
        this.eWH = R.color.cp_cont_b;
        this.iAf = R.color.cp_bg_line_b;
        this.iAg = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.iAd = iAi;
        this.eWB = iAj;
        this.iAe = iAk;
        this.lineHeight = iAl;
        this.radius = DEFAULT_RADIUS;
        this.iAh = iAm;
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
            this.iAd = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.iAd - iAn);
        } else {
            size2 = this.iAd + getPaddingBottom() + getPaddingTop();
        }
        this.eWD = (this.iAd * this.eWA) + (this.eWB * (this.eWA - 1));
        if (mode != 1073741824) {
            size = this.eWD + getPaddingLeft() + getPaddingRight() + this.iAe + this.iAh;
        } else if (size < this.eWD) {
            this.iAe = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.eWD) - this.iAh);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eWI != null && this.eWJ != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.iAc; i++) {
                this.eWI.setBounds(paddingLeft, getPaddingTop(), this.iAd + paddingLeft, this.iAd + getPaddingTop());
                this.eWI.draw(canvas);
                paddingLeft += this.eWB + this.iAd;
            }
            for (int i2 = this.iAc; i2 < this.eWA; i2++) {
                this.eWJ.setBounds(paddingLeft, getPaddingTop(), this.iAd + paddingLeft, this.iAd + getPaddingTop());
                this.eWJ.draw(canvas);
                paddingLeft += this.eWB + this.iAd;
            }
            int i3 = (paddingLeft - this.eWB) + this.iAh;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.Gl.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.iAf));
            canvas.drawRoundRect(this.Gl, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.iAg));
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
        this.eWI = SvgManager.bjq().a(this.eWE, this.eWF, (SvgManager.SvgResourceStateType) null);
        this.eWJ = SvgManager.bjq().a(this.eWE, this.eWH, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.iAc = i;
    }
}

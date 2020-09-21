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
/* loaded from: classes21.dex */
public class ItemTableRowView extends View {
    private RectF Gl;
    private int eZA;
    private int eZC;
    private Drawable eZD;
    private Drawable eZE;
    private int eZv;
    private int eZw;
    private int eZy;
    private int eZz;
    private int iHD;
    private int iHE;
    private int iHF;
    private int iHG;
    private int iHH;
    private int iHI;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int iHJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int iHK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int iHL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int iHM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int iHN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int iHO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZv = 5;
        this.eZz = R.drawable.icon_pure_evaluation_star24_n;
        this.eZA = 17170445;
        this.eZC = R.color.cp_cont_b;
        this.iHG = R.color.cp_bg_line_b;
        this.iHH = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.iHE = iHJ;
        this.eZw = iHK;
        this.iHF = iHL;
        this.lineHeight = iHM;
        this.radius = DEFAULT_RADIUS;
        this.iHI = iHN;
        bml();
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
            this.iHE = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.iHE - iHO);
        } else {
            size2 = this.iHE + getPaddingBottom() + getPaddingTop();
        }
        this.eZy = (this.iHE * this.eZv) + (this.eZw * (this.eZv - 1));
        if (mode != 1073741824) {
            size = this.eZy + getPaddingLeft() + getPaddingRight() + this.iHF + this.iHI;
        } else if (size < this.eZy) {
            this.iHF = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.eZy) - this.iHI);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eZD != null && this.eZE != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.iHD; i++) {
                this.eZD.setBounds(paddingLeft, getPaddingTop(), this.iHE + paddingLeft, this.iHE + getPaddingTop());
                this.eZD.draw(canvas);
                paddingLeft += this.eZw + this.iHE;
            }
            for (int i2 = this.iHD; i2 < this.eZv; i2++) {
                this.eZE.setBounds(paddingLeft, getPaddingTop(), this.iHE + paddingLeft, this.iHE + getPaddingTop());
                this.eZE.draw(canvas);
                paddingLeft += this.eZw + this.iHE;
            }
            int i3 = (paddingLeft - this.eZw) + this.iHI;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.Gl.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.iHG));
            canvas.drawRoundRect(this.Gl, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.iHH));
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
        bml();
        invalidate();
    }

    public void bml() {
        this.eZD = SvgManager.bkl().a(this.eZz, this.eZA, (SvgManager.SvgResourceStateType) null);
        this.eZE = SvgManager.bkl().a(this.eZz, this.eZC, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.iHD = i;
    }
}

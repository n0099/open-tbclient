package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ItemTableRowView extends View {
    private int fQL;
    private int fQN;
    private int fQP;
    private int fQQ;
    private int fQR;
    private int fQT;
    private Drawable fQU;
    private Drawable fQV;
    private int jPA;
    private int jPB;
    private int jPC;
    private int jPD;
    private int jPE;
    private int jPF;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private RectF rectF;
    private static final int jPG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jPH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    private static final int jPI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jPJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jPK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    private static final int juh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQL = 5;
        this.fQQ = R.drawable.icon_pure_evaluation_star24_n;
        this.fQR = 17170445;
        this.fQT = R.color.CAM_X0109;
        this.jPD = R.color.CAM_X0210;
        this.jPE = R.color.CAM_X0305;
        init();
    }

    private void init() {
        this.jPB = jPG;
        this.fQN = jPH;
        this.jPC = jPI;
        this.lineHeight = jPJ;
        this.radius = DEFAULT_RADIUS;
        this.jPF = jPK;
        byy();
        this.rectF = new RectF();
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
            this.jPB = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jPB - juh);
        } else {
            size2 = this.jPB + getPaddingBottom() + getPaddingTop();
        }
        this.fQP = (this.jPB * this.fQL) + (this.fQN * (this.fQL - 1));
        if (mode != 1073741824) {
            size = this.fQP + getPaddingLeft() + getPaddingRight() + this.jPC + this.jPF;
        } else if (size < this.fQP) {
            this.jPC = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fQP) - this.jPF);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fQU != null && this.fQV != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jPA; i++) {
                this.fQU.setBounds(paddingLeft, getPaddingTop(), this.jPB + paddingLeft, this.jPB + getPaddingTop());
                this.fQU.draw(canvas);
                paddingLeft += this.fQN + this.jPB;
            }
            for (int i2 = this.jPA; i2 < this.fQL; i2++) {
                this.fQV.setBounds(paddingLeft, getPaddingTop(), this.jPB + paddingLeft, this.jPB + getPaddingTop());
                this.fQV.draw(canvas);
                paddingLeft += this.fQN + this.jPB;
            }
            int i3 = (paddingLeft - this.fQN) + this.jPF;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.rectF.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ao.getColor(this.jPD));
            canvas.drawRoundRect(this.rectF, this.radius, this.radius, this.paint);
            this.paint.setColor(ao.getColor(this.jPE));
            this.rectF.set(i3, measuredHeight, ((getMeasuredWidth() - i3) * this.progress) + i3, this.lineHeight + measuredHeight);
            canvas.drawRoundRect(this.rectF, this.radius, this.radius, this.paint);
        }
    }

    public void setData(float f) {
        this.progress = f;
    }

    public void clear() {
        this.progress = 0.0f;
    }

    public void onChangeSkinType() {
        byy();
        invalidate();
    }

    public void byy() {
        this.fQU = SvgManager.bwq().a(this.fQQ, this.fQR, (SvgManager.SvgResourceStateType) null);
        this.fQV = SvgManager.bwq().a(this.fQQ, this.fQT, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.jPA = i;
    }
}

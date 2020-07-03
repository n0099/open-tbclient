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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ItemTableRowView extends View {
    private RectF FG;
    private int eFB;
    private int eFC;
    private int eFD;
    private int eFF;
    private Drawable eFG;
    private Drawable eFH;
    private int eFy;
    private int eFz;
    private int ifU;
    private int ifV;
    private int ifW;
    private int ifX;
    private int ifY;
    private int ifZ;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int iga = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int igb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int igc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int igd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int ige = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int igf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFy = 5;
        this.eFC = R.drawable.icon_pure_evaluation_star24_n;
        this.eFD = 17170445;
        this.eFF = R.color.cp_cont_b;
        this.ifX = R.color.cp_bg_line_b;
        this.ifY = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.ifV = iga;
        this.eFz = igb;
        this.ifW = igc;
        this.lineHeight = igd;
        this.radius = DEFAULT_RADIUS;
        this.ifZ = ige;
        aYW();
        this.FG = new RectF();
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
            this.ifV = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.ifV - igf);
        } else {
            size2 = this.ifV + getPaddingBottom() + getPaddingTop();
        }
        this.eFB = (this.ifV * this.eFy) + (this.eFz * (this.eFy - 1));
        if (mode != 1073741824) {
            size = this.eFB + getPaddingLeft() + getPaddingRight() + this.ifW + this.ifZ;
        } else if (size < this.eFB) {
            this.ifW = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.eFB) - this.ifZ);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eFG != null && this.eFH != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.ifU; i++) {
                this.eFG.setBounds(paddingLeft, getPaddingTop(), this.ifV + paddingLeft, this.ifV + getPaddingTop());
                this.eFG.draw(canvas);
                paddingLeft += this.eFz + this.ifV;
            }
            for (int i2 = this.ifU; i2 < this.eFy; i2++) {
                this.eFH.setBounds(paddingLeft, getPaddingTop(), this.ifV + paddingLeft, this.ifV + getPaddingTop());
                this.eFH.draw(canvas);
                paddingLeft += this.eFz + this.ifV;
            }
            int i3 = (paddingLeft - this.eFz) + this.ifZ;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.FG.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(an.getColor(this.ifX));
            canvas.drawRoundRect(this.FG, this.radius, this.radius, this.paint);
            this.paint.setColor(an.getColor(this.ifY));
            this.FG.set(i3, measuredHeight, ((getMeasuredWidth() - i3) * this.progress) + i3, this.lineHeight + measuredHeight);
            canvas.drawRoundRect(this.FG, this.radius, this.radius, this.paint);
        }
    }

    public void setData(float f) {
        this.progress = f;
    }

    public void clear() {
        this.progress = 0.0f;
    }

    public void onChangeSkinType() {
        aYW();
        invalidate();
    }

    public void aYW() {
        this.eFG = SvgManager.aWQ().a(this.eFC, this.eFD, (SvgManager.SvgResourceStateType) null);
        this.eFH = SvgManager.aWQ().a(this.eFC, this.eFF, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.ifU = i;
    }
}

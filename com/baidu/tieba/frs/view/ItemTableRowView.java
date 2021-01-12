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
    private int fMe;
    private int fMg;
    private int fMi;
    private int fMj;
    private int fMk;
    private int fMm;
    private Drawable fMn;
    private Drawable fMo;
    private int jKU;
    private int jKV;
    private int jKW;
    private int jKX;
    private int jKY;
    private int jKZ;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private RectF rectF;
    private static final int jLa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jLb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    private static final int jLc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jLd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jLe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    private static final int jpB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMe = 5;
        this.fMj = R.drawable.icon_pure_evaluation_star24_n;
        this.fMk = 17170445;
        this.fMm = R.color.CAM_X0109;
        this.jKX = R.color.CAM_X0210;
        this.jKY = R.color.CAM_X0305;
        init();
    }

    private void init() {
        this.jKV = jLa;
        this.fMg = jLb;
        this.jKW = jLc;
        this.lineHeight = jLd;
        this.radius = DEFAULT_RADIUS;
        this.jKZ = jLe;
        buF();
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
            this.jKV = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jKV - jpB);
        } else {
            size2 = this.jKV + getPaddingBottom() + getPaddingTop();
        }
        this.fMi = (this.jKV * this.fMe) + (this.fMg * (this.fMe - 1));
        if (mode != 1073741824) {
            size = this.fMi + getPaddingLeft() + getPaddingRight() + this.jKW + this.jKZ;
        } else if (size < this.fMi) {
            this.jKW = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fMi) - this.jKZ);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fMn != null && this.fMo != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jKU; i++) {
                this.fMn.setBounds(paddingLeft, getPaddingTop(), this.jKV + paddingLeft, this.jKV + getPaddingTop());
                this.fMn.draw(canvas);
                paddingLeft += this.fMg + this.jKV;
            }
            for (int i2 = this.jKU; i2 < this.fMe; i2++) {
                this.fMo.setBounds(paddingLeft, getPaddingTop(), this.jKV + paddingLeft, this.jKV + getPaddingTop());
                this.fMo.draw(canvas);
                paddingLeft += this.fMg + this.jKV;
            }
            int i3 = (paddingLeft - this.fMg) + this.jKZ;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.rectF.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ao.getColor(this.jKX));
            canvas.drawRoundRect(this.rectF, this.radius, this.radius, this.paint);
            this.paint.setColor(ao.getColor(this.jKY));
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
        buF();
        invalidate();
    }

    public void buF() {
        this.fMn = SvgManager.bsx().a(this.fMj, this.fMk, (SvgManager.SvgResourceStateType) null);
        this.fMo = SvgManager.bsx().a(this.fMj, this.fMm, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.jKU = i;
    }
}

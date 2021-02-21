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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ItemTableRowView extends View {
    private int fOA;
    private Drawable fOB;
    private Drawable fOC;
    private int fOs;
    private int fOu;
    private int fOw;
    private int fOx;
    private int fOy;
    private int jSf;
    private int jSg;
    private int jSh;
    private int jSi;
    private int jSj;
    private int jSk;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private RectF rectF;
    private static final int jSl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jSm = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    private static final int jSn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jSo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jSp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    private static final int jvv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fOs = 5;
        this.fOx = R.drawable.icon_pure_evaluation_star24_n;
        this.fOy = 17170445;
        this.fOA = R.color.CAM_X0109;
        this.jSi = R.color.CAM_X0210;
        this.jSj = R.color.CAM_X0305;
        init();
    }

    private void init() {
        this.jSg = jSl;
        this.fOu = jSm;
        this.jSh = jSn;
        this.lineHeight = jSo;
        this.radius = DEFAULT_RADIUS;
        this.jSk = jSp;
        buZ();
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
            this.jSg = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jSg - jvv);
        } else {
            size2 = this.jSg + getPaddingBottom() + getPaddingTop();
        }
        this.fOw = (this.jSg * this.fOs) + (this.fOu * (this.fOs - 1));
        if (mode != 1073741824) {
            size = this.fOw + getPaddingLeft() + getPaddingRight() + this.jSh + this.jSk;
        } else if (size < this.fOw) {
            this.jSh = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fOw) - this.jSk);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fOB != null && this.fOC != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jSf; i++) {
                this.fOB.setBounds(paddingLeft, getPaddingTop(), this.jSg + paddingLeft, this.jSg + getPaddingTop());
                this.fOB.draw(canvas);
                paddingLeft += this.fOu + this.jSg;
            }
            for (int i2 = this.jSf; i2 < this.fOs; i2++) {
                this.fOC.setBounds(paddingLeft, getPaddingTop(), this.jSg + paddingLeft, this.jSg + getPaddingTop());
                this.fOC.draw(canvas);
                paddingLeft += this.fOu + this.jSg;
            }
            int i3 = (paddingLeft - this.fOu) + this.jSk;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.rectF.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.jSi));
            canvas.drawRoundRect(this.rectF, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.jSj));
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
        buZ();
        invalidate();
    }

    public void buZ() {
        this.fOB = SvgManager.bsR().a(this.fOx, this.fOy, (SvgManager.SvgResourceStateType) null);
        this.fOC = SvgManager.bsR().a(this.fOx, this.fOA, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.jSf = i;
    }
}

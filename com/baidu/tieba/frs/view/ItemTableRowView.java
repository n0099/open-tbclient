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
    private int jRR;
    private int jRS;
    private int jRT;
    private int jRU;
    private int jRV;
    private int jRW;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private RectF rectF;
    private static final int jRX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jRY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    private static final int jRZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jSa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jSb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    private static final int jvh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

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
        this.jRU = R.color.CAM_X0210;
        this.jRV = R.color.CAM_X0305;
        init();
    }

    private void init() {
        this.jRS = jRX;
        this.fOu = jRY;
        this.jRT = jRZ;
        this.lineHeight = jSa;
        this.radius = DEFAULT_RADIUS;
        this.jRW = jSb;
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
            this.jRS = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jRS - jvh);
        } else {
            size2 = this.jRS + getPaddingBottom() + getPaddingTop();
        }
        this.fOw = (this.jRS * this.fOs) + (this.fOu * (this.fOs - 1));
        if (mode != 1073741824) {
            size = this.fOw + getPaddingLeft() + getPaddingRight() + this.jRT + this.jRW;
        } else if (size < this.fOw) {
            this.jRT = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fOw) - this.jRW);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fOB != null && this.fOC != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jRR; i++) {
                this.fOB.setBounds(paddingLeft, getPaddingTop(), this.jRS + paddingLeft, this.jRS + getPaddingTop());
                this.fOB.draw(canvas);
                paddingLeft += this.fOu + this.jRS;
            }
            for (int i2 = this.jRR; i2 < this.fOs; i2++) {
                this.fOC.setBounds(paddingLeft, getPaddingTop(), this.jRS + paddingLeft, this.jRS + getPaddingTop());
                this.fOC.draw(canvas);
                paddingLeft += this.fOu + this.jRS;
            }
            int i3 = (paddingLeft - this.fOu) + this.jRW;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.rectF.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.jRU));
            canvas.drawRoundRect(this.rectF, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.jRV));
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
        this.jRR = i;
    }
}

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
    private int fPS;
    private int fPU;
    private int fPW;
    private int fPX;
    private int fPY;
    private int fQa;
    private Drawable fQb;
    private Drawable fQc;
    private int jTO;
    private int jTP;
    private int jTQ;
    private int jTR;
    private int jTS;
    private int jTT;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private RectF rectF;
    private static final int jTU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jTV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    private static final int jTW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jTX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jTY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    private static final int jxe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPS = 5;
        this.fPX = R.drawable.icon_pure_evaluation_star24_n;
        this.fPY = 17170445;
        this.fQa = R.color.CAM_X0109;
        this.jTR = R.color.CAM_X0210;
        this.jTS = R.color.CAM_X0305;
        init();
    }

    private void init() {
        this.jTP = jTU;
        this.fPU = jTV;
        this.jTQ = jTW;
        this.lineHeight = jTX;
        this.radius = DEFAULT_RADIUS;
        this.jTT = jTY;
        bvc();
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
            this.jTP = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jTP - jxe);
        } else {
            size2 = this.jTP + getPaddingBottom() + getPaddingTop();
        }
        this.fPW = (this.jTP * this.fPS) + (this.fPU * (this.fPS - 1));
        if (mode != 1073741824) {
            size = this.fPW + getPaddingLeft() + getPaddingRight() + this.jTQ + this.jTT;
        } else if (size < this.fPW) {
            this.jTQ = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fPW) - this.jTT);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fQb != null && this.fQc != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jTO; i++) {
                this.fQb.setBounds(paddingLeft, getPaddingTop(), this.jTP + paddingLeft, this.jTP + getPaddingTop());
                this.fQb.draw(canvas);
                paddingLeft += this.fPU + this.jTP;
            }
            for (int i2 = this.jTO; i2 < this.fPS; i2++) {
                this.fQc.setBounds(paddingLeft, getPaddingTop(), this.jTP + paddingLeft, this.jTP + getPaddingTop());
                this.fQc.draw(canvas);
                paddingLeft += this.fPU + this.jTP;
            }
            int i3 = (paddingLeft - this.fPU) + this.jTT;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.rectF.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.jTR));
            canvas.drawRoundRect(this.rectF, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.jTS));
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
        bvc();
        invalidate();
    }

    public void bvc() {
        this.fQb = SvgManager.bsU().a(this.fPX, this.fPY, (SvgManager.SvgResourceStateType) null);
        this.fQc = SvgManager.bsU().a(this.fPX, this.fQa, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.jTO = i;
    }
}

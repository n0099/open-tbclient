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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ItemTableRowView extends View {
    private RectF FG;
    private int eLU;
    private int eLV;
    private int eLX;
    private int eLY;
    private int eLZ;
    private int eMb;
    private Drawable eMc;
    private Drawable eMd;
    private int ilZ;
    private int ima;
    private int imb;
    private int imc;
    private int imd;
    private int ime;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int imf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int imh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int imi = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int imj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int imk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int iml = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eLU = 5;
        this.eLY = R.drawable.icon_pure_evaluation_star24_n;
        this.eLZ = 17170445;
        this.eMb = R.color.cp_cont_b;
        this.imc = R.color.cp_bg_line_b;
        this.imd = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.ima = imf;
        this.eLV = imh;
        this.imb = imi;
        this.lineHeight = imj;
        this.radius = DEFAULT_RADIUS;
        this.ime = imk;
        bcT();
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
            this.ima = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.ima - iml);
        } else {
            size2 = this.ima + getPaddingBottom() + getPaddingTop();
        }
        this.eLX = (this.ima * this.eLU) + (this.eLV * (this.eLU - 1));
        if (mode != 1073741824) {
            size = this.eLX + getPaddingLeft() + getPaddingRight() + this.imb + this.ime;
        } else if (size < this.eLX) {
            this.imb = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.eLX) - this.ime);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.eMc != null && this.eMd != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.ilZ; i++) {
                this.eMc.setBounds(paddingLeft, getPaddingTop(), this.ima + paddingLeft, this.ima + getPaddingTop());
                this.eMc.draw(canvas);
                paddingLeft += this.eLV + this.ima;
            }
            for (int i2 = this.ilZ; i2 < this.eLU; i2++) {
                this.eMd.setBounds(paddingLeft, getPaddingTop(), this.ima + paddingLeft, this.ima + getPaddingTop());
                this.eMd.draw(canvas);
                paddingLeft += this.eLV + this.ima;
            }
            int i3 = (paddingLeft - this.eLV) + this.ime;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.FG.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ao.getColor(this.imc));
            canvas.drawRoundRect(this.FG, this.radius, this.radius, this.paint);
            this.paint.setColor(ao.getColor(this.imd));
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
        bcT();
        invalidate();
    }

    public void bcT() {
        this.eMc = SvgManager.baR().a(this.eLY, this.eLZ, (SvgManager.SvgResourceStateType) null);
        this.eMd = SvgManager.baR().a(this.eLY, this.eMb, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.ilZ = i;
    }
}

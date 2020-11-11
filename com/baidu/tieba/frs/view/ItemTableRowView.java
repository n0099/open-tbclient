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
/* loaded from: classes22.dex */
public class ItemTableRowView extends View {
    private RectF GD;
    private int fAb;
    private int fAc;
    private int fAd;
    private int fAf;
    private Drawable fAg;
    private Drawable fAh;
    private int fzY;
    private int fzZ;
    private int joO;
    private int joP;
    private int joQ;
    private int joR;
    private int joS;
    private int joT;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int joU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int joV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int joW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int joX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int joY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int joZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzY = 5;
        this.fAc = R.drawable.icon_pure_evaluation_star24_n;
        this.fAd = 17170445;
        this.fAf = R.color.cp_cont_b;
        this.joR = R.color.cp_bg_line_b;
        this.joS = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.joP = joU;
        this.fzZ = joV;
        this.joQ = joW;
        this.lineHeight = joX;
        this.radius = DEFAULT_RADIUS;
        this.joT = joY;
        bto();
        this.GD = new RectF();
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
            this.joP = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.joP - joZ);
        } else {
            size2 = this.joP + getPaddingBottom() + getPaddingTop();
        }
        this.fAb = (this.joP * this.fzY) + (this.fzZ * (this.fzY - 1));
        if (mode != 1073741824) {
            size = this.fAb + getPaddingLeft() + getPaddingRight() + this.joQ + this.joT;
        } else if (size < this.fAb) {
            this.joQ = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fAb) - this.joT);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fAg != null && this.fAh != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.joO; i++) {
                this.fAg.setBounds(paddingLeft, getPaddingTop(), this.joP + paddingLeft, this.joP + getPaddingTop());
                this.fAg.draw(canvas);
                paddingLeft += this.fzZ + this.joP;
            }
            for (int i2 = this.joO; i2 < this.fzY; i2++) {
                this.fAh.setBounds(paddingLeft, getPaddingTop(), this.joP + paddingLeft, this.joP + getPaddingTop());
                this.fAh.draw(canvas);
                paddingLeft += this.fzZ + this.joP;
            }
            int i3 = (paddingLeft - this.fzZ) + this.joT;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.GD.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.joR));
            canvas.drawRoundRect(this.GD, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.joS));
            this.GD.set(i3, measuredHeight, ((getMeasuredWidth() - i3) * this.progress) + i3, this.lineHeight + measuredHeight);
            canvas.drawRoundRect(this.GD, this.radius, this.radius, this.paint);
        }
    }

    public void setData(float f) {
        this.progress = f;
    }

    public void clear() {
        this.progress = 0.0f;
    }

    public void onChangeSkinType() {
        bto();
        invalidate();
    }

    public void bto() {
        this.fAg = SvgManager.brn().a(this.fAc, this.fAd, (SvgManager.SvgResourceStateType) null);
        this.fAh = SvgManager.brn().a(this.fAc, this.fAf, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.joO = i;
    }
}

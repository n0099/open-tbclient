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
    private RectF GD;
    private int fzA;
    private int fzC;
    private Drawable fzD;
    private Drawable fzE;
    private int fzu;
    private int fzw;
    private int fzy;
    private int fzz;
    private int jpA;
    private int jpv;
    private int jpw;
    private int jpx;
    private int jpy;
    private int jpz;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int jpB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jpC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    private static final int jpD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jpE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jpF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    private static final int jpG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzu = 5;
        this.fzz = R.drawable.icon_pure_evaluation_star24_n;
        this.fzA = 17170445;
        this.fzC = R.color.CAM_X0109;
        this.jpy = R.color.CAM_X0210;
        this.jpz = R.color.CAM_X0305;
        init();
    }

    private void init() {
        this.jpw = jpB;
        this.fzw = jpC;
        this.jpx = jpD;
        this.lineHeight = jpE;
        this.radius = DEFAULT_RADIUS;
        this.jpA = jpF;
        bsE();
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
            this.jpw = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jpw - jpG);
        } else {
            size2 = this.jpw + getPaddingBottom() + getPaddingTop();
        }
        this.fzy = (this.jpw * this.fzu) + (this.fzw * (this.fzu - 1));
        if (mode != 1073741824) {
            size = this.fzy + getPaddingLeft() + getPaddingRight() + this.jpx + this.jpA;
        } else if (size < this.fzy) {
            this.jpx = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fzy) - this.jpA);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fzD != null && this.fzE != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jpv; i++) {
                this.fzD.setBounds(paddingLeft, getPaddingTop(), this.jpw + paddingLeft, this.jpw + getPaddingTop());
                this.fzD.draw(canvas);
                paddingLeft += this.fzw + this.jpw;
            }
            for (int i2 = this.jpv; i2 < this.fzu; i2++) {
                this.fzE.setBounds(paddingLeft, getPaddingTop(), this.jpw + paddingLeft, this.jpw + getPaddingTop());
                this.fzE.draw(canvas);
                paddingLeft += this.fzw + this.jpw;
            }
            int i3 = (paddingLeft - this.fzw) + this.jpA;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.GD.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.jpy));
            canvas.drawRoundRect(this.GD, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.jpz));
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
        bsE();
        invalidate();
    }

    public void bsE() {
        this.fzD = SvgManager.bqB().a(this.fzz, this.fzA, (SvgManager.SvgResourceStateType) null);
        this.fzE = SvgManager.bqB().a(this.fzz, this.fzC, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.jpv = i;
    }
}

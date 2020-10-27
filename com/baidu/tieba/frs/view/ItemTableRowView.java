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
    private int fui;
    private int fuj;
    private int ful;
    private int fum;
    private int fun;
    private int fup;
    private Drawable fuq;
    private Drawable fur;
    private int jiQ;
    private int jiR;
    private int jiS;
    private int jiT;
    private int jiU;
    private int jiV;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int jiW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jiX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jiY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jiZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jja = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    private static final int jjb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fui = 5;
        this.fum = R.drawable.icon_pure_evaluation_star24_n;
        this.fun = 17170445;
        this.fup = R.color.cp_cont_b;
        this.jiT = R.color.cp_bg_line_b;
        this.jiU = R.color.cp_cont_b;
        init();
    }

    private void init() {
        this.jiR = jiW;
        this.fuj = jiX;
        this.jiS = jiY;
        this.lineHeight = jiZ;
        this.radius = DEFAULT_RADIUS;
        this.jiV = jja;
        bqO();
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
            this.jiR = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jiR - jjb);
        } else {
            size2 = this.jiR + getPaddingBottom() + getPaddingTop();
        }
        this.ful = (this.jiR * this.fui) + (this.fuj * (this.fui - 1));
        if (mode != 1073741824) {
            size = this.ful + getPaddingLeft() + getPaddingRight() + this.jiS + this.jiV;
        } else if (size < this.ful) {
            this.jiS = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.ful) - this.jiV);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fuq != null && this.fur != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jiQ; i++) {
                this.fuq.setBounds(paddingLeft, getPaddingTop(), this.jiR + paddingLeft, this.jiR + getPaddingTop());
                this.fuq.draw(canvas);
                paddingLeft += this.fuj + this.jiR;
            }
            for (int i2 = this.jiQ; i2 < this.fui; i2++) {
                this.fur.setBounds(paddingLeft, getPaddingTop(), this.jiR + paddingLeft, this.jiR + getPaddingTop());
                this.fur.draw(canvas);
                paddingLeft += this.fuj + this.jiR;
            }
            int i3 = (paddingLeft - this.fuj) + this.jiV;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.GD.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.jiT));
            canvas.drawRoundRect(this.GD, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.jiU));
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
        bqO();
        invalidate();
    }

    public void bqO() {
        this.fuq = SvgManager.boN().a(this.fum, this.fun, (SvgManager.SvgResourceStateType) null);
        this.fur = SvgManager.boN().a(this.fum, this.fup, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.jiQ = i;
    }
}

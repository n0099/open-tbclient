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
    private RectF Hx;
    private int fHj;
    private int fHl;
    private int fHn;
    private int fHo;
    private int fHp;
    private int fHr;
    private Drawable fHs;
    private Drawable fHt;
    private int jCY;
    private int jCZ;
    private int jDa;
    private int jDb;
    private int jDc;
    private int jDd;
    private int lineHeight;
    private Paint paint;
    private float progress;
    private int radius;
    private static final int jDe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
    private static final int jDf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    private static final int jDg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds644);
    private static final int jDh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
    private static final int DEFAULT_RADIUS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    private static final int jDi = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X003);
    private static final int jhH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds6);

    public ItemTableRowView(Context context) {
        this(context, null);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTableRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fHj = 5;
        this.fHo = R.drawable.icon_pure_evaluation_star24_n;
        this.fHp = 17170445;
        this.fHr = R.color.CAM_X0109;
        this.jDb = R.color.CAM_X0210;
        this.jDc = R.color.CAM_X0305;
        init();
    }

    private void init() {
        this.jCZ = jDe;
        this.fHl = jDf;
        this.jDa = jDg;
        this.lineHeight = jDh;
        this.radius = DEFAULT_RADIUS;
        this.jDd = jDi;
        bwe();
        this.Hx = new RectF();
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
            this.jCZ = (size2 - getPaddingBottom()) - getPaddingTop();
            this.lineHeight = Math.max(0, this.jCZ - jhH);
        } else {
            size2 = this.jCZ + getPaddingBottom() + getPaddingTop();
        }
        this.fHn = (this.jCZ * this.fHj) + (this.fHl * (this.fHj - 1));
        if (mode != 1073741824) {
            size = this.fHn + getPaddingLeft() + getPaddingRight() + this.jDa + this.jDd;
        } else if (size < this.fHn) {
            this.jDa = Math.max(0, (((size - getPaddingLeft()) - getPaddingRight()) - this.fHn) - this.jDd);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fHs != null && this.fHt != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.jCY; i++) {
                this.fHs.setBounds(paddingLeft, getPaddingTop(), this.jCZ + paddingLeft, this.jCZ + getPaddingTop());
                this.fHs.draw(canvas);
                paddingLeft += this.fHl + this.jCZ;
            }
            for (int i2 = this.jCY; i2 < this.fHj; i2++) {
                this.fHt.setBounds(paddingLeft, getPaddingTop(), this.jCZ + paddingLeft, this.jCZ + getPaddingTop());
                this.fHt.draw(canvas);
                paddingLeft += this.fHl + this.jCZ;
            }
            int i3 = (paddingLeft - this.fHl) + this.jDd;
            float measuredHeight = (((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.lineHeight) / 2;
            this.Hx.set(i3, measuredHeight, getMeasuredWidth(), this.lineHeight + measuredHeight);
            this.paint.setColor(ap.getColor(this.jDb));
            canvas.drawRoundRect(this.Hx, this.radius, this.radius, this.paint);
            this.paint.setColor(ap.getColor(this.jDc));
            this.Hx.set(i3, measuredHeight, ((getMeasuredWidth() - i3) * this.progress) + i3, this.lineHeight + measuredHeight);
            canvas.drawRoundRect(this.Hx, this.radius, this.radius, this.paint);
        }
    }

    public void setData(float f) {
        this.progress = f;
    }

    public void clear() {
        this.progress = 0.0f;
    }

    public void onChangeSkinType() {
        bwe();
        invalidate();
    }

    public void bwe() {
        this.fHs = SvgManager.btW().a(this.fHo, this.fHp, (SvgManager.SvgResourceStateType) null);
        this.fHt = SvgManager.btW().a(this.fHo, this.fHr, (SvgManager.SvgResourceStateType) null);
    }

    public void setEmptyStartCount(int i) {
        this.jCY = i;
    }
}

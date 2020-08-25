package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class RankStarView extends View {
    private int aiB;
    private int eWA;
    private int eWB;
    private int eWC;
    private int eWD;
    private int eWE;
    private int eWF;
    private int eWG;
    private int eWH;
    private Drawable eWI;
    private Drawable eWJ;
    private int eWz;

    public RankStarView(Context context) {
        super(context);
        this.eWA = 5;
        this.eWE = R.drawable.icon_pure_evaluation_star24_n;
        this.eWF = R.color.cp_cont_i;
        this.eWG = R.drawable.icon_pure_evaluation_star24_n;
        this.eWH = R.color.cp_link_tip_d;
        this.aiB = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWA = 5;
        this.eWE = R.drawable.icon_pure_evaluation_star24_n;
        this.eWF = R.color.cp_cont_i;
        this.eWG = R.drawable.icon_pure_evaluation_star24_n;
        this.eWH = R.color.cp_link_tip_d;
        this.aiB = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWA = 5;
        this.eWE = R.drawable.icon_pure_evaluation_star24_n;
        this.eWF = R.color.cp_cont_i;
        this.eWG = R.drawable.icon_pure_evaluation_star24_n;
        this.eWH = R.color.cp_link_tip_d;
        this.aiB = 3;
        init(context);
    }

    private void init(Context context) {
        this.eWC = l.getDimens(context, R.dimen.tbds63);
        blq();
    }

    public int getStarCount() {
        return this.eWz;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.eWA) {
            i = this.eWA;
        }
        if (this.eWz != i) {
            this.eWz = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.eWB = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.eWE = i;
        this.eWF = i2;
        this.eWG = i3;
        this.eWH = i4;
        blq();
    }

    public void onChangeSkinType(int i) {
        if (this.aiB != i) {
            this.aiB = i;
            blq();
        }
    }

    public void blq() {
        this.eWI = SvgManager.bjq().a(this.eWE, this.eWF, (SvgManager.SvgResourceStateType) null);
        this.eWJ = SvgManager.bjq().a(this.eWG, this.eWH, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.eWD + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.eWD) * this.eWA)) + 1);
            return onTouchEvent;
        }
        return onTouchEvent;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            this.eWC = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.eWC + getPaddingBottom() + getPaddingTop();
        }
        this.eWD = (this.eWC * this.eWA) + (this.eWB * (this.eWA - 1));
        if (mode != 1073741824) {
            size = this.eWD + getPaddingLeft() + getPaddingRight();
        } else if (size < this.eWD) {
            this.eWD = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eWI != null && this.eWJ != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.eWz; i++) {
                this.eWJ.setBounds(paddingLeft, getPaddingTop(), this.eWC + paddingLeft, this.eWC + getPaddingTop());
                this.eWJ.draw(canvas);
                paddingLeft += this.eWB + this.eWC;
            }
            for (int i2 = this.eWz; i2 < this.eWA; i2++) {
                this.eWI.setBounds(paddingLeft, getPaddingTop(), this.eWC + paddingLeft, this.eWC + getPaddingTop());
                this.eWI.draw(canvas);
                paddingLeft += this.eWB + this.eWC;
            }
        }
    }
}

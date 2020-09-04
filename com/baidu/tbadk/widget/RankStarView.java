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
/* loaded from: classes.dex */
public class RankStarView extends View {
    private int aiD;
    private int eWD;
    private int eWE;
    private int eWF;
    private int eWG;
    private int eWH;
    private int eWI;
    private int eWJ;
    private int eWK;
    private int eWL;
    private Drawable eWM;
    private Drawable eWN;

    public RankStarView(Context context) {
        super(context);
        this.eWE = 5;
        this.eWI = R.drawable.icon_pure_evaluation_star24_n;
        this.eWJ = R.color.cp_cont_i;
        this.eWK = R.drawable.icon_pure_evaluation_star24_n;
        this.eWL = R.color.cp_link_tip_d;
        this.aiD = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWE = 5;
        this.eWI = R.drawable.icon_pure_evaluation_star24_n;
        this.eWJ = R.color.cp_cont_i;
        this.eWK = R.drawable.icon_pure_evaluation_star24_n;
        this.eWL = R.color.cp_link_tip_d;
        this.aiD = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWE = 5;
        this.eWI = R.drawable.icon_pure_evaluation_star24_n;
        this.eWJ = R.color.cp_cont_i;
        this.eWK = R.drawable.icon_pure_evaluation_star24_n;
        this.eWL = R.color.cp_link_tip_d;
        this.aiD = 3;
        init(context);
    }

    private void init(Context context) {
        this.eWG = l.getDimens(context, R.dimen.tbds63);
        blq();
    }

    public int getStarCount() {
        return this.eWD;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.eWE) {
            i = this.eWE;
        }
        if (this.eWD != i) {
            this.eWD = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.eWF = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.eWI = i;
        this.eWJ = i2;
        this.eWK = i3;
        this.eWL = i4;
        blq();
    }

    public void onChangeSkinType(int i) {
        if (this.aiD != i) {
            this.aiD = i;
            blq();
        }
    }

    public void blq() {
        this.eWM = SvgManager.bjq().a(this.eWI, this.eWJ, (SvgManager.SvgResourceStateType) null);
        this.eWN = SvgManager.bjq().a(this.eWK, this.eWL, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.eWH + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.eWH) * this.eWE)) + 1);
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
            this.eWG = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.eWG + getPaddingBottom() + getPaddingTop();
        }
        this.eWH = (this.eWG * this.eWE) + (this.eWF * (this.eWE - 1));
        if (mode != 1073741824) {
            size = this.eWH + getPaddingLeft() + getPaddingRight();
        } else if (size < this.eWH) {
            this.eWH = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eWM != null && this.eWN != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.eWD; i++) {
                this.eWN.setBounds(paddingLeft, getPaddingTop(), this.eWG + paddingLeft, this.eWG + getPaddingTop());
                this.eWN.draw(canvas);
                paddingLeft += this.eWF + this.eWG;
            }
            for (int i2 = this.eWD; i2 < this.eWE; i2++) {
                this.eWM.setBounds(paddingLeft, getPaddingTop(), this.eWG + paddingLeft, this.eWG + getPaddingTop());
                this.eWM.draw(canvas);
                paddingLeft += this.eWF + this.eWG;
            }
        }
    }
}

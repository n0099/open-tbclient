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
    private int ajq;
    private int fAa;
    private int fAb;
    private int fAc;
    private int fAd;
    private int fAe;
    private int fAf;
    private Drawable fAg;
    private Drawable fAh;
    private int fzX;
    private int fzY;
    private int fzZ;

    public RankStarView(Context context) {
        super(context);
        this.fzY = 5;
        this.fAc = R.drawable.icon_pure_evaluation_star24_n;
        this.fAd = R.color.cp_cont_i;
        this.fAe = R.drawable.icon_pure_evaluation_star24_n;
        this.fAf = R.color.cp_link_tip_d;
        this.ajq = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzY = 5;
        this.fAc = R.drawable.icon_pure_evaluation_star24_n;
        this.fAd = R.color.cp_cont_i;
        this.fAe = R.drawable.icon_pure_evaluation_star24_n;
        this.fAf = R.color.cp_link_tip_d;
        this.ajq = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzY = 5;
        this.fAc = R.drawable.icon_pure_evaluation_star24_n;
        this.fAd = R.color.cp_cont_i;
        this.fAe = R.drawable.icon_pure_evaluation_star24_n;
        this.fAf = R.color.cp_link_tip_d;
        this.ajq = 3;
        init(context);
    }

    private void init(Context context) {
        this.fAa = l.getDimens(context, R.dimen.tbds63);
        bto();
    }

    public int getStarCount() {
        return this.fzX;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.fzY) {
            i = this.fzY;
        }
        if (this.fzX != i) {
            this.fzX = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.fzZ = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fAc = i;
        this.fAd = i2;
        this.fAe = i3;
        this.fAf = i4;
        bto();
    }

    public void onChangeSkinType(int i) {
        if (this.ajq != i) {
            this.ajq = i;
            bto();
        }
    }

    public void bto() {
        this.fAg = SvgManager.brn().a(this.fAc, this.fAd, (SvgManager.SvgResourceStateType) null);
        this.fAh = SvgManager.brn().a(this.fAe, this.fAf, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.fAb + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.fAb) * this.fzY)) + 1);
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
            this.fAa = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fAa + getPaddingBottom() + getPaddingTop();
        }
        this.fAb = (this.fAa * this.fzY) + (this.fzZ * (this.fzY - 1));
        if (mode != 1073741824) {
            size = this.fAb + getPaddingLeft() + getPaddingRight();
        } else if (size < this.fAb) {
            this.fAb = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fAg != null && this.fAh != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fzX; i++) {
                this.fAh.setBounds(paddingLeft, getPaddingTop(), this.fAa + paddingLeft, this.fAa + getPaddingTop());
                this.fAh.draw(canvas);
                paddingLeft += this.fzZ + this.fAa;
            }
            for (int i2 = this.fzX; i2 < this.fzY; i2++) {
                this.fAg.setBounds(paddingLeft, getPaddingTop(), this.fAa + paddingLeft, this.fAa + getPaddingTop());
                this.fAg.draw(canvas);
                paddingLeft += this.fzZ + this.fAa;
            }
        }
    }
}

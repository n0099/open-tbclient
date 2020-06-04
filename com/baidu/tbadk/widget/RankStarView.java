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
    private int agt;
    private int ewp;
    private int ewq;
    private int ewr;
    private int ews;
    private int ewt;
    private int ewu;
    private int ewv;
    private int eww;
    private int ewx;
    private Drawable ewy;
    private Drawable ewz;

    public RankStarView(Context context) {
        super(context);
        this.ewq = 5;
        this.ewu = R.drawable.icon_pure_evaluation_star24_n;
        this.ewv = R.color.cp_cont_i;
        this.eww = R.drawable.icon_pure_evaluation_star24_n;
        this.ewx = R.color.cp_link_tip_d;
        this.agt = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewq = 5;
        this.ewu = R.drawable.icon_pure_evaluation_star24_n;
        this.ewv = R.color.cp_cont_i;
        this.eww = R.drawable.icon_pure_evaluation_star24_n;
        this.ewx = R.color.cp_link_tip_d;
        this.agt = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewq = 5;
        this.ewu = R.drawable.icon_pure_evaluation_star24_n;
        this.ewv = R.color.cp_cont_i;
        this.eww = R.drawable.icon_pure_evaluation_star24_n;
        this.ewx = R.color.cp_link_tip_d;
        this.agt = 3;
        init(context);
    }

    private void init(Context context) {
        this.ews = l.getDimens(context, R.dimen.tbds63);
        bhj();
    }

    public int getStarCount() {
        return this.ewp;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.ewq) {
            i = this.ewq;
        }
        if (this.ewp != i) {
            this.ewp = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.ewr = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.ewu = i;
        this.ewv = i2;
        this.eww = i3;
        this.ewx = i4;
        bhj();
    }

    private void bhj() {
        this.ewy = SvgManager.aUW().a(this.ewu, this.ewv, (SvgManager.SvgResourceStateType) null);
        this.ewz = SvgManager.aUW().a(this.eww, this.ewx, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.ewt + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.ewt) * this.ewq)) + 1);
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
            this.ews = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.ews + getPaddingBottom() + getPaddingTop();
        }
        this.ewt = (this.ews * this.ewq) + (this.ewr * (this.ewq - 1));
        if (mode != 1073741824) {
            size = this.ewt + getPaddingLeft() + getPaddingRight();
        } else if (size < this.ewt) {
            this.ewt = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ewy != null && this.ewz != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.ewp; i++) {
                this.ewz.setBounds(paddingLeft, getPaddingTop(), this.ews + paddingLeft, this.ews + getPaddingTop());
                this.ewz.draw(canvas);
                paddingLeft += this.ewr + this.ews;
            }
            for (int i2 = this.ewp; i2 < this.ewq; i2++) {
                this.ewy.setBounds(paddingLeft, getPaddingTop(), this.ews + paddingLeft, this.ews + getPaddingTop());
                this.ewy.draw(canvas);
                paddingLeft += this.ewr + this.ews;
            }
        }
    }
}

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
    private int aiX;
    private int eZA;
    private int eZB;
    private int eZC;
    private Drawable eZD;
    private Drawable eZE;
    private int eZu;
    private int eZv;
    private int eZw;
    private int eZx;
    private int eZy;
    private int eZz;

    public RankStarView(Context context) {
        super(context);
        this.eZv = 5;
        this.eZz = R.drawable.icon_pure_evaluation_star24_n;
        this.eZA = R.color.cp_cont_i;
        this.eZB = R.drawable.icon_pure_evaluation_star24_n;
        this.eZC = R.color.cp_link_tip_d;
        this.aiX = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZv = 5;
        this.eZz = R.drawable.icon_pure_evaluation_star24_n;
        this.eZA = R.color.cp_cont_i;
        this.eZB = R.drawable.icon_pure_evaluation_star24_n;
        this.eZC = R.color.cp_link_tip_d;
        this.aiX = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZv = 5;
        this.eZz = R.drawable.icon_pure_evaluation_star24_n;
        this.eZA = R.color.cp_cont_i;
        this.eZB = R.drawable.icon_pure_evaluation_star24_n;
        this.eZC = R.color.cp_link_tip_d;
        this.aiX = 3;
        init(context);
    }

    private void init(Context context) {
        this.eZx = l.getDimens(context, R.dimen.tbds63);
        bml();
    }

    public int getStarCount() {
        return this.eZu;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.eZv) {
            i = this.eZv;
        }
        if (this.eZu != i) {
            this.eZu = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.eZw = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.eZz = i;
        this.eZA = i2;
        this.eZB = i3;
        this.eZC = i4;
        bml();
    }

    public void onChangeSkinType(int i) {
        if (this.aiX != i) {
            this.aiX = i;
            bml();
        }
    }

    public void bml() {
        this.eZD = SvgManager.bkl().a(this.eZz, this.eZA, (SvgManager.SvgResourceStateType) null);
        this.eZE = SvgManager.bkl().a(this.eZB, this.eZC, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.eZy + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.eZy) * this.eZv)) + 1);
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
            this.eZx = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.eZx + getPaddingBottom() + getPaddingTop();
        }
        this.eZy = (this.eZx * this.eZv) + (this.eZw * (this.eZv - 1));
        if (mode != 1073741824) {
            size = this.eZy + getPaddingLeft() + getPaddingRight();
        } else if (size < this.eZy) {
            this.eZy = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eZD != null && this.eZE != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.eZu; i++) {
                this.eZE.setBounds(paddingLeft, getPaddingTop(), this.eZx + paddingLeft, this.eZx + getPaddingTop());
                this.eZE.draw(canvas);
                paddingLeft += this.eZw + this.eZx;
            }
            for (int i2 = this.eZu; i2 < this.eZv; i2++) {
                this.eZD.setBounds(paddingLeft, getPaddingTop(), this.eZx + paddingLeft, this.eZx + getPaddingTop());
                this.eZD.draw(canvas);
                paddingLeft += this.eZw + this.eZx;
            }
        }
    }
}

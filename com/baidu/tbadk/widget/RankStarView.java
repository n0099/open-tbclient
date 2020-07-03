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
    private int ahx;
    private int eFA;
    private int eFB;
    private int eFC;
    private int eFD;
    private int eFE;
    private int eFF;
    private Drawable eFG;
    private Drawable eFH;
    private int eFx;
    private int eFy;
    private int eFz;

    public RankStarView(Context context) {
        super(context);
        this.eFy = 5;
        this.eFC = R.drawable.icon_pure_evaluation_star24_n;
        this.eFD = R.color.cp_cont_i;
        this.eFE = R.drawable.icon_pure_evaluation_star24_n;
        this.eFF = R.color.cp_link_tip_d;
        this.ahx = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFy = 5;
        this.eFC = R.drawable.icon_pure_evaluation_star24_n;
        this.eFD = R.color.cp_cont_i;
        this.eFE = R.drawable.icon_pure_evaluation_star24_n;
        this.eFF = R.color.cp_link_tip_d;
        this.ahx = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFy = 5;
        this.eFC = R.drawable.icon_pure_evaluation_star24_n;
        this.eFD = R.color.cp_cont_i;
        this.eFE = R.drawable.icon_pure_evaluation_star24_n;
        this.eFF = R.color.cp_link_tip_d;
        this.ahx = 3;
        init(context);
    }

    private void init(Context context) {
        this.eFA = l.getDimens(context, R.dimen.tbds63);
        aYW();
    }

    public int getStarCount() {
        return this.eFx;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.eFy) {
            i = this.eFy;
        }
        if (this.eFx != i) {
            this.eFx = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.eFz = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.eFC = i;
        this.eFD = i2;
        this.eFE = i3;
        this.eFF = i4;
        aYW();
    }

    public void onChangeSkinType(int i) {
        if (this.ahx != i) {
            this.ahx = i;
            aYW();
        }
    }

    public void aYW() {
        this.eFG = SvgManager.aWQ().a(this.eFC, this.eFD, (SvgManager.SvgResourceStateType) null);
        this.eFH = SvgManager.aWQ().a(this.eFE, this.eFF, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.eFB + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.eFB) * this.eFy)) + 1);
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
            this.eFA = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.eFA + getPaddingBottom() + getPaddingTop();
        }
        this.eFB = (this.eFA * this.eFy) + (this.eFz * (this.eFy - 1));
        if (mode != 1073741824) {
            size = this.eFB + getPaddingLeft() + getPaddingRight();
        } else if (size < this.eFB) {
            this.eFB = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eFG != null && this.eFH != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.eFx; i++) {
                this.eFH.setBounds(paddingLeft, getPaddingTop(), this.eFA + paddingLeft, this.eFA + getPaddingTop());
                this.eFH.draw(canvas);
                paddingLeft += this.eFz + this.eFA;
            }
            for (int i2 = this.eFx; i2 < this.eFy; i2++) {
                this.eFG.setBounds(paddingLeft, getPaddingTop(), this.eFA + paddingLeft, this.eFA + getPaddingTop());
                this.eFG.draw(canvas);
                paddingLeft += this.eFz + this.eFA;
            }
        }
    }
}

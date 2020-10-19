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
    private int ajp;
    private int flG;
    private int flH;
    private int flI;
    private int flJ;
    private int flK;
    private int flL;
    private int flM;
    private int flN;
    private int flO;
    private Drawable flP;
    private Drawable flQ;

    public RankStarView(Context context) {
        super(context);
        this.flH = 5;
        this.flL = R.drawable.icon_pure_evaluation_star24_n;
        this.flM = R.color.cp_cont_i;
        this.flN = R.drawable.icon_pure_evaluation_star24_n;
        this.flO = R.color.cp_link_tip_d;
        this.ajp = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flH = 5;
        this.flL = R.drawable.icon_pure_evaluation_star24_n;
        this.flM = R.color.cp_cont_i;
        this.flN = R.drawable.icon_pure_evaluation_star24_n;
        this.flO = R.color.cp_link_tip_d;
        this.ajp = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flH = 5;
        this.flL = R.drawable.icon_pure_evaluation_star24_n;
        this.flM = R.color.cp_cont_i;
        this.flN = R.drawable.icon_pure_evaluation_star24_n;
        this.flO = R.color.cp_link_tip_d;
        this.ajp = 3;
        init(context);
    }

    private void init(Context context) {
        this.flJ = l.getDimens(context, R.dimen.tbds63);
        boV();
    }

    public int getStarCount() {
        return this.flG;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.flH) {
            i = this.flH;
        }
        if (this.flG != i) {
            this.flG = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.flI = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.flL = i;
        this.flM = i2;
        this.flN = i3;
        this.flO = i4;
        boV();
    }

    public void onChangeSkinType(int i) {
        if (this.ajp != i) {
            this.ajp = i;
            boV();
        }
    }

    public void boV() {
        this.flP = SvgManager.bmU().a(this.flL, this.flM, (SvgManager.SvgResourceStateType) null);
        this.flQ = SvgManager.bmU().a(this.flN, this.flO, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.flK + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.flK) * this.flH)) + 1);
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
            this.flJ = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.flJ + getPaddingBottom() + getPaddingTop();
        }
        this.flK = (this.flJ * this.flH) + (this.flI * (this.flH - 1));
        if (mode != 1073741824) {
            size = this.flK + getPaddingLeft() + getPaddingRight();
        } else if (size < this.flK) {
            this.flK = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.flP != null && this.flQ != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.flG; i++) {
                this.flQ.setBounds(paddingLeft, getPaddingTop(), this.flJ + paddingLeft, this.flJ + getPaddingTop());
                this.flQ.draw(canvas);
                paddingLeft += this.flI + this.flJ;
            }
            for (int i2 = this.flG; i2 < this.flH; i2++) {
                this.flP.setBounds(paddingLeft, getPaddingTop(), this.flJ + paddingLeft, this.flJ + getPaddingTop());
                this.flP.draw(canvas);
                paddingLeft += this.flI + this.flJ;
            }
        }
    }
}

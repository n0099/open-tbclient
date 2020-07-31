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
    private int aho;
    private int eLT;
    private int eLU;
    private int eLV;
    private int eLW;
    private int eLX;
    private int eLY;
    private int eLZ;
    private int eMa;
    private int eMb;
    private Drawable eMc;
    private Drawable eMd;

    public RankStarView(Context context) {
        super(context);
        this.eLU = 5;
        this.eLY = R.drawable.icon_pure_evaluation_star24_n;
        this.eLZ = R.color.cp_cont_i;
        this.eMa = R.drawable.icon_pure_evaluation_star24_n;
        this.eMb = R.color.cp_link_tip_d;
        this.aho = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLU = 5;
        this.eLY = R.drawable.icon_pure_evaluation_star24_n;
        this.eLZ = R.color.cp_cont_i;
        this.eMa = R.drawable.icon_pure_evaluation_star24_n;
        this.eMb = R.color.cp_link_tip_d;
        this.aho = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eLU = 5;
        this.eLY = R.drawable.icon_pure_evaluation_star24_n;
        this.eLZ = R.color.cp_cont_i;
        this.eMa = R.drawable.icon_pure_evaluation_star24_n;
        this.eMb = R.color.cp_link_tip_d;
        this.aho = 3;
        init(context);
    }

    private void init(Context context) {
        this.eLW = l.getDimens(context, R.dimen.tbds63);
        bcT();
    }

    public int getStarCount() {
        return this.eLT;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.eLU) {
            i = this.eLU;
        }
        if (this.eLT != i) {
            this.eLT = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.eLV = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.eLY = i;
        this.eLZ = i2;
        this.eMa = i3;
        this.eMb = i4;
        bcT();
    }

    public void onChangeSkinType(int i) {
        if (this.aho != i) {
            this.aho = i;
            bcT();
        }
    }

    public void bcT() {
        this.eMc = SvgManager.baR().a(this.eLY, this.eLZ, (SvgManager.SvgResourceStateType) null);
        this.eMd = SvgManager.baR().a(this.eMa, this.eMb, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.eLX + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.eLX) * this.eLU)) + 1);
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
            this.eLW = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.eLW + getPaddingBottom() + getPaddingTop();
        }
        this.eLX = (this.eLW * this.eLU) + (this.eLV * (this.eLU - 1));
        if (mode != 1073741824) {
            size = this.eLX + getPaddingLeft() + getPaddingRight();
        } else if (size < this.eLX) {
            this.eLX = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eMc != null && this.eMd != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.eLT; i++) {
                this.eMd.setBounds(paddingLeft, getPaddingTop(), this.eLW + paddingLeft, this.eLW + getPaddingTop());
                this.eMd.draw(canvas);
                paddingLeft += this.eLV + this.eLW;
            }
            for (int i2 = this.eLT; i2 < this.eLU; i2++) {
                this.eMc.setBounds(paddingLeft, getPaddingTop(), this.eLW + paddingLeft, this.eLW + getPaddingTop());
                this.eMc.draw(canvas);
                paddingLeft += this.eLV + this.eLW;
            }
        }
    }
}

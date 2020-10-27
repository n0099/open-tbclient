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
    private int fuh;
    private int fui;
    private int fuj;
    private int fuk;
    private int ful;
    private int fum;
    private int fun;
    private int fuo;
    private int fup;
    private Drawable fuq;
    private Drawable fur;

    public RankStarView(Context context) {
        super(context);
        this.fui = 5;
        this.fum = R.drawable.icon_pure_evaluation_star24_n;
        this.fun = R.color.cp_cont_i;
        this.fuo = R.drawable.icon_pure_evaluation_star24_n;
        this.fup = R.color.cp_link_tip_d;
        this.ajq = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fui = 5;
        this.fum = R.drawable.icon_pure_evaluation_star24_n;
        this.fun = R.color.cp_cont_i;
        this.fuo = R.drawable.icon_pure_evaluation_star24_n;
        this.fup = R.color.cp_link_tip_d;
        this.ajq = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fui = 5;
        this.fum = R.drawable.icon_pure_evaluation_star24_n;
        this.fun = R.color.cp_cont_i;
        this.fuo = R.drawable.icon_pure_evaluation_star24_n;
        this.fup = R.color.cp_link_tip_d;
        this.ajq = 3;
        init(context);
    }

    private void init(Context context) {
        this.fuk = l.getDimens(context, R.dimen.tbds63);
        bqO();
    }

    public int getStarCount() {
        return this.fuh;
    }

    public void setStarCount(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.fui) {
            i = this.fui;
        }
        if (this.fuh != i) {
            this.fuh = i;
            invalidate();
        }
    }

    public void setStarSpacing(int i) {
        this.fuj = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fum = i;
        this.fun = i2;
        this.fuo = i3;
        this.fup = i4;
        bqO();
    }

    public void onChangeSkinType(int i) {
        if (this.ajq != i) {
            this.ajq = i;
            bqO();
        }
    }

    public void bqO() {
        this.fuq = SvgManager.boN().a(this.fum, this.fun, (SvgManager.SvgResourceStateType) null);
        this.fur = SvgManager.boN().a(this.fuo, this.fup, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.ful + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount(((int) ((((x - getPaddingLeft()) * 1.0f) / this.ful) * this.fui)) + 1);
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
            this.fuk = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fuk + getPaddingBottom() + getPaddingTop();
        }
        this.ful = (this.fuk * this.fui) + (this.fuj * (this.fui - 1));
        if (mode != 1073741824) {
            size = this.ful + getPaddingLeft() + getPaddingRight();
        } else if (size < this.ful) {
            this.ful = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fuq != null && this.fur != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fuh; i++) {
                this.fur.setBounds(paddingLeft, getPaddingTop(), this.fuk + paddingLeft, this.fuk + getPaddingTop());
                this.fur.draw(canvas);
                paddingLeft += this.fuj + this.fuk;
            }
            for (int i2 = this.fuh; i2 < this.fui; i2++) {
                this.fuq.setBounds(paddingLeft, getPaddingTop(), this.fuk + paddingLeft, this.fuk + getPaddingTop());
                this.fuq.draw(canvas);
                paddingLeft += this.fuj + this.fuk;
            }
        }
    }
}

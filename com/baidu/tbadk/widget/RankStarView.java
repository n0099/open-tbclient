package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
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
    private int ajv;
    private int fzA;
    private int fzB;
    private int fzC;
    private Drawable fzD;
    private Drawable fzE;
    private Rect fzF;
    private Rect fzG;
    private boolean fzH;
    private int fzu;
    private float fzv;
    private int fzw;
    private int fzx;
    private int fzy;
    private int fzz;

    public RankStarView(Context context) {
        super(context);
        this.fzu = 5;
        this.fzz = R.drawable.icon_pure_evaluation_star24_n;
        this.fzA = R.color.CAM_X0112;
        this.fzB = R.drawable.icon_pure_evaluation_star24_n;
        this.fzC = R.color.CAM_X0305;
        this.ajv = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzu = 5;
        this.fzz = R.drawable.icon_pure_evaluation_star24_n;
        this.fzA = R.color.CAM_X0112;
        this.fzB = R.drawable.icon_pure_evaluation_star24_n;
        this.fzC = R.color.CAM_X0305;
        this.ajv = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzu = 5;
        this.fzz = R.drawable.icon_pure_evaluation_star24_n;
        this.fzA = R.color.CAM_X0112;
        this.fzB = R.drawable.icon_pure_evaluation_star24_n;
        this.fzC = R.color.CAM_X0305;
        this.ajv = 3;
        init(context);
    }

    private void init(Context context) {
        this.fzx = l.getDimens(context, R.dimen.tbds63);
        this.fzF = new Rect(0, 0, 0, 0);
        this.fzG = new Rect(0, 0, 0, 0);
        bsE();
    }

    public void setIsHalfStar(boolean z) {
        this.fzH = z;
    }

    public void setStarCount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > this.fzu) {
            f = this.fzu;
        }
        if (this.fzv != f) {
            this.fzv = f;
            invalidate();
        }
    }

    public int getStarCount() {
        return ((int) this.fzv) + 1;
    }

    public void setStarSpacing(int i) {
        this.fzw = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fzz = i;
        this.fzA = i2;
        this.fzB = i3;
        this.fzC = i4;
        bsE();
    }

    public void onChangeSkinType(int i) {
        if (this.ajv != i) {
            this.ajv = i;
            bsE();
        }
    }

    public void bsE() {
        this.fzD = SvgManager.bqB().a(this.fzz, this.fzA, (SvgManager.SvgResourceStateType) null);
        this.fzE = SvgManager.bqB().a(this.fzB, this.fzC, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.fzy + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.fzy) * this.fzu);
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
            this.fzx = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fzx + getPaddingBottom() + getPaddingTop();
        }
        this.fzy = (this.fzx * this.fzu) + (this.fzw * (this.fzu - 1));
        if (mode != 1073741824) {
            size = this.fzy + getPaddingLeft() + getPaddingRight();
        } else if (size < this.fzy) {
            this.fzy = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fzD != null && this.fzE != null) {
            if (this.fzH) {
                J(canvas);
            } else {
                K(canvas);
            }
        }
    }

    private void J(Canvas canvas) {
        int i;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < ((int) this.fzv); i2++) {
            this.fzE.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
            this.fzE.draw(canvas);
            paddingLeft += this.fzw + this.fzx;
        }
        if (this.fzv - ((int) this.fzv) >= 0.5d) {
            this.fzE.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
            this.fzE.draw(canvas);
            i = this.fzw + this.fzx + paddingLeft;
        } else if (this.fzv - ((int) this.fzv) > 0.0f) {
            this.fzE.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
            canvas.save();
            this.fzF.set(paddingLeft, getPaddingTop(), (this.fzx / 2) + paddingLeft, this.fzx + getPaddingTop());
            canvas.clipRect(this.fzF);
            this.fzE.draw(canvas);
            canvas.restore();
            this.fzD.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
            canvas.save();
            this.fzG.set((this.fzx / 2) + paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
            canvas.clipRect(this.fzG);
            this.fzD.draw(canvas);
            canvas.restore();
            i = this.fzw + this.fzx + paddingLeft;
        } else {
            this.fzD.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
            this.fzD.draw(canvas);
            i = this.fzw + this.fzx + paddingLeft;
        }
        int i3 = i;
        for (int i4 = ((int) this.fzv) + 1; i4 < this.fzu; i4++) {
            this.fzD.setBounds(i3, getPaddingTop(), this.fzx + i3, this.fzx + getPaddingTop());
            this.fzD.draw(canvas);
            i3 += this.fzw + this.fzx;
        }
    }

    private void K(Canvas canvas) {
        if (this.fzD != null && this.fzE != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fzv; i++) {
                this.fzE.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
                this.fzE.draw(canvas);
                paddingLeft += this.fzw + this.fzx;
            }
            if (this.fzv - ((int) this.fzv) > 0.0f) {
                int i2 = (int) this.fzv;
                while (true) {
                    i2++;
                    if (i2 < this.fzu) {
                        this.fzD.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
                        this.fzD.draw(canvas);
                        paddingLeft += this.fzw + this.fzx;
                    } else {
                        return;
                    }
                }
            } else {
                for (int i3 = (int) this.fzv; i3 < this.fzu; i3++) {
                    this.fzD.setBounds(paddingLeft, getPaddingTop(), this.fzx + paddingLeft, this.fzx + getPaddingTop());
                    this.fzD.draw(canvas);
                    paddingLeft += this.fzw + this.fzx;
                }
            }
        }
    }
}

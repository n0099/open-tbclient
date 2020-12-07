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
    private int aku;
    private int fHj;
    private float fHk;
    private int fHl;
    private int fHm;
    private int fHn;
    private int fHo;
    private int fHp;
    private int fHq;
    private int fHr;
    private Drawable fHs;
    private Drawable fHt;
    private Rect fHu;
    private Rect fHv;
    private boolean fHw;
    private a fHx;

    /* loaded from: classes.dex */
    public interface a {
        void an(float f);
    }

    public RankStarView(Context context) {
        super(context);
        this.fHj = 5;
        this.fHo = R.drawable.icon_pure_evaluation_star24_n;
        this.fHp = R.color.CAM_X0112;
        this.fHq = R.drawable.icon_pure_evaluation_star24_n;
        this.fHr = R.color.CAM_X0305;
        this.aku = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fHj = 5;
        this.fHo = R.drawable.icon_pure_evaluation_star24_n;
        this.fHp = R.color.CAM_X0112;
        this.fHq = R.drawable.icon_pure_evaluation_star24_n;
        this.fHr = R.color.CAM_X0305;
        this.aku = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fHj = 5;
        this.fHo = R.drawable.icon_pure_evaluation_star24_n;
        this.fHp = R.color.CAM_X0112;
        this.fHq = R.drawable.icon_pure_evaluation_star24_n;
        this.fHr = R.color.CAM_X0305;
        this.aku = 3;
        init(context);
    }

    private void init(Context context) {
        this.fHm = l.getDimens(context, R.dimen.tbds63);
        this.fHu = new Rect(0, 0, 0, 0);
        this.fHv = new Rect(0, 0, 0, 0);
        bwe();
    }

    public void setIsHalfStar(boolean z) {
        this.fHw = z;
    }

    public void setStarCount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > this.fHj) {
            f = this.fHj;
        }
        if (this.fHk != f) {
            this.fHk = f;
            invalidate();
        }
        if (this.fHx != null) {
            this.fHx.an(f);
        }
    }

    public int getStarCount() {
        if (this.fHk == 0.0f) {
            return 0;
        }
        return ((int) this.fHk) + 1;
    }

    public boolean bHk() {
        return this.fHk != 0.0f;
    }

    public void setStarSpacing(int i) {
        this.fHl = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fHo = i;
        this.fHp = i2;
        this.fHq = i3;
        this.fHr = i4;
        bwe();
    }

    public void onChangeSkinType(int i) {
        if (this.aku != i) {
            this.aku = i;
            bwe();
        }
    }

    public void bwe() {
        this.fHs = SvgManager.btW().a(this.fHo, this.fHp, (SvgManager.SvgResourceStateType) null);
        this.fHt = SvgManager.btW().a(this.fHq, this.fHr, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.fHn + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.fHn) * this.fHj);
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
            this.fHm = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fHm + getPaddingBottom() + getPaddingTop();
        }
        this.fHn = (this.fHm * this.fHj) + (this.fHl * (this.fHj - 1));
        if (mode != 1073741824) {
            size = this.fHn + getPaddingLeft() + getPaddingRight();
        } else if (size < this.fHn) {
            this.fHn = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fHs != null && this.fHt != null) {
            if (this.fHw) {
                J(canvas);
            } else {
                K(canvas);
            }
        }
    }

    private void J(Canvas canvas) {
        int i;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < ((int) this.fHk); i2++) {
            this.fHt.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
            this.fHt.draw(canvas);
            paddingLeft += this.fHl + this.fHm;
        }
        if (this.fHk - ((int) this.fHk) >= 0.5d) {
            this.fHt.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
            this.fHt.draw(canvas);
            i = this.fHl + this.fHm + paddingLeft;
        } else if (this.fHk - ((int) this.fHk) > 0.0f) {
            this.fHt.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
            canvas.save();
            this.fHu.set(paddingLeft, getPaddingTop(), (this.fHm / 2) + paddingLeft, this.fHm + getPaddingTop());
            canvas.clipRect(this.fHu);
            this.fHt.draw(canvas);
            canvas.restore();
            this.fHs.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
            canvas.save();
            this.fHv.set((this.fHm / 2) + paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
            canvas.clipRect(this.fHv);
            this.fHs.draw(canvas);
            canvas.restore();
            i = this.fHl + this.fHm + paddingLeft;
        } else {
            this.fHs.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
            this.fHs.draw(canvas);
            i = this.fHl + this.fHm + paddingLeft;
        }
        int i3 = i;
        for (int i4 = ((int) this.fHk) + 1; i4 < this.fHj; i4++) {
            this.fHs.setBounds(i3, getPaddingTop(), this.fHm + i3, this.fHm + getPaddingTop());
            this.fHs.draw(canvas);
            i3 += this.fHl + this.fHm;
        }
    }

    private void K(Canvas canvas) {
        if (this.fHs != null && this.fHt != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fHk; i++) {
                this.fHt.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
                this.fHt.draw(canvas);
                paddingLeft += this.fHl + this.fHm;
            }
            if (this.fHk - ((int) this.fHk) > 0.0f) {
                int i2 = (int) this.fHk;
                while (true) {
                    i2++;
                    if (i2 < this.fHj) {
                        this.fHs.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
                        this.fHs.draw(canvas);
                        paddingLeft += this.fHl + this.fHm;
                    } else {
                        return;
                    }
                }
            } else {
                for (int i3 = (int) this.fHk; i3 < this.fHj; i3++) {
                    this.fHs.setBounds(paddingLeft, getPaddingTop(), this.fHm + paddingLeft, this.fHm + getPaddingTop());
                    this.fHs.draw(canvas);
                    paddingLeft += this.fHl + this.fHm;
                }
            }
        }
    }

    public void setStarChangListener(a aVar) {
        this.fHx = aVar;
    }
}

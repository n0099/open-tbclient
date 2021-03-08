package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class RankStarView extends View {
    private int aln;
    private int fPS;
    private float fPT;
    private int fPU;
    private int fPV;
    private int fPW;
    private int fPX;
    private int fPY;
    private int fPZ;
    private int fQa;
    private Drawable fQb;
    private Drawable fQc;
    private Rect fQd;
    private Rect fQe;
    private boolean fQf;
    private a fQg;

    /* loaded from: classes.dex */
    public interface a {
        void au(float f);
    }

    public RankStarView(Context context) {
        super(context);
        this.fPS = 5;
        this.fPX = R.drawable.icon_pure_evaluation_star24_n;
        this.fPY = R.color.CAM_X0112;
        this.fPZ = R.drawable.icon_pure_evaluation_star24_n;
        this.fQa = R.color.CAM_X0305;
        this.aln = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fPS = 5;
        this.fPX = R.drawable.icon_pure_evaluation_star24_n;
        this.fPY = R.color.CAM_X0112;
        this.fPZ = R.drawable.icon_pure_evaluation_star24_n;
        this.fQa = R.color.CAM_X0305;
        this.aln = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPS = 5;
        this.fPX = R.drawable.icon_pure_evaluation_star24_n;
        this.fPY = R.color.CAM_X0112;
        this.fPZ = R.drawable.icon_pure_evaluation_star24_n;
        this.fQa = R.color.CAM_X0305;
        this.aln = 3;
        init(context);
    }

    private void init(Context context) {
        this.fPV = l.getDimens(context, R.dimen.tbds63);
        this.fQd = new Rect(0, 0, 0, 0);
        this.fQe = new Rect(0, 0, 0, 0);
        bvc();
    }

    public void setIsHalfStar(boolean z) {
        this.fQf = z;
    }

    public void setStarCount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > this.fPS) {
            f = this.fPS;
        }
        if (this.fPT != f) {
            this.fPT = f;
            invalidate();
        }
        if (this.fQg != null) {
            this.fQg.au(f);
        }
    }

    public int getStarCount() {
        if (this.fPT == 0.0f) {
            return 0;
        }
        return ((int) this.fPT) + 1;
    }

    public boolean bGk() {
        return this.fPT != 0.0f;
    }

    public void setStarSpacing(int i) {
        this.fPU = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fPX = i;
        this.fPY = i2;
        this.fPZ = i3;
        this.fQa = i4;
        bvc();
    }

    public void onChangeSkinType(int i) {
        if (this.aln != i) {
            this.aln = i;
            bvc();
        }
    }

    public void bvc() {
        this.fQb = SvgManager.bsU().a(this.fPX, this.fPY, (SvgManager.SvgResourceStateType) null);
        this.fQc = SvgManager.bsU().a(this.fPZ, this.fQa, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.fPW + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.fPW) * this.fPS);
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
            this.fPV = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fPV + getPaddingBottom() + getPaddingTop();
        }
        this.fPW = (this.fPV * this.fPS) + (this.fPU * (this.fPS - 1));
        if (mode != 1073741824) {
            size = this.fPW + getPaddingLeft() + getPaddingRight();
        } else if (size < this.fPW) {
            this.fPW = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fQb != null && this.fQc != null) {
            if (this.fQf) {
                P(canvas);
            } else {
                Q(canvas);
            }
        }
    }

    private void P(Canvas canvas) {
        int i;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < ((int) this.fPT); i2++) {
            this.fQc.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
            this.fQc.draw(canvas);
            paddingLeft += this.fPU + this.fPV;
        }
        if (this.fPT - ((int) this.fPT) >= 0.5d) {
            this.fQc.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
            this.fQc.draw(canvas);
            i = this.fPU + this.fPV + paddingLeft;
        } else if (this.fPT - ((int) this.fPT) > 0.0f) {
            this.fQc.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
            canvas.save();
            this.fQd.set(paddingLeft, getPaddingTop(), (this.fPV / 2) + paddingLeft, this.fPV + getPaddingTop());
            canvas.clipRect(this.fQd);
            this.fQc.draw(canvas);
            canvas.restore();
            this.fQb.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
            canvas.save();
            this.fQe.set((this.fPV / 2) + paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
            canvas.clipRect(this.fQe);
            this.fQb.draw(canvas);
            canvas.restore();
            i = this.fPU + this.fPV + paddingLeft;
        } else {
            this.fQb.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
            this.fQb.draw(canvas);
            i = this.fPU + this.fPV + paddingLeft;
        }
        int i3 = i;
        for (int i4 = ((int) this.fPT) + 1; i4 < this.fPS; i4++) {
            this.fQb.setBounds(i3, getPaddingTop(), this.fPV + i3, this.fPV + getPaddingTop());
            this.fQb.draw(canvas);
            i3 += this.fPU + this.fPV;
        }
    }

    private void Q(Canvas canvas) {
        if (this.fQb != null && this.fQc != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fPT; i++) {
                this.fQc.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
                this.fQc.draw(canvas);
                paddingLeft += this.fPU + this.fPV;
            }
            if (this.fPT - ((int) this.fPT) > 0.0f) {
                int i2 = (int) this.fPT;
                while (true) {
                    i2++;
                    if (i2 < this.fPS) {
                        this.fQb.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
                        this.fQb.draw(canvas);
                        paddingLeft += this.fPU + this.fPV;
                    } else {
                        return;
                    }
                }
            } else {
                for (int i3 = (int) this.fPT; i3 < this.fPS; i3++) {
                    this.fQb.setBounds(paddingLeft, getPaddingTop(), this.fPV + paddingLeft, this.fPV + getPaddingTop());
                    this.fQb.draw(canvas);
                    paddingLeft += this.fPU + this.fPV;
                }
            }
        }
    }

    public void setStarChangListener(a aVar) {
        this.fQg = aVar;
    }
}

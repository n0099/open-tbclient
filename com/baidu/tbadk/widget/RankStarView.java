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
    private int akf;
    private int fMe;
    private float fMf;
    private int fMg;
    private int fMh;
    private int fMi;
    private int fMj;
    private int fMk;
    private int fMl;
    private int fMm;
    private Drawable fMn;
    private Drawable fMo;
    private Rect fMp;
    private Rect fMq;
    private boolean fMr;
    private a fMs;

    /* loaded from: classes.dex */
    public interface a {
        void ap(float f);
    }

    public RankStarView(Context context) {
        super(context);
        this.fMe = 5;
        this.fMj = R.drawable.icon_pure_evaluation_star24_n;
        this.fMk = R.color.CAM_X0112;
        this.fMl = R.drawable.icon_pure_evaluation_star24_n;
        this.fMm = R.color.CAM_X0305;
        this.akf = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMe = 5;
        this.fMj = R.drawable.icon_pure_evaluation_star24_n;
        this.fMk = R.color.CAM_X0112;
        this.fMl = R.drawable.icon_pure_evaluation_star24_n;
        this.fMm = R.color.CAM_X0305;
        this.akf = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMe = 5;
        this.fMj = R.drawable.icon_pure_evaluation_star24_n;
        this.fMk = R.color.CAM_X0112;
        this.fMl = R.drawable.icon_pure_evaluation_star24_n;
        this.fMm = R.color.CAM_X0305;
        this.akf = 3;
        init(context);
    }

    private void init(Context context) {
        this.fMh = l.getDimens(context, R.dimen.tbds63);
        this.fMp = new Rect(0, 0, 0, 0);
        this.fMq = new Rect(0, 0, 0, 0);
        buF();
    }

    public void setIsHalfStar(boolean z) {
        this.fMr = z;
    }

    public void setStarCount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > this.fMe) {
            f = this.fMe;
        }
        if (this.fMf != f) {
            this.fMf = f;
            invalidate();
        }
        if (this.fMs != null) {
            this.fMs.ap(f);
        }
    }

    public int getStarCount() {
        if (this.fMf == 0.0f) {
            return 0;
        }
        return ((int) this.fMf) + 1;
    }

    public boolean bFM() {
        return this.fMf != 0.0f;
    }

    public void setStarSpacing(int i) {
        this.fMg = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fMj = i;
        this.fMk = i2;
        this.fMl = i3;
        this.fMm = i4;
        buF();
    }

    public void onChangeSkinType(int i) {
        if (this.akf != i) {
            this.akf = i;
            buF();
        }
    }

    public void buF() {
        this.fMn = SvgManager.bsx().a(this.fMj, this.fMk, (SvgManager.SvgResourceStateType) null);
        this.fMo = SvgManager.bsx().a(this.fMl, this.fMm, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.fMi + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.fMi) * this.fMe);
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
            this.fMh = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fMh + getPaddingBottom() + getPaddingTop();
        }
        this.fMi = (this.fMh * this.fMe) + (this.fMg * (this.fMe - 1));
        if (mode != 1073741824) {
            size = this.fMi + getPaddingLeft() + getPaddingRight();
        } else if (size < this.fMi) {
            this.fMi = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fMn != null && this.fMo != null) {
            if (this.fMr) {
                P(canvas);
            } else {
                Q(canvas);
            }
        }
    }

    private void P(Canvas canvas) {
        int i;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < ((int) this.fMf); i2++) {
            this.fMo.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
            this.fMo.draw(canvas);
            paddingLeft += this.fMg + this.fMh;
        }
        if (this.fMf - ((int) this.fMf) >= 0.5d) {
            this.fMo.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
            this.fMo.draw(canvas);
            i = this.fMg + this.fMh + paddingLeft;
        } else if (this.fMf - ((int) this.fMf) > 0.0f) {
            this.fMo.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
            canvas.save();
            this.fMp.set(paddingLeft, getPaddingTop(), (this.fMh / 2) + paddingLeft, this.fMh + getPaddingTop());
            canvas.clipRect(this.fMp);
            this.fMo.draw(canvas);
            canvas.restore();
            this.fMn.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
            canvas.save();
            this.fMq.set((this.fMh / 2) + paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
            canvas.clipRect(this.fMq);
            this.fMn.draw(canvas);
            canvas.restore();
            i = this.fMg + this.fMh + paddingLeft;
        } else {
            this.fMn.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
            this.fMn.draw(canvas);
            i = this.fMg + this.fMh + paddingLeft;
        }
        int i3 = i;
        for (int i4 = ((int) this.fMf) + 1; i4 < this.fMe; i4++) {
            this.fMn.setBounds(i3, getPaddingTop(), this.fMh + i3, this.fMh + getPaddingTop());
            this.fMn.draw(canvas);
            i3 += this.fMg + this.fMh;
        }
    }

    private void Q(Canvas canvas) {
        if (this.fMn != null && this.fMo != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fMf; i++) {
                this.fMo.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
                this.fMo.draw(canvas);
                paddingLeft += this.fMg + this.fMh;
            }
            if (this.fMf - ((int) this.fMf) > 0.0f) {
                int i2 = (int) this.fMf;
                while (true) {
                    i2++;
                    if (i2 < this.fMe) {
                        this.fMn.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
                        this.fMn.draw(canvas);
                        paddingLeft += this.fMg + this.fMh;
                    } else {
                        return;
                    }
                }
            } else {
                for (int i3 = (int) this.fMf; i3 < this.fMe; i3++) {
                    this.fMn.setBounds(paddingLeft, getPaddingTop(), this.fMh + paddingLeft, this.fMh + getPaddingTop());
                    this.fMn.draw(canvas);
                    paddingLeft += this.fMg + this.fMh;
                }
            }
        }
    }

    public void setStarChangListener(a aVar) {
        this.fMs = aVar;
    }
}

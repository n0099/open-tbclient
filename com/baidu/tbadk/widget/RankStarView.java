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
    private int ajU;
    private int fOA;
    private Drawable fOB;
    private Drawable fOC;
    private Rect fOD;
    private Rect fOE;
    private boolean fOF;
    private a fOG;
    private int fOs;
    private float fOt;
    private int fOu;
    private int fOv;
    private int fOw;
    private int fOx;
    private int fOy;
    private int fOz;

    /* loaded from: classes.dex */
    public interface a {
        void aq(float f);
    }

    public RankStarView(Context context) {
        super(context);
        this.fOs = 5;
        this.fOx = R.drawable.icon_pure_evaluation_star24_n;
        this.fOy = R.color.CAM_X0112;
        this.fOz = R.drawable.icon_pure_evaluation_star24_n;
        this.fOA = R.color.CAM_X0305;
        this.ajU = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fOs = 5;
        this.fOx = R.drawable.icon_pure_evaluation_star24_n;
        this.fOy = R.color.CAM_X0112;
        this.fOz = R.drawable.icon_pure_evaluation_star24_n;
        this.fOA = R.color.CAM_X0305;
        this.ajU = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fOs = 5;
        this.fOx = R.drawable.icon_pure_evaluation_star24_n;
        this.fOy = R.color.CAM_X0112;
        this.fOz = R.drawable.icon_pure_evaluation_star24_n;
        this.fOA = R.color.CAM_X0305;
        this.ajU = 3;
        init(context);
    }

    private void init(Context context) {
        this.fOv = l.getDimens(context, R.dimen.tbds63);
        this.fOD = new Rect(0, 0, 0, 0);
        this.fOE = new Rect(0, 0, 0, 0);
        buZ();
    }

    public void setIsHalfStar(boolean z) {
        this.fOF = z;
    }

    public void setStarCount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > this.fOs) {
            f = this.fOs;
        }
        if (this.fOt != f) {
            this.fOt = f;
            invalidate();
        }
        if (this.fOG != null) {
            this.fOG.aq(f);
        }
    }

    public int getStarCount() {
        if (this.fOt == 0.0f) {
            return 0;
        }
        return ((int) this.fOt) + 1;
    }

    public boolean bGg() {
        return this.fOt != 0.0f;
    }

    public void setStarSpacing(int i) {
        this.fOu = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fOx = i;
        this.fOy = i2;
        this.fOz = i3;
        this.fOA = i4;
        buZ();
    }

    public void onChangeSkinType(int i) {
        if (this.ajU != i) {
            this.ajU = i;
            buZ();
        }
    }

    public void buZ() {
        this.fOB = SvgManager.bsR().a(this.fOx, this.fOy, (SvgManager.SvgResourceStateType) null);
        this.fOC = SvgManager.bsR().a(this.fOz, this.fOA, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.fOw + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.fOw) * this.fOs);
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
            this.fOv = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fOv + getPaddingBottom() + getPaddingTop();
        }
        this.fOw = (this.fOv * this.fOs) + (this.fOu * (this.fOs - 1));
        if (mode != 1073741824) {
            size = this.fOw + getPaddingLeft() + getPaddingRight();
        } else if (size < this.fOw) {
            this.fOw = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fOB != null && this.fOC != null) {
            if (this.fOF) {
                P(canvas);
            } else {
                Q(canvas);
            }
        }
    }

    private void P(Canvas canvas) {
        int i;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < ((int) this.fOt); i2++) {
            this.fOC.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
            this.fOC.draw(canvas);
            paddingLeft += this.fOu + this.fOv;
        }
        if (this.fOt - ((int) this.fOt) >= 0.5d) {
            this.fOC.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
            this.fOC.draw(canvas);
            i = this.fOu + this.fOv + paddingLeft;
        } else if (this.fOt - ((int) this.fOt) > 0.0f) {
            this.fOC.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
            canvas.save();
            this.fOD.set(paddingLeft, getPaddingTop(), (this.fOv / 2) + paddingLeft, this.fOv + getPaddingTop());
            canvas.clipRect(this.fOD);
            this.fOC.draw(canvas);
            canvas.restore();
            this.fOB.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
            canvas.save();
            this.fOE.set((this.fOv / 2) + paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
            canvas.clipRect(this.fOE);
            this.fOB.draw(canvas);
            canvas.restore();
            i = this.fOu + this.fOv + paddingLeft;
        } else {
            this.fOB.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
            this.fOB.draw(canvas);
            i = this.fOu + this.fOv + paddingLeft;
        }
        int i3 = i;
        for (int i4 = ((int) this.fOt) + 1; i4 < this.fOs; i4++) {
            this.fOB.setBounds(i3, getPaddingTop(), this.fOv + i3, this.fOv + getPaddingTop());
            this.fOB.draw(canvas);
            i3 += this.fOu + this.fOv;
        }
    }

    private void Q(Canvas canvas) {
        if (this.fOB != null && this.fOC != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fOt; i++) {
                this.fOC.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
                this.fOC.draw(canvas);
                paddingLeft += this.fOu + this.fOv;
            }
            if (this.fOt - ((int) this.fOt) > 0.0f) {
                int i2 = (int) this.fOt;
                while (true) {
                    i2++;
                    if (i2 < this.fOs) {
                        this.fOB.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
                        this.fOB.draw(canvas);
                        paddingLeft += this.fOu + this.fOv;
                    } else {
                        return;
                    }
                }
            } else {
                for (int i3 = (int) this.fOt; i3 < this.fOs; i3++) {
                    this.fOB.setBounds(paddingLeft, getPaddingTop(), this.fOv + paddingLeft, this.fOv + getPaddingTop());
                    this.fOB.draw(canvas);
                    paddingLeft += this.fOu + this.fOv;
                }
            }
        }
    }

    public void setStarChangListener(a aVar) {
        this.fOG = aVar;
    }
}

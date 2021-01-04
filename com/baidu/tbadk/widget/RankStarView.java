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
    private int akW;
    private int fQL;
    private float fQM;
    private int fQN;
    private int fQO;
    private int fQP;
    private int fQQ;
    private int fQR;
    private int fQS;
    private int fQT;
    private Drawable fQU;
    private Drawable fQV;
    private Rect fQW;
    private Rect fQX;
    private boolean fQY;
    private a fQZ;

    /* loaded from: classes.dex */
    public interface a {
        void ap(float f);
    }

    public RankStarView(Context context) {
        super(context);
        this.fQL = 5;
        this.fQQ = R.drawable.icon_pure_evaluation_star24_n;
        this.fQR = R.color.CAM_X0112;
        this.fQS = R.drawable.icon_pure_evaluation_star24_n;
        this.fQT = R.color.CAM_X0305;
        this.akW = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQL = 5;
        this.fQQ = R.drawable.icon_pure_evaluation_star24_n;
        this.fQR = R.color.CAM_X0112;
        this.fQS = R.drawable.icon_pure_evaluation_star24_n;
        this.fQT = R.color.CAM_X0305;
        this.akW = 3;
        init(context);
    }

    public RankStarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQL = 5;
        this.fQQ = R.drawable.icon_pure_evaluation_star24_n;
        this.fQR = R.color.CAM_X0112;
        this.fQS = R.drawable.icon_pure_evaluation_star24_n;
        this.fQT = R.color.CAM_X0305;
        this.akW = 3;
        init(context);
    }

    private void init(Context context) {
        this.fQO = l.getDimens(context, R.dimen.tbds63);
        this.fQW = new Rect(0, 0, 0, 0);
        this.fQX = new Rect(0, 0, 0, 0);
        byy();
    }

    public void setIsHalfStar(boolean z) {
        this.fQY = z;
    }

    public void setStarCount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > this.fQL) {
            f = this.fQL;
        }
        if (this.fQM != f) {
            this.fQM = f;
            invalidate();
        }
        if (this.fQZ != null) {
            this.fQZ.ap(f);
        }
    }

    public int getStarCount() {
        if (this.fQM == 0.0f) {
            return 0;
        }
        return ((int) this.fQM) + 1;
    }

    public boolean bJD() {
        return this.fQM != 0.0f;
    }

    public void setStarSpacing(int i) {
        this.fQN = i;
    }

    public void setStarResource(@DrawableRes int i, @ColorRes int i2, @DrawableRes int i3, @ColorRes int i4) {
        this.fQQ = i;
        this.fQR = i2;
        this.fQS = i3;
        this.fQT = i4;
        byy();
    }

    public void onChangeSkinType(int i) {
        if (this.akW != i) {
            this.akW = i;
            byy();
        }
    }

    public void byy() {
        this.fQU = SvgManager.bwq().a(this.fQQ, this.fQR, (SvgManager.SvgResourceStateType) null);
        this.fQV = SvgManager.bwq().a(this.fQS, this.fQT, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent != null && onTouchEvent) {
            int x = (int) motionEvent.getX();
            if (x < getPaddingLeft() - 10 || x > this.fQP + getPaddingLeft() + 10) {
                return true;
            }
            setStarCount((((x - getPaddingLeft()) * 1.0f) / this.fQP) * this.fQL);
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
            this.fQO = (size2 - getPaddingBottom()) - getPaddingTop();
        } else {
            size2 = this.fQO + getPaddingBottom() + getPaddingTop();
        }
        this.fQP = (this.fQO * this.fQL) + (this.fQN * (this.fQL - 1));
        if (mode != 1073741824) {
            size = this.fQP + getPaddingLeft() + getPaddingRight();
        } else if (size < this.fQP) {
            this.fQP = (size - getPaddingLeft()) - getPaddingRight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fQU != null && this.fQV != null) {
            if (this.fQY) {
                P(canvas);
            } else {
                Q(canvas);
            }
        }
    }

    private void P(Canvas canvas) {
        int i;
        int paddingLeft = getPaddingLeft();
        for (int i2 = 0; i2 < ((int) this.fQM); i2++) {
            this.fQV.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
            this.fQV.draw(canvas);
            paddingLeft += this.fQN + this.fQO;
        }
        if (this.fQM - ((int) this.fQM) >= 0.5d) {
            this.fQV.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
            this.fQV.draw(canvas);
            i = this.fQN + this.fQO + paddingLeft;
        } else if (this.fQM - ((int) this.fQM) > 0.0f) {
            this.fQV.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
            canvas.save();
            this.fQW.set(paddingLeft, getPaddingTop(), (this.fQO / 2) + paddingLeft, this.fQO + getPaddingTop());
            canvas.clipRect(this.fQW);
            this.fQV.draw(canvas);
            canvas.restore();
            this.fQU.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
            canvas.save();
            this.fQX.set((this.fQO / 2) + paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
            canvas.clipRect(this.fQX);
            this.fQU.draw(canvas);
            canvas.restore();
            i = this.fQN + this.fQO + paddingLeft;
        } else {
            this.fQU.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
            this.fQU.draw(canvas);
            i = this.fQN + this.fQO + paddingLeft;
        }
        int i3 = i;
        for (int i4 = ((int) this.fQM) + 1; i4 < this.fQL; i4++) {
            this.fQU.setBounds(i3, getPaddingTop(), this.fQO + i3, this.fQO + getPaddingTop());
            this.fQU.draw(canvas);
            i3 += this.fQN + this.fQO;
        }
    }

    private void Q(Canvas canvas) {
        if (this.fQU != null && this.fQV != null) {
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < this.fQM; i++) {
                this.fQV.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
                this.fQV.draw(canvas);
                paddingLeft += this.fQN + this.fQO;
            }
            if (this.fQM - ((int) this.fQM) > 0.0f) {
                int i2 = (int) this.fQM;
                while (true) {
                    i2++;
                    if (i2 < this.fQL) {
                        this.fQU.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
                        this.fQU.draw(canvas);
                        paddingLeft += this.fQN + this.fQO;
                    } else {
                        return;
                    }
                }
            } else {
                for (int i3 = (int) this.fQM; i3 < this.fQL; i3++) {
                    this.fQU.setBounds(paddingLeft, getPaddingTop(), this.fQO + paddingLeft, this.fQO + getPaddingTop());
                    this.fQU.draw(canvas);
                    paddingLeft += this.fQN + this.fQO;
                }
            }
        }
    }

    public void setStarChangListener(a aVar) {
        this.fQZ = aVar;
    }
}

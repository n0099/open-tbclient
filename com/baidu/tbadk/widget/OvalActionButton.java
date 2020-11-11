package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class OvalActionButton extends ImageView {
    private int color;
    private int endColor;
    private PorterDuffXfermode fzA;
    private PorterDuffXfermode fzB;
    private boolean fzO;
    private boolean fzP;
    private boolean fzQ;
    private Paint fzR;
    private float[] fzS;
    private float[] fzT;
    private LinearGradient fzU;
    private Drawable fzV;
    private int fzW;
    private int mHeight;
    private Drawable mIcon;
    private Paint mPaint;
    private Path mPath;
    private int mSkinType;
    private int mWidth;
    private int startColor;

    public OvalActionButton(Context context) {
        this(context, null);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzO = true;
        this.fzQ = true;
        this.fzS = new float[4];
        this.fzT = new float[4];
        this.color = ap.getColor(R.color.cp_link_tip_e);
        this.fzA = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.fzB = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        bEp();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.fzR = new Paint();
        this.fzR.setColor(ap.getColor(R.color.cp_cont_a));
        this.fzR.setStrokeCap(Paint.Cap.ROUND);
        this.fzR.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void bEp() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType == 0) {
            this.startColor = com.baidu.tieba.tbadkCore.c.fv("#00E1FF");
            this.endColor = com.baidu.tieba.tbadkCore.c.fv("#00A2FF");
        } else if (this.mSkinType == 1) {
            this.startColor = com.baidu.tieba.tbadkCore.c.fv("#00BBD4");
            this.endColor = com.baidu.tieba.tbadkCore.c.fv("#0086D4");
        } else if (this.mSkinType == 4) {
            this.startColor = com.baidu.tieba.tbadkCore.c.fv("#2BE6FF");
            this.endColor = com.baidu.tieba.tbadkCore.c.fv("#2BB1FF");
        }
    }

    public void setIsCircle(boolean z) {
        this.fzP = z;
    }

    public void setHasShadow(boolean z) {
        this.fzQ = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.mPath == null) {
            this.mPath = new Path();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mWidth > 0 && this.mHeight > 0) {
            if (getDrawable() != null) {
                if (getLayerType() != 2) {
                    setLayerType(2, null);
                }
                int saveCount = canvas.getSaveCount();
                canvas.save();
                canvas.scale(0.7f, 0.7f, this.mWidth / 2, this.mHeight / 2);
                super.onDraw(canvas);
                if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
                    canvas.restoreToCount(saveCount);
                    return;
                }
                return;
            }
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            int saveCount2 = canvas.getSaveCount();
            canvas.save();
            G(canvas);
            canvas.rotate(45.0f, this.mWidth / 2, this.mHeight / 2);
            if (this.mPath != null) {
                this.mPath.reset();
                float f = this.mWidth * 0.15f;
                float f2 = this.mWidth * 0.85f;
                float f3 = (f + f2) / 2.0f;
                float f4 = this.mHeight * 0.15f;
                float f5 = this.mHeight * 0.85f;
                float f6 = (f4 + f5) / 2.0f;
                float f7 = (((f2 - f) / 2.0f) * 51.0f) / 65.0f;
                float f8 = (((f5 - f4) / 2.0f) * 51.0f) / 65.0f;
                this.mPath.moveTo(f3, f4);
                this.mPath.cubicTo(f3 + f7, f4, f2, f6 - f8, f2, f6);
                this.mPath.cubicTo(f2, f6 + f8, f3 + f7, f5, f3, f5);
                this.mPath.cubicTo(f3 - f7, f5, f, f6 + f8, f, f6);
                this.mPath.cubicTo(f, f6 - f8, f3 - f7, f4, f3, f4);
                this.mPath.close();
                if (this.fzO) {
                    this.fzU = new LinearGradient(f, 0.0f, f2, 0.0f, new int[]{this.startColor, this.endColor}, (float[]) null, Shader.TileMode.CLAMP);
                    this.fzO = false;
                }
                if (this.fzQ) {
                    if (this.fzP) {
                        this.mPaint.setShadowLayer(16.0f, 5.0f, 5.0f, com.baidu.tieba.tbadkCore.c.m(this.fzU == null ? this.color : this.endColor, 0.5f));
                    } else {
                        float f9 = 0.054f * this.mWidth;
                        float f10 = this.mWidth * 0.0226f;
                        double radians = Math.toRadians(getRotation() - 45.0f);
                        this.mPaint.setShadowLayer(f9, (float) (f10 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * f10)), com.baidu.tieba.tbadkCore.c.m(this.fzU == null ? this.color : this.endColor, 0.83f));
                    }
                }
                if (this.fzU != null) {
                    this.mPaint.setShader(this.fzU);
                } else {
                    this.mPaint.setColor(this.color);
                }
                float f11 = this.mWidth * 0.032f;
                if (this.fzP) {
                    canvas.drawCircle(f3, f6, (this.mWidth / 2) - 20, this.mPaint);
                } else {
                    canvas.drawPath(this.mPath, this.mPaint);
                }
                this.fzS[0] = ((3.0f * f3) + f) / 4.0f;
                this.fzS[1] = ((3.0f * f6) + f4) / 4.0f;
                this.fzS[2] = ((3.0f * f3) + f2) / 4.0f;
                this.fzS[3] = ((3.0f * f6) + f5) / 4.0f;
                this.fzT[0] = (f2 + (3.0f * f3)) / 4.0f;
                this.fzT[1] = (f4 + (3.0f * f6)) / 4.0f;
                this.fzT[2] = ((3.0f * f3) + f) / 4.0f;
                this.fzT[3] = ((3.0f * f6) + f5) / 4.0f;
                F(canvas);
                H(canvas);
                this.fzR.setStrokeWidth(f11);
                canvas.drawLines(this.fzS, this.fzR);
                canvas.drawLines(this.fzT, this.fzR);
            }
            if (saveCount2 >= 1 && saveCount2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(saveCount2);
            }
        }
    }

    private void F(Canvas canvas) {
        if (this.mIcon != null) {
            if (Build.VERSION.SDK_INT < 19 || this.mIcon.getAlpha() > 0) {
                canvas.save();
                canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
                this.mIcon.setBounds((getWidth() / 2) - (this.mIcon.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.mIcon.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.mIcon.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.mIcon.getIntrinsicHeight() / 2));
                this.mIcon.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void H(Canvas canvas) {
        if (this.fzV != null) {
            if (Build.VERSION.SDK_INT < 19 || this.fzV.getAlpha() > 0) {
                canvas.save();
                canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
                this.fzV.setBounds(((getWidth() / 2) - (this.fzV.getIntrinsicWidth() / 2)) + this.fzW, ((getHeight() / 2) - (this.fzV.getIntrinsicHeight() / 2)) + this.fzW, ((getWidth() / 2) + (this.fzV.getIntrinsicWidth() / 2)) - this.fzW, ((getHeight() / 2) + (this.fzV.getIntrinsicHeight() / 2)) - this.fzW);
                this.fzV.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void setIconFade(int i) {
        if (i > 0) {
            this.mIcon = ap.getDrawable(i);
            if (this.mIcon != null) {
                this.mIcon.setAlpha(255);
            }
            this.fzR.setAlpha(0);
        } else {
            this.mIcon = null;
            this.fzR.setAlpha(255);
        }
        postInvalidate();
    }

    public void bBj() {
        if (this.mIcon != null) {
            this.mIcon.setAlpha(255);
            postInvalidate();
        }
    }

    public void setCrossFade(float f, boolean z) {
        float f2;
        if (this.fzV != null) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if ((!z && f > 0.3d) || (z && f > 0.5d)) {
                if (z) {
                    f2 = (2.0f * f) - 1.0f;
                } else {
                    f2 = ((10.0f * f) / 7.0f) - 0.42857143f;
                }
                int i = (int) (f2 * 255.0f);
                if (z) {
                    i = 255 - i;
                }
                this.fzV.setAlpha(i);
                this.mPaint.setAlpha(255 - i);
                if (this.mIcon != null) {
                    this.mIcon.setAlpha(255 - i);
                    this.fzR.setAlpha(0);
                } else {
                    this.fzR.setAlpha(255 - i);
                }
            }
            invalidate();
        }
    }

    public void setEndIcon(int i, int i2) {
        if (i > 0) {
            this.fzV = SvgManager.brn().a(i, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            this.fzV = null;
        }
        this.fzW = i2;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        super.setRotation(f);
        invalidate();
    }

    private void G(Canvas canvas) {
        this.mPaint.setXfermode(this.fzA);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.fzB);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.startColor = com.baidu.tieba.tbadkCore.c.fv(str);
        this.endColor = com.baidu.tieba.tbadkCore.c.fv(str2);
        this.fzO = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        this.fzO = true;
        invalidate();
    }

    public void a(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            ovalActionButton.setStartAndEndColor(this.startColor, this.endColor);
            ovalActionButton.setColor(this.color);
        }
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            bEp();
            this.color = ap.getColor(this.mSkinType, R.color.cp_link_tip_e);
            this.fzR.setColor(ap.getColor(R.color.cp_cont_a));
            this.fzO = true;
            invalidate();
        }
    }
}

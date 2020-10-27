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
    private PorterDuffXfermode ftK;
    private PorterDuffXfermode ftL;
    private boolean ftY;
    private boolean ftZ;
    private boolean fua;
    private Paint fub;
    private float[] fuc;
    private float[] fud;
    private LinearGradient fue;
    private Drawable fuf;
    private int fug;
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
        this.ftY = true;
        this.fua = true;
        this.fuc = new float[4];
        this.fud = new float[4];
        this.color = ap.getColor(R.color.cp_link_tip_e);
        this.ftK = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.ftL = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        bBQ();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.fub = new Paint();
        this.fub.setColor(ap.getColor(R.color.cp_cont_a));
        this.fub.setStrokeCap(Paint.Cap.ROUND);
        this.fub.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void bBQ() {
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
        this.ftZ = z;
    }

    public void setHasShadow(boolean z) {
        this.fua = z;
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
                if (this.ftY) {
                    this.fue = new LinearGradient(f, 0.0f, f2, 0.0f, new int[]{this.startColor, this.endColor}, (float[]) null, Shader.TileMode.CLAMP);
                    this.ftY = false;
                }
                if (this.fua) {
                    if (this.ftZ) {
                        this.mPaint.setShadowLayer(16.0f, 5.0f, 5.0f, com.baidu.tieba.tbadkCore.c.m(this.fue == null ? this.color : this.endColor, 0.5f));
                    } else {
                        float f9 = 0.054f * this.mWidth;
                        float f10 = this.mWidth * 0.0226f;
                        double radians = Math.toRadians(getRotation() - 45.0f);
                        this.mPaint.setShadowLayer(f9, (float) (f10 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * f10)), com.baidu.tieba.tbadkCore.c.m(this.fue == null ? this.color : this.endColor, 0.83f));
                    }
                }
                if (this.fue != null) {
                    this.mPaint.setShader(this.fue);
                } else {
                    this.mPaint.setColor(this.color);
                }
                float f11 = this.mWidth * 0.032f;
                if (this.ftZ) {
                    canvas.drawCircle(f3, f6, (this.mWidth / 2) - 20, this.mPaint);
                } else {
                    canvas.drawPath(this.mPath, this.mPaint);
                }
                this.fuc[0] = ((3.0f * f3) + f) / 4.0f;
                this.fuc[1] = ((3.0f * f6) + f4) / 4.0f;
                this.fuc[2] = ((3.0f * f3) + f2) / 4.0f;
                this.fuc[3] = ((3.0f * f6) + f5) / 4.0f;
                this.fud[0] = (f2 + (3.0f * f3)) / 4.0f;
                this.fud[1] = (f4 + (3.0f * f6)) / 4.0f;
                this.fud[2] = ((3.0f * f3) + f) / 4.0f;
                this.fud[3] = ((3.0f * f6) + f5) / 4.0f;
                F(canvas);
                H(canvas);
                this.fub.setStrokeWidth(f11);
                canvas.drawLines(this.fuc, this.fub);
                canvas.drawLines(this.fud, this.fub);
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
        if (this.fuf != null) {
            if (Build.VERSION.SDK_INT < 19 || this.fuf.getAlpha() > 0) {
                canvas.save();
                canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
                this.fuf.setBounds(((getWidth() / 2) - (this.fuf.getIntrinsicWidth() / 2)) + this.fug, ((getHeight() / 2) - (this.fuf.getIntrinsicHeight() / 2)) + this.fug, ((getWidth() / 2) + (this.fuf.getIntrinsicWidth() / 2)) - this.fug, ((getHeight() / 2) + (this.fuf.getIntrinsicHeight() / 2)) - this.fug);
                this.fuf.draw(canvas);
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
            this.fub.setAlpha(0);
        } else {
            this.mIcon = null;
            this.fub.setAlpha(255);
        }
        postInvalidate();
    }

    public void byK() {
        if (this.mIcon != null) {
            this.mIcon.setAlpha(255);
            postInvalidate();
        }
    }

    public void setCrossFade(float f, boolean z) {
        float f2;
        if (this.fuf != null) {
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
                this.fuf.setAlpha(i);
                this.mPaint.setAlpha(255 - i);
                if (this.mIcon != null) {
                    this.mIcon.setAlpha(255 - i);
                    this.fub.setAlpha(0);
                } else {
                    this.fub.setAlpha(255 - i);
                }
            }
            invalidate();
        }
    }

    public void setEndIcon(int i, int i2) {
        if (i > 0) {
            this.fuf = SvgManager.boN().a(i, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            this.fuf = null;
        }
        this.fug = i2;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        super.setRotation(f);
        invalidate();
    }

    private void G(Canvas canvas) {
        this.mPaint.setXfermode(this.ftK);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.ftL);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.startColor = com.baidu.tieba.tbadkCore.c.fv(str);
        this.endColor = com.baidu.tieba.tbadkCore.c.fv(str2);
        this.ftY = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        this.ftY = true;
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
            bBQ();
            this.color = ap.getColor(this.mSkinType, R.color.cp_link_tip_e);
            this.fub.setColor(ap.getColor(R.color.cp_cont_a));
            this.ftY = true;
            invalidate();
        }
    }
}

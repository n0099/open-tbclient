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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class OvalActionButton extends ImageView {
    private static final int cDh = al.getColor(R.color.cp_link_tip_e);
    private boolean cDi;
    private Paint cDj;
    private float[] cDk;
    private float[] cDl;
    private boolean cDm;
    private LinearGradient cDn;
    private PorterDuffXfermode cDo;
    private PorterDuffXfermode cDp;
    private int color;
    private int endColor;
    private Drawable mIcon;
    private Paint mPaint;
    private Path mPath;
    private int mSkinType;
    private int startColor;

    public OvalActionButton(Context context) {
        this(context, null);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDi = true;
        this.cDk = new float[4];
        this.cDl = new float[4];
        this.cDm = true;
        this.color = cDh;
        this.cDo = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.cDp = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        avZ();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.cDj = new Paint();
        this.mPaint.setAntiAlias(true);
        this.cDj.setColor(al.getColor(R.color.cp_btn_a));
        this.cDj.setStrokeCap(Paint.Cap.ROUND);
        this.cDj.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void avZ() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType == 0) {
            this.startColor = com.baidu.tieba.lego.card.d.a.parseColor("#2bb8ff");
            this.endColor = com.baidu.tieba.lego.card.d.a.parseColor("#2b80ff");
        } else if (this.mSkinType == 1) {
            this.startColor = com.baidu.tieba.lego.card.d.a.parseColor("#249BD6");
            this.endColor = com.baidu.tieba.lego.card.d.a.parseColor("#246CD6");
        }
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
        if (getDrawable() != null) {
            if (getLayerType() != 2) {
                setLayerType(2, null);
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.scale(0.7f, 0.7f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            super.onDraw(canvas);
            canvas.restoreToCount(saveCount);
            return;
        }
        if (getLayerType() != 1) {
            setLayerType(1, null);
        }
        int saveCount2 = canvas.getSaveCount();
        canvas.save();
        A(canvas);
        canvas.rotate(45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
        if (this.mPath != null) {
            this.mPath.reset();
            float width = canvas.getWidth() * 0.15f;
            float width2 = canvas.getWidth() * 0.85f;
            float f = (width + width2) / 2.0f;
            float height = canvas.getHeight() * 0.15f;
            float height2 = canvas.getHeight() * 0.85f;
            float f2 = (height + height2) / 2.0f;
            float f3 = (((width2 - width) / 2.0f) * 51.0f) / 65.0f;
            float f4 = (((height2 - height) / 2.0f) * 51.0f) / 65.0f;
            this.mPath.moveTo(f, height);
            this.mPath.cubicTo(f + f3, height, width2, f2 - f4, width2, f2);
            this.mPath.cubicTo(width2, f2 + f4, f + f3, height2, f, height2);
            this.mPath.cubicTo(f - f3, height2, width, f2 + f4, width, f2);
            this.mPath.cubicTo(width, f2 - f4, f - f3, height, f, height);
            this.mPath.close();
            if (this.cDi) {
                this.cDn = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.startColor, this.endColor}, (float[]) null, Shader.TileMode.CLAMP);
                this.cDi = false;
            }
            if (this.cDm) {
                float width3 = 0.054f * canvas.getWidth();
                float width4 = canvas.getWidth() * 0.0226f;
                double radians = Math.toRadians(getRotation() - 45.0f);
                this.mPaint.setShadowLayer(width3, (float) (width4 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * width4)), com.baidu.tieba.tbadkCore.c.j(this.cDn == null ? this.color : this.endColor, 0.83f));
            }
            if (this.cDn != null) {
                this.mPaint.setShader(this.cDn);
            } else {
                this.mPaint.setColor(this.color);
            }
            canvas.drawPath(this.mPath, this.mPaint);
            this.cDk[0] = ((3.0f * f) + width) / 4.0f;
            this.cDk[1] = ((3.0f * f2) + height) / 4.0f;
            this.cDk[2] = ((3.0f * f) + width2) / 4.0f;
            this.cDk[3] = ((3.0f * f2) + height2) / 4.0f;
            this.cDl[0] = (width2 + (3.0f * f)) / 4.0f;
            this.cDl[1] = (height + (3.0f * f2)) / 4.0f;
            this.cDl[2] = ((3.0f * f) + width) / 4.0f;
            this.cDl[3] = ((3.0f * f2) + height2) / 4.0f;
            z(canvas);
            this.cDj.setStrokeWidth(canvas.getWidth() * 0.032f);
            canvas.drawLines(this.cDk, this.cDj);
            canvas.drawLines(this.cDl, this.cDj);
        }
        canvas.restoreToCount(saveCount2);
    }

    private void z(Canvas canvas) {
        if (this.mIcon == null) {
            this.cDj.setAlpha(255);
            return;
        }
        if (Build.VERSION.SDK_INT < 19 || this.mIcon.getAlpha() > 0) {
            canvas.save();
            canvas.rotate(-45.0f, canvas.getWidth() / 2, canvas.getHeight() / 2);
            this.mIcon.setBounds((getWidth() / 2) - (this.mIcon.getIntrinsicWidth() / 2), (getHeight() / 2) - (this.mIcon.getIntrinsicHeight() / 2), (getWidth() / 2) + (this.mIcon.getIntrinsicWidth() / 2), (getHeight() / 2) + (this.mIcon.getIntrinsicHeight() / 2));
            this.mIcon.draw(canvas);
            canvas.restore();
        }
    }

    public void setIconFade(int i) {
        if (i > 0) {
            this.mIcon = al.getDrawable(i);
            if (this.mIcon != null) {
                this.mIcon.setAlpha(255);
            }
            this.cDj.setAlpha(0);
        } else {
            this.mIcon = null;
            this.cDj.setAlpha(255);
        }
        postInvalidate();
    }

    public void asM() {
        if (this.mIcon != null) {
            this.mIcon.setAlpha(255);
            postInvalidate();
        }
    }

    public void setCrossFade(float f) {
        if (this.mIcon != null) {
            float f2 = f > 1.0f ? -0.5f : 0.5f - f;
            int i = (int) (255.0f * f2 * 2.0f);
            if (f2 > 0.0f) {
                this.mIcon.setAlpha(i);
                this.cDj.setAlpha(0);
            } else {
                this.cDj.setAlpha(-i);
                this.mIcon.setAlpha(0);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void setRotation(float f) {
        super.setRotation(f);
        invalidate();
    }

    private void A(Canvas canvas) {
        this.mPaint.setXfermode(this.cDo);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.cDp);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.startColor = com.baidu.tieba.lego.card.d.a.parseColor(str);
        this.endColor = com.baidu.tieba.lego.card.d.a.parseColor(str2);
        this.cDi = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        this.cDi = true;
        invalidate();
    }

    public void a(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            ovalActionButton.setStartAndEndColor(this.startColor, this.endColor);
            ovalActionButton.setColor(this.color);
        }
    }

    public void setNeedShadow(boolean z) {
        this.cDm = z;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setStringColor(String str) {
        this.color = com.baidu.tieba.lego.card.d.a.parseColor(str);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            avZ();
            this.color = al.getColor(this.mSkinType, R.color.cp_link_tip_e);
            this.cDi = true;
            this.cDj.setColor(al.getColor(R.color.cp_btn_a));
            invalidate();
        }
    }
}

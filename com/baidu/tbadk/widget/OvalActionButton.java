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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class OvalActionButton extends ImageView {
    private static final int cFW = am.getColor(R.color.cp_link_tip_e);
    private float[] cFA;
    private boolean cFB;
    private LinearGradient cFC;
    private int cFD;
    private int cFE;
    private PorterDuffXfermode cFG;
    private PorterDuffXfermode cFH;
    private boolean cFx;
    private Paint cFy;
    private float[] cFz;
    private int color;
    private Drawable mIcon;
    private Paint mPaint;
    private Path mPath;
    private int mSkinType;

    public OvalActionButton(Context context) {
        this(context, null);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OvalActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFx = true;
        this.cFz = new float[4];
        this.cFA = new float[4];
        this.cFB = true;
        this.color = cFW;
        this.cFG = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.cFH = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mSkinType = 3;
        init();
    }

    private void init() {
        axy();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.cFy = new Paint();
        this.mPaint.setAntiAlias(true);
        this.cFy.setColor(am.getColor(R.color.cp_cont_a));
        this.cFy.setStrokeCap(Paint.Cap.ROUND);
        this.cFy.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void axy() {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType == 0) {
            this.cFD = com.baidu.tieba.lego.card.d.a.cE("#2bb8ff");
            this.cFE = com.baidu.tieba.lego.card.d.a.cE("#2b80ff");
        } else if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.cFD = com.baidu.tieba.lego.card.d.a.cE("#249BD6");
            this.cFE = com.baidu.tieba.lego.card.d.a.cE("#246CD6");
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
            if (this.cFx) {
                this.cFC = new LinearGradient(width, 0.0f, width2, 0.0f, new int[]{this.cFD, this.cFE}, (float[]) null, Shader.TileMode.CLAMP);
                this.cFx = false;
            }
            if (this.cFB) {
                float width3 = 0.054f * canvas.getWidth();
                float width4 = canvas.getWidth() * 0.0226f;
                double radians = Math.toRadians(getRotation() - 45.0f);
                this.mPaint.setShadowLayer(width3, (float) (width4 * Math.cos(radians)), (-1.0f) * ((float) (Math.sin(radians) * width4)), com.baidu.tieba.tbadkCore.c.j(this.cFC == null ? this.color : this.cFE, 0.83f));
            }
            if (this.cFC != null) {
                this.mPaint.setShader(this.cFC);
            } else {
                this.mPaint.setColor(this.color);
            }
            canvas.drawPath(this.mPath, this.mPaint);
            this.cFz[0] = ((3.0f * f) + width) / 4.0f;
            this.cFz[1] = ((3.0f * f2) + height) / 4.0f;
            this.cFz[2] = ((3.0f * f) + width2) / 4.0f;
            this.cFz[3] = ((3.0f * f2) + height2) / 4.0f;
            this.cFA[0] = (width2 + (3.0f * f)) / 4.0f;
            this.cFA[1] = (height + (3.0f * f2)) / 4.0f;
            this.cFA[2] = ((3.0f * f) + width) / 4.0f;
            this.cFA[3] = ((3.0f * f2) + height2) / 4.0f;
            z(canvas);
            this.cFy.setStrokeWidth(canvas.getWidth() * 0.032f);
            canvas.drawLines(this.cFz, this.cFy);
            canvas.drawLines(this.cFA, this.cFy);
        }
        canvas.restoreToCount(saveCount2);
    }

    private void z(Canvas canvas) {
        if (this.mIcon == null) {
            this.cFy.setAlpha(255);
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
            this.mIcon = am.getDrawable(i);
            if (this.mIcon != null) {
                this.mIcon.setAlpha(255);
            }
            this.cFy.setAlpha(0);
        } else {
            this.mIcon = null;
            this.cFy.setAlpha(255);
        }
        postInvalidate();
    }

    public void aui() {
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
                this.cFy.setAlpha(0);
            } else {
                this.cFy.setAlpha(-i);
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
        this.mPaint.setXfermode(this.cFG);
        canvas.drawPaint(this.mPaint);
        this.mPaint.setXfermode(this.cFH);
    }

    public void setStartAndEndColor(String str, String str2) {
        this.cFD = com.baidu.tieba.lego.card.d.a.cE(str);
        this.cFE = com.baidu.tieba.lego.card.d.a.cE(str2);
        this.cFx = true;
        invalidate();
    }

    public void setStartAndEndColor(int i, int i2) {
        this.cFD = i;
        this.cFE = i2;
        this.cFx = true;
        invalidate();
    }

    public void a(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            ovalActionButton.setStartAndEndColor(this.cFD, this.cFE);
            ovalActionButton.setColor(this.color);
        }
    }

    public void setNeedShadow(boolean z) {
        this.cFB = z;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setStringColor(String str) {
        this.color = com.baidu.tieba.lego.card.d.a.cE(str);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            axy();
            this.color = am.getColor(this.mSkinType, R.color.cp_link_tip_e);
            this.cFx = true;
            this.cFy.setColor(am.getColor(R.color.cp_cont_a));
            invalidate();
        }
    }
}

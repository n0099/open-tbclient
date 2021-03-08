package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes.dex */
public class LinearGradientView extends View {
    private LinearGradient bMw;
    private int bPt;
    private int bUG;
    private int fPC;
    private int fPD;
    private int fPE;
    private int fPF;
    private final Paint fPG;
    private int fPH;
    private int fPI;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fPG = new Paint();
        this.mRadius = 0;
        this.fPI = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fPG = new Paint();
        this.mRadius = 0;
        this.fPI = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fPG = new Paint();
        this.mRadius = 0;
        this.fPI = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bGh();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bMw = bGi();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bGg();
        if (this.fPI == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.fPG);
        } else {
            canvas.drawPath(this.mPath, this.fPG);
        }
    }

    private void bGg() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.fPH != this.mRadius) && this.fPI != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.fPH = this.mRadius;
            this.mPath.reset();
            switch (this.fPI) {
                case 1:
                    this.mPath.addRoundRect(new RectF(0.0f, 0.0f, this.mWidth, this.mHeight), this.mRadius, this.mRadius, Path.Direction.CW);
                    return;
                case 2:
                    this.mPath.addRoundRect(new RectF(0.0f, 0.0f, this.mWidth, this.mHeight), new float[]{this.mRadius, this.mRadius, 0.0f, 0.0f, 0.0f, 0.0f, this.mRadius, this.mRadius}, Path.Direction.CW);
                    return;
                case 3:
                    this.mPath.addRoundRect(new RectF(0.0f, 0.0f, this.mWidth, this.mHeight), new float[]{this.mRadius, this.mRadius, this.mRadius, this.mRadius, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                case 4:
                    this.mPath.addRoundRect(new RectF(0.0f, 0.0f, this.mWidth, this.mHeight), new float[]{0.0f, 0.0f, this.mRadius, this.mRadius, this.mRadius, this.mRadius, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                case 5:
                    this.mPath.addRoundRect(new RectF(0.0f, 0.0f, this.mWidth, this.mHeight), new float[]{0.0f, 0.0f, 0.0f, 0.0f, this.mRadius, this.mRadius, this.mRadius, this.mRadius}, Path.Direction.CW);
                    return;
                default:
                    return;
            }
        }
    }

    public void setRoundMode(int i) {
        this.fPI = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bPt = i;
        this.bUG = i2;
        this.fPC = i3;
        this.fPD = i4;
        this.fPE = i5;
        this.fPF = i6;
        this.bMw = bGi();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bPt != com.baidu.tieba.lego.card.c.b.rT(str) || this.bUG != com.baidu.tieba.lego.card.c.b.rT(str2) || this.fPC != com.baidu.tieba.lego.card.c.b.rT(str3) || this.fPD != com.baidu.tieba.lego.card.c.b.rT(str4) || this.fPE != com.baidu.tieba.lego.card.c.b.rT(str5) || this.fPF != com.baidu.tieba.lego.card.c.b.rT(str6)) {
            this.bPt = com.baidu.tieba.lego.card.c.b.rT(str);
            this.bUG = com.baidu.tieba.lego.card.c.b.rT(str2);
            this.fPC = com.baidu.tieba.lego.card.c.b.rT(str3);
            this.fPD = com.baidu.tieba.lego.card.c.b.rT(str4);
            this.fPE = com.baidu.tieba.lego.card.c.b.rT(str5);
            this.fPF = com.baidu.tieba.lego.card.c.b.rT(str6);
            this.bMw = bGi();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int rT;
        int i;
        int rT2;
        int i2;
        int rT3;
        int rT4;
        if (themeElement == null) {
            int rT5 = com.baidu.tieba.lego.card.c.b.rT("#2BB8FF");
            rT = com.baidu.tieba.lego.card.c.b.rT("#2BB8FF");
            i = rT5;
        } else {
            int rT6 = com.baidu.tieba.lego.card.c.b.rT(themeElement.common_color);
            rT = com.baidu.tieba.lego.card.c.b.rT(themeElement.common_color);
            i = rT6;
        }
        if (themeElement2 == null) {
            int rT7 = com.baidu.tieba.lego.card.c.b.rT("#249BD6");
            rT2 = com.baidu.tieba.lego.card.c.b.rT("#246CD6");
            i2 = rT7;
        } else {
            int rT8 = com.baidu.tieba.lego.card.c.b.rT(themeElement2.common_color);
            rT2 = com.baidu.tieba.lego.card.c.b.rT(themeElement2.common_color);
            i2 = rT8;
        }
        if (themeElement3 == null) {
            rT3 = com.baidu.tieba.lego.card.c.b.rT("#249BD6");
            rT4 = com.baidu.tieba.lego.card.c.b.rT("#246CD6");
        } else {
            rT3 = com.baidu.tieba.lego.card.c.b.rT(themeElement3.common_color);
            rT4 = com.baidu.tieba.lego.card.c.b.rT(themeElement3.common_color);
        }
        this.bPt = i;
        this.bUG = rT;
        this.fPC = i2;
        this.fPD = rT2;
        this.fPE = rT3;
        this.fPF = rT4;
        this.bMw = bGi();
        invalidate();
    }

    private void bGh() {
        this.bPt = com.baidu.tieba.lego.card.c.b.rT("#2BB8FF");
        this.bUG = com.baidu.tieba.lego.card.c.b.rT("#2BB8FF");
        this.fPC = com.baidu.tieba.lego.card.c.b.rT("#249BD6");
        this.fPD = com.baidu.tieba.lego.card.c.b.rT("#246CD6");
        this.fPE = com.baidu.tieba.lego.card.c.b.rT("#249BD6");
        this.fPF = com.baidu.tieba.lego.card.c.b.rT("#246CD6");
        this.bMw = bGi();
    }

    public void setDefaultGradientColor() {
        bGh();
        invalidate();
    }

    private LinearGradient bGi() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bPt;
        int i4 = this.bUG;
        if (skinType == 4) {
            int i5 = this.fPE;
            i = this.fPF;
            i2 = i5;
        } else if (skinType == 1) {
            int i6 = this.fPC;
            i = this.fPD;
            i2 = i6;
        } else {
            i = i4;
            i2 = i3;
        }
        this.bMw = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i2, i}, (float[]) null, Shader.TileMode.CLAMP);
        this.fPG.setShader(this.bMw);
        this.mSkinType = skinType;
        return this.bMw;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bMw = bGi();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bPt));
        arrayList.add(Integer.valueOf(this.bUG));
        arrayList.add(Integer.valueOf(this.fPC));
        arrayList.add(Integer.valueOf(this.fPD));
        arrayList.add(Integer.valueOf(this.fPE));
        arrayList.add(Integer.valueOf(this.fPF));
        return arrayList;
    }
}

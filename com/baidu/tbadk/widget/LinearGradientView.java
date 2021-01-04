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
    private LinearGradient bLY;
    private int bOV;
    private int bUc;
    private int fQA;
    private int fQB;
    private int fQv;
    private int fQw;
    private int fQx;
    private int fQy;
    private final Paint fQz;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fQz = new Paint();
        this.mRadius = 0;
        this.fQB = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fQz = new Paint();
        this.mRadius = 0;
        this.fQB = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fQz = new Paint();
        this.mRadius = 0;
        this.fQB = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bJA();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bLY = bJB();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bJz();
        if (this.fQB == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.fQz);
        } else {
            canvas.drawPath(this.mPath, this.fQz);
        }
    }

    private void bJz() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.fQA != this.mRadius) && this.fQB != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.fQA = this.mRadius;
            this.mPath.reset();
            switch (this.fQB) {
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
        this.fQB = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bOV = i;
        this.bUc = i2;
        this.fQv = i3;
        this.fQw = i4;
        this.fQx = i5;
        this.fQy = i6;
        this.bLY = bJB();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bOV != com.baidu.tieba.lego.card.c.b.sF(str) || this.bUc != com.baidu.tieba.lego.card.c.b.sF(str2) || this.fQv != com.baidu.tieba.lego.card.c.b.sF(str3) || this.fQw != com.baidu.tieba.lego.card.c.b.sF(str4) || this.fQx != com.baidu.tieba.lego.card.c.b.sF(str5) || this.fQy != com.baidu.tieba.lego.card.c.b.sF(str6)) {
            this.bOV = com.baidu.tieba.lego.card.c.b.sF(str);
            this.bUc = com.baidu.tieba.lego.card.c.b.sF(str2);
            this.fQv = com.baidu.tieba.lego.card.c.b.sF(str3);
            this.fQw = com.baidu.tieba.lego.card.c.b.sF(str4);
            this.fQx = com.baidu.tieba.lego.card.c.b.sF(str5);
            this.fQy = com.baidu.tieba.lego.card.c.b.sF(str6);
            this.bLY = bJB();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int sF;
        int i;
        int sF2;
        int i2;
        int sF3;
        int sF4;
        if (themeElement == null) {
            int sF5 = com.baidu.tieba.lego.card.c.b.sF("#2BB8FF");
            sF = com.baidu.tieba.lego.card.c.b.sF("#2BB8FF");
            i = sF5;
        } else {
            int sF6 = com.baidu.tieba.lego.card.c.b.sF(themeElement.common_color);
            sF = com.baidu.tieba.lego.card.c.b.sF(themeElement.common_color);
            i = sF6;
        }
        if (themeElement2 == null) {
            int sF7 = com.baidu.tieba.lego.card.c.b.sF("#249BD6");
            sF2 = com.baidu.tieba.lego.card.c.b.sF("#246CD6");
            i2 = sF7;
        } else {
            int sF8 = com.baidu.tieba.lego.card.c.b.sF(themeElement2.common_color);
            sF2 = com.baidu.tieba.lego.card.c.b.sF(themeElement2.common_color);
            i2 = sF8;
        }
        if (themeElement3 == null) {
            sF3 = com.baidu.tieba.lego.card.c.b.sF("#249BD6");
            sF4 = com.baidu.tieba.lego.card.c.b.sF("#246CD6");
        } else {
            sF3 = com.baidu.tieba.lego.card.c.b.sF(themeElement3.common_color);
            sF4 = com.baidu.tieba.lego.card.c.b.sF(themeElement3.common_color);
        }
        this.bOV = i;
        this.bUc = sF;
        this.fQv = i2;
        this.fQw = sF2;
        this.fQx = sF3;
        this.fQy = sF4;
        this.bLY = bJB();
        invalidate();
    }

    private void bJA() {
        this.bOV = com.baidu.tieba.lego.card.c.b.sF("#2BB8FF");
        this.bUc = com.baidu.tieba.lego.card.c.b.sF("#2BB8FF");
        this.fQv = com.baidu.tieba.lego.card.c.b.sF("#249BD6");
        this.fQw = com.baidu.tieba.lego.card.c.b.sF("#246CD6");
        this.fQx = com.baidu.tieba.lego.card.c.b.sF("#249BD6");
        this.fQy = com.baidu.tieba.lego.card.c.b.sF("#246CD6");
        this.bLY = bJB();
    }

    public void setDefaultGradientColor() {
        bJA();
        invalidate();
    }

    private LinearGradient bJB() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bOV;
        int i4 = this.bUc;
        if (skinType == 4) {
            int i5 = this.fQx;
            i = this.fQy;
            i2 = i5;
        } else if (skinType == 1) {
            int i6 = this.fQv;
            i = this.fQw;
            i2 = i6;
        } else {
            i = i4;
            i2 = i3;
        }
        this.bLY = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i2, i}, (float[]) null, Shader.TileMode.CLAMP);
        this.fQz.setShader(this.bLY);
        this.mSkinType = skinType;
        return this.bLY;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bLY = bJB();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bOV));
        arrayList.add(Integer.valueOf(this.bUc));
        arrayList.add(Integer.valueOf(this.fQv));
        arrayList.add(Integer.valueOf(this.fQw));
        arrayList.add(Integer.valueOf(this.fQx));
        arrayList.add(Integer.valueOf(this.fQy));
        return arrayList;
    }
}

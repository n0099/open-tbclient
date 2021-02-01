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
    private LinearGradient bKW;
    private int bNT;
    private int bTg;
    private int fOc;
    private int fOd;
    private int fOe;
    private int fOf;
    private final Paint fOg;
    private int fOh;
    private int fOi;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fOg = new Paint();
        this.mRadius = 0;
        this.fOi = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fOg = new Paint();
        this.mRadius = 0;
        this.fOi = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fOg = new Paint();
        this.mRadius = 0;
        this.fOi = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bGd();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bKW = bGe();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bGc();
        if (this.fOi == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.fOg);
        } else {
            canvas.drawPath(this.mPath, this.fOg);
        }
    }

    private void bGc() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.fOh != this.mRadius) && this.fOi != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.fOh = this.mRadius;
            this.mPath.reset();
            switch (this.fOi) {
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
        this.fOi = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bNT = i;
        this.bTg = i2;
        this.fOc = i3;
        this.fOd = i4;
        this.fOe = i5;
        this.fOf = i6;
        this.bKW = bGe();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bNT != com.baidu.tieba.lego.card.c.b.rM(str) || this.bTg != com.baidu.tieba.lego.card.c.b.rM(str2) || this.fOc != com.baidu.tieba.lego.card.c.b.rM(str3) || this.fOd != com.baidu.tieba.lego.card.c.b.rM(str4) || this.fOe != com.baidu.tieba.lego.card.c.b.rM(str5) || this.fOf != com.baidu.tieba.lego.card.c.b.rM(str6)) {
            this.bNT = com.baidu.tieba.lego.card.c.b.rM(str);
            this.bTg = com.baidu.tieba.lego.card.c.b.rM(str2);
            this.fOc = com.baidu.tieba.lego.card.c.b.rM(str3);
            this.fOd = com.baidu.tieba.lego.card.c.b.rM(str4);
            this.fOe = com.baidu.tieba.lego.card.c.b.rM(str5);
            this.fOf = com.baidu.tieba.lego.card.c.b.rM(str6);
            this.bKW = bGe();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int rM;
        int i;
        int rM2;
        int i2;
        int rM3;
        int rM4;
        if (themeElement == null) {
            int rM5 = com.baidu.tieba.lego.card.c.b.rM("#2BB8FF");
            rM = com.baidu.tieba.lego.card.c.b.rM("#2BB8FF");
            i = rM5;
        } else {
            int rM6 = com.baidu.tieba.lego.card.c.b.rM(themeElement.common_color);
            rM = com.baidu.tieba.lego.card.c.b.rM(themeElement.common_color);
            i = rM6;
        }
        if (themeElement2 == null) {
            int rM7 = com.baidu.tieba.lego.card.c.b.rM("#249BD6");
            rM2 = com.baidu.tieba.lego.card.c.b.rM("#246CD6");
            i2 = rM7;
        } else {
            int rM8 = com.baidu.tieba.lego.card.c.b.rM(themeElement2.common_color);
            rM2 = com.baidu.tieba.lego.card.c.b.rM(themeElement2.common_color);
            i2 = rM8;
        }
        if (themeElement3 == null) {
            rM3 = com.baidu.tieba.lego.card.c.b.rM("#249BD6");
            rM4 = com.baidu.tieba.lego.card.c.b.rM("#246CD6");
        } else {
            rM3 = com.baidu.tieba.lego.card.c.b.rM(themeElement3.common_color);
            rM4 = com.baidu.tieba.lego.card.c.b.rM(themeElement3.common_color);
        }
        this.bNT = i;
        this.bTg = rM;
        this.fOc = i2;
        this.fOd = rM2;
        this.fOe = rM3;
        this.fOf = rM4;
        this.bKW = bGe();
        invalidate();
    }

    private void bGd() {
        this.bNT = com.baidu.tieba.lego.card.c.b.rM("#2BB8FF");
        this.bTg = com.baidu.tieba.lego.card.c.b.rM("#2BB8FF");
        this.fOc = com.baidu.tieba.lego.card.c.b.rM("#249BD6");
        this.fOd = com.baidu.tieba.lego.card.c.b.rM("#246CD6");
        this.fOe = com.baidu.tieba.lego.card.c.b.rM("#249BD6");
        this.fOf = com.baidu.tieba.lego.card.c.b.rM("#246CD6");
        this.bKW = bGe();
    }

    public void setDefaultGradientColor() {
        bGd();
        invalidate();
    }

    private LinearGradient bGe() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bNT;
        int i4 = this.bTg;
        if (skinType == 4) {
            int i5 = this.fOe;
            i = this.fOf;
            i2 = i5;
        } else if (skinType == 1) {
            int i6 = this.fOc;
            i = this.fOd;
            i2 = i6;
        } else {
            i = i4;
            i2 = i3;
        }
        this.bKW = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i2, i}, (float[]) null, Shader.TileMode.CLAMP);
        this.fOg.setShader(this.bKW);
        this.mSkinType = skinType;
        return this.bKW;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bKW = bGe();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bNT));
        arrayList.add(Integer.valueOf(this.bTg));
        arrayList.add(Integer.valueOf(this.fOc));
        arrayList.add(Integer.valueOf(this.fOd));
        arrayList.add(Integer.valueOf(this.fOe));
        arrayList.add(Integer.valueOf(this.fOf));
        return arrayList;
    }
}

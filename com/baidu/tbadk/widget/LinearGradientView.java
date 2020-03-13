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
/* loaded from: classes8.dex */
public class LinearGradientView extends View {
    private LinearGradient aBP;
    private int aDP;
    private int aEz;
    private int dHG;
    private int dHH;
    private int dHI;
    private int dHJ;
    private final Paint dHK;
    private int dHL;
    private int dHM;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dHK = new Paint();
        this.mRadius = 0;
        this.dHM = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHK = new Paint();
        this.mRadius = 0;
        this.dHM = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dHK = new Paint();
        this.mRadius = 0;
        this.dHM = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aSJ();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.aBP = aSK();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        aSI();
        if (this.dHM == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.dHK);
        } else {
            canvas.drawPath(this.mPath, this.dHK);
        }
    }

    private void aSI() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.dHL != this.mRadius) && this.dHM != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.dHL = this.mRadius;
            this.mPath.reset();
            switch (this.dHM) {
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
        this.dHM = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.aDP = i;
        this.aEz = i2;
        this.dHG = i3;
        this.dHH = i4;
        this.dHI = i5;
        this.dHJ = i6;
        this.aBP = aSK();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.aDP != com.baidu.tieba.lego.card.d.a.cG(str) || this.aEz != com.baidu.tieba.lego.card.d.a.cG(str2) || this.dHG != com.baidu.tieba.lego.card.d.a.cG(str3) || this.dHH != com.baidu.tieba.lego.card.d.a.cG(str4) || this.dHI != com.baidu.tieba.lego.card.d.a.cG(str5) || this.dHJ != com.baidu.tieba.lego.card.d.a.cG(str6)) {
            this.aDP = com.baidu.tieba.lego.card.d.a.cG(str);
            this.aEz = com.baidu.tieba.lego.card.d.a.cG(str2);
            this.dHG = com.baidu.tieba.lego.card.d.a.cG(str3);
            this.dHH = com.baidu.tieba.lego.card.d.a.cG(str4);
            this.dHI = com.baidu.tieba.lego.card.d.a.cG(str5);
            this.dHJ = com.baidu.tieba.lego.card.d.a.cG(str6);
            this.aBP = aSK();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int cG;
        int i;
        int cG2;
        int i2;
        int cG3;
        int cG4;
        if (themeElement == null) {
            int cG5 = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
            cG = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
            i = cG5;
        } else {
            int cG6 = com.baidu.tieba.lego.card.d.a.cG(themeElement.common_color);
            cG = com.baidu.tieba.lego.card.d.a.cG(themeElement.common_color);
            i = cG6;
        }
        if (themeElement2 == null) {
            int cG7 = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
            cG2 = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
            i2 = cG7;
        } else {
            int cG8 = com.baidu.tieba.lego.card.d.a.cG(themeElement2.common_color);
            cG2 = com.baidu.tieba.lego.card.d.a.cG(themeElement2.common_color);
            i2 = cG8;
        }
        if (themeElement3 == null) {
            cG3 = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
            cG4 = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
        } else {
            cG3 = com.baidu.tieba.lego.card.d.a.cG(themeElement3.common_color);
            cG4 = com.baidu.tieba.lego.card.d.a.cG(themeElement3.common_color);
        }
        if (this.aDP != i || this.aEz != cG || this.dHG != i2 || this.dHH != cG2 || this.dHI != cG3 || this.dHJ != cG4) {
            this.aDP = i;
            this.aEz = cG;
            this.dHG = i2;
            this.dHH = cG2;
            this.dHI = cG3;
            this.dHJ = cG4;
            this.aBP = aSK();
            invalidate();
        }
    }

    private void aSJ() {
        this.aDP = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
        this.aEz = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
        this.dHG = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
        this.dHH = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
        this.dHI = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
        this.dHJ = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
        this.aBP = aSK();
    }

    public void setDefaultGradientColor() {
        aSJ();
        invalidate();
    }

    private LinearGradient aSK() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.aDP;
        int i4 = this.aEz;
        if (skinType == 4) {
            i = this.dHI;
            i2 = this.dHJ;
        } else if (skinType == 1) {
            i = this.dHG;
            i2 = this.dHH;
        } else {
            i = i3;
            i2 = i4;
        }
        this.aBP = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.dHK.setShader(this.aBP);
        this.mSkinType = skinType;
        return this.aBP;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aBP = aSK();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.aDP));
        arrayList.add(Integer.valueOf(this.aEz));
        arrayList.add(Integer.valueOf(this.dHG));
        arrayList.add(Integer.valueOf(this.dHH));
        arrayList.add(Integer.valueOf(this.dHI));
        arrayList.add(Integer.valueOf(this.dHJ));
        return arrayList;
    }
}

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
    private LinearGradient aBN;
    private int aDN;
    private int aEx;
    private int dHs;
    private int dHt;
    private int dHu;
    private int dHv;
    private final Paint dHw;
    private int dHx;
    private int dHy;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dHw = new Paint();
        this.mRadius = 0;
        this.dHy = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHw = new Paint();
        this.mRadius = 0;
        this.dHy = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dHw = new Paint();
        this.mRadius = 0;
        this.dHy = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aSG();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.aBN = aSH();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        aSF();
        if (this.dHy == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.dHw);
        } else {
            canvas.drawPath(this.mPath, this.dHw);
        }
    }

    private void aSF() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.dHx != this.mRadius) && this.dHy != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.dHx = this.mRadius;
            this.mPath.reset();
            switch (this.dHy) {
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
        this.dHy = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.aDN = i;
        this.aEx = i2;
        this.dHs = i3;
        this.dHt = i4;
        this.dHu = i5;
        this.dHv = i6;
        this.aBN = aSH();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.aDN != com.baidu.tieba.lego.card.d.a.cG(str) || this.aEx != com.baidu.tieba.lego.card.d.a.cG(str2) || this.dHs != com.baidu.tieba.lego.card.d.a.cG(str3) || this.dHt != com.baidu.tieba.lego.card.d.a.cG(str4) || this.dHu != com.baidu.tieba.lego.card.d.a.cG(str5) || this.dHv != com.baidu.tieba.lego.card.d.a.cG(str6)) {
            this.aDN = com.baidu.tieba.lego.card.d.a.cG(str);
            this.aEx = com.baidu.tieba.lego.card.d.a.cG(str2);
            this.dHs = com.baidu.tieba.lego.card.d.a.cG(str3);
            this.dHt = com.baidu.tieba.lego.card.d.a.cG(str4);
            this.dHu = com.baidu.tieba.lego.card.d.a.cG(str5);
            this.dHv = com.baidu.tieba.lego.card.d.a.cG(str6);
            this.aBN = aSH();
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
        if (this.aDN != i || this.aEx != cG || this.dHs != i2 || this.dHt != cG2 || this.dHu != cG3 || this.dHv != cG4) {
            this.aDN = i;
            this.aEx = cG;
            this.dHs = i2;
            this.dHt = cG2;
            this.dHu = cG3;
            this.dHv = cG4;
            this.aBN = aSH();
            invalidate();
        }
    }

    private void aSG() {
        this.aDN = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
        this.aEx = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
        this.dHs = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
        this.dHt = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
        this.dHu = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
        this.dHv = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
        this.aBN = aSH();
    }

    public void setDefaultGradientColor() {
        aSG();
        invalidate();
    }

    private LinearGradient aSH() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.aDN;
        int i4 = this.aEx;
        if (skinType == 4) {
            i = this.dHu;
            i2 = this.dHv;
        } else if (skinType == 1) {
            i = this.dHs;
            i2 = this.dHt;
        } else {
            i = i3;
            i2 = i4;
        }
        this.aBN = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.dHw.setShader(this.aBN);
        this.mSkinType = skinType;
        return this.aBN;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aBN = aSH();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.aDN));
        arrayList.add(Integer.valueOf(this.aEx));
        arrayList.add(Integer.valueOf(this.dHs));
        arrayList.add(Integer.valueOf(this.dHt));
        arrayList.add(Integer.valueOf(this.dHu));
        arrayList.add(Integer.valueOf(this.dHv));
        return arrayList;
    }
}

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
    private LinearGradient aBO;
    private int aDO;
    private int aEy;
    private int dHt;
    private int dHu;
    private int dHv;
    private int dHw;
    private final Paint dHx;
    private int dHy;
    private int dHz;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dHx = new Paint();
        this.mRadius = 0;
        this.dHz = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHx = new Paint();
        this.mRadius = 0;
        this.dHz = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dHx = new Paint();
        this.mRadius = 0;
        this.dHz = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aSI();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.aBO = aSJ();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        aSH();
        if (this.dHz == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.dHx);
        } else {
            canvas.drawPath(this.mPath, this.dHx);
        }
    }

    private void aSH() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.dHy != this.mRadius) && this.dHz != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.dHy = this.mRadius;
            this.mPath.reset();
            switch (this.dHz) {
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
        this.dHz = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.aDO = i;
        this.aEy = i2;
        this.dHt = i3;
        this.dHu = i4;
        this.dHv = i5;
        this.dHw = i6;
        this.aBO = aSJ();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.aDO != com.baidu.tieba.lego.card.d.a.cG(str) || this.aEy != com.baidu.tieba.lego.card.d.a.cG(str2) || this.dHt != com.baidu.tieba.lego.card.d.a.cG(str3) || this.dHu != com.baidu.tieba.lego.card.d.a.cG(str4) || this.dHv != com.baidu.tieba.lego.card.d.a.cG(str5) || this.dHw != com.baidu.tieba.lego.card.d.a.cG(str6)) {
            this.aDO = com.baidu.tieba.lego.card.d.a.cG(str);
            this.aEy = com.baidu.tieba.lego.card.d.a.cG(str2);
            this.dHt = com.baidu.tieba.lego.card.d.a.cG(str3);
            this.dHu = com.baidu.tieba.lego.card.d.a.cG(str4);
            this.dHv = com.baidu.tieba.lego.card.d.a.cG(str5);
            this.dHw = com.baidu.tieba.lego.card.d.a.cG(str6);
            this.aBO = aSJ();
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
        if (this.aDO != i || this.aEy != cG || this.dHt != i2 || this.dHu != cG2 || this.dHv != cG3 || this.dHw != cG4) {
            this.aDO = i;
            this.aEy = cG;
            this.dHt = i2;
            this.dHu = cG2;
            this.dHv = cG3;
            this.dHw = cG4;
            this.aBO = aSJ();
            invalidate();
        }
    }

    private void aSI() {
        this.aDO = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
        this.aEy = com.baidu.tieba.lego.card.d.a.cG("#2BB8FF");
        this.dHt = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
        this.dHu = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
        this.dHv = com.baidu.tieba.lego.card.d.a.cG("#249BD6");
        this.dHw = com.baidu.tieba.lego.card.d.a.cG("#246CD6");
        this.aBO = aSJ();
    }

    public void setDefaultGradientColor() {
        aSI();
        invalidate();
    }

    private LinearGradient aSJ() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.aDO;
        int i4 = this.aEy;
        if (skinType == 4) {
            i = this.dHv;
            i2 = this.dHw;
        } else if (skinType == 1) {
            i = this.dHt;
            i2 = this.dHu;
        } else {
            i = i3;
            i2 = i4;
        }
        this.aBO = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.dHx.setShader(this.aBO);
        this.mSkinType = skinType;
        return this.aBO;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aBO = aSJ();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.aDO));
        arrayList.add(Integer.valueOf(this.aEy));
        arrayList.add(Integer.valueOf(this.dHt));
        arrayList.add(Integer.valueOf(this.dHu));
        arrayList.add(Integer.valueOf(this.dHv));
        arrayList.add(Integer.valueOf(this.dHw));
        return arrayList;
    }
}

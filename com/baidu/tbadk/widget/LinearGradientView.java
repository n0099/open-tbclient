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
    private LinearGradient aVK;
    private int aXP;
    private int bau;
    private int ehD;
    private int ehE;
    private int ehF;
    private int ehG;
    private final Paint ehH;
    private int ehI;
    private int ehJ;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ehH = new Paint();
        this.mRadius = 0;
        this.ehJ = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ehH = new Paint();
        this.mRadius = 0;
        this.ehJ = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ehH = new Paint();
        this.mRadius = 0;
        this.ehJ = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        baW();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.aVK = baX();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        baV();
        if (this.ehJ == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.ehH);
        } else {
            canvas.drawPath(this.mPath, this.ehH);
        }
    }

    private void baV() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.ehI != this.mRadius) && this.ehJ != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.ehI = this.mRadius;
            this.mPath.reset();
            switch (this.ehJ) {
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
        this.ehJ = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.aXP = i;
        this.bau = i2;
        this.ehD = i3;
        this.ehE = i4;
        this.ehF = i5;
        this.ehG = i6;
        this.aVK = baX();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.aXP != com.baidu.tieba.lego.card.d.a.dA(str) || this.bau != com.baidu.tieba.lego.card.d.a.dA(str2) || this.ehD != com.baidu.tieba.lego.card.d.a.dA(str3) || this.ehE != com.baidu.tieba.lego.card.d.a.dA(str4) || this.ehF != com.baidu.tieba.lego.card.d.a.dA(str5) || this.ehG != com.baidu.tieba.lego.card.d.a.dA(str6)) {
            this.aXP = com.baidu.tieba.lego.card.d.a.dA(str);
            this.bau = com.baidu.tieba.lego.card.d.a.dA(str2);
            this.ehD = com.baidu.tieba.lego.card.d.a.dA(str3);
            this.ehE = com.baidu.tieba.lego.card.d.a.dA(str4);
            this.ehF = com.baidu.tieba.lego.card.d.a.dA(str5);
            this.ehG = com.baidu.tieba.lego.card.d.a.dA(str6);
            this.aVK = baX();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int dA;
        int i;
        int dA2;
        int i2;
        int dA3;
        int dA4;
        if (themeElement == null) {
            int dA5 = com.baidu.tieba.lego.card.d.a.dA("#2BB8FF");
            dA = com.baidu.tieba.lego.card.d.a.dA("#2BB8FF");
            i = dA5;
        } else {
            int dA6 = com.baidu.tieba.lego.card.d.a.dA(themeElement.common_color);
            dA = com.baidu.tieba.lego.card.d.a.dA(themeElement.common_color);
            i = dA6;
        }
        if (themeElement2 == null) {
            int dA7 = com.baidu.tieba.lego.card.d.a.dA("#249BD6");
            dA2 = com.baidu.tieba.lego.card.d.a.dA("#246CD6");
            i2 = dA7;
        } else {
            int dA8 = com.baidu.tieba.lego.card.d.a.dA(themeElement2.common_color);
            dA2 = com.baidu.tieba.lego.card.d.a.dA(themeElement2.common_color);
            i2 = dA8;
        }
        if (themeElement3 == null) {
            dA3 = com.baidu.tieba.lego.card.d.a.dA("#249BD6");
            dA4 = com.baidu.tieba.lego.card.d.a.dA("#246CD6");
        } else {
            dA3 = com.baidu.tieba.lego.card.d.a.dA(themeElement3.common_color);
            dA4 = com.baidu.tieba.lego.card.d.a.dA(themeElement3.common_color);
        }
        this.aXP = i;
        this.bau = dA;
        this.ehD = i2;
        this.ehE = dA2;
        this.ehF = dA3;
        this.ehG = dA4;
        this.aVK = baX();
        invalidate();
    }

    private void baW() {
        this.aXP = com.baidu.tieba.lego.card.d.a.dA("#2BB8FF");
        this.bau = com.baidu.tieba.lego.card.d.a.dA("#2BB8FF");
        this.ehD = com.baidu.tieba.lego.card.d.a.dA("#249BD6");
        this.ehE = com.baidu.tieba.lego.card.d.a.dA("#246CD6");
        this.ehF = com.baidu.tieba.lego.card.d.a.dA("#249BD6");
        this.ehG = com.baidu.tieba.lego.card.d.a.dA("#246CD6");
        this.aVK = baX();
    }

    public void setDefaultGradientColor() {
        baW();
        invalidate();
    }

    private LinearGradient baX() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.aXP;
        int i4 = this.bau;
        if (skinType == 4) {
            i = this.ehF;
            i2 = this.ehG;
        } else if (skinType == 1) {
            i = this.ehD;
            i2 = this.ehE;
        } else {
            i = i3;
            i2 = i4;
        }
        this.aVK = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.ehH.setShader(this.aVK);
        this.mSkinType = skinType;
        return this.aVK;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aVK = baX();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.aXP));
        arrayList.add(Integer.valueOf(this.bau));
        arrayList.add(Integer.valueOf(this.ehD));
        arrayList.add(Integer.valueOf(this.ehE));
        arrayList.add(Integer.valueOf(this.ehF));
        arrayList.add(Integer.valueOf(this.ehG));
        return arrayList;
    }
}

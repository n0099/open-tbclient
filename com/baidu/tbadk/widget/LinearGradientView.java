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
    private LinearGradient aCd;
    private int aEN;
    private int aEd;
    private int dHW;
    private int dHX;
    private int dHY;
    private int dHZ;
    private final Paint dIa;
    private int dIb;
    private int dIc;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dIa = new Paint();
        this.mRadius = 0;
        this.dIc = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dIa = new Paint();
        this.mRadius = 0;
        this.dIc = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dIa = new Paint();
        this.mRadius = 0;
        this.dIc = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aSN();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.aCd = aSO();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        aSM();
        if (this.dIc == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.dIa);
        } else {
            canvas.drawPath(this.mPath, this.dIa);
        }
    }

    private void aSM() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.dIb != this.mRadius) && this.dIc != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.dIb = this.mRadius;
            this.mPath.reset();
            switch (this.dIc) {
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
        this.dIc = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.aEd = i;
        this.aEN = i2;
        this.dHW = i3;
        this.dHX = i4;
        this.dHY = i5;
        this.dHZ = i6;
        this.aCd = aSO();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.aEd != com.baidu.tieba.lego.card.d.a.cF(str) || this.aEN != com.baidu.tieba.lego.card.d.a.cF(str2) || this.dHW != com.baidu.tieba.lego.card.d.a.cF(str3) || this.dHX != com.baidu.tieba.lego.card.d.a.cF(str4) || this.dHY != com.baidu.tieba.lego.card.d.a.cF(str5) || this.dHZ != com.baidu.tieba.lego.card.d.a.cF(str6)) {
            this.aEd = com.baidu.tieba.lego.card.d.a.cF(str);
            this.aEN = com.baidu.tieba.lego.card.d.a.cF(str2);
            this.dHW = com.baidu.tieba.lego.card.d.a.cF(str3);
            this.dHX = com.baidu.tieba.lego.card.d.a.cF(str4);
            this.dHY = com.baidu.tieba.lego.card.d.a.cF(str5);
            this.dHZ = com.baidu.tieba.lego.card.d.a.cF(str6);
            this.aCd = aSO();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int cF;
        int i;
        int cF2;
        int i2;
        int cF3;
        int cF4;
        if (themeElement == null) {
            int cF5 = com.baidu.tieba.lego.card.d.a.cF("#2BB8FF");
            cF = com.baidu.tieba.lego.card.d.a.cF("#2BB8FF");
            i = cF5;
        } else {
            int cF6 = com.baidu.tieba.lego.card.d.a.cF(themeElement.common_color);
            cF = com.baidu.tieba.lego.card.d.a.cF(themeElement.common_color);
            i = cF6;
        }
        if (themeElement2 == null) {
            int cF7 = com.baidu.tieba.lego.card.d.a.cF("#249BD6");
            cF2 = com.baidu.tieba.lego.card.d.a.cF("#246CD6");
            i2 = cF7;
        } else {
            int cF8 = com.baidu.tieba.lego.card.d.a.cF(themeElement2.common_color);
            cF2 = com.baidu.tieba.lego.card.d.a.cF(themeElement2.common_color);
            i2 = cF8;
        }
        if (themeElement3 == null) {
            cF3 = com.baidu.tieba.lego.card.d.a.cF("#249BD6");
            cF4 = com.baidu.tieba.lego.card.d.a.cF("#246CD6");
        } else {
            cF3 = com.baidu.tieba.lego.card.d.a.cF(themeElement3.common_color);
            cF4 = com.baidu.tieba.lego.card.d.a.cF(themeElement3.common_color);
        }
        if (this.aEd != i || this.aEN != cF || this.dHW != i2 || this.dHX != cF2 || this.dHY != cF3 || this.dHZ != cF4) {
            this.aEd = i;
            this.aEN = cF;
            this.dHW = i2;
            this.dHX = cF2;
            this.dHY = cF3;
            this.dHZ = cF4;
            this.aCd = aSO();
            invalidate();
        }
    }

    private void aSN() {
        this.aEd = com.baidu.tieba.lego.card.d.a.cF("#2BB8FF");
        this.aEN = com.baidu.tieba.lego.card.d.a.cF("#2BB8FF");
        this.dHW = com.baidu.tieba.lego.card.d.a.cF("#249BD6");
        this.dHX = com.baidu.tieba.lego.card.d.a.cF("#246CD6");
        this.dHY = com.baidu.tieba.lego.card.d.a.cF("#249BD6");
        this.dHZ = com.baidu.tieba.lego.card.d.a.cF("#246CD6");
        this.aCd = aSO();
    }

    public void setDefaultGradientColor() {
        aSN();
        invalidate();
    }

    private LinearGradient aSO() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.aEd;
        int i4 = this.aEN;
        if (skinType == 4) {
            i = this.dHY;
            i2 = this.dHZ;
        } else if (skinType == 1) {
            i = this.dHW;
            i2 = this.dHX;
        } else {
            i = i3;
            i2 = i4;
        }
        this.aCd = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.dIa.setShader(this.aCd);
        this.mSkinType = skinType;
        return this.aCd;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aCd = aSO();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.aEd));
        arrayList.add(Integer.valueOf(this.aEN));
        arrayList.add(Integer.valueOf(this.dHW));
        arrayList.add(Integer.valueOf(this.dHX));
        arrayList.add(Integer.valueOf(this.dHY));
        arrayList.add(Integer.valueOf(this.dHZ));
        return arrayList;
    }
}

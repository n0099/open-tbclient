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
/* loaded from: classes5.dex */
public class LinearGradientView extends View {
    private LinearGradient awO;
    private int ayM;
    private int azx;
    private int dDe;
    private int dDf;
    private int dDg;
    private int dDh;
    private final Paint dDi;
    private int dDj;
    private int dDk;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dDi = new Paint();
        this.mRadius = 0;
        this.dDk = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dDi = new Paint();
        this.mRadius = 0;
        this.dDk = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dDi = new Paint();
        this.mRadius = 0;
        this.dDk = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aPW();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.awO = aPX();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        aPV();
        if (this.dDk == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.dDi);
        } else {
            canvas.drawPath(this.mPath, this.dDi);
        }
    }

    private void aPV() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.dDj != this.mRadius) && this.dDk != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.dDj = this.mRadius;
            this.mPath.reset();
            switch (this.dDk) {
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
        this.dDk = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.ayM = i;
        this.azx = i2;
        this.dDe = i3;
        this.dDf = i4;
        this.dDg = i5;
        this.dDh = i6;
        this.awO = aPX();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.ayM != com.baidu.tieba.lego.card.d.a.cy(str) || this.azx != com.baidu.tieba.lego.card.d.a.cy(str2) || this.dDe != com.baidu.tieba.lego.card.d.a.cy(str3) || this.dDf != com.baidu.tieba.lego.card.d.a.cy(str4) || this.dDg != com.baidu.tieba.lego.card.d.a.cy(str5) || this.dDh != com.baidu.tieba.lego.card.d.a.cy(str6)) {
            this.ayM = com.baidu.tieba.lego.card.d.a.cy(str);
            this.azx = com.baidu.tieba.lego.card.d.a.cy(str2);
            this.dDe = com.baidu.tieba.lego.card.d.a.cy(str3);
            this.dDf = com.baidu.tieba.lego.card.d.a.cy(str4);
            this.dDg = com.baidu.tieba.lego.card.d.a.cy(str5);
            this.dDh = com.baidu.tieba.lego.card.d.a.cy(str6);
            this.awO = aPX();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int cy;
        int i;
        int cy2;
        int i2;
        int cy3;
        int cy4;
        if (themeElement == null) {
            int cy5 = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
            cy = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
            i = cy5;
        } else {
            int cy6 = com.baidu.tieba.lego.card.d.a.cy(themeElement.common_color);
            cy = com.baidu.tieba.lego.card.d.a.cy(themeElement.common_color);
            i = cy6;
        }
        if (themeElement2 == null) {
            int cy7 = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
            cy2 = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
            i2 = cy7;
        } else {
            int cy8 = com.baidu.tieba.lego.card.d.a.cy(themeElement2.common_color);
            cy2 = com.baidu.tieba.lego.card.d.a.cy(themeElement2.common_color);
            i2 = cy8;
        }
        if (themeElement3 == null) {
            cy3 = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
            cy4 = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
        } else {
            cy3 = com.baidu.tieba.lego.card.d.a.cy(themeElement3.common_color);
            cy4 = com.baidu.tieba.lego.card.d.a.cy(themeElement3.common_color);
        }
        if (this.ayM != i || this.azx != cy || this.dDe != i2 || this.dDf != cy2 || this.dDg != cy3 || this.dDh != cy4) {
            this.ayM = i;
            this.azx = cy;
            this.dDe = i2;
            this.dDf = cy2;
            this.dDg = cy3;
            this.dDh = cy4;
            this.awO = aPX();
            invalidate();
        }
    }

    private void aPW() {
        this.ayM = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
        this.azx = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
        this.dDe = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
        this.dDf = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
        this.dDg = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
        this.dDh = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
        this.awO = aPX();
    }

    public void setDefaultGradientColor() {
        aPW();
        invalidate();
    }

    private LinearGradient aPX() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.ayM;
        int i4 = this.azx;
        if (skinType == 4) {
            i = this.dDg;
            i2 = this.dDh;
        } else if (skinType == 1) {
            i = this.dDe;
            i2 = this.dDf;
        } else {
            i = i3;
            i2 = i4;
        }
        this.awO = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.dDi.setShader(this.awO);
        this.mSkinType = skinType;
        return this.awO;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.awO = aPX();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.ayM));
        arrayList.add(Integer.valueOf(this.azx));
        arrayList.add(Integer.valueOf(this.dDe));
        arrayList.add(Integer.valueOf(this.dDf));
        arrayList.add(Integer.valueOf(this.dDg));
        arrayList.add(Integer.valueOf(this.dDh));
        return arrayList;
    }
}

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
/* loaded from: classes21.dex */
public class LinearGradientView extends View {
    private int bAz;
    private int bFW;
    private LinearGradient bxD;
    private int ftR;
    private int ftS;
    private int ftT;
    private int ftU;
    private final Paint ftV;
    private int ftW;
    private int ftX;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ftV = new Paint();
        this.mRadius = 0;
        this.ftX = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ftV = new Paint();
        this.mRadius = 0;
        this.ftX = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ftV = new Paint();
        this.mRadius = 0;
        this.ftX = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bBO();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bxD = bBP();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bBN();
        if (this.ftX == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.ftV);
        } else {
            canvas.drawPath(this.mPath, this.ftV);
        }
    }

    private void bBN() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.ftW != this.mRadius) && this.ftX != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.ftW = this.mRadius;
            this.mPath.reset();
            switch (this.ftX) {
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
        this.ftX = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bAz = i;
        this.bFW = i2;
        this.ftR = i3;
        this.ftS = i4;
        this.ftT = i5;
        this.ftU = i6;
        this.bxD = bBP();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bAz != com.baidu.tieba.lego.card.d.b.fv(str) || this.bFW != com.baidu.tieba.lego.card.d.b.fv(str2) || this.ftR != com.baidu.tieba.lego.card.d.b.fv(str3) || this.ftS != com.baidu.tieba.lego.card.d.b.fv(str4) || this.ftT != com.baidu.tieba.lego.card.d.b.fv(str5) || this.ftU != com.baidu.tieba.lego.card.d.b.fv(str6)) {
            this.bAz = com.baidu.tieba.lego.card.d.b.fv(str);
            this.bFW = com.baidu.tieba.lego.card.d.b.fv(str2);
            this.ftR = com.baidu.tieba.lego.card.d.b.fv(str3);
            this.ftS = com.baidu.tieba.lego.card.d.b.fv(str4);
            this.ftT = com.baidu.tieba.lego.card.d.b.fv(str5);
            this.ftU = com.baidu.tieba.lego.card.d.b.fv(str6);
            this.bxD = bBP();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int fv;
        int i;
        int fv2;
        int i2;
        int fv3;
        int fv4;
        if (themeElement == null) {
            int fv5 = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
            fv = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
            i = fv5;
        } else {
            int fv6 = com.baidu.tieba.lego.card.d.b.fv(themeElement.common_color);
            fv = com.baidu.tieba.lego.card.d.b.fv(themeElement.common_color);
            i = fv6;
        }
        if (themeElement2 == null) {
            int fv7 = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
            fv2 = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
            i2 = fv7;
        } else {
            int fv8 = com.baidu.tieba.lego.card.d.b.fv(themeElement2.common_color);
            fv2 = com.baidu.tieba.lego.card.d.b.fv(themeElement2.common_color);
            i2 = fv8;
        }
        if (themeElement3 == null) {
            fv3 = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
            fv4 = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
        } else {
            fv3 = com.baidu.tieba.lego.card.d.b.fv(themeElement3.common_color);
            fv4 = com.baidu.tieba.lego.card.d.b.fv(themeElement3.common_color);
        }
        this.bAz = i;
        this.bFW = fv;
        this.ftR = i2;
        this.ftS = fv2;
        this.ftT = fv3;
        this.ftU = fv4;
        this.bxD = bBP();
        invalidate();
    }

    private void bBO() {
        this.bAz = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
        this.bFW = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
        this.ftR = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
        this.ftS = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
        this.ftT = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
        this.ftU = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
        this.bxD = bBP();
    }

    public void setDefaultGradientColor() {
        bBO();
        invalidate();
    }

    private LinearGradient bBP() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bAz;
        int i4 = this.bFW;
        if (skinType == 4) {
            i = this.ftT;
            i2 = this.ftU;
        } else if (skinType == 1) {
            i = this.ftR;
            i2 = this.ftS;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bxD = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.ftV.setShader(this.bxD);
        this.mSkinType = skinType;
        return this.bxD;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bxD = bBP();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bAz));
        arrayList.add(Integer.valueOf(this.bFW));
        arrayList.add(Integer.valueOf(this.ftR));
        arrayList.add(Integer.valueOf(this.ftS));
        arrayList.add(Integer.valueOf(this.ftT));
        arrayList.add(Integer.valueOf(this.ftU));
        return arrayList;
    }
}

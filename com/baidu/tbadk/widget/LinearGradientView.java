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
    private LinearGradient bHm;
    private int bKj;
    private int bPq;
    private int fLO;
    private int fLP;
    private int fLQ;
    private int fLR;
    private final Paint fLS;
    private int fLT;
    private int fLU;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fLS = new Paint();
        this.mRadius = 0;
        this.fLU = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fLS = new Paint();
        this.mRadius = 0;
        this.fLU = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fLS = new Paint();
        this.mRadius = 0;
        this.fLU = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bFJ();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bHm = bFK();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bFI();
        if (this.fLU == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.fLS);
        } else {
            canvas.drawPath(this.mPath, this.fLS);
        }
    }

    private void bFI() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.fLT != this.mRadius) && this.fLU != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.fLT = this.mRadius;
            this.mPath.reset();
            switch (this.fLU) {
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
        this.fLU = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bKj = i;
        this.bPq = i2;
        this.fLO = i3;
        this.fLP = i4;
        this.fLQ = i5;
        this.fLR = i6;
        this.bHm = bFK();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bKj != com.baidu.tieba.lego.card.c.b.rt(str) || this.bPq != com.baidu.tieba.lego.card.c.b.rt(str2) || this.fLO != com.baidu.tieba.lego.card.c.b.rt(str3) || this.fLP != com.baidu.tieba.lego.card.c.b.rt(str4) || this.fLQ != com.baidu.tieba.lego.card.c.b.rt(str5) || this.fLR != com.baidu.tieba.lego.card.c.b.rt(str6)) {
            this.bKj = com.baidu.tieba.lego.card.c.b.rt(str);
            this.bPq = com.baidu.tieba.lego.card.c.b.rt(str2);
            this.fLO = com.baidu.tieba.lego.card.c.b.rt(str3);
            this.fLP = com.baidu.tieba.lego.card.c.b.rt(str4);
            this.fLQ = com.baidu.tieba.lego.card.c.b.rt(str5);
            this.fLR = com.baidu.tieba.lego.card.c.b.rt(str6);
            this.bHm = bFK();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int rt;
        int i;
        int rt2;
        int i2;
        int rt3;
        int rt4;
        if (themeElement == null) {
            int rt5 = com.baidu.tieba.lego.card.c.b.rt("#2BB8FF");
            rt = com.baidu.tieba.lego.card.c.b.rt("#2BB8FF");
            i = rt5;
        } else {
            int rt6 = com.baidu.tieba.lego.card.c.b.rt(themeElement.common_color);
            rt = com.baidu.tieba.lego.card.c.b.rt(themeElement.common_color);
            i = rt6;
        }
        if (themeElement2 == null) {
            int rt7 = com.baidu.tieba.lego.card.c.b.rt("#249BD6");
            rt2 = com.baidu.tieba.lego.card.c.b.rt("#246CD6");
            i2 = rt7;
        } else {
            int rt8 = com.baidu.tieba.lego.card.c.b.rt(themeElement2.common_color);
            rt2 = com.baidu.tieba.lego.card.c.b.rt(themeElement2.common_color);
            i2 = rt8;
        }
        if (themeElement3 == null) {
            rt3 = com.baidu.tieba.lego.card.c.b.rt("#249BD6");
            rt4 = com.baidu.tieba.lego.card.c.b.rt("#246CD6");
        } else {
            rt3 = com.baidu.tieba.lego.card.c.b.rt(themeElement3.common_color);
            rt4 = com.baidu.tieba.lego.card.c.b.rt(themeElement3.common_color);
        }
        this.bKj = i;
        this.bPq = rt;
        this.fLO = i2;
        this.fLP = rt2;
        this.fLQ = rt3;
        this.fLR = rt4;
        this.bHm = bFK();
        invalidate();
    }

    private void bFJ() {
        this.bKj = com.baidu.tieba.lego.card.c.b.rt("#2BB8FF");
        this.bPq = com.baidu.tieba.lego.card.c.b.rt("#2BB8FF");
        this.fLO = com.baidu.tieba.lego.card.c.b.rt("#249BD6");
        this.fLP = com.baidu.tieba.lego.card.c.b.rt("#246CD6");
        this.fLQ = com.baidu.tieba.lego.card.c.b.rt("#249BD6");
        this.fLR = com.baidu.tieba.lego.card.c.b.rt("#246CD6");
        this.bHm = bFK();
    }

    public void setDefaultGradientColor() {
        bFJ();
        invalidate();
    }

    private LinearGradient bFK() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bKj;
        int i4 = this.bPq;
        if (skinType == 4) {
            int i5 = this.fLQ;
            i = this.fLR;
            i2 = i5;
        } else if (skinType == 1) {
            int i6 = this.fLO;
            i = this.fLP;
            i2 = i6;
        } else {
            i = i4;
            i2 = i3;
        }
        this.bHm = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i2, i}, (float[]) null, Shader.TileMode.CLAMP);
        this.fLS.setShader(this.bHm);
        this.mSkinType = skinType;
        return this.bHm;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bHm = bFK();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bKj));
        arrayList.add(Integer.valueOf(this.bPq));
        arrayList.add(Integer.valueOf(this.fLO));
        arrayList.add(Integer.valueOf(this.fLP));
        arrayList.add(Integer.valueOf(this.fLQ));
        arrayList.add(Integer.valueOf(this.fLR));
        return arrayList;
    }
}

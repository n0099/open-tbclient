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
/* loaded from: classes20.dex */
public class LinearGradientView extends View {
    private LinearGradient brB;
    private int btK;
    private int bwx;
    private int eZe;
    private int eZf;
    private int eZg;
    private int eZh;
    private final Paint eZi;
    private int eZj;
    private int eZk;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eZi = new Paint();
        this.mRadius = 0;
        this.eZk = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eZi = new Paint();
        this.mRadius = 0;
        this.eZk = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eZi = new Paint();
        this.mRadius = 0;
        this.eZk = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bxl();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.brB = bxm();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bxk();
        if (this.eZk == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.eZi);
        } else {
            canvas.drawPath(this.mPath, this.eZi);
        }
    }

    private void bxk() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.eZj != this.mRadius) && this.eZk != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.eZj = this.mRadius;
            this.mPath.reset();
            switch (this.eZk) {
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
        this.eZk = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.btK = i;
        this.bwx = i2;
        this.eZe = i3;
        this.eZf = i4;
        this.eZg = i5;
        this.eZh = i6;
        this.brB = bxm();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.btK != com.baidu.tieba.lego.card.d.b.fq(str) || this.bwx != com.baidu.tieba.lego.card.d.b.fq(str2) || this.eZe != com.baidu.tieba.lego.card.d.b.fq(str3) || this.eZf != com.baidu.tieba.lego.card.d.b.fq(str4) || this.eZg != com.baidu.tieba.lego.card.d.b.fq(str5) || this.eZh != com.baidu.tieba.lego.card.d.b.fq(str6)) {
            this.btK = com.baidu.tieba.lego.card.d.b.fq(str);
            this.bwx = com.baidu.tieba.lego.card.d.b.fq(str2);
            this.eZe = com.baidu.tieba.lego.card.d.b.fq(str3);
            this.eZf = com.baidu.tieba.lego.card.d.b.fq(str4);
            this.eZg = com.baidu.tieba.lego.card.d.b.fq(str5);
            this.eZh = com.baidu.tieba.lego.card.d.b.fq(str6);
            this.brB = bxm();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int fq;
        int i;
        int fq2;
        int i2;
        int fq3;
        int fq4;
        if (themeElement == null) {
            int fq5 = com.baidu.tieba.lego.card.d.b.fq("#2BB8FF");
            fq = com.baidu.tieba.lego.card.d.b.fq("#2BB8FF");
            i = fq5;
        } else {
            int fq6 = com.baidu.tieba.lego.card.d.b.fq(themeElement.common_color);
            fq = com.baidu.tieba.lego.card.d.b.fq(themeElement.common_color);
            i = fq6;
        }
        if (themeElement2 == null) {
            int fq7 = com.baidu.tieba.lego.card.d.b.fq("#249BD6");
            fq2 = com.baidu.tieba.lego.card.d.b.fq("#246CD6");
            i2 = fq7;
        } else {
            int fq8 = com.baidu.tieba.lego.card.d.b.fq(themeElement2.common_color);
            fq2 = com.baidu.tieba.lego.card.d.b.fq(themeElement2.common_color);
            i2 = fq8;
        }
        if (themeElement3 == null) {
            fq3 = com.baidu.tieba.lego.card.d.b.fq("#249BD6");
            fq4 = com.baidu.tieba.lego.card.d.b.fq("#246CD6");
        } else {
            fq3 = com.baidu.tieba.lego.card.d.b.fq(themeElement3.common_color);
            fq4 = com.baidu.tieba.lego.card.d.b.fq(themeElement3.common_color);
        }
        this.btK = i;
        this.bwx = fq;
        this.eZe = i2;
        this.eZf = fq2;
        this.eZg = fq3;
        this.eZh = fq4;
        this.brB = bxm();
        invalidate();
    }

    private void bxl() {
        this.btK = com.baidu.tieba.lego.card.d.b.fq("#2BB8FF");
        this.bwx = com.baidu.tieba.lego.card.d.b.fq("#2BB8FF");
        this.eZe = com.baidu.tieba.lego.card.d.b.fq("#249BD6");
        this.eZf = com.baidu.tieba.lego.card.d.b.fq("#246CD6");
        this.eZg = com.baidu.tieba.lego.card.d.b.fq("#249BD6");
        this.eZh = com.baidu.tieba.lego.card.d.b.fq("#246CD6");
        this.brB = bxm();
    }

    public void setDefaultGradientColor() {
        bxl();
        invalidate();
    }

    private LinearGradient bxm() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.btK;
        int i4 = this.bwx;
        if (skinType == 4) {
            i = this.eZg;
            i2 = this.eZh;
        } else if (skinType == 1) {
            i = this.eZe;
            i2 = this.eZf;
        } else {
            i = i3;
            i2 = i4;
        }
        this.brB = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.eZi.setShader(this.brB);
        this.mSkinType = skinType;
        return this.brB;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.brB = bxm();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.btK));
        arrayList.add(Integer.valueOf(this.bwx));
        arrayList.add(Integer.valueOf(this.eZe));
        arrayList.add(Integer.valueOf(this.eZf));
        arrayList.add(Integer.valueOf(this.eZg));
        arrayList.add(Integer.valueOf(this.eZh));
        return arrayList;
    }
}

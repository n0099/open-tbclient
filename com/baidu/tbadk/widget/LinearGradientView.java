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
    private LinearGradient bdd;
    private int bfp;
    private int bhW;
    private int ewb;
    private int ewc;
    private int ewd;
    private int ewe;
    private final Paint ewf;
    private int ewg;
    private int ewh;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ewf = new Paint();
        this.mRadius = 0;
        this.ewh = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ewf = new Paint();
        this.mRadius = 0;
        this.ewh = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ewf = new Paint();
        this.mRadius = 0;
        this.ewh = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bhf();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bdd = bhg();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bhe();
        if (this.ewh == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.ewf);
        } else {
            canvas.drawPath(this.mPath, this.ewf);
        }
    }

    private void bhe() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.ewg != this.mRadius) && this.ewh != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.ewg = this.mRadius;
            this.mPath.reset();
            switch (this.ewh) {
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
        this.ewh = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bfp = i;
        this.bhW = i2;
        this.ewb = i3;
        this.ewc = i4;
        this.ewd = i5;
        this.ewe = i6;
        this.bdd = bhg();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bfp != com.baidu.tieba.lego.card.d.a.dT(str) || this.bhW != com.baidu.tieba.lego.card.d.a.dT(str2) || this.ewb != com.baidu.tieba.lego.card.d.a.dT(str3) || this.ewc != com.baidu.tieba.lego.card.d.a.dT(str4) || this.ewd != com.baidu.tieba.lego.card.d.a.dT(str5) || this.ewe != com.baidu.tieba.lego.card.d.a.dT(str6)) {
            this.bfp = com.baidu.tieba.lego.card.d.a.dT(str);
            this.bhW = com.baidu.tieba.lego.card.d.a.dT(str2);
            this.ewb = com.baidu.tieba.lego.card.d.a.dT(str3);
            this.ewc = com.baidu.tieba.lego.card.d.a.dT(str4);
            this.ewd = com.baidu.tieba.lego.card.d.a.dT(str5);
            this.ewe = com.baidu.tieba.lego.card.d.a.dT(str6);
            this.bdd = bhg();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int dT;
        int i;
        int dT2;
        int i2;
        int dT3;
        int dT4;
        if (themeElement == null) {
            int dT5 = com.baidu.tieba.lego.card.d.a.dT("#2BB8FF");
            dT = com.baidu.tieba.lego.card.d.a.dT("#2BB8FF");
            i = dT5;
        } else {
            int dT6 = com.baidu.tieba.lego.card.d.a.dT(themeElement.common_color);
            dT = com.baidu.tieba.lego.card.d.a.dT(themeElement.common_color);
            i = dT6;
        }
        if (themeElement2 == null) {
            int dT7 = com.baidu.tieba.lego.card.d.a.dT("#249BD6");
            dT2 = com.baidu.tieba.lego.card.d.a.dT("#246CD6");
            i2 = dT7;
        } else {
            int dT8 = com.baidu.tieba.lego.card.d.a.dT(themeElement2.common_color);
            dT2 = com.baidu.tieba.lego.card.d.a.dT(themeElement2.common_color);
            i2 = dT8;
        }
        if (themeElement3 == null) {
            dT3 = com.baidu.tieba.lego.card.d.a.dT("#249BD6");
            dT4 = com.baidu.tieba.lego.card.d.a.dT("#246CD6");
        } else {
            dT3 = com.baidu.tieba.lego.card.d.a.dT(themeElement3.common_color);
            dT4 = com.baidu.tieba.lego.card.d.a.dT(themeElement3.common_color);
        }
        this.bfp = i;
        this.bhW = dT;
        this.ewb = i2;
        this.ewc = dT2;
        this.ewd = dT3;
        this.ewe = dT4;
        this.bdd = bhg();
        invalidate();
    }

    private void bhf() {
        this.bfp = com.baidu.tieba.lego.card.d.a.dT("#2BB8FF");
        this.bhW = com.baidu.tieba.lego.card.d.a.dT("#2BB8FF");
        this.ewb = com.baidu.tieba.lego.card.d.a.dT("#249BD6");
        this.ewc = com.baidu.tieba.lego.card.d.a.dT("#246CD6");
        this.ewd = com.baidu.tieba.lego.card.d.a.dT("#249BD6");
        this.ewe = com.baidu.tieba.lego.card.d.a.dT("#246CD6");
        this.bdd = bhg();
    }

    public void setDefaultGradientColor() {
        bhf();
        invalidate();
    }

    private LinearGradient bhg() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bfp;
        int i4 = this.bhW;
        if (skinType == 4) {
            i = this.ewd;
            i2 = this.ewe;
        } else if (skinType == 1) {
            i = this.ewb;
            i2 = this.ewc;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bdd = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.ewf.setShader(this.bdd);
        this.mSkinType = skinType;
        return this.bdd;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bdd = bhg();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bfp));
        arrayList.add(Integer.valueOf(this.bhW));
        arrayList.add(Integer.valueOf(this.ewb));
        arrayList.add(Integer.valueOf(this.ewc));
        arrayList.add(Integer.valueOf(this.ewd));
        arrayList.add(Integer.valueOf(this.ewe));
        return arrayList;
    }
}

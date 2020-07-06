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
    private LinearGradient biq;
    private int bkz;
    private int bnd;
    private int eFh;
    private int eFi;
    private int eFj;
    private int eFk;
    private final Paint eFl;
    private int eFm;
    private int eFn;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eFl = new Paint();
        this.mRadius = 0;
        this.eFn = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eFl = new Paint();
        this.mRadius = 0;
        this.eFn = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eFl = new Paint();
        this.mRadius = 0;
        this.eFn = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bju();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.biq = bjv();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bjt();
        if (this.eFn == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.eFl);
        } else {
            canvas.drawPath(this.mPath, this.eFl);
        }
    }

    private void bjt() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.eFm != this.mRadius) && this.eFn != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.eFm = this.mRadius;
            this.mPath.reset();
            switch (this.eFn) {
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
        this.eFn = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bkz = i;
        this.bnd = i2;
        this.eFh = i3;
        this.eFi = i4;
        this.eFj = i5;
        this.eFk = i6;
        this.biq = bjv();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bkz != com.baidu.tieba.lego.card.d.a.dV(str) || this.bnd != com.baidu.tieba.lego.card.d.a.dV(str2) || this.eFh != com.baidu.tieba.lego.card.d.a.dV(str3) || this.eFi != com.baidu.tieba.lego.card.d.a.dV(str4) || this.eFj != com.baidu.tieba.lego.card.d.a.dV(str5) || this.eFk != com.baidu.tieba.lego.card.d.a.dV(str6)) {
            this.bkz = com.baidu.tieba.lego.card.d.a.dV(str);
            this.bnd = com.baidu.tieba.lego.card.d.a.dV(str2);
            this.eFh = com.baidu.tieba.lego.card.d.a.dV(str3);
            this.eFi = com.baidu.tieba.lego.card.d.a.dV(str4);
            this.eFj = com.baidu.tieba.lego.card.d.a.dV(str5);
            this.eFk = com.baidu.tieba.lego.card.d.a.dV(str6);
            this.biq = bjv();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int dV;
        int i;
        int dV2;
        int i2;
        int dV3;
        int dV4;
        if (themeElement == null) {
            int dV5 = com.baidu.tieba.lego.card.d.a.dV("#2BB8FF");
            dV = com.baidu.tieba.lego.card.d.a.dV("#2BB8FF");
            i = dV5;
        } else {
            int dV6 = com.baidu.tieba.lego.card.d.a.dV(themeElement.common_color);
            dV = com.baidu.tieba.lego.card.d.a.dV(themeElement.common_color);
            i = dV6;
        }
        if (themeElement2 == null) {
            int dV7 = com.baidu.tieba.lego.card.d.a.dV("#249BD6");
            dV2 = com.baidu.tieba.lego.card.d.a.dV("#246CD6");
            i2 = dV7;
        } else {
            int dV8 = com.baidu.tieba.lego.card.d.a.dV(themeElement2.common_color);
            dV2 = com.baidu.tieba.lego.card.d.a.dV(themeElement2.common_color);
            i2 = dV8;
        }
        if (themeElement3 == null) {
            dV3 = com.baidu.tieba.lego.card.d.a.dV("#249BD6");
            dV4 = com.baidu.tieba.lego.card.d.a.dV("#246CD6");
        } else {
            dV3 = com.baidu.tieba.lego.card.d.a.dV(themeElement3.common_color);
            dV4 = com.baidu.tieba.lego.card.d.a.dV(themeElement3.common_color);
        }
        this.bkz = i;
        this.bnd = dV;
        this.eFh = i2;
        this.eFi = dV2;
        this.eFj = dV3;
        this.eFk = dV4;
        this.biq = bjv();
        invalidate();
    }

    private void bju() {
        this.bkz = com.baidu.tieba.lego.card.d.a.dV("#2BB8FF");
        this.bnd = com.baidu.tieba.lego.card.d.a.dV("#2BB8FF");
        this.eFh = com.baidu.tieba.lego.card.d.a.dV("#249BD6");
        this.eFi = com.baidu.tieba.lego.card.d.a.dV("#246CD6");
        this.eFj = com.baidu.tieba.lego.card.d.a.dV("#249BD6");
        this.eFk = com.baidu.tieba.lego.card.d.a.dV("#246CD6");
        this.biq = bjv();
    }

    public void setDefaultGradientColor() {
        bju();
        invalidate();
    }

    private LinearGradient bjv() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bkz;
        int i4 = this.bnd;
        if (skinType == 4) {
            i = this.eFj;
            i2 = this.eFk;
        } else if (skinType == 1) {
            i = this.eFh;
            i2 = this.eFi;
        } else {
            i = i3;
            i2 = i4;
        }
        this.biq = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.eFl.setShader(this.biq);
        this.mSkinType = skinType;
        return this.biq;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.biq = bjv();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bkz));
        arrayList.add(Integer.valueOf(this.bnd));
        arrayList.add(Integer.valueOf(this.eFh));
        arrayList.add(Integer.valueOf(this.eFi));
        arrayList.add(Integer.valueOf(this.eFj));
        arrayList.add(Integer.valueOf(this.eFk));
        return arrayList;
    }
}

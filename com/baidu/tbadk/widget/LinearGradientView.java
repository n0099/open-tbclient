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
    private LinearGradient aVP;
    private int aXU;
    private int baz;
    private int ehI;
    private int ehJ;
    private int ehK;
    private int ehL;
    private final Paint ehM;
    private int ehN;
    private int ehO;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ehM = new Paint();
        this.mRadius = 0;
        this.ehO = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ehM = new Paint();
        this.mRadius = 0;
        this.ehO = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ehM = new Paint();
        this.mRadius = 0;
        this.ehO = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        baU();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.aVP = baV();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        baT();
        if (this.ehO == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.ehM);
        } else {
            canvas.drawPath(this.mPath, this.ehM);
        }
    }

    private void baT() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.ehN != this.mRadius) && this.ehO != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.ehN = this.mRadius;
            this.mPath.reset();
            switch (this.ehO) {
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
        this.ehO = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.aXU = i;
        this.baz = i2;
        this.ehI = i3;
        this.ehJ = i4;
        this.ehK = i5;
        this.ehL = i6;
        this.aVP = baV();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.aXU != com.baidu.tieba.lego.card.d.a.dA(str) || this.baz != com.baidu.tieba.lego.card.d.a.dA(str2) || this.ehI != com.baidu.tieba.lego.card.d.a.dA(str3) || this.ehJ != com.baidu.tieba.lego.card.d.a.dA(str4) || this.ehK != com.baidu.tieba.lego.card.d.a.dA(str5) || this.ehL != com.baidu.tieba.lego.card.d.a.dA(str6)) {
            this.aXU = com.baidu.tieba.lego.card.d.a.dA(str);
            this.baz = com.baidu.tieba.lego.card.d.a.dA(str2);
            this.ehI = com.baidu.tieba.lego.card.d.a.dA(str3);
            this.ehJ = com.baidu.tieba.lego.card.d.a.dA(str4);
            this.ehK = com.baidu.tieba.lego.card.d.a.dA(str5);
            this.ehL = com.baidu.tieba.lego.card.d.a.dA(str6);
            this.aVP = baV();
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
        this.aXU = i;
        this.baz = dA;
        this.ehI = i2;
        this.ehJ = dA2;
        this.ehK = dA3;
        this.ehL = dA4;
        this.aVP = baV();
        invalidate();
    }

    private void baU() {
        this.aXU = com.baidu.tieba.lego.card.d.a.dA("#2BB8FF");
        this.baz = com.baidu.tieba.lego.card.d.a.dA("#2BB8FF");
        this.ehI = com.baidu.tieba.lego.card.d.a.dA("#249BD6");
        this.ehJ = com.baidu.tieba.lego.card.d.a.dA("#246CD6");
        this.ehK = com.baidu.tieba.lego.card.d.a.dA("#249BD6");
        this.ehL = com.baidu.tieba.lego.card.d.a.dA("#246CD6");
        this.aVP = baV();
    }

    public void setDefaultGradientColor() {
        baU();
        invalidate();
    }

    private LinearGradient baV() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.aXU;
        int i4 = this.baz;
        if (skinType == 4) {
            i = this.ehK;
            i2 = this.ehL;
        } else if (skinType == 1) {
            i = this.ehI;
            i2 = this.ehJ;
        } else {
            i = i3;
            i2 = i4;
        }
        this.aVP = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.ehM.setShader(this.aVP);
        this.mSkinType = skinType;
        return this.aVP;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aVP = baV();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.aXU));
        arrayList.add(Integer.valueOf(this.baz));
        arrayList.add(Integer.valueOf(this.ehI));
        arrayList.add(Integer.valueOf(this.ehJ));
        arrayList.add(Integer.valueOf(this.ehK));
        arrayList.add(Integer.valueOf(this.ehL));
        return arrayList;
    }
}

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
    private LinearGradient bDO;
    private int bGK;
    private int bLB;
    private int fzH;
    private int fzI;
    private int fzJ;
    private int fzK;
    private final Paint fzL;
    private int fzM;
    private int fzN;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fzL = new Paint();
        this.mRadius = 0;
        this.fzN = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fzL = new Paint();
        this.mRadius = 0;
        this.fzN = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fzL = new Paint();
        this.mRadius = 0;
        this.fzN = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bEn();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bDO = bEo();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bEm();
        if (this.fzN == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.fzL);
        } else {
            canvas.drawPath(this.mPath, this.fzL);
        }
    }

    private void bEm() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.fzM != this.mRadius) && this.fzN != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.fzM = this.mRadius;
            this.mPath.reset();
            switch (this.fzN) {
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
        this.fzN = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bGK = i;
        this.bLB = i2;
        this.fzH = i3;
        this.fzI = i4;
        this.fzJ = i5;
        this.fzK = i6;
        this.bDO = bEo();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bGK != com.baidu.tieba.lego.card.d.b.fv(str) || this.bLB != com.baidu.tieba.lego.card.d.b.fv(str2) || this.fzH != com.baidu.tieba.lego.card.d.b.fv(str3) || this.fzI != com.baidu.tieba.lego.card.d.b.fv(str4) || this.fzJ != com.baidu.tieba.lego.card.d.b.fv(str5) || this.fzK != com.baidu.tieba.lego.card.d.b.fv(str6)) {
            this.bGK = com.baidu.tieba.lego.card.d.b.fv(str);
            this.bLB = com.baidu.tieba.lego.card.d.b.fv(str2);
            this.fzH = com.baidu.tieba.lego.card.d.b.fv(str3);
            this.fzI = com.baidu.tieba.lego.card.d.b.fv(str4);
            this.fzJ = com.baidu.tieba.lego.card.d.b.fv(str5);
            this.fzK = com.baidu.tieba.lego.card.d.b.fv(str6);
            this.bDO = bEo();
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
        this.bGK = i;
        this.bLB = fv;
        this.fzH = i2;
        this.fzI = fv2;
        this.fzJ = fv3;
        this.fzK = fv4;
        this.bDO = bEo();
        invalidate();
    }

    private void bEn() {
        this.bGK = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
        this.bLB = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
        this.fzH = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
        this.fzI = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
        this.fzJ = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
        this.fzK = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
        this.bDO = bEo();
    }

    public void setDefaultGradientColor() {
        bEn();
        invalidate();
    }

    private LinearGradient bEo() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bGK;
        int i4 = this.bLB;
        if (skinType == 4) {
            i = this.fzJ;
            i2 = this.fzK;
        } else if (skinType == 1) {
            i = this.fzH;
            i2 = this.fzI;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bDO = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.fzL.setShader(this.bDO);
        this.mSkinType = skinType;
        return this.bDO;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bDO = bEo();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bGK));
        arrayList.add(Integer.valueOf(this.bLB));
        arrayList.add(Integer.valueOf(this.fzH));
        arrayList.add(Integer.valueOf(this.fzI));
        arrayList.add(Integer.valueOf(this.fzJ));
        arrayList.add(Integer.valueOf(this.fzK));
        return arrayList;
    }
}

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
    private LinearGradient bHl;
    private int bKi;
    private int bOY;
    private int fGT;
    private int fGU;
    private int fGV;
    private int fGW;
    private final Paint fGX;
    private int fGY;
    private int fGZ;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fGX = new Paint();
        this.mRadius = 0;
        this.fGZ = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fGX = new Paint();
        this.mRadius = 0;
        this.fGZ = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fGX = new Paint();
        this.mRadius = 0;
        this.fGZ = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bHh();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bHl = bHi();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bHg();
        if (this.fGZ == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.fGX);
        } else {
            canvas.drawPath(this.mPath, this.fGX);
        }
    }

    private void bHg() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.fGY != this.mRadius) && this.fGZ != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.fGY = this.mRadius;
            this.mPath.reset();
            switch (this.fGZ) {
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
        this.fGZ = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bKi = i;
        this.bOY = i2;
        this.fGT = i3;
        this.fGU = i4;
        this.fGV = i5;
        this.fGW = i6;
        this.bHl = bHi();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bKi != com.baidu.tieba.lego.card.d.b.sI(str) || this.bOY != com.baidu.tieba.lego.card.d.b.sI(str2) || this.fGT != com.baidu.tieba.lego.card.d.b.sI(str3) || this.fGU != com.baidu.tieba.lego.card.d.b.sI(str4) || this.fGV != com.baidu.tieba.lego.card.d.b.sI(str5) || this.fGW != com.baidu.tieba.lego.card.d.b.sI(str6)) {
            this.bKi = com.baidu.tieba.lego.card.d.b.sI(str);
            this.bOY = com.baidu.tieba.lego.card.d.b.sI(str2);
            this.fGT = com.baidu.tieba.lego.card.d.b.sI(str3);
            this.fGU = com.baidu.tieba.lego.card.d.b.sI(str4);
            this.fGV = com.baidu.tieba.lego.card.d.b.sI(str5);
            this.fGW = com.baidu.tieba.lego.card.d.b.sI(str6);
            this.bHl = bHi();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int sI;
        int i;
        int sI2;
        int i2;
        int sI3;
        int sI4;
        if (themeElement == null) {
            int sI5 = com.baidu.tieba.lego.card.d.b.sI("#2BB8FF");
            sI = com.baidu.tieba.lego.card.d.b.sI("#2BB8FF");
            i = sI5;
        } else {
            int sI6 = com.baidu.tieba.lego.card.d.b.sI(themeElement.common_color);
            sI = com.baidu.tieba.lego.card.d.b.sI(themeElement.common_color);
            i = sI6;
        }
        if (themeElement2 == null) {
            int sI7 = com.baidu.tieba.lego.card.d.b.sI("#249BD6");
            sI2 = com.baidu.tieba.lego.card.d.b.sI("#246CD6");
            i2 = sI7;
        } else {
            int sI8 = com.baidu.tieba.lego.card.d.b.sI(themeElement2.common_color);
            sI2 = com.baidu.tieba.lego.card.d.b.sI(themeElement2.common_color);
            i2 = sI8;
        }
        if (themeElement3 == null) {
            sI3 = com.baidu.tieba.lego.card.d.b.sI("#249BD6");
            sI4 = com.baidu.tieba.lego.card.d.b.sI("#246CD6");
        } else {
            sI3 = com.baidu.tieba.lego.card.d.b.sI(themeElement3.common_color);
            sI4 = com.baidu.tieba.lego.card.d.b.sI(themeElement3.common_color);
        }
        this.bKi = i;
        this.bOY = sI;
        this.fGT = i2;
        this.fGU = sI2;
        this.fGV = sI3;
        this.fGW = sI4;
        this.bHl = bHi();
        invalidate();
    }

    private void bHh() {
        this.bKi = com.baidu.tieba.lego.card.d.b.sI("#2BB8FF");
        this.bOY = com.baidu.tieba.lego.card.d.b.sI("#2BB8FF");
        this.fGT = com.baidu.tieba.lego.card.d.b.sI("#249BD6");
        this.fGU = com.baidu.tieba.lego.card.d.b.sI("#246CD6");
        this.fGV = com.baidu.tieba.lego.card.d.b.sI("#249BD6");
        this.fGW = com.baidu.tieba.lego.card.d.b.sI("#246CD6");
        this.bHl = bHi();
    }

    public void setDefaultGradientColor() {
        bHh();
        invalidate();
    }

    private LinearGradient bHi() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bKi;
        int i4 = this.bOY;
        if (skinType == 4) {
            i = this.fGV;
            i2 = this.fGW;
        } else if (skinType == 1) {
            i = this.fGT;
            i2 = this.fGU;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bHl = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.fGX.setShader(this.bHl);
        this.mSkinType = skinType;
        return this.bHl;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bHl = bHi();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bKi));
        arrayList.add(Integer.valueOf(this.bOY));
        arrayList.add(Integer.valueOf(this.fGT));
        arrayList.add(Integer.valueOf(this.fGU));
        arrayList.add(Integer.valueOf(this.fGV));
        arrayList.add(Integer.valueOf(this.fGW));
        return arrayList;
    }
}

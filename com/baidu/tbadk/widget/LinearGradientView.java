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
/* loaded from: classes3.dex */
public class LinearGradientView extends View {
    private int cER;
    private int cES;
    private int cET;
    private int cEU;
    private LinearGradient cEV;
    private final Paint cEW;
    private int cEX;
    private int cEY;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cEW = new Paint();
        this.mRadius = 0;
        this.cEY = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cEW = new Paint();
        this.mRadius = 0;
        this.cEY = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cEW = new Paint();
        this.mRadius = 0;
        this.cEY = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        axn();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.cEV = axo();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cEW == null) {
            this.cEV = axo();
        }
        int width = getWidth();
        int height = getHeight();
        axm();
        if (this.cEY == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cEW);
        } else {
            canvas.drawPath(this.mPath, this.cEW);
        }
    }

    private void axm() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cEX != this.mRadius) && this.cEY != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cEX = this.mRadius;
            this.mPath.reset();
            switch (this.cEY) {
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
        this.cEY = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.cER = i;
        this.cES = i2;
        this.cET = i3;
        this.cEU = i4;
        this.cEV = axo();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.cER != com.baidu.tieba.lego.card.d.a.cE(str) || this.cES != com.baidu.tieba.lego.card.d.a.cE(str2) || this.cET != com.baidu.tieba.lego.card.d.a.cE(str3) || this.cEU != com.baidu.tieba.lego.card.d.a.cE(str4)) {
            this.cER = com.baidu.tieba.lego.card.d.a.cE(str);
            this.cES = com.baidu.tieba.lego.card.d.a.cE(str2);
            this.cET = com.baidu.tieba.lego.card.d.a.cE(str3);
            this.cEU = com.baidu.tieba.lego.card.d.a.cE(str4);
            this.cEV = axo();
            invalidate();
        }
    }

    private void axn() {
        this.cER = com.baidu.tieba.lego.card.d.a.cE("#2BB8FF");
        this.cES = com.baidu.tieba.lego.card.d.a.cE("#2BB8FF");
        this.cET = com.baidu.tieba.lego.card.d.a.cE("#249BD6");
        this.cEU = com.baidu.tieba.lego.card.d.a.cE("#246CD6");
        this.cEV = axo();
    }

    public void setDefaultGradientColor() {
        axn();
        invalidate();
    }

    private LinearGradient axo() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1;
        this.cEV = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cET : this.cER, z ? this.cEU : this.cES}, (float[]) null, Shader.TileMode.CLAMP);
        this.cEW.setShader(this.cEV);
        this.mSkinType = skinType;
        return this.cEV;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cEV = axo();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.cER));
        arrayList.add(Integer.valueOf(this.cES));
        arrayList.add(Integer.valueOf(this.cET));
        arrayList.add(Integer.valueOf(this.cEU));
        return arrayList;
    }
}

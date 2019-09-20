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
    private int cFO;
    private int cFP;
    private int cFQ;
    private int cFR;
    private LinearGradient cFS;
    private final Paint cFT;
    private int cFU;
    private int cFV;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cFT = new Paint();
        this.mRadius = 0;
        this.cFV = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cFT = new Paint();
        this.mRadius = 0;
        this.cFV = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cFT = new Paint();
        this.mRadius = 0;
        this.cFV = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        axB();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.cFS = axC();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cFT == null) {
            this.cFS = axC();
        }
        int width = getWidth();
        int height = getHeight();
        axA();
        if (this.cFV == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cFT);
        } else {
            canvas.drawPath(this.mPath, this.cFT);
        }
    }

    private void axA() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cFU != this.mRadius) && this.cFV != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cFU = this.mRadius;
            this.mPath.reset();
            switch (this.cFV) {
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
        this.cFV = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.cFO = i;
        this.cFP = i2;
        this.cFQ = i3;
        this.cFR = i4;
        this.cFS = axC();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.cFO != com.baidu.tieba.lego.card.d.a.cE(str) || this.cFP != com.baidu.tieba.lego.card.d.a.cE(str2) || this.cFQ != com.baidu.tieba.lego.card.d.a.cE(str3) || this.cFR != com.baidu.tieba.lego.card.d.a.cE(str4)) {
            this.cFO = com.baidu.tieba.lego.card.d.a.cE(str);
            this.cFP = com.baidu.tieba.lego.card.d.a.cE(str2);
            this.cFQ = com.baidu.tieba.lego.card.d.a.cE(str3);
            this.cFR = com.baidu.tieba.lego.card.d.a.cE(str4);
            this.cFS = axC();
            invalidate();
        }
    }

    private void axB() {
        this.cFO = com.baidu.tieba.lego.card.d.a.cE("#2BB8FF");
        this.cFP = com.baidu.tieba.lego.card.d.a.cE("#2BB8FF");
        this.cFQ = com.baidu.tieba.lego.card.d.a.cE("#249BD6");
        this.cFR = com.baidu.tieba.lego.card.d.a.cE("#246CD6");
        this.cFS = axC();
    }

    public void setDefaultGradientColor() {
        axB();
        invalidate();
    }

    private LinearGradient axC() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1 || skinType == 4;
        this.cFS = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cFQ : this.cFO, z ? this.cFR : this.cFP}, (float[]) null, Shader.TileMode.CLAMP);
        this.cFT.setShader(this.cFS);
        this.mSkinType = skinType;
        return this.cFS;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cFS = axC();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.cFO));
        arrayList.add(Integer.valueOf(this.cFP));
        arrayList.add(Integer.valueOf(this.cFQ));
        arrayList.add(Integer.valueOf(this.cFR));
        return arrayList;
    }
}

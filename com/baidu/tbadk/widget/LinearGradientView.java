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
    private int cDA;
    private LinearGradient cDB;
    private final Paint cDC;
    private int cDD;
    private int cDE;
    private int cDx;
    private int cDy;
    private int cDz;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cDC = new Paint();
        this.mRadius = 0;
        this.cDE = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cDC = new Paint();
        this.mRadius = 0;
        this.cDE = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cDC = new Paint();
        this.mRadius = 0;
        this.cDE = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        awc();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.cDB = awd();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cDC == null) {
            this.cDB = awd();
        }
        int width = getWidth();
        int height = getHeight();
        awb();
        if (this.cDE == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cDC);
        } else {
            canvas.drawPath(this.mPath, this.cDC);
        }
    }

    private void awb() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cDD != this.mRadius) && this.cDE != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cDD = this.mRadius;
            this.mPath.reset();
            switch (this.cDE) {
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
        this.cDE = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.cDx = i;
        this.cDy = i2;
        this.cDz = i3;
        this.cDA = i4;
        this.cDB = awd();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.cDx != com.baidu.tieba.lego.card.d.a.parseColor(str) || this.cDy != com.baidu.tieba.lego.card.d.a.parseColor(str2) || this.cDz != com.baidu.tieba.lego.card.d.a.parseColor(str3) || this.cDA != com.baidu.tieba.lego.card.d.a.parseColor(str4)) {
            this.cDx = com.baidu.tieba.lego.card.d.a.parseColor(str);
            this.cDy = com.baidu.tieba.lego.card.d.a.parseColor(str2);
            this.cDz = com.baidu.tieba.lego.card.d.a.parseColor(str3);
            this.cDA = com.baidu.tieba.lego.card.d.a.parseColor(str4);
            this.cDB = awd();
            invalidate();
        }
    }

    private void awc() {
        this.cDx = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cDy = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cDz = com.baidu.tieba.lego.card.d.a.parseColor("#249BD6");
        this.cDA = com.baidu.tieba.lego.card.d.a.parseColor("#246CD6");
        this.cDB = awd();
    }

    public void setDefaultGradientColor() {
        awc();
        invalidate();
    }

    private LinearGradient awd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1;
        this.cDB = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cDz : this.cDx, z ? this.cDA : this.cDy}, (float[]) null, Shader.TileMode.CLAMP);
        this.cDC.setShader(this.cDB);
        this.mSkinType = skinType;
        return this.cDB;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cDB = awd();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.cDx));
        arrayList.add(Integer.valueOf(this.cDy));
        arrayList.add(Integer.valueOf(this.cDz));
        arrayList.add(Integer.valueOf(this.cDA));
        return arrayList;
    }
}

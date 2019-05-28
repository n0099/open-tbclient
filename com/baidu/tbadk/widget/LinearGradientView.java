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
    private LinearGradient cDA;
    private final Paint cDB;
    private int cDC;
    private int cDD;
    private int cDw;
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
        this.cDB = new Paint();
        this.mRadius = 0;
        this.cDD = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cDB = new Paint();
        this.mRadius = 0;
        this.cDD = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cDB = new Paint();
        this.mRadius = 0;
        this.cDD = 0;
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
            this.cDA = awd();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cDB == null) {
            this.cDA = awd();
        }
        int width = getWidth();
        int height = getHeight();
        awb();
        if (this.cDD == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cDB);
        } else {
            canvas.drawPath(this.mPath, this.cDB);
        }
    }

    private void awb() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cDC != this.mRadius) && this.cDD != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cDC = this.mRadius;
            this.mPath.reset();
            switch (this.cDD) {
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
        this.cDD = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.cDw = i;
        this.cDx = i2;
        this.cDy = i3;
        this.cDz = i4;
        this.cDA = awd();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.cDw != com.baidu.tieba.lego.card.d.a.parseColor(str) || this.cDx != com.baidu.tieba.lego.card.d.a.parseColor(str2) || this.cDy != com.baidu.tieba.lego.card.d.a.parseColor(str3) || this.cDz != com.baidu.tieba.lego.card.d.a.parseColor(str4)) {
            this.cDw = com.baidu.tieba.lego.card.d.a.parseColor(str);
            this.cDx = com.baidu.tieba.lego.card.d.a.parseColor(str2);
            this.cDy = com.baidu.tieba.lego.card.d.a.parseColor(str3);
            this.cDz = com.baidu.tieba.lego.card.d.a.parseColor(str4);
            this.cDA = awd();
            invalidate();
        }
    }

    private void awc() {
        this.cDw = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cDx = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cDy = com.baidu.tieba.lego.card.d.a.parseColor("#249BD6");
        this.cDz = com.baidu.tieba.lego.card.d.a.parseColor("#246CD6");
        this.cDA = awd();
    }

    public void setDefaultGradientColor() {
        awc();
        invalidate();
    }

    private LinearGradient awd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1;
        this.cDA = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cDy : this.cDw, z ? this.cDz : this.cDx}, (float[]) null, Shader.TileMode.CLAMP);
        this.cDB.setShader(this.cDA);
        this.mSkinType = skinType;
        return this.cDA;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cDA = awd();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.cDw));
        arrayList.add(Integer.valueOf(this.cDx));
        arrayList.add(Integer.valueOf(this.cDy));
        arrayList.add(Integer.valueOf(this.cDz));
        return arrayList;
    }
}

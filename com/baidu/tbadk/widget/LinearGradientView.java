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
    private int cEY;
    private int cEZ;
    private int cFa;
    private int cFb;
    private LinearGradient cFc;
    private final Paint cFd;
    private int cFe;
    private int cFf;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cFd = new Paint();
        this.mRadius = 0;
        this.cFf = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cFd = new Paint();
        this.mRadius = 0;
        this.cFf = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cFd = new Paint();
        this.mRadius = 0;
        this.cFf = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        axp();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.cFc = axq();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cFd == null) {
            this.cFc = axq();
        }
        int width = getWidth();
        int height = getHeight();
        axo();
        if (this.cFf == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cFd);
        } else {
            canvas.drawPath(this.mPath, this.cFd);
        }
    }

    private void axo() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cFe != this.mRadius) && this.cFf != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cFe = this.mRadius;
            this.mPath.reset();
            switch (this.cFf) {
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
        this.cFf = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.cEY = i;
        this.cEZ = i2;
        this.cFa = i3;
        this.cFb = i4;
        this.cFc = axq();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.cEY != com.baidu.tieba.lego.card.d.a.cE(str) || this.cEZ != com.baidu.tieba.lego.card.d.a.cE(str2) || this.cFa != com.baidu.tieba.lego.card.d.a.cE(str3) || this.cFb != com.baidu.tieba.lego.card.d.a.cE(str4)) {
            this.cEY = com.baidu.tieba.lego.card.d.a.cE(str);
            this.cEZ = com.baidu.tieba.lego.card.d.a.cE(str2);
            this.cFa = com.baidu.tieba.lego.card.d.a.cE(str3);
            this.cFb = com.baidu.tieba.lego.card.d.a.cE(str4);
            this.cFc = axq();
            invalidate();
        }
    }

    private void axp() {
        this.cEY = com.baidu.tieba.lego.card.d.a.cE("#2BB8FF");
        this.cEZ = com.baidu.tieba.lego.card.d.a.cE("#2BB8FF");
        this.cFa = com.baidu.tieba.lego.card.d.a.cE("#249BD6");
        this.cFb = com.baidu.tieba.lego.card.d.a.cE("#246CD6");
        this.cFc = axq();
    }

    public void setDefaultGradientColor() {
        axp();
        invalidate();
    }

    private LinearGradient axq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1;
        this.cFc = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cFa : this.cEY, z ? this.cFb : this.cEZ}, (float[]) null, Shader.TileMode.CLAMP);
        this.cFd.setShader(this.cFc);
        this.mSkinType = skinType;
        return this.cFc;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cFc = axq();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.cEY));
        arrayList.add(Integer.valueOf(this.cEZ));
        arrayList.add(Integer.valueOf(this.cFa));
        arrayList.add(Integer.valueOf(this.cFb));
        return arrayList;
    }
}

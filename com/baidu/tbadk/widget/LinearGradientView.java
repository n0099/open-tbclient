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
    private LinearGradient aoV;
    private int arN;
    private int arb;
    private int cPh;
    private int cPi;
    private final Paint cPj;
    private int cPk;
    private int cPl;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cPj = new Paint();
        this.mRadius = 0;
        this.cPl = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cPj = new Paint();
        this.mRadius = 0;
        this.cPl = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cPj = new Paint();
        this.mRadius = 0;
        this.cPl = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aye();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.aoV = ayf();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cPj == null) {
            this.aoV = ayf();
        }
        int width = getWidth();
        int height = getHeight();
        ayd();
        if (this.cPl == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cPj);
        } else {
            canvas.drawPath(this.mPath, this.cPj);
        }
    }

    private void ayd() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cPk != this.mRadius) && this.cPl != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cPk = this.mRadius;
            this.mPath.reset();
            switch (this.cPl) {
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
        this.cPl = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.arb = i;
        this.arN = i2;
        this.cPh = i3;
        this.cPi = i4;
        this.aoV = ayf();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.arb != com.baidu.tieba.lego.card.d.a.bR(str) || this.arN != com.baidu.tieba.lego.card.d.a.bR(str2) || this.cPh != com.baidu.tieba.lego.card.d.a.bR(str3) || this.cPi != com.baidu.tieba.lego.card.d.a.bR(str4)) {
            this.arb = com.baidu.tieba.lego.card.d.a.bR(str);
            this.arN = com.baidu.tieba.lego.card.d.a.bR(str2);
            this.cPh = com.baidu.tieba.lego.card.d.a.bR(str3);
            this.cPi = com.baidu.tieba.lego.card.d.a.bR(str4);
            this.aoV = ayf();
            invalidate();
        }
    }

    private void aye() {
        this.arb = com.baidu.tieba.lego.card.d.a.bR("#2BB8FF");
        this.arN = com.baidu.tieba.lego.card.d.a.bR("#2BB8FF");
        this.cPh = com.baidu.tieba.lego.card.d.a.bR("#249BD6");
        this.cPi = com.baidu.tieba.lego.card.d.a.bR("#246CD6");
        this.aoV = ayf();
    }

    public void setDefaultGradientColor() {
        aye();
        invalidate();
    }

    private LinearGradient ayf() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1 || skinType == 4;
        this.aoV = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cPh : this.arb, z ? this.cPi : this.arN}, (float[]) null, Shader.TileMode.CLAMP);
        this.cPj.setShader(this.aoV);
        this.mSkinType = skinType;
        return this.aoV;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aoV = ayf();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.arb));
        arrayList.add(Integer.valueOf(this.arN));
        arrayList.add(Integer.valueOf(this.cPh));
        arrayList.add(Integer.valueOf(this.cPi));
        return arrayList;
    }
}

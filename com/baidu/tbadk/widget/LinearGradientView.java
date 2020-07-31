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
/* loaded from: classes15.dex */
public class LinearGradientView extends View {
    private LinearGradient biK;
    private int bkT;
    private int bny;
    private int eLD;
    private int eLE;
    private int eLF;
    private int eLG;
    private final Paint eLH;
    private int eLI;
    private int eLJ;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eLH = new Paint();
        this.mRadius = 0;
        this.eLJ = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eLH = new Paint();
        this.mRadius = 0;
        this.eLJ = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eLH = new Paint();
        this.mRadius = 0;
        this.eLJ = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bnn();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.biK = bno();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bnm();
        if (this.eLJ == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.eLH);
        } else {
            canvas.drawPath(this.mPath, this.eLH);
        }
    }

    private void bnm() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.eLI != this.mRadius) && this.eLJ != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.eLI = this.mRadius;
            this.mPath.reset();
            switch (this.eLJ) {
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
        this.eLJ = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bkT = i;
        this.bny = i2;
        this.eLD = i3;
        this.eLE = i4;
        this.eLF = i5;
        this.eLG = i6;
        this.biK = bno();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bkT != com.baidu.tieba.lego.card.d.a.dU(str) || this.bny != com.baidu.tieba.lego.card.d.a.dU(str2) || this.eLD != com.baidu.tieba.lego.card.d.a.dU(str3) || this.eLE != com.baidu.tieba.lego.card.d.a.dU(str4) || this.eLF != com.baidu.tieba.lego.card.d.a.dU(str5) || this.eLG != com.baidu.tieba.lego.card.d.a.dU(str6)) {
            this.bkT = com.baidu.tieba.lego.card.d.a.dU(str);
            this.bny = com.baidu.tieba.lego.card.d.a.dU(str2);
            this.eLD = com.baidu.tieba.lego.card.d.a.dU(str3);
            this.eLE = com.baidu.tieba.lego.card.d.a.dU(str4);
            this.eLF = com.baidu.tieba.lego.card.d.a.dU(str5);
            this.eLG = com.baidu.tieba.lego.card.d.a.dU(str6);
            this.biK = bno();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int dU;
        int i;
        int dU2;
        int i2;
        int dU3;
        int dU4;
        if (themeElement == null) {
            int dU5 = com.baidu.tieba.lego.card.d.a.dU("#2BB8FF");
            dU = com.baidu.tieba.lego.card.d.a.dU("#2BB8FF");
            i = dU5;
        } else {
            int dU6 = com.baidu.tieba.lego.card.d.a.dU(themeElement.common_color);
            dU = com.baidu.tieba.lego.card.d.a.dU(themeElement.common_color);
            i = dU6;
        }
        if (themeElement2 == null) {
            int dU7 = com.baidu.tieba.lego.card.d.a.dU("#249BD6");
            dU2 = com.baidu.tieba.lego.card.d.a.dU("#246CD6");
            i2 = dU7;
        } else {
            int dU8 = com.baidu.tieba.lego.card.d.a.dU(themeElement2.common_color);
            dU2 = com.baidu.tieba.lego.card.d.a.dU(themeElement2.common_color);
            i2 = dU8;
        }
        if (themeElement3 == null) {
            dU3 = com.baidu.tieba.lego.card.d.a.dU("#249BD6");
            dU4 = com.baidu.tieba.lego.card.d.a.dU("#246CD6");
        } else {
            dU3 = com.baidu.tieba.lego.card.d.a.dU(themeElement3.common_color);
            dU4 = com.baidu.tieba.lego.card.d.a.dU(themeElement3.common_color);
        }
        this.bkT = i;
        this.bny = dU;
        this.eLD = i2;
        this.eLE = dU2;
        this.eLF = dU3;
        this.eLG = dU4;
        this.biK = bno();
        invalidate();
    }

    private void bnn() {
        this.bkT = com.baidu.tieba.lego.card.d.a.dU("#2BB8FF");
        this.bny = com.baidu.tieba.lego.card.d.a.dU("#2BB8FF");
        this.eLD = com.baidu.tieba.lego.card.d.a.dU("#249BD6");
        this.eLE = com.baidu.tieba.lego.card.d.a.dU("#246CD6");
        this.eLF = com.baidu.tieba.lego.card.d.a.dU("#249BD6");
        this.eLG = com.baidu.tieba.lego.card.d.a.dU("#246CD6");
        this.biK = bno();
    }

    public void setDefaultGradientColor() {
        bnn();
        invalidate();
    }

    private LinearGradient bno() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bkT;
        int i4 = this.bny;
        if (skinType == 4) {
            i = this.eLF;
            i2 = this.eLG;
        } else if (skinType == 1) {
            i = this.eLD;
            i2 = this.eLE;
        } else {
            i = i3;
            i2 = i4;
        }
        this.biK = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.eLH.setShader(this.biK);
        this.mSkinType = skinType;
        return this.biK;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.biK = bno();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bkT));
        arrayList.add(Integer.valueOf(this.bny));
        arrayList.add(Integer.valueOf(this.eLD));
        arrayList.add(Integer.valueOf(this.eLE));
        arrayList.add(Integer.valueOf(this.eLF));
        arrayList.add(Integer.valueOf(this.eLG));
        return arrayList;
    }
}

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
    private LinearGradient bop;
    private int bqz;
    private int btd;
    private int eWj;
    private int eWk;
    private int eWl;
    private int eWm;
    private final Paint eWn;
    private int eWo;
    private int eWp;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eWn = new Paint();
        this.mRadius = 0;
        this.eWp = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eWn = new Paint();
        this.mRadius = 0;
        this.eWp = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eWn = new Paint();
        this.mRadius = 0;
        this.eWp = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bwb();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bop = bwc();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bwa();
        if (this.eWp == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.eWn);
        } else {
            canvas.drawPath(this.mPath, this.eWn);
        }
    }

    private void bwa() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.eWo != this.mRadius) && this.eWp != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.eWo = this.mRadius;
            this.mPath.reset();
            switch (this.eWp) {
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
        this.eWp = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bqz = i;
        this.btd = i2;
        this.eWj = i3;
        this.eWk = i4;
        this.eWl = i5;
        this.eWm = i6;
        this.bop = bwc();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bqz != com.baidu.tieba.lego.card.d.b.fn(str) || this.btd != com.baidu.tieba.lego.card.d.b.fn(str2) || this.eWj != com.baidu.tieba.lego.card.d.b.fn(str3) || this.eWk != com.baidu.tieba.lego.card.d.b.fn(str4) || this.eWl != com.baidu.tieba.lego.card.d.b.fn(str5) || this.eWm != com.baidu.tieba.lego.card.d.b.fn(str6)) {
            this.bqz = com.baidu.tieba.lego.card.d.b.fn(str);
            this.btd = com.baidu.tieba.lego.card.d.b.fn(str2);
            this.eWj = com.baidu.tieba.lego.card.d.b.fn(str3);
            this.eWk = com.baidu.tieba.lego.card.d.b.fn(str4);
            this.eWl = com.baidu.tieba.lego.card.d.b.fn(str5);
            this.eWm = com.baidu.tieba.lego.card.d.b.fn(str6);
            this.bop = bwc();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int fn;
        int i;
        int fn2;
        int i2;
        int fn3;
        int fn4;
        if (themeElement == null) {
            int fn5 = com.baidu.tieba.lego.card.d.b.fn("#2BB8FF");
            fn = com.baidu.tieba.lego.card.d.b.fn("#2BB8FF");
            i = fn5;
        } else {
            int fn6 = com.baidu.tieba.lego.card.d.b.fn(themeElement.common_color);
            fn = com.baidu.tieba.lego.card.d.b.fn(themeElement.common_color);
            i = fn6;
        }
        if (themeElement2 == null) {
            int fn7 = com.baidu.tieba.lego.card.d.b.fn("#249BD6");
            fn2 = com.baidu.tieba.lego.card.d.b.fn("#246CD6");
            i2 = fn7;
        } else {
            int fn8 = com.baidu.tieba.lego.card.d.b.fn(themeElement2.common_color);
            fn2 = com.baidu.tieba.lego.card.d.b.fn(themeElement2.common_color);
            i2 = fn8;
        }
        if (themeElement3 == null) {
            fn3 = com.baidu.tieba.lego.card.d.b.fn("#249BD6");
            fn4 = com.baidu.tieba.lego.card.d.b.fn("#246CD6");
        } else {
            fn3 = com.baidu.tieba.lego.card.d.b.fn(themeElement3.common_color);
            fn4 = com.baidu.tieba.lego.card.d.b.fn(themeElement3.common_color);
        }
        this.bqz = i;
        this.btd = fn;
        this.eWj = i2;
        this.eWk = fn2;
        this.eWl = fn3;
        this.eWm = fn4;
        this.bop = bwc();
        invalidate();
    }

    private void bwb() {
        this.bqz = com.baidu.tieba.lego.card.d.b.fn("#2BB8FF");
        this.btd = com.baidu.tieba.lego.card.d.b.fn("#2BB8FF");
        this.eWj = com.baidu.tieba.lego.card.d.b.fn("#249BD6");
        this.eWk = com.baidu.tieba.lego.card.d.b.fn("#246CD6");
        this.eWl = com.baidu.tieba.lego.card.d.b.fn("#249BD6");
        this.eWm = com.baidu.tieba.lego.card.d.b.fn("#246CD6");
        this.bop = bwc();
    }

    public void setDefaultGradientColor() {
        bwb();
        invalidate();
    }

    private LinearGradient bwc() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bqz;
        int i4 = this.btd;
        if (skinType == 4) {
            i = this.eWl;
            i2 = this.eWm;
        } else if (skinType == 1) {
            i = this.eWj;
            i2 = this.eWk;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bop = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.eWn.setShader(this.bop);
        this.mSkinType = skinType;
        return this.bop;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bop = bwc();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bqz));
        arrayList.add(Integer.valueOf(this.btd));
        arrayList.add(Integer.valueOf(this.eWj));
        arrayList.add(Integer.valueOf(this.eWk));
        arrayList.add(Integer.valueOf(this.eWl));
        arrayList.add(Integer.valueOf(this.eWm));
        return arrayList;
    }
}

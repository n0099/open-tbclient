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
    private int bDa;
    private LinearGradient bvp;
    private int bxx;
    private int flq;
    private int flr;
    private int fls;
    private int flt;
    private final Paint flu;
    private int flv;
    private int flw;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.flu = new Paint();
        this.mRadius = 0;
        this.flw = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.flu = new Paint();
        this.mRadius = 0;
        this.flw = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.flu = new Paint();
        this.mRadius = 0;
        this.flw = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bzV();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bvp = bzW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bzU();
        if (this.flw == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.flu);
        } else {
            canvas.drawPath(this.mPath, this.flu);
        }
    }

    private void bzU() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.flv != this.mRadius) && this.flw != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.flv = this.mRadius;
            this.mPath.reset();
            switch (this.flw) {
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
        this.flw = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bxx = i;
        this.bDa = i2;
        this.flq = i3;
        this.flr = i4;
        this.fls = i5;
        this.flt = i6;
        this.bvp = bzW();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bxx != com.baidu.tieba.lego.card.d.b.fv(str) || this.bDa != com.baidu.tieba.lego.card.d.b.fv(str2) || this.flq != com.baidu.tieba.lego.card.d.b.fv(str3) || this.flr != com.baidu.tieba.lego.card.d.b.fv(str4) || this.fls != com.baidu.tieba.lego.card.d.b.fv(str5) || this.flt != com.baidu.tieba.lego.card.d.b.fv(str6)) {
            this.bxx = com.baidu.tieba.lego.card.d.b.fv(str);
            this.bDa = com.baidu.tieba.lego.card.d.b.fv(str2);
            this.flq = com.baidu.tieba.lego.card.d.b.fv(str3);
            this.flr = com.baidu.tieba.lego.card.d.b.fv(str4);
            this.fls = com.baidu.tieba.lego.card.d.b.fv(str5);
            this.flt = com.baidu.tieba.lego.card.d.b.fv(str6);
            this.bvp = bzW();
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
        this.bxx = i;
        this.bDa = fv;
        this.flq = i2;
        this.flr = fv2;
        this.fls = fv3;
        this.flt = fv4;
        this.bvp = bzW();
        invalidate();
    }

    private void bzV() {
        this.bxx = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
        this.bDa = com.baidu.tieba.lego.card.d.b.fv("#2BB8FF");
        this.flq = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
        this.flr = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
        this.fls = com.baidu.tieba.lego.card.d.b.fv("#249BD6");
        this.flt = com.baidu.tieba.lego.card.d.b.fv("#246CD6");
        this.bvp = bzW();
    }

    public void setDefaultGradientColor() {
        bzV();
        invalidate();
    }

    private LinearGradient bzW() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bxx;
        int i4 = this.bDa;
        if (skinType == 4) {
            i = this.fls;
            i2 = this.flt;
        } else if (skinType == 1) {
            i = this.flq;
            i2 = this.flr;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bvp = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.flu.setShader(this.bvp);
        this.mSkinType = skinType;
        return this.bvp;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bvp = bzW();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bxx));
        arrayList.add(Integer.valueOf(this.bDa));
        arrayList.add(Integer.valueOf(this.flq));
        arrayList.add(Integer.valueOf(this.flr));
        arrayList.add(Integer.valueOf(this.fls));
        arrayList.add(Integer.valueOf(this.flt));
        return arrayList;
    }
}

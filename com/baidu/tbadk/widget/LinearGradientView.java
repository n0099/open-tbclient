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
/* loaded from: classes6.dex */
public class LinearGradientView extends View {
    private int aAh;
    private LinearGradient axx;
    private int azx;
    private int dDo;
    private int dDp;
    private int dDq;
    private int dDr;
    private final Paint dDs;
    private int dDt;
    private int dDu;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dDs = new Paint();
        this.mRadius = 0;
        this.dDu = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dDs = new Paint();
        this.mRadius = 0;
        this.dDu = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dDs = new Paint();
        this.mRadius = 0;
        this.dDu = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aQp();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.axx = aQq();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        aQo();
        if (this.dDu == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.dDs);
        } else {
            canvas.drawPath(this.mPath, this.dDs);
        }
    }

    private void aQo() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.dDt != this.mRadius) && this.dDu != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.dDt = this.mRadius;
            this.mPath.reset();
            switch (this.dDu) {
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
        this.dDu = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.azx = i;
        this.aAh = i2;
        this.dDo = i3;
        this.dDp = i4;
        this.dDq = i5;
        this.dDr = i6;
        this.axx = aQq();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.azx != com.baidu.tieba.lego.card.d.a.cy(str) || this.aAh != com.baidu.tieba.lego.card.d.a.cy(str2) || this.dDo != com.baidu.tieba.lego.card.d.a.cy(str3) || this.dDp != com.baidu.tieba.lego.card.d.a.cy(str4) || this.dDq != com.baidu.tieba.lego.card.d.a.cy(str5) || this.dDr != com.baidu.tieba.lego.card.d.a.cy(str6)) {
            this.azx = com.baidu.tieba.lego.card.d.a.cy(str);
            this.aAh = com.baidu.tieba.lego.card.d.a.cy(str2);
            this.dDo = com.baidu.tieba.lego.card.d.a.cy(str3);
            this.dDp = com.baidu.tieba.lego.card.d.a.cy(str4);
            this.dDq = com.baidu.tieba.lego.card.d.a.cy(str5);
            this.dDr = com.baidu.tieba.lego.card.d.a.cy(str6);
            this.axx = aQq();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int cy;
        int i;
        int cy2;
        int i2;
        int cy3;
        int cy4;
        if (themeElement == null) {
            int cy5 = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
            cy = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
            i = cy5;
        } else {
            int cy6 = com.baidu.tieba.lego.card.d.a.cy(themeElement.common_color);
            cy = com.baidu.tieba.lego.card.d.a.cy(themeElement.common_color);
            i = cy6;
        }
        if (themeElement2 == null) {
            int cy7 = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
            cy2 = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
            i2 = cy7;
        } else {
            int cy8 = com.baidu.tieba.lego.card.d.a.cy(themeElement2.common_color);
            cy2 = com.baidu.tieba.lego.card.d.a.cy(themeElement2.common_color);
            i2 = cy8;
        }
        if (themeElement3 == null) {
            cy3 = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
            cy4 = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
        } else {
            cy3 = com.baidu.tieba.lego.card.d.a.cy(themeElement3.common_color);
            cy4 = com.baidu.tieba.lego.card.d.a.cy(themeElement3.common_color);
        }
        if (this.azx != i || this.aAh != cy || this.dDo != i2 || this.dDp != cy2 || this.dDq != cy3 || this.dDr != cy4) {
            this.azx = i;
            this.aAh = cy;
            this.dDo = i2;
            this.dDp = cy2;
            this.dDq = cy3;
            this.dDr = cy4;
            this.axx = aQq();
            invalidate();
        }
    }

    private void aQp() {
        this.azx = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
        this.aAh = com.baidu.tieba.lego.card.d.a.cy("#2BB8FF");
        this.dDo = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
        this.dDp = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
        this.dDq = com.baidu.tieba.lego.card.d.a.cy("#249BD6");
        this.dDr = com.baidu.tieba.lego.card.d.a.cy("#246CD6");
        this.axx = aQq();
    }

    public void setDefaultGradientColor() {
        aQp();
        invalidate();
    }

    private LinearGradient aQq() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.azx;
        int i4 = this.aAh;
        if (skinType == 4) {
            i = this.dDq;
            i2 = this.dDr;
        } else if (skinType == 1) {
            i = this.dDo;
            i2 = this.dDp;
        } else {
            i = i3;
            i2 = i4;
        }
        this.axx = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.dDs.setShader(this.axx);
        this.mSkinType = skinType;
        return this.axx;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.axx = aQq();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.azx));
        arrayList.add(Integer.valueOf(this.aAh));
        arrayList.add(Integer.valueOf(this.dDo));
        arrayList.add(Integer.valueOf(this.dDp));
        arrayList.add(Integer.valueOf(this.dDq));
        arrayList.add(Integer.valueOf(this.dDr));
        return arrayList;
    }
}

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
    private LinearGradient bos;
    private int bqC;
    private int btg;
    private int eWn;
    private int eWo;
    private int eWp;
    private int eWq;
    private final Paint eWr;
    private int eWs;
    private int eWt;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eWr = new Paint();
        this.mRadius = 0;
        this.eWt = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eWr = new Paint();
        this.mRadius = 0;
        this.eWt = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eWr = new Paint();
        this.mRadius = 0;
        this.eWt = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bwc();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bos = bwd();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bwb();
        if (this.eWt == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.eWr);
        } else {
            canvas.drawPath(this.mPath, this.eWr);
        }
    }

    private void bwb() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.eWs != this.mRadius) && this.eWt != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.eWs = this.mRadius;
            this.mPath.reset();
            switch (this.eWt) {
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
        this.eWt = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bqC = i;
        this.btg = i2;
        this.eWn = i3;
        this.eWo = i4;
        this.eWp = i5;
        this.eWq = i6;
        this.bos = bwd();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bqC != com.baidu.tieba.lego.card.d.b.fo(str) || this.btg != com.baidu.tieba.lego.card.d.b.fo(str2) || this.eWn != com.baidu.tieba.lego.card.d.b.fo(str3) || this.eWo != com.baidu.tieba.lego.card.d.b.fo(str4) || this.eWp != com.baidu.tieba.lego.card.d.b.fo(str5) || this.eWq != com.baidu.tieba.lego.card.d.b.fo(str6)) {
            this.bqC = com.baidu.tieba.lego.card.d.b.fo(str);
            this.btg = com.baidu.tieba.lego.card.d.b.fo(str2);
            this.eWn = com.baidu.tieba.lego.card.d.b.fo(str3);
            this.eWo = com.baidu.tieba.lego.card.d.b.fo(str4);
            this.eWp = com.baidu.tieba.lego.card.d.b.fo(str5);
            this.eWq = com.baidu.tieba.lego.card.d.b.fo(str6);
            this.bos = bwd();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int fo;
        int i;
        int fo2;
        int i2;
        int fo3;
        int fo4;
        if (themeElement == null) {
            int fo5 = com.baidu.tieba.lego.card.d.b.fo("#2BB8FF");
            fo = com.baidu.tieba.lego.card.d.b.fo("#2BB8FF");
            i = fo5;
        } else {
            int fo6 = com.baidu.tieba.lego.card.d.b.fo(themeElement.common_color);
            fo = com.baidu.tieba.lego.card.d.b.fo(themeElement.common_color);
            i = fo6;
        }
        if (themeElement2 == null) {
            int fo7 = com.baidu.tieba.lego.card.d.b.fo("#249BD6");
            fo2 = com.baidu.tieba.lego.card.d.b.fo("#246CD6");
            i2 = fo7;
        } else {
            int fo8 = com.baidu.tieba.lego.card.d.b.fo(themeElement2.common_color);
            fo2 = com.baidu.tieba.lego.card.d.b.fo(themeElement2.common_color);
            i2 = fo8;
        }
        if (themeElement3 == null) {
            fo3 = com.baidu.tieba.lego.card.d.b.fo("#249BD6");
            fo4 = com.baidu.tieba.lego.card.d.b.fo("#246CD6");
        } else {
            fo3 = com.baidu.tieba.lego.card.d.b.fo(themeElement3.common_color);
            fo4 = com.baidu.tieba.lego.card.d.b.fo(themeElement3.common_color);
        }
        this.bqC = i;
        this.btg = fo;
        this.eWn = i2;
        this.eWo = fo2;
        this.eWp = fo3;
        this.eWq = fo4;
        this.bos = bwd();
        invalidate();
    }

    private void bwc() {
        this.bqC = com.baidu.tieba.lego.card.d.b.fo("#2BB8FF");
        this.btg = com.baidu.tieba.lego.card.d.b.fo("#2BB8FF");
        this.eWn = com.baidu.tieba.lego.card.d.b.fo("#249BD6");
        this.eWo = com.baidu.tieba.lego.card.d.b.fo("#246CD6");
        this.eWp = com.baidu.tieba.lego.card.d.b.fo("#249BD6");
        this.eWq = com.baidu.tieba.lego.card.d.b.fo("#246CD6");
        this.bos = bwd();
    }

    public void setDefaultGradientColor() {
        bwc();
        invalidate();
    }

    private LinearGradient bwd() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bqC;
        int i4 = this.btg;
        if (skinType == 4) {
            i = this.eWp;
            i2 = this.eWq;
        } else if (skinType == 1) {
            i = this.eWn;
            i2 = this.eWo;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bos = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.eWr.setShader(this.bos);
        this.mSkinType = skinType;
        return this.bos;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bos = bwd();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bqC));
        arrayList.add(Integer.valueOf(this.btg));
        arrayList.add(Integer.valueOf(this.eWn));
        arrayList.add(Integer.valueOf(this.eWo));
        arrayList.add(Integer.valueOf(this.eWp));
        arrayList.add(Integer.valueOf(this.eWq));
        return arrayList;
    }
}

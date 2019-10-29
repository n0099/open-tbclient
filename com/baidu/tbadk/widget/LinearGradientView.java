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
    private LinearGradient apn;
    private int art;
    private int asf;
    private int cPY;
    private int cPZ;
    private final Paint cQa;
    private int cQb;
    private int cQc;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cQa = new Paint();
        this.mRadius = 0;
        this.cQc = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cQa = new Paint();
        this.mRadius = 0;
        this.cQc = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cQa = new Paint();
        this.mRadius = 0;
        this.cQc = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        ayg();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.apn = ayh();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cQa == null) {
            this.apn = ayh();
        }
        int width = getWidth();
        int height = getHeight();
        ayf();
        if (this.cQc == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cQa);
        } else {
            canvas.drawPath(this.mPath, this.cQa);
        }
    }

    private void ayf() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cQb != this.mRadius) && this.cQc != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cQb = this.mRadius;
            this.mPath.reset();
            switch (this.cQc) {
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
        this.cQc = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.art = i;
        this.asf = i2;
        this.cPY = i3;
        this.cPZ = i4;
        this.apn = ayh();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.art != com.baidu.tieba.lego.card.d.a.bR(str) || this.asf != com.baidu.tieba.lego.card.d.a.bR(str2) || this.cPY != com.baidu.tieba.lego.card.d.a.bR(str3) || this.cPZ != com.baidu.tieba.lego.card.d.a.bR(str4)) {
            this.art = com.baidu.tieba.lego.card.d.a.bR(str);
            this.asf = com.baidu.tieba.lego.card.d.a.bR(str2);
            this.cPY = com.baidu.tieba.lego.card.d.a.bR(str3);
            this.cPZ = com.baidu.tieba.lego.card.d.a.bR(str4);
            this.apn = ayh();
            invalidate();
        }
    }

    private void ayg() {
        this.art = com.baidu.tieba.lego.card.d.a.bR("#2BB8FF");
        this.asf = com.baidu.tieba.lego.card.d.a.bR("#2BB8FF");
        this.cPY = com.baidu.tieba.lego.card.d.a.bR("#249BD6");
        this.cPZ = com.baidu.tieba.lego.card.d.a.bR("#246CD6");
        this.apn = ayh();
    }

    public void setDefaultGradientColor() {
        ayg();
        invalidate();
    }

    private LinearGradient ayh() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1 || skinType == 4;
        this.apn = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cPY : this.art, z ? this.cPZ : this.asf}, (float[]) null, Shader.TileMode.CLAMP);
        this.cQa.setShader(this.apn);
        this.mSkinType = skinType;
        return this.apn;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.apn = ayh();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.art));
        arrayList.add(Integer.valueOf(this.asf));
        arrayList.add(Integer.valueOf(this.cPY));
        arrayList.add(Integer.valueOf(this.cPZ));
        return arrayList;
    }
}

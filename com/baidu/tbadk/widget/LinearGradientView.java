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
    private int cvm;
    private int cvn;
    private int cvo;
    private int cvp;
    private LinearGradient cvq;
    private final Paint cvr;
    private int cvs;
    private int cvt;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cvr = new Paint();
        this.mRadius = 0;
        this.cvt = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cvr = new Paint();
        this.mRadius = 0;
        this.cvt = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cvr = new Paint();
        this.mRadius = 0;
        this.cvt = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aqV();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.cvq = aqW();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cvr == null) {
            this.cvq = aqW();
        }
        int width = getWidth();
        int height = getHeight();
        aqU();
        if (this.cvt == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cvr);
        } else {
            canvas.drawPath(this.mPath, this.cvr);
        }
    }

    private void aqU() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cvs != this.mRadius) && this.cvt != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cvs = this.mRadius;
            this.mPath.reset();
            switch (this.cvt) {
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
        this.cvt = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.cvm = i;
        this.cvn = i2;
        this.cvo = i3;
        this.cvp = i4;
        this.cvq = aqW();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.cvm != com.baidu.tieba.lego.card.d.a.parseColor(str) || this.cvn != com.baidu.tieba.lego.card.d.a.parseColor(str2) || this.cvo != com.baidu.tieba.lego.card.d.a.parseColor(str3) || this.cvp != com.baidu.tieba.lego.card.d.a.parseColor(str4)) {
            this.cvm = com.baidu.tieba.lego.card.d.a.parseColor(str);
            this.cvn = com.baidu.tieba.lego.card.d.a.parseColor(str2);
            this.cvo = com.baidu.tieba.lego.card.d.a.parseColor(str3);
            this.cvp = com.baidu.tieba.lego.card.d.a.parseColor(str4);
            this.cvq = aqW();
            invalidate();
        }
    }

    private void aqV() {
        this.cvm = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cvn = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cvo = com.baidu.tieba.lego.card.d.a.parseColor("#249BD6");
        this.cvp = com.baidu.tieba.lego.card.d.a.parseColor("#246CD6");
        this.cvq = aqW();
    }

    public void setDefaultGradientColor() {
        aqV();
        invalidate();
    }

    private LinearGradient aqW() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1;
        this.cvq = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cvo : this.cvm, z ? this.cvp : this.cvn}, (float[]) null, Shader.TileMode.CLAMP);
        this.cvr.setShader(this.cvq);
        this.mSkinType = skinType;
        return this.cvq;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cvq = aqW();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.cvm));
        arrayList.add(Integer.valueOf(this.cvn));
        arrayList.add(Integer.valueOf(this.cvo));
        arrayList.add(Integer.valueOf(this.cvp));
        return arrayList;
    }
}

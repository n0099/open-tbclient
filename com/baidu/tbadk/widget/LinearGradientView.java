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
    private int cvk;
    private int cvl;
    private int cvm;
    private int cvn;
    private LinearGradient cvo;
    private final Paint cvp;
    private int cvq;
    private int cvr;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cvp = new Paint();
        this.mRadius = 0;
        this.cvr = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cvp = new Paint();
        this.mRadius = 0;
        this.cvr = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cvp = new Paint();
        this.mRadius = 0;
        this.cvr = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        aqY();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.cvo = aqZ();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cvp == null) {
            this.cvo = aqZ();
        }
        int width = getWidth();
        int height = getHeight();
        aqX();
        if (this.cvr == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.cvp);
        } else {
            canvas.drawPath(this.mPath, this.cvp);
        }
    }

    private void aqX() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.cvq != this.mRadius) && this.cvr != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.cvq = this.mRadius;
            this.mPath.reset();
            switch (this.cvr) {
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
        this.cvr = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        this.cvk = i;
        this.cvl = i2;
        this.cvm = i3;
        this.cvn = i4;
        this.cvo = aqZ();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.cvk != com.baidu.tieba.lego.card.d.a.parseColor(str) || this.cvl != com.baidu.tieba.lego.card.d.a.parseColor(str2) || this.cvm != com.baidu.tieba.lego.card.d.a.parseColor(str3) || this.cvn != com.baidu.tieba.lego.card.d.a.parseColor(str4)) {
            this.cvk = com.baidu.tieba.lego.card.d.a.parseColor(str);
            this.cvl = com.baidu.tieba.lego.card.d.a.parseColor(str2);
            this.cvm = com.baidu.tieba.lego.card.d.a.parseColor(str3);
            this.cvn = com.baidu.tieba.lego.card.d.a.parseColor(str4);
            this.cvo = aqZ();
            invalidate();
        }
    }

    private void aqY() {
        this.cvk = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cvl = com.baidu.tieba.lego.card.d.a.parseColor("#2BB8FF");
        this.cvm = com.baidu.tieba.lego.card.d.a.parseColor("#249BD6");
        this.cvn = com.baidu.tieba.lego.card.d.a.parseColor("#246CD6");
        this.cvo = aqZ();
    }

    public void setDefaultGradientColor() {
        aqY();
        invalidate();
    }

    private LinearGradient aqZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        boolean z = skinType == 1;
        this.cvo = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{z ? this.cvm : this.cvk, z ? this.cvn : this.cvl}, (float[]) null, Shader.TileMode.CLAMP);
        this.cvp.setShader(this.cvo);
        this.mSkinType = skinType;
        return this.cvo;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cvo = aqZ();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.cvk));
        arrayList.add(Integer.valueOf(this.cvl));
        arrayList.add(Integer.valueOf(this.cvm));
        arrayList.add(Integer.valueOf(this.cvn));
        return arrayList;
    }
}

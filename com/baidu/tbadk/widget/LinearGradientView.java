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
/* loaded from: classes20.dex */
public class LinearGradientView extends View {
    private LinearGradient bCd;
    private int bEZ;
    private int bJQ;
    private int fze;
    private int fzf;
    private int fzg;
    private int fzh;
    private final Paint fzi;
    private int fzj;
    private int fzk;
    private int mHeight;
    private Path mPath;
    private int mRadius;
    private int mSkinType;
    private int mWidth;

    public LinearGradientView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fzi = new Paint();
        this.mRadius = 0;
        this.fzk = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fzi = new Paint();
        this.mRadius = 0;
        this.fzk = 0;
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fzi = new Paint();
        this.mRadius = 0;
        this.fzk = 0;
        init();
    }

    private void init() {
        this.mPath = new Path();
        bDG();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.bCd = bDH();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        bDF();
        if (this.fzk == 0) {
            canvas.drawRect(0.0f, 0.0f, width, height, this.fzi);
        } else {
            canvas.drawPath(this.mPath, this.fzi);
        }
    }

    private void bDF() {
        if ((getWidth() != this.mWidth || getHeight() != this.mHeight || this.fzj != this.mRadius) && this.fzk != 0) {
            this.mWidth = getWidth();
            this.mHeight = getHeight();
            this.fzj = this.mRadius;
            this.mPath.reset();
            switch (this.fzk) {
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
        this.fzk = i;
    }

    public void setCornerRadius(int i) {
        this.mRadius = i;
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bEZ = i;
        this.bJQ = i2;
        this.fze = i3;
        this.fzf = i4;
        this.fzg = i5;
        this.fzh = i6;
        this.bCd = bDH();
        invalidate();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            setDefaultGradientColor();
        } else if (this.bEZ != com.baidu.tieba.lego.card.d.b.sa(str) || this.bJQ != com.baidu.tieba.lego.card.d.b.sa(str2) || this.fze != com.baidu.tieba.lego.card.d.b.sa(str3) || this.fzf != com.baidu.tieba.lego.card.d.b.sa(str4) || this.fzg != com.baidu.tieba.lego.card.d.b.sa(str5) || this.fzh != com.baidu.tieba.lego.card.d.b.sa(str6)) {
            this.bEZ = com.baidu.tieba.lego.card.d.b.sa(str);
            this.bJQ = com.baidu.tieba.lego.card.d.b.sa(str2);
            this.fze = com.baidu.tieba.lego.card.d.b.sa(str3);
            this.fzf = com.baidu.tieba.lego.card.d.b.sa(str4);
            this.fzg = com.baidu.tieba.lego.card.d.b.sa(str5);
            this.fzh = com.baidu.tieba.lego.card.d.b.sa(str6);
            this.bCd = bDH();
            invalidate();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int sa;
        int i;
        int sa2;
        int i2;
        int sa3;
        int sa4;
        if (themeElement == null) {
            int sa5 = com.baidu.tieba.lego.card.d.b.sa("#2BB8FF");
            sa = com.baidu.tieba.lego.card.d.b.sa("#2BB8FF");
            i = sa5;
        } else {
            int sa6 = com.baidu.tieba.lego.card.d.b.sa(themeElement.common_color);
            sa = com.baidu.tieba.lego.card.d.b.sa(themeElement.common_color);
            i = sa6;
        }
        if (themeElement2 == null) {
            int sa7 = com.baidu.tieba.lego.card.d.b.sa("#249BD6");
            sa2 = com.baidu.tieba.lego.card.d.b.sa("#246CD6");
            i2 = sa7;
        } else {
            int sa8 = com.baidu.tieba.lego.card.d.b.sa(themeElement2.common_color);
            sa2 = com.baidu.tieba.lego.card.d.b.sa(themeElement2.common_color);
            i2 = sa8;
        }
        if (themeElement3 == null) {
            sa3 = com.baidu.tieba.lego.card.d.b.sa("#249BD6");
            sa4 = com.baidu.tieba.lego.card.d.b.sa("#246CD6");
        } else {
            sa3 = com.baidu.tieba.lego.card.d.b.sa(themeElement3.common_color);
            sa4 = com.baidu.tieba.lego.card.d.b.sa(themeElement3.common_color);
        }
        this.bEZ = i;
        this.bJQ = sa;
        this.fze = i2;
        this.fzf = sa2;
        this.fzg = sa3;
        this.fzh = sa4;
        this.bCd = bDH();
        invalidate();
    }

    private void bDG() {
        this.bEZ = com.baidu.tieba.lego.card.d.b.sa("#2BB8FF");
        this.bJQ = com.baidu.tieba.lego.card.d.b.sa("#2BB8FF");
        this.fze = com.baidu.tieba.lego.card.d.b.sa("#249BD6");
        this.fzf = com.baidu.tieba.lego.card.d.b.sa("#246CD6");
        this.fzg = com.baidu.tieba.lego.card.d.b.sa("#249BD6");
        this.fzh = com.baidu.tieba.lego.card.d.b.sa("#246CD6");
        this.bCd = bDH();
    }

    public void setDefaultGradientColor() {
        bDG();
        invalidate();
    }

    private LinearGradient bDH() {
        int i;
        int i2;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        int i3 = this.bEZ;
        int i4 = this.bJQ;
        if (skinType == 4) {
            i = this.fzg;
            i2 = this.fzh;
        } else if (skinType == 1) {
            i = this.fze;
            i2 = this.fzf;
        } else {
            i = i3;
            i2 = i4;
        }
        this.bCd = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
        this.fzi.setShader(this.bCd);
        this.mSkinType = skinType;
        return this.bCd;
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bCd = bDH();
            invalidate();
        }
        this.mSkinType = i;
    }

    public ArrayList<Integer> getGradientColor() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(this.bEZ));
        arrayList.add(Integer.valueOf(this.bJQ));
        arrayList.add(Integer.valueOf(this.fze));
        arrayList.add(Integer.valueOf(this.fzf));
        arrayList.add(Integer.valueOf(this.fzg));
        arrayList.add(Integer.valueOf(this.fzh));
        return arrayList;
    }
}

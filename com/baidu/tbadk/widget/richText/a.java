package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    public static final float aUe = l.af(TbadkCoreApplication.getInst());
    protected boolean aUu;
    protected TbImageView.b mOnDrawListener;
    protected float aUf = 0.0f;
    protected float aUg = 0.0f;
    protected int aUh = 0;
    protected int aUi = 0;
    protected float aUj = 15.0f;
    protected int aUk = -1;
    protected int aUl = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int aUm = 200;
    protected int aUn = 200;
    protected int aUo = 0;
    protected int aUp = 0;
    protected boolean aUq = false;
    protected int aUr = -9989158;
    protected ImageView.ScaleType aUs = ImageView.ScaleType.CENTER_CROP;
    protected boolean aUt = false;
    protected int aUv = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int aUw = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aUx = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aUy = 0;
    protected int aUz = -1;
    protected int aUA = -1;
    protected int aUB = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void a(TypedArray typedArray) {
        this.aUi = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.aUh = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.aUf = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.aUj = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.aUj);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.aUm = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.aUm);
        this.aUn = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.aUn);
        this.aUo = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.aUk = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.aUk);
        this.aUl = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.aUl);
        this.aUp = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.aUq = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.aUA = this.aUi;
    }

    public void release() {
    }

    public void J(float f) {
        this.aUf = f;
    }

    public void R(int i, int i2) {
        this.aUk = i;
        this.aUl = i2;
    }

    public void fS(int i) {
        this.aUp = i;
    }

    public void fT(int i) {
        this.aUm = i;
    }

    public void fU(int i) {
        this.aUn = i;
    }

    public void fV(int i) {
        this.aUo = i;
    }

    public void Jp() {
        this.aUt = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.aUf = f2;
        this.aUg = f;
    }

    public void S(int i, int i2) {
        this.aUv = i;
        this.aUw = i2;
    }

    public void fW(int i) {
        this.aUx = i;
    }

    public void fX(int i) {
        this.aUy = i;
    }

    public void fY(int i) {
        this.aUz = i;
    }

    public void fZ(int i) {
        this.aUA = i;
    }

    public void ga(int i) {
        this.aUB = i;
    }

    public void cf(boolean z) {
        this.aUu = z;
    }

    public int[] l(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aUu || i3 <= i5 || aUe <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aUe <= i3) {
                if (i5 * aUe > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aUe);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.aUf = aVar.aUf;
        this.aUg = aVar.aUg;
        this.aUh = aVar.aUh;
        this.aUi = aVar.aUi;
        this.aUj = aVar.aUj;
        this.aUk = aVar.aUk;
        this.aUl = aVar.aUl;
        this.mTextColor = aVar.mTextColor;
        this.aUm = aVar.aUm;
        this.aUn = aVar.aUn;
        this.aUo = aVar.aUo;
        this.aUp = aVar.aUp;
        this.aUq = aVar.aUq;
        this.aUr = aVar.aUr;
        this.aUt = aVar.aUt;
        this.aUu = aVar.aUu;
        this.aUv = aVar.aUv;
        this.aUw = aVar.aUw;
        this.aUx = aVar.aUx;
        this.aUy = aVar.aUy;
        this.aUz = aVar.aUz;
        this.aUA = aVar.aUi;
        this.aUB = aVar.aUB;
    }
}

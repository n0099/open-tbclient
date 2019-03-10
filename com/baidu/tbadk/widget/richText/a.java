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
    public static final float cBR = l.aR(TbadkCoreApplication.getInst());
    protected boolean cCg;
    public int cCq;
    public int cCr;
    public int cCs;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cBS = 0.0f;
    protected float cBT = 0.0f;
    protected int bOy = 0;
    protected int cBU = 0;
    protected float cBV = 15.0f;
    protected int cBW = -1;
    protected int cBX = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cBY = 200;
    protected int cBZ = 200;
    protected int cCa = 0;
    protected int cCb = 0;
    protected boolean cCc = false;
    protected int cCd = -9989158;
    protected ImageView.ScaleType cCe = ImageView.ScaleType.CENTER_CROP;
    public boolean cCf = false;
    public int cCh = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    public int cCi = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    public int cCj = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18);
    protected int cCk = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int cCl = 0;
    protected int cCm = -1;
    protected int cCn = -1;
    protected int cCo = -1;
    protected boolean cCp = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cBU = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bOy = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.cBS = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.cBV = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.cBV);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.cBY = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.cBY);
        this.cBZ = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.cBZ);
        this.cCa = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.cBW = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.cBW);
        this.cBX = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.cBX);
        this.cCb = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.cCc = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.cCn = this.cBU;
    }

    public void release() {
    }

    public void ar(int i, int i2) {
        this.cBW = i;
        this.cBX = i2;
    }

    public void ky(int i) {
        this.cCb = i;
    }

    public void kz(int i) {
        this.cBY = i;
    }

    public void kA(int i) {
        this.cBZ = i;
    }

    public void kB(int i) {
        this.cCa = i;
    }

    public void setSupportNoImage() {
        this.cCf = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cBS = f2;
        this.cBT = f;
    }

    public void as(int i, int i2) {
        this.cCh = i;
        this.cCi = i2;
    }

    public void kC(int i) {
        this.cCj = i;
    }

    public void kD(int i) {
        this.cCk = i;
    }

    public void kE(int i) {
        this.cBU = i;
    }

    public void kF(int i) {
        this.cCl = i;
    }

    public void kG(int i) {
        this.cCm = i;
    }

    public void kH(int i) {
        this.cCn = i;
    }

    public void kI(int i) {
        this.cCo = i;
    }

    public void setTextSize(int i) {
        this.cBV = i;
    }

    public boolean asw() {
        return this.cCp;
    }

    public void fs(boolean z) {
        this.cCp = z;
    }

    public void ft(boolean z) {
        this.cCg = z;
    }

    public int[] o(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cCg || i3 <= i5 || cBR <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cBR <= i3) {
                if (i5 * cBR > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cBR);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cBS = aVar.cBS;
        this.cBT = aVar.cBT;
        this.bOy = aVar.bOy;
        this.cBU = aVar.cBU;
        this.cBV = aVar.cBV;
        this.cBW = aVar.cBW;
        this.cBX = aVar.cBX;
        this.mTextColor = aVar.mTextColor;
        this.cBY = aVar.cBY;
        this.cBZ = aVar.cBZ;
        this.cCa = aVar.cCa;
        this.cCb = aVar.cCb;
        this.cCc = aVar.cCc;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cCd = aVar.cCd;
        this.cCf = aVar.cCf;
        this.cCg = aVar.cCg;
        this.cCh = aVar.cCh;
        this.cCi = aVar.cCi;
        this.cCk = aVar.cCk;
        this.cCl = aVar.cCl;
        this.cCm = aVar.cCm;
        this.cCn = aVar.cBU;
        this.cCo = aVar.cCo;
        this.cCp = aVar.cCp;
    }
}

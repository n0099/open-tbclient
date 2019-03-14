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
    public static final float cBO = l.aR(TbadkCoreApplication.getInst());
    protected boolean cCd;
    public int cCn;
    public int cCo;
    public int cCp;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cBP = 0.0f;
    protected float cBQ = 0.0f;
    protected int bOz = 0;
    protected int cBR = 0;
    protected float cBS = 15.0f;
    protected int cBT = -1;
    protected int cBU = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cBV = 200;
    protected int cBW = 200;
    protected int cBX = 0;
    protected int cBY = 0;
    protected boolean cBZ = false;
    protected int cCa = -9989158;
    protected ImageView.ScaleType cCb = ImageView.ScaleType.CENTER_CROP;
    public boolean cCc = false;
    public int cCe = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    public int cCf = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    public int cCg = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18);
    protected int cCh = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int cCi = 0;
    protected int cCj = -1;
    protected int cCk = -1;
    protected int cCl = -1;
    protected boolean cCm = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cBR = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bOz = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.cBP = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.cBS = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.cBS);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.cBV = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.cBV);
        this.cBW = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.cBW);
        this.cBX = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.cBT = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.cBT);
        this.cBU = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.cBU);
        this.cBY = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.cBZ = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.cCk = this.cBR;
    }

    public void release() {
    }

    public void ar(int i, int i2) {
        this.cBT = i;
        this.cBU = i2;
    }

    public void ky(int i) {
        this.cBY = i;
    }

    public void kz(int i) {
        this.cBV = i;
    }

    public void kA(int i) {
        this.cBW = i;
    }

    public void kB(int i) {
        this.cBX = i;
    }

    public void setSupportNoImage() {
        this.cCc = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cBP = f2;
        this.cBQ = f;
    }

    public void as(int i, int i2) {
        this.cCe = i;
        this.cCf = i2;
    }

    public void kC(int i) {
        this.cCg = i;
    }

    public void kD(int i) {
        this.cCh = i;
    }

    public void kE(int i) {
        this.cBR = i;
    }

    public void kF(int i) {
        this.cCi = i;
    }

    public void kG(int i) {
        this.cCj = i;
    }

    public void kH(int i) {
        this.cCk = i;
    }

    public void kI(int i) {
        this.cCl = i;
    }

    public void setTextSize(int i) {
        this.cBS = i;
    }

    public boolean asv() {
        return this.cCm;
    }

    public void fs(boolean z) {
        this.cCm = z;
    }

    public void ft(boolean z) {
        this.cCd = z;
    }

    public int[] o(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cCd || i3 <= i5 || cBO <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cBO <= i3) {
                if (i5 * cBO > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cBO);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cBP = aVar.cBP;
        this.cBQ = aVar.cBQ;
        this.bOz = aVar.bOz;
        this.cBR = aVar.cBR;
        this.cBS = aVar.cBS;
        this.cBT = aVar.cBT;
        this.cBU = aVar.cBU;
        this.mTextColor = aVar.mTextColor;
        this.cBV = aVar.cBV;
        this.cBW = aVar.cBW;
        this.cBX = aVar.cBX;
        this.cBY = aVar.cBY;
        this.cBZ = aVar.cBZ;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cCa = aVar.cCa;
        this.cCc = aVar.cCc;
        this.cCd = aVar.cCd;
        this.cCe = aVar.cCe;
        this.cCf = aVar.cCf;
        this.cCh = aVar.cCh;
        this.cCi = aVar.cCi;
        this.cCj = aVar.cCj;
        this.cCk = aVar.cBR;
        this.cCl = aVar.cCl;
        this.cCm = aVar.cCm;
    }
}

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
    public static final float cBQ = l.aR(TbadkCoreApplication.getInst());
    protected boolean cCf;
    public int cCp;
    public int cCq;
    public int cCr;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cBR = 0.0f;
    protected float cBS = 0.0f;
    protected int bOB = 0;
    protected int cBT = 0;
    protected float cBU = 15.0f;
    protected int cBV = -1;
    protected int cBW = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cBX = 200;
    protected int cBY = 200;
    protected int cBZ = 0;
    protected int cCa = 0;
    protected boolean cCb = false;
    protected int cCc = -9989158;
    protected ImageView.ScaleType cCd = ImageView.ScaleType.CENTER_CROP;
    public boolean cCe = false;
    public int cCg = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    public int cCh = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    public int cCi = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds18);
    protected int cCj = l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int cCk = 0;
    protected int cCl = -1;
    protected int cCm = -1;
    protected int cCn = -1;
    protected boolean cCo = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cBT = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bOB = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.cBR = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.cBU = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.cBU);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.cBX = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.cBX);
        this.cBY = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.cBY);
        this.cBZ = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.cBV = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.cBV);
        this.cBW = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.cBW);
        this.cCa = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.cCb = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.cCm = this.cBT;
    }

    public void release() {
    }

    public void ar(int i, int i2) {
        this.cBV = i;
        this.cBW = i2;
    }

    public void kx(int i) {
        this.cCa = i;
    }

    public void ky(int i) {
        this.cBX = i;
    }

    public void kz(int i) {
        this.cBY = i;
    }

    public void kA(int i) {
        this.cBZ = i;
    }

    public void setSupportNoImage() {
        this.cCe = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cBR = f2;
        this.cBS = f;
    }

    public void as(int i, int i2) {
        this.cCg = i;
        this.cCh = i2;
    }

    public void kB(int i) {
        this.cCi = i;
    }

    public void kC(int i) {
        this.cCj = i;
    }

    public void kD(int i) {
        this.cBT = i;
    }

    public void kE(int i) {
        this.cCk = i;
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

    public void setTextSize(int i) {
        this.cBU = i;
    }

    public boolean ass() {
        return this.cCo;
    }

    public void fs(boolean z) {
        this.cCo = z;
    }

    public void ft(boolean z) {
        this.cCf = z;
    }

    public int[] o(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cCf || i3 <= i5 || cBQ <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cBQ <= i3) {
                if (i5 * cBQ > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cBQ);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cBR = aVar.cBR;
        this.cBS = aVar.cBS;
        this.bOB = aVar.bOB;
        this.cBT = aVar.cBT;
        this.cBU = aVar.cBU;
        this.cBV = aVar.cBV;
        this.cBW = aVar.cBW;
        this.mTextColor = aVar.mTextColor;
        this.cBX = aVar.cBX;
        this.cBY = aVar.cBY;
        this.cBZ = aVar.cBZ;
        this.cCa = aVar.cCa;
        this.cCb = aVar.cCb;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cCc = aVar.cCc;
        this.cCe = aVar.cCe;
        this.cCf = aVar.cCf;
        this.cCg = aVar.cCg;
        this.cCh = aVar.cCh;
        this.cCj = aVar.cCj;
        this.cCk = aVar.cCk;
        this.cCl = aVar.cCl;
        this.cCm = aVar.cBT;
        this.cCn = aVar.cCn;
        this.cCo = aVar.cCo;
    }
}

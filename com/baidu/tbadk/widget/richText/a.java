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
    public static final float bKs = l.ar(TbadkCoreApplication.getInst());
    protected boolean bKI;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bKt = 0.0f;
    protected float bKu = 0.0f;
    protected int bKv = 0;
    protected int bKw = 0;
    protected float bKx = 15.0f;
    protected int bKy = -1;
    protected int bKz = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bKA = 200;
    protected int bKB = 200;
    protected int bKC = 0;
    protected int bKD = 0;
    protected boolean bKE = false;
    protected int bKF = -9989158;
    protected ImageView.ScaleType bKG = ImageView.ScaleType.CENTER_CROP;
    protected boolean bKH = false;
    protected int bKJ = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int bKK = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bKL = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bKM = 0;
    protected int bKN = -1;
    protected int bKO = -1;
    protected int bKP = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bKw = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bKv = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.bKt = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.bKx = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.bKx);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.bKA = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.bKA);
        this.bKB = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.bKB);
        this.bKC = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.bKy = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.bKy);
        this.bKz = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.bKz);
        this.bKD = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.bKE = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.bKO = this.bKw;
    }

    public void release() {
    }

    public void aR(int i, int i2) {
        this.bKy = i;
        this.bKz = i2;
    }

    public void iK(int i) {
        this.bKD = i;
    }

    public void iL(int i) {
        this.bKA = i;
    }

    public void iM(int i) {
        this.bKB = i;
    }

    public void iN(int i) {
        this.bKC = i;
    }

    public void Rh() {
        this.bKH = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bKt = f2;
        this.bKu = f;
    }

    public void aS(int i, int i2) {
        this.bKJ = i;
        this.bKK = i2;
    }

    public void iO(int i) {
        this.bKL = i;
    }

    public void iP(int i) {
        this.bKM = i;
    }

    public void iQ(int i) {
        this.bKN = i;
    }

    public void iR(int i) {
        this.bKO = i;
    }

    public void iS(int i) {
        this.bKP = i;
    }

    public void cM(boolean z) {
        this.bKI = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] j = l.j(i, i2, i3, i4);
        if (j == null) {
            return null;
        }
        int[] iArr = {j[0], j[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bKI || i3 <= i5 || bKs <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bKs <= i3) {
                if (i5 * bKs > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bKs);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bKt = aVar.bKt;
        this.bKu = aVar.bKu;
        this.bKv = aVar.bKv;
        this.bKw = aVar.bKw;
        this.bKx = aVar.bKx;
        this.bKy = aVar.bKy;
        this.bKz = aVar.bKz;
        this.mTextColor = aVar.mTextColor;
        this.bKA = aVar.bKA;
        this.bKB = aVar.bKB;
        this.bKC = aVar.bKC;
        this.bKD = aVar.bKD;
        this.bKE = aVar.bKE;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bKF = aVar.bKF;
        this.bKH = aVar.bKH;
        this.bKI = aVar.bKI;
        this.bKJ = aVar.bKJ;
        this.bKK = aVar.bKK;
        this.bKL = aVar.bKL;
        this.bKM = aVar.bKM;
        this.bKN = aVar.bKN;
        this.bKO = aVar.bKw;
        this.bKP = aVar.bKP;
    }
}

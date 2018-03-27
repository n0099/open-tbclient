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
    public static final float bKi = l.ar(TbadkCoreApplication.getInst());
    protected boolean bKy;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bKj = 0.0f;
    protected float bKk = 0.0f;
    protected int bKl = 0;
    protected int bKm = 0;
    protected float bKn = 15.0f;
    protected int bKo = -1;
    protected int bKp = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bKq = 200;
    protected int bKr = 200;
    protected int bKs = 0;
    protected int bKt = 0;
    protected boolean bKu = false;
    protected int bKv = -9989158;
    protected ImageView.ScaleType bKw = ImageView.ScaleType.CENTER_CROP;
    protected boolean bKx = false;
    protected int bKz = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int bKA = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bKB = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bKC = 0;
    protected int bKD = -1;
    protected int bKE = -1;
    protected int bKF = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bKm = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bKl = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.bKj = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.bKn = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.bKn);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.bKq = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.bKq);
        this.bKr = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.bKr);
        this.bKs = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.bKo = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.bKo);
        this.bKp = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.bKp);
        this.bKt = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.bKu = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.bKE = this.bKm;
    }

    public void release() {
    }

    public void aR(int i, int i2) {
        this.bKo = i;
        this.bKp = i2;
    }

    public void iK(int i) {
        this.bKt = i;
    }

    public void iL(int i) {
        this.bKq = i;
    }

    public void iM(int i) {
        this.bKr = i;
    }

    public void iN(int i) {
        this.bKs = i;
    }

    public void Rh() {
        this.bKx = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bKj = f2;
        this.bKk = f;
    }

    public void aS(int i, int i2) {
        this.bKz = i;
        this.bKA = i2;
    }

    public void iO(int i) {
        this.bKB = i;
    }

    public void iP(int i) {
        this.bKC = i;
    }

    public void iQ(int i) {
        this.bKD = i;
    }

    public void iR(int i) {
        this.bKE = i;
    }

    public void iS(int i) {
        this.bKF = i;
    }

    public void cM(boolean z) {
        this.bKy = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] j = l.j(i, i2, i3, i4);
        if (j == null) {
            return null;
        }
        int[] iArr = {j[0], j[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bKy || i3 <= i5 || bKi <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bKi <= i3) {
                if (i5 * bKi > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bKi);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bKj = aVar.bKj;
        this.bKk = aVar.bKk;
        this.bKl = aVar.bKl;
        this.bKm = aVar.bKm;
        this.bKn = aVar.bKn;
        this.bKo = aVar.bKo;
        this.bKp = aVar.bKp;
        this.mTextColor = aVar.mTextColor;
        this.bKq = aVar.bKq;
        this.bKr = aVar.bKr;
        this.bKs = aVar.bKs;
        this.bKt = aVar.bKt;
        this.bKu = aVar.bKu;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bKv = aVar.bKv;
        this.bKx = aVar.bKx;
        this.bKy = aVar.bKy;
        this.bKz = aVar.bKz;
        this.bKA = aVar.bKA;
        this.bKB = aVar.bKB;
        this.bKC = aVar.bKC;
        this.bKD = aVar.bKD;
        this.bKE = aVar.bKm;
        this.bKF = aVar.bKF;
    }
}

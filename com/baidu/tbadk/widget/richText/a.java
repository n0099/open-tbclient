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
    public static final float bKf = l.ar(TbadkCoreApplication.getInst());
    protected boolean bKv;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bKg = 0.0f;
    protected float bKh = 0.0f;
    protected int bKi = 0;
    protected int bKj = 0;
    protected float bKk = 15.0f;
    protected int bKl = -1;
    protected int bKm = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bKn = 200;
    protected int bKo = 200;
    protected int bKp = 0;
    protected int bKq = 0;
    protected boolean bKr = false;
    protected int bKs = -9989158;
    protected ImageView.ScaleType bKt = ImageView.ScaleType.CENTER_CROP;
    protected boolean bKu = false;
    protected int bKw = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int bKx = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bKy = l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bKz = 0;
    protected int bKA = -1;
    protected int bKB = -1;
    protected int bKC = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bKj = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bKi = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.bKg = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.bKk = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.bKk);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.bKn = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.bKn);
        this.bKo = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.bKo);
        this.bKp = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.bKl = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.bKl);
        this.bKm = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.bKm);
        this.bKq = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.bKr = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.bKB = this.bKj;
    }

    public void release() {
    }

    public void aR(int i, int i2) {
        this.bKl = i;
        this.bKm = i2;
    }

    public void iK(int i) {
        this.bKq = i;
    }

    public void iL(int i) {
        this.bKn = i;
    }

    public void iM(int i) {
        this.bKo = i;
    }

    public void iN(int i) {
        this.bKp = i;
    }

    public void Rg() {
        this.bKu = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bKg = f2;
        this.bKh = f;
    }

    public void aS(int i, int i2) {
        this.bKw = i;
        this.bKx = i2;
    }

    public void iO(int i) {
        this.bKy = i;
    }

    public void iP(int i) {
        this.bKz = i;
    }

    public void iQ(int i) {
        this.bKA = i;
    }

    public void iR(int i) {
        this.bKB = i;
    }

    public void iS(int i) {
        this.bKC = i;
    }

    public void cM(boolean z) {
        this.bKv = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] j = l.j(i, i2, i3, i4);
        if (j == null) {
            return null;
        }
        int[] iArr = {j[0], j[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bKv || i3 <= i5 || bKf <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bKf <= i3) {
                if (i5 * bKf > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bKf);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bKg = aVar.bKg;
        this.bKh = aVar.bKh;
        this.bKi = aVar.bKi;
        this.bKj = aVar.bKj;
        this.bKk = aVar.bKk;
        this.bKl = aVar.bKl;
        this.bKm = aVar.bKm;
        this.mTextColor = aVar.mTextColor;
        this.bKn = aVar.bKn;
        this.bKo = aVar.bKo;
        this.bKp = aVar.bKp;
        this.bKq = aVar.bKq;
        this.bKr = aVar.bKr;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bKs = aVar.bKs;
        this.bKu = aVar.bKu;
        this.bKv = aVar.bKv;
        this.bKw = aVar.bKw;
        this.bKx = aVar.bKx;
        this.bKy = aVar.bKy;
        this.bKz = aVar.bKz;
        this.bKA = aVar.bKA;
        this.bKB = aVar.bKj;
        this.bKC = aVar.bKC;
    }
}

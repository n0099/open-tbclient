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
    public static final float bIn = l.ar(TbadkCoreApplication.getInst());
    protected boolean bID;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bIo = 0.0f;
    protected float bIp = 0.0f;
    protected int bIq = 0;
    protected int bIr = 0;
    protected float bIs = 15.0f;
    protected int bIt = -1;
    protected int bIu = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bIv = 200;
    protected int bIw = 200;
    protected int bIx = 0;
    protected int bIy = 0;
    protected boolean bIz = false;
    protected int bIA = -9989158;
    protected ImageView.ScaleType bIB = ImageView.ScaleType.CENTER_CROP;
    protected boolean bIC = false;
    protected int bIE = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int bIF = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bIG = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bIH = 0;
    protected int bII = -1;
    protected int bIJ = -1;
    protected int bIK = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bIr = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bIq = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.bIo = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.bIs = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.bIs);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.bIv = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.bIv);
        this.bIw = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.bIw);
        this.bIx = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.bIt = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.bIt);
        this.bIu = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.bIu);
        this.bIy = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.bIz = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.bIJ = this.bIr;
    }

    public void release() {
    }

    public void aR(int i, int i2) {
        this.bIt = i;
        this.bIu = i2;
    }

    public void iN(int i) {
        this.bIy = i;
    }

    public void iO(int i) {
        this.bIv = i;
    }

    public void iP(int i) {
        this.bIw = i;
    }

    public void iQ(int i) {
        this.bIx = i;
    }

    public void QC() {
        this.bIC = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bIo = f2;
        this.bIp = f;
    }

    public void aS(int i, int i2) {
        this.bIE = i;
        this.bIF = i2;
    }

    public void iR(int i) {
        this.bIG = i;
    }

    public void iS(int i) {
        this.bIH = i;
    }

    public void iT(int i) {
        this.bII = i;
    }

    public void iU(int i) {
        this.bIJ = i;
    }

    public void iV(int i) {
        this.bIK = i;
    }

    public void cI(boolean z) {
        this.bID = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] j = l.j(i, i2, i3, i4);
        if (j == null) {
            return null;
        }
        int[] iArr = {j[0], j[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bID || i3 <= i5 || bIn <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bIn <= i3) {
                if (i5 * bIn > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bIn);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bIo = aVar.bIo;
        this.bIp = aVar.bIp;
        this.bIq = aVar.bIq;
        this.bIr = aVar.bIr;
        this.bIs = aVar.bIs;
        this.bIt = aVar.bIt;
        this.bIu = aVar.bIu;
        this.mTextColor = aVar.mTextColor;
        this.bIv = aVar.bIv;
        this.bIw = aVar.bIw;
        this.bIx = aVar.bIx;
        this.bIy = aVar.bIy;
        this.bIz = aVar.bIz;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bIA = aVar.bIA;
        this.bIC = aVar.bIC;
        this.bID = aVar.bID;
        this.bIE = aVar.bIE;
        this.bIF = aVar.bIF;
        this.bIG = aVar.bIG;
        this.bIH = aVar.bIH;
        this.bII = aVar.bII;
        this.bIJ = aVar.bIr;
        this.bIK = aVar.bIK;
    }
}

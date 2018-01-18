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
    public static final float bIf = l.ar(TbadkCoreApplication.getInst());
    protected boolean bIv;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bIg = 0.0f;
    protected float bIh = 0.0f;
    protected int bIi = 0;
    protected int bIj = 0;
    protected float bIk = 15.0f;
    protected int bIl = -1;
    protected int bIm = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bIn = 200;
    protected int bIo = 200;
    protected int bIp = 0;
    protected int bIq = 0;
    protected boolean bIr = false;
    protected int bIs = -9989158;
    protected ImageView.ScaleType bIt = ImageView.ScaleType.CENTER_CROP;
    protected boolean bIu = false;
    protected int bIw = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int bIx = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bIy = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bIz = 0;
    protected int bIA = -1;
    protected int bIB = -1;
    protected int bIC = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bIj = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bIi = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.bIg = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.bIk = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.bIk);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.bIn = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.bIn);
        this.bIo = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.bIo);
        this.bIp = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.bIl = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.bIl);
        this.bIm = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.bIm);
        this.bIq = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.bIr = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.bIB = this.bIj;
    }

    public void release() {
    }

    public void aR(int i, int i2) {
        this.bIl = i;
        this.bIm = i2;
    }

    public void iN(int i) {
        this.bIq = i;
    }

    public void iO(int i) {
        this.bIn = i;
    }

    public void iP(int i) {
        this.bIo = i;
    }

    public void iQ(int i) {
        this.bIp = i;
    }

    public void QA() {
        this.bIu = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bIg = f2;
        this.bIh = f;
    }

    public void aS(int i, int i2) {
        this.bIw = i;
        this.bIx = i2;
    }

    public void iR(int i) {
        this.bIy = i;
    }

    public void iS(int i) {
        this.bIz = i;
    }

    public void iT(int i) {
        this.bIA = i;
    }

    public void iU(int i) {
        this.bIB = i;
    }

    public void iV(int i) {
        this.bIC = i;
    }

    public void cH(boolean z) {
        this.bIv = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] j = l.j(i, i2, i3, i4);
        if (j == null) {
            return null;
        }
        int[] iArr = {j[0], j[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bIv || i3 <= i5 || bIf <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bIf <= i3) {
                if (i5 * bIf > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bIf);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bIg = aVar.bIg;
        this.bIh = aVar.bIh;
        this.bIi = aVar.bIi;
        this.bIj = aVar.bIj;
        this.bIk = aVar.bIk;
        this.bIl = aVar.bIl;
        this.bIm = aVar.bIm;
        this.mTextColor = aVar.mTextColor;
        this.bIn = aVar.bIn;
        this.bIo = aVar.bIo;
        this.bIp = aVar.bIp;
        this.bIq = aVar.bIq;
        this.bIr = aVar.bIr;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bIs = aVar.bIs;
        this.bIu = aVar.bIu;
        this.bIv = aVar.bIv;
        this.bIw = aVar.bIw;
        this.bIx = aVar.bIx;
        this.bIy = aVar.bIy;
        this.bIz = aVar.bIz;
        this.bIA = aVar.bIA;
        this.bIB = aVar.bIj;
        this.bIC = aVar.bIC;
    }
}

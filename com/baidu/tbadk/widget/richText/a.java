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
    public static final float bHX = l.ar(TbadkCoreApplication.getInst());
    protected boolean bIn;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bHY = 0.0f;
    protected float bHZ = 0.0f;
    protected int bIa = 0;
    protected int bIb = 0;
    protected float bIc = 15.0f;
    protected int bId = -1;
    protected int bIe = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bIf = 200;
    protected int bIg = 200;
    protected int bIh = 0;
    protected int bIi = 0;
    protected boolean bIj = false;
    protected int bIk = -9989158;
    protected ImageView.ScaleType bIl = ImageView.ScaleType.CENTER_CROP;
    protected boolean bIm = false;
    protected int bIo = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int bIp = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bIq = l.s(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bIr = 0;
    protected int bIs = -1;
    protected int bIt = -1;
    protected int bIu = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bIb = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.bIa = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.bHY = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.bIc = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.bIc);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.bIf = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.bIf);
        this.bIg = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.bIg);
        this.bIh = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.bId = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.bId);
        this.bIe = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.bIe);
        this.bIi = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.bIj = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.bIt = this.bIb;
    }

    public void release() {
    }

    public void Z(float f) {
        this.bHY = f;
    }

    public void aR(int i, int i2) {
        this.bId = i;
        this.bIe = i2;
    }

    public void iR(int i) {
        this.bIi = i;
    }

    public void iS(int i) {
        this.bIf = i;
    }

    public void iT(int i) {
        this.bIg = i;
    }

    public void iU(int i) {
        this.bIh = i;
    }

    public void QM() {
        this.bIm = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bHY = f2;
        this.bHZ = f;
    }

    public void aS(int i, int i2) {
        this.bIo = i;
        this.bIp = i2;
    }

    public void iV(int i) {
        this.bIq = i;
    }

    public void iW(int i) {
        this.bIr = i;
    }

    public void iX(int i) {
        this.bIs = i;
    }

    public void iY(int i) {
        this.bIt = i;
    }

    public void iZ(int i) {
        this.bIu = i;
    }

    public void cJ(boolean z) {
        this.bIn = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] j = l.j(i, i2, i3, i4);
        if (j == null) {
            return null;
        }
        int[] iArr = {j[0], j[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bIn || i3 <= i5 || bHX <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bHX <= i3) {
                if (i5 * bHX > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bHX);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bHY = aVar.bHY;
        this.bHZ = aVar.bHZ;
        this.bIa = aVar.bIa;
        this.bIb = aVar.bIb;
        this.bIc = aVar.bIc;
        this.bId = aVar.bId;
        this.bIe = aVar.bIe;
        this.mTextColor = aVar.mTextColor;
        this.bIf = aVar.bIf;
        this.bIg = aVar.bIg;
        this.bIh = aVar.bIh;
        this.bIi = aVar.bIi;
        this.bIj = aVar.bIj;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bIk = aVar.bIk;
        this.bIm = aVar.bIm;
        this.bIn = aVar.bIn;
        this.bIo = aVar.bIo;
        this.bIp = aVar.bIp;
        this.bIq = aVar.bIq;
        this.bIr = aVar.bIr;
        this.bIs = aVar.bIs;
        this.bIt = aVar.bIb;
        this.bIu = aVar.bIu;
    }
}

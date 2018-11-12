package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    public static final float bmP = l.aR(TbadkCoreApplication.getInst());
    protected boolean bne;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bmQ = 0.0f;
    protected float bmR = 0.0f;
    protected int aCn = 0;
    protected int bmS = 0;
    protected float bmT = 15.0f;
    protected int bmU = -1;
    protected int bmV = -1;
    protected int mTextColor = -16777216;
    protected int bmW = 200;
    protected int bmX = 200;
    protected int bmY = 0;
    protected int bmZ = 0;
    protected boolean bna = false;
    protected int bnb = -9989158;
    protected ImageView.ScaleType bnc = ImageView.ScaleType.CENTER_CROP;
    protected boolean bnd = false;
    protected int bnf = l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds16);
    protected int bng = l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds20);
    protected int bnh = l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds20);
    protected int bni = 0;
    protected int bnj = -1;
    protected int bnk = -1;
    protected int bnl = -1;
    protected boolean bnm = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bmS = typedArray.getDimensionPixelSize(e.l.TbRichTextView_segmentMargin, 0);
        this.aCn = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textPadding, 0);
        this.bmQ = typedArray.getFloat(e.l.TbRichTextView_lineSpacing, 1.12f);
        this.bmT = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textSize, (int) this.bmT);
        this.mTextColor = typedArray.getColor(e.l.TbRichTextView_textColor, this.mTextColor);
        this.bmW = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageWidth, this.bmW);
        this.bmX = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageHeight, this.bmX);
        this.bmY = typedArray.getResourceId(e.l.TbRichTextView_defaultImage, 0);
        this.bmU = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceWidth, this.bmU);
        this.bmV = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceHeight, this.bmV);
        this.bmZ = typedArray.getResourceId(e.l.TbRichTextView_videoImage, 0);
        this.bna = typedArray.getBoolean(e.l.TbRichTextView_singleLine, false);
        this.bnk = this.bmS;
    }

    public void release() {
    }

    public void S(int i, int i2) {
        this.bmU = i;
        this.bmV = i2;
    }

    public void gv(int i) {
        this.bmZ = i;
    }

    public void gw(int i) {
        this.bmW = i;
    }

    public void gx(int i) {
        this.bmX = i;
    }

    public void gy(int i) {
        this.bmY = i;
    }

    public void setSupportNoImage() {
        this.bnd = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bmQ = f2;
        this.bmR = f;
    }

    public void T(int i, int i2) {
        this.bnf = i;
        this.bng = i2;
    }

    public void gz(int i) {
        this.bnh = i;
    }

    public void gA(int i) {
        this.bmS = i;
    }

    public void gB(int i) {
        this.bni = i;
    }

    public void gC(int i) {
        this.bnj = i;
    }

    public void gD(int i) {
        this.bnk = i;
    }

    public void gE(int i) {
        this.bnl = i;
    }

    public void setTextSize(int i) {
        this.bmT = i;
    }

    public boolean QS() {
        return this.bnm;
    }

    public void cY(boolean z) {
        this.bnm = z;
    }

    public void cZ(boolean z) {
        this.bne = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bne || i3 <= i5 || bmP <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bmP <= i3) {
                if (i5 * bmP > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bmP);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bmQ = aVar.bmQ;
        this.bmR = aVar.bmR;
        this.aCn = aVar.aCn;
        this.bmS = aVar.bmS;
        this.bmT = aVar.bmT;
        this.bmU = aVar.bmU;
        this.bmV = aVar.bmV;
        this.mTextColor = aVar.mTextColor;
        this.bmW = aVar.bmW;
        this.bmX = aVar.bmX;
        this.bmY = aVar.bmY;
        this.bmZ = aVar.bmZ;
        this.bna = aVar.bna;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bnb = aVar.bnb;
        this.bnd = aVar.bnd;
        this.bne = aVar.bne;
        this.bnf = aVar.bnf;
        this.bng = aVar.bng;
        this.bnh = aVar.bnh;
        this.bni = aVar.bni;
        this.bnj = aVar.bnj;
        this.bnk = aVar.bmS;
        this.bnl = aVar.bnl;
        this.bnm = aVar.bnm;
    }
}

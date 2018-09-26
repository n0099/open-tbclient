package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    public static final float bhW = l.aR(TbadkCoreApplication.getInst());
    protected boolean bin;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bhX = 0.0f;
    protected float bhY = 0.0f;
    protected int awO = 0;
    protected int bhZ = 0;
    protected float bia = 15.0f;
    protected int bib = -1;
    protected int bic = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bie = 200;
    protected int bif = 200;
    protected int bih = 0;
    protected int bii = 0;
    protected boolean bij = false;
    protected int bik = -9989158;
    protected ImageView.ScaleType bil = ImageView.ScaleType.CENTER_CROP;
    protected boolean bim = false;
    protected int bio = l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds16);
    protected int bip = l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds20);
    protected int biq = l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds20);
    protected int bir = 0;
    protected int bis = -1;
    protected int bit = -1;
    protected int biu = -1;
    protected boolean biv = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bhZ = typedArray.getDimensionPixelSize(e.l.TbRichTextView_segmentMargin, 0);
        this.awO = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textPadding, 0);
        this.bhX = typedArray.getFloat(e.l.TbRichTextView_lineSpacing, 1.12f);
        this.bia = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textSize, (int) this.bia);
        this.mTextColor = typedArray.getColor(e.l.TbRichTextView_textColor, this.mTextColor);
        this.bie = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageWidth, this.bie);
        this.bif = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageHeight, this.bif);
        this.bih = typedArray.getResourceId(e.l.TbRichTextView_defaultImage, 0);
        this.bib = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceWidth, this.bib);
        this.bic = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceHeight, this.bic);
        this.bii = typedArray.getResourceId(e.l.TbRichTextView_videoImage, 0);
        this.bij = typedArray.getBoolean(e.l.TbRichTextView_singleLine, false);
        this.bit = this.bhZ;
    }

    public void release() {
    }

    public void R(int i, int i2) {
        this.bib = i;
        this.bic = i2;
    }

    public void fZ(int i) {
        this.bii = i;
    }

    public void ga(int i) {
        this.bie = i;
    }

    public void gb(int i) {
        this.bif = i;
    }

    public void gc(int i) {
        this.bih = i;
    }

    public void setSupportNoImage() {
        this.bim = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bhX = f2;
        this.bhY = f;
    }

    public void S(int i, int i2) {
        this.bio = i;
        this.bip = i2;
    }

    public void gd(int i) {
        this.biq = i;
    }

    public void ge(int i) {
        this.bhZ = i;
    }

    public void gf(int i) {
        this.bir = i;
    }

    public void gg(int i) {
        this.bis = i;
    }

    public void gh(int i) {
        this.bit = i;
    }

    public void gi(int i) {
        this.biu = i;
    }

    public void setTextSize(int i) {
        this.bia = i;
    }

    public boolean OO() {
        return this.biv;
    }

    public void cy(boolean z) {
        this.biv = z;
    }

    public void cz(boolean z) {
        this.bin = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bin || i3 <= i5 || bhW <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bhW <= i3) {
                if (i5 * bhW > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bhW);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bhX = aVar.bhX;
        this.bhY = aVar.bhY;
        this.awO = aVar.awO;
        this.bhZ = aVar.bhZ;
        this.bia = aVar.bia;
        this.bib = aVar.bib;
        this.bic = aVar.bic;
        this.mTextColor = aVar.mTextColor;
        this.bie = aVar.bie;
        this.bif = aVar.bif;
        this.bih = aVar.bih;
        this.bii = aVar.bii;
        this.bij = aVar.bij;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bik = aVar.bik;
        this.bim = aVar.bim;
        this.bin = aVar.bin;
        this.bio = aVar.bio;
        this.bip = aVar.bip;
        this.biq = aVar.biq;
        this.bir = aVar.bir;
        this.bis = aVar.bis;
        this.bit = aVar.bhZ;
        this.biu = aVar.biu;
        this.biv = aVar.biv;
    }
}

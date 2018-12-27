package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    public static final float bqp = l.aR(TbadkCoreApplication.getInst());
    protected boolean bqE;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bqq = 0.0f;
    protected float bqr = 0.0f;
    protected int aFO = 0;
    protected int bqs = 0;
    protected float bqt = 15.0f;
    protected int bqu = -1;
    protected int bqv = -1;
    protected int mTextColor = -16777216;
    protected int bqw = 200;
    protected int bqx = 200;
    protected int bqy = 0;
    protected int bqz = 0;
    protected boolean bqA = false;
    protected int bqB = -9989158;
    protected ImageView.ScaleType bqC = ImageView.ScaleType.CENTER_CROP;
    protected boolean bqD = false;
    protected int bqF = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds16);
    protected int bqG = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int bqH = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int bqI = 0;
    protected int bqJ = -1;
    protected int bqK = -1;
    protected int bqL = -1;
    protected boolean bqM = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bqs = typedArray.getDimensionPixelSize(e.l.TbRichTextView_segmentMargin, 0);
        this.aFO = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textPadding, 0);
        this.bqq = typedArray.getFloat(e.l.TbRichTextView_lineSpacing, 1.12f);
        this.bqt = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textSize, (int) this.bqt);
        this.mTextColor = typedArray.getColor(e.l.TbRichTextView_textColor, this.mTextColor);
        this.bqw = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageWidth, this.bqw);
        this.bqx = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageHeight, this.bqx);
        this.bqy = typedArray.getResourceId(e.l.TbRichTextView_defaultImage, 0);
        this.bqu = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceWidth, this.bqu);
        this.bqv = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceHeight, this.bqv);
        this.bqz = typedArray.getResourceId(e.l.TbRichTextView_videoImage, 0);
        this.bqA = typedArray.getBoolean(e.l.TbRichTextView_singleLine, false);
        this.bqK = this.bqs;
    }

    public void release() {
    }

    public void T(int i, int i2) {
        this.bqu = i;
        this.bqv = i2;
    }

    public void gK(int i) {
        this.bqz = i;
    }

    public void gL(int i) {
        this.bqw = i;
    }

    public void gM(int i) {
        this.bqx = i;
    }

    public void gN(int i) {
        this.bqy = i;
    }

    public void setSupportNoImage() {
        this.bqD = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bqq = f2;
        this.bqr = f;
    }

    public void U(int i, int i2) {
        this.bqF = i;
        this.bqG = i2;
    }

    public void gO(int i) {
        this.bqH = i;
    }

    public void gP(int i) {
        this.bqs = i;
    }

    public void gQ(int i) {
        this.bqI = i;
    }

    public void gR(int i) {
        this.bqJ = i;
    }

    public void gS(int i) {
        this.bqK = i;
    }

    public void gT(int i) {
        this.bqL = i;
    }

    public void setTextSize(int i) {
        this.bqt = i;
    }

    public boolean Sa() {
        return this.bqM;
    }

    public void cZ(boolean z) {
        this.bqM = z;
    }

    public void da(boolean z) {
        this.bqE = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bqE || i3 <= i5 || bqp <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bqp <= i3) {
                if (i5 * bqp > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bqp);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bqq = aVar.bqq;
        this.bqr = aVar.bqr;
        this.aFO = aVar.aFO;
        this.bqs = aVar.bqs;
        this.bqt = aVar.bqt;
        this.bqu = aVar.bqu;
        this.bqv = aVar.bqv;
        this.mTextColor = aVar.mTextColor;
        this.bqw = aVar.bqw;
        this.bqx = aVar.bqx;
        this.bqy = aVar.bqy;
        this.bqz = aVar.bqz;
        this.bqA = aVar.bqA;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bqB = aVar.bqB;
        this.bqD = aVar.bqD;
        this.bqE = aVar.bqE;
        this.bqF = aVar.bqF;
        this.bqG = aVar.bqG;
        this.bqH = aVar.bqH;
        this.bqI = aVar.bqI;
        this.bqJ = aVar.bqJ;
        this.bqK = aVar.bqs;
        this.bqL = aVar.bqL;
        this.bqM = aVar.bqM;
    }
}

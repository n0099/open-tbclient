package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    public static final float bqm = l.aR(TbadkCoreApplication.getInst());
    protected boolean bqB;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bqn = 0.0f;
    protected float bqo = 0.0f;
    protected int aFN = 0;
    protected int bqp = 0;
    protected float bqq = 15.0f;
    protected int bqr = -1;
    protected int bqs = -1;
    protected int mTextColor = -16777216;
    protected int bqt = 200;
    protected int bqu = 200;
    protected int bqv = 0;
    protected int bqw = 0;
    protected boolean bqx = false;
    protected int bqy = -9989158;
    protected ImageView.ScaleType bqz = ImageView.ScaleType.CENTER_CROP;
    protected boolean bqA = false;
    protected int bqC = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds16);
    protected int bqD = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int bqE = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int bqF = 0;
    protected int bqG = -1;
    protected int bqH = -1;
    protected int bqI = -1;
    protected boolean bqJ = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bqp = typedArray.getDimensionPixelSize(e.l.TbRichTextView_segmentMargin, 0);
        this.aFN = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textPadding, 0);
        this.bqn = typedArray.getFloat(e.l.TbRichTextView_lineSpacing, 1.12f);
        this.bqq = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textSize, (int) this.bqq);
        this.mTextColor = typedArray.getColor(e.l.TbRichTextView_textColor, this.mTextColor);
        this.bqt = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageWidth, this.bqt);
        this.bqu = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageHeight, this.bqu);
        this.bqv = typedArray.getResourceId(e.l.TbRichTextView_defaultImage, 0);
        this.bqr = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceWidth, this.bqr);
        this.bqs = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceHeight, this.bqs);
        this.bqw = typedArray.getResourceId(e.l.TbRichTextView_videoImage, 0);
        this.bqx = typedArray.getBoolean(e.l.TbRichTextView_singleLine, false);
        this.bqH = this.bqp;
    }

    public void release() {
    }

    public void T(int i, int i2) {
        this.bqr = i;
        this.bqs = i2;
    }

    public void gJ(int i) {
        this.bqw = i;
    }

    public void gK(int i) {
        this.bqt = i;
    }

    public void gL(int i) {
        this.bqu = i;
    }

    public void gM(int i) {
        this.bqv = i;
    }

    public void setSupportNoImage() {
        this.bqA = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bqn = f2;
        this.bqo = f;
    }

    public void U(int i, int i2) {
        this.bqC = i;
        this.bqD = i2;
    }

    public void gN(int i) {
        this.bqE = i;
    }

    public void gO(int i) {
        this.bqp = i;
    }

    public void gP(int i) {
        this.bqF = i;
    }

    public void gQ(int i) {
        this.bqG = i;
    }

    public void gR(int i) {
        this.bqH = i;
    }

    public void gS(int i) {
        this.bqI = i;
    }

    public void setTextSize(int i) {
        this.bqq = i;
    }

    public boolean RY() {
        return this.bqJ;
    }

    public void cZ(boolean z) {
        this.bqJ = z;
    }

    public void da(boolean z) {
        this.bqB = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bqB || i3 <= i5 || bqm <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bqm <= i3) {
                if (i5 * bqm > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bqm);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bqn = aVar.bqn;
        this.bqo = aVar.bqo;
        this.aFN = aVar.aFN;
        this.bqp = aVar.bqp;
        this.bqq = aVar.bqq;
        this.bqr = aVar.bqr;
        this.bqs = aVar.bqs;
        this.mTextColor = aVar.mTextColor;
        this.bqt = aVar.bqt;
        this.bqu = aVar.bqu;
        this.bqv = aVar.bqv;
        this.bqw = aVar.bqw;
        this.bqx = aVar.bqx;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bqy = aVar.bqy;
        this.bqA = aVar.bqA;
        this.bqB = aVar.bqB;
        this.bqC = aVar.bqC;
        this.bqD = aVar.bqD;
        this.bqE = aVar.bqE;
        this.bqF = aVar.bqF;
        this.bqG = aVar.bqG;
        this.bqH = aVar.bqp;
        this.bqI = aVar.bqI;
        this.bqJ = aVar.bqJ;
    }
}

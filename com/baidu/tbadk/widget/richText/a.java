package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    public static final float bre = l.aR(TbadkCoreApplication.getInst());
    protected boolean brt;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float brf = 0.0f;
    protected float brg = 0.0f;
    protected int aGr = 0;
    protected int brh = 0;
    protected float bri = 15.0f;
    protected int brj = -1;
    protected int brk = -1;
    protected int mTextColor = -16777216;
    protected int brl = 200;
    protected int brm = 200;
    protected int brn = 0;
    protected int bro = 0;
    protected boolean brp = false;
    protected int brq = -9989158;
    protected ImageView.ScaleType brr = ImageView.ScaleType.CENTER_CROP;
    protected boolean brs = false;
    protected int bru = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds16);
    protected int brv = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int brw = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int brx = 0;
    protected int bry = -1;
    protected int brz = -1;
    protected int brA = -1;
    protected boolean brB = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.brh = typedArray.getDimensionPixelSize(e.l.TbRichTextView_segmentMargin, 0);
        this.aGr = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textPadding, 0);
        this.brf = typedArray.getFloat(e.l.TbRichTextView_lineSpacing, 1.12f);
        this.bri = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textSize, (int) this.bri);
        this.mTextColor = typedArray.getColor(e.l.TbRichTextView_textColor, this.mTextColor);
        this.brl = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageWidth, this.brl);
        this.brm = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageHeight, this.brm);
        this.brn = typedArray.getResourceId(e.l.TbRichTextView_defaultImage, 0);
        this.brj = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceWidth, this.brj);
        this.brk = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceHeight, this.brk);
        this.bro = typedArray.getResourceId(e.l.TbRichTextView_videoImage, 0);
        this.brp = typedArray.getBoolean(e.l.TbRichTextView_singleLine, false);
        this.brz = this.brh;
    }

    public void release() {
    }

    public void T(int i, int i2) {
        this.brj = i;
        this.brk = i2;
    }

    public void gK(int i) {
        this.bro = i;
    }

    public void gL(int i) {
        this.brl = i;
    }

    public void gM(int i) {
        this.brm = i;
    }

    public void gN(int i) {
        this.brn = i;
    }

    public void setSupportNoImage() {
        this.brs = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.brf = f2;
        this.brg = f;
    }

    public void U(int i, int i2) {
        this.bru = i;
        this.brv = i2;
    }

    public void gO(int i) {
        this.brw = i;
    }

    public void gP(int i) {
        this.brh = i;
    }

    public void gQ(int i) {
        this.brx = i;
    }

    public void gR(int i) {
        this.bry = i;
    }

    public void gS(int i) {
        this.brz = i;
    }

    public void gT(int i) {
        this.brA = i;
    }

    public void setTextSize(int i) {
        this.bri = i;
    }

    public boolean Sw() {
        return this.brB;
    }

    public void dc(boolean z) {
        this.brB = z;
    }

    public void dd(boolean z) {
        this.brt = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.brt || i3 <= i5 || bre <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bre <= i3) {
                if (i5 * bre > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bre);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.brf = aVar.brf;
        this.brg = aVar.brg;
        this.aGr = aVar.aGr;
        this.brh = aVar.brh;
        this.bri = aVar.bri;
        this.brj = aVar.brj;
        this.brk = aVar.brk;
        this.mTextColor = aVar.mTextColor;
        this.brl = aVar.brl;
        this.brm = aVar.brm;
        this.brn = aVar.brn;
        this.bro = aVar.bro;
        this.brp = aVar.brp;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.brq = aVar.brq;
        this.brs = aVar.brs;
        this.brt = aVar.brt;
        this.bru = aVar.bru;
        this.brv = aVar.brv;
        this.brw = aVar.brw;
        this.brx = aVar.brx;
        this.bry = aVar.bry;
        this.brz = aVar.brh;
        this.brA = aVar.brA;
        this.brB = aVar.brB;
    }
}

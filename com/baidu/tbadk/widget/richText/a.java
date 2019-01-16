package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    public static final float brd = l.aR(TbadkCoreApplication.getInst());
    protected boolean brs;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bre = 0.0f;
    protected float brf = 0.0f;
    protected int aGq = 0;
    protected int brg = 0;
    protected float brh = 15.0f;
    protected int bri = -1;
    protected int brj = -1;
    protected int mTextColor = -16777216;
    protected int brk = 200;
    protected int brl = 200;
    protected int brm = 0;
    protected int brn = 0;
    protected boolean bro = false;
    protected int brp = -9989158;
    protected ImageView.ScaleType brq = ImageView.ScaleType.CENTER_CROP;
    protected boolean brr = false;
    protected int brt = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds16);
    protected int bru = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int brv = l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds20);
    protected int brw = 0;
    protected int brx = -1;
    protected int bry = -1;
    protected int brz = -1;
    protected boolean brA = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.brg = typedArray.getDimensionPixelSize(e.l.TbRichTextView_segmentMargin, 0);
        this.aGq = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textPadding, 0);
        this.bre = typedArray.getFloat(e.l.TbRichTextView_lineSpacing, 1.12f);
        this.brh = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textSize, (int) this.brh);
        this.mTextColor = typedArray.getColor(e.l.TbRichTextView_textColor, this.mTextColor);
        this.brk = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageWidth, this.brk);
        this.brl = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageHeight, this.brl);
        this.brm = typedArray.getResourceId(e.l.TbRichTextView_defaultImage, 0);
        this.bri = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceWidth, this.bri);
        this.brj = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceHeight, this.brj);
        this.brn = typedArray.getResourceId(e.l.TbRichTextView_videoImage, 0);
        this.bro = typedArray.getBoolean(e.l.TbRichTextView_singleLine, false);
        this.bry = this.brg;
    }

    public void release() {
    }

    public void T(int i, int i2) {
        this.bri = i;
        this.brj = i2;
    }

    public void gK(int i) {
        this.brn = i;
    }

    public void gL(int i) {
        this.brk = i;
    }

    public void gM(int i) {
        this.brl = i;
    }

    public void gN(int i) {
        this.brm = i;
    }

    public void setSupportNoImage() {
        this.brr = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bre = f2;
        this.brf = f;
    }

    public void U(int i, int i2) {
        this.brt = i;
        this.bru = i2;
    }

    public void gO(int i) {
        this.brv = i;
    }

    public void gP(int i) {
        this.brg = i;
    }

    public void gQ(int i) {
        this.brw = i;
    }

    public void gR(int i) {
        this.brx = i;
    }

    public void gS(int i) {
        this.bry = i;
    }

    public void gT(int i) {
        this.brz = i;
    }

    public void setTextSize(int i) {
        this.brh = i;
    }

    public boolean Sw() {
        return this.brA;
    }

    public void dc(boolean z) {
        this.brA = z;
    }

    public void dd(boolean z) {
        this.brs = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.brs || i3 <= i5 || brd <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * brd <= i3) {
                if (i5 * brd > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * brd);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bre = aVar.bre;
        this.brf = aVar.brf;
        this.aGq = aVar.aGq;
        this.brg = aVar.brg;
        this.brh = aVar.brh;
        this.bri = aVar.bri;
        this.brj = aVar.brj;
        this.mTextColor = aVar.mTextColor;
        this.brk = aVar.brk;
        this.brl = aVar.brl;
        this.brm = aVar.brm;
        this.brn = aVar.brn;
        this.bro = aVar.bro;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.brp = aVar.brp;
        this.brr = aVar.brr;
        this.brs = aVar.brs;
        this.brt = aVar.brt;
        this.bru = aVar.bru;
        this.brv = aVar.brv;
        this.brw = aVar.brw;
        this.brx = aVar.brx;
        this.bry = aVar.brg;
        this.brz = aVar.brz;
        this.brA = aVar.brA;
    }
}

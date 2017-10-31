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
    public static final float aQZ = l.af(TbadkCoreApplication.getInst());
    protected boolean aRo;
    protected TbImageView.b mOnDrawListener;
    protected float aRa = 0.0f;
    protected float aRb = 0.0f;
    protected int aRc = 0;
    protected int aRd = 0;
    protected float aRe = 15.0f;
    protected int aRf = -1;
    protected int aRg = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int aRh = 200;
    protected int aRi = 200;
    protected int VF = 0;
    protected int aRj = 0;
    protected boolean aRk = false;
    protected int aRl = -9989158;
    protected ImageView.ScaleType aRm = ImageView.ScaleType.CENTER_CROP;
    protected boolean aRn = false;
    protected int aRp = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int aRq = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aRr = 0;
    protected int aRs = -1;
    protected int aRt = -1;
    protected int aRu = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void a(TypedArray typedArray) {
        this.aRd = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.aRc = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.aRa = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.aRe = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.aRe);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.aRh = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.aRh);
        this.aRi = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.aRi);
        this.VF = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.aRf = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.aRf);
        this.aRg = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.aRg);
        this.aRj = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.aRk = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.aRt = this.aRd;
    }

    public void release() {
    }

    public void I(float f) {
        this.aRa = f;
    }

    public void Q(int i, int i2) {
        this.aRf = i;
        this.aRg = i2;
    }

    public void fM(int i) {
        this.aRj = i;
    }

    public void fN(int i) {
        this.aRh = i;
    }

    public void fO(int i) {
        this.aRi = i;
    }

    public void fP(int i) {
        this.VF = i;
    }

    public void IH() {
        this.aRn = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.aRa = f2;
        this.aRb = f;
    }

    public void R(int i, int i2) {
        this.aRp = i;
        this.aRq = i2;
    }

    public void fQ(int i) {
        this.aRr = i;
    }

    public void fR(int i) {
        this.aRs = i;
    }

    public void fS(int i) {
        this.aRt = i;
    }

    public void fT(int i) {
        this.aRu = i;
    }

    public void cb(boolean z) {
        this.aRo = z;
    }

    public int[] l(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aRo || i3 <= i5 || aQZ <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aQZ <= i3) {
                if (i5 * aQZ > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aQZ);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.aRa = aVar.aRa;
        this.aRb = aVar.aRb;
        this.aRc = aVar.aRc;
        this.aRd = aVar.aRd;
        this.aRe = aVar.aRe;
        this.aRf = aVar.aRf;
        this.aRg = aVar.aRg;
        this.mTextColor = aVar.mTextColor;
        this.aRh = aVar.aRh;
        this.aRi = aVar.aRi;
        this.VF = aVar.VF;
        this.aRj = aVar.aRj;
        this.aRk = aVar.aRk;
        this.aRl = aVar.aRl;
        this.aRn = aVar.aRn;
        this.aRo = aVar.aRo;
        this.aRp = aVar.aRp;
        this.aRq = aVar.aRq;
        this.aRr = aVar.aRr;
        this.aRs = aVar.aRs;
        this.aRt = aVar.aRd;
        this.aRu = aVar.aRu;
    }
}

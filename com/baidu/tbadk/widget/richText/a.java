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
    public static final float aRh = l.af(TbadkCoreApplication.getInst());
    protected boolean aRw;
    protected TbImageView.b mOnDrawListener;
    protected float aRi = 0.0f;
    protected float aRj = 0.0f;
    protected int aRk = 0;
    protected int aRl = 0;
    protected float aRm = 15.0f;
    protected int aRn = -1;
    protected int aRo = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int aRp = 200;
    protected int aRq = 200;
    protected int VF = 0;
    protected int aRr = 0;
    protected boolean aRs = false;
    protected int aRt = -9989158;
    protected ImageView.ScaleType aRu = ImageView.ScaleType.CENTER_CROP;
    protected boolean aRv = false;
    protected int aRx = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int aRy = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aRz = 0;
    protected int aRA = -1;
    protected int aRB = -1;
    protected int aRC = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void a(TypedArray typedArray) {
        this.aRl = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.aRk = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.aRi = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.aRm = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.aRm);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.aRp = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.aRp);
        this.aRq = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.aRq);
        this.VF = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.aRn = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.aRn);
        this.aRo = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.aRo);
        this.aRr = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.aRs = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.aRB = this.aRl;
    }

    public void release() {
    }

    public void I(float f) {
        this.aRi = f;
    }

    public void Q(int i, int i2) {
        this.aRn = i;
        this.aRo = i2;
    }

    public void fL(int i) {
        this.aRr = i;
    }

    public void fM(int i) {
        this.aRp = i;
    }

    public void fN(int i) {
        this.aRq = i;
    }

    public void fO(int i) {
        this.VF = i;
    }

    public void IS() {
        this.aRv = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.aRi = f2;
        this.aRj = f;
    }

    public void R(int i, int i2) {
        this.aRx = i;
        this.aRy = i2;
    }

    public void fP(int i) {
        this.aRz = i;
    }

    public void fQ(int i) {
        this.aRA = i;
    }

    public void fR(int i) {
        this.aRB = i;
    }

    public void fS(int i) {
        this.aRC = i;
    }

    public void cc(boolean z) {
        this.aRw = z;
    }

    public int[] l(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aRw || i3 <= i5 || aRh <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aRh <= i3) {
                if (i5 * aRh > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aRh);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.aRi = aVar.aRi;
        this.aRj = aVar.aRj;
        this.aRk = aVar.aRk;
        this.aRl = aVar.aRl;
        this.aRm = aVar.aRm;
        this.aRn = aVar.aRn;
        this.aRo = aVar.aRo;
        this.mTextColor = aVar.mTextColor;
        this.aRp = aVar.aRp;
        this.aRq = aVar.aRq;
        this.VF = aVar.VF;
        this.aRr = aVar.aRr;
        this.aRs = aVar.aRs;
        this.aRt = aVar.aRt;
        this.aRv = aVar.aRv;
        this.aRw = aVar.aRw;
        this.aRx = aVar.aRx;
        this.aRy = aVar.aRy;
        this.aRz = aVar.aRz;
        this.aRA = aVar.aRA;
        this.aRB = aVar.aRl;
        this.aRC = aVar.aRC;
    }
}

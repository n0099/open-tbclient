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
    public static final float aUY = l.ai(TbadkCoreApplication.getInst());
    protected boolean aVo;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float aUZ = 0.0f;
    protected float aVa = 0.0f;
    protected int aVb = 0;
    protected int aVc = 0;
    protected float aVd = 15.0f;
    protected int aVe = -1;
    protected int aVf = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int aVg = 200;
    protected int aVh = 200;
    protected int aVi = 0;
    protected int aVj = 0;
    protected boolean aVk = false;
    protected int aVl = -9989158;
    protected ImageView.ScaleType aVm = ImageView.ScaleType.CENTER_CROP;
    protected boolean aVn = false;
    protected int aVp = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int aVq = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aVr = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aVs = 0;
    protected int aVt = -1;
    protected int aVu = -1;
    protected int aVv = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.aVc = typedArray.getDimensionPixelSize(d.m.TbRichTextView_segmentMargin, 0);
        this.aVb = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textPadding, 0);
        this.aUZ = typedArray.getFloat(d.m.TbRichTextView_lineSpacing, 1.12f);
        this.aVd = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textSize, (int) this.aVd);
        this.mTextColor = typedArray.getColor(d.m.TbRichTextView_textColor, this.mTextColor);
        this.aVg = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageWidth, this.aVg);
        this.aVh = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageHeight, this.aVh);
        this.aVi = typedArray.getResourceId(d.m.TbRichTextView_defaultImage, 0);
        this.aVe = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceWidth, this.aVe);
        this.aVf = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceHeight, this.aVf);
        this.aVj = typedArray.getResourceId(d.m.TbRichTextView_videoImage, 0);
        this.aVk = typedArray.getBoolean(d.m.TbRichTextView_singleLine, false);
        this.aVu = this.aVc;
    }

    public void release() {
    }

    public void N(int i, int i2) {
        this.aVe = i;
        this.aVf = i2;
    }

    public void fL(int i) {
        this.aVj = i;
    }

    public void fM(int i) {
        this.aVg = i;
    }

    public void fN(int i) {
        this.aVh = i;
    }

    public void fO(int i) {
        this.aVi = i;
    }

    public void setSupportNoImage() {
        this.aVn = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.aUZ = f2;
        this.aVa = f;
    }

    public void O(int i, int i2) {
        this.aVp = i;
        this.aVq = i2;
    }

    public void fP(int i) {
        this.aVr = i;
    }

    public void fQ(int i) {
        this.aVs = i;
    }

    public void fR(int i) {
        this.aVt = i;
    }

    public void fS(int i) {
        this.aVu = i;
    }

    public void fT(int i) {
        this.aVv = i;
    }

    public void ce(boolean z) {
        this.aVo = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aVo || i3 <= i5 || aUY <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aUY <= i3) {
                if (i5 * aUY > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aUY);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.aUZ = aVar.aUZ;
        this.aVa = aVar.aVa;
        this.aVb = aVar.aVb;
        this.aVc = aVar.aVc;
        this.aVd = aVar.aVd;
        this.aVe = aVar.aVe;
        this.aVf = aVar.aVf;
        this.mTextColor = aVar.mTextColor;
        this.aVg = aVar.aVg;
        this.aVh = aVar.aVh;
        this.aVi = aVar.aVi;
        this.aVj = aVar.aVj;
        this.aVk = aVar.aVk;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.aVl = aVar.aVl;
        this.aVn = aVar.aVn;
        this.aVo = aVar.aVo;
        this.aVp = aVar.aVp;
        this.aVq = aVar.aVq;
        this.aVr = aVar.aVr;
        this.aVs = aVar.aVs;
        this.aVt = aVar.aVt;
        this.aVu = aVar.aVc;
        this.aVv = aVar.aVv;
    }
}

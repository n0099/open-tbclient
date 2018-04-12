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
    public static final float aUX = l.ai(TbadkCoreApplication.getInst());
    protected boolean aVn;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float aUY = 0.0f;
    protected float aUZ = 0.0f;
    protected int aVa = 0;
    protected int aVb = 0;
    protected float aVc = 15.0f;
    protected int aVd = -1;
    protected int aVe = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int aVf = 200;
    protected int aVg = 200;
    protected int aVh = 0;
    protected int aVi = 0;
    protected boolean aVj = false;
    protected int aVk = -9989158;
    protected ImageView.ScaleType aVl = ImageView.ScaleType.CENTER_CROP;
    protected boolean aVm = false;
    protected int aVo = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int aVp = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aVq = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aVr = 0;
    protected int aVs = -1;
    protected int aVt = -1;
    protected int aVu = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.aVb = typedArray.getDimensionPixelSize(d.m.TbRichTextView_segmentMargin, 0);
        this.aVa = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textPadding, 0);
        this.aUY = typedArray.getFloat(d.m.TbRichTextView_lineSpacing, 1.12f);
        this.aVc = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textSize, (int) this.aVc);
        this.mTextColor = typedArray.getColor(d.m.TbRichTextView_textColor, this.mTextColor);
        this.aVf = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageWidth, this.aVf);
        this.aVg = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageHeight, this.aVg);
        this.aVh = typedArray.getResourceId(d.m.TbRichTextView_defaultImage, 0);
        this.aVd = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceWidth, this.aVd);
        this.aVe = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceHeight, this.aVe);
        this.aVi = typedArray.getResourceId(d.m.TbRichTextView_videoImage, 0);
        this.aVj = typedArray.getBoolean(d.m.TbRichTextView_singleLine, false);
        this.aVt = this.aVb;
    }

    public void release() {
    }

    public void N(int i, int i2) {
        this.aVd = i;
        this.aVe = i2;
    }

    public void fL(int i) {
        this.aVi = i;
    }

    public void fM(int i) {
        this.aVf = i;
    }

    public void fN(int i) {
        this.aVg = i;
    }

    public void fO(int i) {
        this.aVh = i;
    }

    public void setSupportNoImage() {
        this.aVm = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.aUY = f2;
        this.aUZ = f;
    }

    public void O(int i, int i2) {
        this.aVo = i;
        this.aVp = i2;
    }

    public void fP(int i) {
        this.aVq = i;
    }

    public void fQ(int i) {
        this.aVr = i;
    }

    public void fR(int i) {
        this.aVs = i;
    }

    public void fS(int i) {
        this.aVt = i;
    }

    public void fT(int i) {
        this.aVu = i;
    }

    public void ce(boolean z) {
        this.aVn = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aVn || i3 <= i5 || aUX <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aUX <= i3) {
                if (i5 * aUX > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aUX);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.aUY = aVar.aUY;
        this.aUZ = aVar.aUZ;
        this.aVa = aVar.aVa;
        this.aVb = aVar.aVb;
        this.aVc = aVar.aVc;
        this.aVd = aVar.aVd;
        this.aVe = aVar.aVe;
        this.mTextColor = aVar.mTextColor;
        this.aVf = aVar.aVf;
        this.aVg = aVar.aVg;
        this.aVh = aVar.aVh;
        this.aVi = aVar.aVi;
        this.aVj = aVar.aVj;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.aVk = aVar.aVk;
        this.aVm = aVar.aVm;
        this.aVn = aVar.aVn;
        this.aVo = aVar.aVo;
        this.aVp = aVar.aVp;
        this.aVq = aVar.aVq;
        this.aVr = aVar.aVr;
        this.aVs = aVar.aVs;
        this.aVt = aVar.aVb;
        this.aVu = aVar.aVu;
    }
}

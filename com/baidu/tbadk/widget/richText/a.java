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
    public static final float bdc = l.ak(TbadkCoreApplication.getInst());
    protected boolean bds;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bdd = 0.0f;
    protected float bde = 0.0f;
    protected int bdf = 0;
    protected int bdg = 0;
    protected float bdh = 15.0f;
    protected int bdi = -1;
    protected int bdj = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bdk = 200;
    protected int bdl = 200;
    protected int bdm = 0;
    protected int bdn = 0;
    protected boolean bdo = false;
    protected int bdp = -9989158;
    protected ImageView.ScaleType bdq = ImageView.ScaleType.CENTER_CROP;
    protected boolean bdr = false;
    protected int bdt = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int bdu = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bdv = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int bdw = 0;
    protected int bdx = -1;
    protected int bdy = -1;
    protected int bdz = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bdg = typedArray.getDimensionPixelSize(d.m.TbRichTextView_segmentMargin, 0);
        this.bdf = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textPadding, 0);
        this.bdd = typedArray.getFloat(d.m.TbRichTextView_lineSpacing, 1.12f);
        this.bdh = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textSize, (int) this.bdh);
        this.mTextColor = typedArray.getColor(d.m.TbRichTextView_textColor, this.mTextColor);
        this.bdk = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageWidth, this.bdk);
        this.bdl = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageHeight, this.bdl);
        this.bdm = typedArray.getResourceId(d.m.TbRichTextView_defaultImage, 0);
        this.bdi = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceWidth, this.bdi);
        this.bdj = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceHeight, this.bdj);
        this.bdn = typedArray.getResourceId(d.m.TbRichTextView_videoImage, 0);
        this.bdo = typedArray.getBoolean(d.m.TbRichTextView_singleLine, false);
        this.bdy = this.bdg;
    }

    public void release() {
    }

    public void O(int i, int i2) {
        this.bdi = i;
        this.bdj = i2;
    }

    public void fM(int i) {
        this.bdn = i;
    }

    public void fN(int i) {
        this.bdk = i;
    }

    public void fO(int i) {
        this.bdl = i;
    }

    public void fP(int i) {
        this.bdm = i;
    }

    public void setSupportNoImage() {
        this.bdr = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bdd = f2;
        this.bde = f;
    }

    public void P(int i, int i2) {
        this.bdt = i;
        this.bdu = i2;
    }

    public void fQ(int i) {
        this.bdv = i;
    }

    public void fR(int i) {
        this.bdw = i;
    }

    public void fS(int i) {
        this.bdx = i;
    }

    public void fT(int i) {
        this.bdy = i;
    }

    public void fU(int i) {
        this.bdz = i;
    }

    public void cj(boolean z) {
        this.bds = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bds || i3 <= i5 || bdc <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bdc <= i3) {
                if (i5 * bdc > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bdc);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bdd = aVar.bdd;
        this.bde = aVar.bde;
        this.bdf = aVar.bdf;
        this.bdg = aVar.bdg;
        this.bdh = aVar.bdh;
        this.bdi = aVar.bdi;
        this.bdj = aVar.bdj;
        this.mTextColor = aVar.mTextColor;
        this.bdk = aVar.bdk;
        this.bdl = aVar.bdl;
        this.bdm = aVar.bdm;
        this.bdn = aVar.bdn;
        this.bdo = aVar.bdo;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bdp = aVar.bdp;
        this.bdr = aVar.bdr;
        this.bds = aVar.bds;
        this.bdt = aVar.bdt;
        this.bdu = aVar.bdu;
        this.bdv = aVar.bdv;
        this.bdw = aVar.bdw;
        this.bdx = aVar.bdx;
        this.bdy = aVar.bdg;
        this.bdz = aVar.bdz;
    }
}

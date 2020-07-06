package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    public static final float eNa = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c ais;
    public int eNA;
    public int eNB;
    protected boolean eNo;
    public int eNz;
    public boolean mIsFromCDN;
    protected float eNb = 0.0f;
    protected float eNc = 0.0f;
    protected int dZh = 0;
    protected int eNd = 0;
    protected float mTextSize = 15.0f;
    protected int eNe = -1;
    protected int eNf = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int eNg = 200;
    protected int eNh = 200;
    protected int eNi = 0;
    protected int eNj = 0;
    protected boolean eNk = false;
    protected int eNl = -9989158;
    protected ImageView.ScaleType eNm = ImageView.ScaleType.CENTER_CROP;
    public boolean eNn = false;
    public int eNp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int eNq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int eNr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int eNs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int eNt = 0;
    protected int eNu = -1;
    protected int eNv = -1;
    protected int eNw = -1;
    protected int eNx = 0;
    protected boolean eNy = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.eNd = typedArray.getDimensionPixelSize(5, 0);
        this.dZh = typedArray.getDimensionPixelSize(2, 0);
        this.eNb = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.eNg = typedArray.getDimensionPixelSize(8, this.eNg);
        this.eNh = typedArray.getDimensionPixelSize(11, this.eNh);
        this.eNi = typedArray.getResourceId(3, 0);
        this.eNe = typedArray.getDimensionPixelSize(10, this.eNe);
        this.eNf = typedArray.getDimensionPixelSize(4, this.eNf);
        this.eNj = typedArray.getResourceId(9, 0);
        this.eNk = typedArray.getBoolean(6, false);
        this.eNv = this.eNd;
    }

    public void release() {
    }

    public void bf(int i, int i2) {
        this.eNe = i;
        this.eNf = i2;
    }

    public void ox(int i) {
        this.eNj = i;
    }

    public void oy(int i) {
        this.eNg = i;
    }

    public void oz(int i) {
        this.eNh = i;
    }

    public void oA(int i) {
        this.eNi = i;
    }

    public void setSupportNoImage() {
        this.eNn = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.eNb = f2;
        this.eNc = f;
    }

    public void bg(int i, int i2) {
        this.eNp = i;
        this.eNq = i2;
    }

    public void oB(int i) {
        this.eNr = i;
    }

    public void oC(int i) {
        this.eNs = i;
    }

    public void oD(int i) {
        this.eNd = i;
    }

    public void oE(int i) {
        this.eNt = i;
    }

    public void oF(int i) {
        this.eNu = i;
    }

    public void oG(int i) {
        this.eNv = i;
    }

    public void oH(int i) {
        this.eNw = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bkO() {
        return this.eNy;
    }

    public void iS(boolean z) {
        this.eNy = z;
    }

    public void iT(boolean z) {
        this.eNo = z;
    }

    public void oI(int i) {
        this.eNx = i;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.eNo || i3 <= i5 || eNa <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * eNa <= i3) {
                if (i5 * eNa > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * eNa);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.eNb = aVar.eNb;
        this.eNc = aVar.eNc;
        this.dZh = aVar.dZh;
        this.eNd = aVar.eNd;
        this.mTextSize = aVar.mTextSize;
        this.eNe = aVar.eNe;
        this.eNf = aVar.eNf;
        this.mTextColor = aVar.mTextColor;
        this.eNg = aVar.eNg;
        this.eNh = aVar.eNh;
        this.eNi = aVar.eNi;
        this.eNj = aVar.eNj;
        this.eNk = aVar.eNk;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.eNl = aVar.eNl;
        this.eNn = aVar.eNn;
        this.eNo = aVar.eNo;
        this.eNp = aVar.eNp;
        this.eNq = aVar.eNq;
        this.eNs = aVar.eNs;
        this.eNt = aVar.eNt;
        this.eNu = aVar.eNu;
        this.eNv = aVar.eNd;
        this.eNw = aVar.eNw;
        this.eNy = aVar.eNy;
    }
}

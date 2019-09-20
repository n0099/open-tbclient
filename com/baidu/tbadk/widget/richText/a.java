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
    public static final float cMr = l.ai(TbadkCoreApplication.getInst());
    protected boolean cMG;
    public int cMQ;
    public int cMR;
    public int cMS;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cMs = 0.0f;
    protected float cMt = 0.0f;
    protected int bYs = 0;
    protected int cMu = 0;
    protected float cMv = 15.0f;
    protected int cMw = -1;
    protected int cMx = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cMy = 200;
    protected int cMz = 200;
    protected int cMA = 0;
    protected int cMB = 0;
    protected boolean cMC = false;
    protected int cMD = -9989158;
    protected ImageView.ScaleType cME = ImageView.ScaleType.CENTER_CROP;
    public boolean cMF = false;
    public int cMH = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int cMI = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int cMJ = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int cMK = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int cML = 0;
    protected int cMM = -1;
    protected int cMN = -1;
    protected int cMO = -1;
    protected boolean cMP = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cMu = typedArray.getDimensionPixelSize(4, 0);
        this.bYs = typedArray.getDimensionPixelSize(1, 0);
        this.cMs = typedArray.getFloat(12, 1.12f);
        this.cMv = typedArray.getDimensionPixelSize(11, (int) this.cMv);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.cMy = typedArray.getDimensionPixelSize(7, this.cMy);
        this.cMz = typedArray.getDimensionPixelSize(10, this.cMz);
        this.cMA = typedArray.getResourceId(2, 0);
        this.cMw = typedArray.getDimensionPixelSize(9, this.cMw);
        this.cMx = typedArray.getDimensionPixelSize(3, this.cMx);
        this.cMB = typedArray.getResourceId(8, 0);
        this.cMC = typedArray.getBoolean(5, false);
        this.cMN = this.cMu;
    }

    public void release() {
    }

    public void av(int i, int i2) {
        this.cMw = i;
        this.cMx = i2;
    }

    public void lx(int i) {
        this.cMB = i;
    }

    public void ly(int i) {
        this.cMy = i;
    }

    public void lz(int i) {
        this.cMz = i;
    }

    public void lA(int i) {
        this.cMA = i;
    }

    public void setSupportNoImage() {
        this.cMF = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cMs = f2;
        this.cMt = f;
    }

    public void aw(int i, int i2) {
        this.cMH = i;
        this.cMI = i2;
    }

    public void lB(int i) {
        this.cMJ = i;
    }

    public void lC(int i) {
        this.cMK = i;
    }

    public void lD(int i) {
        this.cMu = i;
    }

    public void lE(int i) {
        this.cML = i;
    }

    public void lF(int i) {
        this.cMM = i;
    }

    public void lG(int i) {
        this.cMN = i;
    }

    public void lH(int i) {
        this.cMO = i;
    }

    public void setTextSize(int i) {
        this.cMv = i;
    }

    public boolean ayY() {
        return this.cMP;
    }

    public void fW(boolean z) {
        this.cMP = z;
    }

    public void fX(boolean z) {
        this.cMG = z;
    }

    public int[] s(int i, int i2, int i3, int i4) {
        int[] e = l.e(i, i2, i3, i4);
        if (e == null) {
            return null;
        }
        int[] iArr = {e[0], e[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cMG || i3 <= i5 || cMr <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cMr <= i3) {
                if (i5 * cMr > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cMr);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cMs = aVar.cMs;
        this.cMt = aVar.cMt;
        this.bYs = aVar.bYs;
        this.cMu = aVar.cMu;
        this.cMv = aVar.cMv;
        this.cMw = aVar.cMw;
        this.cMx = aVar.cMx;
        this.mTextColor = aVar.mTextColor;
        this.cMy = aVar.cMy;
        this.cMz = aVar.cMz;
        this.cMA = aVar.cMA;
        this.cMB = aVar.cMB;
        this.cMC = aVar.cMC;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cMD = aVar.cMD;
        this.cMF = aVar.cMF;
        this.cMG = aVar.cMG;
        this.cMH = aVar.cMH;
        this.cMI = aVar.cMI;
        this.cMK = aVar.cMK;
        this.cML = aVar.cML;
        this.cMM = aVar.cMM;
        this.cMN = aVar.cMu;
        this.cMO = aVar.cMO;
        this.cMP = aVar.cMP;
    }
}

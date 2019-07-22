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
    public static final float cLu = l.ai(TbadkCoreApplication.getInst());
    protected boolean cLJ;
    public int cLT;
    public int cLU;
    public int cLV;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cLv = 0.0f;
    protected float cLw = 0.0f;
    protected int bXt = 0;
    protected int cLx = 0;
    protected float cLy = 15.0f;
    protected int cLz = -1;
    protected int cLA = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cLB = 200;
    protected int cLC = 200;
    protected int cLD = 0;
    protected int cLE = 0;
    protected boolean cLF = false;
    protected int cLG = -9989158;
    protected ImageView.ScaleType cLH = ImageView.ScaleType.CENTER_CROP;
    public boolean cLI = false;
    public int cLK = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int cLL = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int cLM = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int cLN = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int cLO = 0;
    protected int cLP = -1;
    protected int cLQ = -1;
    protected int cLR = -1;
    protected boolean cLS = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cLx = typedArray.getDimensionPixelSize(4, 0);
        this.bXt = typedArray.getDimensionPixelSize(1, 0);
        this.cLv = typedArray.getFloat(12, 1.12f);
        this.cLy = typedArray.getDimensionPixelSize(11, (int) this.cLy);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.cLB = typedArray.getDimensionPixelSize(7, this.cLB);
        this.cLC = typedArray.getDimensionPixelSize(10, this.cLC);
        this.cLD = typedArray.getResourceId(2, 0);
        this.cLz = typedArray.getDimensionPixelSize(9, this.cLz);
        this.cLA = typedArray.getDimensionPixelSize(3, this.cLA);
        this.cLE = typedArray.getResourceId(8, 0);
        this.cLF = typedArray.getBoolean(5, false);
        this.cLQ = this.cLx;
    }

    public void release() {
    }

    public void av(int i, int i2) {
        this.cLz = i;
        this.cLA = i2;
    }

    public void ls(int i) {
        this.cLE = i;
    }

    public void lt(int i) {
        this.cLB = i;
    }

    public void lu(int i) {
        this.cLC = i;
    }

    public void lv(int i) {
        this.cLD = i;
    }

    public void setSupportNoImage() {
        this.cLI = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cLv = f2;
        this.cLw = f;
    }

    public void aw(int i, int i2) {
        this.cLK = i;
        this.cLL = i2;
    }

    public void lw(int i) {
        this.cLM = i;
    }

    public void lx(int i) {
        this.cLN = i;
    }

    public void ly(int i) {
        this.cLx = i;
    }

    public void lz(int i) {
        this.cLO = i;
    }

    public void lA(int i) {
        this.cLP = i;
    }

    public void lB(int i) {
        this.cLQ = i;
    }

    public void lC(int i) {
        this.cLR = i;
    }

    public void setTextSize(int i) {
        this.cLy = i;
    }

    public boolean ayK() {
        return this.cLS;
    }

    public void fT(boolean z) {
        this.cLS = z;
    }

    public void fU(boolean z) {
        this.cLJ = z;
    }

    public int[] p(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cLJ || i3 <= i5 || cLu <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cLu <= i3) {
                if (i5 * cLu > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cLu);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cLv = aVar.cLv;
        this.cLw = aVar.cLw;
        this.bXt = aVar.bXt;
        this.cLx = aVar.cLx;
        this.cLy = aVar.cLy;
        this.cLz = aVar.cLz;
        this.cLA = aVar.cLA;
        this.mTextColor = aVar.mTextColor;
        this.cLB = aVar.cLB;
        this.cLC = aVar.cLC;
        this.cLD = aVar.cLD;
        this.cLE = aVar.cLE;
        this.cLF = aVar.cLF;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cLG = aVar.cLG;
        this.cLI = aVar.cLI;
        this.cLJ = aVar.cLJ;
        this.cLK = aVar.cLK;
        this.cLL = aVar.cLL;
        this.cLN = aVar.cLN;
        this.cLO = aVar.cLO;
        this.cLP = aVar.cLP;
        this.cLQ = aVar.cLx;
        this.cLR = aVar.cLR;
        this.cLS = aVar.cLS;
    }
}

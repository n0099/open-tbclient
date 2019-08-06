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
    public static final float cLB = l.ai(TbadkCoreApplication.getInst());
    protected boolean cLQ;
    public int cMa;
    public int cMb;
    public int cMc;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cLC = 0.0f;
    protected float cLD = 0.0f;
    protected int bXz = 0;
    protected int cLE = 0;
    protected float cLF = 15.0f;
    protected int cLG = -1;
    protected int cLH = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cLI = 200;
    protected int cLJ = 200;
    protected int cLK = 0;
    protected int cLL = 0;
    protected boolean cLM = false;
    protected int cLN = -9989158;
    protected ImageView.ScaleType cLO = ImageView.ScaleType.CENTER_CROP;
    public boolean cLP = false;
    public int cLR = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int cLS = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int cLT = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int cLU = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int cLV = 0;
    protected int cLW = -1;
    protected int cLX = -1;
    protected int cLY = -1;
    protected boolean cLZ = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cLE = typedArray.getDimensionPixelSize(4, 0);
        this.bXz = typedArray.getDimensionPixelSize(1, 0);
        this.cLC = typedArray.getFloat(12, 1.12f);
        this.cLF = typedArray.getDimensionPixelSize(11, (int) this.cLF);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.cLI = typedArray.getDimensionPixelSize(7, this.cLI);
        this.cLJ = typedArray.getDimensionPixelSize(10, this.cLJ);
        this.cLK = typedArray.getResourceId(2, 0);
        this.cLG = typedArray.getDimensionPixelSize(9, this.cLG);
        this.cLH = typedArray.getDimensionPixelSize(3, this.cLH);
        this.cLL = typedArray.getResourceId(8, 0);
        this.cLM = typedArray.getBoolean(5, false);
        this.cLX = this.cLE;
    }

    public void release() {
    }

    public void av(int i, int i2) {
        this.cLG = i;
        this.cLH = i2;
    }

    public void lt(int i) {
        this.cLL = i;
    }

    public void lu(int i) {
        this.cLI = i;
    }

    public void lv(int i) {
        this.cLJ = i;
    }

    public void lw(int i) {
        this.cLK = i;
    }

    public void setSupportNoImage() {
        this.cLP = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cLC = f2;
        this.cLD = f;
    }

    public void aw(int i, int i2) {
        this.cLR = i;
        this.cLS = i2;
    }

    public void lx(int i) {
        this.cLT = i;
    }

    public void ly(int i) {
        this.cLU = i;
    }

    public void lz(int i) {
        this.cLE = i;
    }

    public void lA(int i) {
        this.cLV = i;
    }

    public void lB(int i) {
        this.cLW = i;
    }

    public void lC(int i) {
        this.cLX = i;
    }

    public void lD(int i) {
        this.cLY = i;
    }

    public void setTextSize(int i) {
        this.cLF = i;
    }

    public boolean ayM() {
        return this.cLZ;
    }

    public void fT(boolean z) {
        this.cLZ = z;
    }

    public void fU(boolean z) {
        this.cLQ = z;
    }

    public int[] p(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cLQ || i3 <= i5 || cLB <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cLB <= i3) {
                if (i5 * cLB > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cLB);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cLC = aVar.cLC;
        this.cLD = aVar.cLD;
        this.bXz = aVar.bXz;
        this.cLE = aVar.cLE;
        this.cLF = aVar.cLF;
        this.cLG = aVar.cLG;
        this.cLH = aVar.cLH;
        this.mTextColor = aVar.mTextColor;
        this.cLI = aVar.cLI;
        this.cLJ = aVar.cLJ;
        this.cLK = aVar.cLK;
        this.cLL = aVar.cLL;
        this.cLM = aVar.cLM;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cLN = aVar.cLN;
        this.cLP = aVar.cLP;
        this.cLQ = aVar.cLQ;
        this.cLR = aVar.cLR;
        this.cLS = aVar.cLS;
        this.cLU = aVar.cLU;
        this.cLV = aVar.cLV;
        this.cLW = aVar.cLW;
        this.cLX = aVar.cLE;
        this.cLY = aVar.cLY;
        this.cLZ = aVar.cLZ;
    }
}

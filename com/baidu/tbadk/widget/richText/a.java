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
    public static final float dNB = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c NT;
    protected boolean dNP;
    public int dNZ;
    public int dOa;
    public int dOb;
    public boolean mIsFromCDN;
    protected float dNC = 0.0f;
    protected float dND = 0.0f;
    protected int dea = 0;
    protected int dNE = 0;
    protected float mTextSize = 15.0f;
    protected int dNF = -1;
    protected int dNG = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int dNH = 200;
    protected int dNI = 200;
    protected int dNJ = 0;
    protected int dNK = 0;
    protected boolean dNL = false;
    protected int dNM = -9989158;
    protected ImageView.ScaleType dNN = ImageView.ScaleType.CENTER_CROP;
    public boolean dNO = false;
    public int dNQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int dNR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int dNS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int dNT = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int dNU = 0;
    protected int dNV = -1;
    protected int dNW = -1;
    protected int dNX = -1;
    protected boolean dNY = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.dNE = typedArray.getDimensionPixelSize(5, 0);
        this.dea = typedArray.getDimensionPixelSize(2, 0);
        this.dNC = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.dNH = typedArray.getDimensionPixelSize(8, this.dNH);
        this.dNI = typedArray.getDimensionPixelSize(11, this.dNI);
        this.dNJ = typedArray.getResourceId(3, 0);
        this.dNF = typedArray.getDimensionPixelSize(10, this.dNF);
        this.dNG = typedArray.getDimensionPixelSize(4, this.dNG);
        this.dNK = typedArray.getResourceId(9, 0);
        this.dNL = typedArray.getBoolean(6, false);
        this.dNW = this.dNE;
    }

    public void release() {
    }

    public void aS(int i, int i2) {
        this.dNF = i;
        this.dNG = i2;
    }

    public void nh(int i) {
        this.dNK = i;
    }

    public void ni(int i) {
        this.dNH = i;
    }

    public void nj(int i) {
        this.dNI = i;
    }

    public void nk(int i) {
        this.dNJ = i;
    }

    public void setSupportNoImage() {
        this.dNO = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.dNC = f2;
        this.dND = f;
    }

    public void aT(int i, int i2) {
        this.dNQ = i;
        this.dNR = i2;
    }

    public void nl(int i) {
        this.dNS = i;
    }

    public void nm(int i) {
        this.dNT = i;
    }

    public void nn(int i) {
        this.dNE = i;
    }

    public void no(int i) {
        this.dNU = i;
    }

    public void np(int i) {
        this.dNV = i;
    }

    public void nq(int i) {
        this.dNW = i;
    }

    public void nr(int i) {
        this.dNX = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean aTR() {
        return this.dNY;
    }

    public void hk(boolean z) {
        this.dNY = z;
    }

    public void hl(boolean z) {
        this.dNP = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.dNP || i3 <= i5 || dNB <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * dNB <= i3) {
                if (i5 * dNB > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * dNB);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.dNC = aVar.dNC;
        this.dND = aVar.dND;
        this.dea = aVar.dea;
        this.dNE = aVar.dNE;
        this.mTextSize = aVar.mTextSize;
        this.dNF = aVar.dNF;
        this.dNG = aVar.dNG;
        this.mTextColor = aVar.mTextColor;
        this.dNH = aVar.dNH;
        this.dNI = aVar.dNI;
        this.dNJ = aVar.dNJ;
        this.dNK = aVar.dNK;
        this.dNL = aVar.dNL;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.dNM = aVar.dNM;
        this.dNO = aVar.dNO;
        this.dNP = aVar.dNP;
        this.dNQ = aVar.dNQ;
        this.dNR = aVar.dNR;
        this.dNT = aVar.dNT;
        this.dNU = aVar.dNU;
        this.dNV = aVar.dNV;
        this.dNW = aVar.dNE;
        this.dNX = aVar.dNX;
        this.dNY = aVar.dNY;
    }
}

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
    public static final float dNA = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c NT;
    protected boolean dNO;
    public int dNY;
    public int dNZ;
    public int dOa;
    public boolean mIsFromCDN;
    protected float dNB = 0.0f;
    protected float dNC = 0.0f;
    protected int ddZ = 0;
    protected int dND = 0;
    protected float mTextSize = 15.0f;
    protected int dNE = -1;
    protected int dNF = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int dNG = 200;
    protected int dNH = 200;
    protected int dNI = 0;
    protected int dNJ = 0;
    protected boolean dNK = false;
    protected int dNL = -9989158;
    protected ImageView.ScaleType dNM = ImageView.ScaleType.CENTER_CROP;
    public boolean dNN = false;
    public int dNP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int dNQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int dNR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int dNS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int dNT = 0;
    protected int dNU = -1;
    protected int dNV = -1;
    protected int dNW = -1;
    protected boolean dNX = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.dND = typedArray.getDimensionPixelSize(5, 0);
        this.ddZ = typedArray.getDimensionPixelSize(2, 0);
        this.dNB = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.dNG = typedArray.getDimensionPixelSize(8, this.dNG);
        this.dNH = typedArray.getDimensionPixelSize(11, this.dNH);
        this.dNI = typedArray.getResourceId(3, 0);
        this.dNE = typedArray.getDimensionPixelSize(10, this.dNE);
        this.dNF = typedArray.getDimensionPixelSize(4, this.dNF);
        this.dNJ = typedArray.getResourceId(9, 0);
        this.dNK = typedArray.getBoolean(6, false);
        this.dNV = this.dND;
    }

    public void release() {
    }

    public void aS(int i, int i2) {
        this.dNE = i;
        this.dNF = i2;
    }

    public void nh(int i) {
        this.dNJ = i;
    }

    public void ni(int i) {
        this.dNG = i;
    }

    public void nj(int i) {
        this.dNH = i;
    }

    public void nk(int i) {
        this.dNI = i;
    }

    public void setSupportNoImage() {
        this.dNN = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.dNB = f2;
        this.dNC = f;
    }

    public void aT(int i, int i2) {
        this.dNP = i;
        this.dNQ = i2;
    }

    public void nl(int i) {
        this.dNR = i;
    }

    public void nm(int i) {
        this.dNS = i;
    }

    public void nn(int i) {
        this.dND = i;
    }

    public void no(int i) {
        this.dNT = i;
    }

    public void np(int i) {
        this.dNU = i;
    }

    public void nq(int i) {
        this.dNV = i;
    }

    public void nr(int i) {
        this.dNW = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean aTP() {
        return this.dNX;
    }

    public void hk(boolean z) {
        this.dNX = z;
    }

    public void hl(boolean z) {
        this.dNO = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.dNO || i3 <= i5 || dNA <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * dNA <= i3) {
                if (i5 * dNA > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * dNA);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.dNB = aVar.dNB;
        this.dNC = aVar.dNC;
        this.ddZ = aVar.ddZ;
        this.dND = aVar.dND;
        this.mTextSize = aVar.mTextSize;
        this.dNE = aVar.dNE;
        this.dNF = aVar.dNF;
        this.mTextColor = aVar.mTextColor;
        this.dNG = aVar.dNG;
        this.dNH = aVar.dNH;
        this.dNI = aVar.dNI;
        this.dNJ = aVar.dNJ;
        this.dNK = aVar.dNK;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.dNL = aVar.dNL;
        this.dNN = aVar.dNN;
        this.dNO = aVar.dNO;
        this.dNP = aVar.dNP;
        this.dNQ = aVar.dNQ;
        this.dNS = aVar.dNS;
        this.dNT = aVar.dNT;
        this.dNU = aVar.dNU;
        this.dNV = aVar.dND;
        this.dNW = aVar.dNW;
        this.dNX = aVar.dNX;
    }
}

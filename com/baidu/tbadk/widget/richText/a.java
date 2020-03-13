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
    public static final float dNO = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c NT;
    protected boolean dOc;
    public int dOm;
    public int dOn;
    public int dOo;
    public boolean mIsFromCDN;
    protected float dNP = 0.0f;
    protected float dNQ = 0.0f;
    protected int den = 0;
    protected int dNR = 0;
    protected float mTextSize = 15.0f;
    protected int dNS = -1;
    protected int dNT = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int dNU = 200;
    protected int dNV = 200;
    protected int dNW = 0;
    protected int dNX = 0;
    protected boolean dNY = false;
    protected int dNZ = -9989158;
    protected ImageView.ScaleType dOa = ImageView.ScaleType.CENTER_CROP;
    public boolean dOb = false;
    public int dOd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int dOe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int dOf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int dOg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int dOh = 0;
    protected int dOi = -1;
    protected int dOj = -1;
    protected int dOk = -1;
    protected boolean dOl = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.dNR = typedArray.getDimensionPixelSize(5, 0);
        this.den = typedArray.getDimensionPixelSize(2, 0);
        this.dNP = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.dNU = typedArray.getDimensionPixelSize(8, this.dNU);
        this.dNV = typedArray.getDimensionPixelSize(11, this.dNV);
        this.dNW = typedArray.getResourceId(3, 0);
        this.dNS = typedArray.getDimensionPixelSize(10, this.dNS);
        this.dNT = typedArray.getDimensionPixelSize(4, this.dNT);
        this.dNX = typedArray.getResourceId(9, 0);
        this.dNY = typedArray.getBoolean(6, false);
        this.dOj = this.dNR;
    }

    public void release() {
    }

    public void aS(int i, int i2) {
        this.dNS = i;
        this.dNT = i2;
    }

    public void nh(int i) {
        this.dNX = i;
    }

    public void ni(int i) {
        this.dNU = i;
    }

    public void nj(int i) {
        this.dNV = i;
    }

    public void nk(int i) {
        this.dNW = i;
    }

    public void setSupportNoImage() {
        this.dOb = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.dNP = f2;
        this.dNQ = f;
    }

    public void aT(int i, int i2) {
        this.dOd = i;
        this.dOe = i2;
    }

    public void nl(int i) {
        this.dOf = i;
    }

    public void nm(int i) {
        this.dOg = i;
    }

    public void nn(int i) {
        this.dNR = i;
    }

    public void no(int i) {
        this.dOh = i;
    }

    public void np(int i) {
        this.dOi = i;
    }

    public void nq(int i) {
        this.dOj = i;
    }

    public void nr(int i) {
        this.dOk = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean aTS() {
        return this.dOl;
    }

    public void hk(boolean z) {
        this.dOl = z;
    }

    public void hl(boolean z) {
        this.dOc = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.dOc || i3 <= i5 || dNO <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * dNO <= i3) {
                if (i5 * dNO > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * dNO);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.dNP = aVar.dNP;
        this.dNQ = aVar.dNQ;
        this.den = aVar.den;
        this.dNR = aVar.dNR;
        this.mTextSize = aVar.mTextSize;
        this.dNS = aVar.dNS;
        this.dNT = aVar.dNT;
        this.mTextColor = aVar.mTextColor;
        this.dNU = aVar.dNU;
        this.dNV = aVar.dNV;
        this.dNW = aVar.dNW;
        this.dNX = aVar.dNX;
        this.dNY = aVar.dNY;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.dNZ = aVar.dNZ;
        this.dOb = aVar.dOb;
        this.dOc = aVar.dOc;
        this.dOd = aVar.dOd;
        this.dOe = aVar.dOe;
        this.dOg = aVar.dOg;
        this.dOh = aVar.dOh;
        this.dOi = aVar.dOi;
        this.dOj = aVar.dNR;
        this.dOk = aVar.dOk;
        this.dOl = aVar.dOl;
    }
}

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
    public static final float dOf = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c NU;
    public int dOD;
    public int dOE;
    public int dOF;
    protected boolean dOt;
    public boolean mIsFromCDN;
    protected float dOg = 0.0f;
    protected float dOh = 0.0f;
    protected int deB = 0;
    protected int dOi = 0;
    protected float mTextSize = 15.0f;
    protected int dOj = -1;
    protected int dOk = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int dOl = 200;
    protected int dOm = 200;
    protected int dOn = 0;
    protected int dOo = 0;
    protected boolean dOp = false;
    protected int dOq = -9989158;
    protected ImageView.ScaleType dOr = ImageView.ScaleType.CENTER_CROP;
    public boolean dOs = false;
    public int dOu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int dOv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int dOw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int dOx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int dOy = 0;
    protected int dOz = -1;
    protected int dOA = -1;
    protected int dOB = -1;
    protected boolean dOC = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.dOi = typedArray.getDimensionPixelSize(5, 0);
        this.deB = typedArray.getDimensionPixelSize(2, 0);
        this.dOg = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.dOl = typedArray.getDimensionPixelSize(8, this.dOl);
        this.dOm = typedArray.getDimensionPixelSize(11, this.dOm);
        this.dOn = typedArray.getResourceId(3, 0);
        this.dOj = typedArray.getDimensionPixelSize(10, this.dOj);
        this.dOk = typedArray.getDimensionPixelSize(4, this.dOk);
        this.dOo = typedArray.getResourceId(9, 0);
        this.dOp = typedArray.getBoolean(6, false);
        this.dOA = this.dOi;
    }

    public void release() {
    }

    public void aT(int i, int i2) {
        this.dOj = i;
        this.dOk = i2;
    }

    public void nj(int i) {
        this.dOo = i;
    }

    public void nk(int i) {
        this.dOl = i;
    }

    public void nl(int i) {
        this.dOm = i;
    }

    public void nm(int i) {
        this.dOn = i;
    }

    public void setSupportNoImage() {
        this.dOs = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.dOg = f2;
        this.dOh = f;
    }

    public void aU(int i, int i2) {
        this.dOu = i;
        this.dOv = i2;
    }

    public void nn(int i) {
        this.dOw = i;
    }

    public void no(int i) {
        this.dOx = i;
    }

    public void np(int i) {
        this.dOi = i;
    }

    public void nq(int i) {
        this.dOy = i;
    }

    public void nr(int i) {
        this.dOz = i;
    }

    public void ns(int i) {
        this.dOA = i;
    }

    public void nt(int i) {
        this.dOB = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean aTW() {
        return this.dOC;
    }

    public void hl(boolean z) {
        this.dOC = z;
    }

    public void hm(boolean z) {
        this.dOt = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.dOt || i3 <= i5 || dOf <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * dOf <= i3) {
                if (i5 * dOf > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * dOf);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.dOg = aVar.dOg;
        this.dOh = aVar.dOh;
        this.deB = aVar.deB;
        this.dOi = aVar.dOi;
        this.mTextSize = aVar.mTextSize;
        this.dOj = aVar.dOj;
        this.dOk = aVar.dOk;
        this.mTextColor = aVar.mTextColor;
        this.dOl = aVar.dOl;
        this.dOm = aVar.dOm;
        this.dOn = aVar.dOn;
        this.dOo = aVar.dOo;
        this.dOp = aVar.dOp;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.dOq = aVar.dOq;
        this.dOs = aVar.dOs;
        this.dOt = aVar.dOt;
        this.dOu = aVar.dOu;
        this.dOv = aVar.dOv;
        this.dOx = aVar.dOx;
        this.dOy = aVar.dOy;
        this.dOz = aVar.dOz;
        this.dOA = aVar.dOi;
        this.dOB = aVar.dOB;
        this.dOC = aVar.dOC;
    }
}

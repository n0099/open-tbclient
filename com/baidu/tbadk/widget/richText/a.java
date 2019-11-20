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
    public static final float cUT = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.b HC;
    protected boolean cVh;
    public int cVr;
    public int cVs;
    public int cVt;
    public boolean mIsFromCDN;
    protected float cUU = 0.0f;
    protected float cUV = 0.0f;
    protected int cmz = 0;
    protected int cUW = 0;
    protected float asP = 15.0f;
    protected int cUX = -1;
    protected int cUY = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cUZ = 200;
    protected int cVa = 200;
    protected int cVb = 0;
    protected int cVc = 0;
    protected boolean cVd = false;
    protected int cVe = -9989158;
    protected ImageView.ScaleType cVf = ImageView.ScaleType.CENTER_CROP;
    public boolean cVg = false;
    public int cVi = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int cVj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int cVk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int cVl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int cVm = 0;
    protected int cVn = -1;
    protected int cVo = -1;
    protected int cVp = -1;
    protected boolean cVq = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cUW = typedArray.getDimensionPixelSize(4, 0);
        this.cmz = typedArray.getDimensionPixelSize(1, 0);
        this.cUU = typedArray.getFloat(12, 1.12f);
        this.asP = typedArray.getDimensionPixelSize(11, (int) this.asP);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.cUZ = typedArray.getDimensionPixelSize(7, this.cUZ);
        this.cVa = typedArray.getDimensionPixelSize(10, this.cVa);
        this.cVb = typedArray.getResourceId(2, 0);
        this.cUX = typedArray.getDimensionPixelSize(9, this.cUX);
        this.cUY = typedArray.getDimensionPixelSize(3, this.cUY);
        this.cVc = typedArray.getResourceId(8, 0);
        this.cVd = typedArray.getBoolean(5, false);
        this.cVo = this.cUW;
    }

    public void release() {
    }

    public void au(int i, int i2) {
        this.cUX = i;
        this.cUY = i2;
    }

    public void kB(int i) {
        this.cVc = i;
    }

    public void kC(int i) {
        this.cUZ = i;
    }

    public void kD(int i) {
        this.cVa = i;
    }

    public void kE(int i) {
        this.cVb = i;
    }

    public void setSupportNoImage() {
        this.cVg = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cUU = f2;
        this.cUV = f;
    }

    public void av(int i, int i2) {
        this.cVi = i;
        this.cVj = i2;
    }

    public void kF(int i) {
        this.cVk = i;
    }

    public void kG(int i) {
        this.cVl = i;
    }

    public void kH(int i) {
        this.cUW = i;
    }

    public void kI(int i) {
        this.cVm = i;
    }

    public void kJ(int i) {
        this.cVn = i;
    }

    public void kK(int i) {
        this.cVo = i;
    }

    public void kL(int i) {
        this.cVp = i;
    }

    public void setTextSize(int i) {
        this.asP = i;
    }

    public boolean aze() {
        return this.cVq;
    }

    public void fL(boolean z) {
        this.cVq = z;
    }

    public void fM(boolean z) {
        this.cVh = z;
    }

    public int[] q(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cVh || i3 <= i5 || cUT <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cUT <= i3) {
                if (i5 * cUT > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cUT);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cUU = aVar.cUU;
        this.cUV = aVar.cUV;
        this.cmz = aVar.cmz;
        this.cUW = aVar.cUW;
        this.asP = aVar.asP;
        this.cUX = aVar.cUX;
        this.cUY = aVar.cUY;
        this.mTextColor = aVar.mTextColor;
        this.cUZ = aVar.cUZ;
        this.cVa = aVar.cVa;
        this.cVb = aVar.cVb;
        this.cVc = aVar.cVc;
        this.cVd = aVar.cVd;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cVe = aVar.cVe;
        this.cVg = aVar.cVg;
        this.cVh = aVar.cVh;
        this.cVi = aVar.cVi;
        this.cVj = aVar.cVj;
        this.cVl = aVar.cVl;
        this.cVm = aVar.cVm;
        this.cVn = aVar.cVn;
        this.cVo = aVar.cUW;
        this.cVp = aVar.cVp;
        this.cVq = aVar.cVq;
    }
}

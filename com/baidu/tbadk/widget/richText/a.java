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
    public static final float cVK = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.b Id;
    protected boolean cVY;
    public int cWi;
    public int cWj;
    public int cWk;
    public boolean mIsFromCDN;
    protected float cVL = 0.0f;
    protected float cVM = 0.0f;
    protected int cnq = 0;
    protected int cVN = 0;
    protected float ath = 15.0f;
    protected int cVO = -1;
    protected int cVP = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cVQ = 200;
    protected int cVR = 200;
    protected int cVS = 0;
    protected int cVT = 0;
    protected boolean cVU = false;
    protected int cVV = -9989158;
    protected ImageView.ScaleType cVW = ImageView.ScaleType.CENTER_CROP;
    public boolean cVX = false;
    public int cVZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int cWa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int cWb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int cWc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int cWd = 0;
    protected int cWe = -1;
    protected int cWf = -1;
    protected int cWg = -1;
    protected boolean cWh = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cVN = typedArray.getDimensionPixelSize(4, 0);
        this.cnq = typedArray.getDimensionPixelSize(1, 0);
        this.cVL = typedArray.getFloat(12, 1.12f);
        this.ath = typedArray.getDimensionPixelSize(11, (int) this.ath);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.cVQ = typedArray.getDimensionPixelSize(7, this.cVQ);
        this.cVR = typedArray.getDimensionPixelSize(10, this.cVR);
        this.cVS = typedArray.getResourceId(2, 0);
        this.cVO = typedArray.getDimensionPixelSize(9, this.cVO);
        this.cVP = typedArray.getDimensionPixelSize(3, this.cVP);
        this.cVT = typedArray.getResourceId(8, 0);
        this.cVU = typedArray.getBoolean(5, false);
        this.cWf = this.cVN;
    }

    public void release() {
    }

    public void aw(int i, int i2) {
        this.cVO = i;
        this.cVP = i2;
    }

    public void kC(int i) {
        this.cVT = i;
    }

    public void kD(int i) {
        this.cVQ = i;
    }

    public void kE(int i) {
        this.cVR = i;
    }

    public void kF(int i) {
        this.cVS = i;
    }

    public void setSupportNoImage() {
        this.cVX = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cVL = f2;
        this.cVM = f;
    }

    public void ax(int i, int i2) {
        this.cVZ = i;
        this.cWa = i2;
    }

    public void kG(int i) {
        this.cWb = i;
    }

    public void kH(int i) {
        this.cWc = i;
    }

    public void kI(int i) {
        this.cVN = i;
    }

    public void kJ(int i) {
        this.cWd = i;
    }

    public void kK(int i) {
        this.cWe = i;
    }

    public void kL(int i) {
        this.cWf = i;
    }

    public void kM(int i) {
        this.cWg = i;
    }

    public void setTextSize(int i) {
        this.ath = i;
    }

    public boolean azg() {
        return this.cWh;
    }

    public void fL(boolean z) {
        this.cWh = z;
    }

    public void fM(boolean z) {
        this.cVY = z;
    }

    public int[] q(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cVY || i3 <= i5 || cVK <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cVK <= i3) {
                if (i5 * cVK > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cVK);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cVL = aVar.cVL;
        this.cVM = aVar.cVM;
        this.cnq = aVar.cnq;
        this.cVN = aVar.cVN;
        this.ath = aVar.ath;
        this.cVO = aVar.cVO;
        this.cVP = aVar.cVP;
        this.mTextColor = aVar.mTextColor;
        this.cVQ = aVar.cVQ;
        this.cVR = aVar.cVR;
        this.cVS = aVar.cVS;
        this.cVT = aVar.cVT;
        this.cVU = aVar.cVU;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cVV = aVar.cVV;
        this.cVX = aVar.cVX;
        this.cVY = aVar.cVY;
        this.cVZ = aVar.cVZ;
        this.cWa = aVar.cWa;
        this.cWc = aVar.cWc;
        this.cWd = aVar.cWd;
        this.cWe = aVar.cWe;
        this.cWf = aVar.cVN;
        this.cWg = aVar.cWg;
        this.cWh = aVar.cWh;
    }
}

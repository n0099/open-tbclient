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
    public static final float eCG = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c ahi;
    protected boolean eCU;
    public int eDe;
    public int eDf;
    public int eDg;
    public boolean mIsFromCDN;
    protected float eCH = 0.0f;
    protected float eCI = 0.0f;
    protected int dSp = 0;
    protected int eCJ = 0;
    protected float mTextSize = 15.0f;
    protected int eCK = -1;
    protected int eCL = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int eCM = 200;
    protected int eCN = 200;
    protected int eCO = 0;
    protected int eCP = 0;
    protected boolean eCQ = false;
    protected int eCR = -9989158;
    protected ImageView.ScaleType eCS = ImageView.ScaleType.CENTER_CROP;
    public boolean eCT = false;
    public int eCV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int eCW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int eCX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int eCY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int eCZ = 0;
    protected int eDa = -1;
    protected int eDb = -1;
    protected int eDc = -1;
    protected boolean eDd = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.eCJ = typedArray.getDimensionPixelSize(5, 0);
        this.dSp = typedArray.getDimensionPixelSize(2, 0);
        this.eCH = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.eCM = typedArray.getDimensionPixelSize(8, this.eCM);
        this.eCN = typedArray.getDimensionPixelSize(11, this.eCN);
        this.eCO = typedArray.getResourceId(3, 0);
        this.eCK = typedArray.getDimensionPixelSize(10, this.eCK);
        this.eCL = typedArray.getDimensionPixelSize(4, this.eCL);
        this.eCP = typedArray.getResourceId(9, 0);
        this.eCQ = typedArray.getBoolean(6, false);
        this.eDb = this.eCJ;
    }

    public void release() {
    }

    public void bb(int i, int i2) {
        this.eCK = i;
        this.eCL = i2;
    }

    public void nY(int i) {
        this.eCP = i;
    }

    public void nZ(int i) {
        this.eCM = i;
    }

    public void oa(int i) {
        this.eCN = i;
    }

    public void ob(int i) {
        this.eCO = i;
    }

    public void setSupportNoImage() {
        this.eCT = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.eCH = f2;
        this.eCI = f;
    }

    public void bc(int i, int i2) {
        this.eCV = i;
        this.eCW = i2;
    }

    public void oc(int i) {
        this.eCX = i;
    }

    public void od(int i) {
        this.eCY = i;
    }

    public void oe(int i) {
        this.eCJ = i;
    }

    public void of(int i) {
        this.eCZ = i;
    }

    public void og(int i) {
        this.eDa = i;
    }

    public void oh(int i) {
        this.eDb = i;
    }

    public void oi(int i) {
        this.eDc = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bip() {
        return this.eDd;
    }

    public void iG(boolean z) {
        this.eDd = z;
    }

    public void iH(boolean z) {
        this.eCU = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.eCU || i3 <= i5 || eCG <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * eCG <= i3) {
                if (i5 * eCG > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * eCG);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.eCH = aVar.eCH;
        this.eCI = aVar.eCI;
        this.dSp = aVar.dSp;
        this.eCJ = aVar.eCJ;
        this.mTextSize = aVar.mTextSize;
        this.eCK = aVar.eCK;
        this.eCL = aVar.eCL;
        this.mTextColor = aVar.mTextColor;
        this.eCM = aVar.eCM;
        this.eCN = aVar.eCN;
        this.eCO = aVar.eCO;
        this.eCP = aVar.eCP;
        this.eCQ = aVar.eCQ;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.eCR = aVar.eCR;
        this.eCT = aVar.eCT;
        this.eCU = aVar.eCU;
        this.eCV = aVar.eCV;
        this.eCW = aVar.eCW;
        this.eCY = aVar.eCY;
        this.eCZ = aVar.eCZ;
        this.eDa = aVar.eDa;
        this.eDb = aVar.eCJ;
        this.eDc = aVar.eDc;
        this.eDd = aVar.eDd;
    }
}

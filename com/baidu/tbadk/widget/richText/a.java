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
    public static final float dJv = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c Nr;
    protected boolean dJJ;
    public int dJT;
    public int dJU;
    public int dJV;
    public boolean mIsFromCDN;
    protected float dJw = 0.0f;
    protected float dJx = 0.0f;
    protected int cZU = 0;
    protected int dJy = 0;
    protected float mTextSize = 15.0f;
    protected int dJz = -1;
    protected int dJA = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int dJB = 200;
    protected int dJC = 200;
    protected int dJD = 0;
    protected int dJE = 0;
    protected boolean dJF = false;
    protected int dJG = -9989158;
    protected ImageView.ScaleType dJH = ImageView.ScaleType.CENTER_CROP;
    public boolean dJI = false;
    public int dJK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int dJL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int dJM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int dJN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int dJO = 0;
    protected int dJP = -1;
    protected int dJQ = -1;
    protected int dJR = -1;
    protected boolean dJS = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.dJy = typedArray.getDimensionPixelSize(5, 0);
        this.cZU = typedArray.getDimensionPixelSize(2, 0);
        this.dJw = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.dJB = typedArray.getDimensionPixelSize(8, this.dJB);
        this.dJC = typedArray.getDimensionPixelSize(11, this.dJC);
        this.dJD = typedArray.getResourceId(3, 0);
        this.dJz = typedArray.getDimensionPixelSize(10, this.dJz);
        this.dJA = typedArray.getDimensionPixelSize(4, this.dJA);
        this.dJE = typedArray.getResourceId(9, 0);
        this.dJF = typedArray.getBoolean(6, false);
        this.dJQ = this.dJy;
    }

    public void release() {
    }

    public void aS(int i, int i2) {
        this.dJz = i;
        this.dJA = i2;
    }

    public void mQ(int i) {
        this.dJE = i;
    }

    public void mR(int i) {
        this.dJB = i;
    }

    public void mS(int i) {
        this.dJC = i;
    }

    public void mT(int i) {
        this.dJD = i;
    }

    public void setSupportNoImage() {
        this.dJI = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.dJw = f2;
        this.dJx = f;
    }

    public void aT(int i, int i2) {
        this.dJK = i;
        this.dJL = i2;
    }

    public void mU(int i) {
        this.dJM = i;
    }

    public void mV(int i) {
        this.dJN = i;
    }

    public void mW(int i) {
        this.dJy = i;
    }

    public void mX(int i) {
        this.dJO = i;
    }

    public void mY(int i) {
        this.dJP = i;
    }

    public void mZ(int i) {
        this.dJQ = i;
    }

    public void na(int i) {
        this.dJR = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean aRy() {
        return this.dJS;
    }

    public void hd(boolean z) {
        this.dJS = z;
    }

    public void he(boolean z) {
        this.dJJ = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.dJJ || i3 <= i5 || dJv <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * dJv <= i3) {
                if (i5 * dJv > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * dJv);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.dJw = aVar.dJw;
        this.dJx = aVar.dJx;
        this.cZU = aVar.cZU;
        this.dJy = aVar.dJy;
        this.mTextSize = aVar.mTextSize;
        this.dJz = aVar.dJz;
        this.dJA = aVar.dJA;
        this.mTextColor = aVar.mTextColor;
        this.dJB = aVar.dJB;
        this.dJC = aVar.dJC;
        this.dJD = aVar.dJD;
        this.dJE = aVar.dJE;
        this.dJF = aVar.dJF;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.dJG = aVar.dJG;
        this.dJI = aVar.dJI;
        this.dJJ = aVar.dJJ;
        this.dJK = aVar.dJK;
        this.dJL = aVar.dJL;
        this.dJN = aVar.dJN;
        this.dJO = aVar.dJO;
        this.dJP = aVar.dJP;
        this.dJQ = aVar.dJy;
        this.dJR = aVar.dJR;
        this.dJS = aVar.dJS;
    }
}

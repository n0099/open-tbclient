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
    public static final float dJm = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c Nn;
    protected boolean dJA;
    public int dJK;
    public int dJL;
    public int dJM;
    public boolean mIsFromCDN;
    protected float dJn = 0.0f;
    protected float dJo = 0.0f;
    protected int cZK = 0;
    protected int dJp = 0;
    protected float mTextSize = 15.0f;
    protected int dJq = -1;
    protected int dJr = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int dJs = 200;
    protected int dJt = 200;
    protected int dJu = 0;
    protected int dJv = 0;
    protected boolean dJw = false;
    protected int dJx = -9989158;
    protected ImageView.ScaleType dJy = ImageView.ScaleType.CENTER_CROP;
    public boolean dJz = false;
    public int dJB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int dJC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int dJD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int dJE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int dJF = 0;
    protected int dJG = -1;
    protected int dJH = -1;
    protected int dJI = -1;
    protected boolean dJJ = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.dJp = typedArray.getDimensionPixelSize(5, 0);
        this.cZK = typedArray.getDimensionPixelSize(2, 0);
        this.dJn = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.dJs = typedArray.getDimensionPixelSize(8, this.dJs);
        this.dJt = typedArray.getDimensionPixelSize(11, this.dJt);
        this.dJu = typedArray.getResourceId(3, 0);
        this.dJq = typedArray.getDimensionPixelSize(10, this.dJq);
        this.dJr = typedArray.getDimensionPixelSize(4, this.dJr);
        this.dJv = typedArray.getResourceId(9, 0);
        this.dJw = typedArray.getBoolean(6, false);
        this.dJH = this.dJp;
    }

    public void release() {
    }

    public void aO(int i, int i2) {
        this.dJq = i;
        this.dJr = i2;
    }

    public void mQ(int i) {
        this.dJv = i;
    }

    public void mR(int i) {
        this.dJs = i;
    }

    public void mS(int i) {
        this.dJt = i;
    }

    public void mT(int i) {
        this.dJu = i;
    }

    public void setSupportNoImage() {
        this.dJz = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.dJn = f2;
        this.dJo = f;
    }

    public void aP(int i, int i2) {
        this.dJB = i;
        this.dJC = i2;
    }

    public void mU(int i) {
        this.dJD = i;
    }

    public void mV(int i) {
        this.dJE = i;
    }

    public void mW(int i) {
        this.dJp = i;
    }

    public void mX(int i) {
        this.dJF = i;
    }

    public void mY(int i) {
        this.dJG = i;
    }

    public void mZ(int i) {
        this.dJH = i;
    }

    public void na(int i) {
        this.dJI = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean aRe() {
        return this.dJJ;
    }

    public void gY(boolean z) {
        this.dJJ = z;
    }

    public void gZ(boolean z) {
        this.dJA = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.dJA || i3 <= i5 || dJm <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * dJm <= i3) {
                if (i5 * dJm > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * dJm);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.dJn = aVar.dJn;
        this.dJo = aVar.dJo;
        this.cZK = aVar.cZK;
        this.dJp = aVar.dJp;
        this.mTextSize = aVar.mTextSize;
        this.dJq = aVar.dJq;
        this.dJr = aVar.dJr;
        this.mTextColor = aVar.mTextColor;
        this.dJs = aVar.dJs;
        this.dJt = aVar.dJt;
        this.dJu = aVar.dJu;
        this.dJv = aVar.dJv;
        this.dJw = aVar.dJw;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.dJx = aVar.dJx;
        this.dJz = aVar.dJz;
        this.dJA = aVar.dJA;
        this.dJB = aVar.dJB;
        this.dJC = aVar.dJC;
        this.dJE = aVar.dJE;
        this.dJF = aVar.dJF;
        this.dJG = aVar.dJG;
        this.dJH = aVar.dJp;
        this.dJI = aVar.dJI;
        this.dJJ = aVar.dJJ;
    }
}

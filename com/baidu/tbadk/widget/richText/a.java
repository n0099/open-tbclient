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
    public static final float eCR = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c ahi;
    protected boolean eDf;
    public int eDp;
    public int eDq;
    public int eDr;
    public boolean mIsFromCDN;
    protected float eCS = 0.0f;
    protected float eCT = 0.0f;
    protected int dSp = 0;
    protected int eCU = 0;
    protected float mTextSize = 15.0f;
    protected int eCV = -1;
    protected int eCW = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int eCX = 200;
    protected int eCY = 200;
    protected int eCZ = 0;
    protected int eDa = 0;
    protected boolean eDb = false;
    protected int eDc = -9989158;
    protected ImageView.ScaleType eDd = ImageView.ScaleType.CENTER_CROP;
    public boolean eDe = false;
    public int eDg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int eDh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int eDi = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int eDj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int eDk = 0;
    protected int eDl = -1;
    protected int eDm = -1;
    protected int eDn = -1;
    protected boolean eDo = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.eCU = typedArray.getDimensionPixelSize(5, 0);
        this.dSp = typedArray.getDimensionPixelSize(2, 0);
        this.eCS = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.eCX = typedArray.getDimensionPixelSize(8, this.eCX);
        this.eCY = typedArray.getDimensionPixelSize(11, this.eCY);
        this.eCZ = typedArray.getResourceId(3, 0);
        this.eCV = typedArray.getDimensionPixelSize(10, this.eCV);
        this.eCW = typedArray.getDimensionPixelSize(4, this.eCW);
        this.eDa = typedArray.getResourceId(9, 0);
        this.eDb = typedArray.getBoolean(6, false);
        this.eDm = this.eCU;
    }

    public void release() {
    }

    public void bb(int i, int i2) {
        this.eCV = i;
        this.eCW = i2;
    }

    public void oa(int i) {
        this.eDa = i;
    }

    public void ob(int i) {
        this.eCX = i;
    }

    public void oc(int i) {
        this.eCY = i;
    }

    public void od(int i) {
        this.eCZ = i;
    }

    public void setSupportNoImage() {
        this.eDe = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.eCS = f2;
        this.eCT = f;
    }

    public void bc(int i, int i2) {
        this.eDg = i;
        this.eDh = i2;
    }

    public void oe(int i) {
        this.eDi = i;
    }

    public void of(int i) {
        this.eDj = i;
    }

    public void og(int i) {
        this.eCU = i;
    }

    public void oh(int i) {
        this.eDk = i;
    }

    public void oi(int i) {
        this.eDl = i;
    }

    public void oj(int i) {
        this.eDm = i;
    }

    public void ok(int i) {
        this.eDn = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bir() {
        return this.eDo;
    }

    public void iG(boolean z) {
        this.eDo = z;
    }

    public void iH(boolean z) {
        this.eDf = z;
    }

    public int[] u(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.eDf || i3 <= i5 || eCR <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * eCR <= i3) {
                if (i5 * eCR > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * eCR);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.eCS = aVar.eCS;
        this.eCT = aVar.eCT;
        this.dSp = aVar.dSp;
        this.eCU = aVar.eCU;
        this.mTextSize = aVar.mTextSize;
        this.eCV = aVar.eCV;
        this.eCW = aVar.eCW;
        this.mTextColor = aVar.mTextColor;
        this.eCX = aVar.eCX;
        this.eCY = aVar.eCY;
        this.eCZ = aVar.eCZ;
        this.eDa = aVar.eDa;
        this.eDb = aVar.eDb;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.eDc = aVar.eDc;
        this.eDe = aVar.eDe;
        this.eDf = aVar.eDf;
        this.eDg = aVar.eDg;
        this.eDh = aVar.eDh;
        this.eDj = aVar.eDj;
        this.eDk = aVar.eDk;
        this.eDl = aVar.eDl;
        this.eDm = aVar.eCU;
        this.eDn = aVar.eDn;
        this.eDo = aVar.eDo;
    }
}

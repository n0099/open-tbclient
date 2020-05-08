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
    public static final float eod = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c agE;
    public int eoC;
    public int eoD;
    public int eoE;
    protected boolean eos;
    public boolean mIsFromCDN;
    protected float eoe = 0.0f;
    protected float eog = 0.0f;
    protected int dEd = 0;
    protected int eoh = 0;
    protected float mTextSize = 15.0f;
    protected int eoi = -1;
    protected int eoj = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int eok = 200;
    protected int eol = 200;
    protected int eom = 0;
    protected int eon = 0;
    protected boolean eoo = false;
    protected int eop = -9989158;
    protected ImageView.ScaleType eoq = ImageView.ScaleType.CENTER_CROP;
    public boolean eor = false;
    public int eot = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int eou = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int eov = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int eow = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int eox = 0;
    protected int eoy = -1;
    protected int eoz = -1;
    protected int eoA = -1;
    protected boolean eoB = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.eoh = typedArray.getDimensionPixelSize(5, 0);
        this.dEd = typedArray.getDimensionPixelSize(2, 0);
        this.eoe = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.eok = typedArray.getDimensionPixelSize(8, this.eok);
        this.eol = typedArray.getDimensionPixelSize(11, this.eol);
        this.eom = typedArray.getResourceId(3, 0);
        this.eoi = typedArray.getDimensionPixelSize(10, this.eoi);
        this.eoj = typedArray.getDimensionPixelSize(4, this.eoj);
        this.eon = typedArray.getResourceId(9, 0);
        this.eoo = typedArray.getBoolean(6, false);
        this.eoz = this.eoh;
    }

    public void release() {
    }

    public void aX(int i, int i2) {
        this.eoi = i;
        this.eoj = i2;
    }

    public void nv(int i) {
        this.eon = i;
    }

    public void nw(int i) {
        this.eok = i;
    }

    public void nx(int i) {
        this.eol = i;
    }

    public void ny(int i) {
        this.eom = i;
    }

    public void setSupportNoImage() {
        this.eor = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.eoe = f2;
        this.eog = f;
    }

    public void aY(int i, int i2) {
        this.eot = i;
        this.eou = i2;
    }

    public void nz(int i) {
        this.eov = i;
    }

    public void nA(int i) {
        this.eow = i;
    }

    public void nB(int i) {
        this.eoh = i;
    }

    public void nC(int i) {
        this.eox = i;
    }

    public void nD(int i) {
        this.eoy = i;
    }

    public void nE(int i) {
        this.eoz = i;
    }

    public void nF(int i) {
        this.eoA = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bce() {
        return this.eoB;
    }

    public void ij(boolean z) {
        this.eoB = z;
    }

    public void ik(boolean z) {
        this.eos = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.eos || i3 <= i5 || eod <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * eod <= i3) {
                if (i5 * eod > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * eod);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.eoe = aVar.eoe;
        this.eog = aVar.eog;
        this.dEd = aVar.dEd;
        this.eoh = aVar.eoh;
        this.mTextSize = aVar.mTextSize;
        this.eoi = aVar.eoi;
        this.eoj = aVar.eoj;
        this.mTextColor = aVar.mTextColor;
        this.eok = aVar.eok;
        this.eol = aVar.eol;
        this.eom = aVar.eom;
        this.eon = aVar.eon;
        this.eoo = aVar.eoo;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.eop = aVar.eop;
        this.eor = aVar.eor;
        this.eos = aVar.eos;
        this.eot = aVar.eot;
        this.eou = aVar.eou;
        this.eow = aVar.eow;
        this.eox = aVar.eox;
        this.eoy = aVar.eoy;
        this.eoz = aVar.eoh;
        this.eoA = aVar.eoA;
        this.eoB = aVar.eoB;
    }
}

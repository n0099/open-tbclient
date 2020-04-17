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
    public static final float enY = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c agB;
    protected boolean eon;
    public int eox;
    public int eoy;
    public int eoz;
    public boolean mIsFromCDN;
    protected float enZ = 0.0f;
    protected float eoa = 0.0f;
    protected int dDZ = 0;
    protected int eob = 0;
    protected float mTextSize = 15.0f;
    protected int eoc = -1;
    protected int eod = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int eoe = 200;
    protected int eog = 200;
    protected int eoh = 0;
    protected int eoi = 0;
    protected boolean eoj = false;
    protected int eok = -9989158;
    protected ImageView.ScaleType eol = ImageView.ScaleType.CENTER_CROP;
    public boolean eom = false;
    public int eoo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int eop = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int eoq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int eor = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int eos = 0;
    protected int eot = -1;
    protected int eou = -1;
    protected int eov = -1;
    protected boolean eow = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.eob = typedArray.getDimensionPixelSize(5, 0);
        this.dDZ = typedArray.getDimensionPixelSize(2, 0);
        this.enZ = typedArray.getFloat(12, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(1, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.eoe = typedArray.getDimensionPixelSize(8, this.eoe);
        this.eog = typedArray.getDimensionPixelSize(11, this.eog);
        this.eoh = typedArray.getResourceId(3, 0);
        this.eoc = typedArray.getDimensionPixelSize(10, this.eoc);
        this.eod = typedArray.getDimensionPixelSize(4, this.eod);
        this.eoi = typedArray.getResourceId(9, 0);
        this.eoj = typedArray.getBoolean(6, false);
        this.eou = this.eob;
    }

    public void release() {
    }

    public void aX(int i, int i2) {
        this.eoc = i;
        this.eod = i2;
    }

    public void nv(int i) {
        this.eoi = i;
    }

    public void nw(int i) {
        this.eoe = i;
    }

    public void nx(int i) {
        this.eog = i;
    }

    public void ny(int i) {
        this.eoh = i;
    }

    public void setSupportNoImage() {
        this.eom = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.enZ = f2;
        this.eoa = f;
    }

    public void aY(int i, int i2) {
        this.eoo = i;
        this.eop = i2;
    }

    public void nz(int i) {
        this.eoq = i;
    }

    public void nA(int i) {
        this.eor = i;
    }

    public void nB(int i) {
        this.eob = i;
    }

    public void nC(int i) {
        this.eos = i;
    }

    public void nD(int i) {
        this.eot = i;
    }

    public void nE(int i) {
        this.eou = i;
    }

    public void nF(int i) {
        this.eov = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bcg() {
        return this.eow;
    }

    public void ij(boolean z) {
        this.eow = z;
    }

    public void ik(boolean z) {
        this.eon = z;
    }

    public int[] t(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.eon || i3 <= i5 || enY <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * enY <= i3) {
                if (i5 * enY > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * enY);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.enZ = aVar.enZ;
        this.eoa = aVar.eoa;
        this.dDZ = aVar.dDZ;
        this.eob = aVar.eob;
        this.mTextSize = aVar.mTextSize;
        this.eoc = aVar.eoc;
        this.eod = aVar.eod;
        this.mTextColor = aVar.mTextColor;
        this.eoe = aVar.eoe;
        this.eog = aVar.eog;
        this.eoh = aVar.eoh;
        this.eoi = aVar.eoi;
        this.eoj = aVar.eoj;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.eok = aVar.eok;
        this.eom = aVar.eom;
        this.eon = aVar.eon;
        this.eoo = aVar.eoo;
        this.eop = aVar.eop;
        this.eor = aVar.eor;
        this.eos = aVar.eos;
        this.eot = aVar.eot;
        this.eou = aVar.eob;
        this.eov = aVar.eov;
        this.eow = aVar.eow;
    }
}

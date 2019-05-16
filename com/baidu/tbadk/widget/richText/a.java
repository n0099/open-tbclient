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
    public static final float cJZ = l.ai(TbadkCoreApplication.getInst());
    public int cKA;
    protected boolean cKo;
    public int cKy;
    public int cKz;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cKa = 0.0f;
    protected float cKb = 0.0f;
    protected int bWq = 0;
    protected int cKc = 0;
    protected float cKd = 15.0f;
    protected int cKe = -1;
    protected int cKf = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cKg = 200;
    protected int cKh = 200;
    protected int cKi = 0;
    protected int cKj = 0;
    protected boolean cKk = false;
    protected int cKl = -9989158;
    protected ImageView.ScaleType cKm = ImageView.ScaleType.CENTER_CROP;
    public boolean cKn = false;
    public int cKp = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int cKq = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int cKr = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int cKs = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int cKt = 0;
    protected int cKu = -1;
    protected int cKv = -1;
    protected int cKw = -1;
    protected boolean cKx = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cKc = typedArray.getDimensionPixelSize(4, 0);
        this.bWq = typedArray.getDimensionPixelSize(1, 0);
        this.cKa = typedArray.getFloat(12, 1.12f);
        this.cKd = typedArray.getDimensionPixelSize(11, (int) this.cKd);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.cKg = typedArray.getDimensionPixelSize(7, this.cKg);
        this.cKh = typedArray.getDimensionPixelSize(10, this.cKh);
        this.cKi = typedArray.getResourceId(2, 0);
        this.cKe = typedArray.getDimensionPixelSize(9, this.cKe);
        this.cKf = typedArray.getDimensionPixelSize(3, this.cKf);
        this.cKj = typedArray.getResourceId(8, 0);
        this.cKk = typedArray.getBoolean(5, false);
        this.cKv = this.cKc;
    }

    public void release() {
    }

    public void ar(int i, int i2) {
        this.cKe = i;
        this.cKf = i2;
    }

    public void lm(int i) {
        this.cKj = i;
    }

    public void ln(int i) {
        this.cKg = i;
    }

    public void lo(int i) {
        this.cKh = i;
    }

    public void lp(int i) {
        this.cKi = i;
    }

    public void setSupportNoImage() {
        this.cKn = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cKa = f2;
        this.cKb = f;
    }

    public void as(int i, int i2) {
        this.cKp = i;
        this.cKq = i2;
    }

    public void lq(int i) {
        this.cKr = i;
    }

    public void lr(int i) {
        this.cKs = i;
    }

    public void ls(int i) {
        this.cKc = i;
    }

    public void lt(int i) {
        this.cKt = i;
    }

    public void lu(int i) {
        this.cKu = i;
    }

    public void lv(int i) {
        this.cKv = i;
    }

    public void lw(int i) {
        this.cKw = i;
    }

    public void setTextSize(int i) {
        this.cKd = i;
    }

    public boolean axx() {
        return this.cKx;
    }

    public void fP(boolean z) {
        this.cKx = z;
    }

    public void fQ(boolean z) {
        this.cKo = z;
    }

    public int[] o(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cKo || i3 <= i5 || cJZ <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cJZ <= i3) {
                if (i5 * cJZ > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cJZ);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cKa = aVar.cKa;
        this.cKb = aVar.cKb;
        this.bWq = aVar.bWq;
        this.cKc = aVar.cKc;
        this.cKd = aVar.cKd;
        this.cKe = aVar.cKe;
        this.cKf = aVar.cKf;
        this.mTextColor = aVar.mTextColor;
        this.cKg = aVar.cKg;
        this.cKh = aVar.cKh;
        this.cKi = aVar.cKi;
        this.cKj = aVar.cKj;
        this.cKk = aVar.cKk;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cKl = aVar.cKl;
        this.cKn = aVar.cKn;
        this.cKo = aVar.cKo;
        this.cKp = aVar.cKp;
        this.cKq = aVar.cKq;
        this.cKs = aVar.cKs;
        this.cKt = aVar.cKt;
        this.cKu = aVar.cKu;
        this.cKv = aVar.cKc;
        this.cKw = aVar.cKw;
        this.cKx = aVar.cKx;
    }
}

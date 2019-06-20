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
    public static final float cKa = l.ai(TbadkCoreApplication.getInst());
    public int cKA;
    public int cKB;
    protected boolean cKp;
    public int cKz;
    public boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float cKb = 0.0f;
    protected float cKc = 0.0f;
    protected int bWr = 0;
    protected int cKd = 0;
    protected float cKe = 15.0f;
    protected int cKf = -1;
    protected int cKg = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int cKh = 200;
    protected int cKi = 200;
    protected int cKj = 0;
    protected int cKk = 0;
    protected boolean cKl = false;
    protected int cKm = -9989158;
    protected ImageView.ScaleType cKn = ImageView.ScaleType.CENTER_CROP;
    public boolean cKo = false;
    public int cKq = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int cKr = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int cKs = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int cKt = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int cKu = 0;
    protected int cKv = -1;
    protected int cKw = -1;
    protected int cKx = -1;
    protected boolean cKy = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.cKd = typedArray.getDimensionPixelSize(4, 0);
        this.bWr = typedArray.getDimensionPixelSize(1, 0);
        this.cKb = typedArray.getFloat(12, 1.12f);
        this.cKe = typedArray.getDimensionPixelSize(11, (int) this.cKe);
        this.mTextColor = typedArray.getColor(0, this.mTextColor);
        this.cKh = typedArray.getDimensionPixelSize(7, this.cKh);
        this.cKi = typedArray.getDimensionPixelSize(10, this.cKi);
        this.cKj = typedArray.getResourceId(2, 0);
        this.cKf = typedArray.getDimensionPixelSize(9, this.cKf);
        this.cKg = typedArray.getDimensionPixelSize(3, this.cKg);
        this.cKk = typedArray.getResourceId(8, 0);
        this.cKl = typedArray.getBoolean(5, false);
        this.cKw = this.cKd;
    }

    public void release() {
    }

    public void ar(int i, int i2) {
        this.cKf = i;
        this.cKg = i2;
    }

    public void lm(int i) {
        this.cKk = i;
    }

    public void ln(int i) {
        this.cKh = i;
    }

    public void lo(int i) {
        this.cKi = i;
    }

    public void lp(int i) {
        this.cKj = i;
    }

    public void setSupportNoImage() {
        this.cKo = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.cKb = f2;
        this.cKc = f;
    }

    public void as(int i, int i2) {
        this.cKq = i;
        this.cKr = i2;
    }

    public void lq(int i) {
        this.cKs = i;
    }

    public void lr(int i) {
        this.cKt = i;
    }

    public void ls(int i) {
        this.cKd = i;
    }

    public void lt(int i) {
        this.cKu = i;
    }

    public void lu(int i) {
        this.cKv = i;
    }

    public void lv(int i) {
        this.cKw = i;
    }

    public void lw(int i) {
        this.cKx = i;
    }

    public void setTextSize(int i) {
        this.cKe = i;
    }

    public boolean axy() {
        return this.cKy;
    }

    public void fP(boolean z) {
        this.cKy = z;
    }

    public void fQ(boolean z) {
        this.cKp = z;
    }

    public int[] o(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.cKp || i3 <= i5 || cKa <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * cKa <= i3) {
                if (i5 * cKa > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * cKa);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.cKb = aVar.cKb;
        this.cKc = aVar.cKc;
        this.bWr = aVar.bWr;
        this.cKd = aVar.cKd;
        this.cKe = aVar.cKe;
        this.cKf = aVar.cKf;
        this.cKg = aVar.cKg;
        this.mTextColor = aVar.mTextColor;
        this.cKh = aVar.cKh;
        this.cKi = aVar.cKi;
        this.cKj = aVar.cKj;
        this.cKk = aVar.cKk;
        this.cKl = aVar.cKl;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.cKm = aVar.cKm;
        this.cKo = aVar.cKo;
        this.cKp = aVar.cKp;
        this.cKq = aVar.cKq;
        this.cKr = aVar.cKr;
        this.cKt = aVar.cKt;
        this.cKu = aVar.cKu;
        this.cKv = aVar.cKv;
        this.cKw = aVar.cKd;
        this.cKx = aVar.cKx;
        this.cKy = aVar.cKy;
    }
}

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
    public static final float fgY = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c ajZ;
    protected boolean fhm;
    public int fhx;
    public int fhy;
    public int fhz;
    public boolean mIsFromCDN;
    protected float fgZ = 0.0f;
    protected float fha = 0.0f;
    protected int cNV = 0;
    protected int fhb = 0;
    protected float mTextSize = 15.0f;
    protected int fhc = -1;
    protected int fhd = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fhe = 200;
    protected int fhf = 200;
    protected int fhg = 0;
    protected int fhh = 0;
    protected boolean fhi = false;
    protected int fhj = -9989158;
    protected ImageView.ScaleType fhk = ImageView.ScaleType.CENTER_CROP;
    public boolean fhl = false;
    public int fhn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fho = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fhp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fhq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fhr = 0;
    protected int fhs = -1;
    protected int fht = -1;
    protected int fhu = -1;
    protected int fhv = 0;
    protected boolean fhw = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fhb = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.cNV = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fgZ = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fhe = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fhe);
        this.fhf = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fhf);
        this.fhg = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fhc = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fhc);
        this.fhd = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fhd);
        this.fhh = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fhi = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fht = this.fhb;
    }

    public void release() {
    }

    public void br(int i, int i2) {
        this.fhc = i;
        this.fhd = i2;
    }

    public void rt(int i) {
        this.fhh = i;
    }

    public void ru(int i) {
        this.fhe = i;
    }

    public void rv(int i) {
        this.fhf = i;
    }

    public void rw(int i) {
        this.fhg = i;
    }

    public void setSupportNoImage() {
        this.fhl = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fgZ = f2;
        this.fha = f;
    }

    public void bs(int i, int i2) {
        this.fhn = i;
        this.fho = i2;
    }

    public void rx(int i) {
        this.fhp = i;
    }

    public void ry(int i) {
        this.fhq = i;
    }

    public void rz(int i) {
        this.fhb = i;
    }

    public void rA(int i) {
        this.fhr = i;
    }

    public void rB(int i) {
        this.fhs = i;
    }

    public void rC(int i) {
        this.fht = i;
    }

    public void rD(int i) {
        this.fhu = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean byF() {
        return this.fhw;
    }

    public void jY(boolean z) {
        this.fhw = z;
    }

    public void jZ(boolean z) {
        this.fhm = z;
    }

    public void rE(int i) {
        this.fhv = i;
    }

    public int[] v(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fhm || i3 <= i5 || fgY <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fgY <= i3) {
                if (i5 * fgY > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fgY);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fgZ = aVar.fgZ;
        this.fha = aVar.fha;
        this.cNV = aVar.cNV;
        this.fhb = aVar.fhb;
        this.mTextSize = aVar.mTextSize;
        this.fhc = aVar.fhc;
        this.fhd = aVar.fhd;
        this.mTextColor = aVar.mTextColor;
        this.fhe = aVar.fhe;
        this.fhf = aVar.fhf;
        this.fhg = aVar.fhg;
        this.fhh = aVar.fhh;
        this.fhi = aVar.fhi;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fhj = aVar.fhj;
        this.fhl = aVar.fhl;
        this.fhm = aVar.fhm;
        this.fhn = aVar.fhn;
        this.fho = aVar.fho;
        this.fhq = aVar.fhq;
        this.fhr = aVar.fhr;
        this.fhs = aVar.fhs;
        this.fht = aVar.fhb;
        this.fhu = aVar.fhu;
        this.fhw = aVar.fhw;
    }
}

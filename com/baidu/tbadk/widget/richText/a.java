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
    public static final float fHc = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c akv;
    public int fHC;
    public int fHD;
    public int fHE;
    protected boolean fHr;
    public boolean mIsFromCDN;
    protected float fHd = 0.0f;
    protected float fHe = 0.0f;
    protected int dmN = 0;
    protected int fHf = 0;
    protected float mTextSize = 15.0f;
    protected boolean fHg = false;
    protected int fHh = -1;
    protected int fHi = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fHj = 200;
    protected int fHk = 200;
    protected int fHl = 0;
    protected int fHm = 0;
    protected boolean fHn = false;
    protected int fHo = -9989158;
    protected ImageView.ScaleType fHp = ImageView.ScaleType.CENTER_CROP;
    public boolean fHq = false;
    public int fHs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fHt = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fHu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fHv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fHw = 0;
    protected int fHx = -1;
    protected int fHy = -1;
    protected int fHz = -1;
    protected int fHA = 0;
    protected boolean fHB = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fHf = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.dmN = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fHd = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fHj = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fHj);
        this.fHk = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fHk);
        this.fHl = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fHh = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fHh);
        this.fHi = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fHi);
        this.fHm = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fHn = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fHy = this.fHf;
    }

    public void release() {
    }

    public void ao(float f) {
        this.fHd = f;
    }

    public void br(int i, int i2) {
        this.fHh = i;
        this.fHi = i2;
    }

    public void sK(int i) {
        this.fHm = i;
    }

    public void sL(int i) {
        this.fHj = i;
    }

    public void sM(int i) {
        this.fHk = i;
    }

    public void sN(int i) {
        this.fHl = i;
    }

    public void setSupportNoImage() {
        this.fHq = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fHd = f2;
        this.fHe = f;
    }

    public void bs(int i, int i2) {
        this.fHs = i;
        this.fHt = i2;
    }

    public void sO(int i) {
        this.fHu = i;
    }

    public void sP(int i) {
        this.fHv = i;
    }

    public void sQ(int i) {
        this.fHf = i;
    }

    public void sR(int i) {
        this.fHw = i;
    }

    public void sS(int i) {
        this.fHx = i;
    }

    public void sT(int i) {
        this.fHy = i;
    }

    public void sU(int i) {
        this.fHz = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bFa() {
        return this.fHB;
    }

    public void kT(boolean z) {
        this.fHB = z;
    }

    public void kU(boolean z) {
        this.fHr = z;
    }

    public void sV(int i) {
        this.fHA = i;
    }

    public int[] w(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fHr || i3 <= i5 || fHc <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fHc <= i3) {
                if (i5 * fHc > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fHc);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fHd = aVar.fHd;
        this.fHe = aVar.fHe;
        this.dmN = aVar.dmN;
        this.fHf = aVar.fHf;
        this.mTextSize = aVar.mTextSize;
        this.fHh = aVar.fHh;
        this.fHi = aVar.fHi;
        this.mTextColor = aVar.mTextColor;
        this.fHj = aVar.fHj;
        this.fHk = aVar.fHk;
        this.fHl = aVar.fHl;
        this.fHm = aVar.fHm;
        this.fHn = aVar.fHn;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fHo = aVar.fHo;
        this.fHq = aVar.fHq;
        this.fHr = aVar.fHr;
        this.fHs = aVar.fHs;
        this.fHt = aVar.fHt;
        this.fHv = aVar.fHv;
        this.fHw = aVar.fHw;
        this.fHx = aVar.fHx;
        this.fHy = aVar.fHf;
        this.fHz = aVar.fHz;
        this.fHB = aVar.fHB;
    }
}

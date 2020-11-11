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
    public static final float fHA = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c aks;
    protected boolean fHO;
    public int fHZ;
    public int fIa;
    public int fIb;
    public boolean mIsFromCDN;
    protected float fHB = 0.0f;
    protected float fHC = 0.0f;
    protected int dox = 0;
    protected int fHD = 0;
    protected float mTextSize = 15.0f;
    protected int fHE = -1;
    protected int fHF = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fHG = 200;
    protected int fHH = 200;
    protected int fHI = 0;
    protected int fHJ = 0;
    protected boolean fHK = false;
    protected int fHL = -9989158;
    protected ImageView.ScaleType fHM = ImageView.ScaleType.CENTER_CROP;
    public boolean fHN = false;
    public int fHP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fHQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fHR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fHS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fHT = 0;
    protected int fHU = -1;
    protected int fHV = -1;
    protected int fHW = -1;
    protected int fHX = 0;
    protected boolean fHY = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fHD = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.dox = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fHB = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fHG = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fHG);
        this.fHH = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fHH);
        this.fHI = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fHE = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fHE);
        this.fHF = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fHF);
        this.fHJ = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fHK = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fHV = this.fHD;
    }

    public void release() {
    }

    public void br(int i, int i2) {
        this.fHE = i;
        this.fHF = i2;
    }

    public void sm(int i) {
        this.fHJ = i;
    }

    public void sn(int i) {
        this.fHG = i;
    }

    public void so(int i) {
        this.fHH = i;
    }

    public void sp(int i) {
        this.fHI = i;
    }

    public void setSupportNoImage() {
        this.fHN = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fHB = f2;
        this.fHC = f;
    }

    public void bs(int i, int i2) {
        this.fHP = i;
        this.fHQ = i2;
    }

    public void sq(int i) {
        this.fHR = i;
    }

    public void sr(int i) {
        this.fHS = i;
    }

    public void ss(int i) {
        this.fHD = i;
    }

    public void st(int i) {
        this.fHT = i;
    }

    public void su(int i) {
        this.fHU = i;
    }

    public void sv(int i) {
        this.fHV = i;
    }

    public void sw(int i) {
        this.fHW = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bFH() {
        return this.fHY;
    }

    public void kS(boolean z) {
        this.fHY = z;
    }

    public void kT(boolean z) {
        this.fHO = z;
    }

    public void sx(int i) {
        this.fHX = i;
    }

    public int[] v(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fHO || i3 <= i5 || fHA <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fHA <= i3) {
                if (i5 * fHA > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fHA);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fHB = aVar.fHB;
        this.fHC = aVar.fHC;
        this.dox = aVar.dox;
        this.fHD = aVar.fHD;
        this.mTextSize = aVar.mTextSize;
        this.fHE = aVar.fHE;
        this.fHF = aVar.fHF;
        this.mTextColor = aVar.mTextColor;
        this.fHG = aVar.fHG;
        this.fHH = aVar.fHH;
        this.fHI = aVar.fHI;
        this.fHJ = aVar.fHJ;
        this.fHK = aVar.fHK;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fHL = aVar.fHL;
        this.fHN = aVar.fHN;
        this.fHO = aVar.fHO;
        this.fHP = aVar.fHP;
        this.fHQ = aVar.fHQ;
        this.fHS = aVar.fHS;
        this.fHT = aVar.fHT;
        this.fHU = aVar.fHU;
        this.fHV = aVar.fHD;
        this.fHW = aVar.fHW;
        this.fHY = aVar.fHY;
    }
}

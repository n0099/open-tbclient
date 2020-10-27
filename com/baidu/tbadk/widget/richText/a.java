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
    public static final float fBK = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c aks;
    protected boolean fBY;
    public int fCj;
    public int fCk;
    public int fCl;
    public boolean mIsFromCDN;
    protected float fBL = 0.0f;
    protected float fBM = 0.0f;
    protected int diC = 0;
    protected int fBN = 0;
    protected float mTextSize = 15.0f;
    protected int fBO = -1;
    protected int fBP = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fBQ = 200;
    protected int fBR = 200;
    protected int fBS = 0;
    protected int fBT = 0;
    protected boolean fBU = false;
    protected int fBV = -9989158;
    protected ImageView.ScaleType fBW = ImageView.ScaleType.CENTER_CROP;
    public boolean fBX = false;
    public int fBZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fCa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fCb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fCc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fCd = 0;
    protected int fCe = -1;
    protected int fCf = -1;
    protected int fCg = -1;
    protected int fCh = 0;
    protected boolean fCi = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fBN = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.diC = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fBL = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fBQ = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fBQ);
        this.fBR = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fBR);
        this.fBS = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fBO = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fBO);
        this.fBP = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fBP);
        this.fBT = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fBU = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fCf = this.fBN;
    }

    public void release() {
    }

    public void br(int i, int i2) {
        this.fBO = i;
        this.fBP = i2;
    }

    public void sc(int i) {
        this.fBT = i;
    }

    public void sd(int i) {
        this.fBQ = i;
    }

    public void se(int i) {
        this.fBR = i;
    }

    public void sf(int i) {
        this.fBS = i;
    }

    public void setSupportNoImage() {
        this.fBX = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fBL = f2;
        this.fBM = f;
    }

    public void bs(int i, int i2) {
        this.fBZ = i;
        this.fCa = i2;
    }

    public void sg(int i) {
        this.fCb = i;
    }

    public void sh(int i) {
        this.fCc = i;
    }

    public void si(int i) {
        this.fBN = i;
    }

    public void sj(int i) {
        this.fCd = i;
    }

    public void sk(int i) {
        this.fCe = i;
    }

    public void sl(int i) {
        this.fCf = i;
    }

    public void sm(int i) {
        this.fCg = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bDi() {
        return this.fCi;
    }

    public void kJ(boolean z) {
        this.fCi = z;
    }

    public void kK(boolean z) {
        this.fBY = z;
    }

    public void sn(int i) {
        this.fCh = i;
    }

    public int[] v(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fBY || i3 <= i5 || fBK <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fBK <= i3) {
                if (i5 * fBK > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fBK);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fBL = aVar.fBL;
        this.fBM = aVar.fBM;
        this.diC = aVar.diC;
        this.fBN = aVar.fBN;
        this.mTextSize = aVar.mTextSize;
        this.fBO = aVar.fBO;
        this.fBP = aVar.fBP;
        this.mTextColor = aVar.mTextColor;
        this.fBQ = aVar.fBQ;
        this.fBR = aVar.fBR;
        this.fBS = aVar.fBS;
        this.fBT = aVar.fBT;
        this.fBU = aVar.fBU;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fBV = aVar.fBV;
        this.fBX = aVar.fBX;
        this.fBY = aVar.fBY;
        this.fBZ = aVar.fBZ;
        this.fCa = aVar.fCa;
        this.fCc = aVar.fCc;
        this.fCd = aVar.fCd;
        this.fCe = aVar.fCe;
        this.fCf = aVar.fBN;
        this.fCg = aVar.fCg;
        this.fCi = aVar.fCi;
    }
}

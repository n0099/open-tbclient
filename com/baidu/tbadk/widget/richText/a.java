package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    public static final float fTK = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c alg;
    protected boolean fTZ;
    public int fUk;
    public int fUl;
    public int fUm;
    public boolean mIsFromCDN;
    protected float fTL = 0.0f;
    protected float fTM = 0.0f;
    protected int dva = 0;
    protected int fTN = 0;
    protected float mTextSize = 15.0f;
    protected boolean fTO = false;
    protected int fTP = -1;
    protected int fTQ = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fTR = 200;
    protected int fTS = 200;
    protected int fTT = 0;
    protected int fTU = 0;
    protected boolean fTV = false;
    protected int fTW = -9989158;
    protected ImageView.ScaleType fTX = ImageView.ScaleType.CENTER_CROP;
    public boolean fTY = false;
    public int fUa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fUb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fUc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fUd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fUe = 0;
    protected int fUf = -1;
    protected int fUg = -1;
    protected int fUh = -1;
    protected int fUi = 0;
    protected boolean fUj = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fTN = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.dva = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fTL = typedArray.getFloat(R.styleable.TbRichTextView_tbLineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fTR = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fTR);
        this.fTS = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fTS);
        this.fTT = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fTP = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fTP);
        this.fTQ = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fTQ);
        this.fTU = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fTV = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fUg = this.fTN;
    }

    public void release() {
    }

    public void ar(float f) {
        this.fTL = f;
    }

    public void br(int i, int i2) {
        this.fTP = i;
        this.fTQ = i2;
    }

    public void rS(int i) {
        this.fTU = i;
    }

    public void rT(int i) {
        this.fTR = i;
    }

    public void rU(int i) {
        this.fTS = i;
    }

    public void rV(int i) {
        this.fTT = i;
    }

    public void setSupportNoImage() {
        this.fTY = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fTL = f2;
        this.fTM = f;
    }

    public void bs(int i, int i2) {
        this.fUa = i;
        this.fUb = i2;
    }

    public void rW(int i) {
        this.fUc = i;
    }

    public void rX(int i) {
        this.fUd = i;
    }

    public void rY(int i) {
        this.fTN = i;
    }

    public void rZ(int i) {
        this.fUe = i;
    }

    public void sa(int i) {
        this.fUf = i;
    }

    public void sb(int i) {
        this.fUg = i;
    }

    public void sc(int i) {
        this.fUh = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bHe() {
        return this.fUj;
    }

    public void lF(boolean z) {
        this.fUj = z;
    }

    public void lG(boolean z) {
        this.fTZ = z;
    }

    public void sd(int i) {
        this.fUi = i;
    }

    public int[] B(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fTZ || i3 <= i5 || fTK <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fTK <= i3) {
                if (i5 * fTK > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fTK);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fTL = aVar.fTL;
        this.fTM = aVar.fTM;
        this.dva = aVar.dva;
        this.fTN = aVar.fTN;
        this.mTextSize = aVar.mTextSize;
        this.fTP = aVar.fTP;
        this.fTQ = aVar.fTQ;
        this.mTextColor = aVar.mTextColor;
        this.fTR = aVar.fTR;
        this.fTS = aVar.fTS;
        this.fTT = aVar.fTT;
        this.fTU = aVar.fTU;
        this.fTV = aVar.fTV;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fTW = aVar.fTW;
        this.fTY = aVar.fTY;
        this.fTZ = aVar.fTZ;
        this.fUa = aVar.fUa;
        this.fUb = aVar.fUb;
        this.fUd = aVar.fUd;
        this.fUe = aVar.fUe;
        this.fUf = aVar.fUf;
        this.fUg = aVar.fTN;
        this.fUh = aVar.fUh;
        this.fUj = aVar.fUj;
    }
}

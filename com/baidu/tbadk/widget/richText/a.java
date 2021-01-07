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
    public static final float fYr = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c alY;
    protected boolean fYG;
    public int fYR;
    public int fYS;
    public int fYT;
    public boolean mIsFromCDN;
    protected float fYs = 0.0f;
    protected float fYt = 0.0f;
    protected int dzM = 0;
    protected int fYu = 0;
    protected float mTextSize = 15.0f;
    protected boolean fYv = false;
    protected int fYw = -1;
    protected int fYx = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fYy = 200;
    protected int fYz = 200;
    protected int fYA = 0;
    protected int fYB = 0;
    protected boolean fYC = false;
    protected int fYD = -9989158;
    protected ImageView.ScaleType fYE = ImageView.ScaleType.CENTER_CROP;
    public boolean fYF = false;
    public int fYH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fYI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fYJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fYK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fYL = 0;
    protected int fYM = -1;
    protected int fYN = -1;
    protected int fYO = -1;
    protected int fYP = 0;
    protected boolean fYQ = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fYu = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.dzM = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fYs = typedArray.getFloat(R.styleable.TbRichTextView_tbLineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fYy = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fYy);
        this.fYz = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fYz);
        this.fYA = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fYw = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fYw);
        this.fYx = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fYx);
        this.fYB = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fYC = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fYN = this.fYu;
    }

    public void release() {
    }

    public void ar(float f) {
        this.fYs = f;
    }

    public void br(int i, int i2) {
        this.fYw = i;
        this.fYx = i2;
    }

    public void ty(int i) {
        this.fYB = i;
    }

    public void tz(int i) {
        this.fYy = i;
    }

    public void tA(int i) {
        this.fYz = i;
    }

    public void tB(int i) {
        this.fYA = i;
    }

    public void setSupportNoImage() {
        this.fYF = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fYs = f2;
        this.fYt = f;
    }

    public void bs(int i, int i2) {
        this.fYH = i;
        this.fYI = i2;
    }

    public void tC(int i) {
        this.fYJ = i;
    }

    public void tD(int i) {
        this.fYK = i;
    }

    public void tE(int i) {
        this.fYu = i;
    }

    public void tF(int i) {
        this.fYL = i;
    }

    public void tG(int i) {
        this.fYM = i;
    }

    public void tH(int i) {
        this.fYN = i;
    }

    public void tI(int i) {
        this.fYO = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bKW() {
        return this.fYQ;
    }

    public void lJ(boolean z) {
        this.fYQ = z;
    }

    public void lK(boolean z) {
        this.fYG = z;
    }

    public void tJ(int i) {
        this.fYP = i;
    }

    public int[] B(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fYG || i3 <= i5 || fYr <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fYr <= i3) {
                if (i5 * fYr > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fYr);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fYs = aVar.fYs;
        this.fYt = aVar.fYt;
        this.dzM = aVar.dzM;
        this.fYu = aVar.fYu;
        this.mTextSize = aVar.mTextSize;
        this.fYw = aVar.fYw;
        this.fYx = aVar.fYx;
        this.mTextColor = aVar.mTextColor;
        this.fYy = aVar.fYy;
        this.fYz = aVar.fYz;
        this.fYA = aVar.fYA;
        this.fYB = aVar.fYB;
        this.fYC = aVar.fYC;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fYD = aVar.fYD;
        this.fYF = aVar.fYF;
        this.fYG = aVar.fYG;
        this.fYH = aVar.fYH;
        this.fYI = aVar.fYI;
        this.fYK = aVar.fYK;
        this.fYL = aVar.fYL;
        this.fYM = aVar.fYM;
        this.fYN = aVar.fYu;
        this.fYO = aVar.fYO;
        this.fYQ = aVar.fYQ;
    }
}

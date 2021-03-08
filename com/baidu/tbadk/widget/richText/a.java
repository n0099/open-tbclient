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
    public static final float fXz = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c amp;
    protected boolean fXO;
    public int fXZ;
    public int fYa;
    public int fYb;
    public boolean mIsFromCDN;
    protected float fXA = 0.0f;
    protected float fXB = 0.0f;
    protected int dyJ = 0;
    protected int fXC = 0;
    protected float mTextSize = 15.0f;
    protected boolean fXD = false;
    protected int fXE = -1;
    protected int fXF = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fXG = 200;
    protected int fXH = 200;
    protected int fXI = 0;
    protected int fXJ = 0;
    protected boolean fXK = false;
    protected int fXL = -9989158;
    protected ImageView.ScaleType fXM = ImageView.ScaleType.CENTER_CROP;
    public boolean fXN = false;
    public int fXP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fXQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fXR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fXS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fXT = 0;
    protected int fXU = -1;
    protected int fXV = -1;
    protected int fXW = -1;
    protected int fXX = 0;
    protected boolean fXY = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fXC = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.dyJ = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fXA = typedArray.getFloat(R.styleable.TbRichTextView_tbLineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fXG = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fXG);
        this.fXH = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fXH);
        this.fXI = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fXE = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fXE);
        this.fXF = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fXF);
        this.fXJ = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fXK = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fXV = this.fXC;
    }

    public void release() {
    }

    public void aw(float f) {
        this.fXA = f;
    }

    public void bo(int i, int i2) {
        this.fXE = i;
        this.fXF = i2;
    }

    public void rZ(int i) {
        this.fXJ = i;
    }

    public void sa(int i) {
        this.fXG = i;
    }

    public void sb(int i) {
        this.fXH = i;
    }

    public void sc(int i) {
        this.fXI = i;
    }

    public void setSupportNoImage() {
        this.fXN = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fXA = f2;
        this.fXB = f;
    }

    public void bp(int i, int i2) {
        this.fXP = i;
        this.fXQ = i2;
    }

    public void sd(int i) {
        this.fXR = i;
    }

    public void se(int i) {
        this.fXS = i;
    }

    public void sf(int i) {
        this.fXC = i;
    }

    public void sg(int i) {
        this.fXT = i;
    }

    public void sh(int i) {
        this.fXU = i;
    }

    public void si(int i) {
        this.fXV = i;
    }

    public void sj(int i) {
        this.fXW = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bHC() {
        return this.fXY;
    }

    public void lJ(boolean z) {
        this.fXY = z;
    }

    public void lK(boolean z) {
        this.fXO = z;
    }

    public void sk(int i) {
        this.fXX = i;
    }

    public int[] B(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fXO || i3 <= i5 || fXz <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fXz <= i3) {
                if (i5 * fXz > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fXz);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fXA = aVar.fXA;
        this.fXB = aVar.fXB;
        this.dyJ = aVar.dyJ;
        this.fXC = aVar.fXC;
        this.mTextSize = aVar.mTextSize;
        this.fXE = aVar.fXE;
        this.fXF = aVar.fXF;
        this.mTextColor = aVar.mTextColor;
        this.fXG = aVar.fXG;
        this.fXH = aVar.fXH;
        this.fXI = aVar.fXI;
        this.fXJ = aVar.fXJ;
        this.fXK = aVar.fXK;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fXL = aVar.fXL;
        this.fXN = aVar.fXN;
        this.fXO = aVar.fXO;
        this.fXP = aVar.fXP;
        this.fXQ = aVar.fXQ;
        this.fXS = aVar.fXS;
        this.fXT = aVar.fXT;
        this.fXU = aVar.fXU;
        this.fXV = aVar.fXC;
        this.fXW = aVar.fXW;
        this.fXY = aVar.fXY;
    }
}

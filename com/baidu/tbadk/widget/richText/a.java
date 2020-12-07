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
    public static final float fOO = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.b alw;
    protected boolean fPd;
    public int fPo;
    public int fPp;
    public int fPq;
    public boolean mIsFromCDN;
    protected float fOP = 0.0f;
    protected float fOQ = 0.0f;
    protected int dtQ = 0;
    protected int fOR = 0;
    protected float mTextSize = 15.0f;
    protected boolean fOS = false;
    protected int fOT = -1;
    protected int fOU = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fOV = 200;
    protected int fOW = 200;
    protected int fOX = 0;
    protected int fOY = 0;
    protected boolean fOZ = false;
    protected int fPa = -9989158;
    protected ImageView.ScaleType fPb = ImageView.ScaleType.CENTER_CROP;
    public boolean fPc = false;
    public int fPe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fPf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fPg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fPh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fPi = 0;
    protected int fPj = -1;
    protected int fPk = -1;
    protected int fPl = -1;
    protected int fPm = 0;
    protected boolean fPn = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fOR = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.dtQ = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fOP = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fOV = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fOV);
        this.fOW = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fOW);
        this.fOX = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fOT = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fOT);
        this.fOU = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fOU);
        this.fOY = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fOZ = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fPk = this.fOR;
    }

    public void release() {
    }

    public void ap(float f) {
        this.fOP = f;
    }

    public void bt(int i, int i2) {
        this.fOT = i;
        this.fOU = i2;
    }

    public void tn(int i) {
        this.fOY = i;
    }

    public void to(int i) {
        this.fOV = i;
    }

    public void tp(int i) {
        this.fOW = i;
    }

    public void tq(int i) {
        this.fOX = i;
    }

    public void setSupportNoImage() {
        this.fPc = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fOP = f2;
        this.fOQ = f;
    }

    public void bu(int i, int i2) {
        this.fPe = i;
        this.fPf = i2;
    }

    public void tr(int i) {
        this.fPg = i;
    }

    public void ts(int i) {
        this.fPh = i;
    }

    public void tt(int i) {
        this.fOR = i;
    }

    public void tu(int i) {
        this.fPi = i;
    }

    public void tv(int i) {
        this.fPj = i;
    }

    public void tw(int i) {
        this.fPk = i;
    }

    public void tx(int i) {
        this.fPl = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bIB() {
        return this.fPn;
    }

    public void ln(boolean z) {
        this.fPn = z;
    }

    public void lo(boolean z) {
        this.fPd = z;
    }

    public void ty(int i) {
        this.fPm = i;
    }

    public int[] A(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fPd || i3 <= i5 || fOO <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fOO <= i3) {
                if (i5 * fOO > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fOO);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fOP = aVar.fOP;
        this.fOQ = aVar.fOQ;
        this.dtQ = aVar.dtQ;
        this.fOR = aVar.fOR;
        this.mTextSize = aVar.mTextSize;
        this.fOT = aVar.fOT;
        this.fOU = aVar.fOU;
        this.mTextColor = aVar.mTextColor;
        this.fOV = aVar.fOV;
        this.fOW = aVar.fOW;
        this.fOX = aVar.fOX;
        this.fOY = aVar.fOY;
        this.fOZ = aVar.fOZ;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fPa = aVar.fPa;
        this.fPc = aVar.fPc;
        this.fPd = aVar.fPd;
        this.fPe = aVar.fPe;
        this.fPf = aVar.fPf;
        this.fPh = aVar.fPh;
        this.fPi = aVar.fPi;
        this.fPj = aVar.fPj;
        this.fPk = aVar.fOR;
        this.fPl = aVar.fPl;
        this.fPn = aVar.fPn;
    }
}

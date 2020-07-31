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
    public static final float eTv = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c aik;
    protected boolean eTJ;
    public int eTU;
    public int eTV;
    public int eTW;
    public boolean mIsFromCDN;
    protected float eTw = 0.0f;
    protected float eTx = 0.0f;
    protected int efu = 0;
    protected int eTy = 0;
    protected float mTextSize = 15.0f;
    protected int eTz = -1;
    protected int eTA = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int eTB = 200;
    protected int eTC = 200;
    protected int eTD = 0;
    protected int eTE = 0;
    protected boolean eTF = false;
    protected int eTG = -9989158;
    protected ImageView.ScaleType eTH = ImageView.ScaleType.CENTER_CROP;
    public boolean eTI = false;
    public int eTK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int eTL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int eTM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int eTN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int eTO = 0;
    protected int eTP = -1;
    protected int eTQ = -1;
    protected int eTR = -1;
    protected int eTS = 0;
    protected boolean eTT = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.eTy = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.efu = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.eTw = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.eTB = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.eTB);
        this.eTC = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.eTC);
        this.eTD = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.eTz = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.eTz);
        this.eTA = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.eTA);
        this.eTE = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.eTF = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.eTQ = this.eTy;
    }

    public void release() {
    }

    public void bi(int i, int i2) {
        this.eTz = i;
        this.eTA = i2;
    }

    public void oQ(int i) {
        this.eTE = i;
    }

    public void oR(int i) {
        this.eTB = i;
    }

    public void oS(int i) {
        this.eTC = i;
    }

    public void oT(int i) {
        this.eTD = i;
    }

    public void setSupportNoImage() {
        this.eTI = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.eTw = f2;
        this.eTx = f;
    }

    public void bj(int i, int i2) {
        this.eTK = i;
        this.eTL = i2;
    }

    public void oU(int i) {
        this.eTM = i;
    }

    public void oV(int i) {
        this.eTN = i;
    }

    public void oW(int i) {
        this.eTy = i;
    }

    public void oX(int i) {
        this.eTO = i;
    }

    public void oY(int i) {
        this.eTP = i;
    }

    public void oZ(int i) {
        this.eTQ = i;
    }

    public void pa(int i) {
        this.eTR = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean boI() {
        return this.eTT;
    }

    public void jx(boolean z) {
        this.eTT = z;
    }

    public void jy(boolean z) {
        this.eTJ = z;
    }

    public void pb(int i) {
        this.eTS = i;
    }

    public int[] v(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.eTJ || i3 <= i5 || eTv <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * eTv <= i3) {
                if (i5 * eTv > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * eTv);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.eTw = aVar.eTw;
        this.eTx = aVar.eTx;
        this.efu = aVar.efu;
        this.eTy = aVar.eTy;
        this.mTextSize = aVar.mTextSize;
        this.eTz = aVar.eTz;
        this.eTA = aVar.eTA;
        this.mTextColor = aVar.mTextColor;
        this.eTB = aVar.eTB;
        this.eTC = aVar.eTC;
        this.eTD = aVar.eTD;
        this.eTE = aVar.eTE;
        this.eTF = aVar.eTF;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.eTG = aVar.eTG;
        this.eTI = aVar.eTI;
        this.eTJ = aVar.eTJ;
        this.eTK = aVar.eTK;
        this.eTL = aVar.eTL;
        this.eTN = aVar.eTN;
        this.eTO = aVar.eTO;
        this.eTP = aVar.eTP;
        this.eTQ = aVar.eTy;
        this.eTR = aVar.eTR;
        this.eTT = aVar.eTT;
    }
}

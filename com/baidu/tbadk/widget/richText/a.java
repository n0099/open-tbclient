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
    public static final float fVZ = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c akW;
    public int fWA;
    public int fWB;
    protected boolean fWo;
    public int fWz;
    public boolean mIsFromCDN;
    protected float fWa = 0.0f;
    protected float fWb = 0.0f;
    protected int dxi = 0;
    protected int fWc = 0;
    protected float mTextSize = 15.0f;
    protected boolean fWd = false;
    protected int fWe = -1;
    protected int fWf = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fWg = 200;
    protected int fWh = 200;
    protected int fWi = 0;
    protected int fWj = 0;
    protected boolean fWk = false;
    protected int fWl = -9989158;
    protected ImageView.ScaleType fWm = ImageView.ScaleType.CENTER_CROP;
    public boolean fWn = false;
    public int fWp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fWq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fWr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fWs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fWt = 0;
    protected int fWu = -1;
    protected int fWv = -1;
    protected int fWw = -1;
    protected int fWx = 0;
    protected boolean fWy = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fWc = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.dxi = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fWa = typedArray.getFloat(R.styleable.TbRichTextView_tbLineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fWg = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fWg);
        this.fWh = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fWh);
        this.fWi = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fWe = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fWe);
        this.fWf = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fWf);
        this.fWj = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fWk = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fWv = this.fWc;
    }

    public void release() {
    }

    public void as(float f) {
        this.fWa = f;
    }

    public void bo(int i, int i2) {
        this.fWe = i;
        this.fWf = i2;
    }

    public void rX(int i) {
        this.fWj = i;
    }

    public void rY(int i) {
        this.fWg = i;
    }

    public void rZ(int i) {
        this.fWh = i;
    }

    public void sa(int i) {
        this.fWi = i;
    }

    public void setSupportNoImage() {
        this.fWn = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fWa = f2;
        this.fWb = f;
    }

    public void bp(int i, int i2) {
        this.fWp = i;
        this.fWq = i2;
    }

    public void sb(int i) {
        this.fWr = i;
    }

    public void sc(int i) {
        this.fWs = i;
    }

    public void sd(int i) {
        this.fWc = i;
    }

    public void se(int i) {
        this.fWt = i;
    }

    public void sf(int i) {
        this.fWu = i;
    }

    public void sg(int i) {
        this.fWv = i;
    }

    public void sh(int i) {
        this.fWw = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bHy() {
        return this.fWy;
    }

    public void lJ(boolean z) {
        this.fWy = z;
    }

    public void lK(boolean z) {
        this.fWo = z;
    }

    public void si(int i) {
        this.fWx = i;
    }

    public int[] B(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.fWo || i3 <= i5 || fVZ <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fVZ <= i3) {
                if (i5 * fVZ > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fVZ);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fWa = aVar.fWa;
        this.fWb = aVar.fWb;
        this.dxi = aVar.dxi;
        this.fWc = aVar.fWc;
        this.mTextSize = aVar.mTextSize;
        this.fWe = aVar.fWe;
        this.fWf = aVar.fWf;
        this.mTextColor = aVar.mTextColor;
        this.fWg = aVar.fWg;
        this.fWh = aVar.fWh;
        this.fWi = aVar.fWi;
        this.fWj = aVar.fWj;
        this.fWk = aVar.fWk;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fWl = aVar.fWl;
        this.fWn = aVar.fWn;
        this.fWo = aVar.fWo;
        this.fWp = aVar.fWp;
        this.fWq = aVar.fWq;
        this.fWs = aVar.fWs;
        this.fWt = aVar.fWt;
        this.fWu = aVar.fWu;
        this.fWv = aVar.fWc;
        this.fWw = aVar.fWw;
        this.fWy = aVar.fWy;
    }
}

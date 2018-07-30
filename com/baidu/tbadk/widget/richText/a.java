package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    public static final float beB = l.ak(TbadkCoreApplication.getInst());
    protected boolean beQ;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float beC = 0.0f;
    protected float beD = 0.0f;
    protected int atz = 0;
    protected int beE = 0;
    protected float beF = 15.0f;
    protected int beG = -1;
    protected int beH = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int beI = 200;
    protected int beJ = 200;
    protected int beK = 0;
    protected int beL = 0;
    protected boolean beM = false;
    protected int beN = -9989158;
    protected ImageView.ScaleType beO = ImageView.ScaleType.CENTER_CROP;
    protected boolean beP = false;
    protected int beR = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int beS = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int beT = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int beU = 0;
    protected int beV = -1;
    protected int beW = -1;
    protected int beX = -1;
    protected boolean beY = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.beE = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.atz = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.beC = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.beF = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.beF);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.beI = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.beI);
        this.beJ = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.beJ);
        this.beK = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.beG = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.beG);
        this.beH = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.beH);
        this.beL = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.beM = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.beW = this.beE;
    }

    public void release() {
    }

    public void P(int i, int i2) {
        this.beG = i;
        this.beH = i2;
    }

    public void fO(int i) {
        this.beL = i;
    }

    public void fP(int i) {
        this.beI = i;
    }

    public void fQ(int i) {
        this.beJ = i;
    }

    public void fR(int i) {
        this.beK = i;
    }

    public void setSupportNoImage() {
        this.beP = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.beC = f2;
        this.beD = f;
    }

    public void Q(int i, int i2) {
        this.beR = i;
        this.beS = i2;
    }

    public void fS(int i) {
        this.beT = i;
    }

    public void fT(int i) {
        this.beE = i;
    }

    public void fU(int i) {
        this.beU = i;
    }

    public void fV(int i) {
        this.beV = i;
    }

    public void fW(int i) {
        this.beW = i;
    }

    public void fX(int i) {
        this.beX = i;
    }

    public void setTextSize(int i) {
        this.beF = i;
    }

    public boolean Nw() {
        return this.beY;
    }

    public void cl(boolean z) {
        this.beY = z;
    }

    public void cm(boolean z) {
        this.beQ = z;
    }

    public int[] j(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.beQ || i3 <= i5 || beB <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * beB <= i3) {
                if (i5 * beB > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * beB);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.beC = aVar.beC;
        this.beD = aVar.beD;
        this.atz = aVar.atz;
        this.beE = aVar.beE;
        this.beF = aVar.beF;
        this.beG = aVar.beG;
        this.beH = aVar.beH;
        this.mTextColor = aVar.mTextColor;
        this.beI = aVar.beI;
        this.beJ = aVar.beJ;
        this.beK = aVar.beK;
        this.beL = aVar.beL;
        this.beM = aVar.beM;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.beN = aVar.beN;
        this.beP = aVar.beP;
        this.beQ = aVar.beQ;
        this.beR = aVar.beR;
        this.beS = aVar.beS;
        this.beT = aVar.beT;
        this.beU = aVar.beU;
        this.beV = aVar.beV;
        this.beW = aVar.beE;
        this.beX = aVar.beX;
        this.beY = aVar.beY;
    }
}

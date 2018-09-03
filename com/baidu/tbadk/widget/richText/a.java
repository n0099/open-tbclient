package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class a {
    public static final float beC = l.ak(TbadkCoreApplication.getInst());
    protected boolean beR;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float beD = 0.0f;
    protected float beE = 0.0f;
    protected int atA = 0;
    protected int beF = 0;
    protected float beG = 15.0f;
    protected int beH = -1;
    protected int beI = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int beJ = 200;
    protected int beK = 200;
    protected int beL = 0;
    protected int beM = 0;
    protected boolean beN = false;
    protected int beO = -9989158;
    protected ImageView.ScaleType beP = ImageView.ScaleType.CENTER_CROP;
    protected boolean beQ = false;
    protected int beS = l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds16);
    protected int beT = l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds20);
    protected int beU = l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds20);
    protected int beV = 0;
    protected int beW = -1;
    protected int beX = -1;
    protected int beY = -1;
    protected boolean beZ = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.beF = typedArray.getDimensionPixelSize(f.l.TbRichTextView_segmentMargin, 0);
        this.atA = typedArray.getDimensionPixelSize(f.l.TbRichTextView_textPadding, 0);
        this.beD = typedArray.getFloat(f.l.TbRichTextView_lineSpacing, 1.12f);
        this.beG = typedArray.getDimensionPixelSize(f.l.TbRichTextView_textSize, (int) this.beG);
        this.mTextColor = typedArray.getColor(f.l.TbRichTextView_textColor, this.mTextColor);
        this.beJ = typedArray.getDimensionPixelSize(f.l.TbRichTextView_maxImageWidth, this.beJ);
        this.beK = typedArray.getDimensionPixelSize(f.l.TbRichTextView_maxImageHeight, this.beK);
        this.beL = typedArray.getResourceId(f.l.TbRichTextView_defaultImage, 0);
        this.beH = typedArray.getDimensionPixelSize(f.l.TbRichTextView_faceWidth, this.beH);
        this.beI = typedArray.getDimensionPixelSize(f.l.TbRichTextView_faceHeight, this.beI);
        this.beM = typedArray.getResourceId(f.l.TbRichTextView_videoImage, 0);
        this.beN = typedArray.getBoolean(f.l.TbRichTextView_singleLine, false);
        this.beX = this.beF;
    }

    public void release() {
    }

    public void P(int i, int i2) {
        this.beH = i;
        this.beI = i2;
    }

    public void fN(int i) {
        this.beM = i;
    }

    public void fO(int i) {
        this.beJ = i;
    }

    public void fP(int i) {
        this.beK = i;
    }

    public void fQ(int i) {
        this.beL = i;
    }

    public void setSupportNoImage() {
        this.beQ = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.beD = f2;
        this.beE = f;
    }

    public void Q(int i, int i2) {
        this.beS = i;
        this.beT = i2;
    }

    public void fR(int i) {
        this.beU = i;
    }

    public void fS(int i) {
        this.beF = i;
    }

    public void fT(int i) {
        this.beV = i;
    }

    public void fU(int i) {
        this.beW = i;
    }

    public void fV(int i) {
        this.beX = i;
    }

    public void fW(int i) {
        this.beY = i;
    }

    public void setTextSize(int i) {
        this.beG = i;
    }

    public boolean Nv() {
        return this.beZ;
    }

    public void cm(boolean z) {
        this.beZ = z;
    }

    public void cn(boolean z) {
        this.beR = z;
    }

    public int[] j(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.beR || i3 <= i5 || beC <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * beC <= i3) {
                if (i5 * beC > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * beC);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.beD = aVar.beD;
        this.beE = aVar.beE;
        this.atA = aVar.atA;
        this.beF = aVar.beF;
        this.beG = aVar.beG;
        this.beH = aVar.beH;
        this.beI = aVar.beI;
        this.mTextColor = aVar.mTextColor;
        this.beJ = aVar.beJ;
        this.beK = aVar.beK;
        this.beL = aVar.beL;
        this.beM = aVar.beM;
        this.beN = aVar.beN;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.beO = aVar.beO;
        this.beQ = aVar.beQ;
        this.beR = aVar.beR;
        this.beS = aVar.beS;
        this.beT = aVar.beT;
        this.beU = aVar.beU;
        this.beV = aVar.beV;
        this.beW = aVar.beW;
        this.beX = aVar.beF;
        this.beY = aVar.beY;
        this.beZ = aVar.beZ;
    }
}

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
    public static final float ber = l.ak(TbadkCoreApplication.getInst());
    protected boolean beH;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bes = 0.0f;
    protected float beu = 0.0f;
    protected int atV = 0;
    protected int bev = 0;
    protected float bew = 15.0f;
    protected int bex = -1;
    protected int bey = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int bez = 200;
    protected int beA = 200;
    protected int beB = 0;
    protected int beC = 0;
    protected boolean beD = false;
    protected int beE = -9989158;
    protected ImageView.ScaleType beF = ImageView.ScaleType.CENTER_CROP;
    protected boolean beG = false;
    protected int beI = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int beJ = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int beK = l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int beL = 0;
    protected int beM = -1;
    protected int beN = -1;
    protected int beO = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bev = typedArray.getDimensionPixelSize(d.m.TbRichTextView_segmentMargin, 0);
        this.atV = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textPadding, 0);
        this.bes = typedArray.getFloat(d.m.TbRichTextView_lineSpacing, 1.12f);
        this.bew = typedArray.getDimensionPixelSize(d.m.TbRichTextView_textSize, (int) this.bew);
        this.mTextColor = typedArray.getColor(d.m.TbRichTextView_textColor, this.mTextColor);
        this.bez = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageWidth, this.bez);
        this.beA = typedArray.getDimensionPixelSize(d.m.TbRichTextView_maxImageHeight, this.beA);
        this.beB = typedArray.getResourceId(d.m.TbRichTextView_defaultImage, 0);
        this.bex = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceWidth, this.bex);
        this.bey = typedArray.getDimensionPixelSize(d.m.TbRichTextView_faceHeight, this.bey);
        this.beC = typedArray.getResourceId(d.m.TbRichTextView_videoImage, 0);
        this.beD = typedArray.getBoolean(d.m.TbRichTextView_singleLine, false);
        this.beN = this.bev;
    }

    public void release() {
    }

    public void O(int i, int i2) {
        this.bex = i;
        this.bey = i2;
    }

    public void fN(int i) {
        this.beC = i;
    }

    public void fO(int i) {
        this.bez = i;
    }

    public void fP(int i) {
        this.beA = i;
    }

    public void fQ(int i) {
        this.beB = i;
    }

    public void setSupportNoImage() {
        this.beG = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bes = f2;
        this.beu = f;
    }

    public void P(int i, int i2) {
        this.beI = i;
        this.beJ = i2;
    }

    public void fR(int i) {
        this.beK = i;
    }

    public void fS(int i) {
        this.beL = i;
    }

    public void fT(int i) {
        this.beM = i;
    }

    public void fU(int i) {
        this.beN = i;
    }

    public void fV(int i) {
        this.beO = i;
    }

    public void cm(boolean z) {
        this.beH = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.beH || i3 <= i5 || ber <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * ber <= i3) {
                if (i5 * ber > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * ber);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bes = aVar.bes;
        this.beu = aVar.beu;
        this.atV = aVar.atV;
        this.bev = aVar.bev;
        this.bew = aVar.bew;
        this.bex = aVar.bex;
        this.bey = aVar.bey;
        this.mTextColor = aVar.mTextColor;
        this.bez = aVar.bez;
        this.beA = aVar.beA;
        this.beB = aVar.beB;
        this.beC = aVar.beC;
        this.beD = aVar.beD;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.beE = aVar.beE;
        this.beG = aVar.beG;
        this.beH = aVar.beH;
        this.beI = aVar.beI;
        this.beJ = aVar.beJ;
        this.beK = aVar.beK;
        this.beL = aVar.beL;
        this.beM = aVar.beM;
        this.beN = aVar.bev;
        this.beO = aVar.beO;
    }
}

package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    public static final float bmd = l.aR(TbadkCoreApplication.getInst());
    protected boolean bms;
    protected boolean mIsFromCDN;
    protected TbImageView.b mOnDrawListener;
    protected float bme = 0.0f;
    protected float bmf = 0.0f;
    protected int aBy = 0;
    protected int bmg = 0;
    protected float bmh = 15.0f;
    protected int bmi = -1;
    protected int bmj = -1;
    protected int mTextColor = -16777216;
    protected int bmk = 200;
    protected int bml = 200;
    protected int bmm = 0;
    protected int bmn = 0;
    protected boolean bmo = false;
    protected int bmp = -9989158;
    protected ImageView.ScaleType bmq = ImageView.ScaleType.CENTER_CROP;
    protected boolean bmr = false;
    protected int bmt = l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds16);
    protected int bmu = l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds20);
    protected int bmv = l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds20);
    protected int bmw = 0;
    protected int bmx = -1;
    protected int bmy = -1;
    protected int bmz = -1;
    protected boolean bmA = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.bmg = typedArray.getDimensionPixelSize(e.l.TbRichTextView_segmentMargin, 0);
        this.aBy = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textPadding, 0);
        this.bme = typedArray.getFloat(e.l.TbRichTextView_lineSpacing, 1.12f);
        this.bmh = typedArray.getDimensionPixelSize(e.l.TbRichTextView_textSize, (int) this.bmh);
        this.mTextColor = typedArray.getColor(e.l.TbRichTextView_textColor, this.mTextColor);
        this.bmk = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageWidth, this.bmk);
        this.bml = typedArray.getDimensionPixelSize(e.l.TbRichTextView_maxImageHeight, this.bml);
        this.bmm = typedArray.getResourceId(e.l.TbRichTextView_defaultImage, 0);
        this.bmi = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceWidth, this.bmi);
        this.bmj = typedArray.getDimensionPixelSize(e.l.TbRichTextView_faceHeight, this.bmj);
        this.bmn = typedArray.getResourceId(e.l.TbRichTextView_videoImage, 0);
        this.bmo = typedArray.getBoolean(e.l.TbRichTextView_singleLine, false);
        this.bmy = this.bmg;
    }

    public void release() {
    }

    public void R(int i, int i2) {
        this.bmi = i;
        this.bmj = i2;
    }

    public void gh(int i) {
        this.bmn = i;
    }

    public void gi(int i) {
        this.bmk = i;
    }

    public void gj(int i) {
        this.bml = i;
    }

    public void gk(int i) {
        this.bmm = i;
    }

    public void setSupportNoImage() {
        this.bmr = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.bme = f2;
        this.bmf = f;
    }

    public void S(int i, int i2) {
        this.bmt = i;
        this.bmu = i2;
    }

    public void gl(int i) {
        this.bmv = i;
    }

    public void gm(int i) {
        this.bmg = i;
    }

    public void gn(int i) {
        this.bmw = i;
    }

    public void go(int i) {
        this.bmx = i;
    }

    public void gp(int i) {
        this.bmy = i;
    }

    public void gq(int i) {
        this.bmz = i;
    }

    public void setTextSize(int i) {
        this.bmh = i;
    }

    public boolean QJ() {
        return this.bmA;
    }

    public void cH(boolean z) {
        this.bmA = z;
    }

    public void cI(boolean z) {
        this.bms = z;
    }

    public int[] k(int i, int i2, int i3, int i4) {
        int[] c = l.c(i, i2, i3, i4);
        if (c == null) {
            return null;
        }
        int[] iArr = {c[0], c[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.bms || i3 <= i5 || bmd <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * bmd <= i3) {
                if (i5 * bmd > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * bmd);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.bme = aVar.bme;
        this.bmf = aVar.bmf;
        this.aBy = aVar.aBy;
        this.bmg = aVar.bmg;
        this.bmh = aVar.bmh;
        this.bmi = aVar.bmi;
        this.bmj = aVar.bmj;
        this.mTextColor = aVar.mTextColor;
        this.bmk = aVar.bmk;
        this.bml = aVar.bml;
        this.bmm = aVar.bmm;
        this.bmn = aVar.bmn;
        this.bmo = aVar.bmo;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.bmp = aVar.bmp;
        this.bmr = aVar.bmr;
        this.bms = aVar.bms;
        this.bmt = aVar.bmt;
        this.bmu = aVar.bmu;
        this.bmv = aVar.bmv;
        this.bmw = aVar.bmw;
        this.bmx = aVar.bmx;
        this.bmy = aVar.bmg;
        this.bmz = aVar.bmz;
        this.bmA = aVar.bmA;
    }
}

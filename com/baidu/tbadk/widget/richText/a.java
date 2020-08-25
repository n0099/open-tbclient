package com.baidu.tbadk.widget.richText;

import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a {
    public static final float fec = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c ajz;
    public int feB;
    public int feC;
    public int feD;
    protected boolean feq;
    public boolean mIsFromCDN;
    protected float fed = 0.0f;
    protected float fee = 0.0f;
    protected int cLR = 0;
    protected int fef = 0;
    protected float mTextSize = 15.0f;
    protected int feg = -1;
    protected int feh = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fei = 200;
    protected int fej = 200;
    protected int fek = 0;
    protected int fel = 0;
    protected boolean fem = false;
    protected int fen = -9989158;
    protected ImageView.ScaleType feo = ImageView.ScaleType.CENTER_CROP;
    public boolean fep = false;
    public int fer = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int fes = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fet = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int feu = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fev = 0;
    protected int few = -1;
    protected int fex = -1;
    protected int fey = -1;
    protected int fez = 0;
    protected boolean feA = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fef = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.cLR = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fed = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fei = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fei);
        this.fej = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fej);
        this.fek = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.feg = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.feg);
        this.feh = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.feh);
        this.fel = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.fem = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.fex = this.fef;
    }

    public void release() {
    }

    public void br(int i, int i2) {
        this.feg = i;
        this.feh = i2;
    }

    public void rc(int i) {
        this.fel = i;
    }

    public void rd(int i) {
        this.fei = i;
    }

    public void re(int i) {
        this.fej = i;
    }

    public void rf(int i) {
        this.fek = i;
    }

    public void setSupportNoImage() {
        this.fep = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fed = f2;
        this.fee = f;
    }

    public void bs(int i, int i2) {
        this.fer = i;
        this.fes = i2;
    }

    public void rg(int i) {
        this.fet = i;
    }

    public void rh(int i) {
        this.feu = i;
    }

    public void ri(int i) {
        this.fef = i;
    }

    public void rj(int i) {
        this.fev = i;
    }

    public void rk(int i) {
        this.few = i;
    }

    public void rl(int i) {
        this.fex = i;
    }

    public void rm(int i) {
        this.fey = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bxv() {
        return this.feA;
    }

    public void jV(boolean z) {
        this.feA = z;
    }

    public void jW(boolean z) {
        this.feq = z;
    }

    public void rn(int i) {
        this.fez = i;
    }

    public int[] v(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.feq || i3 <= i5 || fec <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * fec <= i3) {
                if (i5 * fec > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * fec);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fed = aVar.fed;
        this.fee = aVar.fee;
        this.cLR = aVar.cLR;
        this.fef = aVar.fef;
        this.mTextSize = aVar.mTextSize;
        this.feg = aVar.feg;
        this.feh = aVar.feh;
        this.mTextColor = aVar.mTextColor;
        this.fei = aVar.fei;
        this.fej = aVar.fej;
        this.fek = aVar.fek;
        this.fel = aVar.fel;
        this.fem = aVar.fem;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fen = aVar.fen;
        this.fep = aVar.fep;
        this.feq = aVar.feq;
        this.fer = aVar.fer;
        this.fes = aVar.fes;
        this.feu = aVar.feu;
        this.fev = aVar.fev;
        this.few = aVar.few;
        this.fex = aVar.fef;
        this.fey = aVar.fey;
        this.feA = aVar.feA;
    }
}

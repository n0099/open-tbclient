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
    public static final float feg = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c ajB;
    public int feF;
    public int feG;
    public int feH;
    protected boolean feu;
    public boolean mIsFromCDN;
    protected float feh = 0.0f;
    protected float fei = 0.0f;
    protected int cLV = 0;
    protected int fej = 0;
    protected float mTextSize = 15.0f;
    protected int fek = -1;
    protected int fel = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int fem = 200;
    protected int fen = 200;
    protected int feo = 0;
    protected int fep = 0;
    protected boolean feq = false;
    protected int fer = -9989158;
    protected ImageView.ScaleType fes = ImageView.ScaleType.CENTER_CROP;
    public boolean fet = false;
    public int fev = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int few = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int fex = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int fey = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int fez = 0;
    protected int feA = -1;
    protected int feB = -1;
    protected int feC = -1;
    protected int feD = 0;
    protected boolean feE = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.fej = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.cLV = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.feh = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.fem = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.fem);
        this.fen = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.fen);
        this.feo = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fek = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fek);
        this.fel = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.fel);
        this.fep = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.feq = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.feB = this.fej;
    }

    public void release() {
    }

    public void br(int i, int i2) {
        this.fek = i;
        this.fel = i2;
    }

    public void rc(int i) {
        this.fep = i;
    }

    public void rd(int i) {
        this.fem = i;
    }

    public void re(int i) {
        this.fen = i;
    }

    public void rf(int i) {
        this.feo = i;
    }

    public void setSupportNoImage() {
        this.fet = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.feh = f2;
        this.fei = f;
    }

    public void bs(int i, int i2) {
        this.fev = i;
        this.few = i2;
    }

    public void rg(int i) {
        this.fex = i;
    }

    public void rh(int i) {
        this.fey = i;
    }

    public void ri(int i) {
        this.fej = i;
    }

    public void rj(int i) {
        this.fez = i;
    }

    public void rk(int i) {
        this.feA = i;
    }

    public void rl(int i) {
        this.feB = i;
    }

    public void rm(int i) {
        this.feC = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bxw() {
        return this.feE;
    }

    public void jX(boolean z) {
        this.feE = z;
    }

    public void jY(boolean z) {
        this.feu = z;
    }

    public void rn(int i) {
        this.feD = i;
    }

    public int[] v(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.feu || i3 <= i5 || feg <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * feg <= i3) {
                if (i5 * feg > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * feg);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.feh = aVar.feh;
        this.fei = aVar.fei;
        this.cLV = aVar.cLV;
        this.fej = aVar.fej;
        this.mTextSize = aVar.mTextSize;
        this.fek = aVar.fek;
        this.fel = aVar.fel;
        this.mTextColor = aVar.mTextColor;
        this.fem = aVar.fem;
        this.fen = aVar.fen;
        this.feo = aVar.feo;
        this.fep = aVar.fep;
        this.feq = aVar.feq;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.fer = aVar.fer;
        this.fet = aVar.fet;
        this.feu = aVar.feu;
        this.fev = aVar.fev;
        this.few = aVar.few;
        this.fey = aVar.fey;
        this.fez = aVar.fez;
        this.feA = aVar.feA;
        this.feB = aVar.fej;
        this.feC = aVar.feC;
        this.feE = aVar.feE;
    }
}

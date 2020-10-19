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
    public static final float ftn = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    protected TbImageView.c akr;
    protected boolean ftD;
    public int ftO;
    public int ftP;
    public int ftQ;
    public boolean mIsFromCDN;
    protected float fto = 0.0f;
    protected float ftq = 0.0f;
    protected int cZY = 0;
    protected int ftr = 0;
    protected float mTextSize = 15.0f;
    protected int fts = -1;
    protected int ftt = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int ftu = 200;
    protected int ftw = 200;
    protected int ftx = 0;
    protected int fty = 0;
    protected boolean ftz = false;
    protected int ftA = -9989158;
    protected ImageView.ScaleType ftB = ImageView.ScaleType.CENTER_CROP;
    public boolean ftC = false;
    public int ftE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds16);
    public int ftF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    public int ftG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
    protected int ftH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
    protected int ftI = 0;
    protected int ftJ = -1;
    protected int ftK = -1;
    protected int ftL = -1;
    protected int ftM = 0;
    protected boolean ftN = false;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void b(TypedArray typedArray) {
        this.ftr = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_segmentMargin, 0);
        this.cZY = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textPadding, 0);
        this.fto = typedArray.getFloat(R.styleable.TbRichTextView_lineSpacing, 1.12f);
        this.mTextSize = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_textSize, (int) this.mTextSize);
        this.mTextColor = typedArray.getColor(R.styleable.TbRichTextView_textColor, this.mTextColor);
        this.ftu = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageWidth, this.ftu);
        this.ftw = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_maxImageHeight, this.ftw);
        this.ftx = typedArray.getResourceId(R.styleable.TbRichTextView_defaultImage, 0);
        this.fts = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceWidth, this.fts);
        this.ftt = typedArray.getDimensionPixelSize(R.styleable.TbRichTextView_faceHeight, this.ftt);
        this.fty = typedArray.getResourceId(R.styleable.TbRichTextView_videoImage, 0);
        this.ftz = typedArray.getBoolean(R.styleable.TbRichTextView_singleLine, false);
        this.ftK = this.ftr;
    }

    public void release() {
    }

    public void bq(int i, int i2) {
        this.fts = i;
        this.ftt = i2;
    }

    public void rR(int i) {
        this.fty = i;
    }

    public void rS(int i) {
        this.ftu = i;
    }

    public void rT(int i) {
        this.ftw = i;
    }

    public void rU(int i) {
        this.ftx = i;
    }

    public void setSupportNoImage() {
        this.ftC = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.fto = f2;
        this.ftq = f;
    }

    public void br(int i, int i2) {
        this.ftE = i;
        this.ftF = i2;
    }

    public void rV(int i) {
        this.ftG = i;
    }

    public void rW(int i) {
        this.ftH = i;
    }

    public void rX(int i) {
        this.ftr = i;
    }

    public void rY(int i) {
        this.ftI = i;
    }

    public void rZ(int i) {
        this.ftJ = i;
    }

    public void sa(int i) {
        this.ftK = i;
    }

    public void sb(int i) {
        this.ftL = i;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }

    public boolean bBp() {
        return this.ftN;
    }

    public void kw(boolean z) {
        this.ftN = z;
    }

    public void kx(boolean z) {
        this.ftD = z;
    }

    public void sc(int i) {
        this.ftM = i;
    }

    public int[] v(int i, int i2, int i3, int i4) {
        int[] imageResize = l.getImageResize(i, i2, i3, i4);
        if (imageResize == null) {
            return null;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.ftD || i3 <= i5 || ftn <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * ftn <= i3) {
                if (i5 * ftn > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * ftn);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.fto = aVar.fto;
        this.ftq = aVar.ftq;
        this.cZY = aVar.cZY;
        this.ftr = aVar.ftr;
        this.mTextSize = aVar.mTextSize;
        this.fts = aVar.fts;
        this.ftt = aVar.ftt;
        this.mTextColor = aVar.mTextColor;
        this.ftu = aVar.ftu;
        this.ftw = aVar.ftw;
        this.ftx = aVar.ftx;
        this.fty = aVar.fty;
        this.ftz = aVar.ftz;
        this.mIsFromCDN = aVar.mIsFromCDN;
        this.ftA = aVar.ftA;
        this.ftC = aVar.ftC;
        this.ftD = aVar.ftD;
        this.ftE = aVar.ftE;
        this.ftF = aVar.ftF;
        this.ftH = aVar.ftH;
        this.ftI = aVar.ftI;
        this.ftJ = aVar.ftJ;
        this.ftK = aVar.ftr;
        this.ftL = aVar.ftL;
        this.ftN = aVar.ftN;
    }
}

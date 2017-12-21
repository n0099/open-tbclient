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
    public static final float aUk = l.af(TbadkCoreApplication.getInst());
    protected boolean aUA;
    protected TbImageView.b mOnDrawListener;
    protected float aUl = 0.0f;
    protected float aUm = 0.0f;
    protected int aUn = 0;
    protected int aUo = 0;
    protected float aUp = 15.0f;
    protected int aUq = -1;
    protected int aUr = -1;
    protected int mTextColor = ViewCompat.MEASURED_STATE_MASK;
    protected int aUs = 200;
    protected int aUt = 200;
    protected int aUu = 0;
    protected int aUv = 0;
    protected boolean aUw = false;
    protected int aUx = -9989158;
    protected ImageView.ScaleType aUy = ImageView.ScaleType.CENTER_CROP;
    protected boolean aUz = false;
    protected int aUB = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds16);
    protected int aUC = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aUD = l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds20);
    protected int aUE = 0;
    protected int aUF = -1;
    protected int aUG = -1;
    protected int aUH = -1;

    public a() {
    }

    public a(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    public void a(TypedArray typedArray) {
        this.aUo = typedArray.getDimensionPixelSize(d.l.TbRichTextView_segmentMargin, 0);
        this.aUn = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textPadding, 0);
        this.aUl = typedArray.getFloat(d.l.TbRichTextView_lineSpacing, 1.12f);
        this.aUp = typedArray.getDimensionPixelSize(d.l.TbRichTextView_textSize, (int) this.aUp);
        this.mTextColor = typedArray.getColor(d.l.TbRichTextView_textColor, this.mTextColor);
        this.aUs = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageWidth, this.aUs);
        this.aUt = typedArray.getDimensionPixelSize(d.l.TbRichTextView_maxImageHeight, this.aUt);
        this.aUu = typedArray.getResourceId(d.l.TbRichTextView_defaultImage, 0);
        this.aUq = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceWidth, this.aUq);
        this.aUr = typedArray.getDimensionPixelSize(d.l.TbRichTextView_faceHeight, this.aUr);
        this.aUv = typedArray.getResourceId(d.l.TbRichTextView_videoImage, 0);
        this.aUw = typedArray.getBoolean(d.l.TbRichTextView_singleLine, false);
        this.aUG = this.aUo;
    }

    public void release() {
    }

    public void J(float f) {
        this.aUl = f;
    }

    public void S(int i, int i2) {
        this.aUq = i;
        this.aUr = i2;
    }

    public void fS(int i) {
        this.aUv = i;
    }

    public void fT(int i) {
        this.aUs = i;
    }

    public void fU(int i) {
        this.aUt = i;
    }

    public void fV(int i) {
        this.aUu = i;
    }

    public void Jq() {
        this.aUz = true;
    }

    public void setLineSpacing(float f, float f2) {
        this.aUl = f2;
        this.aUm = f;
    }

    public void T(int i, int i2) {
        this.aUB = i;
        this.aUC = i2;
    }

    public void fW(int i) {
        this.aUD = i;
    }

    public void fX(int i) {
        this.aUE = i;
    }

    public void fY(int i) {
        this.aUF = i;
    }

    public void fZ(int i) {
        this.aUG = i;
    }

    public void ga(int i) {
        this.aUH = i;
    }

    public void cg(boolean z) {
        this.aUA = z;
    }

    public int[] l(int i, int i2, int i3, int i4) {
        int[] b = l.b(i, i2, i3, i4);
        if (b == null) {
            return null;
        }
        int[] iArr = {b[0], b[1]};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aUA || i3 <= i5 || aUk <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aUk <= i3) {
                if (i5 * aUk > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aUk);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        return new int[]{i3, i6};
    }

    public void a(a aVar) {
        this.aUl = aVar.aUl;
        this.aUm = aVar.aUm;
        this.aUn = aVar.aUn;
        this.aUo = aVar.aUo;
        this.aUp = aVar.aUp;
        this.aUq = aVar.aUq;
        this.aUr = aVar.aUr;
        this.mTextColor = aVar.mTextColor;
        this.aUs = aVar.aUs;
        this.aUt = aVar.aUt;
        this.aUu = aVar.aUu;
        this.aUv = aVar.aUv;
        this.aUw = aVar.aUw;
        this.aUx = aVar.aUx;
        this.aUz = aVar.aUz;
        this.aUA = aVar.aUA;
        this.aUB = aVar.aUB;
        this.aUC = aVar.aUC;
        this.aUD = aVar.aUD;
        this.aUE = aVar.aUE;
        this.aUF = aVar.aUF;
        this.aUG = aVar.aUo;
        this.aUH = aVar.aUH;
    }
}
